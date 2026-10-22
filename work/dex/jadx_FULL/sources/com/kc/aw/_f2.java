package com.kc.aw;

import android.graphics.Bitmap;
import com.kc.aw.lib.doodle.Doodle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _f2 implements Runnable {
    public final String _b;
    public final _kq _d;
    public final int _a = 2;
    public final int _c = 3000;

    @Keep
    public final class _a implements Runnable {
        public final Bitmap _a;
        public final _f2 _b;

        public _a(_f2 _f2Var, Bitmap bitmap) {
            this._b = _f2Var;
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _kq _kqVar = this._b._d;
            if (_kqVar != null) {
                _kqVar._a(this._a);
            }
        }
    }

    public _f2(_lw _lwVar, String str) {
        this._b = str;
        this._d = _lwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap_a = null;
        for (int i = 0; i < this._a; i++) {
            _l2 _l2VarLoad = Doodle.load(this._b);
            _l2VarLoad._h = false;
            bitmap_a = _l2VarLoad._a(this._c);
            if (bitmap_a != null) {
                break;
            }
        }
        _ez._b.post(new _a(this, bitmap_a));
    }
}
