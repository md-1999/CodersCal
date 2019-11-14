package com.example.coderscal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Activity activity;
    List<SiteModel> sites;
    LayoutInflater inflater;

    public CustomAdapter(Activity activity){
        this.activity=activity;
    }

    public CustomAdapter(Activity activity,List<SiteModel> sites){
        this.activity=activity;
        this.sites=sites;

        inflater=activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return sites.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            view=inflater.inflate(R.layout.list_view_item,viewGroup,false);
            holder=new ViewHolder();
            holder.tvSiteName=(TextView)view.findViewById(R.id.tv_site_name);
            holder.ivCheckBox=(ImageView)view.findViewById(R.id.iv_check_box);

            view.setTag(holder);
        }
        else{
            holder=(ViewHolder)view.getTag();
        }
        SiteModel model=sites.get(i);

        holder.tvSiteName.setText(model.getSiteName());

        if(model.isSelected()){
            holder.ivCheckBox.setBackgroundResource(R.drawable.ic_check_box_black_20dp);
        }
        else{
            holder.ivCheckBox.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_20dp);
        }

        return view;
    }
    public void updateRecords(List<SiteModel> sites){
        this.sites=sites;
        notifyDataSetChanged();
    }
    class ViewHolder{
        TextView tvSiteName;
        ImageView ivCheckBox;
    }

}
