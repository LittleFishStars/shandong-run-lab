package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.im.R;
import com.huachenjie.im.page.SignalTowerFragment;
import com.huachenjie.im.vm.ChatRoomVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentChatRoomBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignalTowerFragment.h f9670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChatRoomVM f9671a;

    @NonNull
    public final FrameLayout b;

    public FragmentChatRoomBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f34413a = frameLayout;
        this.b = frameLayout2;
        this.f9669a = recyclerView;
    }

    public static FragmentChatRoomBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentChatRoomBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentChatRoomBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_chat_room);
    }

    @NonNull
    public static FragmentChatRoomBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentChatRoomBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentChatRoomBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentChatRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_chat_room, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentChatRoomBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentChatRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_chat_room, null, false, obj);
    }

    @Nullable
    public SignalTowerFragment.h f() {
        return this.f9670a;
    }

    @Nullable
    public ChatRoomVM g() {
        return this.f9671a;
    }

    public abstract void l(@Nullable SignalTowerFragment.h hVar);

    public abstract void m(@Nullable ChatRoomVM chatRoomVM);
}
