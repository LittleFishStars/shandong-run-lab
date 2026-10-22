package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLEditText;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogAddFriendBindingImpl extends WorksDialogAddFriendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13965a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f13968a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36816a = sparseIntArray;
        sparseIntArray.put(R.id.et_content, 3);
        sparseIntArray.put(R.id.bt_cancel, 4);
        sparseIntArray.put(R.id.bt_apply, 5);
    }

    public WorksDialogAddFriendBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f13965a, f36816a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String avatarFrameImgUrl;
        String nickName;
        String avatar;
        synchronized (this) {
            j = this.f13966a;
            this.f13966a = 0L;
        }
        UserInfoBean userInfoBean = ((WorksDialogAddFriendBinding) this).f13962a;
        long j2 = j & 3;
        if (j2 == 0 || userInfoBean == null) {
            avatarFrameImgUrl = null;
            nickName = null;
            avatar = null;
        } else {
            avatarFrameImgUrl = userInfoBean.getAvatarFrameImgUrl();
            nickName = userInfoBean.getNickName();
            avatar = userInfoBean.getAvatar();
        }
        if (j2 != 0) {
            aw9.d(this.f13968a, avatar, false, null);
            aw9.c(this.f13968a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(((WorksDialogAddFriendBinding) this).f36815a, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13966a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13966a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogAddFriendBinding
    public void k(@Nullable UserInfoBean Bean) {
        ((WorksDialogAddFriendBinding) this).f13962a = Bean;
        synchronized (this) {
            this.f13966a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((UserInfoBean) variable);
        return true;
    }

    public WorksDialogAddFriendBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLButton) bindings[5], (BLButton) bindings[4], (BLEditText) bindings[3], (TextView) bindings[2]);
        this.f13966a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f13967a = frameLayout;
        frameLayout.setTag(null);
        AvatarView avatarView = (AvatarView) bindings[1];
        this.f13968a = avatarView;
        avatarView.setTag(null);
        ((WorksDialogAddFriendBinding) this).f36815a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
