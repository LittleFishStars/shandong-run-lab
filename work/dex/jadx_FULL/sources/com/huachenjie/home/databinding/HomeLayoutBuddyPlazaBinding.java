package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.widget.BuddyScopeTabWidget;
import com.huachenjie.home.widget.WrapContentHeightViewPager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class HomeLayoutBuddyPlazaBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f34298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f9558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BuddyScopeTabWidget f9559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WrapContentHeightViewPager f9560a;

    @NonNull
    public final LinearLayout b;

    public HomeLayoutBuddyPlazaBinding(@NonNull LinearLayout linearLayout, @NonNull BuddyScopeTabWidget buddyScopeTabWidget, @NonNull LinearLayout linearLayout2, @NonNull SlidingTabLayout slidingTabLayout, @NonNull TextView textView, @NonNull WrapContentHeightViewPager wrapContentHeightViewPager) {
        this.f34298a = linearLayout;
        this.f9559a = buddyScopeTabWidget;
        this.b = linearLayout2;
        this.f9558a = slidingTabLayout;
        this.f9557a = textView;
        this.f9560a = wrapContentHeightViewPager;
    }

    @NonNull
    public static HomeLayoutBuddyPlazaBinding a(@NonNull View view) {
        int i = R.id.buddy_scope_tab;
        BuddyScopeTabWidget buddyScopeTabWidget = (BuddyScopeTabWidget) ViewBindings.findChildViewById(view, i);
        if (buddyScopeTabWidget != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.rv_buddy_type;
            SlidingTabLayout slidingTabLayout = (SlidingTabLayout) ViewBindings.findChildViewById(view, i);
            if (slidingTabLayout != null) {
                i = R.id.tv_buddy_more;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.vp_buddy_card;
                    WrapContentHeightViewPager wrapContentHeightViewPager = (WrapContentHeightViewPager) ViewBindings.findChildViewById(view, i);
                    if (wrapContentHeightViewPager != null) {
                        return new HomeLayoutBuddyPlazaBinding(linearLayout, buddyScopeTabWidget, linearLayout, slidingTabLayout, textView, wrapContentHeightViewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static HomeLayoutBuddyPlazaBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static HomeLayoutBuddyPlazaBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.home_layout_buddy_plaza, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f34298a;
    }
}
