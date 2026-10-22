package com.kc.bw.adIdUtils.oaid.impl;

import android.content.Context;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class XiaomiImpl implements IOAID {
    public final Context context;
    public Class<?> idProviderClass;
    public Object idProviderImpl;

    public XiaomiImpl(Context context) {
        this.context = context;
        try {
            Class<?> cls = Class.forName(dexg.dexa("dpn/boespje/je/jnqm/JeQspwjefsJnqm"));
            this.idProviderClass = cls;
            this.idProviderImpl = cls.newInstance();
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("YjbpnjJnqm!tvqqpsufe!gbjm!") + th);
        }
    }

    private String getOAID() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.idProviderClass.getMethod(dexg.dexa("hfuPBJE"), Context.class).invoke(this.idProviderImpl, this.context);
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.idProviderClass == null || this.idProviderImpl == null) {
            iGetter.onOAIDGetError(new OAIDException(dexg.dexa("Yjbpnj!JeQspwjefs!opu!fyjtut")));
            return;
        }
        try {
            String oaid = getOAID();
            if (oaid == null || oaid.length() == 0) {
                throw new OAIDException(dexg.dexa("PBJE!rvfsz!gbjmfe"));
            }
            OAIDLog.print(dexg.dexa("PBJE!rvfsz!tvddftt;!") + oaid);
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        return this.idProviderImpl != null;
    }
}
