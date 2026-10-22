package com.kc.aw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lw implements _kq {
    public final Activity _a;
    public final _lg _b;

    @Keep
    public final class _a implements Runnable {
        public final _lw _a;

        public _a(_lw _lwVar) {
            this._a = _lwVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _h _hVar = this._a._b._b;
            if (_hVar != null) {
                _hVar._I = System.currentTimeMillis();
            }
            _lg _lgVar = this._a._b;
            _m1._a(_lgVar._G, _lgVar._b);
            _la._a()._a(this._a._b._a2);
            _lg _lgVar2 = this._a._b;
            if (_lgVar2._a5 == null) {
                _lgVar2._a5 = new _lg._i(this._a._b, 10000);
                this._a._b._a(true);
            }
            _la._a()._e(this._a._b._a2);
            _lw _lwVar = this._a;
            _in _inVar = _lwVar._b._E;
            if (_inVar != null) {
                _inVar._a(_lwVar._a);
            }
        }
    }

    public _lw(_lg _lgVar, Activity activity) {
        this._b = _lgVar;
        this._a = activity;
    }

    @Override // com.kc.aw._kq
    public final void _a(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap == null) {
            ProgressBar progressBar = this._b._F;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this._b._a();
            _la._a()._a(this._b._a2, PtgErrorCode.SDK_RESOURCE_ERROR, "load image error!");
            this._b._b(0);
            return;
        }
        _lg _lgVar = this._b;
        if (_lgVar._G == null || (imageView = _lgVar._H) == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        ProgressBar progressBar2 = this._b._F;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        this._b._G.post(new _a(this));
    }
}
