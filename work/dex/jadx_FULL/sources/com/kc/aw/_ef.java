package com.kc.aw;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ef extends _hr {
    public final _ei _i;
    public final _dr _j;
    public _b0 _k;

    public _ef(_ei _eiVar, _dr _drVar) {
        super(_eiVar, _drVar);
        this._j = _drVar;
        this._i = _eiVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01ab */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void _a(_dx _dxVar, Socket socket) throws _hs, IOException {
        String str;
        String str2;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        _ei _eiVar = this._i;
        synchronized (_eiVar) {
            if (TextUtils.isEmpty(_eiVar._c._c)) {
                _eiVar._a();
            }
            str = _eiVar._c._c;
        }
        boolean zIsEmpty = TextUtils.isEmpty(str);
        long jAvailable = this._j._a() ? this._j.available() : this._i.length();
        boolean z = jAvailable >= 0;
        boolean z2 = _dxVar._c;
        long j = z2 ? jAvailable - _dxVar._b : jAvailable;
        boolean z3 = z && z2;
        StringBuilder sb = new StringBuilder();
        sb.append(_dxVar._c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z ? String.format(Locale.US, "Content-Length: %d\n", Long.valueOf(j)) : "");
        if (z3) {
            str2 = String.format(Locale.US, "Content-Range: bytes %d-%d/%d\n", Long.valueOf(_dxVar._b), Long.valueOf(jAvailable - 1), Long.valueOf(jAvailable));
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append(zIsEmpty ^ true ? String.format(Locale.US, "Content-Type: %s\n", str) : "");
        sb.append("\n");
        bufferedOutputStream.write(sb.toString().getBytes("UTF-8"));
        long j2 = _dxVar._b;
        long length = this._i.length();
        if ((((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && _dxVar._c && ((float) _dxVar._b) > (((float) length) * 0.2f) + ((float) this._j.available())) ? false : true) {
            byte[] bArr = new byte[8192];
            while (true) {
                if (!(j2 >= 0)) {
                    throw new IllegalArgumentException("Data offset must be positive!");
                }
                while (!this._b._a() && this._b.available() < ((long) 8192) + j2 && !this._g) {
                    synchronized (this) {
                        boolean z4 = (this._f == null || this._f.getState() == Thread.State.TERMINATED) ? false : true;
                        if (!this._g && !this._b._a() && !z4) {
                            this._f = new Thread(new _hr._a(this), "Source reader for " + this._a);
                            this._f.start();
                        }
                    }
                    synchronized (this._c) {
                        try {
                            this._c.wait(1000L);
                        } catch (InterruptedException e) {
                            throw new _hs("Waiting source data is interrupted!", e);
                        }
                    }
                    int i = this._e.get();
                    if (i >= 1) {
                        this._e.set(0);
                        throw new _hs("Error reading source " + i + " times");
                    }
                }
                int i_a = this._b._a(bArr, j2);
                if (this._b._a() && this._h != 100) {
                    this._h = 100;
                    _b0 _b0Var = this._k;
                    if (_b0Var != null) {
                        File file = this._j._b;
                        String str3 = this._i._c._a;
                        _b0Var._a(file, 100);
                    }
                }
                if (i_a == -1) {
                    bufferedOutputStream.flush();
                    return;
                } else {
                    bufferedOutputStream.write(bArr, 0, i_a);
                    j2 += (long) i_a;
                }
            }
        } else {
            _ei _eiVar2 = new _ei(this._i);
            try {
                _eiVar2._a((int) j2);
                byte[] bArr2 = new byte[8192];
                while (true) {
                    int i2 = _eiVar2.read(bArr2);
                    if (i2 == -1) {
                        bufferedOutputStream.flush();
                        return;
                    }
                    bufferedOutputStream.write(bArr2, 0, i2);
                }
            } finally {
                _eiVar2.close();
            }
        }
    }
}
