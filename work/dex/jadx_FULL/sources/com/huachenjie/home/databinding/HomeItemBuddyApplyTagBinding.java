package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.home.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class HomeItemBuddyApplyTagBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLTextView f34264a;

    public HomeItemBuddyApplyTagBinding(@NonNull BLTextView bLTextView) {
        this.f34264a = bLTextView;
    }

    @NonNull
    public static HomeItemBuddyApplyTagBinding a(@NonNull View view) {
        if (view != null) {
            return new HomeItemBuddyApplyTagBinding((BLTextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static HomeItemBuddyApplyTagBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static HomeItemBuddyApplyTagBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.home_item_buddy_apply_tag, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLTextView getRoot() {
        return this.f34264a;
    }
}
