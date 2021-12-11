package com.cysd.pricecontrol.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
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
     * 建立网络框架，获取网络数据，异步get请求（Form）
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void getFormRequest(String url, Map<String, Object> params, DataCallBack callBack) {
        getInstance().inner_getFormAsync(url, params, callBack);
    }

    /**
     * 建立网络框架，获取网络数据，异步post请求（Form）
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void postFormRequest(String url, Map<String, String> params, DataCallBack callBack) {
        getInstance().inner_postFormAsync(url, params, callBack);
    }

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

    /**
     * 建立网络框架，获取网络数据，异步get请求（json）
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void getJsonRequest(String url, Map<String, Object> params, DataCallBack callBack) {
        getInstance().inner_getJsonAsync(url, params, callBack);
    }

    /**
     * 建立网络框架，获取网络数据，异步post请求（formData）
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void formDataJsonRequest(String url, Map<String, String> params, DataCallBack callBack) {
        getInstance().inner_formDataJsonAsync(url, params, callBack);
    }

    //传图片使用
    public static void formDataJsonRequest(String url, Map<String, String> params, String name, DataCallBack callBack) {
        getInstance().inner_formDataJsonAsync(url, params, name, callBack);
    }

    //传图片使用Object
    public static void formDataJsonRequestOb(String url, Map<String, Object> params, String name, DataCallBack callBack) {
        getInstance().inner_formDataJsonAsyncOb(url, params, name, callBack);
    }

    /**
     * 建立网络框架，获取网络数据，异步post请求（formData） 事件文件附件上传
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void formDataJsonRequest_event(String url, String typeStr, Map<String, String> params, DataCallBack callBack) {
        getInstance().inner_formDataJsonAsync_event(url, typeStr, params, callBack);
    }

    /**
     * 建立网络框架，获取网络数据，put请求
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void putJsonRequest(String url, Map<String, Object> params, DataCallBack callBack) {
        getInstance().inner_putJsonAsync(url, params, callBack);
    }

    /**
     * 建立网络框架，获取网络数据，delete请求
     *
     * @param url      url
     * @param params   key value
     * @param callBack data
     */
    public static void deleteJsonRequest(String url, Map<String, Object> params, DataCallBack callBack) {
        getInstance().inner_deleteJsonAsync(url, params, callBack);
    }

    //-------------对外提供的方法End--------------------------------

    ///////////////////////////////////自定义方法-对外//////////////////////////////////////////////////////////////

    /**
     * 图片上传功能 （单图或多图同时上传）
     */
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    private static final OkHttpClient client = new OkHttpClient();

    public static void uploadImg(Context context, String url, List<String> mImgUrls) {

       /* LoadingDialog.Builder loadBuilder = new LoadingDialog.Builder(context)
                .setMessage("加载中...")
                .setCancelable(true)
                .setCancelOutside(true);
        LoadingDialog dialog = loadBuilder.create();
        dialog.show();*/

        // mImgUrls为存放图片的url集合
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (int i = 0; i < mImgUrls.size(); i++) {
            File f = new File(mImgUrls.get(i));
            if (f != null) {
                builder.addFormDataPart("img", f.getName(), RequestBody.create(MEDIA_TYPE_PNG, f));
            }
        }

        //添加其它信息
//        builder.addFormDataPart("time",takePicTime);
//        builder.addFormDataPart("mapX", SharedInfoUtils.getLongitude());
//        builder.addFormDataPart("mapY",SharedInfoUtils.getLatitude());
//        builder.addFormDataPart("name",SharedInfoUtils.getUserName());

        MultipartBody requestBody = builder.build();
        //构建请求
        Request request = new Request.Builder()
                //.url(Constant.BASE_URL)//地址
                .url(url)//地址
                .post(requestBody)//添加请求体
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("上传失败:e.getLocalizedMessage() = " + e.getLocalizedMessage());
                ToastUtils.showLong("上传失败");
                //dialog.dismiss();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse服务器返回===" + request.toString() + "/code==" + response.code());
                if (response.code() == 500) {
                    ToastUtils.showLong("服务器返回500");
                }
                System.out.println("上传照片成功：response = " + response.body().string());
                ToastUtils.showLong("上传成功");
                //dialog.dismiss();
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 异步get请求（Form），内部实现方法
     *
     * @param url    url
     * @param params key value
     */
    private void inner_getFormAsync(String url, Map<String, Object> params, final DataCallBack callBack) {
        if (params == null) {
            params = new HashMap<>();
        }
        // 请求url（baseUrl+参数）
        final String doUrl = urlJoint(url, params);
        Logger.d("请求接口url地址为：" + doUrl + "\tget请求(form)\n\n传输过去的 Map<String, String> 的内容为：\n" + params);

        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }
        //version:1.0.0
        final Request request = new Request.Builder().url(doUrl).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").build();

        System.out.println("authKey=" + authKey);

        // 新建一个请求
        //final Request request = new Request.Builder().url(doUrl).addHeader("Client","Android").addHeader("Authorization","bearer "+ SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getToken()).build();
        //执行请求获得响应结果
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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

    /**
     * 异步post请求（Form）,内部实现方法
     *
     * @param url      url
     * @param params   params
     * @param callBack callBack
     */
    private void inner_postFormAsync(String url, Map<String, String> params, final DataCallBack callBack) {
        RequestBody requestBody;
        if (params == null) {
            params = new HashMap<>();
        }
        FormBody.Builder builder = new FormBody.Builder();
        /**
         * 在这对添加的参数进行遍历
         */
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
            /**
             * 把key和value添加到formbody中
             */
            builder.add(key, value);
        }
        requestBody = builder.build();
        Logger.d("请求接口url地址为：" + url + "\tpost请求(form)\n\n传输过去的 Map<String, String> 的内容为：\n" + params);
        //结果返回
        //final Request request = new Request.Builder().url(url).post(requestBody).addHeader("Client","Android").addHeader("Authorization","bearer "+ SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getToken()).build();

        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

        final Request request = new Request.Builder().url(url).post(requestBody).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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
                    throw new IOException(response + "请求失败");
                }
            }
        });
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
                    response.code();
                    System.out.println("请求失败onResponse===" + request.toString() + "/n打印response==" + response);
                    throw new IOException(response + "");
                }
            }
        });
    }

    /**
     * get请求传json
     *
     * @param url      url
     * @param callBack 成功或失败回调
     * @param params   params
     */
    private void inner_getJsonAsync(String url, Map<String, Object> params, final DataCallBack callBack) {
        if (params == null) {
            params = new HashMap<>();
        }
        // 请求url（baseUrl+参数）
        final String doUrl = urlJoint(url, params);
        final Request request = buildJsonGetRequest(doUrl);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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

    /**
     * formData请求传json
     *
     * @param url      url
     * @param callBack 成功或失败回调
     * @param params   params
     */
    private void inner_formDataJsonAsync(String url, Map<String, String> params, final DataCallBack callBack) {
        final Request request = buildJsonFormDataRequest(url, params);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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
    private void inner_formDataJsonAsync(String url, Map<String, String> params, String name, final DataCallBack callBack) {
        final Request request = buildJsonFormDataRequest(url, params, name);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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

    //传图片使用Object
    private void inner_formDataJsonAsyncOb(String url, Map<String, Object> params, String name, final DataCallBack callBack) {
        final Request request = buildJsonFormDataRequestOb(url, params, name);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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

    /**
     * formData请求传json  --- event 事件文件附件上传
     *
     * @param url      url
     * @param callBack 成功或失败回调
     * @param params   params
     */
    private void inner_formDataJsonAsync_event(String url, String typeStr, Map<String, String> params, final DataCallBack callBack) {
        final Request request = buildJsonFormDataRequest_event(url, typeStr, params);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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

    /**
     * put请求
     *
     * @param url      url
     * @param callBack 成功或失败回调
     * @param params   params
     */
    private void inner_putJsonAsync(String url, Map<String, Object> params, final DataCallBack callBack) {
        // 将map转换成json,需要引入Gson包
        String mapToJson = new Gson().toJson(params);
        final Request request = buildJsonPutRequest(url, mapToJson);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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

    /**
     * delete请求
     *
     * @param url      url
     * @param callBack 成功或失败回调
     * @param params   params
     */
    private void inner_deleteJsonAsync(String url, Map<String, Object> params, final DataCallBack callBack) {
        // 将map转换成json,需要引入Gson包
        String mapToJson = new Gson().toJson(params);
        final Request request = buildJsonDeleteRequest(url, mapToJson);
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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

        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

        return new Request.Builder().url(url).post(requestBody).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").build();
        //return new Request.Builder().url(url).post(requestBody).build();
    }

    /**
     * Json_GET请求参数
     *
     * @param url url
     * @return requestBody
     */
    private Request buildJsonGetRequest(String url) {
        Logger.d("请求接口url地址为：" + url + "\tget请求(json)");

        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }


        System.out.println("authKey=" + authKey);

        return new Request.Builder().url(url).get().addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").build();
        //return new Request.Builder().url(url).get().build();
    }

    /**
     * formData_POST请求参数
     *
     * @param url
     * @param params
     * @return
     */
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
            //if (key.equals("file")) {
            if (key.equals("23")) {
                File file = new File(value);
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
                builder.addFormDataPart("23", file.getName(), fileBody);
            }
            if (key.equals("123")) {
                File file = new File(value);
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
                builder.addFormDataPart("123", file.getName(), fileBody);
            } else {
                builder.addFormDataPart(key, value);
            }

        }
        MultipartBody requestBody = builder.build();
        Logger.d("请求接口url地址为：" + url + "\tpost请求（FormData）\n\n传输过去的 Map<String, String> params 的内容为：\n" + params);


        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

        //return new Request.Builder().url(url).addHeader("authKey",authKey).addHeader("sessionId",sessionId).build();
        return new Request.Builder().url(url).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").post(requestBody).build();
        //return new Request.Builder().url(url).addHeader("Client","Android").addHeader("Authorization","bearer "+SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getToken()).post(requestBody).build();
    }

    //传图片使用
    private Request buildJsonFormDataRequest(String url, Map<String, String> params, String name) {

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
            //if (key.equals("file")) {
            if (key.equals(name)) {
                File file = new File(value);
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
                builder.addFormDataPart(name, file.getName(), fileBody);
            } else {
                builder.addFormDataPart(key, value);
            }

        }
        MultipartBody requestBody = builder.build();
        Logger.d("请求接口url地址为：" + url + "\tpost请求（FormData）\n\n传输过去的 Map<String, String> params 的内容为：\n" + params);


        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

        //return new Request.Builder().url(url).addHeader("authKey",authKey).addHeader("sessionId",sessionId).build();
        return new Request.Builder().url(url).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").post(requestBody).build();
        //return new Request.Builder().url(url).addHeader("Client","Android").addHeader("Authorization","bearer "+SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getToken()).post(requestBody).build();
    }

    //传图片使用 Object
    private Request buildJsonFormDataRequestOb(String url, Map<String, Object> params, String name) {

        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String, Object> map : params.entrySet()) {
            String key = map.getKey();
            String value;
            /**
             * 判断值是否是空的
             */
            if (map.getValue() == null) {
                value = "";
            } else {
                value = (String) map.getValue();
            }
            //if (key.equals("file")) {
            if (key.equals(name)) {
                File file = new File(value);
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
                builder.addFormDataPart(name, file.getName(), fileBody);
            } else {
                builder.addFormDataPart(key, value);
            }

        }
        MultipartBody requestBody = builder.build();
        Logger.d("请求接口url地址为：" + url + "\tpost请求（FormData）\n\n传输过去的 Map<String, String> params 的内容为：\n" + params);


        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

         //return new Request.Builder().url(url).addHeader("authKey",authKey).addHeader("sessionId",sessionId).build();
        return new Request.Builder().url(url).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").post(requestBody).build();
        //return new Request.Builder().url(url).addHeader("Client","Android").addHeader("Authorization","bearer "+SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getToken()).post(requestBody).build();
    }


    /**
     * formData_POST请求参数  event 事件文件附件上传
     *
     * @param url
     * @param params
     * @return
     */
    private Request buildJsonFormDataRequest_event(String url, String typeStr, Map<String, String> params) {


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
            //if (key.equals("file")) {
            if (key.equals(typeStr)) {
                File file = new File(value);
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
                builder.addFormDataPart(typeStr, file.getName(), fileBody);
            } else {
                builder.addFormDataPart(key, value);
            }

        }
        MultipartBody requestBody = builder.build();
        Logger.d("请求接口url地址为：" + url + "\tpost请求（FormData）\n\n传输过去的 Map<String, String> params 的内容为：\n" + params);


        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

        Logger.d("打印数据：" + builder.build().toString());


         //return new Request.Builder().url(url).addHeader("authKey",authKey).addHeader("sessionId",sessionId).build();
        return new Request.Builder().url(url).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").post(requestBody).build();
        //return new Request.Builder().url(url).addHeader("Client","Android").addHeader("Authorization","bearer "+SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getToken()).post(requestBody).build();
    }


    /**
     * Json_PUT请求参数
     *
     * @param url  url
     * @param json json
     * @return requestBody
     */
    private Request buildJsonPutRequest(String url, String json) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        Logger.d("请求接口url地址为：" + url + "\tput请求(json)\n\n传输过去的json的内容为：\n" + json);

        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

         return new Request.Builder().url(url).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").put(requestBody).build();
        //return new Request.Builder().url(url).put(requestBody).build();
    }

    /**
     * Json_DELETE请求参数
     *
     * @param url  url
     * @param json json
     * @return requestBody
     */
    private Request buildJsonDeleteRequest(String url, String json) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        Logger.d("请求接口url地址为：" + url + "\tdelete请求(json)\n\n传输过去的json的内容为：\n" + json);

        String authKey = "";
        String sessionId = "";

        //请求头参数
        if (SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData() != null) {
            authKey = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getAuthKey();
            sessionId = SharedPreferenceUtils.getLoginSp(MyApplication.getInstance()).getData().getSessionId();
        }

         return new Request.Builder().url(url).addHeader("authKey", authKey).addHeader("sessionId", sessionId).addHeader("sourcefrom", "android").delete(requestBody).build();
        //return new Request.Builder().url(url).delete(requestBody).build();
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
