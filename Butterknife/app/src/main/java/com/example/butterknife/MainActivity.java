package com.example.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;
    private ArrayList<String> list;


    @BindView(R.id.tv_test1)
    TextView tvTest;
    @BindView(R.id.btn_test1)
    Button btnTest;
    @BindView(R.id.et_test1)
    EditText etTest;
    @BindView(R.id.lv_test1)
    ListView lvTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list = new ArrayList<String>();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        list.add("测试4");
        list.add("测试5");
        list.add("测试10");
        list.add("测试11");
        list.add("测试12");
        list.add("测试13");
        list.add("测试14");
        list.add("测试15");
        adapter = new MyAdapter(this,list);
        lvTest.setAdapter(adapter);

//        tvTest.setText("文本控件已被初始化");
//        btnTest.setText("按钮已被初始化");

    }

    @OnItemClick(R.id.lv_test1)
    public void onMyItemClick(int position){
        Toast.makeText(this,position+"",Toast.LENGTH_SHORT).show();
    }
//这个是手动生成的
    @OnClick(R.id.btn_test1)
    public void onViewClicked() {
        btnTest.setText("我被点击了");
        tvTest.setText("天若有情天亦老");
    }
//下面这个是通过butterknife自动生成的
//    @OnClick(R.id.btn_test1)
//    public void onViewClicked() {
//    }
}
