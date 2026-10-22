package com.kc.aw;

import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alipay.sdk.m.p.a;
import com.aliyun.openapiutil.Client;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.u15;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _l9 {
    public static final AtomicBoolean _a = new AtomicBoolean(false);
    public static final AtomicBoolean _b = new AtomicBoolean(false);

    public static String _a(String str, LinkedHashMap linkedHashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (!linkedHashMap.isEmpty()) {
            String str2 = str.contains("?") ? str.endsWith("?") ? "" : "&" : "?";
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                sb.append(str2);
                sb.append(com.kc.aw.lib.utils._a._b((String) entry.getKey()));
                sb.append(a.h);
                sb.append(com.kc.aw.lib.utils._a._b((String) entry.getValue()));
                str2 = "&";
            }
        }
        return sb.toString();
    }

    public static LinkedHashMap _a(AdSlot adSlot, String str, int i) {
        String str2 = PtgAdSdk.getConfig()._h;
        String str3 = PtgAdSdk.getConfig()._a;
        String ptgSlotID = adSlot.getPtgSlotID();
        String userID = adSlot.getUserID();
        String reqId = adSlot.getReqId();
        String mediaExtra = adSlot.getMediaExtra();
        String string = str2 + u15.f19942b + reqId;
        try {
            byte[] bArrDigest = MessageDigest.getInstance(Client.HASH_SHA256).digest(string.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            string = sb.toString();
        } catch (Exception unused) {
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(_lb._a("1"), userID);
        linkedHashMap.put(_lb._a("2"), reqId);
        linkedHashMap.put(_lb._a("3"), str);
        linkedHashMap.put(_lb._a("4"), String.valueOf(i));
        linkedHashMap.put(_lb._a("5"), mediaExtra);
        linkedHashMap.put(_lb._a("6"), string);
        linkedHashMap.put(_lb._a("7"), str3);
        linkedHashMap.put(_lb._a(PrepareException.ERROR_AUTH_FAIL), ptgSlotID);
        return linkedHashMap;
    }
}
