package com.dg.recyclevieweasy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author: duguang
 * Date 2017/11/6 0006.
 */

public class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected Context mContext;
    protected List<T> mDatas;
    protected ItemTypeDelagateManager<T> delagateManager;
    protected View emptyView;
    protected SparseArray headers;
    protected SparseArray footers;

    public BaseRecycleAdapter(Context context, List<T> datas) {
        mContext = context;
        mDatas = datas;
        delagateManager = new ItemTypeDelagateManager<>();

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTypeDelagate delagate = delagateManager.getItemTypedelagate(viewType);
        final BaseViewHolder holder = BaseViewHolder.createViewHolder(mContext, View.inflate(mContext, delagate.getLayoutId(), null));
        if (delagate instanceof ItemTypeDelagate.OnItemClickListener) {
            final ItemTypeDelagate.OnItemClickListener listener = (ItemTypeDelagate.OnItemClickListener) delagate;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(holder);
                }
            });
        }
        if (delagate instanceof ItemTypeDelagate.OnItemLongClickListener) {
            final ItemTypeDelagate.OnItemLongClickListener listener = (ItemTypeDelagate.OnItemLongClickListener) delagate;
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClick(holder);
                    return false;
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
            convert(holder, mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        if (emptyView != null) {
            emptyView.setVisibility(mDatas == null || mDatas.size() == 0 ? View.VISIBLE : View.GONE);
        }
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (delagateManager.getItemTypeDelagateCount() > 0) {
            return delagateManager.getItemViewType(mDatas.get(position), position);
        }
        return super.getItemViewType(position);
    }

    protected void convert(BaseViewHolder holder, T item) {
        delagateManager.convert(holder, item);
    }


    public BaseRecycleAdapter addDelagate(ItemTypeDelagate<T> delagate) {

        delagateManager.addDelagate(delagate);
        return this;
    }

    public BaseRecycleAdapter addDelagate(int viewType, ItemTypeDelagate<T> delagate) {
        delagateManager.addDelagate(viewType, delagate);
        return this;
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }

    public void addHeader() {

    }

    public void removeHeader() {

    }

    public void addFooter() {

    }

    public void removeFooter() {
    }


}
