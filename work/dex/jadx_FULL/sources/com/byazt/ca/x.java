package com.byazt.ca;

import com.byazt.lw.m;
import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 71})
public class x extends a {
    @Override // com.byazt.ca.a
    public int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar) {
        if (!com.byazt.to.c.uj(c(i, str))) {
            return cVar.c(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{c(i, str), c(i2, str)});
        if (com.byazt.zg.ve.c(str2) != null) {
            deque.push(new m(com.byazt.zg.ve.c(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(c(i, str));
        if (com.byazt.zg.ve.c(strValueOf) != null) {
            deque.push(new m(com.byazt.zg.ve.c(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
