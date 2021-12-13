package com.cysd.pricecontrol.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.load.HttpException;
import com.cysd.pricecontrol.MyApplication;
import com.cysd.pricecontrol.R;
import com.cysd.pricecontrol.util.SharedPreferenceUtils;
import com.cysd.pricecontrol.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.orhanobut.logger.Logger;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp3Utils {
    private static OkHttp3Utils okHttp3Utils;
    private static OkHttpClient okHttpClient; // OKHttp网络请求
    private Handler mHandler;

    private OkHttp3Utils() {
        // 初始化okhttp 创建一个OKHttpClient对象，一个app里最好实例化一个此对象
        okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder()
                /* .sslSocketFactory(TrustAllCerts.createSSLSocketFactory())
                 .hostnameVerifier(new TrustAllCerts.TrustAllHostnameVerifier())*/
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 单例模式  获取OkHttp3Utils实例
     *
     * @return okHttp3Utils
     */
    private static OkHttp3Utils getInstance() {
        if (okHttp3Utils == null) {
            okHttp3Utils = new OkHttp3Utils();
        }
        return okHttp3Utils;
    }

    //-------------对外提供的方法Start--------------------------------


    /**
     * 建立网络框架，获取网络数据，异步post请求（json）
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void postJsonRequest(String url, Map<String, Object> params, DataCallBack callBack) {
        getInstance().inner_postJsonAsync(url, params, callBack);
    }

    //传图片使用
    public static void formDataJsonRequest(String url, Map<String, String> params, DataCallBack callBack) {
        getInstance().inner_formDataJsonAsync(url, params, callBack);
    }

    //-------------对外提供的方法End--------------------------------

    ///////////////////////////////////自定义方法-对外//////////////////////////////////////////////////////////////

    /**
     * 图片上传功能 （单图或多图同时上传）
     */
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");


    ///////////////////////////////////////////////////////////////////////////////////////////////

    //传图片使用
    private void inner_formDataJsonAsync(String url, Map<String, String> params, final DataCallBack callBack) {
        final Request request = buildJsonFormDataRequest(url, params);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtils.showLong("请求失败1：" + e.getMessage());
                System.out.println("请求失败onFailure===" + request.toString() + "/n打印IOxception==" + e.getMessage());
                deliverDataFailure(request, e, callBack);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse服务器返回===" + request.toString() + "/code==" + response.code());
                if (response.code() == 500) {
                    ToastUtils.showLong("服务器返回500");
                }
                if (response.isSuccessful()) { // 请求成功
                    //执行请求成功的操作
                    String result = response.body().string();
                    deliverDataSuccess(result, callBack);
                } else {
                    if (response.code() == 404) ToastUtils.showLong("接口地址不存在");
                    throw new IOException(response + "");
                }
            }
        });
    }

    //传图片使用
    private Request buildJsonFormDataRequest(String url, Map<String, String> params) {

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, String> map : params.entrySet()) {
            String key = map.getKey();
            String value;
            /**
             * 判断值是否是空的
             */
            if (map.getValue() == null) {
                value = "";
            } else {
                value = map.getValue();
            }
            File file = new File(value);
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), file);
            builder.addFormDataPart("name", file.getName(), fileBody);
        }
        MultipartBody requestBody = builder.build();
        Logger.d("请求接口url地址为：" + url + "\tpost请求（FormData）\n\n传输过去的 Map<String, String> params 的内容为：\n" + params);


        //请求头参数
        Request request;
        if (!TextUtils.isEmpty(SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()))) {
            Log.d("xuwudi", "token===存在" + SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()));
            request = new Request.Builder().url(url).post(requestBody).addHeader("token", SharedPreferenceUtils.getLoginSp(MyApplication.getInstance())).build();
        } else {
            Log.d("xuwudi", "token===不存在");
            request = new Request.Builder().url(url).post(requestBody).build();
        }
        Log.d("xuwudi", "request==" + request.toString());
        return request;

    }

    /**
     * post请求传json
     *
     * @param url      url
     * @param callBack 成功或失败回调
     * @param params   params
     */
    private void inner_postJsonAsync(String url, Map<String, Object> params, final DataCallBack callBack) {
        // 将map转换成json,需要引入Gson包
        String mapToJson = new Gson().toJson(params);
        final Request request = buildJsonPostRequest(url, mapToJson);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("请求失败onFailure===" + request.toString() + "/n打印IOxception==" + e.getMessage());
                ToastUtils.showLong("请求失败2：" + e.getMessage());
                deliverDataFailure(request, e, callBack);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse服务器返回===" + request.toString() + "/code==" + response.code());
                if (response.code() == 500) {
                    ToastUtils.showLong("服务器返回500");
                } else if (response.code() == 400) {
                    ToastUtils.showLong("账号或密码错误");
                }

                if (response.isSuccessful()) { // 请求成功
                    //执行请求成功的操作
                    String result = response.body().string();
                    deliverDataSuccess(result, callBack);
                } else {
                    if (response.code() == 404) ToastUtils.showLong("接口地址不存在");
                    response.code();
                    System.out.println("请求失败onResponse===" + request.toString() + "/n打印response==" + response);
                    throw new IOException(response + "");
                }
            }
        });
    }


    /**
     * Json_POST请求参数
     *
     * @param url  url
     * @param json json
     * @return requestBody
     */
    private Request buildJsonPostRequest(String url, String json) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        Logger.d("请求接口url地址为：" + url + "\tpost请求(json)\n\n传输过去的json的内容为：\n" + json);
        Request request;
        if (!TextUtils.isEmpty(SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()))) {
            Log.d("xuwudi", "token===存在" + SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()));
            request = new Request.Builder().url(url).post(requestBody).addHeader("token", SharedPreferenceUtils.getLoginSp(MyApplication.getInstance())).build();
        } else {
            Log.d("xuwudi", "token===不存在");
            request = new Request.Builder().url(url).post(requestBody).build();
        }
        Log.d("xuwudi", "request==" + request.toString());
        return request;
        //return new Request.Builder().url(url).post(requestBody).build();
    }


    /**
     * 分发失败的时候调用
     *
     * @param request  request
     * @param e        e
     * @param callBack callBack
     */
    private void deliverDataFailure(final Request request, final IOException e, final DataCallBack callBack) {
        /**
         * 在这里使用异步处理
         */
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.requestFailure(request, e);
                    if (e instanceof HttpException) {     //   HTTP错误
                        onException(ExceptionReason.BAD_NETWORK);
                    } else if (e instanceof ConnectException
                            || e instanceof UnknownHostException) {   //   连接错误
                        onException(ExceptionReason.CONNECT_ERROR);
                    } else if (e instanceof InterruptedIOException) {   //  连接超时
                        onException(ExceptionReason.CONNECT_TIMEOUT);
                    }

                }
            }
        });
    }

    /**
     * 分发成功的时候调用
     *
     * @param result   result
     * @param callBack callBack
     */
    private void deliverDataSuccess(final String result, final DataCallBack callBack) {
        /**
         * 在这里使用异步线程处理
         */
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    try {
                        callBack.requestSuccess(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (e instanceof HttpException) {     //   HTTP错误
                            onException(ExceptionReason.BAD_NETWORK);
                        } else if (e instanceof ConnectException
                                || e instanceof UnknownHostException) {   //   连接错误
                            onException(ExceptionReason.CONNECT_ERROR);
                        } else if (e instanceof InterruptedIOException) {   //  连接超时
                            onException(ExceptionReason.CONNECT_TIMEOUT);
                        } else if (e instanceof JsonParseException
                                || e instanceof JSONException
                                || e instanceof ParseException) {   //  解析错误
                            onException(ExceptionReason.PARSE_ERROR);
                        } else {
                            onException(ExceptionReason.UNKNOWN_ERROR);
                        }
                        Logger.e("异常打印=" + e.getMessage().toString());
                    }
                }
            }
        });
    }

    /**
     * 数据回调接口
     */
    public interface DataCallBack {

        void requestSuccess(String result) throws Exception;

        void requestFailure(Request request, IOException e);
    }

    /**
     * 拼接url和请求参数
     *
     * @param url    url
     * @param params key value
     * @return String url
     */
    private static String urlJoint(String url, Map<String, Object> params) {
        StringBuilder endUrl = new StringBuilder(url);
        boolean isFirst = true;
        Set<Map.Entry<String, Object>> entrySet = params.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            if (isFirst && !url.contains("?")) {
                isFirst = false;
                endUrl.append("?");
            } else {
                endUrl.append("&");
            }
            endUrl.append(entry.getKey());
            endUrl.append("=");
            endUrl.append(entry.getValue());
        }
        return endUrl.toString();
    }

    /**
     * get请求
     *
     * @param address
     * @param callback
     */

    public void get(String address, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        FormBody body = builder.build();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtils.showLong(R.string.connect_error, Toast.LENGTH_SHORT);
                break;

            case CONNECT_TIMEOUT:
                ToastUtils.showLong(R.string.connect_timeout, Toast.LENGTH_SHORT);
                break;

            case BAD_NETWORK:
                ToastUtils.showLong(R.string.bad_network, Toast.LENGTH_SHORT);
                break;

            case PARSE_ERROR:
                ToastUtils.showLong(R.string.parse_error, Toast.LENGTH_SHORT);
                break;

            case UNKNOWN_ERROR:
            default:
                ToastUtils.showLong(R.string.unknown_error, Toast.LENGTH_SHORT);
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }

}
