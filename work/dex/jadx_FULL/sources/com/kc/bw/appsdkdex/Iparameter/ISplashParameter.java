package com.kc.bw.appsdkdex.Iparameter;

import com.kc.bw.common.Ibase.IBaseParameter;
import com.kc.bw.common.Ilistener.XAdSplashListener;
import com.kc.bw.common.bean.SplashBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface ISplashParameter extends IBaseParameter<SplashBean> {
    int getCountDownDuration();

    XAdSplashListener getSplashListener();
}
