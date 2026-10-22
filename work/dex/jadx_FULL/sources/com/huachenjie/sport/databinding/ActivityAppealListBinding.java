package com.huachenjie.sport.databinding;

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
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class ActivityAppealListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f36350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f13090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TabLayout f13091a;

    public ActivityAppealListBinding(@NonNull LinearLayout linearLayout, @NonNull TabLayout tabLayout, @NonNull ViewPager viewPager) {
        this.f36350a = linearLayout;
        this.f13091a = tabLayout;
        this.f13090a = viewPager;
    }

    @NonNull
    public static ActivityAppealListBinding a(@NonNull View view) {
        int i = R.id.tab_appeal_list;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
        if (tabLayout != null) {
            i = R.id.viewpager_appeal_list;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i);
            if (viewPager != null) {
                return new ActivityAppealListBinding((LinearLayout) view, tabLayout, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityAppealListBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAppealListBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_appeal_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f36350a;
    }
}
