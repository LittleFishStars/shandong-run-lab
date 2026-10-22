package com.byazt.ca;

import com.byazt.lw.gt;
import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 13})
public class tt extends a {
    @Override // com.byazt.ca.a
    public int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar) {
        if ('\'' != c(i, str)) {
            return cVar.c(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && c(i3, str) != '\'') {
            i3++;
        }
        if (c(i3, str) != '\'') {
            throw new com.byazt.hh.c("String expression not surrounded by '", str.substring(i2 - 1));
        }
        deque.push(new gt(str.substring(i2, i3)));
        return i3 + 1;
    }
}
