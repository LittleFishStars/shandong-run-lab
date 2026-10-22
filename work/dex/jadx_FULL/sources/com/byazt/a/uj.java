package com.byazt.a;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 34, 15})
public class uj {
    public static c c(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo);
        if (str.equals(com.alipay.sdk.m.c0.c.c)) {
            return new da(context, cVarC, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new sl(context, cVarC, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new t(context, cVarC, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new sp(context, cVarC, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new x(context, cVarC, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new i(context, cVarC, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new ve(context, cVarC, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new u(context, cVarC, com.byazt.z.ve.c(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.byazt.z.uj.sl().n(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean c(Context context, String str, JSONObject jSONObject, com.byazt.k.c cVar) {
        c uVar;
        if (context != null && str != null) {
            String strTt = com.byazt.z.ve.tt();
            if (!TextUtils.isEmpty(strTt) && !TextUtils.isEmpty(str)) {
                if (com.byazt.i.n.uj() && str.equals(com.alipay.sdk.m.c0.c.c)) {
                    uVar = new da(context, cVar, strTt);
                } else if (com.byazt.i.n.uj() && str.equals("v2")) {
                    uVar = new sl(context, cVar, strTt);
                } else if (com.byazt.i.n.uj() && str.equals("v3")) {
                    uVar = new t(context, cVar, strTt);
                } else if (com.byazt.i.n.n() && str.equals("o1")) {
                    uVar = new sp(context, cVar, strTt);
                } else if (com.byazt.i.n.n() && str.equals("o2")) {
                    uVar = new x(context, cVar, strTt);
                } else if (com.byazt.i.n.n() && str.equals("o3")) {
                    uVar = new i(context, cVar, strTt, strTt, strTt);
                } else if (com.byazt.i.n.uj() && str.equals("custom")) {
                    uVar = new ve(context, cVar, strTt, jSONObject);
                } else {
                    uVar = (com.byazt.i.n.uj() && str.equals("vbi")) ? new u(context, cVar, strTt) : null;
                }
                if (uVar != null && uVar.c()) {
                    return true;
                }
            }
        }
        return false;
    }
}
