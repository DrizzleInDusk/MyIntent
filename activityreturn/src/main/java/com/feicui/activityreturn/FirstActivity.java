package com.feicui.activityreturn;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends Activity {
    public static final int Regist=0;
    public static final int Login=1;
    public static final int Other=2;
    public static final int Phone=3;

    public static final String key="first";

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.textView);
    }

    public void Regist(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra(key,"Regist");
        startActivityForResult(intent,Regist);
    }

    public void Login(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra(key,"Login");
        startActivityForResult(intent,Login);
    }

    public void Other(View view){
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra(key,"other");
        startActivityForResult(intent,Other);
    }

    public void Phone(View view){
        Intent intent=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent,Phone);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode){
            case Activity.RESULT_OK:
                switch (requestCode){
                    case Regist:
                        tv.setText("注册成功");
                        break;
                    case Login:
                        tv.setText("登陆成功");
                        break;
                    case Phone:
                        Cursor c=getContentResolver().query(
                                data.getData(),
                                new String[]{ContactsContract.Contacts.DISPLAY_NAME},
                                null,null,null
                        );
                        int index=c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                        while (c.moveToNext()){
                            String name=c.getString(index);
                            tv.setText(name);
                        }
                        break;
                }
                break;
            case Activity.RESULT_CANCELED:
                tv.setText("失败");
                break;

        }

    }
}

