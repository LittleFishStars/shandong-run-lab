package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import androidx.annotation.Keep;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class XiaomiDeviceIDHelper {
    private static final String TAG = "XiaomiDeviceIDHelper";
    private Context mContext;

    public XiaomiDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String str;
        Exception e;
        try {
            str = (String) OaidJavaCalls.callMethod(OaidJavaCalls.newInstance("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
            try {
                LiteApiLogger.i(TAG, "getOAID oaid:" + str);
            } catch (Exception e2) {
                e = e2;
                LiteApiLogger.i(TAG, "getOAID fail");
                LiteApiLogger.printStackTraceOnly(e);
            }
        } catch (Exception e3) {
            str = "";
            e = e3;
        }
        return str;
    }
}
