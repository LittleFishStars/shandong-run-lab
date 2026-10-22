package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.bean.NotifyConfig;
import com.huachenjie.compat.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class CompatItemPushSettingTitleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public NotifyConfig f34067a;

    public CompatItemPushSettingTitleBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CompatItemPushSettingTitleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompatItemPushSettingTitleBinding d(@NonNull View view, @Nullable Object obj) {
        return (CompatItemPushSettingTitleBinding) ViewDataBinding.bind(obj, view, R.layout.compat_item_push_setting_title);
    }

    @NonNull
    public static CompatItemPushSettingTitleBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CompatItemPushSettingTitleBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CompatItemPushSettingTitleBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CompatItemPushSettingTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_item_push_setting_title, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CompatItemPushSettingTitleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CompatItemPushSettingTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_item_push_setting_title, null, false, obj);
    }

    @Nullable
    public NotifyConfig f() {
        return this.f34067a;
    }

    public abstract void k(@Nullable NotifyConfig notifyConfig);
}
