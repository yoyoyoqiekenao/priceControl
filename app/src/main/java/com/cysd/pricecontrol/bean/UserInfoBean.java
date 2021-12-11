package com.cysd.pricecontrol.bean;

import java.util.List;

public class UserInfoBean {

    /**
     * code : 200
     * msg : 获取成功
     * data : {"data":{"username":"安迪小赤佬","headimgurl":"https://stc.qiaolu.com/19/23/20201030/ed724d51a9fd6a66e2c1d90cb963fe3a.jpg","desc":"千窟唯佑, 太平无忧","ql_code":"ql9596","sex":2,"country":"中国","province":"浙江省","city":"杭州市","mobile":"18358557217","email":"wanglu1995812@qq.com","country_id":100000,"province_id":330000,"city_id":330100,"wechat":{"nickname":"嚣张🐷"},"qq":{"qq_nickname":"@哥尔罗杰"},"bank":[{"id":2145,"name":"绿了","sub_bank":"中国工商银行诸暨山下湖支行","number":"6215581211000171916","type_name":"普通"}],"zfb":{"id":2144,"sub_bank":"","name":"","number":"18358557217"},"address":[{"id":819,"address_type":0,"complete":"北京市,市辖区,东城区,v个和好如初健健康康"}],"verify":{"person":{"id":10000317,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":11,"lid":"1322075366185021440","type":1,"status":1,"create_time":"1604042305","audit":151,"audit_time":"2020-10-30","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":19,"source_lid":151,"update_time":"1604042497","user_subject_rel":226,"credit_code":"330681199509065869","address":"浙江省杭州市江干区西湖边雷峰塔底下","name":"王露"},"corp":[{"id":10000214,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126848508118311424","type":4,"status":1,"create_time":"1593410205","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321415,"update_time":"1594113198","user_subject_rel":160,"credit_code":"91330109MA28XDDW8D","address":"浙江省杭州市萧山区萧山经济技术开发区宝龙城市中心3幢2414室","name":"杭州宽朴投资管理有限公司"},{"id":10000216,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127042128181142016","type":4,"status":1,"create_time":"1593415972","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":19011178,"update_time":"1594113195","user_subject_rel":159,"credit_code":"91110108718704736N","address":"北京市海淀区阜成路115号C座418室","name":"北京东方亚科技术发展有限公司"},{"id":10000221,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127216632455569920","type":4,"status":1,"create_time":"1593496617","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":16758761,"update_time":"1594113191","user_subject_rel":158,"credit_code":"91440606588281375H","address":"佛山市顺德区乐从镇岭南大道南2号D栋6层601-01室","name":"广东顺德美的科技孵化器有限公司"},{"id":10000222,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126907683663454720","type":4,"status":1,"create_time":"1593497346","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":15648233,"update_time":"1593770439","user_subject_rel":156,"credit_code":"91330110MA27X4PX7X","address":"浙江省杭州市余杭区五常街道文一西路969号3幢592室","name":"杭州阿里巴巴音乐科技有限公司"},{"id":10000223,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":-1,"create_time":"1593498639","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1594113188","user_subject_rel":0,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000224,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":1,"create_time":"1593499428","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1593757851","user_subject_rel":154,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000226,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":-1,"create_time":"1594114029","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114042","user_subject_rel":0,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000227,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":1,"create_time":"1594114084","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114094","user_subject_rel":161,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000228,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127179520158409216","type":4,"status":-1,"create_time":"1594114155","audit":151,"audit_time":"2020-07-07","respond":55,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320631,"update_time":"1594114250","user_subject_rel":0,"credit_code":"91330110MA2H3NAJ42","address":"浙江省杭州市余杭区仓前街道良睦路1399号26号楼F1-123、F1-124号","name":"杭州宇堂好课科技有限公司"},{"id":10000237,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126898932697014784","type":4,"status":0,"create_time":"1594370816","audit":0,"audit_time":"-","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320621,"update_time":"1594370816","user_subject_rel":0,"credit_code":"91330110MA2H03N78N","address":"浙江省杭州市余杭区瓶窑镇凤都工业园区1幢1148室","name":"杭州芑氘贸易有限公司"},{"id":10000258,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127337835043201536","type":4,"status":1,"create_time":"1598438180","audit":151,"audit_time":"2020-08-26","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1127337835043201536,"update_time":"1598438266","user_subject_rel":182,"credit_code":"91110000339750652L","address":"北京市朝阳区五里桥二街2号院7号楼13层1313","name":"阿里巴巴传媒（北京）有限公司"},{"id":10000265,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126821136872055296","type":4,"status":1,"create_time":"1598840475","audit":151,"audit_time":"2020-08-31","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1126821136872055296,"update_time":"1598840496","user_subject_rel":190,"credit_code":"91330782089471377Y","address":"浙江省义乌市稠城街道大塘下三区31栋2单元4楼402室（自主申报）","name":"义乌市昱希贸易有限公司"}],"other_person":[]}},"collect_num":26,"cart_num":3,"trade_num":36}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : {"username":"安迪小赤佬","headimgurl":"https://stc.qiaolu.com/19/23/20201030/ed724d51a9fd6a66e2c1d90cb963fe3a.jpg","desc":"千窟唯佑, 太平无忧","ql_code":"ql9596","sex":2,"country":"中国","province":"浙江省","city":"杭州市","mobile":"18358557217","email":"wanglu1995812@qq.com","country_id":100000,"province_id":330000,"city_id":330100,"wechat":{"nickname":"嚣张🐷"},"qq":{"qq_nickname":"@哥尔罗杰"},"bank":[{"id":2145,"name":"绿了","sub_bank":"中国工商银行诸暨山下湖支行","number":"6215581211000171916","type_name":"普通"}],"zfb":{"id":2144,"sub_bank":"","name":"","number":"18358557217"},"address":[{"id":819,"address_type":0,"complete":"北京市,市辖区,东城区,v个和好如初健健康康"}],"verify":{"person":{"id":10000317,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":11,"lid":"1322075366185021440","type":1,"status":1,"create_time":"1604042305","audit":151,"audit_time":"2020-10-30","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":19,"source_lid":151,"update_time":"1604042497","user_subject_rel":226,"credit_code":"330681199509065869","address":"浙江省杭州市江干区西湖边雷峰塔底下","name":"王露"},"corp":[{"id":10000214,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126848508118311424","type":4,"status":1,"create_time":"1593410205","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321415,"update_time":"1594113198","user_subject_rel":160,"credit_code":"91330109MA28XDDW8D","address":"浙江省杭州市萧山区萧山经济技术开发区宝龙城市中心3幢2414室","name":"杭州宽朴投资管理有限公司"},{"id":10000216,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127042128181142016","type":4,"status":1,"create_time":"1593415972","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":19011178,"update_time":"1594113195","user_subject_rel":159,"credit_code":"91110108718704736N","address":"北京市海淀区阜成路115号C座418室","name":"北京东方亚科技术发展有限公司"},{"id":10000221,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127216632455569920","type":4,"status":1,"create_time":"1593496617","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":16758761,"update_time":"1594113191","user_subject_rel":158,"credit_code":"91440606588281375H","address":"佛山市顺德区乐从镇岭南大道南2号D栋6层601-01室","name":"广东顺德美的科技孵化器有限公司"},{"id":10000222,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126907683663454720","type":4,"status":1,"create_time":"1593497346","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":15648233,"update_time":"1593770439","user_subject_rel":156,"credit_code":"91330110MA27X4PX7X","address":"浙江省杭州市余杭区五常街道文一西路969号3幢592室","name":"杭州阿里巴巴音乐科技有限公司"},{"id":10000223,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":-1,"create_time":"1593498639","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1594113188","user_subject_rel":0,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000224,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":1,"create_time":"1593499428","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1593757851","user_subject_rel":154,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000226,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":-1,"create_time":"1594114029","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114042","user_subject_rel":0,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000227,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":1,"create_time":"1594114084","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114094","user_subject_rel":161,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000228,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127179520158409216","type":4,"status":-1,"create_time":"1594114155","audit":151,"audit_time":"2020-07-07","respond":55,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320631,"update_time":"1594114250","user_subject_rel":0,"credit_code":"91330110MA2H3NAJ42","address":"浙江省杭州市余杭区仓前街道良睦路1399号26号楼F1-123、F1-124号","name":"杭州宇堂好课科技有限公司"},{"id":10000237,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126898932697014784","type":4,"status":0,"create_time":"1594370816","audit":0,"audit_time":"-","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320621,"update_time":"1594370816","user_subject_rel":0,"credit_code":"91330110MA2H03N78N","address":"浙江省杭州市余杭区瓶窑镇凤都工业园区1幢1148室","name":"杭州芑氘贸易有限公司"},{"id":10000258,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127337835043201536","type":4,"status":1,"create_time":"1598438180","audit":151,"audit_time":"2020-08-26","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1127337835043201536,"update_time":"1598438266","user_subject_rel":182,"credit_code":"91110000339750652L","address":"北京市朝阳区五里桥二街2号院7号楼13层1313","name":"阿里巴巴传媒（北京）有限公司"},{"id":10000265,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126821136872055296","type":4,"status":1,"create_time":"1598840475","audit":151,"audit_time":"2020-08-31","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1126821136872055296,"update_time":"1598840496","user_subject_rel":190,"credit_code":"91330782089471377Y","address":"浙江省义乌市稠城街道大塘下三区31栋2单元4楼402室（自主申报）","name":"义乌市昱希贸易有限公司"}],"other_person":[]}}
         * collect_num : 26
         * cart_num : 3
         * trade_num : 36
         */

