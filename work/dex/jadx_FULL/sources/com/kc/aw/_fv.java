package com.kc.aw;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fv {
    public static final long _a = Runtime.getRuntime().maxMemory() / 64;
    public static long _b = 0;
    public static final LinkedHashMap _c = new LinkedHashMap(16, 0.75f, true);

    @Keep
    public static final class _a {
        public final Bitmap _a;
        public final int _b;

        public _a(Bitmap bitmap) {
            this._a = bitmap;
            this._b = _o2._a(bitmap);
        }
    }

    public static void _a(long j) {
        _oa._a _aVar;
        Iterator it = _c.entrySet().iterator();
        while (it.hasNext() && _b > j) {
            Map.Entry entry = (Map.Entry) it.next();
            _a _aVar2 = (_a) entry.getValue();
            _oa _oaVar = _g5._c;
            _az _azVar = (_az) entry.getKey();
            Bitmap bitmap = _aVar2._a;
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
            it.remove();
            _b -= (long) _aVar2._b;
        }
    }
}
