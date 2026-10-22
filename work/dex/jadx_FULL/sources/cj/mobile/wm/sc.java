package cj.mobile.wm;

import android.content.Context;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class sc {
    public static rc dexa;
    public static final Object dexb = new Object();

    public static long dexa(rc rcVar) {
        if (rcVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", rcVar.dexe(), rcVar.dexb(), Long.valueOf(rcVar.dexa()), rcVar.dexd(), rcVar.dexc());
        if (lc.dexb(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static rc dexa(Context context) {
        if (context == null) {
            return null;
        }
        new rc();
        synchronized (dexb) {
            String strDexa = uc.dexa(context).dexa();
            if (lc.dexb(strDexa)) {
                return null;
            }
            if (strDexa.endsWith("\n")) {
                strDexa = strDexa.substring(0, strDexa.length() - 1);
            }
            rc rcVar = new rc();
            rcVar.dexb(System.currentTimeMillis());
            rcVar.dexa(strDexa);
            rcVar.dexa(dexa(rcVar));
            return rcVar;
        }
    }

    public static synchronized rc dexb(Context context) {
        rc rcVar = dexa;
        if (rcVar != null) {
            return rcVar;
        }
        if (context == null) {
            return null;
        }
        rc rcVarDexa = dexa(context);
        dexa = rcVarDexa;
        return rcVarDexa;
    }
}
