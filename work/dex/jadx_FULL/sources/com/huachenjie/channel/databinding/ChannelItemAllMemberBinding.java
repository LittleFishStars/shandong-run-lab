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
import com.huachenjie.channel.bean.ChannelMemberBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemAllMemberBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMemberBean f7914a;

    public ChannelItemAllMemberBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f33222a = textView;
    }

    public static ChannelItemAllMemberBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemAllMemberBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemAllMemberBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_all_member);
    }

    @NonNull
    public static ChannelItemAllMemberBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemAllMemberBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemAllMemberBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemAllMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_all_member, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemAllMemberBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemAllMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_all_member, null, false, obj);
    }

    @Nullable
    public ChannelMemberBean f() {
        return this.f7914a;
    }

    public abstract void k(@Nullable ChannelMemberBean channelMemberBean);
}
