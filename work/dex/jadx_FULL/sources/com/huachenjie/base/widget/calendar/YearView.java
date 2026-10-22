package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class YearView extends View {
    protected Paint mCurDayLunarTextPaint;
    protected Paint mCurDayTextPaint;
    protected Paint mCurMonthLunarTextPaint;
    protected Paint mCurMonthTextPaint;
    CalendarViewDelegate mDelegate;
    protected int mItemHeight;
    protected int mItemWidth;
    List<Calendar> mItems;
    protected int mLineCount;
    protected int mMonth;
    protected float mMonthTextBaseLine;
    protected Paint mMonthTextPaint;
    protected int mNextDiff;
    protected Paint mOtherMonthLunarTextPaint;
    protected Paint mOtherMonthTextPaint;
    protected Paint mSchemeLunarTextPaint;
    protected Paint mSchemePaint;
    protected Paint mSchemeTextPaint;
    protected Paint mSelectTextPaint;
    protected Paint mSelectedLunarTextPaint;
    protected Paint mSelectedPaint;
    protected float mTextBaseLine;
    protected int mWeekStart;
    protected float mWeekTextBaseLine;
    protected Paint mWeekTextPaint;
    protected int mYear;

    public YearView(Context context) {
        this(context, null);
    }

    private void addSchemesFromMap() {
        Map<String, Calendar> map = this.mDelegate.mSchemeDatesMap;
        if (map == null || map.size() == 0) {
            return;
        }
        for (Calendar calendar : this.mItems) {
            if (this.mDelegate.mSchemeDatesMap.containsKey(calendar.toString())) {
                Calendar calendar2 = this.mDelegate.mSchemeDatesMap.get(calendar.toString());
                if (calendar2 != null) {
                    calendar.setScheme(TextUtils.isEmpty(calendar2.getScheme()) ? this.mDelegate.getSchemeText() : calendar2.getScheme());
                    calendar.setSchemeColor(calendar2.getSchemeColor());
                    calendar.setSchemes(calendar2.getSchemes());
                }
            } else {
                calendar.setScheme("");
                calendar.setSchemeColor(0);
                calendar.setSchemes(null);
            }
        }
    }

    private void draw(Canvas canvas, Calendar calendar, int i, int j, int d) {
        int yearViewMonthPaddingLeft = (j * this.mItemWidth) + this.mDelegate.getYearViewMonthPaddingLeft();
        int monthViewTop = (i * this.mItemHeight) + getMonthViewTop();
        boolean zEquals = calendar.equals(this.mDelegate.mSelectedCalendar);
        boolean zHasScheme = calendar.hasScheme();
        if (zHasScheme) {
            if ((zEquals ? onDrawSelected(canvas, calendar, yearViewMonthPaddingLeft, monthViewTop, true) : false) || !zEquals) {
                this.mSchemePaint.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor());
                onDrawScheme(canvas, calendar, yearViewMonthPaddingLeft, monthViewTop);
            }
        } else if (zEquals) {
            onDrawSelected(canvas, calendar, yearViewMonthPaddingLeft, monthViewTop, false);
        }
        onDrawText(canvas, calendar, yearViewMonthPaddingLeft, monthViewTop, zHasScheme, zEquals);
    }

    private int getMonthViewTop() {
        return this.mDelegate.getYearViewMonthPaddingTop() + this.mDelegate.getYearViewMonthHeight() + this.mDelegate.getYearViewMonthPaddingBottom() + this.mDelegate.getYearViewWeekHeight();
    }

    private void initPaint() {
        this.mCurMonthTextPaint.setAntiAlias(true);
        this.mCurMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurMonthTextPaint.setColor(-15658735);
        this.mCurMonthTextPaint.setFakeBoldText(true);
        this.mOtherMonthTextPaint.setAntiAlias(true);
        this.mOtherMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthTextPaint.setColor(-1973791);
        this.mOtherMonthTextPaint.setFakeBoldText(true);
        this.mCurMonthLunarTextPaint.setAntiAlias(true);
        this.mCurMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectedLunarTextPaint.setAntiAlias(true);
        this.mSelectedLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthLunarTextPaint.setAntiAlias(true);
        this.mOtherMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mMonthTextPaint.setAntiAlias(true);
        this.mMonthTextPaint.setFakeBoldText(true);
        this.mWeekTextPaint.setAntiAlias(true);
        this.mWeekTextPaint.setFakeBoldText(true);
        this.mWeekTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeLunarTextPaint.setAntiAlias(true);
        this.mSchemeLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setAntiAlias(true);
        this.mSchemeTextPaint.setStyle(Paint.Style.FILL);
        this.mSchemeTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setColor(-1223853);
        this.mSchemeTextPaint.setFakeBoldText(true);
        this.mSelectTextPaint.setAntiAlias(true);
        this.mSelectTextPaint.setStyle(Paint.Style.FILL);
        this.mSelectTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectTextPaint.setColor(-1223853);
        this.mSelectTextPaint.setFakeBoldText(true);
        this.mSchemePaint.setAntiAlias(true);
        this.mSchemePaint.setStyle(Paint.Style.FILL);
        this.mSchemePaint.setStrokeWidth(2.0f);
        this.mSchemePaint.setColor(-1052689);
        this.mCurDayTextPaint.setAntiAlias(true);
        this.mCurDayTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayTextPaint.setColor(-65536);
        this.mCurDayTextPaint.setFakeBoldText(true);
        this.mCurDayLunarTextPaint.setAntiAlias(true);
        this.mCurDayLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayLunarTextPaint.setColor(-65536);
        this.mCurDayLunarTextPaint.setFakeBoldText(true);
        this.mSelectedPaint.setAntiAlias(true);
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setStrokeWidth(2.0f);
    }

    private void onDrawMonth(Canvas canvas) {
        onDrawMonth(canvas, this.mYear, this.mMonth, this.mDelegate.getYearViewMonthPaddingLeft(), this.mDelegate.getYearViewMonthPaddingTop(), getWidth() - (this.mDelegate.getYearViewMonthPaddingRight() * 2), this.mDelegate.getYearViewMonthHeight() + this.mDelegate.getYearViewMonthPaddingTop());
    }

    private void onDrawMonthView(Canvas canvas) {
        int i = 0;
        int i2 = 0;
        while (i2 < this.mLineCount) {
            int i3 = i;
            for (int i4 = 0; i4 < 7; i4++) {
                Calendar calendar = this.mItems.get(i3);
                if (i3 > this.mItems.size() - this.mNextDiff) {
                    return;
                }
                if (calendar.isCurrentMonth()) {
                    draw(canvas, calendar, i2, i4, i3);
                }
                i3++;
            }
            i2++;
            i = i3;
        }
    }

    private void onDrawWeek(Canvas canvas) {
        if (this.mDelegate.getYearViewWeekHeight() <= 0) {
            return;
        }
        int weekStart = this.mDelegate.getWeekStart();
        if (weekStart > 0) {
            weekStart--;
        }
        int width = ((getWidth() - this.mDelegate.getYearViewMonthPaddingLeft()) - this.mDelegate.getYearViewMonthPaddingRight()) / 7;
        for (int i = 0; i < 7; i++) {
            onDrawWeek(canvas, weekStart, this.mDelegate.getYearViewMonthPaddingLeft() + (i * width), this.mDelegate.getYearViewMonthHeight() + this.mDelegate.getYearViewMonthPaddingTop() + this.mDelegate.getYearViewMonthPaddingBottom(), width, this.mDelegate.getYearViewWeekHeight());
            weekStart++;
            if (weekStart >= 7) {
                weekStart = 0;
            }
        }
    }

    public final void init(int year, int month) {
        this.mYear = year;
        this.mMonth = month;
        this.mNextDiff = CalendarUtil.getMonthEndDiff(year, month, this.mDelegate.getWeekStart());
        CalendarUtil.getMonthViewStartDiff(this.mYear, this.mMonth, this.mDelegate.getWeekStart());
        this.mItems = CalendarUtil.initCalendarForMonthView(this.mYear, this.mMonth, this.mDelegate.getCurrentDay(), this.mDelegate.getWeekStart());
        this.mLineCount = 6;
        addSchemesFromMap();
    }

    public final void measureSize(int width, int height) {
        Rect rect = new Rect();
        this.mCurMonthTextPaint.getTextBounds("1", 0, 1, rect);
        int iHeight = (rect.height() * 12) + getMonthViewTop();
        if (height < iHeight) {
            height = iHeight;
        }
        getLayoutParams().width = width;
        getLayoutParams().height = height;
        this.mItemHeight = (height - getMonthViewTop()) / 6;
        Paint.FontMetrics fontMetrics = this.mCurMonthTextPaint.getFontMetrics();
        this.mTextBaseLine = ((this.mItemHeight / 2) - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
        Paint.FontMetrics fontMetrics2 = this.mMonthTextPaint.getFontMetrics();
        this.mMonthTextBaseLine = ((this.mDelegate.getYearViewMonthHeight() / 2) - fontMetrics2.descent) + ((fontMetrics2.bottom - fontMetrics2.top) / 2.0f);
        Paint.FontMetrics fontMetrics3 = this.mWeekTextPaint.getFontMetrics();
        this.mWeekTextBaseLine = ((this.mDelegate.getYearViewWeekHeight() / 2) - fontMetrics3.descent) + ((fontMetrics3.bottom - fontMetrics3.top) / 2.0f);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mItemWidth = ((getWidth() - this.mDelegate.getYearViewMonthPaddingLeft()) - this.mDelegate.getYearViewMonthPaddingRight()) / 7;
        onPreviewHook();
        onDrawMonth(canvas);
        onDrawWeek(canvas);
        onDrawMonthView(canvas);
    }

    public abstract void onDrawMonth(Canvas canvas, int year, int month, int x, int y, int width, int height);

    public abstract void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y);

    public abstract boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme);

    public abstract void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected);

    public abstract void onDrawWeek(Canvas canvas, int week, int x, int y, int width, int height);

    public void onPreviewHook() {
    }

    public final void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        updateStyle();
    }

    public final void updateStyle() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) {
            return;
        }
        this.mCurMonthTextPaint.setTextSize(calendarViewDelegate.getYearViewDayTextSize());
        this.mSchemeTextPaint.setTextSize(this.mDelegate.getYearViewDayTextSize());
        this.mOtherMonthTextPaint.setTextSize(this.mDelegate.getYearViewDayTextSize());
        this.mCurDayTextPaint.setTextSize(this.mDelegate.getYearViewDayTextSize());
        this.mSelectTextPaint.setTextSize(this.mDelegate.getYearViewDayTextSize());
        this.mSchemeTextPaint.setColor(this.mDelegate.getYearViewSchemeTextColor());
        this.mCurMonthTextPaint.setColor(this.mDelegate.getYearViewDayTextColor());
        this.mOtherMonthTextPaint.setColor(this.mDelegate.getYearViewDayTextColor());
        this.mCurDayTextPaint.setColor(this.mDelegate.getYearViewCurDayTextColor());
        this.mSelectTextPaint.setColor(this.mDelegate.getYearViewSelectTextColor());
        this.mMonthTextPaint.setTextSize(this.mDelegate.getYearViewMonthTextSize());
        this.mMonthTextPaint.setColor(this.mDelegate.getYearViewMonthTextColor());
        this.mWeekTextPaint.setColor(this.mDelegate.getYearViewWeekTextColor());
        this.mWeekTextPaint.setTextSize(this.mDelegate.getYearViewWeekTextSize());
    }

    public YearView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mCurMonthTextPaint = new Paint();
        this.mOtherMonthTextPaint = new Paint();
        this.mCurMonthLunarTextPaint = new Paint();
        this.mSelectedLunarTextPaint = new Paint();
        this.mOtherMonthLunarTextPaint = new Paint();
        this.mSchemeLunarTextPaint = new Paint();
        this.mSchemePaint = new Paint();
        this.mSelectedPaint = new Paint();
        this.mSchemeTextPaint = new Paint();
        this.mSelectTextPaint = new Paint();
        this.mCurDayTextPaint = new Paint();
        this.mCurDayLunarTextPaint = new Paint();
        this.mMonthTextPaint = new Paint();
        this.mWeekTextPaint = new Paint();
        initPaint();
    }
}
