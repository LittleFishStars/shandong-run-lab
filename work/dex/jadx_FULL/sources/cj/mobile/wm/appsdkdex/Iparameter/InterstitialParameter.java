package cj.mobile.wm.appsdkdex.Iparameter;

import cj.mobile.wm.common.Ibase.IBaseParameter;
import cj.mobile.wm.common.Ilistener.XAdInterstitialListener;
import cj.mobile.wm.common.bean.InterstialBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface InterstitialParameter extends IBaseParameter<InterstialBean> {
    XAdInterstitialListener getInterstitialistener();

    boolean isMuted();
}
