package com.cysd.pricecontrol;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.cysd.pricecontrol.util.SharedPreferenceUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MyApplication extends Application {
    private static Context mContext;

    //微信支付回调需要用到的参数
    public static Context wx_mContext;
    public static int wx_mIntentType;
    public static String wx_tv_priceStr;
    public static String wx_mPidStr;

    //全局记录检查是否可以正常下单需要的lsc
    public static String lscs = "2392";
    public static String pidStr = "";

    //全局记录当前团队 org
    public static String orgIdStr = "";

    @Override
    public void onCreate() {
        super.onCreate();







        mContext = getApplicationContext();
        setInitialization();



        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);



     }












    public static Context getInstance() {
        return mContext;
    }

    /**
     * 初始化配置
     */
    private void setInitialization(){
        //注册日志打印信息配置
        Logger.addLogAdapter(new AndroidLogAdapter());


    }



















    /**
     * 当前Activity个数
     */
    private int activityNumber = 0;

    /**
     * Activity 生命周期监听，用于监控app前后台状态切换
     */
    ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

            activityNumber++;
            //ToastUtils.showLong("activityNumber = " + activityNumber);
        }

        @Override
        public void onActivityResumed(Activity activity) {
        }

        @Override
        public void onActivityPaused(Activity activity) {
        }

        @Override
        public void onActivityStopped(Activity activity) {
            activityNumber--;
            //ToastUtils.showLong("activityNumber = " + activityNumber);
            if (activityNumber == 0) {
                // app回到后台
                System.out.println("长连接发送数据：监听前后台="+"app回到后台");
                //ToastUtils.showLong("app回到后台");
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
        }
    };












}
