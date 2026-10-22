package com.byazt.nn;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.ar.AdDownloadController;
import com.byazt.ar.AdDownloadEventConfig;
import com.byazt.ar.AdDownloadModel;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 46})
public class n implements com.byazt.dd.c {
    public long c;
    public com.byazt.dd.tt n;
    public DownloadModel tt;
    public DownloadController uj;
    public DownloadEventConfig ve;

    public n() {
    }

    @Override // com.byazt.dd.c
    public String a() {
        if (this.tt.getDeepLink() != null) {
            return this.tt.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.byazt.dd.c
    public String c() {
        return this.tt.getDownloadUrl();
    }

    @Override // com.byazt.dd.c
    public String da() {
        return this.ve.getClickButtonTag();
    }

    public boolean gr() {
        DownloadModel downloadModel;
        if (this.c == 0 || (downloadModel = this.tt) == null || this.ve == null || this.uj == null) {
            return true;
        }
        return downloadModel.isAd() && this.c <= 0;
    }

    @Override // com.byazt.dd.c
    public int gt() {
        return this.ve.getDownloadScene();
    }

    @Override // com.byazt.dd.c
    public DownloadController gu() {
        return this.uj;
    }

    @Override // com.byazt.dd.c
    public String i() {
        return this.ve.getRefer();
    }

    @Override // com.byazt.dd.c
    public JSONObject m() {
        return this.ve.getExtraJson();
    }

    @Override // com.byazt.dd.c
    public int my() {
        return 0;
    }

    @Override // com.byazt.dd.c
    public String n() {
        return this.tt.getPackageName();
    }

    @Override // com.byazt.dd.c
    public boolean nu() {
        return this.uj.enableNewActivity();
    }

    @Override // com.byazt.dd.c
    public DownloadEventConfig qy() {
        return this.ve;
    }

    @Override // com.byazt.dd.c
    public JSONObject rh() {
        return this.tt.getDownloadSettings();
    }

    @Override // com.byazt.dd.c
    public DownloadModel rl() {
        return this.tt;
    }

    @Override // com.byazt.dd.c
    public JSONObject sl() {
        return this.ve.getParamsJson();
    }

    @Override // com.byazt.dd.c
    public JSONObject sp() {
        return this.tt.getExtra();
    }

    @Override // com.byazt.dd.c
    public long t() {
        return this.tt.getExtraValue();
    }

    @Override // com.byazt.dd.c
    public long tt() {
        return this.tt.getId();
    }

    @Override // com.byazt.dd.c
    public boolean u() {
        return this.ve.isEnableV3Event();
    }

    @Override // com.byazt.dd.c
    public String uj() {
        return this.tt.getLogExtra();
    }

    @Override // com.byazt.dd.c
    public boolean ve() {
        return this.tt.isAd();
    }

    @Override // com.byazt.dd.c
    public int x() {
        if (this.uj.getDownloadMode() == 2) {
            return 2;
        }
        return this.tt.getFunnelType();
    }

    @Override // com.byazt.dd.c
    public List<String> yp() {
        return this.tt.getClickTrackUrl();
    }

    @Override // com.byazt.dd.c
    public Object z() {
        return this.ve.getExtraEventObject();
    }

    public boolean zm() {
        if (gr()) {
            return false;
        }
        if (!this.tt.isAd()) {
            return this.tt instanceof AdDownloadModel;
        }
        DownloadModel downloadModel = this.tt;
        return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.ve instanceof AdDownloadEventConfig) && (this.uj instanceof AdDownloadController);
    }

    public n(long j, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.c = j;
        this.tt = downloadModel;
        this.ve = downloadEventConfig;
        this.uj = downloadController;
    }
}
