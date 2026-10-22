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
import com.huachenjie.channel.bean.TopicMainBean;
import com.huachenjie.channel.page.topic_main.TopicMainActivity;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelViewTopicMainHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TopicMainBean f8253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TopicMainActivity.a f8254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f8255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f8257a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8258b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLImageView f8259b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLImageView f8260c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ChannelViewTopicMainHeaderBinding(Object obj, View view, int i, DrawableCenterButton drawableCenterButton, ImageView imageView, BLImageView bLImageView, BLImageView bLImageView2, BLImageView bLImageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3) {
        super(obj, view, i);
        this.f8255a = drawableCenterButton;
        this.f8251a = imageView;
        this.f8256a = bLImageView;
        this.f8259b = bLImageView2;
        this.f8260c = bLImageView3;
        this.f8252a = textView;
        this.f8258b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f33344a = view2;
        this.b = view3;
    }

    public static ChannelViewTopicMainHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelViewTopicMainHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelViewTopicMainHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.channel_view_topic_main_header);
    }

    @NonNull
    public static ChannelViewTopicMainHeaderBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelViewTopicMainHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelViewTopicMainHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelViewTopicMainHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_topic_main_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelViewTopicMainHeaderBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelViewTopicMainHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_topic_main_header, null, false, obj);
    }

    @Nullable
    public TopicMainBean f() {
        return this.f8253a;
    }

    @Nullable
    public TopicMainActivity.a g() {
        return this.f8254a;
    }

    @Nullable
    public Integer h() {
        return this.f8257a;
    }

    public abstract void m(@Nullable TopicMainBean topicMainBean);

    public abstract void n(@Nullable TopicMainActivity.a aVar);

    public abstract void o(@Nullable Integer num);
}
