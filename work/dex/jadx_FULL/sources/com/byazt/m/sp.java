package com.byazt.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 130, 91})
public class sp extends BaseException {
    public sp(int i, String str) {
        super(i, str);
    }

    public sp c(String str) {
        setExtraInfo(str);
        return this;
    }

    public String c() {
        return getExtraInfo();
    }
}
