package com.seven.sugar.base;

/**
 * Created by Seven on 2017/4/3.
 */
public class BaseApi {

    public static final int HOST_FORMAL = 1;//正式环境
    public static final int HOST_DEV = 2;//开发环境
    public static int HOST_NOW;//当前环境

    /**
     * 聚合数据
     */
    public static String JU_HE_URL = "";

    /**
     * environment: 1，正式环境 2，开发环境
     */
    public static void init(int environment) {
        switch (environment) {
            case HOST_FORMAL:
                JU_HE_URL = "http://v.juhe.cn/";
                break;
            case HOST_DEV:
                JU_HE_URL = "http://v.juhe.cn/";
                break;
            default:
                break;
        }
    }

    public static boolean isDebug() {
        return HOST_NOW == HOST_DEV;
    }

    /**
     * 所有的相对URL
     */
    public static class Url {
        /**
         * 成语词典
         */
        public static final String URL_CHENG_YU_QUERY = "chengyu/query";

    }


}
