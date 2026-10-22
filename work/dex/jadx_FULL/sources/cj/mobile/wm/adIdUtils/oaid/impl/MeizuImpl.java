package cj.mobile.wm.adIdUtils.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MeizuImpl extends IOAID {
    public final String AUTHORITY = dexc.dexa("dpn/nfj{v/gmznf/pqfojetel");
    public final String URI_STRING = dexc.dexa("dpoufou;00dpn/nfj{v/gmznf/pqfojetel0");
    public final Context context;

    public MeizuImpl(Context context) {
        this.context = context;
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.context;
        if (context == null || iGetter == null) {
            return;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(this.URI_STRING), null, null, new String[]{dexc.dexa("pbje")}, null);
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(dexc.dexa("wbmvf")));
                if (string == null || string.length() == 0) {
                    throw new OAIDException(dexc.dexa("Nfj{vJnqm!pbje!rvfsz!gbjm-sftvmu!jt!ovmm"));
                }
                OAIDLog.print(dexc.dexa("Nfj{vJnqm!pbje!rvfsz!tvddftt-pbje>") + string);
                iGetter.onOAIDGetComplete(string);
                cursorQuery.close();
            } catch (Exception e) {
                OAIDLog.print(e);
                iGetter.onOAIDGetError(e);
                if (0 == 0) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider(this.AUTHORITY, 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexc.dexa("Nfj{vJnqm!difdl!tvqqpsufe!gbjm-") + th);
            return false;
        }
    }
}
