package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.CheckImageView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesActivity;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityChooseClassesBindingImpl extends ActivityChooseClassesBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13163a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f13165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f13172a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13173b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13174b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13175c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseClassesActivity.a f36378a;

        public a a(ChooseClassesActivity.a aVar) {
            this.f36378a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36378a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseClassesActivity.a f36379a;

        public b a(ChooseClassesActivity.a aVar) {
            this.f36379a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36379a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseClassesActivity.a f36380a;

        public c a(ChooseClassesActivity.a aVar) {
            this.f36380a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36380a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseClassesActivity.a f36381a;

        public d a(ChooseClassesActivity.a aVar) {
            this.f36381a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36381a.c(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseClassesActivity.a f36382a;

        public e a(ChooseClassesActivity.a aVar) {
            this.f36382a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36382a.e(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36377a = sparseIntArray;
        sparseIntArray.put(R.id.fl_content, 10);
    }

    public ActivityChooseClassesBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f13163a, f36377a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a0  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        boolean zSafeUnbox;
        int i;
        String str;
        c cVarA;
        d dVarA;
        b bVarA;
        e eVarA;
        a aVarA;
        String value2;
        long j2;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f13164a;
            this.f13164a = 0L;
        }
        ChooseClassesVM chooseClassesVM = ((ActivityChooseClassesBinding) this).f13162a;
        ChooseClassesActivity.a aVar = ((ActivityChooseClassesBinding) this).f13161a;
        if ((95 & j) != 0) {
            if ((j & 81) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = chooseClassesVM != null ? chooseClassesVM.p() : null;
                updateLiveDataRegistration(0, mutableLiveDataP);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 82) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataS = chooseClassesVM != null ? chooseClassesVM.s() : null;
                updateLiveDataRegistration(1, mutableLiveDataS);
                if (mutableLiveDataS != null) {
                    value2 = mutableLiveDataS.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) != 0) {
                MutableLiveData<Integer> mutableLiveData = chooseClassesVM != null ? chooseClassesVM.b : null;
                updateLiveDataRegistration(2, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
                j2 = 88;
            } else {
                j2 = 88;
                iSafeUnbox = 0;
            }
            if ((j & j2) == 0) {
                str = value2;
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataM = chooseClassesVM != null ? chooseClassesVM.m() : null;
                updateLiveDataRegistration(3, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value = mutableLiveDataM.getValue();
                    str = value2;
                    i = iSafeUnbox;
                } else {
                    str = value2;
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            value = null;
            zSafeUnbox = false;
            i = 0;
            str = null;
        }
        long j3 = j & 96;
        if (j3 == 0 || aVar == null) {
            cVarA = null;
            dVarA = null;
            bVarA = null;
            eVarA = null;
            aVarA = null;
        } else {
            e eVar = this.f13172a;
            if (eVar == null) {
                eVar = new e();
                this.f13172a = eVar;
            }
            eVarA = eVar.a(aVar);
            a aVar2 = this.f13168a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13168a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f13169a;
            if (bVar == null) {
                bVar = new b();
                this.f13169a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f13170a;
            if (cVar == null) {
                cVar = new c();
                this.f13170a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f13171a;
            if (dVar == null) {
                dVar = new d();
                this.f13171a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if ((81 & j) != 0) {
            ((ActivityChooseClassesBinding) this).f13160a.setChecked(zSafeUnbox);
        }
        if ((64 & j) != 0) {
            CheckImageView checkImageView = ((ActivityChooseClassesBinding) this).f13160a;
            DrawablesBindingAdapter.d(checkImageView, AppCompatResources.getDrawable(checkImageView.getContext(), R.drawable.ic_pe_classe_uncheck), null, AppCompatResources.getDrawable(((ActivityChooseClassesBinding) this).f13160a.getContext(), R.drawable.ic_pe_classe_checked), null, null, null, null, null, null, null, null, null, null, null);
            LinearLayoutCompat linearLayoutCompat = this.f13174b;
            DrawablesBindingAdapter.h(linearLayoutCompat, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 14.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ActivityChooseClassesBinding) this).f13160a, aVarA, null);
            CommonBindingAdapter.q(((ActivityChooseClassesBinding) this).f13159a, dVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(this.f13174b, eVarA, null);
            CommonBindingAdapter.q(this.c, cVarA, null);
            CommonBindingAdapter.q(this.f13175c, dVarA, null);
        }
        if ((84 & j) != 0) {
            CommonBindingAdapter.G(this.f13165a, i);
        }
        if ((82 & j) != 0) {
            TextViewBindingAdapter.setText(this.f13166a, str);
        }
        if ((j & 88) != 0) {
            TextViewBindingAdapter.setText(this.f13173b, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13164a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13164a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityChooseClassesBinding
    public void l(@Nullable ChooseClassesActivity.a aVar) {
        ((ActivityChooseClassesBinding) this).f13161a = aVar;
        synchronized (this) {
            this.f13164a |= 32;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityChooseClassesBinding
    public void m(@Nullable ChooseClassesVM chooseClassesVM) {
        ((ActivityChooseClassesBinding) this).f13162a = chooseClassesVM;
        synchronized (this) {
            this.f13164a |= 16;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13164a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13164a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13164a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13164a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((ChooseClassesVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((ChooseClassesActivity.a) obj);
        }
        return true;
    }

    public ActivityChooseClassesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (CheckImageView) objArr[7], (FrameLayout) objArr[10], (ImageView) objArr[8]);
        this.f13164a = -1L;
        ((ActivityChooseClassesBinding) this).f13160a.setTag(null);
        ((ActivityChooseClassesBinding) this).f13159a.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13167a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        View view2 = (View) objArr[1];
        this.f13165a = view2;
        view2.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.b = imageView;
        imageView.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) objArr[3];
        this.f13174b = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f13166a = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.c = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.f13173b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[9];
        this.f13175c = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
