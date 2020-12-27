package com.amadeus.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.amadeus.petagram.pojo.Mascota;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private Context context;



    public Database(@Nullable Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String queryTablaContacto = "CREATE TABLE "                 + DBConstants.TABLE_MASCOTA +"( " +
                                    DBConstants.TABLE_MASCOTA_ID    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    DBConstants.TABLE_MASCOTA_NAME  + " TEXT, " +
                                    DBConstants.TABLE_MASCOTA_PHOTO + " INTEGER" +
                                    ")";

        String queryLikesMascotas = "CREATE TABLE "                                 + DBConstants.TABLE_MASCOTA_LIKES + "(" +
                                    DBConstants.TABLE_MASCOTA_LIKES_ID              + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA      + " INTEGER, " +
                                    DBConstants.TABLE_MASCOTA_LIKES_NUMERO_LIKES    + " INTEGER, " +
                                    "FOREIGN KEY ("                                 + DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA + ") " +
                                    "REFERENCES "                                   + DBConstants.TABLE_MASCOTA + "("+ DBConstants.TABLE_MASCOTA_ID +")" +
                ")";


        sqLiteDatabase.execSQL(queryTablaContacto);
        sqLiteDatabase.execSQL(queryLikesMascotas);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBConstants.TABLE_MASCOTA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBConstants.TABLE_MASCOTA_LIKES);

        onCreate(sqLiteDatabase);

    }

    public ArrayList<Mascota> obtenerMascotas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + DBConstants.TABLE_MASCOTA;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registrosMascotas = sqLiteDatabase.rawQuery(query,null);

        while (registrosMascotas.moveToNext()){

            Mascota mascotaActual = new Mascota();

            mascotaActual.setId(registrosMascotas.getInt(0));
            mascotaActual.setNombre(registrosMascotas.getString(1));
            mascotaActual.setFoto(registrosMascotas.getInt(2));

            String queryLikes = "SELECT COUNT(" + DBConstants.TABLE_MASCOTA_LIKES_NUMERO_LIKES+") as likes " +
                                " FROM "        + DBConstants.TABLE_MASCOTA_LIKES +
                                " WHERE "       + DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = sqLiteDatabase.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){

                mascotaActual.setNroLikes(registrosLikes.getInt(0));

            }else {

                mascotaActual.setNroLikes(0);
            }

            mascotas.add(mascotaActual);
        }

        sqLiteDatabase.close();

        return mascotas;


    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DBConstants.TABLE_MASCOTA, null, contentValues);

        sqLiteDatabase.close();
    }

    public void insertarLike(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DBConstants.TABLE_MASCOTA_LIKES, null, contentValues);

        sqLiteDatabase.close();
    }

    public int obtenerLikesMascota(Mascota mascota){

        int likes = 0;

        String query = "SELECT DISTINCT " + DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA + " ,COUNT("+DBConstants.TABLE_MASCOTA_LIKES_NUMERO_LIKES+")" +
                " FROM " + DBConstants.TABLE_MASCOTA_LIKES +
                " WHERE " + DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA + "="+mascota.getId();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        int i = 0;

        while(registros.moveToNext()){

            likes = registros.getInt(1);
            i++;

        }

        sqLiteDatabase.close();

        return likes;

    }

    public ArrayList<Mascota> obtenerFive(){

        ArrayList<Mascota> fiveMascotas = new ArrayList<>(4);

        ArrayList<Integer> fiveId = new ArrayList<>();

        String queryId = "SELECT DISTINCT " + DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA +
                        " FROM " + DBConstants.TABLE_MASCOTA_LIKES;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registrosId = sqLiteDatabase.rawQuery(queryId,null);


        while (registrosId.moveToNext()){

            fiveId.add(registrosId.getInt(0));


        }

        if(fiveId.isEmpty()){

            Toast.makeText(context,"AGREGAR 5 FAVORITOS!!!",Toast.LENGTH_SHORT).show();
        }

        else{

        for(int i=fiveId.size()-1; i>=fiveId.size()-5; i--){
            Mascota mascotaLiked = new Mascota();

            String query = "SELECT DISTINCT "
                    + DBConstants.TABLE_MASCOTA_NAME +", "+ DBConstants.TABLE_MASCOTA_PHOTO +", "  +
                    " COUNT (" + DBConstants.TABLE_MASCOTA_LIKES_NUMERO_LIKES+") " +
                    " FROM " + DBConstants.TABLE_MASCOTA  +
                    " INNER JOIN " + DBConstants.TABLE_MASCOTA_LIKES +
                    " ON " + DBConstants.TABLE_MASCOTA +"."+DBConstants.TABLE_MASCOTA_ID + "=" +DBConstants.TABLE_MASCOTA_LIKES+"."+
                    DBConstants.TABLE_MASCOTA_LIKES_ID_MASCOTA +
                    " WHERE " + DBConstants.TABLE_MASCOTA+"."+
                    DBConstants.TABLE_MASCOTA_ID+ "=" + fiveId.get(i);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor registrosFive = db.rawQuery(query,null);

            while (registrosFive.moveToNext()){

                mascotaLiked.setNombre(registrosFive.getString(0));
                mascotaLiked.setFoto(registrosFive.getInt(1));
                mascotaLiked.setNroLikes(registrosFive.getInt(2));

                fiveMascotas.add(mascotaLiked);


            }
        }

        }





        return fiveMascotas;
    }


}
