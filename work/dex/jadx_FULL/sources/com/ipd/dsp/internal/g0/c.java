package com.ipd.dsp.internal.g0;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.StatFs;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.aliyun.openapiutil.Client;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.f0.h;
import com.ipd.dsp.internal.h0.d;
import com.ipd.dsp.internal.h0.e;
import com.zj.adlib.gj9;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38307a = "HEAD";
    public static final String b = "Range";
    public static final String c = "If-Match";
    public static final String d = "User-Agent";
    public static final String e = "Content-Length";
    public static final String f = "Content-Range";
    public static final String g = "Etag";
    public static final String h = "Transfer-Encoding";
    public static final String i = "Accept-Ranges";
    public static final String j = "Content-Disposition";
    public static final String k = "chunked";
    public static final int l = -1;
    public static final int m = 416;
    public static InterfaceC0880c n = new b();

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f38308a;
        public final /* synthetic */ boolean b;

        public a(String str, boolean z) {
            this.f38308a = str;
            this.b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable, this.f38308a);
            thread.setDaemon(this.b);
            return thread;
        }
    }

    public static class b implements InterfaceC0880c {
        @Override // com.ipd.dsp.internal.g0.c.InterfaceC0880c
        public void a(String str, String str2, Exception exc) {
        }

        @Override // com.ipd.dsp.internal.g0.c.InterfaceC0880c
        public void d(String str, String str2) {
        }

        @Override // com.ipd.dsp.internal.g0.c.InterfaceC0880c
        public void i(String str, String str2) {
        }

        @Override // com.ipd.dsp.internal.g0.c.InterfaceC0880c
        public void w(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.g0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0880c {
        void a(String str, String str2, Exception exc);

        void d(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    public static void a(@Nullable InterfaceC0880c interfaceC0880c) {
        n = interfaceC0880c;
    }

    public static boolean a(long j2, long j3) {
        return j2 == j3;
    }

    public static void b() {
        n = null;
    }

    public static InterfaceC0880c c() {
        return n;
    }

    @Nullable
    public static String d(String str) {
        byte[] bArrDigest;
        try {
            bArrDigest = MessageDigest.getInstance(Client.HASH_SHA256).digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        if (bArrDigest == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
        for (byte b2 : bArrDigest) {
            int i2 = b2 & 255;
            if (i2 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString().substring(16, 48);
    }

    public static void a(String str, String str2, Exception exc) {
        InterfaceC0880c interfaceC0880c = n;
        if (interfaceC0880c != null) {
            interfaceC0880c.a(str, str2, exc);
        } else {
            k.b(str, str2, exc);
        }
    }

    public static void b(String str, String str2) {
        InterfaceC0880c interfaceC0880c = n;
        if (interfaceC0880c != null) {
            interfaceC0880c.i(str, str2);
        } else {
            k.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        InterfaceC0880c interfaceC0880c = n;
        if (interfaceC0880c != null) {
            interfaceC0880c.w(str, str2);
        } else {
            k.f(str, str2);
        }
    }

    public static void a(String str, String str2) {
        InterfaceC0880c interfaceC0880c = n;
        if (interfaceC0880c != null) {
            interfaceC0880c.d(str, str2);
        } else {
            k.a(str, str2);
        }
    }

    public static long b(@Nullable String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            a(gj9.e, "parseContentLength failed parse for '" + str + "'");
            return -1L;
        }
    }

    public static long c(@Nullable String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                c(gj9.e, "parse content-length from content-range failed " + e2);
            }
        }
        return -1L;
    }

    public static boolean b(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            c(gj9.e, "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static boolean d(@NonNull Uri uri) {
        return uri.getScheme().equals("file");
    }

    public static boolean a(@Nullable CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static ThreadFactory a(String str, boolean z) {
        return new a(str, z);
    }

    public static void a(com.ipd.dsp.internal.h0.a aVar) {
        if (aVar.c() >= 0 && aVar.c() <= aVar.b()) {
            return;
        }
        c("resetBlockIfDirty", "block is dirty so have to reset: " + aVar);
        aVar.g();
    }

    public static long b(@NonNull Uri uri) {
        Cursor cursorQuery = h.j().d().getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return 0L;
        }
        try {
            cursorQuery.moveToFirst();
            return cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
        } finally {
            cursorQuery.close();
        }
    }

    public static boolean c(@NonNull Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static long a(@NonNull StatFs statFs) {
        return statFs.getAvailableBytes();
    }

    public static String a(long j2, boolean z) {
        int i2 = z ? 1000 : 1024;
        if (j2 < i2) {
            return j2 + " B";
        }
        double d2 = j2;
        double d3 = i2;
        int iLog = (int) (Math.log(d2) / Math.log(d3));
        StringBuilder sb = new StringBuilder();
        sb.append((z ? "kMGTPE" : "KMGTPE").charAt(iLog - 1));
        sb.append(z ? "" : "i");
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d2 / Math.pow(d3, iLog)), sb.toString());
    }

    public static void b(@NonNull Map<String, List<String>> map, @NonNull com.ipd.dsp.internal.j0.a aVar) throws IOException {
        a(map);
        a(map, aVar);
    }

    @NonNull
    public static e a(Context context) {
        try {
            return (e) Class.forName("com.ipd.dsp.internal.components.okdownload.core.breakpoint.BreakpointStoreOnSQLite").getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new d();
        }
    }

    @NonNull
    public static e a(@NonNull e eVar) {
        try {
            eVar = (e) eVar.getClass().getMethod("createRemitSelf", null).invoke(eVar, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        a(gj9.e, "Get final download store is " + eVar);
        return eVar;
    }

    @NonNull
    public static com.ipd.dsp.internal.j0.a.b a() {
        try {
            return (com.ipd.dsp.internal.j0.a.b) Class.forName("com.ipd.dsp.internal.components.okdownload.core.connection.DownloadOkHttp3Connection$Factory").getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new com.ipd.dsp.internal.j0.b.C0887b();
        }
    }

    public static void a(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, long j2, boolean z) {
        int iA = h.j().f().a(z) ? h.j().f().a(fVar, j2) : 1;
        bVar.n();
        long j3 = iA;
        long j4 = j2 / j3;
        long j5 = 0;
        int i2 = 0;
        long j6 = 0;
        while (i2 < iA) {
            j5 += j6;
            j6 = i2 == 0 ? (j2 % j3) + j4 : j4;
            bVar.a(new com.ipd.dsp.internal.h0.a(j5, j6));
            i2++;
        }
    }

    public static boolean a(String str) {
        return h.j().d().checkCallingOrSelfPermission(str) == 0;
    }

    @Nullable
    public static String a(@NonNull Uri uri) {
        Cursor cursorQuery = h.j().d().getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            cursorQuery.moveToFirst();
            return cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
        } finally {
            cursorQuery.close();
        }
    }

    @NonNull
    public static File a(File file) {
        File parentFile = file.getParentFile();
        return parentFile == null ? new File(WVNativeCallbackUtil.SEPERATER) : parentFile;
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            c(gj9.e, "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void a(@NonNull Map<String, List<String>> map) throws IOException {
        if (map.containsKey("If-Match") || map.containsKey("Range")) {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static void a(@NonNull Map<String, List<String>> map, @NonNull com.ipd.dsp.internal.j0.a aVar) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                aVar.a(key, it.next());
            }
        }
    }

    public static void a(@NonNull com.ipd.dsp.internal.j0.a aVar) {
        aVar.a("User-Agent", "OkDownload/1.08");
    }
}
