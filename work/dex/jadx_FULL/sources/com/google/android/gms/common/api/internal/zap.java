package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.VisibleForTesting;
import com.zj.adlib.ay6;
import com.zj.adlib.b5c;
import com.zj.adlib.o5c;
import com.zj.adlib.pv3;
import com.zj.adlib.t4c;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f31266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final pv3 f5615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicReference f5616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f5617a;

    @VisibleForTesting
    public zap(LifecycleFragment lifecycleFragment, pv3 pv3Var) {
        super(lifecycleFragment);
        this.f5616a = new AtomicReference(null);
        this.f31266a = new o5c(Looper.getMainLooper());
        this.f5615a = pv3Var;
    }

    public static final int m(@Nullable t4c t4cVar) {
        if (t4cVar == null) {
            return -1;
        }
        return t4cVar.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void d(int i, int i2, Intent intent) {
        t4c t4cVar = (t4c) this.f5616a.get();
        if (i != 1) {
            if (i == 2) {
                int iJ = this.f5615a.j(getActivity());
                if (iJ == 0) {
                    l();
                    return;
                } else {
                    if (t4cVar == null) {
                        return;
                    }
                    if (t4cVar.b().getErrorCode() == 18 && iJ == 18) {
                        return;
                    }
                }
            }
        } else if (i2 == -1) {
            l();
            return;
        } else if (i2 == 0) {
            if (t4cVar == null) {
                return;
            }
            k(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, t4cVar.b().toString()), m(t4cVar));
            return;
        }
        if (t4cVar != null) {
            k(t4cVar.b(), t4cVar.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(@Nullable Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            this.f5616a.set(bundle.getBoolean("resolving_error", false) ? new t4c(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h(Bundle bundle) {
        super.h(bundle);
        t4c t4cVar = (t4c) this.f5616a.get();
        if (t4cVar == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", t4cVar.a());
        bundle.putInt("failed_status", t4cVar.b().getErrorCode());
        bundle.putParcelable("failed_resolution", t4cVar.b().getResolution());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        super.i();
        this.f5617a = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f5617a = false;
    }

    public final void k(ConnectionResult connectionResult, int i) {
        this.f5616a.set(null);
        zab(connectionResult, i);
    }

    public final void l() {
        this.f5616a.set(null);
        zac();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        k(new ConnectionResult(13, null), m((t4c) this.f5616a.get()));
    }

    public final void p(ConnectionResult connectionResult, int i) {
        t4c t4cVar = new t4c(connectionResult, i);
        AtomicReference atomicReference = this.f5616a;
        while (!ay6.a(atomicReference, null, t4cVar)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.f31266a.post(new b5c(this, t4cVar));
    }

    public abstract void zab(ConnectionResult connectionResult, int i);

    public abstract void zac();
}
