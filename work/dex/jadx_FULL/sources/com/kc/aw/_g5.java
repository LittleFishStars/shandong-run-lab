package com.kc.aw;

import android.graphics.Bitmap;
import android.support.v4.media.session.PlaybackStateCompat;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.Reference;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _g5 {
    public static final long _a = Runtime.getRuntime().maxMemory();
    public static final AtomicBoolean _b = new AtomicBoolean(false);
    public static final _oa _c = new _oa();
    public static final _oa _d = new _oa();

    public static Bitmap _a(_az _azVar) {
        Bitmap bitmap;
        Object obj;
        synchronized (_fv.class) {
            try {
                _fv._a _aVar = (_fv._a) _fv._c.get(_azVar);
                bitmap = _aVar != null ? _aVar._a : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bitmap != null) {
            return bitmap;
        }
        _oa _oaVar = _c;
        synchronized (_oaVar) {
            Reference<? extends Object> referencePoll = _oaVar._b.poll();
            while (true) {
                _oa._a _aVar2 = (_oa._a) referencePoll;
                if (_aVar2 == null) {
                    break;
                }
                _oa._a _aVar3 = (_oa._a) _oaVar._a.get(_aVar2._a);
                if (_aVar3 != null && _aVar3.get() == null) {
                    _oaVar._a.remove(_aVar2._a);
                }
                referencePoll = _oaVar._b.poll();
            }
            _oa._a _aVar4 = (_oa._a) _oaVar._a.get(_azVar);
            obj = _aVar4 != null ? _aVar4.get() : null;
        }
        return (Bitmap) obj;
    }

    public static void _a() {
        AtomicBoolean atomicBoolean = _b;
        if (atomicBoolean.compareAndSet(false, true)) {
            Runtime runtime = Runtime.getRuntime();
            long jFreeMemory = runtime.freeMemory() + (_a - runtime.totalMemory());
            if (jFreeMemory < PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED) {
                synchronized (_fv.class) {
                    try {
                        _fv._a(0L);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                atomicBoolean.set(false);
            }
            if (jFreeMemory < 10485760) {
                synchronized (_fv.class) {
                    try {
                        _fv._a(Math.max(_fv._b >> 1, _fv._a));
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            atomicBoolean.set(false);
            atomicBoolean.set(false);
        }
    }

    public static void _a(_az _azVar, Bitmap bitmap, boolean z) {
        _oa._a _aVar;
        if (!z) {
            synchronized (_fv.class) {
                try {
                    LinkedHashMap linkedHashMap = _fv._c;
                    long j = _bn._c;
                    if (bitmap != null && j > 0 && !linkedHashMap.containsKey(_azVar)) {
                        _fv._a _aVar2 = new _fv._a(bitmap);
                        linkedHashMap.put(_azVar, _aVar2);
                        long j2 = _fv._b + ((long) _aVar2._b);
                        _fv._b = j2;
                        if (j2 > j) {
                            _fv._a((j * 9) / 10);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        _oa _oaVar = _c;
        synchronized (_oaVar) {
            Reference<? extends Object> referencePoll = _oaVar._b.poll();
            while (true) {
                _oa._a _aVar3 = (_oa._a) referencePoll;
                if (_aVar3 == null) {
                    break;
                }
                _oa._a _aVar4 = (_oa._a) _oaVar._a.get(_aVar3._a);
                if (_aVar4 != null && _aVar4.get() == null) {
                    _oaVar._a.remove(_aVar3._a);
                }
                referencePoll = _oaVar._b.poll();
            }
            if (bitmap != null && ((_aVar = (_oa._a) _oaVar._a.get(_azVar)) == null || _aVar.get() != bitmap)) {
                _oaVar._a.put(_azVar, new _oa._a(_azVar, bitmap, _oaVar._b));
            }
        }
    }
}
