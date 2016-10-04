package com.feicui.activityreturn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    public static final String key = "first";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = (TextView) findViewById(R.id.textView2);
        parstIntent();
    }

    /**
     * 解析数据
     */
    public void parstIntent() {
        Intent intent = getIntent();
        String result = intent.getStringExtra(key);
        switch (result) {
            case "Regist":
                tv.setText("注册成功");
                break;
            case "Login":
                tv.setText("登录成功");
                break;
            default:
                tv.setText("失败");
                break;
        }
    }

    /**
     * 返回结果
     */
    public void ruturnResurt(View view) {
        Intent intent=new Intent();
        switch(tv.getText().toString()){
            case "登录成功":
                intent.putExtra(key,"登陆成功");
                setResult(Activity.RESULT_OK,intent);
                break;
            case "注册成功":
                intent.putExtra(key,"注册成功");
                setResult(Activity.RESULT_OK,intent);
                break;
            default:
                intent.putExtra(key,"失败");
                setResult(Activity.RESULT_CANCELED,intent);
                break;
        }
        finish();

    }

}

