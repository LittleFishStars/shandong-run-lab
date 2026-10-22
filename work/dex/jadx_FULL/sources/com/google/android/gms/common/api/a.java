package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.zj.adlib.ys0;
import com.zj.adlib.z1c;
import com.zj.adlib.zs0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends BasePendingResult<ys0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingResult[] f31218a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Object f5486b;
    public boolean e;
    public boolean f;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    public static final class C0708a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoogleApiClient f31219a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List f5487a = new ArrayList();

        public C0708a(@NonNull GoogleApiClient googleApiClient) {
            this.f31219a = googleApiClient;
        }

        @NonNull
        public <R extends Result> zs0<R> a(@NonNull PendingResult<R> pendingResult) {
            zs0<R> zs0Var = new zs0<>(this.f5487a.size());
            this.f5487a.add(pendingResult);
            return zs0Var;
        }

        @NonNull
        public a b() {
            return new a(this.f5487a, this.f31219a, null);
        }
    }

    public /* synthetic */ a(List list, GoogleApiClient googleApiClient, z1c z1cVar) {
        super(googleApiClient);
        this.f5486b = new Object();
        int size = list.size();
        this.b = size;
        PendingResult[] pendingResultArr = new PendingResult[size];
        this.f31218a = pendingResultArr;
        if (list.isEmpty()) {
            setResult(new ys0(Status.RESULT_SUCCESS, pendingResultArr));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult pendingResult = (PendingResult) list.get(i);
            this.f31218a[i] = pendingResult;
            pendingResult.b(new b(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void e() {
        super.e();
        for (PendingResult pendingResult : this.f31218a) {
            pendingResult.e();
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    @NonNull
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ys0 createFailedResult(@NonNull Status status) {
        return new ys0(status, this.f31218a);
    }
}
