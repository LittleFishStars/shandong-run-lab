package cn.hzjizhun.admin.ad.utils;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo;
import cn.hzjizhun.admin.ad.bean.JZNativeAdInfo;
import cn.hzjizhun.admin.ad.listener.JZNativeAdListener;
import cn.hzjizhun.admin.ddsksdddk;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DisplayUtil;
import cn.hzjizhun.admin.view.INativeAdFlow;
import cn.hzjizhun.admin.view.INativeAdPop;
import cn.hzjizhun.admin.view.NativeAdPopHelper;
import cn.hzjizhun.admin.view.RootTouchViewGroup;
import cn.hzjizhun.admin.view.SlideLRLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JZAdUtil {
    private static float mAmount = 0.0f;
    private static JZNativeAdListener mAsyncJZNativeAdListener = null;
    private static INativeAdPop mAsyncNativeAdInfo = null;
    private static boolean mCancelable = true;
    private static boolean mIsOutsideCancel;
    private static boolean mIsViewBottomCloseView;
    private static WeakHashMap<INativeAdPop, NativeAdPopHelper> mNativeAdPopHelperMap = new WeakHashMap<>();
    private static int mTopY;
    private static long sCloseTime;

    public class a implements SlideLRLayout.akdsd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f22686a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ JZNativeAdListener f274a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ INativeAdFlow f275a;

        public a(ViewGroup viewGroup, INativeAdFlow iNativeAdFlow, JZNativeAdListener jZNativeAdListener) {
            this.f22686a = viewGroup;
            this.f275a = iNativeAdFlow;
            this.f274a = jZNativeAdListener;
        }

        @Override // cn.hzjizhun.admin.view.SlideLRLayout.akdsd
        public void a() {
            ALog.d("AdUtil", "adContainer end ChildCount=" + this.f22686a.getChildCount());
            this.f275a.release();
            try {
                JZNativeAdListener jZNativeAdListener = this.f274a;
                if (jZNativeAdListener != null) {
                    jZNativeAdListener.onAdClose((JZNativeAdInfo) this.f275a);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void addAdViewToAdContainer(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return;
        }
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            viewGroup.addView(view, layoutParams);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            viewGroup.addView(view, layoutParams2);
        } else {
            if (!(viewGroup instanceof LinearLayout)) {
                viewGroup.addView(view);
                return;
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            viewGroup.addView(view, layoutParams3);
        }
    }

    public static boolean checkInterstitialAd(JZInterstitialAdInfo jZInterstitialAdInfo) {
        return (jZInterstitialAdInfo == null || jZInterstitialAdInfo.hasShown() || jZInterstitialAdInfo.hasExpired()) ? false : true;
    }

    public static void closeNativeAd(JZNativeAdInfo jZNativeAdInfo) {
        try {
            getsNativeAdPopHelper(jZNativeAdInfo).closeAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static NativeAdPopHelper getsNativeAdPopHelper(JZNativeAdInfo jZNativeAdInfo) {
        return mNativeAdPopHelperMap.get(jZNativeAdInfo);
    }

    public static void removeNativeAdPopHelper(INativeAdPop iNativeAdPop) {
        try {
            mNativeAdPopHelperMap.remove(iNativeAdPop);
        } catch (Throwable unused) {
        }
    }

    public static void renderTradPlusNaiveAd(ViewGroup viewGroup, JZNativeAdInfo jZNativeAdInfo) {
        try {
            jZNativeAdInfo.render(viewGroup);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setAsyncNativeAdInfo(INativeAdPop iNativeAdPop, JZNativeAdListener jZNativeAdListener) {
        mAsyncNativeAdInfo = iNativeAdPop;
        mAsyncJZNativeAdListener = jZNativeAdListener;
    }

    public static void setCancelable(boolean z) {
        mCancelable = z;
    }

    public static void setCanceledOnTouchOutside(boolean z) {
        mIsOutsideCancel = z;
    }

    public static void setCloseTime(long j) {
    }

    public static void setCountdown(int i) {
        if (i <= 0) {
            sCloseTime = 0L;
        } else {
            sCloseTime = i * 1000;
        }
    }

    public static void setDimAmount(float f) {
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        mAmount = f;
    }

    public static void setIsViewBottomCloseView(boolean z) {
        mIsViewBottomCloseView = z;
    }

    public static void setTopY(int i) {
        mTopY = i;
    }

    public static void showAsyncNativeAdConvenient(Activity activity) {
        JZNativeAdListener jZNativeAdListener;
        try {
            INativeAdPop iNativeAdPop = mAsyncNativeAdInfo;
            if (iNativeAdPop != null && !iNativeAdPop.isReleased() && (jZNativeAdListener = mAsyncJZNativeAdListener) != null) {
                showJZNativeAdConvenient(activity, mAsyncNativeAdInfo, jZNativeAdListener);
            }
            mAsyncNativeAdInfo = null;
            mAsyncJZNativeAdListener = null;
        } catch (Throwable unused) {
        }
    }

    public static boolean showInterstitialAd(Activity activity, JZInterstitialAdInfo jZInterstitialAdInfo) {
        if (activity == null || activity.isFinishing() || !checkInterstitialAd(jZInterstitialAdInfo)) {
            return false;
        }
        jZInterstitialAdInfo.showInterstitial(activity);
        return true;
    }

    public static boolean showJZNaiveAd(ViewGroup viewGroup, JZNativeAdInfo jZNativeAdInfo) {
        View nativeExpressAdView;
        if (viewGroup != null && jZNativeAdInfo != null) {
            try {
                if (!jZNativeAdInfo.isReleased() && (nativeExpressAdView = jZNativeAdInfo.getNativeExpressAdView(viewGroup)) != null && nativeExpressAdView.getParent() == null) {
                    nativeExpressAdView.setTag("nativeAd");
                    if (viewGroup.getChildCount() > 0) {
                        viewGroup.removeAllViews();
                    }
                    RootTouchViewGroup rootTouchViewGroup = new RootTouchViewGroup(viewGroup.getContext());
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    ddsksdddk.c(jZNativeAdInfo.getPlatformPosId(), rootTouchViewGroup);
                    rootTouchViewGroup.addView(nativeExpressAdView, layoutParams);
                    if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams2.gravity = 17;
                        viewGroup.addView(rootTouchViewGroup, layoutParams2);
                    } else if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams3.addRule(13);
                        viewGroup.addView(rootTouchViewGroup, layoutParams3);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams4.gravity = 17;
                        viewGroup.addView(rootTouchViewGroup, layoutParams4);
                    } else {
                        viewGroup.addView(rootTouchViewGroup);
                    }
                    jZNativeAdInfo.render(viewGroup);
                    if (viewGroup.getVisibility() == 0) {
                        return true;
                    }
                    viewGroup.setVisibility(0);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean showJZNaiveAdSlideClose(ViewGroup viewGroup, String str, INativeAdFlow iNativeAdFlow, JZNativeAdListener jZNativeAdListener) {
        View nativeExpressAdView;
        if (viewGroup == null || iNativeAdFlow == null || iNativeAdFlow.isReleased() || (nativeExpressAdView = iNativeAdFlow.getNativeExpressAdView(viewGroup)) == null || nativeExpressAdView.getParent() != null) {
            return false;
        }
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        SlideLRLayout slideLRLayout = new SlideLRLayout(viewGroup.getContext());
        ALog.d("AdUtil", "adContainer start ChildCount=" + viewGroup.getChildCount());
        slideLRLayout.setStampCallback(new a(viewGroup, iNativeAdFlow, jZNativeAdListener));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        if (nativeExpressAdView.getParent() != null) {
            ((ViewGroup) nativeExpressAdView.getParent()).removeView(nativeExpressAdView);
        }
        RootTouchViewGroup rootTouchViewGroup = new RootTouchViewGroup(viewGroup.getContext());
        ddsksdddk.c(iNativeAdFlow.getPlatformPosId(), rootTouchViewGroup);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        nativeExpressAdView.setPadding(0, 0, 0, DisplayUtil.dp2px(20));
        rootTouchViewGroup.addView(nativeExpressAdView, layoutParams2);
        slideLRLayout.addView(rootTouchViewGroup, layoutParams);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            nativeExpressAdView.setBackgroundColor(Color.parseColor(str));
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            viewGroup.addView(slideLRLayout, layoutParams3);
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams4.addRule(13);
            viewGroup.addView(slideLRLayout, layoutParams4);
        } else if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams5.gravity = 17;
            viewGroup.addView(slideLRLayout, layoutParams5);
        } else {
            viewGroup.addView(slideLRLayout);
        }
        iNativeAdFlow.render(viewGroup);
        if (viewGroup.getVisibility() == 0) {
            return true;
        }
        viewGroup.setVisibility(0);
        return true;
    }

    public static void showJZNativeAdConvenient(Activity activity, INativeAdPop iNativeAdPop, JZNativeAdListener jZNativeAdListener) {
        ALog.d("size", "showNativeAdConvenient " + mNativeAdPopHelperMap.size());
        showJZNativeAdConvenient(activity, iNativeAdPop, false, jZNativeAdListener);
    }

    public static boolean showTradPlusNaiveAd(ViewGroup viewGroup, JZNativeAdInfo jZNativeAdInfo) {
        View nativeExpressAdView;
        if (viewGroup != null && jZNativeAdInfo != null) {
            try {
                if (!jZNativeAdInfo.isReleased() && (nativeExpressAdView = jZNativeAdInfo.getNativeExpressAdView(viewGroup)) != null && nativeExpressAdView.getParent() == null) {
                    nativeExpressAdView.setTag("nativeAd");
                    if (viewGroup.getChildCount() > 0) {
                        viewGroup.removeAllViews();
                    }
                    if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = 17;
                        viewGroup.addView(nativeExpressAdView, layoutParams);
                    } else if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams2.addRule(13);
                        viewGroup.addView(nativeExpressAdView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams3.gravity = 17;
                        viewGroup.addView(nativeExpressAdView, layoutParams3);
                    } else {
                        viewGroup.addView(nativeExpressAdView);
                    }
                    if (viewGroup.getVisibility() == 0) {
                        return true;
                    }
                    viewGroup.setVisibility(0);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean showInterstitialAd(Fragment fragment, JZInterstitialAdInfo jZInterstitialAdInfo) {
        Activity activity;
        if (fragment == null || !checkInterstitialAd(jZInterstitialAdInfo) || (activity = fragment.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        jZInterstitialAdInfo.showInterstitial(activity);
        return true;
    }

    public static void showJZNativeAdConvenient(Activity activity, INativeAdPop iNativeAdPop, boolean z, JZNativeAdListener jZNativeAdListener) {
        ALog.d("size", "showNativeAdConvenient " + mNativeAdPopHelperMap.size());
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            NativeAdPopHelper nativeAdPopHelper = new NativeAdPopHelper(activity, mTopY, z);
            mNativeAdPopHelperMap.put(iNativeAdPop, nativeAdPopHelper);
            nativeAdPopHelper.setNativeAdListener(jZNativeAdListener);
            nativeAdPopHelper.setCloseTime(sCloseTime);
            nativeAdPopHelper.setCancelable(mCancelable);
            nativeAdPopHelper.setIsViewBottomCloseView(mIsViewBottomCloseView);
            nativeAdPopHelper.setDimAmount(mAmount);
            nativeAdPopHelper.setCanceledOnTouchOutside(mIsOutsideCancel);
            nativeAdPopHelper.showNativeAd(iNativeAdPop);
        }
        mIsOutsideCancel = false;
        mCancelable = true;
        sCloseTime = 0L;
    }

    public static void showJZNativeAdConvenient(Fragment fragment, INativeAdPop iNativeAdPop, JZNativeAdListener jZNativeAdListener) {
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        showJZNativeAdConvenient(fragment.getActivity(), iNativeAdPop, jZNativeAdListener);
    }
}
