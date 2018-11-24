package com.example.masti.dewali;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private FloatingActionButton floatingActionButton;
    private Main2Activity thisMain2;

    private Integer[] img = {R.mipmap.majid,R.mipmap.anju,R.mipmap.sujeet,R.mipmap.bhaiyaa,R.mipmap.sunal,
            R.mipmap.subham,R.mipmap.manisha,R.mipmap.abhay_sir,R.mipmap.paul_sir,R.mipmap.prince,
            R.mipmap.supu,R.mipmap.khusboo,R.mipmap.pragati,R.mipmap.sanjay,R.mipmap.shainy,R.mipmap.alka};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String mess = intent.getStringExtra("importantMessage");


        thisMain2 = this;
        imageView = findViewById(R.id.bigImg);
        textView = findViewById(R.id.dMessage);
        floatingActionButton = findViewById(R.id.bnt_status);
        textView.setText(textView.getText().toString()+" "+mess);

        String finalMessage = mess.toLowerCase();
        int i=0;

           if(finalMessage.equals("majid anari"))
               i=0;
           else
               if(finalMessage.equals("anju kumari"))
                    i=1;
           else
               if(finalMessage.equals("sujeet kumar"))
                   i=2;
           else
               if(finalMessage.equals("prasant bhaiyaa"))
                   i=3;
           else
               if(finalMessage.equals("sunal kumar"))
                   i=4;
           else
               if(finalMessage.equals("shubham kumar"))
                   i=5;
           else
                if(finalMessage.equals("manisha kumari"))
                    i=6;
           else
                if(finalMessage.equals("abhay sir"))
                   i=7;
           else
                if(finalMessage.equals("paul sir"))
                   i=8;
           else
                if(finalMessage.equals("prince kumar"))
                    i=9;
            else
                if(finalMessage.equals("supu kumari"))
                   i=10;
           else
                if(finalMessage.equals("khusboo kumari"))
                   i=11;
           else
               if(finalMessage.equals("pragati kumari"))
                   i=12;
           else
               if(finalMessage.equals("sanjay kumar"))
                   i=13;
           else
               if(finalMessage.equals("shainy kiro"))
                   i=14;
           else
               if(finalMessage.equals("alka kumari"))
                   i=15;

        imageView.setImageResource(img[i]);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisMain2,Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
