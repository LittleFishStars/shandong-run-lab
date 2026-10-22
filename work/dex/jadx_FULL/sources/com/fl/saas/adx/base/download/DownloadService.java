package com.fl.saas.adx.base.download;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1437u;
import com.fl.saas.C1415j;
import com.fl.saas.F;
import com.fl.saas.s2s.sdk.util.CommConstant;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownloadService extends IntentService {
    private F downLoadSupportPauseUtil;
    private String downloadUrl;
    private boolean haveComplete;

    public DownloadService() {
        super(com.google.android.exoplayer2.offline.DownloadService.u);
        this.downloadUrl = "";
        this.haveComplete = false;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        AbstractC1437u.f30196a = false;
        F f = this.downLoadSupportPauseUtil;
        if (f != null) {
            f.b();
            this.downLoadSupportPauseUtil = null;
        }
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        AbstractC1437u.f30196a = true;
        if (intent != null) {
            C1415j c1415j = (C1415j) intent.getSerializableExtra(CommConstant.DownloadConstants.REPORT_POJO);
            if (c1415j != null) {
                this.downloadUrl = !TextUtils.isEmpty(c1415j.z0) ? c1415j.z0 : c1415j.x0;
                F f = new F(this, c1415j, new F.d() { // from class: com.fl.saas.adx.base.download.DownloadService.1
                    @Override // com.fl.saas.F.d
                    public void onCancel() {
                        DownloadService.this.haveComplete = true;
                    }

                    @Override // com.fl.saas.F.d
                    public void onError() {
                        DownloadService.this.haveComplete = true;
                        Intent intent2 = new Intent();
                        intent2.setAction(F.v);
                        DownloadService.this.sendBroadcast(intent2);
                    }

                    @Override // com.fl.saas.F.d
                    public void onProgress(int i) {
                        Intent intent2 = new Intent();
                        intent2.setAction(F.x);
                        intent2.putExtra("progress", i);
                        DownloadService.this.sendBroadcast(intent2);
                    }

                    @Override // com.fl.saas.F.d
                    public void onSuccess(File file) {
                        DownloadService.this.haveComplete = true;
                        if (file != null) {
                            Intent intent2 = new Intent();
                            intent2.setAction(F.y);
                            intent2.putExtra("downloadFilePath", file.getAbsolutePath());
                            DownloadService.this.sendBroadcast(intent2);
                        }
                    }
                });
                this.downLoadSupportPauseUtil = f;
                f.f();
            }
            while (!this.haveComplete) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
