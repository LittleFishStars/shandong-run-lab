package com.zj.adlib;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class my0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18326a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue f43410a = new LinkedBlockingQueue();

    @NonNull
    @KeepForSdk
    public IBinder a() throws InterruptedException {
        yw6.k("BlockingServiceConnection.getService() called on main thread");
        if (this.f18326a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f18326a = true;
        return (IBinder) this.f43410a.take();
    }

    @NonNull
    @KeepForSdk
    public IBinder b(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        yw6.k("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f18326a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f18326a = true;
        IBinder iBinder = (IBinder) this.f43410a.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.f43410a.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
    }
}
