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
public final class ChannelItemManageCreateTopicBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLTextView f33267a;

    public ChannelItemManageCreateTopicBinding(@NonNull BLTextView bLTextView) {
        this.f33267a = bLTextView;
    }

    @NonNull
    public static ChannelItemManageCreateTopicBinding a(@NonNull View view) {
        if (view != null) {
            return new ChannelItemManageCreateTopicBinding((BLTextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ChannelItemManageCreateTopicBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelItemManageCreateTopicBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_item_manage_create_topic, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLTextView getRoot() {
        return this.f33267a;
    }
}
