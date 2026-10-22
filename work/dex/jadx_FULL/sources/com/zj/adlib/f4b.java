package com.zj.adlib;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.amap.api.col.p0003l.i;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f4b implements LocationSource.OnLocationChangedListener, LBSTraceBase {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f16451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.amap.api.col.p0003l.a f16452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z f16453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CoordinateConverter f16454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TraceStatusListener f16456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f16457a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public z f16461b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16450a = 2000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41593a = 5;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<TraceLocation> f16458a = new ArrayList();
    public int b = 0;
    public int c = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16460b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TraceLocation f16455a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<LatLng> f16462b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<LatLng> f16464c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public List<LatLng> f16465d = new ArrayList();
    public int d = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BlockingQueue<Runnable> f16459a = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public BlockingQueue<Runnable> f16463b = new LinkedBlockingQueue();

    public class a extends it {
        public int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TraceListener f41594a;
        public List<TraceLocation> c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<TraceLocation> f16467a = new ArrayList();
        public String f = rwa.a();

        /* JADX INFO: renamed from: com.zj.adlib.f4b$a$a, reason: collision with other inner class name */
        public class C1328a extends it {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d4b f41595a;

            public C1328a(d4b d4bVar) {
                this.f41595a = d4bVar;
            }

            @Override // com.amap.api.col.p0003l.it
            public final void runTask() {
                this.f41595a.run();
            }
        }

        public a(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
            this.K = i2;
            this.L = i;
            this.c = list;
            this.f41594a = traceListener;
        }

        public static int e(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }

        public final int d() {
            List<TraceLocation> list = this.c;
            int iE = 0;
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (TraceLocation traceLocation : this.c) {
                    if (traceLocation != null) {
                        if (traceLocation.getSpeed() < 0.01d) {
                            arrayList.add(traceLocation);
                        } else {
                            iE += e(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return iE;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                f4b.this.f16457a.a(this.f41594a);
                int iD = d();
                List<TraceLocation> list = this.c;
                if (list != null && list.size() >= 2) {
                    Iterator<TraceLocation> it = this.c.iterator();
                    while (it.hasNext()) {
                        TraceLocation traceLocationCopy = it.next().copy();
                        if (traceLocationCopy != null && traceLocationCopy.getLatitude() > AudioStats.AUDIO_AMPLITUDE_NONE && traceLocationCopy.getLongitude() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                            this.f16467a.add(traceLocationCopy);
                        }
                    }
                    int size = (this.f16467a.size() - 2) / 500;
                    h4b.b().d(this.f, this.L, size, iD);
                    int i = 0;
                    int size2 = 500;
                    while (i <= size) {
                        if (i == size) {
                            size2 = this.f16467a.size();
                        }
                        int i2 = size2;
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < i2; i3++) {
                            TraceLocation traceLocationRemove = this.f16467a.remove(0);
                            if (traceLocationRemove != null) {
                                int i4 = this.K;
                                if (i4 != 1) {
                                    if (i4 == 3) {
                                        f4b.this.f16454a.from(CoordinateConverter.CoordType.BAIDU);
                                    } else if (i4 == 2) {
                                        f4b.this.f16454a.from(CoordinateConverter.CoordType.GPS);
                                    }
                                    f4b.this.f16454a.coord(new LatLng(traceLocationRemove.getLatitude(), traceLocationRemove.getLongitude()));
                                    LatLng latLngConvert = f4b.this.f16454a.convert();
                                    if (latLngConvert != null) {
                                        traceLocationRemove.setLatitude(latLngConvert.latitude);
                                        traceLocationRemove.setLongitude(latLngConvert.longitude);
                                    }
                                }
                                arrayList.add(traceLocationRemove);
                            }
                        }
                        if (arrayList.size() >= 2 && arrayList.size() <= 500) {
                            f4b.this.f16461b.b(new C1328a(new d4b(f4b.this.f16451a, f4b.this.f16457a, arrayList, this.f, this.L, i)));
                            i++;
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        size2 = i2;
                    }
                    return;
                }
                h4b.b();
                h4b.c(f4b.this.f16457a, this.L, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class b implements TraceListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<TraceLocation> f16469a;

        public b(List<TraceLocation> list) {
            this.f16469a = list;
        }

        public final void a(int i, List<LatLng> list) {
            try {
                synchronized (f4b.this.f16465d) {
                    f4b.this.f16465d.clear();
                    f4b.this.f16465d.addAll(list);
                }
                f4b.this.f16464c.clear();
                if (i == 0) {
                    f4b.this.f16464c.addAll(f4b.this.f16465d);
                } else {
                    f4b.this.f16464c.addAll(f4b.this.f16462b);
                    f4b.this.f16464c.addAll(f4b.this.f16465d);
                }
                f4b.this.f16456a.onTraceStatus(f4b.this.f16458a, f4b.this.f16464c, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i, List<LatLng> list, int i2, int i3) {
            a(i, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i, String str) {
            ArrayList arrayList = new ArrayList();
            if (f4b.this.f16465d != null) {
                arrayList.addAll(f4b.this.f16465d);
            }
            List<TraceLocation> list = this.f16469a;
            if (list != null) {
                int size = list.size();
                if (this.f16469a.size() > f4b.this.f41593a) {
                    for (int i2 = size - f4b.this.f41593a; i2 < size; i2++) {
                        TraceLocation traceLocation = this.f16469a.get(i2);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i, int i2, List<LatLng> list) {
        }
    }

    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TraceListener f41597a;

        public c(Looper looper) {
            super(looper);
        }

        public final void a(TraceListener traceListener) {
            this.f41597a = traceListener;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.f41597a == null || (data = message.getData()) == null) {
                    return;
                }
                int i = data.getInt("lineID");
                switch (message.what) {
                    case 100:
                        this.f41597a.onTraceProcessing(i, message.arg1, (List) message.obj);
                        break;
                    case 101:
                        this.f41597a.onFinished(i, (List) message.obj, message.arg1, message.arg2);
                        break;
                    case 102:
                        this.f41597a.onRequestFailed(i, (String) message.obj);
                        break;
                    default:
                        break;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public f4b(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f16451a = applicationContext;
        this.f16454a = new CoordinateConverter(applicationContext);
        this.f16457a = new c(Looper.getMainLooper());
        n4b.a().c(this.f16451a);
        this.f16453a = i.a(this.d * 2, this.f16459a, "AMapTraceManagerProcess");
        this.f16461b = i.a(this.d * 2, this.f16463b, "AMapTraceManagerRequest");
    }

    public static double a(double d, double d2, double d3, double d4) {
        double d5 = d > d3 ? d - d3 : d3 - d;
        double d6 = d2 > d4 ? d2 - d4 : d4 - d2;
        return Math.sqrt((d5 * d5) + (d6 * d6));
    }

    public static boolean e(TraceLocation traceLocation, TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    public final void c() throws Throwable {
        int size = this.f16458a.size();
        if (size < this.f41593a) {
            return;
        }
        if (size <= 50) {
            ArrayList arrayList = new ArrayList(this.f16458a);
            queryProcessedTrace(0, arrayList, 1, new b(arrayList));
            return;
        }
        int i = size - 50;
        if (i < 0) {
            return;
        }
        d(new ArrayList(this.f16458a.subList(i - this.f41593a, i)));
        ArrayList arrayList2 = new ArrayList(this.f16458a.subList(i, size));
        queryProcessedTrace(i, arrayList2, 1, new b(arrayList2));
    }

    public final void d(List<TraceLocation> list) throws Throwable {
        f4b f4bVar = this;
        synchronized (f4bVar.f16465d) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                if (f4bVar.f16465d.size() <= 0) {
                    return;
                }
                LatLng latLng = null;
                double dA = AudioStats.AUDIO_AMPLITUDE_NONE;
                TraceLocation traceLocation = null;
                double d = 0.0d;
                for (TraceLocation traceLocation2 : list) {
                    if (traceLocation2 != null) {
                        if (traceLocation != null) {
                            double dA2 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                            if (dA2 <= 100.0d) {
                                d += dA2;
                            }
                        }
                        traceLocation = traceLocation2;
                    }
                }
                Iterator<LatLng> it = f4bVar.f16465d.iterator();
                while (it.hasNext()) {
                    LatLng next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        if (latLng == null) {
                            f4bVar.f16462b.add(next);
                            it.remove();
                        } else {
                            Iterator<LatLng> it2 = it;
                            try {
                                dA += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                                if (dA >= d) {
                                    break;
                                }
                                f4bVar = this;
                                f4bVar.f16462b.add(next);
                                it2.remove();
                                it = it2;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        latLng = next;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void destroy() {
        try {
            stopTrace();
            z zVar = this.f16453a;
            if (zVar != null) {
                zVar.f();
                this.f16453a = null;
            }
            z zVar2 = this.f16461b;
            if (zVar2 != null) {
                zVar2.f();
                this.f16461b = null;
            }
            this.f16458a = null;
            this.f16456a = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f16451a = null;
        this.f16454a = null;
    }

    public final void g() {
        com.amap.api.col.p0003l.a aVar = this.f16452a;
        if (aVar != null) {
            aVar.deactivate();
            this.f16452a = null;
        }
    }

    public final void i() {
        this.f16459a.clear();
        this.f16463b.clear();
        List<TraceLocation> list = this.f16458a;
        if (list != null) {
            synchronized (list) {
                List<TraceLocation> list2 = this.f16458a;
                if (list2 != null) {
                    list2.clear();
                }
                this.c = 0;
                this.b = 0;
                this.f16460b = 0L;
                this.f16455a = null;
            }
        }
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        TraceStatusListener traceStatusListener;
        if (this.f16456a != null) {
            try {
                if (System.currentTimeMillis() - this.f16460b >= 30000 && (traceStatusListener = this.f16456a) != null) {
                    traceStatusListener.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.f16460b = System.currentTimeMillis();
                Bundle extras = location.getExtras();
                int i = extras.getInt("errorCode");
                if (i != 0) {
                    Log.w("LBSTraceClient", "Locate failed [errorCode:\"" + i + "\"  errorInfo:" + extras.getString(MyLocationStyle.ERROR_INFO) + "\"]");
                    return;
                }
                synchronized (this.f16458a) {
                    TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                    if (e(this.f16455a, traceLocation)) {
                        return;
                    }
                    this.f16458a.add(traceLocation);
                    this.f16455a = traceLocation;
                    int i2 = this.b + 1;
                    this.b = i2;
                    if (i2 == this.f41593a) {
                        this.c += i2;
                        c();
                        this.b = 0;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void queryProcessedTrace(int i, List<TraceLocation> list, int i2, TraceListener traceListener) {
        try {
            this.f16453a.b(new a(i, list, i2, traceListener));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setLocationInterval(long j) {
        this.f16450a = j;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setTraceStatusInterval(int i) {
        this.f41593a = Math.max(i, 2);
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void startTrace(TraceStatusListener traceStatusListener) {
        if (this.f16451a == null) {
            Log.w("LBSTraceClient", "Context need to be initialized");
            return;
        }
        this.f16460b = System.currentTimeMillis();
        this.f16456a = traceStatusListener;
        if (this.f16452a == null) {
            com.amap.api.col.p0003l.a aVar = new com.amap.api.col.p0003l.a(this.f16451a);
            this.f16452a = aVar;
            aVar.b(this.f16450a);
            this.f16452a.activate(this);
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void stopTrace() {
        g();
        i();
    }
}
