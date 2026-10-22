package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ItemChatCustomShareTopicOtherBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f34478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9830a;

    public ItemChatCustomShareTopicOtherBinding(@NonNull RelativeLayout relativeLayout, @NonNull ConstraintLayout constraintLayout, @NonNull AvatarView avatarView) {
        this.f34478a = relativeLayout;
        this.f9829a = constraintLayout;
        this.f9830a = avatarView;
    }

    @NonNull
    public static ItemChatCustomShareTopicOtherBinding a(@NonNull View view) {
        int i = R.id.cl_share_topic;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.ivAvatar;
            AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
            if (avatarView != null) {
                return new ItemChatCustomShareTopicOtherBinding((RelativeLayout) view, constraintLayout, avatarView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ItemChatCustomShareTopicOtherBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ItemChatCustomShareTopicOtherBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_chat_custom_share_topic_other, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f34478a;
    }
}
