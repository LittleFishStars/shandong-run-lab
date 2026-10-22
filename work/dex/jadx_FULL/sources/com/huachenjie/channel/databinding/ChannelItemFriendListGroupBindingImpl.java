package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.channel.bean.FriendListBean;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemFriendListGroupBindingImpl extends ChannelItemFriendListGroupBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33248a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7980a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7982a;

    public ChannelItemFriendListGroupBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f7980a, f33248a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7981a;
            this.f7981a = 0L;
        }
        FriendListBean friendListBean = ((ChannelItemFriendListGroupBinding) this).f33247a;
        long j2 = j & 3;
        String groupName = (j2 == 0 || friendListBean == null) ? null : friendListBean.getGroupName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f7982a, groupName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7981a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7981a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemFriendListGroupBinding
    public void k(@Nullable FriendListBean friendListBean) {
        ((ChannelItemFriendListGroupBinding) this).f33247a = friendListBean;
        synchronized (this) {
            this.f7981a |= 1;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g != i) {
            return false;
        }
        k((FriendListBean) obj);
        return true;
    }

    public ChannelItemFriendListGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f7981a = -1L;
        TextView textView = (TextView) objArr[0];
        this.f7982a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
