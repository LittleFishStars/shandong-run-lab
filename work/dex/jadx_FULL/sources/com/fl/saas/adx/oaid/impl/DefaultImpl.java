package com.fl.saas.adx.oaid.impl;

import com.fl.saas.adx.oaid.IGetter;
import com.fl.saas.adx.oaid.IOAID;
import com.fl.saas.adx.oaid.OAIDException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class DefaultImpl implements IOAID {
    @Override // com.fl.saas.adx.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.onOAIDGetError(new OAIDException("Unsupported"));
    }

    @Override // com.fl.saas.adx.oaid.IOAID
    public boolean supported() {
        return false;
    }
}
