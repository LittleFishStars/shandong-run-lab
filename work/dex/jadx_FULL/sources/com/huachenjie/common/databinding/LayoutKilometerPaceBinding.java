package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutKilometerPaceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f33776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f8674a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public LayoutKilometerPaceBinding(@NonNull LinearLayout rootView, @NonNull BLLinearLayout llPaceBar, @NonNull TextView tvFastestPaceTag, @NonNull TextView tvKilometerNum, @NonNull TextView tvPace) {
        this.f33776a = rootView;
        this.f8674a = llPaceBar;
        this.f8673a = tvFastestPaceTag;
        this.b = tvKilometerNum;
        this.c = tvPace;
    }

    @NonNull
    public static LayoutKilometerPaceBinding a(@NonNull View rootView) {
        int i = R.id.ll_pace_bar;
        BLLinearLayout bLLinearLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (bLLinearLayoutFindChildViewById != null) {
            i = R.id.tv_fastest_pace_tag;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_kilometer_num;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tv_pace;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        return new LayoutKilometerPaceBinding((LinearLayout) rootView, bLLinearLayoutFindChildViewById, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutKilometerPaceBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutKilometerPaceBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_kilometer_pace, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f33776a;
    }
}
