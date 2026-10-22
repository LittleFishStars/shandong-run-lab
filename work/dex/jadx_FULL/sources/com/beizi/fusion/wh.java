package com.beizi.fusion;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kc.openset.constant.DeviceIdType;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class wh implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27910a;

    public wh(Context context) {
        this.f27910a = context;
    }

    @Override // com.beizi.fusion.xd
    public boolean a() {
        Context context = this.f27910a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e) {
            xj.a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.xd
    public void a(jc jcVar) {
        if (this.f27910a == null || jcVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f27910a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{DeviceIdType.OAID}, null);
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
