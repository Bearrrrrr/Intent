# Intent
跳转webview页面
![](https://github.com/Bearrrrrr/Intent/blob/master/image/QQ%E5%9B%BE%E7%89%8720190429204857.png)
![](https://github.com/Bearrrrrr/Intent/blob/master/image/QQ%E5%9B%BE%E7%89%8720190429204902.png)

Intetnt
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

web
package com.example.web;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="fff" ;
    //    Bundle bundle ;
    WebView webView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = this.getIntent();
        String url=intent.getData().toString();
//        bundle = intent.getExtras();
        webView = (WebView)findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        if(url !=null){

            webView.loadUrl(url);
        }
//        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }

        });




    }
}

web Manifest
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.web">
    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:usesCleartextTraffic="true"
        android:theme="@style/AppTheme">

        <activity android:name=".MainActivity">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.MY_CATEGORY"/>

                <data android:scheme="http"/>
                <data android:scheme="https"/>
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
    </application>

</manifest>
