package com.kc.aw.lib.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _c implements Logger.ILogger {
    public ArrayList _a;

    public _c(Logger.ILogger... iLoggerArr) {
        ArrayList arrayList = new ArrayList();
        this._a = arrayList;
        arrayList.addAll(Arrays.asList(iLoggerArr));
    }

    @Override // com.kc.aw.lib.utils.Logger.ILogger
    public final void d(Logger.LogMessage logMessage) {
        Logger.ILogger iLogger;
        Iterator it = this._a.iterator();
        do {
            if (!it.hasNext()) {
                iLogger = null;
                break;
            }
            iLogger = (Logger.ILogger) it.next();
        } while (!iLogger.enable());
        if (iLogger != null) {
            iLogger.d(logMessage);
        }
    }

    @Override // com.kc.aw.lib.utils.Logger.ILogger
    public final void e(Logger.LogMessage logMessage) {
        Logger.ILogger iLogger;
        Iterator it = this._a.iterator();
        do {
            if (!it.hasNext()) {
                iLogger = null;
                break;
            }
            iLogger = (Logger.ILogger) it.next();
        } while (!iLogger.enable());
        if (iLogger != null) {
            iLogger.e(logMessage);
        }
    }

    @Override // com.kc.aw.lib.utils.Logger.ILogger
    public final boolean enable() {
        return true;
    }

    @Override // com.kc.aw.lib.utils.Logger.ILogger
    public final void i(Logger.LogMessage logMessage) {
        Logger.ILogger iLogger;
        Iterator it = this._a.iterator();
        do {
            if (!it.hasNext()) {
                iLogger = null;
                break;
            }
            iLogger = (Logger.ILogger) it.next();
        } while (!iLogger.enable());
        if (iLogger != null) {
            iLogger.i(logMessage);
        }
    }

    @Override // com.kc.aw.lib.utils.Logger.ILogger
    public final void setLoggerOutput(Class cls) {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            ((Logger.ILogger) it.next()).setLoggerOutput(cls);
        }
    }

    @Override // com.kc.aw.lib.utils.Logger.ILogger
    public final void w(Logger.LogMessage logMessage) {
        Logger.ILogger iLogger;
        Iterator it = this._a.iterator();
        do {
            if (!it.hasNext()) {
                iLogger = null;
                break;
            }
            iLogger = (Logger.ILogger) it.next();
        } while (!iLogger.enable());
        if (iLogger != null) {
            iLogger.w(logMessage);
        }
    }
}
