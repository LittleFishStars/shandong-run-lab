package com.alipay.sdk.m.a0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    public class a implements com.alipay.sdk.m.a0.a.InterfaceC0185a<Object, Boolean> {
        @Override // com.alipay.sdk.m.a0.a.InterfaceC0185a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.a0.b$b, reason: collision with other inner class name */
    public class CallableC0186b implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25383a;

        public CallableC0186b(Context context) {
            this.f25383a = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            return com.alipay.sdk.m.c.c.a(this.f25383a);
        }
    }

    public class c implements com.alipay.sdk.m.a0.a.InterfaceC0185a<Object, Boolean> {
        @Override // com.alipay.sdk.m.a0.a.InterfaceC0185a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    public class d implements Callable<NetworkInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25384a;

        public d(Context context) {
            this.f25384a = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetworkInfo call() {
            return ((ConnectivityManager) this.f25384a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    public class e implements com.alipay.sdk.m.a0.a.InterfaceC0185a<Object, Boolean> {
        @Override // com.alipay.sdk.m.a0.a.InterfaceC0185a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public class f implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25385a;
        public final /* synthetic */ com.alipay.sdk.m.w.a b;

        public f(Context context, com.alipay.sdk.m.w.a aVar) {
            this.f25385a = context;
            this.b = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            try {
                return com.alipay.sdk.m.s0.a.c(this.f25385a);
            } catch (Throwable th) {
                com.alipay.sdk.m.m.a.b(this.b, com.alipay.sdk.m.m.b.o, com.alipay.sdk.m.m.b.u, th.getClass().getName());
                return "";
            }
        }
    }

    public class g implements com.alipay.sdk.m.a0.a.InterfaceC0185a<Object, Boolean> {
        @Override // com.alipay.sdk.m.a0.a.InterfaceC0185a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public class h implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f25386a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ com.alipay.sdk.m.w.a d;

        public class a implements APSecuritySdk.InitResultListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f25387a;
            public final /* synthetic */ ConditionVariable b;

            public a(String[] strArr, ConditionVariable conditionVariable) {
                this.f25387a = strArr;
                this.b = conditionVariable;
            }

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.f25387a[0] = tokenResult.apdidToken;
                }
                this.b.open();
            }
        }

        public h(String str, String str2, Context context, com.alipay.sdk.m.w.a aVar) {
            this.f25386a = str;
            this.b = str2;
            this.c = context;
            this.d = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            HashMap map = new HashMap();
            map.put("tid", this.f25386a);
            map.put("utdid", this.b);
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(this.c);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, map, new a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                com.alipay.sdk.m.y.g.a(th);
                com.alipay.sdk.m.m.a.b(this.d, com.alipay.sdk.m.m.b.o, com.alipay.sdk.m.m.b.r, th.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                com.alipay.sdk.m.m.a.b(this.d, com.alipay.sdk.m.m.b.o, com.alipay.sdk.m.m.b.s, "missing token");
            }
            return strArr[0];
        }
    }

    public static NetworkInfo a(com.alipay.sdk.m.w.a aVar, Context context) {
        Context contextA = com.alipay.sdk.m.a0.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (NetworkInfo) com.alipay.sdk.m.a0.a.a(2, 10L, timeUnit, new c(), new d(contextA), false, 10L, timeUnit, aVar, false);
    }

    public static String b(com.alipay.sdk.m.w.a aVar, Context context) {
        if (!com.alipay.sdk.m.o.b.i().B()) {
            return "";
        }
        return (String) com.alipay.sdk.m.a0.a.a(1, 1L, TimeUnit.DAYS, new a(), new CallableC0186b(com.alipay.sdk.m.a0.a.a(context)), true, 200L, TimeUnit.MILLISECONDS, aVar, true);
    }

    public static String c(com.alipay.sdk.m.w.a aVar, Context context) {
        return (String) com.alipay.sdk.m.a0.a.a(3, 1L, TimeUnit.DAYS, new e(), new f(com.alipay.sdk.m.a0.a.a(context), aVar), true, 3L, TimeUnit.SECONDS, aVar, false);
    }

    public static String a(com.alipay.sdk.m.w.a aVar, Context context, String str, String str2) {
        Context contextA = com.alipay.sdk.m.a0.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (String) com.alipay.sdk.m.a0.a.a(4, 10L, timeUnit, new g(), new h(str, str2, contextA, aVar), true, 3L, timeUnit, aVar, true);
    }
}
