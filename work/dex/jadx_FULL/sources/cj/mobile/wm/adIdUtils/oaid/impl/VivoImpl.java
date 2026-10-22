package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.adIdUtils.oaid.OAIDRom;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VivoImpl extends IOAID {
    public final Context context;
    public final String URI_STRING = dexc.dexa("dpoufou;00dpn/wjwp/wnt/JeQspwjefs0JefoujgjfsJe0PBJE");
    public final String SUPPORTED_KEY = dexc.dexa("qfstjtu/tzt/jefoujgjfsje/tvqqpsufe");

    public VivoImpl(Context context) {
        this.context = context;
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(this.URI_STRING), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex(dexc.dexa("wbmvf")));
            if (TextUtils.isEmpty(string)) {
                throw new OAIDException(dexc.dexa("WjwpJnqm!pbje!rvfsz!gbjmfe"));
            }
            OAIDLog.print(dexc.dexa("WjwpJnqm!pbje!rvfsz!tvddftt-pbje>") + string);
            iGetter.onOAIDGetComplete(string);
            cursorQuery.close();
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public boolean supported() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return OAIDRom.sysProperty(this.SUPPORTED_KEY, dexc.dexa("1")).equals(dexc.dexa("2"));
    }
}
