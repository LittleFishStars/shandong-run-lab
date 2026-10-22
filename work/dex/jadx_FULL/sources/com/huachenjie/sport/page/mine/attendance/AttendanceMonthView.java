package com.huachenjie.sport.page.mine.attendance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huachenjie.base.widget.calendar.Calendar;
import com.huachenjie.base.widget.calendar.MonthView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AttendanceType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AttendanceMonthView extends MonthView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f36588a;

    public AttendanceMonthView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f36588a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final Bitmap b(int i) {
        Drawable drawable = getContext().getDrawable(i);
        if (drawable == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        if (bitmapCreateBitmap == null) {
            return bitmapCreateBitmap;
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // com.huachenjie.base.widget.calendar.MonthView
    public void onDrawScheme(Canvas canvas, Calendar calendar, int i, int i2) {
    }

    @Override // com.huachenjie.base.widget.calendar.MonthView
    public boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z) {
        return true;
    }

    @Override // com.huachenjie.base.widget.calendar.MonthView
    public void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2) {
        Bitmap bitmapB;
        float fA = (this.mTextBaseLine + i2) - a(getContext(), 1.0f);
        int i3 = i + (this.mItemWidth / 2);
        int iA = a(getContext(), 15.0f) + i2;
        float f = fA - ((i2 + (this.mItemHeight / 2)) - iA);
        if (z2) {
            this.f36588a.setColor(-10155284);
            float f2 = i3;
            canvas.drawCircle(f2, iA, a(getContext(), 12.0f), this.f36588a);
            canvas.drawText(String.valueOf(calendar.getDay()), f2, f, this.mSelectTextPaint);
        } else {
            if (calendar.isCurrentDay()) {
                this.f36588a.setColor(862259948);
                canvas.drawCircle(i3, iA, a(getContext(), 12.0f), this.f36588a);
            }
            canvas.drawText(String.valueOf(calendar.getDay()), i3, f, calendar.isCurrentMonth() ? this.mCurMonthTextPaint : this.mOtherMonthTextPaint);
        }
        if (z) {
            String scheme = calendar.getScheme();
            if (TextUtils.equals(scheme, AttendanceType.CLOCKED_IN)) {
                Bitmap bitmapB2 = b(R.drawable.ic_attendance_clocked);
                if (bitmapB2 != null) {
                    canvas.drawBitmap(bitmapB2, (Rect) null, new RectF(i3 - a(getContext(), 4.0f), a(getContext(), 14.0f) + iA, i3 + a(getContext(), 4.0f), iA + a(getContext(), 22.0f)), (Paint) null);
                    return;
                }
                return;
            }
            if (!TextUtils.equals(scheme, AttendanceType.MISSING_IN) || (bitmapB = b(R.drawable.ic_attendance_missing)) == null) {
                return;
            }
            canvas.drawBitmap(bitmapB, (Rect) null, new RectF(i3 - a(getContext(), 4.0f), a(getContext(), 14.0f) + iA, i3 + a(getContext(), 4.0f), iA + a(getContext(), 22.0f)), (Paint) null);
        }
    }
}
