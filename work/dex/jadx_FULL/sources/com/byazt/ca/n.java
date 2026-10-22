package com.byazt.ca;

import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 46})
public class n extends a {
    @Override // com.byazt.ca.a
    public int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar) {
        char c;
        int i2 = i;
        while (true) {
            c = c(i2, str);
            if (!com.byazt.to.c.tt(c) && !com.byazt.to.c.ve(c)) {
                break;
            }
            i2++;
        }
        if (c != '(') {
            return cVar.c(str, i, deque);
        }
        deque.push(new com.byazt.lw.da(str.substring(i, i2)));
        return i2 + 1;
    }
}
