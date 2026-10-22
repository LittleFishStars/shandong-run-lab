package com.byazt.ff;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.byazt.nr.m;
import com.byazt.zqa.c;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 142, 1875})
public class TTProgressBar extends ProgressBar {
    public TTProgressBar(Context context) {
        super(context);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            try {
                super.onRestoreInstanceState(parcelable);
            } catch (Throwable th) {
                m.c(th);
            }
        } catch (Exception unused) {
            Field field = getClass().getField("mPrivateFlags");
            field.setAccessible(true);
            field.set(this, Integer.valueOf(((Integer) field.get(this)).intValue() | 131072));
        }
    }

    public TTProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
