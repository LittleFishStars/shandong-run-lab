package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemExamInfoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public Float f36503a;

    @Bindable
    public String f;

    @Bindable
    public String g;

    public ItemExamInfoBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemExamInfoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExamInfoBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemExamInfoBinding) ViewDataBinding.bind(obj, view, R.layout.item_exam_info);
    }

    @NonNull
    public static ItemExamInfoBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExamInfoBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExamInfoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemExamInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_info, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExamInfoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExamInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_info, null, false, obj);
    }

    @Nullable
    public Float f() {
        return this.f36503a;
    }

    @Nullable
    public String getContent() {
        return this.g;
    }

    @Nullable
    public String getTitle() {
        return this.f;
    }

    public abstract void k(@Nullable Float f);

    public abstract void l(@Nullable String str);

    public abstract void setContent(@Nullable String str);
}
