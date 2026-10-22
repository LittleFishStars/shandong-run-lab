package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.dialog.PublishEntryDialog;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogPublishEntryBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f14096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishEntryDialog.ClickProxy f14097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14099a;

    @NonNull
    public final ImageView b;

    public WorksDialogPublishEntryBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivClose, ImageView ivVideo, BLLinearLayout llPicture, RelativeLayout rlVideo, BLTextView tvTimeOpen) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36872a = ivClose;
        this.b = ivVideo;
        this.f14098a = llPicture;
        this.f14096a = rlVideo;
        this.f14099a = tvTimeOpen;
    }

    public static WorksDialogPublishEntryBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogPublishEntryBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogPublishEntryBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_publish_entry);
    }

    @NonNull
    public static WorksDialogPublishEntryBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogPublishEntryBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogPublishEntryBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogPublishEntryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_publish_entry, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogPublishEntryBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogPublishEntryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_publish_entry, null, false, component);
    }

    @Nullable
    public PublishEntryDialog.ClickProxy f() {
        return this.f14097a;
    }

    public abstract void k(@Nullable PublishEntryDialog.ClickProxy click);
}
