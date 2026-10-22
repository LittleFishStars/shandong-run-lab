package cj.mobile.wm.appsdkdex.Iparameter;

import cj.mobile.wm.common.Ibase.IBaseParameter;
import cj.mobile.wm.common.Ilistener.XAdNativeExpressListener;
import cj.mobile.wm.common.bean.NativeExpressBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface INativeExpressParameter extends IBaseParameter<NativeExpressBean> {
    XAdNativeExpressListener getNativeExpressListener();

    boolean isMuted();
}
