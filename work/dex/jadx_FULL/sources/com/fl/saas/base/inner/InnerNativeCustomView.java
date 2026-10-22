package com.fl.saas.base.inner;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.fl.saas.common.util.feature.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerNativeCustomView {
    View getAdView();

    View getCATView();

    Consumer<Bitmap> loadIcon();

    InnerNativeCustomView setCAT(String str);

    InnerNativeCustomView setDes(String str);

    InnerNativeCustomView setMediaView(View view, @Nullable Drawable drawable);

    InnerNativeCustomView setTitle(String str);
}
