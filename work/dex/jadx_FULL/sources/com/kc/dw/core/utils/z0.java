package com.kc.dw.core.utils;

import com.kc.dw.core.ad.BaseAdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class z0 {
    public static String a(int i, int i2, int i3, String str) {
        return "{\"rewardType\":" + i + ",\"rewardCompleteType\":" + i2 + ",\"rewardTempId\":" + i3 + ",\"msg\":\"" + str + "\"}";
    }

    public static String a(int i, String str) {
        return "{\"rewardType\":" + i + ",\"msg\":\"" + str + "\"}";
    }

    public static void a(BaseAdSlot baseAdSlot, int i) {
        a(baseAdSlot, i, 0, "");
    }

    public static void a(BaseAdSlot baseAdSlot, int i, int i2, String str) {
        try {
            s1.a(baseAdSlot.getEventUrl(), i, i2, i != 17 ? a(3, str) : a(3, 0, 0, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
