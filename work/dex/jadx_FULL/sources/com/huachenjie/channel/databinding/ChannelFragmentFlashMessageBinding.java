package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.home.FlashMessageFragment;
import com.huachenjie.channel.page.home.FlashMessageVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentFlashMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FlashMessageFragment.a f7778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FlashMessageVM f7779a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public ChannelFragmentFlashMessageBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f33165a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static ChannelFragmentFlashMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentFlashMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentFlashMessageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_flash_message);
    }

    @NonNull
    public static ChannelFragmentFlashMessageBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentFlashMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentFlashMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentFlashMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_flash_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentFlashMessageBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentFlashMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_flash_message, null, false, obj);
    }

    @Nullable
    public FlashMessageFragment.a f() {
        return this.f7778a;
    }

    @Nullable
    public FlashMessageVM g() {
        return this.f7779a;
    }

    public abstract void l(@Nullable FlashMessageFragment.a aVar);

    public abstract void m(@Nullable FlashMessageVM flashMessageVM);
}
