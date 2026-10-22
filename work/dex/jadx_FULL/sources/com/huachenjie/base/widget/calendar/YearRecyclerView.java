package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class YearRecyclerView extends RecyclerView {
    private YearViewAdapter mAdapter;
    private CalendarViewDelegate mDelegate;
    private OnMonthSelectedListener mListener;

    public interface OnMonthSelectedListener {
        void onMonthSelected(int year, int month);
    }

    public YearRecyclerView(Context context) {
        this(context, null);
    }

    public final void init(int year) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        for (int i = 1; i <= 12; i++) {
            calendar.set(year, i - 1, 1);
            int monthDaysCount = CalendarUtil.getMonthDaysCount(year, i);
            Month month = new Month();
            month.setDiff(CalendarUtil.getMonthViewStartDiff(year, i, this.mDelegate.getWeekStart()));
            month.setCount(monthDaysCount);
            month.setMonth(i);
            month.setYear(year);
            this.mAdapter.addItem(month);
        }
    }

    public void notifyAdapterDataSetChanged() {
        if (getAdapter() == null) {
            return;
        }
        getAdapter().notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        int size = View.MeasureSpec.getSize(heightSpec);
        this.mAdapter.setYearViewSize(View.MeasureSpec.getSize(widthSpec) / 3, size / 4);
    }

    public final void setOnMonthSelectedListener(OnMonthSelectedListener listener) {
        this.mListener = listener;
    }

    public final void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        this.mAdapter.setup(delegate);
    }

    public final void updateStyle() {
        for (int i = 0; i < getChildCount(); i++) {
            YearView yearView = (YearView) getChildAt(i);
            yearView.updateStyle();
            yearView.invalidate();
        }
    }

    public final void updateWeekStart() {
        for (Month month : this.mAdapter.getItems()) {
            month.setDiff(CalendarUtil.getMonthViewStartDiff(month.getYear(), month.getMonth(), this.mDelegate.getWeekStart()));
        }
    }

    public YearRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mAdapter = new YearViewAdapter(context);
        setLayoutManager(new GridLayoutManager(context, 3));
        setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() { // from class: com.huachenjie.base.widget.calendar.YearRecyclerView.1
            @Override // com.huachenjie.base.widget.calendar.BaseRecyclerAdapter.OnItemClickListener
            public void onItemClick(int position, long itemId) {
                Month item;
                if (YearRecyclerView.this.mListener == null || YearRecyclerView.this.mDelegate == null || (item = YearRecyclerView.this.mAdapter.getItem(position)) == null || !CalendarUtil.isMonthInRange(item.getYear(), item.getMonth(), YearRecyclerView.this.mDelegate.getMinYear(), YearRecyclerView.this.mDelegate.getMinYearMonth(), YearRecyclerView.this.mDelegate.getMaxYear(), YearRecyclerView.this.mDelegate.getMaxYearMonth())) {
                    return;
                }
                YearRecyclerView.this.mListener.onMonthSelected(item.getYear(), item.getMonth());
                if (YearRecyclerView.this.mDelegate.mYearViewChangeListener != null) {
                    YearRecyclerView.this.mDelegate.mYearViewChangeListener.onYearViewChange(true);
                }
            }
        });
    }
}
