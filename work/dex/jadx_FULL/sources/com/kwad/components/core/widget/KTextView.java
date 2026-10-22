package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.kwad.sdk.R;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KTextView extends AppCompatTextView {

    public enum Font {
        HYQiHei75S("HYQiHei_75S"),
        HYQiHei80S("HYQiHei_80S"),
        HYQiHei90S("HYQiHei_90S"),
        SIYuan("SIYuan"),
        AvenirNextBold("AvenirNext-Bold"),
        AvenirNextBoldItalic("AvenirNext-Boldltalic"),
        DIN("din");

        public final String name;

        Font(String str) {
            this.name = str;
        }
    }

    public KTextView(Context context) {
        super(context);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        boolean z;
        int i;
        int i2 = R.attr.ksad_use_fake_bold;
        int i3 = R.attr.ksad_font_weight;
        int i4 = R.attr.ksad_font_name;
        int[] iArr = {i2, i3, i4};
        Arrays.sort(iArr);
        int i5 = 400;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
            z = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), false);
            i5 = typedArrayObtainStyledAttributes.getInt(Arrays.binarySearch(iArr, i3), 400);
            i = typedArrayObtainStyledAttributes.getInt(Arrays.binarySearch(iArr, i4), 0);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            z = false;
            i = 0;
        }
        if (i > 0) {
            if (i == 1) {
                setFontName(Font.HYQiHei75S);
            } else if (i == 2) {
                setFontName(Font.HYQiHei80S);
            } else if (i == 3) {
                setFontName(Font.HYQiHei90S);
            } else if (i == 4) {
                setFontName(Font.SIYuan);
            } else if (i == 5) {
                setFontName(Font.AvenirNextBold);
            } else if (i == 6) {
                setFontName(Font.AvenirNextBoldItalic);
            } else if (i == 7) {
                setFontName(Font.DIN);
            }
        } else if (z || i5 >= 500) {
            getPaint().setFakeBoldText(true);
        }
        setIncludeFontPadding(false);
    }

    private SpannableStringBuilder c(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new LineHeightSpan() { // from class: com.kwad.components.core.widget.KTextView.1
            @Override // android.text.style.LineHeightSpan
            public final void chooseHeight(CharSequence charSequence2, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
                Rect rect = new Rect();
                KTextView.this.getPaint().getTextBounds(charSequence2.toString(), 0, charSequence2.length(), rect);
                int i5 = fontMetricsInt.descent - fontMetricsInt.ascent;
                int iMax = Math.max((int) KTextView.this.getTextSize(), rect.bottom - rect.top);
                int iAbs = Math.abs(fontMetricsInt.ascent - rect.top);
                int i6 = fontMetricsInt.descent - rect.bottom;
                int i7 = (i5 - iMax) / 2;
                if (i7 < Math.min(iAbs, i6)) {
                    fontMetricsInt.ascent += i7;
                    fontMetricsInt.descent -= i7;
                } else if (iAbs < i6) {
                    int i8 = rect.top;
                    fontMetricsInt.ascent = i8;
                    fontMetricsInt.descent = iMax + i8;
                } else {
                    int i9 = rect.bottom;
                    fontMetricsInt.descent = i9;
                    fontMetricsInt.ascent = i9 - iMax;
                }
            }
        }, 0, charSequence.length(), 33);
        return spannableStringBuilder;
    }

    public void setFontName(Font font) {
        try {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/" + font.name + ".ttf"));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public void setFontWeight(int i) {
        getPaint().setFakeBoldText(i >= 500);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(c(charSequence), bufferType);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    public void setUseFakeBold(boolean z) {
        getPaint().setFakeBoldText(z);
    }

    public KTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public KTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }
}
