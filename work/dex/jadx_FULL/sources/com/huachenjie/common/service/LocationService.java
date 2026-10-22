package com.huachenjie.common.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.location.LocationClientOption;
import com.huachenjie.common.event.SignalChangeEvent;
import com.huachenjie.common.event.StartLocationEvent;
import com.zj.adlib.lj0;
import com.zj.adlib.r90;
import com.zj.adlib.t26;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class LocationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f33894a = 15000;
    public static final String f = "notificationId";
    public static final String g = "LocationService";
    public int K = 1235;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f8873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJLocationListener f8875a;

    public static class a implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<LocationService> f33895a;

        public a(LocationService service) {
            if (service != null) {
                this.f33895a = new WeakReference<>(service);
            }
        }

        public void onLocationListener(int code, HCJAddressInfo addressInfo) {
            LocationService locationService;
            boolean zIsFromMockProvider;
            float accuracy;
            String str;
            float speed;
            boolean zIsMock;
            WeakReference<LocationService> weakReference = this.f33895a;
            if (weakReference == null || (locationService = weakReference.get()) == null) {
                return;
            }
            if (addressInfo != null) {
                str = addressInfo.getLat() + "," + addressInfo.getLng();
                accuracy = addressInfo.getAccuracy();
                speed = addressInfo.getSpeed();
                zIsFromMockProvider = addressInfo.isFromMockProvider();
                zIsMock = addressInfo.isMock();
            } else {
                zIsFromMockProvider = false;
                accuracy = 0.0f;
                str = "";
                speed = 0.0f;
                zIsMock = false;
            }
            Log.e(LocationService.g, "location code:" + code + "   lat,lng:" + str + "    accuracy:" + accuracy + "    speed:" + speed + "    isFromMockProvider:" + zIsFromMockProvider + "    isMock:" + zIsMock);
            if (code != 0 || addressInfo == null) {
                locationService.h(code);
            } else {
                locationService.i(addressInfo);
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<LocationService> f33896a;

        public b(LocationService service) {
            if (service != null) {
                this.f33896a = new WeakReference<>(service);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            LocationService locationService;
            WeakReference<LocationService> weakReference = this.f33896a;
            if (weakReference == null || (locationService = weakReference.get()) == null) {
                return;
            }
            locationService.d();
        }
    }

    public final void d() {
        HCJAddressInfo hCJAddressInfoO = r90.o();
        if (hCJAddressInfoO == null || System.currentTimeMillis() - hCJAddressInfoO.getTime() > 15000) {
            j(0L);
        }
        this.f8873a.postDelayed(this.f8874a, 15000L);
    }

    public final void e(HCJAddressInfo addressInfo) {
        int i = 0;
        if (addressInfo == null) {
            EventBus.f().q(new SignalChangeEvent(0));
            return;
        }
        float accuracy = addressInfo.getAccuracy();
        if (accuracy > 0.0f && accuracy <= 15.0f) {
            i = 3;
        } else if (accuracy > 15.0f && accuracy <= 25.0f) {
            i = 2;
        } else if (accuracy > 25.0f && accuracy <= 50.0f) {
            i = 1;
        }
        EventBus.f().q(new SignalChangeEvent(i));
    }

    public final void f(Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        this.K = intent.getIntExtra(f, 1235);
    }

    public final void g() {
        Notification notificationD = t26.f44833a.d(this);
        if (notificationD != null) {
            startForeground(this.K, notificationD);
        }
    }

    public final void h(int code) {
        e(null);
    }

    public final void i(HCJAddressInfo addressInfo) {
        r90.k0(addressInfo);
        EventBus.f().q(addressInfo);
        e(addressInfo);
    }

    public final void j(long interval) {
        try {
            if (this.f8875a == null) {
                this.f8875a = new a(this);
            }
            if (interval == 0) {
                interval = 2000;
            }
            lj0.m(this, interval, this.f8875a, LocationClientOption.LocationMode.Hight_Accuracy, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void k() {
        lj0.s(this, false);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        EventBus.f().v(this);
        this.f8873a = new Handler();
        this.f8874a = new b(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f8873a.removeCallbacksAndMessages(null);
        this.f8874a = null;
        stopForeground(true);
        k();
        this.f8875a = null;
        EventBus.f().A(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(StartLocationEvent event) {
        j(event.getInterval());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (this.f8873a == null) {
            this.f8873a = new Handler(Looper.getMainLooper());
        }
        if (this.f8874a == null) {
            this.f8874a = new b(this);
        }
        f(intent);
        g();
        j(0L);
        this.f8873a.removeCallbacks(this.f8874a);
        this.f8873a.postDelayed(this.f8874a, 15000L);
        return 1;
    }
}
