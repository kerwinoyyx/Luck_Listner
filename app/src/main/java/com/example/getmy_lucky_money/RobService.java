package com.example.getmy_lucky_money;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Path;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.List;

public class RobService extends AccessibilityService {


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        switch (eventType) {
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                handleNotification(event);
                //获取消息栏内容,判断是否启动活动
                //如果带有红包字样，跳转到红包的聊天界面，非好友列表界面
                break;

            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                String className = event.getClassName().toString();
                Log.e("testt","classname:"+className);
                if (className.equals("com.tencent.mm.ui.LauncherUI")) {
//如果到达了红包聊天界面
                    firsttimeclickredpackage();
                    //打开红包页面

                } else if (className.equals("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI")) {

                    //去拆开红包
                    chairedpackage();
                } else if (className.equals("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI")) {
                  back();
                }

                break;











        }










    }



    /**
     * 处理通知栏信息
     *
     * 如果是微信红包的提示信息,则跳转
     *
     * @param event
     */
    private void handleNotification(AccessibilityEvent event) {
        List<CharSequence> texts = event.getText();
        if (!texts.isEmpty()) {
            for (CharSequence text : texts) {
                String content = text.toString();
                //如果微信红包的提示信息,则模拟点击进入相应的聊天窗口
                if (content.contains("[微信红包]")) {
                    if (event.getParcelableData() != null && event.getParcelableData() instanceof Notification) {
                        //Parcelable data
                        Notification notification = (Notification) event.getParcelableData();
                        PendingIntent pendingIntent = notification.contentIntent;
                        //从notification启动一个activity
                        try {
                            pendingIntent.send();
                        } catch (PendingIntent.CanceledException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }







    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }









    /**
     *
     *
     * 打开红包页
     *
     *
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public  void   firsttimeclickredpackage(){


Log.e("testt","first time go to red package interface");


    }



























    /**
     *
     *
     * 拆红包
     *
     *
     */


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void chairedpackage() {

        Log.e("testt","chairedpackage");
        //获取node








    }
















    public  void  back(){

        Log.e("testt","on back method");
    }




}