        private DataBean data;
        private String collect_num;
        private String cart_num;
        private String trade_num;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getCollect_num() {
            return collect_num;
        }

        public void setCollect_num(String collect_num) {
            this.collect_num = collect_num;
        }

        public String getCart_num() {
            return cart_num;
        }

        public void setCart_num(String cart_num) {
            this.cart_num = cart_num;
        }

        public String getTrade_num() {
            return trade_num;
        }

        public void setTrade_num(String trade_num) {
            this.trade_num = trade_num;
        }

        public static class DataBean {
            /**
             * username : 安迪小赤佬
             * headimgurl : https://stc.qiaolu.com/19/23/20201030/ed724d51a9fd6a66e2c1d90cb963fe3a.jpg
             * desc : 千窟唯佑, 太平无忧
             * ql_code : ql9596
             * sex : 2
             * country : 中国
             * province : 浙江省
             * city : 杭州市
             * mobile : 18358557217
             * email : wanglu1995812@qq.com
             * country_id : 100000
             * province_id : 330000
             * city_id : 330100
             * wechat : {"nickname":"嚣张🐷"}
             * qq : {"qq_nickname":"@哥尔罗杰"}
             * bank : [{"id":2145,"name":"绿了","sub_bank":"中国工商银行诸暨山下湖支行","number":"6215581211000171916","type_name":"普通"}]
             * zfb : {"id":2144,"sub_bank":"","name":"","number":"18358557217"}
             * address : [{"id":819,"address_type":0,"complete":"北京市,市辖区,东城区,v个和好如初健健康康"}]
             * verify : {"person":{"id":10000317,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":11,"lid":"1322075366185021440","type":1,"status":1,"create_time":"1604042305","audit":151,"audit_time":"2020-10-30","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":19,"source_lid":151,"update_time":"1604042497","user_subject_rel":226,"credit_code":"330681199509065869","address":"浙江省杭州市江干区西湖边雷峰塔底下","name":"王露"},"corp":[{"id":10000214,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126848508118311424","type":4,"status":1,"create_time":"1593410205","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321415,"update_time":"1594113198","user_subject_rel":160,"credit_code":"91330109MA28XDDW8D","address":"浙江省杭州市萧山区萧山经济技术开发区宝龙城市中心3幢2414室","name":"杭州宽朴投资管理有限公司"},{"id":10000216,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127042128181142016","type":4,"status":1,"create_time":"1593415972","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":19011178,"update_time":"1594113195","user_subject_rel":159,"credit_code":"91110108718704736N","address":"北京市海淀区阜成路115号C座418室","name":"北京东方亚科技术发展有限公司"},{"id":10000221,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127216632455569920","type":4,"status":1,"create_time":"1593496617","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":16758761,"update_time":"1594113191","user_subject_rel":158,"credit_code":"91440606588281375H","address":"佛山市顺德区乐从镇岭南大道南2号D栋6层601-01室","name":"广东顺德美的科技孵化器有限公司"},{"id":10000222,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126907683663454720","type":4,"status":1,"create_time":"1593497346","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":15648233,"update_time":"1593770439","user_subject_rel":156,"credit_code":"91330110MA27X4PX7X","address":"浙江省杭州市余杭区五常街道文一西路969号3幢592室","name":"杭州阿里巴巴音乐科技有限公司"},{"id":10000223,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":-1,"create_time":"1593498639","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1594113188","user_subject_rel":0,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000224,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":1,"create_time":"1593499428","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1593757851","user_subject_rel":154,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000226,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":-1,"create_time":"1594114029","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114042","user_subject_rel":0,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000227,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":1,"create_time":"1594114084","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114094","user_subject_rel":161,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000228,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127179520158409216","type":4,"status":-1,"create_time":"1594114155","audit":151,"audit_time":"2020-07-07","respond":55,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320631,"update_time":"1594114250","user_subject_rel":0,"credit_code":"91330110MA2H3NAJ42","address":"浙江省杭州市余杭区仓前街道良睦路1399号26号楼F1-123、F1-124号","name":"杭州宇堂好课科技有限公司"},{"id":10000237,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126898932697014784","type":4,"status":0,"create_time":"1594370816","audit":0,"audit_time":"-","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320621,"update_time":"1594370816","user_subject_rel":0,"credit_code":"91330110MA2H03N78N","address":"浙江省杭州市余杭区瓶窑镇凤都工业园区1幢1148室","name":"杭州芑氘贸易有限公司"},{"id":10000258,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127337835043201536","type":4,"status":1,"create_time":"1598438180","audit":151,"audit_time":"2020-08-26","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1127337835043201536,"update_time":"1598438266","user_subject_rel":182,"credit_code":"91110000339750652L","address":"北京市朝阳区五里桥二街2号院7号楼13层1313","name":"阿里巴巴传媒（北京）有限公司"},{"id":10000265,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126821136872055296","type":4,"status":1,"create_time":"1598840475","audit":151,"audit_time":"2020-08-31","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1126821136872055296,"update_time":"1598840496","user_subject_rel":190,"credit_code":"91330782089471377Y","address":"浙江省义乌市稠城街道大塘下三区31栋2单元4楼402室（自主申报）","name":"义乌市昱希贸易有限公司"}],"other_person":[]}
             */

