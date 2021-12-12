package com.cysd.pricecontrol.bean;

import com.google.gson.annotations.SerializedName;

public class ImageUpLoadBean  {

    @SerializedName("code")
    public Integer code;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ImageUpLoadBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataDTO {
        @SerializedName("url")
        public String url;
        @SerializedName("use_url")
        public String useUrl;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUseUrl() {
            return useUrl;
        }

        public void setUseUrl(String useUrl) {
            this.useUrl = useUrl;
        }

        @Override
        public String toString() {
            return "DataDTO{" +
                    "url='" + url + '\'' +
                    ", useUrl='" + useUrl + '\'' +
                    '}';
        }
    }
}
