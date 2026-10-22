package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.zj.adlib.qk3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CustomerTextView extends AppCompatTextView {
    public CustomerTextView(Context context) {
        super(context);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        setTypeface(getFontTypefaceFromAssert("font/shandong.ttf"));
    }

    private Typeface getFontTypefaceFromAssert(String fontName) {
        try {
            return qk3.a(fontName);
        } catch (Exception unused) {
            return null;
        }
    }

    public CustomerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomerTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context);
    }
}
