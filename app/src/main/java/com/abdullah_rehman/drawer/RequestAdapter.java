package com.abdullah_rehman.drawer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abdullah_Rehman on 28-Sep-17.
 */

public class RequestAdapter extends ArrayAdapter<RequestModel> {

    ArrayList<RequestModel> requestsList;
    int Resource;
    LayoutInflater vi;
    ViewHolder holder;
    Drawable light_grey_bg;

    public RequestAdapter(Context context, int resource, ArrayList<RequestModel> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        requestsList = objects;
        Resource = resource;
        light_grey_bg = context.getResources().getDrawable(R.drawable.light_grey_bg);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = vi.inflate(Resource, null);
            if(position%2==0){
                convertView.setBackground(light_grey_bg);
            }

            holder = new ViewHolder();
            holder.tvBloodGroup = (TextView) convertView.findViewById(R.id.tvBloodGroup);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            holder.tvCity = (TextView) convertView.findViewById(R.id.tvCity);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        RequestModel singleObject = requestsList.get(position);
        holder.tvBloodGroup.setText(singleObject.getBloodGroup());
        holder.tvDate.setText(singleObject.getDate());
        holder.tvCity.setText(singleObject.getCity());
        return convertView;
    }

    static class ViewHolder{
        public TextView tvBloodGroup, tvDate, tvCity;
    }
}
