package com.bwt.top;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bwt.top.ad.bean.InterstitialAdInfo;
import com.bwt.top.ad.bean.NativeAdInfo;
import com.bwt.top.util.ALog;
import com.bwt.top.util.DisplayUtil;
import com.bwt.top.view.NativeAdPopHelper;
import com.bwt.top.view.SlideLRLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdUtil {
    private static long sCloseTime;
    private static NativeAdPopHelper sNativeAdPopHelper;

    public class a implements SlideLRLayout.akdsd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28237a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ NativeAdListener f1464a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ NativeAdInfo f1465a;

        public a(ViewGroup viewGroup, NativeAdInfo nativeAdInfo, NativeAdListener nativeAdListener) {
            this.f28237a = viewGroup;
            this.f1465a = nativeAdInfo;
            this.f1464a = nativeAdListener;
        }

        @Override // com.bwt.top.view.SlideLRLayout.akdsd
        public void a() {
            ALog.d("AdUtil", "adContainer end ChildCount=" + this.f28237a.getChildCount());
            this.f1465a.release();
            NativeAdListener nativeAdListener = this.f1464a;
            if (nativeAdListener != null) {
                nativeAdListener.onAdClose(this.f1465a);
            }
        }
    }

    public static void addAdViewToAdContainer(ViewGroup viewGroup, View view) {
        ViewGroup.LayoutParams layoutParams;
        if (viewGroup == null || view == null) {
            return;
        }
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            layoutParams = layoutParams2;
        } else if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            layoutParams = layoutParams3;
        } else if (!(viewGroup instanceof LinearLayout)) {
            viewGroup.addView(view);
            return;
        } else {
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = 17;
            layoutParams = layoutParams4;
        }
        viewGroup.addView(view, layoutParams);
    }

    public static boolean checkInterstitialAd(InterstitialAdInfo interstitialAdInfo) {
        return (interstitialAdInfo == null || interstitialAdInfo.hasShown() || interstitialAdInfo.hasExpired()) ? false : true;
    }

    public static NativeAdPopHelper getsNativeAdPopHelper() {
        return sNativeAdPopHelper;
    }

    public static void setCloseTime(long j) {
        sCloseTime = j;
    }

    public static void setNativeAdPopHelper(NativeAdPopHelper nativeAdPopHelper) {
        sNativeAdPopHelper = nativeAdPopHelper;
    }

    public static boolean showInterstitialAd(Activity activity, InterstitialAdInfo interstitialAdInfo) {
        if (activity == null || activity.isFinishing() || !checkInterstitialAd(interstitialAdInfo)) {
            return false;
        }
        interstitialAdInfo.showInterstitial(activity);
        return true;
    }

    public static boolean showInterstitialAd(Fragment fragment, InterstitialAdInfo interstitialAdInfo) {
        Activity activity;
        if (fragment == null || !checkInterstitialAd(interstitialAdInfo) || (activity = fragment.getActivity()) == null || activity.isFinishing()) {
            return false;
        }
        interstitialAdInfo.showInterstitial(activity);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public static boolean showNaiveAd(ViewGroup viewGroup, NativeAdInfo nativeAdInfo) {
        View nativeExpressAdView;
        ViewGroup.LayoutParams layoutParams;
        if (viewGroup == null || nativeAdInfo == null || nativeAdInfo.isReleased() || (nativeExpressAdView = nativeAdInfo.getNativeExpressAdView(viewGroup)) == null) {
            return false;
        }
        nativeExpressAdView.setTag("nativeAd");
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            layoutParams = layoutParams2;
        } else {
            if (!(viewGroup instanceof RelativeLayout)) {
                if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 17;
                    layoutParams = layoutParams3;
                } else {
                    viewGroup.addView(nativeExpressAdView);
                }
                nativeAdInfo.render(viewGroup);
                if (viewGroup.getVisibility() != 0) {
                    return true;
                }
                viewGroup.setVisibility(0);
                return true;
            }
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            layoutParams = layoutParams4;
        }
        viewGroup.addView(nativeExpressAdView, layoutParams);
        nativeAdInfo.render(viewGroup);
        if (viewGroup.getVisibility() != 0) {
            return true;
        }
        viewGroup.setVisibility(0);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    public static boolean showNaiveAdSlideClose(ViewGroup viewGroup, String str, NativeAdInfo nativeAdInfo, NativeAdListener nativeAdListener) {
        View nativeExpressAdView;
        ViewGroup.LayoutParams layoutParams;
        if (viewGroup == null || nativeAdInfo == null || nativeAdInfo.isReleased() || (nativeExpressAdView = nativeAdInfo.getNativeExpressAdView(viewGroup)) == null) {
            return false;
        }
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        SlideLRLayout slideLRLayout = new SlideLRLayout(viewGroup.getContext());
        ALog.d("AdUtil", "adContainer start ChildCount=" + viewGroup.getChildCount());
        slideLRLayout.setStampCallback(new a(viewGroup, nativeAdInfo, nativeAdListener));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        if (nativeExpressAdView.getParent() != null) {
            ((ViewGroup) nativeExpressAdView.getParent()).removeView(nativeExpressAdView);
        }
        nativeExpressAdView.setPadding(0, 0, 0, DisplayUtil.dp2px(20));
        slideLRLayout.addView(nativeExpressAdView, layoutParams2);
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            nativeExpressAdView.setBackgroundColor(Color.parseColor(str));
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            layoutParams = layoutParams3;
        } else {
            if (!(viewGroup instanceof RelativeLayout)) {
                if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    viewGroup.addView(slideLRLayout);
                }
                nativeAdInfo.render(viewGroup);
                if (viewGroup.getVisibility() != 0) {
                    return true;
                }
                viewGroup.setVisibility(0);
                return true;
            }
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams5.addRule(13);
            layoutParams = layoutParams5;
        }
        viewGroup.addView(slideLRLayout, layoutParams);
        nativeAdInfo.render(viewGroup);
        if (viewGroup.getVisibility() != 0) {
            return true;
        }
        viewGroup.setVisibility(0);
        return true;
    }

    public static void showNativeAdConvenient(Activity activity, NativeAdInfo nativeAdInfo, NativeAdListener nativeAdListener) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            NativeAdPopHelper nativeAdPopHelper = new NativeAdPopHelper(activity);
            sNativeAdPopHelper = nativeAdPopHelper;
            nativeAdPopHelper.setNativeAdListener(nativeAdListener);
            sNativeAdPopHelper.setCloseTime(sCloseTime);
            sNativeAdPopHelper.showNativeAd(nativeAdInfo);
        }
        sCloseTime = 0L;
    }

    public static void showNativeAdConvenient(Fragment fragment, NativeAdInfo nativeAdInfo, NativeAdListener nativeAdListener) {
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        showNativeAdConvenient(fragment.getActivity(), nativeAdInfo, nativeAdListener);
    }
}
