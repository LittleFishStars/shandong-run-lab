package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.home.R;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class HomeLayoutBuddyCardEmptyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f9555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9556a;

    @NonNull
    public final TextView b;

    public HomeLayoutBuddyCardEmptyBinding(@NonNull BLConstraintLayout bLConstraintLayout, @NonNull BLTextView bLTextView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f9555a = bLConstraintLayout;
        this.f9556a = bLTextView;
        this.f34297a = imageView;
        this.f9554a = textView;
        this.b = textView2;
    }

    @NonNull
    public static HomeLayoutBuddyCardEmptyBinding a(@NonNull View view) {
        int i = R.id.bt_buddy_empty;
        BLTextView bLTextViewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLTextViewFindChildViewById != null) {
            i = R.id.iv_buddy_empty;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tv_buddy_empty_subtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_buddy_empty_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new HomeLayoutBuddyCardEmptyBinding((BLConstraintLayout) view, bLTextViewFindChildViewById, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static HomeLayoutBuddyCardEmptyBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static HomeLayoutBuddyCardEmptyBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.home_layout_buddy_card_empty, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f9555a;
    }
}
