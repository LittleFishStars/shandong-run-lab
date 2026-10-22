package com.fl.saas.adx.base.inner;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.fl.saas.B;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerNativeCustomView {
    View getAdView();

    View getCATView();

    B loadIcon();

    InnerNativeCustomView setCAT(String str);

    InnerNativeCustomView setDes(String str);

    InnerNativeCustomView setMediaView(View view, @Nullable Drawable drawable);

    InnerNativeCustomView setTitle(String str);
}
