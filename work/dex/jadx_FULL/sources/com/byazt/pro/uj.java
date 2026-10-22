package com.byazt.pro;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.cu;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.afw.nu;
import com.byazt.apd.EcMallWebView;
import com.byazt.bzd.t;
import com.byazt.bzd.x;
import com.byazt.ete.bx;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.jzl.a;
import com.byazt.lbn.LazeLayout;
import com.byazt.nc.u;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import com.byazt.ukr.n;
import com.byazt.ukr.yp;
import com.byazt.un.NativeDrawVideoTsView;
import com.byazt.un.NativeVideoTsView;
import com.huachenjie.common.video.VideoPlayerActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 199, 15})
public class uj extends com.byazt.lq.tt implements com.byazt.oce.c, com.byazt.dh.ve.uj, com.byazt.dh.ve.InterfaceC0386ve, com.byazt.ua.c.InterfaceC0539c, LazeLayout.c<NativeVideoTsView>, com.byazt.lbn.c<NativeVideoTsView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.kyz.ve f28958a;
    public com.byazt.ua.c c;
    public LazeLayout da;
    public boolean i;
    public ic m;
    public com.byazt.bf.c n;
    public CreativeContainer nu;
    public com.byazt.lsp.c rh;
    public volatile WeakReference<NativeVideoTsView> sl;
    public int sp;
    public WeakReference<View> t;
    public com.byazt.dj.tt tt;
    public com.byazt.bf.tt u;
    public int[] uj;
    public int ve;
    public com.byazt.yh.c x;
    public volatile int yp;
    public volatile boolean z;

    public uj(Context context, ic icVar, int i, com.byazt.dj.tt ttVar) {
        super(new com.byazt.kyz.ve(context, icVar, i, ttVar, true));
        this.uj = null;
        this.i = false;
        this.da = null;
        this.sl = null;
        this.t = null;
        this.rh = new com.byazt.lsp.c(null) { // from class: com.byazt.pro.uj.4
            @Override // com.byazt.lsp.c
            public void c(View view, u uVar) {
                if (uj.this.sl == null || uj.this.sl.get() == null) {
                    return;
                }
                ((NativeVideoTsView) uj.this.sl.get()).sl();
            }

            @Override // com.byazt.lsp.c
            public void c(u uVar) {
            }

            @Override // com.byazt.lsp.c
            public void tt(View view, u uVar) {
                if (uj.this.sl == null || uj.this.sl.get() == null) {
                    return;
                }
                ((NativeVideoTsView) uj.this.sl.get()).sl();
            }
        };
        com.byazt.kyz.ve veVar = (com.byazt.kyz.ve) getNativeAd();
        this.f28958a = veVar;
        veVar.getInteractionManager().c(this);
        this.ve = i;
        this.tt = ttVar;
        this.c = new com.byazt.ua.c();
        this.m = icVar;
        int iT = nb.t(icVar);
        this.sp = iT;
        c(iT);
        this.f28958a.setPluginAdInteractionListener(this.rh);
        if (context == null || ic.ve(icVar) || !CreativeContainer.c(icVar)) {
            return;
        }
        this.nu = new CreativeContainer(context, icVar, this.f28958a.getInteractionManager());
    }

    public NativeVideoTsView createNativeVideoTsView(boolean z) {
        NativeVideoTsView nativeDrawVideoTsView = z ? new NativeDrawVideoTsView(this.f28958a.getContext(), this.f28958a.getMaterialMeta()) : new NativeVideoTsView(this.f28958a.getContext(), this.f28958a.getMaterialMeta(), false, false, nb.tt(this.ve), false, false);
        this.sl = new WeakReference<>(nativeDrawVideoTsView);
        this.f28958a.setWeakReferenceTsView(this.sl);
        this.f28958a.setVideoViewEasyPlayableSender();
        return nativeDrawVideoTsView;
    }

    @Override // com.byazt.lq.tt, com.byazt.nc.u
    public void destroy() {
        NativeVideoTsView nativeVideoTsView;
        if (this.sl != null && (nativeVideoTsView = this.sl.get()) != null) {
            nativeVideoTsView.gt();
        }
        LazeLayout lazeLayout = this.da;
        if (lazeLayout != null) {
            lazeLayout.c();
        }
        CreativeContainer creativeContainer = this.nu;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
        super.destroy();
    }

    public JSONObject filterVideoKeys(Map<String, Object> map) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null) {
                    if (key.contains("video") || key.contains("video_url") || key.contains(VideoPlayerActivity.t)) {
                        jSONObject.put(key, value);
                    }
                }
            }
        }
        return jSONObject;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.tt.ve(getLifecycleId(), 3);
    }

    public int getAdType() {
        return this.ve;
    }

    @Override // com.byazt.lq.tt, com.byazt.nc.u
    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsViewInflate = null;
        if (this.f28958a.getMaterialMeta() == null || this.f28958a.getContext() == null) {
            return null;
        }
        com.byazt.iyp.tt.c(this.f28958a.getMaterialMeta().c());
        if (ic.tt(this.f28958a.getMaterialMeta())) {
            yp.c().c(this.f28958a.getMaterialMeta(), 3, "valid invoke");
        }
        if (com.byazt.wu.uj.c(this.f28958a.getMaterialMeta())) {
            return c();
        }
        Context context = this.f28958a.getContext();
        if (ic.ve(this.m)) {
            if (!x.c() || !gt.tt().bw().tt) {
                try {
                    nativeVideoTsViewInflate = inflate(context);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewInflate != null) {
                    onFill(nativeVideoTsViewInflate);
                }
                return nativeVideoTsViewInflate;
            }
            if (this.sl != null && (nativeVideoTsView = this.sl.get()) != null) {
                nativeVideoTsView.setNativeRenderAd(true);
                return nativeVideoTsView;
            }
            this.da = new LazeLayout(context, this, this);
        } else if (this.nu != null) {
            com.byazt.kyz.ve veVar = this.f28958a;
            if (veVar != null && veVar.getInteractionManager() != null) {
                this.f28958a.getInteractionManager().c(this.nu);
            }
            return this.nu;
        }
        com.byazt.dz.uj.c().c(this.f28958a.getMaterialMeta()).c(this.ve).tt(this.sp);
        return this.da;
    }

    @Override // com.byazt.nc.da
    public int getAdViewHeight() {
        com.byazt.kyz.ve veVar = this.f28958a;
        if (veVar != null) {
            ic materialMeta = veVar.getMaterialMeta();
            int imageMode = this.f28958a.getImageMode();
            if (CreativeContainer.c(materialMeta) && (imageMode == 5 || imageMode == 15 || imageMode == 2001 || imageMode == 2002)) {
                return materialMeta.pa().get(0).ve();
            }
        }
        try {
            if (this.uj == null) {
                this.uj = tt();
            }
            int[] iArr = this.uj;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            m.ve("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    @Override // com.byazt.nc.da
    public int getAdViewWidth() {
        com.byazt.kyz.ve veVar = this.f28958a;
        if (veVar != null) {
            ic materialMeta = veVar.getMaterialMeta();
            int imageMode = this.f28958a.getImageMode();
            if (CreativeContainer.c(materialMeta) && (imageMode == 5 || imageMode == 15 || imageMode == 2001 || imageMode == 2002)) {
                return materialMeta.pa().get(0).tt();
            }
        }
        try {
            if (this.uj == null) {
                this.uj = tt();
            }
            int[] iArr = this.uj;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return 1280;
        } catch (Throwable th) {
            m.ve("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    public int getCodeId() {
        return this.sp;
    }

    @Override // com.byazt.nc.da
    public com.byazt.yh.c getCustomVideo() {
        if (ic.tt(this.m)) {
            yp.c().c(this.m, 1, "invalid invoke");
            return null;
        }
        if (!ic.c(this.f28958a.getMaterialMeta())) {
            return null;
        }
        if (this.x == null) {
            this.x = new com.byazt.yh.c() { // from class: com.byazt.pro.uj.3
                public long tt = 0;

                @Override // com.byazt.yh.c
                public String getVideoUrl() {
                    if (ic.tt(uj.this.m)) {
                        yp.c().c(uj.this.m, 2, "invalid invoke url");
                        return null;
                    }
                    if (uj.this.f28958a.getMaterialMeta() == null || uj.this.f28958a.getMaterialMeta().g() != 1 || xd.z(uj.this.f28958a.getMaterialMeta()) == null) {
                        return null;
                    }
                    if (!uj.this.i) {
                        uj.this.i = true;
                    }
                    return xd.c(uj.this.f28958a.getMaterialMeta());
                }

                @Override // com.byazt.yh.c
                public void reportVideoAutoStart() {
                    com.byazt.ddx.uj.c(uj.this.f28958a.getMaterialMeta(), nb.tt(uj.this.f28958a.getMaterialMeta()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (xd.z(uj.this.f28958a.getMaterialMeta()) != null) {
                        a aVarC = xd.c(4, uj.this.f28958a.getMaterialMeta());
                        aVarC.putExtra("material_meta", uj.this.f28958a.getMaterialMeta());
                        com.byazt.dj.tt ttVarIj = uj.this.f28958a.getMaterialMeta().ij();
                        aVarC.putExtra("ad_slot", Integer.valueOf(ttVarIj != null ? ttVarIj.gt() : 0));
                        aVarC.setPlayerType(-1);
                        com.byazt.sw.uj.c(uj.this.f28958a.getMaterialMeta(), (com.byazt.oce.c) uj.this, aVarC, true, com.byazt.sw.uj.c());
                    }
                }

                @Override // com.byazt.yh.c
                public void reportVideoBreak(long j) {
                    if (this.tt == 0) {
                        this.tt = SystemClock.elapsedRealtime();
                    }
                    long videoDuration = ((long) uj.this.getVideoDuration()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.tt) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    nu.c cVar = new nu.c();
                    cVar.c(j);
                    cVar.ve(videoDuration);
                    cVar.tt(j2);
                    cVar.n(0);
                    cVar.a(0);
                    cVar.c(true);
                    com.byazt.sw.uj.c(uj.this, cVar, null, -1);
                }

                @Override // com.byazt.yh.c
                public void reportVideoContinue(long j) {
                    if (this.tt == 0) {
                        this.tt = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.tt) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    nu.c cVar = new nu.c();
                    cVar.c(j);
                    cVar.ve(((long) uj.this.getVideoDuration()) * 1000);
                    cVar.tt(j2);
                    cVar.c(true);
                    com.byazt.sw.uj.tt(uj.this, cVar);
                }

                @Override // com.byazt.yh.c
                public void reportVideoError(long j, int i, int i2) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.tt == 0) {
                        this.tt = jElapsedRealtime;
                    }
                    long j2 = jElapsedRealtime - this.tt;
                    long videoDuration = ((long) uj.this.getVideoDuration()) * 1000;
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int i3 = j2 == 0 ? 1 : 0;
                    nu.c cVar = new nu.c();
                    cVar.tt(j3);
                    cVar.ve(videoDuration);
                    cVar.c(j);
                    cVar.c(i);
                    cVar.tt(i2);
                    cVar.c(true);
                    com.byazt.sw.uj.c((com.byazt.oce.c) uj.this, cVar, "customer error", i3, false);
                }

                @Override // com.byazt.yh.c
                public void reportVideoFinish() {
                    if (this.tt == 0) {
                        this.tt = SystemClock.elapsedRealtime();
                    }
                    long videoDuration = ((long) uj.this.getVideoDuration()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.tt) - videoDuration;
                    long j = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    nu.c cVar = new nu.c();
                    cVar.c(videoDuration);
                    cVar.ve(videoDuration);
                    cVar.tt(j);
                    cVar.a(0);
                    cVar.c(true);
                    com.byazt.sw.uj.uj(uj.this, cVar);
                }

                @Override // com.byazt.yh.c
                public void reportVideoPause(long j) {
                    if (this.tt == 0) {
                        this.tt = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.tt) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    nu.c cVar = new nu.c();
                    cVar.c(j);
                    cVar.ve(((long) uj.this.getVideoDuration()) * 1000);
                    cVar.tt(j2);
                    cVar.c(true);
                    com.byazt.sw.uj.c(uj.this, cVar, -1);
                }

                @Override // com.byazt.yh.c
                public void reportVideoStart() {
                    this.tt = SystemClock.elapsedRealtime();
                    nu.c cVar = new nu.c();
                    cVar.tt(true);
                    cVar.c(true);
                    com.byazt.sw.uj.c(uj.this, cVar);
                }

                @Override // com.byazt.yh.c
                public void reportVideoStartError(int i, int i2) {
                    HashMap map = new HashMap();
                    map.put("creative_id", uj.this.f28958a.getMaterialMeta().uj());
                    map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
                    map.put("extra_error_code", Integer.valueOf(i2));
                    map.put("is_customer", 1);
                    com.byazt.jzl.uj ujVarZ = xd.z(uj.this.f28958a.getMaterialMeta());
                    if (ujVarZ != null) {
                        map.put("video_size", Long.valueOf(ujVarZ.getSize()));
                        map.put(CropKey.VIDEO_RESOLUTION, ujVarZ.getResolution());
                    }
                    com.byazt.ddx.uj.ve(uj.this.f28958a.getMaterialMeta(), nb.tt(uj.this.f28958a.getMaterialMeta()), "play_start_error", map);
                }
            };
        }
        return this.x;
    }

    @Override // com.byazt.ua.c.InterfaceC0539c
    public boolean getHasUseCustomizeVideo() {
        return this.i;
    }

    @Override // com.byazt.nc.u
    public String getLifecycleId() {
        ic icVar = this.m;
        if (icVar != null) {
            return icVar.zm();
        }
        return null;
    }

    @Override // com.byazt.lq.tt, com.byazt.nc.u
    public Map<String, Object> getMediaExtraInfo() {
        JSONObject jSONObjectFilterVideoKeys;
        Map<String, Object> mediaExtraInfo = this.f28958a.getMediaExtraInfo();
        if (n.c("media_ext_video", 1.0d)) {
            Exception e = null;
            try {
                jSONObjectFilterVideoKeys = filterVideoKeys(mediaExtraInfo);
                try {
                    ic materialMeta = this.f28958a.getMaterialMeta();
                    if (jSONObjectFilterVideoKeys != null && jSONObjectFilterVideoKeys.length() > 0) {
                        jSONObjectFilterVideoKeys.put("rit", nb.c(materialMeta, ""));
                        jSONObjectFilterVideoKeys.put("req_id", materialMeta.qy());
                        jSONObjectFilterVideoKeys.put("cid", materialMeta.uj());
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                jSONObjectFilterVideoKeys = null;
                e = e3;
            }
            if (jSONObjectFilterVideoKeys != null && jSONObjectFilterVideoKeys.length() > 0) {
                yp.c().c("media_ext_video", jSONObjectFilterVideoKeys, e);
            }
        }
        ic materialMeta2 = this.f28958a.getMaterialMeta();
        if (materialMeta2 == null) {
            return mediaExtraInfo;
        }
        if (mediaExtraInfo == null) {
            mediaExtraInfo = new HashMap<>();
        }
        mediaExtraInfo.put("reward_task_type", Integer.valueOf(materialMeta2.ne()));
        mediaExtraInfo.put("reward_task_threshold", Integer.valueOf(materialMeta2.ix() != null ? materialMeta2.ix().tt() : -1));
        if (materialMeta2.id() == 166 && com.byazt.ex.c.c(materialMeta2)) {
            int iUj = bx.uj(materialMeta2);
            int iN = bx.n(materialMeta2);
            mediaExtraInfo.put("live_author_follower_count", Integer.valueOf(iUj));
            mediaExtraInfo.put("live_watch_count", Integer.valueOf(iN));
        }
        return mediaExtraInfo;
    }

    @Override // com.byazt.nc.u
    public com.byazt.sbm.n getMediationManager() {
        return new com.byazt.ah.ve();
    }

    public NativeVideoTsView getNativeVideoTsView() {
        if (this.sl != null) {
            return this.sl.get();
        }
        return null;
    }

    @Override // com.byazt.nc.da
    public double getVideoDuration() {
        return t.c(this.f28958a.getMaterialMeta()) ? AudioStats.AUDIO_AMPLITUDE_NONE : xd.sp(this.f28958a.getMaterialMeta());
    }

    @Override // com.byazt.ua.c.InterfaceC0539c
    public com.byazt.ua.c getVideoModel() {
        return this.c;
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onProgressUpdate(long j, long j2) {
        com.byazt.bf.c cVar = this.n;
        if (cVar != null) {
            cVar.c(j, j2);
        }
        c(j, j2);
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdContinuePlay() {
        com.byazt.bf.c cVar = this.n;
        if (cVar != null) {
            cVar.uj(this);
        }
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdPaused() {
        com.byazt.bf.c cVar = this.n;
        if (cVar != null) {
            cVar.ve(this);
        }
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoAdStartPlay() {
        com.byazt.bf.c cVar = this.n;
        if (cVar != null) {
            cVar.tt(this);
        }
    }

    @Override // com.byazt.dh.ve.InterfaceC0386ve
    public void onVideoComplete() {
        com.byazt.bf.c cVar = this.n;
        if (cVar != null) {
            cVar.n(this);
        }
        if (!ve() || this.z) {
            return;
        }
        this.u.c(0);
        this.z = true;
    }

    @Override // com.byazt.dh.ve.uj
    public void onVideoError(int i, int i2) {
        com.byazt.bf.c cVar = this.n;
        if (cVar != null) {
            cVar.c(i, i2);
        }
    }

    @Override // com.byazt.dh.ve.uj
    public void onVideoLoad() {
        com.byazt.bf.c cVar = this.n;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.lsp.c cVar, com.byazt.am.uj ujVar) {
        View adView;
        try {
            registerViewForInteraction(viewGroup, (List<View>) null, list, list2, list3, (View) null, cVar);
            if (ujVar != null) {
                View viewFindViewById = viewGroup.findViewById(ujVar.t());
                if (viewFindViewById != null && getAdLogo() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(getAdLogo());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = pf.ve(viewGroup.getContext(), 38.0f);
                        layoutParams.height = pf.ve(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(getAdLogo());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(ujVar.sp());
                if (frameLayout == null || (adView = getAdView()) == null) {
                    return;
                }
                pf.x(adView);
                frameLayout.removeAllViews();
                frameLayout.addView(adView, -1, -1);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    @Override // com.byazt.nc.u
    public void setEasyPlayWidgetListener(com.byazt.lsp.tt ttVar) {
        com.byazt.kyz.ve veVar = this.f28958a;
        if (veVar != null) {
            veVar.setEasyPlayWidgetListener(ttVar);
        }
    }

    @Override // com.byazt.nc.da
    public void setVideoAdListener(com.byazt.bf.c cVar) {
        this.n = cVar;
    }

    @Override // com.byazt.nc.da
    public void setVideoRewardListener(com.byazt.bf.tt ttVar) {
        this.u = ttVar;
    }

    private int[] tt() {
        if (this.f28958a.getMaterialMeta() == null) {
            return null;
        }
        if (this.f28958a.getMaterialMeta().id() == 166 && bx.c(this.f28958a.getMaterialMeta())) {
            return new int[]{bx.t(this.f28958a.getMaterialMeta()), bx.u(this.f28958a.getMaterialMeta())};
        }
        if (this.f28958a.getMaterialMeta().xx() == 1 && this.f28958a.getMaterialMeta().hc() == 1 && xd.m(this.f28958a.getMaterialMeta()) != null) {
            return xd.m(this.f28958a.getMaterialMeta()).getWidthAndHeight();
        }
        if (xd.z(this.f28958a.getMaterialMeta()) != null) {
            return xd.z(this.f28958a.getMaterialMeta()).getWidthAndHeight();
        }
        return null;
    }

    private boolean ve() {
        if (this.f28958a.getMaterialMeta() == null || this.u == null) {
            return false;
        }
        int iKz = this.f28958a.getMaterialMeta().kz();
        return iKz == 1 || iKz == 2;
    }

    @Override // com.byazt.lbn.c
    public NativeVideoTsView inflate(Context context) {
        NativeVideoTsView nativeVideoTsViewCreateNativeVideoTsView = createNativeVideoTsView(false);
        nativeVideoTsViewCreateNativeVideoTsView.setVideoAdClickListenerTTNativeAd(this);
        nativeVideoTsViewCreateNativeVideoTsView.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.byazt.pro.uj.1
            @Override // com.byazt.un.NativeVideoTsView.c
            public void c(View view, int i) {
                if (uj.this.f28958a.getInteractionManager() != null) {
                    uj.this.f28958a.getInteractionManager().c(view, i);
                }
            }
        });
        com.byazt.omf.x.m().c(-1L);
        nativeVideoTsViewCreateNativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.uj() { // from class: com.byazt.pro.uj.2
            @Override // com.byazt.un.NativeVideoTsView.uj
            public void c(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                com.byazt.ua.c cVar = uj.this.c;
                if (cVar != null) {
                    cVar.c = z;
                    cVar.n = j;
                    cVar.f29083a = j2;
                    cVar.sp = j3;
                    cVar.uj = z2;
                    cVar.x = z3;
                }
            }
        });
        nativeVideoTsViewCreateNativeVideoTsView.setVideoAdLoadListener(this);
        nativeVideoTsViewCreateNativeVideoTsView.setVideoAdInteractionListener(this);
        if (5 == this.ve) {
            nativeVideoTsViewCreateNativeVideoTsView.setIsAutoPlay(this.f28958a.isAllowDevOperate() ? this.tt.n() : this.f28958a.isAutoPlay());
        } else {
            nativeVideoTsViewCreateNativeVideoTsView.setIsAutoPlay(this.f28958a.isAutoPlay());
        }
        nativeVideoTsViewCreateNativeVideoTsView.setIsQuiet(this.m.ab() == 1);
        com.byazt.pop.ve veVarC = this.f28958a.getInteractionManager().c();
        if (veVarC != null) {
            veVarC.c(this);
        }
        return nativeVideoTsViewCreateNativeVideoTsView;
    }

    @Override // com.byazt.lbn.LazeLayout.c
    public void onFill(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.c(0L, true, false);
        }
    }

    private View c() {
        View view;
        WeakReference<View> weakReference = this.t;
        if (weakReference != null && (view = weakReference.get()) != null) {
            return view;
        }
        EcMallWebView ecMallWebView = new EcMallWebView(this.f28958a.getContext(), this.f28958a.getMaterialMeta(), this.ve == 9 ? 6 : 1);
        ecMallWebView.setMaterialMeta(cu.c(this.m));
        this.t = new WeakReference<>(ecMallWebView);
        return ecMallWebView;
    }

    private void c(int i) {
        int iA = gt.tt().a(i);
        if (3 == iA) {
            this.f28958a.setAllowDevOperate(false);
            this.f28958a.setAutoPlay(false);
            return;
        }
        if (1 == iA && rh.uj(this.f28958a.getContext())) {
            this.f28958a.setAllowDevOperate(false);
        } else if (2 == iA) {
            if (!rh.n(this.f28958a.getContext()) && !rh.uj(this.f28958a.getContext()) && !rh.a(this.f28958a.getContext())) {
                return;
            } else {
                this.f28958a.setAllowDevOperate(false);
            }
        } else if (4 == iA) {
            this.f28958a.setAllowDevOperate(true);
            return;
        } else {
            if (5 != iA) {
                return;
            }
            if (!rh.uj(this.f28958a.getContext()) && !rh.a(this.f28958a.getContext())) {
                return;
            }
        }
        this.f28958a.setAutoPlay(true);
    }

    private void c(long j, long j2) {
        long j3;
        int i;
        if (ve() && !this.z) {
            int iKz = this.f28958a.getMaterialMeta().kz();
            if (iKz == 1) {
                j3 = 15000;
            } else {
                j3 = iKz == 2 ? 30000L : 0L;
            }
            if (j2 <= j3) {
                i = (int) ((j2 - j) / 1000);
            } else {
                i = (int) ((j3 - j) / 1000);
            }
            if (i < 0) {
                i = 0;
            }
            if (i == this.yp) {
                return;
            }
            this.yp = i;
            if (this.yp == 0) {
                this.z = true;
            }
            this.u.c(this.yp);
        }
    }
}
