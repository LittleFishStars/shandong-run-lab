package com.kwad.components.core.page.widget.a;

import android.net.Uri;
import android.text.TextUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.kwad.components.core.t.r;
import com.kwad.components.core.t.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f implements g {
    private static boolean bd(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.page.widget.a.g
    public final e bc(String str) {
        e eVar = new e();
        if (TextUtils.isEmpty(str)) {
            return eVar;
        }
        Uri uri = Uri.parse(str);
        eVar.ahx = r.a(u.a(uri, "heightRatio", "0"), 0.0f);
        eVar.ahy = r.a(u.a(uri, "absoluteHeight", "0"), 0.0f);
        eVar.ahA = r.m(u.a(uri, "topRadius", "0"), 0);
        eVar.ahz = r.a(u.a(uri, "maskAlpha", "0"), 0.0f);
        eVar.ahB = bd(u.a(uri, "disableClickOutsideDismiss", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        eVar.ahC = bd(u.a(uri, "enableDragHalfToFull", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        eVar.ahD = bd(u.a(uri, "showStatusBar", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
        eVar.ahF = bd(u.a(uri, "isAdjustKeyBoard", "true"));
        eVar.ahH = u.a(uri);
        return eVar;
    }
}
