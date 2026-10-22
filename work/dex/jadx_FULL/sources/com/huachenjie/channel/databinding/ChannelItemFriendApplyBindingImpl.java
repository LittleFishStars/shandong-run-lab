package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.bean.FriendApplyBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemFriendApplyBindingImpl extends ChannelItemFriendApplyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33244a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7971a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7974a;

    public ChannelItemFriendApplyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f7971a, f33244a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        int i;
        CharSequence closeContent;
        boolean textExpand;
        boolean z2;
        String str2;
        String str3;
        boolean z3;
        String str4;
        boolean z4;
        boolean z5;
        CharSequence charSequence;
        String avatarFrameImgUrl;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f7972a;
            this.f7972a = 0L;
        }
        FriendApplyBean friendApplyBean = ((ChannelItemFriendApplyBinding) this).f7970a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (friendApplyBean != null) {
                avatarFrameImgUrl = friendApplyBean.getAvatarFrameImgUrl();
                closeContent = friendApplyBean.getCloseContent();
                nickName = friendApplyBean.getNickName();
                avatar = friendApplyBean.getAvatar();
                int status = friendApplyBean.getStatus();
                textExpand = friendApplyBean.getTextExpand();
                i = status;
            } else {
                i = 0;
                avatarFrameImgUrl = null;
                closeContent = null;
                nickName = null;
                avatar = null;
                textExpand = false;
            }
            if (j2 != 0) {
                j = textExpand ? j | 8 : j | 4;
            }
            boolean zIsEmpty = TextUtils.isEmpty(closeContent);
            boolean z6 = i == 0;
            z2 = i == 1;
            if ((j & 3) != 0) {
                j = z2 ? j | 32 | 512 : j | 16 | 256;
            }
            z = !zIsEmpty;
            str = avatarFrameImgUrl;
            str2 = nickName;
            str3 = avatar;
            z3 = z6;
        } else {
            z = false;
            str = null;
            i = 0;
            closeContent = null;
            textExpand = false;
            z2 = false;
            str2 = null;
            str3 = null;
            z3 = false;
        }
        if ((j & 272) != 0) {
            z4 = i == 2;
            if ((j & 256) != 0) {
                j |= z4 ? 128L : 64L;
            }
            if ((256 & j) != 0) {
                str4 = z4 ? "已拒绝" : "";
            } else {
                str4 = null;
            }
        } else {
            str4 = null;
            z4 = false;
        }
        CharSequence expandContent = ((8 & j) == 0 || friendApplyBean == null) ? null : friendApplyBean.getExpandContent();
        long j3 = j & 3;
        if (j3 != 0) {
            if (textExpand) {
                closeContent = expandContent;
            }
            boolean z7 = z2 ? true : z4;
            if (z2) {
                str4 = "已添加";
            }
            z5 = z7;
            charSequence = closeContent;
        } else {
            z5 = false;
            charSequence = null;
            str4 = null;
        }
        if (j3 != 0) {
            aw9.d(((ChannelItemFriendApplyBinding) this).f7969a, str3, false, null);
            aw9.c(((ChannelItemFriendApplyBinding) this).f7969a, str, null);
            CommonBindingAdapter.l0(this.f7974a, z5);
            TextViewBindingAdapter.setText(this.f7974a, str4);
            boolean z8 = z3;
            CommonBindingAdapter.l0(((ChannelItemFriendApplyBinding) this).f33243a, z8);
            CommonBindingAdapter.l0(this.b, z8);
            TextViewBindingAdapter.setText(((ChannelItemFriendApplyBinding) this).f7967a, str2);
            CommonBindingAdapter.l0(((ChannelItemFriendApplyBinding) this).f7968a, z);
            TextViewBindingAdapter.setText(((ChannelItemFriendApplyBinding) this).f7968a, charSequence);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7972a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7972a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemFriendApplyBinding
    public void k(@Nullable FriendApplyBean friendApplyBean) {
        ((ChannelItemFriendApplyBinding) this).f7970a = friendApplyBean;
        synchronized (this) {
            this.f7972a |= 1;
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
        k((FriendApplyBean) obj);
        return true;
    }

    public ChannelItemFriendApplyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (ImageView) objArr[5], (ImageView) objArr[6], (TextView) objArr[2], (ExpandableTextView) objArr[3]);
        this.f7972a = -1L;
        ((ChannelItemFriendApplyBinding) this).f7969a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7973a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f7974a = bLTextView;
        bLTextView.setTag(null);
        ((ChannelItemFriendApplyBinding) this).f33243a.setTag(null);
        this.b.setTag(null);
        ((ChannelItemFriendApplyBinding) this).f7967a.setTag(null);
        ((ChannelItemFriendApplyBinding) this).f7968a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
