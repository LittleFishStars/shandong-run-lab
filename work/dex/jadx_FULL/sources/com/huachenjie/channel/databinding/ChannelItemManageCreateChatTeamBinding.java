package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.channel.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ChannelItemManageCreateChatTeamBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLTextView f33266a;

    public ChannelItemManageCreateChatTeamBinding(@NonNull BLTextView bLTextView) {
        this.f33266a = bLTextView;
    }

    @NonNull
    public static ChannelItemManageCreateChatTeamBinding a(@NonNull View view) {
        if (view != null) {
            return new ChannelItemManageCreateChatTeamBinding((BLTextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ChannelItemManageCreateChatTeamBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelItemManageCreateChatTeamBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_item_manage_create_chat_team, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLTextView getRoot() {
        return this.f33266a;
    }
}
