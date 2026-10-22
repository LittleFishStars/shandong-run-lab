package com.byazt.dk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.aas.pf;
import com.byazt.bv.BaseConstants;
import com.byazt.ete.ic;
import com.byazt.omf.gt;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 67})
public class u implements uj {
    private u() {
    }

    public static uj uj() {
        return new u();
    }

    @Override // com.byazt.dk.uj
    public void c(JSONObject jSONObject, String str) {
        com.byazt.qt.tt ttVarC;
        ic icVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("open_ad_sdk_download_extra");
        if (jSONObjectOptJSONObject == null || !pf.c() || (ttVarC = com.byazt.qt.tt.c(jSONObjectOptJSONObject)) == null || (icVar = ttVarC.c) == null) {
            return;
        }
        com.byazt.yih.i.c(str, icVar);
    }

    @Override // com.byazt.dk.uj
    public boolean c(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        return true;
    }

    @Override // com.byazt.dk.uj
    public sp tt() {
        return null;
    }

    @Override // com.byazt.dk.uj
    public void tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.nr.x.ve(new File(str));
    }

    @Override // com.byazt.dk.uj
    public boolean ve() {
        return com.byazt.omf.x.m().c();
    }

    @Override // com.byazt.dk.uj
    public boolean tt(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        int iOptInt = 0;
        if (downloadModel == null || downloadInfo == null) {
            return false;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        long id = downloadModel.getId();
        int id2 = downloadInfo.getId();
        com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(id);
        String savePath = downloadInfo.getSavePath();
        String url = downloadInfo.getUrl();
        JSONObject jSONObjectSp = ttVarUj.sp();
        String strOptString = null;
        if (jSONObjectSp == null || (jSONObjectOptJSONObject = jSONObjectSp.optJSONObject("open_ad_sdk_download_extra")) == null) {
            str = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = jSONObjectOptJSONObject2.optString(LoginConstants.EXT);
            }
            str = strOptString;
            strOptString = strOptString2;
        }
        com.byazt.yih.a aVar = new com.byazt.yih.a();
        com.byazt.qt.c cVar = new com.byazt.qt.c();
        cVar.c(name);
        cVar.tt(appIcon);
        cVar.ve(packageName);
        cVar.c(id2);
        cVar.uj(logExtra);
        cVar.n(targetFilePath);
        cVar.tt(iOptInt);
        cVar.a(strOptString);
        cVar.sp(str);
        cVar.x(savePath);
        cVar.i(url);
        return aVar.c(cVar);
    }

    @Override // com.byazt.dk.uj
    public JSONObject c() {
        JSONObject jSONObjectC = com.byazt.yih.i.c();
        try {
            if (!gt.tt().ic()) {
                jSONObjectC.put("enable_app_install_receiver", 0);
            }
            if (jSONObjectC.optInt("enable_target_34", -1) == -1) {
                jSONObjectC.put("enable_target_34", gt.tt().id());
            }
            if (!jSONObjectC.has("use_network_callback")) {
                jSONObjectC.put("use_network_callback", 1);
            }
        } catch (Exception unused) {
        }
        return jSONObjectC;
    }

    @Override // com.byazt.dk.uj
    public String c(boolean z) {
        return com.byazt.yih.i.c(z);
    }

    @Override // com.byazt.dk.uj
    public void c(Activity activity, String[] strArr, a aVar) {
        t.c(activity, strArr, aVar);
    }

    @Override // com.byazt.dk.uj
    public boolean c(Context context, String str) {
        return t.c(context, str);
    }

    @Override // com.byazt.dk.uj
    public void c(int i, String str, Map<String, Object> map, n nVar) {
        da.c(i, str, map, nVar);
    }

    @Override // com.byazt.dk.uj
    public void c(String str, byte[] bArr, String str2, n nVar) {
        da.c(str, bArr, str2, 0, nVar);
    }

    @Override // com.byazt.dk.uj
    public AlertDialog c(Activity activity, boolean z, c cVar) {
        return sl.c(activity, z, cVar);
    }

    @Override // com.byazt.dk.uj
    public void c(WeakReference<Context> weakReference, boolean z, c cVar) {
        sl.c(weakReference, z, cVar);
    }

    @Override // com.byazt.dk.uj
    public boolean c(String str) {
        return i.c(str);
    }

    @Override // com.byazt.dk.uj
    public void c(x xVar, boolean z) {
        if (c(xVar)) {
            try {
                com.byazt.bwm.n.c(i.c.c(xVar, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.dk.uj
    public boolean c(DownloadModel downloadModel) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        if (downloadModel == null) {
            return true;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        JSONObject jSONObjectSp = com.byazt.nn.a.c().uj(downloadModel.getId()).sp();
        String strOptString = null;
        int iOptInt = 0;
        if (jSONObjectSp == null || (jSONObjectOptJSONObject = jSONObjectSp.optJSONObject("open_ad_sdk_download_extra")) == null) {
            str = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = jSONObjectOptJSONObject2.optString(LoginConstants.EXT);
            }
            str = strOptString;
            strOptString = strOptString2;
        }
        com.byazt.yih.a aVar = new com.byazt.yih.a();
        com.byazt.qt.c cVar = new com.byazt.qt.c();
        cVar.c(name);
        cVar.tt(appIcon);
        cVar.ve(packageName);
        cVar.uj(logExtra);
        cVar.tt(iOptInt);
        cVar.a(strOptString);
        cVar.sp(str);
        return aVar.tt(cVar);
    }

    private boolean c(x xVar) {
        JSONObject jSONObjectUj;
        if (xVar == null || (jSONObjectUj = xVar.uj()) == null) {
            return false;
        }
        String strOptString = jSONObjectUj.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        try {
            return new JSONObject(strOptString).optJSONObject("open_ad_sdk_download_extra") != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
