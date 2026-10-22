package com.beizi.fusion;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kc.openset.constant.DeviceIdType;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class xh implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f28031a;

    public xh(Context context) {
        this.f28031a = context;
    }

    @Override // com.beizi.fusion.yd
    public boolean a() {
        Context context = this.f28031a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e) {
            yj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.yd
    public void a(kc kcVar) {
        if (this.f28031a == null || kcVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f28031a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{DeviceIdType.OAID}, null);
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
