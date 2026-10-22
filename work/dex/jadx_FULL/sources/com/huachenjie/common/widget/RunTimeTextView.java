package com.huachenjie.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.zj.adlib.s72;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class RunTimeTextView extends AppCompatTextView {
    public RunTimeTextView(Context context) {
        this(context, null);
    }

    private void init() {
        setTime(0L);
    }

    public void setTime(long time) {
        setText(s72.o(time / 1000, true));
    }

    public RunTimeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RunTimeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
}
