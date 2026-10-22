package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoDetailBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.R;
import com.huachenjie.home.dialog.reward.RewardInfoDialog;
import com.huachenjie.home.dialog.reward.RewardInfoVM;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeDialogRewardInfoBindingImpl extends HomeDialogRewardInfoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9372a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9378a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardInfoDialog.a f34235a;

        public a a(RewardInfoDialog.a aVar) {
            this.f34235a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34235a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardInfoDialog.a f34236a;

        public b a(RewardInfoDialog.a aVar) {
            this.f34236a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34236a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34234a = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 5);
        sparseIntArray.put(R.id.ll_content, 6);
        sparseIntArray.put(R.id.fl_bg, 7);
        sparseIntArray.put(R.id.iv_award, 8);
        sparseIntArray.put(R.id.jsEmptyView, 9);
    }

    public HomeDialogRewardInfoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f9372a, f34234a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String awardName;
        String dialogTitle;
        b bVarA;
        a aVarA;
        RewardInfoDetailBean awardInfo;
        synchronized (this) {
            j = this.f9373a;
            this.f9373a = 0L;
        }
        RewardInfoVM rewardInfoVM = ((HomeDialogRewardInfoBinding) this).f9370a;
        RewardInfoDialog.a aVar = ((HomeDialogRewardInfoBinding) this).f9369a;
        long j2 = 11 & j;
        boolean z = false;
        if (j2 != 0) {
            MutableLiveData<RewardInfoBean> mutableLiveDataI = rewardInfoVM != null ? rewardInfoVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            RewardInfoBean value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
            if (value != null) {
                boolean zShowValidTime = value.showValidTime();
                String str3 = value.formatterMenuName(false, true);
                awardInfo = value.getAwardInfo();
                dialogTitle = value.getDialogTitle();
                str = value.formatterValidTimeStyle2();
                str2 = str3;
                z = zShowValidTime;
            } else {
                str = null;
                str2 = null;
                awardInfo = null;
                dialogTitle = null;
            }
            awardName = awardInfo != null ? awardInfo.getAwardName() : null;
        } else {
            str = null;
            str2 = null;
            awardName = null;
            dialogTitle = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f9377a;
            if (bVar == null) {
                bVar = new b();
                this.f9377a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f9376a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9376a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f9374a, bVarA, null);
            CommonBindingAdapter.q(this.f9378a, aVarA, null);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f9375a, dialogTitle);
            TextViewBindingAdapter.setText(this.b, awardName);
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.c, str);
            TextViewBindingAdapter.setText(this.f9378a, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9373a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9373a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogRewardInfoBinding
    public void l(@Nullable RewardInfoDialog.a aVar) {
        ((HomeDialogRewardInfoBinding) this).f9369a = aVar;
        synchronized (this) {
            this.f9373a |= 4;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogRewardInfoBinding
    public void m(@Nullable RewardInfoVM rewardInfoVM) {
        ((HomeDialogRewardInfoBinding) this).f9370a = rewardInfoVM;
        synchronized (this) {
            this.f9373a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<RewardInfoBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9373a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((RewardInfoVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((RewardInfoDialog.a) obj);
        }
        return true;
    }

    public HomeDialogRewardInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (BLFrameLayout) objArr[7], (ImageView) objArr[8], (ImageView) objArr[5], (LottieAnimationView) objArr[9], (LinearLayout) objArr[6]);
        this.f9373a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9374a = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f9375a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.c = textView3;
        textView3.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f9378a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
