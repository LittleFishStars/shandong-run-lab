package com.byazt.nm;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.byazt.nc.u;
import com.byazt.nr.m;
import com.byazt.omf.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 71})
public class x {

    @com.byazt.zqa.c(c = {0, 1, 585, 62})
    public static class c extends com.byazt.yl.ve {
        public com.byazt.nc.da sl;
        public int t;
        public com.byazt.lsp.c x = new com.byazt.lsp.c(0 == true ? 1 : 0) { // from class: com.byazt.nm.x.c.2
            @Override // com.byazt.lsp.c
            public void c(View view, u uVar) {
                if (c.this.c != null) {
                    c.this.c.c(view);
                }
            }

            @Override // com.byazt.lsp.c
            public void tt(View view, u uVar) {
                if (c.this.c != null) {
                    c.this.c.c(view);
                }
            }

            @Override // com.byazt.lsp.c
            public void c(u uVar) {
                if (c.this.c != null) {
                    c.this.c.c();
                }
            }
        };
        public com.byazt.bf.c i = new com.byazt.bf.c(0 == true ? 1 : 0) { // from class: com.byazt.nm.x.c.3
            @Override // com.byazt.bf.c
            public void c(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.c();
                }
            }

            @Override // com.byazt.bf.c
            public void n(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.n();
                }
            }

