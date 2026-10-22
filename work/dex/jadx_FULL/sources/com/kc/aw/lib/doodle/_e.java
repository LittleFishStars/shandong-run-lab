package com.kc.aw.lib.doodle;

import com.kc.aw._az;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e extends _d._c {
    public final _az _c;
    public final _d._b _d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _e(_d._b _bVar, FutureTask futureTask, boolean z, _az _azVar) {
        super(futureTask, z);
        this._d = _bVar;
        this._c = _azVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this._a.run();
            _d._b _bVar = this._d;
            _az _azVar = this._c;
            synchronized (_bVar) {
                HashSet hashSet = _d._b._a;
                hashSet.remove(_azVar);
                HashMap map = _d._b._b;
                LinkedList linkedList = (LinkedList) map.get(_azVar);
                if (linkedList != null) {
                    _d._c _cVar = (_d._c) linkedList.poll();
                    if (_cVar == null) {
                        map.remove(_azVar);
                    } else {
                        hashSet.add(_azVar);
                        (_cVar._b ? _d._b : _d._a).execute(_cVar);
                    }
                }
            }
        } catch (Throwable th) {
            _d._b _bVar2 = this._d;
            _az _azVar2 = this._c;
            synchronized (_bVar2) {
                HashSet hashSet2 = _d._b._a;
                hashSet2.remove(_azVar2);
                HashMap map2 = _d._b._b;
                LinkedList linkedList2 = (LinkedList) map2.get(_azVar2);
                if (linkedList2 != null) {
                    _d._c _cVar2 = (_d._c) linkedList2.poll();
                    if (_cVar2 != null) {
                        hashSet2.add(_azVar2);
                        (_cVar2._b ? _d._b : _d._a).execute(_cVar2);
                    } else {
                        map2.remove(_azVar2);
                    }
                }
                throw th;
            }
        }
    }
}
