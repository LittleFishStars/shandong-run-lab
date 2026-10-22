package com.kc.aw;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g4 implements _ek {
    public final Context _a;

    public _g4(Context context) {
        this._a = context;
    }

    @Override // com.kc.aw._ek
    public final void _a(_a3 _a3Var) {
        try {
            Context context = this._a;
            if (context == null) {
                if (_a3Var != null) {
                    _a3Var._a("");
                    return;
                }
                return;
            }
            try {
                context.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Cursor cursorQuery = this._a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{DeviceIdType.OAID}, null);
                String string = null;
                if (cursorQuery != null) {
                    try {
                        if (!cursorQuery.isClosed()) {
                            cursorQuery.moveToFirst();
                            int columnIndex = cursorQuery.getColumnIndex("value");
                            string = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : null;
                            int columnIndex2 = cursorQuery.getColumnIndex("code");
                            if (columnIndex2 > 0) {
                                cursorQuery.getInt(columnIndex2);
                            }
                            int columnIndex3 = cursorQuery.getColumnIndex("expired");
                            if (columnIndex3 > 0) {
                                cursorQuery.getLong(columnIndex3);
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (_a3Var != null) {
                    _a3Var._a(string);
                }
                cursorQuery.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }
}
