package com.ali.auth.third.core.task;

import android.os.AsyncTask;
import android.webkit.CookieSyncManager;
import com.ali.auth.third.core.callback.InitResultCallback;
import com.ali.auth.third.core.config.ConfigManager;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.device.DeviceInfo;
import com.ali.auth.third.core.exception.AlibabaSDKException;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.service.CredentialService;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.StorageService;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.ReflectionUtils;
import com.ali.auth.third.login.LoginLifecycleAdapter;
import com.baidu.location.BDLocation;
import java.io.File;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InitResultCallback f23440a;
    private Integer b;

    /* JADX INFO: renamed from: com.ali.auth.third.core.task.a$a, reason: collision with other inner class name */
    public class RunnableC0118a implements Runnable {
        public RunnableC0118a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23440a != null) {
                a.this.f23440a.onFailure(-1, "service register fail");
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f23440a != null) {
                a.this.f23440a.onSuccess();
            }
        }
    }

    public a(InitResultCallback initResultCallback, Integer num) {
        this.f23440a = initResultCallback;
        this.b = num;
    }

    private Object a(String str, String[] strArr, Object[] objArr) {
        try {
            return ReflectionUtils.newInstance(str, strArr, objArr);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(com.ali.auth.third.core.registry.a aVar) {
        SDKLogger.d("init", "registerRpc");
        try {
            aVar.a(new Class[]{RpcService.class}, a("com.ali.auth.third.mtop.rpc.impl.MtopRpcServiceImpl", null, null), null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean b(com.ali.auth.third.core.registry.a aVar) {
        SDKLogger.d("init", "registerStorage");
        try {
            KernelContext.isMini = false;
            KernelContext.sdkVersion = KernelContext.SDK_VERSION_STD;
        } catch (Throwable unused) {
        }
        try {
            aVar.a(new Class[]{StorageService.class}, a("com.ali.auth.third.securityguard.SecurityGuardWrapper", null, null), null);
            KernelContext.storageService = (StorageService) aVar.a(StorageService.class, null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c() {
        try {
            long jD = d();
            SDKLogger.e("init", "timeStamp=" + jD);
            KernelContext.timestamp = jD;
        } catch (Exception e) {
            SDKLogger.e("init", e.getMessage(), e);
        }
        if (!b()) {
            SDKLogger.d("init", " INIT FAILURE");
            KernelContext.executorService.postUITask(new RunnableC0118a());
        } else {
            KernelContext.executorService.postUITask(new b());
            KernelContext.isInitOk = Boolean.TRUE;
            SDKLogger.d("init", "INIT SUCCESS");
        }
    }

    private boolean c(com.ali.auth.third.core.registry.a aVar) {
        SDKLogger.d("init", "registerUserTrack");
        try {
            aVar.a(new Class[]{UserTrackerService.class}, a("com.ali.auth.third.ut.UserTrackerImpl", null, null), null);
            return true;
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return false;
        }
    }

    private long d() {
        File file = new File(KernelContext.context.getFilesDir().getAbsolutePath() + File.separator + "timestamp");
        if (file.exists()) {
            return file.lastModified();
        }
        try {
            file.createNewFile();
            return file.lastModified();
        } catch (Exception e) {
            SDKLogger.e("init", e.getMessage(), e);
            return 0L;
        }
    }

    private boolean e() {
        try {
            Class.forName(AsyncTask.class.getName());
        } catch (Exception unused) {
        }
        KernelContext.wrapServiceRegistry();
        ConfigManager.getInstance().init(this.b.intValue());
        com.ali.auth.third.core.registry.a aVar = KernelContext.serviceRegistry;
        if (!a(aVar) || !b(aVar) || !c(aVar)) {
            return false;
        }
        aVar.a(new Class[]{MemberExecutorService.class, ExecutorService.class}, KernelContext.executorService, Collections.singletonMap(Constants.PLUGIN_VENDOR_KEY, "kernel"));
        aVar.a(new Class[]{CredentialService.class}, CredentialManager.INSTANCE, Collections.singletonMap("scop", BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM));
        KernelContext.credentialService = (CredentialService) aVar.a(CredentialService.class, null);
        boolean z = h() || i();
        if (!KernelContext.isMini) {
            g();
        }
        SDKLogger.d("init", "INIT SUCCESS");
        return z;
    }

    private void f() {
        DeviceInfo.init(KernelContext.context);
    }

    private boolean g() {
        SDKLogger.d("init", "register account link service");
        try {
            ReflectionUtils.invoke("com.ali.auth.third.accountlink.AccountLinkLifecycleAdapter", "init", null, Class.forName("com.ali.auth.third.accountlink.AccountLinkLifecycleAdapter"), null);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean h() {
        SDKLogger.d("init", "register login service");
        try {
            ReflectionUtils.invoke("com.ali.auth.third.login.LoginLifecycleAdapter", "init", null, LoginLifecycleAdapter.class, null);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean i() {
        SDKLogger.d("init", "register offline login service");
        try {
            ReflectionUtils.invoke("com.ali.auth.third.offline.login.LoginLifecycleAdapter", "init", null, Class.forName("com.ali.auth.third.offline.login.LoginLifecycleAdapter"), null);
            KernelContext.supportOfflineLogin = true;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void a() {
        KernelContext.initLock.unlock();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public void a(Throwable th) {
        String string;
        int i;
        KernelContext.isInitOk = Boolean.FALSE;
        if (th instanceof AlibabaSDKException) {
            AlibabaSDKException alibabaSDKException = (AlibabaSDKException) th;
            if (alibabaSDKException.getSDKMessage() != null) {
                Message sDKMessage = alibabaSDKException.getSDKMessage();
                i = sDKMessage.code;
                string = sDKMessage.message;
            } else {
                string = CommonUtils.toString(th);
                i = 10010;
            }
        } else {
            string = CommonUtils.toString(th);
            i = 10010;
        }
        CommonUtils.onFailure(this.f23440a, i, string);
    }

    public boolean b() {
        SDKLogger.d("init", "sdk version = " + ConfigManager.SDK_VERSION.toString());
        f();
        if (KernelContext.syncInitialized) {
            return true;
        }
        try {
            CookieSyncManager.createInstance(KernelContext.getApplicationContext());
            if (!e()) {
                return false;
            }
            KernelContext.syncInitialized = true;
            return true;
        } catch (Throwable th) {
            SDKLogger.e("init", "fail to sync start", th);
            a(th);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            KernelContext.initLock.lock();
            c();
        } catch (Throwable th) {
            try {
                SDKLogger.e("init", th.getMessage(), th);
                a(th);
            } finally {
                a();
            }
        }
    }
}
