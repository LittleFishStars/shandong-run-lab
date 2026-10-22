package com.byazt.zj;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.c.IDownloadListener;
import com.byazt.ev.EnqueueType;
import com.byazt.m.BaseException;
import com.byazt.omf.gt;
import com.byazt.t.DownloadInfo;
import com.byazt.t.DownloadTask;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 20})
public class c implements IDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29239a;
    public String c;
    public String n;
    public String tt;
    public InterfaceC0596c uj;
    public String ve;
    public int sp = 0;
    public boolean x = true;

    /* JADX INFO: renamed from: com.byazt.zj.c$c, reason: collision with other inner class name */
    public interface InterfaceC0596c {
        void c(DownloadInfo downloadInfo);

        void c(DownloadInfo downloadInfo, int i);

        void c(DownloadInfo downloadInfo, BaseException baseException);

        void c(DownloadInfo downloadInfo, BaseException baseException, int i);

        void tt(DownloadInfo downloadInfo);

        void tt(DownloadInfo downloadInfo, int i);
    }

    public c(String str, String str2, String str3, String str4, boolean z, InterfaceC0596c interfaceC0596c) {
        this.c = str2;
        this.tt = str3;
        this.ve = str4;
        this.uj = interfaceC0596c;
        this.n = str;
        this.f29239a = z;
    }

    public void c(Context context) {
        DownloadTask downloadTaskMonitorScene = com.byazt.zz.tt.with(context).url(this.c).name(this.ve).onlyWifi(this.f29239a).savePath(new File(this.tt).getAbsolutePath()).downloadSetting(c()).enqueueType(EnqueueType.ENQUEUE_TAIL).needIndependentProcess(false).subThreadListener(this).monitorScene("plugin_downloader");
        com.byazt.k.c.c(com.byazt.zz.ve.c(this.c, new File(this.tt).getAbsolutePath()), c());
        downloadTaskMonitorScene.asyncDownload(null);
    }

    @Override // com.byazt.c.IDownloadListener
    public void onCanceled(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (!this.x) {
            InterfaceC0596c interfaceC0596c = this.uj;
            if (interfaceC0596c != null) {
                interfaceC0596c.c(downloadInfo, baseException, this.sp);
                return;
            }
            return;
        }
        this.x = false;
        InterfaceC0596c interfaceC0596c2 = this.uj;
        if (interfaceC0596c2 != null) {
            interfaceC0596c2.c(downloadInfo, baseException);
        }
    }

    @Override // com.byazt.c.IDownloadListener
    public void onFirstStart(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onFirstSuccess(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
    }

    @Override // com.byazt.c.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        int i = this.sp + 1;
        this.sp = i;
        InterfaceC0596c interfaceC0596c = this.uj;
        if (interfaceC0596c != null) {
            if (this.x) {
                interfaceC0596c.c(downloadInfo);
            } else {
                interfaceC0596c.tt(downloadInfo, i);
            }
        }
    }

    @Override // com.byazt.c.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (!this.x) {
            InterfaceC0596c interfaceC0596c = this.uj;
            if (interfaceC0596c != null) {
                interfaceC0596c.c(downloadInfo, this.sp);
                return;
            }
            return;
        }
        this.x = false;
        InterfaceC0596c interfaceC0596c2 = this.uj;
        if (interfaceC0596c2 != null) {
            interfaceC0596c2.tt(downloadInfo);
        }
    }

    private JSONObject c() {
        JSONObject jSONObjectPo = gt.tt().po();
        if (jSONObjectPo == null) {
            return null;
        }
        String strOptString = jSONObjectPo.optString("config");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(this.n);
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("default");
            if (jSONObjectOptJSONObject2 != null) {
                return jSONObjectOptJSONObject2;
            }
        } catch (JSONException unused) {
        }
        return null;
    }
}
