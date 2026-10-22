package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.ShadowLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutGpsSignalBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f8669a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f8670b;

    @NonNull
    public final View c;

    public LayoutGpsSignalBinding(@NonNull ShadowLayout rootView, @NonNull ShadowLayout slGpsSignal, @NonNull View viewSignal1, @NonNull View viewSignal2, @NonNull View viewSignal3) {
        this.f8669a = rootView;
        this.f8670b = slGpsSignal;
        this.f33774a = viewSignal1;
        this.b = viewSignal2;
        this.c = viewSignal3;
    }

    @NonNull
    public static LayoutGpsSignalBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        ShadowLayout shadowLayout = (ShadowLayout) rootView;
        int i = R.id.view_signal_1;
        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, i);
        if (viewFindChildViewById3 == null || (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_signal_2))) == null || (viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.view_signal_3))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new LayoutGpsSignalBinding(shadowLayout, shadowLayout, viewFindChildViewById3, viewFindChildViewById, viewFindChildViewById2);
    }

    @NonNull
    public static LayoutGpsSignalBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutGpsSignalBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_gps_signal, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShadowLayout getRoot() {
        return this.f8669a;
    }
}
