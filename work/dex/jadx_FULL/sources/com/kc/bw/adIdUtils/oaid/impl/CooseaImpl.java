package com.kc.bw.adIdUtils.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CooseaImpl implements IOAID {
    public final Context context;
    public final KeyguardManager keyguardManager;

    public CooseaImpl(Context context) {
        this.context = context;
        this.keyguardManager = (KeyguardManager) context.getSystemService(dexg.dexa("lfzhvbse"));
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.keyguardManager;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new OAIDException(dexg.dexa("LfzhvbseNbobhfs!opu!gpvoe")));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod(dexg.dexa("pcubjoPbje"), new Class[0]).invoke(this.keyguardManager, new Object[0]);
            if (objInvoke == null) {
                throw new OAIDException(dexg.dexa("PBJE!pcubjo!gbjmfe"));
            }
            String string = objInvoke.toString();
            OAIDLog.print(dexg.dexa("PBJE!pcubjo!tvddftt;!") + string);
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        KeyguardManager keyguardManager;
        if (this.context == null || (keyguardManager = this.keyguardManager) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod(dexg.dexa("jtTvqqpsufe"), new Class[0]).invoke(this.keyguardManager, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("DpptfbJnqm!tvqqpsufe!gbjm!") + th);
            return false;
        }
    }
}
