package com.huachenjie.im.databinding;

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
import com.huachenjie.im.R;
import com.huachenjie.im.page.SingleChatFragment;
import com.huachenjie.im.vm.SingleChatVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentSingleChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SingleChatFragment.k f9744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SingleChatVM f9745a;

    @NonNull
    public final FrameLayout b;

    public FragmentSingleChatBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f34439a = frameLayout;
        this.b = frameLayout2;
        this.f9743a = recyclerView;
    }

    public static FragmentSingleChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSingleChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentSingleChatBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_single_chat);
    }

    @NonNull
    public static FragmentSingleChatBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentSingleChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSingleChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSingleChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_single_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentSingleChatBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSingleChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_single_chat, null, false, obj);
    }

    @Nullable
    public SingleChatFragment.k f() {
        return this.f9744a;
    }

    @Nullable
    public SingleChatVM g() {
        return this.f9745a;
    }

    public abstract void l(@Nullable SingleChatFragment.k kVar);

    public abstract void m(@Nullable SingleChatVM singleChatVM);
}
