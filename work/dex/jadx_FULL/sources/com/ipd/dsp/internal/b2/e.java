package com.ipd.dsp.internal.b2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.y.l;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends b {
    public e(@NonNull String str, @Nullable com.ipd.dsp.internal.y1.b.a aVar) {
        super("TP", str, null, 5, aVar);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fa, code lost:
    
        if (r4 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0118, code lost:
    
        if (r4 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x011a, code lost:
    
        r4.close();
        r0 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ?? r2;
        HttpURLConnection httpURLConnection;
        ?? r3;
        HttpURLConnection httpURLConnection2;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        HttpURLConnection httpURLConnectionB;
        IOException e;
        ?? inputStream = "gzip";
        try {
            try {
                try {
                    httpURLConnectionB = b(this.g);
                    try {
                        try {
                            httpURLConnectionB.setRequestMethod("GET");
                            httpURLConnectionB.setConnectTimeout(this.i * 1000);
                            httpURLConnectionB.setReadTimeout(this.i * 1000);
                            httpURLConnectionB.setRequestProperty("Accept-Encoding", "gzip");
                            httpURLConnectionB.setRequestProperty("X-Request-With", g.a().O());
                            if (httpURLConnectionB.getResponseCode() >= 200 && httpURLConnectionB.getResponseCode() <= 299) {
                                String strName = StandardCharsets.UTF_8.name();
                                String contentType = httpURLConnectionB.getContentType();
                                if (contentType != null) {
                                    for (String str : contentType.split(l.b)) {
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
                                String headerField = httpURLConnectionB.getHeaderField("content-encoding");
                                inputStream = (headerField == null || !headerField.contains("gzip")) ? httpURLConnectionB.getInputStream() : new GZIPInputStream(httpURLConnectionB.getInputStream());
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
                                            httpURLConnectionB.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                        byteArrayOutputStream.close();
                                        inputStream = inputStream;
                                    } catch (IOException e2) {
                                        e = e2;
                                        r.a(e);
                                        b(com.ipd.dsp.internal.f1.a.f(), e);
                                        if (httpURLConnectionB != null) {
                                            try {
                                                httpURLConnectionB.disconnect();
                                            } catch (Throwable unused4) {
                                            }
                                        }
                                        if (inputStream != 0) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused5) {
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r.a(th);
                                        b(com.ipd.dsp.internal.f1.a.k(), th);
                                        if (httpURLConnectionB != null) {
                                            try {
                                                httpURLConnectionB.disconnect();
                                            } catch (Throwable unused6) {
                                            }
                                        }
                                        if (inputStream != 0) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused7) {
                                            }
                                        }
                                    }
                                } catch (IOException e3) {
                                    r3 = inputStream;
                                    e = e3;
                                    httpURLConnection2 = httpURLConnectionB;
                                    byteArrayOutputStream = null;
                                    e = e;
                                    inputStream = r3;
                                    httpURLConnectionB = httpURLConnection2;
                                    r.a(e);
                                    b(com.ipd.dsp.internal.f1.a.f(), e);
                                    if (httpURLConnectionB != null) {
                                        httpURLConnectionB.disconnect();
                                    }
                                    if (inputStream != 0) {
                                        inputStream.close();
                                    }
                                } catch (Throwable th3) {
                                    r2 = inputStream;
                                    th = th3;
                                    httpURLConnection = httpURLConnectionB;
                                    byteArrayOutputStream = null;
                                    th = th;
                                    inputStream = r2;
                                    httpURLConnectionB = httpURLConnection;
                                    r.a(th);
                                    b(com.ipd.dsp.internal.f1.a.k(), th);
                                    if (httpURLConnectionB != null) {
                                        httpURLConnectionB.disconnect();
                                    }
                                    if (inputStream != 0) {
                                        inputStream.close();
                                    }
                                }
                                return;
                            }
                            b(com.ipd.dsp.internal.f1.a.f(), null);
                            try {
                                httpURLConnectionB.disconnect();
                            } catch (Throwable unused8) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            httpURLConnection = httpURLConnectionB;
                            r2 = 0;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        httpURLConnection2 = httpURLConnectionB;
                        r3 = 0;
                    }
                } catch (IOException unused9) {
                }
            } catch (IOException e5) {
                e = e5;
                r3 = 0;
                httpURLConnection2 = null;
            } catch (Throwable th5) {
                th = th5;
                r2 = 0;
                httpURLConnection = null;
            }
        } catch (Throwable th6) {
            if (httpURLConnectionB != null) {
                try {
                    httpURLConnectionB.disconnect();
                } catch (Throwable unused10) {
                }
            }
            if (inputStream != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused11) {
                }
            }
            if (byteArrayOutputStream == null) {
                throw th6;
            }
            try {
                byteArrayOutputStream.close();
                throw th6;
            } catch (IOException unused12) {
                throw th6;
            }
        }
    }
}
