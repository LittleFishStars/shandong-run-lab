package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private static List<String> bfb = null;
    private static List<String> bfc = null;
    private static int bfd = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        bfb = new ArrayList();
        List<String> list = aVar.bfo;
        if (list == null || list.isEmpty()) {
            bfb.add("com.kwad");
            bfb.add("com.kwai");
            bfb.add("com.ksad");
            bfb.add("tkruntime");
            bfb.add("tachikoma");
            bfb.add("kuaishou");
        } else {
            bfb.addAll(aVar.bfo);
        }
        bfd = aVar.bft;
        bfc = new ArrayList();
        List<String> list2 = aVar.bfn;
        if (list2 != null && !list2.isEmpty()) {
            bfc.addAll(aVar.bfn);
            return;
        }
        bfc.add("android.");
        bfc.add("androidx.");
        bfc.add("org.");
        bfc.add("java.");
    }

    private static boolean gu(String str) {
        List<String> list = bfc;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean gv(String str) {
        List<String> list = bfb;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String gw(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        com.kwad.sdk.core.d.c.d("perfMonitor.Filter", "stacks after split:" + strArrSplit.length);
        boolean z = false;
        int i = 0;
        for (String str2 : strArrSplit) {
            if (z || !gu(str2)) {
                if (i >= bfd) {
                    return "";
                }
                if (gv(str2)) {
                    return str;
                }
                i++;
                z = true;
            }
        }
        return "";
    }
}
