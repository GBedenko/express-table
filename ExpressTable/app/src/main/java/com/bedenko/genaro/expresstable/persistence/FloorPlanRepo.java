package com.bedenko.genaro.expresstable.persistence;

import android.content.ContentValues;

import com.bedenko.genaro.expresstable.models.FloorPlan;

import java.util.ArrayList;

public class FloorPlanRepo {

    public void addFloorPlanToDB(DatabaseHandler db, FloorPlan floorPlan) {

        ContentValues floorPlanValues = new ContentValues();
        floorPlanValues.put("restaurant_id", floorPlan.getRestaurantID());
        floorPlanValues.put("image", floorPlan.getImage());

        db.write("floorPlans", floorPlanValues);
    }

    public ArrayList<FloorPlan> getAllFloorPlans() {

        ArrayList<FloorPlan> retrievedFloorPlans = new ArrayList<>();

        return retrievedFloorPlans;
    }

    public FloorPlan getFloorPlan(FloorPlan floorPlan) {

        FloorPlan retrievedFloorPlan = new FloorPlan();

        return retrievedFloorPlan;
    }

    public void updateFloorPlan(FloorPlan floorPlan) {

    }

    public void deleteFloorPlan(FloorPlan floorPlan) {

    }
}
