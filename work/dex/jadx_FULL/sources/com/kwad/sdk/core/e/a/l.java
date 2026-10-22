package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class l {
    private Context mContext;

    public l(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String string = "";
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                    com.kwad.sdk.core.d.c.i("VivoDeviceIDHelper", "getOAID oaid:" + string);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.i("VivoDeviceIDHelper", "getOAID fail");
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            return string;
        } finally {
            h.closeQuietly(cursorQuery);
        }
    }
}
