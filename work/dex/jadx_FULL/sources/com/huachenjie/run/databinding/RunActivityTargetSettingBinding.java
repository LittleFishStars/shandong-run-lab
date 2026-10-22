package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunActivityTargetSettingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f11655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TabLayout f11656a;

    public RunActivityTargetSettingBinding(@NonNull FrameLayout rootView, @NonNull TabLayout tabTarget, @NonNull TextView tvStartRun, @NonNull ViewPager viewpagerTarget) {
        this.f35511a = rootView;
        this.f11656a = tabTarget;
        this.f11654a = tvStartRun;
        this.f11655a = viewpagerTarget;
    }

    @NonNull
    public static RunActivityTargetSettingBinding a(@NonNull View rootView) {
        int i = R.id.tab_target;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, i);
        if (tabLayout != null) {
            i = R.id.tv_start_run;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.viewpager_target;
                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, i);
                if (viewPager != null) {
                    return new RunActivityTargetSettingBinding((FrameLayout) rootView, tabLayout, textView, viewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunActivityTargetSettingBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunActivityTargetSettingBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_activity_target_setting, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f35511a;
    }
}
