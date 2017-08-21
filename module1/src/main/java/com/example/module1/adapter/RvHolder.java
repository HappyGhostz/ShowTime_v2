package com.example.module1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.module1.R;

/**
 * @author Zhao Chenping
 * @creat 2017/8/21.
 * @description
 */

public class RvHolder extends RecyclerView.ViewHolder {

    public final ImageView mIv;
    public final TextView mTvTitle;
    public final TextView mTvSource;
    public final TextView mTvTime;
    public final RelativeLayout mRl;

    public RvHolder(View itemView) {
        super(itemView);
        mRl = (RelativeLayout) itemView.findViewById(R.id.m1_rlayout);
        mIv = (ImageView) itemView.findViewById(R.id.m1_iv_icon);
        mTvTitle = (TextView) itemView.findViewById(R.id.m1_tv_title);
        mTvSource = (TextView) itemView.findViewById(R.id.m1_tv_source);
        mTvTime = (TextView) itemView.findViewById(R.id.m1_tv_time);
    }
}
