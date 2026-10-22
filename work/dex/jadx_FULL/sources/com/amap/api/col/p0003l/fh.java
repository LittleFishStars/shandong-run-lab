package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.baichuan.log.TLogConstant;
import com.alipay.sdk.m.y.l;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.maps.AMapException;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.a7b;
import com.zj.adlib.g9b;
import com.zj.adlib.i9b;
import com.zj.adlib.j4b;
import com.zj.adlib.lbb;
import com.zj.adlib.mbb;
import com.zj.adlib.n4b;
import com.zj.adlib.p4b;
import com.zj.adlib.r4b;
import com.zj.adlib.r8b;
import com.zj.adlib.s4b;
import com.zj.adlib.s6b;
import com.zj.adlib.v6b;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f25939a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Context f838a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f839a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile boolean f845a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f846b = "6";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static String f849c = "4";

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static String f852d = "9";
    public static String e = "8";
    public static volatile boolean i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Vector<f> f843a = new Vector<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<String, Integer> f841a = new HashMap();
    public static String f = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static long f837a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static volatile boolean f848b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile ConcurrentHashMap<String, h> f844a = new ConcurrentHashMap<>(8);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static volatile ConcurrentHashMap<String, Long> f847b = new ConcurrentHashMap<>(8);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static volatile ConcurrentHashMap<String, e> f850c = new ConcurrentHashMap<>(8);

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static boolean f851c = false;
    public static int b = 5000;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static boolean f854d = true;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static boolean f856e = false;
    public static int c = 3;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static boolean f857f = true;
    public static boolean g = false;
    public static int d = 3;
    public static boolean h = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static ConcurrentHashMap<String, Boolean> f853d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static ConcurrentHashMap<String, Boolean> f855e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ArrayList<u.a> f840a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Queue<u.c> f842a = new LinkedList();

    public interface a {
        void a(c cVar);
    }

    public static class b extends it {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        public b(String str, String str2, String str3, String str4) {
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = str4;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            e eVar = (e) fh.f850c.get(this.f);
            if (eVar == null) {
                return;
            }
            a aVar = eVar.f25943a;
            c cVarB = fh.b(fh.f838a, eVar.f865a, eVar.f866a, this.g, this.h, this.i);
            if (cVarB == null || aVar == null) {
                return;
            }
            aVar.a(cVarB);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25940a = -1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f858a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public a f859a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public b f860a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f861a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Deprecated
        public JSONObject f862a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f863a;

        @Deprecated
        public JSONObject b;
        public JSONObject c;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public JSONObject f25941a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f864a;
            public boolean b;
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f25942a;
        }
    }

    public static class d extends hm {
        public Map<String, String> c;
        public String f;
        public String k;
        public String l;
        public String m;

        public d(Context context, r4b r4bVar, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, r4bVar);
            this.f = str;
            this.c = map;
            this.k = str2;
            this.l = str3;
            this.m = str4;
            setHttpProtocol(hs.c.HTTPS);
            setDegradeAbility(hs.a.FIX);
        }

        public static String m(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.p0003l.hm
        public final byte[] c() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.hm
        public final byte[] d() {
            String strE0 = fj.e0(((hm) this).f25968a);
            if (!TextUtils.isEmpty(strE0)) {
                strE0 = p4b.d(new StringBuilder(strE0).reverse().toString());
            }
            HashMap map = new HashMap();
            map.put("authkey", TextUtils.isEmpty(this.f) ? "" : this.f);
            map.put("plattype", "android");
            map.put("ccver", "1");
            map.put(ze1.n, ((hm) this).b.a());
            map.put("version", ((hm) this).b.e());
            map.put(com.alibaba.ariver.remotedebug.b.c.g, "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            map.put("androidversion", sb.toString());
            map.put("deviceId", strE0);
            map.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map2 = this.c;
            if (map2 != null && !map2.isEmpty()) {
                map.putAll(this.c);
            }
            map.put("abitype", s4b.d(((hm) this).f25968a));
            map.put(LoginConstants.EXT, ((hm) this).b.g());
            return s4b.p(s4b.f(map));
        }

        @Override // com.amap.api.col.p0003l.hm
        public final String e() {
            return "3.0";
        }

        @Override // com.amap.api.col.p0003l.hs
        public final String getIPDNSName() {
            return !TextUtils.isEmpty(this.m) ? this.m : super.getIPDNSName();
        }

        @Override // com.amap.api.col.p0003l.fm, com.amap.api.col.p0003l.hs
        public final String getIPV6URL() {
            return m("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.l);
        }

        @Override // com.amap.api.col.p0003l.hs
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.m)) {
                return null;
            }
            HashMap map = new HashMap();
            map.put(com.alipay.sdk.m.n.c.f, this.m);
            return map;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final String getURL() {
            return m("https://restsdk.amap.com/v3/iasdkauth", this.k);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f25943a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public r4b f865a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f866a;

        public e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25944a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public AtomicInteger f867a;
        public String b;

        public f(String str, String str2, int i) {
            this.f25944a = str;
            this.b = str2;
            this.f867a = new AtomicInteger(i);
        }

        public static f d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new f(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt(y6b.g));
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f867a;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f25944a);
                jSONObject.put("f", this.b);
                jSONObject.put(y6b.g, this.f867a.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f25945a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static boolean f868a = true;
        public static int b = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public static boolean f869b = false;
        public static boolean c = true;
        public static boolean d = false;
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f25946a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f870a;

        public h(Long l, String str) {
            this.f25946a = 0L;
            this.f870a = "";
            this.f25946a = l.longValue();
            this.f870a = str;
        }
    }

    public static r4b A(String str) {
        e eVar = f850c.get(str);
        if (eVar != null) {
            return eVar.f865a;
        }
        return null;
    }

    public static String B(String str, String str2) {
        return str2 + LoginConstants.UNDER_LINE + p4b.b(str.getBytes());
    }

    public static String C(List<String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void D(Context context) {
        if (context == null) {
            return;
        }
        f845a = r8b.k(context, "open_common", "a2", true);
    }

    public static void E(u.c cVar) {
        synchronized (f840a) {
            boolean z = false;
            for (int i2 = 0; i2 < f840a.size(); i2++) {
                u.a aVar = f840a.get(i2);
                if (cVar.g.equals(aVar.f) && cVar.h.equals(aVar.i)) {
                    int i3 = cVar.K;
                    int i4 = aVar.L;
                    if (i3 == i4) {
                        z = true;
                        if (i4 == 1) {
                            aVar.f26054a = ((((long) aVar.f1101a.get()) * aVar.f26054a) + cVar.f26056a) / ((long) (aVar.f1101a.get() + 1));
                        }
                        aVar.f1101a.getAndIncrement();
                    }
                }
            }
            if (!z) {
                f840a.add(new u.a(cVar));
            }
            u.s();
        }
    }

    public static synchronized void F(String str, boolean z) {
        r(str, z, null, null, null);
    }

    public static boolean G() {
        Integer num;
        Context context = f838a;
        if (context == null) {
            return false;
        }
        String strD0 = fj.d0(context);
        return (TextUtils.isEmpty(strD0) || (num = f841a.get(strD0.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static String H(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;17S;183";
    }

    public static void I(Context context) {
        if (context == null) {
            return;
        }
        f854d = r8b.k(context, "open_common", "a13", true);
        f857f = r8b.k(context, "open_common", "a6", true);
        f856e = r8b.k(context, "open_common", "a7", false);
        b = r8b.a(context, "open_common", "a8", 5000);
        c = r8b.a(context, "open_common", "a9", 3);
        g = r8b.k(context, "open_common", "a10", false);
        d = r8b.a(context, "open_common", "a11", 3);
        h = r8b.k(context, "open_common", "a12", false);
    }

    public static void J(u.c cVar) {
        if (cVar != null && h) {
            synchronized (f842a) {
                f842a.offer(cVar);
                u.s();
            }
        }
    }

    public static boolean K() {
        Integer num;
        Context context = f838a;
        if (context == null) {
            return false;
        }
        String strD0 = fj.d0(context);
        return (TextUtils.isEmpty(strD0) || (num = f841a.get(strD0.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void L() {
        try {
            f fVarE = e(f838a, "IPV6_CONFIG_NAME", "open_common");
            String strC = s4b.c(System.currentTimeMillis(), "yyyyMMdd");
            if (!strC.equals(fVarE.b)) {
                fVarE.c(strC);
                fVarE.f867a.set(0);
            }
            fVarE.f867a.incrementAndGet();
            m(f838a, "IPV6_CONFIG_NAME", "open_common", fVarE);
        } catch (Throwable unused) {
        }
    }

    public static void M(Context context) {
        try {
            if (f851c) {
                return;
            }
            s6b.f19529a = r8b.k(context, "open_common", "a4", true);
            s6b.f19532b = r8b.k(context, "open_common", "a5", true);
            f851c = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized boolean N(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f850c == null) {
                return false;
            }
            if (f847b == null) {
                f847b = new ConcurrentHashMap<>(8);
            }
            if (f850c.containsKey(str) && !f847b.containsKey(str)) {
                f847b.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
        } catch (Throwable th) {
            v6b.b(th, t.u, "cslct");
        }
        return false;
    }

    public static void O() {
        if (f848b) {
            return;
        }
        try {
            Context context = f838a;
            if (context == null) {
                return;
            }
            f848b = true;
            n4b.a().c(context);
            D(context);
            I(context);
            g.f868a = r8b.k(context, "open_common", "ucf", g.f868a);
            g.f869b = r8b.k(context, "open_common", "fsv2", g.f869b);
            g.c = r8b.k(context, "open_common", "usc", g.c);
            g.f25945a = r8b.a(context, "open_common", "umv", g.f25945a);
            g.d = r8b.k(context, "open_common", "ust", g.d);
            g.b = r8b.a(context, "open_common", "ustv", g.b);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void P(String str) {
        if (f847b == null) {
            return;
        }
        if (f847b.containsKey(str)) {
            f847b.remove(str);
        }
    }

    public static synchronized h Q(String str) {
        try {
            if (f844a == null) {
                f844a = new ConcurrentHashMap<>(8);
            }
            if (f844a.containsKey(str)) {
                return f844a.get(str);
            }
            return new h(0L, "");
        } catch (Throwable th) {
            v6b.b(th, t.u, "glcut");
        }
        throw th;
    }

    public static u.a R() {
        if (i) {
            return null;
        }
        synchronized (f840a) {
            if (i) {
                return null;
            }
            Collections.sort(f840a);
            if (f840a.size() <= 0) {
                return null;
            }
            u.a aVarClone = f840a.get(0).clone();
            i = true;
            return aVarClone;
        }
    }

    public static u.c S() {
        synchronized (f842a) {
            u.c cVarPoll = f842a.poll();
            if (cVarPoll != null) {
                return cVarPoll;
            }
            return null;
        }
    }

    public static boolean T(String str) {
        f fVarE;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f854d) {
                return false;
            }
            if (!(f853d.get(str) == null)) {
                return false;
            }
            Context context = f838a;
            return context == null || (fVarE = e(context, B(str, "a14"), "open_common")) == null || fVarE.a() < c;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean V(String str) {
        f fVarE;
        try {
            if (TextUtils.isEmpty(str) || !g) {
                return false;
            }
            if (!(f855e.get(str) == null)) {
                return false;
            }
            Context context = f838a;
            if (context == null || (fVarE = e(context, B(str, "a15"), "open_common")) == null || fVarE.a() < d) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void W() {
        try {
            Context context = f838a;
            if (context != null) {
                String strD0 = fj.d0(context);
                if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(strD0) && f.equals(strD0) && System.currentTimeMillis() - f837a < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(strD0)) {
                    f = strD0;
                }
            } else if (System.currentTimeMillis() - f837a < 10000) {
                return;
            }
            f837a = System.currentTimeMillis();
            f841a.clear();
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    Iterator<InterfaceAddress> it = networkInterface.getInterfaceAddresses().iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        InetAddress address = it.next().getAddress();
                        if (address instanceof Inet6Address) {
                            if (!y((Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!y(inet4Address) && !inet4Address.getHostAddress().startsWith(s4b.v("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f841a.put(NetworkUtil.NETWORK_TYPE_WIFI, Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f841a.put("MOBILE", Integer.valueOf(i2));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            v6b.b(th, t.u, "ipstack");
        }
    }

    public static long a(List<String> list) {
        if (list == null) {
            return 0L;
        }
        try {
            if (list.size() <= 0) {
                return 0L;
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.valueOf(str).longValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static c b(Context context, r4b r4bVar, String str, String str2, String str3, String str4) {
        return d(context, r4bVar, str, null, str2, str3, str4);
    }

    public static c c(Context context, r4b r4bVar, String str, Map<String, String> map) {
        return z(context, r4bVar, str, map);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0201 A[Catch: all -> 0x0254, TRY_LEAVE, TryCatch #12 {all -> 0x0254, blocks: (B:84:0x01ab, B:86:0x01b6, B:88:0x01bd, B:111:0x0219, B:113:0x0221, B:110:0x0216, B:92:0x01c8, B:94:0x01d1, B:96:0x01df, B:97:0x01e5, B:99:0x01ef, B:100:0x01f3, B:102:0x0201, B:105:0x0208, B:107:0x020e), top: B:127:0x01ab, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x020e A[Catch: all -> 0x0215, TRY_LEAVE, TryCatch #14 {all -> 0x0215, blocks: (B:105:0x0208, B:107:0x020e), top: B:128:0x0208, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0221 A[Catch: all -> 0x0254, TRY_LEAVE, TryCatch #12 {all -> 0x0254, blocks: (B:84:0x01ab, B:86:0x01b6, B:88:0x01bd, B:111:0x0219, B:113:0x0221, B:110:0x0216, B:92:0x01c8, B:94:0x01d1, B:96:0x01df, B:97:0x01e5, B:99:0x01ef, B:100:0x01f3, B:102:0x0201, B:105:0x0208, B:107:0x020e), top: B:127:0x01ab, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0245 A[Catch: all -> 0x0258, TryCatch #15 {all -> 0x0258, blocks: (B:114:0x0228, B:116:0x0245, B:117:0x024c), top: B:131:0x0228 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x024c A[Catch: all -> 0x0258, TRY_LEAVE, TryCatch #15 {all -> 0x0258, blocks: (B:114:0x0228, B:116:0x0245, B:117:0x024c), top: B:131:0x0228 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0193 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x0194  */
    /* JADX WARN: Code duplicated, block: B:80:0x019a  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b6 A[Catch: all -> 0x0254, TryCatch #12 {all -> 0x0254, blocks: (B:84:0x01ab, B:86:0x01b6, B:88:0x01bd, B:111:0x0219, B:113:0x0221, B:110:0x0216, B:92:0x01c8, B:94:0x01d1, B:96:0x01df, B:97:0x01e5, B:99:0x01ef, B:100:0x01f3, B:102:0x0201, B:105:0x0208, B:107:0x020e), top: B:127:0x01ab, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01bd A[Catch: all -> 0x0254, TryCatch #12 {all -> 0x0254, blocks: (B:84:0x01ab, B:86:0x01b6, B:88:0x01bd, B:111:0x0219, B:113:0x0221, B:110:0x0216, B:92:0x01c8, B:94:0x01d1, B:96:0x01df, B:97:0x01e5, B:99:0x01ef, B:100:0x01f3, B:102:0x0201, B:105:0x0208, B:107:0x020e), top: B:127:0x01ab, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c8 A[Catch: all -> 0x0254, TryCatch #12 {all -> 0x0254, blocks: (B:84:0x01ab, B:86:0x01b6, B:88:0x01bd, B:111:0x0219, B:113:0x0221, B:110:0x0216, B:92:0x01c8, B:94:0x01d1, B:96:0x01df, B:97:0x01e5, B:99:0x01ef, B:100:0x01f3, B:102:0x0201, B:105:0x0208, B:107:0x020e), top: B:127:0x01ab, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:96:0x01df A[Catch: all -> 0x0254, TryCatch #12 {all -> 0x0254, blocks: (B:84:0x01ab, B:86:0x01b6, B:88:0x01bd, B:111:0x0219, B:113:0x0221, B:110:0x0216, B:92:0x01c8, B:94:0x01d1, B:96:0x01df, B:97:0x01e5, B:99:0x01ef, B:100:0x01f3, B:102:0x0201, B:105:0x0208, B:107:0x020e), top: B:127:0x01ab, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01ef A[Catch: all -> 0x0254, TryCatch #12 {all -> 0x0254, blocks: (B:84:0x01ab, B:86:0x01b6, B:88:0x01bd, B:111:0x0219, B:113:0x0221, B:110:0x0216, B:92:0x01c8, B:94:0x01d1, B:96:0x01df, B:97:0x01e5, B:99:0x01ef, B:100:0x01f3, B:102:0x0201, B:105:0x0208, B:107:0x020e), top: B:127:0x01ab, inners: #14 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10, types: [com.amap.api.col.3l.fh$c] */
    /* JADX WARN: Type inference failed for: r13v14, types: [com.amap.api.col.3l.fh$c] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [com.amap.api.col.3l.fh$c] */
    public static c d(Context context, r4b r4bVar, String str, Map<String, String> map, String str2, String str3, String str4) throws ff {
        String str5;
        String str6;
        String str7;
        String str8;
        String strH;
        i9b i9bVarE;
        byte[] bArr;
        ?? r13;
        String str9;
        String str10;
        JSONObject jSONObject;
        int i2;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        JSONObject jSONObject2;
        boolean zX;
        String str16 = "infocode";
        ?? r14 = "result";
        String str17 = "ver";
        c cVar = new c();
        cVar.c = new JSONObject();
        if (context != null) {
            f838a = context.getApplicationContext();
        }
        O();
        String strG = null;
        try {
            o(r4bVar);
            new hl();
            boolean zIsEmpty = TextUtils.isEmpty(str);
            try {
                if (zIsEmpty) {
                    strH = str;
                } else {
                    try {
                        strH = H(str);
                    } catch (ff e2) {
                        e = e2;
                        throw e;
                    } catch (Throwable unused) {
                        throw new ff(AMapException.ERROR_UNKNOWN);
                    }
                }
                try {
                    M(context);
                    str7 = "result";
                    String str18 = strH;
                    r14 = cVar;
                    str8 = "ver";
                    str17 = t.u;
                    str5 = "infocode";
                    str16 = "lc";
                    str6 = AliyunLogCommon.LogLevel.INFO;
                    try {
                        i9bVarE = hl.e(new d(context, r4bVar, str18, map, str2, str3, str4));
                        if (zIsEmpty) {
                            return r14;
                        }
                        if (i9bVarE != null) {
                            try {
                                bArr = i9bVarE.f17171a;
                                try {
                                    try {
                                        Map<String, List<String>> map2 = i9bVarE.f17169a;
                                        if (map2 != null && map2.containsKey("lct")) {
                                            List<String> list = map2.get("lct");
                                            List<String> list2 = map2.get("lct-info");
                                            r14.f858a = a(list);
                                            String strC = C(list2);
                                            if (r14.f858a != 0 && r4bVar != null) {
                                                String strA = r4bVar.a();
                                                if (!TextUtils.isEmpty(strA)) {
                                                    p(strA, r14.f858a, strC);
                                                }
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                        a7b.m(th, str17, "lct");
                                    }
                                } catch (ff e3) {
                                    e = e3;
                                    r14.f861a = e.a();
                                    h(context, r4bVar, e.a());
                                    a7b.g(r4bVar, "/v3/iasdkauth", e);
                                    r13 = r14;
                                } catch (IllegalBlockSizeException e4) {
                                    e = e4;
                                    k(context, r4bVar, e);
                                    r13 = r14;
                                } catch (Throwable th2) {
                                    th = th2;
                                    a7b.m(th, str17, str16);
                                    k(context, r4bVar, th);
                                    r13 = r14;
                                }
                            } catch (ff e5) {
                                e = e5;
                                bArr = null;
                                r14.f861a = e.a();
                                h(context, r4bVar, e.a());
                                a7b.g(r4bVar, "/v3/iasdkauth", e);
                                r13 = r14;
                            } catch (IllegalBlockSizeException e6) {
                                e = e6;
                                bArr = null;
                                k(context, r4bVar, e);
                                r13 = r14;
                            } catch (Throwable th3) {
                                th = th3;
                                bArr = null;
                                a7b.m(th, str17, str16);
                                k(context, r4bVar, th);
                                r13 = r14;
                            }
                        } else {
                            bArr = null;
                        }
                        byte[] bArr2 = new byte[16];
                        byte[] bArr3 = new byte[bArr.length - 16];
                        System.arraycopy(bArr, 0, bArr2, 0, 16);
                        System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, s4b.v("EQUVT"));
                        Cipher cipher = Cipher.getInstance(s4b.v("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
                        cipher.init(2, secretKeySpec, new IvParameterSpec(s4b.w()));
                        strG = s4b.g(cipher.doFinal(bArr3));
                        r13 = r14;
                        str9 = strH;
                        if (bArr == null) {
                            return r13;
                        }
                        if (TextUtils.isEmpty(strG)) {
                            strG = s4b.g(bArr);
                        }
                        str10 = strG;
                        if (TextUtils.isEmpty(str10)) {
                            h(context, r4bVar, "result is null");
                        }
                        try {
                            jSONObject = new JSONObject(str10);
                            if (jSONObject.has("status")) {
                                i2 = jSONObject.getInt("status");
                                if (i2 == 1) {
                                    f25939a = 1;
                                } else if (i2 == 0) {
                                    if (i9bVarE != null) {
                                        str11 = i9bVarE.f42307a;
                                        str12 = i9bVarE.b;
                                    } else {
                                        str11 = "authcsid";
                                        str12 = "authgsid";
                                    }
                                    s4b.j(context, str11, str12, jSONObject);
                                    f25939a = 0;
                                    str13 = str6;
                                    if (jSONObject.has(str13)) {
                                        f839a = jSONObject.getString(str13);
                                    }
                                    String str19 = str5;
                                    a7b.i(r4bVar, "/v3/iasdkauth", f839a, str12, str11, jSONObject.has(str19) ? jSONObject.getString(str19) : "");
                                    if (f25939a == 0) {
                                        r13.f861a = f839a;
                                        return r13;
                                    }
                                }
                                str14 = str8;
                                try {
                                    if (jSONObject.has(str14)) {
                                        r13.f25940a = jSONObject.getInt(str14);
                                    }
                                } catch (Throwable th4) {
                                    v6b.b(th4, str17, str16);
                                }
                                str15 = str7;
                                if (s4b.n(jSONObject, str15)) {
                                    JSONObject jSONObject3 = jSONObject.getJSONObject(str15);
                                    j(context, r4bVar, str9, r13, jSONObject3);
                                    try {
                                        jSONObject2 = jSONObject3.getJSONObject("15K");
                                        zX = x(jSONObject2.optString("isTargetAble"), false);
                                        if (x(jSONObject2.optString("able"), false)) {
                                            n4b.a().d(context, zX);
                                        } else {
                                            n4b.a();
                                            n4b.f(context);
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            v6b.b(th5, str17, str16);
                        }
                        return r13;
                    } catch (ff e7) {
                        throw e7;
                    } catch (Throwable unused3) {
                        throw new ff(AMapException.ERROR_UNKNOWN);
                    }
                } catch (ff e8) {
                    e = e8;
                    throw e;
                } catch (Throwable unused4) {
                    throw new ff(AMapException.ERROR_UNKNOWN);
                }
            } catch (ff e9) {
                e = e9;
                i9bVarE = null;
                bArr = null;
                r14.f861a = e.a();
                h(context, r4bVar, e.a());
                a7b.g(r4bVar, "/v3/iasdkauth", e);
                r13 = r14;
                str9 = strH;
                if (bArr == null) {
                    return r13;
                }
                if (TextUtils.isEmpty(strG)) {
                    strG = s4b.g(bArr);
                }
                str10 = strG;
                if (TextUtils.isEmpty(str10)) {
                    h(context, r4bVar, "result is null");
                }
                jSONObject = new JSONObject(str10);
                if (jSONObject.has("status")) {
                    i2 = jSONObject.getInt("status");
                    if (i2 == 1) {
                        f25939a = 1;
                    } else if (i2 == 0) {
                        if (i9bVarE != null) {
                            str11 = i9bVarE.f42307a;
                            str12 = i9bVarE.b;
                        } else {
                            str11 = "authcsid";
                            str12 = "authgsid";
                        }
                        s4b.j(context, str11, str12, jSONObject);
                        f25939a = 0;
                        str13 = str6;
                        if (jSONObject.has(str13)) {
                            f839a = jSONObject.getString(str13);
                        }
                        String str110 = str5;
                        if (jSONObject.has(str110)) {
                        }
                        a7b.i(r4bVar, "/v3/iasdkauth", f839a, str12, str11, jSONObject.has(str110) ? jSONObject.getString(str110) : "");
                        if (f25939a == 0) {
                            r13.f861a = f839a;
                            return r13;
                        }
                    }
                    str14 = str8;
                    if (jSONObject.has(str14)) {
                        r13.f25940a = jSONObject.getInt(str14);
                    }
                    str15 = str7;
                    if (s4b.n(jSONObject, str15)) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject(str15);
                        j(context, r4bVar, str9, r13, jSONObject4);
                        jSONObject2 = jSONObject4.getJSONObject("15K");
                        zX = x(jSONObject2.optString("isTargetAble"), false);
                        if (x(jSONObject2.optString("able"), false)) {
                            n4b.a();
                            n4b.f(context);
                        } else {
                            n4b.a().d(context, zX);
                        }
                    }
                }
                return r13;
            } catch (IllegalBlockSizeException e10) {
                e = e10;
                i9bVarE = null;
                bArr = null;
                k(context, r4bVar, e);
                r13 = r14;
                str9 = strH;
                if (bArr == null) {
                    return r13;
                }
                if (TextUtils.isEmpty(strG)) {
                    strG = s4b.g(bArr);
                }
                str10 = strG;
                if (TextUtils.isEmpty(str10)) {
                    h(context, r4bVar, "result is null");
                }
                jSONObject = new JSONObject(str10);
                if (jSONObject.has("status")) {
                    i2 = jSONObject.getInt("status");
                    if (i2 == 1) {
                        f25939a = 1;
                    } else if (i2 == 0) {
                        if (i9bVarE != null) {
                            str11 = i9bVarE.f42307a;
                            str12 = i9bVarE.b;
                        } else {
                            str11 = "authcsid";
                            str12 = "authgsid";
                        }
                        s4b.j(context, str11, str12, jSONObject);
                        f25939a = 0;
                        str13 = str6;
                        if (jSONObject.has(str13)) {
                            f839a = jSONObject.getString(str13);
                        }
                        String str111 = str5;
                        if (jSONObject.has(str111)) {
                        }
                        a7b.i(r4bVar, "/v3/iasdkauth", f839a, str12, str11, jSONObject.has(str111) ? jSONObject.getString(str111) : "");
                        if (f25939a == 0) {
                            r13.f861a = f839a;
                            return r13;
                        }
                    }
                    str14 = str8;
                    if (jSONObject.has(str14)) {
                        r13.f25940a = jSONObject.getInt(str14);
                    }
                    str15 = str7;
                    if (s4b.n(jSONObject, str15)) {
                        JSONObject jSONObject5 = jSONObject.getJSONObject(str15);
                        j(context, r4bVar, str9, r13, jSONObject5);
                        jSONObject2 = jSONObject5.getJSONObject("15K");
                        zX = x(jSONObject2.optString("isTargetAble"), false);
                        if (x(jSONObject2.optString("able"), false)) {
                            n4b.a();
                            n4b.f(context);
                        } else {
                            n4b.a().d(context, zX);
                        }
                    }
                }
                return r13;
            } catch (Throwable th6) {
                th = th6;
                i9bVarE = null;
                bArr = null;
                a7b.m(th, str17, str16);
                k(context, r4bVar, th);
                r13 = r14;
                str9 = strH;
                if (bArr == null) {
                    return r13;
                }
                if (TextUtils.isEmpty(strG)) {
                    strG = s4b.g(bArr);
                }
                str10 = strG;
                if (TextUtils.isEmpty(str10)) {
                    h(context, r4bVar, "result is null");
                }
                jSONObject = new JSONObject(str10);
                if (jSONObject.has("status")) {
                    i2 = jSONObject.getInt("status");
                    if (i2 == 1) {
                        f25939a = 1;
                    } else if (i2 == 0) {
                        if (i9bVarE != null) {
                            str11 = i9bVarE.f42307a;
                            str12 = i9bVarE.b;
                        } else {
                            str11 = "authcsid";
                            str12 = "authgsid";
                        }
                        s4b.j(context, str11, str12, jSONObject);
                        f25939a = 0;
                        str13 = str6;
                        if (jSONObject.has(str13)) {
                            f839a = jSONObject.getString(str13);
                        }
                        String str112 = str5;
                        if (jSONObject.has(str112)) {
                        }
                        a7b.i(r4bVar, "/v3/iasdkauth", f839a, str12, str11, jSONObject.has(str112) ? jSONObject.getString(str112) : "");
                        if (f25939a == 0) {
                            r13.f861a = f839a;
                            return r13;
                        }
                    }
                    str14 = str8;
                    if (jSONObject.has(str14)) {
                        r13.f25940a = jSONObject.getInt(str14);
                    }
                    str15 = str7;
                    if (s4b.n(jSONObject, str15)) {
                        JSONObject jSONObject6 = jSONObject.getJSONObject(str15);
                        j(context, r4bVar, str9, r13, jSONObject6);
                        jSONObject2 = jSONObject6.getJSONObject("15K");
                        zX = x(jSONObject2.optString("isTargetAble"), false);
                        if (x(jSONObject2.optString("able"), false)) {
                            n4b.a();
                            n4b.f(context);
                        } else {
                            n4b.a().d(context, zX);
                        }
                    }
                }
                return r13;
            }
        } catch (ff e11) {
            e = e11;
            str5 = "infocode";
            str6 = AliyunLogCommon.LogLevel.INFO;
            str7 = "result";
            str8 = "ver";
            r14 = cVar;
            str17 = t.u;
            str16 = "lc";
            strH = str;
        } catch (IllegalBlockSizeException e12) {
            e = e12;
            str5 = "infocode";
            str6 = AliyunLogCommon.LogLevel.INFO;
            str7 = "result";
            str8 = "ver";
            r14 = cVar;
            str17 = t.u;
            str16 = "lc";
            strH = str;
        } catch (Throwable th7) {
            th = th7;
            str5 = "infocode";
            str6 = AliyunLogCommon.LogLevel.INFO;
            str7 = "result";
            str8 = "ver";
            r14 = cVar;
            str17 = t.u;
            str16 = "lc";
            strH = str;
        }
    }

    public static synchronized f e(Context context, String str, String str2) {
        f fVar;
        if (!TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                if (i2 >= f843a.size()) {
                    fVar = null;
                    break;
                }
                fVar = f843a.get(i2);
                if (fVar != null && str.equals(fVar.f25944a)) {
                    break;
                }
                i2++;
            }
        } else {
            fVar = null;
            break;
        }
        if (fVar != null) {
            return fVar;
        }
        if (context == null) {
            return null;
        }
        f fVarD = f.d(r8b.o(context, str2, str, ""));
        String strC = s4b.c(System.currentTimeMillis(), "yyyyMMdd");
        if (fVarD == null) {
            fVarD = new f(str, strC, 0);
        }
        if (!strC.equals(fVarD.b)) {
            fVarD.c(strC);
            fVarD.f867a.set(0);
        }
        f843a.add(fVarD);
        return fVarD;
    }

    public static String f(String str) {
        e eVar;
        if (!f850c.containsKey(str) || (eVar = f850c.get(str)) == null) {
            return null;
        }
        return eVar.f866a;
    }

    public static void g(Context context) {
        if (context != null) {
            f838a = context.getApplicationContext();
        }
    }

    public static void h(Context context, r4b r4bVar, String str) {
        HashMap map = new HashMap();
        map.put("amap_sdk_auth_fail", "1");
        map.put("amap_sdk_auth_fail_type", str);
        map.put("amap_sdk_name", r4bVar.a());
        map.put("amap_sdk_version", r4bVar.f());
        String string = new JSONObject(map).toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            lbb lbbVar = new lbb(context, "core", "2.0", "O001");
            lbbVar.a(string);
            mbb.d(lbbVar, context);
        } catch (ff unused) {
        }
    }

    public static synchronized void i(Context context, r4b r4bVar, String str, a aVar) {
        if (context == null || r4bVar == null) {
            return;
        }
        try {
            if (f838a == null) {
                f838a = context.getApplicationContext();
            }
            String strA = r4bVar.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            o(r4bVar);
            if (f850c == null) {
                f850c = new ConcurrentHashMap<>(8);
            }
            if (f847b == null) {
                f847b = new ConcurrentHashMap<>(8);
            }
            if (f844a == null) {
                f844a = new ConcurrentHashMap<>(8);
            }
            if (!f850c.containsKey(strA)) {
                e eVar = new e((byte) 0);
                eVar.f865a = r4bVar;
                eVar.f866a = str;
                eVar.f25943a = aVar;
                f850c.put(strA, eVar);
                f844a.put(strA, new h(Long.valueOf(r8b.n(f838a, "open_common", strA)), r8b.o(f838a, "open_common", strA + "lct-info", "")));
                M(f838a);
            }
        } catch (Throwable th) {
            v6b.b(th, t.u, "rglc");
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:105:0x020e A[Catch: all -> 0x0294, TryCatch #11 {all -> 0x0294, blocks: (B:103:0x0208, B:105:0x020e, B:107:0x024c, B:109:0x0250, B:111:0x0254, B:113:0x0258, B:115:0x025c, B:117:0x0260), top: B:160:0x0208 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x024c A[Catch: all -> 0x0294, TryCatch #11 {all -> 0x0294, blocks: (B:103:0x0208, B:105:0x020e, B:107:0x024c, B:109:0x0250, B:111:0x0254, B:113:0x0258, B:115:0x025c, B:117:0x0260), top: B:160:0x0208 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x029d  */
    /* JADX WARN: Code duplicated, block: B:152:0x02bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x02a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:? A[RETURN, SYNTHETIC] */
    public static void j(Context context, r4b r4bVar, String str, c cVar, JSONObject jSONObject) throws JSONException {
        String str2;
        String str3;
        String str4;
        boolean zX;
        Context context2;
        JSONObject jSONObject2;
        boolean zX2;
        boolean zX3;
        boolean zX4;
        int iOptInt;
        boolean zX5;
        int iOptInt2;
        c.a aVar = new c.a();
        aVar.f864a = false;
        aVar.b = false;
        cVar.f859a = aVar;
        try {
            String[] strArrSplit = str.split(l.b);
            if (strArrSplit != null && strArrSplit.length > 0) {
                int length = strArrSplit.length;
                int i2 = 0;
                while (i2 < length) {
                    String str5 = strArrSplit[i2];
                    if (jSONObject.has(str5)) {
                        cVar.c.putOpt(str5, jSONObject.get(str5));
                    }
                    i2++;
                    strArrSplit = strArrSplit;
                }
            }
        } catch (Throwable th) {
            v6b.b(th, t.u, AliyunLogKey.KEY_CONNECTION);
        }
        if (s4b.n(jSONObject, "16H")) {
            try {
                cVar.f863a = x(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (Throwable th2) {
                v6b.b(th2, "AuthConfigManager", "load 16H");
            }
        }
        if (s4b.n(jSONObject, "11K")) {
            try {
                JSONObject jSONObject3 = jSONObject.getJSONObject("11K");
                aVar.f864a = x(jSONObject3.getString("able"), false);
                if (jSONObject3.has(TLogConstant.TLOG_MODULE_OFF)) {
                    aVar.f25941a = jSONObject3.getJSONObject(TLogConstant.TLOG_MODULE_OFF);
                }
            } catch (Throwable th3) {
                v6b.b(th3, "AuthConfigManager", "load 11K");
            }
        }
        if (s4b.n(jSONObject, "145")) {
            try {
                cVar.f862a = jSONObject.getJSONObject("145");
            } catch (Throwable th4) {
                v6b.b(th4, "AuthConfigManager", "load 145");
            }
        }
        if (s4b.n(jSONObject, "14D")) {
            try {
                cVar.b = jSONObject.getJSONObject("14D");
            } catch (Throwable th5) {
                v6b.b(th5, "AuthConfigManager", "load 14D");
            }
        }
        if (s4b.n(jSONObject, "151")) {
            try {
                JSONObject jSONObject4 = jSONObject.getJSONObject("151");
                c.b bVar = new c.b();
                if (jSONObject4 != null) {
                    bVar.f25942a = x(jSONObject4.optString("able"), false);
                }
                cVar.f860a = bVar;
            } catch (Throwable th6) {
                v6b.b(th6, "AuthConfigManager", "load 151");
            }
        }
        if (s4b.n(jSONObject, "17S")) {
            try {
                JSONObject jSONObject5 = jSONObject.getJSONObject("17S");
                if (jSONObject5 != null && (zX = x(jSONObject5.optString("able"), false)) != f845a) {
                    f845a = zX;
                    if (context != null) {
                        SharedPreferences.Editor editorB = r8b.b(context, "open_common");
                        r8b.j(editorB, "a2", zX);
                        r8b.e(editorB);
                    }
                }
                if (jSONObject5 != null) {
                    boolean zX6 = x(jSONObject5.optString("static_enable"), true);
                    boolean zX7 = x(jSONObject5.optString("static_ip_direct_enable"), false);
                    int iOptInt3 = jSONObject5.optInt("static_timeout", 5) * 1000;
                    int iOptInt4 = jSONObject5.optInt("static_retry", 3);
                    str2 = "ustv";
                    try {
                        boolean zX8 = x(jSONObject5.optString("bgp_enable"), true);
                        str3 = "ust";
                        try {
                            boolean zX9 = x(jSONObject5.optString("bgp_ip_direct_enable"), false);
                            str4 = "umv";
                            try {
                                int iOptInt5 = jSONObject5.optInt("bgp_retry", 3);
                                boolean zX10 = x(jSONObject5.optString("perf_data_upload_enable"), false);
                                if (zX6 != f854d || zX7 != f856e || iOptInt3 != b || iOptInt4 != c || zX8 != f857f || zX9 != g || iOptInt5 != d || zX10 != h) {
                                    f854d = zX6;
                                    f856e = zX7;
                                    b = iOptInt3;
                                    c = iOptInt4;
                                    f857f = zX8;
                                    g = zX9;
                                    d = iOptInt5;
                                    h = zX10;
                                    if (context != null) {
                                        SharedPreferences.Editor editorB2 = r8b.b(context, "open_common");
                                        r8b.j(editorB2, "a13", zX6);
                                        r8b.j(editorB2, "a6", zX8);
                                        r8b.j(editorB2, "a7", zX7);
                                        r8b.g(editorB2, "a8", iOptInt3);
                                        r8b.g(editorB2, "a9", iOptInt4);
                                        r8b.j(editorB2, "a10", zX9);
                                        r8b.g(editorB2, "a11", iOptInt5);
                                        r8b.j(editorB2, "a12", zX10);
                                        r8b.e(editorB2);
                                    }
                                }
                                u.s();
                                u.s();
                                u.s();
                                u.s();
                                u.s();
                            } catch (Throwable th7) {
                                th = th7;
                                v6b.b(th, "AuthConfigManager", "load 17S");
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            str4 = "umv";
                            v6b.b(th, "AuthConfigManager", "load 17S");
                            if (s4b.n(jSONObject, "15K")) {
                                try {
                                    jSONObject2 = jSONObject.getJSONObject("15K");
                                    if (jSONObject2 != null) {
                                        zX2 = x(jSONObject2.optString("ucf"), g.f868a);
                                        zX3 = x(jSONObject2.optString("fsv2"), g.f869b);
                                        zX4 = x(jSONObject2.optString("usc"), g.c);
                                        String str6 = str4;
                                        iOptInt = jSONObject2.optInt(str6, g.f25945a);
                                        String str7 = str3;
                                        zX5 = x(jSONObject2.optString(str7), g.d);
                                        String str8 = str2;
                                        iOptInt2 = jSONObject2.optInt(str8, g.b);
                                        if (zX2 != g.f868a) {
                                        }
                                        g.f868a = zX2;
                                        g.f869b = zX3;
                                        g.c = zX4;
                                        g.f25945a = iOptInt;
                                        g.d = zX5;
                                        g.b = iOptInt2;
                                        context2 = context;
                                        try {
                                            SharedPreferences.Editor editorB3 = r8b.b(context2, "open_common");
                                            r8b.j(editorB3, "ucf", g.f868a);
                                            r8b.j(editorB3, "fsv2", g.f869b);
                                            r8b.j(editorB3, "usc", g.c);
                                            r8b.g(editorB3, str6, g.f25945a);
                                            r8b.j(editorB3, str7, g.d);
                                            r8b.g(editorB3, str8, g.b);
                                            r8b.e(editorB3);
                                        } catch (Throwable unused) {
                                        }
                                    } else {
                                        context2 = context;
                                    }
                                } catch (Throwable th9) {
                                    context2 = context;
                                    v6b.b(th9, "AuthConfigManager", "load 15K");
                                }
                            } else {
                                context2 = context;
                            }
                            if (s4b.n(jSONObject, "183")) {
                                try {
                                    g9b.c(r4bVar, jSONObject.getJSONObject("183"));
                                } catch (Throwable th10) {
                                    v6b.b(th10, "AuthConfigManager", "load 183");
                                }
                            }
                            if (s4b.n(jSONObject, "17I")) {
                                try {
                                    JSONObject jSONObject6 = jSONObject.getJSONObject("17I");
                                    boolean zX11 = x(jSONObject6.optString("na"), false);
                                    boolean zX12 = x(jSONObject6.optString("aa"), false);
                                    s6b.f19529a = zX11;
                                    s6b.f19532b = zX12;
                                    SharedPreferences.Editor editorB4 = r8b.b(context2, "open_common");
                                    r8b.j(editorB4, "a4", zX11);
                                    r8b.j(editorB4, "a5", zX12);
                                    r8b.e(editorB4);
                                } catch (Throwable th11) {
                                    v6b.b(th11, "AuthConfigManager", "load 17I");
                                    return;
                                }
                            }
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        str3 = "ust";
                        str4 = "umv";
                        v6b.b(th, "AuthConfigManager", "load 17S");
                        if (s4b.n(jSONObject, "15K")) {
                            jSONObject2 = jSONObject.getJSONObject("15K");
                            if (jSONObject2 != null) {
                                zX2 = x(jSONObject2.optString("ucf"), g.f868a);
                                zX3 = x(jSONObject2.optString("fsv2"), g.f869b);
                                zX4 = x(jSONObject2.optString("usc"), g.c);
                                String str9 = str4;
                                iOptInt = jSONObject2.optInt(str9, g.f25945a);
                                String str10 = str3;
                                zX5 = x(jSONObject2.optString(str10), g.d);
                                String str11 = str2;
                                iOptInt2 = jSONObject2.optInt(str11, g.b);
                                if (zX2 != g.f868a) {
                                }
                                g.f868a = zX2;
                                g.f869b = zX3;
                                g.c = zX4;
                                g.f25945a = iOptInt;
                                g.d = zX5;
                                g.b = iOptInt2;
                                context2 = context;
                                SharedPreferences.Editor editorB5 = r8b.b(context2, "open_common");
                                r8b.j(editorB5, "ucf", g.f868a);
                                r8b.j(editorB5, "fsv2", g.f869b);
                                r8b.j(editorB5, "usc", g.c);
                                r8b.g(editorB5, str9, g.f25945a);
                                r8b.j(editorB5, str10, g.d);
                                r8b.g(editorB5, str11, g.b);
                                r8b.e(editorB5);
                            } else {
                                context2 = context;
                            }
                        } else {
                            context2 = context;
                        }
                        if (s4b.n(jSONObject, "183")) {
                            g9b.c(r4bVar, jSONObject.getJSONObject("183"));
                        }
                        if (s4b.n(jSONObject, "17I")) {
                            JSONObject jSONObject7 = jSONObject.getJSONObject("17I");
                            boolean zX13 = x(jSONObject7.optString("na"), false);
                            boolean zX14 = x(jSONObject7.optString("aa"), false);
                            s6b.f19529a = zX13;
                            s6b.f19532b = zX14;
                            SharedPreferences.Editor editorB6 = r8b.b(context2, "open_common");
                            r8b.j(editorB6, "a4", zX13);
                            r8b.j(editorB6, "a5", zX14);
                            r8b.e(editorB6);
                        }
                    }
                } else {
                    str2 = "ustv";
                    str3 = "ust";
                    str4 = "umv";
                }
            } catch (Throwable th13) {
                th = th13;
                str2 = "ustv";
            }
        } else {
            str2 = "ustv";
            str3 = "ust";
            str4 = "umv";
        }
        if (s4b.n(jSONObject, "15K")) {
            jSONObject2 = jSONObject.getJSONObject("15K");
            if (jSONObject2 != null) {
                zX2 = x(jSONObject2.optString("ucf"), g.f868a);
                zX3 = x(jSONObject2.optString("fsv2"), g.f869b);
                zX4 = x(jSONObject2.optString("usc"), g.c);
                String str12 = str4;
                iOptInt = jSONObject2.optInt(str12, g.f25945a);
                String str13 = str3;
                zX5 = x(jSONObject2.optString(str13), g.d);
                String str14 = str2;
                iOptInt2 = jSONObject2.optInt(str14, g.b);
                if (zX2 != g.f868a && zX3 == g.f869b && zX4 == g.c && iOptInt == g.f25945a && zX5 == g.d && iOptInt2 == g.f25945a) {
                    context2 = context;
                } else {
                    g.f868a = zX2;
                    g.f869b = zX3;
                    g.c = zX4;
                    g.f25945a = iOptInt;
                    g.d = zX5;
                    g.b = iOptInt2;
                    context2 = context;
                    SharedPreferences.Editor editorB7 = r8b.b(context2, "open_common");
                    r8b.j(editorB7, "ucf", g.f868a);
                    r8b.j(editorB7, "fsv2", g.f869b);
                    r8b.j(editorB7, "usc", g.c);
                    r8b.g(editorB7, str12, g.f25945a);
                    r8b.j(editorB7, str13, g.d);
                    r8b.g(editorB7, str14, g.b);
                    r8b.e(editorB7);
                }
            } else {
                context2 = context;
            }
        } else {
            context2 = context;
        }
        if (s4b.n(jSONObject, "183")) {
            g9b.c(r4bVar, jSONObject.getJSONObject("183"));
        }
        if (s4b.n(jSONObject, "17I")) {
            JSONObject jSONObject8 = jSONObject.getJSONObject("17I");
            boolean zX15 = x(jSONObject8.optString("na"), false);
            boolean zX16 = x(jSONObject8.optString("aa"), false);
            s6b.f19529a = zX15;
            s6b.f19532b = zX16;
            SharedPreferences.Editor editorB8 = r8b.b(context2, "open_common");
            r8b.j(editorB8, "a4", zX15);
            r8b.j(editorB8, "a5", zX16);
            r8b.e(editorB8);
        }
    }

    public static void k(Context context, r4b r4bVar, Throwable th) {
        h(context, r4bVar, th.getMessage());
    }

    public static void l(Context context, String str) {
        j4b.b(context, str);
    }

    public static void m(Context context, String str, String str2, f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.f25944a)) {
            return;
        }
        String strE = fVar.e();
        if (TextUtils.isEmpty(strE) || context == null) {
            return;
        }
        SharedPreferences.Editor editorB = r8b.b(context, str2);
        editorB.putString(str, strE);
        r8b.e(editorB);
    }

    public static void n(u.c cVar) {
        if (cVar == null || f838a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("serverip", cVar.g);
        map.put("hostname", cVar.i);
        map.put("path", cVar.h);
        map.put("csid", cVar.f);
        map.put("degrade", String.valueOf(cVar.f1103a.a()));
        map.put("errorcode", String.valueOf(cVar.K));
        map.put("errorsubcode", String.valueOf(cVar.L));
        map.put("connecttime", String.valueOf(cVar.c));
        map.put("writetime", String.valueOf(cVar.d));
        map.put("readtime", String.valueOf(cVar.e));
        map.put("datasize", String.valueOf(cVar.k));
        map.put("totaltime", String.valueOf(cVar.f26056a));
        String string = new JSONObject(map).toString();
        "--埋点--".concat(String.valueOf(string));
        u.s();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            lbb lbbVar = new lbb(f838a, "core", "2.0", "O008");
            lbbVar.a(string);
            mbb.d(lbbVar, f838a);
        } catch (ff unused) {
        }
    }

    public static void o(r4b r4bVar) {
        if (r4bVar != null) {
            try {
                if (TextUtils.isEmpty(r4bVar.a())) {
                    return;
                }
                String strF = r4bVar.f();
                if (TextUtils.isEmpty(strF)) {
                    strF = r4bVar.e();
                }
                if (TextUtils.isEmpty(strF)) {
                    return;
                }
                s6b.b(r4bVar.a(), strF);
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void p(String str, long j, String str2) {
        try {
            if (f850c != null && f850c.containsKey(str)) {
                if (f844a == null) {
                    f844a = new ConcurrentHashMap<>(8);
                }
                f844a.put(str, new h(Long.valueOf(j), str2));
                Context context = f838a;
                if (context != null) {
                    SharedPreferences.Editor editorB = r8b.b(context, "open_common");
                    r8b.h(editorB, str, j);
                    r8b.i(editorB, str + "lct-info", str2);
                    r8b.e(editorB);
                }
            }
        } catch (Throwable th) {
            v6b.b(th, t.u, "ucut");
        }
    }

    public static void q(String str, String str2) {
        f fVarE = e(f838a, str, str2);
        String strC = s4b.c(System.currentTimeMillis(), "yyyyMMdd");
        if (!strC.equals(fVarE.b)) {
            fVarE.c(strC);
            fVarE.f867a.set(0);
        }
        fVarE.f867a.incrementAndGet();
        m(f838a, str, str2, fVarE);
    }

    public static synchronized void r(String str, boolean z, String str2, String str3, String str4) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (f847b == null) {
                f847b = new ConcurrentHashMap<>(8);
            }
            f847b.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            if (f850c == null) {
                return;
            }
            if (f850c.containsKey(str)) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (z) {
                    g9b.j(true, str);
                }
                z.g().b(new b(str, str2, str3, str4));
            }
        } catch (Throwable th) {
            v6b.b(th, t.u, "lca");
        }
    }

    public static void s(String str, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str) || f838a == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("url", str);
        map.put("downLevel", String.valueOf(z));
        map.put("ant", fj.Y(f838a) == 0 ? "0" : "1");
        if (z3) {
            map.put("type", z ? f852d : e);
        } else {
            map.put("type", z ? f846b : f849c);
        }
        map.put("status", z2 ? "0" : "1");
        String string = new JSONObject(map).toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            lbb lbbVar = new lbb(f838a, "core", "2.0", "O002");
            lbbVar.a(string);
            mbb.d(lbbVar, f838a);
        } catch (ff unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006e A[Catch: all -> 0x0084, LOOP:0: B:23:0x0068->B:25:0x006e, LOOP_END, TryCatch #0 {, blocks: (B:9:0x000d, B:10:0x0013, B:12:0x0019, B:14:0x0029, B:16:0x0033, B:18:0x0039, B:20:0x003f, B:21:0x0046, B:22:0x005c, B:23:0x0068, B:25:0x006e, B:26:0x007f, B:27:0x0082), top: B:33:0x000d }] */
    public static void t(boolean z, u.a aVar) {
        if (!i || aVar == null) {
            return;
        }
        synchronized (f840a) {
            if (z) {
                Iterator<u.a> it = f840a.iterator();
                while (it.hasNext()) {
                    u.a next = it.next();
                    if (next.f.equals(aVar.f) && next.i.equals(aVar.i) && next.L == aVar.L) {
                        if (next.f1101a == aVar.f1101a) {
                            it.remove();
                            u.s();
                        } else {
                            next.f1101a.set(next.f1101a.get() - aVar.f1101a.get());
                            u.s();
                        }
                    }
                }
                i = false;
                u.s();
                for (u.a aVar2 : f840a) {
                    String str = aVar2.i;
                    Objects.toString(aVar2.f1101a);
                    u.s();
                }
                u.s();
            } else {
                i = false;
                u.s();
                while (r4.hasNext()) {
                    String str2 = aVar2.i;
                    Objects.toString(aVar2.f1101a);
                    u.s();
                }
                u.s();
            }
            throw th;
        }
    }

    public static void u(boolean z, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            u.s();
            if (f854d || z) {
                if ((g || !z) && !TextUtils.isEmpty(str)) {
                    if (z) {
                        if (f855e.get(str) != null) {
                            return;
                        }
                        f855e.put(str, Boolean.TRUE);
                        q(B(str, "a15"), "open_common");
                        return;
                    }
                    if (f853d.get(str) != null) {
                        return;
                    }
                    f853d.put(str, Boolean.TRUE);
                    q(B(str, "a14"), "open_common");
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean v() {
        f fVarE;
        if (f838a != null) {
            W();
            if (!K()) {
                return false;
            }
            if (G()) {
                return true;
            }
        }
        return f845a && (fVarE = e(f838a, "IPV6_CONFIG_NAME", "open_common")) != null && fVarE.a() < 5;
    }

    public static synchronized boolean w(String str, long j) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h hVarQ = Q(str);
            long jLongValue = 0;
            if (j != (hVarQ != null ? hVarQ.f25946a : 0L)) {
                if (f847b != null && f847b.containsKey(str)) {
                    jLongValue = f847b.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - jLongValue > 30000) {
                    z = true;
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static boolean x(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] strArrSplit = URLDecoder.decode(str).split(WVNativeCallbackUtil.SEPERATER);
            return strArrSplit[strArrSplit.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static boolean y(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    public static c z(Context context, r4b r4bVar, String str, Map<String, String> map) {
        return d(context, r4bVar, str, map, null, null, null);
    }
}
