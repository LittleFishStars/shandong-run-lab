package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.manage_channel.share.ShareSettingFragment;
import com.huachenjie.channel.page.manage_channel.share.ShareSettingVM;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentManageShareSettingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f7820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShareSettingFragment.a f7821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShareSettingVM f7822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f7823a;

    @NonNull
    public final BLImageView b;

    public ChannelFragmentManageShareSettingBinding(Object obj, View view, int i, CardView cardView, BLImageView bLImageView, BLImageView bLImageView2, TextView textView, View view2) {
        super(obj, view, i);
        this.f7820a = cardView;
        this.f7823a = bLImageView;
        this.b = bLImageView2;
        this.f7819a = textView;
        this.f33184a = view2;
    }

    public static ChannelFragmentManageShareSettingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentManageShareSettingBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentManageShareSettingBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_manage_share_setting);
    }

    @NonNull
    public static ChannelFragmentManageShareSettingBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentManageShareSettingBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageShareSettingBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentManageShareSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_share_setting, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageShareSettingBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentManageShareSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_share_setting, null, false, obj);
    }

    @Nullable
    public ShareSettingFragment.a f() {
        return this.f7821a;
    }

    @Nullable
    public ShareSettingVM g() {
        return this.f7822a;
    }

    public abstract void l(@Nullable ShareSettingFragment.a aVar);

    public abstract void m(@Nullable ShareSettingVM shareSettingVM);
}
