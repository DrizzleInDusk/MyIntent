package com.feicui.myintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public final static int RESULT_EXIT=0x100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 一键退出
     */
    private void oneExit(){
        finish();
    }

    /**
     * 监听一键退出
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_EXIT){

            oneExit();
        }
    }

    public void into2(View view){
        Intent intent=new Intent();
        intent.setClass(this,Main2Activity.class);
        //正常模式
        //startActivity(intent);
        //一键退出的模式
        startActivityForResult(intent,1);
    }

//    public void startActivityBysetComponent(View view){
//        Intent intent=new Intent();
//        //通过logcat查看点击设置后出现的提示而写出的
//        //这里写的是包名
//        ComponentName cn=new ComponentName( "com.android.settings",
//                "com.android.settings.Settings"
//        );
//       intent.setComponent(cn);
//       startActivity(intent);
//    }
//
//    /**
//     * 最常用的，第一参数为context，第二为类，范围相对setClassName比较小
//     */
//    public void startActivityBysetclass(View view){
//        Intent intent=new Intent();
//        intent.setClass(this,Main2Activity.class);
//        startActivity(intent);
//    }
//
//    /**
//     *范围相对大，因为不用上下文，只要写存在的名字就行
//     */
//    public void startActivityBysetClassName(View view){
//        Intent intent=new Intent();
//        intent.setClassName("com.android.settings",
//                "com.android.settings.Settings");

//电话的logcat所显示
//        intent.setClassName("com.android.dialer",
//                "com.android.dialer.DialtactsActivity");
//        startActivity(intent);

//    }

    /**
     * 指定要执行的通用操作，这里是隐式
     */
//    public void startMyIntent(View view){
//        Intent intent=new Intent();
//        //这是自定义的隐式
//        //   intent.setAction("com.feicui.myintent");
//        //该属性为 要查看
//        intent.setAction(Intent.ACTION_VIEW);
//        startActivity(intent);
//
//    }
//
//    /**
//     * 设置了一个包含应处理 Intent 组件类型的附加信息的字符串。
//     */
//    public void startImageUriIntent(View view){
//        File file=new File(Environment.getExternalStoragePublicDirectory
//                (Environment.DIRECTORY_PICTURES),"sunset.jpg");
//        if (file.exists()){
//            Intent intent=new Intent();
//            Uri uri=Uri.fromFile(file);
//            intent.setDataAndType(uri,"image/*");
//            intent.setAction(Intent.ACTION_VIEW);
//            startActivity(intent);
//
//        }
//        else {
//            Toast.makeText(this,"没有这个文件",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /**
//     * 添加Extra
//     * 携带完成请求操作所需的附加信息的键值对
//     */
//    public void startActivityByKey(View view){
//        Intent intent=new Intent();
//        Bundle bundle=new Bundle();
//        bundle.putString("key1","爱好的空间和");
//        bundle.putString("key2","lkjkljads");
//        intent.putExtras(bundle);
//        intent.setClass(this,Main3Activity.class);
//        startActivity(intent);
//    }



//    public void startIntentTestActivity(View view) {
//        /*
//         * 1.指定的Intent中的Action或Category,只要某个过
//         * 滤器中存在相应的内容(过滤器中的元素可以超出,但不可缺少)
//         * 则会匹配成功,但是不可单独使用Category进行匹配,必须与Action结合
//         *
//         * 2.Intent可以使用单独的Data来进行匹配,使用该Intent时,实际上默认添加了类似
//         * VIEW和EDIT之类的操作
//         *
//         * 3.若Data中只指定了MIME类型,则默认的Uri会匹配Content和File架构,若显式指定
//         * uri,则必须匹配该uri
//*4.隐式Intent过滤器中必须有Action,否则不会正确匹配
//         */
//
////        //Intent中含有目标过滤器中的某个对应Action,则会成功匹配
////        //指定一个隐式的Intent
////        Intent mIntent = new Intent(Intent.ACTION_VIEW);
////        //启动对应组件
////        startActivity(mIntent);
//
////        //Intent中含有目标过滤器中的某个对应Category,则会成功匹配
////        //指定一个隐式的Intent
////        Intent mIntent = new Intent();
////        //指定它的操作
////        mIntent.setAction(Intent.ACTION_VIEW);
////        //指定它的类别
////        mIntent.addCategory("com.feicui.lichao.MYCATEGORY");
////        //启动对应组件
////        startActivity(mIntent);
//
//
//        //指定一个隐式的Intent
//        Intent mIntent = new Intent();
//        //指定它的数据类别
//        mIntent.setDataAndType(Uri.parse("content://"), "video/*");
//        //启动对应组件
//        startActivity(mIntent);
//
//        //检查对应的Acitivity
//        List<ResolveInfo> list =
//                getPackageManager().
//                        queryIntentActivities(
//                                mIntent,
//                                PackageManager.MATCH_DEFAULT_ONLY);
//    }

}
