package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.manage_channel.ManageVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityManageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f33088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f7572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ManageVM f7573a;

    public ChannelActivityManageBinding(Object obj, View view, int i, SlidingTabLayout2 slidingTabLayout2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f7572a = slidingTabLayout2;
        this.f33088a = viewPager2;
    }

    public static ChannelActivityManageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityManageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityManageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_manage);
    }

    @NonNull
    public static ChannelActivityManageBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityManageBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityManageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_manage, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityManageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_manage, null, false, obj);
    }

    @Nullable
    public ManageVM f() {
        return this.f7573a;
    }

    public abstract void k(@Nullable ManageVM manageVM);
}
