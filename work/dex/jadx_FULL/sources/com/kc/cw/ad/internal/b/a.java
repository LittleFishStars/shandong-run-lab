package com.kc.cw.ad.internal.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.cw.ad.AdRequest;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.SSAdSdkController;
import com.kc.cw.ad.d.b.i;
import com.kc.cw.ad.internal.c.h;
import com.kc.cw.ad.internal.c.m;
import com.kc.cw.ad.internal.c.o;
import com.kc.cw.ad.internal.c.p;
import com.kc.cw.ad.internal.c.r;
import com.kc.cw.ad.internal.c.s;
import com.kc.cw.ad.internal.c.t;
import com.kc.cw.ad.internal.l;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.utils.ThreadUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {
    private SoftReference<com.kc.cw.ad.internal.e> b;
    private com.kc.cw.ad.internal.d d;
    private String e;
    private int f;
    private int g;
    private long h;
    private long i;
    private boolean j;
    private boolean k;
    private volatile boolean l;
    private static final f c = new f(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38864a = h.a("emulator");

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.a$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f38865a;
        final Context b;
        final a c;

        public AnonymousClass1(a aVar, String str, Context context) {
            this.c = aVar;
            this.f38865a = str;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (this.c.d == null) {
                this.c.a(80100);
                this.c.a(false, "80100 adParams is null");
                return;
            }
            if (!p.a(this.f38865a)) {
                com.kc.cw.ad.a.c.t tVarA = com.kc.cw.ad.a.c.t.a(this.c.d.c(), this.c.e, this.c.d.h(), this.f38865a, true);
                this.c.a(new f(tVarA, this.c.d, this.c.d.p(), this.c.e, tVarA.c()));
                return;
            }
            boolean zC = o.c(this.b, "isPreload_" + this.c.d.c());
            if (zC) {
                String strB = o.b(this.b, "adPreRsp_" + this.c.d.c());
                if (TextUtils.isEmpty(strB)) {
                    str = "返回错误码";
                } else {
                    try {
                        String[] strArrSplit = strB.split("@#&!");
                        String str2 = strArrSplit[0];
                        String str3 = strArrSplit[1];
                        String str4 = strArrSplit[2];
                        this.c.d.e(str3);
                        this.c.d.a(Long.parseLong(str4));
                        com.kc.cw.ad.a.c.t tVarA2 = com.kc.cw.ad.a.c.t.a(this.c.d.c(), str3, this.c.d.h(), str2, false);
                        this.c.a(new f(tVarA2, this.c.d, this.c.d.p(), str3, tVarA2.c()));
                        o.d(this.b, "adPreRsp_" + this.c.d.c());
                        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "走缓存创建ServerResponse耗时" + (System.currentTimeMillis() - this.c.h));
                    } catch (Exception e) {
                        str = "返回错误码:" + e.getMessage();
                        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", str);
                        this.c.a(80100);
                    }
                }
                com.kc.cw.ad.d.b.f.c("OctopusAd_Time", str);
                this.c.a(80100);
            }
            a aVar = this.c;
            byte[] bytes = aVar.a(aVar.d, false).getBytes();
            com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "请求参数封装完成，耗时：" + (System.currentTimeMillis() - this.c.h));
            com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "开始连接服务器");
            this.c.h = System.currentTimeMillis();
            ArrayList<String> arrayList = q.a().j;
            if (zC || arrayList == null || arrayList.size() < 2) {
                this.c.a(this.b, q.a().b(q.a().i, this.c.d.l()), bytes, zC, null, null);
                return;
            }
            this.c.k = true;
            CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.c.a(this.b, q.a().b(it.next(), this.c.d.l()), bytes, zC, countDownLatch, arrayList2);
            }
            new Thread(new Runnable(this, countDownLatch, arrayList2) { // from class: com.kc.cw.ad.internal.b.a.1.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final CountDownLatch f38866a;
                final ArrayList b;
                final AnonymousClass1 c;

                {
                    this.c = this;
                    this.f38866a = countDownLatch;
                    this.b = arrayList2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        this.f38866a.await(q.a().b, TimeUnit.MILLISECONDS);
                        if (this.b.isEmpty()) {
                            this.c.c.a((f) null);
                        } else if (this.b.size() == 1) {
                            this.c.c.a((f) this.b.get(0));
                        } else {
                            this.c.c.a(a.b((ArrayList<f>) this.b));
                        }
                    } catch (Exception unused) {
                        this.c.c.a((f) null);
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.a$a, reason: collision with other inner class name */
    @Keep
    public static final class C1001a {
        private Date d;
        private String e;
        private String h;
        private boolean j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashSet<String> f38869a = new HashSet<>();
        private final Bundle b = new Bundle();
        private final HashSet<String> c = new HashSet<>();
        private int f = -1;
        private boolean g = false;
        private int i = -1;

        public void a(int i) {
            this.f = i;
        }

        public void a(Class<? extends Object> cls, Bundle bundle) {
            this.b.putBundle(cls.getName(), bundle);
        }

        public void a(String str) {
            this.f38869a.add(str);
        }

        public void a(Date date) {
            this.d = date;
        }

        public void a(boolean z) {
            this.i = z ? 1 : 0;
        }

        public void b(String str) {
            this.c.add(str);
        }

        public void b(boolean z) {
            this.j = z;
        }

        public void c(String str) {
            this.e = str;
        }

        public void d(String str) {
            this.h = str;
        }
    }

    public a() {
    }

    public a(C1001a c1001a) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutputStream a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestProperty("User-Agent", q.a().m());
        httpURLConnection.setRequestProperty("Content-Type", ze1.g);
        httpURLConnection.setRequestProperty("Accept", ze1.g);
        String strA = t.a();
        if (!TextUtils.isEmpty(strA)) {
            httpURLConnection.setRequestProperty(com.google.common.net.b.p, strA);
        }
        httpURLConnection.setRequestProperty("Connect-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        return outputStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(q.v);
        httpURLConnection.setReadTimeout(q.w);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kc.cw.ad.internal.e eVar = this.b.get();
        if (eVar != null) {
            eVar.a(i);
        }
        com.kc.cw.ad.internal.c.f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, byte[] bArr, boolean z, CountDownLatch countDownLatch, ArrayList<f> arrayList) {
        ThreadUtils.runOnThreadPool(new Runnable(this, str, bArr, z, context, arrayList, countDownLatch) { // from class: com.kc.cw.ad.internal.b.a.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final String f38867a;
            final byte[] b;
            final boolean c;
            final Context d;
            final ArrayList e;
            final CountDownLatch f;
            final a g;

            {
                this.g = this;
                this.f38867a = str;
                this.b = bArr;
                this.c = z;
                this.d = context;
                this.e = arrayList;
                this.f = countDownLatch;
            }

            /* JADX WARN: Code duplicated, block: B:110:0x0304 A[Catch: Exception -> 0x031b, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:112:0x0308 A[Catch: Exception -> 0x031b, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:114:0x030f A[Catch: Exception -> 0x031b, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:116:0x0314 A[Catch: Exception -> 0x031b, TRY_LEAVE, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:129:0x0334 A[Catch: Exception -> 0x037b, TryCatch #11 {Exception -> 0x037b, blocks: (B:127:0x0330, B:129:0x0334, B:131:0x0338, B:134:0x0342, B:136:0x0348, B:138:0x0352, B:139:0x0357, B:144:0x036d, B:146:0x0372, B:148:0x0377, B:140:0x0362, B:142:0x0366), top: B:161:0x0330 }] */
            /* JADX WARN: Code duplicated, block: B:140:0x0362 A[Catch: Exception -> 0x037b, TryCatch #11 {Exception -> 0x037b, blocks: (B:127:0x0330, B:129:0x0334, B:131:0x0338, B:134:0x0342, B:136:0x0348, B:138:0x0352, B:139:0x0357, B:144:0x036d, B:146:0x0372, B:148:0x0377, B:140:0x0362, B:142:0x0366), top: B:161:0x0330 }] */
            /* JADX WARN: Code duplicated, block: B:142:0x0366 A[Catch: Exception -> 0x037b, TryCatch #11 {Exception -> 0x037b, blocks: (B:127:0x0330, B:129:0x0334, B:131:0x0338, B:134:0x0342, B:136:0x0348, B:138:0x0352, B:139:0x0357, B:144:0x036d, B:146:0x0372, B:148:0x0377, B:140:0x0362, B:142:0x0366), top: B:161:0x0330 }] */
            /* JADX WARN: Code duplicated, block: B:144:0x036d A[Catch: Exception -> 0x037b, TryCatch #11 {Exception -> 0x037b, blocks: (B:127:0x0330, B:129:0x0334, B:131:0x0338, B:134:0x0342, B:136:0x0348, B:138:0x0352, B:139:0x0357, B:144:0x036d, B:146:0x0372, B:148:0x0377, B:140:0x0362, B:142:0x0366), top: B:161:0x0330 }] */
            /* JADX WARN: Code duplicated, block: B:146:0x0372 A[Catch: Exception -> 0x037b, TryCatch #11 {Exception -> 0x037b, blocks: (B:127:0x0330, B:129:0x0334, B:131:0x0338, B:134:0x0342, B:136:0x0348, B:138:0x0352, B:139:0x0357, B:144:0x036d, B:146:0x0372, B:148:0x0377, B:140:0x0362, B:142:0x0366), top: B:161:0x0330 }] */
            /* JADX WARN: Code duplicated, block: B:148:0x0377 A[Catch: Exception -> 0x037b, TRY_LEAVE, TryCatch #11 {Exception -> 0x037b, blocks: (B:127:0x0330, B:129:0x0334, B:131:0x0338, B:134:0x0342, B:136:0x0348, B:138:0x0352, B:139:0x0357, B:144:0x036d, B:146:0x0372, B:148:0x0377, B:140:0x0362, B:142:0x0366), top: B:161:0x0330 }] */
            /* JADX WARN: Code duplicated, block: B:172:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:174:? A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:61:0x024d A[Catch: Exception -> 0x031b, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:63:0x0251 A[Catch: Exception -> 0x031b, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:65:0x0258 A[Catch: Exception -> 0x031b, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Code duplicated, block: B:67:0x025d A[Catch: Exception -> 0x031b, TryCatch #12 {Exception -> 0x031b, blocks: (B:48:0x021b, B:50:0x021f, B:52:0x0223, B:55:0x022d, B:57:0x0233, B:59:0x023d, B:60:0x0242, B:65:0x0258, B:67:0x025d, B:68:0x0260, B:61:0x024d, B:63:0x0251, B:97:0x02d2, B:99:0x02d6, B:101:0x02da, B:104:0x02e4, B:106:0x02ea, B:108:0x02f4, B:109:0x02f9, B:114:0x030f, B:116:0x0314, B:110:0x0304, B:112:0x0308), top: B:163:0x000f }] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Not initialized variable reg: 11, insn: 0x0322: MOVE (r8 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:123:0x0321 */
            /* JADX WARN: Type inference failed for: r0v69, types: [com.kc.cw.ad.internal.b.a] */
            /* JADX WARN: Type inference failed for: r0v78, types: [com.kc.cw.ad.internal.b.a] */
            /* JADX WARN: Type inference failed for: r11v14, types: [int] */
            /* JADX WARN: Type inference failed for: r11v15 */
            /* JADX WARN: Type inference failed for: r11v16 */
            /* JADX WARN: Type inference failed for: r11v19 */
            /* JADX WARN: Type inference failed for: r11v23, types: [com.kc.cw.ad.internal.b.f, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v24 */
            /* JADX WARN: Type inference failed for: r11v26 */
            /* JADX WARN: Type inference failed for: r11v27 */
            /* JADX WARN: Type inference failed for: r11v28 */
            /* JADX WARN: Type inference failed for: r12v0 */
            /* JADX WARN: Type inference failed for: r12v17, types: [com.kc.cw.ad.internal.b.f] */
            /* JADX WARN: Type inference failed for: r12v4 */
            /* JADX WARN: Type inference failed for: r23v1 */
            /* JADX WARN: Type inference failed for: r3v2, types: [com.kc.cw.ad.internal.b.a] */
            /* JADX WARN: Type inference failed for: r3v6, types: [com.kc.cw.ad.internal.b.a] */
            /* JADX WARN: Type inference failed for: r8v0 */
            /* JADX WARN: Type inference failed for: r8v10 */
            /* JADX WARN: Type inference failed for: r8v11 */
            /* JADX WARN: Type inference failed for: r8v2 */
            /* JADX WARN: Type inference failed for: r8v20 */
            /* JADX WARN: Type inference failed for: r8v21 */
            /* JADX WARN: Type inference failed for: r8v22 */
            /* JADX WARN: Type inference failed for: r8v23 */
            /* JADX WARN: Type inference failed for: r8v3 */
            /* JADX WARN: Type inference failed for: r8v6, types: [com.kc.cw.ad.internal.b.f, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r8v8 */
            /* JADX WARN: Type inference failed for: r8v9 */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                HttpURLConnection httpURLConnectionA;
                InputStream inputStream;
                Throwable th;
                InputStream inputStream2;
                OutputStream outputStreamA;
                InputStream inputStream3;
                f fVar;
                ?? r11;
                a aVar;
                String str2;
                String str3 = this.f38867a;
                boolean z2 = false;
                ?? r8 = 0;
                InputStream inputStream4 = null;
                 = 0;
                 = 0;
                r8 = 0;
                ?? r9 = 0;
                try {
                    try {
                        try {
                            if (!"OctopusGroup".equals(this.g.d.d())) {
                                str3 = str3 + "&v=1";
                            }
                            httpURLConnectionA = this.g.a(new URL(str3));
                            try {
                                outputStreamA = this.g.a(httpURLConnectionA, this.b);
                                try {
                                    httpURLConnectionA.connect();
                                    com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "连接服务器耗时" + (System.currentTimeMillis() - this.g.h));
                                    this.g.h = System.currentTimeMillis();
                                    this.g.g = httpURLConnectionA.getResponseCode();
                                    com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "获取状态码耗时" + (System.currentTimeMillis() - this.g.h));
                                    this.g.h = System.currentTimeMillis();
                                    a aVar2 = this.g;
                                    ?? r12 = aVar2.g;
                                    try {
                                        if (aVar2.b((int) r12)) {
                                            if (httpURLConnectionA.getContentLength() == 0) {
                                                com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.e, com.kc.cw.ad.internal.c.f.a(R.string.response_blank));
                                                f fVar2 = a.c;
                                                aVar = this.g;
                                                str2 = "response is empty";
                                                r12 = fVar2;
                                            } else {
                                                inputStream3 = httpURLConnectionA.getInputStream();
                                                try {
                                                    com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "reqId: " + this.g.e);
                                                    com.kc.cw.ad.a.c.t tVarA = com.kc.cw.ad.a.c.t.a(inputStream3, this.g.d.c(), this.g.e, this.g.d.h(), this.c);
                                                    String strC = !this.c ? tVarA.c() : "0";
                                                    String str4 = "isPreload_" + this.g.d.c();
                                                    if (tVarA.d()) {
                                                        o.a(this.d, str4, Boolean.TRUE);
                                                    } else {
                                                        o.d(this.d, str4);
                                                    }
                                                    com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "解析响应参数耗时" + (System.currentTimeMillis() - this.g.h));
                                                    this.g.h = System.currentTimeMillis();
                                                    ?? fVar3 = new f(tVarA, this.g.d, this.g.d.p(), this.g.e, strC);
                                                    try {
                                                        try {
                                                            com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "创建ServerResponse耗时" + (System.currentTimeMillis() - this.g.h));
                                                            try {
                                                                if (tVarA.f()) {
                                                                    q.a().d();
                                                                }
                                                                if (tVarA.g()) {
                                                                    q.a().a(fVar3.ag());
                                                                }
                                                            } catch (Exception e) {
                                                                com.kc.cw.ad.d.b.f.c("OctopusAd", "Catch An Exception: " + e.getMessage());
                                                            }
                                                            inputStream4 = inputStream3;
                                                            r11 = fVar3;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            th = th;
                                                            inputStream2 = inputStream3;
                                                            r8 = fVar3;
                                                            try {
                                                                if (this.e == null && this.f != null) {
                                                                    if (q.a().c == 1 && r8 != 0 && r8 != a.c && !r8.i().equals("204")) {
                                                                        this.g.a(r8);
                                                                    }
                                                                    this.e.add(r8);
                                                                    this.f.countDown();
                                                                } else if (!this.c) {
                                                                    this.g.a(r8);
                                                                }
                                                                if (inputStream2 != null) {
                                                                    inputStream2.close();
                                                                }
                                                                if (outputStreamA != null) {
                                                                    outputStreamA.close();
                                                                }
                                                                if (httpURLConnectionA != null) {
                                                                    throw th;
                                                                }
                                                                httpURLConnectionA.disconnect();
                                                                throw th;
                                                            } catch (Exception e2) {
                                                                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e2);
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        r9 = fVar3;
                                                        try {
                                                            a aVar3 = this.g;
                                                            if (e.getMessage() != null && e.getMessage().startsWith("Unable to resolve host")) {
                                                                z2 = true;
                                                            }
                                                            aVar3.j = z2;
                                                            com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "参数封装或广告请求报错" + e);
                                                            this.g.h = System.currentTimeMillis();
                                                            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.d, com.kc.cw.ad.internal.c.f.a(R.string.unknown_exception));
                                                            fVar = a.c;
                                                            this.g.c(e.getMessage());
                                                            if (this.e == null && this.f != null) {
                                                                if (q.a().c == 1 && fVar != null && fVar != a.c && !fVar.i().equals("204")) {
                                                                    this.g.a(fVar);
                                                                }
                                                                this.e.add(fVar);
                                                                this.f.countDown();
                                                            } else if (!this.c) {
                                                                this.g.a(fVar);
                                                            }
                                                            if (inputStream3 != null) {
                                                                inputStream3.close();
                                                            }
                                                            if (outputStreamA != null) {
                                                                outputStreamA.close();
                                                            }
                                                            if (httpURLConnectionA == null) {
                                                                return;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            fVar3 = r9;
                                                            th = th;
                                                            inputStream2 = inputStream3;
                                                            r8 = fVar3;
                                                            if (this.e == null) {
                                                                if (!this.c) {
                                                                    this.g.a(r8);
                                                                }
                                                            } else if (!this.c) {
                                                                this.g.a(r8);
                                                            }
                                                            if (inputStream2 != null) {
                                                                inputStream2.close();
                                                            }
                                                            if (outputStreamA != null) {
                                                                outputStreamA.close();
                                                            }
                                                            if (httpURLConnectionA != null) {
                                                                throw th;
                                                            }
                                                            httpURLConnectionA.disconnect();
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                }
                                            }
                                            if (this.e == null && this.f != null) {
                                                if (q.a().c == 1 && r11 != 0 && r11 != a.c && !r11.i().equals("204")) {
                                                    this.g.a(r11);
                                                }
                                                this.e.add(r11);
                                                this.f.countDown();
                                            } else if (!this.c) {
                                                this.g.a(r11);
                                            }
                                            if (inputStream4 != null) {
                                                inputStream4.close();
                                            }
                                            if (outputStreamA != null) {
                                                outputStreamA.close();
                                            }
                                            httpURLConnectionA.disconnect();
                                        }
                                        f fVar4 = a.c;
                                        aVar = this.g;
                                        str2 = "responseCode:" + this.g.g;
                                        r12 = fVar4;
                                        aVar.a(false, str2);
                                        r11 = r12;
                                        if (this.e == null) {
                                            if (!this.c) {
                                                this.g.a(r11);
                                            }
                                        } else if (!this.c) {
                                            this.g.a(r11);
                                        }
                                        if (inputStream4 != null) {
                                            inputStream4.close();
                                        }
                                        if (outputStreamA != null) {
                                            outputStreamA.close();
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        ?? r23 = r12;
                                        inputStream3 = null;
                                        r9 = r23;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        inputStream2 = null;
                                        r8 = r12;
                                        if (this.e == null) {
                                            if (!this.c) {
                                                this.g.a(r8);
                                            }
                                        } else if (!this.c) {
                                            this.g.a(r8);
                                        }
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (outputStreamA != null) {
                                            outputStreamA.close();
                                        }
                                        if (httpURLConnectionA != null) {
                                            throw th;
                                        }
                                        httpURLConnectionA.disconnect();
                                        throw th;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    inputStream3 = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    inputStream2 = null;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                outputStreamA = null;
                                inputStream3 = null;
                                a aVar4 = this.g;
                                if (e.getMessage() != null) {
                                    z2 = true;
                                }
                                aVar4.j = z2;
                                com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "参数封装或广告请求报错" + e);
                                this.g.h = System.currentTimeMillis();
                                com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.d, com.kc.cw.ad.internal.c.f.a(R.string.unknown_exception));
                                fVar = a.c;
                                this.g.c(e.getMessage());
                                if (this.e == null) {
                                    if (!this.c) {
                                        this.g.a(fVar);
                                    }
                                } else if (!this.c) {
                                    this.g.a(fVar);
                                }
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                }
                                if (outputStreamA != null) {
                                    outputStreamA.close();
                                }
                                if (httpURLConnectionA == null) {
                                    return;
                                }
                                httpURLConnectionA.disconnect();
                            } catch (Throwable th6) {
                                th = th6;
                                th = th;
                                inputStream2 = null;
                                outputStreamA = null;
                                if (this.e == null) {
                                    if (!this.c) {
                                        this.g.a(r8);
                                    }
                                } else if (!this.c) {
                                    this.g.a(r8);
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (outputStreamA != null) {
                                    outputStreamA.close();
                                }
                                if (httpURLConnectionA != null) {
                                    throw th;
                                }
                                httpURLConnectionA.disconnect();
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            inputStream2 = inputStream;
                            r8 = 0;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        httpURLConnectionA = null;
                    } catch (Throwable th8) {
                        th = th8;
                        httpURLConnectionA = null;
                    }
                    httpURLConnectionA.disconnect();
                } catch (Exception e9) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e9);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        com.kc.cw.ad.internal.d dVar = this.d;
        if (dVar != null) {
            com.kc.cw.ad.internal.o.a(new l("RES", dVar.c(), this.d.e(), System.currentTimeMillis() - this.d.h(), z, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f b(ArrayList<f> arrayList) {
        f fVar = null;
        for (f fVar2 : arrayList) {
            if (fVar == null || fVar2.B() > fVar.B() || fVar2.q() > fVar.q()) {
                fVar = fVar2;
            }
        }
        return fVar;
    }

    public static void b(f fVar) {
        if (fVar != null) {
            b(fVar.f());
            String strG = fVar.g();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            for (String str : strG.split(",")) {
                b(str);
            }
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context contextL = q.a().l();
        C1001a c1001aA = new AdRequest.Builder().build().a();
        com.kc.cw.ad.internal.e.g gVar = new com.kc.cw.ad.internal.e.g(contextL, new FrameLayout(contextL), "");
        gVar.setAdSlotId(str);
        gVar.setIsBoost(true);
        gVar.a(c1001aA);
        gVar.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i) {
        return i == 200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.kc.cw.ad.internal.d dVar = this.d;
        if (dVar != null) {
            com.kc.cw.ad.internal.o.a(new l("TIMEOUT", dVar.c(), this.d.e(), System.currentTimeMillis() - this.d.h(), "80003 " + str));
        }
    }

    public String a(com.kc.cw.ad.internal.d dVar, boolean z) {
        String strJ;
        try {
            Context contextL = q.a().l();
            boolean z2 = dVar.p() == com.kc.cw.ad.internal.p.PREFETCH;
            q qVarA = q.a();
            com.kc.cw.ad.internal.c.a aVarA = com.kc.cw.ad.internal.c.a.a();
            com.kc.cw.ad.a.f.a aVarA2 = new com.kc.cw.ad.a.f.a.C0967a().a(aVarA.c).l(com.kc.cw.ad.internal.c.a.o).m(com.kc.cw.ad.internal.c.a.p).b(com.kc.cw.ad.d.a.b.a(contextL)).n(com.kc.cw.ad.d.a.b.e(contextL)).p(com.kc.cw.ad.d.b.g.a(contextL)).q(com.kc.cw.ad.d.b.g.a()).r(com.kc.cw.ad.d.b.g.c(contextL)).s(com.kc.cw.ad.d.b.g.b(contextL)).t(aVarA.s).u(aVarA.t).c("").d(aVarA.h).a(com.kc.cw.ad.a.g.e.PLATFORM_ANDROID).a(aVarA.i).e(aVarA.j).f(aVarA.k).g(aVarA.l).h(aVarA.m).i(aVarA.n).j(aVarA.q).k(aVarA.r).o(aVarA.e).v(aVarA.w).w(aVarA.x).x(aVarA.y).y(aVarA.z).z(aVarA.A).A(aVarA.B).B(aVarA.C).C(aVarA.D).a(aVarA.E).D(com.kc.cw.ad.internal.c.a.u).E(com.kc.cw.ad.internal.c.a.v).F(aVarA.F).b(aVarA.f).c(aVarA.g).a();
            r rVarA = r.a();
            com.kc.cw.ad.a.f.c cVarA = new com.kc.cw.ad.a.f.c.a().a(rVarA.f38953a).a(rVarA.b).a();
            com.kc.cw.ad.a.f.b bVar = new com.kc.cw.ad.a.f.b();
            bVar.a(com.kc.cw.ad.internal.c.l.a().b);
            String strK = qVarA.k();
            if ("OctopusGroup".equals(dVar.d())) {
                strJ = qVarA.i();
                if (!TextUtils.isEmpty(strJ)) {
                    strK = strJ;
                }
            } else {
                strJ = qVarA.j();
                if (!TextUtils.isEmpty(strJ)) {
                    strK = strJ;
                }
            }
            this.e = "OctopusGroup".equals(dVar.d()) ? dVar.e() : dVar.a();
            com.kc.cw.ad.a.b.C0964b.a aVarC = new com.kc.cw.ad.a.b.C0964b.a().a("2.6.1.8").b(i.f(contextL)).a(com.kc.cw.ad.a.g.i.SRC_APP).e(s.b(contextL)).a(z2 ? com.kc.cw.ad.a.g.EnumC0968g.REQ_WIFI_PRELOAD : com.kc.cw.ad.a.g.EnumC0968g.REQ_AD).a(System.currentTimeMillis()).c(strK).d(this.e).a(this.f).a(aVarA2).a(cVarA).a(bVar).e(i.e(contextL)).f(i.h(contextL)).g(i.d(contextL)).b(i.a(contextL)).c(i.c(contextL));
            SSAdSdkController customController = SSAd.getCustomController();
            if (customController != null) {
                aVarC.a(customController.isCanShake());
                if (customController.getShakeValue() != null) {
                    aVarC.a(customController.getShakeValue());
                }
            }
            if (z2) {
                for (String str : q.a().s()) {
                    if (!p.a(str)) {
                        aVarC.a(new com.kc.cw.ad.a.b.a.C0963a().a(str).c(dVar.a()).a());
                    }
                }
            } else {
                aVarC.a(new com.kc.cw.ad.a.b.a.C0963a().a(dVar.c()).c(dVar.a()).b(dVar.r()).a());
            }
            com.kc.cw.ad.a.b.C0964b c0964bA = aVarC.a();
            Boolean bool = (Boolean) o.c(contextL, "encrypt", Boolean.TRUE);
            if (bool != null && !bool.booleanValue() && !z) {
                return c0964bA.toString();
            }
            String strA = com.kc.cw.ad.d.b.a.a(com.kc.cw.ad.d.b.e.a(), c0964bA.toString());
            return strA == null ? "" : strA;
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(f fVar) {
        if (this.l) {
            return;
        }
        this.l = true;
        ThreadUtils.runOnUIThread(new Runnable(this, fVar) { // from class: com.kc.cw.ad.internal.b.a.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final f f38868a;
            final a b;

            {
                this.b = this;
                this.f38868a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar;
                String str;
                if (this.f38868a == null || this.b.d == null) {
                    com.kc.cw.ad.internal.c.f.a(com.kc.cw.ad.internal.c.f.e, com.kc.cw.ad.internal.c.f.a(R.string.no_response));
                    this.b.a(80100);
                    aVar = this.b;
                    str = "80100 response is null";
                } else {
                    if (this.f38868a.v()) {
                        int i = q.a().f39051a;
                        if (this.b.j || i == 0 || System.currentTimeMillis() - this.b.i > i) {
                            this.b.a(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
                            return;
                        }
                        Log.i("OctopusAd", "80003重试");
                        this.b.d.a(p.a());
                        this.b.f = 1;
                        if (this.b.k) {
                            return;
                        }
                        this.b.a("");
                        return;
                    }
                    if (!"204".equals(this.f38868a.i())) {
                        com.kc.cw.ad.internal.e eVar = (com.kc.cw.ad.internal.e) this.b.b.get();
                        if (eVar != null) {
                            this.b.a(true, "");
                            eVar.a(this.f38868a);
                            return;
                        } else {
                            this.b.a(80100);
                            this.b.a(false, "80100 adRequestDelegate is null");
                            return;
                        }
                    }
                    a.b(this.f38868a);
                    this.b.a(80100);
                    aVar = this.b;
                    str = "80100 response code is 204";
                }
                aVar.a(false, str);
            }
        });
    }

    public void a(com.kc.cw.ad.internal.e eVar) {
        int i;
        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "setDelegate");
        this.b = new SoftReference<>(eVar);
        Context contextL = q.a().l();
        if (contextL != null) {
            q.a().e();
            com.kc.cw.ad.internal.c.b.a(contextL);
            s.a(contextL);
            m.a(contextL);
            if (g.a(contextL).b(contextL)) {
                return;
            } else {
                i = MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL;
            }
        } else {
            i = MediationConstant.ErrorCode.ADN_AD_NO_CACHE;
        }
        a(i);
    }

    public void a(String str) {
        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "开始请求封装参数");
        if (this.i == 0) {
            this.i = System.currentTimeMillis();
        }
        this.h = System.currentTimeMillis();
        com.kc.cw.ad.internal.e eVar = this.b.get();
        Context contextL = q.a().l();
        if (contextL == null || eVar == null) {
            return;
        }
        com.kc.cw.ad.internal.d dVarB = eVar.b();
        this.d = dVarB;
        if (dVarB != null) {
            dVarB.b(this.h);
            com.kc.cw.ad.internal.o.a(new l("REQ", this.d.c(), this.d.e(), this.f));
            ThreadUtils.runOnThreadPool(new AnonymousClass1(this, str, contextL));
        }
    }
}
