// Inder Singh 100816726 November 6, 2024

package com.example.locationfinderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "locationFinder.db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = "location";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOCATION_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_LATITUDE + " REAL,"
                + COLUMN_LONGITUDE + " REAL)";
        db.execSQL(CREATE_LOCATION_TABLE);

        //Insert initial 100 locations
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('301 Front St W', 43.642566, -79.387057)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('100 Queens Park', 43.66771, -79.394777)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('317 Dundas St W', 43.653606, -79.392512)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2000 Meadowvale Rd', 43.817699, -79.18593)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1 Austin Terrace', 43.678045, -79.409415)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('288 Bremner Blvd', 43.642403, -79.386345)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('93 Front St E', 43.649093, -79.371601)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('220 Yonge St', 43.654438, -79.380699)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('55 Mill St', 43.650313, -79.359533)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1873 Bloor St W', 43.646548, -79.463706)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('770 Don Mills Rd', 43.7167, -79.338229)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('30 Yonge St', 43.646977, -79.377189)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1 Blue Jays Way', 43.641438, -79.389353)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('40 Bay St', 43.643466, -79.379099)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('27 King''s College Cir', 43.662891, -79.395656)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('350 Victoria St', 43.657722, -79.378514)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('4700 Keele St', 43.7735, -79.501868)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1 Brimley Rd S', 43.705, -79.235)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1675 Lake Shore Blvd E', 43.661667, -79.301667)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2169 Queen St E', 43.6727, -79.287391)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('222 Spadina Ave', 43.653206, -79.398574)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('622 College St', 43.65426, -79.41918)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('463 Danforth Ave', 43.679563, -79.352678)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('235 Queens Quay W', 43.638731, -79.381326)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('250 Fort York Blvd', 43.63925, -79.406393)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1355 Kingston Rd', 43.8386, -79.0865)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('777 Lawrence Ave E', 43.734, -79.363)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1000 Murray Ross Pkwy', 43.7735, -79.507)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('955 Lake Shore Blvd W', 43.628947, -79.414452)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('100 Princes'' Blvd', 43.6331, -79.4184)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('650 Dixon Rd', 43.689, -79.578)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('6301 Silver Dart Dr', 43.677717, -79.62482)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('100 City Centre Dr', 43.593399, -79.642)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('300 City Centre Dr', 43.589045, -79.644119)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('4141 Living Arts Dr', 43.5895, -79.6445)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('99 Rathburn Rd W', 43.593, -79.642)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('29 Lakeshore Rd E', 43.5515, -79.586)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1180 Lakeshore Rd W', 43.531, -79.615)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('660 Bexhill Rd', 43.514, -79.617)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('5100 Erin Mills Pkwy', 43.561, -79.711)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('6045 Mavis Rd', 43.606, -79.686)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2 Wellington St W', 43.686, -79.76)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1 Theatre Ln', 43.687, -79.76)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('9 Wellington St E', 43.684, -79.758)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('9050 Bramalea Rd', 43.731, -79.743)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('10818 Heart Lake Rd', 43.737, -79.805)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('25 Peel Centre Dr', 43.715, -79.726)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('7575 Kennedy Rd S', 43.678, -79.705)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1660 North Park Dr', 43.741, -79.731)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('8520 Creditview Rd', 43.634, -79.805)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1 Bass Pro Mills Dr', 43.825, -79.539)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1 Canada''s Wonderland Dr', 43.843, -79.539)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('10365 Islington Ave', 43.843, -79.625)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('8739 Islington Ave', 43.788, -79.588)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2141 Major MacKenzie Dr W', 43.845, -79.529)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('10268 Yonge St', 43.878, -79.438)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('123 Hillsview Dr', 43.861, -79.42)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('43 Mill St', 43.878, -79.448)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1300 Elgin Mills Rd E', 43.89, -79.404)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('9350 Markham Rd', 43.876, -79.257)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('4300 Steeles Ave E', 43.824, -79.306)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('101 Town Centre Blvd', 43.856, -79.337)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('300 Borough Dr', 43.775, -79.257)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('520 Progress Ave', 43.779, -79.253)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1305 Ellesmere Rd', 43.769, -79.257)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('85 Executive Ct', 43.776, -79.281)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1571 Sandhurst Cir', 43.811, -79.267)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1800 Sheppard Ave E', 43.7787, -79.3431)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('31 Tapscott Rd', 43.8041, -79.2313)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2061 Eglinton Ave E', 43.7317, -79.2686)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('85 Ellesmere Rd', 43.7572, -79.2906)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('25 The West Mall', 43.6112, -79.556)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1132 Leslie St', 43.7255, -79.363)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('3199 Lake Shore Blvd W', 43.5933, -79.5106)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1101 Bloor St W', 43.6618, -79.4318)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2275 Bayview Ave', 43.7287, -79.3744)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2 Eireann Quay', 43.6285, -79.3961)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('9 Queens Quay W', 43.6205, -79.3789)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('77 Wynford Dr', 43.7258, -79.3317)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1 Dundas St E', 43.6562, -79.3801)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('60 Queen St W', 43.6519, -79.3816)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('130 Queen St W', 43.6509, -79.3883)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('30 Bond St', 43.6534, -79.3785)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('200 Elizabeth St', 43.6582, -79.3866)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('555 Rexdale Blvd', 43.7166, -79.6066)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('249 Queens Quay W', 43.6389, -79.38)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('100 Queen St W', 43.6525, -79.384)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('170 Princes Blvd', 43.6332, -79.4184)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('195 Rouge Hills Dr', 43.7833, -79.1181)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('256 Centennial Park Rd', 43.6448, -79.582)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1749 Meadowvale Rd', 43.8129, -79.1525)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2000 Simcoe St N', 43.94561, -78.896749)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('178 Victoria St', 43.6524, -79.378)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('1610 Champlain Avenue', 43.8726, -78.932)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('111 Queens Park', 43.6677, -79.3936)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('550 Bayview Ave', 43.6843, -79.3648)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('13850 Steeles Ave W', 43.5728, -79.8338)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('2701 Queen St E', 43.6726, -79.2752)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('70 Canuck Ave', 43.7498, -79.4791)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (address, latitude, longitude) VALUES ('6900 Airport Rd', 43.7004, -79.6374)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Query method
    public Cursor queryLocation(String address) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, new String[]{COLUMN_LATITUDE, COLUMN_LONGITUDE},
                COLUMN_ADDRESS + "=?", new String[]{address},
                null, null, null);
    }

    //Add method
    public long addLocation(String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);

        return db.insert(TABLE_NAME, null, values);
    }

    //Delete method
    public int deleteLocation(String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_ADDRESS + "=?", new String[]{address});
    }

    //Update method
    public int updateLocation(String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);

        return db.update(TABLE_NAME, values, COLUMN_ADDRESS + "=?", new String[]{address});
    }
}

