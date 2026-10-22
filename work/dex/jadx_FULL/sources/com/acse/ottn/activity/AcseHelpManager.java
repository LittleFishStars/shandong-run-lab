package com.acse.ottn.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.acse.ottn.b;
import com.acse.ottn.c5;
import com.acse.ottn.d5;
import com.acse.ottn.i;
import com.acse.ottn.i4;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.j4;
import com.acse.ottn.l0;
import com.acse.ottn.l1;
import com.acse.ottn.m1;
import com.acse.ottn.n3;
import com.acse.ottn.o1;
import com.acse.ottn.p4;
import com.acse.ottn.q0;
import com.acse.ottn.r1;
import com.acse.ottn.service.StartProcreeService;
import com.acse.ottn.t0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.w3;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AcseHelpManager {
    private static Application mContext;
    public static boolean mIsDebug;

    /* JADX INFO: renamed from: com.acse.ottn.activity.AcseHelpManager$3, reason: invalid class name */
    public class AnonymousClass3 implements OnOpenPermission {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22837a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ OnCurrentStateCallBack c;
        public final /* synthetic */ boolean d;

        public AnonymousClass3(boolean z, Activity activity, OnCurrentStateCallBack onCurrentStateCallBack, boolean z2) {
            this.f22837a = z;
            this.b = activity;
            this.c = onCurrentStateCallBack;
            this.d = z2;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z) {
            if (!z && !this.f22837a) {
                OnCurrentStateCallBack onCurrentStateCallBack = this.c;
                if (onCurrentStateCallBack != null) {
                    onCurrentStateCallBack.onState("0");
                    return;
                }
                return;
            }
            if (!AcseHelpManager.isOpenAccessiblityPermission()) {
                AcseHelpManager.showRunningDialog(this.b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("4");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (anonymousClass3.d) {
                            AcseHelpManager.showWarningDialog(anonymousClass3.b, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.3.1.1
                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onClose() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("4");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onDismiss() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("3");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onOpen() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.c;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("2");
                                    }
                                }
                            });
                            return;
                        }
                        OnCurrentStateCallBack onCurrentStateCallBack2 = anonymousClass3.c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("0");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass3.this.c;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("1");
                        }
                    }
                });
                return;
            }
            OnCurrentStateCallBack onCurrentStateCallBack2 = this.c;
            if (onCurrentStateCallBack2 != null) {
                onCurrentStateCallBack2.onState("0");
            }
        }
    }

    /* JADX INFO: renamed from: com.acse.ottn.activity.AcseHelpManager$4, reason: invalid class name */
    public class AnonymousClass4 implements OnOpenPermission {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22840a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ OnCurrentStateCallBack f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public AnonymousClass4(Activity activity, String str, String str2, String str3, String str4, OnCurrentStateCallBack onCurrentStateCallBack, boolean z, String str5, String str6, String str7, String str8) {
            this.f22840a = activity;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = onCurrentStateCallBack;
            this.g = z;
            this.h = str5;
            this.i = str6;
            this.j = str7;
            this.k = str8;
        }

        @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
        public void openPermission(boolean z) {
            if (!z) {
                OnCurrentStateCallBack onCurrentStateCallBack = this.f;
                if (onCurrentStateCallBack != null) {
                    onCurrentStateCallBack.onState("0");
                    return;
                }
                return;
            }
            if (!AcseHelpManager.isOpenAccessiblityPermission()) {
                w3.a(this.f22840a, this.b, this.c, this.d, this.e, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.4.1
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("4");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        if (anonymousClass4.g) {
                            AcseHelpManager.showWarningDialog(anonymousClass4.f22840a, anonymousClass4.h, anonymousClass4.i, anonymousClass4.j, anonymousClass4.k, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.4.1.1
                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onClose() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("4");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onDismiss() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("3");
                                    }
                                }

                                @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                                public void onOpen() {
                                    OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f;
                                    if (onCurrentStateCallBack2 != null) {
                                        onCurrentStateCallBack2.onState("2");
                                    }
                                }
                            });
                            return;
                        }
                        OnCurrentStateCallBack onCurrentStateCallBack2 = anonymousClass4.f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("0");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = AnonymousClass4.this.f;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("1");
                        }
                    }
                });
                return;
            }
            OnCurrentStateCallBack onCurrentStateCallBack2 = this.f;
            if (onCurrentStateCallBack2 != null) {
                onCurrentStateCallBack2.onState("0");
            }
        }
    }

    public static class InitSdk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Application f22844a;

        public void build() {
            new AcseHelpManager(this);
            HelpShopAppUtil.init(AcseHelpManager.mContext);
            AcseHelpManager.isApkInDebug();
            if (!(AcseHelpManager.mContext instanceof Application)) {
                throw new Error("shophelp SDK init activity manager throw a Error");
            }
            m1.a(AcseHelpManager.mContext);
        }

        public InitSdk setContext(Application application) {
            this.f22844a = application;
            return this;
        }
    }

    public interface OnAccessiblityStateCallBack {
        void onSuccess(String str);
    }

    public interface OnClickCallBack {
        void onClose();

        void onDismiss();

        void onOpen();
    }

    public interface OnCurrentStateCallBack {
        void onState(String str);
    }

    public interface OnIndividuationCallBack {
        void onIndividuationState(boolean z);
    }

    public interface OnOpenPermission {
        void openPermission(boolean z);
    }

    public static boolean checkAccessiblityState() {
        if (HelpShopAppUtil.getContext() != null) {
            return b.c().e();
        }
        Log.d("AcseHelpManager", "init sdk fail");
        return false;
    }

    public static boolean checkBatteryPermission() {
        if ("".equals(l0.y)) {
            return true;
        }
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
            return true;
        }
        if (Build.VERSION.SDK_INT > 28) {
            return d5.a().b(l0.y);
        }
        return true;
    }

    public static boolean checkFloatWindow() {
        if (HelpShopAppUtil.getContext() != null) {
            return b.c().a();
        }
        Log.d("AcseHelpManager", "init sdk fail");
        return false;
    }

    public static void closeAccessiblityPlugIn(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        q0.a(activity, "关闭辅助功能:", "关闭辅助功能不会影响软件正常使用。但辅助功能可以优化运动轨迹，并能提高软件的稳定性，以及自动查找优惠信息。是否仍要关闭？", "保持开启", "关闭辅助", onClickCallBack);
    }

    public static void close_remind() {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
        } else {
            r1.c().b();
        }
    }

    public static void customDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        q0.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void getGoodsWelfare(OnIndividuationCallBack onIndividuationCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
        } else {
            r1.c().a(onIndividuationCallBack);
        }
    }

    public static String getPluninId() {
        if (HelpShopAppUtil.getContext() != null) {
            return b.c().d();
        }
        Log.d("AcseHelpManager", "init sdk fail");
        return "";
    }

    private static String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null && activityManager.getRunningAppProcesses() != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isApkInDebug() {
        try {
            boolean z = (mContext.getApplicationInfo().flags & 2) != 0 && mContext.getPackageName().equals(l0.q);
            mIsDebug = z;
            return z;
        } catch (Exception unused) {
            return mIsDebug;
        }
    }

    public static boolean isOPenAccessiblityAndFlowWindowPermission() {
        if (HelpShopAppUtil.getContext() != null) {
            return !o1.c().f() || (b.c().e() && b.c().a());
        }
        Log.d("AcseHelpManager", "init sdk fail");
        return false;
    }

    public static boolean isOPenPermission() {
        if (o1.c().f()) {
            return b.c().e() && b.c().a();
        }
        return true;
    }

    public static boolean isOpenAccessiblityPermission() {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
            return false;
        }
        if (o1.c().f()) {
            return b.c().e();
        }
        return true;
    }

    private static void isShowRunningDialog(Activity activity, OnOpenPermission onOpenPermission) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        r1.c().a(activity, onOpenPermission);
    }

    public static boolean isTargetProcess(Application application) {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                new InitSdk().setContext(application).build();
            }
            return getProcessName(application).equals(".LoadingActivity");
        } catch (Exception unused) {
            return false;
        }
    }

    public static void lon_lat() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        new l1().h(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(i.a()).s5(new Consumer<String>() { // from class: com.acse.ottn.activity.AcseHelpManager.6
            @Override // com.acse.ottn.io.reactivex.functions.Consumer
            public void accept(String str) throws Exception {
            }
        }, new Consumer<Throwable>() { // from class: com.acse.ottn.activity.AcseHelpManager.7
            @Override // com.acse.ottn.io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
            }
        });
    }

    public static void openAccessiblityDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        q0.a(activity, "提示:", "需要启用辅助功能，才能为您一键开启必要权限。", "立即开启", "再想想", onClickCallBack);
    }

    public static void openAccessiblityView(Activity activity) {
        activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
    }

    public static void openBatteryPermission(Activity activity) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openFloatWindow(Activity activity) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivity(intent);
    }

    public static void openWithOneButton(final Activity activity, final int i, final OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        if (isOPenAccessiblityAndFlowWindowPermission()) {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("5");
            }
        } else {
            if (l0.l.equals(Boolean.valueOf(b.c().e()))) {
                openAccessiblityDialog(activity, new OnClickCallBack() { // from class: com.acse.ottn.activity.AcseHelpManager.5
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onClose() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = onCurrentStateCallBack;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("02");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onDismiss() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = onCurrentStateCallBack;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState("03");
                        }
                    }

                    @Override // com.acse.ottn.activity.AcseHelpManager.OnClickCallBack
                    public void onOpen() {
                        OnCurrentStateCallBack onCurrentStateCallBack2 = onCurrentStateCallBack;
                        if (onCurrentStateCallBack2 != null) {
                            onCurrentStateCallBack2.onState(HiAnalyticsConstant.KeyAndValue.NUMBER_01);
                        }
                        AcseHelpManager.setGoodsWelfare(l0.k);
                        AcseHelpManager.startAccessibilityIntroduceActivityForResult(activity, i);
                    }
                });
                return;
            }
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("4");
            }
            startAccessibilityIntroduceActivityForResult(activity, i);
        }
    }

    private static void running(Activity activity, boolean z, boolean z2, OnCurrentStateCallBack onCurrentStateCallBack) {
        isShowRunningDialog(activity, new AnonymousClass3(z2, activity, onCurrentStateCallBack, z));
    }

    public static void setGoodsWelfare(String str) {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
        } else {
            r1.c().a(str);
        }
    }

    public static void setOpenWithOneButtonColorState(Activity activity, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        try {
            if (!b.c().e() || !b.c().a()) {
                activity.startService(new Intent(activity, (Class<?>) StartProcreeService.class));
            }
        } catch (Throwable unused) {
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("0");
            }
        } else if (isOPenAccessiblityAndFlowWindowPermission()) {
            if (onCurrentStateCallBack != null) {
                onCurrentStateCallBack.onState("0");
            }
        } else if (onCurrentStateCallBack != null) {
            onCurrentStateCallBack.onState("1");
        }
    }

    public static void showFrequentOperationDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
            j4.a(activity, onClickCallBack);
        } else {
            c5.a(activity, onClickCallBack);
        }
    }

    public static void showRunningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
            new InitSdk().setContext(activity.getApplication()).build();
        }
        if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
            i4.a(activity, onClickCallBack);
        } else {
            w3.a(activity, onClickCallBack);
        }
    }

    public static void showWarningDialog(Activity activity, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
            j4.a(activity, onClickCallBack);
        } else {
            c5.a(activity, onClickCallBack);
        }
    }

    public static void startAccessibilityIntroduceActivityForResult(Activity activity, int i) {
        if (p4.b().equals("vivo") && Build.VERSION.SDK_INT >= 36 && n3.a().a("vivo_auto_start")) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) AccessibiltyVivoPermissionGreenActivity.class), i);
        } else {
            activity.startActivityForResult(new Intent(activity, (Class<?>) AccessibiltyTsnPermissionGreenActivity.class), i);
        }
    }

    public static void startRunning(Activity activity, boolean z, boolean z2, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        running(activity, z, z2, onCurrentStateCallBack);
    }

    public static void syncUserIdState(String str, String str2) {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
        } else {
            b.c().a(str);
            b.c().a(str, str2);
        }
    }

    private AcseHelpManager(InitSdk initSdk) {
        mContext = initSdk.f22844a;
    }

    public static void closeAccessiblityPlugIn(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        q0.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static void getGoodsWelfare(Activity activity, OnIndividuationCallBack onIndividuationCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        r1.c().a(onIndividuationCallBack);
    }

    public static String getPluninId(Activity activity) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        return b.c().d();
    }

    public static void isOPenPermission(Activity activity, final OnOpenPermission onOpenPermission) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        isShowRunningDialog(activity, new OnOpenPermission() { // from class: com.acse.ottn.activity.AcseHelpManager.1
            @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
            public void openPermission(boolean z) {
                if (!z) {
                    onOpenPermission.openPermission(true);
                } else if (o1.c().f()) {
                    onOpenPermission.openPermission(b.c().e() && b.c().a());
                } else {
                    onOpenPermission.openPermission(true);
                }
            }
        });
    }

    public static void setGoodsWelfare(Activity activity, String str) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        r1.c().a(str);
    }

    public static void startRunning(Activity activity, boolean z, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        running(activity, z, false, onCurrentStateCallBack);
    }

    public static void syncUserIdState(Activity activity, String str, String str2) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        b.c().a(str);
        b.c().a(str, str2);
    }

    public static void showWarningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        c5.a(activity, str, str2, str3, str4, onClickCallBack);
    }

    public static String getGoodsWelfare() {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
            return "1";
        }
        return o1.c().a();
    }

    public static void isOPenPermission(final OnOpenPermission onOpenPermission) {
        if (HelpShopAppUtil.getContext() == null) {
            return;
        }
        isShowRunningDialog(null, new OnOpenPermission() { // from class: com.acse.ottn.activity.AcseHelpManager.2
            @Override // com.acse.ottn.activity.AcseHelpManager.OnOpenPermission
            public void openPermission(boolean z) {
                if (!z) {
                    onOpenPermission.openPermission(true);
                } else if (o1.c().f()) {
                    onOpenPermission.openPermission(b.c().e() && b.c().a());
                } else {
                    onOpenPermission.openPermission(true);
                }
            }
        });
    }

    public static void showRunningDialog(Activity activity, String str, String str2, String str3, String str4, OnClickCallBack onClickCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            w3.a(activity, onClickCallBack);
        } else {
            i4.a(activity, onClickCallBack);
        }
    }

    public static void startRunning(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, OnCurrentStateCallBack onCurrentStateCallBack) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        isShowRunningDialog(activity, new AnonymousClass4(activity, str, str2, str3, str4, onCurrentStateCallBack, z, str5, str6, str7, str8));
    }

    public static void syncUserIdState(String str) {
        if (HelpShopAppUtil.getContext() == null) {
            Log.d("AcseHelpManager", "init sdk fail");
        } else {
            syncUserIdState(str, "0");
        }
    }

    public static void syncUserIdState(Activity activity, String str) {
        if (HelpShopAppUtil.getContext() == null) {
            new InitSdk().setContext(activity.getApplication()).build();
        }
        syncUserIdState(str, "0");
    }
}
