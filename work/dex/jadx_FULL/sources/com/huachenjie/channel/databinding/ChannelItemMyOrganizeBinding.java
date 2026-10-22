package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeBean f8095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8096a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8097b;

    public ChannelItemMyOrganizeBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f33290a = imageView;
        this.f8093a = linearLayout;
        this.b = linearLayout2;
        this.f8094a = textView;
        this.f8097b = textView2;
    }

    public static ChannelItemMyOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_organize);
    }

    @NonNull
    public static ChannelItemMyOrganizeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyOrganizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyOrganizeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_organize, null, false, obj);
    }

    @Nullable
    public OrganizeBean f() {
        return this.f8095a;
    }

    @Nullable
    public Boolean g() {
        return this.f8096a;
    }

    public abstract void l(@Nullable OrganizeBean organizeBean);

    public abstract void m(@Nullable Boolean bool);
}
