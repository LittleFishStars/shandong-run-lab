package com.kc.aw;

import android.text.TextUtils;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _gb implements _hn {
    public _hn[] _a;

    @Keep
    public final class _a implements _ho {
        public final AtomicInteger _a;
        public final List _b;
        public final _ho _c;
        public final _gb _d;

        public _a(_gb _gbVar, AtomicInteger atomicInteger, ArrayList arrayList, _ho _hoVar) {
            this._d = _gbVar;
            this._a = atomicInteger;
            this._b = arrayList;
            this._c = _hoVar;
        }

        @Override // com.kc.aw._ho
        public final void _a(_cj _cjVar, _cn _cnVar) {
            int iDecrementAndGet = this._a.decrementAndGet();
            if (_cnVar != null) {
                this._b.add(new _b(_cjVar, _cnVar));
            }
            if (iDecrementAndGet == 0) {
                _b _bVar_a = _gb._a(this._d, this._b);
                if (_bVar_a == null) {
                    Logger.d("Complete policy filtering, not find Policy");
                    _ho _hoVar = this._c;
                    if (_hoVar != null) {
                        _hoVar._c("MultiplePolicyLoader 未发现合适的 Policy");
                        return;
                    }
                    return;
                }
                _cn _cnVar2 = _bVar_a._b;
                Logger.d("Complete policy filtering, find policy " + (_cnVar2 == null ? "null" : _cnVar2._f));
                _ho _hoVar2 = this._c;
                if (_hoVar2 != null) {
                    _hoVar2._a(_bVar_a._a, _bVar_a._b);
                }
            }
        }

        @Override // com.kc.aw._ho
        public final void _a(String str) {
            _b _bVar_a;
            _cn _cnVar;
            if (this._a.get() != 0 || this._c == null || (_bVar_a = _gb._a(this._d, this._b)) == null || (_cnVar = _bVar_a._b) == null || TextUtils.isEmpty(_cnVar._a)) {
                return;
            }
            this._c._a(_bVar_a._b._a);
        }

        @Override // com.kc.aw._ho
        public final void _b(String str) {
            _b _bVar_a;
            _cj _cjVar;
            if (this._a.get() != 0 || this._c == null || (_bVar_a = _gb._a(this._d, this._b)) == null || (_cjVar = _bVar_a._a) == null || TextUtils.isEmpty(_cjVar._f)) {
                return;
            }
            this._c._b(_bVar_a._a._f);
        }

        @Override // com.kc.aw._ho
        public final void _c(String str) {
            int iDecrementAndGet = this._a.decrementAndGet();
            Logger.e("Policy filtering error " + str);
            if (iDecrementAndGet == 0) {
                _b _bVar_a = _gb._a(this._d, this._b);
                if (_bVar_a == null) {
                    Logger.d("Complete policy filtering, not find Policy");
                    _ho _hoVar = this._c;
                    if (_hoVar != null) {
                        _hoVar._c("Complete policy filtering, not find Policy");
                        return;
                    }
                    return;
                }
                _cn _cnVar = _bVar_a._b;
                Logger.d("Complete policy filtering, find policy " + (_cnVar == null ? "null" : _cnVar._f));
                _ho _hoVar2 = this._c;
                if (_hoVar2 != null) {
                    _hoVar2._a(_bVar_a._a, _bVar_a._b);
                }
            }
        }
    }

    @Keep
    public static final class _b {
        public final _cj _a;
        public final _cn _b;

        public _b(_cj _cjVar, _cn _cnVar) {
            this._a = _cjVar;
            this._b = _cnVar;
        }
    }

    public _gb(_hn... _hnVarArr) {
        this._a = _hnVarArr;
    }

    public static _b _a(_gb _gbVar, List list) {
        _gbVar.getClass();
        Iterator it = list.iterator();
        _b _bVar = null;
        long j = -1;
        while (it.hasNext()) {
            _b _bVar2 = (_b) it.next();
            String str = _bVar2._b._f;
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                long jLongValue = Long.valueOf(str).longValue();
                if (jLongValue > j) {
                    _bVar = _bVar2;
                    j = jLongValue;
                } else {
                    Logger.d("Scrapped policy version " + str);
                }
            }
        }
        Logger.i("Apply policy version " + j);
        return _bVar;
    }

    @Override // com.kc.aw._hn
    public final void _a(_ho _hoVar) {
        _b(_hoVar);
    }

    @Override // com.kc.aw._hn
    public final void _b(_ho _hoVar) {
        AtomicInteger atomicInteger = new AtomicInteger(this._a.length);
        ArrayList arrayList = new ArrayList();
        for (_hn _hnVar : this._a) {
            _hnVar._a(new _a(this, atomicInteger, arrayList, _hoVar));
        }
    }
}
