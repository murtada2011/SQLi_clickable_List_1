/*made it by Murtada 202392463*/


package com.example.georgevio.sqlinew;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper mydb;

    Button bttnshow1,  bttnshowall, bttnadd;
    EditText editTextName, editTextPhone, editTextEmail, editTextPlace, editTextGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);

        editTextName = (EditText)findViewById(R.id.editName);
        editTextPhone = (EditText)findViewById(R.id.editPhone);
        editTextEmail = (EditText)findViewById(R.id.txtEmail);
        editTextPlace = (EditText)findViewById(R.id.editPlace);
        editTextGender = (EditText)findViewById(R.id.txtGender);

        bttnadd = (Button) findViewById(R.id.bttnAdd);
        bttnshow1 = (Button) findViewById(R.id.bttnShow1);
        bttnshowall = (Button) findViewById(R.id.bttnShowAll);

        bttnadd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String getName = editTextName.getText().toString();
                String getPhone = editTextPhone.getText().toString();
                String getEmail = editTextEmail.getText().toString();
                String getPlace = editTextPlace.getText().toString();
                String getGender = editTextGender.getText().toString();


                if (mydb.insertContact(getName, getPhone, getEmail, getPlace, getGender)) {
                    Log.v("georgeLog", "A Record Has Been Inserted To DateBase Successfully");
                    Toast.makeText(getApplicationContext(),
                            "Inserted:" + getName + ", " + getPhone + "," + getEmail+ "," + getPlace+ "," + getGender, Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "No Data Has Been Inserted To DataBase!", Toast.LENGTH_SHORT).show();
            }
        });

        bttnshow1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("georgeLog", "clicked on fetch");
                Cursor getData=mydb.getData(1); //specific record (id=1)

                if (getData.moveToNext()) {// data?
                    Log.v("georgeLog", "data found in DB...");
                    String dName = getData.getString(getData.getColumnIndex("name"));
                    String dPhone = getData.getString(getData.getColumnIndex("phone"));
                    String dEmail = getData.getString(getData.getColumnIndex("email"));
                    String dPlace = getData.getString(getData.getColumnIndex("place"));
                    String dGender = getData.getString(getData.getColumnIndex("gender"));
                    Toast.makeText(getApplicationContext(),
                            "Record" + dName + ", " + dPhone + ", " + dEmail + ", " + dPlace + ", " + dGender, Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Did Not Receive Data ", Toast.LENGTH_LONG).show();
                getData.close();
            }
        });

        bttnshowall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("georgeLog", "clicked on Result Button");
                ArrayList<String> fetchAll = new ArrayList<String>();
                fetchAll=mydb.getAllContacts();
                for (String a:fetchAll)
                    Log.v("georgeLog:", a.toString());
                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    Log.v("georgeLog:", "intent executed");
                    intent.putStringArrayListExtra("fetchAll",fetchAll);
                    Log.v("georgeLog:","fetchALL executed");
                    startActivity(intent);
                    Log.v("georgeLog:", "startActivity executed");
            }
        });

        // to delete a record
        //find the record you want, get its id, and use the following
        //mydb.deleteContact (id);

    }
}
