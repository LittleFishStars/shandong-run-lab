package com.kc.bw.adIdUtils.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.adIdUtils.oaid.OAIDRom;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class VivoImpl implements IOAID {
    public final Context context;

    public VivoImpl(Context context) {
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
                cursorQuery = this.context.getContentResolver().query(Uri.parse(dexg.dexa("dpoufou;00dpn/wjwp/wnt/JeQspwjefs0JefoujgjfsJe0PBJE")), null, null, null, null);
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
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return OAIDRom.sysProperty(dexg.dexa("qfstjtu/tzt/jefoujgjfsje/tvqqpsufe"), dexg.dexa("1")).equals(dexg.dexa("2"));
    }
}
