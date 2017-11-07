package com.dg.recyclevieweasy;

import android.content.Context;

import java.util.List;

/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class SingleAdapter<T> extends BaseRecycleAdapter {
    public SingleAdapter(Context context, List datas, int id) {
        super(context, datas);
        addDelagate(new Delagate(id));
    }

    class Delagate implements ItemTypeDelagate<T> {
        private int layoutId;

        public Delagate(int layoutId) {
            this.layoutId = layoutId;
        }

        @Override
        public boolean isViewType(T item, int position) {
            return true;
        }

        @Override
        public int getLayoutId() {
            return layoutId;
        }

        @Override
        public void convert(BaseViewHolder holder, int posittion, T item) {
            convertHolder(holder, posittion, item);
        }
    }

    public void convertHolder(BaseViewHolder holder, int posittion, T item) {

    }

}
