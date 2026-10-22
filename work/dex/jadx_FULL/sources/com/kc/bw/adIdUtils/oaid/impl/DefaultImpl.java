package com.kc.bw.adIdUtils.oaid.impl;

import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DefaultImpl implements IOAID {
    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.onOAIDGetError(new OAIDException(dexg.dexa("EfgbvmuJnqm!Votvqqpsufe")));
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        return false;
    }
}
