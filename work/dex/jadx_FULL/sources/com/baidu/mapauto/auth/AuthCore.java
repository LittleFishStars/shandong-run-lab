package com.baidu.mapauto.auth;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.net.c;
import com.baidu.mapauto.auth.util.LogUtil;
import com.zj.adlib.xh9;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AuthCore {
    public static final String TAG = "AuthCore";
    public static final int TYPE_LICENSE_ALL = 3;
    public static final int TYPE_LICENSE_FILE = 1;
    public static final int TYPE_LICENSE_FUNCTION = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.baidu.mapauto.auth.data.license.impl.a f26588a;
    public volatile com.baidu.mapauto.auth.data.license.impl.b b;
    public final ThreadPoolExecutor c;
    public final ThreadPoolExecutor d;
    public volatile com.baidu.mapauto.auth.process.a e;
    public volatile com.baidu.mapauto.auth.process.b f;
    public String g;
    public String h;
    public String i;

    public static class AuthParam extends HashMap<String, Object> {
        public static final String KEY_EXTRA_APP_VERSION = "extra_app_version";
        public static final String KEY_EXTRA_CUID = "extra_cuid";
        public static final String KEY_EXTRA_MODEL = "extra_model";
        public static final String KEY_EXTRA_OS_VERSION = "extra_os_version";

        public AuthParam() {
        }

        public AuthParam(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
            put("ak", str);
            put(xh9.WEBSITE_PARAMS_CHANNEL, str2);
            put("device_id", str3);
            put("service_name", str4);
            put("function_name", str5);
            if (map != null) {
                putAll(map);
            }
            put("sdk_version_name", "1.0.0");
            put("sdk_version_code", 1);
        }

        public final AuthParam a() {
            AuthParam authParam = new AuthParam();
            for (String str : keySet()) {
                authParam.put(str, get(str));
            }
            return authParam;
        }

        public final boolean a(int i) {
            boolean z = (TextUtils.isEmpty(b()) || TextUtils.isEmpty(e())) ? false : true;
            if ((i & 2) == 2) {
                z = z && !TextUtils.isEmpty(c());
            }
            if ((i & 1) == 1) {
                return z && !TextUtils.isEmpty(d());
            }
            return z;
        }

        public final String b() {
            Object obj = get("ak");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String c() {
            Object obj = get(xh9.WEBSITE_PARAMS_CHANNEL);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String d() {
            Object obj = get("device_id");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public final String e() {
            Object obj = get("service_name");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
    }

    public class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return !TextUtils.isEmpty(str) && "https://api.map.baidu.com".contains(str);
        }
    }

    public static final class b implements ILicenseAuthListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ILicenseAuthListener> f26589a;
        public final Handler b = new Handler(Looper.getMainLooper());

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map f26590a;

            public a(Map map) {
                this.f26590a = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ILicenseAuthListener iLicenseAuthListener = b.this.f26589a.get();
                LogUtil.getInstance().i(AuthCore.TAG, "授权成功(回调 " + iLicenseAuthListener + "): " + this.f26590a);
                if (iLicenseAuthListener != null) {
                    iLicenseAuthListener.onSuccess(this.f26590a);
                }
            }
        }

        /* JADX INFO: renamed from: com.baidu.mapauto.auth.AuthCore$b$b, reason: collision with other inner class name */
        public class RunnableC0270b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f26591a;
            public final /* synthetic */ String b;

            public RunnableC0270b(int i, String str) {
                this.f26591a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ILicenseAuthListener iLicenseAuthListener = b.this.f26589a.get();
                LogUtil.getInstance().e(AuthCore.TAG, "授权失败(回调 " + iLicenseAuthListener + "): code = " + this.f26591a + ", msg = " + this.b);
                if (iLicenseAuthListener != null) {
                    iLicenseAuthListener.onError(this.f26591a, this.b);
                }
            }
        }

        public b(ILicenseAuthListener iLicenseAuthListener) {
            this.f26589a = new WeakReference<>(iLicenseAuthListener);
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public final void onError(int i, String str) {
            RunnableC0270b runnableC0270b = new RunnableC0270b(i, str);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                runnableC0270b.run();
            } else {
                this.b.post(runnableC0270b);
            }
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public final void onSuccess(Map<String, Integer> map) {
            a aVar = new a(map);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                aVar.run();
            } else {
                this.b.post(aVar);
            }
        }
    }

    public AuthCore() {
        HashMap map = new HashMap(2);
        map.put("sdk_version_name", "1.0.0");
        map.put("sdk_version_code", 1);
        this.f26588a = new com.baidu.mapauto.auth.data.license.impl.a(new com.baidu.mapauto.auth.net.a(new c.a().d().c().b().a(map).a(new a()).a()));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.c = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 60L, timeUnit, new LinkedBlockingQueue());
        this.d = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 60L, timeUnit, new LinkedBlockingQueue());
    }

    public final HashMap a(Context context, String str, String str2, String str3, String str4, String str5, int i) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        LogUtil logUtil = LogUtil.getInstance();
        String str6 = TAG;
        logUtil.i(str6, "本地: 开始授权");
        if (context == null) {
            LogUtil.getInstance().i(str6, "本地: context 为空");
            throw new BaseLicenseAuthDataStandardProcess.ProcessException(-1002, "context 不可以为空");
        }
        String str7 = TextUtils.isEmpty(str) ? this.g : str;
        String str8 = TextUtils.isEmpty(str2) ? this.h : str2;
        AuthParam authParam = new AuthParam(str7, TextUtils.isEmpty(str3) ? this.i : str3, str8, str4, str5, new HashMap(0));
        if (!authParam.a(i)) {
            LogUtil.getInstance().i(str6, "本地: 核心参数检测失败");
            throw new BaseLicenseAuthDataStandardProcess.ProcessException(-1002, "参数错误, 请确保 ak, channel, serviceName 、 file 类型下时的 deviceId 不为空");
        }
        if (this.b == null) {
            synchronized (AuthCore.class) {
                if (this.b == null) {
                    this.b = new com.baidu.mapauto.auth.data.license.impl.b(new com.baidu.mapauto.auth.store.a(context));
                }
            }
        }
        if (this.b instanceof com.baidu.mapauto.auth.data.license.impl.b) {
            com.baidu.mapauto.auth.data.license.impl.b bVar = this.b;
            bVar.getClass();
            bVar.b = str7 + str8;
        }
        ArrayList arrayList = new ArrayList(2);
        if ((i & 1) == 1) {
            arrayList.add(new com.baidu.mapauto.auth.process.a(2, this.f26588a, this.b));
            LogUtil.getInstance().i(str6, "本地: 添加 license file 授权流程");
        }
        if ((i & 2) == 2) {
            arrayList.add(new com.baidu.mapauto.auth.process.b(2, this.f26588a, this.b));
            LogUtil.getInstance().i(str6, "本地: 添加 license function 授权流程");
        }
        if (arrayList.isEmpty()) {
            LogUtil.getInstance().i(str6, "本地: 没有发现任何授权流程");
            return new HashMap(0);
        }
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                map.putAll(((BaseLicenseAuthDataStandardProcess) it.next()).a(authParam));
            } catch (BaseLicenseAuthDataStandardProcess.ProcessException e) {
                LogUtil logUtil2 = LogUtil.getInstance();
                String str9 = TAG;
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("本地: 授权异常结束（");
                sbA.append(e.getMessage());
                sbA.append(")");
                logUtil2.i(str9, sbA.toString());
                throw e;
            }
        }
        LogUtil.getInstance().i(TAG, "本地: 授权成功结束");
        return map;
    }
}
