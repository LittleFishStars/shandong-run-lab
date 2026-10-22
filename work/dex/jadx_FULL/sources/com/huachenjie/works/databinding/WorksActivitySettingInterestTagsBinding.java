package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsActivity;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivitySettingInterestTagsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f13946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f13947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SettingInterestTagsActivity.a f13948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SettingInterestTagsVM f13949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13950a;

    public WorksActivitySettingInterestTagsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, ShadowLayout slBottom, LayoutToolbarBindingBinding toolBar, BLTextView tvTips) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36808a = recyclerView;
        this.f13947a = slBottom;
        this.f13946a = toolBar;
        this.f13950a = tvTips;
    }

    public static WorksActivitySettingInterestTagsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivitySettingInterestTagsBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivitySettingInterestTagsBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_setting_interest_tags);
    }

    @NonNull
    public static WorksActivitySettingInterestTagsBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivitySettingInterestTagsBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivitySettingInterestTagsBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivitySettingInterestTagsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_setting_interest_tags, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivitySettingInterestTagsBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivitySettingInterestTagsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_setting_interest_tags, null, false, component);
    }

    @Nullable
    public SettingInterestTagsActivity.a f() {
        return this.f13948a;
    }

    @Nullable
    public SettingInterestTagsVM g() {
        return this.f13949a;
    }

    public abstract void l(@Nullable SettingInterestTagsActivity.a click);

    public abstract void m(@Nullable SettingInterestTagsVM vm);
}
