package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.advertise.create.CreateAdvertiseActivity;
import com.huachenjie.channel.page.advertise.create.CreateAdvertiseVM;
import com.noober.background.view.BLEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityAdvertiseCreateBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwitchCompat f7381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImagePickView f7382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateAdvertiseActivity.a f7383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateAdvertiseVM f7384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f7385a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImagePickView f7386b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLEditText f7387b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ChannelActivityAdvertiseCreateBinding(Object obj, View view, int i, ImagePickView imagePickView, BLEditText bLEditText, BLEditText bLEditText2, ImagePickView imagePickView2, SwitchCompat switchCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f7382a = imagePickView;
        this.f7385a = bLEditText;
        this.f7387b = bLEditText2;
        this.f7386b = imagePickView2;
        this.f7381a = switchCompat;
        this.f33024a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
    }

    public static ChannelActivityAdvertiseCreateBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityAdvertiseCreateBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityAdvertiseCreateBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_advertise_create);
    }

    @NonNull
    public static ChannelActivityAdvertiseCreateBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityAdvertiseCreateBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAdvertiseCreateBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityAdvertiseCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_advertise_create, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAdvertiseCreateBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityAdvertiseCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_advertise_create, null, false, obj);
    }

    @Nullable
    public CreateAdvertiseActivity.a f() {
        return this.f7383a;
    }

    @Nullable
    public CreateAdvertiseVM g() {
        return this.f7384a;
    }

    public abstract void l(@Nullable CreateAdvertiseActivity.a aVar);

    public abstract void m(@Nullable CreateAdvertiseVM createAdvertiseVM);
}
