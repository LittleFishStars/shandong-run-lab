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
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.organize_detail.OrganizeDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelViewOrganizeDetailHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f8245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeDetailVM f8246a;

    @NonNull
    public final TextView b;

    public ChannelViewOrganizeDetailHeaderBinding(Object obj, View view, int i, ImageView imageView, ExpandableTextView expandableTextView, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f8243a = imageView;
        this.f8245a = expandableTextView;
        this.f8244a = textView;
        this.b = textView2;
        this.f33342a = view2;
    }

    public static ChannelViewOrganizeDetailHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelViewOrganizeDetailHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelViewOrganizeDetailHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.channel_view_organize_detail_header);
    }

    @NonNull
    public static ChannelViewOrganizeDetailHeaderBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelViewOrganizeDetailHeaderBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelViewOrganizeDetailHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelViewOrganizeDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_organize_detail_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelViewOrganizeDetailHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelViewOrganizeDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_organize_detail_header, null, false, obj);
    }

    @Nullable
    public OrganizeDetailVM f() {
        return this.f8246a;
    }

    public abstract void k(@Nullable OrganizeDetailVM organizeDetailVM);
}
