package cj.mobile.wm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import cj.mobile.wm.appsdkdex.SdkStatus;
import cj.mobile.wm.appsdkdex.WMAdSdk;
import cj.mobile.wm.common.IAdLoader;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.common.utils.ThreadUtils;
import cj.mobile.wm.common.utils.Utils;
import cj.mobile.wm.common.utils.WMResources;
import cj.mobile.wm.dexa;
import com.zj.adlib.c49;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexa {
    public static IAdLoader dexa;

    /* JADX INFO: renamed from: cj.mobile.wm.dexa$dexa, reason: collision with other inner class name */
    public class RunnableC0082dexa implements Runnable {
        public final /* synthetic */ Context dexa;
        public final /* synthetic */ String dexb;
        public final /* synthetic */ dexb dexc;

        public RunnableC0082dexa(Context context, String str, dexb dexbVar) {
            this.dexa = context;
            this.dexb = str;
            this.dexc = dexbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            dexa.dexb(this.dexa, this.dexb, this.dexc);
        }
    }

    public interface dexb {
        void onFailed(String str);

        void onLoaded(IAdLoader iAdLoader);
    }

    public static void dexa(Context context, String str, dexb dexbVar) {
        if (ThreadUtils.isUIThread(dexc.dexa("cvjmeBeMpbefs"))) {
            ThreadUtils.runOnThreadPool(new RunnableC0082dexa(context, str, dexbVar));
        } else {
            dexb(context, str, dexbVar);
        }
    }

    public static void dexb(Context context, String str, dexb dexbVar) {
        try {
            if (dexa != null) {
                DebugLog.loadPlugin(dexc.dexa("beMpbe!sfbez!"));
                if (dexbVar != null) {
                    dexbVar.onLoaded(dexa);
                    return;
                }
                return;
            }
            if (WMAdSdk.getSdkStatus() == SdkStatus.INITIALIZED) {
                synchronized (IAdLoader.class) {
                    if (dexa == null) {
                        dexa(context, dexbVar);
                    } else {
                        DebugLog.loadPlugin(dexc.dexa("beMpbe!sfbez!"));
                        if (dexbVar != null) {
                            dexbVar.onLoaded(dexa);
                        }
                    }
                }
                return;
            }
            String str2 = dexc.dexa("tel!opu!jojujbmj{fe)") + ConstantInfo.sdkInitStartTime + dexc.dexa(c49.f40900a) + (Utils.getElapsedRealTime() - ConstantInfo.sdkInitStartTime) + dexc.dexa("*");
            if (dexbVar != null) {
                dexbVar.onFailed(str2);
            }
            ReportUtils.exReport(context, str, 200022, dexc.dexa("��撋鰸粃楲鵦"), str2);
        } catch (Throwable th) {
            String str3 = dexc.dexa("epCvjmeBeMpbefs!gbjm!") + Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(str3);
            ReportUtils.exReport(context, str, 200022, dexc.dexa("��撋鰸粃楲鵦"), str3);
        }
    }

    public static void dexa(final Context context, final dexb dexbVar) {
        try {
            DebugLog.loadPlugin(dexc.dexa("mpbe!qmh!"));
            String strDexa = dexa(context);
            if (TextUtils.isEmpty(strDexa)) {
                DebugLog.loadPlugin_e(dexc.dexa("dqmh!qbui!jowbmje!"));
                ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), dexc.dexa("mpbeEfy!gbjm-dvssfouEfyGjmfQbui!jt!ovmm"));
                return;
            }
            final File file = new File(strDexa);
            if (!file.exists()) {
                String strDexa2 = dexc.dexa("mpbeEfy!gbjm-dvssfouEfyGjmf!epft!opu!fyjtu");
                DebugLog.loadPlugin_e(dexc.dexa("dqmh!gjmf!jowbmje!"));
                ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa2);
                return;
            }
            try {
                Utils.setFileReadOnly(file, context);
                try {
                    dexa = (IAdLoader) new DexClassLoader(file.getAbsolutePath(), context.getDir(dexc.dexa("efy"), 0).getAbsolutePath(), context.getApplicationInfo().nativeLibraryDir, context.getClassLoader()).loadClass(dexc.dexa("dk/npcjmf/xn/be/efy/bmmnpevmft/BeMpbefs")).getConstructor(Context.class).newInstance(context);
                    DebugLog.loadPlugin(dexc.dexa("beMpbe!jotubodf!"));
                    try {
                        final AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                        final Method method = assetManager.getClass().getMethod(dexc.dexa("beeBttfuQbui"), String.class);
                        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        final Configuration configuration = context.getResources().getConfiguration();
                        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.zj.adlib.rva
                            @Override // java.lang.Runnable
                            public final void run() {
                                dexa.dexa(method, assetManager, file, displayMetrics, configuration, dexbVar, context);
                            }
                        });
                    } catch (Throwable th) {
                        String str = dexc.dexa("BeBttfu!cvjme!gbjm-") + Log.getStackTraceString(th);
                        DebugLog.loadPlugin_e(str);
                        ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), str);
                    }
                } catch (Throwable th2) {
                    String str2 = dexc.dexa("BeMpbefs!cvjme!gbjm-") + Log.getStackTraceString(th2);
                    DebugLog.loadPlugin_e(str2);
                    ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), str2);
                }
            } catch (Throwable th3) {
                String str3 = dexc.dexa("BeDmbttMpbefs!cvjme!gbjm-") + Log.getStackTraceString(th3);
                DebugLog.loadPlugin_e(str3);
                ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), str3);
            }
        } catch (Throwable th4) {
            String str4 = dexc.dexa("mpbeEfy!gbjm-") + Log.getStackTraceString(th4);
            DebugLog.loadPlugin_e(str4);
            ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), str4);
        }
    }

    public static /* synthetic */ void dexa(Method method, AssetManager assetManager, File file, DisplayMetrics displayMetrics, Configuration configuration, final dexb dexbVar, final Context context) {
        try {
            DebugLog.loadPlugin(dexc.dexa("bee!bttfut!!"));
            method.invoke(assetManager, file.getAbsolutePath());
            WMResources.resources = new Resources(assetManager, displayMetrics, configuration);
            DebugLog.loadPlugin(dexc.dexa("sft!cvjme!epof!"));
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.qva
                @Override // java.lang.Runnable
                public final void run() {
                    dexa.dexa(dexbVar, context);
                }
            });
        } catch (Throwable th) {
            String str = dexc.dexa("BeSftpvsdft!cvjme!gbjm-") + Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(str);
            ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), str);
        }
    }

    public static /* synthetic */ void dexa(dexb dexbVar, Context context) {
        DebugLog.loadPlugin(dexc.dexa("beMpbe!cvjme!epof!"));
        if (dexbVar != null) {
            dexbVar.onLoaded(dexa);
            return;
        }
        String strDexa = dexc.dexa("dbmmcbdl!poMpbefe!gbjm-JJBeMpbefsDbmmcbdl!jt!ovmm");
        DebugLog.loadPlugin_e(strDexa);
        ReportUtils.exReport(context, 200022, dexc.dexa("��撋鰸粃楲鵦"), strDexa);
    }

    public static void dexa() {
        dexa = null;
        DebugLog.loadPlugin(dexc.dexa("dmfbs!jotubodf!"));
    }

    public static String dexa(Context context) {
        try {
            String strDexd = dexh.dexd(context);
            if (TextUtils.isEmpty(strDexd)) {
                DebugLog.loadPlugin_e(dexc.dexa("qmh!qbui!jowbmje"));
                return "";
            }
            File file = new File(strDexd, dexc.dexa("xnefwdbm`8/:/29/31"));
            if (!file.exists()) {
                DebugLog.loadPlugin_e(dexc.dexa("mqmh!gjmf!jowbmje!"));
                return "";
            }
            File file2 = new File(strDexd, dexc.dexa("xnefw`8/:/29/31"));
            if (!file2.exists()) {
                DebugLog.loadPlugin(dexc.dexa("iqmh!gjmf!jowbmje!"));
                return file.getAbsolutePath();
            }
            PackageInfo apkPackageInfo = Utils.getApkPackageInfo(context, file2.getAbsolutePath());
            if (apkPackageInfo == null) {
                DebugLog.loadPlugin(dexc.dexa("iqmh!qbdlbhf!jowbmje!"));
                return file.getAbsolutePath();
            }
            PackageInfo apkPackageInfo2 = Utils.getApkPackageInfo(context, file.getAbsolutePath());
            if (apkPackageInfo2 == null) {
                DebugLog.loadPlugin_e(dexc.dexa("mqmh!qbdlbhf!jowbmje"));
                return "";
            }
            if (TextUtils.equals(dexh.dexa(apkPackageInfo2.versionName, apkPackageInfo.versionName), apkPackageInfo2.versionName)) {
                return file.getAbsolutePath();
            }
            return file2.getAbsolutePath();
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(dexc.dexa("dqmh!qbui!jowbmje!") + th);
            ReportUtils.exReport(context, 999967, dexc.dexa("痈強鰼懚楲鵦"), dexc.dexa("hfu!dvssfou!vtf!efy!qbui!gbjm!") + th);
            return "";
        }
    }
}
