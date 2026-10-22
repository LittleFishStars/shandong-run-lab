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
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminDialog;
import com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminVM;
import com.noober.background.view.BLEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelDialogAddSubAdminBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AddSubAdminDialog.a f7715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AddSubAdminVM f7716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f7717a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public ChannelDialogAddSubAdminBinding(Object obj, View view, int i, BLEditText bLEditText, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7717a = bLEditText;
        this.f33138a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static ChannelDialogAddSubAdminBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelDialogAddSubAdminBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelDialogAddSubAdminBinding) ViewDataBinding.bind(obj, view, R.layout.channel_dialog_add_sub_admin);
    }

    @NonNull
    public static ChannelDialogAddSubAdminBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelDialogAddSubAdminBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelDialogAddSubAdminBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelDialogAddSubAdminBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_add_sub_admin, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelDialogAddSubAdminBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelDialogAddSubAdminBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_add_sub_admin, null, false, obj);
    }

    @Nullable
    public AddSubAdminDialog.a f() {
        return this.f7715a;
    }

    @Nullable
    public AddSubAdminVM g() {
        return this.f7716a;
    }

    public abstract void l(@Nullable AddSubAdminDialog.a aVar);

    public abstract void m(@Nullable AddSubAdminVM addSubAdminVM);
}
