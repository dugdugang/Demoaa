package com.dg.demoaa;

/**
 * Author: duguang
 * Date 2017/11/7 0007.
 */

public class ItemA extends Item {
    private String value;

    public ItemA( String value) {
        this.value = value;
        this.type = R.layout.item_a;
    }
    public ItemA(int type, String value) {
        this.value = value;
        this.type = type;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
