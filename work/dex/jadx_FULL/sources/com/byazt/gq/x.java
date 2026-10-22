package com.byazt.gq;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.ar.AdDownloadModel;
import com.byazt.c.IDownloadListener;
import com.byazt.e.DownloadShortInfo;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.ou.rl;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import com.hjq.permissions.Permission;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 71})
public class x implements com.byazt.hu.yp.c {
    public com.byazt.nn.n c;
    public tt n;
    public long tt;
    public n uj;
    public boolean ve = false;

    @com.byazt.zqa.c(c = {0, 1, 52, 62})
    public static class c extends com.byazt.c.c {
        public com.byazt.hu.yp c;

        public c(com.byazt.hu.yp ypVar) {
            this.c = ypVar;
        }

        @Override // com.byazt.c.c, com.byazt.c.my
        public void c(DownloadInfo downloadInfo) {
            c(downloadInfo, 11);
        }

        @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            c(downloadInfo, -4);
        }

        @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            c(downloadInfo, -1);
        }

        @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            c(downloadInfo, -2);
        }

        @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            c(downloadInfo, 1);
        }

        @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            c(downloadInfo, 4);
        }

        @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            c(downloadInfo, 2);
        }

        @Override // com.byazt.c.AbsDownloadListener, com.byazt.c.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            c(downloadInfo, -3);
        }

        private void c(DownloadInfo downloadInfo, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i;
            this.c.sendMessage(messageObtain);
        }
    }

    public interface tt {
        void c(DownloadInfo downloadInfo);
    }

    public x(n nVar) {
        this.uj = nVar;
    }

    private boolean a() {
        return com.byazt.hu.u.c(this.c.tt) && i.c(this.c.uj.getLinkMode());
    }

    private boolean n() {
        return this.c.uj.isAddToDownloadManage();
    }

    private boolean uj() {
        DownloadModel downloadModel = this.c.tt;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.c.tt.getDownloadUrl())) ? false : true;
    }

    private boolean ve() {
        return uj() && n();
    }

    @Override // com.byazt.hu.yp.c
    public void c(Message message) {
    }

    public void tt(@Nullable DownloadInfo downloadInfo) {
        tt ttVar = this.n;
        if (ttVar != null) {
            ttVar.c(downloadInfo);
            this.n = null;
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.byazt.w.a.uj(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean n(DownloadInfo downloadInfo) {
        return !com.byazt.hu.u.c(this.c.tt) && a(downloadInfo);
    }

    public void c(long j) {
        this.tt = j;
        com.byazt.nn.n nVarN = com.byazt.nn.a.c().n(j);
        this.c = nVarN;
        if (nVarN.gr()) {
            com.byazt.dm.ve.c().c("setAdId ModelBox notValid");
        }
    }

    public void ve(DownloadInfo downloadInfo) {
        if (!i.c(this.c.tt) || this.ve) {
            return;
        }
        com.byazt.zn.c.c().c("file_status", (downloadInfo == null || !com.byazt.hu.u.tt(downloadInfo.getTargetFilePath())) ? 2 : 1, this.c);
        this.ve = true;
    }

    private void tt(final rl rlVar) {
        String str;
        if (com.byazt.hu.da.tt("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (rlVar != null) {
                rlVar.c();
                return;
            }
            return;
        }
        if (com.byazt.hu.u.c()) {
            str = Permission.READ_MEDIA_IMAGES;
            if (com.byazt.hu.da.tt(Permission.READ_MEDIA_IMAGES) || com.byazt.hu.da.tt(Permission.READ_MEDIA_AUDIO) || com.byazt.hu.da.tt(Permission.READ_MEDIA_VIDEO)) {
                if (rlVar != null) {
                    rlVar.c();
                    return;
                }
                return;
            }
        } else {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        }
        com.byazt.hu.da.c(new String[]{str}, new com.byazt.hu.da.c() { // from class: com.byazt.gq.x.2
            @Override // com.byazt.hu.da.c
            public void c() {
                rl rlVar2 = rlVar;
                if (rlVar2 != null) {
                    rlVar2.c();
                }
            }

            @Override // com.byazt.hu.da.c
            public void c(String str2) {
                rl rlVar2 = rlVar;
                if (rlVar2 != null) {
                    rlVar2.c(str2);
                }
            }
        });
    }

    public boolean uj(DownloadInfo downloadInfo) {
        return a() || n(downloadInfo);
    }

    public void c(DownloadInfo downloadInfo) {
        this.ve = false;
        tt(downloadInfo);
    }

    public boolean c(Context context, int i, boolean z) {
        if (com.byazt.hu.u.c(this.c.tt)) {
            com.byazt.dd.tt ttVarUj = com.byazt.nn.a.c().uj(this.c.c);
            if (ttVarUj != null) {
                com.byazt.n.tt.c().a(ttVarUj.my());
            }
            return com.byazt.us.c.c(this.c);
        }
        if (c(i) && !TextUtils.isEmpty(this.c.tt.getPackageName()) && t.i().optInt("disable_market") != 1) {
            if (com.byazt.us.c.c(this.c, i)) {
                return true;
            }
            return this.uj.i() && this.uj.uj(true);
        }
        if (!z || this.c.uj.getDownloadMode() != 4 || this.uj.n()) {
            return false;
        }
        this.uj.ve(true);
        return true;
    }

    @Nullable
    public String tt() {
        File externalFilesDir = t.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.byazt.su.c> tt(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.byazt.su.c) {
                    arrayList.add((com.byazt.su.c) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.byazt.su.c) {
                            arrayList.add((com.byazt.su.c) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.byazt.su.c) {
                            arrayList.add((com.byazt.su.c) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean c(int i) {
        if (this.c.uj.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.c.uj.getDownloadMode() == 2 && i == 1 && t.i().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean c(int i, DownloadModel downloadModel) {
        return com.byazt.i.n.ve() && c(i) && !com.byazt.hu.u.c(downloadModel);
    }

    public boolean c(boolean z) {
        return !z && this.c.uj.getDownloadMode() == 1;
    }

    public void c(@NonNull final rl rlVar) {
        if (!TextUtils.isEmpty(this.c.tt.getFilePath())) {
            String filePath = this.c.tt.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                rlVar.c();
                return;
            }
            try {
                String parent = t.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (filePath.startsWith(parent)) {
                    rlVar.c();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        tt(new rl() { // from class: com.byazt.gq.x.1
            @Override // com.byazt.ou.rl
            public void c() {
                rlVar.c();
            }

            @Override // com.byazt.ou.rl
            public void c(String str) {
                t.ve().c(1, t.getContext(), x.this.c.tt, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.byazt.zn.c.c().tt(x.this.tt, 1);
                rlVar.c(str);
            }
        });
    }

    public void c(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        tt ttVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i = message.arg1;
        if (i != 1 && i != 6 && i == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.byazt.di.x xVarC = com.byazt.di.x.c();
                com.byazt.nn.n nVar = this.c;
                xVarC.c(nVar.tt, nVar.uj, nVar.ve);
                downloadInfo.setFirstDownload(false);
            }
            com.byazt.zn.c.c().c(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        da.c(downloadShortInfo);
        int iC = com.byazt.z.ve.c(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.byazt.k.c.ve().c("fix_click_start")) && (ttVar = this.n) != null) {
            ttVar.c(downloadInfo);
            this.n = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : c(map)) {
            if (iC != 1) {
                if (iC == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, da.c(downloadInfo.getId(), curBytes));
                } else if (iC == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.byazt.hu.u.c(this.c.tt)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, da.c(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.byazt.su.c> it = tt(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public void c() {
        if (this.n == null) {
            this.n = new tt() { // from class: com.byazt.gq.x.3
                @Override // com.byazt.gq.x.tt
                public void c(DownloadInfo downloadInfo) {
                    com.byazt.zn.c.c().c(x.this.tt, 2, downloadInfo);
                }
            };
        }
    }

    public int c(Context context, IDownloadListener iDownloadListener) {
        com.byazt.ie.c cVar;
        com.byazt.t.ve veVarC;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.c.tt.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (t.i().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.c.tt.getLogExtra()) && (veVarC = c(this.c.tt.getLogExtra())) != null) {
            arrayList.add(veVarC);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.byazt.t.ve(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strC = com.byazt.hu.uj.c(String.valueOf(this.c.tt.getId()), this.c.tt.getNotificationJumpUrl(), this.c.tt.isShowToast(), String.valueOf(this.c.tt.getModelType()));
        com.byazt.k.c cVarTt = com.byazt.hu.n.tt(this.c.tt);
        JSONObject jSONObjectC = com.byazt.hu.n.c(this.c.tt);
        if (!this.c.uj.enableAH()) {
            jSONObjectC = com.byazt.hu.u.c(jSONObjectC);
            com.byazt.hu.u.c(jSONObjectC, "ah_plans", new JSONArray());
        }
        int executorGroup = this.c.tt.getExecutorGroup();
        if (this.c.tt.isAd() || i.tt(this.c.tt)) {
            executorGroup = 4;
        }
        String strC2 = c(cVarTt);
        DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(com.byazt.zz.ve.c(this.c.tt.getDownloadUrl(), strC2));
        if (downloadInfo != null && 3 == this.c.tt.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.byazt.z.n nVarZ = new com.byazt.z.n(context, this.c.tt.getDownloadUrl()).tt(this.c.tt.getBackupUrls()).c(this.c.tt.getName()).n(strC).c(arrayList).c(this.c.tt.isShowNotification()).ve(this.c.tt.isNeedWifi()).tt(this.c.tt.getFileName()).ve(strC2).sl(this.c.tt.getAppIcon()).x(this.c.tt.getMd5()).da(this.c.tt.getSdkMonitorScene()).c(this.c.tt.getExpectFileLength()).c(iDownloadListener).t(this.c.tt.needIndependentProcess() || cVarTt.c("need_independent_process", 0) == 1).c(this.c.tt.getDownloadFileUriProvider()).tt(this.c.tt.autoInstallWithoutNotification()).sp(this.c.tt.getPackageName()).uj(1000).n(100).c(jSONObjectC).i(true).da(true).tt(cVarTt.c("retry_count", 5)).ve(cVarTt.c("backup_url_retry_count", 0)).da(true).u(cVarTt.c("need_head_connection", 0) == 1).uj(cVarTt.c("need_https_to_http_retry", 0) == 1).x(cVarTt.c("need_chunk_downgrade_retry", 1) == 1).sp(cVarTt.c("need_retry_delay", 0) == 1).i(cVarTt.ve("retry_delay_time_array")).sl(cVarTt.c("need_reuse_runnable", 0) == 1).a(executorGroup).m(this.c.tt.isAutoInstall()).z(this.c.tt.distinctDir());
        if (!TextUtils.isEmpty(this.c.tt.getMimeType())) {
            nVarZ.a(this.c.tt.getMimeType());
        } else {
            nVarZ.a(AdBaseConstants.MIME_APK);
        }
        if (cVarTt.c("notification_opt_2", 0) == 1) {
            nVarZ.c(false);
            nVarZ.tt(true);
        }
        if (cVarTt.c("clear_space_use_disk_handler", 0) == 1) {
            cVar = new com.byazt.ie.c();
            nVarZ.c(cVar);
        } else {
            cVar = null;
        }
        DownloadModel downloadModel = this.c.tt;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            nVarZ.uj(((AdDownloadModel) this.c.tt).getTaskKey());
        }
        int iC = i.c(this.c, ve(), nVarZ);
        if (cVar != null) {
            cVar.c(iC);
        }
        return iC;
    }

    private String c(com.byazt.k.c cVar) {
        boolean zTt;
        String strTt;
        if (!TextUtils.isEmpty(this.c.tt.getFilePath())) {
            return this.c.tt.getFilePath();
        }
        DownloadInfo downloadInfoC = com.byazt.z.uj.sl().c(t.getContext(), this.c.tt.getDownloadUrl());
        if (!com.byazt.hu.u.c()) {
            zTt = com.byazt.hu.da.tt("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            zTt = com.byazt.hu.da.tt(Permission.READ_MEDIA_IMAGES) || com.byazt.hu.da.tt(Permission.READ_MEDIA_AUDIO) || com.byazt.hu.da.tt(Permission.READ_MEDIA_VIDEO);
        }
        String strTt2 = tt();
        if (downloadInfoC != null && !TextUtils.isEmpty(downloadInfoC.getSavePath())) {
            String savePath = downloadInfoC.getSavePath();
            if (zTt || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strTt2) && savePath.startsWith(strTt2)) {
                    return savePath;
                }
            } catch (Exception e) {
                m.c(e);
            }
            Downloader.getInstance(com.byazt.zz.ve.ic()).cancel(downloadInfoC.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zTt ? 1 : 2));
        } catch (JSONException e2) {
            m.c(e2);
        }
        com.byazt.zn.c.c().c("label_external_permission", jSONObject, this.c);
        try {
            strTt = com.byazt.z.ve.tt();
        } catch (Exception unused) {
            strTt = null;
        }
        int iC = com.byazt.hu.n.c(cVar);
        if (iC != 0) {
            if (iC != 4 && (zTt || iC != 2)) {
                if ((iC == 3 || (!zTt && iC == 1)) && !TextUtils.isEmpty(strTt2)) {
                    return strTt2;
                }
            } else {
                File filesDir = t.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return strTt;
    }

    public void c(DownloadInfo downloadInfo, boolean z) {
        if (this.c.tt == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || i.c(this.c.tt) || (z && com.byazt.zn.ve.c().ve() && (status == -2 || status == -3))) {
            com.byazt.zn.c.c().c(this.tt, 2);
        }
        switch (status) {
            case -4:
            case -1:
                c();
                com.byazt.nn.a aVarC = com.byazt.nn.a.c();
                com.byazt.nn.n nVar = this.c;
                aVarC.c(new com.byazt.dd.tt(nVar.tt, nVar.ve, nVar.uj, downloadInfo.getId()));
                break;
            case -3:
                if (com.byazt.hu.u.c(this.c.tt)) {
                    com.byazt.dm.ve.c().tt("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.byazt.zn.c.c().c(this.tt, 5, downloadInfo);
                    if (z && com.byazt.zn.ve.c().tt() && !com.byazt.zn.ve.c().tt(this.tt, this.c.tt.getLogExtra())) {
                        com.byazt.zn.c.c().c(this.tt, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.byazt.zn.c.c().c(this.tt, 4, downloadInfo);
                if (z && com.byazt.zn.ve.c().tt() && !com.byazt.zn.ve.c().tt(this.tt, this.c.tt.getLogExtra())) {
                    com.byazt.zn.c.c().c(this.tt, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.byazt.zn.c.c().c(this.tt, 3, downloadInfo);
                break;
        }
    }

    public void c(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list, boolean z) {
        int curBytes;
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            try {
                curBytes = downloadInfo.getTotalBytes() > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes()) : 0;
            } catch (Exception e) {
                m.c(e);
            }
            int i = curBytes >= 0 ? curBytes : 0;
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            da.c(downloadShortInfo);
            for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                switch (downloadInfo.getStatus()) {
                    case -4:
                    case 0:
                        if (com.byazt.hu.u.c(this.c.tt)) {
                            downloadShortInfo.status = -3;
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onIdle();
                        }
                        break;
                    case -3:
                        if (z) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                        break;
                    case -2:
                        downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, da.c(downloadInfo.getId(), i));
                        break;
                    case -1:
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, da.c(downloadInfo.getId(), i));
                        break;
                    case 11:
                        if (!(downloadStatusChangeListener instanceof com.byazt.su.c)) {
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, da.c(downloadInfo.getId(), i));
                        }
                        break;
                }
            }
            return;
        }
        Iterator<DownloadStatusChangeListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
    }

    @NonNull
    public static List<DownloadStatusChangeListener> c(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.byazt.t.ve c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.byazt.t.ve("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            t.gt().c(e, "parseLogExtra Error");
            return null;
        }
    }
}
