package com.feicui.myintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Main3Activity extends Activity {
    public final static int RESULT_EXIT=0x100;
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv3= (TextView) findViewById(R.id.textView3);
      //  getKey();
    }

    /**
     * 解析传递key的intent并设置
     */
//    private void getKey(){
//        Intent intent=getIntent();
//       Bundle bundle= intent.getExtras();
//        if (bundle!=null){
//            tv3.setText("value1:"+bundle.getString("key1")+"\n"+
//                    "value2:"+bundle.getString("key2")+"\n");
//        }
//        }

    public void into1(View view){
        Intent intent=new Intent();
        intent.setClass(this,MainActivity.class);
        //清除了1往后的activity
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //正常模式
        startActivity(intent);
        //一键退出的模式
        startActivityForResult(intent,1);
    }

    /**
     * 一键退出
     */

    public void exit(View view){
        oneExit();
    }

    private void oneExit(){
        setResult(RESULT_EXIT);
        finish();
    }

}
