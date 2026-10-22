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
import com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoFragment;
import com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoVM;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.noober.background.view.BLEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentManageBasicInfoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ManageBasicInfoFragment.a f7800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ManageBasicInfoVM f7801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UploadPictureButton f7802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f7803a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final UploadPictureButton f7804b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLEditText f7805b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ChannelFragmentManageBasicInfoBinding(Object obj, View view, int i, BLEditText bLEditText, BLEditText bLEditText2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, UploadPictureButton uploadPictureButton, UploadPictureButton uploadPictureButton2) {
        super(obj, view, i);
        this.f7803a = bLEditText;
        this.f7805b = bLEditText2;
        this.f33175a = imageView;
        this.f7799a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.f7802a = uploadPictureButton;
        this.f7804b = uploadPictureButton2;
    }

    public static ChannelFragmentManageBasicInfoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentManageBasicInfoBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentManageBasicInfoBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_manage_basic_info);
    }

    @NonNull
    public static ChannelFragmentManageBasicInfoBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentManageBasicInfoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageBasicInfoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentManageBasicInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_basic_info, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageBasicInfoBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentManageBasicInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_basic_info, null, false, obj);
    }

    @Nullable
    public ManageBasicInfoFragment.a f() {
        return this.f7800a;
    }

    @Nullable
    public ManageBasicInfoVM g() {
        return this.f7801a;
    }

    public abstract void l(@Nullable ManageBasicInfoFragment.a aVar);

    public abstract void m(@Nullable ManageBasicInfoVM manageBasicInfoVM);
}
