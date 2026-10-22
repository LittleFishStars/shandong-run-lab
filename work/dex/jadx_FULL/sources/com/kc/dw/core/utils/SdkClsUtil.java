package com.kc.dw.core.utils;

import android.text.TextUtils;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.domain.SdkAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkClsUtil {

    @Keep
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f39343a;

        static {
            int[] iArr = new int[AdType.values().length];
            f39343a = iArr;
            try {
                iArr[AdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39343a[AdType.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39343a[AdType.REWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39343a[AdType.FEED_MIX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39343a[AdType.DRAW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39343a[AdType.FULL_SCREEN_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39343a[AdType.INTERSTITIAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f39343a[AdType.PASTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static void handleAdmob(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            if ("ADMOB".equals(sdkAdInfo.getSdk())) {
                sdkAdInfo.setSdk("CUSTOM");
                int i = a.f39343a[adType.ordinal()];
                if (i == 2) {
                    str = "com.meishu.admob.banner.AdmobBannerAdWrapper";
                } else if (i == 3) {
                    str = "com.meishu.admob.reward.AdmobRewardAdWrapper";
                } else if (i == 4) {
                    str = "com.meishu.admob.feed.AdmobFeedAdWrapper";
                } else if (i != 7) {
                    return;
                } else {
                    str = "com.meishu.admob.interstitial.AdmobIntertitialAdWrapper";
                }
                sdkAdInfo.setCls(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void handleBd(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getInitCls()) && "BAIDU".equals(sdkAdInfo.getSdk())) {
                sdkAdInfo.setInitCls("com.kc.dw.gather.bd.BDInitManager");
            }
            if (TextUtils.isEmpty(sdkAdInfo.getCls()) && "BAIDU".equals(sdkAdInfo.getSdk())) {
                int i = a.f39343a[adType.ordinal()];
                if (i == 1) {
                    if (sdkAdInfo.getDrawing() == 1) {
                        sdkAdInfo.setCls("com.kc.dw.gather.bd.feed.BDFeedAdapter");
                    } else {
                        str = "com.kc.dw.gather.bd.splash.BDSplashAdapter";
                        sdkAdInfo.setCls(str);
                    }
                }
                if (i == 7) {
                    if (sdkAdInfo.getDrawing() == 1) {
                        sdkAdInfo.setCls("com.kc.dw.gather.bd.feed.BDFeedAdapter");
                    } else {
                        str = "com.kc.dw.gather.bd.intertitial.BDIntertitialAdapter";
                        sdkAdInfo.setCls(str);
                    }
                }
                if (i == 3) {
                    str = "com.kc.dw.gather.bd.reward.BDRewardAdapter";
                    sdkAdInfo.setCls(str);
                } else {
                    if (i != 4) {
                        return;
                    }
                    sdkAdInfo.setCls("com.kc.dw.gather.bd.feed.BDFeedAdapter");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void handleCsj(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getInitCls()) && "CSJ".equals(sdkAdInfo.getSdk())) {
                sdkAdInfo.setInitCls("com.kc.dw.gather.csj.CSJInitManager");
            }
            if (TextUtils.isEmpty(sdkAdInfo.getCls()) && "CSJ".equals(sdkAdInfo.getSdk())) {
                int i = a.f39343a[adType.ordinal()];
                if (i == 1) {
                    if (sdkAdInfo.getDrawing() == 1) {
                        sdkAdInfo.setCls("com.kc.dw.gather.csj.feed.CSJFeedAdapter");
                        return;
                    } else {
                        str = "com.kc.dw.gather.csj.splash.CSJSplashAdapter";
                        sdkAdInfo.setCls(str);
                    }
                }
                if (i == 2) {
                    str = "com.kc.dw.gather.csj.banner.CSJBannerAdapter";
                } else {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 7) {
                                return;
                            }
                            if (sdkAdInfo.getDrawing() != 1) {
                                str = "com.kc.dw.gather.csj.intertitial.CSJIntertitialAdapter";
                            }
                        }
                        sdkAdInfo.setCls("com.kc.dw.gather.csj.feed.CSJFeedAdapter");
                        return;
                    }
                    str = "com.kc.dw.gather.csj.reward.CSJRewardAdapter";
                }
                sdkAdInfo.setCls(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void handleDuoMeng(SdkAdInfo sdkAdInfo, AdType adType) {
        try {
            if (sdkAdInfo.getCls().contains("com.kc.dw.gather.duomeng")) {
                sdkAdInfo.setSdk("DM");
            }
            if ("DM".equals(sdkAdInfo.getSdk()) && a.f39343a[adType.ordinal()] == 1) {
                sdkAdInfo.setCls("com.kc.dw.gather.duomeng.splash.DMSplashAdapter");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void handleGdt(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getInitCls()) && "GDT".equals(sdkAdInfo.getSdk())) {
                sdkAdInfo.setInitCls("com.kc.dw.gather.gdt.GDTInitManager");
            }
            if (TextUtils.isEmpty(sdkAdInfo.getCls()) && "GDT".equals(sdkAdInfo.getSdk())) {
                int i = a.f39343a[adType.ordinal()];
                if (i == 1) {
                    if (sdkAdInfo.getDrawing() == 1) {
                        sdkAdInfo.setCls("com.kc.dw.gather.gdt.feed.GDTFeedAdapter");
                        return;
                    } else {
                        str = "com.kc.dw.gather.gdt.splash.GDTSplashAdapter";
                        sdkAdInfo.setCls(str);
                    }
                }
                if (i == 2) {
                    str = "com.kc.dw.gather.gdt.banner.GDTBannerAdapter";
                } else {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 7) {
                                return;
                            }
                            if (sdkAdInfo.getDrawing() != 1) {
                                str = "com.kc.dw.gather.gdt.intertitial.GDTIntertitialAdapter";
                            }
                        }
                        sdkAdInfo.setCls("com.kc.dw.gather.gdt.feed.GDTFeedAdapter");
                        return;
                    }
                    str = "com.kc.dw.gather.gdt.reward.GDTRewardAdapter";
                }
                sdkAdInfo.setCls(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void handleKs(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getInitCls()) && "KS".equals(sdkAdInfo.getSdk())) {
                sdkAdInfo.setInitCls("com.kc.dw.gather.ks.KSInitManager");
            }
            if (TextUtils.isEmpty(sdkAdInfo.getCls()) && "KS".equals(sdkAdInfo.getSdk())) {
                int i = a.f39343a[adType.ordinal()];
                if (i == 1) {
                    if (sdkAdInfo.getDrawing() == 1) {
                        sdkAdInfo.setCls("com.kc.dw.gather.ks.feed.KSFeedAdapter");
                        return;
                    } else {
                        str = "com.kc.dw.gather.ks.splash.KSSplashAdapter";
                        sdkAdInfo.setCls(str);
                    }
                }
                if (i == 2) {
                    str = "com.kc.dw.gather.ks.banner.KSBannerAdapter";
                } else {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 7) {
                                return;
                            }
                            if (sdkAdInfo.getDrawing() != 1) {
                                str = "com.kc.dw.gather.ks.intertitial.KSIntertitialAdapter";
                            }
                        }
                        sdkAdInfo.setCls("com.kc.dw.gather.ks.feed.KSFeedAdapter");
                        return;
                    }
                    str = "com.kc.dw.gather.ks.reward.KSRewardAdapter";
                }
                sdkAdInfo.setCls(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void handleOwnSdkCls(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            switch (a.f39343a[adType.ordinal()]) {
                case 1:
                    str = "com.kc.dw.own.splash.OwnSplashAdapter";
                    break;
                case 2:
                    str = "com.kc.dw.own.banner.OwnBannerAdapter";
                    break;
                case 3:
                    str = "com.kc.dw.own.reward.OwnRewardAdapter";
                    break;
                case 4:
                    str = "com.kc.dw.own.feed.OwnFeedAdapter";
                    break;
                case 5:
                    str = "com.kc.dw.own.draw.OwnDrawAdapter";
                    break;
                case 6:
                    str = "com.kc.dw.own.fullscreen.OwnFullscreenAdapter";
                    break;
                case 7:
                    str = "com.kc.dw.own.intertitial.OwnIntertitialAdapter";
                    break;
                case 8:
                    str = "com.kc.dw.own.paster.OwnPasterAdapter";
                    break;
                default:
                    return;
            }
            sdkAdInfo.setCls(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void handlePangle(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            if (sdkAdInfo.getCls().contains("com.kc.dw.platform.pangle")) {
                sdkAdInfo.setSdk("PANGLE");
            }
            if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                int i = a.f39343a[adType.ordinal()];
                if (i == 1) {
                    str = "com.kc.dw.platform.pangle.splash.PangleSplashAdapter";
                } else if (i == 2) {
                    str = "com.kc.dw.platform.pangle.banner.PangleBannerAdapter";
                } else if (i == 3) {
                    str = "com.kc.dw.platform.pangle.reward.PangleRewardAdapter";
                } else if (i == 4) {
                    str = "com.kc.dw.platform.pangle.feed.PangleNativeAdapter";
                } else if (i != 7) {
                    return;
                } else {
                    str = "com.kc.dw.platform.pangle.interstitial.PangleInterstitialAdapter";
                }
                sdkAdInfo.setCls(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void handleSdkCls(SdkAdInfo sdkAdInfo, AdType adType) {
        handleCsj(sdkAdInfo, adType);
        handleGdt(sdkAdInfo, adType);
        handleBd(sdkAdInfo, adType);
        handleKs(sdkAdInfo, adType);
        handleSigmob(sdkAdInfo, adType);
        handleAdmob(sdkAdInfo, adType);
        handlePangle(sdkAdInfo, adType);
        handleDuoMeng(sdkAdInfo, adType);
    }

    private static void handleSigmob(SdkAdInfo sdkAdInfo, AdType adType) {
        String str;
        try {
            if ("SGM".equals(sdkAdInfo.getSdk())) {
                int i = a.f39343a[adType.ordinal()];
                if (i == 1) {
                    str = "com.kc.dw.platform.sigmob.custom.splash.SigmobCustomSplashAdapter";
                } else if (i == 3) {
                    str = "com.kc.dw.platform.sigmob.custom.reward.SigmobCustomRewardAdapter";
                } else if (i == 4) {
                    str = "com.kc.dw.platform.sigmob.custom.feed.SigmobCustomFeedAdapter";
                } else if (i == 6) {
                    str = "com.kc.dw.platform.sigmob.custom.fullscreen.SigmobCustomFullscreenAdapter";
                } else if (i != 7) {
                    return;
                } else {
                    str = "com.kc.dw.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter";
                }
                sdkAdInfo.setCls(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
