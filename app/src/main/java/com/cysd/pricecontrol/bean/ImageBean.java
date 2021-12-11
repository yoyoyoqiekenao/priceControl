package com.cysd.pricecontrol.bean;

import com.chad.library.adapter.base.BaseQuickAdapter;

public class ImageBean {
    private String imgUrl;
    private String type;

    @Override
    public String toString() {
        return "ImageBean{" +
                "imgUrl='" + imgUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public ImageBean(String imgUrl, String type) {
        this.imgUrl = imgUrl;

        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
