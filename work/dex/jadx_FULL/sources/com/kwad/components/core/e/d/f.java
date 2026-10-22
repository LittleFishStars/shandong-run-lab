package com.kwad.components.core.e.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    private static boolean RE = false;

    public static boolean G(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo;
        return (adInfo == null || (smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo) == null || TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) ? false : true;
    }

    public static int a(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        if (!com.kwad.sdk.core.response.helper.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            com.kwad.sdk.core.adlog.c.n(adTemplate, 1);
            return 0;
        }
        Cursor cursor = null;
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
            if (cursorQuery != null) {
                try {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    try {
                        com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, by.y(th));
                        com.kwad.sdk.core.adlog.c.n(adTemplate, 2);
                        return -1;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    }
                }
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.core.adlog.c.c(adTemplate, "wxsmallapp", 1, null);
            a(jumpFrom, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            return 1;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aG(boolean z) {
        RE = z;
    }

    private static int b(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        if (!com.kwad.sdk.core.response.helper.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            return 0;
        }
        Cursor cursorQuery = null;
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
            if (cursorQuery != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            return 1;
        } catch (Throwable th) {
            try {
                com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, by.y(th));
                return -1;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            }
        }
    }

    public static int e(Context context, AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.U(adInfoEO) || com.kwad.sdk.core.response.helper.a.V(adInfoEO)) {
            return 0;
        }
        return a(context, adInfoEO.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    public static int f(Context context, AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.V(adInfoEO)) {
            return 0;
        }
        return b(context, adInfoEO.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    private static boolean qI() {
        return RE;
    }

    private static void a(final JumpFrom jumpFrom, final String str, final String str2, final String str3, final AdTemplate adTemplate) {
        if (qI()) {
            return;
        }
        aG(true);
        int iAbs = Math.abs(com.kwad.sdk.core.config.e.JK());
        if (iAbs > 0) {
            by.a(new Runnable() { // from class: com.kwad.components.core.e.d.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.aG(false);
                    com.kwad.sdk.core.c.b.LW();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, str, str2, str3);
                    com.kwad.sdk.core.adlog.c.a(adTemplate, "wxsmallapp", 1);
                }
            }, null, ((long) iAbs) * 1000);
        } else {
            aG(false);
        }
    }
}
