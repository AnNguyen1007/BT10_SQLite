package com.example.sqlite;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BaiHocAdapter extends BaseAdapter {

    private MainActivity context;
    private int layout;
    private List<BaiHoc> baiHocList;

    public BaiHocAdapter(MainActivity context, int layout, List<BaiHoc> baihocList) {
        this.context = context;
        this.layout = layout;
        this.baiHocList = baihocList;
    }

    @Override
    public int getCount() {
        return baiHocList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView tvTen;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null ){
            viewHolder  = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view  = layoutInflater.inflate(layout,null);

            viewHolder.tvTen = (TextView) view.findViewById(R.id.tvTen);

            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();



        }
        final BaiHoc baiHoc = baiHocList.get(i);
        viewHolder.tvTen.setText(baiHoc.getTenBai());



        return view;
    }
}
