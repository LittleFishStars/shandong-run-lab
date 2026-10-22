package cn.hzjizhun.admin.ad.adapter;

import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.kdsksdda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AdapterAdLoader<T extends kdsksdda> {
    void loadAdObject(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback);

    void onPaused();

    void onResumed();

    void release();

    void setAd(T t);

    void shakeClick();

    void showAdObject();
}
