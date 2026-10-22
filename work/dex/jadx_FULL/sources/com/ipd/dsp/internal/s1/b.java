package com.ipd.dsp.internal.s1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends AppCompatButton {
    public String f;
    public String g;
    public ShapeDrawable h;

    public b(@NonNull Context context) {
        super(context);
        this.f = "#90CCCCCC";
    }

    public String getCornerStrokeColor() {
        String str = this.g;
        return str != null ? str : this.f;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.h == null || z) {
            float height = getHeight() / 2.0f;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{height, height, height, height, height, height, height, height}, new RectF(0.0f, 0.0f, 0.0f, 0.0f), null));
            this.h = shapeDrawable;
            shapeDrawable.getPaint().setColor(Color.parseColor(getCornerStrokeColor()));
            this.h.getPaint().setStyle(Paint.Style.FILL);
            this.h.setPadding(new Rect(0, 0, 0, 0));
            setBackgroundDrawable(this.h);
        }
    }

    public void setCornerStrokeColor(String str) {
        try {
            Color.parseColor(str);
            this.g = str;
        } catch (Throwable unused) {
        }
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = "#90CCCCCC";
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = "#90CCCCCC";
    }
}
