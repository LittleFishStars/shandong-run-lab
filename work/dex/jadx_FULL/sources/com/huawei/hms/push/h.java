package com.huawei.hms.push;

import android.R;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h {
    private static int a(Context context) {
        int i = context.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return R.drawable.sym_def_app_icon;
    }

    private static int b(Context context, o oVar) {
        int iA = 0;
        if (context == null || oVar == null) {
            HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (!TextUtils.isEmpty(oVar.l())) {
            String[] strArrSplit = oVar.l().split(WVNativeCallbackUtil.SEPERATER);
            if (strArrSplit.length == 3) {
                iA = s.a(context, strArrSplit[1], strArrSplit[2]);
            }
        }
        if (iA == 0) {
            iA = s.a(context, "com.huawei.messaging.default_notification_icon");
        }
        return iA != 0 ? iA : a(context);
    }

    public static Bitmap a(Context context, o oVar) {
        if (context == null || oVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            }
            if ("com.huawei.android.pushagent".equals(oVar.j())) {
                return null;
            }
            HMSLog.i("PushSelfShowLog", "get left bitmap from " + oVar.j());
            return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(oVar.j())).getBitmap();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @TargetApi(23)
    public static void a(Context context, Notification.Builder builder, o oVar) {
        if (context != null && builder != null && oVar != null) {
            builder.setSmallIcon(b(context, oVar));
        } else {
            HMSLog.e("PushSelfShowLog", "msg is null");
        }
    }
}
