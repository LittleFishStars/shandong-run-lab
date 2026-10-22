package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PackageBean implements Serializable {
    private AdBean ad;
    private AppBean app;
    private DClick dclk;
    private List<String> defImages;
    private List<DpFlagBean> dpflag;
    private Integer fieldExport;
    private HappyBean happy;
    private List<String> jbUrlPrefixes;
    private LogBean log;
    private int olp;
    private long shakeTimeout;
    private SplashBean sty;
    private int syncSave;
    private int useBrowser;
    private String ver;
    private int verbosity;
    public List<String> webviewBlackSchemes;
    public HashMap<String, Integer> webviewLimitedSchemes;
    public int dpstay = 2;
    private int useHttps = 3;

    @Keep
    public static class AdBean {
        private int crdpf;
        private FeedConfigBean feed;
        private SplashConfigBean splash;

        public int getCrdpf() {
            return this.crdpf;
        }

        public FeedConfigBean getFeed() {
            return this.feed;
        }

        public SplashConfigBean getSplash() {
            return this.splash;
        }

        public void setSplash(SplashConfigBean splashConfigBean) {
            this.splash = splashConfigBean;
        }
    }

    @Keep
    public static class AppBean implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f39342a;
        private Integer b;
        private Integer c;
        private Integer d;
        private Integer e;
        private List<PackBean> others;
        private List<PackBean> required;
        private Integer ttl;
        private String url;

        @Keep
        public static class PackBean implements Serializable {
            private long expirationTime;
            private String id;
            private boolean isInstalled;
            private long lastCheckTime;
            private String query;

            public long getExpirationTime() {
                return this.expirationTime;
            }

            public String getId() {
                return this.id;
            }

            public boolean getInstalled() {
                return this.isInstalled;
            }

            public long getLastCheckTime() {
                return this.lastCheckTime;
            }

            public String getQuery() {
                return this.query;
            }

            public void setExpirationTime(long j) {
                this.expirationTime = j;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setInstalled(boolean z) {
                this.isInstalled = z;
            }

            public void setLastCheckTime(long j) {
                this.lastCheckTime = j;
            }

            public void setQuery(String str) {
                this.query = str;
            }
        }

        public Integer getA() {
            return this.f39342a;
        }

        public Integer getB() {
            return this.b;
        }

        public Integer getC() {
            return this.c;
        }

        public Integer getD() {
            return this.d;
        }

        public Integer getE() {
            return this.e;
        }

        public List<PackBean> getOthers() {
            return this.others;
        }

        public List<PackBean> getRequired() {
            return this.required;
        }

        public Integer getTtl() {
            return this.ttl;
        }

        public String getUrl() {
            return this.url;
        }

        public void setA(Integer num) {
            this.f39342a = num;
        }

        public void setB(Integer num) {
            this.b = num;
        }

        public void setC(Integer num) {
            this.c = num;
        }

        public void setD(Integer num) {
            this.d = num;
        }

        public void setE(Integer num) {
            this.e = num;
        }

        public void setOthers(List<PackBean> list) {
            this.others = list;
        }

        public void setRequired(List<PackBean> list) {
            this.required = list;
        }

        public void setTtl(Integer num) {
            this.ttl = num;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    @Keep
    public static class DClick implements Serializable {
        private int status;

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public String toString() {
            StringBuilder sbA = com.kc.dw.activity.a.a("DClick{status=");
            sbA.append(this.status);
            sbA.append('}');
            return sbA.toString();
        }
    }

    @Keep
    public static class DpFlagBean implements Serializable {
        private List<String> flag;
        private String scheme;

        public List<String> getFlag() {
            return this.flag;
        }

        public String getScheme() {
            return this.scheme;
        }

        public void setFlag(List<String> list) {
            this.flag = list;
        }

        public void setScheme(String str) {
            this.scheme = str;
        }
    }

    @Keep
    public static class FeedConfigBean {
        private int useOldStyle;

        public int getUseOldStyle() {
            return this.useOldStyle;
        }
    }

    @Keep
    public static class HappyBean {
        private int i;
        private List<String> k;
        private long lastTime;
        private Map<String, Integer> r;
        private int x;

        public int getI() {
            return this.i;
        }

        public List<String> getK() {
            return this.k;
        }

        public long getLastTime() {
            return this.lastTime;
        }

        public Map<String, Integer> getR() {
            return this.r;
        }

        public int getX() {
            return this.x;
        }

        public void setI(int i) {
            this.i = i;
        }

        public void setK(List<String> list) {
            this.k = list;
        }

        public void setLastTime(long j) {
            this.lastTime = j;
        }

        public void setR(Map<String, Integer> map) {
            this.r = map;
        }

        public void setX(int i) {
            this.x = i;
        }
    }

    @Keep
    public static class LogBean implements Serializable {
        private String[] e;
        private Integer n;
        private Integer t;
        private String u;
        private Integer x;

        public Integer getBackGroundTimeDur() {
            return this.x;
        }

        public Integer getLogSize() {
            return this.n;
        }

        public Integer getTimeDur() {
            return this.t;
        }

        public String[] getUploadEvents() {
            return this.e;
        }

        public String getUploadUrl() {
            return this.u;
        }
    }

    @Keep
    public static class SplashBean implements Serializable {
        private int v;

        public int getV() {
            return this.v;
        }

        public void setV(int i) {
            this.v = i;
        }
    }

    @Keep
    public static class SplashConfigBean {
        private int ar;
        private int ic;
        private int nie;
        private int rs;
        private int to = -1;
        private int videoCacheTime;

        public int getAr() {
            return this.ar;
        }

        public int getIc() {
            return this.ic;
        }

        public int getNie() {
            return this.nie;
        }

        public int getRs() {
            return this.rs;
        }

        public int getTo() {
            return this.to;
        }

        public int getVideoCacheTime() {
            return this.videoCacheTime;
        }

        public void setAr(int i) {
            this.ar = i;
        }

        public void setTo(int i) {
            this.to = i;
        }

        public void setVideoCacheTime(int i) {
            this.videoCacheTime = i;
        }
    }

    public AdBean getAd() {
        return this.ad;
    }

    public AppBean getApp() {
        return this.app;
    }

    public DClick getDclk() {
        return this.dclk;
    }

    public List<String> getDefImages() {
        return this.defImages;
    }

    public List<DpFlagBean> getDpflag() {
        return this.dpflag;
    }

    public int getDpstay() {
        return this.dpstay;
    }

    public Integer getFieldExport() {
        return this.fieldExport;
    }

    public HappyBean getHappy() {
        return this.happy;
    }

    public List<String> getJbUrlPrefixes() {
        return this.jbUrlPrefixes;
    }

    public LogBean getLog() {
        return this.log;
    }

    public int getOlp() {
        return this.olp;
    }

    public long getShakeTimeout() {
        return this.shakeTimeout;
    }

    public SplashBean getSty() {
        return this.sty;
    }

    public int getSyncSave() {
        return this.syncSave;
    }

    public int getUseBrowser() {
        return this.useBrowser;
    }

    public int getUseHttps() {
        return this.useHttps;
    }

    public String getVer() {
        return this.ver;
    }

    public int getVerbosity() {
        return this.verbosity;
    }

    public List<String> getWebviewBlackSchemes() {
        return this.webviewBlackSchemes;
    }

    public HashMap<String, Integer> getWebviewLimitedSchemes() {
        return this.webviewLimitedSchemes;
    }

    public void setAd(AdBean adBean) {
        this.ad = adBean;
    }

    public void setApp(AppBean appBean) {
        this.app = appBean;
    }

    public void setDclk(DClick dClick) {
        this.dclk = dClick;
    }

    public void setDpflag(List<DpFlagBean> list) {
        this.dpflag = list;
    }

    public void setDpstay(int i) {
        this.dpstay = i;
    }

    public void setFieldExport(Integer num) {
        this.fieldExport = num;
    }

    public void setHappy(HappyBean happyBean) {
        this.happy = happyBean;
    }

    public void setOlp(int i) {
        this.olp = i;
    }

    public void setShakeTimeout(long j) {
        this.shakeTimeout = j;
    }

    public void setSty(SplashBean splashBean) {
        this.sty = splashBean;
    }

    public void setSyncSave(int i) {
        this.syncSave = i;
    }

    public void setUseBrowser(int i) {
        this.useBrowser = i;
    }

    public void setUseHttps(int i) {
        this.useHttps = i;
    }

    public void setVer(String str) {
        this.ver = str;
    }

    public void setVerbosity(int i) {
        this.verbosity = i;
    }

    public void setWebviewBlackSchemes(List<String> list) {
        this.webviewBlackSchemes = list;
    }

    public void setWebviewLimitedSchemes(HashMap<String, Integer> map) {
        this.webviewLimitedSchemes = map;
    }
}
