package com.seven.sugar.home.model.bean;

import java.util.List;

/**
 * Created by Seven on 2017/4/3.
 */

public class ChengYu {

    /**
     * reason : success
     * result : {"bushou":"禾","head":"积","pinyin":"jī shǎo chéng duō","chengyujs":" 积累少量的东西，能成为巨大的数量。","from_":" 《战国策·秦策四》：\u201c积薄而为厚，聚少而为多。\u201d《汉书·董仲舒传》：\u201c聚少成多，积小致巨。\u201d","example":" 其实一个人做一把刀、一个勺子是有限得很，然而～，这笔账就难算了，何况更是历年如此呢。 《二十年目睹之怪现状》第二十九回","yufa":" 连动式；作谓语、宾语、分句；用于事物的逐渐聚积","ciyujs":"[many a little makes a mickle;from small increments comes abundance;little will grow to much;penny and penny laid up will be many] 积累少数而渐成多数","yinzhengjs":"谓只要不断积累，就会从少变多。语出《汉书·董仲舒传》：\u201c众少成多，积小致鉅。\u201d 唐 李商隐 《杂纂》：\u201c积少成多。\u201d 宋 苏轼 《论纲梢欠折利害状》：\u201c押纲纲梢，既与客旅附载物货，官不点检，专栏无由乞取；然梢工自须赴务量纳税钱，以防告訐，积少成多，所获未必减於今日。\u201d 清 薛福成 《陈派拨兵船保护华民片》：\u201c惟海军船数不多，经费不裕，势难分拨，兵轮久驻海外， 华 民集貲，积少成多，未尝不愿供给船费。\u201d 包天笑 《钏影楼回忆录·入泮》：\u201c这项赏封，不过数十文而已，然积少成多，亦可以百计。\u201d","tongyi":["集腋成裘","聚沙成塔","日积月累","积水成渊"],"fanyi":["杯水车薪"]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * bushou : 禾
         * head : 积
         * pinyin : jī shǎo chéng duō
         * chengyujs :  积累少量的东西，能成为巨大的数量。
         * from_ :  《战国策·秦策四》：“积薄而为厚，聚少而为多。”《汉书·董仲舒传》：“聚少成多，积小致巨。”
         * example :  其实一个人做一把刀、一个勺子是有限得很，然而～，这笔账就难算了，何况更是历年如此呢。 《二十年目睹之怪现状》第二十九回
         * yufa :  连动式；作谓语、宾语、分句；用于事物的逐渐聚积
         * ciyujs : [many a little makes a mickle;from small increments comes abundance;little will grow to much;penny and penny laid up will be many] 积累少数而渐成多数
         * yinzhengjs : 谓只要不断积累，就会从少变多。语出《汉书·董仲舒传》：“众少成多，积小致鉅。” 唐 李商隐 《杂纂》：“积少成多。” 宋 苏轼 《论纲梢欠折利害状》：“押纲纲梢，既与客旅附载物货，官不点检，专栏无由乞取；然梢工自须赴务量纳税钱，以防告訐，积少成多，所获未必减於今日。” 清 薛福成 《陈派拨兵船保护华民片》：“惟海军船数不多，经费不裕，势难分拨，兵轮久驻海外， 华 民集貲，积少成多，未尝不愿供给船费。” 包天笑 《钏影楼回忆录·入泮》：“这项赏封，不过数十文而已，然积少成多，亦可以百计。”
         * tongyi : ["集腋成裘","聚沙成塔","日积月累","积水成渊"]
         * fanyi : ["杯水车薪"]
         */

        private String bushou;
        private String head;
        private String pinyin;
        private String chengyujs;
        private String from_;
        private String example;
        private String yufa;
        private String ciyujs;
        private String yinzhengjs;
        private List<String> tongyi;
        private List<String> fanyi;

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getChengyujs() {
            return chengyujs;
        }

        public void setChengyujs(String chengyujs) {
            this.chengyujs = chengyujs;
        }

        public String getFrom_() {
            return from_;
        }

        public void setFrom_(String from_) {
            this.from_ = from_;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getYufa() {
            return yufa;
        }

        public void setYufa(String yufa) {
            this.yufa = yufa;
        }

        public String getCiyujs() {
            return ciyujs;
        }

        public void setCiyujs(String ciyujs) {
            this.ciyujs = ciyujs;
        }

        public String getYinzhengjs() {
            return yinzhengjs;
        }

        public void setYinzhengjs(String yinzhengjs) {
            this.yinzhengjs = yinzhengjs;
        }

        public List<String> getTongyi() {
            return tongyi;
        }

        public void setTongyi(List<String> tongyi) {
            this.tongyi = tongyi;
        }

        public List<String> getFanyi() {
            return fanyi;
        }

        public void setFanyi(List<String> fanyi) {
            this.fanyi = fanyi;
        }
    }
}
