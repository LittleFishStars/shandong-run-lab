package com.byazt.ds;

import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 13})
public class tt {
    public static final LinkedList<com.byazt.tv.c> c = new LinkedList<>();
    public static final LinkedList<com.byazt.tv.c> tt = new LinkedList<>();

    public static void c(com.byazt.tv.c cVar) {
        LinkedList<com.byazt.tv.c> linkedList = c;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                com.byazt.tv.c cVarPoll = linkedList.poll();
                com.byazt.yv.da.tt("drop event in cache", null);
                tt.add(cVarPoll);
            }
            linkedList.add(cVar);
        }
    }

    public static void c() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<com.byazt.tv.c> linkedList3 = c;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<com.byazt.tv.c> linkedList4 = tt;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            com.byazt.lu.uj.c((com.byazt.tv.c) linkedList.poll());
        }
    }
}
