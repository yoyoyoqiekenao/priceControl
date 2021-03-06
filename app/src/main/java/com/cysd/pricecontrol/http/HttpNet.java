package com.cysd.pricecontrol.http;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.cysd.pricecontrol.LoginActivity;
import com.cysd.pricecontrol.util.ActivityManager;
import com.cysd.pricecontrol.util.SharedPreferenceUtils;
import com.cysd.pricecontrol.util.ShowUtils;
import com.cysd.pricecontrol.util.ToastUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.Request;

public class HttpNet {
    //修改
    public static void updateThingDetail(Context context, String id, String name, String number, String company,
                                         String handover, String handover_mobile, String htype,
                                         String escrow_start, String escrow_end, String remark,
                                         List<String> image, final NetListener netListener) {
        String url = Urls.update;
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("number", number);
        params.put("company", company);
        params.put("handover", handover);
        params.put("handover_mobile", handover_mobile);
        params.put("htype", htype);
        params.put("escrow_start", escrow_start);
        params.put("escrow_end", escrow_end);
        params.put("remark", remark);
        params.put("image", image);

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

    //物品详情
    public static void getThingDetail(Context context, String id, final NetListener netListener) {
        String url = Urls.detail;
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
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

    //物品列表
    public static void getThingList(Context context, String keyword, final NetListener netListener) {
        String url = Urls.thingList;
        HashMap<String, Object> params = new HashMap<>();
        if (!TextUtils.isEmpty(keyword)) {
            params.put("keyword", keyword);
        }
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

    //录入
    public static void save(Context context, String name, String number, String company,
                            String handover, String handover_mobile, String htype,
                            String escrow_start, String escrow_end, String remark,
                            List<String> image, final NetListener netListener) {
        String url = Urls.save;
        HashMap<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("number", number);
        params.put("company", company);
        params.put("handover", handover);
        params.put("handover_mobile", handover_mobile);
        params.put("htype", htype);
        params.put("escrow_start", escrow_start);
        params.put("escrow_end", escrow_end);
        params.put("remark", remark);
        params.put("image", image);
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

    //上传图片
    public static void uploadImg(Context context, String str, final NetListener netListener) {
        String url = Urls.upload;
        HashMap<String, String> params = new HashMap<>();
        params.put("file", str);


        OkHttp3Utils.formDataJsonRequest(url, params, new OkHttp3Utils.DataCallBack() {
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

    //登陆
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


        if ("401".equals(retCode)) {
            SharedPreferenceUtils.deleteLoginSp(context);
            ActivityManager.exit();
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
        }


    }

    //公共返回失败方法
    private static void FailureRequest(Context context, Request request) {
        System.out.println(request.toString());
        if (context != null) {

        }
    }
}
