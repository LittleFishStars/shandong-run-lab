package com.byazt.ex;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.aas.z;
import com.byazt.apd.tt;
import com.byazt.bzd.x;
import com.byazt.dna.u;
import com.byazt.ete.bx;
import com.byazt.ete.ic;
import com.byazt.ete.pf;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nr.ve;
import com.byazt.omf.a;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ut.uj;
import com.byazt.yj.gr;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.android.metrics.LiveMetricsBuilder;
import com.huawei.hms.adapter.internal.CommonCode;
import com.kc.openset.constant.DeviceIdType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 889, 20})
public class c {
    public static void c(final String str, final ic icVar, final long j) {
        x.tt(new Runnable() { // from class: com.byazt.ex.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pf pfVarGt = icVar.gt();
                    String strDa = icVar.da();
                    if (TextUtils.isEmpty(strDa) && pfVarGt != null) {
                        strDa = pfVarGt.tt();
                    }
                    if (TextUtils.isEmpty(strDa)) {
                        return;
                    }
                    String strA = pfVarGt != null ? pfVarGt.a() : null;
                    if (TextUtils.isEmpty(strA)) {
                        strA = icVar.qy();
                    }
                    JSONObject jSONObjectFilterParam = LiveMetrics.filterParam(new LiveMetricsBuilder().roomId(Long.parseLong(strDa)).anchorId(pfVarGt != null ? pfVarGt.c() : "").requestId(strA).enterFromMerge(c.tt(nb.sl(icVar))).enterMethod(c.c(nb.sl(icVar))).actionType(ActionType.CLICK).duration(j).build(), c.c(gt.getContext()));
                    jSONObjectFilterParam.put("tob_extra", icVar.w_());
                    jSONObjectFilterParam.put("live_sdk_status", tt.c().ve());
                    jSONObjectFilterParam.put("live_auth_status", tt.c().n());
                    jSONObjectFilterParam.put("app_start_time", SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
                    jSONObjectFilterParam.put("is_web", icVar.s_());
                    a.tt(str, jSONObjectFilterParam);
                } catch (Throwable th) {
                    m.ve("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static EnterFromMerge tt(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION;
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT;
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED;
        }
        return i == 9 ? EnterFromMerge.AD_UNION_DRAW : EnterFromMerge.NO_VALUE;
    }

    private static String ve(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i != 480) {
            return i != 640 ? "mdpi" : "xxxhdpi";
        }
        return "xxhdpi";
    }

    public static Map<String, String> c(Context context) {
        u uVar = (u) uj.getService("device_info_new");
        com.byazt.vxy.c.n();
        HashMap map = new HashMap();
        map.put("device_id", z.c());
        map.put("sdk_version", p.n);
        map.put("os", "Android");
        map.put("os_version", Build.VERSION.RELEASE);
        map.put("device_model", uVar.getDeviceModel());
        map.put(CommonCode.MapKey.HAS_RESOLUTION, com.byazt.aas.pf.n(context) + "x" + com.byazt.aas.pf.uj(context));
        map.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        map.put("timezone", String.valueOf(c()));
        map.put("access", rh.sp(context));
        map.put("openudid", DeviceUtils.tt());
        map.put("aid", "1371");
        map.put("display_name", com.byazt.fh.c.a());
        map.put(AlibcCommonConstant.APP_VERSION, com.byazt.fh.c.n());
        map.put("package", nb.x());
        map.put("region", Locale.getDefault().getCountry());
        map.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        map.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        map.put("rom", ((u) uj.getService("device_info_new")).getRom());
        String str = Build.MANUFACTURER;
        map.put("device_manufacturer", str);
        ArrayList<String> arrayListC = ve.c(context, "MD5");
        if (arrayListC != null && !arrayListC.isEmpty()) {
            map.put("sig_hash", str);
        }
        map.put("display_density", ve(uVar.getDisplayDpi()));
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        map.put("density_dpi", String.valueOf(uVar.getDisplayDpi()));
        map.put("device_brand", Build.BRAND);
        map.put("build_serial", uVar.getBuildSerial());
        map.put("version_code", nb.i());
        map.put("udid", DeviceUtils.c((Boolean) null));
        map.put("cpu_abi", Build.CPU_ABI);
        map.put(DeviceIdType.OAID, ((com.byazt.dna.ve) uj.getService("embed_applog")).getOAID(false));
        return map;
    }

    public static void tt(ic icVar) {
        if (icVar != null && c(icVar)) {
            String strX = bx.x(icVar);
            String strI = bx.i(icVar);
            if (!TextUtils.isEmpty(strX)) {
                com.byazt.xky.tt.c(strX).to(new gr() { // from class: com.byazt.ex.c.2
                    @Override // com.byazt.yj.gr
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.byazt.yj.gr
                    public void onSuccess(com.byazt.yj.m mVar) {
                    }
                });
            }
            if (TextUtils.isEmpty(strI)) {
                return;
            }
            com.byazt.xky.tt.c(strI).to(new gr() { // from class: com.byazt.ex.c.3
                @Override // com.byazt.yj.gr
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.byazt.yj.gr
                public void onSuccess(com.byazt.yj.m mVar) {
                }
            });
        }
    }

    public static EnterMethod c(int i) {
        if (i == 5) {
            return EnterMethod.LIVE_CARD;
        }
        if (i != 7 && i != 8 && i != 9) {
            return EnterMethod.NO_VALUE;
        }
        return EnterMethod.LIVE_CELL;
    }

    public static boolean c(ic icVar) {
        return p.n() && bx.c(icVar);
    }

    private static int c() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }
}
