package com.cysd.pricecontrol.util;

import com.orhanobut.logger.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import okhttp3.Request;

/**
 * 请求接口时调用的显示效果方法 （过滤提示）
 */
public class ShowUtils {

    //////////////satrt 显示提示信息/////////////////

    /**
     * 显示请求成功后的提示信息
     *
     * @param str
     * @param retMsg
     */
    public static void showLogAndToast(String str, String retMsg, String retCode, String url) {

        str = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");

        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    /*    JsonElement je = new JsonParser().parse(str);
        String retCode = je.getAsJsonObject().get("code").getAsString();*/

        //正常返回200不提示 登录失效不提示
        if (!retCode.equals("200")) {
            if (!retMsg.contains("登录失效") && !retMsg.contains("职务名称已存在，请重命名")&&!retMsg.contains("安全码异常")) {
                ToastUtils.showLong(retMsg);
            }
        }


        Logger.d("接口请求返回成功onSuccess:\t" + "url地址为：" + url + "\n" + str);
        if (/*!retMsg.equals("请勿重复提交") &&*/ !retMsg.equals("") && !retMsg.equals("获取成功") && !retMsg.equals("获取成功！") && !retMsg.equals("查询成功") && !retMsg.equals("查询成功！") && !retMsg.equals("操作成功")
                && !retMsg.equals("用户已读") && !retMsg.equals("请更新后使用")
                && !retMsg.equals("登录状态正常！") && !retMsg.equals("正常")) {
            //  ToastUtils.showLong(retMsg);
        }
        /*switch (retCode) {
            case "200":
                if (!retMsg.equals("请勿重复提交") && !retMsg.equals("") && !retMsg.equals("获取成功") && !retMsg.equals("获取成功！") && !retMsg.equals("查询成功") && !retMsg.equals("查询成功！") && !retMsg.equals("操作成功") && !retMsg.equals("用户已读") && !retMsg.equals("请更新后使用") && !retMsg.equals("登录状态正常！") && !retMsg.equals("正常")) {
                    //ToastUtils.showLong(retMsg);
                }
                break;
            case "505": //505弹窗拦截

                break;
            default:
                break;*/
    }

    /**
     * 显示请求失败后的提示信息
     *
     * @param str
     */
    public static void showLogAndToast(Request str) {
        //ToastUtils.showLong("网络请求失败！");
        Logger.e("接口请求返回失败onFailure: \n" + str);
        //ToastUtils.showLong("失败！" + str);
    }
    //////////////end 显示提示信息//////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////

}
