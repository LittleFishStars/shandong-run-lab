package com.kc.bw.appsdkdex.Iparameter;

import com.kc.bw.common.Ibase.IBaseParameter;
import com.kc.bw.common.Ilistener.XAdNativeExpressListener;
import com.kc.bw.common.bean.NativeExpressBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface INativeExpressParameter extends IBaseParameter<NativeExpressBean> {
    XAdNativeExpressListener getNativeExpressListener();
}
