package com.kc.bw.adIdUtils.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.kc.bw.adIdUtils.oaid.IGetter;
import com.kc.bw.adIdUtils.oaid.IOAID;
import com.kc.bw.adIdUtils.oaid.OAIDException;
import com.kc.bw.adIdUtils.oaid.OAIDLog;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class NubiaImpl implements IOAID {
    public final Context context;

    public NubiaImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (!supported()) {
            String strDexa = dexg.dexa("Pomz!tvqqpsut!Boespje!21/1!boe!bcpwf!gps!Ovcjb");
            OAIDLog.print(strDexa);
            iGetter.onOAIDGetError(new OAIDException(strDexa));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.context.getContentResolver().acquireContentProviderClient(Uri.parse(dexg.dexa("dpoufou;00do/ovcjb/jefoujuz0jefoujuz")));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call(dexg.dexa("hfuPBJE"), null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new OAIDException(dexg.dexa("PBJE!rvfsz!gbjmfe;!cvoemf!jt!ovmm"));
            }
            String string = bundleCall.getInt(dexg.dexa("dpef"), -1) == 0 ? bundleCall.getString(dexg.dexa("je")) : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException(dexg.dexa("PBJE!rvfsz!gbjmfe;!") + bundleCall.getString(dexg.dexa("nfttbhf")));
            }
            OAIDLog.print(dexg.dexa("PBJE!rvfsz!tvddftt;!") + string);
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // com.kc.bw.adIdUtils.oaid.IOAID
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
