package com.example.butterknife;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 潘硕 on 2017/11/8.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> lists;

    public MyAdapter(Context context, ArrayList<String> list){
        mContext = context;
        lists = list;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (holder==null){
            convertView = View.inflate(mContext,R.layout.item,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String s = lists.get(position);
        holder.tv_test.setText(s);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"你点击了按钮"+position,Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
    static class ViewHolder{
        @BindView(R.id.tv_text)
        TextView tv_test;
        @BindView(R.id.btn)
        Button btn;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
