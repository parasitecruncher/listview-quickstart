package com.idiots.redundant.listview_quickstart;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by prashanth on 05/07/16.
 */
public class ListAdapter extends ArrayAdapter<String> {
    private final String[] itemname;
    private final MainActivity context;

    public ListAdapter(MainActivity context, String[] itemname) {
        super(context, R.layout.item, itemname);
        this.context=context;
        this.itemname = itemname;
    }

    public View getView(int position, final View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.item, null, true);
        rowView.setOnGenericMotionListener(new View.OnGenericMotionListener() {
            @Override
            public boolean onGenericMotion(View v, MotionEvent event) {
                Toast t=Toast.makeText(rowView.getContext(),event.toString(),Toast.LENGTH_SHORT);
                t.show();
                return false;
            }
        });
        TextView txtTitle = (TextView) rowView.findViewById(R.id.listitem);

        txtTitle.setText(itemname[position]);
        Log.d("ListAdapter","Sending Row View");
        return rowView;
    }
}
