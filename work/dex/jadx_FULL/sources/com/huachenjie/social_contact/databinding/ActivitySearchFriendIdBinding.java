package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.SearchFriendIdActivity;
import com.huachenjie.social_contact.vm.SearchFriendIdVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivitySearchFriendIdBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f36106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f12785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f12786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchFriendIdActivity.a f12787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchFriendIdVM f12788a;

    public ActivitySearchFriendIdBinding(Object obj, View view, int i, EditText editText, ImageView imageView, AvatarView avatarView, LinearLayout linearLayout, ShadowConstraintLayout shadowConstraintLayout, TextView textView) {
        super(obj, view, i);
        this.f36106a = editText;
        this.f12782a = imageView;
        this.f12785a = avatarView;
        this.f12783a = linearLayout;
        this.f12786a = shadowConstraintLayout;
        this.f12784a = textView;
    }

    public static ActivitySearchFriendIdBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySearchFriendIdBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySearchFriendIdBinding) ViewDataBinding.bind(obj, view, R.layout.activity_search_friend_id);
    }

    @NonNull
    public static ActivitySearchFriendIdBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySearchFriendIdBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySearchFriendIdBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySearchFriendIdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search_friend_id, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySearchFriendIdBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySearchFriendIdBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search_friend_id, null, false, obj);
    }

    @Nullable
    public SearchFriendIdActivity.a f() {
        return this.f12787a;
    }

    @Nullable
    public SearchFriendIdVM g() {
        return this.f12788a;
    }

    public abstract void l(@Nullable SearchFriendIdActivity.a aVar);

    public abstract void m(@Nullable SearchFriendIdVM searchFriendIdVM);
}
