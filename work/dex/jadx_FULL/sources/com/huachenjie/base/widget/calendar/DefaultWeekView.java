package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DefaultWeekView extends WeekView {
    private int mPadding;
    private float mRadio;
    private float mSchemeBaseLine;
    private Paint mSchemeBasicPaint;
    private Paint mTextPaint;

    public DefaultWeekView(Context context) {
        super(context);
        this.mTextPaint = new Paint();
        this.mSchemeBasicPaint = new Paint();
        this.mTextPaint.setTextSize(CalendarUtil.dipToPx(context, 8.0f));
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mSchemeBasicPaint.setAntiAlias(true);
        this.mSchemeBasicPaint.setStyle(Paint.Style.FILL);
        this.mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeBasicPaint.setColor(-1223853);
        this.mSchemeBasicPaint.setFakeBoldText(true);
        this.mRadio = CalendarUtil.dipToPx(getContext(), 7.0f);
        this.mPadding = CalendarUtil.dipToPx(getContext(), 4.0f);
        Paint.FontMetrics fontMetrics = this.mSchemeBasicPaint.getFontMetrics();
        this.mSchemeBaseLine = (this.mRadio - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f) + CalendarUtil.dipToPx(getContext(), 1.0f);
    }

    private float getTextWidth(String text) {
        return this.mTextPaint.measureText(text);
    }

    @Override // com.huachenjie.base.widget.calendar.WeekView
    public void onDrawScheme(Canvas canvas, Calendar calendar, int x) {
        this.mSchemeBasicPaint.setColor(calendar.getSchemeColor());
        int i = this.mItemWidth + x;
        int i2 = this.mPadding;
        float f = this.mRadio;
        canvas.drawCircle((i - i2) - (f / 2.0f), i2 + f, f, this.mSchemeBasicPaint);
        canvas.drawText(calendar.getScheme(), (((x + this.mItemWidth) - this.mPadding) - (this.mRadio / 2.0f)) - (getTextWidth(calendar.getScheme()) / 2.0f), this.mPadding + this.mSchemeBaseLine, this.mTextPaint);
    }

    @Override // com.huachenjie.base.widget.calendar.WeekView
    public boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, boolean hasScheme) {
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        int i = this.mPadding;
        canvas.drawRect(x + i, i, (x + this.mItemWidth) - i, this.mItemHeight - i, this.mSelectedPaint);
        return true;
    }

    @Override // com.huachenjie.base.widget.calendar.WeekView
    public void onDrawText(Canvas canvas, Calendar calendar, int x, boolean hasScheme, boolean isSelected) {
        Paint paint;
        Paint paint2;
        Paint paint3;
        int i = x + (this.mItemWidth / 2);
        int i2 = (-this.mItemHeight) / 6;
        if (isSelected) {
            float f = i;
            canvas.drawText(String.valueOf(calendar.getDay()), f, this.mTextBaseLine + i2, this.mSelectTextPaint);
            canvas.drawText(calendar.getLunar(), f, this.mTextBaseLine + (this.mItemHeight / 10), this.mSelectedLunarTextPaint);
            return;
        }
        if (hasScheme) {
            String strValueOf = String.valueOf(calendar.getDay());
            float f2 = i;
            float f3 = this.mTextBaseLine + i2;
            if (calendar.isCurrentDay()) {
                paint3 = this.mCurDayTextPaint;
            } else {
                paint3 = calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint;
            }
            canvas.drawText(strValueOf, f2, f3, paint3);
            canvas.drawText(calendar.getLunar(), f2, this.mTextBaseLine + (this.mItemHeight / 10), calendar.isCurrentDay() ? this.mCurDayLunarTextPaint : this.mSchemeLunarTextPaint);
            return;
        }
        String strValueOf2 = String.valueOf(calendar.getDay());
        float f4 = i;
        float f5 = this.mTextBaseLine + i2;
        if (calendar.isCurrentDay()) {
            paint = this.mCurDayTextPaint;
        } else {
            paint = calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint;
        }
        canvas.drawText(strValueOf2, f4, f5, paint);
        String lunar = calendar.getLunar();
        float f6 = this.mTextBaseLine + (this.mItemHeight / 10);
        if (calendar.isCurrentDay()) {
            paint2 = this.mCurDayLunarTextPaint;
        } else {
            paint2 = calendar.isCurrentMonth() ? this.mCurMonthLunarTextPaint : this.mOtherMonthLunarTextPaint;
        }
        canvas.drawText(lunar, f4, f6, paint2);
    }
}
