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
public final class ItemChatCustomShareEmojiOtherBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f9815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9818a;

    public ItemChatCustomShareEmojiOtherBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull BLLinearLayout bLLinearLayout, @NonNull TextView textView, @NonNull AvatarView avatarView) {
        this.f9815a = relativeLayout;
        this.f34472a = imageView;
        this.f9818a = bLLinearLayout;
        this.f9816a = textView;
        this.f9817a = avatarView;
    }

    @NonNull
    public static ItemChatCustomShareEmojiOtherBinding a(@NonNull View view) {
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
                    return new ItemChatCustomShareEmojiOtherBinding((RelativeLayout) view, imageView, bLLinearLayoutFindChildViewById, textView, avatarView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ItemChatCustomShareEmojiOtherBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemChatCustomShareEmojiOtherBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chat_custom_share_emoji_other, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f9815a;
    }
}
