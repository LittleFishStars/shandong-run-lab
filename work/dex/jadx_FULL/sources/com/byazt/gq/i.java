package com.byazt.gq;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.ar.AdDownloadModel;
import com.byazt.nr.m;
import com.byazt.ou.IDownloadButtonClickListener;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 42})
public class i {
    public static boolean c(int i) {
        return i == 0 || i == 1;
    }

    public static boolean c(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean tt(int i) {
        return i == 2 || i == 1;
    }

    public static boolean tt(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static String uj(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public static String ve(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public static boolean c(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int c(@NonNull com.byazt.nn.n nVar, boolean z, com.byazt.z.n nVar2) {
        int iC;
        if (nVar2 == null || TextUtils.isEmpty(nVar2.c()) || nVar2.getContext() == null) {
            return 0;
        }
        try {
            iC = c(nVar2, nVar2.c());
        } catch (Throwable th) {
            t.gt().c(th, "redirectSavePathIfPossible");
            iC = 4;
        }
        nVar2.c(iC);
        if (iC == 0) {
            nVar2.c(new com.byazt.sd.c());
        }
        if (!nVar2.q()) {
            nVar2.c(new com.byazt.sd.tt());
        }
        int iC2 = com.byazt.z.uj.sl().c(nVar2);
        com.byazt.dd.tt ttVarC = c(nVar, iC2);
        com.byazt.nn.a.c().c(ttVarC);
        ttVarC.sp(iC2);
        ttVarC.x(System.currentTimeMillis());
        ttVarC.i(0L);
        com.byazt.k.c cVarC = com.byazt.k.c.c(nVar2.os());
        if (!c(nVar2, cVarC, iC2) && nVar.tt.isShowToast()) {
            String startToast = nVar.tt.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = cVarC.ve("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            t.ve().c(2, nVar2.getContext(), nVar.tt, startToast, null, 0);
        }
        return iC2;
    }

    private static com.byazt.dd.tt c(com.byazt.nn.n nVar, int i) {
        com.byazt.dd.tt ttVar = new com.byazt.dd.tt(nVar.tt, nVar.ve, nVar.uj, i);
        boolean z = true;
        if (com.byazt.k.c.c(i).c("download_event_opt", 1) > 1) {
            try {
                String packageName = nVar.tt.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (t.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    ttVar.x(z);
                }
            } catch (Throwable unused) {
            }
        }
        return ttVar;
    }

    private static boolean c(com.byazt.z.n nVar, @NonNull com.byazt.k.c cVar, int i) {
        String strOptString;
        JSONArray jSONArrayN = cVar.n("ah_plans");
        if (jSONArrayN != null && jSONArrayN.length() != 0) {
            int length = jSONArrayN.length();
            int i2 = 0;
            JSONObject jSONObject = null;
            while (true) {
                if (i2 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayN.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.byazt.i.c.c(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.byazt.z.tt.c(jSONObjectOptJSONObject, cVar).tt != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "plan_c":
                                jSONObject = jSONObjectOptJSONObject;
                                continue;
                                break;
                            case "plan_d":
                            case "plan_h":
                                break;
                            case "plan_g":
                                if (com.byazt.z.tt.tt(jSONObjectOptJSONObject, cVar).tt != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            default:
                                continue;
                                break;
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.byazt.z.tt.c(com.byazt.zz.ve.ic(), (Intent) null, jSONObject, i, new com.byazt.z.c());
                }
            }
        }
        return false;
    }

    public static String c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            m.c(e);
        }
        return null;
    }

    private static int c(com.byazt.z.n nVar, String str) {
        com.byazt.k.c cVarC = com.byazt.k.c.c(nVar.os());
        JSONObject jSONObjectUj = cVarC.uj("download_dir");
        if (jSONObjectUj == null || TextUtils.isEmpty(jSONObjectUj.optString("dir_name"))) {
            return -1;
        }
        String strTt = nVar.tt();
        String strBx = nVar.bx();
        if (TextUtils.isEmpty(strBx)) {
            strBx = com.byazt.z.ve.c(str, strTt, nVar.t(), true);
        }
        if (strBx.length() > 255) {
            strBx = strBx.substring(strBx.length() - 255);
        }
        if (TextUtils.isEmpty(strTt)) {
            strTt = strBx;
        }
        String strVe = nVar.ve();
        if (TextUtils.isEmpty(strVe)) {
            strVe = com.byazt.z.ve.tt();
        }
        String str2 = strVe + File.separator + com.byazt.z.ve.c(strTt, cVarC);
        DownloadInfo downloadInfoC = com.byazt.z.uj.sl().c(nVar.getContext(), str);
        if (downloadInfoC != null && downloadInfoC.isSavePathRedirected()) {
            nVar.ve(downloadInfoC.getSavePath());
            try {
                nVar.c(new JSONObject(downloadInfoC.getDownloadSettingString()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        if (downloadInfoC != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.byazt.z.uj.sl().c(strBx, nVar.t()))) {
            return downloadInfoC != null ? 8 : 9;
        }
        int iC = com.byazt.z.tt.c(cVarC);
        if (iC == 0) {
            nVar.ve(str2);
        }
        return iC;
    }
}
