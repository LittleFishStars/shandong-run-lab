package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.works.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemChooseFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final AvatarView f37011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FriendUserInfo f14504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14505a;

    public WorksItemChooseFriendBinding(Object _bindingComponent, View _root, int _localFieldCount, AvatarView ivAvatar, BLTextView tvShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37011a = ivAvatar;
        this.f14505a = tvShare;
    }

    public static WorksItemChooseFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemChooseFriendBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemChooseFriendBinding) ViewDataBinding.bind(component, view, R.layout.works_item_choose_friend);
    }

    @NonNull
    public static WorksItemChooseFriendBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemChooseFriendBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemChooseFriendBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemChooseFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_choose_friend, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemChooseFriendBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemChooseFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_choose_friend, null, false, component);
    }

    @Nullable
    public FriendUserInfo f() {
        return this.f14504a;
    }

    public abstract void k(@Nullable FriendUserInfo vm);
}
