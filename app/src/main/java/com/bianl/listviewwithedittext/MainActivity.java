package com.bianl.listviewwithedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView mList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = (ListView) findViewById(R.id.list);
        List<String> datas = new ArrayList<>();
        datas.add("黄昏");
        datas.add("清晨");
        datas.add("幼鸟");
        datas.add("绝望");
        datas.add("难过");
        datas.add("伤心");
        datas.add("奋斗");
        datas.add("振作");
        datas.add("候鸟");
        datas.add("飞翔");
        datas.add("歌唱");
        datas.add("气馁");
        datas.add("失望");
        datas.add("忧虑");
        datas.add("春天");
        datas.add("幻想");
        datas.add("种子");
        datas.add("孩子");
        datas.add("激动");
        datas.add("过去");
        datas.add("现在");
        datas.add("后悔");
        datas.add("遗憾");
        datas.add("迷茫");
        datas.add("犹豫");
        datas.add("茫然");
        datas.add("惘然");
        datas.add("枉然");
        datas.add("生活");
        adapter = new Adapter(datas, this);
        mList.setAdapter(adapter);
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("TAG", adapter.getJson());
    }
}
