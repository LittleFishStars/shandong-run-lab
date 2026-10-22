package com.amap.api.col.p0003l;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.maps.AMapException;
import com.huachenjie.common.constants.ErrorCode;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.a7b;
import com.zj.adlib.c49;
import com.zj.adlib.d9b;
import com.zj.adlib.g9b;
import com.zj.adlib.i9b;
import com.zj.adlib.m4b;
import com.zj.adlib.n4b;
import com.zj.adlib.s4b;
import com.zj.adlib.u15;
import com.zj.adlib.v6b;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<SSLContext> f26053a;
    public static SoftReference<v> b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hl.a f1088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f1089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Proxy f1092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SSLContext f1093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1094a;
    public String c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1098c;
    public String d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile boolean f1097b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f1087a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f1095b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f1096b = "";

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f1099d = false;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f1100e = false;
    public String e = "";
    public String f = "";
    public String g = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f1090a = new f();

    public static class a implements Cloneable, Comparable {
        public int K;
        public int L;
        public int M;
        public int N;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f26054a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile AtomicInteger f1101a = new AtomicInteger(1);
        public String f;
        public String g;
        public String h;
        public String i;

        public a(c cVar) {
            this.f = cVar.g;
            this.g = cVar.i;
            this.i = cVar.h;
            this.L = cVar.K;
            this.M = cVar.L;
            this.N = cVar.f1103a.a();
            this.h = cVar.f;
            this.f26054a = cVar.f26056a;
            if (this.L == 10) {
                this.K = 0;
            }
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a clone() {
            try {
                return (a) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                String str5 = this.L + "#";
                if (TextUtils.isEmpty(this.i)) {
                    str = str5 + "-#";
                } else {
                    str = str5 + this.i + "#";
                }
                String str6 = (str + this.N + "#") + this.f1101a + "#";
                if (TextUtils.isEmpty(this.f)) {
                    str2 = str6 + "-#";
                } else {
                    str2 = str6 + this.f + "#";
                }
                if (this.L == 1) {
                    str3 = str2 + this.h + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.L == 1) {
                    str4 = str3 + this.f26054a + "#";
                } else {
                    str4 = str3 + "-#";
                }
                String strF = m4b.f(d9b.a(((str4 + this.g + "#") + this.M).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                u.s();
                return strF;
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.K - ((a) obj).K;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HttpURLConnection f1102a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26055a = this.f26055a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26055a = this.f26055a;

        public b(HttpURLConnection httpURLConnection) {
            this.f1102a = httpURLConnection;
        }
    }

    public static class c implements Cloneable {
        public String f = "";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public hs.b f1103a = hs.b.FIRST_NONDEGRADE;
        public String g = "";
        public String h = "";
        public String i = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f26056a = 0;
        public long b = 0;
        public long c = 0;
        public long d = 0;
        public long e = 0;
        public String j = c49.f40900a;
        public String k = c49.f40900a;
        public int K = 0;
        public int L = 0;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public final String b() {
            String str;
            String str2;
            if (TextUtils.isEmpty(this.g)) {
                str = "-#";
            } else {
                str = this.g + "#";
            }
            if (TextUtils.isEmpty(this.h)) {
                str2 = str + "-#";
            } else {
                str2 = str + this.h + "#";
            }
            String strF = m4b.f(d9b.a(((((str2 + this.f1103a.a() + "#") + this.c + "#") + this.e + "#") + this.f26056a).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            u.s();
            return strF;
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f + "', degradeType=" + this.f1103a + ", serverIp='" + this.g + "', path='" + this.h + "', hostname='" + this.i + "', totalTime=" + this.f26056a + ", DNSTime=" + this.b + ", connectionTime=" + this.c + ", writeTime=" + this.d + ", readTime=" + this.e + ", serverTime='" + this.j + "', datasize='" + this.k + "', errorcode=" + this.K + ", errorcodeSub=" + this.L + '}';
        }
    }

    public static class e implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26058a;
        public String b;

        public e() {
        }

        public final String a() {
            return this.b;
        }

        public final void b(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(this.f26058a) || !str.contains(u15.f19942b) || (strArrSplit = str.split(u15.f19942b)) == null || strArrSplit.length <= 0) {
                this.f26058a = str;
            } else {
                this.f26058a = strArrSplit[0];
            }
        }

        public final void c(String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            if (TextUtils.isEmpty(this.f26058a)) {
                return !TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
            }
            return this.f26058a.equals(str);
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public a f1105a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1108a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public URL f1109a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public c f1110b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f26059a = 0;
        public long b = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public c f1106a = new c();

        public f() {
        }

        public final void a() {
            this.f1106a.c = SystemClock.elapsedRealtime() - this.b;
        }

        public final void b(int i) {
            "----errorcode-----".concat(String.valueOf(i));
            u.s();
            try {
                this.f1106a.f26056a = SystemClock.elapsedRealtime() - this.f26059a;
                c cVar = this.f1106a;
                cVar.K = i;
                if (cVar.f1103a.e()) {
                    fh.u(false, this.f1106a.i);
                }
                boolean zO = u.this.o(this.f1106a.i);
                if (zO) {
                    if (u.this.f1100e && !TextUtils.isEmpty(u.this.d) && this.f1106a.f1103a.b()) {
                        fh.L();
                    }
                    if (this.f1106a.f1103a.c()) {
                        fh.u(this.f1106a.f1103a.c(), this.f1106a.i);
                    }
                    fh.J(this.f1110b);
                    fh.t(false, this.f1105a);
                    fh.E(this.f1106a);
                }
                fh.s(this.f1109a.toString(), this.f1106a.f1103a.c(), true, zO);
                this.f1106a.toString();
                u.s();
            } catch (Throwable unused) {
            }
        }

        public final void c(long j) {
            this.f1106a.k = new DecimalFormat("0.00").format(j / 1024.0f);
        }

        public final void d(hs hsVar, URL url) {
            this.f1109a = url;
            this.f1106a.h = url.getPath();
            this.f1106a.i = url.getHost();
            if (!TextUtils.isEmpty(u.this.d) && hsVar.getDegradeType().b()) {
                c cVar = this.f1106a;
                cVar.g = cVar.i.replace("[", "").replace("]", "");
                this.f1106a.i = u.this.d;
            }
            if (hsVar.getDegradeType().b()) {
                hsVar.setNon_degrade_final_Host(this.f1106a.i);
            }
            if (hsVar.getDegradeType().d()) {
                this.f1108a = hsVar.getNon_degrade_final_Host();
            }
        }

        public final void e(i9b i9bVar) {
            c cVarClone;
            try {
                this.f1106a.f26056a = SystemClock.elapsedRealtime() - this.f26059a;
                if (i9bVar != null) {
                    i9bVar.f17172b = this.f1106a.f1103a.c();
                }
                if (this.f1106a.f1103a.b()) {
                    c cVar = this.f1106a;
                    if (cVar.f26056a > 10000) {
                        fh.u(false, cVar.i);
                    }
                }
                if (this.f1106a.f1103a.d()) {
                    fh.u(false, this.f1108a);
                }
                boolean zO = u.this.o(this.f1106a.i);
                if (zO) {
                    fh.J(this.f1106a);
                    fh.t(true, this.f1105a);
                    c cVar2 = this.f1106a;
                    if (cVar2.f26056a > fh.b && (cVarClone = cVar2.clone()) != null) {
                        cVarClone.K = 1;
                        fh.E(cVarClone);
                        cVarClone.toString();
                        u.s();
                    }
                }
                fh.s(this.f1109a.toString(), this.f1106a.f1103a.c(), false, zO);
                this.f1106a.toString();
                u.s();
            } catch (Throwable unused) {
            }
        }

        public final void f() {
            this.f1106a.d = SystemClock.elapsedRealtime() - this.b;
        }

        public final void g(int i) {
            this.f1106a.L = i;
        }

        public final void h() {
            this.f1106a.e = SystemClock.elapsedRealtime() - this.b;
        }

        public final void i() {
            c cVarClone = this.f1106a.clone();
            if (this.f1106a.f26056a > fh.b) {
                cVarClone.K = 1;
            }
            fh.n(cVarClone);
        }
    }

    public u() {
        fh.O();
        try {
            this.f1091a = UUID.randomUUID().toString().replaceAll(c49.f40900a, "").toLowerCase();
        } catch (Throwable th) {
            v6b.b(th, AliyunLogKey.KEY_HEIGHT, "ic");
        }
    }

    public static int a(Exception exc) {
        if (exc instanceof SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof SSLKeyException) {
            return 4102;
        }
        if (exc instanceof SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return 4104;
        }
        if (exc instanceof ConnectException) {
            return 6101;
        }
        if (exc instanceof SocketException) {
            return 6102;
        }
        if (exc instanceof ConnectTimeoutException) {
            return 2101;
        }
        if (exc instanceof SocketTimeoutException) {
            return ErrorCode.FENCE_ERROR.f33661a;
        }
        return 0;
    }

    public static String e(String str, String str2) {
        String str3 = Build.MANUFACTURER;
        Context context = fh.f838a;
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? s4b.d(context) : "");
    }

    public static String f(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap<String, String> map2 = hl.c;
        if (map2 != null) {
            if (map != null) {
                map.putAll(map2);
            } else {
                map = map2;
            }
        }
        if (map == null || map.size() <= 0) {
            return str;
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf >= 0) {
            HashMap map3 = new HashMap();
            String strSubstring = str.substring(iIndexOf);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (!strSubstring.matches(".*[\\?\\&]" + URLEncoder.encode(key) + "=.*")) {
                    map3.put(key, value);
                }
            }
            map = map3;
        }
        if (map.size() == 0) {
            return str;
        }
        String strH = h(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (iIndexOf < 0) {
            stringBuffer.append("?");
        } else if (!str.endsWith("?") && !str.endsWith("&")) {
            stringBuffer.append("&");
        }
        if (strH != null) {
            stringBuffer.append(strH);
        }
        return stringBuffer.toString();
    }

    public static String g(HttpURLConnection httpURLConnection) {
        List<String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null && (list = headerFields.get("gsid")) != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String h(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(key));
            sb.append("=");
            sb.append(URLEncoder.encode(value));
        }
        return sb.toString();
    }

    public static String r(Map<String, List<String>> map) {
        try {
            List<String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("#")) {
                String[] strArrSplit = str.split("#");
                if (strArrSplit.length <= 1) {
                    return "";
                }
                str = strArrSplit[0];
            }
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void s() {
    }

    public static boolean v(String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01f1 A[Catch: all -> 0x0207, TryCatch #1 {all -> 0x0207, blocks: (B:100:0x01e7, B:102:0x01eb, B:105:0x01fc, B:107:0x0200, B:104:0x01f1), top: B:138:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0200 A[Catch: all -> 0x0207, TRY_LEAVE, TryCatch #1 {all -> 0x0207, blocks: (B:100:0x01e7, B:102:0x01eb, B:105:0x01fc, B:107:0x0200, B:104:0x01f1), top: B:138:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0207  */
    /* JADX WARN: Code duplicated, block: B:124:0x0246  */
    /* JADX WARN: Code duplicated, block: B:127:0x024c  */
    /* JADX WARN: Code duplicated, block: B:130:0x0270  */
    /* JADX WARN: Code duplicated, block: B:131:0x027f  */
    /* JADX WARN: Code duplicated, block: B:136:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x005e  */
    /* JADX WARN: Code duplicated, block: B:21:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x015c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0185 A[Catch: all -> 0x01af, TryCatch #2 {all -> 0x01af, blocks: (B:44:0x00cd, B:47:0x00e5, B:49:0x00e8, B:51:0x00ec, B:53:0x00f2, B:57:0x00fb, B:60:0x0107, B:62:0x010a, B:64:0x0110, B:74:0x013c, B:76:0x0142, B:78:0x014c, B:80:0x015d, B:82:0x0185, B:84:0x01a6, B:85:0x01a9, B:65:0x0126, B:67:0x012a, B:69:0x012d, B:71:0x0133, B:72:0x0138), top: B:140:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01a6 A[Catch: all -> 0x01af, TryCatch #2 {all -> 0x01af, blocks: (B:44:0x00cd, B:47:0x00e5, B:49:0x00e8, B:51:0x00ec, B:53:0x00f2, B:57:0x00fb, B:60:0x0107, B:62:0x010a, B:64:0x0110, B:74:0x013c, B:76:0x0142, B:78:0x014c, B:80:0x015d, B:82:0x0185, B:84:0x01a6, B:85:0x01a9, B:65:0x0126, B:67:0x012a, B:69:0x012d, B:71:0x0133, B:72:0x0138), top: B:140:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:96:0x01da  */
    /* JADX WARN: Code duplicated, block: B:97:0x01df  */
    public final b b(hs hsVar, boolean z, boolean z2) throws ff, IOException {
        String str;
        boolean z3;
        URL url;
        URL url2;
        hl.a aVar;
        URLConnection uRLConnectionOpenConnection;
        SSLContext sSLContext;
        HttpsURLConnection httpsURLConnection;
        v vVarW;
        SoftReference<SSLContext> softReference;
        SoftReference<SSLContext> softReference2;
        HttpURLConnection httpURLConnection;
        Proxy proxy;
        String str2;
        boolean z4;
        InetAddress[] allByName;
        String hostAddress;
        String host;
        f fVar = this.f1090a;
        hs.b degradeType = hsVar.getDegradeType();
        c cVar = fVar.f1106a;
        cVar.f = u.this.f1091a;
        cVar.f1103a = degradeType;
        fVar.f26059a = SystemClock.elapsedRealtime();
        Map<String, String> requestHead = hsVar.getRequestHead();
        if (requestHead == null) {
            requestHead = new HashMap<>();
        }
        e eVarA = this.f1089a.a(this.d);
        int i = hl.f25967a;
        String string = this.c;
        Uri uri = Uri.parse(string);
        String host2 = uri.getHost();
        if (i != 1) {
            if (i != 2) {
                str = "";
            } else {
                HashMap<String, String> map = hl.f925a;
                str = map != null ? map.get(host2) : "";
                z3 = false;
            }
            if (!TextUtils.isEmpty(str)) {
                hsVar.setHostToIP(false);
                string = uri.buildUpon().encodedAuthority(str).build().toString();
                if (z3) {
                    requestHead.put("targetHost", host2);
                    this.g = host2;
                }
                if (z3 && this.f1094a) {
                    eVarA.b(str);
                }
            }
            this.c = string;
            url = new URL(this.c);
            this.f1090a.d(hsVar, url);
            if (v(url.getHost()) && hsVar.isHostToIP()) {
                hs.b degradeType2 = hsVar.getDegradeType();
                str2 = this.f1090a.f1106a.i;
                if (o(str2) || !((degradeType2.b() && fh.f856e) || (degradeType2.c() && fh.V(str2)))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    try {
                        this.f1090a.b = SystemClock.elapsedRealtime();
                        allByName = InetAddress.getAllByName(this.f1090a.f1106a.i);
                        if (allByName != null || allByName.length <= 0 || allByName[0] == null) {
                            hostAddress = "";
                        } else {
                            boolean z5 = fh.v() && fh.K();
                            "---canUseIpv6---".concat(String.valueOf(z5));
                            if (!z5) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= allByName.length) {
                                        hostAddress = "";
                                        break;
                                    }
                                    InetAddress inetAddress = allByName[i2];
                                    if (inetAddress instanceof Inet4Address) {
                                        hostAddress = inetAddress.getHostAddress();
                                        break;
                                    }
                                    i2++;
                                }
                            } else {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= allByName.length) {
                                        hostAddress = "";
                                        break;
                                    }
                                    if (allByName[i3] instanceof Inet6Address) {
                                        hostAddress = "[" + allByName[i3].getHostAddress() + "]";
                                        break;
                                    }
                                    i3++;
                                }
                            }
                            if (TextUtils.isEmpty(hostAddress)) {
                                InetAddress inetAddress2 = allByName[0];
                                hostAddress = inetAddress2.getHostAddress();
                                if (inetAddress2 instanceof Inet6Address) {
                                    hostAddress = "[" + hostAddress + "]";
                                }
                            }
                        }
                        f fVar2 = this.f1090a;
                        "---onDNSEnd---ip=".concat(String.valueOf(hostAddress));
                        fVar2.f1106a.g = hostAddress.replace("[", "").replace("]", "");
                        fVar2.f1106a.b = SystemClock.elapsedRealtime() - fVar2.b;
                        if (!TextUtils.isEmpty(hostAddress)) {
                            Uri uri2 = Uri.parse(this.c);
                            host = uri2.getHost();
                            Uri uriBuild = uri2.buildUpon().encodedAuthority(hostAddress).build();
                            this.d = host;
                            requestHead.put(com.alipay.sdk.m.n.c.f, host);
                            if (this.f1094a) {
                                eVarA.c(host);
                            }
                            this.c = uriBuild.toString();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.f1094a) {
                this.c = n4b.b(this.c);
            }
            Objects.toString(hsVar.getDegradeType());
            url2 = new URL(this.c);
            aVar = this.f1088a;
            if (aVar != null) {
                uRLConnectionOpenConnection = aVar.a();
            } else {
                uRLConnectionOpenConnection = null;
            }
            if (uRLConnectionOpenConnection == null) {
                proxy = this.f1092a;
                if (proxy != null) {
                    uRLConnectionOpenConnection = url2.openConnection(proxy);
                } else {
                    uRLConnectionOpenConnection = url2.openConnection();
                }
            }
            if (this.f1094a) {
                try {
                    softReference = f26053a;
                    if (softReference != null || softReference.get() == null) {
                        f26053a = new SoftReference<>(SSLContext.getInstance("TLS"));
                    }
                    softReference2 = f26053a;
                    if (softReference2 != null) {
                        sSLContext = softReference2.get();
                    } else {
                        sSLContext = null;
                    }
                } catch (Throwable unused2) {
                }
                if (sSLContext == null) {
                    try {
                        sSLContext = SSLContext.getInstance("TLS");
                    } catch (Throwable th) {
                        v6b.b(th, AliyunLogKey.KEY_HEIGHT, "ne");
                    }
                }
                sSLContext.init(null, null, null);
                this.f1093a = sSLContext;
                httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                if (fh.g.f868a || (vVarW = w()) == null) {
                    httpsURLConnection.setSSLSocketFactory(this.f1093a.getSocketFactory());
                } else {
                    httpsURLConnection.setSSLSocketFactory(vVarW);
                    vVarW.b();
                }
                httpsURLConnection.setHostnameVerifier(eVarA);
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            }
            if (Build.VERSION.SDK != null) {
                httpURLConnection.setRequestProperty("Connection", "close");
            }
            int real_max_timeout = (int) (((long) hsVar.getReal_max_timeout()) - (this.f1090a.f1106a.b / 1000));
            m(requestHead, httpURLConnection, z2);
            httpURLConnection.setConnectTimeout(real_max_timeout);
            httpURLConnection.setReadTimeout(real_max_timeout);
            if (z) {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
            } else {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
            }
            return new b(httpURLConnection);
        }
        str = hl.f924a;
        z3 = true;
        if (!TextUtils.isEmpty(str)) {
            hsVar.setHostToIP(false);
            string = uri.buildUpon().encodedAuthority(str).build().toString();
            if (z3) {
                requestHead.put("targetHost", host2);
                this.g = host2;
            }
            if (z3) {
                eVarA.b(str);
            }
        }
        this.c = string;
        url = new URL(this.c);
        this.f1090a.d(hsVar, url);
        if (v(url.getHost())) {
            hs.b degradeType3 = hsVar.getDegradeType();
            str2 = this.f1090a.f1106a.i;
            if (o(str2)) {
                z4 = false;
            } else {
                z4 = false;
            }
            if (z4) {
                this.f1090a.b = SystemClock.elapsedRealtime();
                allByName = InetAddress.getAllByName(this.f1090a.f1106a.i);
                if (allByName != null) {
                    hostAddress = "";
                } else {
                    hostAddress = "";
                }
                f fVar3 = this.f1090a;
                "---onDNSEnd---ip=".concat(String.valueOf(hostAddress));
                fVar3.f1106a.g = hostAddress.replace("[", "").replace("]", "");
                fVar3.f1106a.b = SystemClock.elapsedRealtime() - fVar3.b;
                if (!TextUtils.isEmpty(hostAddress)) {
                    Uri uri3 = Uri.parse(this.c);
                    host = uri3.getHost();
                    Uri uriBuild2 = uri3.buildUpon().encodedAuthority(hostAddress).build();
                    this.d = host;
                    requestHead.put(com.alipay.sdk.m.n.c.f, host);
                    if (this.f1094a) {
                        eVarA.c(host);
                    }
                    this.c = uriBuild2.toString();
                }
            }
        }
        if (this.f1094a) {
            this.c = n4b.b(this.c);
        }
        Objects.toString(hsVar.getDegradeType());
        url2 = new URL(this.c);
        aVar = this.f1088a;
        if (aVar != null) {
            uRLConnectionOpenConnection = aVar.a();
        } else {
            uRLConnectionOpenConnection = null;
        }
        if (uRLConnectionOpenConnection == null) {
            proxy = this.f1092a;
            if (proxy != null) {
                uRLConnectionOpenConnection = url2.openConnection(proxy);
            } else {
                uRLConnectionOpenConnection = url2.openConnection();
            }
        }
        if (this.f1094a) {
            softReference = f26053a;
            if (softReference != null) {
                f26053a = new SoftReference<>(SSLContext.getInstance("TLS"));
            } else {
                f26053a = new SoftReference<>(SSLContext.getInstance("TLS"));
            }
            softReference2 = f26053a;
            if (softReference2 != null) {
                sSLContext = softReference2.get();
            } else {
                sSLContext = null;
            }
            if (sSLContext == null) {
                sSLContext = SSLContext.getInstance("TLS");
            }
            sSLContext.init(null, null, null);
            this.f1093a = sSLContext;
            httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
            if (fh.g.f868a) {
                httpsURLConnection.setSSLSocketFactory(this.f1093a.getSocketFactory());
            } else {
                httpsURLConnection.setSSLSocketFactory(this.f1093a.getSocketFactory());
            }
            httpsURLConnection.setHostnameVerifier(eVarA);
            httpURLConnection = httpsURLConnection;
        } else {
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        }
        if (Build.VERSION.SDK != null) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        int real_max_timeout2 = (int) (((long) hsVar.getReal_max_timeout()) - (this.f1090a.f1106a.b / 1000));
        m(requestHead, httpURLConnection, z2);
        httpURLConnection.setConnectTimeout(real_max_timeout2);
        httpURLConnection.setReadTimeout(real_max_timeout2);
        if (z) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return new b(httpURLConnection);
    }

    /* JADX WARN: Code duplicated, block: B:154:0x021e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x0229 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a1 A[PHI: r4
      0x00a1: PHI (r4v10 java.lang.String) = (r4v0 java.lang.String), (r4v26 java.lang.String), (r4v26 java.lang.String) binds: [B:4:0x001b, B:152:0x00a1, B:12:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.InputStream] */
    public final i9b c(b bVar, boolean z) throws Throwable {
        Throwable th;
        ?? r6;
        InputStream inputStream;
        PushbackInputStream pushbackInputStream;
        Object obj;
        boolean zP;
        InputStream inputStream2;
        InputStream inputStream3;
        char c2;
        String str = "";
        ByteArrayOutputStream byteArrayOutputStream = null;
        gZIPInputStream = null;
        gZIPInputStream = null;
        gZIPInputStream = null;
        InputStream gZIPInputStream = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        try {
            try {
                g9b.b();
                HttpURLConnection httpURLConnection = bVar.f1102a;
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                int responseCode = httpURLConnection.getResponseCode();
                if (headerFields == null) {
                    zP = false;
                } else {
                    List<String> list = headerFields.get("gsid");
                    if (list != null && list.size() > 0) {
                        str = list.get(0);
                    }
                    this.f1090a.f1106a.j = r(headerFields);
                    try {
                        if (TextUtils.isEmpty(this.f1096b)) {
                            zP = false;
                        } else {
                            if (!this.f1099d) {
                                zP = p(headerFields, true);
                                c2 = 2;
                            } else if (headerFields.containsKey("sc")) {
                                zP = p(headerFields, false);
                                c2 = 1;
                            } else {
                                fh.P(this.f1096b);
                                zP = false;
                                c2 = 0;
                            }
                            try {
                                if (zP) {
                                    if (this.f1096b.equals("loc")) {
                                        String host = this.g;
                                        if (TextUtils.isEmpty(host)) {
                                            host = httpURLConnection.getURL().getHost();
                                        }
                                        fh.r(this.f1096b, c2 == 2, host, host, this.d);
                                    } else {
                                        fh.F(this.f1096b, c2 == 2);
                                    }
                                } else if (c2 == 1) {
                                    g9b.j(false, this.f1096b);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (responseCode != 200) {
                    ff ffVar = new ff("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + q.a.i + str + " " + this.f1091a, str, this.f1091a);
                    ffVar.a(httpURLConnection.getResponseMessage());
                    ffVar.a(headerFields);
                    this.f1090a.g(responseCode);
                    this.f1090a.b(10);
                    ffVar.h();
                    throw ffVar;
                }
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    this.f1090a.b = SystemClock.elapsedRealtime();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        pushbackInputStream = new PushbackInputStream(inputStream, 2);
                        try {
                            byte[] bArr = new byte[2];
                            pushbackInputStream.read(bArr);
                            pushbackInputStream.unread(bArr);
                            gZIPInputStream = (bArr[0] == 31 && bArr[1] == -117 && !z) ? new GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i = gZIPInputStream.read(bArr2);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, i);
                            }
                            this.f1090a.h();
                            a7b.n();
                            i9b i9bVar = new i9b();
                            i9bVar.f17171a = byteArrayOutputStream2.toByteArray();
                            i9bVar.f17169a = headerFields;
                            i9bVar.f42307a = this.f1091a;
                            i9bVar.b = str;
                            i9bVar.f17170a = zP;
                            g9b.i(httpURLConnection.getURL(), i9bVar);
                            this.f1090a.c(i9bVar.f17171a.length);
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Throwable th2) {
                                v6b.b(th2, AliyunLogKey.KEY_HEIGHT, "par");
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                    v6b.b(th3, AliyunLogKey.KEY_HEIGHT, "par");
                                }
                            }
                            try {
                                pushbackInputStream.close();
                            } catch (Throwable th4) {
                                v6b.b(th4, AliyunLogKey.KEY_HEIGHT, "par");
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th5) {
                                v6b.b(th5, AliyunLogKey.KEY_HEIGHT, "par");
                            }
                            return i9bVar;
                        } catch (SocketTimeoutException e2) {
                            e = e2;
                            throw e;
                        } catch (ConnectTimeoutException e3) {
                            e = e3;
                            throw e;
                        } catch (IOException e4) {
                            e = e4;
                            inputStream3 = gZIPInputStream;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            obj = inputStream3;
                            try {
                                if (!(e instanceof InterruptedIOException)) {
                                    throw e;
                                }
                                ff ffVar2 = new ff(AMapException.ERROR_IO, str, this.f1091a);
                                if (TextUtils.isEmpty(e.getMessage()) || !e.getMessage().equals("thread interrupted")) {
                                    throw ffVar2;
                                }
                                ffVar2.j();
                                throw ffVar2;
                            } catch (Throwable th6) {
                                th = th6;
                                th = th;
                                r6 = obj;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th7) {
                                        v6b.b(th7, AliyunLogKey.KEY_HEIGHT, "par");
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th8) {
                                        v6b.b(th8, AliyunLogKey.KEY_HEIGHT, "par");
                                    }
                                }
                                if (pushbackInputStream != null) {
                                    try {
                                        pushbackInputStream.close();
                                    } catch (Throwable th9) {
                                        v6b.b(th9, AliyunLogKey.KEY_HEIGHT, "par");
                                    }
                                }
                                if (r6 == 0) {
                                    throw th;
                                }
                                try {
                                    r6.close();
                                    throw th;
                                } catch (Throwable th10) {
                                    v6b.b(th10, AliyunLogKey.KEY_HEIGHT, "par");
                                    throw th;
                                }
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            inputStream2 = gZIPInputStream;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            r6 = inputStream2;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (pushbackInputStream != null) {
                                pushbackInputStream.close();
                            }
                            if (r6 == 0) {
                                throw th;
                            }
                            r6.close();
                            throw th;
                        }
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                    } catch (ConnectTimeoutException e6) {
                        e = e6;
                    } catch (IOException e7) {
                        e = e7;
                        inputStream3 = null;
                        pushbackInputStream = null;
                    } catch (Throwable th12) {
                        th = th12;
                        inputStream2 = null;
                        pushbackInputStream = null;
                    }
                } catch (SocketTimeoutException e8) {
                    e = e8;
                } catch (ConnectTimeoutException e9) {
                    e = e9;
                } catch (IOException e10) {
                    e = e10;
                    inputStream3 = null;
                    inputStream = null;
                    pushbackInputStream = null;
                } catch (Throwable th13) {
                    th = th13;
                    inputStream2 = null;
                    inputStream = null;
                    pushbackInputStream = null;
                }
            } catch (Throwable th14) {
                th = th14;
                obj = "";
                th = th;
                r6 = obj;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (r6 == 0) {
                    throw th;
                }
                r6.close();
                throw th;
            }
        } catch (SocketTimeoutException e11) {
            throw e11;
        } catch (ConnectTimeoutException e12) {
            throw e12;
        } catch (IOException e13) {
            e = e13;
            obj = null;
            inputStream = null;
            pushbackInputStream = null;
        } catch (Throwable th15) {
            th = th15;
            r6 = 0;
            inputStream = null;
            pushbackInputStream = null;
        }
    }

    public final Map<String, String> i(hs hsVar) throws ff {
        String headerFieldKey;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                y(hsVar);
                this.c = f(this.c, hsVar.getParams());
                HttpURLConnection httpURLConnection2 = b(hsVar, false, false).f1102a;
                try {
                    this.f1090a.b = SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f1090a.a();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode >= 400) {
                        this.f1090a.g(responseCode);
                        this.f1090a.b(10);
                        ff ffVar = new ff("http读取header失败");
                        ffVar.a(responseCode);
                        throw ffVar;
                    }
                    HashMap map = new HashMap();
                    for (int i = 0; i < 50 && (headerFieldKey = httpURLConnection2.getHeaderFieldKey(i)) != null; i++) {
                        map.put(headerFieldKey.toLowerCase(), httpURLConnection2.getHeaderField(headerFieldKey));
                    }
                    this.f1090a.e(null);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable th) {
                        v6b.b(th, "hth", "mgr");
                    }
                    this.f1090a.i();
                    return map;
                } catch (ff e2) {
                    e = e2;
                    this.f1090a.b(e.g());
                    throw e;
                } catch (InterruptedIOException unused) {
                    this.f1090a.g(7101);
                    this.f1090a.b(7);
                    throw new ff(AMapException.ERROR_UNKNOWN);
                } catch (ConnectException e3) {
                    e = e3;
                    this.f1090a.g(a(e));
                    this.f1090a.b(6);
                    throw new ff(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException unused2) {
                    this.f1090a.b(8);
                    throw new ff(AMapException.ERROR_URL);
                } catch (SocketException e4) {
                    e = e4;
                    this.f1090a.g(a(e));
                    this.f1090a.b(6);
                    throw new ff(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e5) {
                    e = e5;
                    this.f1090a.g(a(e));
                    this.f1090a.b(2);
                    throw new ff(AMapException.ERROR_SOCKE_TIME_OUT);
                } catch (UnknownHostException unused3) {
                    this.f1090a.b(9);
                    throw new ff(AMapException.ERROR_UNKNOW_HOST);
                } catch (SSLException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f1090a.g(a(e));
                    this.f1090a.b(4);
                    throw new ff(AMapException.ERROR_IO);
                } catch (ConnectTimeoutException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f1090a.g(a(e));
                    this.f1090a.b(2);
                    throw new ff(AMapException.ERROR_IO);
                } catch (IOException unused4) {
                    this.f1090a.b(7);
                    throw new ff(AMapException.ERROR_IO);
                } catch (Throwable th2) {
                    th = th2;
                    this.f1090a.b(9);
                    th.printStackTrace();
                    throw new ff(AMapException.ERROR_UNKNOWN);
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        v6b.b(th4, "hth", "mgr");
                    }
                }
                this.f1090a.i();
                throw th3;
            }
        } catch (ff e8) {
            e = e8;
        } catch (ConnectException e9) {
            e = e9;
        } catch (MalformedURLException unused5) {
        } catch (SocketException e10) {
            e = e10;
        } catch (SocketTimeoutException e11) {
            e = e11;
        } catch (ConnectTimeoutException e12) {
            e = e12;
        } catch (InterruptedIOException unused6) {
        } catch (UnknownHostException unused7) {
        } catch (SSLException e13) {
            e = e13;
        } catch (IOException unused8) {
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void j() {
        this.f1097b = true;
    }

    public final void k(long j) {
        this.f1095b = j;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0144  */
    /* JADX WARN: Code duplicated, block: B:107:0x0148 A[Catch: all -> 0x00cc, ff -> 0x00cf, IOException -> 0x00d2, InterruptedIOException -> 0x00d5, SocketTimeoutException -> 0x00d8, SocketException -> 0x00db, UnknownHostException -> 0x00de, MalformedURLException -> 0x00e1, ConnectTimeoutException -> 0x00e4, SSLException -> 0x00e7, ConnectException -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #56 {ff -> 0x00cf, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, ConnectException -> 0x00ea, MalformedURLException -> 0x00e1, SocketException -> 0x00db, UnknownHostException -> 0x00de, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, IOException -> 0x00d2, all -> 0x00cc, blocks: (B:38:0x00bc, B:107:0x0148), top: B:613:0x00bc }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0192 A[Catch: all -> 0x02b4, ff -> 0x02be, IOException -> 0x02c8, InterruptedIOException -> 0x02d2, SocketTimeoutException -> 0x02dc, SocketException -> 0x02e6, UnknownHostException -> 0x02f0, MalformedURLException -> 0x02fa, ConnectTimeoutException -> 0x0304, SSLException -> 0x030e, ConnectException -> 0x0318, TRY_ENTER, TRY_LEAVE, TryCatch #55 {ff -> 0x02be, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, ConnectException -> 0x0318, MalformedURLException -> 0x02fa, SocketException -> 0x02e6, UnknownHostException -> 0x02f0, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, IOException -> 0x02c8, all -> 0x02b4, blocks: (B:96:0x0130, B:119:0x0192), top: B:615:0x0130 }] */
    /* JADX WARN: Code duplicated, block: B:545:0x0183 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x012f  */
    /* JADX WARN: Code duplicated, block: B:99:0x013c  */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x063e: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:519:0x0649, block:B:514:0x063e */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0649: IF  (r7 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:524:0x0654, block:B:519:0x0649 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x062d: IF  (r8 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:514:0x063e, block:B:507:0x062d */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:123:0x01a7
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final void l(com.amap.api.col.p0003l.hs r19, com.amap.api.col.3l.hn.a r20) {
        /*
            Method dump skipped, instruction units count: 1626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.u.l(com.amap.api.col.3l.hs, com.amap.api.col.3l.hn$a):void");
    }

    public final void m(Map<String, String> map, HttpURLConnection httpURLConnection, boolean z) {
        c cVarS;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (Throwable th) {
                v6b.b(th, AliyunLogKey.KEY_HEIGHT, "adh");
                return;
            }
        }
        HashMap<String, String> map2 = hl.b;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                httpURLConnection.addRequestProperty(str2, hl.b.get(str2));
            }
        }
        String strF = "";
        if (z && !this.c.contains("/v3/iasdkauth") && !TextUtils.isEmpty(this.f1096b) && fh.N(this.f1096b)) {
            this.f1099d = true;
            fh.h hVarQ = fh.Q(this.f1096b);
            httpURLConnection.addRequestProperty("lct", String.valueOf(hVarQ.f25946a));
            httpURLConnection.addRequestProperty("lct-info", hVarQ.f870a);
            httpURLConnection.addRequestProperty("aks", fh.H(fh.f(this.f1096b)));
            httpURLConnection.addRequestProperty("lct-args", e(fh.A(this.f1096b) != null ? fh.A(this.f1096b).e() : "", this.f1096b));
        }
        httpURLConnection.addRequestProperty("csid", this.f1091a);
        if (o(this.f1090a.f1106a.i)) {
            f fVar = this.f1090a;
            if (!TextUtils.isEmpty(fVar.f1106a.g)) {
                strF = m4b.f(d9b.a(fVar.f1106a.g.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                String str3 = fVar.f1106a.g;
            }
            if (!TextUtils.isEmpty(strF)) {
                httpURLConnection.addRequestProperty("sip", strF);
            }
            if (fh.h && (cVarS = fh.S()) != null) {
                httpURLConnection.addRequestProperty("nls", cVarS.b());
                this.f1090a.f1110b = cVarS;
            }
            a aVarR = fh.R();
            if (aVarR != null) {
                httpURLConnection.addRequestProperty("nlf", aVarR.b());
                this.f1090a.f1105a = aVarR;
            }
        }
    }

    public final boolean o(String str) {
        if (this.f1098c) {
            return true;
        }
        return (!TextUtils.isEmpty(this.d) && (this.d.contains("rest") || this.d.contains("apilocate"))) || v(str);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    public final boolean p(Map<String, List<String>> map, boolean z) {
        boolean z2;
        List<String> list;
        try {
            List<String> list2 = map.get("sc");
            if (list2 == null || list2.size() <= 0) {
                z2 = false;
            } else {
                String str = list2.get(0);
                if (TextUtils.isEmpty(str)) {
                    z2 = false;
                } else {
                    if (str.contains("#")) {
                        String[] strArrSplit = str.split("#");
                        if (strArrSplit.length <= 1 || !"1".equals(strArrSplit[1])) {
                            z2 = false;
                        }
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                return false;
            }
            if (!z) {
                return true;
            }
            if (!map.containsKey("lct") || (list = map.get("lct")) == null || list.size() <= 0) {
                return false;
            }
            return fh.w(this.f1096b, fh.a(list));
        } catch (Throwable unused) {
            return false;
        }
    }

    public final i9b q(hs hsVar) throws ff {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        y(hsVar);
                                        String strF = f(this.c, hsVar.getParams());
                                        this.c = strF;
                                        i9b i9bVarO = g9b.o(strF, this.f1096b);
                                        if (i9bVarO != null) {
                                            this.f1090a.i();
                                            return i9bVarO;
                                        }
                                        b bVarB = b(hsVar, false, true);
                                        httpURLConnection = bVarB.f1102a;
                                        this.f1090a.b = SystemClock.elapsedRealtime();
                                        httpURLConnection.connect();
                                        this.f1090a.a();
                                        i9b i9bVarC = c(bVarB, hsVar.isIgnoreGZip());
                                        this.f1090a.e(i9bVarC);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable th) {
                                            v6b.b(th, AliyunLogKey.KEY_HEIGHT, "mgr");
                                        }
                                        this.f1090a.i();
                                        return i9bVarC;
                                    } catch (IOException unused) {
                                        this.f1090a.b(7);
                                        throw new ff(AMapException.ERROR_IO);
                                    }
                                } catch (ff e2) {
                                    if (!e2.i() && e2.g() != 10) {
                                        this.f1090a.b(e2.f());
                                    }
                                    throw e2;
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                this.f1090a.b(9);
                                throw new ff(AMapException.ERROR_UNKNOWN);
                            }
                        } catch (ConnectException e3) {
                            this.f1090a.g(a(e3));
                            this.f1090a.b(6);
                            throw new ff(AMapException.ERROR_CONNECTION);
                        } catch (SocketTimeoutException e4) {
                            this.f1090a.g(a(e4));
                            this.f1090a.b(2);
                            throw new ff(AMapException.ERROR_SOCKE_TIME_OUT);
                        }
                    } catch (UnknownHostException unused2) {
                        this.f1090a.b(9);
                        throw new ff(AMapException.ERROR_UNKNOW_HOST);
                    } catch (SSLException e5) {
                        e5.printStackTrace();
                        this.f1090a.g(a(e5));
                        this.f1090a.b(4);
                        throw new ff(AMapException.ERROR_IO);
                    }
                } catch (MalformedURLException unused3) {
                    this.f1090a.b(8);
                    throw new ff(AMapException.ERROR_URL);
                } catch (ConnectTimeoutException e6) {
                    e6.printStackTrace();
                    this.f1090a.g(a(e6));
                    this.f1090a.b(2);
                    throw new ff(AMapException.ERROR_IO);
                }
            } catch (InterruptedIOException unused4) {
                this.f1090a.g(7101);
                this.f1090a.b(7);
                throw new ff(AMapException.ERROR_UNKNOWN);
            } catch (SocketException e7) {
                this.f1090a.g(a(e7));
                this.f1090a.b(6);
                throw new ff(AMapException.ERROR_SOCKET);
            }
        } catch (Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    v6b.b(th4, AliyunLogKey.KEY_HEIGHT, "mgr");
                }
            }
            this.f1090a.i();
            throw th3;
        }
    }

    public final void t(long j) {
        this.f1087a = j;
    }

    public final v w() {
        try {
            SoftReference<v> softReference = b;
            if (softReference == null || softReference.get() == null) {
                b = new SoftReference<>(new v(fh.f838a, this.f1093a));
            }
            v vVar = f26053a != null ? b.get() : null;
            return vVar == null ? new v(fh.f838a, this.f1093a) : vVar;
        } catch (Throwable th) {
            a7b.m(th, AliyunLogKey.KEY_HEIGHT, "gsf");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final i9b x(hs hsVar) throws ff {
        OutputStream outputStream;
        ?? r7 = 0;
        r7 = 0;
        try {
            try {
                y(hsVar);
                i9b i9bVarO = g9b.o(this.c, this.f1096b);
                if (i9bVarO != null) {
                    this.f1090a.i();
                    return i9bVarO;
                }
                b bVarB = b(hsVar, true, true);
                HttpURLConnection httpURLConnection = bVarB.f1102a;
                try {
                    this.f1090a.b = SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    this.f1090a.a();
                    byte[] entityBytes = hsVar.getEntityBytes();
                    if (entityBytes == null || entityBytes.length == 0) {
                        Map<String, String> params = hsVar.getParams();
                        HashMap<String, String> map = hl.c;
                        if (map != null) {
                            if (params != null) {
                                params.putAll(map);
                            } else {
                                params = map;
                            }
                        }
                        String strH = h(params);
                        if (!TextUtils.isEmpty(strH)) {
                            entityBytes = s4b.p(strH);
                        }
                    }
                    if (entityBytes != null && entityBytes.length > 0) {
                        try {
                            this.f1090a.b = SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection.getOutputStream();
                            try {
                                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                                try {
                                    dataOutputStream.write(entityBytes);
                                    dataOutputStream.close();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.f1090a.f();
                                } catch (Throwable th) {
                                    th = th;
                                    r7 = dataOutputStream;
                                    if (r7 != 0) {
                                        r7.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.f1090a.f();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream = null;
                        }
                    }
                    i9b i9bVarC = c(bVarB, hsVar.isIgnoreGZip());
                    this.f1090a.e(i9bVarC);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th4) {
                        v6b.b(th4, AliyunLogKey.KEY_HEIGHT, "mPt");
                    }
                    this.f1090a.i();
                    return i9bVarC;
                } catch (ff e2) {
                    e = e2;
                } catch (InterruptedIOException unused) {
                    this.f1090a.g(7101);
                    this.f1090a.b(7);
                    throw new ff(AMapException.ERROR_UNKNOWN);
                } catch (ConnectException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.f1090a.g(a(e));
                    this.f1090a.b(6);
                    throw new ff(AMapException.ERROR_CONNECTION);
                } catch (MalformedURLException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.f1090a.b(8);
                    throw new ff(AMapException.ERROR_URL);
                } catch (SocketException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.f1090a.g(a(e));
                    this.f1090a.b(6);
                    throw new ff(AMapException.ERROR_SOCKET);
                } catch (SocketTimeoutException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f1090a.g(a(e));
                    this.f1090a.b(2);
                    throw new ff(AMapException.ERROR_SOCKE_TIME_OUT);
                } catch (UnknownHostException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f1090a.b(5);
                    throw new ff(AMapException.ERROR_UNKNOW_HOST);
                } catch (SSLException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.f1090a.g(a(e));
                    this.f1090a.b(4);
                    throw new ff(AMapException.ERROR_IO);
                } catch (ConnectTimeoutException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.f1090a.g(a(e));
                    this.f1090a.b(2);
                    throw new ff(AMapException.ERROR_IO);
                } catch (IOException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.f1090a.b(7);
                    throw new ff(AMapException.ERROR_IO);
                } catch (Throwable th5) {
                    th = th5;
                    v6b.b(th, AliyunLogKey.KEY_HEIGHT, "mPt");
                    this.f1090a.b(9);
                    throw new ff(AMapException.ERROR_UNKNOWN);
                }
            } catch (Throwable th6) {
                if (0 != 0) {
                    try {
                        r7.disconnect();
                    } catch (Throwable th7) {
                        v6b.b(th7, AliyunLogKey.KEY_HEIGHT, "mPt");
                    }
                }
                this.f1090a.i();
                throw th6;
            }
        } catch (ff e11) {
            e = e11;
        } catch (InterruptedIOException unused2) {
        } catch (ConnectException e12) {
            e = e12;
        } catch (MalformedURLException e13) {
            e = e13;
        } catch (SocketException e14) {
            e = e14;
        } catch (SocketTimeoutException e15) {
            e = e15;
        } catch (UnknownHostException e16) {
            e = e16;
        } catch (SSLException e17) {
            e = e17;
        } catch (ConnectTimeoutException e18) {
            e = e18;
        } catch (IOException e19) {
            e = e19;
        } catch (Throwable th8) {
            th = th8;
        }
        if (!e.i() && e.g() != 10) {
            this.f1090a.b(e.g());
        }
        v6b.b(e, AliyunLogKey.KEY_HEIGHT, "mPt");
        throw e;
    }

    public final void y(hs hsVar) throws ff {
        this.f1089a = new d((byte) 0);
        this.f1100e = hsVar.isIPV6Request();
        this.f1092a = hsVar.getProxy();
        this.f1088a = hsVar.getUrlConnectionImpl();
        this.f1098c = hsVar.isBinary();
        this.f1096b = hsVar.parseSdkNameFromRequest();
        this.f1094a = n4b.a().e(hsVar.isHttps());
        String strB = hsVar.getDegradeType().b() ? hsVar.b() : hsVar.a();
        this.c = strB;
        this.c = g9b.a(strB, this.f1096b);
        this.d = hsVar.getIPDNSName();
        if ("loc".equals(this.f1096b)) {
            String strA = hsVar.a();
            String strB2 = hsVar.b();
            if (!TextUtils.isEmpty(strA)) {
                try {
                    this.f = new URL(strA).getHost();
                } catch (Exception unused) {
                }
            }
            if (TextUtils.isEmpty(strB2)) {
                return;
            }
            try {
                if (TextUtils.isEmpty(this.d)) {
                    this.e = new URL(strB2).getHost();
                } else {
                    this.e = this.d;
                }
            } catch (Exception unused2) {
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile e f26057a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Vector<e> f1104a;

        public d() {
            this.f1104a = new Vector<>();
            this.f26057a = new e((byte) 0);
        }

        public final e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.f26057a;
            }
            byte b = 0;
            for (int i = 0; i < this.f1104a.size(); i++) {
                e eVar = this.f1104a.get(i);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            e eVar2 = new e(b);
            eVar2.c(str);
            this.f1104a.add(eVar2);
            return eVar2;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }
}
