package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.mall.R;
import com.noober.background.view.BLConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class MallPopubHomeFilterBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Flow f35075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11013a;

    public MallPopubHomeFilterBinding(@NonNull ConstraintLayout constraintLayout, @NonNull BLConstraintLayout bLConstraintLayout, @NonNull Flow flow) {
        this.f11012a = constraintLayout;
        this.f11013a = bLConstraintLayout;
        this.f35075a = flow;
    }

    @NonNull
    public static MallPopubHomeFilterBinding a(@NonNull View view) {
        int i = R.id.constraintLayout;
        BLConstraintLayout bLConstraintLayoutFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLConstraintLayoutFindChildViewById != null) {
            i = R.id.flowLevel;
            Flow flow = (Flow) ViewBindings.findChildViewById(view, i);
            if (flow != null) {
                return new MallPopubHomeFilterBinding((ConstraintLayout) view, bLConstraintLayoutFindChildViewById, flow);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static MallPopubHomeFilterBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static MallPopubHomeFilterBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mall_popub_home_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f11012a;
    }
}
