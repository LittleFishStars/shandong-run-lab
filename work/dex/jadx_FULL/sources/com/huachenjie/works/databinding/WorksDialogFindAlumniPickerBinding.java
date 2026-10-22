package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.MaxHeightRecyclerView;
import com.huachenjie.works.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class WorksDialogFindAlumniPickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MaxHeightRecyclerView f14086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14087a;

    public WorksDialogFindAlumniPickerBinding(@NonNull LinearLayout rootView, @NonNull MaxHeightRecyclerView recyclerView, @NonNull BLTextView tvConfirm, @NonNull View vBottom) {
        this.f14085a = rootView;
        this.f14086a = recyclerView;
        this.f14087a = tvConfirm;
        this.f36867a = vBottom;
    }

    @NonNull
    public static WorksDialogFindAlumniPickerBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        View viewFindChildViewById;
        int i = R.id.recycler_view;
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) ViewBindings.findChildViewById(rootView, i);
        if (maxHeightRecyclerView == null || (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tv_confirm))) == null || (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.v_bottom))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new WorksDialogFindAlumniPickerBinding((LinearLayout) rootView, maxHeightRecyclerView, bLTextViewFindChildViewById, viewFindChildViewById);
    }

    @NonNull
    public static WorksDialogFindAlumniPickerBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksDialogFindAlumniPickerBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_dialog_find_alumni_picker, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f14085a;
    }
}
