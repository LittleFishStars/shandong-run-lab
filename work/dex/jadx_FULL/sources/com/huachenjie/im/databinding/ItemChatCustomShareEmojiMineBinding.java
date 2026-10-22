package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.R;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ItemChatCustomShareEmojiMineBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f9811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9814a;

    public ItemChatCustomShareEmojiMineBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull BLLinearLayout bLLinearLayout, @NonNull TextView textView, @NonNull AvatarView avatarView) {
        this.f9811a = relativeLayout;
        this.f34471a = imageView;
        this.f9814a = bLLinearLayout;
        this.f9812a = textView;
        this.f9813a = avatarView;
    }

    @NonNull
    public static ItemChatCustomShareEmojiMineBinding a(@NonNull View view) {
        BLLinearLayout bLLinearLayoutFindChildViewById;
        int i = R.id.emojiImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null && (bLLinearLayoutFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.emojiItem))) != null) {
            i = R.id.emojiName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.ivAvatar;
                AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
                if (avatarView != null) {
                    return new ItemChatCustomShareEmojiMineBinding((RelativeLayout) view, imageView, bLLinearLayoutFindChildViewById, textView, avatarView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ItemChatCustomShareEmojiMineBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemChatCustomShareEmojiMineBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chat_custom_share_emoji_mine, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f9811a;
    }
}
