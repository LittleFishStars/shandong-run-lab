package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.notify.buddy.BuddyMemberManagerActivity;
import com.huachenjie.channel.page.notify.buddy.BuddyMemberManagerVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityBuddyMemberManagerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuddyMemberManagerActivity.a f7432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuddyMemberManagerVM f7433a;

    public ChannelActivityBuddyMemberManagerBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f33042a = recyclerView;
    }

    public static ChannelActivityBuddyMemberManagerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityBuddyMemberManagerBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityBuddyMemberManagerBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_buddy_member_manager);
    }

    @NonNull
    public static ChannelActivityBuddyMemberManagerBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityBuddyMemberManagerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityBuddyMemberManagerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityBuddyMemberManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_buddy_member_manager, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityBuddyMemberManagerBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityBuddyMemberManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_buddy_member_manager, null, false, obj);
    }

    @Nullable
    public BuddyMemberManagerActivity.a f() {
        return this.f7432a;
    }

    @Nullable
    public BuddyMemberManagerVM g() {
        return this.f7433a;
    }

    public abstract void l(@Nullable BuddyMemberManagerActivity.a aVar);

    public abstract void m(@Nullable BuddyMemberManagerVM buddyMemberManagerVM);
}
