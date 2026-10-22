package com.kc.cw.ad.c.g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.alipay.sdk.m.d.e;
import com.kc.cw.ad.c.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements c {
    @Override // com.kc.cw.ad.c.c
    public String a(Context context) {
        String string = null;
        if (context == null) {
            return null;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(e.f25426a), null, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("device_ids_grndid")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
