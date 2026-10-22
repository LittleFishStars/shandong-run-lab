package com.fl.saas.adx.oaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.fl.saas.adx.oaid.IGetter;
import com.fl.saas.adx.oaid.IOAID;
import com.fl.saas.adx.oaid.OAIDException;
import com.fl.saas.adx.oaid.OAIDLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class XiaomiImpl implements IOAID {
    private final Context context;
    private Class<?> idProviderClass;
    private Object idProviderImpl;

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.context = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.idProviderClass = cls;
            this.idProviderImpl = cls.newInstance();
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    private String getOAID() {
        return (String) this.idProviderClass.getMethod("getOAID", Context.class).invoke(this.idProviderImpl, this.context);
    }

    @Override // com.fl.saas.adx.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.idProviderClass == null || this.idProviderImpl == null) {
            iGetter.onOAIDGetError(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String oaid = getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            OAIDLog.print("OAID query success: " + oaid);
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // com.fl.saas.adx.oaid.IOAID
    public boolean supported() {
        return this.idProviderImpl != null;
    }
}
