package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.zj.adlib.yw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class BaseImplementation {

    @KeepForSdk
    public interface ResultHolder<R> {
        @KeepForSdk
        void a(@NonNull Status status);

        @KeepForSdk
        void setResult(@NonNull R r);
    }

    @KeepForSdk
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @KeepForSdk
        public final Api.a<A> f31222a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        @KeepForSdk
        public final Api<?> f5491a;

        @KeepForSdk
        @Deprecated
        public ApiMethodImpl(@NonNull Api.a<A> aVar, @NonNull GoogleApiClient googleApiClient) {
            super((GoogleApiClient) yw6.m(googleApiClient, "GoogleApiClient must not be null"));
            this.f31222a = (Api.a) yw6.l(aVar);
            this.f5491a = null;
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public final void a(@NonNull Status status) {
            yw6.b(!status.isSuccess(), "Failed result must not be success");
            R rCreateFailedResult = createFailedResult(status);
            setResult((Result) rCreateFailedResult);
            onSetFailedResult(rCreateFailedResult);
        }

        @KeepForSdk
        public abstract void doExecute(@NonNull A a2) throws RemoteException;

        @KeepForSdk
        public void onSetFailedResult(@NonNull R r) {
        }

        @Nullable
        @KeepForSdk
        public final Api<?> s() {
            return this.f5491a;
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        @KeepForSdk
        public /* bridge */ /* synthetic */ void setResult(@NonNull Object obj) {
            super.setResult((Result) obj);
        }

        @NonNull
        @KeepForSdk
        public final Api.a<A> t() {
            return this.f31222a;
        }

        @KeepForSdk
        public final void u(@NonNull A a2) throws DeadObjectException {
            try {
                doExecute(a2);
            } catch (DeadObjectException e) {
                v(e);
                throw e;
            } catch (RemoteException e2) {
                v(e2);
            }
        }

        @KeepForSdk
        public final void v(@NonNull RemoteException remoteException) {
            a(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        @KeepForSdk
        public ApiMethodImpl(@NonNull Api<?> api, @NonNull GoogleApiClient googleApiClient) {
            super((GoogleApiClient) yw6.m(googleApiClient, "GoogleApiClient must not be null"));
            yw6.m(api, "Api must not be null");
            this.f31222a = api.b();
            this.f5491a = api;
        }

        @KeepForSdk
        @VisibleForTesting
        public ApiMethodImpl(@NonNull BasePendingResult.a<R> aVar) {
            super(aVar);
            this.f31222a = new Api.a<>();
            this.f5491a = null;
        }
    }
}
