package com.example.listviewapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //extends ar modde onek bundle thake . jemon : on create on resom etc .
    ListView mylistview;
    ArrayList< HashMap <String, String> > arrayList = new ArrayList<>();
    HashMap <String, String> hashMap;
    //Hashmap<key, value> hashMap //key that mean table head name.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mylistview = findViewById(R.id.listview);

        hashMap=new HashMap<>();
        hashMap.put("name","Shahrear");
        hashMap.put("mobile","018");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("name","Tanvir");
        hashMap.put("mobile","016");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("name","Mehedi");
        hashMap.put("mobile","019");
        arrayList.add(hashMap);




//Adapter call koro
        Myadapter myadapter=new Myadapter();
        mylistview.setAdapter(myadapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private  class Myadapter extends BaseAdapter {
    LayoutInflater layoutInflater; // best practice use layoutinflater as a global variable

        @Override
        public int getCount() {
            return arrayList.size(); // মোট কতগুলো আইটেম থাকবে, তা রিটার্ন করবে।
            // এখানে arrayList.size() দিছে কারণ আমরা তো জানব না ইউজার কয়টা
            // ডাটা ইনপুট দিবে তো সেজন্য এটাকে সরাসরি arrayList থেকে size() নিয়ে নিয়েছি।
        }
        @Override
        public Object getItem(int position) {
            return null; // নির্দিষ্ট কোনো পজিশনের আইটেম রিটার্ন করবে।
        }
        @Override
        public long getItemId(int position) {
            return 0;// নির্দিষ্ট পজিশনের আইটেমের আইডি রিটার্ন করবে।
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item, parent, false);

            ImageView imageView = myView.findViewById(R.id.imageView);
            TextView tvName = myView.findViewById(R.id.tvName);
            TextView tvMobile = myView.findViewById(R.id.tvMobile);

            HashMap<String, String> hashMap = arrayList.get(position);

            //tvName.setText(hashMap.get("name"));
            //tvMobile.setText(hashMap.get("mobile"));
            // এভাবে শর্টকাটে ধরা যায় but কোন কাজে কল করা যাবে না । কারণ ভেরিয়েবলে ধরি নেই।





            String name = hashMap.get("name"), mobile = hashMap.get("mobile");
            tvName.setText(name);
            tvMobile.setText(mobile);
           // String & variable ধরতে হবে ।Toast এর ভিতরে কল করব তখন এই ভেরিয়েবল ধরেই কল করতে হবে । তা না হলে কাজ করবে না।



            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Hello\n" +name, Toast.LENGTH_SHORT).show();
                }
            });

            return myView;

        }
    }
    //=========================================

}
