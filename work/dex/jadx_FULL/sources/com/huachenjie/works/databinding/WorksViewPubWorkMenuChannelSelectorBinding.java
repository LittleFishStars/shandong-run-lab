package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.works.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class WorksViewPubWorkMenuChannelSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RadioButton f37112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioGroup f14815a;

    @NonNull
    public final RadioButton b;

    public WorksViewPubWorkMenuChannelSelectorBinding(@NonNull RadioGroup rootView, @NonNull RadioButton rbHot, @NonNull RadioButton rbJoin) {
        this.f14815a = rootView;
        this.f37112a = rbHot;
        this.b = rbJoin;
    }

    @NonNull
    public static WorksViewPubWorkMenuChannelSelectorBinding a(@NonNull View rootView) {
        int i = R.id.rb_hot;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, i);
        if (radioButton != null) {
            i = R.id.rb_join;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
            if (radioButton2 != null) {
                return new WorksViewPubWorkMenuChannelSelectorBinding((RadioGroup) rootView, radioButton, radioButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static WorksViewPubWorkMenuChannelSelectorBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksViewPubWorkMenuChannelSelectorBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_view_pub_work_menu_channel_selector, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RadioGroup getRoot() {
        return this.f14815a;
    }
}
