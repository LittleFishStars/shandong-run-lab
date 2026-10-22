package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.R;
import com.vanniktech.emoji.EmojiTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ItemChatTextOtherBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f34495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EmojiTextView f9871a;

    public ItemChatTextOtherBinding(@NonNull RelativeLayout relativeLayout, @NonNull AvatarView avatarView, @NonNull EmojiTextView emojiTextView) {
        this.f34495a = relativeLayout;
        this.f9870a = avatarView;
        this.f9871a = emojiTextView;
    }

    @NonNull
    public static ItemChatTextOtherBinding a(@NonNull View view) {
        EmojiTextView emojiTextViewFindChildViewById;
        int i = R.id.ivAvatar;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
        if (avatarView == null || (emojiTextViewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.tvMessage))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new ItemChatTextOtherBinding((RelativeLayout) view, avatarView, emojiTextViewFindChildViewById);
    }

    @NonNull
    public static ItemChatTextOtherBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemChatTextOtherBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chat_text_other, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f34495a;
    }
}
