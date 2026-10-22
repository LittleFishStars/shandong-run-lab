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
import com.huachenjie.works.bean.ChatTeamHeaderBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemChooseTeamHeadreBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ChatTeamHeaderBean f37015a;

    public WorksItemChooseTeamHeadreBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemChooseTeamHeadreBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemChooseTeamHeadreBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemChooseTeamHeadreBinding) ViewDataBinding.bind(component, view, R.layout.works_item_choose_team_headre);
    }

    @NonNull
    public static WorksItemChooseTeamHeadreBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemChooseTeamHeadreBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemChooseTeamHeadreBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemChooseTeamHeadreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_choose_team_headre, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemChooseTeamHeadreBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemChooseTeamHeadreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_choose_team_headre, null, false, component);
    }

    @Nullable
    public ChatTeamHeaderBean f() {
        return this.f37015a;
    }

    public abstract void k(@Nullable ChatTeamHeaderBean bean);
}
