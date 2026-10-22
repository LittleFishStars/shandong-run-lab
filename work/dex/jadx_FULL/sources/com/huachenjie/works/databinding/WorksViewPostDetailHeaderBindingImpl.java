package com.huachenjie.works.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.works.bean.PostDetailBean;
import com.huachenjie.works.page.campus_wall.detail.PostDetailViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksViewPostDetailHeaderBindingImpl extends WorksViewPostDetailHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37108a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14805a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14809a;

    @NonNull
    public final TextView b;

    public WorksViewPostDetailHeaderBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14805a, f37108a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:43:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x009a  */
    /* JADX WARN: Code duplicated, block: B:45:0x009f  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        CharSequence charSequence;
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        int size;
        CharSequence value;
        String redPacket;
        String submitTime;
        synchronized (this) {
            j = this.f14806a;
            this.f14806a = 0L;
        }
        PostDetailViewModel postDetailViewModel = ((WorksViewPostDetailHeaderBinding) this).f14804a;
        List<ImageBean> imageList = null;
        boolean z4 = false;
        if ((15 & j) != 0) {
            if ((j & 13) == 0) {
                value = null;
            } else {
                MutableLiveData<CharSequence> mutableLiveDataP = postDetailViewModel != null ? postDetailViewModel.p() : null;
                updateLiveDataRegistration(0, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value = mutableLiveDataP.getValue();
                } else {
                    value = null;
                }
            }
            long j3 = j & 14;
            if (j3 != 0) {
                MutableLiveData<PostDetailBean> mutableLiveDataN = postDetailViewModel != null ? postDetailViewModel.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                PostDetailBean value2 = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
                if (value2 != null) {
                    imageList = value2.getImageList();
                    submitTime = value2.formatSubmitTime();
                    redPacket = value2.getRedPacket();
                } else {
                    redPacket = null;
                    submitTime = null;
                }
                z2 = imageList != null;
                str2 = String.format("¥%s", redPacket);
                boolean zIsEmpty = TextUtils.isEmpty(redPacket);
                if (j3 != 0) {
                    j = z2 ? j | 32 : j | 16;
                }
                z = !zIsEmpty;
                charSequence = value;
                str = submitTime;
            } else {
                charSequence = value;
                str = null;
                str2 = null;
            }
            if ((32 & j) == 0) {
                if (imageList != null) {
                    size = imageList.size();
                } else {
                    size = 0;
                }
                z3 = size > 0;
            }
            j2 = 14 & j;
            if (j2 != 0 && z2) {
                z4 = z3;
            }
            if (j2 != 0) {
                CommonBindingAdapter.l0(((WorksViewPostDetailHeaderBinding) this).f37107a, z4);
                TextViewBindingAdapter.setText(this.b, str);
                TextViewBindingAdapter.setText(this.f14809a, str2);
                CommonBindingAdapter.l0(this.f14809a, z);
            }
            if ((j & 13) != 0) {
                TextViewBindingAdapter.setText(this.f14808a, charSequence);
            }
        }
        str = null;
        str2 = null;
        charSequence = null;
        z = false;
        z2 = false;
        if ((32 & j) == 0) {
            if (imageList != null) {
                size = imageList.size();
            } else {
                size = 0;
            }
            if (size > 0) {
            }
        }
        j2 = 14 & j;
        if (j2 != 0) {
            z4 = z3;
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((WorksViewPostDetailHeaderBinding) this).f37107a, z4);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.f14809a, str2);
            CommonBindingAdapter.l0(this.f14809a, z);
        }
        if ((j & 13) != 0) {
            TextViewBindingAdapter.setText(this.f14808a, charSequence);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14806a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14806a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksViewPostDetailHeaderBinding
    public void k(@Nullable PostDetailViewModel Vm) {
        ((WorksViewPostDetailHeaderBinding) this).f14804a = Vm;
        synchronized (this) {
            this.f14806a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<PostDetailBean> VmPostDetailBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14806a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<CharSequence> VmTagContent, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14806a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((PostDetailViewModel) variable);
        return true;
    }

    public WorksViewPostDetailHeaderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (CommonBanner) bindings[1]);
        this.f14806a = -1L;
        ((WorksViewPostDetailHeaderBinding) this).f37107a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14807a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f14808a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.b = textView2;
        textView2.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[4];
        this.f14809a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
