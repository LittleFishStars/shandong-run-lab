package com.huachenjie.mine.databinding;

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
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.widget.FriendFollowButton;
import com.huachenjie.mine.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineItemFansAndAttentionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FansBean f11325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FriendFollowButton f11326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f11327a;

    public MineItemFansAndAttentionBinding(Object obj, View view, int i, FriendFollowButton friendFollowButton, AvatarView avatarView, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f11326a = friendFollowButton;
        this.f11324a = avatarView;
        this.f35345a = imageView;
        this.f11323a = textView;
    }

    public static MineItemFansAndAttentionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineItemFansAndAttentionBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineItemFansAndAttentionBinding) ViewDataBinding.bind(obj, view, R.layout.mine_item_fans_and_attention);
    }

    @NonNull
    public static MineItemFansAndAttentionBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineItemFansAndAttentionBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineItemFansAndAttentionBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineItemFansAndAttentionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_item_fans_and_attention, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineItemFansAndAttentionBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineItemFansAndAttentionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_item_fans_and_attention, null, false, obj);
    }

    @Nullable
    public FansBean f() {
        return this.f11325a;
    }

    @Nullable
    public Boolean g() {
        return this.f11327a;
    }

    public abstract void l(@Nullable FansBean fansBean);

    public abstract void m(@Nullable Boolean bool);
}
