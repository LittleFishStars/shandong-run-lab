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
public final class WorksViewInputSelectUserMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RadioButton f37105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioGroup f14799a;

    @NonNull
    public final RadioButton b;

    public WorksViewInputSelectUserMenuBinding(@NonNull RadioGroup rootView, @NonNull RadioButton rbFollow, @NonNull RadioButton rbFriend) {
        this.f14799a = rootView;
        this.f37105a = rbFollow;
        this.b = rbFriend;
    }

    @NonNull
    public static WorksViewInputSelectUserMenuBinding a(@NonNull View rootView) {
        int i = R.id.rb_follow;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, i);
        if (radioButton != null) {
            i = R.id.rb_friend;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, i);
            if (radioButton2 != null) {
                return new WorksViewInputSelectUserMenuBinding((RadioGroup) rootView, radioButton, radioButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static WorksViewInputSelectUserMenuBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksViewInputSelectUserMenuBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_view_input_select_user_menu, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RadioGroup getRoot() {
        return this.f14799a;
    }
}
