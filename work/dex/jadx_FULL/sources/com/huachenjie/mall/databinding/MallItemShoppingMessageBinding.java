package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MessageContactBean;
import com.noober.background.view.BLTextView;
import com.vanniktech.emoji.EmojiTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemShoppingMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f10927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MessageContactBean f10928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EmojiTextView f10930a;

    @NonNull
    public final TextView b;

    public MallItemShoppingMessageBinding(Object obj, View view, int i, AvatarView avatarView, TextView textView, TextView textView2, EmojiTextView emojiTextView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f10927a = avatarView;
        this.f35040a = textView;
        this.b = textView2;
        this.f10930a = emojiTextView;
        this.f10929a = bLTextView;
    }

    public static MallItemShoppingMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemShoppingMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemShoppingMessageBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_shopping_message);
    }

    @NonNull
    public static MallItemShoppingMessageBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemShoppingMessageBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemShoppingMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemShoppingMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shopping_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemShoppingMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemShoppingMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shopping_message, null, false, obj);
    }

    @Nullable
    public MessageContactBean f() {
        return this.f10928a;
    }

    public abstract void k(@Nullable MessageContactBean messageContactBean);
}
