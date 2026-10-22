package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.im.bean.ContactUserBean;
import com.noober.background.view.BLTextView;
import com.vanniktech.emoji.EmojiTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.j64;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemFlashMessageSingleChatBindingImpl extends ChannelItemFlashMessageSingleChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33242a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7963a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7966a;

    public ChannelItemFlashMessageSingleChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f7963a, f33242a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean z;
        String strS;
        String avatarFrameImgUrl;
        String strC;
        String content;
        String avatar;
        String nickName;
        long time;
        int unreadCount;
        Boolean boolIsMyFriend;
        synchronized (this) {
            j = this.f7964a;
            this.f7964a = 0L;
        }
        ContactUserBean contactUserBean = ((ChannelItemFlashMessageSingleChatBinding) this).f7961a;
        long j2 = 3 & j;
        if (j2 != 0) {
            if (contactUserBean != null) {
                avatarFrameImgUrl = contactUserBean.getAvatarFrameImgUrl();
                time = contactUserBean.getTime();
                content = contactUserBean.getContent();
                avatar = contactUserBean.getAvatar();
                nickName = contactUserBean.getNickName();
                boolIsMyFriend = contactUserBean.isMyFriend();
                unreadCount = contactUserBean.getUnreadCount();
            } else {
                time = 0;
                unreadCount = 0;
                avatarFrameImgUrl = null;
                content = null;
                avatar = null;
                nickName = null;
                boolIsMyFriend = null;
            }
            strC = j64.c(time);
            boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(boolIsMyFriend);
            boolean z2 = unreadCount > 0;
            strS = j64.s(unreadCount);
            zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox2));
            z = z2;
        } else {
            zSafeUnbox = false;
            z = false;
            strS = null;
            avatarFrameImgUrl = null;
            strC = null;
            content = null;
            avatar = null;
            nickName = null;
        }
        if (j2 != 0) {
            aw9.d(((ChannelItemFlashMessageSingleChatBinding) this).f7960a, avatar, false, null);
            aw9.c(((ChannelItemFlashMessageSingleChatBinding) this).f7960a, avatarFrameImgUrl, null);
            CommonBindingAdapter.l0(this.f7966a, zSafeUnbox);
            TextViewBindingAdapter.setText(((ChannelItemFlashMessageSingleChatBinding) this).f33241a, nickName);
            TextViewBindingAdapter.setText(this.b, strC);
            TextViewBindingAdapter.setText(((ChannelItemFlashMessageSingleChatBinding) this).f7962a, content);
            TextViewBindingAdapter.setText(this.c, strS);
            CommonBindingAdapter.l0(this.c, z);
        }
        if ((j & 2) != 0) {
            DrawablesBindingAdapter.h(this.c, 0, -57312, 0, 0.0f, 0.0f, 0.0f, 18.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7964a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7964a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemFlashMessageSingleChatBinding
    public void k(@Nullable ContactUserBean contactUserBean) {
        ((ChannelItemFlashMessageSingleChatBinding) this).f7961a = contactUserBean;
        synchronized (this) {
            this.f7964a |= 1;
        }
        notifyPropertyChanged(tk0.o);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.o != i) {
            return false;
        }
        k((ContactUserBean) obj);
        return true;
    }

    public ChannelItemFlashMessageSingleChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (TextView) objArr[3], (TextView) objArr[5], (EmojiTextView) objArr[6], (TextView) objArr[4]);
        this.f7964a = -1L;
        ((ChannelItemFlashMessageSingleChatBinding) this).f7960a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7965a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f7966a = bLTextView;
        bLTextView.setTag(null);
        ((ChannelItemFlashMessageSingleChatBinding) this).f33241a.setTag(null);
        this.b.setTag(null);
        ((ChannelItemFlashMessageSingleChatBinding) this).f7962a.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
