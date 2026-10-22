package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class IncludeCustomShareChannelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f9767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9768a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final AvatarView f9769b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final AvatarView f9770c;

    public IncludeCustomShareChannelBinding(@NonNull View view, @NonNull RoundImageView roundImageView, @NonNull AvatarView avatarView, @NonNull AvatarView avatarView2, @NonNull AvatarView avatarView3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f34449a = view;
        this.f9767a = roundImageView;
        this.f9768a = avatarView;
        this.f9769b = avatarView2;
        this.f9770c = avatarView3;
        this.f9766a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    @NonNull
    public static IncludeCustomShareChannelBinding a(@NonNull View view) {
        int i = R.id.channelImage;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, i);
        if (roundImageView != null) {
            i = R.id.ivAvatar_1;
            AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, i);
            if (avatarView != null) {
                i = R.id.ivAvatar_2;
                AvatarView avatarView2 = (AvatarView) ViewBindings.findChildViewById(view, i);
                if (avatarView2 != null) {
                    i = R.id.ivAvatar_3;
                    AvatarView avatarView3 = (AvatarView) ViewBindings.findChildViewById(view, i);
                    if (avatarView3 != null) {
                        i = R.id.tvChannelName;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tvChannelUserNum;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tvHot;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new IncludeCustomShareChannelBinding(view, roundImageView, avatarView, avatarView2, avatarView3, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static IncludeCustomShareChannelBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.include_custom_share_channel, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f34449a;
    }
}
