package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DefaultYearView extends YearView {
    private int mTextPadding;

    public DefaultYearView(Context context) {
        super(context);
        this.mTextPadding = CalendarUtil.dipToPx(context, 3.0f);
    }

    @Override // com.huachenjie.base.widget.calendar.YearView
    public void onDrawMonth(Canvas canvas, int year, int month, int x, int y, int width, int height) {
        canvas.drawText(getContext().getResources().getStringArray(R.array.month_string_array)[month - 1], (x + (this.mItemWidth / 2)) - this.mTextPadding, y + this.mMonthTextBaseLine, this.mMonthTextPaint);
    }

    @Override // com.huachenjie.base.widget.calendar.YearView
    public void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
    }

    @Override // com.huachenjie.base.widget.calendar.YearView
    public boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        return false;
    }

    @Override // com.huachenjie.base.widget.calendar.YearView
    public void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        Paint paint;
        Paint paint2;
        float f = this.mTextBaseLine + y;
        int i = x + (this.mItemWidth / 2);
        if (isSelected) {
            canvas.drawText(String.valueOf(calendar.getDay()), i, f, hasScheme ? this.mSchemeTextPaint : this.mSelectTextPaint);
            return;
        }
        if (hasScheme) {
            String strValueOf = String.valueOf(calendar.getDay());
            float f2 = i;
            if (calendar.isCurrentDay()) {
                paint2 = this.mCurDayTextPaint;
            } else {
                paint2 = calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint;
            }
            canvas.drawText(strValueOf, f2, f, paint2);
            return;
        }
        String strValueOf2 = String.valueOf(calendar.getDay());
        float f3 = i;
        if (calendar.isCurrentDay()) {
            paint = this.mCurDayTextPaint;
        } else {
            paint = calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint;
        }
        canvas.drawText(strValueOf2, f3, f, paint);
    }

    @Override // com.huachenjie.base.widget.calendar.YearView
    public void onDrawWeek(Canvas canvas, int week, int x, int y, int width, int height) {
        canvas.drawText(getContext().getResources().getStringArray(R.array.year_view_week_string_array)[week], x + (width / 2), y + this.mWeekTextBaseLine, this.mWeekTextPaint);
    }
}
