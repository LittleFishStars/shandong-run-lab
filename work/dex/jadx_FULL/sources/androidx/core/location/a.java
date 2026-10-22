package androidx.core.location;

import android.location.LocationManager;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final /* synthetic */ class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationManager f21451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f184a;

    public /* synthetic */ a(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.f21451a = locationManager;
        this.f184a = gpsStatusTransport;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LocationManagerCompat.lambda$registerGnssStatusCallback$1(this.f21451a, this.f184a);
    }
}
