package com.huachenjie.works.databinding;

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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.ChatTeamBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemChooseTeamBindingImpl extends WorksItemChooseTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14511a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14515a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37014a = sparseIntArray;
        sparseIntArray.put(R.id.tv_share, 3);
    }

    public WorksItemChooseTeamBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14511a, f37014a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String teamTitle;
        synchronized (this) {
            j = this.f14512a;
            this.f14512a = 0L;
        }
        ChatTeamBean chatTeamBean = ((WorksItemChooseTeamBinding) this).f37013a;
        long j2 = j & 3;
        String logoUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.b;
            if (chatTeamBean != null) {
                logoUrl = chatTeamBean.getLogoUrl();
                teamTitle = chatTeamBean.getTeamTitle();
            } else {
                teamTitle = null;
            }
        } else {
            requestOptions = null;
            teamTitle = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f14513a, logoUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f14515a, teamTitle);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14512a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14512a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemChooseTeamBinding
    public void k(@Nullable ChatTeamBean Bean) {
        ((WorksItemChooseTeamBinding) this).f37013a = Bean;
        synchronized (this) {
            this.f14512a |= 1;
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
        k((ChatTeamBean) variable);
        return true;
    }

    public WorksItemChooseTeamBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLTextView) bindings[3]);
        this.f14512a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14514a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f14513a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14515a = textView;
        textView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
