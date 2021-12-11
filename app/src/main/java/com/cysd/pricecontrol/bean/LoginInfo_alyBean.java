package com.cysd.pricecontrol.bean;

import java.util.List;

public class LoginInfo_alyBean {

    /**
     * code : 200
     * msg : 登陆成功
     * data : {"authKey":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTcyODUwNTMsImRhdGEiOnsiaWQiOjI0MSwidXNlcm5hbWUiOiIxODg2NzUxMTAzOCIsInR5cGUiOiJBUFAifX0.ZjTnkFqN9Tz5P1T_TguYWwquLrWrRC0gJdVhcIIpaQo","sessionId":"12ie01qsqe1udka9065ik0ta201594693053","userInfo":{"id":241,"mobile":"18867511038","openid":"","unionid":"","qq_unionid":"","qq_openid":"","nickname":"18867511038","qq_nickname":"","username":"复兴中华","sex":6,"province":"天津市","city":"市辖区","country":"中国大陆","status":1,"email":"","type":1,"qq_headimgurl":"","wx_headimgurl":"","headimgurl":"https://stc.qiaolu.com/lutai/19/23/20200630/d5deccc9b8c64432392b7ef9736cc582.jpeg","create_time":"1588840370","desc":"哈哈哈he is the only thing","old_ql_code":"","ql_code":"wiaoluhao123456","update_time":"1593506988","last_login_time":1592203431,"last_login_ip":665458989,"ql_code_time":0,"login_status":0,"person":0,"miniapp_openid":"","app_openid":"","wmid":0,"workmate_department_rel":[],"post_ids":[],"value_std_mate_info":null,"nim":{"accid":"241pkt2s8uefr","token":"5a5cj3MYmfS1RkS7yNpijV2rJcpGWKvQE7vRI4PJR-2F0Xc1YB2xZ0dWzmCTVfffay-2BDSU0YxXPXDj3q2AflFWCQs"}}}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * authKey : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTcyODUwNTMsImRhdGEiOnsiaWQiOjI0MSwidXNlcm5hbWUiOiIxODg2NzUxMTAzOCIsInR5cGUiOiJBUFAifX0.ZjTnkFqN9Tz5P1T_TguYWwquLrWrRC0gJdVhcIIpaQo
         * sessionId : 12ie01qsqe1udka9065ik0ta201594693053
         * userInfo : {"id":241,"mobile":"18867511038","openid":"","unionid":"","qq_unionid":"","qq_openid":"","nickname":"18867511038","qq_nickname":"","username":"复兴中华","sex":6,"province":"天津市","city":"市辖区","country":"中国大陆","status":1,"email":"","type":1,"qq_headimgurl":"","wx_headimgurl":"","headimgurl":"https://stc.qiaolu.com/lutai/19/23/20200630/d5deccc9b8c64432392b7ef9736cc582.jpeg","create_time":"1588840370","desc":"哈哈哈he is the only thing","old_ql_code":"","ql_code":"wiaoluhao123456","update_time":"1593506988","last_login_time":1592203431,"last_login_ip":665458989,"ql_code_time":0,"login_status":0,"person":0,"miniapp_openid":"","app_openid":"","wmid":0,"workmate_department_rel":[],"post_ids":[],"value_std_mate_info":null,"nim":{"accid":"241pkt2s8uefr","token":"5a5cj3MYmfS1RkS7yNpijV2rJcpGWKvQE7vRI4PJR-2F0Xc1YB2xZ0dWzmCTVfffay-2BDSU0YxXPXDj3q2AflFWCQs"}}
         */

        private String setInfo;

        private String authKey;
        private String sessionId;
        private UserInfoBean userInfo;

        private jpushAliaBean jpush_alia;


        public static class jpushAliaBean {
            /**
             * jpush_alia
             * ios : 91557e9d6df386532f1eba4d671a1f5e
             * android : 031e36297562385f8fae1e434d75416a
             */

            private String ios;
            private String android;

            public String getIos() {
                return ios;
            }

            public void setIos(String ios) {
                this.ios = ios;
            }

            public String getAndroid() {
                return android;
            }

            public void setAndroid(String android) {
                this.android = android;
            }

        }


        public String getSetInfo() {
            return setInfo;
        }

        public void setSetInfo(String setInfo) {
            this.setInfo = setInfo;
        }

        public String getAuthKey() {
            return authKey;
        }

