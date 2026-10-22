package com.beizi.fusion;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kc.openset.constant.DeviceIdType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27869a;

    public vh(Context context) {
        this.f27869a = context;
    }

    public void a(c7.a aVar) {
        try {
            this.f27869a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e) {
            om.a(e);
        }
        Uri uri = Uri.parse("content://com.meizu.flyme.openidsdk/");
        try {
            Cursor cursorQuery = this.f27869a.getContentResolver().query(uri, null, null, new String[]{DeviceIdType.OAID}, null);
            String strA = a(cursorQuery);
            if (aVar != null) {
                aVar.a(strA);
            }
            cursorQuery.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }
}
