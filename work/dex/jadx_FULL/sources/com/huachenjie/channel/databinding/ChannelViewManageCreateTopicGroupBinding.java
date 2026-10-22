package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.channel.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ChannelViewManageCreateTopicGroupBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f33338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8236a;

    public ChannelViewManageCreateTopicGroupBinding(@NonNull LinearLayout linearLayout, @NonNull BLTextView bLTextView) {
        this.f33338a = linearLayout;
        this.f8236a = bLTextView;
    }

    @NonNull
    public static ChannelViewManageCreateTopicGroupBinding a(@NonNull View view) {
        int i = R.id.tv_add;
        BLTextView bLTextViewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (bLTextViewFindChildViewById != null) {
            return new ChannelViewManageCreateTopicGroupBinding((LinearLayout) view, bLTextViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ChannelViewManageCreateTopicGroupBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelViewManageCreateTopicGroupBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_view_manage_create_topic_group, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f33338a;
    }
}
