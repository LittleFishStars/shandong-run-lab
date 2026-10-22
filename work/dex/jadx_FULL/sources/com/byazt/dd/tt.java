package com.byazt.dd;

import com.byazt.ar.AdDownloadController;
import com.byazt.ar.AdDownloadEventConfig;
import com.byazt.ar.AdDownloadModel;
import com.byazt.e.DeepLink;
import com.byazt.gq.t;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadEventConfig;
import com.byazt.su.DownloadModel;
import com.byazt.tk.AdBaseConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1806, 13})
public class tt implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28383a;
    public String aw;
    public boolean b;
    public int bm;
    public boolean bx;
    public boolean c;
    public boolean cu;
    public long d;
    public String da;
    public long dz;
    public int eo;
    public int gr;
    public String gt;
    public JSONObject gu;
    public long h;
    public boolean hd;
    public int i;
    public boolean ic;
    public boolean iu;
    public String j;
    public boolean kk;
    public String kp;
    public long l;
    public long lo;

    @AdBaseConstants.FunnelType
    public int lr;
    public boolean lt;
    public int m;
    public long md;
    public String my;
    public final AtomicBoolean n;
    public boolean nb;
    public int nu;
    public String or;
    public boolean os;
    public boolean oz;
    public int p;
    public boolean pf;
    public boolean pu;
    public boolean q;
    public String qp;
    public long qy;
    public boolean r;
    public String rh;
    public boolean rl;
    public boolean s;
    public String sl;
    public long sp;
    public String sv;
    public String t;
    public long tk;
    public long to;
    public boolean tt;
    public long tx;
    public String u;
    public final AtomicBoolean uj;
    public transient boolean v;
    public final AtomicBoolean ve;
    public String x;
    public boolean y;
    public int yp;
    public int yv;
    public int z;
    public int zb;
    public boolean zm;

    private tt() {
        this.i = 1;
        this.rl = true;
        this.zm = false;
        this.yv = 0;
        this.p = 0;
        this.cu = false;
        this.nb = false;
        this.pf = true;
        this.bx = true;
        this.c = true;
        this.tt = true;
        this.ve = new AtomicBoolean(false);
        this.uj = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.lr = 1;
        this.pu = true;
        this.tx = -1L;
    }

    public void a(long j) {
        if (j > 0) {
            this.qy = j;
        }
    }

    public String aw() {
        return this.my;
    }

    public boolean b() {
        return this.os;
    }

    public boolean bm() {
        return this.q;
    }

    public boolean bx() {
        return this.zm;
    }

    public void c(int i) {
        this.yv = i;
    }

    public long cu() {
        return this.qy;
    }

    public int d() {
        return this.eo;
    }

    @Override // com.byazt.dd.c
    public String da() {
        return this.sv;
    }

    public int eo() {
        return this.zb;
    }

    public int gr() {
        return this.yv;
    }

    @Override // com.byazt.dd.c
    public int gt() {
        return -1;
    }

    public void gt(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.dd.c
    public DownloadController gu() {
        return j();
    }

    public long h() {
        return this.h;
    }

    public String hd() {
        return this.kp;
    }

    public void i(int i) {
        this.lr = i;
    }

    public int ic() {
        return this.z;
    }

    public AdDownloadEventConfig iu() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.sv).setRefer(this.aw).setIsEnableV3Event(this.ic).build();
    }

    public AdDownloadController j() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.zm).setLinkMode(this.z).setDownloadMode(this.m).setEnableShowComplianceDialog(this.pu).setEnableAH(this.c).setEnableAM(this.tt).build();
    }

    public boolean kk() {
        return this.oz;
    }

    public boolean kp() {
        return this.v;
    }

    public boolean l() {
        return this.kk;
    }

    public long lo() {
        return this.l;
    }

    public boolean lr() {
        return this.hd;
    }

    public boolean lt() {
        return this.cu;
    }

    @Override // com.byazt.dd.c
    public JSONObject m() {
        return null;
    }

    public void m(boolean z) {
        this.pu = z;
    }

    public long md() {
        long j = this.md;
        return j == 0 ? this.qy : j;
    }

    @Override // com.byazt.dd.c
    public int my() {
        return this.gr;
    }

    public void n(long j) {
        this.sp = j;
    }

    public String nb() {
        return this.rh;
    }

    public void nu(boolean z) {
        this.lt = z;
    }

    public int or() {
        return this.i;
    }

    public boolean os() {
        return this.iu;
    }

    public String oz() {
        return this.j;
    }

    public synchronized void p() {
        this.p++;
    }

    public int pf() {
        return this.bm;
    }

    public long pu() {
        return this.lo;
    }

    public boolean q() {
        return this.r;
    }

    public int qp() {
        return this.nu;
    }

    public void qy(boolean z) {
        this.iu = z;
    }

    public long r() {
        return this.dz;
    }

    @Override // com.byazt.dd.c
    public JSONObject rh() {
        return null;
    }

    public void rh(boolean z) {
        this.pf = z;
    }

    public void rl(boolean z) {
        this.tt = z;
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f28383a);
            jSONObject.put("mExtValue", this.sp);
            jSONObject.put("mLogExtra", this.x);
            jSONObject.put("mDownloadStatus", this.i);
            jSONObject.put("mPackageName", this.da);
            jSONObject.put("mIsAd", this.rl);
            jSONObject.put("mTimeStamp", this.qy);
            jSONObject.put("mExtras", this.gu);
            jSONObject.put("mVersionCode", this.nu);
            jSONObject.put("mVersionName", this.rh);
            jSONObject.put("mDownloadId", this.gr);
            jSONObject.put("mIsV3Event", this.ic);
            jSONObject.put("mScene", this.bm);
            jSONObject.put("mEventTag", this.sv);
            jSONObject.put("mEventRefer", this.aw);
            jSONObject.put("mDownloadUrl", this.sl);
            jSONObject.put("mEnableBackDialog", this.zm);
            jSONObject.put("hasSendInstallFinish", this.ve.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.uj.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.n.get());
            jSONObject.put("mLastFailedErrCode", this.zb);
            jSONObject.put("mLastFailedErrMsg", this.or);
            jSONObject.put("mOpenUrl", this.t);
            jSONObject.put("mLinkMode", this.z);
            jSONObject.put("mDownloadMode", this.m);
            jSONObject.put("mModelType", this.yp);
            jSONObject.put("mAppName", this.my);
            jSONObject.put("mAppIcon", this.gt);
            jSONObject.put("mDownloadFailedTimes", this.yv);
            long j = this.md;
            if (j == 0) {
                j = this.qy;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.p);
            jSONObject.put("mJumpInstallTime", this.h);
            jSONObject.put("mCancelInstallTime", this.d);
            jSONObject.put("mLastFailedResumeCount", this.eo);
            jSONObject.put("mIsUpdateDownload", this.cu);
            jSONObject.put("mOriginMimeType", this.qp);
            jSONObject.put("mIsPatchApplyHandled", this.nb);
            jSONObject.put("downloadFinishReason", this.kp);
            jSONObject.put("clickDownloadTime", this.l);
            jSONObject.put("clickDownloadSize", this.lo);
            jSONObject.put("installAfterCleanSpace", this.hd);
            jSONObject.put("funnelType", this.lr);
            jSONObject.put("webUrl", this.u);
            jSONObject.put("enableShowComplianceDialog", this.pu);
            jSONObject.put("isAutoDownloadOnCardShow", this.lt);
            int i = 1;
            jSONObject.put("enable_new_activity", this.pf ? 1 : 0);
            jSONObject.put("enable_pause", this.bx ? 1 : 0);
            jSONObject.put("enable_ah", this.c ? 1 : 0);
            if (!this.tt) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.iu));
            jSONObject.put("task_key", this.j);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.dz));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.to));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.tk));
        } catch (Exception e) {
            t.gt().c(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.byazt.dd.c
    public JSONObject sl() {
        return null;
    }

    public void sl(String str) {
        this.gt = str;
    }

    @Override // com.byazt.dd.c
    public JSONObject sp() {
        return this.gu;
    }

    public long sv() {
        return this.tx;
    }

    @Override // com.byazt.dd.c
    public long t() {
        return this.sp;
    }

    public boolean tk() {
        return this.nb;
    }

    public String to() {
        return this.qp;
    }

    public void tt(int i) {
        this.p = i;
    }

    public boolean tx() {
        return this.s;
    }

    @Override // com.byazt.dd.c
    public boolean u() {
        return this.ic;
    }

    public void uj(int i) {
        this.zb = i;
    }

    public boolean v() {
        return this.y;
    }

    public void ve(long j) {
        this.d = j;
    }

    public void x(int i) {
        this.bm = i;
    }

    public AdDownloadModel y() {
        return new AdDownloadModel.Builder().setAdId(this.f28383a).setExtraValue(this.sp).setLogExtra(this.x).setPackageName(this.da).setExtra(this.gu).setIsAd(this.rl).setVersionCode(this.nu).setVersionName(this.rh).setDownloadUrl(this.sl).setModelType(this.yp).setMimeType(this.qp).setAppName(this.my).setAppIcon(this.gt).setTaskKey(this.j).setDeepLink(new DeepLink(this.t, this.u, null)).build();
    }

    @Override // com.byazt.dd.c
    public List<String> yp() {
        return null;
    }

    public void yp(boolean z) {
        this.s = z;
    }

    public int yv() {
        return this.p;
    }

    @Override // com.byazt.dd.c
    public Object z() {
        return null;
    }

    public void z(boolean z) {
        this.y = z;
    }

    public String zb() {
        return this.or;
    }

    public synchronized void zm() {
        this.yv++;
    }

    public void a(int i) {
        this.nu = i;
    }

    public void c(long j) {
        this.md = j;
    }

    public void da(String str) {
        this.my = str;
    }

    @Override // com.byazt.dd.c
    public String i() {
        return this.aw;
    }

    public void my(boolean z) {
        this.bx = z;
    }

    public void n(int i) {
        this.i = i;
    }

    @Override // com.byazt.dd.c
    public boolean nu() {
        return this.pf;
    }

    @Override // com.byazt.dd.c
    public DownloadEventConfig qy() {
        return iu();
    }

    @Override // com.byazt.dd.c
    public DownloadModel rl() {
        return y();
    }

    public void sl(int i) {
        this.m = i;
    }

    public void sp(int i) {
        this.gr = i;
    }

    public void t(int i) {
        this.yp = i;
    }

    public void tt(long j) {
        this.h = j;
    }

    public void u(String str) {
        this.qp = str;
    }

    public void uj(long j) {
        this.f28383a = j;
    }

    public void ve(int i) {
        this.eo = i;
    }

    @Override // com.byazt.dd.c
    public int x() {
        return this.lr;
    }

    public void yp(String str) {
        this.j = str;
    }

    public void a(String str) {
        this.sv = str;
    }

    public void c(String str) {
        this.or = str;
    }

    public void da(int i) {
        this.z = i;
    }

    public void i(String str) {
        this.t = str;
    }

    @Override // com.byazt.dd.c
    public String n() {
        return this.da;
    }

    public void sl(boolean z) {
        this.os = z;
    }

    public void sp(String str) {
        this.aw = str;
    }

    public void t(String str) {
        this.kp = str;
    }

    @Override // com.byazt.dd.c
    public long tt() {
        return this.f28383a;
    }

    public void u(boolean z) {
        this.oz = z;
    }

    @Override // com.byazt.dd.c
    public String uj() {
        return this.x;
    }

    public void ve(String str) {
        this.x = str;
    }

    public void x(String str) {
        this.sl = str;
    }

    @Override // com.byazt.dd.c
    public String a() {
        return this.t;
    }

    public void c(boolean z) {
        this.rl = z;
    }

    public void da(boolean z) {
        this.v = z;
    }

    public void i(long j) {
        this.lo = j;
    }

    public void n(String str) {
        this.u = str;
    }

    public void sl(long j) {
        this.to = j;
    }

    public void sp(long j) {
        this.tx = j;
    }

    public void t(boolean z) {
        this.r = z;
    }

    public void tt(String str) {
        this.da = str;
    }

    public void uj(String str) {
        this.rh = str;
    }

    @Override // com.byazt.dd.c
    public boolean ve() {
        return this.rl;
    }

    public void x(long j) {
        this.l = j;
    }

    public void a(boolean z) {
        this.hd = z;
    }

    public void c(JSONObject jSONObject) {
        this.gu = jSONObject;
    }

    public void da(long j) {
        this.dz = j;
    }

    public void i(boolean z) {
        this.nb = z;
    }

    public void n(boolean z) {
        this.q = z;
    }

    public void sp(boolean z) {
        this.kk = z;
    }

    public void t(long j) {
        this.tk = j;
    }

    public void tt(boolean z) {
        this.ic = z;
    }

    public void uj(boolean z) {
        this.b = z;
    }

    public void ve(boolean z) {
        this.zm = z;
    }

    public void x(boolean z) {
        this.cu = z;
    }

    public static tt tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        tt ttVar = new tt();
        try {
            ttVar.uj(com.byazt.ki.tt.c(jSONObject, "mId"));
            ttVar.n(com.byazt.ki.tt.c(jSONObject, "mExtValue"));
            ttVar.ve(jSONObject.optString("mLogExtra"));
            ttVar.n(jSONObject.optInt("mDownloadStatus"));
            ttVar.tt(jSONObject.optString("mPackageName"));
            boolean z = true;
            ttVar.c(jSONObject.optBoolean("mIsAd", true));
            ttVar.a(com.byazt.ki.tt.c(jSONObject, "mTimeStamp"));
            ttVar.a(jSONObject.optInt("mVersionCode"));
            ttVar.uj(jSONObject.optString("mVersionName"));
            ttVar.sp(jSONObject.optInt("mDownloadId"));
            ttVar.tt(jSONObject.optBoolean("mIsV3Event"));
            ttVar.x(jSONObject.optInt("mScene"));
            ttVar.a(jSONObject.optString("mEventTag"));
            ttVar.sp(jSONObject.optString("mEventRefer"));
            ttVar.x(jSONObject.optString("mDownloadUrl"));
            ttVar.ve(jSONObject.optBoolean("mEnableBackDialog"));
            ttVar.ve.set(jSONObject.optBoolean("hasSendInstallFinish"));
            ttVar.uj.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            ttVar.n.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            ttVar.uj(jSONObject.optInt("mLastFailedErrCode"));
            ttVar.c(jSONObject.optString("mLastFailedErrMsg"));
            ttVar.i(jSONObject.optString("mOpenUrl"));
            ttVar.da(jSONObject.optInt("mLinkMode"));
            ttVar.sl(jSONObject.optInt("mDownloadMode"));
            ttVar.t(jSONObject.optInt("mModelType"));
            ttVar.da(jSONObject.optString("mAppName"));
            ttVar.sl(jSONObject.optString("mAppIcon"));
            ttVar.c(jSONObject.optInt("mDownloadFailedTimes", 0));
            ttVar.c(com.byazt.ki.tt.c(jSONObject, "mRecentDownloadResumeTime"));
            ttVar.tt(jSONObject.optInt("mClickPauseTimes"));
            ttVar.tt(com.byazt.ki.tt.c(jSONObject, "mJumpInstallTime"));
            ttVar.ve(com.byazt.ki.tt.c(jSONObject, "mCancelInstallTime"));
            ttVar.ve(jSONObject.optInt("mLastFailedResumeCount"));
            ttVar.t(jSONObject.optString("downloadFinishReason"));
            ttVar.i(jSONObject.optLong("clickDownloadSize"));
            ttVar.x(jSONObject.optLong("clickDownloadTime"));
            ttVar.x(jSONObject.optBoolean("mIsUpdateDownload"));
            ttVar.u(jSONObject.optString("mOriginMimeType"));
            ttVar.i(jSONObject.optBoolean("mIsPatchApplyHandled"));
            ttVar.a(jSONObject.optBoolean("installAfterCleanSpace"));
            ttVar.i(jSONObject.optInt("funnelType", 1));
            ttVar.n(jSONObject.optString("webUrl"));
            ttVar.m(jSONObject.optBoolean("enableShowComplianceDialog", true));
            ttVar.nu(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            ttVar.rh(jSONObject.optInt("enable_new_activity", 1) == 1);
            ttVar.my(jSONObject.optInt("enable_pause", 1) == 1);
            ttVar.gt(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            ttVar.rl(z);
            ttVar.c(jSONObject.optJSONObject("mExtras"));
            ttVar.qy(jSONObject.optBoolean("intent_jump_browser_success"));
            ttVar.yp(jSONObject.optString("task_key"));
            ttVar.da(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            ttVar.sl(jSONObject.optLong("download_pause_timestamp", 0L));
            ttVar.t(jSONObject.optLong("download_finish_timestamp", 0L));
        } catch (Exception e) {
            t.gt().c(e, "NativeDownloadModel fromJson");
        }
        return ttVar;
    }

    @Override // com.byazt.dd.c
    public String c() {
        return this.sl;
    }

    public tt(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public tt(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.i = 1;
        this.rl = true;
        this.zm = false;
        this.yv = 0;
        this.p = 0;
        this.cu = false;
        this.nb = false;
        this.pf = true;
        this.bx = true;
        this.c = true;
        this.tt = true;
        this.ve = new AtomicBoolean(false);
        this.uj = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.lr = 1;
        this.pu = true;
        this.tx = -1L;
        this.f28383a = downloadModel.getId();
        this.sp = downloadModel.getExtraValue();
        this.x = downloadModel.getLogExtra();
        this.da = downloadModel.getPackageName();
        this.gu = downloadModel.getExtra();
        this.rl = downloadModel.isAd();
        this.nu = downloadModel.getVersionCode();
        this.rh = downloadModel.getVersionName();
        this.sl = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.t = downloadModel.getDeepLink().getOpenUrl();
            this.u = downloadModel.getDeepLink().getWebUrl();
        }
        this.yp = downloadModel.getModelType();
        this.my = downloadModel.getName();
        this.gt = downloadModel.getAppIcon();
        this.qp = downloadModel.getMimeType();
        this.sv = downloadEventConfig.getClickButtonTag();
        this.aw = downloadEventConfig.getRefer();
        this.ic = downloadEventConfig.isEnableV3Event();
        this.zm = downloadController.isEnableBackDialog();
        this.z = downloadController.getLinkMode();
        this.m = downloadController.getDownloadMode();
        this.pu = downloadController.enableShowComplianceDialog();
        this.lt = downloadController.isAutoDownloadOnCardShow();
        this.pf = downloadController.enableNewActivity();
        this.c = downloadController.enableAH();
        this.tt = downloadController.enableAM();
        this.gr = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.qy = jCurrentTimeMillis;
        this.md = jCurrentTimeMillis;
        this.nb = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.j = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
