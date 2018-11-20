package com.bedenko.genaro.expresstable.persistence;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseHandler {

    private static final String TAG = "FirebaseHandler";
    private boolean addedToFirebase = false;
    private boolean documentExists = false;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public boolean addDocumentToFirebase(Object object, CollectionReference collectionReference) {

        collectionReference.document()
                .set(object)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Document added to Firebase successfully");
                        setAddedToFirebase(true);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document to Firebase", e);
                        setAddedToFirebase(false);
                    }
                });

        return isAddedToFirebase();
    }

    public boolean queryIfDocumentExists(Query query) {

        // Ensures false as default before running query
        setDocumentExists(false);

        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.exists()) {
                            setDocumentExists(true);
                        }
                    }
                }
            }
        });

        return isDocumentExists();
    }

    public boolean isAddedToFirebase() {
        return addedToFirebase;
    }

    public void setAddedToFirebase(boolean addedToFirebase) {
        this.addedToFirebase = addedToFirebase;
    }

    public boolean isDocumentExists() {
        return documentExists;
    }

    public void setDocumentExists(boolean documentExists) {
        this.documentExists = documentExists;
    }
}
