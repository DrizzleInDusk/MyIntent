package com.feicui.myintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends Activity {

    //这必须是0x100，否则不能一键退出
    public final static int RESULT_EXIT=0x100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    /**
     * 一键退出
     */
    private void oneExit(){

        setResult(RESULT_EXIT);
        finish();
        Toast.makeText(this,"进入到第二页oneExit",Toast.LENGTH_SHORT).show();
    }

    /**
     * 监听一键退出
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_EXIT){
            Toast.makeText(this,"返回第二页",Toast.LENGTH_SHORT).show();
            oneExit();
        }
    }

    public void into3(View view){
        Intent intent=new Intent();
        intent.setClass(this,Main3Activity.class);
        //如果不注释这句话那么不能一键退出
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //正常模式
        //startActivity(intent);
        //一键退出的模式
        startActivityForResult(intent,1);
    }

//    public void into4(View view){
//        Intent intent=new Intent();
//        intent.setClass(this,Main4Activity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }

}
