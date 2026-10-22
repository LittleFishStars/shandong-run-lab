package com.byazt.vgp;

import android.content.Context;
import com.byazt.el.SSWebView;
import com.byazt.zb.x;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1713, 54})
public class ve {
    public x c;
    public com.byazt.zb.c tt;

    public x c(Context context, SSWebView sSWebView, com.byazt.zb.ve veVar, com.byazt.zb.c cVar, Set<String> set, x.c cVar2) {
        if (this.c == null) {
            x xVarC = x.c(context, sSWebView, veVar, cVar, set, cVar2, true);
            this.c = xVarC;
            xVarC.uj(false);
        }
        this.tt = cVar;
        return this.c;
    }
}
