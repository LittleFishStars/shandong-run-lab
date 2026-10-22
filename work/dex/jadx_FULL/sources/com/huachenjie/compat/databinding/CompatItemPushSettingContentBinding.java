package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.bean.NotifySubConfig;
import com.huachenjie.compat.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class CompatItemPushSettingContentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifySubConfig f9197a;

    public CompatItemPushSettingContentBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f34064a = textView;
    }

    public static CompatItemPushSettingContentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompatItemPushSettingContentBinding d(@NonNull View view, @Nullable Object obj) {
        return (CompatItemPushSettingContentBinding) ViewDataBinding.bind(obj, view, R.layout.compat_item_push_setting_content);
    }

    @NonNull
    public static CompatItemPushSettingContentBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CompatItemPushSettingContentBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CompatItemPushSettingContentBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CompatItemPushSettingContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_item_push_setting_content, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CompatItemPushSettingContentBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CompatItemPushSettingContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_item_push_setting_content, null, false, obj);
    }

    @Nullable
    public NotifySubConfig f() {
        return this.f9197a;
    }

    public abstract void k(@Nullable NotifySubConfig notifySubConfig);
}
