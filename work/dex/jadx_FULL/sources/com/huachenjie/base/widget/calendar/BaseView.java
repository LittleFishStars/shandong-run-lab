package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseView extends View implements View.OnClickListener, View.OnLongClickListener {
    static final int TEXT_SIZE = 14;
    boolean isClick;
    protected Paint mCurDayLunarTextPaint;
    protected Paint mCurDayTextPaint;
    protected Paint mCurMonthLunarTextPaint;
    protected Paint mCurMonthTextPaint;
    int mCurrentItem;
    CalendarViewDelegate mDelegate;
    protected int mItemHeight;
    protected int mItemWidth;
    protected List<Calendar> mItems;
    protected Paint mOtherMonthLunarTextPaint;
    protected Paint mOtherMonthTextPaint;
    CalendarLayout mParentLayout;
    protected Paint mSchemeLunarTextPaint;
    protected Paint mSchemePaint;
    protected Paint mSchemeTextPaint;
    protected Paint mSelectTextPaint;
    protected Paint mSelectedLunarTextPaint;
    protected Paint mSelectedPaint;
    protected float mTextBaseLine;
    int mWeekStartWidth;
    protected float mX;
    protected float mY;

    public BaseView(Context context) {
        this(context, null);
    }

    private void initPaint(Context context) {
        this.mCurMonthTextPaint.setAntiAlias(true);
        this.mCurMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurMonthTextPaint.setColor(-15658735);
        this.mCurMonthTextPaint.setFakeBoldText(false);
        this.mCurMonthTextPaint.setTextSize(CalendarUtil.dipToPx(context, 14.0f));
        this.mOtherMonthTextPaint.setAntiAlias(true);
        this.mOtherMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthTextPaint.setColor(-1973791);
        this.mOtherMonthTextPaint.setFakeBoldText(false);
        this.mOtherMonthTextPaint.setTextSize(CalendarUtil.dipToPx(context, 14.0f));
        this.mCurMonthLunarTextPaint.setAntiAlias(true);
        this.mCurMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectedLunarTextPaint.setAntiAlias(true);
        this.mSelectedLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthLunarTextPaint.setAntiAlias(true);
        this.mOtherMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeLunarTextPaint.setAntiAlias(true);
        this.mSchemeLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setAntiAlias(true);
        this.mSchemeTextPaint.setStyle(Paint.Style.FILL);
        this.mSchemeTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setColor(-1223853);
        this.mSchemeTextPaint.setFakeBoldText(true);
        this.mSchemeTextPaint.setTextSize(CalendarUtil.dipToPx(context, 14.0f));
        this.mSelectTextPaint.setAntiAlias(true);
        this.mSelectTextPaint.setStyle(Paint.Style.FILL);
        this.mSelectTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectTextPaint.setColor(-1223853);
        this.mSelectTextPaint.setFakeBoldText(false);
        this.mSelectTextPaint.setTextSize(CalendarUtil.dipToPx(context, 14.0f));
        this.mSchemePaint.setAntiAlias(true);
        this.mSchemePaint.setStyle(Paint.Style.FILL);
        this.mSchemePaint.setStrokeWidth(2.0f);
        this.mSchemePaint.setColor(-1052689);
        this.mCurDayTextPaint.setAntiAlias(true);
        this.mCurDayTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayTextPaint.setColor(-65536);
        this.mCurDayTextPaint.setFakeBoldText(true);
        this.mCurDayTextPaint.setTextSize(CalendarUtil.dipToPx(context, 14.0f));
        this.mCurDayLunarTextPaint.setAntiAlias(true);
        this.mCurDayLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayLunarTextPaint.setColor(-65536);
        this.mCurDayLunarTextPaint.setFakeBoldText(true);
        this.mCurDayLunarTextPaint.setTextSize(CalendarUtil.dipToPx(context, 14.0f));
        this.mSelectedPaint.setAntiAlias(true);
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setStrokeWidth(2.0f);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public final void addSchemesFromMap() {
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

    public int getCalendarPaddingLeft() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate != null) {
            return calendarViewDelegate.getCalendarPaddingLeft();
        }
        return 0;
    }

    public int getCalendarPaddingRight() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate != null) {
            return calendarViewDelegate.getCalendarPaddingRight();
        }
        return 0;
    }

    public int getWeekStartWith() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate != null) {
            return calendarViewDelegate.getWeekStart();
        }
        return 1;
    }

    public void initPaint() {
    }

    public final boolean isInRange(Calendar calendar) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        return calendarViewDelegate != null && CalendarUtil.isCalendarInRange(calendar, calendarViewDelegate);
    }

    public boolean isSelected(Calendar calendar) {
        List<Calendar> list = this.mItems;
        return list != null && list.indexOf(calendar) == this.mCurrentItem;
    }

    public final boolean onCalendarIntercept(Calendar calendar) {
        CalendarView.OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.mCalendarInterceptListener;
        return onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(calendar);
    }

    public abstract void onDestroy();

    public void onPreviewHook() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() > 1) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.mX = event.getX();
            this.mY = event.getY();
            this.isClick = true;
        } else if (action == 1) {
            this.mX = event.getX();
            this.mY = event.getY();
        } else if (action == 2 && this.isClick) {
            this.isClick = Math.abs(event.getY() - this.mY) <= 50.0f;
        }
        return super.onTouchEvent(event);
    }

    public final void removeSchemes() {
        for (Calendar calendar : this.mItems) {
            calendar.setScheme("");
            calendar.setSchemeColor(0);
            calendar.setSchemes(null);
        }
    }

    public final void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        this.mWeekStartWidth = delegate.getWeekStart();
        updateStyle();
        updateItemHeight();
        initPaint();
    }

    public final void update() {
        Map<String, Calendar> map = this.mDelegate.mSchemeDatesMap;
        if (map == null || map.size() == 0) {
            removeSchemes();
            invalidate();
        } else {
            addSchemesFromMap();
            invalidate();
        }
    }

    public abstract void updateCurrentDate();

    public void updateItemHeight() {
        this.mItemHeight = this.mDelegate.getCalendarItemHeight();
        Paint.FontMetrics fontMetrics = this.mCurMonthTextPaint.getFontMetrics();
        this.mTextBaseLine = ((this.mItemHeight / 2) - fontMetrics.descent) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f);
    }

    public final void updateStyle() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) {
            return;
        }
        this.mCurDayTextPaint.setColor(calendarViewDelegate.getCurDayTextColor());
        this.mCurDayLunarTextPaint.setColor(this.mDelegate.getCurDayLunarTextColor());
        this.mCurMonthTextPaint.setColor(this.mDelegate.getCurrentMonthTextColor());
        this.mOtherMonthTextPaint.setColor(this.mDelegate.getOtherMonthTextColor());
        this.mCurMonthLunarTextPaint.setColor(this.mDelegate.getCurrentMonthLunarTextColor());
        this.mSelectedLunarTextPaint.setColor(this.mDelegate.getSelectedLunarTextColor());
        this.mSelectTextPaint.setColor(this.mDelegate.getSelectedTextColor());
        this.mOtherMonthLunarTextPaint.setColor(this.mDelegate.getOtherMonthLunarTextColor());
        this.mSchemeLunarTextPaint.setColor(this.mDelegate.getSchemeLunarTextColor());
        this.mSchemePaint.setColor(this.mDelegate.getSchemeThemeColor());
        this.mSchemeTextPaint.setColor(this.mDelegate.getSchemeTextColor());
        this.mCurMonthTextPaint.setTextSize(this.mDelegate.getDayTextSize());
        this.mOtherMonthTextPaint.setTextSize(this.mDelegate.getDayTextSize());
        this.mCurDayTextPaint.setTextSize(this.mDelegate.getDayTextSize());
        this.mSchemeTextPaint.setTextSize(this.mDelegate.getDayTextSize());
        this.mSelectTextPaint.setTextSize(this.mDelegate.getDayTextSize());
        this.mCurMonthLunarTextPaint.setTextSize(this.mDelegate.getLunarTextSize());
        this.mSelectedLunarTextPaint.setTextSize(this.mDelegate.getLunarTextSize());
        this.mCurDayLunarTextPaint.setTextSize(this.mDelegate.getLunarTextSize());
        this.mOtherMonthLunarTextPaint.setTextSize(this.mDelegate.getLunarTextSize());
        this.mSchemeLunarTextPaint.setTextSize(this.mDelegate.getLunarTextSize());
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setColor(this.mDelegate.getSelectedThemeColor());
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
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
        this.isClick = true;
        this.mCurrentItem = -1;
        initPaint(context);
    }
}
