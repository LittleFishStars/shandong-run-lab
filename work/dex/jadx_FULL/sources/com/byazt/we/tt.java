package com.byazt.we;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.byazt.bog.a;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 916, 13})
public class tt {
    public static boolean c(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback, boolean z) {
        try {
            LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback, z);
            return true;
        } catch (Throwable th) {
            a.c(th);
            ve.reportException("initLivePlugin", th);
            return false;
        }
    }

    public static boolean c() {
        try {
            LivePluginHelper.initLiveCommerce();
            return true;
        } catch (Exception e) {
            a.c(e);
            ve.reportException("initLiveCommerce", e);
            return false;
        }
    }

    public static boolean c(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey("room_id")) {
            long j = bundle.getLong("room_id");
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService == null) {
                    return false;
                }
                liveRoomService.enterLiveRoom(context, j, bundle);
                return true;
            } catch (Throwable th) {
                a.c(th);
                ve.reportException("openLive", th);
            }
        }
        return false;
    }

    public static boolean c(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                if (liveRoomService != null) {
                    return liveRoomService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th) {
                a.c(th);
                ve.reportException("handleScheme", th);
            }
        }
        return false;
    }
}
