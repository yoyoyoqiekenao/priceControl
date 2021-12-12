package com.cysd.pricecontrol.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThingListBean {

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
        @SerializedName("list")
        public List<ListDTO> list;
        @SerializedName("image_url")
        public String imageUrl;

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public static class ListDTO {
            @SerializedName("id")
            public Integer id;
            @SerializedName("user_id")
            public Integer userId;
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
            public Object escrowEnd;
            @SerializedName("remark")
            public String remark;
            @SerializedName("image")
            public String image;
            @SerializedName("created_at")
            public Integer createdAt;
            @SerializedName("updated_at")
            public Integer updatedAt;
            @SerializedName("add_date")
            public String addDate;
            @SerializedName("image_use")
            public String imageUse;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
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

            public Object getEscrowEnd() {
                return escrowEnd;
            }

            public void setEscrowEnd(Object escrowEnd) {
                this.escrowEnd = escrowEnd;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public Integer getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(Integer createdAt) {
                this.createdAt = createdAt;
            }

            public Integer getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(Integer updatedAt) {
                this.updatedAt = updatedAt;
            }

            public String getAddDate() {
                return addDate;
            }

            public void setAddDate(String addDate) {
                this.addDate = addDate;
            }

            public String getImageUse() {
                return imageUse;
            }

            public void setImageUse(String imageUse) {
                this.imageUse = imageUse;
            }
        }
    }
}
