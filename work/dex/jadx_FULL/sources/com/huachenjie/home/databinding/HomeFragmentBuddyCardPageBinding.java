package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.home.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class HomeFragmentBuddyCardPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final HomeLayoutBuddyCardEmptyBinding f9398a;

    public HomeFragmentBuddyCardPageBinding(@NonNull FrameLayout frameLayout, @NonNull HomeLayoutBuddyCardEmptyBinding homeLayoutBuddyCardEmptyBinding, @NonNull RecyclerView recyclerView) {
        this.f34244a = frameLayout;
        this.f9398a = homeLayoutBuddyCardEmptyBinding;
        this.f9397a = recyclerView;
    }

    @NonNull
    public static HomeFragmentBuddyCardPageBinding a(@NonNull View view) {
        int i = R.id.layout_buddy_empty;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            HomeLayoutBuddyCardEmptyBinding homeLayoutBuddyCardEmptyBindingA = HomeLayoutBuddyCardEmptyBinding.a(viewFindChildViewById);
            int i2 = R.id.rv_buddy_card;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i2);
            if (recyclerView != null) {
                return new HomeFragmentBuddyCardPageBinding((FrameLayout) view, homeLayoutBuddyCardEmptyBindingA, recyclerView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static HomeFragmentBuddyCardPageBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static HomeFragmentBuddyCardPageBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.home_fragment_buddy_card_page, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f34244a;
    }
}
