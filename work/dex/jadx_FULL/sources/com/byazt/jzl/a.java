package com.byazt.jzl;

import android.text.TextUtils;
import com.byazt.fk.u;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1574, 34})
public class a implements u, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28712a;
    public String c;
    public int gt;
    public long m;
    public com.byazt.fk.n n;
    public boolean nu;
    public boolean rh;
    public int rl;
    public String sl;
    public int sp;
    public int t;
    public int tt;
    public int u;
    public com.byazt.fk.n uj;
    public List<String> yp;
    public String z;
    public int x = 204800;
    public int i = 0;
    public int da = 0;
    public long my = -1;
    public final HashMap<String, Object> ve = new HashMap<>();
    public int qy = 10000;
    public int gu = 10000;
    public int gr = 10000;
    public int zm = 0;
    public JSONObject yv = new JSONObject();

    public a(String str, com.byazt.fk.n nVar, com.byazt.fk.n nVar2, int i, int i2) {
        this.gt = 0;
        this.rl = 0;
        this.f28712a = str;
        this.uj = nVar;
        this.n = nVar2;
        this.gt = i;
        this.rl = i2;
    }

    @Override // com.byazt.fk.u
    public String getCacheParentDir() {
        return this.f28712a;
    }

    @Override // com.byazt.fk.u
    public String getCid() {
        return this.sl;
    }

    @Override // com.byazt.fk.u
    public String getCodeId() {
        return this.c;
    }

    @Override // com.byazt.fk.u
    public int getConnectTimeOutMills() {
        return this.qy;
    }

    @Override // com.byazt.fk.u
    public long getCurrent() {
        return this.m;
    }

    @Override // com.byazt.fk.u
    public com.byazt.fk.n getCurrentVideoInfo() {
        if (isH265()) {
            return this.n;
        }
        com.byazt.fk.n nVar = this.uj;
        if (nVar != null) {
            return nVar;
        }
        return null;
    }

    @Override // com.byazt.fk.u
    public synchronized Object getExtra(String str) {
        return this.ve.get(str);
    }

    @Override // com.byazt.fk.u
    public String getFileNameKey() {
        if (isH265()) {
            return this.n.getFileHash();
        }
        com.byazt.fk.n nVar = this.uj;
        if (nVar != null) {
            return nVar.getFileHash();
        }
        return null;
    }

    @Override // com.byazt.fk.u
    public int getHeight() {
        return this.u;
    }

    @Override // com.byazt.fk.u
    public String getLogExtra() {
        return this.z;
    }

    @Override // com.byazt.fk.u
    public JSONObject getPassThroughJson() {
        return this.yv;
    }

    @Override // com.byazt.fk.u
    public int getPitayaCacheSize() {
        return this.yv.optInt("pitaya_cache_size", 0);
    }

    @Override // com.byazt.fk.u
    public int getPitayaCode() {
        return this.yv.optInt("pitaya_code", 0);
    }

    @Override // com.byazt.fk.u
    public String getPitayaErrorMsg() {
        return this.yv.optString("pitaya_msg");
    }

    @Override // com.byazt.fk.u
    public float getPlaySpeedRatio() {
        if (isH265()) {
            return this.n.getPlay_speed_ratio();
        }
        com.byazt.fk.n nVar = this.uj;
        if (nVar != null) {
            return nVar.getPlay_speed_ratio();
        }
        return -1.0f;
    }

    @Override // com.byazt.fk.u
    public List<String> getPlayTrackUrls() {
        return this.yp;
    }

    @Override // com.byazt.fk.u
    public int getPlayerType() {
        return this.gt;
    }

    @Override // com.byazt.fk.u
    public int getPreloadSize() {
        if (isH265()) {
            return this.n.getVideoPreloadSize();
        }
        com.byazt.fk.n nVar = this.uj;
        if (nVar != null) {
            return nVar.getVideoPreloadSize();
        }
        return 0;
    }

    @Override // com.byazt.fk.u
    public int getReadTimeOutMills() {
        return this.gu;
    }

    @Override // com.byazt.fk.u
    public int getScene() {
        return this.tt;
    }

    @Override // com.byazt.fk.u
    public int getSourceType() {
        return this.zm;
    }

    @Override // com.byazt.fk.u
    public String getUrl() {
        if (isH265()) {
            return this.n.getVideo_url();
        }
        com.byazt.fk.n nVar = this.uj;
        if (nVar != null) {
            return nVar.getVideo_url();
        }
        return null;
    }

    @Override // com.byazt.fk.u
    public int getVideoEncodeType() {
        return this.rl;
    }

    @Override // com.byazt.fk.u
    public com.byazt.fk.n getVideoH264() {
        return this.uj;
    }

    @Override // com.byazt.fk.u
    public com.byazt.fk.n getVideoH265() {
        return this.n;
    }

    @Override // com.byazt.fk.u
    public long getVideoSize() {
        if (isH265()) {
            return this.n.getSize();
        }
        com.byazt.fk.n nVar = this.uj;
        if (nVar != null) {
            return nVar.getSize();
        }
        return 0L;
    }

    @Override // com.byazt.fk.u
    public int getVideoSkipResult() {
        return this.sp;
    }

    @Override // com.byazt.fk.u
    public int getWidth() {
        return this.t;
    }

    @Override // com.byazt.fk.u
    public int getWriteTimeOutMills() {
        return this.gr;
    }

    @Override // com.byazt.fk.u
    public boolean isAudio() {
        return this.rh;
    }

    @Override // com.byazt.fk.u
    public boolean isH265() {
        com.byazt.fk.n nVar;
        return this.rl == 1 && (nVar = this.n) != null && !TextUtils.isEmpty(nVar.getVideo_url()) && (com.byazt.oy.tt.n() == 2 || this.gt == 1);
    }

    @Override // com.byazt.fk.u
    public boolean isPreloadAll() {
        if (isH265()) {
            return this.n.isCacheAllVideo();
        }
        com.byazt.fk.n nVar = this.uj;
        if (nVar != null) {
            return nVar.isCacheAllVideo();
        }
        return true;
    }

    @Override // com.byazt.fk.u
    public boolean isQuiet() {
        return this.nu;
    }

    @Override // com.byazt.fk.u
    public synchronized void putExtra(String str, Object obj) {
        this.ve.put(str, obj);
    }

    @Override // com.byazt.fk.u
    public Object removeExtra(String str) {
        return this.ve.remove(str);
    }

    @Override // com.byazt.fk.u
    public void setAudio(boolean z) {
        this.rh = z;
    }

    @Override // com.byazt.fk.u
    public void setCacheParentDir(String str) {
        this.f28712a = str;
    }

    @Override // com.byazt.fk.u
    public void setCid(String str) {
        this.sl = str;
    }

    @Override // com.byazt.fk.u
    public void setCodeId(String str) {
        this.c = str;
    }

    @Override // com.byazt.fk.u
    public void setConnectTimeOutMills(int i) {
        this.qy = i;
    }

    @Override // com.byazt.fk.u
    public void setCurrent(long j) {
        this.m = j;
    }

    @Override // com.byazt.fk.u
    public void setHeight(int i) {
        this.u = i;
    }

    @Override // com.byazt.fk.u
    public void setLogExtra(String str) {
        this.z = str;
    }

    @Override // com.byazt.fk.u
    public void setPlayTrackUrls(List<String> list) {
        this.yp = list;
    }

    @Override // com.byazt.fk.u
    public void setPlayerType(int i) {
        this.gt = i;
    }

    @Override // com.byazt.fk.u
    public void setQuiet(boolean z) {
        this.nu = z;
    }

    @Override // com.byazt.fk.u
    public void setReadTimeOutMills(int i) {
        this.gu = i;
    }

    @Override // com.byazt.fk.u
    public void setScene(int i) {
        this.tt = i;
    }

    @Override // com.byazt.fk.u
    public void setSourceType(int i) {
        this.zm = i;
    }

    @Override // com.byazt.fk.u
    public void setVideoEncodeType(int i) {
        this.rl = i;
    }

    @Override // com.byazt.fk.u
    public void setVideoH264(com.byazt.fk.n nVar) {
        this.uj = nVar;
    }

    @Override // com.byazt.fk.u
    public void setVideoH265(com.byazt.fk.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.fk.u
    public void setVideoSkipResult(int i) {
        this.sp = i;
    }

    @Override // com.byazt.fk.u
    public void setWidth(int i) {
        this.t = i;
    }

    @Override // com.byazt.fk.u
    public void setWriteTimeOutMills(int i) {
        this.gr = i;
    }
}
