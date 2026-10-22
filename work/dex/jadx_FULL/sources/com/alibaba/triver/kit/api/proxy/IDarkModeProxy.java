package com.alibaba.triver.kit.api.proxy;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.annotation.ColorInt;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IDarkModeProxy extends Proxiable {
    public static final int BACKGROUND = 3;
    public static final int FOREGROUND_DRAWABLE = 2;
    public static final int FOREGROUND_TEXT = 1;

    void disableForceDark(View view);

    void enableAutoDark(Dialog dialog);

    boolean isDarkModeEnable(Context context);

    @ColorInt
    int transformColor(int i, @ColorInt int i2);
}
