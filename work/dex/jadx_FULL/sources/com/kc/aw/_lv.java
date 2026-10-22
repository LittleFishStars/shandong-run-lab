package com.kc.aw;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lv implements _d3._d {
    public final Activity _a;
    public final _lg _b;

    @Keep
    public final class _a implements Runnable {
        public final _lv _a;

        public _a(_lv _lvVar) {
            this._a = _lvVar;
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
            _lv _lvVar = this._a;
            _in _inVar = _lvVar._b._E;
            if (_inVar != null) {
                _inVar._a(_lvVar._a);
            }
        }
    }

    public _lv(_lg _lgVar, Activity activity) {
        this._b = _lgVar;
        this._a = activity;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) {
        ImageView imageView;
        _lg _lgVar = this._b;
        if (_lgVar._G == null || (imageView = _lgVar._H) == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        ProgressBar progressBar = this._b._F;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this._b._G.post(new _a(this));
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        ProgressBar progressBar = this._b._F;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this._b._a();
        _la._a()._a(this._b._a2, PtgErrorCode.SDK_RESOURCE_ERROR, "load image error!");
        this._b._b(0);
    }
}
