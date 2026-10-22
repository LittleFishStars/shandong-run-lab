package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageVM;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityPublishOrgMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImagePickView f33124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishOrgMessageActivity.ClickProxy f7679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishOrgMessageVM f7680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7682a;

    public ChannelActivityPublishOrgMessageBinding(Object obj, View view, int i, BLTextView bLTextView, ImagePickView imagePickView, BLView bLView) {
        super(obj, view, i);
        this.f7681a = bLTextView;
        this.f33124a = imagePickView;
        this.f7682a = bLView;
    }

    public static ChannelActivityPublishOrgMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityPublishOrgMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityPublishOrgMessageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_publish_org_message);
    }

    @NonNull
    public static ChannelActivityPublishOrgMessageBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityPublishOrgMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityPublishOrgMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityPublishOrgMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_publish_org_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityPublishOrgMessageBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityPublishOrgMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_publish_org_message, null, false, obj);
    }

    @Nullable
    public PublishOrgMessageActivity.ClickProxy f() {
        return this.f7679a;
    }

    @Nullable
    public PublishOrgMessageVM g() {
        return this.f7680a;
    }

    public abstract void l(@Nullable PublishOrgMessageActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable PublishOrgMessageVM publishOrgMessageVM);
}
