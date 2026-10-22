package com.huachenjie.mine.databinding;

import android.text.TextUtils;
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
import com.huachenjie.mine.R;
import com.huachenjie.works.bean.PostImageBean;
import com.huachenjie.works.bean.PostInfoBean;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.bean.PostUserBean;
import com.huachenjie.works.widget.PostNineGridView;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.ik0;
import com.zj.adlib.zv9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineItemPostBindingImpl extends MineItemPostBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11335a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11337a;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35348a = sparseIntArray;
        sparseIntArray.put(R.id.tv_content, 7);
    }

    public MineItemPostBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f11335a, f35348a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String publishTime;
        String avatar;
        List<PostImageBean> imageList;
        String avatarFrameImgUrl;
        String nickName;
        String str;
        PostInfoBean postInfo;
        PostUserBean userInfo;
        String redPacket;
        synchronized (this) {
            j = this.f11336a;
            this.f11336a = 0L;
        }
        PostItemBean postItemBean = ((MineItemPostBinding) this).f11332a;
        long j2 = j & 3;
        if (j2 != 0) {
            if (postItemBean != null) {
                postInfo = postItemBean.getPostInfo();
                userInfo = postItemBean.getUserInfo();
                publishTime = postItemBean.formatPublishTime();
            } else {
                postInfo = null;
                publishTime = null;
                userInfo = null;
            }
            if (postInfo != null) {
                imageList = postInfo.getImageList();
                redPacket = postInfo.getRedPacket();
            } else {
                redPacket = null;
                imageList = null;
            }
            if (userInfo != null) {
                avatarFrameImgUrl = userInfo.getAvatarFrameImgUrl();
                nickName = userInfo.getNickName();
                avatar = userInfo.getAvatar();
            } else {
                avatar = null;
                avatarFrameImgUrl = null;
                nickName = null;
            }
            str = String.format("¥%s", redPacket);
            z = !TextUtils.isEmpty(redPacket);
        } else {
            z = false;
            publishTime = null;
            avatar = null;
            imageList = null;
            avatarFrameImgUrl = null;
            nickName = null;
            str = null;
        }
        if (j2 != 0) {
            aw9.d(((MineItemPostBinding) this).f11331a, avatar, false, null);
            aw9.c(((MineItemPostBinding) this).f11331a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(this.d, str);
            zv9.c(((MineItemPostBinding) this).f11333a, imageList);
            CommonBindingAdapter.l0(((MineItemPostBinding) this).f11334a, z);
            TextViewBindingAdapter.setText(this.b, nickName);
            TextViewBindingAdapter.setText(this.c, publishTime);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11336a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11336a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineItemPostBinding
    public void k(@Nullable PostItemBean postItemBean) {
        ((MineItemPostBinding) this).f11332a = postItemBean;
        synchronized (this) {
            this.f11336a |= 1;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 != i) {
            return false;
        }
        k((PostItemBean) obj);
        return true;
    }

    public MineItemPostBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AvatarView) objArr[1], (PostNineGridView) objArr[4], (BLLinearLayout) objArr[5], (TextView) objArr[7], (TextView) objArr[2], (TextView) objArr[3]);
        this.f11336a = -1L;
        ((MineItemPostBinding) this).f11331a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f11337a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.d = textView;
        textView.setTag(null);
        ((MineItemPostBinding) this).f11333a.setTag(null);
        ((MineItemPostBinding) this).f11334a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
