package com.fl.saas.adx.base.interfaces;

import android.app.Activity;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface SpreadLoadListener {

    public interface SpreadAd extends AdMaterial {
        int getEcpm();

        boolean isAdReady();

        void show(Activity activity, ViewGroup viewGroup);

        void show(ViewGroup viewGroup);
    }

    void onADLoaded(SpreadAd spreadAd);
}
