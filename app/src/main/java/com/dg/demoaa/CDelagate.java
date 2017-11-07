package com.dg.demoaa;

import android.view.View;
import android.widget.Toast;

import com.dg.recyclevieweasy.BaseViewHolder;
import com.dg.recyclevieweasy.ItemTypeDelagate;


/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class CDelagate implements ItemTypeDelagate<Item> {
    @Override
    public boolean isViewType(Item item, int position) {
        return item instanceof ItemC ? true : false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_c;
    }

    @Override
    public void convert(final BaseViewHolder holder, int posittion, Item item) {
        holder.setOnClick(R.id.iv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.getContext(), "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
