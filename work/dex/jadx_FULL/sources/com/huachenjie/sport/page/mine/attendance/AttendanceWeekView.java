package com.huachenjie.sport.page.mine.attendance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.huachenjie.base.widget.calendar.Calendar;
import com.huachenjie.base.widget.calendar.WeekView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AttendanceWeekView extends WeekView {
    public AttendanceWeekView(Context context) {
        super(context);
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.huachenjie.base.widget.calendar.WeekView
    public void onDrawScheme(Canvas canvas, Calendar calendar, int i) {
    }

    @Override // com.huachenjie.base.widget.calendar.WeekView
    public boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, boolean z) {
        return true;
    }

    @Override // com.huachenjie.base.widget.calendar.WeekView
    public void onDrawText(Canvas canvas, Calendar calendar, int i, boolean z, boolean z2) {
        String strValueOf;
        Paint paint;
        Paint paint2;
        float fA = this.mTextBaseLine - a(getContext(), 1.0f);
        int i2 = i + (this.mItemWidth / 2);
        if (z2) {
            canvas.drawText(calendar.isCurrentDay() ? "今" : "选", i2, fA, this.mSelectTextPaint);
            return;
        }
        if (z) {
            strValueOf = calendar.isCurrentDay() ? "今" : String.valueOf(calendar.getDay());
            float f = i2;
            if (calendar.isCurrentDay()) {
                paint2 = this.mCurDayTextPaint;
            } else {
                paint2 = calendar.isCurrentMonth() ? this.mSchemeTextPaint : this.mOtherMonthTextPaint;
            }
            canvas.drawText(strValueOf, f, fA, paint2);
            return;
        }
        strValueOf = calendar.isCurrentDay() ? "今" : String.valueOf(calendar.getDay());
        float f2 = i2;
        if (calendar.isCurrentDay()) {
            paint = this.mCurDayTextPaint;
        } else {
            paint = calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint;
        }
        canvas.drawText(strValueOf, f2, fA, paint);
    }
}
