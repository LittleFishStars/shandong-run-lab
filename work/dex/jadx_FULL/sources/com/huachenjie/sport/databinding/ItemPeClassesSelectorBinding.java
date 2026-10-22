package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class ItemPeClassesSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckTextView f36521a;

    @NonNull
    public final CheckTextView b;

    public ItemPeClassesSelectorBinding(@NonNull CheckTextView checkTextView, @NonNull CheckTextView checkTextView2) {
        this.f36521a = checkTextView;
        this.b = checkTextView2;
    }

    @NonNull
    public static ItemPeClassesSelectorBinding a(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        CheckTextView checkTextView = (CheckTextView) view;
        return new ItemPeClassesSelectorBinding(checkTextView, checkTextView);
    }

    @NonNull
    public static ItemPeClassesSelectorBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemPeClassesSelectorBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_pe_classes_selector, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CheckTextView getRoot() {
        return this.f36521a;
    }
}
