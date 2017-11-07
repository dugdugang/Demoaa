package com.dg.demoaa;

/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class Itemb extends Item {
    String data;

    public Itemb(String value) {
        this.data = value;
        this.type = R.layout.item_b;
    }

    public Itemb(int type, String value) {
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
