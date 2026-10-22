package cj.mobile.wm.appsdkdex.Iparameter;

import cj.mobile.wm.common.Ibase.IBaseParameter;
import cj.mobile.wm.common.Ilistener.XAdSplashListener;
import cj.mobile.wm.common.bean.SplashBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ISplashParameter extends IBaseParameter<SplashBean> {
    int getCountDownDuration();

    XAdSplashListener getSplashListener();

    boolean isMuted();
}
