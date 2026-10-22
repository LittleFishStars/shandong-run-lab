package com.fl.saas.adx.base.innterNative;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ActionView {

    public enum Type {
        Spread,
        Interstitial,
        Template,
        Banner
    }

    View bindActionView(Type type);
}
