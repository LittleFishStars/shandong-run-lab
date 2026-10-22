package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.helpercenter.FeedBackV2VM;
import com.huachenjie.sport.widget.photowall.PhotoWall;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityFeedbackV2Binding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public FeedBackV2VM f36403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PhotoWall f13245a;

    public ActivityFeedbackV2Binding(Object obj, View view, int i, PhotoWall photoWall) {
        super(obj, view, i);
        this.f13245a = photoWall;
    }

    public static ActivityFeedbackV2Binding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFeedbackV2Binding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityFeedbackV2Binding) ViewDataBinding.bind(obj, view, R.layout.activity_feedback_v2);
    }

    @NonNull
    public static ActivityFeedbackV2Binding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityFeedbackV2Binding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityFeedbackV2Binding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityFeedbackV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_feedback_v2, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityFeedbackV2Binding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityFeedbackV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_feedback_v2, null, false, obj);
    }

    @Nullable
    public FeedBackV2VM f() {
        return this.f36403a;
    }

    public abstract void k(@Nullable FeedBackV2VM feedBackV2VM);
}
