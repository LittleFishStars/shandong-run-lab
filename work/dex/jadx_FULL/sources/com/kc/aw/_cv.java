package com.kc.aw;

import android.os.Handler;
import com.ipd.dsp.internal.g0.c;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cv implements Runnable {
    public final String _a;
    public final AtomicBoolean _b;
    public final Handler _c;
    public final Runnable _d;
    public final _cw._a _e;
    public final _cw _f;

    public _cv(_cw _cwVar, String str, AtomicBoolean atomicBoolean, Handler handler, _cu _cuVar, _d6 _d6Var) {
        this._f = _cwVar;
        this._a = str;
        this._b = atomicBoolean;
        this._c = handler;
        this._d = _cuVar;
        this._e = _d6Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        _cw._a _aVar;
        int i;
        _cw _cwVar;
        if (this._f._a.matcher(this._a).matches()) {
            Logger.d("PTG_QM_TAG cut-1");
            if (this._b.getAndSet(true)) {
                return;
            }
            this._c.removeCallbacks(this._d);
            _cw._a(this._f, this._e, 2, -1, "");
            return;
        }
        Logger.d("PTG_QM_TAG cut-2");
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(this._a).openConnection();
                try {
                    httpURLConnection.setRequestMethod(c.f38307a);
                    httpURLConnection.setConnectTimeout(2500);
                    httpURLConnection.setReadTimeout(2500);
                    httpURLConnection.connect();
                    String contentType = httpURLConnection.getContentType();
                    String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                    long j_a = _cw._a(httpURLConnection);
                    if (!this._b.get()) {
                        if (!_cw._a(contentType, headerField)) {
                            if (_cw._a(j_a, contentType, headerField)) {
                                Logger.d("PTG_QM_TAG cut-4");
                                this._c.removeCallbacks(this._d);
                                this._b.set(true);
                                _cw _cwVar2 = this._f;
                                _aVar = this._e;
                                i = 2;
                                _cwVar = _cwVar2;
                            }
                            httpURLConnection.disconnect();
                        }
                        Logger.d("PTG_QM_TAG cut-3");
                        this._c.removeCallbacks(this._d);
                        this._b.set(true);
                        _cwVar = this._f;
                        _aVar = this._e;
                        i = 1;
                        _cw._a(_cwVar, _aVar, i, -1, "");
                    }
                    Logger.d("PTG_QM_TAG cut-5");
                    if (!this._b.getAndSet(true)) {
                        this._c.removeCallbacks(this._d);
                        _cw._a(this._f, this._e, 0, PtgErrorCode.SDK_RESOURCE_ERROR, PtgErrorCode.SDK_RESOURCE_ERR_MSG2);
                    }
                } catch (Exception e) {
                    e = e;
                    httpURLConnection2 = httpURLConnection;
                    Logger.d("PTG_QM_TAG cut-6");
                    if (!this._b.getAndSet(true)) {
                        this._c.removeCallbacks(this._d);
                        _cw._a(this._f, this._e, 0, PtgErrorCode.SDK_RESOURCE_ERROR, e.getMessage());
                    }
                    if (httpURLConnection2 == null) {
                        return;
                    } else {
                        httpURLConnection = httpURLConnection2;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
            }
        } catch (Exception e2) {
            e = e2;
        }
        httpURLConnection.disconnect();
    }
}
