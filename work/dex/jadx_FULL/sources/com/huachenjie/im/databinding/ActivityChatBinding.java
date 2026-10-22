package com.huachenjie.im.databinding;

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
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ActivityChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleVM f9634a;

    public ActivityChatBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView) {
        super(obj, view, i);
        this.f34401a = frameLayout;
        this.f9633a = imageView;
    }

    public static ActivityChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityChatBinding) ViewDataBinding.bind(obj, view, R.layout.activity_chat);
    }

    @NonNull
    public static ActivityChatBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChatBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat, null, false, obj);
    }

    @Nullable
    public BaseTitleVM f() {
        return this.f9634a;
    }

    public abstract void k(@Nullable BaseTitleVM baseTitleVM);
}
