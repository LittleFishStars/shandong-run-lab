package com.alibaba.ariver.kernel.api.track;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EventTrackerUtils {
    public static final String TAG = "EventTrackerUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Integer> f24228a = new ConcurrentHashMap();

    public static synchronized void clearTrackIdIndexDict() {
        RVLogger.d(TAG, "clearTrackIdIndexDict");
        f24228a.clear();
    }

    public static String getExtraAttrByJoinList(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        Map.Entry<String, Object> next = it.next();
        String str = "[" + next.getKey() + "=" + next.getValue();
        while (it.hasNext()) {
            Map.Entry<String, Object> next2 = it.next();
            str = str + "|" + next2.getKey() + "=" + next2.getValue();
        }
        String str2 = str + "]";
        RVLogger.d(TAG, "getExtraAttrByJoinList " + str2);
        return str2;
    }

    public static synchronized String getTrackerIdWithIndex(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, Integer> map = f24228a;
        if (!map.containsKey(str)) {
            map.put(str, 1);
            return str + "_1";
        }
        int iIntValue = map.get(str).intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return str + LoginConstants.UNDER_LINE + iIntValue;
    }

    public static synchronized String getTrackerIdWithIndex(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, Integer> map = f24228a;
        if (!map.containsKey(str)) {
            map.put(str, 1);
            return str + LoginConstants.UNDER_LINE + str2 + "_1";
        }
        int iIntValue = map.get(str).intValue() + 1;
        map.put(str, Integer.valueOf(iIntValue));
        return str + LoginConstants.UNDER_LINE + str2 + LoginConstants.UNDER_LINE + iIntValue;
    }
}
