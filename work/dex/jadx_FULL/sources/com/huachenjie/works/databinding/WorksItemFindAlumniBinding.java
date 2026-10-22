package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.SchoolMateBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemFindAlumniBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f37029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SchoolMateBean f14567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14568a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f14569b;

    @NonNull
    public final BLTextView c;

    @NonNull
    public final BLTextView d;

    public WorksItemFindAlumniBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivAvatar, TextView tvGrade, BLTextView tvGreet, TextView tvName, BLTextView tvTag1, BLTextView tvTag2, BLTextView tvTag3, View vLine) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14565a = ivAvatar;
        this.f14566a = tvGrade;
        this.f14568a = tvGreet;
        this.b = tvName;
        this.f14569b = tvTag1;
        this.c = tvTag2;
        this.d = tvTag3;
        this.f37029a = vLine;
    }

    public static WorksItemFindAlumniBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemFindAlumniBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemFindAlumniBinding) ViewDataBinding.bind(component, view, R.layout.works_item_find_alumni);
    }

    @NonNull
    public static WorksItemFindAlumniBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemFindAlumniBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemFindAlumniBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemFindAlumniBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_find_alumni, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemFindAlumniBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemFindAlumniBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_find_alumni, null, false, component);
    }

    @Nullable
    public SchoolMateBean f() {
        return this.f14567a;
    }

    public abstract void k(@Nullable SchoolMateBean bean);
}
