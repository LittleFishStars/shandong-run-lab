package com.alibaba.alibclinkpartner.smartlink.util;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLConfigConstants;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static String a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            ALSLLogUtil.e("ALPConfigChecker", "getCheckString", "str to json error,errorMsg = " + e.toString());
            return "";
        }
    }

    private static String a(JSONArray jSONArray) throws JSONException {
        StringBuilder sb;
        String strA;
        String string = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof String) {
                sb = new StringBuilder();
                sb.append(string);
                sb.append(obj);
            } else {
                if (obj instanceof JSONObject) {
                    sb = new StringBuilder();
                    sb.append(string);
                    strA = a((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    sb = new StringBuilder();
                    sb.append(string);
                    strA = a((JSONArray) obj);
                } else {
                    sb = new StringBuilder();
                    sb.append(string);
                    sb.append(obj);
                    sb.append("");
                }
                sb.append(strA);
            }
            string = sb.toString();
        }
        return string;
    }

    private static String a(JSONObject jSONObject) throws JSONException {
        StringBuilder sb;
        String strA;
        Iterator<String> itKeys = jSONObject.keys();
        String string = "";
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!next.equals(UserTrackConstant.SIGN)) {
                String str = string + next;
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    sb = new StringBuilder();
                    sb.append(str);
                    strA = a((JSONObject) obj);
                } else {
                    if (obj instanceof String) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append((String) obj);
                    } else if (obj instanceof JSONArray) {
                        sb = new StringBuilder();
                        sb.append(str);
                        strA = a((JSONArray) obj);
                    } else {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append(obj);
                        sb.append("");
                    }
                    string = sb.toString();
                }
                sb.append(strA);
                string = sb.toString();
            }
        }
        return string;
    }

    public static boolean a(String str, String str2) {
        if (str == null) {
            return false;
        }
        return TextUtils.isEmpty(str2) || TextUtils.equals(b(str), str2);
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(a(str));
        try {
            sb.append(ALSLConfigConstants.MD5_SALT);
            char[] charArray = sb.toString().toCharArray();
            Arrays.sort(charArray);
            return d.a(new String(charArray).getBytes("UTF-8"));
        } catch (Exception e) {
            ALSLLogUtil.e("ALPConfigChecker", "getMd5Sign", "UnsupportedEncodingException e = " + e.toString());
            return "";
        }
    }
}
