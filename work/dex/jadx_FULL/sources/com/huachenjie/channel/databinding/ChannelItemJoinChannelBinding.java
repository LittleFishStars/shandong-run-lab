package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.works.external.bean.ChannelBean;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemJoinChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelBean f8002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8004a;

    @NonNull
    public final TextView b;

    public ChannelItemJoinChannelBinding(Object obj, View view, int i, BLTextView bLTextView, ImageView imageView, TextView textView, TextView textView2, View view2, BLView bLView) {
        super(obj, view, i);
        this.f8003a = bLTextView;
        this.f8000a = imageView;
        this.f8001a = textView;
        this.b = textView2;
        this.f33254a = view2;
        this.f8004a = bLView;
    }

    public static ChannelItemJoinChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemJoinChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemJoinChannelBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_join_channel);
    }

    @NonNull
    public static ChannelItemJoinChannelBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemJoinChannelBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemJoinChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemJoinChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_join_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemJoinChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemJoinChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_join_channel, null, false, obj);
    }

    @Nullable
    public ChannelBean f() {
        return this.f8002a;
    }

    public abstract void k(@Nullable ChannelBean channelBean);
}
