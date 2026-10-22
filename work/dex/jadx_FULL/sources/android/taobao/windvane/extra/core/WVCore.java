package android.taobao.windvane.extra.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.taobao.windvane.base.IUCService;
import android.taobao.windvane.base.j;
import android.taobao.windvane.base.m;
import android.taobao.windvane.base.n;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.annotation.Keep;
import com.igexin.assist.sdk.AssistPushConsts;
import com.taobao.uc.UCSoSettings;
import com.uc.webview.export.WebView;
import com.uc.webview.export.business.BusinessWrapper;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCMRunningInfo;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.utility.SetupTask;
import com.zj.adlib.u15;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@SuppressLint({"NewApi"})
public class WVCore {
    private static final String c = "WVCore";
    private static int d = 3;
    private static WVCore i;
    private static AtomicBoolean j = new AtomicBoolean(false);
    private static AtomicBoolean k = new AtomicBoolean(false);
    private int e = 0;
    private String f = UCSoSettings.getInstance().UC_CORE_URL_DEBUG_32;
    private IUCService<android.taobao.windvane.extra.core.b> h = (IUCService) m.a().b(IUCService.class);
    private boolean l = false;
    private android.taobao.windvane.extra.core.a m = null;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private int q = -1;
    private boolean r = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f21226a = 0;
    int b = 0;
    private android.taobao.windvane.base.b g = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);

    public class a implements ValueCallback<SetupTask> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f21229a;

        public a(long j) {
            this.f21229a = j;
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(SetupTask setupTask) {
            Application application = GlobalConfig.context;
            if (application == null) {
                return;
            }
            WVCore.this.a(application, this.f21229a);
        }
    }

    public final class b implements UCCore.Callable<Boolean, Bundle> {
        private Context b;

        public b(Context context) {
            this.b = context.getApplicationContext();
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Bundle bundle) {
            TaoLog.d(WVCore.c, "decompress parameters:" + bundle);
            android.taobao.windvane.extra.c.a aVar = new android.taobao.windvane.extra.c.a(this.b.getCacheDir() + "/.taobaoDec7zSo.lock");
            try {
                try {
                    aVar.a();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.b.getDir("h5container", 0);
                    if (WVCore.this.m()) {
                        TaoLog.d(WVCore.c, "init on main process, mark uc not init!");
                    }
                    boolean zExtractWebCoreLibraryIfNeeded = UCCore.extractWebCoreLibraryIfNeeded(this.b, bundle.getString("zipFilePath"), bundle.getString("zipFileType"), bundle.getString("decDirPath"), bundle.getBoolean("deleteAfterExtract"));
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    TaoLog.d(WVCore.c, "taobaoDec7zSo elapse " + jCurrentTimeMillis2);
                    Boolean boolValueOf = Boolean.valueOf(zExtractWebCoreLibraryIfNeeded);
                    aVar.b();
                    return boolValueOf;
                } catch (Exception e) {
                    TaoLog.e(WVCore.c, "catch exception ", e, new Object[0]);
                    throw e;
                }
            } catch (Throwable th) {
                aVar.b();
                throw th;
            }
        }
    }

    public static class c implements Callable<Boolean> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            String strC = WVCore.c(GlobalConfig.context);
            IUCService iUCService = (IUCService) m.a().b(IUCService.class);
            boolean z = true;
            boolean z2 = iUCService != null && iUCService.open4GDownload();
            if (!z2 && !TextUtils.equals("wifi", strC)) {
                z = false;
            }
            if (z) {
                TaoLog.i("UCCore", "start download u4 core,is4G=[" + z2 + "]");
            } else {
                WVCore.j.set(false);
                WVCore.k.set(false);
                TaoLog.e("UCCore", "current env cannot download u4 core");
            }
            return Boolean.valueOf(z);
        }
    }

    public class d implements ValueCallback<SetupTask> {
        private d() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(SetupTask setupTask) {
            try {
                if (setupTask.getException() != null) {
                    StringWriter stringWriter = new StringWriter();
                    setupTask.getException().printStackTrace(new PrintWriter(stringWriter));
                    TaoLog.e(WVCore.c, "UC ExceptionValueCallback : " + stringWriter.toString());
                }
            } catch (Throwable th) {
                TaoLog.e(WVCore.c, "UC ExceptionValueCallback Throwable : " + th.getMessage());
            }
        }
    }

    public final class e implements UCCore.Callable<Boolean, String> {
        private e() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(String str) {
            TaoLog.i(WVCore.c, "version callable value:" + str);
            return Boolean.valueOf(WVCore.this.b(str));
        }
    }

    public class f implements ValueCallback<Bundle> {
        private f() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(Bundle bundle) {
            TaoLog.i(WVCore.c, "on init start:[" + bundle + "]");
            if (bundle == null || "bit_by_old_dex_dir".equals(bundle.getString("bo_init_type"))) {
                return;
            }
            boolean z = false;
            SetupTask upVar = UCCore.setup("webview_multi_process", Integer.valueOf((!WVCore.this.m() || WVCore.this.g == null) ? 0 : WVCore.this.g.c().ucMultiPolicy)).setup("webview_multi_process_fallback_timeout", Integer.valueOf(WVCore.this.g == null ? 8000 : WVCore.this.g.c().ucMultiTimeOut));
            if (WVCore.this.g != null && WVCore.this.g.c().ucMultiServiceSpeedUp) {
                z = true;
            }
            upVar.setup("webview_multi_process_enable_service_speedup", Boolean.valueOf(z));
        }
    }

    public final class g implements ValueCallback<SetupTask> {
        private g() {
        }

        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(SetupTask setupTask) {
            if (WVCore.this.m != null) {
                WVCore.this.m.a();
            }
            android.taobao.windvane.b.g.a().a(3017);
            TaoLog.i(WVCore.c, "SwitchValueCallback: " + WebView.getCoreType());
            if (WVCore.c().l || WebView.getCoreType() != 3) {
                if (WebView.getCoreType() == 2) {
                    WVCore.c().l = false;
                    TaoLog.i(WVCore.c, "SwitchValueCallback isUCSDKSupport = false");
                    return;
                }
                return;
            }
            WVCore.c().l = true;
            TaoLog.i(WVCore.c, "SwitchValueCallback isUCSDKSupport = true");
            if (WVCore.this.m != null) {
                WVCore.this.m.b();
            }
            android.taobao.windvane.b.g.a().a(3016);
            if (GlobalConfig.getInstance().needSpeed()) {
                return;
            }
            WVCore.this.d();
        }
    }

    private WVCore() {
    }

    private void k() {
        IUCService<android.taobao.windvane.extra.core.b> iUCService;
        IUCService<android.taobao.windvane.extra.core.b> iUCService2;
        int iGpuMultiType = 0;
        int iRenderMultiType = (m() || (iUCService2 = this.h) == null) ? 0 : iUCService2.renderMultiType();
        this.f21226a = iRenderMultiType;
        if (iRenderMultiType != 0 && (iUCService = this.h) != null) {
            iGpuMultiType = iUCService.gpuMultiType();
        }
        this.b = iGpuMultiType;
        TaoLog.i(c, " renderMultiPolicy: " + this.f21226a + "; gpuMultiPolicy: " + this.b);
    }

    private void l() {
        android.taobao.windvane.base.b bVar = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);
        if (bVar == null || "{}".equals(bVar.c().ucParam)) {
            TaoLog.i(c, "no uc config");
            return;
        }
        android.taobao.windvane.extra.core.b bVarA = android.taobao.windvane.extra.core.b.a().a(bVar.c().ucParam);
        if (bVarA == null || !bVar.c().enableUcShareCore || (!bVarA.b() && !android.taobao.windvane.extra.core.b.c())) {
            TaoLog.w(c, "not taobao, or shared core disabled by config, or uc param is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (bVarA.b() && TextUtils.isEmpty(bVarA.c) && TextUtils.equals("wifi", c(GlobalConfig.context))) {
                bVarA.c = "sc_lshco";
                bVarA.h = "1";
            }
            if (!TextUtils.isEmpty(bVarA.h)) {
                jSONObject.put("sc_ustwm", bVarA.h);
            }
            if (bVarA.b() && bVarA.d()) {
                jSONObject.put("sc_ta_fp", bVarA.f21235a);
                jSONObject.put("sc_cpy", bVarA.d);
                jSONObject.put("sc_hucmv", bVarA.b);
                jSONObject.put("sc_udst", bVarA.g);
            }
            if (bVarA.e()) {
                jSONObject.put("sc_ta_fp", bVarA.f21235a);
                jSONObject.put("sc_taucmv", bVarA.e);
                jSONObject.put("sc_ldpl", bVarA.c);
                jSONObject.put("sc_pkgl", bVarA.f);
            }
            String str = "JSON_CMD" + jSONObject.toString();
            TaoLog.d(c, str);
            UCCore.setParam(str);
        } catch (Throwable th) {
            TaoLog.w(c, "failed to setup uc param", th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        boolean zIsMainProcess = CommonUtils.isMainProcess();
        TaoLog.i(c, "是否在主进程:" + zIsMainProcess);
        return zIsMainProcess;
    }

    private String n() {
        if (m()) {
            return "0";
        }
        int i2 = 1;
        while (true) {
            if (CommonUtils.getProcessName().equalsIgnoreCase(GlobalConfig.context.getPackageName() + ":wml" + Integer.toString(i2))) {
                return Integer.toString(i2);
            }
            int i3 = i2 + 1;
            if (i2 > 10) {
                throw new RuntimeException(String.format("%s getMultiProcessPrivateDataDirectorySuffix failure!Subprocess name: %s illegal.", c, CommonUtils.getProcessName()));
            }
            i2 = i3;
        }
    }

    public boolean f() {
        return j.get();
    }

    public String g() {
        IUCService<android.taobao.windvane.extra.core.b> iUCService = this.h;
        if (iUCService == null) {
            TaoLog.e(c, "no uc service, cannot use v8");
            return "";
        }
        if (iUCService.getCorePolicy() != 0) {
            String strC = c(UCCore.getExtractDirPathByUrl(GlobalConfig.context, this.f));
            TaoLog.i(c, "get v8 path by download so, path=[" + strC + "]");
            return strC;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UCCore.getExtractDirPath(GlobalConfig.context, GlobalConfig.context.getApplicationInfo().nativeLibraryDir + WVNativeCallbackUtil.SEPERATER + "libkernelu4_7z_uc.so"));
        sb.append("/lib/libwebviewuc.so");
        String string = sb.toString();
        TaoLog.i(c, "get v8 path by inner so, path=[" + string + "]");
        return string;
    }

    @Keep
    public void initUCCore() {
        if (this.e >= d || GlobalConfig.context == null || GlobalConfig.getInstance().getUcsdkappkeySec() == null) {
            int i2 = this.e;
            if (i2 < d) {
                this.e = i2 + 1;
            }
            if (GlobalConfig.context == null) {
                TaoLog.e(c, "error contex = null");
                return;
            } else {
                if (GlobalConfig.getInstance().getUcsdkappkeySec() == null) {
                    TaoLog.e(c, "error uc key = null");
                    return;
                }
                return;
            }
        }
        android.taobao.windvane.base.b bVar = this.g;
        if (bVar != null) {
            bVar.b();
        }
        if (!j.compareAndSet(false, true)) {
            TaoLog.i(c, "uc core has been initialized");
            return;
        }
        if (GlobalConfig.getInstance().getInjectCode() == -1) {
            GlobalConfig.getInstance().setInjectCode(2);
        }
        try {
            boolean zA = android.taobao.windvane.extra.c.c.a();
            if (!zA && android.taobao.windvane.extra.c.c.a("x86")) {
                ConfigStorage.putLongVal(android.taobao.windvane.extra.c.c.f21225a, android.taobao.windvane.extra.c.c.b, 1L);
                this.f = UCSoSettings.getInstance().UC_CORE_URL_DEBUG_X86;
                TaoLog.i(c, "UCCore use x86 core");
            } else if (EnvUtil.isAppDebug()) {
                this.f = zA ? UCSoSettings.getInstance().UC_CORE_URL_DEBUG_64 : UCSoSettings.getInstance().UC_CORE_URL_DEBUG_32;
                TaoLog.i(c, "use 3.0 debug core, use 64bit = [" + zA + "]");
            } else {
                this.f = zA ? UCSoSettings.getInstance().UC_CORE_URL_64 : UCSoSettings.getInstance().UC_CORE_URL_32;
                TaoLog.i(c, "use 3.0 release core, use 64bit = [" + zA + "]");
            }
        } catch (Exception unused) {
        }
        try {
            k.set(true);
            TaoLog.i(c, "initApi uclib inner");
            GlobalConfig globalConfig = GlobalConfig.getInstance();
            if (globalConfig != null) {
                a(globalConfig.getUcsdkappkeySec(), GlobalConfig.context);
            } else {
                a((String[]) null, GlobalConfig.context);
            }
        } catch (Throwable unused2) {
            b(GlobalConfig.context);
        }
        TaoLog.i(c, "static UCCore:" + this.f);
    }

    public static WVCore c() {
        if (i == null) {
            synchronized (WVCore.class) {
                if (i == null) {
                    i = new WVCore();
                }
            }
        }
        return i;
    }

    private String d(Context context) {
        String stringVal = ConfigStorage.getStringVal("WindVane", "UC_PATH");
        TaoLog.i(c, "get dex path:[" + stringVal + "]");
        return stringVal;
    }

    private String e(Context context) {
        return UCCore.getExtractRootDirPath(context);
    }

    public String b() {
        return this.f;
    }

    public boolean e() {
        return this.l;
    }

    public boolean b(Context context) {
        if (k.get()) {
            if (context == null) {
                TaoLog.e(c, "context must be inited before init UC");
                return false;
            }
            return a((String[]) null, context.getApplicationContext());
        }
        RuntimeException runtimeException = new RuntimeException("initApi uclib outer");
        runtimeException.fillInStackTrace();
        TaoLog.e(c, runtimeException.getStackTrace()[0].toString() + "\n" + runtimeException.getStackTrace()[1].toString() + "\n" + runtimeException.getStackTrace()[2].toString());
        return false;
    }

    public void d() {
        if (this.n) {
            return;
        }
        try {
            TaoLog.d(c, "start to set ServiceWorker client");
            n nVar = (n) m.a().b(n.class);
            if (nVar != null) {
                nVar.b();
            }
            this.n = true;
        } catch (Throwable unused) {
            this.n = false;
            TaoLog.w(c, "failed to set ServiceWorker client");
        }
    }

    public int a() {
        return this.q;
    }

    public void a(android.taobao.windvane.extra.core.a aVar) {
        this.m = aVar;
    }

    public boolean a(Context context) {
        return this.r;
    }

    public boolean c(String[] strArr, Context context, Object[] objArr) {
        SetupTask upVar;
        try {
            if (!TextUtils.isEmpty(GlobalConfig.getInstance().getUcLibDir())) {
                upVar = UCCore.setup("dexFilePath", GlobalConfig.getInstance().getUcLibDir());
            } else {
                upVar = UCCore.setup("dlChecker", new c()).setup("ucmUpdUrl", this.f);
            }
            SetupTask upVar2 = upVar.setup("webview_multi_process", Integer.valueOf(this.f21226a)).setup("gpu_process_mode", Integer.valueOf(this.b)).setup("webview_multi_process_fallback_timeout", 8000).setup("webview_multi_process_enable_service_speedup", Boolean.FALSE);
            android.taobao.windvane.base.b bVar = this.g;
            upVar2.setup("startup_policy", Integer.valueOf(bVar == null ? 16 : bVar.c().initWebPolicy));
            SetupTask upVar3 = upVar.setup("CONTEXT", context.getApplicationContext()).setup("provided_keys", strArr);
            Boolean bool = Boolean.TRUE;
            SetupTask upVar4 = upVar3.setup("VIDEO_AC", bool).setup(AssistPushConsts.MSG_KEY_ACTION, bool);
            android.taobao.windvane.base.b bVar2 = this.g;
            SetupTask upVar5 = upVar4.setup("core_ver_excludes", bVar2 == null ? "" : bVar2.c().excludeUCVersions).setup("MULTI_CORE_TYPE", bool).setup("SYSTEM_WEBVIEW", Boolean.valueOf(this.r)).setup("WEBVIEW_POLICY", 2).setup("loadPolicy", "SPECIFIED_ONLY").setup("VERIFY_POLICY", 0).setup("delete_core", 0).setup("log_conf", objArr).setup("wait_fallback_sys", 4000);
            android.taobao.windvane.base.b bVar3 = this.g;
            SetupTask upVar6 = upVar5.setup("ucPlayer", Boolean.valueOf(bVar3 == null || bVar3.c().useUCPlayer));
            android.taobao.windvane.base.b bVar4 = this.g;
            upVar6.setup("skip_old_extra_kernel", Boolean.valueOf(bVar4 == null || bVar4.c().ucSkipOldKernel)).setup("sdk_international_env", Boolean.valueOf(GlobalConfig.getInstance().isUcSdkInternationalEnv())).setup("PRIVATE_DATA_DIRECTORY_SUFFIX", n()).onEvent(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, new d()).onEvent("success", new a(System.currentTimeMillis())).onEvent("switch", new g()).setAsDefault().start();
            TaoLog.i(c, "final UCCore:" + this.f);
        } catch (Exception e2) {
            TaoLog.e(c, "UCCore initApi fail " + e2.getMessage());
        }
        return !this.r;
    }

    public boolean a(String[] strArr, Context context) {
        UCCore.setPrintLog(false);
        if (this.l) {
            return true;
        }
        try {
            Object[] objArr = {Boolean.TRUE, Boolean.FALSE, new ValueCallback<Object[]>() { // from class: android.taobao.windvane.extra.core.WVCore.1
                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(Object[] objArr2) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(u15.f19942b);
                    stringBuffer.append(objArr2[1]);
                    stringBuffer.append(u15.f19942b);
                    stringBuffer.append(objArr2[2]);
                    stringBuffer.append(u15.f19942b);
                    stringBuffer.append(objArr2[5]);
                    String string = stringBuffer.toString();
                    Object obj = objArr2[6];
                    if (obj == null) {
                        if ("v".equals(objArr2[3])) {
                            TaoLog.v((String) objArr2[4], string);
                            return;
                        }
                        if ("d".equals(objArr2[3])) {
                            TaoLog.d((String) objArr2[4], string);
                            return;
                        }
                        if ("i".equals(objArr2[3])) {
                            TaoLog.i((String) objArr2[4], string);
                            return;
                        } else if ("w".equals(objArr2[3])) {
                            TaoLog.w((String) objArr2[4], string);
                            return;
                        } else {
                            if ("e".equals(objArr2[3])) {
                                TaoLog.e((String) objArr2[4], string);
                                return;
                            }
                            return;
                        }
                    }
                    if (obj instanceof UCKnownException) {
                        WVCore.this.q = ((UCKnownException) obj).errCode();
                        if (WVCore.this.q == 3007) {
                            try {
                                System.loadLibrary("webviewuc");
                            } catch (Throwable unused) {
                                WVCore.this.q = 307;
                            }
                        }
                    }
                    if ("v".equals(objArr2[3])) {
                        TaoLog.v((String) objArr2[4], string, (Throwable) objArr2[6], new Object[0]);
                        return;
                    }
                    if ("d".equals(objArr2[3])) {
                        TaoLog.d((String) objArr2[4], string, (Throwable) objArr2[6], new Object[0]);
                        return;
                    }
                    if ("i".equals(objArr2[3])) {
                        TaoLog.i((String) objArr2[4], string, (Throwable) objArr2[6], new Object[0]);
                    } else if ("w".equals(objArr2[3])) {
                        TaoLog.w((String) objArr2[4], string, (Throwable) objArr2[6], new Object[0]);
                    } else if ("e".equals(objArr2[3])) {
                        TaoLog.e((String) objArr2[4], string, (Throwable) objArr2[6], new Object[0]);
                    }
                }
            }, "[all]", "[all]"};
            File file = new File(android.taobao.windvane.extra.c.c.a(context));
            if (this.h == null) {
                j.set(false);
                TaoLog.e(c, "no uc service found, please register first");
                return false;
            }
            if (CommonUtils.getProcessName().equalsIgnoreCase(context.getPackageName() + ":sandboxed_privilege_process0")) {
                return false;
            }
            this.h.updateConfig(android.taobao.windvane.extra.core.b.a());
            String str = c;
            TaoLog.i(str, android.taobao.windvane.extra.core.b.a().toString());
            int corePolicy = this.h.getCorePolicy();
            k();
            TaoLog.i(str, "uccore policy:[" + corePolicy + "]");
            StringBuilder sb = new StringBuilder();
            sb.append("sandbox:policy [");
            android.taobao.windvane.base.b bVar = this.g;
            Object objValueOf = "";
            sb.append(bVar == null ? "" : Integer.valueOf(bVar.c().ucMultiPolicy));
            sb.append("];");
            sb.append("timeout [");
            android.taobao.windvane.base.b bVar2 = this.g;
            if (bVar2 != null) {
                objValueOf = Integer.valueOf(bVar2.c().ucMultiTimeOut);
            }
            sb.append(objValueOf);
            sb.append("]");
            TaoLog.i(str, sb.toString());
            if (!this.o && file.exists() && corePolicy == 0) {
                if (TextUtils.equals("true", UCSoSettings.getInstance().UC_CORE_THICK)) {
                    TaoLog.i(str, "内置厚集成");
                    return a(strArr, context, objArr);
                }
                TaoLog.i(str, "内置薄集成");
                return b(strArr, context, objArr);
            }
            if (TextUtils.equals("true", UCSoSettings.getInstance().UC_CORE_THICK)) {
                TaoLog.i(str, "下载厚集成");
            } else {
                TaoLog.i(str, "下载薄集成");
            }
            return c(strArr, context, objArr);
        } catch (Exception e2) {
            TaoLog.e(c, "UCCore initApi fail " + e2.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        android.taobao.windvane.base.b bVar = this.g;
        String str2 = bVar == null ? "" : bVar.c().initOldCoreVersions;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!m() && str.startsWith("3.16.1.")) {
            return false;
        }
        try {
            for (String str3 : str2.split("\\^\\^")) {
                if (str.equals(str3) || str.matches(str3)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            TaoLog.e(c, "checkOldCoreVersion exception " + e2.getMessage());
            return true;
        }
    }

    public boolean b(String[] strArr, Context context, Object[] objArr) {
        String strA = android.taobao.windvane.extra.c.c.a(context);
        String strD = d(context);
        String str = "";
        if (strD.equals(a(context, strA))) {
            strD = "";
        }
        TaoLog.i(c, "UCSDK initUCLibBy7Z zipPath: " + strA);
        try {
            SetupTask upVar = BusinessWrapper.setup("CONTEXT", context.getApplicationContext());
            SetupTask upVar2 = upVar.setup("bo_dec_r_p", e(context));
            Boolean bool = Boolean.TRUE;
            SetupTask upVar3 = upVar2.setup("bo_f_u_dec_r_p", bool);
            android.taobao.windvane.base.b bVar = this.g;
            upVar3.setup("first_use_sw", Boolean.valueOf(bVar != null && bVar.c().firstUseSystemWebViewOn7zInit)).setup("bo_new_ucm_zf", strA).setup("bo_new_ucm_z_type", "7z").setup("bo_old_dex_dp", strD).setup("bo_dex_old_dex_dir", Boolean.valueOf(m())).setup("bo_skip_io_dc", bool).setup("bo_prom_sp_v_c_i", new e()).setup("bo_s_i_uc_core", new f()).setup("bo_dec_cl", new b(context)).onEvent("be_init_success", new ValueCallback<SetupTask>() { // from class: android.taobao.windvane.extra.core.WVCore.2
                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(SetupTask setupTask) {
                    UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
                    if (totalLoadedUCM == null || totalLoadedUCM.ucmPackageInfo == null) {
                        return;
                    }
                    WVCore.this.a(totalLoadedUCM.ucmPackageInfo.dataDir);
                }
            });
            SetupTask upVar4 = upVar.setup("CONTEXT", context.getApplicationContext()).setup("webview_multi_process", Integer.valueOf(this.f21226a)).setup("gpu_process_mode", Integer.valueOf(this.b)).setup("webview_multi_process_fallback_timeout", 8000).setup("webview_multi_process_enable_service_speedup", Boolean.FALSE).setup("provided_keys", strArr).setup("VIDEO_AC", bool).setup(AssistPushConsts.MSG_KEY_ACTION, bool);
            android.taobao.windvane.base.b bVar2 = this.g;
            if (bVar2 != null) {
                str = bVar2.c().excludeUCVersions;
            }
            SetupTask upVar5 = upVar4.setup("core_ver_excludes", str).setup("MULTI_CORE_TYPE", bool).setup("SYSTEM_WEBVIEW", Boolean.valueOf(this.r)).setup("WEBVIEW_POLICY", 2).setup("loadPolicy", "SPECIFIED_ONLY").setup("VERIFY_POLICY", 0).setup("delete_core", 0).setup("log_conf", objArr);
            android.taobao.windvane.base.b bVar3 = this.g;
            SetupTask upVar6 = upVar5.setup("ucPlayer", Boolean.valueOf(bVar3 == null || bVar3.c().useUCPlayer)).setup("wait_fallback_sys", 4000);
            android.taobao.windvane.base.b bVar4 = this.g;
            SetupTask upVar7 = upVar6.setup("skip_old_extra_kernel", Boolean.valueOf(bVar4 == null || bVar4.c().ucSkipOldKernel)).setup("sdk_international_env", Boolean.valueOf(GlobalConfig.getInstance().isUcSdkInternationalEnv()));
            android.taobao.windvane.base.b bVar5 = this.g;
            upVar7.setup("startup_policy", Integer.valueOf(bVar5 == null ? 19 : bVar5.c().initWebPolicy)).setup("PRIVATE_DATA_DIRECTORY_SUFFIX", n()).onEvent(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, new d()).onEvent("success", new a(System.currentTimeMillis())).onEvent("switch", new g()).setAsDefault().start();
        } catch (Exception e2) {
            TaoLog.e(c, "initUCLibBy7Z fail " + e2.getMessage());
        }
        return !this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        TaoLog.i(c, "save dex path:[" + str + "]");
        ConfigStorage.putStringVal("WindVane", "UC_PATH", str);
    }

    private String a(Context context, String str) {
        return UCCore.getExtractDirPath(context, str);
    }

    public boolean a(String[] strArr, Context context, Object[] objArr) {
        try {
            Context applicationContext = context.getApplicationContext();
            String strA = android.taobao.windvane.extra.c.c.a(applicationContext);
            String strN = n();
            d dVar = new d();
            a aVar = new a(System.currentTimeMillis());
            g gVar = new g();
            boolean zIsUcSdkInternationalEnv = GlobalConfig.getInstance().isUcSdkInternationalEnv();
            android.taobao.windvane.base.b bVar = this.g;
            int i2 = bVar == null ? 16 : bVar.c().initWebPolicy;
            TaoLog.i(c, "initUCLibByThick7Z core7ZFilePath: " + strA + " processSuffix: " + strN);
            SetupTask upVar = UCCore.setup("CONTEXT", applicationContext).setup("ucmZipFile", strA).setup("webview_multi_process", Integer.valueOf(this.f21226a)).setup("gpu_process_mode", Integer.valueOf(this.b)).setup("webview_multi_process_fallback_timeout", 8000);
            Boolean bool = Boolean.FALSE;
            SetupTask upVar2 = upVar.setup("webview_multi_process_enable_service_speedup", bool).setup("provided_keys", strArr);
            Boolean bool2 = Boolean.TRUE;
            SetupTask upVar3 = upVar2.setup("VIDEO_AC", bool2).setup(AssistPushConsts.MSG_KEY_ACTION, bool2);
            android.taobao.windvane.base.b bVar2 = this.g;
            SetupTask upVar4 = upVar3.setup("core_ver_excludes", bVar2 == null ? "" : bVar2.c().excludeUCVersions).setup("MULTI_CORE_TYPE", bool2).setup("SYSTEM_WEBVIEW", Boolean.valueOf(this.r)).setup("WEBVIEW_POLICY", 2).setup("loadPolicy", "SPECIFIED_ONLY").setup("VERIFY_POLICY", 0).setup("delete_core", 0).setup("log_conf", objArr).setup("wait_fallback_sys", 4000);
            android.taobao.windvane.base.b bVar3 = this.g;
            SetupTask upVar5 = upVar4.setup("ucPlayer", Boolean.valueOf(bVar3 == null || bVar3.c().useUCPlayer));
            android.taobao.windvane.base.b bVar4 = this.g;
            upVar5.setup("skip_old_extra_kernel", Boolean.valueOf(bVar4 == null || bVar4.c().ucSkipOldKernel)).setup("sdk_international_env", Boolean.valueOf(zIsUcSdkInternationalEnv)).setup("startup_policy", Integer.valueOf(i2)).setup("PRIVATE_DATA_DIRECTORY_SUFFIX", strN).setup("THICK_INTEGRATION", bool2).setup("app_st_o", Integer.valueOf(this.p ? 1 : 2)).setup("setup_create_thread", bool).onEvent(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, dVar).onEvent("success", aVar).onEvent("switch", gVar).setAsDefault().start();
        } catch (Exception e2) {
            TaoLog.e(c, "UCCore init fail " + e2.getMessage());
        }
        return !this.r;
    }

    public static String c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "null";
        }
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 4 || subtype == 1 || subtype == 2) {
                return "2g";
            }
            if (subtype == 3 || subtype == 8 || subtype == 6 || subtype == 5 || subtype == 12) {
                return "3g";
            }
            if (subtype == 13) {
                return "4g";
            }
        }
        return "";
    }

    private String c(String str) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            return "";
        }
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                String strC = c(file.getPath());
                if (strC.endsWith("libwebviewuc.so")) {
                    return strC;
                }
            } else if (file.getName().endsWith("libwebviewuc.so")) {
                return file.getPath();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j2) {
        String str = c;
        TaoLog.i(str, "CorePreparedCallback: " + WebView.getCoreType());
        if (c().l || WebView.getCoreType() != 3) {
            return;
        }
        c().l = true;
        this.q = 0;
        TaoLog.i(str, "CorePreparedCallback   isUCSDKSupport = true");
        android.taobao.windvane.extra.core.a aVar = this.m;
        if (aVar != null) {
            aVar.b();
        }
        j jVar = (j) m.a().b(j.class);
        android.taobao.windvane.base.b bVar = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);
        if (jVar != null && jVar.f() != null) {
            jVar.f().a(System.currentTimeMillis() - j2, bVar == null ? "" : String.valueOf(bVar.c().initUCCorePolicy));
        }
        android.taobao.windvane.b.g.a().a(3016);
        if (!GlobalConfig.getInstance().needSpeed()) {
            d();
        }
        try {
            UCCore.updateUCPlayer(GlobalConfig.context, UCSoSettings.getInstance().UC_PLAYER_URL, new c());
        } catch (Exception e2) {
            TaoLog.e(c, "UCCore update UCPlayer failed:" + e2.getMessage());
        }
    }
}
