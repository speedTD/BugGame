package com.developer.dinhduy.buggame;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;

public class BugAdapter extends ArrayAdapter<Integer>{

    public BugAdapter(@NonNull Context context, int resource, Integer[] obj) {
        super(context, resource, obj);
        Resource = resource;
        this.context = context;
        this.obj = obj;
        adapter=new ArrayAdapter<Integer>(context,R.layout.support_simple_spinner_dropdown_item,Price);
    }
    private ArrayAdapter<Integer> adapter;
    private int Resource;
    private Context context;
    private Integer [] obj;
    private Integer [] Price={0,1000,5000,10000,50000};

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=View.inflate(context,Resource,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.image_id);
        Spinner spinner=(Spinner) view.findViewById(R.id.spiner_id);
        imageView.setImageResource(obj[position]);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.Arraychoise[position]=Price[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        return view;
    }
}
