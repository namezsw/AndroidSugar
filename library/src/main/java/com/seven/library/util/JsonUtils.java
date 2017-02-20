package com.seven.library.util;

import android.text.TextUtils;

/**
 * Json工具类
 * Created by Seven on 2017/2/15.
 */
public final class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();

    /**
     * 判断json类型
     *
     * @param json json
     * @return json类型
     */
    public static JsonType getJSONType(String json) {
        if (TextUtils.isEmpty(json))
            return JsonType.JSON_TYPE_ERROR;
        final char[] strChar = json.substring(0, 1).toCharArray();
        final char firstChar = strChar[0];
        switch (firstChar) {
            case '{':
                return JsonType.JSON_TYPE_OBJECT;
            case '[':
                return JsonType.JSON_TYPE_ARRAY;
            default:
                return JsonType.JSON_TYPE_ERROR;
        }
    }

    /**
     * json类型枚举
     */
    public enum JsonType {
        JSON_TYPE_OBJECT,//JSONObject
        JSON_TYPE_ARRAY,//JSONArray
        JSON_TYPE_ERROR//不是JSON格式的字符串
    }

}
