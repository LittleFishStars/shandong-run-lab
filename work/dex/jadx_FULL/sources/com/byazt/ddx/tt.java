package com.byazt.ddx;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 13})
public class tt implements com.byazt.whk.tt {
    public static tt c;

    private tt() {
    }

    public static synchronized tt c() {
        if (c == null) {
            c = new tt();
        }
        return c;
    }

    @Override // com.byazt.whk.tt
    public String c(String str, String str2) {
        return "";
    }

    @Override // com.byazt.whk.tt
    public void c(String str, String str2, String str3) {
    }

    @Override // com.byazt.whk.tt
    public String tt() {
        return "AdEventCollector";
    }
}
