package com.cysd.pricecontrol.bean;

import com.google.gson.annotations.SerializedName;

public class LoginBean {

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

    public static class DataDTO {
        @SerializedName("token")
        public String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
