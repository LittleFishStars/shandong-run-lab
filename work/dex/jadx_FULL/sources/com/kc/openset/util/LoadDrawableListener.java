package com.kc.openset.util;

import android.graphics.drawable.Drawable;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface LoadDrawableListener {
    void onFail();

    void onSuccess(Drawable drawable);
}
