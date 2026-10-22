package com.byazt.nm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import com.byazt.nc.u;
import com.byazt.nc.yp;
import com.byazt.nr.m;
import com.byazt.omf.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.ze1;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 20})
public class c extends com.byazt.nm.tt {
    public com.byazt.ll.tt tt;
    public com.byazt.dv.tt ve;

    /* JADX INFO: renamed from: com.byazt.nm.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 585, 44})
    public class C0474c extends com.byazt.yl.ve {
        public com.byazt.nc.da da;
        public Context sl;
        public boolean t;
        public volatile boolean u = false;
        public com.byazt.lsp.c x = new com.byazt.lsp.c(0 == true ? 1 : 0) { // from class: com.byazt.nm.c.c.3
            @Override // com.byazt.lsp.c
            public void c(View view, u uVar) {
                if (C0474c.this.sp instanceof com.byazt.zq.c) {
                    C0474c.this.c().c(view);
                }
            }

            @Override // com.byazt.lsp.c
            public void tt(View view, u uVar) {
                if (C0474c.this.sp instanceof com.byazt.zq.c) {
                    C0474c.this.c().c(view);
                }
            }

            @Override // com.byazt.lsp.c
            public void c(u uVar) {
                if (C0474c.this.sp instanceof com.byazt.zq.c) {
                    C0474c.this.c().tt(null);
                }
            }
        };

        /* JADX WARN: Multi-variable type inference failed */
        public C0474c(Context context, com.byazt.nc.da daVar) {
            Map<String, Object> mediaExtraInfo;
            this.da = daVar;
            this.sl = context;
            com.byazt.nc.ve complianceInfo = daVar.getComplianceInfo();
            if (complianceInfo != null) {
                setAppName(complianceInfo.getAppName());
                setAuthorName(complianceInfo.getDeveloperName());
                setPrivacyAgreement(complianceInfo.getPrivacyUrl());
                setVersionName(complianceInfo.getAppVersion());
                HashMap map = new HashMap();
                Map<String, String> permissionsMap = complianceInfo.getPermissionsMap();
                if (permissionsMap != null && permissionsMap.size() > 0) {
                    map.putAll(permissionsMap);
                }
                setPermissionsMap(map);
                if (com.byazt.xf.tt.c("5.4.0.3")) {
                    setFunctionDescUrl(complianceInfo.getFunctionDescUrl());
                }
                if (com.byazt.xf.tt.c("6.8.1.6")) {
                    setRegUrl(complianceInfo.getRegUrl());
                }
                setRegNumber(complianceInfo.getRegNumber());
            }
            setTitle(daVar.getTitle());
            setAdDescription(daVar.getDescription());
            setActionText(daVar.getButtonText());
            setIconUrl(daVar.getIcon() != null ? daVar.getIcon().getImageUrl() : null);
            setImageMode(daVar.getImageMode());
            setInteractionType(daVar.getInteractionType());
            setSource(daVar.getSource());
            setRating(daVar.getAppScore());
            setIsAppDownload(daVar.getInteractionType() == 4);
            setExpressAd(false);
            if (daVar.getImageMode() == 16 || daVar.getImageMode() == 3 || daVar.getImageMode() == 2 || daVar.getImageMode() == 131) {
                if (daVar.getImageList() != null && !daVar.getImageList().isEmpty() && daVar.getImageList().get(0) != null) {
                    com.byazt.nc.t tVar = daVar.getImageList().get(0);
                    setImageUrl(tVar.getImageUrl());
                    setImageHeight(tVar.getHeight());
                    setImageWidth(tVar.getWidth());
                }
            } else if (daVar.getImageMode() == 4 && daVar.getImageList() != null && daVar.getImageList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.byazt.nc.t> it = daVar.getImageList().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getImageUrl());
                }
                setImages(arrayList);
            }
            setImageMode(daVar.getImageMode());
            if (!c.this.ve.c() || (mediaExtraInfo = daVar.getMediaExtraInfo()) == null) {
                return;
            }
            double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
            com.byazt.eu.tt.c("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(dC)));
            setCpm(dC <= AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : dC);
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            com.byazt.nc.da daVar = this.da;
            if (daVar != null) {
                return com.byazt.xf.tt.tt(daVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            com.byazt.nc.da daVar = this.da;
            if (daVar != null) {
                return com.byazt.xf.tt.c(daVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Activity activity) {
            if (this.da == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native: getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.da.getDislikeDialog(activity);
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.uj getDislikeInfo() {
            if (this.da == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native : getDislikeInfo");
            return this.da.getDislikeInfo();
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            com.byazt.nc.da daVar = this.da;
            if (daVar == null || (mediaExtraInfo = daVar.getMediaExtraInfo()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mediaExtraInfo.get("coupon"));
            map.put("live_room", mediaExtraInfo.get("live_room"));
            map.put(ze1.n, mediaExtraInfo.get(ze1.n));
            setMediaExtraInfo(map);
            return super.getMediaExtraInfo();
        }

        @Override // com.byazt.yl.ve
        public String getReqId() {
            com.byazt.nc.da daVar = this.da;
            return daVar != null ? com.byazt.xf.tt.ve(daVar.getMediaExtraInfo()) : "";
        }

        @Override // com.byazt.yl.ve
        public int getVideoHeight() {
            com.byazt.nc.da daVar = this.da;
            if (daVar != null) {
                return daVar.getAdViewHeight();
            }
            return 0;
        }

        @Override // com.byazt.yl.ve
        public int getVideoWidth() {
            com.byazt.nc.da daVar = this.da;
            if (daVar != null) {
                return daVar.getAdViewWidth();
            }
            return 0;
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.u;
        }

        @Override // com.byazt.yl.ve
        public boolean hasDislike() {
            return true;
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            this.u = true;
            com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.nm.c.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0474c.this.da != null) {
                        C0474c.this.da.setVideoAdListener(null);
                        C0474c.this.da.setAdInteractionListener(null);
                        C0474c.this.da.destroy();
                    }
                }
            });
        }

        @Override // com.byazt.yl.ve
        public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.me.da daVar, List<View> list4) {
            FrameLayout frameLayout;
            com.byazt.nc.da daVar2;
            View adView;
            View viewFindViewById;
            super.registerViewForInteraction(activity, viewGroup, list, list2, list3, daVar, list4);
            com.byazt.nc.da daVar3 = this.da;
            if (daVar3 != null) {
                daVar3.registerViewForInteraction(viewGroup, (List<View>) null, list, list2, list3, (View) null, this.x);
                this.da.setDislikeCallback(activity, new com.byazt.dhf.c(null) { // from class: com.byazt.nm.c.c.1
                    @Override // com.byazt.dhf.c
                    public void c() {
                    }

                    @Override // com.byazt.dhf.c
                    public void c(int i, String str, boolean z) {
                        if (C0474c.this.t) {
                            return;
                        }
                        C0474c.this.t = true;
                        if (C0474c.this.sp instanceof com.byazt.zq.c) {
                            com.byazt.bg.c.c(c.this.ve.tt());
                            C0474c.this.c().c();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void tt() {
                    }
                });
            }
            com.byazt.nc.da daVar4 = this.da;
            if (daVar4 != null && daVar4.getAdLogo() != null && daVar != null && (viewFindViewById = viewGroup.findViewById(daVar.t)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(this.sl);
                    imageView.setImageBitmap(this.da.getAdLogo());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.byazt.pp.n.ve(this.sl, 38.0f);
                    layoutParams.height = com.byazt.pp.n.ve(this.sl, 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.da.getAdLogo());
                }
            }
            if (daVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(daVar.sp)) == null || (daVar2 = this.da) == null || (adView = daVar2.getAdView()) == null) {
                return;
            }
            removeSelfFromParent(adView);
            frameLayout.removeAllViews();
            frameLayout.addView(adView, -1, -1);
        }

        @Override // com.byazt.yl.ve
        public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(ttVar)));
            com.byazt.nc.da daVar = this.da;
            if (daVar != null) {
                daVar.setAdInteractionListener(ttVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeCallback(Activity activity, final com.byazt.dhf.c cVar) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.da.setDislikeCallback(activity, new com.byazt.dhf.c(null) { // from class: com.byazt.nm.c.c.4
                    @Override // com.byazt.dhf.c
                    public void c() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void tt() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.tt();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void c(int i, String str, boolean z) {
                        if (C0474c.this.t) {
                            return;
                        }
                        C0474c.this.t = true;
                        com.byazt.bg.c.c(c.this.ve.tt());
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c(i, str, z);
                        }
                    }
                });
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.da.setDislikeDialog(dialog, numArr);
            }
        }

        @Override // com.byazt.yl.ve
        public void uploadDislikeEvent(String str) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            com.byazt.nc.da daVar = this.da;
            if (daVar != null) {
                daVar.uploadDislikeEvent(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.zq.c c() {
            return (com.byazt.zq.c) this.sp;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.da == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.da.getDislikeDialog(dialog, numArr);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 585, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public class tt extends com.byazt.yl.ve {
        public boolean da;
        public volatile boolean sl = false;
        public final com.byazt.ft.tt t;
        public yp x;

        public tt(Context context, yp ypVar) {
            Map<String, Object> mediaExtraInfo;
            Function function = null;
            com.byazt.ft.tt ttVar = new com.byazt.ft.tt(function) { // from class: com.byazt.nm.c.tt.3
                @Override // com.byazt.ft.tt
                public void c(View view, int i) {
                    if (tt.this.sp instanceof com.byazt.zq.c) {
                        tt.this.c().c(view);
                    }
                }

                @Override // com.byazt.ft.tt
                public void tt(View view, int i) {
                    if (tt.this.sp instanceof com.byazt.zq.c) {
                        tt.this.c().tt(view);
                    }
                }

                @Override // com.byazt.ft.tt
                public void c(View view, String str, int i) {
                    c.this.notifyLoadFail(new com.byazt.pp.c(i, str));
                }

                @Override // com.byazt.ft.tt
                public void c(View view, float f, float f2) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(tt.this);
                    c.this.notifyLoadSuccess(arrayList);
                }
            };
            this.t = ttVar;
            this.x = ypVar;
            setImageMode(ypVar.getImageMode());
            setInteractionType(this.x.getInteractionType());
            setExpressAd(true);
            this.x.setExpressInteractionListener(ttVar);
            if (context instanceof Activity) {
                this.x.setDislikeCallback((Activity) context, new com.byazt.dhf.c(function) { // from class: com.byazt.nm.c.tt.1
                    @Override // com.byazt.dhf.c
                    public void c() {
                    }

                    @Override // com.byazt.dhf.c
                    public void c(int i, String str, boolean z) {
                        if (tt.this.da) {
                            return;
                        }
                        tt.this.da = true;
                        if (tt.this.sp instanceof com.byazt.zq.c) {
                            com.byazt.bg.c.c(c.this.ve.tt());
                            tt.this.c().c();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void tt() {
                    }
                });
            }
            if (!c.this.ve.c() || (mediaExtraInfo = this.x.getMediaExtraInfo()) == null) {
                return;
            }
            double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
            com.byazt.eu.tt.c("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：".concat(String.valueOf(dC)));
            setCpm(dC <= AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : dC);
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            yp ypVar = this.x;
            if (ypVar != null) {
                return com.byazt.xf.tt.tt(ypVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public View getAdView() {
            yp ypVar = this.x;
            if (ypVar != null) {
                return ypVar.getExpressAdView();
            }
            return null;
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            yp ypVar = this.x;
            if (ypVar != null) {
                return com.byazt.xf.tt.c(ypVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Activity activity) {
            yp ypVar = this.x;
            return ypVar != null ? ypVar.getDislikeDialog(activity) : super.getDislikeDialog(activity);
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.uj getDislikeInfo() {
            yp ypVar = this.x;
            return ypVar != null ? ypVar.getDislikeInfo() : super.getDislikeInfo();
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            yp ypVar = this.x;
            if (ypVar == null || (mediaExtraInfo = ypVar.getMediaExtraInfo()) == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "getMediaExtraInfo ".concat(String.valueOf(mediaExtraInfo)));
            setMediaExtraInfo(mediaExtraInfo);
            return super.getMediaExtraInfo();
        }

        @Override // com.byazt.yl.ve
        public String getReqId() {
            yp ypVar = this.x;
            return ypVar != null ? com.byazt.xf.tt.ve(ypVar.getMediaExtraInfo()) : "";
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.sl;
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            this.sl = true;
            com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.nm.c.tt.2
                @Override // java.lang.Runnable
                public void run() {
                    yp ypVar = tt.this.x;
                    if (ypVar != null) {
                        ypVar.destroy();
                    }
                }
            });
        }

        @Override // com.byazt.yl.ve
        public void render() {
            yp ypVar = this.x;
            if (ypVar != null) {
                ypVar.render();
            }
        }

        @Override // com.byazt.yl.ve
        public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(ttVar)));
            yp ypVar = this.x;
            if (ypVar != null) {
                ypVar.setAdInteractionListener(ttVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeCallback(Activity activity, final com.byazt.dhf.c cVar) {
            if (this.x != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner-native express:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.x.setDislikeCallback(activity, new com.byazt.dhf.c(null) { // from class: com.byazt.nm.c.tt.4
                    @Override // com.byazt.dhf.c
                    public void c() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void tt() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.tt();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void c(int i, String str, boolean z) {
                        if (tt.this.da) {
                            return;
                        }
                        tt.this.da = true;
                        com.byazt.bg.c.c(c.this.ve.tt());
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c(i, str, z);
                        }
                    }
                });
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.x != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner-native express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.x.setDislikeDialog(dialog, numArr);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDownloadListener(com.byazt.ocd.ve veVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(veVar)));
            yp ypVar = this.x;
            if (ypVar != null) {
                ypVar.setDownloadListener(veVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setVideoAdListener(com.byazt.ft.ve veVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner express: setVideoAdListener pluginExpressVideoAdListener = ".concat(String.valueOf(veVar)));
            yp ypVar = this.x;
            if (ypVar != null) {
                ypVar.setVideoAdListener(veVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void uploadDislikeEvent(String str) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
            yp ypVar = this.x;
            if (ypVar != null) {
                ypVar.uploadDislikeEvent(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.zq.c c() {
            return (com.byazt.zq.c) this.sp;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 585, 132})
    public class ve extends com.byazt.yl.ve {
        public SoftReference<FrameLayout> i;
        public boolean t;
        public boolean u;
        public yp x;
        public final Object da = new Object();
        public volatile boolean yp = false;
        public final com.byazt.ft.tt z = new com.byazt.ft.tt(null) { // from class: com.byazt.nm.c.ve.4
            @Override // com.byazt.ft.tt
            public void c(View view, int i) {
                if (ve.this.sp instanceof com.byazt.zq.c) {
                    ve.this.c().c(view);
                }
            }

            @Override // com.byazt.ft.tt
            public void tt(View view, int i) {
                if (ve.this.sp instanceof com.byazt.zq.c) {
                    ve.this.c().tt(view);
                }
            }

            @Override // com.byazt.ft.tt
            public void c(View view, String str, int i) {
                ve.this.u = false;
                com.byazt.eu.tt.uj("TTMediationSDK_banner", com.byazt.eu.uj.tt(c.this.ve.tt(), c.this.ve.t()) + "TTBannerView onRenderFail -> code=" + i + ",msg=" + str);
            }

            @Override // com.byazt.ft.tt
            public void c(View view, float f, float f2) {
                com.byazt.eu.tt.uj("TTMediationSDK_banner", com.byazt.eu.uj.tt(c.this.ve.tt(), c.this.ve.t()) + "TTBannerView onRenderSuccess 渲染成功！！mBannerViewRef = " + ve.this.i);
                SoftReference<FrameLayout> softReference = ve.this.i;
                if (softReference != null) {
                    FrameLayout frameLayout = softReference.get();
                    if (frameLayout != null) {
                        com.byazt.pp.n.c(view);
                        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
                    }
                    ve.this.u = true;
                }
            }
        };

        public ve() {
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            yp ypVar = this.x;
            if (ypVar != null) {
                return com.byazt.xf.tt.tt(ypVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public synchronized View getAdView() {
            SoftReference<FrameLayout> softReference = this.i;
            if (softReference == null) {
                return null;
            }
            FrameLayout frameLayout = softReference.get();
            synchronized (this.da) {
                if (frameLayout == null) {
                    try {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        long j = 2000 + jUptimeMillis;
                        while (!this.u && jUptimeMillis < j) {
                            this.da.wait(j - jUptimeMillis);
                            jUptimeMillis = SystemClock.uptimeMillis();
                        }
                    } catch (InterruptedException e) {
                        m.c(e);
                    }
                }
            }
            return frameLayout;
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            yp ypVar = this.x;
            if (ypVar != null) {
                return com.byazt.xf.tt.c(ypVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Activity activity) {
            if (this.x == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.x.getDislikeDialog(activity);
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.uj getDislikeInfo() {
            if (this.x == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner : getDislikeInfo");
            return this.x.getDislikeInfo();
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            yp ypVar = this.x;
            if (ypVar == null || (mediaExtraInfo = ypVar.getMediaExtraInfo()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mediaExtraInfo.get("coupon"));
            map.put("live_room", mediaExtraInfo.get("live_room"));
            map.put(ze1.n, mediaExtraInfo.get(ze1.n));
            setMediaExtraInfo(map);
            return super.getMediaExtraInfo();
        }

        @Override // com.byazt.yl.ve
        public String getReqId() {
            yp ypVar = this.x;
            return ypVar != null ? com.byazt.xf.tt.ve(ypVar.getMediaExtraInfo()) : "";
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.yp;
        }

        public void loadAd(final Context context) {
            h pluginCSJLoader = c.this.getPluginCSJLoader(context);
            if (pluginCSJLoader == null) {
                return;
            }
            com.byazt.dj.tt.c cVarC = com.byazt.xf.tt.c(c.this.tt, c.this.ve.t(), c.this.ve.m(), c.this.ve.nu(), c.this.ve.zm(), false);
            float fU = c.this.tt.u();
            cVarC.c(fU).tt(c.this.tt.yp());
            pluginCSJLoader.loadBannerExpressAd(cVarC.c(), new com.byazt.nh.a(null) { // from class: com.byazt.nm.c.ve.1
                @Override // com.byazt.nh.a
                public void c(int i, String str) {
                    c.this.notifyLoadFail(new com.byazt.pp.c(i, str));
                }

                @Override // com.byazt.nh.a
                public void c(List<yp> list) {
                    Map<String, Object> mediaExtraInfo;
                    if (list == null || list.size() == 0 || context == null) {
                        c.this.notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                        return;
                    }
                    ve.this.x = list.get(0);
                    Context context2 = context;
                    if (context2 instanceof Activity) {
                        ve.this.x.setDislikeCallback((Activity) context2, new com.byazt.dhf.c(null) { // from class: com.byazt.nm.c.ve.1.1
                            @Override // com.byazt.dhf.c
                            public void c() {
                            }

                            @Override // com.byazt.dhf.c
                            public void c(int i, String str, boolean z) {
                                if (ve.this.t) {
                                    return;
                                }
                                ve.this.t = true;
                                if (ve.this.sp instanceof com.byazt.zq.c) {
                                    com.byazt.bg.c.c(c.this.ve.tt());
                                    ve.this.c().c();
                                }
                            }

                            @Override // com.byazt.dhf.c
                            public void tt() {
                            }
                        });
                    }
                    ve.this.setExpressAd(true);
                    ve veVar = ve.this;
                    veVar.setInteractionType(veVar.x.getInteractionType());
                    ve veVar2 = ve.this;
                    veVar2.setImageMode(veVar2.x.getImageMode());
                    if (c.this.ve.c() && (mediaExtraInfo = ve.this.x.getMediaExtraInfo()) != null) {
                        double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
                        com.byazt.eu.tt.c("TTMediationSDK_ECMP", com.byazt.eu.uj.tt(c.this.ve.tt(), c.this.ve.t()) + "pangle banner 返回的 cpm价格：" + dC);
                        ve veVar3 = ve.this;
                        if (dC <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                            dC = 0.0d;
                        }
                        veVar3.setCpm(dC);
                    }
                    ve veVar4 = ve.this;
                    veVar4.x.setExpressInteractionListener(veVar4.z);
                    ve.this.i = new SoftReference<>(new FrameLayout(context));
                    ve.this.x.render();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(ve.this);
                    c.this.notifyLoadSuccess(arrayList);
                }
            });
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            this.yp = true;
            com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.nm.c.ve.2
                @Override // java.lang.Runnable
                public void run() {
                    yp ypVar = ve.this.x;
                    if (ypVar != null) {
                        ypVar.setExpressInteractionListener((com.byazt.ft.c) null);
                        ve.this.x.destroy();
                    }
                }
            });
        }

        @Override // com.byazt.yl.ve
        public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner : setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(ttVar)));
            yp ypVar = this.x;
            if (ypVar != null) {
                ypVar.setAdInteractionListener(ttVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeCallback(Activity activity, final com.byazt.dhf.c cVar) {
            if (this.x != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner : activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.x.setDislikeCallback(activity, new com.byazt.dhf.c(null) { // from class: com.byazt.nm.c.ve.3
                    @Override // com.byazt.dhf.c
                    public void c() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void tt() {
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.tt();
                        }
                    }

                    @Override // com.byazt.dhf.c
                    public void c(int i, String str, boolean z) {
                        if (ve.this.t) {
                            return;
                        }
                        ve.this.t = true;
                        com.byazt.bg.c.c(c.this.ve.tt());
                        com.byazt.dhf.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.c(i, str, z);
                        }
                    }
                });
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.x != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner :  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.x.setDislikeDialog(dialog, numArr);
            }
        }

        @Override // com.byazt.yl.ve
        public void setSlideIntervalTime(int i) {
            if (this.x != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner : setSlideIntervalTime  intervalTime = ".concat(String.valueOf(i)));
                this.x.setSlideIntervalTime(i);
            }
        }

        @Override // com.byazt.yl.ve
        public void uploadDislikeEvent(String str) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner : uploadDislikeEvent event = ".concat(String.valueOf(str)));
            yp ypVar = this.x;
            if (ypVar != null) {
                ypVar.uploadDislikeEvent(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.zq.c c() {
            return (com.byazt.zq.c) this.sp;
        }
    }

    public c(com.byazt.db.tt ttVar) {
        super(ttVar);
    }

    public String getAdNetWorkName() {
        return MediationConstant.ADN_PANGLE;
    }

    @Override // com.byazt.sp.tt
    public void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        this.tt = ttVar2;
        this.ve = ttVar;
        if (ttVar2 == null) {
            notifyLoadFail(new com.byazt.pp.c("load ad fail adSlot is null"));
            return;
        }
        if (map != null) {
            Object obj = map.get("tt_ad_sub_type");
            if (obj == null || ((Integer) obj).intValue() != 4) {
                new ve().loadAd(context.getApplicationContext());
                return;
            }
            Object obj2 = map.get("tt_ad_origin_type");
            if (obj2 != null) {
                int iIntValue = ((Integer) obj2).intValue();
                if (iIntValue == 1) {
                    c(context.getApplicationContext());
                } else if (iIntValue == 2) {
                    tt(context.getApplicationContext());
                } else {
                    notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "originType is mismatch"));
                }
            }
        }
    }

    private void c(final Context context) {
        h pluginCSJLoader = getPluginCSJLoader(context);
        if (pluginCSJLoader == null) {
            return;
        }
        com.byazt.dj.tt.c cVarTt = com.byazt.xf.tt.c(this.tt, this.ve.t(), this.ve.m(), this.ve.nu(), this.ve.zm(), false).c(this.tt.qy()).tt(this.tt.gu());
        float fU = this.tt.u();
        float fYp = this.tt.yp();
        boolean zC = com.byazt.xf.tt.c(this.tt);
        com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle banner native express autoHeight:" + zC + " width:" + fU + "  height:" + fYp);
        if (fYp <= 0.0f || zC) {
            cVarTt.c(fU).tt(0.0f);
        } else {
            cVarTt.c(fU).tt(fYp);
        }
        pluginCSJLoader.loadNativeExpressAd(cVarTt.c(), new com.byazt.nh.a(null) { // from class: com.byazt.nm.c.1
            @Override // com.byazt.nh.a
            public void c(int i, String str) {
                c.this.notifyLoadFail(new com.byazt.pp.c(i, str));
            }

            @Override // com.byazt.nh.a
            public void c(List<yp> list) {
                if (list == null || list.size() == 0) {
                    c.this.notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                for (yp ypVar : list) {
                    if (ypVar != null) {
                        c.this.new tt(context, ypVar).render();
                        return;
                    }
                }
            }
        });
    }

    private void tt(final Context context) {
        h pluginCSJLoader = getPluginCSJLoader(context);
        if (pluginCSJLoader == null) {
            return;
        }
        com.byazt.dj.tt.c cVarC = com.byazt.xf.tt.c(this.tt, this.ve.t(), this.ve.m(), this.ve.nu(), this.ve.zm(), false);
        cVarC.c(this.tt.qy()).tt(this.tt.gu());
        pluginCSJLoader.loadFeedAd(cVarC.c(), new com.byazt.nh.ve(null) { // from class: com.byazt.nm.c.2
            @Override // com.byazt.nh.ve
            public void c(int i, String str) {
                c.this.notifyLoadFail(new com.byazt.pp.c(i, str));
            }

            @Override // com.byazt.nh.ve
            public void c(List<com.byazt.nc.da> list) {
                if (list == null || list.isEmpty()) {
                    c.this.notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load list is null or empty"));
                    return;
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(c.this.new C0474c(context, list.get(0)));
                c.this.notifyLoadSuccess(arrayList);
            }
        });
    }
}
