package com.kwad.components.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.b.c;
import com.kwad.components.ad.b.g;
import com.kwad.components.ad.b.h;
import com.kwad.components.ad.b.i;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.f;
import com.kwad.sdk.n;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements KsLoadManager {
    private void a(final com.kwad.sdk.g.a<Boolean> aVar) {
        if (o.Gs().GV()) {
            aVar.accept(Boolean.TRUE);
        } else {
            f.a(new n() { // from class: com.kwad.components.core.b.14
                @Override // com.kwad.sdk.n, com.kwad.sdk.m
                public final void M() {
                    aVar.accept(Boolean.TRUE);
                    Gr();
                }

                @Override // com.kwad.sdk.n, com.kwad.sdk.m
                public final void N() {
                    aVar.accept(Boolean.FALSE);
                    Gr();
                }
            });
        }
    }

    private static boolean oD() {
        return o.Gs().Gu();
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        return bVar != null ? bVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        return bVar != null ? bVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadBannerAd(final KsScene ksScene, @NonNull final KsLoadManager.BannerAdListener bannerAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                bannerAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            com.kwad.components.ad.b.a aVar = (com.kwad.components.ad.b.a) d.f(com.kwad.components.ad.b.a.class);
            final KsLoadManager.BannerAdListener bannerAdListener2 = new KsLoadManager.BannerAdListener() { // from class: com.kwad.components.core.b.7
                @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
                public final void onBannerAdLoad(@Nullable KsBannerAd ksBannerAd) {
                    bannerAdListener.onBannerAdLoad(ksBannerAd);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
                public final void onError(int i, String str) {
                    bannerAdListener.onError(i, str);
                }
            };
            if (aVar != null) {
                aVar.loadBannerAd(ksScene, bannerAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.8
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        com.kwad.components.ad.b.a aVar2 = (com.kwad.components.ad.b.a) d.f(com.kwad.components.ad.b.a.class);
                        if (bool.booleanValue() && aVar2 != null) {
                            aVar2.loadBannerAd(ksScene, bannerAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            bannerAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            bannerAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(final KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                feedAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
            final KsLoadManager.FeedAdListener feedAdListener2 = new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.19
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i, String str) {
                    feedAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            };
            if (dVar != null) {
                dVar.loadConfigFeedAd(ksScene, feedAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.20
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        com.kwad.components.ad.b.d dVar2 = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
                        if (bool.booleanValue() && dVar2 != null) {
                            dVar2.loadConfigFeedAd(ksScene, feedAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            feedAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            feedAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(final KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                drawAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            c cVar = (c) d.f(c.class);
            final KsLoadManager.DrawAdListener drawAdListener2 = new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.21
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i, String str) {
                    drawAdListener.onError(i, str);
                }
            };
            if (cVar != null) {
                cVar.loadDrawAd(ksScene, drawAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        c cVar2 = (c) d.f(c.class);
                        if (bool.booleanValue() && cVar2 != null) {
                            cVar2.loadDrawAd(ksScene, drawAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            drawAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            drawAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(final KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                feedAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
            final KsLoadManager.FeedAdListener feedAdListener2 = new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.17
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i, String str) {
                    feedAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            };
            if (dVar != null) {
                dVar.loadFeedAd(ksScene, feedAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.18
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        com.kwad.components.ad.b.d dVar2 = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
                        if (bool.booleanValue() && dVar2 != null) {
                            dVar2.loadFeedAd(ksScene, feedAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            feedAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            feedAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                fullScreenVideoAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            com.kwad.components.ad.b.e eVar2 = (com.kwad.components.ad.b.e) d.f(com.kwad.components.ad.b.e.class);
            final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener2 = new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i, String str) {
                    fullScreenVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoResult(list);
                }
            };
            if (eVar2 != null) {
                eVar2.loadFullScreenVideoAd(ksScene, fullScreenVideoAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.12
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        com.kwad.components.ad.b.e eVar3 = (com.kwad.components.ad.b.e) d.f(com.kwad.components.ad.b.e.class);
                        if (bool.booleanValue() && eVar3 != null) {
                            eVar3.loadFullScreenVideoAd(ksScene, fullScreenVideoAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar4 = e.aTb;
                            fullScreenVideoAdListener.onError(eVar4.errorCode, eVar4.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar3 = e.aTj;
            fullScreenVideoAdListener.onError(eVar3.errorCode, eVar3.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                interstitialAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            com.kwad.components.ad.b.f fVar = (com.kwad.components.ad.b.f) d.f(com.kwad.components.ad.b.f.class);
            final KsLoadManager.InterstitialAdListener interstitialAdListener2 = new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.11
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i, String str) {
                    interstitialAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i) {
                    interstitialAdListener.onRequestResult(i);
                }
            };
            if (fVar != null) {
                fVar.loadInterstitialAd(ksScene, interstitialAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.13
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        com.kwad.components.ad.b.f fVar2 = (com.kwad.components.ad.b.f) d.f(com.kwad.components.ad.b.f.class);
                        if (bool.booleanValue() && fVar2 != null) {
                            fVar2.loadInterstitialAd(ksScene, interstitialAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            interstitialAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            interstitialAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(final KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                nativeAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            g gVar = (g) d.f(g.class);
            final KsLoadManager.NativeAdListener nativeAdListener2 = new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.3
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i, String str) {
                    nativeAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            };
            if (gVar != null) {
                gVar.loadNativeAd(ksScene, nativeAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.4
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        g gVar2 = (g) d.f(g.class);
                        if (bool.booleanValue() && gVar2 != null) {
                            gVar2.loadNativeAd(ksScene, nativeAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            nativeAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            nativeAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                rewardVideoAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            h hVar = (h) d.f(h.class);
            final KsLoadManager.RewardVideoAdListener rewardVideoAdListener2 = new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.15
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i, String str) {
                    rewardVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoResult(list);
                }
            };
            if (hVar != null) {
                hVar.loadRewardVideoAd(ksScene, rewardVideoAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.16
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        h hVar2 = (h) d.f(h.class);
                        if (bool.booleanValue() && hVar2 != null) {
                            hVar2.loadRewardVideoAd(ksScene, rewardVideoAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            rewardVideoAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            rewardVideoAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            i iVar = (i) d.f(i.class);
            final KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.9
                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onError(int i, String str) {
                    splashScreenAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onRequestResult(int i) {
                    splashScreenAdListener.onRequestResult(i);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                }
            };
            if (iVar != null) {
                iVar.loadSplashScreenAd(ksScene, splashScreenAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.10
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        i iVar2 = (i) d.f(i.class);
                        if (bool.booleanValue() && iVar2 != null) {
                            iVar2.loadSplashScreenAd(ksScene, splashScreenAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            splashScreenAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            splashScreenAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        if (bVar != null) {
            return bVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(final String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        try {
            if (!oD()) {
                e eVar = e.aTn;
                nativeAdListener.onError(eVar.errorCode, eVar.msg);
                return;
            }
            g gVar = (g) d.f(g.class);
            final KsLoadManager.NativeAdListener nativeAdListener2 = new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.5
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i, String str2) {
                    nativeAdListener.onError(i, str2);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            };
            if (gVar != null) {
                gVar.loadNativeAd(str, nativeAdListener2);
            } else {
                a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.core.b.6
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(Boolean bool) {
                        g gVar2 = (g) d.f(g.class);
                        if (bool.booleanValue() && gVar2 != null) {
                            gVar2.loadNativeAd(str, nativeAdListener2);
                        } else if (com.kwad.components.ad.f.a.pe.booleanValue()) {
                            e eVar2 = e.aTb;
                            nativeAdListener.onError(eVar2.errorCode, eVar2.msg);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            e eVar2 = e.aTj;
            nativeAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }
}
