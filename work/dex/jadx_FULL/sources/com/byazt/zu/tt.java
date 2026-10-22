package com.byazt.zu;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.byazt.cv.u;
import com.byazt.hr.sl;
import com.byazt.hz.i;
import com.byazt.me.x;
import com.byazt.nc.da;
import com.byazt.nc.sp;
import com.byazt.nc.t;
import com.byazt.nr.m;
import com.byazt.vx.nu;
import com.byazt.vx.z;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 919, 13})
public class tt extends da {
    public static final String REGISTER_VIEW_TIP = "当前广告为模版广告，不能使用自渲染接口进行渲染，请使用render进行渲染";
    public static final String RENDER_TIP = "当前广告为自渲染广告，不能使用模版接口进行渲染，请使用registerViewForInteraction进行渲染";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f29249a;
    public i c;
    public com.byazt.ocd.tt da;
    public com.byazt.ocd.ve i;
    public com.byazt.bf.tt n;
    public com.byazt.lsp.c sp;
    public com.byazt.yl.ve tt;
    public com.byazt.bf.c uj;
    public com.byazt.ll.tt ve;
    public com.byazt.lsp.ve x;

    public tt(i iVar, com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar) {
        this.c = iVar;
        this.tt = veVar;
        if (veVar != null && veVar.getSubAdType() == 3) {
            this.tt.setExpressAd(true);
        }
        this.ve = ttVar;
        c();
    }

    private void x() {
        String strTt;
        long jCurrentTimeMillis;
        if (this.tt == null || this.ve == null) {
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.tt)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        com.byazt.bg.c.n(this.ve.gt());
        com.byazt.yl.ve veVar = this.tt;
        com.byazt.ng.a.c(veVar, this.ve, 0, strTt, jCurrentTimeMillis, veVar.isClickListenRepeatOnce());
    }

