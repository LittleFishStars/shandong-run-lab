package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _hr {
    public final _ml _a;
    public final _ay _b;
    public volatile Thread _f;
    public volatile boolean _g;
    public final Object _c = new Object();
    public final Object _d = new Object();
    public volatile int _h = -1;
    public final AtomicInteger _e = new AtomicInteger();

    @Keep
    public final class _a implements Runnable {
        public final _hr _a;

        public _a(_ef _efVar) {
            this._a = _efVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
        
            r3 = r3 + ((long) r6);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            byte[] bArr;
            _hr _hrVar = this._a;
            _hrVar.getClass();
            long length = -1;
            long jAvailable = 0;
            try {
                jAvailable = _hrVar._b.available();
                _hrVar._a._a(jAvailable);
                length = _hrVar._a.length();
                bArr = new byte[8192];
            } catch (Throwable th) {
                try {
                    _hrVar._e.incrementAndGet();
                    boolean z = th instanceof _fl;
                } finally {
                    try {
                        _hrVar._a.close();
                    } catch (_hs e) {
                        StringBuilder sb_a = _jf._a("Error closing source ");
                        sb_a.append(_hrVar._a);
                        new _hs(sb_a.toString(), e);
                    }
                    _hrVar._a(jAvailable, length);
                }
            }
            try {
                while (true) {
                    int i = _hrVar._a.read(bArr);
                    boolean z2 = true;
                    if (i == -1) {
                        synchronized (_hrVar._d) {
                            if (!Thread.currentThread().isInterrupted() && !_hrVar._g) {
                                z2 = false;
                            }
                            if (!z2 && _hrVar._b.available() == _hrVar._a.length()) {
                                _hrVar._b._b();
                            }
                        }
                        _hrVar._h = 100;
                        int i2 = _hrVar._h;
                        _ef _efVar = (_ef) _hrVar;
                        _b0 _b0Var = _efVar._k;
                        if (_b0Var == null) {
                            break;
                        }
                        File file = _efVar._j._b;
                        String str = _efVar._i._c._a;
                        _b0Var._a(file, i2);
                        break;
                    }
                    synchronized (_hrVar._d) {
                        if (!Thread.currentThread().isInterrupted() && !_hrVar._g) {
                            z2 = false;
                        }
                        if (!z2) {
                            _hrVar._b._a(i, bArr);
                        }
                    }
                    try {
                        _hrVar._a.close();
                    } catch (_hs e2) {
                        StringBuilder sb_a2 = _jf._a("Error closing source ");
                        sb_a2.append(_hrVar._a);
                        new _hs(sb_a2.toString(), e2);
                    }
                    _hrVar._e.incrementAndGet();
                    boolean z3 = th instanceof _fl;
                    _hrVar._a(jAvailable, length);
                }
            } catch (_hs e3) {
            }
        }
    }

    public _hr(_ml _mlVar, _ay _ayVar) {
        this._a = (_ml) _hp._a(_mlVar);
        this._b = (_ay) _hp._a(_ayVar);
    }

    public final void _a(long j, long j2) {
        _ef _efVar;
        _b0 _b0Var;
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this._h;
        if ((j2 >= 0) && z && (_b0Var = (_efVar = (_ef) this)._k) != null) {
            File file = _efVar._j._b;
            String str = _efVar._i._c._a;
            _b0Var._a(file, i);
        }
        this._h = i;
        synchronized (this._c) {
            this._c.notifyAll();
        }
    }
}
