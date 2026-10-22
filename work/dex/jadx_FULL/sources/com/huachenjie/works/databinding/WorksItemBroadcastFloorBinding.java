package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.noober.background.view.BLLinearLayout;
import com.vanniktech.emoji.EmojiTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemBroadcastFloorBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f37006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f14475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BroadcastFloorMessageBean f14477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14479a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EmojiTextView f14480a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14481b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f14482c;

    public WorksItemBroadcastFloorBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clContent, AvatarView ivAvatar, ImageView ivComment, ImageView ivIcon, ImageView ivImage, LottieAnimationView jsonAudio, BLLinearLayout llAudio, LinearLayout llComment, BLOperateAnimView llLike, TextView tvComment, EmojiTextView tvContent, TextView tvNickname, TextView tvPublishTime, View vLine) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14474a = clContent;
        this.f14476a = ivAvatar;
        this.f14471a = ivComment;
        this.b = ivIcon;
        this.c = ivImage;
        this.f14475a = jsonAudio;
        this.f14479a = llAudio;
        this.f14472a = llComment;
        this.f14478a = llLike;
        this.f14473a = tvComment;
        this.f14480a = tvContent;
        this.f14481b = tvNickname;
        this.f14482c = tvPublishTime;
        this.f37006a = vLine;
    }

    public static WorksItemBroadcastFloorBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemBroadcastFloorBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemBroadcastFloorBinding) ViewDataBinding.bind(component, view, R.layout.works_item_broadcast_floor);
    }

    @NonNull
    public static WorksItemBroadcastFloorBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemBroadcastFloorBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemBroadcastFloorBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_broadcast_floor, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemBroadcastFloorBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_broadcast_floor, null, false, component);
    }

    @Nullable
    public BroadcastFloorMessageBean f() {
        return this.f14477a;
    }

    public abstract void k(@Nullable BroadcastFloorMessageBean bean);
}
