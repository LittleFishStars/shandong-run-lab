package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.im.R;
import com.vanniktech.emoji.EmojiTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ItemChatRoomTextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f34486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EmojiTextView f9847a;

    @NonNull
    public final LinearLayout b;

    public ItemChatRoomTextBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull EmojiTextView emojiTextView) {
        this.f34486a = linearLayout;
        this.b = linearLayout2;
        this.f9847a = emojiTextView;
    }

    @NonNull
    public static ItemChatRoomTextBinding a(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.tv_content;
        EmojiTextView emojiTextViewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (emojiTextViewFindChildViewById != null) {
            return new ItemChatRoomTextBinding(linearLayout, linearLayout, emojiTextViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ItemChatRoomTextBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemChatRoomTextBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chat_room_text, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f34486a;
    }
}
