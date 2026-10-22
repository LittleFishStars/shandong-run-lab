package com.byazt.cr;

import com.zj.adlib.tu3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1376, 15})
public final class uj extends c {
    public static final uj ve = new uj(tu3.h, "执行成功");
    public static final uj uj = new uj(7500001, "入参不符合预期");
    public static final uj n = new uj(7500008, "直播插件没有初始化成功");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uj f28376a = new uj(7500009, "直播插件通信bridge未设置");
    public static final uj sp = new uj(7500011, "直播插件通信bridge未设置");

    private uj(int i, String str) {
        this.c = i;
        this.tt = str;
    }
}
