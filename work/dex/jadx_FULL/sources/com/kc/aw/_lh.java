package com.kc.aw;

import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lh implements Runnable {
    public final _lg _a;

    public _lh(_lg _lgVar) {
        this._a = _lgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView = this._a._H;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
