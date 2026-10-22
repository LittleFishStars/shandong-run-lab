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
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.my_channel.CreateSuccessDialog;
import com.huachenjie.channel.page.my_channel.CreateSuccessVM;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelDialogCreateSuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateSuccessDialog.a f7729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateSuccessVM f7730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f7731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7732a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f7733b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f7734b;

    @NonNull
    public final TextView c;

    public ChannelDialogCreateSuccessBinding(Object obj, View view, int i, AvatarView avatarView, BLRelativeLayout bLRelativeLayout, BLRelativeLayout bLRelativeLayout2, BLTextView bLTextView, BLTextView bLTextView2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7728a = avatarView;
        this.f7731a = bLRelativeLayout;
        this.f7733b = bLRelativeLayout2;
        this.f7732a = bLTextView;
        this.f7734b = bLTextView2;
        this.f33145a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static ChannelDialogCreateSuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelDialogCreateSuccessBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelDialogCreateSuccessBinding) ViewDataBinding.bind(obj, view, R.layout.channel_dialog_create_success);
    }

    @NonNull
    public static ChannelDialogCreateSuccessBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelDialogCreateSuccessBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelDialogCreateSuccessBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelDialogCreateSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_create_success, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelDialogCreateSuccessBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelDialogCreateSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_create_success, null, false, obj);
    }

    @Nullable
    public CreateSuccessDialog.a f() {
        return this.f7729a;
    }

    @Nullable
    public CreateSuccessVM g() {
        return this.f7730a;
    }

    public abstract void l(@Nullable CreateSuccessDialog.a aVar);

    public abstract void m(@Nullable CreateSuccessVM createSuccessVM);
}
