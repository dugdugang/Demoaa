package com.dg.demoaa;

/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class ItemC extends Item {
    String data;

    public ItemC(String value) {
        this.data = value;
        this.type = R.layout.item_b;
    }

    public ItemC(int type, String value) {
        this.data = value;
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
