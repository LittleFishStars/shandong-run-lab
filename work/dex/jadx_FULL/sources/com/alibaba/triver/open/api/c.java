package com.alibaba.triver.open.api;

import com.igexin.assist.sdk.AssistPushConsts;
import com.kc.aw.lib.constants.AdConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25040a = "unknown status";
    public static final String b = "ERR_INVALID_REQUEST";
    public static final String c = "ERR_CONNECT_FAILED";
    private static Map<String, String> d;

    static {
        HashMap map = new HashMap();
        d = map;
        map.put("100", "Continue");
        d.put("101", "Switching Protocol");
        d.put("200", "OK");
        d.put("201", "Created");
        d.put("202", "Accepted");
        d.put("203", "Non-Authoritative Information");
        d.put("204", "No Content");
        d.put("205", "Reset Content");
        d.put("206", "Partial Content");
        d.put("300", "Multiple Choice");
        d.put(AdConstant.NATIVE_TYPE.TOP_TEXT, "Moved Permanently");
        d.put(AdConstant.NATIVE_TYPE.TOP_IMAGE, "Found");
        d.put(AdConstant.NATIVE_TYPE.TEXT_FLOAT, "See Other");
        d.put(AdConstant.NATIVE_TYPE.LEFT_IMAGE, "Not Modified");
        d.put(AdConstant.NATIVE_TYPE.LEFT_TEXT, "Use Proxy");
        d.put(AdConstant.NATIVE_TYPE.THREE_IMAGES, "unused");
        d.put("307", "Temporary Redirect");
        d.put("308", "Permanent Redirect");
        d.put("400", "Bad Request");
        d.put("401", "Unauthorized");
        d.put("402", "Payment Required");
        d.put("403", "Forbidden");
        d.put("404", "Not Found");
        d.put(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE, "Method Not Allowed");
        d.put("406", "Not Acceptable");
        d.put("407", "Proxy Authentication Required");
        d.put("408", "Request Timeout");
        d.put("409", "Conflict");
        d.put("410", "Gone");
        d.put("411", "Length Required");
        d.put("412", "Precondition Failed");
        d.put("413", "Payload Too Large");
        d.put("414", "URI Too Long");
        d.put("415", "Unsupported Media Type");
        d.put("416", "Requested Range Not Satisfiable");
        d.put("417", "Expectation Failed");
        d.put("418", "I'm a teapot");
        d.put("421", "Misdirected Request");
        d.put("426", "Upgrade Required");
        d.put("428", "Precondition Required");
        d.put("429", "Too Many Requests");
        d.put("431", "Request Header Fields Too Large");
        d.put("500", "Internal Server Error");
        d.put("501", "Not Implemented");
        d.put("502", "Bad Gateway");
        d.put("503", "Service Unavailable");
        d.put("504", "Gateway Timeout");
        d.put("505", "HTTP Version Not Supported");
        d.put("506", "Variant Also Negotiates");
        d.put("507", "Variant Also Negotiates");
        d.put("511", "Network Authentication Required");
    }

    public static String a(String str) {
        return !d.containsKey(str) ? f25040a : d.get(str);
    }
}
