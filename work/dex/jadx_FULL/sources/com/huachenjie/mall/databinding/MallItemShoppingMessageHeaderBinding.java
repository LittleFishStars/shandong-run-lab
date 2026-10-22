package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.shopping_message.ShoppingMessageVM;
import com.noober.background.view.BLTextView;
import com.vanniktech.emoji.EmojiTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemShoppingMessageHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShoppingMessageVM f10936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EmojiTextView f10938a;

    @NonNull
    public final TextView b;

    public MallItemShoppingMessageHeaderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, EmojiTextView emojiTextView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f10935a = constraintLayout;
        this.f35042a = imageView;
        this.f10934a = textView;
        this.b = textView2;
        this.f10938a = emojiTextView;
        this.f10937a = bLTextView;
    }

    public static MallItemShoppingMessageHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemShoppingMessageHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemShoppingMessageHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_shopping_message_header);
    }

    @NonNull
    public static MallItemShoppingMessageHeaderBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemShoppingMessageHeaderBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemShoppingMessageHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemShoppingMessageHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shopping_message_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemShoppingMessageHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemShoppingMessageHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shopping_message_header, null, false, obj);
    }

    @Nullable
    public ShoppingMessageVM f() {
        return this.f10936a;
    }

    public abstract void k(@Nullable ShoppingMessageVM shoppingMessageVM);
}
