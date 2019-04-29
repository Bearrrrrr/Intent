package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        editText = (EditText) findViewById(R.id.edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
//                Intent intent = new Intent("com.qylk.call.main");
//                intent.setAction("android.intent.action.VIEW");
//                intent.setAction(" com.qylk.call.main ");
//                intent.setAction("com.qylk.call.main");
                String text=editText.getText().toString();
                intent.addCategory("android.intent.category.MY_CATEGORY");
//                intent.putExtra("url",text);
//                intent.setData(Uri.parse("editText.getText().toString()"));
//                startActivity(intent);
//                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(text));
                Intent choose=Intent.createChooser(intent,"选择一个浏览器");
                startActivity(choose);//没有选择
//                startActivity(intent);
            }
        });
    }
    }

