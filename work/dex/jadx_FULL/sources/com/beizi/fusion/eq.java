package com.beizi.fusion;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class eq implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27254a;

    public eq(Context context) {
        this.f27254a = context;
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return zj.a(com.alipay.sdk.m.u0.c.c, "0").equals("1");
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27254a == null || jcVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f27254a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    xj.a("OAID query success: " + string);
                    jcVar.a(string);
                    cursorQuery.close();
                    return;
                }
                throw new sj("OAID query failed");
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
        } catch (Exception e) {
            xj.a(e);
            jcVar.a(e);
        }
    }
}
