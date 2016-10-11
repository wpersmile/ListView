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

        //定于ListView中TextView的数据
        String[] names={"李一","李二","李三","李四","李五","李六","李七"};

        String[] bjs={"软工1401班","软工1402班",
                "计科1401班","计科1402班",
                "网工1401班","网工1402班","网工1403班"};

        String[] nums={"20160111","20160122","20160113","20160134","20160135","20160136","20160137"};


        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();

        for(int i=0;i<names.length;i++) {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put(NAME, names[i]);
            item.put(BJ, bjs[i]);
            item.put(NUM, nums[i]);
            items.add(item);
        }

        //创建适配器
        //items表示显示的数据，一个Map为一行，List<Map>表示多行
        //R.layout.item表示一个item的布局
        //new String[]{NAME,BJ,NUM},表示将key="NAME"的值映射到R.id.textViewName上
        SimpleAdapter adapter=new SimpleAdapter(this,items,R.layout.item,
                new String[]{NAME,BJ,NUM},
                new int[]{R.id.textViewName,R.id.textViewBj,R.id.textViewNum});

        ListView list=(ListView)findViewById(R.id.list);
        //设置适配器
        list.setAdapter(adapter);


    }
}
