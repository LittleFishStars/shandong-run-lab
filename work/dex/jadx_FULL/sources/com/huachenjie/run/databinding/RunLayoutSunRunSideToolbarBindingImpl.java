package com.huachenjie.run.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.ShadowFrameLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutSunRunSideToolbarBindingImpl extends RunLayoutSunRunSideToolbarBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35720a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12228a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowFrameLayout f12232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f12237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f12238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f12239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12240a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowFrameLayout f12241b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunActivity.a f35721a;

        public a a(SunshineRunActivity.a value) {
            this.f35721a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35721a.e(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunActivity.a f35722a;

        public b a(SunshineRunActivity.a value) {
            this.f35722a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35722a.g(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunActivity.a f35723a;

        public c a(SunshineRunActivity.a value) {
            this.f35723a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35723a.a(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunActivity.a f35724a;

        public d a(SunshineRunActivity.a value) {
            this.f35724a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35724a.c(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunActivity.a f35725a;

        public e a(SunshineRunActivity.a value) {
            this.f35725a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35725a.d(arg0);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunActivity.a f35726a;

        public f a(SunshineRunActivity.a value) {
            this.f35726a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35726a.b(arg0);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunActivity.a f35727a;

        public g a(SunshineRunActivity.a value) {
            this.f35727a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35727a.f(arg0);
        }
    }

    public RunLayoutSunRunSideToolbarBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f12228a, f35720a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b4 A[PHI: r2
      0x00b4: PHI (r2v5 long) = (r2v4 long), (r2v16 long) binds: [B:38:0x0086, B:52:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String value;
        int i;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        g gVar;
        f fVarA;
        e eVar;
        c cVar;
        d dVar;
        a aVar;
        b bVar;
        Drawable drawable5;
        int i2;
        Drawable drawable6;
        Context context;
        int i3;
        Context context2;
        int i4;
        Context context3;
        int i5;
        synchronized (this) {
            j = this.f12229a;
            this.f12229a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunLayoutSunRunSideToolbarBinding) this).f12227a;
        SunshineRunActivity.a aVar2 = ((RunLayoutSunRunSideToolbarBinding) this).f35719a;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataI = sunshineRunVM != null ? sunshineRunVM.I() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            long j2 = j & 322;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = sunshineRunVM != null ? sunshineRunVM.N() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                if (j2 != 0) {
                    j |= zSafeUnbox ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                if (zSafeUnbox) {
                    context3 = this.e.getContext();
                    i5 = R.drawable.run_side_ic_voice_on;
                } else {
                    context3 = this.e.getContext();
                    i5 = R.drawable.run_side_ic_voice_off;
                }
                drawable5 = AppCompatResources.getDrawable(context3, i5);
            } else {
                drawable5 = null;
            }
            long j3 = j & 324;
            if (j3 == 0) {
                i2 = 0;
            } else {
                MutableLiveData<Boolean> mutableLiveDataL = sunshineRunVM != null ? sunshineRunVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
                if (j3 != 0) {
                    j |= zSafeUnbox2 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
                }
                if (zSafeUnbox2) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
            }
            long j4 = j & 328;
            if (j4 != 0) {
                MutableLiveData<Boolean> mutableLiveDataL2 = sunshineRunVM != null ? sunshineRunVM.L() : null;
                updateLiveDataRegistration(3, mutableLiveDataL2);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataL2 != null ? mutableLiveDataL2.getValue() : null);
                if (j4 != 0) {
                    j |= zSafeUnbox3 ? 262144L : 131072L;
                }
                drawable6 = AppCompatResources.getDrawable(this.b.getContext(), zSafeUnbox3 ? R.drawable.run_side_ic_map_normal : R.drawable.run_side_ic_map_satellite);
            } else {
                drawable6 = null;
            }
            long j5 = j & 336;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataQ = sunshineRunVM != null ? sunshineRunVM.q() : null;
                updateLiveDataRegistration(4, mutableLiveDataQ);
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null);
                if (j5 != 0) {
                    j |= zSafeUnbox4 ? 1024L : 512L;
                }
                if (zSafeUnbox4) {
                    context2 = this.f12230a.getContext();
                    i4 = R.drawable.run_side_ic_satellite;
                } else {
                    context2 = this.f12230a.getContext();
                    i4 = R.drawable.run_side_ic_mixed_location;
                }
                drawable4 = AppCompatResources.getDrawable(context2, i4);
            } else {
                drawable4 = null;
            }
            long j6 = j & 352;
            if (j6 != 0) {
                MutableLiveData<Boolean> mutableLiveDataJ = sunshineRunVM != null ? sunshineRunVM.J() : null;
                updateLiveDataRegistration(5, mutableLiveDataJ);
                boolean zSafeUnbox5 = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
                if (j6 != 0) {
                    j |= zSafeUnbox5 ? 4096L : 2048L;
                }
                if (zSafeUnbox5) {
                    context = this.f.getContext();
                    i3 = R.drawable.run_side_ic_lock_on;
                } else {
                    context = this.f.getContext();
                    i3 = R.drawable.run_side_ic_lock_off;
                }
                drawable = AppCompatResources.getDrawable(context, i3);
            } else {
                drawable = null;
            }
            drawable3 = drawable6;
            drawable2 = drawable5;
            i = i2;
        } else {
            drawable = null;
            value = null;
            i = 0;
            drawable2 = null;
            drawable3 = null;
            drawable4 = null;
        }
        long j7 = 384 & j;
        if (j7 == 0 || aVar2 == null) {
            gVar = null;
            fVarA = null;
            eVar = null;
            cVar = null;
            dVar = null;
            aVar = null;
            bVar = null;
        } else {
            g gVar2 = this.f12239a;
            if (gVar2 == null) {
                gVar2 = new g();
                this.f12239a = gVar2;
            }
            g gVarA = gVar2.a(aVar2);
            a aVar3 = this.f12233a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f12233a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f12234a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f12234a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar2 = this.f12235a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f12235a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            d dVar2 = this.f12236a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f12236a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            e eVar2 = this.f12237a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f12237a = eVar2;
            }
            e eVarA = eVar2.a(aVar2);
            f fVar = this.f12238a;
            if (fVar == null) {
                fVar = new f();
                this.f12238a = fVar;
            }
            fVarA = fVar.a(aVar2);
            cVar = cVarA;
            gVar = gVarA;
            bVar = bVarA;
            aVar = aVarA;
            dVar = dVarA;
            eVar = eVarA;
        }
        if ((j & 324) != 0) {
            this.f12232a.setVisibility(i);
        }
        if (j7 != 0) {
            CommonBindingAdapter.q(this.f12232a, aVar, null);
            CommonBindingAdapter.q(this.f12241b, gVar, null);
            CommonBindingAdapter.q(this.b, fVarA, null);
            CommonBindingAdapter.q(this.c, eVar, null);
            CommonBindingAdapter.q(this.d, dVar, null);
            CommonBindingAdapter.q(this.e, bVar, null);
            CommonBindingAdapter.q(this.f, cVar, null);
        }
        if ((336 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f12230a, drawable4);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(this.f12240a, value);
        }
        if ((328 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable3);
        }
        if ((322 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.e, drawable2);
        }
        if ((j & 352) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f, drawable);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12229a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12229a = 256L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutSunRunSideToolbarBinding
    public void l(@Nullable SunshineRunActivity.a Click) {
        ((RunLayoutSunRunSideToolbarBinding) this).f35719a = Click;
        synchronized (this) {
            this.f12229a |= 128;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutSunRunSideToolbarBinding
    public void m(@Nullable SunshineRunVM Vm) {
        ((RunLayoutSunRunSideToolbarBinding) this).f12227a = Vm;
        synchronized (this) {
            this.f12229a |= 64;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> VmActivityRunVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12229a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmGpsDeviceOnly, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12229a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return s((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 4) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 5) {
            return false;
        }
        return q((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<String> VmSatelliteCount, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12229a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> VmScreenLocked, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12229a |= 32;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> VmShowNormalMapIcon, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12229a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Boolean> VmSoundOn, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12229a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((SunshineRunVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((SunshineRunActivity.a) variable);
        }
        return true;
    }

    public RunLayoutSunRunSideToolbarBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6);
        this.f12229a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f12231a = linearLayout;
        linearLayout.setTag(null);
        ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) bindings[1];
        this.f12232a = shadowFrameLayout;
        shadowFrameLayout.setTag(null);
        ShadowFrameLayout shadowFrameLayout2 = (ShadowFrameLayout) bindings[2];
        this.f12241b = shadowFrameLayout2;
        shadowFrameLayout2.setTag(null);
        ImageView imageView = (ImageView) bindings[3];
        this.f12230a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[4];
        this.f12240a = bLTextView;
        bLTextView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[5];
        this.b = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) bindings[6];
        this.c = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) bindings[7];
        this.d = imageView4;
        imageView4.setTag(null);
        ImageView imageView5 = (ImageView) bindings[8];
        this.e = imageView5;
        imageView5.setTag(null);
        ImageView imageView6 = (ImageView) bindings[9];
        this.f = imageView6;
        imageView6.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