            private String username;
            private String headimgurl;
            private String desc;
            private String ql_code;
            private String sex;
            private String country;
            private String province;
            private String city;
            private String mobile;
            private String email;
            private String country_id;
            private String province_id;
            private String city_id;
            private WechatBean wechat;
            private QqBean qq;
            private ZfbBean zfb;
            private VerifyBean verify;
            private List<BankBean> bank;
            private List<AddressBean> address;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getHeadimgurl() {
                return headimgurl;
            }

            public void setHeadimgurl(String headimgurl) {
                this.headimgurl = headimgurl;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getQl_code() {
                return ql_code;
            }

            public void setQl_code(String ql_code) {
                this.ql_code = ql_code;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getCountry_id() {
                return country_id;
            }

            public void setCountry_id(String country_id) {
                this.country_id = country_id;
            }

            public String getProvince_id() {
                return province_id;
            }

            public void setProvince_id(String province_id) {
                this.province_id = province_id;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public WechatBean getWechat() {
                return wechat;
            }

            public void setWechat(WechatBean wechat) {
                this.wechat = wechat;
            }

            public QqBean getQq() {
                return qq;
            }

            public void setQq(QqBean qq) {
                this.qq = qq;
            }

            public ZfbBean getZfb() {
                return zfb;
            }

            public void setZfb(ZfbBean zfb) {
                this.zfb = zfb;
            }

            public VerifyBean getVerify() {
                return verify;
            }

            public void setVerify(VerifyBean verify) {
                this.verify = verify;
            }

            public List<BankBean> getBank() {
                return bank;
            }

            public void setBank(List<BankBean> bank) {
                this.bank = bank;
            }

            public List<AddressBean> getAddress() {
                return address;
            }

            public void setAddress(List<AddressBean> address) {
                this.address = address;
            }

            public static class WechatBean {
                /**
                 * nickname : 嚣张🐷
                 */

                private String nickname;

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }
            }

            public static class QqBean {
                /**
                 * qq_nickname : @哥尔罗杰
                 */

                private String qq_nickname;

                public String getQq_nickname() {
                    return qq_nickname;
                }

                public void setQq_nickname(String qq_nickname) {
                    this.qq_nickname = qq_nickname;
                }
            }

            public static class ZfbBean {
                /**
                 * id : 2144
                 * sub_bank :
                 * name :
                 * number : 18358557217
                 */

                private String id;
                private String sub_bank;
                private String name;
                private String number;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getSub_bank() {
                    return sub_bank;
                }

                public void setSub_bank(String sub_bank) {
                    this.sub_bank = sub_bank;
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
            }

            public static class VerifyBean {
                /**
                 * person : {"id":10000317,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":11,"lid":"1322075366185021440","type":1,"status":1,"create_time":"1604042305","audit":151,"audit_time":"2020-10-30","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":19,"source_lid":151,"update_time":"1604042497","user_subject_rel":226,"credit_code":"330681199509065869","address":"浙江省杭州市江干区西湖边雷峰塔底下","name":"王露"}
                 * corp : [{"id":10000214,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126848508118311424","type":4,"status":1,"create_time":"1593410205","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321415,"update_time":"1594113198","user_subject_rel":160,"credit_code":"91330109MA28XDDW8D","address":"浙江省杭州市萧山区萧山经济技术开发区宝龙城市中心3幢2414室","name":"杭州宽朴投资管理有限公司"},{"id":10000216,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127042128181142016","type":4,"status":1,"create_time":"1593415972","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":19011178,"update_time":"1594113195","user_subject_rel":159,"credit_code":"91110108718704736N","address":"北京市海淀区阜成路115号C座418室","name":"北京东方亚科技术发展有限公司"},{"id":10000221,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127216632455569920","type":4,"status":1,"create_time":"1593496617","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":16758761,"update_time":"1594113191","user_subject_rel":158,"credit_code":"91440606588281375H","address":"佛山市顺德区乐从镇岭南大道南2号D栋6层601-01室","name":"广东顺德美的科技孵化器有限公司"},{"id":10000222,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126907683663454720","type":4,"status":1,"create_time":"1593497346","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":15648233,"update_time":"1593770439","user_subject_rel":156,"credit_code":"91330110MA27X4PX7X","address":"浙江省杭州市余杭区五常街道文一西路969号3幢592室","name":"杭州阿里巴巴音乐科技有限公司"},{"id":10000223,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":-1,"create_time":"1593498639","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1594113188","user_subject_rel":0,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000224,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126911664147669504","type":4,"status":1,"create_time":"1593499428","audit":150,"audit_time":"2020-07-03","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321332,"update_time":"1593757851","user_subject_rel":154,"credit_code":"91330185MA2CC2JC1W","address":"浙江省杭州市临安区玲珑街道祥里上家头村28号","name":"杭州爱想科技有限公司"},{"id":10000226,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":-1,"create_time":"1594114029","audit":151,"audit_time":"2020-07-07","respond":56,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114042","user_subject_rel":0,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000227,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126922362982048256","type":4,"status":1,"create_time":"1594114084","audit":151,"audit_time":"2020-07-07","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20321224,"update_time":"1594114094","user_subject_rel":161,"credit_code":"91330108MA28LUM12D","address":"杭州市滨江区西兴街道江陵路1916号兴祺大厦1幢1402室","name":"杭州裕盈贸易有限公司"},{"id":10000228,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127179520158409216","type":4,"status":-1,"create_time":"1594114155","audit":151,"audit_time":"2020-07-07","respond":55,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320631,"update_time":"1594114250","user_subject_rel":0,"credit_code":"91330110MA2H3NAJ42","address":"浙江省杭州市余杭区仓前街道良睦路1399号26号楼F1-123、F1-124号","name":"杭州宇堂好课科技有限公司"},{"id":10000237,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126898932697014784","type":4,"status":0,"create_time":"1594370816","audit":0,"audit_time":"-","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":20320621,"update_time":"1594370816","user_subject_rel":0,"credit_code":"91330110MA2H03N78N","address":"浙江省杭州市余杭区瓶窑镇凤都工业园区1幢1148室","name":"杭州芑氘贸易有限公司"},{"id":10000258,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1127337835043201536","type":4,"status":1,"create_time":"1598438180","audit":151,"audit_time":"2020-08-26","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1127337835043201536,"update_time":"1598438266","user_subject_rel":182,"credit_code":"91110000339750652L","address":"北京市朝阳区五里桥二街2号院7号楼13层1313","name":"阿里巴巴传媒（北京）有限公司"},{"id":10000265,"org":0,"mate":0,"user":151,"object_lsc":0,"object_lid":0,"lsc":101,"lid":"1126821136872055296","type":4,"status":1,"create_time":"1598840475","audit":151,"audit_time":"2020-08-31","respond":0,"favorite":0,"is_deleted":0,"pid":0,"cert_status":1,"source_lsc":222210,"source_lid":1126821136872055296,"update_time":"1598840496","user_subject_rel":190,"credit_code":"91330782089471377Y","address":"浙江省义乌市稠城街道大塘下三区31栋2单元4楼402室（自主申报）","name":"义乌市昱希贸易有限公司"}]
                 * other_person : []
                 */

                private PersonBean person;
                private List<CorpBean> corp;
                private List<?> other_person;

                public PersonBean getPerson() {
                    return person;
                }

                public void setPerson(PersonBean person) {
                    this.person = person;
                }

                public List<CorpBean> getCorp() {
                    return corp;
                }

                public void setCorp(List<CorpBean> corp) {
                    this.corp = corp;
                }

                public List<?> getOther_person() {
                    return other_person;
                }

                public void setOther_person(List<?> other_person) {
                    this.other_person = other_person;
                }

                public static class PersonBean {
                    /**
                     * id : 10000317
                     * org : 0
                     * mate : 0
                     * user : 151
                     * object_lsc : 0
                     * object_lid : 0
                     * lsc : 11
                     * lid : 1322075366185021440
                     * type : 1
                     * status : 1
                     * create_time : 1604042305
                     * audit : 151
                     * audit_time : 2020-10-30
                     * respond : 0
                     * favorite : 0
                     * is_deleted : 0
                     * pid : 0
                     * cert_status : 1
                     * source_lsc : 19
                     * source_lid : 151
                     * update_time : 1604042497
                     * user_subject_rel : 226
                     * credit_code : 330681199509065869
                     * address : 浙江省杭州市江干区西湖边雷峰塔底下
                     * name : 王露
                     */

                    private String id;
                    private String org;
                    private String mate;
                    private String user;
                    private String object_lsc;
                    private String object_lid;
                    private String lsc;
                    private String lid;
                    private String type;
                    private String status;
                    private String create_time;
                    private String audit;
                    private String audit_time;
                    private String respond;
                    private String favorite;
                    private String is_deleted;
                    private String pid;
                    private String cert_status;
                    private String source_lsc;
                    private String source_lid;
                    private String update_time;
                    private String user_subject_rel;
                    private String credit_code;
                    private String address;
                    private String name;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getOrg() {
                        return org;
                    }

                    public void setOrg(String org) {
                        this.org = org;
                    }

                    public String getMate() {
                        return mate;
                    }

                    public void setMate(String mate) {
                        this.mate = mate;
                    }

                    public String getUser() {
                        return user;
                    }

                    public void setUser(String user) {
                        this.user = user;
                    }

                    public String getObject_lsc() {
                        return object_lsc;
                    }

                    public void setObject_lsc(String object_lsc) {
                        this.object_lsc = object_lsc;
                    }

                    public String getObject_lid() {
                        return object_lid;
                    }

                    public void setObject_lid(String object_lid) {
                        this.object_lid = object_lid;
                    }

                    public String getLsc() {
                        return lsc;
                    }

                    public void setLsc(String lsc) {
                        this.lsc = lsc;
                    }

                    public String getLid() {
                        return lid;
                    }

                    public void setLid(String lid) {
                        this.lid = lid;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getAudit() {
                        return audit;
                    }

                    public void setAudit(String audit) {
                        this.audit = audit;
                    }

                    public String getAudit_time() {
                        return audit_time;
                    }

                    public void setAudit_time(String audit_time) {
                        this.audit_time = audit_time;
                    }

                    public String getRespond() {
                        return respond;
                    }

                    public void setRespond(String respond) {
                        this.respond = respond;
                    }

                    public String getFavorite() {
                        return favorite;
                    }

                    public void setFavorite(String favorite) {
                        this.favorite = favorite;
                    }

                    public String getIs_deleted() {
                        return is_deleted;
                    }

                    public void setIs_deleted(String is_deleted) {
                        this.is_deleted = is_deleted;
                    }

                    public String getPid() {
                        return pid;
                    }

                    public void setPid(String pid) {
                        this.pid = pid;
                    }

                    public String getCert_status() {
                        return cert_status;
                    }

                    public void setCert_status(String cert_status) {
                        this.cert_status = cert_status;
                    }

                    public String getSource_lsc() {
                        return source_lsc;
                    }

                    public void setSource_lsc(String source_lsc) {
                        this.source_lsc = source_lsc;
                    }

                    public String getSource_lid() {
                        return source_lid;
                    }

                    public void setSource_lid(String source_lid) {
                        this.source_lid = source_lid;
                    }

                    public String getUpdate_time() {
                        return update_time;
                    }

                    public void setUpdate_time(String update_time) {
                        this.update_time = update_time;
                    }

                    public String getUser_subject_rel() {
                        return user_subject_rel;
                    }

                    public void setUser_subject_rel(String user_subject_rel) {
                        this.user_subject_rel = user_subject_rel;
                    }

                    public String getCredit_code() {
                        return credit_code;
                    }

                    public void setCredit_code(String credit_code) {
                        this.credit_code = credit_code;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class CorpBean {
                    /**
                     * id : 10000214
                     * org : 0
                     * mate : 0
                     * user : 151
                     * object_lsc : 0
                     * object_lid : 0
                     * lsc : 101
                     * lid : 1126848508118311424
                     * type : 4
                     * status : 1
                     * create_time : 1593410205
                     * audit : 151
                     * audit_time : 2020-07-07
                     * respond : 0
                     * favorite : 0
                     * is_deleted : 0
                     * pid : 0
                     * cert_status : 1
                     * source_lsc : 222210
                     * source_lid : 20321415
                     * update_time : 1594113198
                     * user_subject_rel : 160
                     * credit_code : 91330109MA28XDDW8D
                     * address : 浙江省杭州市萧山区萧山经济技术开发区宝龙城市中心3幢2414室
                     * name : 杭州宽朴投资管理有限公司
                     */

                    private String id;
                    private String org;
                    private String mate;
                    private String user;
                    private String object_lsc;
                    private String object_lid;
                    private String lsc;
                    private String lid;
                    private String type;
                    private String status;
                    private String create_time;
                    private String audit;
                    private String audit_time;
                    private String respond;
                    private String favorite;
                    private String is_deleted;
                    private String pid;
                    private String cert_status;
                    private String source_lsc;
                    private String source_lid;
                    private String update_time;
                    private String user_subject_rel;
                    private String credit_code;
                    private String address;
                    private String name;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getOrg() {
                        return org;
                    }

                    public void setOrg(String org) {
                        this.org = org;
                    }

                    public String getMate() {
                        return mate;
                    }

                    public void setMate(String mate) {
                        this.mate = mate;
                    }

                    public String getUser() {
                        return user;
                    }

                    public void setUser(String user) {
                        this.user = user;
                    }

                    public String getObject_lsc() {
                        return object_lsc;
                    }

                    public void setObject_lsc(String object_lsc) {
                        this.object_lsc = object_lsc;
                    }

                    public String getObject_lid() {
                        return object_lid;
                    }

                    public void setObject_lid(String object_lid) {
                        this.object_lid = object_lid;
                    }

                    public String getLsc() {
                        return lsc;
                    }

                    public void setLsc(String lsc) {
                        this.lsc = lsc;
                    }

                    public String getLid() {
                        return lid;
                    }

                    public void setLid(String lid) {
                        this.lid = lid;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getAudit() {
                        return audit;
                    }

                    public void setAudit(String audit) {
                        this.audit = audit;
                    }

                    public String getAudit_time() {
                        return audit_time;
                    }

                    public void setAudit_time(String audit_time) {
                        this.audit_time = audit_time;
                    }

                    public String getRespond() {
                        return respond;
                    }

                    public void setRespond(String respond) {
                        this.respond = respond;
                    }

                    public String getFavorite() {
                        return favorite;
                    }

                    public void setFavorite(String favorite) {
                        this.favorite = favorite;
                    }

                    public String getIs_deleted() {
                        return is_deleted;
                    }

                    public void setIs_deleted(String is_deleted) {
                        this.is_deleted = is_deleted;
                    }

                    public String getPid() {
                        return pid;
                    }

                    public void setPid(String pid) {
                        this.pid = pid;
                    }

                    public String getCert_status() {
                        return cert_status;
                    }

                    public void setCert_status(String cert_status) {
                        this.cert_status = cert_status;
                    }

                    public String getSource_lsc() {
                        return source_lsc;
                    }

                    public void setSource_lsc(String source_lsc) {
                        this.source_lsc = source_lsc;
                    }

                    public String getSource_lid() {
                        return source_lid;
                    }

                    public void setSource_lid(String source_lid) {
                        this.source_lid = source_lid;
                    }

                    public String getUpdate_time() {
                        return update_time;
                    }

                    public void setUpdate_time(String update_time) {
                        this.update_time = update_time;
                    }

                    public String getUser_subject_rel() {
                        return user_subject_rel;
                    }

                    public void setUser_subject_rel(String user_subject_rel) {
                        this.user_subject_rel = user_subject_rel;
                    }

                    public String getCredit_code() {
                        return credit_code;
                    }

                    public void setCredit_code(String credit_code) {
                        this.credit_code = credit_code;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }

            public static class BankBean {
                /**
                 * id : 2145
                 * name : 绿了
                 * sub_bank : 中国工商银行诸暨山下湖支行
                 * number : 6215581211000171916
                 * type_name : 普通
                 */

                private String id;
                private String name;
                private String sub_bank;
                private String number;
                private String type_name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSub_bank() {
                    return sub_bank;
                }

                public void setSub_bank(String sub_bank) {
                    this.sub_bank = sub_bank;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getType_name() {
                    return type_name;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
            }

            public static class AddressBean {
                /**
                 * id : 819
                 * address_type : 0
                 * complete : 北京市,市辖区,东城区,v个和好如初健健康康
                 */

                private String id;
                private String address_type;
                private String complete;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getAddress_type() {
                    return address_type;
                }

                public void setAddress_type(String address_type) {
                    this.address_type = address_type;
                }

                public String getComplete() {
                    return complete;
                }

                public void setComplete(String complete) {
                    this.complete = complete;
                }
            }
        }
    }
}
