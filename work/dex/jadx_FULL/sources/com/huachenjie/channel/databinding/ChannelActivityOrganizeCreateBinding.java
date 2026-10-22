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
import com.huachenjie.base.widget.image_pick.ImagePickView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.organize.create.CreateOrganizeActivity;
import com.huachenjie.channel.page.organize.create.CreateOrganizeVM;
import com.noober.background.view.BLEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityOrganizeCreateBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImagePickView f7637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateOrganizeActivity.a f7638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateOrganizeVM f7639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f7640a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLEditText f7641b;

    @NonNull
    public final TextView c;

    public ChannelActivityOrganizeCreateBinding(Object obj, View view, int i, ImagePickView imagePickView, BLEditText bLEditText, BLEditText bLEditText2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7637a = imagePickView;
        this.f7640a = bLEditText;
        this.f7641b = bLEditText2;
        this.f33109a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static ChannelActivityOrganizeCreateBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityOrganizeCreateBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityOrganizeCreateBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_organize_create);
    }

    @NonNull
    public static ChannelActivityOrganizeCreateBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityOrganizeCreateBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeCreateBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityOrganizeCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_create, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeCreateBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityOrganizeCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_create, null, false, obj);
    }

    @Nullable
    public CreateOrganizeActivity.a f() {
        return this.f7638a;
    }

    @Nullable
    public CreateOrganizeVM g() {
        return this.f7639a;
    }

    public abstract void l(@Nullable CreateOrganizeActivity.a aVar);

    public abstract void m(@Nullable CreateOrganizeVM createOrganizeVM);
}
