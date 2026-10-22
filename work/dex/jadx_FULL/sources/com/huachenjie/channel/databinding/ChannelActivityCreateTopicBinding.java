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
import com.huachenjie.channel.page.manage_channel.topic.CreateTopicActivity;
import com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityCreateTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateTopicActivity.a f7497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateTopicVM f7498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UploadPictureButton f7499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f7502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f7504a;

    @NonNull
    public final TextView b;

    @Bindable
    public String f;

    public ChannelActivityCreateTopicBinding(Object obj, View view, int i, BLEditText bLEditText, ShadowConstraintLayout shadowConstraintLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView, BLTextView bLTextView, TextView textView2, UploadPictureButton uploadPictureButton) {
        super(obj, view, i);
        this.f7502a = bLEditText;
        this.f7501a = shadowConstraintLayout;
        this.f7500a = layoutToolbarBindingBinding;
        this.f33062a = textView;
        this.f7503a = bLTextView;
        this.b = textView2;
        this.f7499a = uploadPictureButton;
    }

    public static ChannelActivityCreateTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityCreateTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityCreateTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_create_topic);
    }

    @NonNull
    public static ChannelActivityCreateTopicBinding k(@NonNull LayoutInflater layoutInflater) {
        return n(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityCreateTopicBinding l(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityCreateTopicBinding m(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityCreateTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_create_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityCreateTopicBinding n(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityCreateTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_create_topic, null, false, obj);
    }

    @Nullable
    public CreateTopicActivity.a f() {
        return this.f7497a;
    }

    @Nullable
    public Boolean g() {
        return this.f7504a;
    }

    @Nullable
    public String h() {
        return this.f;
    }

    @Nullable
    public CreateTopicVM j() {
        return this.f7498a;
    }

    public abstract void o(@Nullable CreateTopicActivity.a aVar);

    public abstract void p(@Nullable Boolean bool);

    public abstract void q(@Nullable String str);

    public abstract void r(@Nullable CreateTopicVM createTopicVM);
}
