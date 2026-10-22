package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.buddy.BuddyApplyDialog;
import com.huachenjie.works.page.buddy.BuddyApplyVM;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogBuddyApplyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f14013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final HorizontalScrollView f14014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14015a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuddyApplyDialog.a f14018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuddyApplyVM f14019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14020a;

    @NonNull
    public final TextView b;

    public WorksDialogBuddyApplyBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText etApplyMessage, HorizontalScrollView hsvBuddyTags, AvatarView ivCreatorAvatar, LinearLayout llBuddyTags, BLLinearLayout llContent, TextView tvBuddyTitle, TextView tvMessageCount, View vKeyboard) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14013a = etApplyMessage;
        this.f14014a = hsvBuddyTags;
        this.f14017a = ivCreatorAvatar;
        this.f14015a = llBuddyTags;
        this.f14020a = llContent;
        this.f14016a = tvBuddyTitle;
        this.b = tvMessageCount;
        this.f36837a = vKeyboard;
    }

    public static WorksDialogBuddyApplyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogBuddyApplyBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogBuddyApplyBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_buddy_apply);
    }

    @NonNull
    public static WorksDialogBuddyApplyBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogBuddyApplyBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogBuddyApplyBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogBuddyApplyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_buddy_apply, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogBuddyApplyBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogBuddyApplyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_buddy_apply, null, false, component);
    }

    @Nullable
    public BuddyApplyDialog.a f() {
        return this.f14018a;
    }

    @Nullable
    public BuddyApplyVM g() {
        return this.f14019a;
    }

    public abstract void l(@Nullable BuddyApplyDialog.a click);

    public abstract void m(@Nullable BuddyApplyVM vm);
}
