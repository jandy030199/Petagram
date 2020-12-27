package com.amadeus.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.amadeus.petagram.R;
import com.amadeus.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {

        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        Database dataBase = new Database(context);
        insertarMascotas(dataBase);
        return dataBase.obtenerMascotas();

    }


    public void insertarMascotas(Database database){

        /*ContentValues contentValues = new ContentValues();

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Catty");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.catty);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Doggy");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.doggy);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Foquisin");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.foquisin);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Orange");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.orange);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Rose");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.rose);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Sakura");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.sakura);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Shiro");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.shiro);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Spring");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.spring);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Sunshine");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.sunshine);
        database.insertarMascota(contentValues);

        contentValues.put(DBConstants.TABLE_MASCOTA_NAME, "Violet");
        contentValues.put(DBConstants.TABLE_MASCOTA_PHOTO, R.drawable.violet);
        database.insertarMascota(contentValues);*/


    }

    public void darLikeMascota(Mascota mascota){

        Database database = new Database(context);

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(DBConstants.TABLE_MASCOTA_LIKES_NUMERO_LIKES, LIKE);

        database.insertarLike(contentValues);

    }

    public  int obtenerLikes(Mascota mascota){

        Database database = new Database(context);
        return database.obtenerLikesMascota(mascota);


    }


    public ArrayList<Mascota> obtenerDatosFive(){

        Database dataBase = new Database(context);
        return dataBase.obtenerFive();

    }
}
