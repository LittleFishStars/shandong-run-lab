package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.test.TestPlayActivity;
import com.huachenjie.mall.page.test.TestPlayVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityTestPlayBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AliVideoView f10456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TestPlayActivity.a f10457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TestPlayVM f10458a;

    @NonNull
    public final FrameLayout b;

    public MallActivityTestPlayBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, AliVideoView aliVideoView) {
        super(obj, view, i);
        this.f34878a = frameLayout;
        this.b = frameLayout2;
        this.f10454a = recyclerView;
        this.f10455a = layoutToolbarBindingBinding;
        this.f10456a = aliVideoView;
    }

    public static MallActivityTestPlayBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityTestPlayBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityTestPlayBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_test_play);
    }

    @NonNull
    public static MallActivityTestPlayBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityTestPlayBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityTestPlayBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityTestPlayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_test_play, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityTestPlayBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityTestPlayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_test_play, null, false, obj);
    }

    @Nullable
    public TestPlayActivity.a f() {
        return this.f10457a;
    }

    @Nullable
    public TestPlayVM g() {
        return this.f10458a;
    }

    public abstract void l(@Nullable TestPlayActivity.a aVar);

    public abstract void m(@Nullable TestPlayVM testPlayVM);
}
