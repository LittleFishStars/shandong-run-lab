package com.igexin.push.f.a;

import android.os.Process;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends com.igexin.c.a.d.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38114a = "com.igexin.push.f.a.b";
    public static final int b = -2147483639;
    private static final int d = 20000;
    public d c;
    private HttpURLConnection e;

    public b(d dVar) {
        super(0);
        this.c = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private byte[] a(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            this.e = httpURLConnection;
            httpURLConnection.setConnectTimeout(20000);
            this.e.setReadTimeout(20000);
            this.e.setRequestMethod("GET");
            this.e.setDoInput(true);
            inputStream = this.e.getInputStream();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        if (this.e.getResponseCode() == 200) {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                                com.igexin.c.a.c.a.a(e);
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e2) {
                                com.igexin.c.a.c.a.a(e2);
                            }
                            g();
                            return byteArray;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e4) {
                            e = e4;
                            com.igexin.c.a.c.a.a(e);
                        }
                    } catch (Exception e5) {
                        e = e5;
                        com.igexin.c.a.c.a.a(e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e6) {
                                com.igexin.c.a.c.a.a(e6);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e7) {
                                e = e7;
                                com.igexin.c.a.c.a.a(e);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e8) {
                            com.igexin.c.a.c.a.a(e8);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e9) {
                            com.igexin.c.a.c.a.a(e9);
                        }
                    }
                    g();
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                g();
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
        g();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    private byte[] a(String str, byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ?? byteArrayOutputStream2;
        Exception e;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                this.e = httpURLConnection;
                httpURLConnection.setDoInput(true);
                this.e.setDoOutput(true);
                this.e.setRequestMethod("POST");
                this.e.setUseCaches(false);
                this.e.setInstanceFollowRedirects(true);
                this.e.setRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                this.e.setConnectTimeout(20000);
                this.e.setReadTimeout(20000);
                this.e.connect();
                str = new DataOutputStream(this.e.getOutputStream());
                try {
                    str.write(bArr, 0, bArr.length);
                    str.flush();
                    if (this.e.getResponseCode() != 200) {
                        try {
                            str.close();
                        } catch (Exception e2) {
                            e = e2;
                            com.igexin.c.a.c.a.a(e);
                        }
                        g();
                        return null;
                    }
                    bArr = this.e.getInputStream();
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i = bArr.read(bArr2);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, i);
                            }
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            try {
                                str.close();
                            } catch (Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                            try {
                                bArr.close();
                            } catch (Exception e4) {
                                com.igexin.c.a.c.a.a(e4);
                            }
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e5) {
                                com.igexin.c.a.c.a.a(e5);
                            }
                            g();
                            return byteArray;
                        } catch (Exception e6) {
                            e = e6;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        byteArrayOutputStream2 = 0;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        th = th2;
                        if (str != 0) {
                            try {
                                str.close();
                            } catch (Exception e8) {
                                com.igexin.c.a.c.a.a(e8);
                            }
                        }
                        if (bArr != 0) {
                            try {
                                bArr.close();
                            } catch (Exception e9) {
                                com.igexin.c.a.c.a.a(e9);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e10) {
                                com.igexin.c.a.c.a.a(e10);
                            }
                        }
                        g();
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    bArr = 0;
                    str = str;
                    byteArrayOutputStream2 = bArr;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    bArr = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e12) {
            e = e12;
            str = 0;
            bArr = 0;
        } catch (Throwable th5) {
            bArr = 0;
            byteArrayOutputStream = null;
            th = th5;
            str = 0;
        }
        com.igexin.c.a.c.a.a(e);
        if (str != 0) {
            try {
                str.close();
            } catch (Exception e13) {
                com.igexin.c.a.c.a.a(e13);
            }
        }
        if (bArr != 0) {
            try {
                bArr.close();
            } catch (Exception e14) {
                com.igexin.c.a.c.a.a(e14);
            }
        }
        if (byteArrayOutputStream2 != 0) {
            try {
                byteArrayOutputStream2.close();
            } catch (Exception e15) {
                e = e15;
                com.igexin.c.a.c.a.a(e);
            }
        }
        g();
        return null;
    }

    private void g() {
        HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.e = null;
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        g();
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        String str;
        byte[] bArr;
        super.b_();
        Process.setThreadPriority(10);
        d dVar = this.c;
        if (dVar == null || (str = dVar.f) == null || ((bArr = dVar.g) != null && bArr.length > com.igexin.push.config.d.A * 1024)) {
            l();
            String str2 = f38114a;
            com.igexin.c.a.c.a.a(str2, "run return ###");
            com.igexin.c.a.c.a.a(str2 + "|run return ###", new Object[0]);
            return;
        }
        try {
            byte[] bArrA = bArr == null ? a(str) : a(str, bArr);
            if (bArrA == null) {
                Exception exc = new Exception("Http response ＝＝ null");
                this.c.a(exc);
                throw exc;
            }
            try {
                this.c.a(bArrA);
                com.igexin.c.a.b.e.a().a(this.c);
                com.igexin.c.a.b.e.a().b();
            } catch (Exception e) {
                this.c.a(e);
                throw e;
            }
        } catch (Exception e2) {
            this.c.a(e2);
            throw e2;
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483639;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        this.o = true;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
        g();
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
