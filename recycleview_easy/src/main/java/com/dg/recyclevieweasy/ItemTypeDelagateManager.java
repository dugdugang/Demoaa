package com.dg.recyclevieweasy;

import android.util.SparseArray;

/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class ItemTypeDelagateManager<T> {

    SparseArray<ItemTypeDelagate<T>> delagates = new SparseArray<>();

    public int getItemTypeDelagateCount() {
        return delagates.size();
    }

    public ItemTypeDelagateManager<T> addDelagate(ItemTypeDelagate<T> delagate) {

        if (delagate != null && delagates.get(delagate.getLayoutId()) == null) {
            delagates.put(delagate.getLayoutId(), delagate);
        }
        return this;
    }

    public ItemTypeDelagateManager<T> addDelagate(int viewType, ItemTypeDelagate<T> delagate) {
        if (delagates.get(viewType) != null) {
            throw new IllegalArgumentException(" An ItemTypeDelagate is registered for the viewType ="
                    + viewType
                    + ". Already registered ItemTypeDelagate is"
                    + delagates.get(viewType));
        }
        delagates.put(viewType, delagate);
        return this;
    }

    public ItemTypeDelagateManager<T> removeDelagate(ItemTypeDelagate<T> delagate) {
        if (delagate == null) {
            throw new NullPointerException("ItemTypeDelagate is null");
        }
        int index = delagates.indexOfValue(delagate);
        if (index >= 0) {
            delagates.removeAt(index);
        }
        return this;
    }

    public ItemTypeDelagateManager<T> removeDelagate(int viewType) {
        int index = delagates.indexOfKey(viewType);
        if (index >= 0) {
            delagates.removeAt(index);
        }
        return this;
    }

    public int getItemViewType(T item, int position) {
        int count = delagates.size();
        for (int i = count - 1; i >= 0; i--) {
            ItemTypeDelagate<T> delagate = delagates.valueAt(i);
            if (delagate.isViewType(item, position)) {
                return delagates.keyAt(i);
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegate added that matches position=" + position + " in data source");
    }

    public void convert(BaseViewHolder holder, T item) {
        int count = delagates.size();
        for (int i = 0; i < count; i++) {
            if (delagates.valueAt(i).isViewType(item, holder.getAdapterPosition())) {
                delagates.valueAt(i).convert(holder, holder.getAdapterPosition(), item);
                return;
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegateManager added that matches position=" + holder.getAdapterPosition() + " in data source");
    }

    public ItemTypeDelagate getItemTypedelagate(int viewType) {
        return delagates.get(viewType);
    }

    public int getItemTypeLayoutId(int viewType) {
        return getItemTypedelagate(viewType).getLayoutId();
    }

    public int getItemViewType(ItemTypeDelagate itemTypeDelagate) {
        return delagates.indexOfValue(itemTypeDelagate);
    }
}
