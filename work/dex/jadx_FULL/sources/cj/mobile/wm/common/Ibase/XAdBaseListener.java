package cj.mobile.wm.common.Ibase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface XAdBaseListener {
    void onAdDownloadFail(String str);

    void onAdDownloadSuccess();

    void onAdRequest();

    void onClick();

    void onExposure();

    void onNoAd(String str);
}
