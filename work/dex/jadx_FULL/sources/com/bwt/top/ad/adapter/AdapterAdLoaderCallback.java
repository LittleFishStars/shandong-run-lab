package com.bwt.top.ad.adapter;

import com.bwt.top.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface AdapterAdLoaderCallback {
    void onLoadAdObjectFailed(PosInfoBean posInfoBean);

    void onLoadAdObjectSucceed(PosInfoBean posInfoBean);
}
