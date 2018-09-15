package com.example.student.expendablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExAdapter extends BaseExpandableListAdapter {

    private Context context;
    ArrayList<String> header = new ArrayList<>();
    HashMap<String, ArrayList<String>> child = new HashMap<>();

    public ExAdapter(Context context, ArrayList<String> header, HashMap<String, ArrayList<String>> child) {
        this.context = context;
        this.header = header;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return header.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child.get(header.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return header.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child.get(header.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent_layout, null);
        }

            String s = (String) getGroup(i);
            TextView textView = view.findViewById(R.id.tvHeader);
           textView.setText(s);


        return view;

    }


    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_layout, null);
        }

            String s = (String) getChild(i,i1);
            TextView textView = view.findViewById(R.id.tvChild);
            textView.setText(s);


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
