package com.kc.bw;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.kc.bw.appsdkdex.SdkStatus;
import com.kc.bw.appsdkdex.WMAdSdk;
import com.kc.bw.common.IAdLoader;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.common.utils.ThreadUtils;
import com.kc.bw.common.utils.Utils;
import com.kc.bw.common.utils.WMResources;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class dexe {
    public static IAdLoader dexa;

    @Keep
    public class dexa implements Runnable {
        public final Context dexa;
        public final String dexb;
        public final dexb dexc;

        public dexa(Context context, String str, dexb dexbVar) {
            this.dexa = context;
            this.dexb = str;
            this.dexc = dexbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            dexe.dexb(this.dexa, this.dexb, this.dexc);
        }
    }

    @Keep
    public interface dexb {
        void onFailed(String str);

        void onLoaded(IAdLoader iAdLoader);
    }

    public static String dexa(Context context) {
        try {
            String strDexc = dexl.dexc(context);
            if (TextUtils.isEmpty(strDexc)) {
                DebugLog.loadPlugin_e(dexg.dexa("sft!qbui!jowbmje"));
                return "";
            }
            File file = new File(strDexc, dexg.dexa("xnefwdbm`8/8/25/21"));
            if (!file.exists()) {
                DebugLog.loadPlugin_e(dexg.dexa("msft!gjmf!jowbmje!"));
                return "";
            }
            File file2 = new File(strDexc, dexg.dexa("xnefw`8/8/25/21"));
            if (!file2.exists()) {
                DebugLog.loadPlugin(dexg.dexa("igsft!gjmf!jowbmje!"));
                return file.getAbsolutePath();
            }
            PackageInfo apkPackageInfo = Utils.getApkPackageInfo(context, file2.getAbsolutePath());
            if (apkPackageInfo == null) {
                DebugLog.loadPlugin(dexg.dexa("igsft!qbdlbhf!jowbmje!"));
                return file.getAbsolutePath();
            }
            PackageInfo apkPackageInfo2 = Utils.getApkPackageInfo(context, file.getAbsolutePath());
            if (apkPackageInfo2 != null) {
                return TextUtils.equals(dexl.dexa(apkPackageInfo2.versionName, apkPackageInfo.versionName), apkPackageInfo2.versionName) ? file.getAbsolutePath() : file2.getAbsolutePath();
            }
            DebugLog.loadPlugin_e(dexg.dexa("msft!qbdlbhf!jowbmje"));
            return "";
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(dexg.dexa("dsft!qbui!jowbmje!") + th);
            ReportUtils.exReport(context, 999967, dexg.dexa("痈強鰼懚楲鵦"), dexg.dexa("hfu!dvssfou!vtf!efy!qbui!gbjm!") + th);
            return "";
        }
    }

    public static void dexa() {
        dexa = null;
        DebugLog.loadPlugin(dexg.dexa("dmfbs!jotubodf!"));
    }

    public static void dexa(final Context context, final dexb dexbVar) {
        try {
            DebugLog.loadPlugin(dexg.dexa("mpbe!sft!"));
            String strDexa = dexa(context);
            if (TextUtils.isEmpty(strDexa)) {
                DebugLog.loadPlugin_e(dexg.dexa("dsft!qbui!jowbmje!"));
                ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), dexg.dexa("mpbeEfy!gbjm-dvssfouEfyGjmfQbui!jt!ovmm"));
                return;
            }
            final File file = new File(strDexa);
            if (!file.exists()) {
                String strDexa2 = dexg.dexa("mpbeEfy!gbjm-dvssfouEfyGjmf!epft!opu!fyjtu");
                DebugLog.loadPlugin_e(dexg.dexa("dsft!gjmf!jowbmje!"));
                ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa2);
                return;
            }
            try {
                Utils.setFileReadOnly(file, context);
                try {
                    dexa = (IAdLoader) new DexClassLoader(file.getAbsolutePath(), context.getDir(dexg.dexa("efy"), 0).getAbsolutePath(), context.getApplicationInfo().nativeLibraryDir, context.getClassLoader()).loadClass(dexg.dexa("dpn/ld/cx/be/efy/bmmnpevmft/BeMpbefs")).getConstructor(Context.class).newInstance(context);
                    DebugLog.loadPlugin(dexg.dexa("beMpbe!jotubodf!"));
                    try {
                        final AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                        final Method method = assetManager.getClass().getMethod(dexg.dexa("beeBttfuQbui"), String.class);
                        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        final Configuration configuration = context.getResources().getConfiguration();
                        ThreadUtils.runOnUIThread(new Runnable(method, assetManager, file, displayMetrics, configuration, dexbVar, context) { // from class: com.kc.bw.dexe$$ExternalSyntheticLambda0
                            public final Method f$0;
                            public final AssetManager f$1;
                            public final File f$2;
                            public final DisplayMetrics f$3;
                            public final Configuration f$4;
                            public final dexe.dexb f$5;
                            public final Context f$6;

                            {
                                this.f$0 = method;
                                this.f$1 = assetManager;
                                this.f$2 = file;
                                this.f$3 = displayMetrics;
                                this.f$4 = configuration;
                                this.f$5 = dexbVar;
                                this.f$6 = context;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                dexe.dexa(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
                            }
                        });
                    } catch (Throwable th) {
                        String str = dexg.dexa("BeBttfu!cvjme!gbjm-") + Log.getStackTraceString(th);
                        DebugLog.loadPlugin_e(str);
                        ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), str);
                    }
                } catch (Throwable th2) {
                    String str2 = dexg.dexa("BeMpbefs!cvjme!gbjm-") + Log.getStackTraceString(th2);
                    DebugLog.loadPlugin_e(str2);
                    ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), str2);
                }
            } catch (Throwable th3) {
                String str3 = dexg.dexa("BeDmbttMpbefs!cvjme!gbjm-") + Log.getStackTraceString(th3);
                DebugLog.loadPlugin_e(str3);
                ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), str3);
            }
        } catch (Throwable th4) {
            String str4 = dexg.dexa("mpbeEfy!gbjm-") + Log.getStackTraceString(th4);
            DebugLog.loadPlugin_e(str4);
            ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), str4);
        }
    }

    public static void dexa(Context context, String str, dexb dexbVar) {
        if (ThreadUtils.isUIThread(dexg.dexa("cvjmeBeMpbefs"))) {
            ThreadUtils.runOnThreadPool(new dexa(context, str, dexbVar));
        } else {
            dexb(context, str, dexbVar);
        }
    }

    public static /* synthetic */ void dexa(dexb dexbVar, Context context) {
        DebugLog.loadPlugin(dexg.dexa("beMpbe!cvjme!epof!"));
        if (dexbVar != null) {
            dexbVar.onLoaded(dexa);
            return;
        }
        String strDexa = dexg.dexa("dbmmcbdl!poMpbefe!gbjm-JJBeMpbefsDbmmcbdl!jt!ovmm");
        DebugLog.loadPlugin_e(strDexa);
        ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), strDexa);
    }

    public static /* synthetic */ void dexa(Method method, AssetManager assetManager, File file, DisplayMetrics displayMetrics, Configuration configuration, final dexb dexbVar, final Context context) {
        try {
            DebugLog.loadPlugin(dexg.dexa("bee!bttfut!!"));
            method.invoke(assetManager, file.getAbsolutePath());
            WMResources.resources = new Resources(assetManager, displayMetrics, configuration);
            DebugLog.loadPlugin(dexg.dexa("sft!cvjme!epof!"));
            ThreadUtils.runOnThreadPool(new Runnable(dexbVar, context) { // from class: com.kc.bw.dexe$$ExternalSyntheticLambda1
                public final dexe.dexb f$0;
                public final Context f$1;

                {
                    this.f$0 = dexbVar;
                    this.f$1 = context;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    dexe.dexa(this.f$0, this.f$1);
                }
            });
        } catch (Throwable th) {
            String str = dexg.dexa("BeSftpvsdft!cvjme!gbjm-") + Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(str);
            ReportUtils.exReport(context, 200022, dexg.dexa("��撋鰸粃楲鵦"), str);
        }
    }

    public static void dexb(Context context, String str, dexb dexbVar) {
        try {
            if (dexa != null) {
                DebugLog.loadPlugin(dexg.dexa("beMpbe!sfbez!"));
                if (dexbVar != null) {
                    dexbVar.onLoaded(dexa);
                    return;
                }
                return;
            }
            if (WMAdSdk.getSdkStatus() == SdkStatus.INITIALIZED) {
                synchronized (IAdLoader.class) {
                    try {
                        if (dexa == null) {
                            dexa(context, dexbVar);
                        } else {
                            DebugLog.loadPlugin(dexg.dexa("beMpbe!sfbez!"));
                            if (dexbVar != null) {
                                dexbVar.onLoaded(dexa);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            String str2 = dexg.dexa("tel!opu!jojujbmj{fe)") + ConstantInfo.sdkInitStartTime + dexg.dexa(c49.f40900a) + (Utils.getElapsedRealTime() - ConstantInfo.sdkInitStartTime) + dexg.dexa("*");
            if (dexbVar != null) {
                dexbVar.onFailed(str2);
            }
            ReportUtils.exReport(context, str, 200022, dexg.dexa("��撋鰸粃楲鵦"), str2);
        } catch (Throwable th2) {
            String str3 = dexg.dexa("epCvjmeBeMpbefs!gbjm!") + Log.getStackTraceString(th2);
            DebugLog.loadPlugin_e(str3);
            ReportUtils.exReport(context, str, 200022, dexg.dexa("��撋鰸粃楲鵦"), str3);
        }
    }
}
