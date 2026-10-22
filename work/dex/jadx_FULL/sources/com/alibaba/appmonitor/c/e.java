package com.alibaba.appmonitor.c;

import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@com.alibaba.analytics.core.b.a.c("ap_stat")
public class e extends a {

    @com.alibaba.analytics.core.b.a.a("detail")
    public int U;

    private boolean b(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return A();
        }
        String strRemove = arrayList.remove(0);
        return h(strRemove) ? ((e) b(strRemove)).b(arrayList) : A();
    }

    public boolean A() {
        return this.U == 1;
    }

    public boolean g(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return b(arrayList);
    }
}
