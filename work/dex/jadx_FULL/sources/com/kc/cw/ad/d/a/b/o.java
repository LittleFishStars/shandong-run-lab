package com.kc.cw.ad.d.a.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o implements com.kc.cw.ad.d.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38804a;

    public o(Context context) {
        this.f38804a = context;
    }

    @Override // com.kc.cw.ad.d.a.d
    public void a(com.kc.cw.ad.d.a.c cVar) {
        if (this.f38804a == null || cVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f38804a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new com.kc.cw.ad.d.a.e("OAID query failed");
                }
                com.kc.cw.ad.d.a.f.a("OAID query success: " + string);
                cVar.a(string);
                cursorQuery.close();
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
            com.kc.cw.ad.d.a.f.a(e);
            cVar.a(e);
        }
    }

    @Override // com.kc.cw.ad.d.a.d
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.kc.cw.ad.d.a.g.a(com.alipay.sdk.m.u0.c.c, "0").equals("1");
    }
}
