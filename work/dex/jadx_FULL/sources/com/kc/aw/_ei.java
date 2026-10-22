package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ei implements _ml {
    public final _mo _a;
    public final _e6 _b;
    public _mn _c;
    public HttpURLConnection _d;
    public BufferedInputStream _e;

    public _ei(_ei _eiVar) {
        this._c = _eiVar._c;
        this._a = _eiVar._a;
        this._b = _eiVar._b;
    }

    public _ei(String str, _mo _moVar, _e6 _e6Var) {
        this._a = (_mo) _hp._a(_moVar);
        this._b = (_e6) _hp._a(_e6Var);
        _mn _mnVar_a = _moVar._a(str);
        this._c = _mnVar_a == null ? new _mn(-2147483648L, str, _ht._b(str)) : _mnVar_a;
    }

    public final HttpURLConnection _a(long j, int i) throws _hs, IOException {
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this._c._a;
        int i2 = 0;
        do {
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            for (Map.Entry entry : this._b._a().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + c49.f40900a);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new _hs("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:? A[SYNTHETIC] */
    public final void _a() throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Throwable th;
        HttpURLConnection httpURLConnection_a;
        String str = this._c._a;
        InputStream inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection_a = _a(0L, 10000);
            try {
                String headerField = httpURLConnection_a.getHeaderField("Content-Length");
                long j = headerField == null ? -1L : Long.parseLong(headerField);
                String contentType = httpURLConnection_a.getContentType();
                inputStream2 = httpURLConnection_a.getInputStream();
                String str2 = this._c._a;
                _mn _mnVar = new _mn(j, str2, contentType);
                this._c = _mnVar;
                this._a._a(str2, _mnVar);
                Objects.toString(this._c);
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
                InputStream inputStream3 = inputStream2;
                httpURLConnection2 = httpURLConnection_a;
                inputStream = inputStream3;
                try {
                    String str3 = this._c._a;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (httpURLConnection2 == null) {
                        return;
                    } else {
                        httpURLConnection_a = httpURLConnection2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    inputStream2 = inputStream;
                    httpURLConnection_a = httpURLConnection3;
                    Throwable th3 = th;
                    httpURLConnection = httpURLConnection_a;
                    th = th3;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (httpURLConnection == null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                Throwable th5 = th;
                httpURLConnection = httpURLConnection_a;
                th = th5;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (httpURLConnection == null) {
                throw th;
            }
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection_a.disconnect();
    }

    @Override // com.kc.aw._ml
    public final void _a(long j) throws _hs {
        try {
            HttpURLConnection httpURLConnection_a = _a(j, -1);
            this._d = httpURLConnection_a;
            String contentType = httpURLConnection_a.getContentType();
            this._e = new BufferedInputStream(this._d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this._d;
            int responseCode = httpURLConnection.getResponseCode();
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            long j2 = headerField == null ? -1L : Long.parseLong(headerField);
            if (responseCode != 200) {
                j2 = responseCode == 206 ? j2 + j : this._c._b;
            }
            String str = this._c._a;
            _mn _mnVar = new _mn(j2, str, contentType);
            this._c = _mnVar;
            this._a._a(str, _mnVar);
        } catch (IOException e) {
            StringBuilder sb_a = _jf._a("Error opening connection for ");
            sb_a.append(this._c._a);
            sb_a.append(" with offset ");
            sb_a.append(j);
            throw new _hs(sb_a.toString(), e);
        }
    }

    @Override // com.kc.aw._ml
    public final void close() {
        HttpURLConnection httpURLConnection = this._d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
            } catch (IllegalArgumentException e) {
                e = e;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kc.aw._ml
    public final long length() {
        long j;
        synchronized (this) {
            if (this._c._b == -2147483648L) {
                _a();
            }
            j = this._c._b;
        }
        return j;
    }

    @Override // com.kc.aw._ml
    public final int read(byte[] bArr) throws _hs {
        BufferedInputStream bufferedInputStream = this._e;
        if (bufferedInputStream == null) {
            StringBuilder sb_a = _jf._a("Error reading data from ");
            sb_a.append(this._c._a);
            sb_a.append(": connection is absent!");
            throw new _hs(sb_a.toString());
        }
        try {
            return bufferedInputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            StringBuilder sb_a2 = _jf._a("Reading source ");
            sb_a2.append(this._c._a);
            sb_a2.append(" is interrupted");
            throw new _fl(sb_a2.toString(), e);
        } catch (IOException e2) {
            StringBuilder sb_a3 = _jf._a("Error reading data from ");
            sb_a3.append(this._c._a);
            throw new _hs(sb_a3.toString(), e2);
        }
    }

    public final String toString() {
        StringBuilder sb_a = _jf._a("HttpUrlSource{sourceInfo='");
        sb_a.append(this._c);
        sb_a.append("}");
        return sb_a.toString();
    }
}
