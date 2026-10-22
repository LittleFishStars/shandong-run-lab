package com.kc.dw.core.safe;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.kc.dw.ad.view.scaleImage.SubsamplingScaleImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        SubsamplingScaleImageView subsamplingScaleImageView;
        View.OnLongClickListener onLongClickListener;
        try {
            SubsamplingScaleImageView.a aVar = (SubsamplingScaleImageView.a) this;
            if (message.what == 1 && (onLongClickListener = (subsamplingScaleImageView = aVar.f39196a).i0) != null) {
                subsamplingScaleImageView.L = 0;
                super/*android.view.View*/.setOnLongClickListener(onLongClickListener);
                aVar.f39196a.performLongClick();
                super/*android.view.View*/.setOnLongClickListener(null);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
            return false;
        }
    }
}
