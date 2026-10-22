package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.advertise.preview.PreviewAdvertiseVM;
import com.huachenjie.common.widget.CommonBanner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityAdvertisePreviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public PreviewAdvertiseVM f33030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonBanner f7398a;

    public ChannelActivityAdvertisePreviewBinding(Object obj, View view, int i, CommonBanner commonBanner) {
        super(obj, view, i);
        this.f7398a = commonBanner;
    }

    public static ChannelActivityAdvertisePreviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityAdvertisePreviewBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityAdvertisePreviewBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_advertise_preview);
    }

    @NonNull
    public static ChannelActivityAdvertisePreviewBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityAdvertisePreviewBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAdvertisePreviewBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityAdvertisePreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_advertise_preview, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAdvertisePreviewBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityAdvertisePreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_advertise_preview, null, false, obj);
    }

    @Nullable
    public PreviewAdvertiseVM f() {
        return this.f33030a;
    }

    public abstract void k(@Nullable PreviewAdvertiseVM previewAdvertiseVM);
}
