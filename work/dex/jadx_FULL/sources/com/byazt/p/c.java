package com.byazt.p;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.w.a;
import com.byazt.zz.Downloader;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 350, 20})
public class c extends com.byazt.n.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28932a;
    public String n;
    public final Context tt;
    public String uj;
    public final Resources ve;

    public c(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.n = str2;
        this.uj = str3;
        this.f28932a = str4;
        Context applicationContext = context.getApplicationContext();
        this.tt = applicationContext;
        this.ve = applicationContext.getResources();
    }

    @Override // com.byazt.n.c
    public void c(DownloadInfo downloadInfo) {
        super.c(downloadInfo);
        this.n = downloadInfo.getSavePath();
        this.uj = downloadInfo.getName();
        this.f28932a = downloadInfo.getExtra();
    }

    @Override // com.byazt.n.c
    public void c(BaseException baseException, boolean z) {
        if (this.tt == null) {
            return;
        }
        try {
            com.byazt.s.ve veVarC = com.byazt.z.uj.sl().c();
            if (veVarC != null) {
                this.c = c(veVarC, baseException, z);
            }
            c(this.c);
        } catch (Exception e) {
            m.c(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:64:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:65:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:67:0x0205 A[PHI: r6 r21 r22
      0x0205: PHI (r6v14 com.byazt.m.BaseException) = 
      (r6v10 com.byazt.m.BaseException)
      (r6v10 com.byazt.m.BaseException)
      (r6v10 com.byazt.m.BaseException)
      (r6v24 com.byazt.m.BaseException)
     binds: [B:93:0x0293, B:95:0x0296, B:96:0x0298, B:66:0x01f8] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r21v8 com.byazt.k.c) = (r21v6 com.byazt.k.c), (r21v6 com.byazt.k.c), (r21v6 com.byazt.k.c), (r21v12 com.byazt.k.c) binds: [B:93:0x0293, B:95:0x0296, B:96:0x0298, B:66:0x01f8] A[DONT_GENERATE, DONT_INLINE]
      0x0205: PHI (r22v5 java.lang.Object) = (r22v2 java.lang.Object), (r22v2 java.lang.Object), (r22v2 java.lang.Object), (r22v7 java.lang.Object) binds: [B:93:0x0293, B:95:0x0296, B:96:0x0298, B:66:0x01f8] A[DONT_GENERATE, DONT_INLINE]] */
    private Notification c(com.byazt.s.ve veVar, BaseException baseException, boolean z) {
        com.byazt.k.c cVar;
        boolean z2;
        int i;
        c cVar2;
        BaseException baseException2;
        Object obj;
        boolean z3;
        Object obj2;
        boolean z4;
        int iN = n();
        int iC = com.byazt.z.ve.c(iN);
        if (iC == 0) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("click_type", Integer.valueOf(iC));
        int iC2 = c();
        map.put("click_download_id", Integer.valueOf(iC2));
        com.byazt.k.c cVarC = com.byazt.k.c.c(iC2);
        long jTt = tt();
        long jVe = ve();
        int i2 = jVe > 0 ? (int) ((100 * jTt) / jVe) : 0;
        String strUj = uj();
        int iTt = cVarC.tt("notification_opt_2");
        map.put("notification_opt_2", Integer.valueOf(iTt));
        if (iTt != 1) {
            map.put("action_click_btn", "android.ss.intent.action.DOWNLOAD_CLICK_BTN");
        }
        int iTt2 = cVarC.tt("enable_notification_ui");
        map.put("enable_notification_ui", Integer.valueOf(iTt2));
        map.put("show_title", strUj);
        map.put("percent", Integer.valueOf(i2));
        map.put("indeterminate", Boolean.valueOf(z));
        map.put("notification_type", Integer.valueOf(iC));
        String strDa = com.byazt.z.uj.sl().da();
        int i3 = Build.VERSION.SDK_INT;
        if (TextUtils.isEmpty(strDa)) {
            strDa = com.byazt.z.ve.c(this.tt);
        }
        map.put("channel_id", strDa);
        map.put("download_status", Integer.valueOf(iN));
        map.put("first_time", Long.valueOf(a()));
        if (cVarC.c("set_notification_group", 0) == 1) {
            map.put("notification_group", "com.ss.android.socialbase.APP_DOWNLOADER");
        }
        map.put("csj_enable_target_34", Boolean.valueOf(i3 >= 31 && com.byazt.k.c.c(iC2).tt("enable_target_34") > 0));
        if (iTt2 > 0) {
            map.put("bitmap", ve.c().c(iC2));
        }
        if (iC == 1 || iC == 4) {
            cVar = cVarC;
            z2 = false;
            map.put("download_size", com.byazt.z.ve.c(jTt) + WVNativeCallbackUtil.SEPERATER + com.byazt.z.ve.c(jVe));
            i = iC;
            if (i == 1) {
                map.put("download_status", Integer.valueOf(n()));
            }
            cVar2 = this;
            map.put("is_bind_app", Boolean.valueOf(com.byazt.z.ve.c(cVar2.f28932a)));
        } else if (iC == 2) {
            map.put("download_size", com.byazt.z.ve.c(jTt) + WVNativeCallbackUtil.SEPERATER + com.byazt.z.ve.c(jVe));
            if (iTt == 1) {
                map.put("progress_70", Integer.valueOf(cVarC.c("noti_progress_show_th", 70)));
            }
            map.put("is_bind_app", Boolean.valueOf(com.byazt.z.ve.c(this.f28932a)));
            if (!com.byazt.z.ve.c(this.f28932a) && iTt2 >= 2) {
                map.put("download_size", com.byazt.z.ve.c(jTt, false) + WVNativeCallbackUtil.SEPERATER + com.byazt.z.ve.c(jVe, false));
            }
            cVar = cVarC;
            z2 = false;
            cVar2 = this;
            i = iC;
        } else if (iC == 3) {
            DownloadInfo downloadInfo = Downloader.getInstance(com.byazt.zz.ve.ic()).getDownloadInfo(iC2);
            int iN2 = n();
            map.put("download_status", Integer.valueOf(iN2));
            if (iN2 == -1 || iN2 == -4) {
                cVar = cVarC;
                boolean zI = a.i(baseException);
                boolean zX = a.x(baseException);
                map.put("is_network_error", Boolean.valueOf(zI));
                map.put("is_insufficient_space_error", Boolean.valueOf(zX));
                if (iTt2 >= 2 && iN2 == -1 && (zI || zX)) {
                    map.put("download_size", com.byazt.z.ve.c(jTt) + WVNativeCallbackUtil.SEPERATER + com.byazt.z.ve.c(jVe));
                }
                baseException2 = baseException;
                if (baseException2 != null) {
                    obj = "download_size";
                    if (baseException.getErrorCode() == 1006) {
                        map.put("is_error_code_insufficient_space_error", Boolean.TRUE);
                    }
                    if (iTt2 < 2 && iN2 == -1 && zI) {
                        obj2 = "is_wait_wifi_and_in_net";
                        map.put(obj2, Boolean.valueOf(a.tt(baseException2, downloadInfo)));
                    } else {
                        obj2 = "is_wait_wifi_and_in_net";
                    }
                } else {
                    obj = "download_size";
                }
                if (c(baseException2, cVar, downloadInfo)) {
                    map.put("is_need_show_wait_net_text", Boolean.TRUE);
                    if (downloadInfo == null || !downloadInfo.isOnlyWifi()) {
                        cVar = cVar;
                        cVar = cVar;
                        z3 = false;
                    } else {
                        cVar = cVar;
                        z3 = true;
                    }
                    map.put("is_wait_wifi", Boolean.valueOf(z3));
                } else {
                    cVar = cVar;
                }
                if (iTt2 < 2) {
                    obj2 = "is_wait_wifi_and_in_net";
                } else {
                    obj2 = "is_wait_wifi_and_in_net";
                }
            } else if (iN2 == -3) {
                map.put("download_size", com.byazt.z.ve.c(jVe));
                if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.getMimeType())) {
                    cVar = cVarC;
                } else {
                    cVar = cVarC;
                    boolean z5 = downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK);
                    map.put("is_mime_apk", Boolean.valueOf(z5));
                    map.put("is_apk_installed", Boolean.valueOf(com.byazt.z.ve.c(this.tt, downloadInfo, false)));
                    if (com.byazt.zz.uj.c().u(iC2) != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    map.put("is_have_notification_click_callback", Boolean.valueOf(z4));
                    baseException2 = baseException;
                    obj = "download_size";
                    obj2 = "is_wait_wifi_and_in_net";
                }
                map.put("is_mime_apk", Boolean.valueOf(z5));
                map.put("is_apk_installed", Boolean.valueOf(com.byazt.z.ve.c(this.tt, downloadInfo, false)));
                if (com.byazt.zz.uj.c().u(iC2) != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                map.put("is_have_notification_click_callback", Boolean.valueOf(z4));
                baseException2 = baseException;
                obj = "download_size";
                obj2 = "is_wait_wifi_and_in_net";
            } else {
                cVar = cVarC;
                obj = "download_size";
                obj2 = "is_wait_wifi_and_in_net";
                baseException2 = baseException;
            }
            boolean zI2 = a.i(baseException);
            boolean zX2 = a.x(baseException);
            map.put("is_network_error", Boolean.valueOf(zI2));
            map.put("is_insufficient_space_error", Boolean.valueOf(zX2));
            if (iTt2 >= 2 && iN2 == -1 && (zI2 || zX2)) {
                boolean zTt = a.tt(baseException2, downloadInfo);
                map.put(obj2, Boolean.valueOf(zTt));
                if (zTt) {
                    StringBuilder sb = new StringBuilder();
                    z2 = false;
                    sb.append(com.byazt.z.ve.c(jTt, false));
                    sb.append(WVNativeCallbackUtil.SEPERATER);
                    sb.append(com.byazt.z.ve.c(jVe, false));
                    map.put(obj, sb.toString());
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            cVar2 = this;
            i = iC;
        } else {
            cVar = cVarC;
            z2 = false;
            i = iC;
            cVar2 = this;
        }
        String str = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (i == 1 || i == 4 || i == 2) {
            map.put("action_apa", "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT");
        } else if (i == 3) {
            if (iN != -1 && iN != -4) {
                if (iN == -3) {
                    map.put("auto_cancel", Boolean.valueOf(cVar.c("notification_click_install_auto_cancel", 1) == 0 ? true : z2));
                }
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            map.put("action_complete", str);
            map.put("action_hide", "android.ss.intent.action.DOWNLOAD_HIDE");
        }
        Notification notification = (Notification) veVar.c(map).get("notification");
        cVar2.c = notification;
        return notification;
    }

    private boolean c(BaseException baseException, com.byazt.k.c cVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && cVar.c("notification_text_opt", 0) == 1;
    }
}
