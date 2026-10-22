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
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.works.R;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogAddFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserInfoBean f13962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f13963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f13964a;

    @NonNull
    public final BLButton b;

    public WorksDialogAddFriendBinding(Object _bindingComponent, View _root, int _localFieldCount, BLButton btApply, BLButton btCancel, BLEditText etContent, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13963a = btApply;
        this.b = btCancel;
        this.f13964a = etContent;
        this.f36815a = tvName;
    }

    public static WorksDialogAddFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogAddFriendBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogAddFriendBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_add_friend);
    }

    @NonNull
    public static WorksDialogAddFriendBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogAddFriendBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogAddFriendBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogAddFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_add_friend, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogAddFriendBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogAddFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_add_friend, null, false, component);
    }

    @Nullable
    public UserInfoBean f() {
        return this.f13962a;
    }

    public abstract void k(@Nullable UserInfoBean bean);
}
