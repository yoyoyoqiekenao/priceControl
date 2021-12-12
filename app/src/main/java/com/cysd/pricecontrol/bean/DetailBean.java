package com.cysd.pricecontrol.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailBean {

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
        @SerializedName("info")
        public InfoDTO info;
        @SerializedName("image_url")
        public String imageUrl;

        public InfoDTO getInfo() {
            return info;
        }

        public void setInfo(InfoDTO info) {
            this.info = info;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public static class InfoDTO {
            @SerializedName("id")
            public String id;
            @SerializedName("user_id")
            public String userId;
            @SerializedName("name")
            public String name;
            @SerializedName("number")
            public String number;
            @SerializedName("company")
            public String company;
            @SerializedName("handover")
            public String handover;
            @SerializedName("handover_mobile")
            public String handoverMobile;
            @SerializedName("htype")
            public String htype;
            @SerializedName("escrow_start")
            public String escrowStart;
            @SerializedName("escrow_end")
            public String escrowEnd;
            @SerializedName("remark")
            public String remark;
            @SerializedName("image")
            public List<String> image;
            @SerializedName("created_at")
            public String createdAt;
            @SerializedName("updated_at")
            public String updatedAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getHandover() {
                return handover;
            }

            public void setHandover(String handover) {
                this.handover = handover;
            }

            public String getHandoverMobile() {
                return handoverMobile;
            }

            public void setHandoverMobile(String handoverMobile) {
                this.handoverMobile = handoverMobile;
            }

            public String getHtype() {
                return htype;
            }

            public void setHtype(String htype) {
                this.htype = htype;
            }

            public String getEscrowStart() {
                return escrowStart;
            }

            public void setEscrowStart(String escrowStart) {
                this.escrowStart = escrowStart;
            }

            public String getEscrowEnd() {
                return escrowEnd;
            }

            public void setEscrowEnd(String escrowEnd) {
                this.escrowEnd = escrowEnd;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public List<String> getImage() {
                return image;
            }

            public void setImage(List<String> image) {
                this.image = image;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
