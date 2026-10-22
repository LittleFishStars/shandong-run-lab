package com.huachenjie.social_contact.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.MirrorDimensionBean;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemShareEmojiFriendBindingImpl extends ItemShareEmojiFriendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12992a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12993a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12995a;

    @NonNull
    public final TextView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36192a = sparseIntArray;
        sparseIntArray.put(R.id.tv_share, 4);
    }

    public ItemShareEmojiFriendBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12992a, f36192a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean zIsEmpty;
        String str;
        String str2;
        String avatarFrameImgUrl;
        String remarkNickname;
        String attitudeName;
        String avatar;
        synchronized (this) {
            j = this.f12993a;
            this.f12993a = 0L;
        }
        MirrorDimensionBean mirrorDimensionBean = ((ItemShareEmojiFriendBinding) this).f12990a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (mirrorDimensionBean != null) {
                attitudeName = mirrorDimensionBean.getAttitudeName();
                avatarFrameImgUrl = mirrorDimensionBean.getAvatarFrameImgUrl();
                remarkNickname = mirrorDimensionBean.getRemarkNickname();
                avatar = mirrorDimensionBean.getAvatar();
            } else {
                attitudeName = null;
                avatarFrameImgUrl = null;
                remarkNickname = null;
                avatar = null;
            }
            boolean zIsEmpty2 = TextUtils.isEmpty(attitudeName);
            str = String.format("%s#", attitudeName);
            zIsEmpty = TextUtils.isEmpty(remarkNickname);
            if (j2 != 0) {
                j = zIsEmpty ? j | 8 : j | 4;
            }
            z = !zIsEmpty2;
            str2 = avatar;
        } else {
            z = false;
            zIsEmpty = false;
            str = null;
            str2 = null;
            avatarFrameImgUrl = null;
            remarkNickname = null;
        }
        String nickName = ((8 & j) == 0 || mirrorDimensionBean == null) ? null : mirrorDimensionBean.getNickName();
        long j3 = j & 3;
        if (j3 == 0) {
            remarkNickname = null;
        } else if (zIsEmpty) {
            remarkNickname = nickName;
        }
        if (j3 != 0) {
            aw9.d(((ItemShareEmojiFriendBinding) this).f36191a, str2, false, null);
            aw9.c(((ItemShareEmojiFriendBinding) this).f36191a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.f12994a, remarkNickname);
            CommonBindingAdapter.l0(this.b, z);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12993a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12993a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ItemShareEmojiFriendBinding
    public void k(@Nullable MirrorDimensionBean mirrorDimensionBean) {
        ((ItemShareEmojiFriendBinding) this).f12990a = mirrorDimensionBean;
        synchronized (this) {
            this.f12993a |= 1;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 != i) {
            return false;
        }
        k((MirrorDimensionBean) obj);
        return true;
    }

    public ItemShareEmojiFriendBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (BLTextView) objArr[4]);
        this.f12993a = -1L;
        ((ItemShareEmojiFriendBinding) this).f36191a.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f12995a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12994a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
