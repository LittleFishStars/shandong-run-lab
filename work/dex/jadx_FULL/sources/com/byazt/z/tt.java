package com.byazt.z;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.u.x;
import com.byazt.y.JumpUnknownSourceActivity;
import com.byazt.zz.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ipd.dsp.internal.i.q;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 133, 13})
public class tt {
    public static final String c = "tt";
    public static ve tt;
    public static c ve;

    /* JADX INFO: renamed from: com.byazt.z.tt$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 133, 28})
    public static class AnonymousClass1 implements InterfaceC0593tt {
        @Override // com.byazt.z.tt.InterfaceC0593tt
        public boolean c(@NonNull Context context) {
            return tt.uj(context);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 133, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c implements com.byazt.g.c.InterfaceC0409c {
        public final n c;
        public final int tt;
        public JSONObject ve;

        public c(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0593tt interfaceC0593tt) {
            this.ve = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.tt = iOptInt;
            this.c = new n(context, intent, i, interfaceC0593tt, iOptInt);
        }

        @Override // com.byazt.g.c.InterfaceC0409c
        public void tt() {
            if (!this.c.i) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.c.f29228a.sendMessage(messageObtain);
            }
            com.byazt.g.c.c().tt(this);
            c unused = tt.ve = null;
        }

        @Override // com.byazt.g.c.InterfaceC0409c
        public void ve() {
            int iOptInt = this.ve.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.c.f29228a.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.c.f29228a.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 133, 1697})
    public static class n implements x.c {
        public static int c;
        public static int tt;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f29228a;
        public boolean i = false;
        public final InterfaceC0593tt n;
        public final long sp;
        public final Intent uj;
        public final Context ve;
        public Future<Boolean> x;

        public n(Context context, Intent intent, int i, InterfaceC0593tt interfaceC0593tt, long j) {
            this.ve = context;
            this.uj = intent;
            tt = i;
            this.n = interfaceC0593tt;
            this.f29228a = new x(Looper.getMainLooper(), this);
            this.sp = j;
        }

        @Override // com.byazt.u.x.c
        public void c(Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1) {
                    long j = this.sp;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    c = 1;
                    this.x = com.byazt.zz.ve.t().submit(new uj(this.f29228a, this.ve, this.n, this.sp));
                    return;
                }
                if (i == 2) {
                    c = 2;
                    this.f29228a.removeMessages(2);
                    this.f29228a.removeMessages(1);
                    Future<Boolean> future = this.x;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.i && (Build.VERSION.SDK_INT < 29 || com.byazt.g.c.c().tt())) {
                        Intent intent = this.uj;
                        if (intent != null) {
                            tt.tt(this.ve, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.ve).getDownloadInfo(tt);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.byazt.z.ve.tt(this.ve, tt, false);
                            }
                        }
                        this.i = true;
                    }
                    tt.tt(tt, this.uj == null, tt.c(this.ve));
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.z.tt$tt, reason: collision with other inner class name */
    public interface InterfaceC0593tt {
        boolean c(@NonNull Context context);
    }

    @com.byazt.zqa.c(c = {0, 1, 133, 1886})
    public static class uj implements Callable<Boolean> {
        public final Context c;
        public final InterfaceC0593tt tt;
        public final long uj;
        public final Handler ve;

        public uj(Handler handler, Context context, InterfaceC0593tt interfaceC0593tt, long j) {
            this.c = context;
            this.tt = interfaceC0593tt;
            this.ve = handler;
            this.uj = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                InterfaceC0593tt interfaceC0593tt = this.tt;
                if (interfaceC0593tt != null) {
                    long j = this.uj;
                    if (j > 0 && j <= 10000) {
                        Context context = this.c;
                        boolean zC = context != null ? interfaceC0593tt.c(context) : false;
                        Message messageObtain = Message.obtain();
                        if (zC) {
                            messageObtain.what = 2;
                            this.ve.sendMessage(messageObtain);
                        } else {
                            messageObtain.what = 1;
                            this.ve.sendMessageDelayed(messageObtain, this.uj);
                        }
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            } catch (Throwable unused) {
            }
        }
    }

