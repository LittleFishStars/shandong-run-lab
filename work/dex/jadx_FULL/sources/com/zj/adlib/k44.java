package com.zj.adlib;

import com.netease.nimlib.sdk.NIMClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class k44 {
    public static <T> T a(Class<T> cls) {
        try {
            return (T) NIMClient.getService(cls);
        } catch (Exception e) {
            i4a.c(e.getMessage());
            return null;
        }
    }
}
