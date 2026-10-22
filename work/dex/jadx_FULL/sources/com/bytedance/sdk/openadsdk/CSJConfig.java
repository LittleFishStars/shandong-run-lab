package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@com.byazt.zqa.c(c = {0, 80, 81, 82, 1992})
public class CSJConfig implements AdConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29297a;
    private String c;
    private boolean da;
    private int[] i;
    private boolean m;
    private String n;
    private IMediationConfig nu;
    private Map<String, Object> sl;
    private boolean sp;
    private TTCustomController t;
    private String tt;
    private int u;
    private String uj;
    private boolean ve;
    private boolean x;
    private int yp;
    private int z;

    @com.byazt.zqa.c(c = {0, 80, 81, 82, 2156})
    public static class c {
        private String c;
        private int[] i;
        private IMediationConfig m;
        private String n;
        private TTCustomController sl;
        private int t;
        private String tt;
        private String uj;
        private boolean z;
        private boolean ve = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f29298a = 0;
        private boolean sp = true;
        private boolean x = false;
        private boolean da = false;
        private int u = 2;
        private int yp = 0;
        private Map<String, Object> nu = null;

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c n(boolean z) {
            this.z = z;
            return this;
        }

        public c tt(String str) {
            this.tt = str;
            return this;
        }

        public c uj(String str) {
            this.n = str;
            return this;
        }

        public c ve(String str) {
            this.uj = str;
            return this;
        }

        public c c(boolean z) {
            this.ve = z;
            return this;
        }

        public c tt(boolean z) {
            this.sp = z;
            return this;
        }

        public c uj(boolean z) {
            this.da = z;
            return this;
        }

        public c ve(boolean z) {
            this.x = z;
            return this;
        }

        public c c(int i) {
            this.f29298a = i;
            return this;
        }

        public c tt(int i) {
            this.t = i;
            return this;
        }

        public c uj(int i) {
            this.yp = i;
            return this;
        }

        public c ve(int i) {
            this.u = i;
            return this;
        }

        public c c(int... iArr) {
            this.i = iArr;
            return this;
        }

        public c c(TTCustomController tTCustomController) {
            this.sl = tTCustomController;
            return this;
        }

        public c c(IMediationConfig iMediationConfig) {
            this.m = iMediationConfig;
            return this;
        }

        public c c(String str, Object obj) {
            if (this.nu == null) {
                this.nu = new HashMap();
            }
            this.nu.put(str, obj);
            return this;
        }
    }

    public CSJConfig(c cVar) {
        this.ve = false;
        this.f29297a = 0;
        this.sp = true;
        this.x = false;
        this.da = false;
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
        this.n = cVar.n;
        this.f29297a = cVar.f29298a;
        this.sp = cVar.sp;
        this.x = cVar.x;
        this.i = cVar.i;
        this.da = cVar.da;
        this.t = cVar.sl;
        this.u = cVar.t;
        this.z = cVar.yp;
        this.yp = cVar.u;
        this.m = cVar.z;
        this.nu = cVar.m;
        this.sl = cVar.nu;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.tt;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.sl;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.sl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.uj;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.nu;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.yp;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f29297a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.sp;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.ve;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.da;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.m;
    }

    public void setAgeGroup(int i) {
        this.z = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.sp = z;
    }

    public void setAppId(String str) {
        this.c = str;
    }

    public void setAppName(String str) {
        this.tt = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.t = tTCustomController;
    }

    public void setData(String str) {
        this.n = str;
    }

    public void setDebug(boolean z) {
        this.x = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.i = iArr;
    }

    public void setKeywords(String str) {
        this.uj = str;
    }

    public void setPaid(boolean z) {
        this.ve = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.da = z;
    }

    public void setThemeStatus(int i) {
        this.u = i;
    }

    public void setTitleBarTheme(int i) {
        this.f29297a = i;
    }
}
