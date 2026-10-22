package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.suit.UserWearSuitListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentUserWearSuitListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserWearSuitListVM f12935a;

    public FragmentUserWearSuitListBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f36169a = recyclerView;
    }

    public static FragmentUserWearSuitListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUserWearSuitListBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentUserWearSuitListBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_user_wear_suit_list);
    }

    @NonNull
    public static FragmentUserWearSuitListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentUserWearSuitListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentUserWearSuitListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentUserWearSuitListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_wear_suit_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentUserWearSuitListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentUserWearSuitListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_wear_suit_list, null, false, obj);
    }

    @Nullable
    public UserWearSuitListVM f() {
        return this.f12935a;
    }

    public abstract void k(@Nullable UserWearSuitListVM userWearSuitListVM);
}
