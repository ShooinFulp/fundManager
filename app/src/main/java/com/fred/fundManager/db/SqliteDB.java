package com.fred.fundManager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.fred.fundManager.constant.TableNameConstant;

import static com.fred.fundManager.constant.TableNameConstant.*;

/**
 * @USER: admin
 * @DATE: 2020/1/17
 * @TIME: 17:02
 **/
public class SqliteDB extends SQLiteOpenHelper {

    public SqliteDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        StringBuffer sb = new StringBuffer();
//        //类型表
//        sb.append("    create table " + TB_TYPE + "(_id integer primary key autoincrement,name varchar(20))   ");
//        //金额表
//        sb.append("    create table " + TB_MONEY + "(money REAL)   ");
//        //账单表
//        sb.append("    create table " + TB_HISTORY + "(" +
//                "_id integer primary key autoincrement," +
//                "type integer," +
//                "money real," +
//                "before_money real," +
//                "after_money real," +
//                "remark varchar(50)," +
//                "create_date text,," +
//                "update_date text," +
//                "gc_flag integer" +
//                ")   ");
//        //金额初始化
//        sb.append("     insert into " + TB_MONEY + " values (0.00)      ");
        //类型表
        String create_TB_TYPE = "    create table " + TB_TYPE + "(_id integer primary key autoincrement,name varchar(20))   ";
        db.execSQL(create_TB_TYPE);

        String create_TB_MONEY = "    create table " + TB_MONEY + "(_id integer primary key autoincrement,money real)   ";
        db.execSQL(create_TB_MONEY);

        String create_TB_HISTORY = "    create table " + TB_HISTORY + "(" +
                "_id integer primary key autoincrement," +
                "type integer," +
                "money real," +
                "before_money real," +
                "after_money real," +
                "remark varchar(50)," +
                "create_date text,," +
                "update_date text," +
                "gc_flag integer" +
                ")   ";
        db.execSQL(create_TB_HISTORY);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

