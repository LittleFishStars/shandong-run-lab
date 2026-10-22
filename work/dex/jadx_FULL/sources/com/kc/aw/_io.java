package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _io implements View.OnTouchListener {
    public final Context _a;
    public final _in _b;

    @Keep
    public final class _a implements Runnable {
        public final View _a;
        public final _io _b;

        public _a(_io _ioVar, View view) {
            this._b = _ioVar;
            this._a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _in._b _bVar = this._b._b._n;
            if (_bVar != null) {
                _bVar._a(this._a, 2, null);
            }
        }
    }

    public _io(_in _inVar, Activity activity) {
        this._b = _inVar;
        this._a = activity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        _nl _nlVar;
        if (this._a != null) {
            _in _inVar = this._b;
            if (_ib._a(_inVar._b) && _inVar._i && !_inVar._p.get() && _inVar._l) {
                this._b.getClass();
                if ((_o6._a(view) != 6) && motionEvent.getAction() == 0) {
                    this._b._p.set(true);
                    if (view != null) {
                        _in _inVar2 = this._b;
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        View view2 = _inVar2._c;
                        int i = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                        if (view2 != null) {
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            _nlVar = new _nl(rawX - iArr[0], rawY - iArr[1], System.currentTimeMillis());
                        } else {
                            _nlVar = new _nl(AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE, AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE, 0L);
                        }
                        this._b.getClass();
                        long jNextInt = com.kc.aw.lib.utils._a._b.nextInt(31) + 50;
                        int i2 = _nlVar._g;
                        if (i2 <= 0 && (i2 = _nlVar._a) == 0) {
                            i2 = -999;
                        }
                        _nlVar._d = i2;
                        int i3 = _nlVar._h;
                        if (i3 > 0 || (i3 = _nlVar._b) != 0) {
                            i = i3;
                        }
                        _nlVar._e = i;
                        _nlVar._f = _nlVar._c + jNextInt;
                        view.setTag(R.id.aw_native_view_tag, _nlVar);
                        view.postDelayed(new _a(this, view), jNextInt);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
