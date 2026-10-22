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
import com.huachenjie.channel.page.create_channel.type.ChooseChannelTypeVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityChooseChannelTypeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseChannelTypeVM f7467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7468a;

    public ChannelActivityChooseChannelTypeBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView) {
        super(obj, view, i);
        this.f7468a = layoutToolbarBindingBinding;
        this.f33053a = textView;
    }

    public static ChannelActivityChooseChannelTypeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityChooseChannelTypeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityChooseChannelTypeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_choose_channel_type);
    }

    @NonNull
    public static ChannelActivityChooseChannelTypeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityChooseChannelTypeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChooseChannelTypeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityChooseChannelTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_choose_channel_type, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChooseChannelTypeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityChooseChannelTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_choose_channel_type, null, false, obj);
    }

    @Nullable
    public ChooseChannelTypeVM f() {
        return this.f7467a;
    }

    public abstract void k(@Nullable ChooseChannelTypeVM chooseChannelTypeVM);
}
