package com.dg.recyclevieweasy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Author: duguang
 * Date 2017/11/6 0006.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private View mItemView;
    private Context mContext;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.mItemView = itemView;
        views = new SparseArray<>();
    }

    public static BaseViewHolder createViewHolder(Context context, View itemView) {
        return new BaseViewHolder(context, itemView);
    }

    public static BaseViewHolder createViewHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent);
        return new BaseViewHolder(context, itemView);
    }


    /**
     * 获取view
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
        }
        return (T) view;
    }

    /**
     * 设置文本信息
     *
     * @param id
     * @param s
     * @return
     */
    public BaseViewHolder setText(int id, String s) {
        TextView textView = getView(id);
        textView.setText(s);
        return this;
    }

    /**
     * 设置图片资源
     *
     * @param id
     * @param img
     * @return
     */
    public BaseViewHolder setImageResource(int id, int img) {
        ImageView imageView = getView(id);
        imageView.setImageResource(id);
        return this;
    }

    public View getItemView() {
        return mItemView;
    }

    public Context getContext() {
        return mContext;
    }

    public void setOnClick(int id, View.OnClickListener onClickListener) {
        View view = getView(id);
        view.setOnClickListener(onClickListener);
    }

}
