package com.kc.aw;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _eh {
    public final AtomicInteger _a = new AtomicInteger(0);
    public final String _b;
    public volatile _ef _c;
    public final _a _d;
    public final _bo _e;

    @Keep
    public static final class _a extends Handler implements _b0 {
        public final List<_b0> _a;

        public _a(String str, CopyOnWriteArrayList copyOnWriteArrayList) {
            super(Looper.getMainLooper());
            this._a = copyOnWriteArrayList;
        }

        @Override // com.kc.aw._b0
        public final void _a(File file, int i) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<_b0> it = this._a.iterator();
            while (it.hasNext()) {
                it.next()._a((File) message.obj, message.arg1);
            }
        }
    }

    public _eh(String str, _bo _boVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this._b = (String) _hp._a(str);
        this._e = (_bo) _hp._a(_boVar);
        this._d = new _a(str, copyOnWriteArrayList);
    }

    public final void _a(_dx _dxVar, Socket socket) {
        _ef _efVar;
        synchronized (this) {
            if (this._c == null) {
                String str = this._b;
                _bo _boVar = this._e;
                _ei _eiVar = new _ei(str, _boVar._d, _boVar._e);
                _bo _boVar2 = this._e;
                String str2 = this._b;
                _boVar2._b.getClass();
                _efVar = new _ef(_eiVar, new _dr(new File(_boVar2._a, _g0._a(str2)), this._e._c));
                _efVar._k = this._d;
            } else {
                _efVar = this._c;
            }
            this._c = _efVar;
        }
        try {
            this._a.incrementAndGet();
            this._c._a(_dxVar, socket);
            synchronized (this) {
                if (this._a.decrementAndGet() <= 0) {
                    _ef _efVar2 = this._c;
                    synchronized (_efVar2._d) {
                        Objects.toString(_efVar2._a);
                        try {
                            _efVar2._g = true;
                            if (_efVar2._f != null) {
                                _efVar2._f.interrupt();
                            }
                            _efVar2._b.close();
                        } catch (_hs e) {
                            boolean z = e instanceof _fl;
                        }
                    }
                    this._c = null;
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                if (this._a.decrementAndGet() <= 0) {
                    _ef _efVar3 = this._c;
                    synchronized (_efVar3._d) {
                        Objects.toString(_efVar3._a);
                        try {
                            _efVar3._g = true;
                            if (_efVar3._f != null) {
                                _efVar3._f.interrupt();
                            }
                            _efVar3._b.close();
                        } catch (_hs e2) {
                            boolean z2 = e2 instanceof _fl;
                        }
                        this._c = null;
                    }
                }
                throw th;
            }
        }
    }
}
