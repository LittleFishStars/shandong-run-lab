package com.byazt.su;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1486, 15})
@Deprecated
public class uj implements DownloadEventConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29031a;
    public String c;
    public String da;
    public String i;
    public String m;
    public String n;
    public String nu;
    public String sl;
    public String sp;
    public Object t;
    public boolean tt;
    public boolean u;
    public String uj;
    public String ve;
    public String x;
    public boolean yp;
    public boolean z;

    @com.byazt.zqa.c(c = {0, 1, 1486, 123})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29032a;
        public String c;
        public String da;
        public String i;
        public String m;
        public String n;
        public String nu;
        public String sl;
        public String sp;
        public Object t;
        public boolean tt;
        public boolean u;
        public String uj;
        public String ve;
        public String x;
        public boolean yp;
        public boolean z;

        public uj c() {
            return new uj(this);
        }
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getClickButtonTag() {
        return this.c;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f29031a;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.sp;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getClickLabel() {
        return this.ve;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.n;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getClickStartLabel() {
        return this.uj;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.t;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getRefer() {
        return this.nu;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.da;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.tt;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.u;
    }

    @Override // com.byazt.su.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.byazt.su.DownloadEventConfig
    public void setRefer(String str) {
    }

    public uj() {
    }

    private uj(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f29031a = cVar.f29032a;
        this.sp = cVar.sp;
        this.x = cVar.x;
        this.i = cVar.i;
        this.da = cVar.da;
        this.sl = cVar.sl;
        this.t = cVar.t;
        this.u = cVar.u;
        this.yp = cVar.yp;
        this.z = cVar.z;
        this.m = cVar.m;
        this.nu = cVar.nu;
    }
}
