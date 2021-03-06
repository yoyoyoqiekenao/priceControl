package com.cysd.pricecontrol.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.cysd.pricecontrol.bean.LoginInfo_alyBean;
import com.cysd.pricecontrol.bean.UserInfoBean;
import com.google.gson.Gson;

public class SharedPreferenceUtils {


    /**
     * 缓存登录页面隐私协议弹框状态信息 （只在第一次打开登录选择页显示）
     *
     * @param context
     */
    public static void setStartXYSp(Context context, boolean bool) {
        SharedPreferences.Editor editor = context.getSharedPreferences("myStartXYPreferences", context.MODE_PRIVATE).edit();
        editor.putBoolean("isShow", bool);
        editor.commit();
    }

    /**
     * 缓存登录页面隐私协议弹框状态信息--查询某个键是否存在 （如果存在返回值）
     *
     * @param context
     */
    public static boolean isStartXYSp(Context context) {
        boolean isShowBool = false;
        SharedPreferences myLoginPreferences = context.getSharedPreferences("myStartXYPreferences", Context.MODE_PRIVATE);
        //检查当前键是否存在
        boolean isShow = myLoginPreferences.contains("isShow");
        if (isShow) {
            isShowBool = myLoginPreferences.getBoolean("isShow", false);
        }
        return isShowBool;
    }


    /**
     * 缓存启动页视频状态信息 （只在第一次安装时显示）
     *
     * @param context
     */
    public static void setStartPageVideoSp(Context context, boolean bool) {
        SharedPreferences.Editor editor = context.getSharedPreferences("myStartPageVideoPreferences", context.MODE_PRIVATE).edit();
        editor.putBoolean("isShow", bool);
        editor.commit();
    }

    /**
     * 动页视频状态--查询某个键是否存在 （如果存在返回值）
     *
     * @param context
     */
    public static boolean isStartPageVideoSp(Context context) {
        boolean isShowBool = false;
        SharedPreferences myLoginPreferences = context.getSharedPreferences("myStartPageVideoPreferences", Context.MODE_PRIVATE);
        //检查当前键是否存在
        boolean isShow = myLoginPreferences.contains("isShow");
        if (isShow) {
            isShowBool = myLoginPreferences.getBoolean("isShow", false);
        }
        return isShowBool;
    }

    /**
     * 缓存登录状态信息
     *
     * @param context
     */
    public static void setLoginSp(Context context, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences("myLoginPreferences", context.MODE_PRIVATE).edit();
        editor.putString("token", token);
        editor.commit();
    }



    /**
     * 获取登录状态信息
     *
     * @param context
     * @return
     */
    public static String getLoginSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences("myLoginPreferences", context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        return token;
    }



