package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.noober.background.view.BLFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkItemBean f14739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f14740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f14741a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14742b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f14743c;

    @NonNull
    public final TextView d;

    public WorksItemWorksBinding(Object _bindingComponent, View _root, int _localFieldCount, BLFrameLayout flImageContainer, FrameLayout flLevel, AvatarView ivAvatar, ImageView ivHot, ImageView ivImage, ImageView ivVideoIcon, TextView tvHot, TextView tvMineRelation, TextView tvTag, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14740a = flImageContainer;
        this.f37085a = flLevel;
        this.f14738a = ivAvatar;
        this.f14736a = ivHot;
        this.b = ivImage;
        this.c = ivVideoIcon;
        this.f14737a = tvHot;
        this.f14742b = tvMineRelation;
        this.f14743c = tvTag;
        this.d = tvTitle;
    }

    public static WorksItemWorksBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works);
    }

    @NonNull
    public static WorksItemWorksBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works, null, false, component);
    }

    @Nullable
    public Boolean f() {
        return this.f14741a;
    }

    @Nullable
    public WorkItemBean g() {
        return this.f14739a;
    }

    public abstract void l(@Nullable Boolean showRelation);

    public abstract void m(@Nullable WorkItemBean vm);
}
