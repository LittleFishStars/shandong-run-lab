package cj.mobile.wm.adIdUtils.oaid.impl;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import cj.mobile.wm.adIdUtils.oaid.IGetter;
import cj.mobile.wm.adIdUtils.oaid.IOAID;
import cj.mobile.wm.adIdUtils.oaid.OAIDException;
import cj.mobile.wm.adIdUtils.oaid.OAIDLog;
import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NubiaImpl extends IOAID {
    public final String URI_STRING = dexc.dexa("dpoufou;00do/ovcjb/jefoujuz0jefoujuz");
    public final Context context;

    public NubiaImpl(Context context) {
        this.context = context;
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        if (!supported()) {
            String strDexa = dexc.dexa("Pomz!tvqqpsut!Boespje!21/1!boe!bcpwf!gps!Ovcjb");
            OAIDLog.print(strDexa);
            iGetter.onOAIDGetError(new OAIDException(strDexa));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.context.getContentResolver().acquireContentProviderClient(Uri.parse(this.URI_STRING));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call(dexc.dexa("hfuPBJE"), null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new OAIDException(dexc.dexa("OvcjbJnqm!pbje!rvfsz!gbjm-cvoemf!jt!ovmm"));
            }
            String string = bundleCall.getInt(dexc.dexa("dpef"), -1) == 0 ? bundleCall.getString(dexc.dexa("je")) : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException(dexc.dexa("OvcjbJnqm!pbje!rvfsz!gbjm-") + bundleCall.getString(dexc.dexa("nfttbhf")));
            }
            OAIDLog.print(dexc.dexa("OvcjbJnqm!pbje!rvfsz!tvddftt-pbje>") + string);
            iGetter.onOAIDGetComplete(string);
        } catch (Exception e) {
            OAIDLog.print(e);
            iGetter.onOAIDGetError(e);
        }
    }

    @Override // cj.mobile.wm.adIdUtils.oaid.IOAID
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
