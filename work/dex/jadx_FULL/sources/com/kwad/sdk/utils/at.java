package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class at {
    private static Handler bgW = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.config.d bpL;

    public static final class a {
        private static final at bpP = new at();
    }

    public static at VN() {
        return a.bpP;
    }

    private com.kwad.sdk.core.config.d VO() {
        if (this.bpL == null) {
            this.bpL = new com.kwad.sdk.core.config.d();
        }
        return this.bpL;
    }

    private static boolean VQ() {
        return k.Uy() || k.Uz();
    }

    private static int VR() {
        String strI = ai.i("ksadsdk_perf", "install_permission_times_per_day", "");
        if (TextUtils.isEmpty(strI)) {
            return 0;
        }
        String[] strArrSplit = strI.split(LoginConstants.UNDER_LINE);
        try {
            if (strArrSplit[0].equals(VV())) {
                return Integer.parseInt(strArrSplit[1]);
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void VS() {
        try {
            String strI = ai.i("ksadsdk_perf", "install_permission_times_per_day", "");
            if (TextUtils.isEmpty(strI)) {
                ai.h("ksadsdk_perf", "install_permission_times_per_day", VV() + "_1");
                return;
            }
            String[] strArrSplit = strI.split(LoginConstants.UNDER_LINE);
            if (!strArrSplit[0].equals(VV())) {
                ai.h("ksadsdk_perf", "install_permission_times_per_day", VV() + "_1");
                return;
            }
            ai.h("ksadsdk_perf", "install_permission_times_per_day", VV() + LoginConstants.UNDER_LINE + (Integer.parseInt(strArrSplit[1]) + 1));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void VT() {
        try {
            ai.a("ksadsdk_perf", "install_permission_times", ai.b("ksadsdk_perf", "install_permission_times", 0) + 1);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    private static int VU() {
        try {
            return ai.b("ksadsdk_perf", "install_permission_times", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String VV() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }

    public static com.kwad.sdk.core.config.d hU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.core.config.d dVar = new com.kwad.sdk.core.config.d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", e);
            return null;
        }
    }

    private static boolean t(Activity activity) {
        return activity.getPackageManager().canRequestPackageInstalls();
    }

    public final void VP() {
        try {
            com.kwad.sdk.core.c.b.LW();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.at.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* JADX INFO: renamed from: onActivityStopped */
                public final void f(Activity activity) {
                    super.f(activity);
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onActivityStopped:" + activity);
                    if (at.bgW != null) {
                        at.bgW.removeCallbacksAndMessages(null);
                    }
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onBackToBackground:");
                    if (at.bgW != null) {
                        at.bgW.removeCallbacksAndMessages(null);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void dC(final String str) {
        GlobalThreadPools.Oi().execute(new Runnable() { // from class: com.kwad.sdk.utils.at.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("PackageInstallHelper", "init configStr:" + str);
                if (TextUtils.isEmpty(str)) {
                    com.kwad.sdk.core.d.c.w("PackageInstallHelper", "config is empty");
                } else {
                    at.this.bpL = at.hU(str);
                }
            }
        });
    }

    public final void s(final Activity activity) {
        com.kwad.sdk.core.config.d dVarVO = VO();
        if (dVarVO == null || dVarVO.aQR == 0) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "config is null or enableDialog is false");
            return;
        }
        int i = dVarVO.aQS;
        if (i < 0) {
            return;
        }
        if (!VQ()) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "not support");
            return;
        }
        if (a(dVarVO)) {
            return;
        }
        if (VU() >= dVarVO.aQU) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show times is over max");
            return;
        }
        if (t(activity)) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "has install permission");
            return;
        }
        Handler handler = bgW;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            bgW.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.at.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        final Activity activity2 = (Activity) com.kwad.sdk.wrapper.m.wrapContextIfNeed(activity);
                        if (activity2.isFinishing() || activity2.isDestroyed()) {
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show dialog");
                        com.kwad.sdk.widget.e.a aVar = new com.kwad.sdk.widget.e.a(activity2);
                        aVar.iH("去授权").iI("残忍拒绝").iG("需要授予安装其他应用权限");
                        aVar.a(new com.kwad.sdk.widget.e.b() { // from class: com.kwad.sdk.utils.at.3.1
                            @Override // com.kwad.sdk.widget.e.b
                            public final void a(DialogInterface dialogInterface) {
                                by.e(dialogInterface);
                                k.cV(activity2);
                            }

                            @Override // com.kwad.sdk.widget.e.b
                            public final void b(DialogInterface dialogInterface) {
                                by.e(dialogInterface);
                            }

                            @Override // com.kwad.sdk.widget.e.b
                            public final void c(DialogInterface dialogInterface) {
                                by.e(dialogInterface);
                            }
                        });
                        try {
                            aVar.XL().show();
                            at atVar = at.this;
                            at.VS();
                            at atVar2 = at.this;
                            at.VT();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e) {
                        ServiceProvider.reportSdkCaughtException(e);
                    }
                }
            }, i);
        }
    }

    private boolean a(com.kwad.sdk.core.config.d dVar) {
        int iVR = VR();
        if (iVR <= dVar.aQT) {
            return false;
        }
        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "todayShow:" + iVR + " > showTimesPerDay:" + dVar.aQT);
        return true;
    }
}
