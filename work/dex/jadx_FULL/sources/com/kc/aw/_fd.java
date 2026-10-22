package com.kc.aw;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fd implements _d3._d {
    public final String _a;
    public final _fa _b;

    public _fd(_fa _faVar, String str) {
        this._b = _faVar;
        this._a = str;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) {
        _3 _3;
        String str;
        try {
            this._b.setVisibility(0);
            if (bitmap != null) {
                _fa _faVar = this._b;
                ImageView imageView = _faVar._j;
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                    _fa _faVar2 = this._b;
                    _3 _4 = _faVar2._a;
                    if (_4 != null) {
                        View view = _faVar2._f;
                        _fj _fjVar = (_fj) _4;
                        _h _hVar = _fjVar._c._d;
                        if (_hVar != null) {
                            _hVar._I = System.currentTimeMillis();
                        }
                        view.post(new _fi(_fjVar, view));
                        return;
                    }
                    return;
                }
                _3 = _faVar._a;
                if (_3 == null) {
                    return;
                } else {
                    str = "页面被销毁或布局丢失！";
                }
            } else {
                _3 = this._b._a;
                if (_3 == null) {
                    return;
                } else {
                    str = "资源下载异常,Bitmap异常！";
                }
            }
            ((_fj) _3)._a(str);
        } catch (Exception e) {
            _3 _5 = this._b._a;
            if (_5 != null) {
                StringBuilder sb_a = _jf._a("渲染失败：");
                sb_a.append(e.getMessage());
                ((_fj) _5)._a(sb_a.toString());
            }
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        _3 _3 = this._b._a;
        if (_3 != null) {
            StringBuilder sb_a = _jf._a("资源下载异常: ");
            sb_a.append(this._a);
            ((_fj) _3)._a(sb_a.toString());
        }
    }
}
