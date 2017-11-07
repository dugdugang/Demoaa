package com.dg.demoaa;

import android.widget.Toast;

import com.dg.recyclevieweasy.BaseViewHolder;
import com.dg.recyclevieweasy.ItemTypeDelagate;

/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class ADelagate implements ItemTypeDelagate<Item>, ItemTypeDelagate.OnItemClickListener {


    @Override
    public boolean isViewType(Item item, int position) {
        return item instanceof ItemA ? true : false;
        // return item.getType() == getLayoutId() ? true : false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_a;
    }

    @Override
    public void convert(BaseViewHolder holder, int posittion, Item item) {
        holder.setText(R.id.textView, ((ItemA) item).getValue());
    }

    @Override
    public void onItemClick(BaseViewHolder holder) {
        Toast.makeText(holder.getContext(), "hello world!"+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
    }
}
