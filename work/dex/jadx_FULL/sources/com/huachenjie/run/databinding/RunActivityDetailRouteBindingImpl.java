package com.huachenjie.run.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.route.RunDetailRouteActivity;
import com.huachenjie.run.page.run_detail.route.RunDetailRouteVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.ai9;
import com.zj.adlib.aw9;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityDetailRouteBindingImpl extends RunActivityDetailRouteBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11474a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11477a;

    @NonNull
    public final FrameLayout b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailRouteActivity.a f35461a;

        public a a(RunDetailRouteActivity.a value) {
            this.f35461a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35461a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailRouteActivity.a f35462a;

        public b a(RunDetailRouteActivity.a value) {
            this.f35462a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35462a.back(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35460a = sparseIntArray;
        sparseIntArray.put(R.id.fl_map_container, 6);
        sparseIntArray.put(R.id.cl_statics_card, 7);
        sparseIntArray.put(R.id.tv_distance_label, 8);
        sparseIntArray.put(R.id.tv_distance, 9);
        sparseIntArray.put(R.id.tv_distance_unit, 10);
        sparseIntArray.put(R.id.tv_time, 11);
        sparseIntArray.put(R.id.ll_pace_bar, 12);
        sparseIntArray.put(R.id.ll_metrics, 13);
        sparseIntArray.put(R.id.tv_costed_time, 14);
        sparseIntArray.put(R.id.tv_pace, 15);
        sparseIntArray.put(R.id.tv_burned_calories, 16);
    }

    public RunActivityDetailRouteBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 17, f11474a, f35460a));
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:67:0x0105  */
    /* JADX WARN: Code duplicated, block: B:69:0x0116  */
    /* JADX WARN: Code duplicated, block: B:72:0x0128  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String avatarFrameImgUrl;
        String avatar;
        int i;
        String strI;
        Drawable drawable;
        String strJ;
        long j2;
        a aVarA;
        b bVarA;
        int iSafeUnbox;
        Context context;
        int i2;
        synchronized (this) {
            j = this.f11475a;
            this.f11475a = 0L;
        }
        RunDetailRouteVM runDetailRouteVM = ((RunActivityDetailRouteBinding) this).f11470a;
        RunDetailRouteActivity.a aVar = ((RunActivityDetailRouteBinding) this).f11469a;
        if ((j & 16) != 0) {
            avatarFrameImgUrl = ai9.e().getAvatarFrameImgUrl();
            avatar = ai9.e().getAvatar();
        } else {
            avatarFrameImgUrl = null;
            avatar = null;
        }
        if ((23 & j) != 0) {
            if ((j & 22) != 0) {
                BaseViewModel.b bVarE = runDetailRouteVM != null ? runDetailRouteVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 4));
            } else {
                iSafeUnbox = 0;
            }
            long j3 = j & 21;
            if (j3 != 0) {
                MutableLiveData<Boolean> mutableLiveDataK = runDetailRouteVM != null ? runDetailRouteVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
                if (j3 != 0) {
                    j |= zSafeUnbox ? 64L : 32L;
                }
                if (runDetailRouteVM != null) {
                    strJ = runDetailRouteVM.j(zSafeUnbox);
                    strI = runDetailRouteVM.i(zSafeUnbox);
                } else {
                    strI = null;
                    strJ = null;
                }
                if (zSafeUnbox) {
                    context = ((RunActivityDetailRouteBinding) this).b.getContext();
                    i2 = R.drawable.run_run_ic_detail_eye_on;
                } else {
                    context = ((RunActivityDetailRouteBinding) this).b.getContext();
                    i2 = R.drawable.run_run_ic_detail_eye_off;
                }
                drawable = AppCompatResources.getDrawable(context, i2);
                i = iSafeUnbox;
            } else {
                i = iSafeUnbox;
            }
            j2 = 24 & j;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
                bVarA = null;
            } else {
                b bVar = this.f11477a;
                if (bVar == null) {
                    bVar = new b();
                    this.f11477a = bVar;
                }
                bVarA = bVar.a(aVar);
                a aVar2 = this.f11476a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f11476a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((16 & j) != 0) {
                aw9.d(((RunActivityDetailRouteBinding) this).f11468a, avatar, false, null);
                aw9.c(((RunActivityDetailRouteBinding) this).f11468a, avatarFrameImgUrl, null);
            }
            if ((22 & j) != 0) {
                CommonBindingAdapter.I(((RunActivityDetailRouteBinding) this).f11465a, 0, i, 0, 0, null);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(((RunActivityDetailRouteBinding) this).f11465a, bVarA, null);
                CommonBindingAdapter.q(((RunActivityDetailRouteBinding) this).b, aVarA, null);
            }
            if ((j & 21) != 0) {
                ImageViewBindingAdapter.setImageDrawable(((RunActivityDetailRouteBinding) this).b, drawable);
                TextViewBindingAdapter.setText(this.f, strI);
                TextViewBindingAdapter.setText(this.h, strJ);
            }
        }
        i = 0;
        strI = null;
        drawable = null;
        strJ = null;
        j2 = 24 & j;
        if (j2 != 0) {
            aVarA = null;
            bVarA = null;
        } else {
            aVarA = null;
            bVarA = null;
        }
        if ((16 & j) != 0) {
            aw9.d(((RunActivityDetailRouteBinding) this).f11468a, avatar, false, null);
            aw9.c(((RunActivityDetailRouteBinding) this).f11468a, avatarFrameImgUrl, null);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.I(((RunActivityDetailRouteBinding) this).f11465a, 0, i, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((RunActivityDetailRouteBinding) this).f11465a, bVarA, null);
            CommonBindingAdapter.q(((RunActivityDetailRouteBinding) this).b, aVarA, null);
        }
        if ((j & 21) != 0) {
            ImageViewBindingAdapter.setImageDrawable(((RunActivityDetailRouteBinding) this).b, drawable);
            TextViewBindingAdapter.setText(this.f, strI);
            TextViewBindingAdapter.setText(this.h, strJ);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11475a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11475a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityDetailRouteBinding
    public void l(@Nullable RunDetailRouteActivity.a Click) {
        ((RunActivityDetailRouteBinding) this).f11469a = Click;
        synchronized (this) {
            this.f11475a |= 8;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityDetailRouteBinding
    public void m(@Nullable RunDetailRouteVM Vm) {
        ((RunActivityDetailRouteBinding) this).f11470a = Vm;
        synchronized (this) {
            this.f11475a |= 4;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11475a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmUserInfoVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11475a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((RunDetailRouteVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunDetailRouteActivity.a) variable);
        }
        return true;
    }

    public RunActivityDetailRouteBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (BLConstraintLayout) bindings[7], (FrameLayout) bindings[6], (AvatarView) bindings[2], (ImageView) bindings[1], (ImageView) bindings[3], (LinearLayout) bindings[13], (LinearLayout) bindings[12], (TextView) bindings[16], (TextView) bindings[14], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[10], (TextView) bindings[4], (TextView) bindings[15], (TextView) bindings[5], (TextView) bindings[11]);
        this.f11475a = -1L;
        ((RunActivityDetailRouteBinding) this).f11468a.setTag(null);
        ((RunActivityDetailRouteBinding) this).f11465a.setTag(null);
        ((RunActivityDetailRouteBinding) this).b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        this.f.setTag(null);
        this.h.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
