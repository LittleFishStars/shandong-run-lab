package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.OriginalChannelHotspotBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemOrginalChannelSubBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f14599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OriginalChannelHotspotBean f14601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14602a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14603b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f14604b;

    public WorksItemOrginalChannelSubBinding(Object _bindingComponent, View _root, int _localFieldCount, AvatarView ivAvatar, RoundImageView ivBg, ImageView ivRank, LinearLayout llInfo, LinearLayout llPic, BLTextView tvEnter, TextView tvName, TextView tvNickname, BLTextView tvRank) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14600a = ivAvatar;
        this.f14599a = ivBg;
        this.f37041a = ivRank;
        this.f14597a = llInfo;
        this.b = llPic;
        this.f14602a = tvEnter;
        this.f14598a = tvName;
        this.f14603b = tvNickname;
        this.f14604b = tvRank;
    }

    public static WorksItemOrginalChannelSubBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemOrginalChannelSubBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemOrginalChannelSubBinding) ViewDataBinding.bind(component, view, R.layout.works_item_orginal_channel_sub);
    }

    @NonNull
    public static WorksItemOrginalChannelSubBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemOrginalChannelSubBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemOrginalChannelSubBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemOrginalChannelSubBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_orginal_channel_sub, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemOrginalChannelSubBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemOrginalChannelSubBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_orginal_channel_sub, null, false, component);
    }

    @Nullable
    public OriginalChannelHotspotBean f() {
        return this.f14601a;
    }

    public abstract void k(@Nullable OriginalChannelHotspotBean bean);
}
