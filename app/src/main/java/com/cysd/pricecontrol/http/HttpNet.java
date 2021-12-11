package com.cysd.pricecontrol.http;

import android.content.Context;

import com.cysd.pricecontrol.util.ShowUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Request;

public class HttpNet {
    public static void Login(Context context, String account, String password, final NetListener netListener) {
        String url = Urls.login;
        HashMap<String, Object> params = new HashMap<>();
        params.put("account", account);
        params.put("password", password);
        OkHttp3Utils.postJsonRequest(url, params, new OkHttp3Utils.DataCallBack() {
            @Override
            public void requestSuccess(String result) throws Exception {
                SuccessRequest(context, result, url, netListener);
            }

            @Override
            public void requestFailure(Request request, IOException e) {
                FailureRequest(context, request);
            }
        });
    }

    //公共返回成功方法
    private static void SuccessRequest(Context context, String result, String url, NetListener netListener) {
        System.out.println("后台返回数据" + result);
        JsonElement je = new JsonParser().parse(result);
        String retCode = je.getAsJsonObject().get("code").getAsString();
        String retMsg = "";
        if (je.getAsJsonObject().get("msg") != null) {
            retMsg = je.getAsJsonObject().get("msg").getAsString();
        }
        //String retData = je.getAsJsonObject().get("data").getAsString();
        if (retMsg != null && retMsg.equals("该事件无查看权限")) {

        } else {
            ShowUtils.showLogAndToast(result, retMsg, retCode, url);
        }
        if (netListener != null) netListener.getRetCodeString(retCode, result);


        if ("403".equals(retCode)) {
            //reTryVerCode(context);
        }


    }

    //公共返回失败方法
    private static void FailureRequest(Context context, Request request) {
        System.out.println(request.toString());
        if (context != null) {

        }
    }
}
