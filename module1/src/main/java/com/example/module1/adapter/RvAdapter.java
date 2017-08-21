package com.example.module1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.module1.R;
import com.example.module1.data.NewsInfo;

import java.util.List;

/**
 * @author Zhao Chenping
 * @creat 2017/8/21.
 * @description
 */

public class RvAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<NewsInfo.NewsInfoBean> mList;
    private NewsInfo.NewsInfoBean infoBean;

    public RvAdapter(Context baseMyContext, List<NewsInfo.NewsInfoBean> mList) {
        this.mList = mList;
        mContext = baseMyContext;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RvHolder holder = new RvHolder(LayoutInflater.from(mContext).inflate(R.layout.m1_item_news,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageView ivSrc = ((RvHolder)holder).mIv;
        TextView tvTitle = ((RvHolder)holder).mTvTitle;
        TextView tvSource = ((RvHolder)holder).mTvSource;
        TextView tvTime = ((RvHolder)holder).mTvTime;
        RelativeLayout rv = ((RvHolder)holder).mRl;
        infoBean = mList.get(position);
        Glide.with(mContext).load(infoBean.getImgsrc()).into(ivSrc);
        tvSource.setText(infoBean.getSource());
        tvTitle.setText(infoBean.getTitle());
        tvTime.setText(infoBean.getMtime());

        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
                    onClickListener.onClick();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public interface OnItemClickListener{
        void onClick();
    }
    private OnItemClickListener onClickListener;
    public void setOnitemClickListener(OnItemClickListener onitemClickListener){
        this.onClickListener=onitemClickListener;
    }
}
