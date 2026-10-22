package com.kc.aw;

import com.kc.aw.lib.interf.Error;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ns implements Error {
    public static final _ns _a = new _ns();

    @Override // com.kc.aw.lib.interf.Error
    public final void onError(AdError adError) {
        Logger.e(adError.getMessage());
    }
}
