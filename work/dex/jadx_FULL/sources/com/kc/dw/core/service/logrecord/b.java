package com.kc.dw.core.service.logrecord;

import android.text.TextUtils;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.utils.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {
    public static int a(BaseAdSlot baseAdSlot) {
        if (baseAdSlot == null) {
            return 1;
        }
        try {
            if (baseAdSlot.getImageUrls() != null && baseAdSlot.getImageUrls().length != 0 && !TextUtils.isEmpty(baseAdSlot.getImageUrls()[0])) {
                if (baseAdSlot.getImageUrls()[0].equals(baseAdSlot.getVideo_cover())) {
                    return 2;
                }
                return baseAdSlot.getImageUrls()[0].equals(baseAdSlot.getDefImage()) ? 3 : 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int a(BaseAdSlot baseAdSlot, SdkAdInfo sdkAdInfo, int i) {
        try {
            if (baseAdSlot != null) {
                if (i != Integer.MAX_VALUE) {
                    try {
                        return h.a(baseAdSlot.getAct_type(), i);
                    } catch (Exception unused) {
                    }
                }
                return baseAdSlot.getAct_type();
            }
            if (sdkAdInfo != null) {
                return sdkAdInfo.getAct_type();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String a(SdkAdInfo sdkAdInfo) {
        String fromId;
        if (sdkAdInfo == null) {
            return null;
        }
        try {
            try {
                fromId = "SSD".equals(sdkAdInfo.getSdk()) ? sdkAdInfo.getAppendInfo().getFromId() : sdkAdInfo.getAccept_id();
            } catch (Exception e) {
                e.printStackTrace();
                fromId = null;
            }
            if (!TextUtils.isEmpty(fromId)) {
                return fromId + System.identityHashCode(sdkAdInfo);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static boolean a(com.kc.dw.core.loader.b bVar, String... strArr) {
        LinkedHashMap<String, Long> eventTimes;
        try {
            if (strArr.length == 0) {
                return false;
            }
            try {
                eventTimes = bVar.getSdkAdInfo().getAppendInfo().getEventTimes(a(bVar.getSdkAdInfo()));
            } catch (Exception unused) {
                eventTimes = null;
            }
            if (eventTimes != null && !eventTimes.isEmpty()) {
                boolean z = false;
                for (String str : strArr) {
                    if (str != null) {
                        if (!eventTimes.containsKey(str)) {
                            return false;
                        }
                        z = true;
                    }
                }
                return z;
            }
        } catch (Exception unused2) {
        }
        return false;
    }
}
