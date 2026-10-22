package com.huachenjie.works.databinding;

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
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCommentBean;
import com.huachenjie.works.bean.PostCommentUserBean;
import com.huachenjie.works.bean.PostItemBean;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksLayoutPostCommentBindingImpl extends WorksLayoutPostCommentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14786a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14788a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37101a = sparseIntArray;
        sparseIntArray.put(R.id.comment_content, 5);
    }

    public WorksLayoutPostCommentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f14786a, f37101a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean liked;
        boolean z;
        String strValueOf;
        String time;
        String avatar;
        int likeCount;
        PostCommentUserBean userInfo;
        synchronized (this) {
            j = this.f14787a;
            this.f14787a = 0L;
        }
        Integer num = ((WorksLayoutPostCommentBinding) this).f14785a;
        PostItemBean postItemBean = ((WorksLayoutPostCommentBinding) this).f14784a;
        long j2 = j & 7;
        if (j2 != 0) {
            PostCommentBean postCommentBeanFindCommentUse = postItemBean != null ? postItemBean.findCommentUse(ViewDataBinding.safeUnbox(num)) : null;
            if (postCommentBeanFindCommentUse != null) {
                liked = postCommentBeanFindCommentUse.getLiked();
                time = postCommentBeanFindCommentUse.formatTime();
                userInfo = postCommentBeanFindCommentUse.getUserInfo();
                likeCount = postCommentBeanFindCommentUse.getLikeCount();
            } else {
                likeCount = 0;
                liked = false;
                time = null;
                userInfo = null;
            }
            z = !liked;
            strValueOf = String.valueOf(likeCount);
            avatar = userInfo != null ? userInfo.getAvatar() : null;
        } else {
            liked = false;
            z = false;
            strValueOf = null;
            time = null;
            avatar = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.b, time);
            aw9.d(((WorksLayoutPostCommentBinding) this).f14783a, avatar, false, null);
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.c, strValueOf);
            CommonBindingAdapter.l0(this.d, liked);
            TextViewBindingAdapter.setText(this.d, strValueOf);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14787a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14787a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksLayoutPostCommentBinding
    public void l(@Nullable Integer Index) {
        ((WorksLayoutPostCommentBinding) this).f14785a = Index;
        synchronized (this) {
            this.f14787a |= 1;
        }
        notifyPropertyChanged(qk0.w);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksLayoutPostCommentBinding
    public void m(@Nullable PostItemBean Vm) {
        ((WorksLayoutPostCommentBinding) this).f14784a = Vm;
        synchronized (this) {
            this.f14787a |= 2;
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
        if (qk0.w == variableId) {
            l((Integer) variable);
        } else {
            if (qk0.p0 != variableId) {
                return false;
            }
            m((PostItemBean) variable);
        }
        return true;
    }

    public WorksLayoutPostCommentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[2], (AvatarView) bindings[1]);
        this.f14787a = -1L;
        this.b.setTag(null);
        ((WorksLayoutPostCommentBinding) this).f14783a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14788a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[4];
        this.d = textView2;
        textView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
