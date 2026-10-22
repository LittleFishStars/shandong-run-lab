package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.PEClassesSearchActivity;
import com.huachenjie.sport.page.mine.choose_classes.PEClassesSearchVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityPeClassesSearchBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f13316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PEClassesSearchActivity.a f13318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PEClassesSearchVM f13319a;

    public ActivityPeClassesSearchBinding(Object obj, View view, int i, EditText editText, ImageView imageView, View view2) {
        super(obj, view, i);
        this.f13316a = editText;
        this.f13317a = imageView;
        this.f36420a = view2;
    }

    public static ActivityPeClassesSearchBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPeClassesSearchBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityPeClassesSearchBinding) ViewDataBinding.bind(obj, view, R.layout.activity_pe_classes_search);
    }

    @NonNull
    public static ActivityPeClassesSearchBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityPeClassesSearchBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPeClassesSearchBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPeClassesSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_pe_classes_search, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityPeClassesSearchBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPeClassesSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_pe_classes_search, null, false, obj);
    }

    @Nullable
    public PEClassesSearchActivity.a f() {
        return this.f13318a;
    }

    @Nullable
    public PEClassesSearchVM g() {
        return this.f13319a;
    }

    public abstract void l(@Nullable PEClassesSearchActivity.a aVar);

    public abstract void m(@Nullable PEClassesSearchVM pEClassesSearchVM);
}