        public void setAuthKey(String authKey) {
            this.authKey = authKey;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public jpushAliaBean getJpushAlia() {
            return jpush_alia;
        }

        public void setJpushAlia(jpushAliaBean jpush_alia) {
            this.jpush_alia = jpush_alia;
        }

        public static class UserInfoBean {
            /**
             * id : 241
             * mobile : 18867511038
             * openid :
             * unionid :
             * qq_unionid :
             * qq_openid :
             * nickname : 18867511038
             * qq_nickname :
             * username : 复兴中华
             * sex : 6
             * province : 天津市
             * city : 市辖区
             * country : 中国大陆
             * status : 1
             * email :
             * type : 1
             * qq_headimgurl :
             * wx_headimgurl :
             * headimgurl : https://stc.qiaolu.com/lutai/19/23/20200630/d5deccc9b8c64432392b7ef9736cc582.jpeg
             * create_time : 1588840370
             * desc : 哈哈哈he is the only thing
             * old_ql_code :
             * ql_code : wiaoluhao123456
             * update_time : 1593506988
             * last_login_time : 1592203431
             * last_login_ip : 665458989
             * ql_code_time : 0
             * login_status : 0
             * person : 0
             * miniapp_openid :
             * app_openid :
             * wmid : 0
             * workmate_department_rel : []
             * post_ids : []
             * value_std_mate_info : null
             * nim : {"accid":"241pkt2s8uefr","token":"5a5cj3MYmfS1RkS7yNpijV2rJcpGWKvQE7vRI4PJR-2F0Xc1YB2xZ0dWzmCTVfffay-2BDSU0YxXPXDj3q2AflFWCQs"}
             */

            private int id;
            private String mobile;
            private String openid;
            private String unionid;
            private String qq_unionid;
            private String qq_openid;
            private String nickname;
            private String qq_nickname;
            private String username;
            private int sex;
            private String province;
            private String city;
            private String country;
            private int status;
            private String email;
            private int type;
            private String qq_headimgurl;
            private String wx_headimgurl;
            private String headimgurl;
            private String create_time;
            private String desc;
            private String old_ql_code;
            private String ql_code;
            private String update_time;
            private String last_login_time;
            private String last_login_ip;
            private String ql_code_time;
            private int login_status;
            private String person;
            private String miniapp_openid;
            private String app_openid;
            private int wmid;
            private Object value_std_mate_info;
            private NimBean nim;
            private List<?> workmate_department_rel;
            private List<?> post_ids;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getOpenid() {
                return openid;
            }

            public void setOpenid(String openid) {
                this.openid = openid;
            }

            public String getUnionid() {
                return unionid;
            }

            public void setUnionid(String unionid) {
                this.unionid = unionid;
            }

            public String getQq_unionid() {
                return qq_unionid;
            }

            public void setQq_unionid(String qq_unionid) {
                this.qq_unionid = qq_unionid;
            }

            public String getQq_openid() {
                return qq_openid;
            }

            public void setQq_openid(String qq_openid) {
                this.qq_openid = qq_openid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getQq_nickname() {
                return qq_nickname;
            }

            public void setQq_nickname(String qq_nickname) {
                this.qq_nickname = qq_nickname;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getQq_headimgurl() {
                return qq_headimgurl;
            }

            public void setQq_headimgurl(String qq_headimgurl) {
                this.qq_headimgurl = qq_headimgurl;
            }

            public String getWx_headimgurl() {
                return wx_headimgurl;
            }

            public void setWx_headimgurl(String wx_headimgurl) {
                this.wx_headimgurl = wx_headimgurl;
            }

            public String getHeadimgurl() {
                return headimgurl;
            }

            public void setHeadimgurl(String headimgurl) {
                this.headimgurl = headimgurl;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getOld_ql_code() {
                return old_ql_code;
            }

            public void setOld_ql_code(String old_ql_code) {
                this.old_ql_code = old_ql_code;
            }

            public String getQl_code() {
                return ql_code;
            }

            public void setQl_code(String ql_code) {
                this.ql_code = ql_code;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getLast_login_time() {
                return last_login_time;
            }

            public void setLast_login_time(String last_login_time) {
                this.last_login_time = last_login_time;
            }

            public String getLast_login_ip() {
                return last_login_ip;
            }

            public void setLast_login_ip(String last_login_ip) {
                this.last_login_ip = last_login_ip;
            }

            public String getQl_code_time() {
                return ql_code_time;
            }

            public void setQl_code_time(String ql_code_time) {
                this.ql_code_time = ql_code_time;
            }

            public int getLogin_status() {
                return login_status;
            }

            public void setLogin_status(int login_status) {
                this.login_status = login_status;
            }

            public String getPerson() {
                return person;
            }

            public void setPerson(String person) {
                this.person = person;
            }

            public String getMiniapp_openid() {
                return miniapp_openid;
            }

            public void setMiniapp_openid(String miniapp_openid) {
                this.miniapp_openid = miniapp_openid;
            }

            public String getApp_openid() {
                return app_openid;
            }

            public void setApp_openid(String app_openid) {
                this.app_openid = app_openid;
            }

            public int getWmid() {
                return wmid;
            }

            public void setWmid(int wmid) {
                this.wmid = wmid;
            }

            public Object getValue_std_mate_info() {
                return value_std_mate_info;
            }

            public void setValue_std_mate_info(Object value_std_mate_info) {
                this.value_std_mate_info = value_std_mate_info;
            }

            public NimBean getNim() {
                return nim;
            }

            public void setNim(NimBean nim) {
                this.nim = nim;
            }

            public List<?> getWorkmate_department_rel() {
                return workmate_department_rel;
            }

            public void setWorkmate_department_rel(List<?> workmate_department_rel) {
                this.workmate_department_rel = workmate_department_rel;
            }

            public List<?> getPost_ids() {
                return post_ids;
            }

            public void setPost_ids(List<?> post_ids) {
                this.post_ids = post_ids;
            }

            public static class NimBean {
                /**
                 * accid : 241pkt2s8uefr
                 * token : 5a5cj3MYmfS1RkS7yNpijV2rJcpGWKvQE7vRI4PJR-2F0Xc1YB2xZ0dWzmCTVfffay-2BDSU0YxXPXDj3q2AflFWCQs
                 */

                private String accid;
                private String token;

                public String getAccid() {
                    return accid;
                }

                public void setAccid(String accid) {
                    this.accid = accid;
                }

                public String getToken() {
                    return token;
                }

                public void setToken(String token) {
                    this.token = token;
                }
            }
        }
    }
}
