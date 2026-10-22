package com.huachenjie.shandong_school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.splash.PrivacyActivity;
import com.noober.background.view.BLButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class ActivityPrivacyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PrivacyActivity.a f12632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f12633a;

    @NonNull
    public final BLButton b;

    public ActivityPrivacyBinding(Object obj, View view, int i, BLButton bLButton, BLButton bLButton2, TextView textView) {
        super(obj, view, i);
        this.f12633a = bLButton;
        this.b = bLButton2;
        this.f36021a = textView;
    }

    public static ActivityPrivacyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPrivacyBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityPrivacyBinding) ViewDataBinding.bind(obj, view, R.layout.activity_privacy);
    }

    @NonNull
    public static ActivityPrivacyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityPrivacyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPrivacyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPrivacyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_privacy, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityPrivacyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPrivacyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_privacy, null, false, obj);
    }

    @Nullable
    public PrivacyActivity.a f() {
        return this.f12632a;
    }

    public abstract void k(@Nullable PrivacyActivity.a aVar);
}
