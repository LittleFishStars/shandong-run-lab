package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.bean.notify.BuddyDetailUserBean;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemBuddyMemberBindingImpl extends ChannelItemBuddyMemberBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33227a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7924a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7928a;

    public ChannelItemBuddyMemberBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7924a, f33227a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f7925a;
            this.f7925a = 0L;
        }
        BuddyDetailUserBean buddyDetailUserBean = ((ChannelItemBuddyMemberBinding) this).f33226a;
        long j2 = j & 3;
        if (j2 == 0 || buddyDetailUserBean == null) {
            nickName = null;
            avatar = null;
        } else {
            nickName = buddyDetailUserBean.getNickName();
            avatar = buddyDetailUserBean.getAvatar();
        }
        if (j2 != 0) {
            aw9.d(this.f7928a, avatar, false, null);
            TextViewBindingAdapter.setText(this.f7927a, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7925a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7925a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemBuddyMemberBinding
    public void k(@Nullable BuddyDetailUserBean buddyDetailUserBean) {
        ((ChannelItemBuddyMemberBinding) this).f33226a = buddyDetailUserBean;
        synchronized (this) {
            this.f7925a |= 1;
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
        k((BuddyDetailUserBean) obj);
        return true;
    }

    public ChannelItemBuddyMemberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f7925a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7926a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[1];
        this.f7928a = avatarView;
        avatarView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f7927a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
