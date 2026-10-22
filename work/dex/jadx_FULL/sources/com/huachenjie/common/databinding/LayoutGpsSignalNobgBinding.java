package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutGpsSignalNobgBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8671a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8672b;

    @NonNull
    public final View c;

    public LayoutGpsSignalNobgBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout slGpsSignalNobg, @NonNull View viewSignal1Nobg, @NonNull View viewSignal2Nobg, @NonNull View viewSignal3Nobg) {
        this.f8671a = rootView;
        this.f8672b = slGpsSignalNobg;
        this.f33775a = viewSignal1Nobg;
        this.b = viewSignal2Nobg;
        this.c = viewSignal3Nobg;
    }

    @NonNull
    public static LayoutGpsSignalNobgBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.view_signal_1_nobg;
        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, i);
        if (viewFindChildViewById3 == null || (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_signal_2_nobg))) == null || (viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.view_signal_3_nobg))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
        }
        return new LayoutGpsSignalNobgBinding(linearLayout, linearLayout, viewFindChildViewById3, viewFindChildViewById, viewFindChildViewById2);
    }

    @NonNull
    public static LayoutGpsSignalNobgBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutGpsSignalNobgBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_gps_signal_nobg, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f8671a;
    }
}
