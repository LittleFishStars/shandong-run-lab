package com.byazt.ca;

import com.byazt.lw.z;
import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 91})
public class sp extends a {
    private boolean c(String str, int i, Deque<com.byazt.dr.c> deque) {
        if ('-' != c(i, str)) {
            return com.byazt.to.c.ve(c(i, str));
        }
        if (deque.peek() != null && !com.byazt.zg.ve.c(deque.peek().c())) {
            return false;
        }
        if (com.byazt.to.c.ve(c(i + 1, str))) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
    }

    @Override // com.byazt.ca.a
    public int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar) {
        char c;
        if (!c(str, i, deque)) {
            return cVar.c(str, i, deque);
        }
        int i2 = c(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            c = c(i2, str);
            if (!com.byazt.to.c.ve(c) && (z || c != '.')) {
                break;
            }
            i2++;
            if (c == '.') {
                z = true;
            }
        }
        if (c != '.') {
            deque.push(new z(str.substring(i, i2)));
            return i2;
        }
        throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
    }
}
