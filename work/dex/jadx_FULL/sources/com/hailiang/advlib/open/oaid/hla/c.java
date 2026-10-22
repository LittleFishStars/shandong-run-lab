package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class c implements com.hailiang.advlib.open.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32589a;

    public c(Context context) {
        this.f32589a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f32589a == null || aVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f32589a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{DeviceIdType.OAID}, null);
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
        Context context = this.f32589a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
