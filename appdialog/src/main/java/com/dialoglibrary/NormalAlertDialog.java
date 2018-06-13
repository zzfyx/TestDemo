package com.dialoglibrary;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.haoz.dialogfragmentdemos.R;
import com.example.haoz.dialogfragmentdemos.dialog.ScreenSizeUtils;


/**
 * Created by Administrator on 2017/11/16.
 */

public  class NormalAlertDialog {
    private Context mContext;
    private View rootView=null;
    private AlertDialog.Builder builder;
    public NormalAlertDialog(Context context) {
        this.mContext=context;
        rootView= LinearLayout.inflate(context, R.layout.widget_dialog_normal,null);
        builder=new AlertDialog.Builder(context);
        builder.setContentView(rootView);
        builder.setWidthAndHeight((int) (ScreenSizeUtils.getInstance(context).getScreenWidth() *
                0.75f), WindowManager.LayoutParams.WRAP_CONTENT);
    }
    public NormalAlertDialog showNurmal1(){
        rootView.findViewById(R.id.dialog_nurmalllt1).setVisibility(View.VISIBLE);
        rootView.findViewById(R.id.dialog_normal_midbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onCenterClick(v);
                }
            }
        });
        return this;
    }
    public NormalAlertDialog showNurmal2(){
        rootView.findViewById(R.id.dialog_nurmalllt2).setVisibility(View.VISIBLE);
        rootView.findViewById(R.id.dialog_normal_leftbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onLeftClick(v);
                }
            }
        });
        rootView.findViewById(R.id.dialog_normal_rightbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onRightClick(v);
                }
            }
        });

        return this;
    }
    public NormalAlertDialog showNurmal3(){
        rootView.findViewById(R.id.dialog_nurmalllt3).setVisibility(View.VISIBLE);
        rootView.findViewById(R.id.dialog_normal3_leftbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onLeftClick(v);
                }
            }
        });
        rootView.findViewById(R.id.dialog_normal3_centerbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onCenterClick(v);
                }
            }
        });
        rootView.findViewById(R.id.dialog_normal3_rightbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onRightClick(v);
                }
            }
        });
        return this;
    }
    public NormalAlertDialog setTitleStr(String title){
        TextView titletv= (TextView) rootView.findViewById(R.id.dialog_normal_title);
        titletv.setText(title);
        ContextCompat.getColor(mContext,R.color.red);
        return this;
    }
    public NormalAlertDialog setContentStr(String strcontent){
        TextView contenttv= (TextView) rootView.findViewById(R.id.dialog_normal_content);
        contenttv.setText(strcontent);
        return this;
    }
    private DialogUtilsImp listener;
    public NormalAlertDialog setNormalClick(DialogClickImp l){
       this.listener=l;
        return this;
    }
    public AlertDialog.Builder  toBuilder(){
        return builder;
    }
}
