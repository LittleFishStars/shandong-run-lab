package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.works.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class WorksItemBuddyApplyTagBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLTextView f37008a;

    public WorksItemBuddyApplyTagBinding(@NonNull BLTextView rootView) {
        this.f37008a = rootView;
    }

    @NonNull
    public static WorksItemBuddyApplyTagBinding a(@NonNull View rootView) {
        if (rootView != null) {
            return new WorksItemBuddyApplyTagBinding((BLTextView) rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static WorksItemBuddyApplyTagBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksItemBuddyApplyTagBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_item_buddy_apply_tag, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLTextView getRoot() {
        return this.f37008a;
    }
}
