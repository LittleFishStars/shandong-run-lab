package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class i implements com.hailiang.advlib.open.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32598a;

    public i(Context context) {
        this.f32598a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f32598a == null || aVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f32598a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                aVar.a(string);
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
            aVar.a(e);
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.hailiang.advlib.open.oaid.c.a(com.alipay.sdk.m.u0.c.c, "0").equals("1");
    }
}
