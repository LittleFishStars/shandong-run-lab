package com.huachenjie.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.b;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\"R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\"R\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\"R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\"R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\"R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010\"¨\u0006;"}, d2 = {"Lcom/huachenjie/base/widget/AttendancePeriodView;", "Landroid/view/View;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", b.f25229a, "onDraw", "Landroid/graphics/Paint;", "paint", "", "text", "", "getFontWidth", "getFontBaseLine", "getFontHeight", "", "Lcom/huachenjie/base/widget/AttendancePeriodView$PeriodBean;", "data", "setPeriodData", "value", "a", "b", "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "textPaint", "Landroid/graphics/Paint;", "", "Ljava/util/List;", "getPeriodList", "()Ljava/util/List;", "periodList", "F", "fontHeight", "halfFontHeight", "c", "textSpace", "d", "itemSpace", "e", "itemPaddingStart", "f", "dotRadius", y6b.f, "lineWidth", y6b.g, "lineHeight", "i", "dotLineSpace", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PeriodBean", "base_release"}, k = 1, mv = {1, 8, 0})
public final class AttendancePeriodView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float fontHeight;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Paint paint;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final TextPaint textPaint;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<PeriodBean> periodList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float halfFontHeight;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float textSpace;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public float itemSpace;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public float itemPaddingStart;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public float dotRadius;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public float lineWidth;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public float lineHeight;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public float dotLineSpace;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/base/widget/AttendancePeriodView$PeriodBean;", "", "startTime", "", "endTime", "(Ljava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "getStartTime", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PeriodBean {

        @NotNull
        private final String endTime;

        @NotNull
        private final String startTime;

        public PeriodBean(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "startTime");
            Intrinsics.checkNotNullParameter(str2, "endTime");
            this.startTime = str;
            this.endTime = str2;
        }

        public static /* synthetic */ PeriodBean copy$default(PeriodBean periodBean, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = periodBean.startTime;
            }
            if ((i & 2) != 0) {
                str2 = periodBean.endTime;
            }
            return periodBean.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getStartTime() {
            return this.startTime;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEndTime() {
            return this.endTime;
        }

        @NotNull
        public final PeriodBean copy(@NotNull String startTime, @NotNull String endTime) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            return new PeriodBean(startTime, endTime);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PeriodBean)) {
                return false;
            }
            PeriodBean periodBean = (PeriodBean) other;
            return Intrinsics.areEqual(this.startTime, periodBean.startTime) && Intrinsics.areEqual(this.endTime, periodBean.endTime);
        }

        @NotNull
        public final String getEndTime() {
            return this.endTime;
        }

        @NotNull
        public final String getStartTime() {
            return this.startTime;
        }

        public int hashCode() {
            return (this.startTime.hashCode() * 31) + this.endTime.hashCode();
        }

        @NotNull
        public String toString() {
            return "PeriodBean(startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttendancePeriodView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttendancePeriodView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AttendancePeriodView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final float a(float value) {
        return TypedValue.applyDimension(1, value, getContext().getResources().getDisplayMetrics());
    }

    public final float b(float value) {
        return TypedValue.applyDimension(2, value, getContext().getResources().getDisplayMetrics());
    }

    public final float getFontBaseLine(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (-(fontMetrics.ascent + fontMetrics.descent)) / 2;
    }

    public final float getFontHeight(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    public final float getFontWidth(@NotNull Paint paint, @Nullable String text) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (text == null) {
            text = "";
        }
        return paint.measureText(text);
    }

    @NotNull
    public final List<PeriodBean> getPeriodList() {
        return this.periodList;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, b.f25229a);
        if (this.periodList.isEmpty()) {
            return;
        }
        float fontBaseLine = getFontBaseLine(this.textPaint);
        int size = this.periodList.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            PeriodBean periodBean = this.periodList.get(i);
            if (periodBean != null) {
                float f2 = this.dotRadius;
                float f3 = 2;
                canvas.drawCircle(f2, (this.fontHeight / f3) + f, f2, this.paint);
                canvas.drawText(periodBean.getStartTime(), (this.dotRadius * f3) + this.itemPaddingStart, this.halfFontHeight + f + fontBaseLine, this.textPaint);
                if (!TextUtils.isEmpty(periodBean.getEndTime())) {
                    float f4 = this.dotRadius;
                    float f5 = f4 - (this.lineWidth / f3);
                    float fA = (this.fontHeight / f3) + f + f4 + a(2.0f);
                    float f6 = this.dotRadius;
                    canvas.drawRect(new RectF(f5, fA, (this.lineWidth / f3) + f6, (this.fontHeight / f3) + f + f6 + a(2.0f) + this.lineHeight), this.paint);
                    float f7 = this.textSpace;
                    float f8 = this.fontHeight;
                    f += f7 + f8;
                    float f9 = this.dotRadius;
                    canvas.drawCircle(f9, (f8 / f3) + f, f9, this.paint);
                    canvas.drawText(periodBean.getEndTime(), (this.dotRadius * f3) + this.itemPaddingStart, this.halfFontHeight + f + fontBaseLine, this.textPaint);
                }
                f += this.fontHeight + this.itemSpace;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.periodList.isEmpty()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        float size = (this.periodList.size() - 1) * this.itemSpace;
        float fMax = 0.0f;
        for (PeriodBean periodBean : this.periodList) {
            size = TextUtils.isEmpty(periodBean.getEndTime()) ? size + this.fontHeight : size + (this.fontHeight * 2) + this.textSpace;
            fMax = Math.max(Math.max(getFontWidth(this.textPaint, periodBean.getStartTime()), getFontWidth(this.textPaint, periodBean.getEndTime())), fMax);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (fMax + this.itemPaddingStart + (this.dotRadius * 2)), 1073741824), View.MeasureSpec.makeMeasureSpec((int) size, 1073741824));
    }

    public final void setPeriodData(@NotNull List<PeriodBean> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.periodList.clear();
        this.periodList.addAll(data);
        postInvalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AttendancePeriodView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        Paint paint = new Paint();
        this.paint = paint;
        ArrayList arrayList = new ArrayList();
        this.periodList = arrayList;
        this.textSpace = 4.0f;
        this.itemSpace = 12.0f;
        this.itemPaddingStart = 8.0f;
        this.dotRadius = 2.0f;
        this.lineWidth = 1.0f;
        this.lineHeight = 16.0f;
        this.dotLineSpace = 2.0f;
        textPaint.setTextSize(b(14.0f));
        textPaint.setColor(Color.parseColor("#FF2C3E50"));
        textPaint.setAntiAlias(true);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FFC1C1C1"));
        paint.setStyle(Paint.Style.FILL);
        float fontHeight = getFontHeight(textPaint);
        this.fontHeight = fontHeight;
        float f = 2;
        this.halfFontHeight = fontHeight / f;
        this.textSpace = a(4.0f);
        this.itemSpace = a(12.0f);
        this.itemPaddingStart = a(8.0f);
        this.dotRadius = a(2.0f);
        this.lineWidth = a(1.0f);
        float fA = a(2.0f);
        this.dotLineSpace = fA;
        this.lineHeight = ((this.fontHeight + this.textSpace) - (this.dotRadius * f)) - (fA * f);
        if (isInEditMode()) {
            arrayList.add(new PeriodBean("2023-01-01", "2023-02-01"));
        }
    }
}