    @Override // com.byazt.nc.u
    public void destroy() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            try {
                veVar.onDestroy();
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    @Override // com.byazt.nc.u
    public Bitmap getAdLogo() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getAdLogo();
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public View getAdView() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null) {
            return null;
        }
        if (!veVar.isExpressAd()) {
            return this.tt.getVideoView();
        }
        com.byazt.ng.a.c(this.ve);
        if (this.tt.getCallBack() != null) {
            this.tt.getCallBack().c();
        }
        com.byazt.yl.ve veVar2 = this.tt;
        com.byazt.ng.a.c(veVar2, this.ve, veVar2.isShowRepeatOnce(), 0);
        View adView = this.tt.getAdView();
        this.f29249a = adView;
        return adView;
    }

    @Override // com.byazt.nc.da
    public int getAdViewHeight() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            if (veVar.isExpressAd()) {
                View view = this.f29249a;
                if (view != null) {
                    return view.getHeight();
                }
                return 0;
            }
            com.byazt.yl.ve veVar2 = this.tt;
            if (veVar2 != null) {
                return veVar2.getVideoHeight();
            }
        }
        return 0;
    }

    @Override // com.byazt.nc.da
    public int getAdViewWidth() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            if (veVar.isExpressAd()) {
                View view = this.f29249a;
                if (view != null) {
                    return view.getWidth();
                }
                return 0;
            }
            com.byazt.yl.ve veVar2 = this.tt;
            if (veVar2 != null) {
                return veVar2.getVideoWidth();
            }
        }
        return 0;
    }

    @Override // com.byazt.nc.u
    public int getAppCommentNum() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getAppCommentNum();
        }
        return 0;
    }

    @Override // com.byazt.nc.u
    public int getAppScore() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return (int) veVar.getStarRating();
        }
        return 0;
    }

    @Override // com.byazt.nc.u
    public int getAppSize() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getAppSize();
        }
        return 0;
    }

    @Override // com.byazt.nc.u
    public String getButtonText() {
        com.byazt.yl.ve veVar = this.tt;
        return veVar != null ? veVar.getActionText() : "";
    }

    @Override // com.byazt.nc.u
    public com.byazt.nc.ve getComplianceInfo() {
        return new com.byazt.cv.tt(this.tt);
    }

    @Override // com.byazt.nc.da
    public com.byazt.yh.c getCustomVideo() {
        return new com.byazt.cv.ve(this.tt);
    }

    @Override // com.byazt.nc.u
    public String getDescription() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getAdDescription();
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public sp getDislikeDialog(Activity activity) {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public com.byazt.nc.uj getDislikeInfo() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getDislikeInfo();
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public com.byazt.nc.n getDownloadStatusController() {
        return new com.byazt.cv.uj(this.tt);
    }

    @Override // com.byazt.nc.u
    public t getIcon() {
        com.byazt.yl.ve veVar = this.tt;
        return new u(veVar != null ? veVar.getIconUrl() : null);
    }

    @Override // com.byazt.nc.u
    public List<t> getImageList() {
        ArrayList arrayList = new ArrayList();
        com.byazt.yl.ve veVar = this.tt;
        List<String> images = veVar != null ? veVar.getImages() : null;
        com.byazt.yl.ve veVar2 = this.tt;
        String imageUrl = veVar2 != null ? veVar2.getImageUrl() : null;
        if (images != null) {
            if (images.size() != 0) {
                Iterator<String> it = images.iterator();
                while (it.hasNext()) {
                    arrayList.add(new u(it.next()));
                }
            } else if (!TextUtils.isEmpty(imageUrl)) {
                com.byazt.yl.ve veVar3 = this.tt;
                int imageWidth = veVar3 != null ? veVar3.getImageWidth() : 0;
                com.byazt.yl.ve veVar4 = this.tt;
                arrayList.add(new u(imageUrl, imageWidth, veVar4 != null ? veVar4.getImageHeight() : 0));
            }
        }
        return arrayList;
    }

    @Override // com.byazt.nc.u
    public int getImageMode() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getImageMode();
        }
        return -1;
    }

    @Override // com.byazt.nc.u
    public int getInteractionType() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getInteractionType();
        }
        return -1;
    }

    @Override // com.byazt.nc.u
    public String getLifecycleId() {
        return null;
    }

    @Override // com.byazt.nc.u
    public Map<String, Object> getMediaExtraInfo() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null) {
            return null;
        }
        Map<String, Object> mediaExtraInfo = veVar.getMediaExtraInfo();
        if (mediaExtraInfo == null) {
            com.byazt.ll.tt ttVar = this.ve;
            mediaExtraInfo = com.byazt.hz.tt.ve(ttVar != null ? ttVar.gt() : "");
        }
        if (this.tt.isHasShowCallback() && z.c()) {
            String strC = z.c(com.byazt.vx.t.c(this.ve, this.tt, true));
            if (!TextUtils.isEmpty(strC)) {
                mediaExtraInfo.put("get_show_ecpm_info", strC);
            }
        }
        return com.byazt.lkb.tt.c(mediaExtraInfo, this.tt.getExtraMsg());
    }

    @Override // com.byazt.nc.u
    public com.byazt.sbm.n getMediationManager() {
        return new com.byazt.cv.da(new ve(this.c, this.tt, this.ve));
    }

    @Override // com.byazt.nc.u
    public String getSource() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getSource();
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public String getTitle() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getAdTitle();
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public t getVideoCoverImage() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getVideoCoverImage();
        }
        return null;
    }

    @Override // com.byazt.nc.da
    public double getVideoDuration() {
        com.byazt.yl.ve veVar = this.tt;
        return veVar != null ? veVar.getVideoDuration() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, View view, com.byazt.lsp.c cVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        registerViewForInteraction(viewGroup, (List<View>) null, arrayList, (List<View>) null, (List<View>) null, (View) null, cVar);
    }

    @Override // com.byazt.nc.u
    public void render() {
        com.byazt.lsp.ve veVar;
        ve();
        if (this.tt != null) {
            uj();
            this.tt.render();
            c(this.tt);
            if (this.tt.getSubAdType() != 3 || (veVar = this.x) == null) {
                return;
            }
            veVar.c(this.f29249a, -1.0f, -2.0f, true);
        }
    }

    @Override // com.byazt.nc.u
    public void setActivityForDownloadApp(Activity activity) {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            veVar.setActivityForDownloadApp(activity);
        }
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        this.da = ttVar;
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            veVar.setAdInteractionListener(ttVar);
        }
    }

    @Override // com.byazt.nc.u
    public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null || activity == null) {
            return;
        }
        veVar.setDislikeCallback(activity, cVar);
    }

    @Override // com.byazt.nc.u
    public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            veVar.setDislikeDialog(dialog, numArr);
        }
    }

    @Override // com.byazt.nc.u
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
        this.i = veVar;
    }

    @Override // com.byazt.nc.u
    public void setEasyPlayWidgetListener(com.byazt.lsp.tt ttVar) {
    }

    @Override // com.byazt.nc.u
    public void setExpressRenderListener(com.byazt.lsp.ve veVar) {
        this.x = veVar;
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
    }

    @Override // com.byazt.nc.da
    public void setVideoAdListener(com.byazt.bf.c cVar) {
        this.uj = cVar;
    }

    @Override // com.byazt.nc.da
    public void setVideoRewardListener(com.byazt.bf.tt ttVar) {
        this.n = ttVar;
    }

    @Override // com.byazt.nc.u
    public void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.byazt.nc.u
    public void uploadDislikeEvent(String str) {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            veVar.uploadDislikeEvent(str);
        }
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
    }

    private void a() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null) {
            return;
        }
        if (veVar.isExpressAd()) {
            this.tt.setGMDrawAdListener(new com.byazt.fy.uj() { // from class: com.byazt.zu.tt.8
                @Override // com.byazt.fy.uj
                public void c(View view, String str, int i) {
                    if (tt.this.x instanceof com.byazt.am.n) {
                        ((com.byazt.am.n) tt.this.x).c(view, str, i);
                    }
                }

                @Override // com.byazt.fy.uj
                public void c(float f, float f2) {
                    if (tt.this.x != null) {
                        tt.this.x.c(tt.this.f29249a, f, f2, true);
                    }
                }

                @Override // com.byazt.fy.c
                public void c(View view) {
                    tt.this.c(view);
                }

                @Override // com.byazt.fy.c
                public void c() {
                    tt.this.tt((View) null);
                }
            });
        } else {
            this.tt.setGMDrawAdListener(new com.byazt.fy.c() { // from class: com.byazt.zu.tt.9
                @Override // com.byazt.fy.c
                public void c(View view) {
                    tt.this.c(view);
                }

                @Override // com.byazt.fy.c
                public void c() {
                    tt.this.tt((View) null);
                }
            });
        }
    }

    private void n() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null) {
            return;
        }
        veVar.setTTAdatperCallback(new com.byazt.zq.c() { // from class: com.byazt.zu.tt.7
            @Override // com.byazt.oc.c
            public void c() {
                if (tt.this.tt.getDislikeCallback() != null) {
                    tt.this.tt.getDislikeCallback().c(0, "banner ad closed", false);
                }
            }

            @Override // com.byazt.oc.c
            public void c(@NonNull com.byazt.pp.c cVar) {
            }

            @Override // com.byazt.oc.c
            public void tt(View view) {
                tt.this.tt(view);
            }

            @Override // com.byazt.oc.c
            public void c(View view) {
                tt.this.c(view);
            }
        });
    }

    private void sp() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null) {
            return;
        }
        if (veVar.isExpressAd()) {
            this.tt.setTTNativeAdListener(new com.byazt.me.a() { // from class: com.byazt.zu.tt.10
                @Override // com.byazt.me.a
                public void c(View view, String str, int i) {
                    if (tt.this.x instanceof com.byazt.am.n) {
                        ((com.byazt.am.n) tt.this.x).c(view, str, i);
                    }
                }

                @Override // com.byazt.me.a
                public void c(float f, float f2) {
                    if (tt.this.x != null) {
                        tt.this.x.c(tt.this.f29249a, f, f2, true);
                    }
                }

                @Override // com.byazt.me.tt
                public void c(View view) {
                    tt.this.c(view);
                }

                @Override // com.byazt.me.tt
                public void c() {
                    tt.this.tt((View) null);
                }
            });
        } else {
            this.tt.setTTNativeAdListener(new com.byazt.me.ve() { // from class: com.byazt.zu.tt.2
                @Override // com.byazt.me.tt
                public void c(View view) {
                    tt.this.c(view);
                }

                @Override // com.byazt.me.tt
                public void c() {
                    tt.this.tt((View) null);
                }
            });
        }
    }

    private void uj() {
        int subAdType = this.tt.getSubAdType();
        if (subAdType != 4) {
            if (subAdType == 5) {
                a();
                return;
            } else if (subAdType == 3) {
                n();
                return;
            }
        }
        sp();
    }

    private void ve() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null || veVar.isExpressAd()) {
            return;
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, RENDER_TIP);
    }

    private void c() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            veVar.setTTVideoListener(new x() { // from class: com.byazt.zu.tt.1
                @Override // com.byazt.me.x
                public void c() {
                    if (tt.this.uj != null) {
                        tt.this.uj.c(tt.this);
                    }
                }

                @Override // com.byazt.me.x
                public void n() {
                    if (tt.this.uj != null) {
                        tt.this.uj.n(tt.this);
                    }
                }

                @Override // com.byazt.me.x
                public void tt() {
                    if (tt.this.uj != null) {
                        tt.this.uj.tt(tt.this);
                    }
                }

                @Override // com.byazt.me.x
                public void uj() {
                    if (tt.this.uj != null) {
                        tt.this.uj.uj(tt.this);
                    }
                }

                @Override // com.byazt.me.x
                public void ve() {
                    if (tt.this.uj != null) {
                        tt.this.uj.ve(tt.this);
                    }
                }

                @Override // com.byazt.me.x
                public void c(com.byazt.pp.c cVar) {
                    String strTt;
                    long jCurrentTimeMillis;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (nu.c(tt.this.tt)) {
                        strTt = nu.tt();
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    } else {
                        strTt = null;
                        jCurrentTimeMillis = -1;
                    }
                    com.byazt.ng.a.c(tt.this.tt, tt.this.ve, (com.byazt.pp.c) null, 2, 0, strTt, jCurrentTimeMillis);
                    if (cVar == null || tt.this.uj == null) {
                        return;
                    }
                    tt.this.uj.c(cVar.c, -1);
                }

                @Override // com.byazt.me.x
                public void c(long j, long j2) {
                    if (tt.this.uj != null) {
                        tt.this.uj.c(j, j2);
                    }
                }
            });
            this.tt.setTTAdAppDownloadListener(new com.byazt.zh.tt() { // from class: com.byazt.zu.tt.3
                @Override // com.byazt.zh.tt
                public void c() {
                    if (tt.this.i != null) {
                        tt.this.i.c();
                    }
                }

                @Override // com.byazt.zh.tt
                public void tt() {
                }

                @Override // com.byazt.zh.tt
                public void tt(long j, long j2, String str, String str2) {
                    if (tt.this.i != null) {
                        tt.this.i.ve(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, long j2, int i, int i2, String str, String str2) {
                    if (tt.this.i != null) {
                        tt.this.i.c(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, long j2, String str, String str2) {
                    if (tt.this.i != null) {
                        tt.this.i.tt(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, String str, String str2) {
                    if (tt.this.i != null) {
                        tt.this.i.c(j, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(String str, String str2) {
                    if (tt.this.i != null) {
                        tt.this.i.c(str, str2);
                    }
                }
            });
            this.tt.setGMVideoRewardListener(new com.byazt.me.i() { // from class: com.byazt.zu.tt.4
                @Override // com.byazt.me.i
                public void c(int i) {
                    if (tt.this.n != null) {
                        tt.this.n.c(i);
                    }
                }
            });
        }
    }

    private void tt() {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar == null || !veVar.isExpressAd()) {
            return;
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, REGISTER_VIEW_TIP);
    }

    @Override // com.byazt.nc.u
    public sp getDislikeDialog(Dialog dialog, Integer[] numArr) {
        com.byazt.yl.ve veVar = this.tt;
        if (veVar != null) {
            return veVar.getDislikeDialog(dialog, numArr);
        }
        return null;
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, com.byazt.lsp.c cVar) {
        registerViewForInteraction(viewGroup, (List<View>) null, list, list2, (List<View>) null, (View) null, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(View view) {
        com.byazt.yl.ve veVar;
        String strTt;
        long jCurrentTimeMillis;
        if (this.ve == null || (veVar = this.tt) == null) {
            return;
        }
        veVar.setHasShowCallback(true);
        com.byazt.lsp.ve veVar2 = this.x;
        if (veVar2 instanceof com.byazt.am.n) {
            ((com.byazt.am.n) veVar2).tt();
        }
        com.byazt.lsp.c cVar = this.sp;
        if (cVar != null) {
            cVar.c(this);
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, com.byazt.eu.uj.c(this.ve.gt(), "show_listen") + "adSlotId：" + this.tt.getAdNetworkSlotId() + "，广告类型：" + com.byazt.yl.c.c(this.tt.getAdNetworkPlatformId()));
        com.byazt.hr.u uVarC = com.byazt.hr.u.c();
        StringBuilder sb = new StringBuilder();
        sb.append(this.ve.gt());
        uVarC.sp(sb.toString());
        com.byazt.hr.u.c().tt(this.ve.gt());
        sl.c().tt(this.ve.gt(), this.tt.getAdNetworkSlotId());
        com.byazt.hr.t.c().tt(this.ve.gt(), this.tt.getAdNetworkSlotId());
        com.byazt.xx.ve.c(this.tt.getAdnName(), this.ve.gt(), this.tt.getAdNetworkSlotId());
        if (this.tt.getCallBack() != null) {
            this.tt.getCallBack().c(this.tt);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (nu.c(this.tt)) {
            strTt = nu.tt();
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        } else {
            strTt = null;
            jCurrentTimeMillis = -1;
        }
        String str = strTt;
        long j = jCurrentTimeMillis;
        boolean zIsShowListenRepeatOnce = this.tt.isShowListenRepeatOnce();
        if (!zIsShowListenRepeatOnce) {
            com.byazt.bg.c.sp(this.ve.gt());
            com.byazt.bg.c.ve(this.ve.gt());
            com.byazt.psp.uj.c(1, this.ve.gt(), this.tt.getAdType(), this.tt.getCpm());
        }
        com.byazt.ng.a.c(this.tt, this.ve, 0, str, j, zIsShowListenRepeatOnce, 1);
        com.byazt.ll.tt ttVar = this.ve;
        com.byazt.oi.ve.c(ttVar != null ? ttVar.gt() : "", this.tt);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.byazt.lsp.c cVar) {
        registerViewForInteraction(viewGroup, (List<View>) null, list, list2, (List<View>) null, view, cVar);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.byazt.lsp.c cVar) {
        registerViewForInteraction(viewGroup, list, list2, list3, (List<View>) null, view, cVar);
    }

    private void c(com.byazt.lsp.c cVar) {
        this.sp = cVar;
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final List<View> list4, final View view, com.byazt.lsp.c cVar) {
        tt();
        if (this.tt != null) {
            c(cVar);
            c(false, new Handler.Callback() { // from class: com.byazt.zu.tt.5
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    if (TextUtils.equals(tt.this.tt.getAdNetWorkName(), MediationConstant.ADN_PANGLE)) {
                        tt.this.tt.registerView(viewGroup, list, list2, list3, list4, view);
                        return false;
                    }
                    tt.this.tt.registerViewForInteraction(null, viewGroup, list2, list3, list4, null, list);
                    return false;
                }
            });
        }
    }

    private void c(boolean z, Handler.Callback callback) {
        com.byazt.ng.a.c(this.ve);
        if (this.tt != null) {
            uj();
            if (callback != null) {
                callback.handleMessage(null);
            }
            if (this.tt.getCallBack() != null) {
                this.tt.getCallBack().c();
            }
            c(this.tt);
            HashMap map = new HashMap();
            map.put("has_view_binder", Boolean.valueOf(z));
            com.byazt.yl.ve veVar = this.tt;
            com.byazt.ng.a.c(veVar, this.ve, veVar.isShowRepeatOnce(), 0, map);
            return;
        }
        com.byazt.ng.a.c((List<com.byazt.yl.ve>) null, this.ve, 0);
    }

    @Override // com.byazt.nc.u
    public void registerViewForInteraction(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, com.byazt.lsp.c cVar, final com.byazt.am.uj ujVar) {
        tt();
        if (this.tt != null) {
            c(cVar);
            c(true, new Handler.Callback() { // from class: com.byazt.zu.tt.6
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    tt.this.tt.registerViewForInteraction(activity, viewGroup, list, list2, list3, com.byazt.me.da.c(ujVar), null);
                    return false;
                }
            });
        }
    }

    private void c(com.byazt.yl.ve veVar) {
        if (com.byazt.bp.tt.tt().aw()) {
            com.byazt.ng.a.c(veVar, this.ve, nu.c(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        com.byazt.lsp.ve veVar = this.x;
        if (veVar instanceof com.byazt.am.n) {
            ((com.byazt.am.n) veVar).c();
        }
        com.byazt.lsp.c cVar = this.sp;
        if (cVar != null) {
            cVar.c(view, this);
        }
        x();
    }
}
