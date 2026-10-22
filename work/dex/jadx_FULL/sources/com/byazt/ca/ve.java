package com.byazt.ca;

import com.byazt.lw.qy;
import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 54})
public class ve extends a {
    @Override // com.byazt.ca.a
    public int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar) {
        char c = c(i, str);
        return (com.byazt.to.c.tt(c) || c == '$') ? c(str, i, deque) : cVar.c(str, i, deque);
    }

    private int c(String str, int i, Deque<com.byazt.dr.c> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char c = c(i2, str);
            if (!com.byazt.to.c.tt(c) && !com.byazt.to.c.ve(c) && '.' != c && '[' != c && ']' != c && '_' != c && '$' != c) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.byazt.zg.c.c(strSubstring) != null) {
            deque.push(new com.byazt.lw.sp(strSubstring));
        } else {
            deque.push(new qy(strSubstring));
        }
        return i2;
    }
}
