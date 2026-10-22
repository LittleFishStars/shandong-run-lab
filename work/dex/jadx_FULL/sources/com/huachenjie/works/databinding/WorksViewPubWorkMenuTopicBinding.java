package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.works.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class WorksViewPubWorkMenuTopicBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f37113a;

    public WorksViewPubWorkMenuTopicBinding(@NonNull TextView rootView) {
        this.f37113a = rootView;
    }

    @NonNull
    public static WorksViewPubWorkMenuTopicBinding a(@NonNull View rootView) {
        if (rootView != null) {
            return new WorksViewPubWorkMenuTopicBinding((TextView) rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static WorksViewPubWorkMenuTopicBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksViewPubWorkMenuTopicBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_view_pub_work_menu_topic, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f37113a;
    }
}
