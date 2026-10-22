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
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelDialogOpenNotificationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseViewModel f7740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7741a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f7742b;

    public ChannelDialogOpenNotificationBinding(Object obj, View view, int i, BLTextView bLTextView, BLTextView bLTextView2, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7741a = bLTextView;
        this.f7742b = bLTextView2;
        this.f33148a = imageView;
        this.f7739a = textView;
        this.b = textView2;
    }

    public static ChannelDialogOpenNotificationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelDialogOpenNotificationBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelDialogOpenNotificationBinding) ViewDataBinding.bind(obj, view, R.layout.channel_dialog_open_notification);
    }

    @NonNull
    public static ChannelDialogOpenNotificationBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelDialogOpenNotificationBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelDialogOpenNotificationBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelDialogOpenNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_open_notification, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelDialogOpenNotificationBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelDialogOpenNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_open_notification, null, false, obj);
    }

    @Nullable
    public BaseViewModel f() {
        return this.f7740a;
    }

    public abstract void k(@Nullable BaseViewModel baseViewModel);
}
