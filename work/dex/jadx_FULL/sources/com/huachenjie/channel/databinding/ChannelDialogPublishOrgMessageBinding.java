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
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageDialog;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageDialogVM;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelDialogPublishOrgMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public PublishOrgMessageDialog.a f33150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishOrgMessageDialogVM f7746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7747a;

    public ChannelDialogPublishOrgMessageBinding(Object obj, View view, int i, StateLayout stateLayout) {
        super(obj, view, i);
        this.f7747a = stateLayout;
    }

    public static ChannelDialogPublishOrgMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelDialogPublishOrgMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelDialogPublishOrgMessageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_dialog_publish_org_message);
    }

    @NonNull
    public static ChannelDialogPublishOrgMessageBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelDialogPublishOrgMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelDialogPublishOrgMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelDialogPublishOrgMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_publish_org_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelDialogPublishOrgMessageBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelDialogPublishOrgMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_publish_org_message, null, false, obj);
    }

    @Nullable
    public PublishOrgMessageDialog.a f() {
        return this.f33150a;
    }

    @Nullable
    public PublishOrgMessageDialogVM g() {
        return this.f7746a;
    }

    public abstract void l(@Nullable PublishOrgMessageDialog.a aVar);

    public abstract void m(@Nullable PublishOrgMessageDialogVM publishOrgMessageDialogVM);
}
