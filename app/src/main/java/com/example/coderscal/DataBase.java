package com.example.coderscal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="coders.db";
    public static final String TABLE_NAME ="registercoder";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="name";
    public static final String COL_3 ="password";
    public static final String COL_4 ="ccname";
    public static final String COL_5 ="cfname";
    public static final String COL_6 ="topname";
    public static final String COL_7 ="hename";
    public static final String COL_8 ="hrname";

    public DataBase(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registercoder (ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,password TEXT,ccname TEXT,cfname TEXT,topname TEXT,hename TEXT,hrname TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int i,int i1){
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addUser(String user,String pass,String cc,String cf,String top,String he,String hr){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",user);
        contentValues.put("password",pass);
        contentValues.put("ccname",cc);
        contentValues.put("cfname",cf);
        contentValues.put("topname",top);
        contentValues.put("hename",he);
        contentValues.put("hrname",hr);
        long res=db.insert("registercoder",null,contentValues);
        db.close();
        return res;
    }
    public boolean checkUser(String user,String pass){
        String[] columns={COL_1};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs={user,pass};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean check(String user){
        String[] columns={COL_1};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=COL_2 + "=?";
        String[] selectionArgs={user};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0){
            return true;
        }
        else{
            return false;
        }
    }
    public String getcc(String user){
        String[] columns={COL_1};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=COL_2 + "=?";
        String[] selectionArgs={user};
        Cursor cursor=db.query(TABLE_NAME,null,selection,selectionArgs,null,null,null);
        String cc;
        cursor.moveToFirst();
        cc = cursor.getString(cursor.getColumnIndex("ccname"));
        cursor.close();
        db.close();
        return cc;
    }
    public String getcf(String user){
        String[] columns={COL_1};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=COL_2 + "=?";
        String[] selectionArgs={user};
        Cursor cursor=db.query(TABLE_NAME,null,selection,selectionArgs,null,null,null);
        String cf;
        cursor.moveToFirst();
        cf = cursor.getString(cursor.getColumnIndex("cfname"));
        cursor.close();
        db.close();
        return cf;
    }
    public String gettop(String user){
        String[] columns={COL_1};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=COL_2 + "=?";
        String[] selectionArgs={user};
        Cursor cursor=db.query(TABLE_NAME,null,selection,selectionArgs,null,null,null);
        String top;
        cursor.moveToFirst();
        top = cursor.getString(cursor.getColumnIndex("topname"));
        cursor.close();
        db.close();
        return top;
    }
    public String gethe(String user){
        String[] columns={COL_1};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=COL_2 + "=?";
        String[] selectionArgs={user};
        Cursor cursor=db.query(TABLE_NAME,null,selection,selectionArgs,null,null,null);
        String he;
        cursor.moveToFirst();
        he = cursor.getString(cursor.getColumnIndex("hename"));
        cursor.close();
        db.close();
        return he;
    }
    public String gethr(String user){
        String[] columns={COL_1};
        SQLiteDatabase db=this.getReadableDatabase();
        String selection=COL_2 + "=?";
        String[] selectionArgs={user};
        Cursor cursor=db.query(TABLE_NAME,null,selection,selectionArgs,null,null,null);
        String hr;
        cursor.moveToFirst();
        hr = cursor.getString(cursor.getColumnIndex("hrname"));
        cursor.close();
        db.close();
        return hr;
    }
    public void updatecc(String user,String cc){
        SQLiteDatabase db=this.getWritableDatabase();
        String strFilter="name=?";
        String[] us={user};
        ContentValues values=new ContentValues();
        values.put("ccname",cc);
        db.update(TABLE_NAME,values,strFilter,us);
        db.close();
    }
    public void updatecf(String user,String cf){
        SQLiteDatabase db=this.getWritableDatabase();
        String strFilter="name=?";
        String[] us={user};
        ContentValues values=new ContentValues();
        values.put("cfname",cf);
        db.update(TABLE_NAME,values,strFilter,us);
        db.close();
    }
    public void updatetop(String user,String top){
        SQLiteDatabase db=this.getWritableDatabase();
        String strFilter="name=?";
        String[] us={user};
        ContentValues values=new ContentValues();
        values.put("topname",top);
        db.update(TABLE_NAME,values,strFilter,us);
        db.close();
    }
    public void updatehe(String user,String he){
        SQLiteDatabase db=this.getWritableDatabase();
        String strFilter="name=?";
        String[] us={user};
        ContentValues values=new ContentValues();
        values.put("hename",he);
        db.update(TABLE_NAME,values,strFilter,us);
        db.close();
    }
    public void updatehr(String user,String hr){
        SQLiteDatabase db=this.getWritableDatabase();
        String strFilter="name=?";
        String[] us={user};
        ContentValues values=new ContentValues();
        values.put("hrname",hr);
        db.update(TABLE_NAME,values,strFilter,us);
        db.close();
    }
}
