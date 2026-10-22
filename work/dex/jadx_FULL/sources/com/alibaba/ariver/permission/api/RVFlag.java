package com.alibaba.ariver.permission.api;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVFlag {
    public static boolean hasShowLoading = false;
    public static boolean initUcNormal = true;
    public static boolean isInChane = true;
    public static boolean isUploadLog = true;
    public static long lastTouchTime = 0;
    public static boolean ucReady = false;
    public static HashMap<String, Boolean> sOpenAuthGrantFlag = new HashMap<>();
    public static Boolean sInjectDebugConsoleJS = Boolean.FALSE;
    public static Map<String, Long> eventTrackerStubMap = new ConcurrentHashMap();
    public static Map<String, Long> eventTrackerCostMap = new ConcurrentHashMap();

    public static synchronized boolean getOpenAuthGrantFlag(String str) {
        return sOpenAuthGrantFlag.containsKey(str) ? sOpenAuthGrantFlag.get(str).booleanValue() : false;
    }

    public static synchronized void setOpenAuthGrantFlag(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            sOpenAuthGrantFlag.put(str, Boolean.valueOf(z));
        }
    }
}
