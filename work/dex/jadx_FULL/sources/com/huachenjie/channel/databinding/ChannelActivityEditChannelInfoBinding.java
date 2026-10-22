package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity;
import com.huachenjie.channel.page.create_channel.info.EditChannelInfoVM;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityEditChannelInfoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f33073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EditChannelInfoActivity.a f7529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EditChannelInfoVM f7530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UploadPictureButton f7531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7533a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ChannelActivityEditChannelInfoBinding(Object obj, View view, int i, EditText editText, ImageView imageView, ShadowConstraintLayout shadowConstraintLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, UploadPictureButton uploadPictureButton) {
        super(obj, view, i);
        this.f33073a = editText;
        this.f7527a = imageView;
        this.f7533a = shadowConstraintLayout;
        this.f7532a = layoutToolbarBindingBinding;
        this.f7528a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f7531a = uploadPictureButton;
    }

    public static ChannelActivityEditChannelInfoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityEditChannelInfoBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityEditChannelInfoBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_edit_channel_info);
    }

    @NonNull
    public static ChannelActivityEditChannelInfoBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityEditChannelInfoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityEditChannelInfoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityEditChannelInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_edit_channel_info, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityEditChannelInfoBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityEditChannelInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_edit_channel_info, null, false, obj);
    }

    @Nullable
    public EditChannelInfoActivity.a f() {
        return this.f7529a;
    }

    @Nullable
    public EditChannelInfoVM g() {
        return this.f7530a;
    }

    public abstract void l(@Nullable EditChannelInfoActivity.a aVar);

    public abstract void m(@Nullable EditChannelInfoVM editChannelInfoVM);
}
