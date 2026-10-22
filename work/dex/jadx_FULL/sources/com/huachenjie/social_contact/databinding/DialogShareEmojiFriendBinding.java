package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogShareEmojiFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShareEmojiFriendDialog.a f12913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShareEmojiFriendVM f12914a;

    public DialogShareEmojiFriendBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.f12912a = recyclerView;
        this.f36157a = textView;
    }

    public static DialogShareEmojiFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogShareEmojiFriendBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogShareEmojiFriendBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_share_emoji_friend);
    }

    @NonNull
    public static DialogShareEmojiFriendBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogShareEmojiFriendBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogShareEmojiFriendBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogShareEmojiFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_share_emoji_friend, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogShareEmojiFriendBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogShareEmojiFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_share_emoji_friend, null, false, obj);
    }

    @Nullable
    public ShareEmojiFriendDialog.a f() {
        return this.f12913a;
    }

    @Nullable
    public ShareEmojiFriendVM g() {
        return this.f12914a;
    }

    public abstract void l(@Nullable ShareEmojiFriendDialog.a aVar);

    public abstract void m(@Nullable ShareEmojiFriendVM shareEmojiFriendVM);
}
