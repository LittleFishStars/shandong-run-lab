package com.byazt.gq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 13})
public class tt {
    public static volatile tt c;
    public Handler tt = null;

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public boolean tt() {
        return t.i().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void c(Context context, DownloadInfo downloadInfo) {
        if (tt() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                m.c(e);
            }
            if (this.tt == null) {
                this.tt = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.tt.post(new Runnable() { // from class: com.byazt.gq.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    t.ve().c(3, t.getContext(), null, "下载失败，请重试！", null, 0);
                    n nVarC = com.byazt.di.x.c().c(url);
                    if (nVarC != null) {
                        nVarC.sp();
                    }
                }
            });
        }
    }
}
