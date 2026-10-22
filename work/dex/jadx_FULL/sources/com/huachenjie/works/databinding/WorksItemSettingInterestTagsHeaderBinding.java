package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.InterestTag;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemSettingInterestTagsHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public InterestTag f37073a;

    public WorksItemSettingInterestTagsHeaderBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemSettingInterestTagsHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemSettingInterestTagsHeaderBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemSettingInterestTagsHeaderBinding) ViewDataBinding.bind(component, view, R.layout.works_item_setting_interest_tags_header);
    }

    @NonNull
    public static WorksItemSettingInterestTagsHeaderBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemSettingInterestTagsHeaderBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemSettingInterestTagsHeaderBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemSettingInterestTagsHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_setting_interest_tags_header, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemSettingInterestTagsHeaderBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemSettingInterestTagsHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_setting_interest_tags_header, null, false, component);
    }

    @Nullable
    public InterestTag f() {
        return this.f37073a;
    }

    public abstract void k(@Nullable InterestTag bean);
}
