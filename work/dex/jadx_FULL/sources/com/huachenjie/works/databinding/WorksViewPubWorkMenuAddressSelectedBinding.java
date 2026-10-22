package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.works.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class WorksViewPubWorkMenuAddressSelectedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f37110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f14812a;

    public WorksViewPubWorkMenuAddressSelectedBinding(@NonNull LinearLayout rootView, @NonNull DrawableCenterButton btClear, @NonNull TextView tvSelected) {
        this.f37110a = rootView;
        this.f14812a = btClear;
        this.f14811a = tvSelected;
    }

    @NonNull
    public static WorksViewPubWorkMenuAddressSelectedBinding a(@NonNull View rootView) {
        int i = R.id.bt_clear;
        DrawableCenterButton drawableCenterButton = (DrawableCenterButton) ViewBindings.findChildViewById(rootView, i);
        if (drawableCenterButton != null) {
            i = R.id.tv_selected;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new WorksViewPubWorkMenuAddressSelectedBinding((LinearLayout) rootView, drawableCenterButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static WorksViewPubWorkMenuAddressSelectedBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksViewPubWorkMenuAddressSelectedBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_view_pub_work_menu_address_selected, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f37110a;
    }
}
