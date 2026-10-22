package com.byazt.uj;

import android.app.Activity;
import com.byazt.nr.m;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 91})
public class sp extends ve {
    public sp(com.byazt.wn.tt ttVar, Function function) {
        super(ttVar, function);
    }

    @Override // com.byazt.yl.ve
    public void showAd(Activity activity, Object obj, String str) {
        try {
            showAd(activity);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void showAd(Activity activity) {
        com.byazt.wn.tt ttVar = ((ve) this).x;
        if (ttVar != null) {
            ttVar.mediationCallShow();
        }
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(8113).c(20033, activity).c(Void.class).tt());
        }
    }
}
