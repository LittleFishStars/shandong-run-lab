package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.huachenjie.channel.page.my_channel.MyChannelVM;
import com.huachenjie.channel.widget.NotSaveStateTabLayout;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentMyChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelFragment.ClickProxy f7839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelVM f7840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NotSaveStateTabLayout f7841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7842a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final FrameLayout c;

    public ChannelFragmentMyChannelBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, BLLinearLayout bLLinearLayout, NotSaveStateTabLayout notSaveStateTabLayout) {
        super(obj, view, i);
        this.f33192a = frameLayout;
        this.b = frameLayout2;
        this.c = frameLayout3;
        this.f7842a = bLLinearLayout;
        this.f7841a = notSaveStateTabLayout;
    }

    public static ChannelFragmentMyChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentMyChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentMyChannelBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_my_channel);
    }

    @NonNull
    public static ChannelFragmentMyChannelBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentMyChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentMyChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentMyChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_my_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentMyChannelBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentMyChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_my_channel, null, false, obj);
    }

    @Nullable
    public MyChannelFragment.ClickProxy f() {
        return this.f7839a;
    }

    @Nullable
    public MyChannelVM g() {
        return this.f7840a;
    }

    public abstract void l(@Nullable MyChannelFragment.ClickProxy clickProxy);

    public abstract void m(@Nullable MyChannelVM myChannelVM);
}
