package com.kc.bw.common.Ilistener;

import com.kc.bw.common.Ibase.XAdBaseListener;
import com.kc.bw.common.nativepot.NativeWMResponse;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface XAdNativePotListener extends XAdBaseListener {
    void onNativePresent(NativeWMResponse nativeWMResponse);
}
