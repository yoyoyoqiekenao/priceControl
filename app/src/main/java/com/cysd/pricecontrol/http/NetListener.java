package com.cysd.pricecontrol.http;

/**
 * 网络请求完成后的回调监听接口
 */
public interface NetListener {
   /* *//**
     * 返回 请求码 retCode
     *
     * @param retCode
     *//*
    void getRetCodeString(String retCode);*/

    /**
     * 返回 请求码 retCode
     *
     * @param retCode
     */
    void getRetCodeString(String retCode, String result);
}
