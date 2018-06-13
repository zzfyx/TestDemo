package com.example.haoz.dialogfragmentdemos.activity;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dialoglibrary.AlertDialog;
import com.dialoglibrary.NormalAlertDialog;
import com.dialoglibrary.DialogClickImp;
import com.example.haoz.dialogfragmentdemos.R;
import com.example.haoz.dialogfragmentdemos.dialog.DialogInterface;
import com.example.haoz.dialogfragmentdemos.dialog.MDAlertDialog;
import com.example.haoz.dialogfragmentdemos.dialog.MDEditDialog;
import com.example.haoz.dialogfragmentdemos.dialog.MDSelectionDialog;
import com.example.haoz.dialogfragmentdemos.dialog.NormalSelectionDialog;
import com.example.haoz.dialogfragmentdemos.dialog.CommonDialogFragment;
import com.example.haoz.dialogfragmentdemos.dialog.DialogFragmentHelper;
import com.example.haoz.dialogfragmentdemos.dialog.IDialogResultListener;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Haoz on 2017/4/6 0006.
 */

public class DialogActivity extends AppCompatActivity {

    private DialogFragment mDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_activity_dialog);
    }

    public void tvTest(View view){
       new NormalAlertDialog(this).showNurmal1().setTitleStr("aaaaaa").setContentStr("aaaaaaaaaaaaaaa").setNormalClick(new DialogClickImp() {
            @Override
            public void onLeftClick(View view) {
                Toast.makeText(DialogActivity.this, "onLeftClick", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onRightClick(View view) {
                Toast.makeText(DialogActivity.this, "onRightClick", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCenterClick(View view) {

                Toast.makeText(DialogActivity.this, "onCenterClick", Toast.LENGTH_SHORT).show();

            }
        }).toBuilder().setCancelable(true).create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_dialog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.showConfirmDialog:
                showConfirmDialog();
                break;

            case R.id.showDateDialog:
                showDateDialog();
                break;

            case R.id.showInsertDialog:
                showInsertDialog();
                break;

            case R.id.showIntervalInsertDialog:
                showIntervalInsertDialog();
                break;

            case R.id.showListDialog:
                showListDialog();
                break;

            case R.id.showPasswordInsertDialog:
                showPasswordInsertDialog();
                break;

            case R.id.showProgress:
                mDialogFragment = DialogFragmentHelper.showProgress(getSupportFragmentManager(), "正在加载中");
                break;

            case R.id.showTimeDialog:
                showTimeDialog();
                break;

            case R.id.showTips:
                DialogFragmentHelper.showTips(getSupportFragmentManager(), "你进入了无网的异次元中");
                break;
            case R.id.initBottomDialog:
                initBottomDialog();
                break;
          case R.id.initNormalDialog:
                initNormalDialog();
                break;
            case R.id.initNormalDialog2:
                initNormalDialog2();
                break;
            case R.id.initMDDialog:
                initMDDialog();
                break;
            case R.id.initMDMidDialog:
                initMDMidDialog();
                break;
            case R.id.initMDEditDialog:
                initMDEditDialog();
                break;

            default:break;
        }
        return true;
    }

    /**
     * 选择时间的弹出窗
     */
    private void showTimeDialog() {
        String titleTime = "请选择时间";
        Calendar calendarTime = Calendar.getInstance();
        DialogFragmentHelper.showTimeDialog(getSupportFragmentManager(), titleTime, calendarTime, new IDialogResultListener<Calendar>() {
            @Override
            public void onDataResult(Calendar result) {
               showToast(String.valueOf(result.getTime().getDate()));
            }
        }, true);
    }

    /**
     * 输入密码的弹出窗
     */
    private void showPasswordInsertDialog() {
        String titlePassword = "请输入密码";
        DialogFragmentHelper.showPasswordInsertDialog(getSupportFragmentManager(), titlePassword, new IDialogResultListener<String>() {
            @Override
            public void onDataResult(String result) {
               showToast("密码为：" + result);
            }
        }, true);
    }

    /**
     * 显示列表的弹出窗
     */
    private void showListDialog() {
        String titleList = "选择哪种方向？";
        final String [] languanges = new String[]{"Android", "iOS", "web 前端", "Web 后端", "老子不打码了"};

        DialogFragmentHelper.showListDialog(getSupportFragmentManager(), titleList, languanges, new IDialogResultListener<Integer>() {
            @Override
            public void onDataResult(Integer result) {
                showToast(languanges[result]);
            }
        }, true);
    }

    /**
     * 两个输入框的弹出窗
     */
    private void showIntervalInsertDialog() {
        String title = "请输入想输入的内容";
        DialogFragmentHelper.showIntervalInsertDialog(getSupportFragmentManager(), title, new IDialogResultListener<String[]>() {
            @Override
            public void onDataResult(String[] result) {
               showToast(result[0] + result[1]);
            }
        }, true);
    }

    private void showInsertDialog() {
        String titleInsert  = "请输入想输入的内容";
        DialogFragmentHelper.showInsertDialog(getSupportFragmentManager(), titleInsert, new IDialogResultListener<String>() {
            @Override
            public void onDataResult(String result) {
                showToast(result);
            }
        }, true);
    }

    /**
     * 选择日期的弹出窗
     */
    private void showDateDialog() {
        String titleDate = "请选择日期";
        Calendar calendar = Calendar.getInstance();
        mDialogFragment = DialogFragmentHelper.showDateDialog(getSupportFragmentManager(), titleDate, calendar, new IDialogResultListener<Calendar>() {
            @Override
            public void onDataResult(Calendar result) {
                showToast(String.valueOf(result.getTime().getDate()));
            }
        }, true);
    }

    /**
     * 确认和取消的弹出窗
     */
    private void showConfirmDialog() {
        DialogFragmentHelper.showConfirmDialog(getSupportFragmentManager(), "是否选择 Android？", new IDialogResultListener<Integer>() {
            @Override
            public void onDataResult(Integer result) {
                showToast("You Click Ok");
            }
        }, true, new CommonDialogFragment.OnDialogCancelListener() {
            @Override
            public void onCancel() {
                showToast("You Click Cancel");
            }
        });
    }


    /**
     * 对 Toast 进行封藏，减少代码量
     *
     * @param message 想要显示的信息
     */
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void initBottomDialog() {

        ArrayList<String> s = new ArrayList<>();
        s.add("Weavey0");
        s.add("Weavey1");
        s.add("Weavey2");
        s.add("Weavey3");

        new NormalSelectionDialog.Builder(this).setlTitleVisible(true)   //设置是否显示标题
                .setTitleHeight(65)   //设置标题高度
                .setTitleText("please select")  //设置标题提示文本
                .setTitleTextSize(14) //设置标题字体大小 sp
                .setTitleTextColor(R.color.colorPrimary) //设置标题文本颜色
                .setItemHeight(40)  //设置item的高度
                .setItemWidth(0.9f)  //屏幕宽度*0.9
                .setItemTextColor(R.color.colorPrimaryDark)  //设置item字体颜色
                .setItemTextSize(14)  //设置item字体大小
                .setCancleButtonText("Cancle")  //设置最底部“取消”按钮文本
                .setOnItemListener(new DialogInterface.OnItemClickListener<NormalSelectionDialog>() {

                    @Override
                    public void onItemClick(NormalSelectionDialog dialog, View button, int
                            position) {
                        dialog.dismiss();
                    }
                })
                .setCanceledOnTouchOutside(true)  //设置是否可点击其他地方取消dialog
                .build()
                .setDatas(s)
                .show();
    }

    private void initNormalDialog() {

        new com.example.haoz.dialogfragmentdemos.dialog.NormalAlertDialog.Builder(this).setTitleVisible(false)
                .setTitleText("温馨提示")
                .setTitleTextColor(R.color.black_light)
                .setContentText("是否关闭对话框？")
                .setContentTextColor(R.color.black_light)
                .setLeftButtonText("关闭")
                .setLeftButtonTextColor(R.color.gray)
                .setRightButtonText("不关闭")
                .setRightButtonTextColor(R.color.black_light)
                .setOnclickListener(new DialogInterface.OnLeftAndRightClickListener<com.example.haoz.dialogfragmentdemos.dialog.NormalAlertDialog>() {
                    @Override
                    public void clickLeftButton(com.example.haoz.dialogfragmentdemos.dialog.NormalAlertDialog dialog, View view) {

                        dialog.dismiss();
                    }

                    @Override
                    public void clickRightButton(com.example.haoz.dialogfragmentdemos.dialog.NormalAlertDialog dialog, View view) {

                        dialog.dismiss();
                    }
                })
                .build()
                .show();

    }

    private void initNormalDialog2() {

        new com.example.haoz.dialogfragmentdemos.dialog.NormalAlertDialog.Builder(this).setHeight(0.23f)  //屏幕高度*0.23
                .setWidth(0.65f)  //屏幕宽度*0.65
                .setTitleVisible(true).setTitleText("温馨提示")
                .setTitleTextColor(R.color.colorPrimary)
                .setContentText("是否关闭对话框？")
                .setContentTextColor(R.color.colorPrimaryDark)
                .setSingleMode(true).setSingleButtonText("关闭")
                .setSingleButtonTextColor(R.color.colorAccent)
                .setCanceledOnTouchOutside(true)
                .setSingleListener(new DialogInterface.OnSingleClickListener<com.example.haoz.dialogfragmentdemos.dialog.NormalAlertDialog>() {
                    @Override
                    public void clickSingleButton(com.example.haoz.dialogfragmentdemos.dialog.NormalAlertDialog dialog, View view) {
                        dialog.dismiss();
                    }
                })
                .build()
                .show();

    }

    private void initMDDialog() {

        new MDAlertDialog.Builder(this)
                .setHeight(0.21f)  //屏幕高度*0.21
                .setWidth(0.7f)  //屏幕宽度*0.7
                .setTitleVisible(true)
                .setTitleText("温馨提示")
                .setTitleTextColor(R.color.black_light)
                .setContentText("确定发送文件？")
                .setContentTextColor(R.color.black_light)
                .setLeftButtonText("不发送")
                .setLeftButtonTextColor(R.color.gray)
                .setRightButtonText("发送")
                .setRightButtonTextColor(R.color.black_light)
                .setTitleTextSize(16)
                .setContentTextSize(14)
                .setButtonTextSize(14)
                .setOnclickListener(new DialogInterface.OnLeftAndRightClickListener<MDAlertDialog>() {

                    @Override
                    public void clickLeftButton(MDAlertDialog dialog, View view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void clickRightButton(MDAlertDialog dialog, View view) {
                        dialog.dismiss();
                    }
                })
                .build()
                .show();

    }

    private void initMDMidDialog() {

     ArrayList   datas = new ArrayList<>();
        datas.add("标为未读");
        datas.add("置顶聊天");
        datas.add("删除该聊天");

        new MDSelectionDialog.Builder(this)
                .setCanceledOnTouchOutside(true)
                .setItemTextColor(R.color.black_light)
                .setItemHeight(50)
                .setItemWidth(0.8f)  //屏幕宽度*0.8
                .setItemTextSize(15)
                .setCanceledOnTouchOutside(true)
                .setOnItemListener(new DialogInterface.OnItemClickListener<MDSelectionDialog>() {
                    @Override
                    public void onItemClick(MDSelectionDialog dialog, View button, int position) {

                        dialog.dismiss();
                    }
                })
                .build()
                .setDatas(datas)
                .show();
    }

    private void initMDEditDialog() {

        new MDEditDialog.Builder(this).setTitleVisible(true)
                .setTitleText("修改用户名")
                .setTitleTextSize(20)
                .setTitleTextColor(R.color.black_light)
                .setContentText("Weavey")
                .setContentTextSize(18)
                .setMaxLength(7)
                .setHintText("7位字符")
                .setMaxLines(1)
                .setContentTextColor(R.color.colorPrimary)
                .setButtonTextSize(14)
                .setLeftButtonTextColor(R.color.colorPrimary)
                .setLeftButtonText("取消")
                .setRightButtonTextColor(R.color.colorPrimary)
                .setRightButtonText("确定")
                .setLineColor(R.color.colorPrimary)
                .setInputTpye(InputType.TYPE_CLASS_NUMBER)
                .setOnclickListener(new DialogInterface.OnLeftAndRightClickListener<MDEditDialog>
                        () {

                    @Override
                    public void clickLeftButton(MDEditDialog dialog, View view) {

                        dialog.getEditTextContent();
                        dialog.dismiss();
                    }

                    @Override
                    public void clickRightButton(MDEditDialog dialog, View view) {

                        dialog.getEditTextContent();
                        dialog.dismiss();
                    }
                })
                .setMinHeight(0.3f)
                .setWidth(0.8f)
                .build()
                .show();
    }
}