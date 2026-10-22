package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentMoreBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemCommentMoreBindingImpl extends WorksItemCommentMoreBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37020a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14529a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBar f14533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14534a;

    public WorksItemCommentMoreBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14529a, f37020a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String string;
        boolean z;
        synchronized (this) {
            j = this.f14530a;
            this.f14530a = 0L;
        }
        CommentMoreBean commentMoreBean = ((WorksItemCommentMoreBinding) this).f37019a;
        long j2 = j & 3;
        boolean zIsLoading = false;
        if (j2 != 0) {
            zIsLoading = commentMoreBean != null ? commentMoreBean.isLoading() : false;
            if (j2 != 0) {
                j |= zIsLoading ? 8L : 4L;
            }
            string = this.f14534a.getResources().getString(zIsLoading ? R.string.brvah_loading : R.string.works_comment_more);
            z = !zIsLoading;
        } else {
            string = null;
            z = false;
        }
        if ((j & 3) != 0) {
            CommonBindingAdapter.l0(this.f14533a, zIsLoading);
            TextViewBindingAdapter.setText(this.f14534a, string);
            CommonBindingAdapter.l0(this.f14531a, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14530a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14530a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemCommentMoreBinding
    public void k(@Nullable CommentMoreBean Bean) {
        ((WorksItemCommentMoreBinding) this).f37019a = Bean;
        synchronized (this) {
            this.f14530a |= 1;
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
        k((CommentMoreBean) variable);
        return true;
    }

    public WorksItemCommentMoreBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0);
        this.f14530a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14532a = linearLayout;
        linearLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) bindings[1];
        this.f14533a = progressBar;
        progressBar.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14534a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[3];
        this.f14531a = imageView;
        imageView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
