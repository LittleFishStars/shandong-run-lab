package com.kc.cw.ad.internal.c;

import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f38942a;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.c.d$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f38943a;

        public AnonymousClass1(d dVar) {
            this.f38943a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader;
            InputStream inputStream;
            StringBuilder sb;
            e eVar = new e();
            HttpURLConnection httpURLConnection = null;
            bufferedReader = null;
            bufferedReader = null;
            bufferedReader = null;
            bufferedReader = null;
            BufferedReader bufferedReader2 = null;
            httpURLConnection = null;
            httpURLConnection = null;
            try {
                try {
                    URL url = new URL(this.f38943a.a());
                    if (url.getHost() == null) {
                        eVar.a(false);
                        try {
                            ThreadUtils.runOnUIThread(new Runnable(this, eVar) { // from class: com.kc.cw.ad.internal.c.d.1.1

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                final e f38944a;
                                final AnonymousClass1 b;

                                {
                                    this.b = this;
                                    this.f38944a = eVar;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    this.b.f38943a.a(this.f38944a);
                                }
                            });
                            return;
                        } catch (Exception e) {
                            com.kc.cw.ad.d.b.f.c("OctopusAd", "Catch An Exception: " + e.getMessage());
                            return;
                        }
                    }
                    HttpURLConnection httpURLConnectionA = this.f38943a.a(url);
                    try {
                        this.f38943a.a(httpURLConnectionA);
                        httpURLConnectionA.connect();
                        int responseCode = httpURLConnectionA.getResponseCode();
                        eVar.a(responseCode);
                        com.kc.cw.ad.d.b.f.a("HTTPGet", "HTTPGet code:" + responseCode);
                        if (this.f38943a.f38942a) {
                            inputStream = httpURLConnectionA.getInputStream();
                            try {
                                StringBuilder sb2 = new StringBuilder();
                                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
                                while (true) {
                                    try {
                                        String line = bufferedReader3.readLine();
                                        if (line == null) {
                                            break;
                                        } else {
                                            sb2.append(line);
                                        }
                                    } catch (Exception unused) {
                                        bufferedReader2 = bufferedReader3;
                                        bufferedReader = bufferedReader2;
                                        httpURLConnection = httpURLConnectionA;
                                        eVar.a(false);
                                        eVar.a(i.TRANSPORT_ERROR);
                                        try {
                                            ThreadUtils.runOnUIThread(new Runnable(this, eVar) { // from class: com.kc.cw.ad.internal.c.d.1.1

                                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                                final e f38944a;
                                                final AnonymousClass1 b;

                                                {
                                                    this.b = this;
                                                    this.f38944a = eVar;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    this.b.f38943a.a(this.f38944a);
                                                }
                                            });
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            return;
                                        } catch (Exception e2) {
                                            e = e2;
                                            sb = new StringBuilder();
                                        }
                                    } catch (Throwable unused2) {
                                        bufferedReader2 = bufferedReader3;
                                        bufferedReader = bufferedReader2;
                                        httpURLConnection = httpURLConnectionA;
                                        eVar.a(false);
                                        eVar.a(i.TRANSPORT_ERROR);
                                        try {
                                            ThreadUtils.runOnUIThread(new Runnable(this, eVar) { // from class: com.kc.cw.ad.internal.c.d.1.1

                                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                                final e f38944a;
                                                final AnonymousClass1 b;

                                                {
                                                    this.b = this;
                                                    this.f38944a = eVar;
                                                }

                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    this.b.f38943a.a(this.f38944a);
                                                }
                                            });
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            return;
                                        } catch (Exception e3) {
                                            e = e3;
                                            sb = new StringBuilder();
                                        }
                                    }
                                    sb.append("Catch An Exception: ");
                                    sb.append(e.getMessage());
                                    com.kc.cw.ad.d.b.f.c("OctopusAd", sb.toString());
                                    return;
                                }
                                eVar.a(sb2.toString());
                                bufferedReader2 = bufferedReader3;
                            } catch (Exception unused3) {
                            } catch (Throwable unused4) {
                            }
                        } else {
                            eVar.a("");
                            inputStream = null;
                        }
                        eVar.a(httpURLConnectionA.getHeaderFields());
                        eVar.a(httpURLConnectionA.getResponseCode() >= 200 && httpURLConnectionA.getResponseCode() < 400);
                        try {
                            ThreadUtils.runOnUIThread(new Runnable(this, eVar) { // from class: com.kc.cw.ad.internal.c.d.1.1

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                final e f38944a;
                                final AnonymousClass1 b;

                                {
                                    this.b = this;
                                    this.f38944a = eVar;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    this.b.f38943a.a(this.f38944a);
                                }
                            });
                            httpURLConnectionA.disconnect();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            sb = new StringBuilder();
                        }
                    } catch (Exception unused5) {
                        inputStream = null;
                    } catch (Throwable unused6) {
                        inputStream = null;
                    }
                } catch (Throwable th) {
                    try {
                        ThreadUtils.runOnUIThread(new Runnable(this, eVar) { // from class: com.kc.cw.ad.internal.c.d.1.1

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final e f38944a;
                            final AnonymousClass1 b;

                            {
                                this.b = this;
                                this.f38944a = eVar;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                this.b.f38943a.a(this.f38944a);
                            }
                        });
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Exception e5) {
                        com.kc.cw.ad.d.b.f.c("OctopusAd", "Catch An Exception: " + e5.getMessage());
                    }
                    throw th;
                }
            } catch (Exception unused7) {
                bufferedReader = null;
                inputStream = null;
            } catch (Throwable unused8) {
                bufferedReader = null;
                inputStream = null;
            }
        }
    }

    @Keep
    public interface a {
        void a(int i, boolean z, String str);
    }

    public d(boolean z) {
        this.f38942a = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setRequestProperty("User-Agent", com.kc.cw.ad.internal.q.a().m());
    }

    public abstract String a();

    public abstract void a(e eVar);

    public void b() {
        ThreadUtils.runOnThreadPool(new AnonymousClass1(this));
    }
}
