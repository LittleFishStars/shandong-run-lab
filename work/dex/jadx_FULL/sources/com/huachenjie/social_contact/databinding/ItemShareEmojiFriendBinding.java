package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.MirrorDimensionBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemShareEmojiFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final AvatarView f36191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MirrorDimensionBean f12990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12991a;

    public ItemShareEmojiFriendBinding(Object obj, View view, int i, AvatarView avatarView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f36191a = avatarView;
        this.f12991a = bLTextView;
    }

    public static ItemShareEmojiFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemShareEmojiFriendBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemShareEmojiFriendBinding) ViewDataBinding.bind(obj, view, R.layout.item_share_emoji_friend);
    }

    @NonNull
    public static ItemShareEmojiFriendBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemShareEmojiFriendBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemShareEmojiFriendBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemShareEmojiFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_share_emoji_friend, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemShareEmojiFriendBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemShareEmojiFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_share_emoji_friend, null, false, obj);
    }

    @Nullable
    public MirrorDimensionBean f() {
        return this.f12990a;
    }

    public abstract void k(@Nullable MirrorDimensionBean mirrorDimensionBean);
}
