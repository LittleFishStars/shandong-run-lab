package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class WeaponHI {
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List<Integer> isList = null;
    public static boolean isLoad = true;
    public static Context mContext = null;
    public static IWeaponInitParams mParams = null;
    public static String sChannel = "";
    public static String sKDeviceId = "";
    public static String sKSAppkey = "";
    public static String sKSSdkver = "";
    public static String sKSSecKey = "";
    public static String sUserId = "";
    public static String skProductName = "";

    public static void iD() {
        try {
            iP(mContext);
        } catch (Throwable unused) {
        }
        try {
            cz.a(mContext).a(100, 0);
            cv.a(mContext).a(100);
            db.a(mContext).a(100);
            cx.a(mContext).a(100);
            dc.a(mContext).a(100);
            cy.a(mContext).a();
            da.a(mContext).a(100);
        } catch (Exception unused2) {
        }
    }

    public static void iP(Context context) {
        try {
            long jB = dd.a(context).b();
            long jCurrentTimeMillis = (System.currentTimeMillis() - jB) - (((long) h.a(context, "re_po_rt").c(dd.h, 12)) * 3600000);
            if (jB < 1 || jCurrentTimeMillis > 0) {
                n.a().a(new cu(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void init(Context context, final IWeaponInitParams iWeaponInitParams) {
        try {
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            if (applicationContext instanceof Application) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            IWeaponInitParams iWeaponInitParams2 = iWeaponInitParams;
                            WeaponHI.mParams = iWeaponInitParams2;
                            WeaponHI.sKSAppkey = iWeaponInitParams2.getAppKey();
                            WeaponHI.sKSSecKey = iWeaponInitParams.getSecKey();
                            WeaponHI.sKSSdkver = "5.4.3";
                            WeaponHI.hostVersionName = bf.q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = iWeaponInitParams.getDeviceId();
                            WeaponHI.skProductName = iWeaponInitParams.getProductName();
                            WeaponHI.sUserId = iWeaponInitParams.getUserId();
                            WeaponHI.sChannel = iWeaponInitParams.getChannel();
                            WeaponHI.as = iWeaponInitParams.getAPPLISTSwitch();
                            WeaponHI.isLoad = iWeaponInitParams.isLoadSo();
                            WeaponHI.cookieData = bf.y(WeaponHI.mContext);
                            try {
                                h hVarA = h.a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", ck.m());
                                jSONObject.put("d", ck.b(WeaponHI.mContext));
                                jSONObject.put("a", bf.q(WeaponHI.mContext));
                                jSONObject.put("p", bf.s(WeaponHI.mContext));
                                jSONObject.put("s", "5.4.3");
                                jSONObject.put("n", TextUtils.isEmpty(hVarA.a(dd.g)) ? 1 : 0);
                                WeaponHI.encryENV = new bl(WeaponHI.mContext).c(jSONObject.toString());
                                String strA = hVarA.a(dd.u);
                                if (!TextUtils.isEmpty(strA)) {
                                    WeaponHI.isList = Arrays.asList(strA.split("\\|"));
                                    WeaponHI.ii = hVarA.c(dd.v, 5);
                                }
                            } catch (Throwable unused) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, iWeaponInitParams.getPrivacySwitch());
                        } catch (Throwable unused2) {
                        }
                    }
                });
            } else {
                Log.e("Risk", "context  is not application！！！");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setPS(final boolean z) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1
                @Override // java.lang.Runnable
                public final void run() {
                    Context context = WeaponHI.mContext;
                    if (context != null) {
                        h hVarA = h.a(context, "re_po_rt");
                        boolean z2 = z;
                        if (!z2) {
                            hVarA.a("a1_p_s_p_s_c_b", Boolean.valueOf(z2));
                            return;
                        }
                        if (hVarA.e("a1_p_s_p_s_c_b")) {
                            return;
                        }
                        hVarA.a("a1_p_s_p_s_c_b", Boolean.valueOf(z));
                        try {
                            if (hVarA.c(dd.bq, 1) == 1) {
                                db.a(WeaponHI.mContext).a(103);
                                cz.a(WeaponHI.mContext).a(103, 0);
                                da.a(WeaponHI.mContext).a(103);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void init(String str, String str2, boolean z) {
        try {
            h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z));
            n.a();
            br.a(mContext);
            bq.a(mContext);
        } catch (Exception unused) {
        }
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q qVarA = q.a(WeaponHI.mContext);
                    if (qVarA == null) {
                        return;
                    }
                    qVarA.a();
                } catch (Exception unused2) {
                }
            }
        });
    }
}
