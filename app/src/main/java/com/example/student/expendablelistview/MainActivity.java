package com.example.student.expendablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ArrayList<String> header= new ArrayList<>() ;
    HashMap<String, ArrayList<String>> child= new HashMap<>();

    int lastPosition= -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        loadData();

        initFunctionality();
    }

    private void initFunctionality() {

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {

                if(lastPosition!= -1 && lastPosition!= i){

                    expandableListView.collapseGroup(lastPosition);
                }
                lastPosition =i;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                String childern = child.get(header.get(i)).get(i1);


                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }



    private void loadData() {

        String[] h= getResources().getStringArray(R.array.parent);
        String[] c= getResources().getStringArray(R.array.child);
        int pos= -1;
        for(int i=0; i<h.length; i++ ){
            header.add(h[i]);
            ArrayList<String> list = new ArrayList<>();
            list.add(c[++pos]);
            list.add(c[++pos]);
            child.put(header.get(i),list);

        }


//        header.add("Apple");
//        header.add("Sumsung");
//        header.add("Huwei");
//        header.add("Oppo");
//        header.add("Xiomi");
//
//        ArrayList<String> list = new ArrayList<>();
//        list.add("Expensive");
//        list.add("Most popular");
//
//        child.put(header.get(0), list);
//
//        ArrayList<String> list1 = new ArrayList<>();
//        list1.add("slow, hang");
//        list1.add("popular");
//        child.put(header.get(1), list1);
//
//        ArrayList<String> list2 = new ArrayList<>();
//        list2.add("fast, hang");
//        list2.add("popular");
//        child.put(header.get(2), list2);
//
//        ArrayList<String> list3 = new ArrayList<>();
//        list3.add("slow, hang");
//        list3.add("unpopular");
//        child.put(header.get(3), list3);
//
//        ArrayList<String> list4 = new ArrayList<>();
//        list4.add("fast, hang");
//        list4.add("popular");
//        child.put(header.get(4), list4);

        ExAdapter adapter = new ExAdapter(this,header,child);
        expandableListView.setAdapter(adapter);






    }

    private void initView() {
        expandableListView=findViewById(R.id.exlvId);

    }
}
