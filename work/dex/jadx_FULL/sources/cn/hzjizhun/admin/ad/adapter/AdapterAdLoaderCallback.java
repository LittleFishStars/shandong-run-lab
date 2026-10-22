package cn.hzjizhun.admin.ad.adapter;

import cn.hzjizhun.admin.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AdapterAdLoaderCallback {
    void onLoadAdObjectFailed(PosInfoBean posInfoBean);

    void onLoadAdObjectSucceed(PosInfoBean posInfoBean);
}
