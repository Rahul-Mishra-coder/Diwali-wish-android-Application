package com.example.masti.dewali;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private String[] personName;
    private Integer[] imgId;
    private Activity context;

    public CustomList( Activity context,String[] personName,Integer[] imgId){
        super(context,R.layout.item_lists,personName);
        this.context = context;
        this.personName = personName;
        this.imgId = imgId;
    }


    @NonNull
    @Override
    public View getView(int position,  @Nullable View convertView,@NonNull ViewGroup parent) {

        View r = convertView;

        ViewHolder viewHolder = null;

        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=  layoutInflater.inflate(R.layout.item_lists,null,true);

            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder =(ViewHolder) r.getTag();
        }

        viewHolder.imageView.setImageResource(imgId[position]);
        viewHolder.textView.setText(personName[position]);

        return r;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;

        ViewHolder(View view){
            textView = view.findViewById(R.id.view1);
            imageView = view.findViewById(R.id.img1);
        }
    }
}
