package com.alibaba.ariver.kernel.common.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVTracePhase {
    public static int cookieSeed = 500;
    public int cookie;
    public String phaseName;

    public RVTracePhase(String str) {
        this.phaseName = str;
        int i = cookieSeed;
        cookieSeed = i + 1;
        this.cookie = i;
    }
}
