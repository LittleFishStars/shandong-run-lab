package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.widget.progress.GradientRoundProgress;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BuddyCardBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemBuddyCardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f37009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final HorizontalScrollView f14485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final GradientRoundProgress f14490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuddyCardBean f14491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14492a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14493b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14494b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f14495b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14496c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f14497c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLTextView f14498c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f14499d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final BLTextView f14500d;

    @NonNull
    public final TextView e;

    public WorksItemBuddyCardBinding(Object _bindingComponent, View _root, int _localFieldCount, HorizontalScrollView hsvBuddyTags, ImageView ivBuddyImage1, ImageView ivBuddyImage2, ImageView ivBuddyImage3, ImageView ivBuddyImage4, AvatarView ivCreatorAvatar, LinearLayout llBuddyImageContainer, LinearLayout llMemberAvatarPreview, LinearLayout llMemberInfo, TextView tvBuddyDescription, BLTextView tvBuddyJoin, TextView tvBuddyJoinedMemberCount, BLTextView tvBuddyLocationTag, TextView tvBuddyMemberCount, BLTextView tvBuddyTimeTag, TextView tvBuddyTitle, BLTextView tvBuddyTypeTag, TextView tvPublishTime, View vMemberDivider, GradientRoundProgress viewMemberProgress) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14485a = hsvBuddyTags;
        this.f14486a = ivBuddyImage1;
        this.b = ivBuddyImage2;
        this.c = ivBuddyImage3;
        this.d = ivBuddyImage4;
        this.f14489a = ivCreatorAvatar;
        this.f14487a = llBuddyImageContainer;
        this.f14493b = llMemberAvatarPreview;
        this.f14496c = llMemberInfo;
        this.f14488a = tvBuddyDescription;
        this.f14492a = tvBuddyJoin;
        this.f14494b = tvBuddyJoinedMemberCount;
        this.f14495b = tvBuddyLocationTag;
        this.f14497c = tvBuddyMemberCount;
        this.f14498c = tvBuddyTimeTag;
        this.f14499d = tvBuddyTitle;
        this.f14500d = tvBuddyTypeTag;
        this.e = tvPublishTime;
        this.f37009a = vMemberDivider;
        this.f14490a = viewMemberProgress;
    }

    public static WorksItemBuddyCardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemBuddyCardBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemBuddyCardBinding) ViewDataBinding.bind(component, view, R.layout.works_item_buddy_card);
    }

    @NonNull
    public static WorksItemBuddyCardBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemBuddyCardBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemBuddyCardBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemBuddyCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_buddy_card, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemBuddyCardBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemBuddyCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_buddy_card, null, false, component);
    }

    @Nullable
    public BuddyCardBean f() {
        return this.f14491a;
    }

    public abstract void k(@Nullable BuddyCardBean bean);
}
