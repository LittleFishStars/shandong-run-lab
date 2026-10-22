package com.kc.aw;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ap implements _fs {
    public final AdvertRatioLayout _a;
    public final ImageView _b;
    public final _d3._d _c;
    public final _am _d;

    public _ap(_am _amVar, AdvertRatioLayout advertRatioLayout, ImageView imageView, _d3._d _dVar) {
        this._d = _amVar;
        this._a = advertRatioLayout;
        this._b = imageView;
        this._c = _dVar;
    }

    @Override // com.kc.aw._fs
    public final void _a() {
        _d3._d _dVar = this._c;
        if (_dVar != null) {
            _dVar._a(new Exception("图片加载失败"));
        }
    }

    @Override // com.kc.aw._fs
    public final void _a(Bitmap bitmap) {
        if (bitmap != null) {
            _am _amVar = this._d;
            _hy _hyVar = _amVar._n;
            if (_hyVar != null && _hyVar._b) {
                _aw._a(_amVar.getContext(), bitmap, this._a);
            }
            ImageView imageView = this._b;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            _d3._d _dVar = this._c;
            if (_dVar != null) {
                _dVar._a(bitmap);
            }
        }
    }
}
