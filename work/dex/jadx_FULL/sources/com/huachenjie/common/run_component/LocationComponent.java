package com.huachenjie.common.run_component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.location.LocationClientOption;
import com.huachenjie.common.base.BaseSimpleComponent;
import com.zj.adlib.i4a;
import com.zj.adlib.lj0;
import com.zj.adlib.r90;
import com.zj.adlib.v05;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class LocationComponent extends BaseSimpleComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f33880a = 60000;
    public static final long b = 8000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f8849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f8850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GPSSignalListener f8851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationCallbackListener f8852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJLocationListener f8853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Boolean> f8854a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Handler f8855b;
    public final String f;

    public interface GPSSignalListener {
        void a(int signalIntensity, int satellites);
    }

    public interface LocationCallbackListener {
        void a(HCJAddressInfo addressInfo, boolean locationEnable);
    }

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            lj0.l(LocationComponent.this.f8849a);
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message msg) {
            lj0.e(LocationComponent.this.f8849a);
            sendEmptyMessageDelayed(0, 8000L);
        }
    }

    public static class c implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f33883a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<LocationComponent> f8856a;

        public c(LocationComponent component) {
            if (component != null) {
                this.f8856a = new WeakReference<>(component);
            }
        }

        public void onLocationListener(int code, HCJAddressInfo addressInfo) {
            LocationComponent locationComponent;
            WeakReference<LocationComponent> weakReference = this.f8856a;
            if (weakReference == null || (locationComponent = weakReference.get()) == null) {
                return;
            }
            if (code != 0 || addressInfo == null) {
                locationComponent.i(code);
                return;
            }
            locationComponent.j(addressInfo);
            if (addressInfo.getTime() != this.f33883a) {
                locationComponent.f8850a.removeCallbacksAndMessages(null);
                locationComponent.f8850a.sendEmptyMessageDelayed(0, 60000L);
            }
            this.f33883a = addressInfo.getTime();
        }
    }

    public LocationComponent(Context context) {
        String simpleName = getClass().getSimpleName();
        this.f = simpleName;
        this.f8850a = new a(Looper.getMainLooper());
        this.f8855b = new b(Looper.getMainLooper());
        i4a.b(simpleName, simpleName + ">>onCreate");
        this.f8849a = context;
    }

    public final void g(HCJAddressInfo addressInfo) {
        int satellites;
        GPSSignalListener gPSSignalListener;
        if (this.f8854a == null) {
            this.f8854a = new ArrayList();
        }
        if (this.f8854a.size() >= 3) {
            this.f8854a.clear();
        }
        if (addressInfo == null || addressInfo.getAccuracy() > r90.g().getRunFilterAccuracy()) {
            this.f8854a.add(Boolean.FALSE);
            satellites = 0;
        } else {
            this.f8854a.add(Boolean.TRUE);
            satellites = addressInfo.getSatellites();
        }
        if (this.f8854a.size() != 3 || (gPSSignalListener = this.f8851a) == null) {
            return;
        }
        gPSSignalListener.a(h(), satellites);
    }

    public final int h() {
        List<Boolean> list = this.f8854a;
        int i = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<Boolean> it = this.f8854a.iterator();
            while (it.hasNext()) {
                if (it.next().booleanValue()) {
                    i++;
                }
            }
        }
        return i;
    }

    public final void i(int code) {
        i4a.b(this.f, "location fail:   code:" + code);
        g(null);
    }

    public final void j(HCJAddressInfo addressInfo) {
        String str = addressInfo.getLat() + "," + addressInfo.getLng();
        float accuracy = addressInfo.getAccuracy();
        float speed = addressInfo.getSpeed();
        boolean zIsFromMockProvider = addressInfo.isFromMockProvider();
        boolean zIsMock = addressInfo.isMock();
        int satellites = addressInfo.getSatellites();
        i4a.b(this.f, "location success:   lat,lng:" + str + "    accuracy:" + accuracy + "    speed:" + speed + "    isFromMockProvider:" + zIsFromMockProvider + "    satellites:" + satellites + "    isMock:" + zIsMock);
        r90.k0(addressInfo);
        g(addressInfo);
        boolean zA = v05.a(this.f8849a);
        LocationCallbackListener locationCallbackListener = this.f8852a;
        if (locationCallbackListener != null) {
            locationCallbackListener.a(addressInfo, zA);
        }
    }

    public void k(GPSSignalListener listener) {
        this.f8851a = listener;
    }

    public void l(LocationCallbackListener listener) {
        this.f8852a = listener;
    }

    public void m(int amapGPSLevel) {
        LocationClientOption.LocationMode locationMode;
        i4a.b(this.f, "startLocation");
        try {
            if (this.f8853a == null) {
                this.f8853a = new c(this);
            }
            if (amapGPSLevel == 1) {
                locationMode = LocationClientOption.LocationMode.Battery_Saving;
            } else {
                locationMode = amapGPSLevel == 2 ? LocationClientOption.LocationMode.Device_Sensors : LocationClientOption.LocationMode.Hight_Accuracy;
            }
            lj0.m(this.f8849a, 3000L, this.f8853a, locationMode, true);
            this.f8850a.sendEmptyMessageDelayed(0, 60000L);
            this.f8855b.sendEmptyMessageDelayed(0, 8000L);
        } catch (Exception e) {
            i4a.d(this.f, e.getMessage());
        }
    }

    public final void n() {
        i4a.b(this.f, "stopLocation");
        try {
            this.f8850a.removeCallbacksAndMessages(null);
            this.f8855b.removeCallbacksAndMessages(null);
            Context context = this.f8849a;
            if (context == null) {
                return;
            }
            lj0.s(context, true);
        } catch (Exception e) {
            i4a.d(this.f, e.getMessage());
        }
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        i4a.b(this.f, this.f + ">>onDestroyed");
        n();
        this.f8852a = null;
        this.f8851a = null;
        this.f8853a = null;
        this.f8849a = null;
        super.onDestroy();
    }
}
