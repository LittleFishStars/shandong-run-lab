package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f40129a = "gzip";
    private static final int b = 1024;
    private static volatile l d;
    private static Context e;
    private boolean c = false;

    private l(Context context) {
        e = context;
    }

    public static l a(Context context) {
        if (d == null) {
            synchronized (l.class) {
                if (d == null) {
                    d = new l(context);
                }
            }
        }
        return d;
    }

    public void b(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "POST");
    }

    public void a(m mVar, j jVar) throws Throwable {
        a(mVar, jVar, "GET");
    }

    public HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if ("https".equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                a(httpsURLConnection);
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setAllowUserInteraction(true);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                if (!str2.equalsIgnoreCase("post")) {
                    return httpURLConnection;
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                return httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f5 A[Catch: Exception -> 0x00fd, TryCatch #4 {Exception -> 0x00fd, blocks: (B:54:0x00f0, B:56:0x00f5, B:58:0x00fa), top: B:77:0x00f0 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00fa A[Catch: Exception -> 0x00fd, TRY_LEAVE, TryCatch #4 {Exception -> 0x00fd, blocks: (B:54:0x00f0, B:56:0x00f5, B:58:0x00fa), top: B:77:0x00f0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void a(m mVar, j jVar, String str) throws Throwable {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        String string;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            HttpURLConnection httpURLConnectionA = a(mVar.f40130a, str);
            String strB = mVar.b();
            if (!TextUtils.isEmpty(strB) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty(com.google.common.net.b.p, strB);
            }
            String strC = mVar.c();
            if (!TextUtils.isEmpty(strC) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty("env", strC);
            }
            if (str.equalsIgnoreCase("post")) {
                byte[] bytes = mVar.a() != null ? mVar.a().toString().getBytes() : null;
                if (bytes != null && bytes.length > 0) {
                    httpURLConnectionA.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                    OutputStream outputStream = httpURLConnectionA.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    outputStream.close();
                }
            }
            boolean z = false;
            if (httpURLConnectionA.getResponseCode() == 200) {
                inputStream2 = httpURLConnectionA.getInputStream();
                try {
                    try {
                        new h(e).b(dd.d, httpURLConnectionA.getDate() - System.currentTimeMillis());
                        e.c("WeaponHttpTask --   date " + httpURLConnectionA.getDate() + " " + System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStream2.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream2.write(bArr, 0, i);
                                }
                            }
                            z = true;
                            byteArrayOutputStream3 = byteArrayOutputStream2;
                            string = byteArrayOutputStream2.toString();
                        } catch (Exception unused2) {
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception unused3) {
                                    return;
                                }
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (jVar != null) {
                                jVar.b(null);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            inputStream = inputStream2;
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (jVar != null) {
                                        jVar.b(null);
                                    }
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            } else {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (jVar != null) {
                                    jVar.b(null);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused5) {
                        byteArrayOutputStream2 = null;
                    }
                } catch (Throwable th2) {
                    byteArrayOutputStream = null;
                    inputStream = inputStream2;
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (jVar != null) {
                            jVar.b(null);
                        }
                    } else {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (jVar != null) {
                            jVar.b(null);
                        }
                    }
                    throw th;
                }
            } else {
                inputStream2 = null;
                string = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.close();
                } catch (Exception unused6) {
                    return;
                }
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (z) {
                if (jVar != null) {
                    jVar.a(string);
                }
            } else if (jVar != null) {
                jVar.b(string);
            }
        } catch (Exception unused7) {
            inputStream2 = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d1 A[Catch: Exception -> 0x00ef, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ef, blocks: (B:39:0x00cc, B:41:0x00d1), top: B:64:0x00cc }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00de A[Catch: Exception -> 0x00e1, TRY_LEAVE, TryCatch #8 {Exception -> 0x00e1, blocks: (B:46:0x00d9, B:48:0x00de), top: B:72:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00eb A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ee, blocks: (B:52:0x00e6, B:54:0x00eb), top: B:66:0x00e6 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String a(m mVar) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        String string;
        ByteArrayOutputStream byteArrayOutputStream2;
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            HttpURLConnection httpURLConnectionA = a(mVar.f40130a, "POST");
            String strB = mVar.b();
            if (!TextUtils.isEmpty(strB) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty(com.google.common.net.b.p, strB);
            }
            String strC = mVar.c();
            if (!TextUtils.isEmpty(strC) && httpURLConnectionA != null) {
                httpURLConnectionA.setRequestProperty("env", strC);
            }
            byte[] bytes = mVar.a() != null ? mVar.a().toString().getBytes() : null;
            if (bytes != null && bytes.length > 0) {
                httpURLConnectionA.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                OutputStream outputStream = httpURLConnectionA.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
            if (httpURLConnectionA.getResponseCode() == 200) {
                inputStream2 = httpURLConnectionA.getInputStream();
                try {
                    try {
                        new h(e).b(dd.d, httpURLConnectionA.getDate() - System.currentTimeMillis());
                        e.c("WeaponHttpTask --   date " + httpURLConnectionA.getDate() + " " + System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStream2.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                            string = byteArrayOutputStream.toString();
                            z = true;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Exception unused2) {
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                } catch (Exception unused3) {
                                    string = null;
                                    if (z) {
                                        return string;
                                    }
                                    return null;
                                }
                            } else if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            string = null;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            Throwable th2 = th;
                            inputStream = inputStream2;
                            th = th2;
                            if (byteArrayOutputStream3 != null) {
                                try {
                                    byteArrayOutputStream3.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            } else if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception unused5) {
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Throwable th4 = th;
                    inputStream = inputStream2;
                    th = th4;
                    if (byteArrayOutputStream3 != null) {
                        byteArrayOutputStream3.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } else if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } else {
                inputStream2 = null;
                string = null;
                byteArrayOutputStream2 = null;
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                } catch (Exception unused6) {
                }
            } else if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (Exception unused7) {
            inputStream2 = null;
            byteArrayOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        if (z) {
            return string;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002c A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:17:0x0027, B:19:0x002c), top: B:23:0x0027 }] */
    public boolean a(String str, File file) {
        HttpURLConnection httpURLConnectionA;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStreamA = null;
        try {
            httpURLConnectionA = a(str, "GET");
            try {
                inputStreamA = a(httpURLConnectionA);
                boolean zA = a(inputStreamA, file);
                if (inputStreamA != null) {
                    try {
                        inputStreamA.close();
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                return zA;
            } catch (Throwable unused2) {
                if (inputStreamA != null) {
                    try {
                        inputStreamA.close();
                        if (httpURLConnectionA != null) {
                            httpURLConnectionA.disconnect();
                        }
                    } catch (Throwable unused3) {
                        return false;
                    }
                } else if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                return false;
            }
        } catch (Throwable unused4) {
            httpURLConnectionA = null;
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.c = true;
            } else {
                this.c = false;
            }
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.c) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        bufferedOutputStream.write(bArr, 0, i);
                        bufferedOutputStream.flush();
                    } else {
                        try {
                            bufferedOutputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused3) {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            }
        } catch (Throwable unused5) {
            bufferedOutputStream = null;
        }
    }

    public String a(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str = str + "&" + entry.getKey() + "=" + entry.getValue();
        }
        return str.substring(1);
    }
}
