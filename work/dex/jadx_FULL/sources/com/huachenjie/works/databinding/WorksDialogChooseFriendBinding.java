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
import com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog;
import com.huachenjie.works.page.share.choose_friend.ChooseFriendVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogChooseFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseFriendDialog.a f14028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseFriendVM f14029a;

    public WorksDialogChooseFriendBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14027a = recyclerView;
        this.f36841a = tvTitle;
    }

    public static WorksDialogChooseFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogChooseFriendBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogChooseFriendBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_choose_friend);
    }

    @NonNull
    public static WorksDialogChooseFriendBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogChooseFriendBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogChooseFriendBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogChooseFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_choose_friend, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogChooseFriendBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogChooseFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_choose_friend, null, false, component);
    }

    @Nullable
    public ChooseFriendDialog.a f() {
        return this.f14028a;
    }

    @Nullable
    public ChooseFriendVM g() {
        return this.f14029a;
    }

    public abstract void l(@Nullable ChooseFriendDialog.a click);

    public abstract void m(@Nullable ChooseFriendVM vm);
}
