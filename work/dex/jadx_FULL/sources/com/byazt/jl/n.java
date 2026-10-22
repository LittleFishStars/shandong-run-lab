package com.byazt.jl;

import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28699a;
    public int n;
    public int sp;
    public int uj;

    public static int c(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    public void c(com.byazt.on.c cVar) throws IOException {
    }

    public void tt(com.byazt.on.c cVar) throws IOException {
        int iUj = cVar.uj();
        c(cVar);
        int iUj2 = iUj - cVar.uj();
        int i = this.uj;
        if (iUj2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iUj2 < i) {
            cVar.c(i - iUj2);
        }
    }
}
