package com.beizi.fusion;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class dq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27201a;
    private boolean b = false;
    String c = null;

    public dq(Context context) {
        this.f27201a = context;
    }

    public String a() {
        Cursor cursorQuery = this.f27201a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        String string = null;
        if (cursorQuery != null) {
            string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("value")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
