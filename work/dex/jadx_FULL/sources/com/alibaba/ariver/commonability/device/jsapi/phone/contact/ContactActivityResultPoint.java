package com.alibaba.ariver.commonability.device.jsapi.phone.contact;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ContactActivityResultPoint implements ActivityResultPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23970a = "ContactActivityResultPoint";

    private void a(Uri uri) {
        Activity activityA;
        Cursor cursorQuery;
        a aVar = new a();
        if (uri != null && (activityA = c.a()) != null && (cursorQuery = activityA.getContentResolver().query(uri, new String[]{"data1", "display_name"}, null, null, null)) != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                    if (string != null) {
                        aVar.b = string2;
                        aVar.f23971a = string;
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(f23970a, "processSystemContactCallback " + uri, th);
                cursorQuery.close();
            }
        }
        c.a(aVar);
    }

    @Override // com.alibaba.ariver.app.api.point.activity.ActivityResultPoint
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 10721) {
            if (i2 != -1) {
                c.a(null);
                return;
            }
            try {
                a(intent.getData());
            } catch (SecurityException unused) {
                c.a(new a());
            } catch (Exception unused2) {
                c.a(new a());
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
