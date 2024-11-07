//Inder Singh 100816726 November 6, 2024

package com.example.locationfinderapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Declare variables
    private EditText addressEditText, latitudeEditText, longitudeEditText;
    private TextView displayTextView;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize variables
        addressEditText = findViewById(R.id.address);
        latitudeEditText = findViewById(R.id.latitude);
        longitudeEditText = findViewById(R.id.longitude);
        displayTextView = findViewById(R.id.display);
        displayTextView.setVisibility(View.GONE);

        //Initialize database
        dbHelper = new DBHelper(this);

        //Set up button on click listeners
        Button queryButton = findViewById(R.id.queryLocation);
        queryButton.setOnClickListener(v -> queryLocation());

        Button addButton = findViewById(R.id.addLocation);
        addButton.setOnClickListener(v -> addLocation());

        Button deleteButton = findViewById(R.id.deleteLocation);
        deleteButton.setOnClickListener(v -> deleteLocation());

        Button updateButton = findViewById(R.id.updateLocation);
        updateButton.setOnClickListener(v -> updateLocation());
    }

    //Method to query the inputted location
    private void queryLocation() {
        String address = addressEditText.getText().toString();
        Cursor cursor = dbHelper.queryLocation(address);

        if (cursor != null && cursor.moveToFirst()) {
            double latitude = cursor.getDouble(0);
            double longitude = cursor.getDouble(1);
            latitudeEditText.setText(String.valueOf(latitude));
            longitudeEditText.setText(String.valueOf(longitude));
            displayTextView.setVisibility(View.VISIBLE);
            displayTextView.setText("Location found: " + address + ", " + latitude + ", " + longitude);
            cursor.close();
        } else {
            Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
        }
    }

    //Method to add a new location and coordinates
    private void addLocation() {
        String address = addressEditText.getText().toString();
        String latitudeText = latitudeEditText.getText().toString();
        String longitudeText = longitudeEditText.getText().toString();

        // Check if all fields are filled
        if (address.isEmpty() || latitudeText.isEmpty() || longitudeText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double latitude = Double.parseDouble(latitudeText);
        double longitude = Double.parseDouble(longitudeText);

        //Check if address already exists in the database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_NAME, new String[]{DBHelper.COLUMN_ID},
                DBHelper.COLUMN_ADDRESS + "=?", new String[]{address}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            //exists
            Toast.makeText(this, "Location already exists", Toast.LENGTH_SHORT).show();
            cursor.close();
        } else {
            //does not exist so add
            cursor.close();
            long result = dbHelper.addLocation(address, latitude, longitude);
            if (result != -1) {
                Toast.makeText(this, "Location added successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error adding location", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Method to delete the inputted address and its coordinates
    private void deleteLocation() {
        String address = addressEditText.getText().toString();
        int result = dbHelper.deleteLocation(address);

        if (result > 0) {
            Toast.makeText(this, "Location deleted", Toast.LENGTH_SHORT).show();
            displayTextView.setText("");
        } else {
            Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
        }
    }

    //Method to update the inputted address along with the coordinates
    private void updateLocation() {
        String address = addressEditText.getText().toString();
        String latitudeText = latitudeEditText.getText().toString();
        String longitudeText = longitudeEditText.getText().toString();

        //Check if all fields are filled
        if (address.isEmpty() || latitudeText.isEmpty() || longitudeText.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double latitude = Double.parseDouble(latitudeText);
        double longitude = Double.parseDouble(longitudeText);

        //Check if a location with the same address, latitude, and longitude already exists
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_NAME,
                new String[]{DBHelper.COLUMN_ID},
                DBHelper.COLUMN_ADDRESS + "=? AND " +
                        DBHelper.COLUMN_LATITUDE + "=? AND " +
                        DBHelper.COLUMN_LONGITUDE + "=?",
                new String[]{address, String.valueOf(latitude), String.valueOf(longitude)},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            //Entry with the same address, latitude, and longitude already exists
            Toast.makeText(this, "Location already exists", Toast.LENGTH_SHORT).show();
            cursor.close();
        } else {
            //No matching entry, so update
            cursor.close();
            int result = dbHelper.updateLocation(address, latitude, longitude);
            if (result > 0) {
                Toast.makeText(this, "Location updated successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
