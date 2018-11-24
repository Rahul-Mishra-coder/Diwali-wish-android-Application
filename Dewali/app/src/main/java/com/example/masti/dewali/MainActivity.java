package com.example.masti.dewali;

import android.content.Intent;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView ;

    private String[] personName={"Majid Ansari","Anju Kumari","Sujeet Kumar","Prasant Bhaiyaa","Sunal Kumar",

    "Shubham Kumar","Manisha Kumari","Abhay Sir","Paul Sir","Prince Kumar","Supu Kumari","Khusboo Kumari",
    "Pragati Kumari","Sanjay Kumar","Shainy Kiro","Alka Kumari"};

    private Integer[] imgId = {R.mipmap.majid,R.mipmap.anju,R.mipmap.sujeet,R.mipmap.bhaiyaa,R.mipmap.sunal,
    R.mipmap.subham,R.mipmap.manisha,R.mipmap.abhay_sir,R.mipmap.paul_sir,R.mipmap.prince,R.mipmap.supu,R.mipmap.khusboo,R.mipmap.pragati,R.mipmap.sanjay,R.mipmap.shainy,R.mipmap.alka};

    private String[] phNumber ={"9934798001","7903303772","8409978785","9709704047","7992456931",
    "9955717315","7781870320","7070794787","9889482378","7870435320","8789531550","9199325212",
    "9709298225","9931838558","7903824496","7319722717"};

    private EditText password;
    private Switch aSwitch;
    private Button btnLogin;
    private EditText txtBox;
    private MainActivity thisMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        password = findViewById(R.id.editText2);
        aSwitch = findViewById(R.id.switch1);
        btnLogin = findViewById(R.id.button2);
        txtBox = findViewById(R.id.editText);
        thisMain =this;

        CustomList customList = new CustomList(this,personName,imgId);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtBox.setText(personName[position]);
            }
        });



        aSwitch.setOnClickListener(new CompoundButton.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(aSwitch.isChecked()){
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    
                }
                else{
                    password.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String str = txtBox.getText().toString();

                for(int i=0;i<personName.length;i++){
                    if(personName[i].equalsIgnoreCase(str) & phNumber[i].equals(password.getText().toString())){

                        String message = txtBox.getText().toString();

                        Intent intent = new Intent(thisMain,Main2Activity.class);
                        intent.putExtra("importantMessage",message);

                        startActivity(intent);

                        txtBox.setHint("Enter you name");
                        password.setHint("Password");

                        txtBox.setText("");
                        password.setText("");

                        break;

                    }
                    else
                    {
                        if(i==personName.length -1)
                        {
                            txtBox.setText("");
                            password.setText("");

                            txtBox.setHint(R.string.invalid_name);
                            password.setHint(R.string.invalid_password);
                        }

                    }
                }
            }
        });


    }
}
