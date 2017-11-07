package com.dg.recyclevieweasy;

/**
 * Author: duguang
 * Date 2017/11/6 0006.
 */

public interface ItemTypeDelagate<T> {
    boolean isViewType(T t, int position);

    int getLayoutId();

    void convert(BaseViewHolder holder, int posittion, T t);


    interface OnItemClickListener {
        void onItemClick(BaseViewHolder holder);
    }

    interface OnItemLongClickListener {
        void onItemLongClick(BaseViewHolder holder);
    }
}
