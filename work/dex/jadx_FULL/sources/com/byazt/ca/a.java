package com.byazt.ca;

import java.util.Deque;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1793, 34})
public abstract class a {
    public char c(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    public abstract int c(String str, int i, Deque<com.byazt.dr.c> deque, com.byazt.pz.c cVar);

    public int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char c = c(i3, str);
            if (!com.byazt.to.c.tt(c) && !com.byazt.to.c.ve(c)) {
                return i3;
            }
            i2++;
        }
    }

    public int tt(int i, String str) {
        while (com.byazt.to.c.c(c(i, str))) {
            i++;
        }
        return i;
    }
}
