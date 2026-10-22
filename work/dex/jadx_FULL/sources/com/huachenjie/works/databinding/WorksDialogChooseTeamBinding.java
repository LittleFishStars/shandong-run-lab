package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.share.choose_team.ChooseTeamDialog;
import com.huachenjie.works.page.share.choose_team.ChooseTeamVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogChooseTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseTeamDialog.a f14036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseTeamVM f14037a;

    public WorksDialogChooseTeamBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14035a = recyclerView;
        this.f36844a = tvTitle;
    }

    public static WorksDialogChooseTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogChooseTeamBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogChooseTeamBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_choose_team);
    }

    @NonNull
    public static WorksDialogChooseTeamBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogChooseTeamBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogChooseTeamBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogChooseTeamBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_choose_team, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogChooseTeamBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogChooseTeamBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_choose_team, null, false, component);
    }

    @Nullable
    public ChooseTeamDialog.a f() {
        return this.f14036a;
    }

    @Nullable
    public ChooseTeamVM g() {
        return this.f14037a;
    }

    public abstract void l(@Nullable ChooseTeamDialog.a click);

    public abstract void m(@Nullable ChooseTeamVM vm);
}
