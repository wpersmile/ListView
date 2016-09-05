package com.example.raind.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static String NAME="name";
    private final static String BJ="bj";
    private final static String NUM="num";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names={"李一","李二","李三","李四"};
        String[] bjs={"软件工程 1班","软件工程 2班","计科 1班","计科 5班"};
        String[] nums={"20160111","20160123","20160114","20160132"};

        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();

        for(int i=0;i<nums.length;i++) {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put(NAME, names[i]);
            item.put(BJ, bjs[i]);
            item.put(NUM, nums[i]);
            items.add(item);
        }

        SimpleAdapter adapter=new SimpleAdapter(this,items,R.layout.item,new String[]{NAME,BJ,NUM},
                new int[]{R.id.textViewName,R.id.textViewBj,R.id.textViewNum});

        ListView list=(ListView)findViewById(R.id.list);

        list.setAdapter(adapter);


    }
}
