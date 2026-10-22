package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.suit.UserWearIPVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentUserWearIpBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public UserWearIPVM f36165a;

    public FragmentUserWearIpBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static FragmentUserWearIpBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUserWearIpBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentUserWearIpBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_user_wear_ip);
    }

    @NonNull
    public static FragmentUserWearIpBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentUserWearIpBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentUserWearIpBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentUserWearIpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_wear_ip, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentUserWearIpBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentUserWearIpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_wear_ip, null, false, obj);
    }

    @Nullable
    public UserWearIPVM f() {
        return this.f36165a;
    }

    public abstract void k(@Nullable UserWearIPVM userWearIPVM);
}
