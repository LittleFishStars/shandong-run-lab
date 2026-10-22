package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.im.R;
import com.huachenjie.im.page.emoji.EmojiPanelFragment;
import com.huachenjie.im.page.emoji.EmojiPanelVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentEmojiPanelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f9688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiPanelFragment.a f9689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiPanelVM f9690a;

    public FragmentEmojiPanelBinding(Object obj, View view, int i, RecyclerView recyclerView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f34421a = recyclerView;
        this.f9688a = viewPager2;
    }

    public static FragmentEmojiPanelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEmojiPanelBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentEmojiPanelBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_emoji_panel);
    }

    @NonNull
    public static FragmentEmojiPanelBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentEmojiPanelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentEmojiPanelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentEmojiPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_emoji_panel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentEmojiPanelBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentEmojiPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_emoji_panel, null, false, obj);
    }

    @Nullable
    public EmojiPanelFragment.a f() {
        return this.f9689a;
    }

    @Nullable
    public EmojiPanelVM g() {
        return this.f9690a;
    }

    public abstract void l(@Nullable EmojiPanelFragment.a aVar);

    public abstract void m(@Nullable EmojiPanelVM emojiPanelVM);
}
