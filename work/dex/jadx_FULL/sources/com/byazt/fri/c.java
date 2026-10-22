package com.byazt.fri;

import com.byazt.omf.rl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2129, 20})
public class c {
    public final String c;
    public final List<String> tt = new ArrayList();

    public c(String str) {
        this.c = str;
    }

    public static void c(String str, String str2) {
        c cVar = (c) rl.c(str, c.class);
        if (cVar != null) {
            cVar.c(str2);
            return;
        }
        c cVar2 = new c(str);
        cVar2.c(str2);
        rl.c(str, cVar2, c.class);
    }

    public void c(String str) {
        this.tt.add(str);
    }
}
