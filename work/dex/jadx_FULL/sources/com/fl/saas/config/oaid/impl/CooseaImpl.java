package com.fl.saas.config.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.oaid.IOAID;
import com.fl.saas.config.oaid.OAIDException;
import com.fl.saas.config.oaid.OAIDLog;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CooseaImpl implements IOAID {
    private final Context context;
    private final KeyguardManager keyguardManager;

    public CooseaImpl(Context context) {
        this.context = context;
        this.keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.keyguardManager;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.keyguardManager, new Object[0]);
            if (objInvoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            String string = objInvoke.toString();
            OAIDLog.print("OAID obtain success: " + string);
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public boolean supported() {
        KeyguardManager keyguardManager;
        if (this.context == null || (keyguardManager = this.keyguardManager) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.keyguardManager, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
