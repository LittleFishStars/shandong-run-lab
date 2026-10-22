package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kc.aw.component.base.AdvertRatioLayout;
import com.kc.aw.component.video.PtgVideoView;
import com.kc.aw.component.videoplayer2.PtgCoreVideo;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.doodle.Doodle;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kf implements View.OnLayoutChangeListener {
    public int _a;
    public int _b;
    public final PtgVideoView _c;

    public _kf(PtgVideoView ptgVideoView) {
        this._c = ptgVideoView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws Throwable {
        FrameLayout.LayoutParams layoutParams;
        int i9 = i3 - i;
        int i10 = i4 - i2;
        if ((i9 <= 0 || i10 <= 0 || i9 == this._a) && i10 == this._b) {
            return;
        }
        this._a = i9;
        this._b = i10;
        PtgVideoView ptgVideoView = this._c;
        _h _hVar = ptgVideoView._l;
        if (_hVar == null) {
            return;
        }
        _hy _hyVar_a = _l5._a(_hVar, i9, i10);
        ptgVideoView._u = _hyVar_a;
        if (_hyVar_a == null || (layoutParams = _hyVar_a._a) == null) {
            return;
        }
        ImageView imageView = ptgVideoView._g;
        if (imageView != null) {
            imageView.post(new _ki(ptgVideoView, layoutParams));
        }
        if (ptgVideoView._u._b) {
            if (TextUtils.isEmpty(ptgVideoView._l._m())) {
                AdvertRatioLayout advertRatioLayout = ptgVideoView._f;
                ImageView imageView2 = ptgVideoView._g;
                if (advertRatioLayout != null && imageView2 != null) {
                    Drawable drawable = imageView2.getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                        Context context = imageView2.getContext();
                        if (bitmap != null) {
                            com.kc.aw.lib.utils._d._b(new _a8(context, bitmap, advertRatioLayout));
                        }
                    }
                }
            } else if (PtgAdSdk.getConfig()._b()) {
                _l2 _l2VarLoad = Doodle.load(ptgVideoView._l._m());
                _l2VarLoad._i = true;
                _l2VarLoad._h = false;
                _aw._a(ptgVideoView.getContext(), _l2VarLoad._a(3000L), ptgVideoView._f);
            } else {
                _aw._a(ptgVideoView.getContext(), ptgVideoView._l._m(), ptgVideoView._f);
            }
        }
        PtgCoreVideo ptgCoreVideo = ptgVideoView._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo.setLayoutParams(layoutParams);
            ptgVideoView._j.setVisibility(0);
        }
        if (ptgVideoView._h != null) {
            int iMax = Math.max(ScreenUtils.dp2px(20.0f), Math.min(ScreenUtils.dp2px(50.0f), (int) (Math.min(i9, i10) * 0.35f)));
            ViewGroup.LayoutParams layoutParams2 = ptgVideoView._h.getLayoutParams();
            layoutParams2.width = iMax;
            layoutParams2.height = iMax;
            ptgVideoView._h.setLayoutParams(layoutParams2);
        }
        AdvertRatioLayout._a _aVar = ptgVideoView._v;
        if (_aVar != null) {
            _aVar._a(i9, i10);
        }
    }
}
