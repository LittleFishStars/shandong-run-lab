package com.kc.dw.core.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kc.dw.core.oaid.OAIDException;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i implements com.kc.dw.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39286a;

    public i(Context context) {
        this.f39286a = context;
    }

    @Override // com.kc.dw.core.oaid.b
    public void a(com.kc.dw.core.oaid.a aVar) {
        if (this.f39286a == null || aVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f39286a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{DeviceIdType.OAID}, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                ((com.kc.dw.core.utils.n) aVar).a(string);
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
            ((com.kc.dw.core.utils.n) aVar).a(e);
        }
    }

    @Override // com.kc.dw.core.oaid.b
    public boolean a() {
        Context context = this.f39286a;
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
