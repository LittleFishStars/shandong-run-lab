package com.huachenjie.mall.databinding;

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
import com.huachenjie.mall.bean.MessageContactBean;
import com.noober.background.view.BLTextView;
import com.vanniktech.emoji.EmojiTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.hk0;
import com.zj.adlib.j64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemShoppingMessageBindingImpl extends MallItemShoppingMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35041a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10931a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10933a;

    public MallItemShoppingMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10931a, f35041a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        long j2;
        boolean z;
        String strC;
        String strS;
        String str;
        String str2;
        String nickname;
        int i;
        int unreadCount;
        synchronized (this) {
            j = this.f10932a;
            j2 = 0;
            this.f10932a = 0L;
        }
        MessageContactBean messageContactBean = ((MallItemShoppingMessageBinding) this).f10928a;
        long j3 = j & 3;
        if (j3 != 0) {
            if (messageContactBean != null) {
                String content = messageContactBean.getContent();
                int unreadCount2 = messageContactBean.getUnreadCount();
                long time = messageContactBean.getTime();
                unreadCount = messageContactBean.getUnreadCount();
                nickname = messageContactBean.getNickname();
                String avatarUrl = messageContactBean.getAvatarUrl();
                str = content;
                i = unreadCount2;
                str2 = avatarUrl;
                j2 = time;
            } else {
                i = 0;
                unreadCount = 0;
                str = null;
                str2 = null;
                nickname = null;
            }
            z = i > 0;
            strC = j64.c(j2);
            strS = j64.s(unreadCount);
        } else {
            z = false;
            strC = null;
            strS = null;
            str = null;
            str2 = null;
            nickname = null;
        }
        if (j3 != 0) {
            aw9.d(((MallItemShoppingMessageBinding) this).f10927a, str2, false, null);
            TextViewBindingAdapter.setText(((MallItemShoppingMessageBinding) this).f35040a, nickname);
            TextViewBindingAdapter.setText(this.b, strC);
            TextViewBindingAdapter.setText(((MallItemShoppingMessageBinding) this).f10930a, str);
            CommonBindingAdapter.l0(((MallItemShoppingMessageBinding) this).f10929a, z);
            TextViewBindingAdapter.setText(((MallItemShoppingMessageBinding) this).f10929a, strS);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10932a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10932a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemShoppingMessageBinding
    public void k(@Nullable MessageContactBean messageContactBean) {
        ((MallItemShoppingMessageBinding) this).f10928a = messageContactBean;
        synchronized (this) {
            this.f10932a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((MessageContactBean) obj);
        return true;
    }

    public MallItemShoppingMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (EmojiTextView) objArr[4], (BLTextView) objArr[5]);
        this.f10932a = -1L;
        ((MallItemShoppingMessageBinding) this).f10927a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10933a = constraintLayout;
        constraintLayout.setTag(null);
        ((MallItemShoppingMessageBinding) this).f35040a.setTag(null);
        this.b.setTag(null);
        ((MallItemShoppingMessageBinding) this).f10930a.setTag(null);
        ((MallItemShoppingMessageBinding) this).f10929a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
