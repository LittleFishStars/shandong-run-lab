package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.calendar.MonthViewPager;
import com.huachenjie.base.widget.calendar.WeekViewPager;
import com.huachenjie.base.widget.calendar.YearViewPager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class CvLayoutCalendarViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f6984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MonthViewPager f6985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WeekViewPager f6986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final YearViewPager f6987a;

    @NonNull
    public final View b;

    public CvLayoutCalendarViewBinding(@NonNull View rootView, @NonNull FrameLayout frameContent, @NonNull View line, @NonNull YearViewPager selectLayout, @NonNull MonthViewPager vpMonth, @NonNull WeekViewPager vpWeek) {
        this.f32812a = rootView;
        this.f6984a = frameContent;
        this.b = line;
        this.f6987a = selectLayout;
        this.f6985a = vpMonth;
        this.f6986a = vpWeek;
    }

    @NonNull
    public static CvLayoutCalendarViewBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.frameContent;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.line))) != null) {
            i = R.id.selectLayout;
            YearViewPager yearViewPager = (YearViewPager) ViewBindings.findChildViewById(rootView, i);
            if (yearViewPager != null) {
                i = R.id.vp_month;
                MonthViewPager monthViewPager = (MonthViewPager) ViewBindings.findChildViewById(rootView, i);
                if (monthViewPager != null) {
                    i = R.id.vp_week;
                    WeekViewPager weekViewPager = (WeekViewPager) ViewBindings.findChildViewById(rootView, i);
                    if (weekViewPager != null) {
                        return new CvLayoutCalendarViewBinding(rootView, frameLayout, viewFindChildViewById, yearViewPager, monthViewPager, weekViewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static CvLayoutCalendarViewBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.cv_layout_calendar_view, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f32812a;
    }
}
