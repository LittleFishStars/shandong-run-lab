package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.channel.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ChannelViewChannelMembersBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33335a;

    public ChannelViewChannelMembersBinding(@NonNull TextView textView) {
        this.f33335a = textView;
    }

    @NonNull
    public static ChannelViewChannelMembersBinding a(@NonNull View view) {
        if (view != null) {
            return new ChannelViewChannelMembersBinding((TextView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ChannelViewChannelMembersBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelViewChannelMembersBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_view_channel_members, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f33335a;
    }
}
