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
public abstract class ChannelItemOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeBean f8135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8136a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8137b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ChannelItemOrganizeBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3) {
        super(obj, view, i);
        this.f8132a = imageView;
        this.f8133a = linearLayout;
        this.f8134a = textView;
        this.f8137b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f33300a = view2;
        this.b = view3;
    }

    public static ChannelItemOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_organize);
    }

    @NonNull
    public static ChannelItemOrganizeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemOrganizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemOrganizeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_organize, null, false, obj);
    }

    @Nullable
    public OrganizeBean f() {
        return this.f8135a;
    }

    @Nullable
    public Boolean g() {
        return this.f8136a;
    }

    public abstract void l(@Nullable OrganizeBean organizeBean);

    public abstract void m(@Nullable Boolean bool);
}
