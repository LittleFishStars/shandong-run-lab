package com.byazt.yih;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.nb;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.da;
import com.byazt.omf.gt;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.hjq.permissions.Permission;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 46})
public class n implements uj {
    public ve c;

    public n(ve veVar) {
        this.c = veVar;
    }

    private String uj(com.byazt.qt.c cVar) {
        ApplicationInfo applicationInfo;
        if (!this.c.tt()) {
            return "enable_action_notification=0";
        }
        if (cVar.a() == 0) {
            return "enable_notification=0";
        }
        Context context = gt.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.byazt.xgx.n.c().tt(gt.getContext(), Permission.POST_NOTIFICATIONS)) {
            return "post_notifications_deny";
        }
        if (c(1440L, this.c.a(), 1000 * this.c.n())) {
            return null;
        }
        return "max_times_limit";
    }

    private String ve(com.byazt.qt.c cVar) {
        ApplicationInfo applicationInfo;
        if (!this.c.c()) {
            return "enable_install_notification";
        }
        com.byazt.dj.uj ujVarNu = com.byazt.omf.x.m().nu();
        if (ujVarNu != null && !ujVarNu.isCanUseMessage()) {
            return "isCanUseMessage";
        }
        if (cVar.a() == 0) {
            return "enable_notification=0";
        }
        Context context = gt.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.byazt.xgx.n.c().tt(gt.getContext(), Permission.POST_NOTIFICATIONS)) {
            return "post_notifications_deny";
        }
        if (c(1440L, this.c.a(), 1000 * this.c.n())) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.byazt.yih.uj
    public boolean tt(com.byazt.qt.c cVar) {
        String strUj = uj(cVar);
        if (TextUtils.isEmpty(strUj)) {
            c(cVar, "pushUnActiveFromMarketMessage");
            return true;
        }
        c("notification", cVar, "open", "othershow", strUj, "failure");
        return false;
    }

    @Override // com.byazt.yih.uj
    public boolean c(final com.byazt.qt.c cVar) {
        String strVe = ve(cVar);
        if (TextUtils.isEmpty(strVe)) {
            da.c().postDelayed(new Runnable() { // from class: com.byazt.yih.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.c(cVar, "startUnInstallNotification");
                }
            }, this.c.uj() * 1000);
            return true;
        }
        c("notification", cVar, "install", "othershow", strVe, "failure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.byazt.qt.c cVar, final String str) {
        if (cVar == null) {
            return;
        }
        com.byazt.xky.tt.c(cVar.tt()).config(Bitmap.Config.ARGB_4444).type(2).to(new gr<Bitmap>() { // from class: com.byazt.yih.n.2
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str2, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(m<Bitmap> mVar) {
                if (mVar != null) {
                    Bitmap result = mVar.getResult();
                    final Bitmap bitmapC = n.c(result, 10.0f);
                    if (result != null) {
                        final boolean zTt = nb.tt(cVar.ve());
                        n.c("notification", cVar, zTt ? "open" : "install", "othershow", str + LoginConstants.UNDER_LINE + cVar.ve(), "success");
                        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.yih.n.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.qt.ve.c(cVar, "com.csj.install", zTt ? 1 : 2, bitmapC);
                            }
                        });
                    }
                }
            }
        }, 4);
    }

    public static void c(String str, final com.byazt.qt.c cVar, final String str2, String str3, final String str4, final String str5) {
        com.byazt.ddx.uj.c(str, str3, cVar.x(), cVar.n(), new com.byazt.ya.c() { // from class: com.byazt.yih.n.3
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", str2);
                jSONObject2.put("installer_package_name", cVar.ve());
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("status", str5);
                }
                if (jSONObject != null) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                }
            }
        });
    }

    public static Bitmap c(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public boolean c(long j, int i, long j2) {
        int i2;
        try {
            Long lValueOf = -1L;
            try {
                lValueOf = Long.valueOf(60 * j * 1000);
                i2 = i;
            } catch (Exception e) {
                com.byazt.nr.m.tt("xgc_notification", "error", e.getMessage());
                i2 = -1;
            }
            if (lValueOf.longValue() >= 0 && i2 >= 0 && lValueOf.longValue() != 0 && i2 != 0) {
                String strC = c();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strC)) {
                    sb.append(jCurrentTimeMillis);
                    c(sb.toString());
                    return true;
                }
                String[] strArrSplit = strC.split(LoginConstants.UNDER_LINE);
                int length = strArrSplit.length;
                if (length < i2) {
                    if (jCurrentTimeMillis - Long.parseLong(strArrSplit[length - 1]) <= j2) {
                        return false;
                    }
                    for (String str : strArrSplit) {
                        sb.append(str);
                        sb.append(LoginConstants.UNDER_LINE);
                    }
                    sb.append(jCurrentTimeMillis);
                    c(sb.toString());
                    return true;
                }
                int i3 = length - i2;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[length + (-1)])).longValue() > j2 && jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i3])).longValue() > lValueOf.longValue()) {
                    for (int i4 = i3; i4 < length; i4++) {
                        String str2 = strArrSplit[i4];
                        if (i4 != i3 && !TextUtils.isEmpty(str2)) {
                            sb.append(str2);
                            sb.append(LoginConstants.UNDER_LINE);
                        }
                    }
                    sb.append(jCurrentTimeMillis);
                    c(sb.toString());
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            com.byazt.nr.m.c(e2);
            com.byazt.nr.m.tt("xgc_notification", "exception:" + e2.getMessage());
            return false;
        }
    }

    public static String c() {
        return com.byazt.omf.tt.c().get("notification_a", "");
    }

    public static void c(String str) {
        com.byazt.omf.tt.c().put("notification_a", str);
    }
}
