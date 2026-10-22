package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.channel.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class ChannelItemHomeLoadMoreBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f7993a;

    @NonNull
    public final View b;

    @NonNull
    public final View c;

    public ChannelItemHomeLoadMoreBinding(@NonNull FrameLayout frameLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar) {
        this.f7991a = frameLayout;
        this.f33251a = view;
        this.b = view2;
        this.c = view3;
        this.f7992a = linearLayout;
        this.f7993a = progressBar;
    }

    @NonNull
    public static ChannelItemHomeLoadMoreBinding a(@NonNull View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.load_more_load_complete_view;
        View viewFindChildViewById3 = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.load_more_load_end_view))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.load_more_load_fail_view))) != null) {
            i = R.id.load_more_loading_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.loading_progress;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    return new ChannelItemHomeLoadMoreBinding((FrameLayout) view, viewFindChildViewById3, viewFindChildViewById, viewFindChildViewById2, linearLayout, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ChannelItemHomeLoadMoreBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ChannelItemHomeLoadMoreBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.channel_item_home_load_more, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f7991a;
    }
}
