package com.bedenko.genaro.expresstable.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bedenko.genaro.expresstable.R;
import com.bedenko.genaro.expresstable.controllers.RestaurantController;
import com.bedenko.genaro.expresstable.models.Restaurant;
import com.bedenko.genaro.expresstable.persistence.DatabaseHandler;
import com.bedenko.genaro.expresstable.utils.CommonUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class NewRestaurantActivity extends AppCompatActivity {

    // Instances of controller, persistence and utils classes
    RestaurantController restaurantController = new RestaurantController();
    DatabaseHandler db = new DatabaseHandler(this);
    CommonUtils commonUtils = new CommonUtils();

    // Variables to store the images being entered by the user
    private Bitmap restaurantLogo;
    private Bitmap restaurantMenuImage;
    private Bitmap restaurantFloorPlanImage;

    private double restaurantLatitude;
    private double restaurantLongitude;
    private String restaurantAddress;

    // Different request types for different intents for onActivityResult
    private static final int LOGO_IMAGE_GALLERY_REQUEST = 1;
    private static final int MENU_IMAGE_CAMERA_REQUEST = 2;
    private static final int FLOORPLAN_IMAGE_CAMERA_REQUEST = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_restaurant);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        // Enter Logo Button and Listener
        Button enterLogoImageButton = findViewById(R.id.enterLogoImageButton);
        enterLogoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterLogoImageButtonClicked();
            }
        });

        // Enter Menu Image Button and Listener
        Button enterMenuImageButton = findViewById(R.id.enterMenuImageButton);
        enterMenuImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterMenuImageButtonClicked();
            }
        });

        // Enter Floor Plan Image Button and Listener
        Button enterFloorPlanButton = findViewById(R.id.enterFloorPlanButton);
        enterFloorPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterFloorPlanButtonClicked();
            }
        });

        Button setRestaurantLocationButton = findViewById(R.id.enterGpsLocation);
        setRestaurantLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRestaurantLocationButtonClicked();
            }
        });

        // Submit all restaurant details button and listener
        Button submitRestaurantButton = findViewById(R.id.submitRestaurantButton);
        submitRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRestaurantButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {

            Intent intent = getIntent();

            setRestaurantLatitude(Double.parseDouble(intent.getStringExtra("latitude")));
            setRestaurantLongitude(Double.parseDouble(intent.getStringExtra("longitude")));
            setRestaurantAddress(intent.getStringExtra("address"));
        } catch (NullPointerException e) {

            setRestaurantLatitude(50.0);
            setRestaurantLongitude(50.0);
            setRestaurantAddress("Address not yet known");
        }
    }

    private void enterLogoImageButtonClicked() {
        // Calls onActivityResult with the intent to select an image from gallery
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, LOGO_IMAGE_GALLERY_REQUEST);
    }

    private void enterMenuImageButtonClicked() {
        // Calls onActivityResult with the intent to capture an image from camera
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, MENU_IMAGE_CAMERA_REQUEST);
    }

    private void enterFloorPlanButtonClicked() {
        // Calls onActivityResult with the intent to capture an image from camera
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, FLOORPLAN_IMAGE_CAMERA_REQUEST);
    }

    private void setRestaurantLocationButtonClicked() {

        startActivity(new Intent(getBaseContext(), SetRestaurantLocationActivity.class));
    }

    private void submitRestaurantButtonClicked() {

        // Take user's input from the following Text Fields
        EditText restaurantUsernameField = findViewById(R.id.restaurantUsernameField);
        EditText restaurantPasswordField = findViewById(R.id.restaurantPasswordField);
        EditText restaurantNameField = findViewById(R.id.restaurantNameField);
        String restaurantUsername = restaurantUsernameField.getText().toString();
        String restaurantName = restaurantNameField.getText().toString();
        String restaurantPasswordHash = commonUtils.md5Hash(restaurantPasswordField.getText().toString());

        // Retrieve the images the user entered from the previous intents (run on previous button clicks)
        Bitmap restaurantLogo = getRestaurantLogo();
        Bitmap restaurantMenuImage = getRestaurantMenuImage();
        Bitmap restaurantFloorPlanImage = getRestaurantFloorPlanImage();

        double restaurantLatitude = getRestaurantLatitude();
        double restaurantLongitude = getRestaurantLongitude();
        String restaurantAddress = getRestaurantAddress();

        // For each of the images, convert them to a byte array so they can be stored in sqlite db
        // Convert logo image
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        restaurantLogo.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] restaurantLogoByteArray = stream.toByteArray();
        restaurantLogo.recycle();
        // Convert menu image
        stream = new ByteArrayOutputStream();
        restaurantMenuImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] restaurantMenuImageByteArray = stream.toByteArray();
        restaurantMenuImage.recycle();
        // Convert floor plan image
        stream = new ByteArrayOutputStream();
        restaurantFloorPlanImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] restaurantFloorPlanImageByteArray = stream.toByteArray();
        restaurantFloorPlanImage.recycle();

        // Create a new restaurant entity from the fields/images/gps that the user entered
        Restaurant newRestaurant = restaurantController.createRestaurant(restaurantUsername, restaurantName, restaurantPasswordHash, restaurantLogoByteArray, restaurantMenuImageByteArray, restaurantFloorPlanImageByteArray, restaurantLatitude, restaurantLongitude, restaurantAddress);

        // Add restaurant details to the local database and send confirmation to user
        restaurantController.addRestaurantToDB(db, newRestaurant);
        Toast.makeText(getApplicationContext(),"Restaurant Account Created", Toast.LENGTH_LONG).show();

        // Obtain the restaurant details now it is stored locally in the db
        Restaurant currentRestaurant = restaurantController.getRestaurantFromDB(db, newRestaurant);

        // Intent to move to the restaurant dashboard and send the restaurant id and username to use in following activities
        Intent intent = new Intent(NewRestaurantActivity.this, RestaurantDashboardActivity.class);
        intent.putExtra("restaurant_id", currentRestaurant.getRestaurantID());
        intent.putExtra("restaurant_username", currentRestaurant.getUsername());

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        // Method called for intents related to taking photo from gallery or camera

        // If the intent is for the logo image
        if (reqCode == LOGO_IMAGE_GALLERY_REQUEST && resultCode == RESULT_OK) {

            try {
                // Prompt the user to select the desired photo from their gallery
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

                // Set the chosen photo as the class variable
                setRestaurantLogo(selectedImage);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_LONG).show();
            }
        }

        // If the intent is for taking a photo of the menu image
        if (reqCode == MENU_IMAGE_CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            setRestaurantMenuImage(photo);
        }

        // If the intent is for taking a photo of the floor plan image
        if (reqCode == FLOORPLAN_IMAGE_CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            setRestaurantFloorPlanImage(photo);
        }
    }

    public Bitmap getRestaurantLogo() {
        return restaurantLogo;
    }

    public void setRestaurantLogo(Bitmap restaurantLogo) {
        this.restaurantLogo = restaurantLogo;
    }

    public Bitmap getRestaurantMenuImage() {
        return restaurantMenuImage;
    }

    public void setRestaurantMenuImage(Bitmap restaurantMenuImage) {
        this.restaurantMenuImage = restaurantMenuImage;
    }

    public Bitmap getRestaurantFloorPlanImage() {
        return restaurantFloorPlanImage;
    }

    public void setRestaurantFloorPlanImage(Bitmap restaurantFloorPlanImage) {
        this.restaurantFloorPlanImage = restaurantFloorPlanImage;
    }

    public double getRestaurantLatitude() {
        return restaurantLatitude;
    }

    public void setRestaurantLatitude(double restaurantLatitude) {
        this.restaurantLatitude = restaurantLatitude;
    }

    public double getRestaurantLongitude() {
        return restaurantLongitude;
    }

    public void setRestaurantLongitude(double restaurantLongitude) {
        this.restaurantLongitude = restaurantLongitude;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

}
