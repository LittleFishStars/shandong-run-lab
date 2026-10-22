package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.widget.FriendFollowButton;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mine.R;
import com.zj.adlib.aw9;
import com.zj.adlib.ik0;
import com.zj.adlib.yv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineItemFansAndAttentionBindingImpl extends MineItemFansAndAttentionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11328a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11330a;

    @NonNull
    public final TextView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35346a = sparseIntArray;
        sparseIntArray.put(R.id.iv_menu, 5);
    }

    public MineItemFansAndAttentionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f11328a, f35346a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String avatarFrameImgUrl;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f11329a;
            this.f11329a = 0L;
        }
        Boolean bool = ((MineItemFansAndAttentionBinding) this).f11327a;
        FansBean fansBean = ((MineItemFansAndAttentionBinding) this).f11325a;
        long j2 = 5 & j;
        boolean zSafeUnbox = j2 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j3 = j & 6;
        if (j3 == 0 || fansBean == null) {
            str = null;
            avatarFrameImgUrl = null;
            nickName = null;
            avatar = null;
        } else {
            str = fansBean.formatterUserWorks();
            avatarFrameImgUrl = fansBean.getAvatarFrameImgUrl();
            nickName = fansBean.getNickName();
            avatar = fansBean.getAvatar();
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((MineItemFansAndAttentionBinding) this).f11326a, zSafeUnbox);
        }
        if (j3 != 0) {
            yv9.a(((MineItemFansAndAttentionBinding) this).f11326a, fansBean, 3);
            aw9.d(((MineItemFansAndAttentionBinding) this).f11324a, avatar, false, null);
            aw9.c(((MineItemFansAndAttentionBinding) this).f11324a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(((MineItemFansAndAttentionBinding) this).f11323a, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11329a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11329a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineItemFansAndAttentionBinding
    public void l(@Nullable FansBean fansBean) {
        ((MineItemFansAndAttentionBinding) this).f11325a = fansBean;
        synchronized (this) {
            this.f11329a |= 2;
        }
        notifyPropertyChanged(ik0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineItemFansAndAttentionBinding
    public void m(@Nullable Boolean bool) {
        ((MineItemFansAndAttentionBinding) this).f11327a = bool;
        synchronized (this) {
            this.f11329a |= 1;
        }
        notifyPropertyChanged(ik0.Z);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.Z == i) {
            m((Boolean) obj);
        } else {
            if (ik0.g != i) {
                return false;
            }
            l((FansBean) obj);
        }
        return true;
    }

    public MineItemFansAndAttentionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FriendFollowButton) objArr[4], (AvatarView) objArr[1], (ImageView) objArr[5], (TextView) objArr[2]);
        this.f11329a = -1L;
        ((MineItemFansAndAttentionBinding) this).f11326a.setTag(null);
        ((MineItemFansAndAttentionBinding) this).f11324a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11330a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.b = textView;
        textView.setTag(null);
        ((MineItemFansAndAttentionBinding) this).f11323a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
