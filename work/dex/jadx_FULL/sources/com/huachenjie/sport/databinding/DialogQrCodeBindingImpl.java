package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.qrcode.QRCodeDialog;
import com.huachenjie.sport.page.mine.qrcode.QRCodeVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogQrCodeBindingImpl extends DialogQrCodeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13413a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13416a;

    @NonNull
    public final ImageView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public QRCodeDialog.a f36456a;

        public a a(QRCodeDialog.a aVar) {
            this.f36456a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36456a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36455a = sparseIntArray;
        sparseIntArray.put(R.id.iv_qr_code, 2);
    }

    public DialogQrCodeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13413a, f36455a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f13414a;
            this.f13414a = 0L;
        }
        QRCodeDialog.a aVar = ((DialogQrCodeBinding) this).f13411a;
        long j2 = j & 6;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13416a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13416a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13414a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13414a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.DialogQrCodeBinding
    public void l(@Nullable QRCodeDialog.a aVar) {
        ((DialogQrCodeBinding) this).f13411a = aVar;
        synchronized (this) {
            this.f13414a |= 2;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.DialogQrCodeBinding
    public void m(@Nullable QRCodeVM qRCodeVM) {
        ((DialogQrCodeBinding) this).f13412a = qRCodeVM;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((QRCodeVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((QRCodeDialog.a) obj);
        }
        return true;
    }

    public DialogQrCodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2]);
        this.f13414a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13415a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.b = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
