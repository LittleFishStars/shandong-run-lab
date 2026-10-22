package com.fl.saas.s2s;

import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter;
import com.fl.saas.s2s.mixNative.S2SMixNativeHandler;
import com.fl.spi.SPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Advertiser(5)
@SPI({AdapterAPI.class})
public class S2SSplashAdapter extends InnerNativeSpreadAdapter {
    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    public MixNativeHandler loadNativeHandler() {
        return new S2SMixNativeHandler();
    }
}
