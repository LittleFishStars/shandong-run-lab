package cj.mobile.wm.adIdUtils.oaid.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class XiaomiImpl extends IOAID {
    public final String CLASS_NAME = dexc.dexa("dpn/boespje/je/jnqm/JeQspwjefsJnqm");
    public final Context context;
    public Class<?> idProviderClass;
    public Object idProviderImpl;

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.context = context;
        try {
            Class<?> cls = Class.forName(dexc.dexa("dpn/boespje/je/jnqm/JeQspwjefsJnqm"));
            this.idProviderClass = cls;
            this.idProviderImpl = cls.newInstance();
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("YjbpnjJnqm!difdl!tvqqpsufe!gbjm-") + th);
        }
    }

    private String getOAID() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.idProviderClass.getMethod(dexc.dexa("hfuPBJE"), Context.class).invoke(this.idProviderImpl, this.context);
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (this.idProviderClass == null || this.idProviderImpl == null) {
            iGetter.onOAIDGetError(new OAIDException(dexc.dexa("YjbpnjJnqm!JeQspwjefs!opu!fyjtut")));
            return;
        }
        try {
            String oaid = getOAID();
            if (TextUtils.isEmpty(oaid)) {
                throw new OAIDException(dexc.dexa("YjbpnjJnqm!pbje!rvfsz!gbjm-pbje!jt!ovmm"));
            }
            OAIDLog.print(dexc.dexa("YjbpnjJnqm!pbje!rvfsz!tvddftt-pbje>") + oaid);
            iGetter.onOAIDGetComplete(oaid);
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public boolean supported() {
        return this.idProviderImpl != null;
    }
}
