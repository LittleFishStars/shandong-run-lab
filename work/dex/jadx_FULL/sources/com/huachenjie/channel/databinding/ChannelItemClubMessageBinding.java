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
import com.huachenjie.channel.bean.ClubMessageBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemClubMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ClubMessageBean f7948a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f7949b;

    public ChannelItemClubMessageBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f7946a = imageView;
        this.b = imageView2;
        this.f7947a = textView;
        this.f7949b = textView2;
        this.f33236a = view2;
    }

    public static ChannelItemClubMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemClubMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemClubMessageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_club_message);
    }

    @NonNull
    public static ChannelItemClubMessageBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemClubMessageBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemClubMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemClubMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_club_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemClubMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemClubMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_club_message, null, false, obj);
    }

    @Nullable
    public ClubMessageBean f() {
        return this.f7948a;
    }

    public abstract void k(@Nullable ClubMessageBean clubMessageBean);
}
