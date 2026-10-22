package com.kc.aw;

import android.graphics.Bitmap;
import com.kc.aw.lib.doodle.Doodle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _f1 implements Runnable {
    public final String _a;
    public final _kq _b;

    @Keep
    public final class _a implements Runnable {
        public final Bitmap _a;
        public final _f1 _b;

        public _a(_f1 _f1Var, Bitmap bitmap) {
            this._b = _f1Var;
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _kq _kqVar = this._b._b;
            if (_kqVar != null) {
                _kqVar._a(this._a);
            }
        }
    }

    public _f1(String str, _kq _kqVar) {
        this._a = str;
        this._b = _kqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _l2 _l2VarLoad = Doodle.load(this._a);
        _l2VarLoad._h = false;
        _ez._b.post(new _a(this, _l2VarLoad._a(3000L)));
    }
}
