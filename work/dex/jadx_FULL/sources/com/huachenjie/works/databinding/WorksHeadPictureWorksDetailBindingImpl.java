package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.works.bean.AttachmentBean;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorkImageBean;
import com.huachenjie.works.page.details.picture.PictureWorksDetailFragment;
import com.huachenjie.works.page.details.picture.PictureWorksDetailModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;
import com.zj.adlib.zv9;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksHeadPictureWorksDetailBindingImpl extends WorksHeadPictureWorksDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36977a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14380a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14384a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PictureWorksDetailFragment.a f36978a;

        public a a(PictureWorksDetailFragment.a value) {
            this.f36978a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36978a.d(arg0);
        }
    }

    public WorksHeadPictureWorksDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, f14380a, f36977a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean zShowCategoryTag;
        boolean zShowChannelName;
        boolean z3;
        boolean z4;
        String categoryTag;
        String str;
        CharSequence charSequence;
        String channelName;
        String str2;
        a aVarA;
        boolean z5;
        CharSequence textContent;
        String location;
        String content;
        String title;
        AttachmentBean attachmentInfo;
        synchronized (this) {
            j = this.f14381a;
            this.f14381a = 0L;
        }
        PictureWorksDetailModel pictureWorksDetailModel = ((WorksHeadPictureWorksDetailBinding) this).f14378a;
        PictureWorksDetailFragment.a aVar = ((WorksHeadPictureWorksDetailBinding) this).f14377a;
        long j2 = j & 11;
        if (j2 != 0) {
            MutableLiveData<WorkDetailBean> mutableLiveDataM = pictureWorksDetailModel != null ? pictureWorksDetailModel.m() : null;
            updateLiveDataRegistration(0, mutableLiveDataM);
            WorkDetailBean value = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
            if (value != null) {
                zShowCategoryTag = value.showCategoryTag();
                channelName = value.formatChannelName();
                zShowChannelName = value.showChannelName();
                textContent = value.getTextContent();
                location = value.getLocation();
                content = value.getContent();
                title = value.getTitle();
                attachmentInfo = value.getAttachmentInfo();
                categoryTag = value.getCategoryTag();
            } else {
                zShowCategoryTag = false;
                zShowChannelName = false;
                categoryTag = null;
                channelName = null;
                textContent = null;
                location = null;
                content = null;
                title = null;
                attachmentInfo = null;
            }
            if (j2 != 0) {
                j |= zShowChannelName ? 32L : 16L;
            }
            boolean zIsEmpty = TextUtils.isEmpty(content);
            boolean zIsEmpty2 = TextUtils.isEmpty(title);
            int length = location != null ? location.length() : 0;
            List<WorkImageBean> imageList = attachmentInfo != null ? attachmentInfo.getImageList() : null;
            z = !zIsEmpty;
            boolean z6 = !zIsEmpty2;
            boolean z7 = length > 0;
            charSequence = textContent;
            str = location;
            z2 = z6;
            str2 = title;
            z3 = (imageList != null ? imageList.size() : 0) > 0;
            z4 = z7;
        } else {
            z = false;
            z2 = false;
            zShowCategoryTag = false;
            zShowChannelName = false;
            z3 = false;
            z4 = false;
            categoryTag = null;
            str = null;
            charSequence = null;
            channelName = null;
            str2 = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f14384a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14384a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        long j4 = j & 11;
        if (j4 != 0) {
            z5 = zShowChannelName ? true : zShowCategoryTag;
        } else {
            z5 = false;
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(((WorksHeadPictureWorksDetailBinding) this).f14376a, z3);
            CommonBindingAdapter.l0(this.b, z2);
            TextViewBindingAdapter.setText(this.b, str2);
            CommonBindingAdapter.l0(this.f14383a, z5);
            CommonBindingAdapter.l0(this.c, z4);
            TextViewBindingAdapter.setText(this.c, str);
            CommonBindingAdapter.l0(((WorksHeadPictureWorksDetailBinding) this).f36976a, z);
            zv9.h(((WorksHeadPictureWorksDetailBinding) this).f36976a, charSequence, true);
            CommonBindingAdapter.l0(((WorksHeadPictureWorksDetailBinding) this).f14379a, zShowChannelName);
            TextViewBindingAdapter.setText(((WorksHeadPictureWorksDetailBinding) this).f14379a, channelName);
            CommonBindingAdapter.l0(super.b, zShowCategoryTag);
            TextViewBindingAdapter.setText(super.b, categoryTag);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((WorksHeadPictureWorksDetailBinding) this).f14379a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14381a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14381a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksHeadPictureWorksDetailBinding
    public void l(@Nullable PictureWorksDetailFragment.a Click) {
        ((WorksHeadPictureWorksDetailBinding) this).f14377a = Click;
        synchronized (this) {
            this.f14381a |= 4;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksHeadPictureWorksDetailBinding
    public void m(@Nullable PictureWorksDetailModel Vm) {
        ((WorksHeadPictureWorksDetailBinding) this).f14378a = Vm;
        synchronized (this) {
            this.f14381a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<WorkDetailBean> VmWorksDetailBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14381a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((PictureWorksDetailModel) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PictureWorksDetailFragment.a) variable);
        }
        return true;
    }

    public WorksHeadPictureWorksDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (CommonBanner) bindings[1], (TextView) bindings[3], (BLTextView) bindings[5], (BLTextView) bindings[6]);
        this.f14381a = -1L;
        ((WorksHeadPictureWorksDetailBinding) this).f14376a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14382a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.b = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[4];
        this.f14383a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView2 = (TextView) bindings[7];
        this.c = textView2;
        textView2.setTag(null);
        ((WorksHeadPictureWorksDetailBinding) this).f36976a.setTag(null);
        ((WorksHeadPictureWorksDetailBinding) this).f14379a.setTag(null);
        super.b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
