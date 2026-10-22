package cn.hzjizhun.admin.h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.custom_ad.AdapterCustomSplashAdLoader;
import cn.hzjizhun.admin.custom_ad.CustomReport;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.h5.AdSdkH5Helper;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DialogUtils;
import cn.hzjizhun.admin.util.ReflectUtil;
import cn.hzjizhun.admin.util.ReportUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdSdkH5Helper {
    private static final AtomicBoolean isDialogShowing = new AtomicBoolean(false);
    private static AdapterCustomSplashAdLoader.AdCloseListener sSplashAdListener;

    public interface DialogCallback {
        void cancel();

        void sure();
    }

    private static Intent buildH5Intent(Context context, String str, SkipH5Params skipH5Params) {
        if (!str.startsWith("http")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(805339136);
            return intent;
        }
        Intent intent2 = new Intent(context, (Class<?>) AdSdkH5Activity.class);
        String strCreateKey = ReportUtils.createKey();
        ReportUtils.getInstance().addReport(strCreateKey, skipH5Params.report);
        intent2.putExtra(AdSdkH5Activity.REPORTKEY, strCreateKey);
        intent2.putExtra("url_str", str);
        intent2.putExtra("isDownload", skipH5Params.adResult.isDownload());
        intent2.putExtra(AdSdkH5Activity.ISOUTFUNCTION, skipH5Params.adResult.isOutFunction());
        intent2.putExtra(AdSdkH5Activity.POSPLATNAME, skipH5Params.adResult.getChannelName());
        intent2.putExtra(AdSdkH5Activity.INFUNCTIONPOSID, skipH5Params.adResult.getPostId());
        intent2.putExtra(AdSdkH5Activity.ISSHOWSUREDIALOG, skipH5Params.adResult.isShowSecondarySureDialog());
        intent2.putExtra(AdSdkH5Activity.ISFULLLANDINGPAGE, skipH5Params.isFullLandingPage);
        CustomAdPosResult.HeadersBean headersBean = skipH5Params.adResult.mHeadersBean;
        if (headersBean == null || TextUtils.isEmpty(headersBean.requested)) {
            intent2.putExtra(AdSdkH5Activity.PKG, skipH5Params.adResult.getPkg());
        } else {
            intent2.putExtra(AdSdkH5Activity.PKG, skipH5Params.adResult.mHeadersBean.requested);
        }
        intent2.putExtra(AdSdkH5Activity.LANDINGPAGEALPHA, skipH5Params.landingPageAlpha);
        intent2.putExtra(AdSdkH5Activity.ISLANDINGPAGEFLOWSYSTEM, skipH5Params.isLandingPageFlowSystem);
        intent2.putExtra(AdSdkH5Activity.ISLANDINGVERTICAL, skipH5Params.isLandingVertical);
        intent2.addFlags(268435456);
        return intent2;
    }

    private static Intent createDeeplinkIntent(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        return intent;
    }

    private static DialogCallback createDialogCallback(final DialogCallback dialogCallback) {
        return new DialogCallback() { // from class: cn.hzjizhun.admin.h5.AdSdkH5Helper.3
            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void cancel() {
                AdSdkH5Helper.resetDialogState();
                AdSdkH5Helper.notifyCancel(dialogCallback);
            }

            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void sure() {
                AdSdkH5Helper.resetDialogState();
                AdSdkH5Helper.notifySure(dialogCallback);
            }
        };
    }

    private static DialogCallback createWrappedCallback(final Context context, final Intent intent, final DialogCallback dialogCallback) {
        return new DialogCallback() { // from class: cn.hzjizhun.admin.h5.AdSdkH5Helper.2
            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void cancel() {
                AdSdkH5Helper.notifyCancel(dialogCallback);
            }

            @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
            public void sure() {
                AdSdkH5Helper.openDeeplinkAndNotify(context, intent, dialogCallback);
            }
        };
    }

    public static AdapterCustomSplashAdLoader.AdCloseListener getSplashAdListener() {
        return sSplashAdListener;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) ? false : true;
    }

    private static void notifyCallback(DialogCallback dialogCallback, boolean z) {
        if (dialogCallback != null) {
            try {
                if (z) {
                    dialogCallback.sure();
                } else {
                    dialogCallback.cancel();
                }
            } catch (Throwable unused) {
                ALog.e("DeeplinkDialogManager", "Callback error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyCancel(DialogCallback dialogCallback) {
        notifyCallback(dialogCallback, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifySure(DialogCallback dialogCallback) {
        notifyCallback(dialogCallback, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void openDeeplinkAndNotify(Context context, Intent intent, final DialogCallback dialogCallback) {
        ReflectUtil.openDeeplink(context, intent);
        ReflectUtil.checkDeeplinkStatus(context, new ReflectUtil.DeeplinkStatusCallback() { // from class: cn.hzjizhun.admin.h5.AdSdkH5Helper.1
            @Override // cn.hzjizhun.admin.util.ReflectUtil.DeeplinkStatusCallback
            public void onStatusChecked(boolean z) {
                if (z) {
                    AdSdkH5Helper.notifySure(dialogCallback);
                } else {
                    AdSdkH5Helper.notifyCancel(dialogCallback);
                }
            }
        });
    }

    public static void releaseSplashAdListener() {
        sSplashAdListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void resetDialogState() {
        isDialogShowing.set(false);
    }

    private static boolean shouldShowDialog(Context context, boolean z) {
        return z && (context instanceof Activity);
    }

    public static void showDeeplinkSureDialog(final Context context, final DialogCallback dialogCallback) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.aw
                @Override // java.lang.Runnable
                public final void run() {
                    AdSdkH5Helper.showDeeplinkSureDialog(context, dialogCallback);
                }
            });
            return;
        }
        if (context == null) {
            notifyCancel(dialogCallback);
        } else if (isDialogShowing.compareAndSet(false, true)) {
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            DialogUtils.show(context, JZAdSdk.getInstance().getPopUpDesc(), createDialogCallback(dialogCallback));
        }
    }

    public static void skipDeeplink(Context context, String str, String str2, boolean z, DialogCallback dialogCallback) {
        try {
            if (TextUtils.isEmpty(str)) {
                notifyCancel(dialogCallback);
                return;
            }
            Intent intentCreateDeeplinkIntent = createDeeplinkIntent(str, str2);
            if (!isIntentAvailable(context, intentCreateDeeplinkIntent)) {
                notifyCancel(dialogCallback);
            } else if (shouldShowDialog(context, z)) {
                showDeeplinkSureDialog(context, createWrappedCallback(context, intentCreateDeeplinkIntent, dialogCallback));
            } else {
                openDeeplinkAndNotify(context, intentCreateDeeplinkIntent, dialogCallback);
            }
        } catch (Throwable unused) {
            ALog.e("skipDeeplink", "Failed to handle deep link: ");
            notifyCancel(dialogCallback);
        }
    }

    public static boolean skipH5(SkipH5Params skipH5Params) {
        releaseSplashAdListener();
        return skipH5Activity(skipH5Params);
    }

    public static boolean skipH5Activity(SkipH5Params skipH5Params) {
        CustomAdPosResult customAdPosResult;
        Intent intentBuildH5Intent;
        if (skipH5Params != null && (customAdPosResult = skipH5Params.adResult) != null) {
            String jumpPage = customAdPosResult.getJumpPage();
            ALog.i("", "skipH5:" + jumpPage);
            if (TextUtils.isEmpty(jumpPage)) {
                return false;
            }
            Context context = skipH5Params.context;
            if (context == null) {
                context = JZAdSdk.getInstance().getContext();
            }
            if (context != null) {
                try {
                    if (jumpPage.startsWith("msx://") || (intentBuildH5Intent = buildH5Intent(context, jumpPage, skipH5Params)) == null) {
                        return false;
                    }
                    context.startActivity(intentBuildH5Intent);
                    return true;
                } catch (Throwable th) {
                    ALog.e("skipH5Activity", "Exception: " + th.getMessage());
                }
            }
        }
        return false;
    }

    public static void skipSplashH5Callback(SkipH5Params skipH5Params, AdapterCustomSplashAdLoader.AdCloseListener adCloseListener) {
        sSplashAdListener = adCloseListener;
        if (skipH5Activity(skipH5Params) || adCloseListener == null) {
            return;
        }
        adCloseListener.onAdClose();
    }

    public static class SkipH5Params {
        public CustomAdPosResult adResult;
        public Context context;
        public boolean isFullLandingPage;
        public boolean isLandingPageFlowSystem;
        public boolean isLandingVertical;
        public int landingPageAlpha;
        public CustomReport report;

        public SkipH5Params(Context context, CustomAdPosResult customAdPosResult, CustomReport customReport) {
            this.isFullLandingPage = true;
            this.landingPageAlpha = 0;
            this.isLandingPageFlowSystem = true;
            this.isLandingVertical = true;
            this.context = context;
            this.adResult = customAdPosResult;
            this.report = customReport;
        }

        public SkipH5Params(Context context, CustomAdPosResult customAdPosResult, CustomReport customReport, boolean z, int i, boolean z2, boolean z3) {
            this.context = context;
            this.adResult = customAdPosResult;
            this.report = customReport;
            this.isFullLandingPage = z;
            this.landingPageAlpha = i;
            this.isLandingPageFlowSystem = z2;
            this.isLandingVertical = z3;
        }
    }
}
