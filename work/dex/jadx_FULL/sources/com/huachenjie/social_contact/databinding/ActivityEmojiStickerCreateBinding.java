package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityEmojiStickerCreateBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f36074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateEmojiStickerVM f12694a;

    public ActivityEmojiStickerCreateBinding(Object obj, View view, int i, EditText editText) {
        super(obj, view, i);
        this.f36074a = editText;
    }

    public static ActivityEmojiStickerCreateBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEmojiStickerCreateBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityEmojiStickerCreateBinding) ViewDataBinding.bind(obj, view, R.layout.activity_emoji_sticker_create);
    }

    @NonNull
    public static ActivityEmojiStickerCreateBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityEmojiStickerCreateBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerCreateBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityEmojiStickerCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_create, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerCreateBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityEmojiStickerCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_create, null, false, obj);
    }

    @Nullable
    public CreateEmojiStickerVM f() {
        return this.f12694a;
    }

    public abstract void k(@Nullable CreateEmojiStickerVM createEmojiStickerVM);
}
