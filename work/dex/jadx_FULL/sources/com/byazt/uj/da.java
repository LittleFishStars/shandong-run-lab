package com.byazt.uj;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.byazt.nr.m;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 72})
public class da extends ve {
    public da(com.byazt.wn.tt ttVar, Function<SparseArray<Object>, Object> function) {
        super(ttVar, function);
    }

    public void showAd(ViewGroup viewGroup) {
        com.byazt.wn.tt ttVar = ((ve) this).x;
        if (ttVar != null) {
            ttVar.mediationCallShow();
        }
        if (((ve) this).i != null) {
            ((ve) this).i.apply(com.byazt.yxi.uj.c().c(6152).c(20060, viewGroup).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void showSplashAd(ViewGroup viewGroup) {
        try {
            showAd(viewGroup);
        } catch (Exception e) {
            m.c(e);
        }
    }
}
