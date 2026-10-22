package com.ipd.dsp.internal.b2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.c2.l;
import com.ipd.dsp.internal.c2.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d extends b {
    public final String k;

    public d(String str, @NonNull Map<String, Object> map, @Nullable com.ipd.dsp.internal.y1.b.a aVar) {
        super("Event", str, map, 5, aVar);
        String strA = l.a(map);
        this.k = strA + "&sign=" + l.a(strA);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0149 A[Catch: IOException -> 0x014c, PHI: r0 r1 r5
      0x0149: PHI (r0v10 ??) = (r0v8 ??), (r0v11 ??) binds: [B:64:0x0129, B:74:0x0147] A[DONT_GENERATE, DONT_INLINE]
      0x0149: PHI (r1v10 ??) = (r1v8 ??), (r1v11 ??) binds: [B:64:0x0129, B:74:0x0147] A[DONT_GENERATE, DONT_INLINE]
      0x0149: PHI (r5v5 java.io.ByteArrayOutputStream) = (r5v3 java.io.ByteArrayOutputStream), (r5v6 java.io.ByteArrayOutputStream) binds: [B:64:0x0129, B:74:0x0147] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x014c, blocks: (B:39:0x00e5, B:75:0x0149), top: B:112:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // java.lang.Runnable
    public void run() {
        ?? r1;
        ?? r3;
        ?? r2;
        ?? r4;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        IOException e;
        ?? inputStream = "gzip";
        ?? B = "http://";
        try {
            try {
                try {
                    String strReplaceFirst = this.g;
                    if (com.ipd.dsp.internal.l1.a.a().isHttpsOnly() && strReplaceFirst.startsWith("http://")) {
                        strReplaceFirst = strReplaceFirst.replaceFirst("http://", "https://");
                    }
                    B = b(strReplaceFirst);
                    try {
                        try {
                            B.setRequestMethod("POST");
                            B.setDoInput(true);
                            B.setDoOutput(true);
                            B.setUseCaches(false);
                            B.setConnectTimeout(this.i * 1000);
                            B.setReadTimeout(this.i * 1000);
                            B.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                            B.setRequestProperty("Accept-Encoding", "gzip");
                            byte[] bytes = this.k.getBytes();
                            B.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                            B.getOutputStream().write(bytes);
                            int responseCode = B.getResponseCode();
                            if (responseCode >= 200 && responseCode <= 299) {
                                String strName = StandardCharsets.UTF_8.name();
                                String contentType = B.getContentType();
                                if (contentType != null) {
                                    for (String str : contentType.split(com.alipay.sdk.m.y.l.b)) {
                                        if (str.trim().startsWith("charset=")) {
                                            try {
                                                String strSubstring = str.trim().substring(8);
                                                if (Charset.isSupported(strSubstring)) {
                                                    strName = strSubstring;
                                                }
                                            } catch (Exception unused) {
                                            }
                                        }
                                    }
                                }
                                String headerField = B.getHeaderField("content-encoding");
                                inputStream = (headerField == null || !headerField.contains("gzip")) ? B.getInputStream() : new GZIPInputStream(B.getInputStream());
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        byte[] bArr = new byte[8192];
                                        while (true) {
                                            int i = inputStream.read(bArr);
                                            if (i == -1) {
                                                break;
                                            } else {
                                                byteArrayOutputStream.write(bArr, 0, i);
                                            }
                                        }
                                        a(byteArrayOutputStream.toString(strName));
                                        try {
                                            B.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                        byteArrayOutputStream.close();
                                    } catch (IOException e2) {
                                        e = e2;
                                        r.a(e);
                                        b(com.ipd.dsp.internal.f1.a.f(), e);
                                        if (B != 0) {
                                            try {
                                                B.disconnect();
                                            } catch (Throwable unused4) {
                                            }
                                        }
                                        if (inputStream != 0) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused5) {
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r.a(th);
                                        b(com.ipd.dsp.internal.f1.a.k(), th);
                                        if (B != 0) {
                                            try {
                                                B.disconnect();
                                            } catch (Throwable unused6) {
                                            }
                                        }
                                        if (inputStream != 0) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused7) {
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            byteArrayOutputStream.close();
                                        }
                                    }
                                } catch (IOException e3) {
                                    r2 = inputStream;
                                    e = e3;
                                    r4 = B;
                                    byteArrayOutputStream = null;
                                    e = e;
                                    inputStream = r2;
                                    B = r4;
                                    r.a(e);
                                    b(com.ipd.dsp.internal.f1.a.f(), e);
                                    if (B != 0) {
                                        B.disconnect();
                                    }
                                    if (inputStream != 0) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return;
                                } catch (Throwable th3) {
                                    r1 = inputStream;
                                    th = th3;
                                    r3 = B;
                                    byteArrayOutputStream = null;
                                    th = th;
                                    inputStream = r1;
                                    B = r3;
                                    r.a(th);
                                    b(com.ipd.dsp.internal.f1.a.k(), th);
                                    if (B != 0) {
                                        B.disconnect();
                                    }
                                    if (inputStream != 0) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return;
                                }
                                return;
                            }
                            b(com.ipd.dsp.internal.f1.a.f(), null);
                            try {
                                B.disconnect();
                            } catch (Throwable unused8) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            r3 = B;
                            r1 = 0;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        r4 = B;
                        r2 = 0;
                    }
                } catch (Throwable th5) {
                    if (B != 0) {
                        try {
                            B.disconnect();
                        } catch (Throwable unused9) {
                        }
                    }
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException unused10) {
                        }
                    }
                    if (byteArrayOutputStream == null) {
                        throw th5;
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th5;
                    } catch (IOException unused11) {
                        throw th5;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                r2 = 0;
                r4 = 0;
            } catch (Throwable th6) {
                th = th6;
                r1 = 0;
                r3 = 0;
            }
        } catch (IOException unused12) {
        }
    }
}
