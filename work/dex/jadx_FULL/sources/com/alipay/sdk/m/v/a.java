package com.alipay.sdk.m.v;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum a {
    None("none"),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit"),
    LocalWebPay("js://localWebPay");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25515a;

    a(String str) {
        this.f25515a = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        for (a aVar2 : values()) {
            if (str.startsWith(aVar2.f25515a)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
