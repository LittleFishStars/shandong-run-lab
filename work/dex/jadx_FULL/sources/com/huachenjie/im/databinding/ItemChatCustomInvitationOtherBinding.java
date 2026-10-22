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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ItemChatCustomInvitationOtherBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f34466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9802a;

    public ItemChatCustomInvitationOtherBinding(@NonNull RelativeLayout relativeLayout, @NonNull AvatarView avatarView) {
        this.f34466a = relativeLayout;
        this.f9802a = avatarView;
    }

    @NonNull
    public static ItemChatCustomInvitationOtherBinding a(@NonNull View view) {
        int i = R.id.ivAvatar;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
        if (avatarView != null) {
            return new ItemChatCustomInvitationOtherBinding((RelativeLayout) view, avatarView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ItemChatCustomInvitationOtherBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemChatCustomInvitationOtherBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chat_custom_invitation_other, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f34466a;
    }
}
