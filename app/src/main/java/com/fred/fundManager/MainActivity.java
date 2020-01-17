package com.fred.fundManager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.fred.fundManager.constant.TableNameConstant;
import com.fred.fundManager.db.SqliteDB;

import static com.fred.fundManager.constant.TableNameConstant.TB_MONEY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = new SqliteDB(this, "/data/fund.db", null, 1).getWritableDatabase();

       // db.insert()

        //金额初始化
        ContentValues values = new ContentValues();
        values.put("money", 0.00);
        db.insert(TB_MONEY, null, values);

        Cursor query = db.query(TableNameConstant.TB_MONEY, new String[]{"money"}, null, null, null, null, null);

        while (query.moveToNext()) {
            float money = query.getFloat(query.getColumnIndex("money"));
            System.out.println(money);
        }
    }

}
