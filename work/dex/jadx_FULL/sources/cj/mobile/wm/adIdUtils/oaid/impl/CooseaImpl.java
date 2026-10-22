package cj.mobile.wm.adIdUtils.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CooseaImpl extends IOAID {
    public final Context context;
    public final KeyguardManager keyguardManager;

    public CooseaImpl(Context context) {
        this.context = context;
        this.keyguardManager = (KeyguardManager) context.getSystemService(dexc.dexa("lfzhvbse"));
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.keyguardManager;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new OAIDException(dexc.dexa("DpptfbJnqm!LfzhvbseNbobhfs!opu!gpvoe")));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod(dexc.dexa("pcubjoPbje"), new Class[0]).invoke(this.keyguardManager, new Object[0]);
            if (objInvoke == null) {
                throw new OAIDException(dexc.dexa("DpptfbJnqm!pbje!rvfsz!gbjmfe"));
            }
            String string = objInvoke.toString();
            OAIDLog.print(dexc.dexa("DpptfbJnqm!pbje!rvfsz-") + string);
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public boolean supported() {
        KeyguardManager keyguardManager;
        if (this.context == null || (keyguardManager = this.keyguardManager) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod(dexc.dexa("jtTvqqpsufe"), new Class[0]).invoke(this.keyguardManager, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("DpptfbJnqm!difdl!tvqqpsufe!gbjm-") + th);
            return false;
        }
    }
}
