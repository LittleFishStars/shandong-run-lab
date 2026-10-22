package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.bean.PostCategoryBean;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemPublishPostBindingImpl extends WorksItemPublishPostBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37057a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14655a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f14657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14658a;

    @NonNull
    public final TextView b;

    public WorksItemPublishPostBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14655a, f37057a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String nickname;
        String str;
        synchronized (this) {
            j = this.f14656a;
            this.f14656a = 0L;
        }
        PostCategoryBean postCategoryBean = ((WorksItemPublishPostBinding) this).f14654a;
        long j2 = j & 3;
        String str2 = null;
        if (j2 != 0) {
            requestOptions = ju3.h;
            if (postCategoryBean != null) {
                String description = postCategoryBean.getDescription();
                nickname = postCategoryBean.getNickname();
                String logo = postCategoryBean.getLogo();
                str = description;
                str2 = logo;
            } else {
                nickname = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((WorksItemPublishPostBinding) this).f37056a, str2, requestOptions, false);
                TextViewBindingAdapter.setText(this.f14658a, nickname);
                TextViewBindingAdapter.setText(this.b, str);
            }
        }
        requestOptions = null;
        nickname = null;
        str = nickname;
        if (j2 != 0) {
            CommonBindingAdapter.b0(((WorksItemPublishPostBinding) this).f37056a, str2, requestOptions, false);
            TextViewBindingAdapter.setText(this.f14658a, nickname);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14656a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14656a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemPublishPostBinding
    public void k(@Nullable PostCategoryBean Bean) {
        ((WorksItemPublishPostBinding) this).f14654a = Bean;
        synchronized (this) {
            this.f14656a |= 1;
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
        k((PostCategoryBean) variable);
        return true;
    }

    public WorksItemPublishPostBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1]);
        this.f14656a = -1L;
        ((WorksItemPublishPostBinding) this).f37056a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f14657a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14658a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
