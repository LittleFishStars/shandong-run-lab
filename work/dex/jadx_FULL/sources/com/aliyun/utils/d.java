package com.aliyun.utils;

import com.cicada.player.utils.Logger;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {
    private static final String h = "d";
    private static ExecutorService i = Executors.newCachedThreadPool();
    private String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private URLConnection f25868a = null;
    private String c = null;
    private int d = 10000;
    private String e = null;
    private String f = null;
    private String[] g = null;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            try {
                if (d.this.f25868a instanceof HttpsURLConnection) {
                    Logger.i(d.h, "HttpClientHelper stop().... HttpsURLConnection.disconnect ");
                    httpURLConnection = (HttpsURLConnection) d.this.f25868a;
                } else {
                    if (!(d.this.f25868a instanceof HttpURLConnection)) {
                        return;
                    }
                    Logger.i(d.h, "HttpClientHelper stop().... HttpURLConnection.disconnect ");
                    httpURLConnection = (HttpURLConnection) d.this.f25868a;
                }
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Logger.e(d.h, e.getMessage());
            }
        }
    }

    public d(String str) {
        this.b = str;
    }

    private URLConnection a(String str) {
        Proxy proxy;
        try {
            if (this.e != null) {
                try {
                    URL url = new URL(this.e);
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
                } catch (Exception unused) {
                    proxy = null;
                }
            } else {
                proxy = null;
            }
            URL url2 = new URL(str);
            URLConnection uRLConnectionOpenConnection = proxy != null ? url2.openConnection(proxy) : url2.openConnection();
            try {
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(this.d);
                httpURLConnection.setReadTimeout(this.d);
            } catch (Exception unused2) {
            }
            return uRLConnectionOpenConnection;
        } catch (Exception unused3) {
            return null;
        }
    }

    private URLConnection b(String str) {
        Proxy proxy;
        try {
            if (this.e != null) {
                try {
                    URL url = new URL(this.e);
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
                } catch (Exception unused) {
                    proxy = null;
                }
            } else {
                proxy = null;
            }
            URL url2 = new URL(str);
            URLConnection uRLConnectionOpenConnection = proxy != null ? url2.openConnection(proxy) : url2.openConnection();
            try {
                if (!(uRLConnectionOpenConnection instanceof HttpsURLConnection)) {
                    return null;
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(this.d);
                httpsURLConnection.setReadTimeout(this.d);
            } catch (Exception unused2) {
            }
            return uRLConnectionOpenConnection;
        } catch (Exception unused3) {
            return null;
        }
    }

    private InputStream c() {
        HttpURLConnection httpURLConnection;
        URLConnection uRLConnection = this.f25868a;
        if (uRLConnection instanceof HttpsURLConnection) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
        } else {
            if (!(uRLConnection instanceof HttpURLConnection)) {
                return null;
            }
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        return httpURLConnection.getErrorStream();
    }

    private int d() throws IOException {
        HttpURLConnection httpURLConnection;
        URLConnection uRLConnection = this.f25868a;
        if (uRLConnection instanceof HttpsURLConnection) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
        } else {
            if (!(uRLConnection instanceof HttpURLConnection)) {
                return 0;
            }
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        return httpURLConnection.getResponseCode();
    }

    public void a(int i2) {
        this.d = i2;
    }

    public void a(String[] strArr) {
        this.g = strArr;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x015c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x015e A[Catch: IOException -> 0x0166, TryCatch #13 {IOException -> 0x0166, blocks: (B:109:0x0159, B:111:0x015e, B:113:0x0163), top: B:153:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0163 A[Catch: IOException -> 0x0166, TRY_LEAVE, TryCatch #13 {IOException -> 0x0166, blocks: (B:109:0x0159, B:111:0x015e, B:113:0x0163), top: B:153:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x016a  */
    /* JADX WARN: Code duplicated, block: B:118:0x016e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:122:0x0178  */
    /* JADX WARN: Code duplicated, block: B:129:0x0187 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x002b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x0189 A[Catch: IOException -> 0x0191, TryCatch #5 {IOException -> 0x0191, blocks: (B:128:0x0184, B:130:0x0189, B:132:0x018e), top: B:149:0x0184 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x018e A[Catch: IOException -> 0x0191, TRY_LEAVE, TryCatch #5 {IOException -> 0x0191, blocks: (B:128:0x0184, B:130:0x0189, B:132:0x018e), top: B:149:0x0184 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0195  */
    /* JADX WARN: Code duplicated, block: B:137:0x0199  */
    /* JADX WARN: Code duplicated, block: B:139:0x019d  */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:147:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0030  */
    /* JADX WARN: Code duplicated, block: B:171:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x008b A[EDGE_INSN: B:173:0x008b->B:38:0x008b BREAK  A[LOOP:1: B:35:0x0081->B:37:0x0087], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x00e8 A[EDGE_INSN: B:174:0x00e8->B:71:0x00e8 BREAK  A[LOOP:2: B:68:0x00de->B:70:0x00e4], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x006c A[Catch: all -> 0x0144, Exception -> 0x0149, TRY_LEAVE, TryCatch #17 {Exception -> 0x0149, all -> 0x0144, blocks: (B:29:0x0064, B:31:0x006c, B:64:0x00cb), top: B:161:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0087 A[Catch: all -> 0x00b0, Exception -> 0x00b6, LOOP:1: B:35:0x0081->B:37:0x0087, LOOP_END, TryCatch #16 {Exception -> 0x00b6, all -> 0x00b0, blocks: (B:34:0x007c, B:35:0x0081, B:37:0x0087, B:38:0x008b), top: B:162:0x007c }] */
    /* JADX WARN: Code duplicated, block: B:44:0x009e  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cb A[Catch: all -> 0x0144, Exception -> 0x0149, TRY_ENTER, TRY_LEAVE, TryCatch #17 {Exception -> 0x0149, all -> 0x0144, blocks: (B:29:0x0064, B:31:0x006c, B:64:0x00cb), top: B:161:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4 A[Catch: all -> 0x0120, Exception -> 0x0125, LOOP:2: B:68:0x00de->B:70:0x00e4, LOOP_END, TryCatch #19 {Exception -> 0x0125, all -> 0x0120, blocks: (B:67:0x00d9, B:68:0x00de, B:70:0x00e4, B:71:0x00e8, B:73:0x00f4), top: B:157:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x010e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0112  */
    /* JADX WARN: Code duplicated, block: B:83:0x0118  */
    /* JADX WARN: Code duplicated, block: B:85:0x011c  */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0044, please report this as an issue */
    public String b() throws Throwable {
        URLConnection uRLConnectionA;
        URLConnection uRLConnection;
        String str;
        String str2;
        String[] strArr;
        Throwable th;
        InputStream inputStream;
        Exception e;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        URLConnection uRLConnection2;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        Throwable th2;
        URLConnection uRLConnection3;
        HttpURLConnection httpURLConnection2;
        int iD;
        InputStream inputStreamC;
        StringBuilder sb;
        String line;
        URLConnection uRLConnection4;
        HttpURLConnection httpURLConnection3;
        StringBuilder sb2;
        String line2;
        URLConnection uRLConnection5;
        HttpURLConnection httpURLConnection4;
        int i2;
        String[] strArrSplit;
        InputStreamReader inputStreamReader3 = null;
        if (!this.b.startsWith("https://")) {
            if (this.b.startsWith("http://")) {
                uRLConnectionA = a(this.b);
            } else {
                this.f25868a = null;
            }
            uRLConnection = this.f25868a;
            if (uRLConnection == null) {
                return null;
            }
            str = this.c;
            if (str != null) {
                uRLConnection.setRequestProperty("Referer", str);
            }
            str2 = this.f;
            if (str2 != null) {
                this.f25868a.addRequestProperty("User-Agent", str2);
            }
            strArr = this.g;
            if (strArr != null) {
                for (String str3 : strArr) {
                    if (str3 != null) {
                        strArrSplit = str3.split(u15.f19942b);
                        if (strArrSplit.length == 2) {
                            this.f25868a.addRequestProperty(strArrSplit[0], strArrSplit[1]);
                        }
                    }
                }
            }
            try {
                iD = d();
                if (iD == 200) {
                    inputStream = this.f25868a.getInputStream();
                    try {
                        inputStreamReader = new InputStreamReader(inputStream);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            try {
                                sb2 = new StringBuilder();
                                while (true) {
                                    line2 = bufferedReader.readLine();
                                    if (line2 != null) {
                                        break;
                                    }
                                    sb2.append(line2);
                                }
                                String string = sb2.toString();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                inputStreamReader.close();
                                bufferedReader.close();
                                uRLConnection5 = this.f25868a;
                                if (uRLConnection5 != null) {
                                    if (uRLConnection5 instanceof HttpURLConnection) {
                                        httpURLConnection4 = (HttpURLConnection) uRLConnection5;
                                    } else if (uRLConnection5 instanceof HttpsURLConnection) {
                                        httpURLConnection4 = (HttpsURLConnection) uRLConnection5;
                                    }
                                    httpURLConnection4.disconnect();
                                }
                                return string;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    Logger.d("HttpClientUtil", e.getMessage());
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            if (inputStreamReader != null) {
                                                inputStreamReader.close();
                                            }
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                        } catch (IOException unused2) {
                                            uRLConnection3 = this.f25868a;
                                            if (uRLConnection3 != null) {
                                                if (uRLConnection3 instanceof HttpURLConnection) {
                                                    httpURLConnection2 = (HttpURLConnection) uRLConnection3;
                                                } else if (uRLConnection3 instanceof HttpsURLConnection) {
                                                    httpURLConnection2 = (HttpsURLConnection) uRLConnection3;
                                                }
                                                httpURLConnection2.disconnect();
                                            }
                                            return null;
                                        }
                                    } else {
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    }
                                    uRLConnection3 = this.f25868a;
                                    if (uRLConnection3 != null) {
                                        if (uRLConnection3 instanceof HttpURLConnection) {
                                            httpURLConnection2 = (HttpURLConnection) uRLConnection3;
                                        } else if (uRLConnection3 instanceof HttpsURLConnection) {
                                            httpURLConnection2 = (HttpsURLConnection) uRLConnection3;
                                        }
                                        httpURLConnection2.disconnect();
                                    }
                                    return null;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    bufferedReader2 = bufferedReader;
                                    inputStreamReader2 = inputStreamReader;
                                    th = th2;
                                    inputStreamReader3 = inputStreamReader2;
                                    bufferedReader = bufferedReader2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                            if (inputStreamReader3 != null) {
                                                inputStreamReader3.close();
                                            }
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                        } catch (IOException unused3) {
                                        }
                                    } else {
                                        if (inputStreamReader3 != null) {
                                            inputStreamReader3.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    }
                                    uRLConnection2 = this.f25868a;
                                    if (uRLConnection2 != null) {
                                        throw th;
                                    }
                                    if (!(uRLConnection2 instanceof HttpURLConnection)) {
                                        httpURLConnection = (HttpURLConnection) uRLConnection2;
                                    } else {
                                        if (uRLConnection2 instanceof HttpsURLConnection) {
                                            throw th;
                                        }
                                        httpURLConnection = (HttpsURLConnection) uRLConnection2;
                                    }
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStreamReader3 = inputStreamReader;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader = null;
                            Logger.d("HttpClientUtil", e.getMessage());
                            if (inputStream != null) {
                                inputStream.close();
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } else {
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            }
                            uRLConnection3 = this.f25868a;
                            if (uRLConnection3 != null) {
                                if (uRLConnection3 instanceof HttpURLConnection) {
                                    httpURLConnection2 = (HttpURLConnection) uRLConnection3;
                                } else if (uRLConnection3 instanceof HttpsURLConnection) {
                                    httpURLConnection2 = (HttpsURLConnection) uRLConnection3;
                                }
                                httpURLConnection2.disconnect();
                            }
                            return null;
                        } catch (Throwable th5) {
                            bufferedReader = null;
                            inputStreamReader3 = inputStreamReader;
                            th = th5;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        inputStreamReader = null;
                        bufferedReader = null;
                        Logger.d("HttpClientUtil", e.getMessage());
                        if (inputStream != null) {
                            inputStream.close();
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } else {
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                        uRLConnection3 = this.f25868a;
                        if (uRLConnection3 != null) {
                            if (uRLConnection3 instanceof HttpURLConnection) {
                                httpURLConnection2 = (HttpURLConnection) uRLConnection3;
                            } else if (uRLConnection3 instanceof HttpsURLConnection) {
                                httpURLConnection2 = (HttpsURLConnection) uRLConnection3;
                            }
                            httpURLConnection2.disconnect();
                        }
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedReader = null;
                    }
                } else {
                    inputStreamC = c();
                    try {
                        inputStreamReader2 = new InputStreamReader(inputStreamC);
                        try {
                            bufferedReader2 = new BufferedReader(inputStreamReader2);
                            try {
                                sb = new StringBuilder();
                                while (true) {
                                    line = bufferedReader2.readLine();
                                    if (line != null) {
                                        break;
                                    }
                                    sb.append(line);
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("StatusCode", iD);
                                jSONObject.put("ResponseStr", sb.toString());
                                String string2 = jSONObject.toString();
                                if (inputStreamC != null) {
                                    try {
                                        inputStreamC.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                inputStreamReader2.close();
                                bufferedReader2.close();
                                uRLConnection4 = this.f25868a;
                                if (uRLConnection4 != null) {
                                    if (uRLConnection4 instanceof HttpURLConnection) {
                                        httpURLConnection3 = (HttpURLConnection) uRLConnection4;
                                    } else if (uRLConnection4 instanceof HttpsURLConnection) {
                                        httpURLConnection3 = (HttpsURLConnection) uRLConnection4;
                                    }
                                    httpURLConnection3.disconnect();
                                }
                                return string2;
                            } catch (Exception e5) {
                                e = e5;
                                inputStream = inputStreamC;
                                inputStreamReader = inputStreamReader2;
                                bufferedReader = bufferedReader2;
                                Logger.d("HttpClientUtil", e.getMessage());
                                if (inputStream != null) {
                                    inputStream.close();
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                } else {
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                }
                                uRLConnection3 = this.f25868a;
                                if (uRLConnection3 != null) {
                                    if (uRLConnection3 instanceof HttpURLConnection) {
                                        httpURLConnection2 = (HttpURLConnection) uRLConnection3;
                                    } else if (uRLConnection3 instanceof HttpsURLConnection) {
                                        httpURLConnection2 = (HttpsURLConnection) uRLConnection3;
                                    }
                                    httpURLConnection2.disconnect();
                                }
                                return null;
                            } catch (Throwable th7) {
                                th2 = th7;
                                inputStream = inputStreamC;
                                th = th2;
                                inputStreamReader3 = inputStreamReader2;
                                bufferedReader = bufferedReader2;
                                if (inputStream != null) {
                                    inputStream.close();
                                    if (inputStreamReader3 != null) {
                                        inputStreamReader3.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                } else {
                                    if (inputStreamReader3 != null) {
                                        inputStreamReader3.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                }
                                uRLConnection2 = this.f25868a;
                                if (uRLConnection2 != null) {
                                    throw th;
                                }
                                if (!(uRLConnection2 instanceof HttpURLConnection)) {
                                    httpURLConnection = (HttpURLConnection) uRLConnection2;
                                } else {
                                    if (uRLConnection2 instanceof HttpsURLConnection) {
                                        throw th;
                                    }
                                    httpURLConnection = (HttpsURLConnection) uRLConnection2;
                                }
                                httpURLConnection.disconnect();
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            inputStream = inputStreamC;
                            inputStreamReader = inputStreamReader2;
                            bufferedReader = null;
                            Logger.d("HttpClientUtil", e.getMessage());
                            if (inputStream != null) {
                                inputStream.close();
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } else {
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            }
                            uRLConnection3 = this.f25868a;
                            if (uRLConnection3 != null) {
                                if (uRLConnection3 instanceof HttpURLConnection) {
                                    httpURLConnection2 = (HttpURLConnection) uRLConnection3;
                                } else if (uRLConnection3 instanceof HttpsURLConnection) {
                                    httpURLConnection2 = (HttpsURLConnection) uRLConnection3;
                                }
                                httpURLConnection2.disconnect();
                            }
                            return null;
                        } catch (Throwable th8) {
                            th = th8;
                            inputStream = inputStreamC;
                            bufferedReader = null;
                            inputStreamReader3 = inputStreamReader2;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        inputStream = inputStreamC;
                        inputStreamReader = null;
                        bufferedReader = null;
                        Logger.d("HttpClientUtil", e.getMessage());
                        if (inputStream != null) {
                            inputStream.close();
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } else {
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                        uRLConnection3 = this.f25868a;
                        if (uRLConnection3 != null) {
                            if (uRLConnection3 instanceof HttpURLConnection) {
                                httpURLConnection2 = (HttpURLConnection) uRLConnection3;
                            } else if (uRLConnection3 instanceof HttpsURLConnection) {
                                httpURLConnection2 = (HttpsURLConnection) uRLConnection3;
                            }
                            httpURLConnection2.disconnect();
                        }
                        return null;
                    } catch (Throwable th9) {
                        th = th9;
                        inputStream = inputStreamC;
                        bufferedReader = null;
                    }
                }
            } catch (Exception e8) {
                e = e8;
                inputStream = null;
            } catch (Throwable th10) {
                th = th10;
                inputStream = null;
            }
            if (inputStream != null) {
                inputStream.close();
                if (inputStreamReader3 != null) {
                    inputStreamReader3.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } else {
                if (inputStreamReader3 != null) {
                    inputStreamReader3.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            uRLConnection2 = this.f25868a;
            if (uRLConnection2 != null) {
                throw th;
            }
            if (!(uRLConnection2 instanceof HttpURLConnection)) {
                httpURLConnection = (HttpURLConnection) uRLConnection2;
            } else {
                if (uRLConnection2 instanceof HttpsURLConnection) {
                    throw th;
                }
                httpURLConnection = (HttpsURLConnection) uRLConnection2;
            }
            httpURLConnection.disconnect();
            throw th;
        }
        uRLConnectionA = b(this.b);
        this.f25868a = uRLConnectionA;
        uRLConnection = this.f25868a;
        if (uRLConnection == null) {
            return null;
        }
        str = this.c;
        if (str != null) {
            uRLConnection.setRequestProperty("Referer", str);
        }
        str2 = this.f;
        if (str2 != null) {
            this.f25868a.addRequestProperty("User-Agent", str2);
        }
        strArr = this.g;
        if (strArr != null) {
            while (i2 < r2) {
                if (str3 != null) {
                    strArrSplit = str3.split(u15.f19942b);
                    if (strArrSplit.length == 2) {
                        this.f25868a.addRequestProperty(strArrSplit[0], strArrSplit[1]);
                    }
                }
            }
        }
        iD = d();
        if (iD == 200) {
            inputStream = this.f25868a.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            sb2 = new StringBuilder();
            while (true) {
                line2 = bufferedReader.readLine();
                if (line2 != null) {
                    break;
                    break;
                }
                sb2.append(line2);
            }
            String string3 = sb2.toString();
            if (inputStream != null) {
                inputStream.close();
            }
            inputStreamReader.close();
            bufferedReader.close();
            uRLConnection5 = this.f25868a;
            if (uRLConnection5 != null) {
                if (uRLConnection5 instanceof HttpURLConnection) {
                    httpURLConnection4 = (HttpURLConnection) uRLConnection5;
                } else if (uRLConnection5 instanceof HttpsURLConnection) {
                    httpURLConnection4 = (HttpsURLConnection) uRLConnection5;
                }
                httpURLConnection4.disconnect();
            }
            return string3;
        }
        inputStreamC = c();
        inputStreamReader2 = new InputStreamReader(inputStreamC);
        bufferedReader2 = new BufferedReader(inputStreamReader2);
        sb = new StringBuilder();
        while (true) {
            line = bufferedReader2.readLine();
            if (line != null) {
                break;
                break;
            }
            sb.append(line);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("StatusCode", iD);
        jSONObject2.put("ResponseStr", sb.toString());
        String string4 = jSONObject2.toString();
        if (inputStreamC != null) {
            inputStreamC.close();
        }
        inputStreamReader2.close();
        bufferedReader2.close();
        uRLConnection4 = this.f25868a;
        if (uRLConnection4 != null) {
            if (uRLConnection4 instanceof HttpURLConnection) {
                httpURLConnection3 = (HttpURLConnection) uRLConnection4;
            } else if (uRLConnection4 instanceof HttpsURLConnection) {
                httpURLConnection3 = (HttpsURLConnection) uRLConnection4;
            }
            httpURLConnection3.disconnect();
        }
        return string4;
        if (inputStream != null) {
            inputStream.close();
            if (inputStreamReader3 != null) {
                inputStreamReader3.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } else {
            if (inputStreamReader3 != null) {
                inputStreamReader3.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        uRLConnection2 = this.f25868a;
        if (uRLConnection2 != null) {
            throw th;
        }
        if (!(uRLConnection2 instanceof HttpURLConnection)) {
            httpURLConnection = (HttpURLConnection) uRLConnection2;
        } else {
            if (uRLConnection2 instanceof HttpsURLConnection) {
                throw th;
            }
            httpURLConnection = (HttpsURLConnection) uRLConnection2;
        }
        httpURLConnection.disconnect();
        throw th;
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e() {
        Logger.d(h, "HttpClientHelper stop().... urlConnection = " + this.f25868a);
        if (this.f25868a != null) {
            i.execute(new a());
        }
    }

    public void e(String str) {
        this.f = str;
    }
}
