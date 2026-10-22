package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.zj.adlib.u15;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.a$a, reason: collision with other inner class name */
    public interface InterfaceC1279a {
        void A(int i, int i2);

        boolean B(int i, int i2);

        void C(int i, int i2);
    }

    @Nullable
    public static String J(AdInfo adInfo) {
        return et(DownloadParams.transform(adInfo).mFileUrl);
    }

    public static void K(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    private static void a(@NonNull AdInfo adInfo, boolean z) {
        try {
            Context context = mContext;
            if (context == null) {
                return;
            }
            if (!aq.isNetworkConnected(context)) {
                Context context2 = mContext;
                ae.V(context2, ag.dk(context2));
                return;
            }
            DownloadParams downloadParamsTransform = DownloadParams.transform(adInfo);
            downloadParamsTransform.requestInstallPermission = false;
            String str = downloadParamsTransform.mFileUrl;
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(downloadParamsTransform.mFileUrl);
                downloadRequest.setDestinationFileName(eu(str));
                downloadRequest.setTag(downloadParamsTransform);
                downloadRequest.setDownloadEnablePause(downloadParamsTransform.downloadEnablePause);
                if (ServiceProvider.getSDKConfig().showNotification && bR(mContext)) {
                    downloadRequest.setNotificationVisibility(3);
                } else {
                    downloadRequest.setNotificationVisibility(0);
                }
                com.kwad.sdk.d.a.a(mContext, downloadParamsTransform.mDownloadid, downloadRequest);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void bQ(Context context) {
        if (context != null) {
            if (!mHasInit) {
                mContext = context;
                com.kwad.sdk.c.Ey().init(context);
                b.Lz().init(context);
                mHasInit = true;
            }
        }
    }

    private static boolean bR(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean d(String str, File file) {
        try {
            return a(str, file, null, false);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String et(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return bg.ef(mContext) + File.separator + eu(str);
    }

    private static String eu(String str) {
        return an.md5(str) + ".apk";
    }

    public static void ev(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.d.a.H(mContext, str);
    }

    public static void ew(String str) {
        if (mContext == null) {
            return;
        }
        String strEt = et(str);
        com.kwad.sdk.d.a.e(mContext, an.md5(str), strEt);
    }

    private static URLConnection ex(String str) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        r.wrapHttpURLConnection(uRLConnectionOpenConnection);
        uRLConnectionOpenConnection.setRequestProperty(com.google.common.net.b.k, "zh-CN");
        uRLConnectionOpenConnection.setConnectTimeout(10000);
        uRLConnectionOpenConnection.setReadTimeout(120000);
        uRLConnectionOpenConnection.setUseCaches(false);
        uRLConnectionOpenConnection.setDoInput(true);
        uRLConnectionOpenConnection.setRequestProperty("Connection", "keep-alive");
        uRLConnectionOpenConnection.setRequestProperty("Charset", "UTF-8");
        return uRLConnectionOpenConnection;
    }

    public static void a(String str, File file, boolean z) {
        a(str, file, null, true);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x00c5 A[EDGE_INSN: B:133:0x00c5->B:37:0x00c5 BREAK  A[LOOP:0: B:34:0x00ba->B:36:0x00c0], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x013b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x013f A[EDGE_INSN: B:135:0x013f->B:67:0x013f BREAK  A[LOOP:1: B:62:0x012f->B:136:0x012f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x012f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x006c A[Catch: all -> 0x0162, TRY_ENTER, TryCatch #0 {all -> 0x0162, blocks: (B:18:0x0058, B:25:0x0075, B:29:0x0087, B:24:0x006c), top: B:105:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0087 A[Catch: all -> 0x0162, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0162, blocks: (B:18:0x0058, B:25:0x0075, B:29:0x0087, B:24:0x006c), top: B:105:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0 A[Catch: all -> 0x00f5, LOOP:0: B:34:0x00ba->B:36:0x00c0, LOOP_END, TryCatch #7 {all -> 0x00f5, blocks: (B:33:0x00b7, B:34:0x00ba, B:36:0x00c0, B:37:0x00c5), top: B:119:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0106  */
    /* JADX WARN: Code duplicated, block: B:51:0x010f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0111  */
    /* JADX WARN: Code duplicated, block: B:57:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0129  */
    /* JADX WARN: Code duplicated, block: B:64:0x0135 A[Catch: all -> 0x0157, TryCatch #9 {all -> 0x0157, blocks: (B:55:0x0115, B:61:0x012d, B:62:0x012f, B:64:0x0135, B:66:0x013b, B:68:0x0141), top: B:123:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0141 A[Catch: all -> 0x0157, TRY_LEAVE, TryCatch #9 {all -> 0x0157, blocks: (B:55:0x0115, B:61:0x012d, B:62:0x012f, B:64:0x0135, B:66:0x013b, B:68:0x0141), top: B:123:0x0115 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0152  */
    /* JADX WARN: Code duplicated, block: B:94:0x0182 A[Catch: all -> 0x01ac, TryCatch #5 {all -> 0x01ac, blocks: (B:92:0x017e, B:94:0x0182, B:96:0x01ab, B:95:0x0185), top: B:115:0x017e }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0185 A[Catch: all -> 0x01ac, TryCatch #5 {all -> 0x01ac, blocks: (B:92:0x017e, B:94:0x0182, B:96:0x01ab, B:95:0x0185), top: B:115:0x017e }] */
    /* JADX WARN: Instruction removed from duplicated block: B:95:0x0185, please report this as an issue */
    public static boolean a(String str, File file, InterfaceC1279a interfaceC1279a, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        File file2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        long length;
        InputStream bufferedInputStream;
        HttpURLConnection httpURLConnection2;
        int contentLength;
        HashMap map;
        BufferedInputStream bufferedInputStream2;
        int i;
        int i2;
        byte[] bArr;
        int i3;
        File file3;
        FileOutputStream fileOutputStream3;
        byte[] bArr2;
        int i4;
        int i5;
        BufferedInputStream bufferedInputStream3;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) ex(str);
            if (z) {
                try {
                    length = file.length();
                    fileOutputStream2 = new FileOutputStream(file, true);
                    if (length > 0) {
                        try {
                            httpURLConnection3.setRequestProperty("Range", String.format("bytes=%s-%s", Long.valueOf(length), ""));
                            try {
                                p.b(httpURLConnection3);
                                httpURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                                bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                                try {
                                    contentLength = httpURLConnection3.getContentLength();
                                    if (httpURLConnection3.getHeaderFields() == null) {
                                        try {
                                            map = new HashMap();
                                        } catch (Throwable th) {
                                            th = th;
                                            httpURLConnection = httpURLConnection3;
                                            inputStream = bufferedInputStream;
                                            file2 = null;
                                            fileOutputStream = null;
                                            if (th instanceof IOException) {
                                                throw th;
                                            }
                                            throw new IOException(th.getClass().getName() + u15.f19942b + th.getMessage(), th);
                                        }
                                    } else {
                                        map = new HashMap(httpURLConnection3.getHeaderFields());
                                    }
                                    bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
                                    try {
                                        bufferedInputStream = a(map, bufferedInputStream2);
                                        if (contentLength <= 0) {
                                            httpURLConnection2 = httpURLConnection3;
                                            try {
                                                Random random = new Random(System.currentTimeMillis());
                                                file3 = new File(bg.eg(mContext), random.nextInt() + ".tmp");
                                                try {
                                                    fileOutputStream3 = new FileOutputStream(file3);
                                                    try {
                                                        bArr2 = new byte[8192];
                                                        i4 = 0;
                                                        while (true) {
                                                            i5 = bufferedInputStream.read(bArr2);
                                                            if (i5 == -1) {
                                                                break;
                                                            }
                                                            i4 += i5;
                                                            fileOutputStream3.write(bArr2, 0, i5);
                                                        }
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream3);
                                                        bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3));
                                                        try {
                                                            map.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                                                            contentLength = i4;
                                                            file2 = file3;
                                                            inputStream = bufferedInputStream3;
                                                            fileOutputStream = fileOutputStream3;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            httpURLConnection = httpURLConnection2;
                                                            file2 = file3;
                                                            inputStream = bufferedInputStream3;
                                                            fileOutputStream = fileOutputStream3;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        httpURLConnection = httpURLConnection2;
                                                        fileOutputStream = fileOutputStream3;
                                                        file2 = file3;
                                                        inputStream = bufferedInputStream;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    httpURLConnection = httpURLConnection2;
                                                    file2 = file3;
                                                    inputStream = bufferedInputStream;
                                                    fileOutputStream = null;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                httpURLConnection = httpURLConnection2;
                                                inputStream = bufferedInputStream;
                                                file2 = null;
                                                fileOutputStream = null;
                                                if (th instanceof IOException) {
                                                    throw th;
                                                }
                                                throw new IOException(th.getClass().getName() + u15.f19942b + th.getMessage(), th);
                                            }
                                        } else {
                                            httpURLConnection2 = httpURLConnection3;
                                            inputStream = bufferedInputStream;
                                            file2 = null;
                                            fileOutputStream = null;
                                        }
                                        if (length > 0) {
                                            i = (int) length;
                                        } else {
                                            i = 0;
                                        }
                                        i2 = contentLength + i;
                                        if (interfaceC1279a != null) {
                                            try {
                                                if (!interfaceC1279a.B(i, i2)) {
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                                    httpURLConnection2.disconnect();
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                                    if (file2 != null) {
                                                        file2.delete();
                                                    }
                                                    return false;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                httpURLConnection = httpURLConnection2;
                                            }
                                        }
                                        bArr = new byte[8192];
                                        while (true) {
                                            i3 = inputStream.read(bArr);
                                            if (i3 == -1) {
                                                break;
                                            }
                                            i += i3;
                                            fileOutputStream2.write(bArr, 0, i3);
                                            if (interfaceC1279a != null) {
                                                interfaceC1279a.A(i, i2);
                                            }
                                        }
                                        if (interfaceC1279a != null) {
                                            interfaceC1279a.C(i2, i2);
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                        httpURLConnection2.disconnect();
                                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                        if (file2 == null) {
                                            return true;
                                        }
                                        file2.delete();
                                        return true;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        httpURLConnection = httpURLConnection3;
                                        inputStream = bufferedInputStream2;
                                        file2 = null;
                                        fileOutputStream = null;
                                        if (th instanceof IOException) {
                                            throw th;
                                        }
                                        throw new IOException(th.getClass().getName() + u15.f19942b + th.getMessage(), th);
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    httpURLConnection2 = httpURLConnection3;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                httpURLConnection = httpURLConnection3;
                                inputStream = null;
                                file2 = null;
                                fileOutputStream = null;
                                if (th instanceof IOException) {
                                    throw th;
                                }
                                throw new IOException(th.getClass().getName() + u15.f19942b + th.getMessage(), th);
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            httpURLConnection = httpURLConnection3;
                            inputStream = null;
                            file2 = null;
                            fileOutputStream = null;
                            if (th instanceof IOException) {
                                throw th;
                            }
                            throw new IOException(th.getClass().getName() + u15.f19942b + th.getMessage(), th);
                        }
                    } else {
                        p.b(httpURLConnection3);
                        httpURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                        bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                        contentLength = httpURLConnection3.getContentLength();
                        if (httpURLConnection3.getHeaderFields() == null) {
                            map = new HashMap();
                        } else {
                            map = new HashMap(httpURLConnection3.getHeaderFields());
                        }
                        bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
                        bufferedInputStream = a(map, bufferedInputStream2);
                        if (contentLength <= 0) {
                            httpURLConnection2 = httpURLConnection3;
                            Random random2 = new Random(System.currentTimeMillis());
                            file3 = new File(bg.eg(mContext), random2.nextInt() + ".tmp");
                            fileOutputStream3 = new FileOutputStream(file3);
                            bArr2 = new byte[8192];
                            i4 = 0;
                            while (true) {
                                i5 = bufferedInputStream.read(bArr2);
                                if (i5 == -1) {
                                    break;
                                    break;
                                }
                                i4 += i5;
                                fileOutputStream3.write(bArr2, 0, i5);
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream3);
                            bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3));
                            map.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                            contentLength = i4;
                            file2 = file3;
                            inputStream = bufferedInputStream3;
                            fileOutputStream = fileOutputStream3;
                        } else {
                            httpURLConnection2 = httpURLConnection3;
                            inputStream = bufferedInputStream;
                            file2 = null;
                            fileOutputStream = null;
                        }
                        if (length > 0) {
                            i = (int) length;
                        } else {
                            i = 0;
                        }
                        i2 = contentLength + i;
                        if (interfaceC1279a != null) {
                            if (!interfaceC1279a.B(i, i2)) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                httpURLConnection2.disconnect();
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                if (file2 != null) {
                                    file2.delete();
                                }
                                return false;
                            }
                        }
                        bArr = new byte[8192];
                        while (true) {
                            i3 = inputStream.read(bArr);
                            if (i3 == -1) {
                                break;
                                break;
                            }
                            i += i3;
                            fileOutputStream2.write(bArr, 0, i3);
                            if (interfaceC1279a != null) {
                                interfaceC1279a.A(i, i2);
                            }
                        }
                        if (interfaceC1279a != null) {
                            interfaceC1279a.C(i2, i2);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        httpURLConnection2.disconnect();
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        if (file2 == null) {
                            return true;
                        }
                        file2.delete();
                        return true;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                    file2 = null;
                    fileOutputStream = null;
                    fileOutputStream2 = null;
                }
            } else {
                try {
                    fileOutputStream2 = new FileOutputStream(file, false);
                    length = -1;
                    p.b(httpURLConnection3);
                    httpURLConnection3.setRequestProperty("Accept-Encoding", "gzip");
                    bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                    contentLength = httpURLConnection3.getContentLength();
                    if (httpURLConnection3.getHeaderFields() == null) {
                        map = new HashMap();
                    } else {
                        map = new HashMap(httpURLConnection3.getHeaderFields());
                    }
                    bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
                    bufferedInputStream = a(map, bufferedInputStream2);
                    if (contentLength <= 0) {
                        httpURLConnection2 = httpURLConnection3;
                        Random random3 = new Random(System.currentTimeMillis());
                        file3 = new File(bg.eg(mContext), random3.nextInt() + ".tmp");
                        fileOutputStream3 = new FileOutputStream(file3);
                        bArr2 = new byte[8192];
                        i4 = 0;
                        while (true) {
                            i5 = bufferedInputStream.read(bArr2);
                            if (i5 == -1) {
                                break;
                                break;
                            }
                            i4 += i5;
                            fileOutputStream3.write(bArr2, 0, i5);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream3);
                        bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3));
                        map.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                        contentLength = i4;
                        file2 = file3;
                        inputStream = bufferedInputStream3;
                        fileOutputStream = fileOutputStream3;
                    } else {
                        httpURLConnection2 = httpURLConnection3;
                        inputStream = bufferedInputStream;
                        file2 = null;
                        fileOutputStream = null;
                    }
                    if (length > 0) {
                        i = (int) length;
                    } else {
                        i = 0;
                    }
                    i2 = contentLength + i;
                    if (interfaceC1279a != null) {
                        if (!interfaceC1279a.B(i, i2)) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                            httpURLConnection2.disconnect();
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                            if (file2 != null) {
                                file2.delete();
                            }
                            return false;
                        }
                    }
                    bArr = new byte[8192];
                    while (true) {
                        i3 = inputStream.read(bArr);
                        if (i3 == -1) {
                            break;
                            break;
                        }
                        i += i3;
                        fileOutputStream2.write(bArr, 0, i3);
                        if (interfaceC1279a != null) {
                            interfaceC1279a.A(i, i2);
                        }
                    }
                    if (interfaceC1279a != null) {
                        interfaceC1279a.C(i2, i2);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    httpURLConnection2.disconnect();
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    if (file2 == null) {
                        return true;
                    }
                    file2.delete();
                    return true;
                } catch (Throwable th12) {
                    th = th12;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                    file2 = null;
                    fileOutputStream = null;
                    fileOutputStream2 = null;
                }
            }
        } catch (Throwable th13) {
            th = th13;
            httpURLConnection = null;
        }
        try {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException(th.getClass().getName() + u15.f19942b + th.getMessage(), th);
        } catch (Throwable th14) {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            if (file2 != null) {
                file2.delete();
            }
            throw th14;
        }
    }

    private static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        boolean z;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                Iterator<String> it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if ("gzip".equalsIgnoreCase(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }
}
