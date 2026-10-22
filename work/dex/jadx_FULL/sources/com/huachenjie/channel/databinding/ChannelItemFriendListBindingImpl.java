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
import com.huachenjie.channel.bean.FriendListBean;
import com.huachenjie.im.bean.FriendUserInfo;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemFriendListBindingImpl extends ChannelItemFriendListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33246a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7975a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7979a;

    public ChannelItemFriendListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7975a, f33246a));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String avatar;
        String avatarFrameImgUrl;
        String nickName;
        synchronized (this) {
            j = this.f7976a;
            this.f7976a = 0L;
        }
        FriendListBean friendListBean = ((ChannelItemFriendListBinding) this).f33245a;
        long j2 = j & 3;
        if (j2 == 0) {
            avatar = null;
            avatarFrameImgUrl = null;
            nickName = null;
        } else {
            FriendUserInfo userInfo = friendListBean != null ? friendListBean.getUserInfo() : null;
            if (userInfo != null) {
                avatarFrameImgUrl = userInfo.getAvatarFrameImgUrl();
                nickName = userInfo.formatNickName();
                avatar = userInfo.getAvatar();
            } else {
                avatar = null;
                avatarFrameImgUrl = null;
                nickName = null;
            }
        }
        if (j2 != 0) {
            aw9.d(this.f7979a, avatar, false, null);
            aw9.c(this.f7979a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.f7978a, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7976a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7976a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemFriendListBinding
    public void k(@Nullable FriendListBean friendListBean) {
        ((ChannelItemFriendListBinding) this).f33245a = friendListBean;
        synchronized (this) {
            this.f7976a |= 1;
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

    public ChannelItemFriendListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f7976a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7977a = linearLayout;
        linearLayout.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[1];
        this.f7979a = avatarView;
        avatarView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f7978a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
