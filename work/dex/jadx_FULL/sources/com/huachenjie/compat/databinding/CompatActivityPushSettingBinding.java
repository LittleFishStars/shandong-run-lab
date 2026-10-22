package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.settings.PushSettingViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class CompatActivityPushSettingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PushSettingViewModel f9181a;

    public CompatActivityPushSettingBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f34058a = imageView;
    }

    public static CompatActivityPushSettingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompatActivityPushSettingBinding d(@NonNull View view, @Nullable Object obj) {
        return (CompatActivityPushSettingBinding) ViewDataBinding.bind(obj, view, R.layout.compat_activity_push_setting);
    }

    @NonNull
    public static CompatActivityPushSettingBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CompatActivityPushSettingBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CompatActivityPushSettingBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CompatActivityPushSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_activity_push_setting, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CompatActivityPushSettingBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CompatActivityPushSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compat_activity_push_setting, null, false, obj);
    }

    @Nullable
    public PushSettingViewModel f() {
        return this.f9181a;
    }

    public abstract void k(@Nullable PushSettingViewModel pushSettingViewModel);
}
