package com.byazt.de;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.byazt.di.da;
import com.byazt.gq.t;
import com.byazt.hu.sl;
import com.byazt.hu.u;
import com.byazt.nn.a;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import com.ipd.dsp.internal.b1.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 111, 20})
public class c {
    public static final String c = "c";
    public static c tt;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tt f28393a;
    public String n;
    public boolean uj = false;

    @NonNull
    public CopyOnWriteArrayList<com.byazt.nn.c> ve;

    /* JADX INFO: renamed from: com.byazt.de.c$c, reason: collision with other inner class name */
    public interface InterfaceC0384c {
        void c();
    }

    private c() {
        tt ttVar = new tt();
        this.f28393a = ttVar;
        this.ve = ttVar.c("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static c c() {
        if (tt == null) {
            tt = new c();
        }
        return tt;
    }

    public void tt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.n = "";
        } else if (TextUtils.equals(this.n, str)) {
            this.n = "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:20:0x004f, B:22:0x005f, B:23:0x0069, B:25:0x006f, B:27:0x0077, B:29:0x0083, B:31:0x008b, B:33:0x009a, B:36:0x00c0, B:34:0x009e), top: B:40:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:21:0x005d  */
    /* JADX WARN: Code duplicated, block: B:25:0x006f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x000b, B:10:0x0019, B:15:0x0024, B:17:0x002c, B:20:0x004f, B:22:0x005f, B:23:0x0069, B:25:0x006f, B:27:0x0077, B:29:0x0083, B:31:0x008b, B:33:0x009a, B:36:0x00c0, B:34:0x009e), top: B:40:0x000b }] */
    private boolean c(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0384c interfaceC0384c) {
        long jLastModified;
        ListIterator<com.byazt.nn.c> listIterator;
        com.byazt.nn.c cVarPrevious;
        if (downloadInfo == null) {
            try {
                if (this.ve.isEmpty()) {
                    return false;
                }
                if (activity != null && !activity.isFinishing()) {
                    boolean z2 = true;
                    if (downloadInfo == null && this.ve.isEmpty()) {
                        c(activity, new com.byazt.nn.c(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0384c);
                        return true;
                    }
                    if (downloadInfo != null) {
                        jLastModified = new File(downloadInfo.getTargetFilePath()).lastModified();
                    } else {
                        jLastModified = 0;
                    }
                    CopyOnWriteArrayList<com.byazt.nn.c> copyOnWriteArrayList = this.ve;
                    listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
                    while (listIterator.hasPrevious()) {
                        cVarPrevious = listIterator.previous();
                        if (cVarPrevious == null && !u.n(t.getContext(), cVarPrevious.uj) && u.c(cVarPrevious.sp)) {
                            if (new File(cVarPrevious.sp).lastModified() >= jLastModified) {
                                c(activity, cVarPrevious, z, interfaceC0384c);
                            } else {
                                c(activity, new com.byazt.nn.c(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0384c);
                            }
                            sl.c(c, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                            return z2;
                        }
                    }
                    z2 = false;
                    sl.c(c, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                    return z2;
                }
            } catch (Exception e) {
                m.c(e);
            }
        } else if (activity != null) {
            boolean z3 = true;
            if (downloadInfo == null) {
            }
            if (downloadInfo != null) {
                jLastModified = new File(downloadInfo.getTargetFilePath()).lastModified();
            } else {
                jLastModified = 0;
            }
            CopyOnWriteArrayList<com.byazt.nn.c> copyOnWriteArrayList2 = this.ve;
            listIterator = copyOnWriteArrayList2.listIterator(copyOnWriteArrayList2.size());
            while (listIterator.hasPrevious()) {
                cVarPrevious = listIterator.previous();
                if (cVarPrevious == null) {
                }
            }
            z3 = false;
            sl.c(c, "tryShowInstallDialog isShow:".concat(String.valueOf(z3)), null);
            return z3;
        }
        return false;
    }

    @MainThread
    public boolean c(Activity activity, boolean z, InterfaceC0384c interfaceC0384c) {
        if (t.i().optInt("disable_install_app_dialog") == 1 || this.uj) {
            return false;
        }
        return c(activity, c(activity), z, interfaceC0384c);
    }

    public void c(Context context, com.byazt.nn.c cVar, boolean z, InterfaceC0384c interfaceC0384c) {
        this.ve.clear();
        c(context, cVar, interfaceC0384c, z);
        this.uj = true;
        da.c(context).ve();
        this.f28393a.tt("sp_ad_install_back_dialog", "key_uninstalled_list");
        sl.c(c, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo c(Context context) {
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            long jTt = da.c(context).tt();
            if (t.i().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
                long j = 0;
                for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                    if (downloadInfo2 != null && !u.n(context, downloadInfo2.getPackageName()) && u.c(downloadInfo2.getTargetFilePath())) {
                        long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (jLastModified >= jTt && downloadInfo2.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || jLastModified > j)) {
                                    downloadInfo = downloadInfo2;
                                    j = jLastModified;
                                }
                            } catch (Exception e) {
                                m.c(e);
                            }
                        }
                    }
                }
                return downloadInfo;
            }
            return null;
        } catch (Exception e2) {
            m.c(e2);
        }
    }

    public void c(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.ve.size(); i++) {
            com.byazt.nn.c cVar = this.ve.get(i);
            if (cVar != null && cVar.tt == j2) {
                this.ve.set(i, new com.byazt.nn.c(j, j2, j3, str, str2, str3, str4));
                this.f28393a.c("sp_ad_install_back_dialog", "key_uninstalled_list", this.ve);
                return;
            }
        }
        this.ve.add(new com.byazt.nn.c(j, j2, j3, str, str2, str3, str4));
        this.f28393a.c("sp_ad_install_back_dialog", "key_uninstalled_list", this.ve);
    }

    private void c(final Context context, final com.byazt.nn.c cVar, final InterfaceC0384c interfaceC0384c, boolean z) {
        final com.byazt.dd.tt ttVarUj = a.c().uj(cVar.tt);
        if (ttVarUj == null) {
            com.byazt.dm.ve.c().c("showBackInstallDialog nativeModel null");
            return;
        }
        com.byazt.ou.u uVarVe = t.ve();
        com.byazt.e.tt.c cVarC = new com.byazt.e.tt.c(context).c(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(cVar.n) ? "刚刚下载的应用" : cVar.n;
        uVarVe.tt(cVarC.tt(String.format("%1$s下载完成，是否立即安装？", objArr)).ve(b.a.o).uj(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).c(false).c(u.c(context, cVar.sp)).c(new com.byazt.e.tt.InterfaceC0394tt() { // from class: com.byazt.de.c.1
            @Override // com.byazt.e.tt.InterfaceC0394tt
            public void c(DialogInterface dialogInterface) {
                com.byazt.zn.c.c().tt("backdialog_install", ttVarUj);
                com.byazt.z.uj.c(context, (int) cVar.c);
                dialogInterface.dismiss();
            }

            @Override // com.byazt.e.tt.InterfaceC0394tt
            public void tt(DialogInterface dialogInterface) {
                com.byazt.zn.c.c().tt("backdialog_exit", ttVarUj);
                InterfaceC0384c interfaceC0384c2 = interfaceC0384c;
                if (interfaceC0384c2 != null) {
                    interfaceC0384c2.c();
                }
                c.this.tt("");
                dialogInterface.dismiss();
            }

            @Override // com.byazt.e.tt.InterfaceC0394tt
            public void ve(DialogInterface dialogInterface) {
                c.this.tt("");
            }
        }).c(1).c());
        com.byazt.zn.c.c().tt("backdialog_show", ttVarUj);
        this.n = cVar.uj;
    }

    public boolean c(String str) {
        return TextUtils.equals(this.n, str);
    }

    public void c(com.byazt.dd.tt ttVar) {
        if (t.i().optInt("enable_open_app_dialog", 0) == 1 && !ttVar.b() && ttVar.nu() && Build.VERSION.SDK_INT < 34) {
            ttVar.sl(true);
            TTDelegateActivity.c(ttVar);
        }
    }
}
