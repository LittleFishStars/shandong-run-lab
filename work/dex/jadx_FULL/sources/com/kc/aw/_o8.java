package com.kc.aw;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o8 implements _ek {
    public final Context _a;

    public _o8(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        String string = "";
        try {
            try {
                Cursor cursorQuery = this._a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
                if (cursorQuery != null) {
                    string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex("value")) : "";
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (_a3Var != null) {
                _a3Var._a(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