    /**
     * 清除所有登录保存的信息
     *
     * @param context
     */
    public static void deleteLoginSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("myLoginPreferences", Context.MODE_PRIVATE);
        myLoginPreferences.edit().clear().commit();
    }





    ////////////////搜索记录历史数据 start ///////////////////////////---new搞定清单记录数据

    /**
     * 缓存new搞定清单搜索记录信息
     *
     * @param context
     */
    public static void setSouSuoNewDoneSearchSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoNewDoneSearchPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoNewDoneSearchStr", str);
        editor.commit();
    }

    /**
     * 获取new搞定清单搜素记录信息
     *
     * @param context
     * @return
     */
    public static String getSouSuoNewDoneSearchSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoNewDoneSearchPreferences", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("SouSuoNewDoneSearchStr", "");
        return userName;
    }

    /**
     * 清除所有new搞定清单搜索记录的信息
     *
     * @param context
     */
    public static void deleteSouSuoNewDoneSearchSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoNewDoneSearchPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

    ////////////////搜索记录历史数据 end ///////////////////////////---new搞定清单记录数据


    ////////////////搜索记录历史数据 start ///////////////////////////---new搞定清单记录数据

    /**
     * 缓存new搞定文档搜索记录信息
     *
     * @param context
     */
    public static void setSouSuoNewDoneDocSearchSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoNewDoneDocSearchPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoNewDoneDocSearchStr", str);
        editor.commit();
    }

    /**
     * 获取new搞定文档搜素记录信息
     *
     * @param context
     * @return
     */
    public static String getSouSuoNewDoneDocSearchSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoNewDoneDocSearchPreferences", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("SouSuoNewDoneDocSearchStr", "");
        return userName;
    }

    /**
     * 清除所有new搞定文档搜索记录的信息
     *
     * @param context
     */
    public static void deleteSouSuoNewDoneDocSearchSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoNewDoneDocSearchPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

    ////////////////搜索记录历史数据 end ///////////////////////////---new搞定清单记录数据


    ////////////////搜索记录历史数据 start ///////////////////////////---通用记录数据

    /**
     * 缓存搜索记录信息
     *
     * @param context
     */
    public static void setSouSuoSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoStr", str);
        editor.commit();
    }

    /**
     * 获取搜素记录信息
     *
     * @param context
     * @return
     */
    public static String getSouSuoSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoPreferences", Context.MODE_PRIVATE);
        String userName = myLoginPreferences.getString("SouSuoStr", "");
        return userName;
    }

    /**
     * 清除所有搜索记录的信息
     *
     * @param context
     */
    public static void deleteSouSuoSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoPreferences", Context.MODE_PRIVATE);
        myLoginPreferences.edit().clear().commit();
    }

    ////////////////搜索记录历史数据 end ///////////////////////////---通用记录数据


    ////////////////搜索记录历史数据 start ///////////////////////////---商标池记录数据

    /**
     * 缓存搜索记录信息
     *
     * @param context
     */
    public static void setSouSuoBrandPondSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoBrandPondPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoBrandPondStr", str);
        editor.commit();
    }

    /**
     * 获取搜素记录信息
     *
     * @param context
     * @return
     */
    public static String getSouSuoBrandPondSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoBrandPondPreferences", Context.MODE_PRIVATE);
        String userName = myLoginPreferences.getString("SouSuoBrandPondStr", "");
        return userName;
    }

    /**
     * 清除所有搜索记录的信息
     *
     * @param context
     */
    public static void deleteSouSuoBrandPondSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoBrandPondPreferences", Context.MODE_PRIVATE);
        myLoginPreferences.edit().clear().commit();
    }

    ////////////////搜索记录历史数据 end ///////////////////////////---商标池记录数据


    ////////////////搜索记录历史数据 start ///////////////////////////---订单记录数据

    /**
     * 缓存搜索记录信息
     *
     * @param context
     */
    public static void setSouSuoOrderSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoOrderPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoOrderStr", str);
        editor.commit();
    }

    /**
     * 获取搜素记录信息
     *
     * @param context
     * @return
     */
    public static String getSouSuoOrderSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoOrderPreferences", Context.MODE_PRIVATE);
        String userName = myLoginPreferences.getString("SouSuoOrderStr", "");
        return userName;
    }

    /**
     * 清除所有搜索记录的信息
     *
     * @param context
     */
    public static void deleteSouSuoOrderSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoOrderPreferences", Context.MODE_PRIVATE);
        myLoginPreferences.edit().clear().commit();
    }

    ////////////////搜索记录历史数据 end ///////////////////////////---订单记录数据


    ////////////////搜索发现模块记录历史数据 start ///////////////////////////

    /**
     * 缓存搜索记录信息 （所有类型）
     *
     * @param context
     */
    public static void setSouSuoDiscoverAllSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoDiscoverAllPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoDiscoverAllStr", str);
        editor.commit();
    }

    /**
     * 获取搜素记录信息 （所有类型）
     *
     * @param context
     * @return
     */
    public static String getSouSuoDiscoverAllSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverAllPreferences", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("SouSuoDiscoverAllStr", "");
        return userName;
    }

    /**
     * 清除所有搜索记录的信息 （所有类型）
     *
     * @param context
     */
    public static void deleteSouSuoDiscoverAllSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverAllPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }


    ///////////////////单位类型

    /**
     * 缓存搜索记录信息 （单位类型）
     *
     * @param context
     */
    public static void setSouSuoDiscoverUnitSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoDiscoverUnitPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoDiscoverUnitStr", str);
        editor.commit();
    }

    /**
     * 获取搜素记录信息 （单位类型）
     *
     * @param context
     * @return
     */
    public static String getSouSuoDiscoverUnitSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverUnitPreferences", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("SouSuoDiscoverUnitStr", "");
        return userName;
    }

    /**
     * 清除所有搜索记录的信息 （单位类型）
     *
     * @param context
     */
    public static void deleteSouSuoDiscoverUnitSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverUnitPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }


    ///////////////////商标类型

    /**
     * 缓存搜索记录信息 （商标类型）
     *
     * @param context
     */
    public static void setSouSuoDiscoverBrandSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoDiscoverBrandPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoDiscoverBrandStr", str);
        editor.commit();
    }

    /**
     * 获取搜素记录信息 （商标类型）
     *
     * @param context
     * @return
     */
    public static String getSouSuoDiscoverBrandSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverBrandPreferences", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("SouSuoDiscoverBrandStr", "");
        return userName;
    }

    /**
     * 清除所有搜索记录的信息 （商标类型）
     *
     * @param context
     */
    public static void deleteSouSuoDiscoverBrandSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverBrandPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }


    ///////////////////可售商标类型

    /**
     * 缓存搜索记录信息 （可售商标类型）
     *
     * @param context
     */
    public static void setSouSuoDiscoverForsaleBrandSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoDiscoverForsaleBrandPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoDiscoverForsaleBrandStr", str);
        editor.commit();
    }

    /**
     * 获取搜素记录信息 （可售商标类型）
     *
     * @param context
     * @return
     */
    public static String getSouSuoDiscoverForsaleBrandSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverForsaleBrandPreferences", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("SouSuoDiscoverForsaleBrandStr", "");
        return userName;
    }

    /**
     * 清除所有搜索记录的信息 （可售商标类型）
     *
     * @param context
     */
    public static void deleteSouSuoDiscoverForsaleBrandSp(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mySouSuoDiscoverForsaleBrandPreferences", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

    ////////////////搜索发现模块记录历史数据 end ///////////////////////////


    ////////////////搜索搞定-事件对象记录历史数据 start ///////////////////////////

    /**
     * 缓存搞定-事件对象记录信息
     *
     * @param context
     */
    public static void setSouSuoDoneEventBeanSp(Context context, String SouSuoDoneEventBeanStr) {
        SharedPreferences.Editor editor = context.getSharedPreferences("mySouSuoDoneEventBeanPreferences", context.MODE_PRIVATE).edit();
        editor.putString("SouSuoDoneEventBeanStr", SouSuoDoneEventBeanStr);
        editor.commit();
    }

    /**
     * 获取搞定-事件对象记录信息
     *
     * @param context
     * @return
     */
    public static String getSouSuoDoneEventBeanSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoDoneEventBeanPreferences", Context.MODE_PRIVATE);
        String SouSuoDoneEventBeanStr = myLoginPreferences.getString("SouSuoDoneEventBeanStr", "");
        return SouSuoDoneEventBeanStr;
    }

    /**
     * 清除所有搞定-事件对象记录的信息
     *
     * @param context
     */
    public static void deleteSouSuoDoneEventBean(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("mySouSuoDoneEventBeanPreferences", Context.MODE_PRIVATE);
        myLoginPreferences.edit().clear().commit();
    }

    ////////////////搜索搞定-事件对象记录历史数据 end ///////////////////////////


    /////////////// 保存用户信息内容 start ////////////////////////


    /**
     * 缓存用户信息内容 - 接口（user/user/info）
     *
     * @param context
     */
    public static void setUserInfoSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("myUserInfoPreferences", context.MODE_PRIVATE).edit();
        editor.putString("UserInfoJsonStr", str);
        editor.commit();
        setUserHeadSp(context, getUserInfoSp(context));
    }

    /**
     * 获取用户信息内容 - 接口（user/user/info）
     *
     * @param context
     * @return
     */
    public static String getUserInfoSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("myUserInfoPreferences", Context.MODE_PRIVATE);
        String UserInfoStr = myLoginPreferences.getString("UserInfoJsonStr", "");
        return UserInfoStr;
    }

    /**
     * 清除所有用户信息内容 - 接口（user/user/info）
     *
     * @param context
     */
    public static void deleteUserInfoSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("myUserInfoPreferences", Context.MODE_PRIVATE);
        myLoginPreferences.edit().clear().commit();
        deleteUserHeadSp(context);
    }


    /////////////// 保存用户信息内容 恩典 /////////////////////////


    /////////// 临时储存头像 ////////////

    /**
     * 缓存用户头像
     *
     * @param context
     */
    public static void setUserHeadSp(Context context, String str) {
        SharedPreferences.Editor editor = context.getSharedPreferences("myUserHeadPreferences", context.MODE_PRIVATE).edit();
        //读取用户信息接口返回的所有信息
        String userInfoJsonStr = SharedPreferenceUtils.getUserInfoSp(context);
        Gson gson = new Gson();
        UserInfoBean userInfoBean = gson.fromJson(userInfoJsonStr, UserInfoBean.class);
        if (userInfoBean != null && userInfoBean.getData() != null && userInfoBean.getData().getData() != null && userInfoBean.getData().getData().getHeadimgurl() != null) {
            editor.putString("UserHeadStr", userInfoBean.getData().getData().getHeadimgurl());
        }
        editor.commit();
        //ToastUtils.showLong(userInfoBean.getData().getData().getHeadimgurl()+"~");
    }

    /**
     * 获取用户头像
     *
     * @param context
     * @return
     */
    public static String getUserHeadSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("myUserHeadPreferences", Context.MODE_PRIVATE);
        String UserInfoStr = myLoginPreferences.getString("UserHeadStr", "");
        return UserInfoStr;
    }

    /**
     * 清除用户头像
     *
     * @param context
     */
    public static void deleteUserHeadSp(Context context) {
        SharedPreferences myLoginPreferences = context.getSharedPreferences("myUserHeadPreferences", Context.MODE_PRIVATE);
        myLoginPreferences.edit().clear().commit();
    }

    ////////// 临时储存头像 ////////////

}
