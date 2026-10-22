package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ActivityChatRoomBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f9643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9644a;

    public ActivityChatRoomBinding(Object obj, View view, int i, FrameLayout frameLayout, AvatarView avatarView, ImageView imageView, LinearLayout linearLayout, TextView textView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f34403a = frameLayout;
        this.f9642a = avatarView;
        this.f9639a = imageView;
        this.f9640a = linearLayout;
        this.f9641a = textView;
        this.f9644a = bLTextView;
    }

    public static ActivityChatRoomBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChatRoomBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityChatRoomBinding) ViewDataBinding.bind(obj, view, R.layout.activity_chat_room);
    }

    @NonNull
    public static ActivityChatRoomBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChatRoomBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChatRoomBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChatRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_room, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityChatRoomBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChatRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_room, null, false, obj);
    }

    @Nullable
    public BaseVM f() {
        return this.f9643a;
    }

    public abstract void k(@Nullable BaseVM baseVM);
}
