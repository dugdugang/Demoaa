package com.dg.demoaa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<Item> items = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            items.add(new ItemA(1, "A类型"));
////            items.add(new Itemb(2,"B类型"));
////            items.add(new ItemC(3,"C类型"));
//
//        }

        TestAdapter testAdapter = new TestAdapter(this, items);
        testAdapter.setEmptyView(findViewById(R.id.empty));
        testAdapter.addHeader();
        recyclerView.setAdapter(testAdapter);
//        recyclerView.setAdapter(new SingleAdapter<ItemA>(this, items, R.layout.item_a) {
//            @Override
//            public void convertHolder(BaseViewHolder holder, final int posittion, ItemA item) {
//                holder.setText(R.id.textView, "sssss");
//                holder.getItemView().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this, ""+posittion, Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
    }
}
