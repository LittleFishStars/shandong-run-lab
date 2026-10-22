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
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.publish.PublishWorkActivity;
import com.huachenjie.works.page.publish.PublishWorkViewModel;
import com.huachenjie.works.widget.PubWorkContentEditView;
import com.huachenjie.works.widget.select_media.SelectGridMediaView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityPulishWorkBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f13911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishWorkActivity.ClickProxy f13912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishWorkViewModel f13913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PubWorkContentEditView f13914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectGridMediaView f13915a;

    public WorksActivityPulishWorkBinding(Object _bindingComponent, View _root, int _localFieldCount, PubWorkContentEditView etContent, RecyclerView recyclerView, SelectBoldTabLayout tabLayout, SelectGridMediaView viewSelectMedia) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13914a = etContent;
        this.f36795a = recyclerView;
        this.f13911a = tabLayout;
        this.f13915a = viewSelectMedia;
    }

    public static WorksActivityPulishWorkBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityPulishWorkBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityPulishWorkBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_pulish_work);
    }

    @NonNull
    public static WorksActivityPulishWorkBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityPulishWorkBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityPulishWorkBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityPulishWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_pulish_work, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityPulishWorkBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityPulishWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_pulish_work, null, false, component);
    }

    @Nullable
    public PublishWorkActivity.ClickProxy f() {
        return this.f13912a;
    }

    @Nullable
    public PublishWorkViewModel g() {
        return this.f13913a;
    }

    public abstract void l(@Nullable PublishWorkActivity.ClickProxy click);

    public abstract void m(@Nullable PublishWorkViewModel vm);
}
