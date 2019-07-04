package com.example.hcc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPopWindow();
        DragView dragView = (DragView) findViewById(R.id.drag_view);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_container);
        dragView.setOnDragViewClickListener(new DragView.onDragViewClickListener() {
            @Override
            public void onDragViewClick() {
                mPopWindow.showAtLocation(relativeLayout, Gravity.CENTER,0,0);
                Toast.makeText(MainActivity.this,"点击按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private PopupWindow mPopWindow;
    private void initPopWindow() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_menu,null);
        //处理popWindow 显示内容
        handleLogic(contentView);
//        mPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
//                .setView(R.layout.pop_menu)//显示的布局，还可以通过设置一个View
//                //     .size(600,400) //设置显示的大小，不设置就默认包裹内容
//                .setFocusable(true)//是否获取焦点，默认为ture
//                .setOutsideTouchable(true)//是否PopupWindow 以外触摸dissmiss
//                .create();//创建PopupWindow
        mPopWindow = new PopupWindow(contentView, RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setWidth(RelativeLayout.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        mPopWindow.setContentView(contentView);



    }
    private void handleLogic(View contentView){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String showContent = "";
                switch (v.getId()){
                    case R.id.iv_btn_1:
                        showContent = "点击 Item菜单1";
                        break;
                    case R.id.iv_btn_2:
                        showContent = "点击 Item菜单2";
                        break;
                    case R.id.iv_btn_3:
                        showContent = "点击 Item菜单3";
                        break;
                    case R.id.iv_btn_4:
                        showContent = "点击 Item菜单4";
                        break;
                    case R.id.iv_btn_5:
                        showContent = "点击 Item菜单5" ;
                        break;
                }
                Toast.makeText(MainActivity.this,showContent,Toast.LENGTH_SHORT).show();
                if(mPopWindow!=null){
                    mPopWindow.dismiss();
                }
            }

        };
        ImageView view1 = (ImageView) contentView.findViewById(R.id.iv_btn_1);
        view1.setOnClickListener(listener);
        contentView.findViewById(R.id.iv_btn_2).setOnClickListener(listener);
        contentView.findViewById(R.id.iv_btn_3).setOnClickListener(listener);
        contentView.findViewById(R.id.iv_btn_4).setOnClickListener(listener);
        contentView.findViewById(R.id.iv_btn_5).setOnClickListener(listener);

    }
}
