package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.works.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemChooseFriendBindingImpl extends WorksItemChooseFriendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14506a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14509a;

    @NonNull
    public final TextView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37012a = sparseIntArray;
        sparseIntArray.put(R.id.tv_share, 4);
    }

    public WorksItemChooseFriendBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14506a, f37012a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String nickName;
        String avatar;
        String avatarFrameImgUrl;
        String signature;
        synchronized (this) {
            j = this.f14507a;
            this.f14507a = 0L;
        }
        FriendUserInfo friendUserInfo = ((WorksItemChooseFriendBinding) this).f14504a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (friendUserInfo != null) {
                signature = friendUserInfo.getSignature();
                avatar = friendUserInfo.getAvatar();
                avatarFrameImgUrl = friendUserInfo.getAvatarFrameImgUrl();
                nickName = friendUserInfo.formatNickName();
            } else {
                signature = null;
                nickName = null;
                avatar = null;
                avatarFrameImgUrl = null;
            }
            str = String.format("%s", signature);
        } else {
            str = null;
            nickName = null;
            avatar = null;
            avatarFrameImgUrl = null;
        }
        if (j2 != 0) {
            aw9.d(((WorksItemChooseFriendBinding) this).f37011a, avatar, false, null);
            aw9.c(((WorksItemChooseFriendBinding) this).f37011a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.f14508a, nickName);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14507a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14507a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemChooseFriendBinding
    public void k(@Nullable FriendUserInfo Vm) {
        ((WorksItemChooseFriendBinding) this).f14504a = Vm;
        synchronized (this) {
            this.f14507a |= 1;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((FriendUserInfo) variable);
        return true;
    }

    public WorksItemChooseFriendBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AvatarView) bindings[1], (BLTextView) bindings[4]);
        this.f14507a = -1L;
        ((WorksItemChooseFriendBinding) this).f37011a.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f14509a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14508a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
