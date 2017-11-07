package com.dg.demoaa;

import android.content.Context;

import com.dg.recyclevieweasy.BaseRecycleAdapter;

import java.util.List;

/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class TestAdapter extends BaseRecycleAdapter<Item> {
    public TestAdapter(Context context, List datas) {
        super(context, datas);
        addDelagate(1, new ADelagate());
        addDelagate(2, new BDelagate());
        addDelagate(3, new CDelagate());

    }


}
