package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.add_friend.AddFriendActivity;
import com.huachenjie.channel.page.add_friend.AddFriendVM;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.ShadowConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityAddFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AddFriendActivity.a f7362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AddFriendVM f7363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7365a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7366b;

    public ChannelActivityAddFriendBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, ShadowConstraintLayout shadowConstraintLayout, ShadowConstraintLayout shadowConstraintLayout2, StateLayout stateLayout) {
        super(obj, view, i);
        this.f33017a = imageView;
        this.b = imageView2;
        this.f7361a = recyclerView;
        this.f7365a = shadowConstraintLayout;
        this.f7366b = shadowConstraintLayout2;
        this.f7364a = stateLayout;
    }

    public static ChannelActivityAddFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityAddFriendBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityAddFriendBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_add_friend);
    }

    @NonNull
    public static ChannelActivityAddFriendBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityAddFriendBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAddFriendBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityAddFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_add_friend, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAddFriendBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityAddFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_add_friend, null, false, obj);
    }

    @Nullable
    public AddFriendActivity.a f() {
        return this.f7362a;
    }

    @Nullable
    public AddFriendVM g() {
        return this.f7363a;
    }

    public abstract void l(@Nullable AddFriendActivity.a aVar);

    public abstract void m(@Nullable AddFriendVM addFriendVM);
}
