package com.byazt.yih;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.nu;
import com.byazt.nr.h;
import com.byazt.nr.m;
import com.byazt.ogz.sl;
import com.byazt.omf.gt;
import com.byazt.omf.rh;
import com.byazt.ukr.yp;
import com.kuaishou.weapon.p0.bo;
import java.io.File;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 42})
public class i {
    private static void tt(final ic icVar, final String str) {
        final com.byazt.aas.c cVarVe;
        if (c(icVar) || (cVarVe = com.byazt.omf.x.m().ve()) == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        cVarVe.c(new com.byazt.aas.c.ve() { // from class: com.byazt.yih.i.1
            @Override // com.byazt.aas.c.ve, com.byazt.aas.c.InterfaceC0346c
            public void c() {
                if (!pf.c()) {
                    com.byazt.aas.c cVar = cVarVe;
                    if (cVar != null) {
                        cVar.ve();
                        return;
                    }
                    return;
                }
                if (!com.byazt.qh.tt.tt(str)) {
                    i.tt(icVar, jCurrentTimeMillis, cVarVe, str);
                }
                com.byazt.aas.c cVar2 = cVarVe;
                if (cVar2 != null) {
                    cVar2.ve();
                }
            }
        });
    }

    public static void uj() {
        if (com.byazt.omf.x.m().nb() != null) {
            com.byazt.omf.x.m().nb().apply(com.byazt.yxi.uj.c().c(20).c(Void.class).tt());
        } else {
            m.uj("TTDownload-Util", "下载SDK 初始化失败 ， bridge = null ！！！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(ic icVar, String str) {
        if (icVar == null) {
            return;
        }
        nb.c(gt.getContext(), str);
    }

    public static String ve() {
        try {
            Function<SparseArray<Object>, Object> functionNb = com.byazt.omf.x.m().nb();
            if (functionNb == null) {
                return bo.e;
            }
            functionNb.apply(com.byazt.yxi.uj.c().c(1).c(String.class).tt());
            return bo.e;
        } catch (Exception unused) {
            return bo.e;
        }
    }

    public static void c(String str, ic icVar) {
        boolean zSp;
        try {
            if (gt.getContext() == null || TextUtils.isEmpty(str) || !(zSp = com.byazt.ete.gt.sp(icVar))) {
                return;
            }
            nu nuVarYp = icVar.yp();
            if (nuVarYp != null && !TextUtils.isEmpty(nuVarYp.tt())) {
                m.uj("TTDownload-Util", "含有deepLink");
                if (com.byazt.ete.gt.uj(icVar) != 0) {
                    m.uj("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + com.byazt.ete.gt.uj(icVar));
                    return;
                }
            }
            if (zSp) {
                if (com.byazt.qh.tt.tt(str)) {
                    m.uj("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                } else if (!com.byazt.ete.gt.x(icVar)) {
                    tt(icVar, str);
                } else {
                    c(gt.getContext(), icVar, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final com.byazt.aas.c cVar, final ic icVar, String str, String str2, final String str3) {
        if (cVar != null && nb.tt(str3)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String strUj = icVar.uj();
            com.byazt.aas.n.c(gt.getContext(), strUj, str, str2, "立即打开", "退出", new com.byazt.aas.n.c() { // from class: com.byazt.yih.i.3
                @Override // com.byazt.aas.n.c
                public void c() {
                    i.ve(icVar, str3);
                    com.byazt.aas.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.ve();
                    }
                }

                @Override // com.byazt.aas.n.c
                public void tt() {
                    com.byazt.aas.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.ve();
                    }
                }

                @Override // com.byazt.aas.n.c
                public void ve() {
                    com.byazt.aas.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.ve();
                    }
                }
            });
        }
    }

    public static boolean tt() {
        return com.byazt.xgx.n.c().c(gt.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(ic icVar, long j, com.byazt.aas.c cVar, String str) {
        if (icVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= ((long) com.byazt.ete.gt.i(icVar)) * 1000) {
            String strVe = icVar.z() != null ? icVar.z().ve() : "";
            tt(cVar, icVar, strVe, TextUtils.isEmpty(strVe) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
        } else {
            ve(icVar, str);
        }
    }

    public static String c(ic icVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("background", z);
            if (icVar != null) {
                jSONObject.put("reqId", icVar.qy());
                jSONObject.put("cid", icVar.uj());
                jSONObject.put("rit", nb.c(icVar, ""));
            }
            Context context = gt.getContext();
            if (context == null) {
                jSONObject.put("message", "context is null");
                yp.c().c("dl_path_empty", jSONObject, (Throwable) null);
                return "";
            }
            File fileTt = com.byazt.qh.tt.tt(context);
            if (fileTt == null) {
                jSONObject.put("message", "file is null");
                yp.c().c("dl_path_empty", jSONObject, (Throwable) null);
                return "";
            }
            if (!fileTt.exists() && !fileTt.mkdirs()) {
                jSONObject.put("message", "mkdirs failed");
                yp.c().c("dl_path_empty", jSONObject, (Throwable) null);
            }
            return fileTt.exists() ? fileTt.getAbsolutePath() : "";
        } catch (Throwable th) {
            try {
                jSONObject.put("message", "path:".concat(""));
            } catch (JSONException unused) {
            }
            yp.c().c("dl_path_empty", jSONObject, th);
            return "";
        }
    }

    private static void c(Context context, final ic icVar, final String str) {
        if (context == null || icVar == null || c(icVar)) {
            return;
        }
        final String strVe = icVar.z() != null ? icVar.z().ve() : "";
        final String str2 = TextUtils.isEmpty(strVe) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
        final com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
        if (cVarVe == null) {
            return;
        }
        cVarVe.c(new com.byazt.aas.c.ve() { // from class: com.byazt.yih.i.2
            @Override // com.byazt.aas.c.ve, com.byazt.aas.c.InterfaceC0346c
            public void c() {
                try {
                    if (!pf.c()) {
                        com.byazt.aas.c cVar = cVarVe;
                        if (cVar != null) {
                            cVar.ve();
                            return;
                        }
                        return;
                    }
                    if (!com.byazt.qh.tt.tt(str)) {
                        i.tt(cVarVe, icVar, strVe, str2, str);
                    }
                    com.byazt.aas.c cVar2 = cVarVe;
                    if (cVar2 != null) {
                        cVar2.ve();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean c(ic icVar) {
        if (icVar == null || !c(c())) {
            return false;
        }
        int i = icVar.i();
        String strGr = icVar.gr();
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        if ((TextUtils.isEmpty(strGr) || i != 4) && !veVarC.get("is_landing_page_open_market", false)) {
            return false;
        }
        veVarC.put("is_landing_page_open_market", false);
        return true;
    }

    public static JSONObject c() {
        sl slVarTt = gt.tt();
        if (slVarTt != null && slVarTt.yf() != null) {
            return slVarTt.yf();
        }
        return new JSONObject();
    }

    private static boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optInt("enable_open_app_dialog") == 1;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public static String c(boolean z) {
        String path;
        File fileC;
        if (z) {
            try {
                if (tt()) {
                    path = null;
                } else {
                    File file = new File(com.byazt.nr.sp.tt(gt.getContext(), false, null), Environment.DIRECTORY_DOWNLOADS);
                    file.mkdirs();
                    path = file.getPath();
                }
            } catch (Throwable unused) {
                return null;
            }
        } else {
            path = null;
        }
        if (TextUtils.isEmpty(path)) {
            if ("mounted".equals(com.byazt.bzd.uj.c()) && (fileC = com.byazt.nr.sp.c(gt.getContext(), Environment.DIRECTORY_DOWNLOADS, false, null)) != null) {
                path = fileC.getPath();
            }
            if (TextUtils.isEmpty(path)) {
                File file2 = new File(com.byazt.nr.sp.c(gt.getContext(), false, null), Environment.DIRECTORY_DOWNLOADS);
                file2.mkdirs();
                path = file2.getPath();
            }
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        com.byazt.aas.i.c();
        return path;
    }

    public static void c(Runnable runnable, com.byazt.eia.sp spVar) {
        if (spVar == null || runnable == null) {
            return;
        }
        if (com.byazt.ete.gt.a(spVar.u_())) {
            com.byazt.bzd.x.c((Runnable) new com.byazt.bwm.sp("tt_download_toast") { // from class: com.byazt.yih.i.4
                @Override // java.lang.Runnable
                public void run() {
                    h.c(gt.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            rh.a().postDelayed(runnable, 500L);
        } else {
            com.byazt.bzd.x.c(runnable);
        }
    }
}
