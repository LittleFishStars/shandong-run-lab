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
import com.huachenjie.works.bean.ChatTeamBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemChooseTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ChatTeamBean f37013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14510a;

    public WorksItemChooseTeamBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView tvShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14510a = tvShare;
    }

    public static WorksItemChooseTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemChooseTeamBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemChooseTeamBinding) ViewDataBinding.bind(component, view, R.layout.works_item_choose_team);
    }

    @NonNull
    public static WorksItemChooseTeamBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemChooseTeamBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemChooseTeamBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemChooseTeamBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_choose_team, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemChooseTeamBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemChooseTeamBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_choose_team, null, false, component);
    }

    @Nullable
    public ChatTeamBean f() {
        return this.f37013a;
    }

    public abstract void k(@Nullable ChatTeamBean bean);
}
