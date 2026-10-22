package com.byazt.ca;

import com.byazt.lw.rl;
import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 20})
public class c extends a {
    @Override // com.byazt.ca.a
    public int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar) {
        if (',' != c(i, str)) {
            return cVar.c(str, i, deque);
        }
        deque.push(new rl(com.byazt.zg.uj.COMMA));
        return i + 1;
    }
}
