package com.byazt.zd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.camera.video.AudioStats;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.bv.BaseConstants;
import com.byazt.bzd.t;
import com.byazt.dh.ve;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.byazt.fk.n;
import com.byazt.fk.sp;
import com.byazt.kft.UpieVideoView;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.byazt.sgn.z;
import com.byazt.ts.uj;
import com.byazt.un.a;
import com.byazt.wol.LayoutVideoPlayLayoutForLive;
import com.bytedance.android.metrics.LiveMetrics;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_LOW_VERISON_JPG, 20})
public abstract class c extends com.byazt.nj.c {
    public int b;
    public WeakReference<ve.tt> bm;
    public InterfaceC0595c ic;
    public int kp;
    public final int lr;
    public final String lt;
    public ViewGroup md;
    public com.byazt.hkv.c or;
    public long os;
    public int oz;
    public long p;
    public long pu;
    public ve.c sv;
    public int tk;
    public long h = 0;
    public boolean d = false;
    public boolean eo = false;
    public Map<String, Object> zb = null;
    public final AtomicInteger qp = new AtomicInteger(0);
    public final AtomicInteger nb = new AtomicInteger(0);
    public long pf = 0;
    public long bx = 0;
    public final Runnable aw = new Runnable() { // from class: com.byazt.zd.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.sv != null) {
                c.this.sv.c();
            }
            if (c.this.ic != null) {
                c.this.ic.tt();
            }
        }
    };
    public boolean hd = false;
    public boolean l = false;
    public boolean lo = true;
    public boolean to = false;
    public boolean q = false;
    public boolean kk = false;
    public boolean tx = false;
    public boolean v = false;
    public sp.c cu = new sp.c() { // from class: com.byazt.zd.c.2
        @Override // com.byazt.fk.sp.c
        public void onBufferEnd(sp spVar, int i) {
            m.c("BaseVideoController", "IVideoPlayerCallback onBufferEnd: ");
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.n != null) {
                        c.this.n(0);
                        c.this.n.tt();
                        c.this.c.removeCallbacks(c.this.aw);
                        c.this.l = false;
                    }
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onBufferStart(sp spVar, int i, int i2, int i3) {
            m.c("BaseVideoController", "IVideoPlayerCallback onBufferStart: ");
            com.byazt.rgb.ve.uj(c.this.b());
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.n != null) {
                        c.this.n(8);
                        c.this.n.gu();
                        c.this.aw();
                        c.this.l = true;
                    }
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onBufferingUpdate(sp spVar, int i) {
            m.c("BaseVideoController", "IVideoPlayerCallback onBufferingUpdate: ");
        }

        @Override // com.byazt.fk.sp.c
        public void onCompletion(sp spVar) {
            m.c("BaseVideoController", "IVideoPlayerCallback onCompletion: ");
            com.byazt.rgb.ve.a(c.this.b());
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(false);
                }
            });
            c.this.c(4);
            c.this.tt(4);
        }

        @Override // com.byazt.fk.sp.c
        public void onError(final sp spVar, final com.byazt.fk.ve veVar) {
            if (veVar == null) {
                return;
            }
            com.byazt.rgb.ve.ve(c.this.b(), 1);
            m.c("BaseVideoController", "IVideoPlayerCallback video_pip_big_error onError: code:" + veVar.getCode() + " msg:" + veVar.getMsg());
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.4
                @Override // java.lang.Runnable
                public void run() {
                    sp spVar2;
                    sp spVar3;
                    int iC;
                    int code = veVar.getCode();
                    if (code == 308 && (spVar2 = c.this.uj) != null && spVar2 != (spVar3 = spVar) && (spVar3 instanceof uj) && ((iC = ((uj) spVar3).c()) == 200 || iC == 203)) {
                        m.uj("BaseVideoController", "ignore errorCode:" + code + " state:" + iC);
                        return;
                    }
                    c.this.c(code, veVar.getExtraCode(), veVar.getMsg(), (JSONArray) null);
                    c.this.c.removeCallbacks(c.this.aw);
                    if (c.this.n != null) {
                        c.this.n(0);
                        c.this.n.tt();
                    }
                    if (c.this.sv != null) {
                        c.this.sv.tt(c.this.bx, com.byazt.vv.c.c(c.this.sp, c.this.p));
                    }
                    if (c.this.ic != null) {
                        c.this.ic.c(code, veVar.getMsg());
                    }
                }
            });
            c.this.c(veVar.getCode(), veVar.getMsg());
        }

        @Override // com.byazt.fk.sp.c
        public void onMonitorLog(sp spVar, JSONObject jSONObject, String str) {
            if (x.m().hd()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.byazt.ddx.uj.c((Context) c.this.i.get(), c.this.f28832a, c.this.lt, "pangle_live_sdk_monitor", jSONObject);
        }

        @Override // com.byazt.fk.sp.c
        public void onPause(sp spVar) {
            c.this.tx = true;
            com.byazt.rgb.ve.n(c.this.b());
        }

        @Override // com.byazt.fk.sp.c
        public void onPlayPositionUpdate(final sp spVar, final long j, final long j2) {
            if (c.this.tx && c.this.v) {
                c.this.tx = false;
                c.this.v = false;
                com.byazt.rgb.ve.tt(c.this.b(), 2);
            }
            if (Math.abs(j - c.this.sp) < 50) {
                return;
            }
            m.c("BaseVideoController", "IVideoPlayerCallback onPlayPositionUpdate: current = ", Long.valueOf(j), "; duration=", Long.valueOf(j2));
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.gu != null) {
                        c.this.gu.c(j, j2);
                    }
                    c.this.tt(j, j2);
                    c.this.c(j, j2);
                    if (c.this.f28832a.pb() <= 0 || j2 <= ((long) c.this.f28832a.pb()) * 1000 || j < ((long) c.this.f28832a.pb()) * 1000 || c.this.yp) {
                        return;
                    }
                    c.this.yp = true;
                    spVar.stop();
                    c.this.a(false);
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onPrepared(sp spVar) {
            if (!c.this.kk) {
                c.this.kk = true;
                com.byazt.rgb.ve.ve(c.this.b());
            }
            m.c("BaseVideoController", "IVideoPlayerCallback onPrepared: ");
            if (com.byazt.ex.c.c(c.this.f28832a)) {
                c.this.f28832a.ve(spVar.getCodec());
            }
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c.removeCallbacks(c.this.aw);
                    if (c.this.n != null) {
                        c.this.n(0);
                        c.this.n.tt();
                    }
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onRelease(sp spVar) {
            m.c("BaseVideoController", "IVideoPlayerCallback onRelease: ");
            com.byazt.rgb.ve.ve(c.this.b(), 2);
        }

        @Override // com.byazt.fk.sp.c
        public void onRenderStart(sp spVar, long j) {
            m.c("BaseVideoController", "IVideoPlayerCallback onRenderStart: ");
            if (!c.this.q) {
                c.this.q = true;
                com.byazt.rgb.ve.tt(c.this.b(), 1);
            }
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.n != null) {
                        c.this.n(0);
                        c.this.n.tt();
                        c.this.c.removeCallbacks(c.this.aw);
                        c.this.l = false;
                    }
                }
            });
            c.this.c(j, false);
            c.this.pu = System.currentTimeMillis();
            c.this.l();
            if (c.this.ic != null) {
                c.this.ic.ve();
            }
        }

        @Override // com.byazt.fk.sp.c
        public void onResume(sp spVar) {
            c.this.v = true;
        }

        @Override // com.byazt.fk.sp.c
        public void onSeekCompletion(sp spVar, boolean z) {
            m.c("BaseVideoController", "IVideoPlayerCallback onSeekCompletion: ");
            c.this.c.post(new Runnable() { // from class: com.byazt.zd.c.2.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c.removeCallbacks(c.this.aw);
                    if (c.this.n != null) {
                        c.this.n(0);
                        c.this.n.tt();
                    }
                }
            });
        }

        @Override // com.byazt.fk.sp.c
        public void onStart(sp spVar) {
        }

        @Override // com.byazt.fk.sp.c
        public void onVideoSizeChanged(sp spVar, int i, int i2) {
            m.c("BaseVideoController", "IVideoPlayerCallback onVideoSizeChanged: ");
            c.this.tk = i;
            c.this.kp = i2;
            c.this.lo();
        }
    };
    public final com.byazt.fn.ve r = new com.byazt.fn.ve() { // from class: com.byazt.zd.c.3
        @Override // com.byazt.fn.ve
        public void onNetworkChanged(Context context, Intent intent, boolean z, int i) {
            c.this.c(context, i);
        }
    };
    public boolean s = false;

    /* JADX INFO: renamed from: com.byazt.zd.c$8, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_LOW_VERISON_JPG, 112})
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[z.c.values().length];
            c = iArr;
            try {
                iArr[z.c.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[z.c.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[z.c.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.zd.c$c, reason: collision with other inner class name */
    public interface InterfaceC0595c {
        void c();

        void c(int i, String str);

        void c(long j, long j2);

        void tt();

        void ve();
    }

    public c(Context context, ViewGroup viewGroup, ic icVar, com.byazt.hkv.c cVar) {
        this.oz = 1;
        this.oz = rh.ve(context);
        this.md = viewGroup;
        this.i = new WeakReference<>(context);
        this.f28832a = icVar;
        this.or = cVar;
        c(context);
        this.lr = nb.t(this.f28832a);
        this.lt = nb.tt(this.f28832a);
    }

    @Override // com.byazt.dh.ve
    public void c(ve.uj ujVar) {
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.ve.ve(b(), 3);
    }

    public abstract int gu();

    @Override // com.byazt.dh.c
    public void n(com.byazt.dh.tt ttVar, View view) {
    }

    @Override // com.byazt.nj.c
    public boolean p() {
        return true;
    }

    public boolean p_() {
        ic icVar = this.f28832a;
        return icVar == null || icVar.fr() == 100.0f;
    }

    @Override // com.byazt.dh.ve
    public boolean rl() {
        return false;
    }

    @Override // com.byazt.dh.ve
    public void uj(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        ic icVar = this.f28832a;
        if (icVar == null) {
            return null;
        }
        return icVar.zm();
    }

    private boolean gr() {
        int i;
        sp ujVar;
        ic icVar = this.f28832a;
        if (com.byazt.ic.c.tt(icVar)) {
            com.byazt.jr.tt ttVarTk = tk();
            if (ttVarTk == null) {
                if (this.cu != null) {
                    StringBuilder sb = new StringBuilder("创建lottie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb.append(this.n == null);
                    this.cu.onError(null, new com.byazt.jzl.ve(60008, 10005, sb.toString()));
                }
                m.uj("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int iSl = nb.sl(this.f28832a);
            this.zm = c("ad");
            this.uj = new com.byazt.kft.c(ttVarTk, com.byazt.ic.c.i(icVar), new uj(String.valueOf(iSl), this.zm), xd.rh(icVar), c("assist"));
            i = 1;
        } else if (com.byazt.ic.c.ve(icVar)) {
            com.byazt.jr.tt ttVarTk2 = tk();
            if (ttVarTk2 == null) {
                if (this.cu != null) {
                    StringBuilder sb2 = new StringBuilder("创建Upie播放器时，iRenderView为null, mediaLayout is null: ");
                    sb2.append(this.n == null);
                    this.cu.onError(null, new com.byazt.jzl.ve(60008, 10005, sb2.toString()));
                }
                m.uj("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
            int iSl2 = nb.sl(this.f28832a);
            if (p.n() && this.qy.getPlayerType() == 1) {
                ujVar = com.byazt.btt.tt.c().createTTVideoPlayer(gt.getContext(), String.valueOf(iSl2));
            } else {
                this.zm = c("ad");
                ujVar = new uj(String.valueOf(iSl2), this.zm);
            }
            this.uj = new com.byazt.kft.tt(ujVar, com.byazt.ic.c.i(icVar), c("assist"), ttVarTk2);
            i = 2;
        } else {
            int iSl3 = nb.sl(this.f28832a);
            if (com.byazt.ex.c.c(this.f28832a)) {
                this.uj = com.byazt.btt.tt.c().createTTLiveVideoPlayer(gt.getContext(), p(), (long) xd.sp(this.f28832a), gt.tt().gy(), null);
                i = 3;
            } else if (p.n() && this.qy.getPlayerType() == 1) {
                this.uj = com.byazt.btt.tt.c().createTTVideoPlayer(gt.getContext(), String.valueOf(iSl3));
                i = 4;
            } else {
                this.zm = c("ad");
                this.uj = new uj(String.valueOf(iSl3), this.zm);
                i = 5;
            }
        }
        if (icVar != null) {
            com.byazt.rgb.ve.c(icVar, String.valueOf(nb.t(this.f28832a)), nb.sl(this.f28832a), i, this.f28832a.zm());
        }
        return true;
    }

    private void kp() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.uj(0);
            this.n.c(false, false);
            this.n.ve(false);
            this.n.n();
            n(8);
            this.n.sp();
        }
    }

    private void lt() {
        InterfaceC0595c interfaceC0595c = this.ic;
        if (interfaceC0595c != null) {
            interfaceC0595c.c();
        }
    }

    private void pu() {
        if (!this.rl.c(64) || ve() || uj()) {
            this.rl.ve(64);
            long j = this.p;
            tt(j, j);
            long j2 = this.p;
            this.sp = j2;
            this.x = j2;
            cu();
        }
    }

    private com.byazt.jr.tt tk() {
        a aVar;
        WeakReference<Context> weakReference = this.i;
        if (weakReference == null || weakReference.get() == null || (aVar = this.n) == null) {
            return null;
        }
        return aVar.nu();
    }

    private boolean to() throws Throwable {
        ic icVar;
        WeakReference<Context> weakReference = this.i;
        return weakReference == null || weakReference.get() == null || tk() == null || this.uj == null || (icVar = this.f28832a) == null || pu.a(icVar) != null || pu.sp(this.f28832a) != null || this.f28832a.cf() == 1;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    public void aw() {
        int iTj;
        int iGu = gu();
        if (iGu == 2 || iGu == 1) {
            iTj = gt.tt().tj() * 1000;
        } else {
            iTj = 5;
            if (iGu == 5) {
                iTj = gt.tt().tj() * 1000;
            } else if (iGu == 3) {
                iTj = gt.tt().x(String.valueOf(this.lr));
            }
        }
        this.c.removeCallbacks(this.aw);
        this.c.postDelayed(this.aw, iTj);
    }

    public boolean bm() {
        return this.uj.isCompleted();
    }

    public void bx() {
        ic icVar = this.f28832a;
        if (icVar != null) {
            new com.byazt.ddx.c.C0382c().tt("auto_replay").c(nb.tt(icVar)).n(this.f28832a.uj()).uj(this.f28832a.w_()).c(new com.byazt.ya.c() { // from class: com.byazt.zd.c.4
                @Override // com.byazt.ya.c
                public void onSend(JSONObject jSONObject) throws JSONException {
                    n currentVideoInfo;
                    JSONObject jSONObject2 = new JSONObject();
                    if (t.c(c.this.f28832a)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (c.this.qy != null && (currentVideoInfo = c.this.qy.getCurrentVideoInfo()) != null && currentVideoInfo.getStart() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        jSONObject2.put("start", currentVideoInfo.getStart());
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            });
        }
    }

    @Override // com.byazt.dh.ve
    public void da() {
        tt(-1);
        i();
    }

    public boolean hd() {
        return this.to;
    }

    @Override // com.byazt.dh.ve
    public void i() {
        sp spVar = this.uj;
        if (spVar != null) {
            spVar.release();
            this.uj = null;
        }
        a aVar = this.n;
        if (aVar != null) {
            aVar.i();
        }
        this.c.removeCallbacks(this.aw);
        this.c.removeCallbacksAndMessages(null);
        this.sv = null;
        this.ic = null;
    }

    public void ic() {
        if (!this.rl.c(64) || ve() || uj()) {
            if (this.rl.c(2) || t.c(this.f28832a)) {
                qp();
            }
        }
    }

    public void l() {
        if (com.byazt.ex.c.c(this.f28832a)) {
            int iGu = gu();
            boolean zC = this.rl.c(1024);
            long jLongValue = this.rl.tt(1).longValue();
            if (zC) {
                return;
            }
            this.rl.ve(1024);
            if (iGu == 1) {
                com.byazt.ddx.uj.c(this.f28832a, "rewarded_video", System.currentTimeMillis() - jLongValue, com.byazt.sw.uj.c(this.n));
            } else if (iGu == 2) {
                com.byazt.ddx.uj.c(this.f28832a, "fullscreen_interstitial_ad", System.currentTimeMillis() - jLongValue, com.byazt.sw.uj.c(this.n));
            }
        }
    }

    public void lo() {
        this.c.post(new Runnable() { // from class: com.byazt.zd.c.7
            @Override // java.lang.Runnable
            public void run() {
                if (my.uj(c.this.f28832a) || !c.this.p_()) {
                    c cVar = c.this;
                    cVar.c(cVar.tk, c.this.kp);
                    return;
                }
                if (com.byazt.ex.c.c(c.this.f28832a) && c.this.f28832a.by() == 2 && c.this.p_()) {
                    return;
                }
                if (!c.this.p_()) {
                    c cVar2 = c.this;
                    cVar2.c(cVar2.tk, c.this.kp);
                    return;
                }
                if (c.this.f28832a != null && c.this.f28832a.vi() == 0) {
                    c cVar3 = c.this;
                    cVar3.uj(cVar3.tk, c.this.kp);
                } else if (c.this.f28832a == null || c.this.f28832a.vi() != 2) {
                    c cVar4 = c.this;
                    cVar4.ve(cVar4.tk, c.this.kp);
                } else {
                    c cVar5 = c.this;
                    cVar5.tt(cVar5.tk, c.this.kp);
                }
            }
        });
    }

    public boolean lr() {
        sp spVar = this.uj;
        return spVar != null && spVar.isPlaying();
    }

    @Override // com.byazt.nj.c
    public Map<String, Object> pf() {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.zb;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : nb.c(this.h, this.f28832a, nu()).entrySet()) {
            map.put(entry2.getKey(), entry2.getValue());
        }
        return map;
    }

    @Override // com.byazt.dh.ve
    public boolean qy() {
        return this.l;
    }

    @Override // com.byazt.dh.ve
    public void sp() {
        sp spVar = this.uj;
        if (spVar != null) {
            spVar.pause();
        }
    }

    public int sv() {
        return t.c(this.f28832a) ? this.nb.get() : this.qp.get();
    }

    @Override // com.byazt.dh.ve
    public int u() {
        sp spVar = this.uj;
        if (spVar == null) {
            return 0;
        }
        return spVar.getBufferCount();
    }

    @Override // com.byazt.dh.ve
    public void x() {
        com.byazt.jzl.a aVar;
        a aVar2 = this.n;
        if (aVar2 != null) {
            aVar2.c();
            this.n.gt();
            this.n.gr();
        }
        m.c("BaseVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.da));
        sp spVar = this.uj;
        if (spVar != null) {
            if (spVar.isPaused()) {
                if (this.da || (((aVar = this.qy) != null && aVar.isAudio()) || com.byazt.ic.c.tt(this.f28832a))) {
                    eo();
                } else {
                    tt(this.yv);
                }
                m.c("BaseVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.da));
            } else {
                this.b = 1;
                this.q = false;
                this.uj.start(false, this.sp, this.nu);
            }
        }
        if (!this.rl.c(64) || ve() || uj()) {
            if (this.rl.c(2) || t.c(this.f28832a)) {
                qp();
            }
        }
    }

    @Override // com.byazt.dh.ve
    public int z() {
        return com.byazt.vv.c.c(this.x, this.p);
    }

    public void a(boolean z) {
        if (md() && this.n != null) {
            this.c.removeCallbacks(this.aw);
            n(0);
            this.n.tt();
            this.bx = System.currentTimeMillis() - this.pf;
            this.n.n(true);
            if (nb.x(this.f28832a)) {
                this.n.c2(this.f28832a, this.i, true);
            } else {
                this.n.yv();
            }
            pu();
            ve.c cVar = this.sv;
            if (cVar != null) {
                cVar.c(this.bx, com.byazt.vv.c.c(this.sp, this.p));
            }
            lt();
            this.my = true;
        }
    }

    @Override // com.byazt.nj.c, com.byazt.dh.ve
    public boolean n() {
        if (t.c(this.f28832a)) {
            return ((double) this.nb.get()) < ((double) xd.nu(this.f28832a).sp());
        }
        return super.uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sp(int i) {
        ic icVar;
        int iVe = rh.ve(gt.getContext());
        if (iVe != 4 && iVe != 0) {
            a();
            this.z = true;
            this.hd = false;
            a aVar = this.n;
            if (aVar != null && (icVar = this.f28832a) != null) {
                return aVar.c(i, xd.z(icVar), true);
            }
        } else if (iVe == 4) {
            this.z = false;
            a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.gt();
            }
        }
        return true;
    }

    @Override // com.byazt.nj.c, com.byazt.dh.ve
    public boolean uj() {
        if (t.c(this.f28832a)) {
            return ((double) this.nb.get()) <= ((double) xd.nu(this.f28832a).sp());
        }
        return super.uj();
    }

    @Override // com.byazt.dh.ve
    public boolean ve() {
        return this.qp.get() > 0;
    }

    private void ve(com.byazt.jzl.a aVar) throws Exception {
        if (aVar == null) {
            tt("model is null");
            return;
        }
        this.qy = aVar;
        if (this.uj != null) {
            ic icVar = this.f28832a;
            if (icVar != null) {
                aVar.setCodeId(String.valueOf(nb.t(icVar)));
            }
            aVar.setScene(1);
            com.byazt.rgb.ve.tt(b());
            this.uj.setDataSource(aVar);
        }
        this.pf = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.getUrl())) {
            this.n.n(8);
            this.n.n(0);
            c(new Runnable() { // from class: com.byazt.zd.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.uj == null) {
                        c.this.tt("play video error proxy empty");
                        return;
                    }
                    if (c.this.rl.uj(1)) {
                        c.this.tt("multi play_start");
                        return;
                    }
                    c.this.rl.c();
                    c.this.nb();
                    c.this.pf = System.currentTimeMillis();
                    c.this.n.uj(0);
                    c.this.b = 1;
                    c.this.q = false;
                    c.this.kk = false;
                    com.byazt.rgb.ve.c(c.this.b(), c.this.b);
                    c.this.uj.start(true, c.this.sp, c.this.nu);
                }
            });
            return;
        }
        tt("url is null");
    }

    @Override // com.byazt.dh.ve
    public void n(boolean z) {
        this.lo = z;
    }

    public void n(int i) {
        Object obj;
        if (this.i == null || !com.byazt.ex.c.c(this.f28832a) || this.i.get() == null || (obj = (Context) this.i.get()) == null || !(obj instanceof com.byazt.fh.tt)) {
            return;
        }
        ((com.byazt.fh.tt) obj).c(i == 0);
    }

    @Override // com.byazt.dh.ve
    public void tt() {
        if (this.uj != null) {
            if (!n()) {
                this.qp.getAndAdd(1);
                bx();
            }
            this.nb.getAndAdd(1);
            this.rl.c();
            nb();
            c(0L, true);
            ve(false);
            this.b = 2;
            this.q = false;
            this.uj.restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(int i, int i2) {
        ic icVar;
        try {
            WeakReference<Context> weakReference = this.i;
            if (weakReference != null && weakReference.get() != null && tk() != null && this.uj != null && (icVar = this.f28832a) != null) {
                boolean z = icVar.by() == 1;
                int[] iArrTt = pf.tt(gt.getContext());
                c(iArrTt[0], iArrTt[1], i, i2, z);
            }
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"InflateParams"})
    private void c(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(com.byazt.dh.tt.c.class);
        enumSetNoneOf.add(com.byazt.dh.tt.c.hideCloseBtn);
        enumSetNoneOf.add(com.byazt.dh.tt.c.hideBackBtn);
        a aVar = new a(context.getApplicationContext(), new LayoutVideoPlayLayoutForLive(context), true, enumSetNoneOf, this.f28832a, this, this.or);
        this.n = aVar;
        aVar.c((com.byazt.dh.c) this);
    }

    public void uj(int i) {
        if (md()) {
            boolean z = i == 0 || i == 8;
            Context context = this.i.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    public void c(long j, boolean z) {
        if (this.rl.c(2)) {
            return;
        }
        this.h = j;
        da(z);
        this.eo = true;
    }

    @Override // com.byazt.dh.ve
    public void a() {
        sp spVar = this.uj;
        if (spVar != null) {
            spVar.pause();
        }
        if (!this.rl.c(64) || ve() || uj()) {
            if (this.rl.c(2) || t.c(this.f28832a)) {
                ve((Map<String, Object>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(int i, int i2) {
        try {
            m.c("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.f28832a.ij());
            if (to()) {
                return;
            }
            m.c("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
            int[] iArrTt = pf.tt(gt.getContext());
            boolean z = false;
            boolean z2 = this.f28832a.by() == 1;
            float f = iArrTt[0];
            float f2 = iArrTt[1];
            float f3 = i;
            float f4 = i2;
            if (z2) {
                if (f3 > f4) {
                    c(f, f2, f3, f4, true);
                    return;
                }
            } else if (f3 < f4) {
                c(f, f2, f3, f4, false);
                return;
            }
            float f5 = f3 / f4;
            float f6 = f / f2;
            if (z2) {
                if (f6 < 0.5625f && f5 == 0.5625f) {
                    f3 = (9.0f * f2) / 16.0f;
                    z = true;
                    f4 = f2;
                }
            } else if (f6 > 1.7777778f && f5 == 1.7777778f) {
                f4 = (9.0f * f) / 16.0f;
                z = true;
                f3 = f;
            }
            m.c("changeVideoSize", "适配后宽高：videoHeight=" + f4 + ",videoWidth=" + f3);
            if (z) {
                f = f3;
                f2 = f4;
            } else {
                m.c("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f2 + "，videoWidth=" + f);
            }
            int i3 = (int) f;
            int i4 = (int) f2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            layoutParams.addRule(13);
            Object objTk = tk();
            if ((objTk instanceof TextureView) || (objTk instanceof UpieVideoView)) {
                if (objTk instanceof TextureView) {
                    ((TextureView) objTk).setLayoutParams(layoutParams);
                } else {
                    ((UpieVideoView) objTk).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.md.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i4;
                    layoutParams2.width = i3;
                    this.md.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            m.ve("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.byazt.dh.ve
    public boolean c(com.byazt.jzl.a aVar) {
        if (aVar == null) {
            tt("model is null");
            return false;
        }
        sp spVar = this.uj;
        if (spVar != null && spVar.isPaused()) {
            this.uj.play();
            return true;
        }
        this.qy = aVar;
        aVar.getUrl();
        if (TextUtils.isEmpty(aVar.getUrl())) {
            m.uj("BaseVideoController", "No video info");
            tt("url is null");
            return false;
        }
        this.d = (aVar.getUrl().startsWith("http") || com.byazt.ex.c.c(this.f28832a)) ? false : true;
        this.nu = aVar.isQuiet();
        if (aVar.getCurrent() > 0) {
            long current = aVar.getCurrent();
            this.sp = current;
            long j = this.x;
            if (j > current) {
                current = j;
            }
            this.x = current;
        }
        a aVar2 = this.n;
        if (aVar2 != null) {
            aVar2.c();
            n(8);
            this.n.sp();
            this.n.ve(aVar.getWidth(), aVar.getHeight());
            this.n.ve(this.md);
        }
        try {
            if (this.uj == null) {
                if (!gr()) {
                    tt("create video error");
                    return false;
                }
                this.uj.addIVideoPlayerCallback(this.cu);
            }
            yv();
            this.bx = 0L;
            ve(aVar);
            return true;
        } catch (Throwable th) {
            tt(th.getMessage());
            m.uj("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    @Override // com.byazt.dh.ve
    public void tt(Map<String, Object> map) {
        this.zb = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(int i, int i2) {
        try {
            WeakReference<Context> weakReference = this.i;
            if (weakReference != null && weakReference.get() != null && tk() != null && this.uj != null && this.f28832a != null) {
                int[] iArrTt = pf.tt(gt.getContext());
                boolean z = this.f28832a.by() == 1;
                float f = iArrTt[0];
                float f2 = iArrTt[1];
                float f3 = i;
                float f4 = i2;
                if (z) {
                    if (f3 > f4) {
                        c(f, f2, f3, f4, true);
                        return;
                    }
                    f2 = (f4 * f) / f3;
                } else {
                    if (f3 < f4) {
                        c(f, f2, f3, f4, false);
                        return;
                    }
                    f = (f3 * f2) / f4;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (this.md != null) {
                    Object objTk = tk();
                    if (objTk instanceof TextureView) {
                        ((TextureView) objTk).setLayoutParams(layoutParams);
                    } else if (objTk instanceof UpieVideoView) {
                        ((UpieVideoView) objTk).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            m.ve("changeVideoSize", "changeVideoSizeByWidth error", th);
        }
    }

    private boolean a(int i) {
        return this.n.ve(i);
    }

    @Override // com.byazt.dh.c
    public void uj(com.byazt.dh.tt ttVar, View view) {
        if (this.gt) {
            i(false);
            a aVar = this.n;
            if (aVar != null) {
                aVar.tt(this.md);
            }
            uj(1);
            return;
        }
        c(1);
        c(true, 3);
    }

    @Override // com.byazt.dh.c
    public void tt(com.byazt.dh.tt ttVar, int i) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(long j, long j2) {
        this.sp = j;
        this.p = j2;
        this.n.c(j, j2);
        int iC = com.byazt.vv.c.c(j, j2);
        if (!ve() && !uj()) {
            this.n.tt(iC);
        } else {
            this.n.tt(100);
        }
        try {
            ve.c cVar = this.sv;
            if (cVar != null) {
                cVar.c(j, j2);
            }
            InterfaceC0595c interfaceC0595c = this.ic;
            if (interfaceC0595c != null) {
                interfaceC0595c.c(j, j2);
            }
        } catch (Throwable th) {
            m.ve("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.byazt.dh.c
    public void ve(com.byazt.dh.tt ttVar, View view) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.i();
        }
        c(1);
        c(true, 3);
    }

    @Override // com.byazt.dh.ve
    public void c(ve.tt ttVar) {
        this.bm = new WeakReference<>(ttVar);
    }

    @Override // com.byazt.dh.ve
    public void c(ve.c cVar) {
        this.sv = cVar;
    }

    @Override // com.byazt.dh.ve
    public void c(Map<String, Object> map) {
        sp spVar = this.uj;
        if (spVar != null) {
            spVar.pause();
        }
        if (!this.rl.c(64) || ve() || uj()) {
            if (this.rl.c(2) || t.c(this.f28832a)) {
                ve(map);
            }
        }
    }

    @Override // com.byazt.dh.c
    public void tt(com.byazt.dh.tt ttVar, View view) {
        tt(ttVar, view, false, false);
    }

    public void tt(com.byazt.dh.tt ttVar, View view, boolean z, boolean z2) {
        if (md()) {
            i(!this.gt);
            if (this.i.get() instanceof Activity) {
                if (this.gt) {
                    uj(z ? 8 : 0);
                    a aVar = this.n;
                    if (aVar != null) {
                        aVar.c(this.md);
                        this.n.ve(false);
                    }
                } else {
                    uj(1);
                    a aVar2 = this.n;
                    if (aVar2 != null) {
                        aVar2.tt(this.md);
                        this.n.ve(false);
                    }
                }
                WeakReference<ve.tt> weakReference = this.bm;
                ve.tt ttVar2 = weakReference != null ? weakReference.get() : null;
                if (ttVar2 != null) {
                    ttVar2.c(this.gt);
                }
            }
        }
    }

    @Override // com.byazt.dh.ve
    public void c(long j) {
        this.sp = Math.max(j, nu().getCurrentPosition());
        this.x = Math.max(this.x, sl());
        a aVar = this.n;
        if (aVar != null) {
            aVar.c();
        }
        sp spVar = this.uj;
        if (spVar != null) {
            this.b = 1;
            this.q = false;
            spVar.start(false, this.sp, this.nu);
            this.uj.seekTo(this.sp);
        }
    }

    @Override // com.byazt.dh.ve
    public void c(boolean z, int i) {
        tt(i);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, int i2) {
        ViewGroup viewGroup;
        try {
            if (tk() != null && this.uj != null && (viewGroup = this.md) != null) {
                float f = i;
                float f2 = i2;
                float width = viewGroup.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.md.getHeight();
                if (f3 <= f2 / (height * 1.0f)) {
                    width = f * (height / (f2 * 1.0f));
                } else {
                    height = f2 * (width / (f * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object objTk = tk();
                if (objTk instanceof TextureView) {
                    ((TextureView) objTk).setLayoutParams(layoutParams);
                } else if (objTk instanceof UpieVideoView) {
                    ((UpieVideoView) objTk).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            m.ve("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    private void tt(long j, boolean z) {
        if (this.uj == null) {
            return;
        }
        if (z) {
            kp();
        }
        this.uj.seekTo(j);
    }

    @Override // com.byazt.dh.ve
    public void tt(com.byazt.jzl.a aVar) {
        this.qy = aVar;
    }

    private void c(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = xd.uj(this.f28832a);
                f4 = xd.ve(this.f28832a);
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            Object objTk = tk();
            if (objTk instanceof TextureView) {
                ((TextureView) objTk).setLayoutParams(layoutParams);
            } else if (objTk instanceof UpieVideoView) {
                ((UpieVideoView) objTk).setLayoutParams(layoutParams);
            }
            this.to = true;
        }
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, View view) {
        if (this.uj == null || !md()) {
            return;
        }
        if (this.uj.isPlaying()) {
            a();
            this.n.tt(true, false);
            this.n.a();
            return;
        }
        if (!this.uj.isPaused()) {
            a aVar = this.n;
            if (aVar != null) {
                aVar.ve(this.md);
            }
            c(this.sp);
            a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.tt(false, false);
                return;
            }
            return;
        }
        x();
        a aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.tt(false, false);
        }
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, int i) {
        if (this.uj == null) {
            return;
        }
        tt(this.os, a(i));
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, int i, boolean z) {
        if (md()) {
            long j = this.p;
            long j2 = (long) (((((long) i) * j) * 1.0f) / 100.0f);
            if (j > 0) {
                this.os = (int) j2;
            } else {
                this.os = 0L;
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.c(this.os);
            }
        }
    }

    @Override // com.byazt.dh.c
    public void c(com.byazt.dh.tt ttVar, View view, boolean z, boolean z2) {
        if (this.t) {
            a();
        }
        if (z && !this.t && !bm()) {
            this.n.tt(!lr(), false);
            this.n.c(z2, true, false);
        }
        sp spVar = this.uj;
        if (spVar != null && spVar.isPlaying()) {
            this.n.a();
            this.n.n();
        } else {
            this.n.a();
        }
    }

    @Override // com.byazt.dh.c
    public void c() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.n();
            this.n.c();
        }
        a aVar2 = this.n;
        if (aVar2 != null) {
            aVar2.gr();
        }
        c(-1L);
    }

    @Override // com.byazt.un.tt
    public void c(z.c cVar, String str) {
        int i = AnonymousClass8.c[cVar.ordinal()];
        if (i == 1) {
            a();
            return;
        }
        if (i == 2) {
            c(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            x();
            this.z = false;
            this.hd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, int i) {
        if (md() && this.oz != i) {
            if (!this.hd) {
                da.tt().post(new Runnable() { // from class: com.byazt.zd.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sp(2);
                    }
                });
            }
            this.oz = i;
        }
    }

    @Override // com.byazt.dh.ve
    public void c(int i) {
        if (com.byazt.ex.c.c(this.f28832a)) {
            int iGu = gu();
            long jCurrentTimeMillis = System.currentTimeMillis() - this.pu;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(u()));
                jSONObject.putOpt("buffer_time", Long.valueOf(t()));
            } catch (Exception e) {
                m.c(e);
            }
            if (!this.rl.c(512)) {
                this.rl.ve(512);
                if (iGu == 1) {
                    com.byazt.ddx.uj.c(this.f28832a, "rewarded_video", jCurrentTimeMillis, jSONObject, com.byazt.sw.uj.c(this.n));
                } else if (iGu == 2) {
                    com.byazt.ddx.uj.c(this.f28832a, "fullscreen_interstitial_ad", jCurrentTimeMillis, jSONObject, com.byazt.sw.uj.c(this.n));
                }
            }
            if (com.byazt.ex.c.c(this.f28832a)) {
                if (com.byazt.apd.tt.c().c(this.f28832a)) {
                    com.byazt.apd.tt.c().c(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.f28832a, jCurrentTimeMillis);
                } else {
                    com.byazt.ex.c.c(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.f28832a, jCurrentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str) {
        if (com.byazt.ex.c.c(this.f28832a)) {
            int iGu = gu();
            if (iGu == 1) {
                com.byazt.ddx.uj.c(this.f28832a, "rewarded_video", i, str, com.byazt.sw.uj.c(this.n));
            } else if (iGu == 2) {
                com.byazt.ddx.uj.c(this.f28832a, "fullscreen_interstitial_ad", i, str, com.byazt.sw.uj.c(this.n));
            }
        }
    }

    public void c(InterfaceC0595c interfaceC0595c) {
        this.ic = interfaceC0595c;
    }
}
