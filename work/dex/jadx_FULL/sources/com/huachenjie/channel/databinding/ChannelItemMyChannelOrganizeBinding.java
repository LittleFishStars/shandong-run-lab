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
import com.huachenjie.channel.bean.OrganizeBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyChannelOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeBean f8062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8063a;

    public ChannelItemMyChannelOrganizeBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f33280a = textView;
    }

    public static ChannelItemMyChannelOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyChannelOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyChannelOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_channel_organize);
    }

    @NonNull
    public static ChannelItemMyChannelOrganizeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyChannelOrganizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyChannelOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelOrganizeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyChannelOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_organize, null, false, obj);
    }

    @Nullable
    public OrganizeBean f() {
        return this.f8062a;
    }

    @Nullable
    public Boolean g() {
        return this.f8063a;
    }

    public abstract void l(@Nullable OrganizeBean organizeBean);

    public abstract void m(@Nullable Boolean bool);
}
