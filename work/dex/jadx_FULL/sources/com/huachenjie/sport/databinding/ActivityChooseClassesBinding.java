package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CheckImageView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesActivity;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityChooseClassesBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckImageView f13160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseClassesActivity.a f13161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseClassesVM f13162a;

    public ActivityChooseClassesBinding(Object obj, View view, int i, CheckImageView checkImageView, FrameLayout frameLayout, ImageView imageView) {
        super(obj, view, i);
        this.f13160a = checkImageView;
        this.f36376a = frameLayout;
        this.f13159a = imageView;
    }

    public static ActivityChooseClassesBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChooseClassesBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityChooseClassesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_choose_classes);
    }

    @NonNull
    public static ActivityChooseClassesBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChooseClassesBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChooseClassesBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChooseClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_choose_classes, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityChooseClassesBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChooseClassesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_choose_classes, null, false, obj);
    }

    @Nullable
    public ChooseClassesActivity.a f() {
        return this.f13161a;
    }

    @Nullable
    public ChooseClassesVM g() {
        return this.f13162a;
    }

    public abstract void l(@Nullable ChooseClassesActivity.a aVar);

    public abstract void m(@Nullable ChooseClassesVM chooseClassesVM);
}
