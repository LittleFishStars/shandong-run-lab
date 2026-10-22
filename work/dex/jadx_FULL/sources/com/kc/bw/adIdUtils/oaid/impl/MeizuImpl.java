package com.kc.bw.adIdUtils.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MeizuImpl implements IOAID {
    public final Context context;

    public MeizuImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.context.getContentResolver().query(Uri.parse(dexg.dexa("dpoufou;00dpn/nfj{v/gmznf/pqfojetel0")), null, null, new String[]{dexg.dexa("pbje")}, null);
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(dexg.dexa("wbmvf")));
                if (string == null || string.length() == 0) {
                    throw new OAIDException(dexg.dexa("PBJE!rvfsz!gbjmfe"));
                }
                OAIDLog.print(dexg.dexa("PBJE!rvfsz!tvddftt;!") + string);
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

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider(dexg.dexa("dpn/nfj{v/gmznf/pqfojetel"), 0) != null;
        } catch (Throwable th) {
            OAIDLog.print(dexg.dexa("Nfj{vJnqm!tvqqpsufe!gbjm!") + th);
            return false;
        }
    }
}
