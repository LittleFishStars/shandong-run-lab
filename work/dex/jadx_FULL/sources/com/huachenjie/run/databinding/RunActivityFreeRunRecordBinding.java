package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunActivityFreeRunRecordBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f11486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TabLayout f11487a;

    public RunActivityFreeRunRecordBinding(@NonNull LinearLayout rootView, @NonNull TabLayout tabRecordList, @NonNull ViewPager viewpagerRecordList) {
        this.f35469a = rootView;
        this.f11487a = tabRecordList;
        this.f11486a = viewpagerRecordList;
    }

    @NonNull
    public static RunActivityFreeRunRecordBinding a(@NonNull View rootView) {
        int i = R.id.tab_record_list;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, i);
        if (tabLayout != null) {
            i = R.id.viewpager_record_list;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, i);
            if (viewPager != null) {
                return new RunActivityFreeRunRecordBinding((LinearLayout) rootView, tabLayout, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunActivityFreeRunRecordBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunActivityFreeRunRecordBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_activity_free_run_record, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f35469a;
    }
}
