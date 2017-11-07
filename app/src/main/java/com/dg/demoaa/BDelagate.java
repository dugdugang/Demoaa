package com.dg.demoaa;

import android.widget.Toast;

import com.dg.recyclevieweasy.BaseViewHolder;
import com.dg.recyclevieweasy.ItemTypeDelagate;


/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class BDelagate implements ItemTypeDelagate<Item> ,ItemTypeDelagate.OnItemLongClickListener {

    @Override
    public boolean isViewType(Item itemb, int position) {
        return itemb instanceof Itemb ? true : false;

       // return itemb.getType() == getLayoutId() ? true : false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_b;
    }

    @Override
    public void convert(BaseViewHolder holder, int posittion, Item itemb) {
        holder.setText(R.id.textView2, ((Itemb) itemb).data);

    }

    @Override
    public void onItemLongClick(BaseViewHolder holder) {
        Toast.makeText(holder.getContext(), "长按!"+holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
    }
}
