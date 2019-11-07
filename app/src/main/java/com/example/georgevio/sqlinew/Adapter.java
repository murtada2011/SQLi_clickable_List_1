package com.example.georgevio.sqlinew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public Adapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView name = (TextView) convertView.findViewById(R.id.txtName);
            TextView phone = (TextView) convertView.findViewById(R.id.txtPhone);
            TextView email = (TextView) convertView.findViewById(R.id.txtEmail);
            TextView place = (TextView) convertView.findViewById(R.id.txtPlace);
            TextView gender = (TextView) convertView.findViewById(R.id.txtGender);
            // check if fields are not empty
            if (name != null) {
                name.setText(user.getName());
            }
            if (phone != null) {
                phone.setText((user.getPhone()));
            }
            if (email != null) {
                email.setText((user.getEmail()));
            }
            if (place != null) {
                place.setText((user.getPlace()));
            }
            if (gender != null) {
                gender.setText((user.getGender()));
            }
        }

        return convertView;
    }
}