package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityEmojiStickerMineBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager f36081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f12712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineEmojiStickerVM f12713a;

    public ActivityEmojiStickerMineBinding(Object obj, View view, int i, SlidingTabLayout slidingTabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.f12712a = slidingTabLayout;
        this.f36081a = viewPager;
    }

    public static ActivityEmojiStickerMineBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEmojiStickerMineBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityEmojiStickerMineBinding) ViewDataBinding.bind(obj, view, R.layout.activity_emoji_sticker_mine);
    }

    @NonNull
    public static ActivityEmojiStickerMineBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityEmojiStickerMineBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerMineBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityEmojiStickerMineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_mine, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerMineBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityEmojiStickerMineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_mine, null, false, obj);
    }

    @Nullable
    public MineEmojiStickerVM f() {
        return this.f12713a;
    }

    public abstract void k(@Nullable MineEmojiStickerVM mineEmojiStickerVM);
}
