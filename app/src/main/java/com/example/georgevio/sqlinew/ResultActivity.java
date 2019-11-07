package com.example.georgevio.sqlinew;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    DBHelper mydb;

    DBHelper myDB;
    ArrayList<User> userList;
    ListView listView;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        myDB = new DBHelper(this);

        userList = new ArrayList<>();
        Cursor data = myDB.getContacts();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(ResultActivity.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                user = new User(data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5));
                userList.add(i,user);

                i++;
            }
            Adapter adapter =  new Adapter(this,R.layout.adapter_list, userList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }


    }
}