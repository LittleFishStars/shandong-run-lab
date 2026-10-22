package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class YearViewAdapter extends BaseRecyclerAdapter<Month> {
    private CalendarViewDelegate mDelegate;
    private int mItemHeight;
    private int mItemWidth;

    public static class YearViewHolder extends RecyclerView.ViewHolder {
        YearView mYearView;

        public YearViewHolder(View itemView, CalendarViewDelegate delegate) {
            super(itemView);
            YearView yearView = (YearView) itemView;
            this.mYearView = yearView;
            yearView.setup(delegate);
        }
    }

    public YearViewAdapter(Context context) {
        super(context);
    }

    @Override // com.huachenjie.base.widget.calendar.BaseRecyclerAdapter
    public RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        View defaultYearView;
        if (TextUtils.isEmpty(this.mDelegate.getYearViewClassPath())) {
            defaultYearView = new DefaultYearView(this.mContext);
        } else {
            try {
                defaultYearView = (YearView) this.mDelegate.getYearViewClass().getConstructor(Context.class).newInstance(this.mContext);
            } catch (Exception e) {
                e.printStackTrace();
                defaultYearView = new DefaultYearView(this.mContext);
            }
        }
        defaultYearView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        return new YearViewHolder(defaultYearView, this.mDelegate);
    }

    public final void setYearViewSize(int width, int height) {
        this.mItemWidth = width;
        this.mItemHeight = height;
    }

    public final void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
    }

    @Override // com.huachenjie.base.widget.calendar.BaseRecyclerAdapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, Month item, int position) {
        YearView yearView = ((YearViewHolder) holder).mYearView;
        yearView.init(item.getYear(), item.getMonth());
        yearView.measureSize(this.mItemWidth, this.mItemHeight);
    }
}
