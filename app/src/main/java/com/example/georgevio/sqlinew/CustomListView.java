package com.example.georgevio.sqlinew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListView {

    private ArrayList<String> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    // Constructor
    public CustomListView(Context context, ArrayList<String> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public int getCount() {
        return listData.size();
    }

    public Object getItem(int position) {
        return listData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //      int type = getItemViewType(position);

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.adapter_list, null);
            holder = new ViewHolder();

            holder.FirstText = (TextView) convertView.findViewById(R.id.editName);
            holder.SecondText = (TextView) convertView.findViewById(R.id.editPhone);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.FirstText.setText("JOPH");
        holder.SecondText.setText("44");

        return convertView;
    }

    static class ViewHolder {
        TextView FirstText;
        TextView SecondText;
    }
}
