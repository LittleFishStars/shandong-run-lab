package com.fl.saas.base.custom.nativead;

import com.fl.saas.common.pojo.YdNativePojo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CustomNativeData extends YdNativePojo {

    public interface CustomNativeEventListener {
        void onNativeAdClicked(int i);

        void onNativeAdShow(int i);
    }
}
