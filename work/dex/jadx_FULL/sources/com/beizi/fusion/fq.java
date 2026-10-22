package com.beizi.fusion;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class fq implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27307a;

    public fq(Context context) {
        this.f27307a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return ak.a(com.alipay.sdk.m.u0.c.c, "0").equals("1");
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f27307a == null || kcVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f27307a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    yj.a("OAID query success: " + string);
                    kcVar.a(string);
                    cursorQuery.close();
                    return;
                }
                throw new tj("OAID query failed");
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
            yj.a(e);
            kcVar.a(e);
        }
    }
}
