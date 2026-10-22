package com.zj.adlib;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ze1 implements TransportBackend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f46244a = "CctTransportBackend";
    public static final int b = 30000;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f21027b = "Accept-Encoding";
    public static final int c = 40000;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f21028c = "Content-Encoding";
    public static final int d = -1;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f21029d = "gzip";
    public static final String e = "Content-Type";
    public static final String f = "X-Goog-Api-Key";
    public static final String g = "application/json";

    @VisibleForTesting
    public static final String h = "net-type";

    @VisibleForTesting
    public static final String i = "mobile-subtype";
    public static final String j = "sdk-version";
    public static final String k = "model";
    public static final String l = "hardware";
    public static final String m = "device";
    public static final String n = "product";
    public static final String o = "os-uild";
    public static final String p = "manufacturer";
    public static final String q = "fingerprint";
    public static final String r = "locale";
    public static final String s = "country";
    public static final String t = "mcc_mnc";
    public static final String u = "tz-offset";
    public static final String v = "application_build";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f21030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f21031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ConnectivityManager f21032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f21033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataEncoder f21034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final URL f21035a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Clock f21036b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BatchedLogRequest f46245a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f21037a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final URL f21038a;

        public a(URL url, BatchedLogRequest batchedLogRequest, @Nullable String str) {
            this.f21038a = url;
            this.f46245a = batchedLogRequest;
            this.f21037a = str;
        }

        public a a(URL url) {
            return new a(url, this.f46245a, this.f21037a);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46246a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f21039a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final URL f21040a;

        public b(int i, @Nullable URL url, long j) {
            this.f46246a = i;
            this.f21040a = url;
            this.f21039a = j;
        }
    }

    public ze1(Context context, Clock clock, Clock clock2, int i2) {
        this.f21034a = BatchedLogRequest.b();
        this.f21031a = context;
        this.f21032a = (ConnectivityManager) context.getSystemService("connectivity");
        this.f21035a = m(o61.d);
        this.f21033a = clock2;
        this.f21036b = clock;
        this.f21030a = i2;
    }

    public static int e(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    public static int f(NetworkInfo networkInfo) {
        return networkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.getValue() : networkInfo.getType();
    }

    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            h25.e(f46244a, "Unable to find version code for package", e2);
            return -1;
        }
    }

    public static TelephonyManager i(Context context) {
        return (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
    }

    @VisibleForTesting
    public static long j() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static /* synthetic */ a k(a aVar, b bVar) {
        URL url = bVar.f21040a;
        if (url == null) {
            return null;
        }
        h25.b(f46244a, "Following redirect to: %s", url);
        return aVar.a(bVar.f21040a);
    }

    public static InputStream l(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL m(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: " + str, e2);
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public BackendResponse a(BackendRequest backendRequest) {
        BatchedLogRequest batchedLogRequestH = h(backendRequest);
        URL urlM = this.f21035a;
        String strG = null;
        if (backendRequest.d() != null) {
            try {
                o61 o61VarF = o61.f(backendRequest.d());
                strG = o61VarF.g() != null ? o61VarF.g() : null;
                if (o61VarF.h() != null) {
                    urlM = m(o61VarF.h());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            b bVar = (b) bh7.a(5, new a(urlM, batchedLogRequestH, strG), xe1.a(this), ye1.b());
            int i2 = bVar.f46246a;
            if (i2 == 200) {
                return BackendResponse.d(bVar.f21039a);
            }
            if (i2 < 500 && i2 != 404) {
                return BackendResponse.a();
            }
            return BackendResponse.e();
        } catch (IOException e2) {
            h25.e(f46244a, "Could not make request to the backend", e2);
            return BackendResponse.e();
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public EventInternal b(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.f21032a.getActiveNetworkInfo();
        return eventInternal.m().a(j, Build.VERSION.SDK_INT).c(k, Build.MODEL).c(l, Build.HARDWARE).c("device", Build.DEVICE).c(n, Build.PRODUCT).c(o, Build.ID).c(p, Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b(u, j()).a(h, f(activeNetworkInfo)).a(i, e(activeNetworkInfo)).c(s, Locale.getDefault().getCountry()).c(r, Locale.getDefault().getLanguage()).c(t, i(this.f21031a).getSimOperator()).c(v, Integer.toString(g(this.f21031a))).d();
    }

    public final b d(a aVar) throws IOException {
        h25.b(f46244a, "Making request to: %s", aVar.f21038a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f21038a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f21030a);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", u11.d));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", g);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f21037a;
        if (str != null) {
            httpURLConnection.setRequestProperty(f, str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f21034a.encode(aVar.f46245a, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    h25.g(f46244a, "Status Code: " + responseCode);
                    h25.g(f46244a, "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    h25.g(f46244a, "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamL = l(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, LogResponse.b(new BufferedReader(new InputStreamReader(inputStreamL))).c());
                            if (inputStreamL != null) {
                                inputStreamL.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (inputStreamL != null) {
                                try {
                                    inputStreamL.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th3;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        } catch (EncodingException e2) {
            e = e2;
            h25.e(f46244a, "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            h25.e(f46244a, "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            h25.e(f46244a, "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e5) {
            e = e5;
            h25.e(f46244a, "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    public final BatchedLogRequest h(BackendRequest backendRequest) {
        LogEvent.Builder builderJ;
        HashMap map = new HashMap();
        for (EventInternal eventInternal : backendRequest.c()) {
            String strK = eventInternal.k();
            if (map.containsKey(strK)) {
                ((List) map.get(strK)).add(eventInternal);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                map.put(strK, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder builderB = LogRequest.a().f(QosTier.DEFAULT).g(this.f21036b.getTime()).h(this.f21033a.getTime()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(AndroidClientInfo.a().m(Integer.valueOf(eventInternal2.f(j))).j(eventInternal2.b(k)).f(eventInternal2.b(l)).d(eventInternal2.b("device")).l(eventInternal2.b(n)).k(eventInternal2.b(o)).h(eventInternal2.b(p)).e(eventInternal2.b("fingerprint")).c(eventInternal2.b(s)).g(eventInternal2.b(r)).i(eventInternal2.b(t)).b(eventInternal2.b(v)).a()).a());
            try {
                builderB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                builderB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                t13 t13VarD = eventInternal3.d();
                f33 f33VarB = t13VarD.b();
                if (f33VarB.equals(f33.b("proto"))) {
                    builderJ = LogEvent.j(t13VarD.a());
                } else if (f33VarB.equals(f33.b("json"))) {
                    builderJ = LogEvent.i(new String(t13VarD.a(), Charset.forName("UTF-8")));
                } else {
                    h25.h(f46244a, "Received event of unsupported encoding %s. Skipping...", f33VarB);
                }
                builderJ.c(eventInternal3.e()).d(eventInternal3.l()).h(eventInternal3.g(u)).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.forNumber(eventInternal3.f(h))).b(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal3.f(i))).a());
                if (eventInternal3.c() != null) {
                    builderJ.b(eventInternal3.c());
                }
                arrayList3.add(builderJ.a());
            }
            builderB.c(arrayList3);
            arrayList2.add(builderB.a());
        }
        return BatchedLogRequest.a(arrayList2);
    }

    public ze1(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 40000);
    }
}