            @Override // com.byazt.bf.c
            public void tt(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.tt();
                }
            }

            @Override // com.byazt.bf.c
            public void uj(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.uj();
                }
            }

            @Override // com.byazt.bf.c
            public void ve(com.byazt.nc.da daVar) {
                if (c.this.tt != null) {
                    c.this.tt.ve();
                }
            }

            @Override // com.byazt.bf.c
            public void c(int i, int i2) {
                if (c.this.tt != null) {
                    c.this.tt.c(new com.byazt.pp.c(i, "Android MediaPlay Error Code :".concat(String.valueOf(i2))));
                }
            }

            @Override // com.byazt.bf.c
            public void c(long j, long j2) {
                if (c.this.tt != null) {
                    c.this.tt.c(j, j2);
                }
            }
        };
        public com.byazt.ocd.ve da = new com.byazt.ocd.ve(0 == true ? 1 : 0) { // from class: com.byazt.nm.x.c.4
            @Override // com.byazt.ocd.ve
            public void c() {
                c.this.t = 0;
                if (c.this.ve != null) {
                    c.this.ve.c();
                }
            }

            @Override // com.byazt.ocd.ve
            public void tt(long j, long j2, String str, String str2) {
                c.this.t = 3;
                if (c.this.ve != null) {
                    c.this.ve.c(j, j2, str, str2);
                }
            }

            @Override // com.byazt.ocd.ve
            public void ve(long j, long j2, String str, String str2) {
                c.this.t = 4;
                if (c.this.ve != null) {
                    c.this.ve.tt(j, j2, str, str2);
                }
            }

            @Override // com.byazt.ocd.ve
            public void c(long j, long j2, String str, String str2) {
                c.this.t = 2;
                if (c.this.ve != null) {
                    c.this.ve.c(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                }
            }

            @Override // com.byazt.ocd.ve
            public void c(long j, String str, String str2) {
                c.this.t = 5;
                if (c.this.ve != null) {
                    c.this.ve.c(j, str, str2);
                }
            }

            @Override // com.byazt.ocd.ve
            public void c(String str, String str2) {
                c.this.t = 6;
                if (c.this.ve != null) {
                    c.this.ve.c(str, str2);
                }
            }
        };

        /* JADX WARN: Multi-variable type inference failed */
        public c(com.byazt.nc.da daVar, boolean z, boolean z2) {
            Map<String, Object> mediaExtraInfo;
            List<com.byazt.nc.t> imageList;
            this.sl = daVar;
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
                if (com.byazt.xf.tt.c("5.1.0.0")) {
                    setPermissionsUrl(complianceInfo.getPermissionUrl());
                }
                if (com.byazt.xf.tt.c("5.4.0.3")) {
                    setFunctionDescUrl(complianceInfo.getFunctionDescUrl());
                }
                if (com.byazt.xf.tt.c("6.8.1.6")) {
                    setRegUrl(complianceInfo.getRegUrl());
                }
                setRegNumber(complianceInfo.getRegNumber());
            }
            setSupportRender(z2 ? 1 : 0);
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
                List<com.byazt.nc.t> imageList2 = daVar.getImageList();
                if (imageList2 != null && !imageList2.isEmpty() && imageList2.get(0) != null) {
                    com.byazt.nc.t tVar = imageList2.get(0);
                    setImageUrl(tVar.getImageUrl());
                    setImageHeight(tVar.getHeight());
                    setImageWidth(tVar.getWidth());
                }
            } else if (daVar.getImageMode() == 4) {
                List<com.byazt.nc.t> imageList3 = daVar.getImageList();
                if (imageList3 != null && imageList3.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.byazt.nc.t> it = imageList3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getImageUrl());
                    }
                    setImages(arrayList);
                }
            } else {
                com.byazt.nc.t videoCoverImage = daVar.getVideoCoverImage();
                if ((videoCoverImage == null || TextUtils.isEmpty(videoCoverImage.getImageUrl())) && (imageList = daVar.getImageList()) != null && !imageList.isEmpty() && imageList.get(0) != null) {
                    videoCoverImage = imageList.get(0);
                }
                if (videoCoverImage != null) {
                    setImageUrl(videoCoverImage.getImageUrl());
                    setImageHeight(videoCoverImage.getHeight());
                    setImageWidth(videoCoverImage.getWidth());
                }
            }
            if (z && (mediaExtraInfo = daVar.getMediaExtraInfo()) != null) {
                double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
                com.byazt.eu.tt.c("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：".concat(String.valueOf(dC)));
                setCpm(dC <= AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : dC);
            }
            this.sl.setVideoAdListener(this.i);
            this.sl.setDownloadListener(this.da);
            new HashMap();
            putExtraMsg(MediationConstant.EXTRA_ADID, Long.valueOf(getAdId()));
            putExtraMsg(MediationConstant.EXTRA_CID, Long.valueOf(getCreativeId()));
            putExtraMsg("duration", Double.valueOf(this.sl.getVideoDuration()));
            Map<String, Object> mediaExtraInfo2 = this.sl.getMediaExtraInfo();
            if (mediaExtraInfo2 != null) {
                putExtraMsg(mediaExtraInfo2);
                putExtraMsg("log_extra", mediaExtraInfo2.toString());
            }
        }

        @Override // com.byazt.yl.ve
        public void cancelDownload() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar == null || daVar.getDownloadStatusController() == null) {
                return;
            }
            this.sl.getDownloadStatusController().cancelDownload();
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                return com.byazt.xf.tt.tt(daVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public Bitmap getAdLogo() {
            com.byazt.nc.da daVar = this.sl;
            return daVar != null ? daVar.getAdLogo() : super.getAdLogo();
        }

        @Override // com.byazt.yl.ve
        public int getAppCommentNum() {
            com.byazt.nc.da daVar = this.sl;
            return daVar != null ? daVar.getAppCommentNum() : super.getAppCommentNum();
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                return com.byazt.xf.tt.c(daVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Activity activity) {
            if (this.sl == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(activity)));
            return this.sl.getDislikeDialog(activity);
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.uj getDislikeInfo() {
            if (this.sl == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle native : getDislikeInfo");
            return this.sl.getDislikeInfo();
        }

        @Override // com.byazt.yl.ve
        public int getDownloadStatus() {
            return this.t;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.me.n getGMNativeCustomVideoReporter() {
            if (isUseCustomVideo()) {
                return new com.byazt.me.n() { // from class: com.byazt.nm.x.c.5
                    @Override // com.byazt.me.n
                    public void c(long j) {
                        if (c.this.sl == null || c.this.sl.getCustomVideo() == null) {
                            return;
                        }
                        c.this.sl.getCustomVideo().reportVideoPause(j);
                    }

                    @Override // com.byazt.me.n
                    public void tt(long j) {
                        if (c.this.sl == null || c.this.sl.getCustomVideo() == null) {
                            return;
                        }
                        c.this.sl.getCustomVideo().reportVideoContinue(j);
                    }

                    @Override // com.byazt.me.n
                    public void ve(long j) {
                        if (c.this.sl == null || c.this.sl.getCustomVideo() == null) {
                            return;
                        }
                        c.this.sl.getCustomVideo().reportVideoBreak(j);
                    }

                    @Override // com.byazt.me.n
                    public void c() {
                        if (c.this.sl == null || c.this.sl.getCustomVideo() == null) {
                            return;
                        }
                        c.this.sl.getCustomVideo().reportVideoFinish();
                    }

                    @Override // com.byazt.me.n
                    public void tt() {
                        if (c.this.sl == null || c.this.sl.getCustomVideo() == null) {
                            return;
                        }
                        c.this.sl.getCustomVideo().reportVideoAutoStart();
                    }

                    @Override // com.byazt.me.n
                    public void c(int i, int i2) {
                        if (c.this.sl == null || c.this.sl.getCustomVideo() == null) {
                            return;
                        }
                        c.this.sl.getCustomVideo().reportVideoStartError(i, i2);
                    }

                    @Override // com.byazt.me.n
                    public void c(long j, int i, int i2) {
                        if (c.this.sl == null || c.this.sl.getCustomVideo() == null) {
                            return;
                        }
                        c.this.sl.getCustomVideo().reportVideoError(j, i, i2);
                    }
                };
            }
            return null;
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            com.byazt.nc.da daVar = this.sl;
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
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                return com.byazt.xf.tt.ve(daVar.getMediaExtraInfo());
            }
            return null;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.t getVideoCoverImage() {
            com.byazt.nc.da daVar = this.sl;
            return daVar != null ? daVar.getVideoCoverImage() : super.getVideoCoverImage();
        }

        @Override // com.byazt.yl.ve
        public double getVideoDuration() {
            com.byazt.nc.da daVar = this.sl;
            return daVar != null ? daVar.getVideoDuration() : super.getVideoDuration();
        }

        @Override // com.byazt.yl.ve
        public int getVideoHeight() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                return daVar.getAdViewHeight();
            }
            return 0;
        }

        @Override // com.byazt.yl.ve
        public String getVideoUrl() {
            com.byazt.nc.da daVar;
            if (!isUseCustomVideo() || (daVar = this.sl) == null || daVar.getCustomVideo() == null) {
                return null;
            }
            return this.sl.getCustomVideo().getVideoUrl();
        }

        @Override // com.byazt.yl.ve
        public View getVideoView() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                return daVar.getAdView();
            }
            return null;
        }

        @Override // com.byazt.yl.ve
        public int getVideoWidth() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                return daVar.getAdViewWidth();
            }
            return 0;
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.sl == null;
        }

        @Override // com.byazt.yl.ve
        public boolean hasDislike() {
            return true;
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                daVar.setVideoAdListener(null);
                this.sl.destroy();
                this.sl = null;
            }
        }

        @Override // com.byazt.yl.ve
        public void pauseAppDownload() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar == null || daVar.getDownloadStatusController() == null || this.t != 2) {
                return;
            }
            this.sl.getDownloadStatusController().changeDownloadStatus();
        }

        @Override // com.byazt.yl.ve
        public void registerView(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            super.registerView(viewGroup, list, list2, list3, list4, view);
            c(viewGroup, list, list2, list3, list4, view);
        }

        @Override // com.byazt.yl.ve
        public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.me.da daVar, List<View> list4) {
            FrameLayout frameLayout;
            com.byazt.nc.da daVar2;
            View adView;
            com.byazt.nc.da daVar3;
            View viewFindViewById;
            super.registerViewForInteraction(activity, viewGroup, list, list2, list3, daVar, list4);
            c(viewGroup, null, list, list2, list3, null);
            com.byazt.nc.da daVar4 = this.sl;
            if (daVar4 != null && daVar4.getAdLogo() != null && daVar != null && (viewFindViewById = viewGroup.findViewById(daVar.t)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(viewGroup.getContext());
                    imageView.setImageBitmap(this.sl.getAdLogo());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    layoutParams.width = com.byazt.eu.a.tt(viewGroup.getContext(), 38.0f);
                    layoutParams.height = com.byazt.eu.a.tt(viewGroup.getContext(), 38.0f);
                    viewFindViewById.setLayoutParams(layoutParams);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ((ImageView) viewFindViewById).setImageBitmap(this.sl.getAdLogo());
                }
            }
            if ((isUseCustomVideo() && (daVar3 = this.sl) != null && daVar3.getCustomVideo() != null && !TextUtils.isEmpty(this.sl.getCustomVideo().getVideoUrl())) || daVar == null || (frameLayout = (FrameLayout) viewGroup.findViewById(daVar.sp)) == null || (daVar2 = this.sl) == null || (adView = daVar2.getAdView()) == null) {
                return;
            }
            removeSelfFromParent(adView);
            frameLayout.removeAllViews();
            frameLayout.addView(adView, -1, -1);
        }

        @Override // com.byazt.yl.ve
        public void resumeAppDownload() {
            com.byazt.nc.da daVar = this.sl;
            if (daVar == null || daVar.getDownloadStatusController() == null || this.t != 3) {
                return;
            }
            this.sl.getDownloadStatusController().changeDownloadStatus();
        }

        @Override // com.byazt.yl.ve
        public void setActivityForDownloadApp(Activity activity) {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                daVar.setActivityForDownloadApp(activity);
            }
        }

        @Override // com.byazt.yl.ve
        public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
            this.sl.setAdInteractionListener(ttVar);
        }

        @Override // com.byazt.yl.ve
        public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
            if (this.sl != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle native:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.sl.setDislikeCallback(activity, cVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.sl != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle native:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.sl.setDislikeDialog(dialog, numArr);
            }
        }

        @Override // com.byazt.yl.ve
        public void uploadDislikeEvent(String str) {
            if (this.sl != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle native : uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.sl.uploadDislikeEvent(str);
            }
        }

        private void c(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
            com.byazt.nc.da daVar = this.sl;
            if (daVar != null) {
                daVar.setDownloadListener(this.da);
                try {
                    this.sl.setVideoRewardListener(new com.byazt.bf.tt(null) { // from class: com.byazt.nm.x.c.1
                        @Override // com.byazt.bf.tt
                        public void c(int i) {
                            if (c.this.n != null) {
                                c.this.n.c(i);
                            }
                        }
                    });
                } catch (Throwable th) {
                    m.c(th);
                }
                this.sl.registerViewForInteraction(viewGroup, list, list2, list3, list4, view, this.x);
            }
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.sl == null) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle native : getDislikeDialog = ".concat(String.valueOf(dialog)));
            return this.sl.getDislikeDialog(dialog, numArr);
        }
    }

    public void c(final boolean z, h hVar, final com.byazt.dj.tt ttVar, final com.byazt.sp.tt ttVar2) {
        if (hVar == null || ttVar2 == null || ttVar == null) {
            return;
        }
        hVar.loadFeedAd(ttVar, new com.byazt.nh.ve(null) { // from class: com.byazt.nm.x.1
            @Override // com.byazt.nh.ve
            public void c(int i, String str) {
                ttVar2.notifyLoadFail(new com.byazt.pp.c(i, str));
            }

            @Override // com.byazt.nh.ve
            public void c(List<com.byazt.nc.da> list) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "PangleNativeAd_onFeedAdLoad_SupportRenderControl:" + ttVar.sl());
                if (list == null || list.isEmpty()) {
                    ttVar2.notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                if (ttVar.sl()) {
                    x.this.c(list, ttVar2, z);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<com.byazt.nc.da> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new c(it.next(), z, false));
                }
                ttVar2.notifyLoadSuccess(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<com.byazt.nc.da> list, final com.byazt.sp.tt ttVar, final boolean z) {
        int size = list.size();
        com.byazt.eu.tt.tt(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_adNum:".concat(String.valueOf(size)));
        final AtomicInteger atomicInteger = new AtomicInteger();
        final ArrayList arrayList = new ArrayList();
        for (final com.byazt.nc.da daVar : list) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final int i = size;
            daVar.setExpressRenderListener(new com.byazt.lsp.ve(null) { // from class: com.byazt.nm.x.2
                @Override // com.byazt.lsp.ve
                public void c(View view, float f, float f2, boolean z2) {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_onRenderSuccess:" + z2 + " duration:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    arrayList.add(new c(daVar, z, z2));
                    if (atomicInteger.incrementAndGet() != i || ttVar == null) {
                        return;
                    }
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "PangleNativeAd_nativeSupportRenderControl_notifyAdSuccess!!!!!");
                    ttVar.notifyLoadSuccess(arrayList);
                }
            });
            daVar.render();
            size = size;
        }
    }
}
