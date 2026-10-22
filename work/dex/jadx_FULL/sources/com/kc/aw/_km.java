package com.kc.aw;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.kc.aw.component.video.PtgVideoView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _km implements _d3._d {
    public final String _a;
    public final PtgVideoView _b;

    public _km(PtgVideoView ptgVideoView, String str) {
        this._b = ptgVideoView;
        this._a = str;
    }

    @Override // com.kc.aw._d3._g
    public final void _a(Bitmap bitmap) throws Throwable {
        PtgVideoView ptgVideoView = this._b;
        ptgVideoView._r = bitmap;
        ImageView imageView = ptgVideoView._g;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        PtgVideoView ptgVideoView2 = this._b;
        _hy _hyVar = ptgVideoView2._u;
        if (_hyVar != null && _hyVar._b) {
            _aw._a(ptgVideoView2.getContext(), this._a, this._b._f);
        }
        if (this._b._q.get()) {
            return;
        }
        PtgVideoView ptgVideoView3 = this._b;
        if (ptgVideoView3._a != null) {
            ptgVideoView3._q.set(true);
            this._b._a._a(bitmap);
        }
    }

    @Override // com.kc.aw._d3._d
    public final void _a(Exception exc) {
        if (this._b._q.get()) {
            return;
        }
        PtgVideoView ptgVideoView = this._b;
        if (ptgVideoView._a != null) {
            ptgVideoView._q.set(true);
            this._b._a._a((Bitmap) null);
        }
    }
}