    public interface ve {
        void c(DownloadInfo downloadInfo, com.byazt.z.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean n(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean uj(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean tt(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.byazt.z.c cVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            cVar.uj = "custom";
            com.byazt.a.c cVarC = com.byazt.a.uj.c(context, "custom", jSONObject, downloadInfo);
            if (cVarC != null && cVarC.c()) {
                Intent intentTt = cVarC.tt();
                if (intentTt == null) {
                    return false;
                }
                if (!c(new File(savePath), downloadInfo, jSONObject)) {
                    cVar.tt = 6;
                } else {
                    if (tt(context, intentTt)) {
                        cVar.tt = 0;
                        return true;
                    }
                    cVar.tt = 1;
                }
                return false;
            }
            cVar.tt = 3;
        }
        return false;
    }

    private static void uj(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zz.ve.bm().tt(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void ve(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zz.ve.bm().tt(i, "guide_auth_open_setting", jSONObject2);
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray jSONArrayN = com.byazt.k.c.c(downloadInfo.getId()).n("ah_plans");
        if (jSONArrayN == null) {
            return false;
        }
        int length = jSONArrayN.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayN.optJSONObject(i);
            if (com.byazt.i.c.c(jSONObjectOptJSONObject) && c(context, downloadInfo, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:103:0x018b  */
    /* JADX WARN: Code duplicated, block: B:106:0x019c  */
    /* JADX WARN: Code duplicated, block: B:93:0x015e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0166 A[PHI: r15
      0x0166: PHI (r15v13 com.byazt.z.c) = (r15v2 com.byazt.z.c), (r15v8 com.byazt.z.c), (r15v14 com.byazt.z.c) binds: [B:94:0x0164, B:84:0x013c, B:60:0x00e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x0168  */
    private static boolean c(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        com.byazt.z.c cVarC;
        boolean zC;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            com.byazt.z.c cVar = new com.byazt.z.c();
            String strOptString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(strOptString)) {
                com.byazt.k.c cVarC2 = com.byazt.k.c.c(downloadInfo);
                cVar.c = strOptString;
                strOptString.hashCode();
                switch (strOptString) {
                    case "plan_a":
                    case "plan_e":
                        if (!downloadInfo.isSavePathRedirected()) {
                            cVar.tt = downloadInfo.getAntiHijackErrorCode(-1);
                        } else {
                            cVarC = c(jSONObject, cVarC2);
                            if (cVarC.tt == 0) {
                                cVar = cVarC;
                            } else if (!strOptString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                cVar.tt = downloadInfo.getAntiHijackErrorCode(10);
                            } else {
                                zC = c(context, downloadInfo, jSONObject, cVar);
                                z2 = zC;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                    case "plan_b":
                        cVarC = c(jSONObject, cVarC2);
                        if (cVarC.tt != 0) {
                            cVar = cVarC;
                        } else if (!downloadInfo.isSavePathRedirected()) {
                            cVar.tt = downloadInfo.getAntiHijackErrorCode(-1);
                        } else {
                            zC = tt(context, downloadInfo, jSONObject, cVar);
                            z2 = zC;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                    case "plan_c":
                        if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                            if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                zC = c(context, intent, jSONObject, downloadInfo.getId(), cVar);
                                z2 = zC;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                    case "plan_d":
                        cVar.c = "plan_d";
                        if (!com.byazt.i.n.uj()) {
                            cVar.tt = 2;
                        } else {
                            try {
                                com.byazt.z.ve.c(context, intent);
                                cVar.tt = 0;
                                z2 = true;
                            } catch (Throwable th) {
                                cVar.tt = 4;
                                cVar.ve = th.toString();
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                    case "plan_f":
                        cVarC = c(jSONObject, cVarC2);
                        if (cVarC.tt == 0) {
                            if (!strOptString.equals("plan_f")) {
                            }
                            zC = c(context, downloadInfo, jSONObject, cVar);
                            z2 = zC;
                            break;
                        } else {
                            cVar = cVarC;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                    case "plan_g":
                        cVarC = tt(jSONObject, cVarC2);
                        if (cVarC.tt != 0) {
                            cVar = cVarC;
                        } else {
                            zC = c(context, downloadInfo, jSONObject, cVar, cVarC2);
                            z2 = zC;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                    case "plan_h":
                        String strC = com.byazt.i.ve.c(cVarC2.ve("bh"), cVarC2.ve("s"));
                        com.byazt.z.c cVarC3 = c(jSONObject, strC, context, cVarC2);
                        if (cVarC3.tt != 0) {
                            cVar = cVarC3;
                        } else {
                            String packageName = context.getPackageName();
                            if (com.byazt.i.c.c(com.byazt.k.c.tt(), context, strC)) {
                                try {
                                    com.byazt.z.ve.c(context, intent);
                                    cVar.tt = 0;
                                    com.byazt.i.c.c(com.byazt.k.c.tt(), context, packageName);
                                    z2 = true;
                                } catch (Throwable th2) {
                                    try {
                                        cVar.tt = 1;
                                        cVar.ve = th2.toString();
                                        com.byazt.i.c.c(com.byazt.k.c.tt(), context, packageName);
                                    } catch (Throwable th3) {
                                        com.byazt.i.c.c(com.byazt.k.c.tt(), context, packageName);
                                        throw th3;
                                    }
                                }
                            } else {
                                cVar.tt = 11;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                    default:
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", cVar.c());
                        }
                        if (tt != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            tt.c(downloadInfo, cVar);
                            break;
                        }
                        break;
                }
            }
        }
        return z2;
    }

    public static com.byazt.z.c tt(JSONObject jSONObject, com.byazt.k.c cVar) {
        com.byazt.z.c cVar2 = new com.byazt.z.c();
        if (jSONObject == null) {
            return cVar2;
        }
        cVar2.c = jSONObject.optString("type");
        cVar2.n = "vbi";
        if (com.byazt.a.uj.c(com.byazt.zz.ve.ic(), "vbi", jSONObject, cVar)) {
            cVar2.tt = 0;
        } else {
            c(cVar2, 3);
        }
        return cVar2;
    }

    public static void tt(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zz.ve.bm().tt(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put("result_code", i2);
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zz.ve.bm().tt(i, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(Context context, Intent intent) {
        return c(context, intent, true);
    }

    private static boolean c(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.byazt.z.c cVar, com.byazt.k.c cVar2) {
        boolean zTt;
        String strOptString = jSONObject.optString("type");
        cVar.c = strOptString;
        Intent intentTt = com.byazt.a.uj.c(context, "vbi", jSONObject, downloadInfo).tt();
        StringBuilder sb = new StringBuilder();
        try {
            zTt = tt(context, intentTt);
        } catch (Throwable th) {
            sb.append(strOptString);
            sb.append(" startActivity failed : ");
            sb.append(c(th));
            c(cVar, 1);
            zTt = false;
        }
        if (!zTt) {
            cVar.ve = sb.toString();
        } else {
            cVar.tt = 0;
        }
        return true;
    }

    private static boolean c(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.byazt.z.c cVar) {
        String str;
        boolean z;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            cVar.n = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        z = false;
                        break;
                    }
                    str = strArrSplit[i];
                    com.byazt.a.c cVarC = com.byazt.a.uj.c(context, str, jSONObject, downloadInfo);
                    if (cVarC != null) {
                        Intent intentTt = cVarC.tt();
                        if (intentTt != null) {
                            if (c(file, downloadInfo, jSONObject)) {
                                z = true;
                                try {
                                    c(context, intentTt, false);
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str);
                                    sb.append(" startActivity failed : ");
                                    sb.append(c(th));
                                    c(cVar, 1);
                                }
                            } else {
                                c(cVar, 6);
                                sb.append(str);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            c(cVar, 3);
                            sb.append(str);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append(q.a.i);
                    i++;
                }
                if (!z) {
                    cVar.ve = sb.toString();
                } else {
                    cVar.uj = str;
                    cVar.tt = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int c(@NonNull com.byazt.k.c cVar) {
        JSONObject jSONObjectUj = cVar.uj("download_dir");
        if (!(jSONObjectUj != null ? !TextUtils.isEmpty(jSONObjectUj.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.byazt.k.c.ve().c("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayN = cVar.n("ah_plans");
        int i = -1;
        if (jSONArrayN != null) {
            int length = jSONArrayN.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayN.optJSONObject(i2);
                if (com.byazt.i.c.c(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if (!"plan_a".equals(strOptString) && !"plan_b".equals(strOptString) && !"plan_e".equals(strOptString) && !"plan_f".equals(strOptString)) {
                        if ("plan_d".equalsIgnoreCase(strOptString) || "plan_h".equalsIgnoreCase(strOptString) || ("plan_g".equalsIgnoreCase(strOptString) && (i = tt(jSONObjectOptJSONObject, cVar).tt) == 0)) {
                            return 0;
                        }
                    } else {
                        i = c(jSONObjectOptJSONObject, cVar).tt;
                        if (i == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i;
    }

    @NonNull
    public static com.byazt.z.c c(JSONObject jSONObject, com.byazt.k.c cVar) {
        com.byazt.z.c cVar2 = new com.byazt.z.c();
        if (jSONObject == null) {
            return cVar2;
        }
        String strOptString = jSONObject.optString("type");
        cVar2.c = strOptString;
        if ("plan_b".equals(strOptString)) {
            cVar2.n = "custom";
            if (com.byazt.a.uj.c(com.byazt.zz.ve.ic(), "custom", jSONObject, cVar)) {
                cVar2.tt = 0;
                return cVar2;
            }
            c(cVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            cVar2.n = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.byazt.a.uj.c(com.byazt.zz.ve.ic(), str, jSONObject, cVar)) {
                        cVar2.tt = 0;
                        return cVar2;
                    }
                    c(cVar2, 3);
                }
            }
        }
        return cVar2;
    }

    public static com.byazt.z.c c(JSONObject jSONObject, String str, Context context, com.byazt.k.c cVar) {
        com.byazt.z.c cVar2 = new com.byazt.z.c();
        if (jSONObject != null && com.byazt.i.n.ve()) {
            cVar2.c = jSONObject.optString("type");
            if (cVar.c("bi", 0) == 1) {
                cVar2.tt = 0;
                return cVar2;
            }
            if (c(context)) {
                cVar2.tt = 2;
            } else if (com.byazt.i.c.c(str) != null) {
                cVar2.tt = 0;
            } else {
                cVar2.tt = 9;
            }
        }
        return cVar2;
    }

    private static void c(com.byazt.z.c cVar, int i) {
        int i2 = cVar.tt;
        if (i2 != -1) {
            cVar.tt = (i2 * 10) + i;
        } else {
            cVar.tt = i;
        }
    }

    private static boolean c(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectUj = com.byazt.k.c.c(downloadInfo.getId()).uj("download_dir");
        File file2 = null;
        String strOptString = jSONObjectUj != null ? jSONObjectUj.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(path + File.separator + strOptString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean c(Context context, @Nullable Intent intent, JSONObject jSONObject, int i, @Nullable com.byazt.z.c cVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferencesTt.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !c(context)) {
                sharedPreferencesTt.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (c(context, intent2, false)) {
                            uj(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (cVar != null) {
                            cVar.tt = 1;
                            cVar.ve = "tryShowUnknownSourceDialog" + c(th);
                        }
                        return false;
                    }
                }
                if (c(context, intent, i, jSONObject)) {
                    ve(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context, @Nullable Intent intent, int i, JSONObject jSONObject) {
        try {
            com.byazt.i.n.ve();
            if (context.getApplicationInfo().targetSdkVersion >= 26 && !n(context)) {
                com.byazt.a.tt ttVar = new com.byazt.a.tt(context);
                if (ttVar.c()) {
                    c(context, intent, i, jSONObject, new InterfaceC0593tt() { // from class: com.byazt.z.tt.2
                        @Override // com.byazt.z.tt.InterfaceC0593tt
                        public boolean c(@NonNull Context context2) {
                            return tt.n(context2);
                        }
                    });
                    return tt(context, ttVar.tt());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return true;
        }
        try {
            com.byazt.i.n.ve();
            if (context.getApplicationInfo().targetSdkVersion >= 26) {
                return n(context);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static boolean c() {
        return n.c == 1;
    }

    public static void c(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zz.ve.bm().tt(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void c(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0593tt interfaceC0593tt) {
        if (ve != null) {
            com.byazt.g.c.c().tt(ve);
            ve = null;
        }
        ve = new c(context, intent, i, jSONObject, interfaceC0593tt);
        com.byazt.g.c.c().c(ve);
    }

    public static boolean c(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String c(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    public static void c(ve veVar) {
        tt = veVar;
    }
}
