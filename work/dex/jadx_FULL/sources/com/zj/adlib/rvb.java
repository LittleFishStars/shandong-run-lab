package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class rvb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static rvb f44553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f19444a;
    public float b;

    public static rvb a() {
        if (f44553a == null) {
            synchronized (rvb.class) {
                if (f44553a == null) {
                    f44553a = new rvb();
                }
            }
        }
        return f44553a;
    }
}
