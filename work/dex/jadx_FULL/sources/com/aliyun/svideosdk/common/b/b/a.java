package com.aliyun.svideosdk.common.b.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f25627a;
    private static final List<String> b;

    static {
        ArrayList arrayList = new ArrayList();
        f25627a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        b = arrayList2;
        arrayList.add("HUAWEI P6-U06");
        arrayList2.add("M5s");
    }

    public static final boolean a(String str) {
        return b.contains(str);
    }
}
