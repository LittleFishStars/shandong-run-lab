package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.InteractBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemAttentionWorksBottomBindingImpl extends WorksItemAttentionWorksBottomBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14440a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14442a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36998a = sparseIntArray;
        sparseIntArray.put(R.id.llShare, 5);
        sparseIntArray.put(R.id.ivShare, 6);
        sparseIntArray.put(R.id.llComment, 7);
        sparseIntArray.put(R.id.ivComment, 8);
        sparseIntArray.put(R.id.tvCollection, 9);
    }

    public WorksItemAttentionWorksBottomBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f14440a, f36998a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int i;
        int likeCount;
        String str;
        String str2;
        String str3;
        String str4;
        boolean zHasLiked;
        boolean zHasCollected;
        InteractBean interactInfo;
        UserInfoBean userInfo;
        String worksNo;
        String commentCount;
        String shareCount;
        synchronized (this) {
            j = this.f14441a;
            this.f14441a = 0L;
        }
        WorkDetailBean workDetailBean = ((WorksItemAttentionWorksBottomBinding) this).f14435a;
        long j2 = j & 3;
        boolean z2 = false;
        if (j2 != 0) {
            if (workDetailBean != null) {
                zHasLiked = workDetailBean.hasLiked();
                userInfo = workDetailBean.getUserInfo();
                zHasCollected = workDetailBean.hasCollected();
                worksNo = workDetailBean.getWorksNo();
                commentCount = workDetailBean.formatCommentCount();
                shareCount = workDetailBean.formatShareCount();
                interactInfo = workDetailBean.getInteractInfo();
            } else {
                zHasLiked = false;
                zHasCollected = false;
                interactInfo = null;
                userInfo = null;
                worksNo = null;
                commentCount = null;
                shareCount = null;
            }
            String appUserCode = userInfo != null ? userInfo.getAppUserCode() : null;
            if (interactInfo != null) {
                int collecteCount = interactInfo.getCollecteCount();
                likeCount = interactInfo.getLikeCount();
                str4 = appUserCode;
                z = zHasLiked;
                str3 = worksNo;
                str2 = commentCount;
                str = shareCount;
                boolean z3 = zHasCollected;
                i = collecteCount;
                z2 = z3;
            } else {
                likeCount = 0;
                str4 = appUserCode;
                z = zHasLiked;
                str3 = worksNo;
                str2 = commentCount;
                str = shareCount;
                z2 = zHasCollected;
                i = 0;
            }
        } else {
            z = false;
            i = 0;
            likeCount = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
        }
        if (j2 != 0) {
            zv9.b(((WorksItemAttentionWorksBottomBinding) this).f14436a, 1, Boolean.valueOf(z2), i, str3, str4, null, null, 1);
            zv9.b(((WorksItemAttentionWorksBottomBinding) this).f14439b, 2, Boolean.valueOf(z), likeCount, str3, str4, null, null, 1);
            TextViewBindingAdapter.setText(((WorksItemAttentionWorksBottomBinding) this).f14438b, str2);
            TextViewBindingAdapter.setText(this.c, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14441a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14441a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemAttentionWorksBottomBinding
    public void k(@Nullable WorkDetailBean Vm) {
        ((WorksItemAttentionWorksBottomBinding) this).f14435a = Vm;
        synchronized (this) {
            this.f14441a |= 1;
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
        k((WorkDetailBean) variable);
        return true;
    }

    public WorksItemAttentionWorksBottomBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[8], (ImageView) bindings[6], (BLOperateAnimView) bindings[3], (LinearLayout) bindings[7], (BLOperateAnimView) bindings[4], (LinearLayout) bindings[5], (TextView) bindings[9], (TextView) bindings[2], (TextView) bindings[1]);
        this.f14441a = -1L;
        ((WorksItemAttentionWorksBottomBinding) this).f14436a.setTag(null);
        ((WorksItemAttentionWorksBottomBinding) this).f14439b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14442a = constraintLayout;
        constraintLayout.setTag(null);
        ((WorksItemAttentionWorksBottomBinding) this).f14438b.setTag(null);
        this.c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
