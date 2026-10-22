package com.autonavi.aps.amapapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.MotionEventCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.hl;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.ka;
import com.amap.api.col.p0003l.kn;
import com.amap.api.col.p0003l.z;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.i;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.a7b;
import com.zj.adlib.acb;
import com.zj.adlib.e9b;
import com.zj.adlib.i9b;
import com.zj.adlib.j4b;
import com.zj.adlib.k9b;
import com.zj.adlib.khb;
import com.zj.adlib.l9b;
import com.zj.adlib.lhb;
import com.zj.adlib.m4b;
import com.zj.adlib.mhb;
import com.zj.adlib.nbb;
import com.zj.adlib.nfb;
import com.zj.adlib.qeb;
import com.zj.adlib.qhb;
import com.zj.adlib.rhb;
import com.zj.adlib.s4b;
import com.zj.adlib.t8b;
import com.zj.adlib.ueb;
import com.zj.adlib.y6b;
import com.zj.adlib.ybb;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c implements kn {
    private static long k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f26170a;
    nfb d;
    k9b e;
    private Handler g;
    private LocationManager h;
    private a i;
    private ArrayList<ueb> f = new ArrayList<>();
    i b = null;
    e c = null;
    private volatile boolean j = false;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f26172a;

        public a(c cVar) {
            this.f26172a = cVar;
        }

        public final void a(c cVar) {
            this.f26172a = cVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                c cVar = this.f26172a;
                if (cVar != null) {
                    cVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public final void a() {
            this.f26172a = null;
        }
    }

    public c(Context context) {
        this.f26170a = null;
        this.f26170a = context;
        k9b k9bVar = new k9b();
        this.e = k9bVar;
        nbb.f(this.f26170a, k9bVar, y6b.k, 100, 1024000, "0");
        k9b k9bVar2 = this.e;
        int i = com.autonavi.aps.amapapi.utils.a.g;
        boolean z = com.autonavi.aps.amapapi.utils.a.e;
        int i2 = com.autonavi.aps.amapapi.utils.a.f;
        k9bVar2.f17615a = new acb(context, i, "kKey", new ybb(context, z, i2, i2 * 10, "carrierLocKey"));
        this.e.f17613a = new t8b();
    }

    private static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static byte[] c(int i) {
        return new byte[]{(byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (i & 255)};
    }

    public static /* synthetic */ byte[] f() {
        return a(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ArrayList<ueb> arrayList;
        try {
            if (!com.autonavi.aps.amapapi.utils.i.m(this.f26170a) && (arrayList = this.f) != null && arrayList.size() != 0) {
                ArrayList<ueb> arrayList2 = new ArrayList();
                synchronized (this.f) {
                    arrayList2.addAll(this.f);
                    this.f.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArrA = a(256);
                if (bArrA == null) {
                    return;
                }
                byteArrayOutputStream.write(c(bArrA.length));
                byteArrayOutputStream.write(bArrA);
                for (ueb uebVar : arrayList2) {
                    byte[] bArrB = uebVar.b();
                    if (bArrB.length >= 10 && bArrB.length <= 65535) {
                        byte[] bArrH = m4b.h(bArrA, bArrB, s4b.w());
                        byteArrayOutputStream.write(c(bArrH.length));
                        byteArrayOutputStream.write(bArrH);
                        byteArrayOutputStream.write(b(uebVar.a()));
                    }
                }
                l9b.c(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.e);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "wtD");
        }
    }

    public final void d() {
        try {
            if (!com.autonavi.aps.amapapi.utils.i.m(this.f26170a) && System.currentTimeMillis() - k >= 60000) {
                z.g().b(new b(2));
            }
        } catch (Throwable unused) {
        }
    }

    public final void e() {
        try {
            z.g().b(new b(3));
        } catch (Throwable unused) {
        }
    }

    public class b extends it {
        private int b;
        private Location c;

        public b(int i) {
            this.b = i;
        }

        private void a() {
            try {
                if (this.c == null || !c.this.j || com.autonavi.aps.amapapi.utils.i.m(c.this.f26170a)) {
                    return;
                }
                Bundle extras = this.c.getExtras();
                int i = extras != null ? extras.getInt("satellites") : 0;
                if (com.autonavi.aps.amapapi.utils.i.a(this.c, i)) {
                    return;
                }
                i iVar = c.this.b;
                if (iVar != null && !iVar.s) {
                    iVar.f();
                }
                ArrayList<mhb> arrayListA = c.this.b.a();
                List<ka> listA = c.this.c.a();
                qeb.a aVar = new qeb.a();
                lhb lhbVar = new lhb();
                ((khb) lhbVar).f17707c = this.c.getAccuracy();
                ((khb) lhbVar).c = this.c.getAltitude();
                ((khb) lhbVar).f42823a = this.c.getLatitude();
                ((khb) lhbVar).f17705b = this.c.getBearing();
                ((khb) lhbVar).b = this.c.getLongitude();
                ((khb) lhbVar).f17704a = this.c.isFromMockProvider();
                ((khb) lhbVar).f17703a = this.c.getProvider();
                ((khb) lhbVar).f17701a = this.c.getSpeed();
                lhbVar.f43069a = (byte) i;
                ((khb) lhbVar).f17702a = System.currentTimeMillis();
                ((khb) lhbVar).f17706b = this.c.getTime();
                lhbVar.c = this.c.getTime();
                aVar.f19091a = lhbVar;
                aVar.f19093a = arrayListA;
                WifiInfo wifiInfoC = c.this.b.c();
                if (wifiInfoC != null) {
                    aVar.f19090a = mhb.a(wifiInfoC.getBSSID());
                }
                aVar.b = i.A;
                aVar.c = this.c.getTime();
                aVar.f44196a = (byte) fj.X(c.this.f26170a);
                aVar.f19092a = fj.c0(c.this.f26170a);
                aVar.f19094a = c.this.b.k();
                aVar.f19096b = com.autonavi.aps.amapapi.utils.i.a(c.this.f26170a);
                aVar.f19095b = listA;
                ueb uebVarA = nfb.a(aVar);
                if (uebVarA == null) {
                    return;
                }
                synchronized (c.this.f) {
                    c.this.f.add(uebVarA);
                    if (c.this.f.size() >= 5) {
                        c.this.e();
                    }
                }
                c.this.d();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "cl", "coll");
            }
        }

        private void b() {
            if (com.autonavi.aps.amapapi.utils.i.m(c.this.f26170a)) {
                return;
            }
            e9b e9bVarC = null;
            try {
                long unused = c.k = System.currentTimeMillis();
                if (c.this.e.f17615a.d()) {
                    e9bVarC = e9b.c(new File(c.this.e.f17616a), c.this.e.f17612a);
                    ArrayList arrayList = new ArrayList();
                    byte[] bArrF = c.f();
                    if (bArrF == null) {
                        try {
                            e9bVarC.close();
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    List listB = c.b(e9bVarC, c.this.e, arrayList, bArrF);
                    if (listB != null && listB.size() != 0) {
                        c.this.e.f17615a.c(true);
                        if (nfb.f(s4b.u(nfb.h(com.autonavi.aps.amapapi.security.a.a(bArrF), m4b.h(bArrF, nfb.g(), s4b.w()), listB)))) {
                            c.b(e9bVarC, arrayList);
                        }
                    }
                    try {
                        e9bVarC.close();
                        return;
                    } catch (Throwable unused3) {
                        return;
                    }
                }
                if (e9bVarC != null) {
                    try {
                        e9bVarC.close();
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable th) {
                try {
                    a7b.m(th, "leg", "uts");
                } finally {
                    if (e9bVarC != null) {
                        try {
                            e9bVarC.close();
                        } catch (Throwable unused5) {
                        }
                    }
                }
            }
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            int i = this.b;
            if (i == 1) {
                a();
            } else if (i == 2) {
                b();
            } else if (i == 3) {
                c.this.g();
            }
        }

        public b(c cVar, Location location) {
            this(1);
            this.c = location;
        }
    }

    public final void b() {
        try {
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.autonavi.aps.amapapi.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        i iVar;
                        try {
                            c cVar = c.this;
                            if (cVar.d == null || (iVar = cVar.b) == null) {
                                return;
                            }
                            nfb.k(iVar.a());
                        } catch (Throwable th) {
                            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upw");
        }
    }

    public final void c() {
        e eVar;
        try {
            if (this.d == null || (eVar = this.c) == null) {
                return;
            }
            nfb.e(eVar.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(e9b e9bVar, List<String> list) {
        if (e9bVar != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    e9bVar.E(it.next());
                }
                e9bVar.close();
            } catch (Throwable th) {
                a7b.m(th, t.p, "dlo");
            }
        }
    }

    public final void a() {
        LocationManager locationManager;
        if (com.autonavi.aps.amapapi.utils.i.m(this.f26170a)) {
            return;
        }
        try {
            a aVar = this.i;
            if (aVar != null && (locationManager = this.h) != null) {
                locationManager.removeUpdates(aVar);
            }
            a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.j) {
                g();
                this.b.a((c) null);
                this.c.a((c) null);
                this.c = null;
                this.b = null;
                this.g = null;
                this.j = false;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "stc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x00cc A[EXC_TOP_SPLITTER, PHI: r5 r9 r16
      0x00cc: PHI (r5v3 int) = (r5v4 int), (r5v5 int), (r5v5 int) binds: [B:59:0x00ec, B:74:0x00cc, B:50:0x00c9] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r9v1 com.zj.adlib.e9b$e) = (r9v2 com.zj.adlib.e9b$e), (r9v3 com.zj.adlib.e9b$e), (r9v3 com.zj.adlib.e9b$e) binds: [B:59:0x00ec, B:74:0x00cc, B:50:0x00c9] A[DONT_GENERATE, DONT_INLINE]
      0x00cc: PHI (r16v3 java.lang.String[]) = (r16v4 java.lang.String[]), (r16v6 java.lang.String[]), (r16v6 java.lang.String[]) binds: [B:59:0x00ec, B:74:0x00cc, B:50:0x00c9] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static List<ueb> b(e9b e9bVar, k9b k9bVar, List<String> list, byte[] bArr) {
        String[] list2;
        String[] strArr;
        e9b.e eVarB;
        ArrayList arrayList = new ArrayList();
        try {
            File fileR = e9bVar.r();
            if (fileR == null || !fileR.exists() || (list2 = fileR.list()) == null) {
                return arrayList;
            }
            int length = list2.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str = list2[i2];
                if (str.contains(".0")) {
                    InputStream inputStreamA = null;
                    try {
                        String str2 = str.split("\\.")[i];
                        try {
                            eVarB = e9bVar.b(str2);
                            try {
                                if (eVarB != null) {
                                    try {
                                        inputStreamA = eVarB.a();
                                        if (inputStreamA != null) {
                                            byte[] bArr2 = new byte[2];
                                            inputStreamA.read(bArr2);
                                            int iB = com.autonavi.aps.amapapi.utils.i.b(bArr2);
                                            if (iB != 0 && iB <= 65535) {
                                                byte[] bArr3 = new byte[iB];
                                                inputStreamA.read(bArr3);
                                                byte[] bArr4 = new byte[2];
                                                int length2 = i;
                                                while (inputStreamA.read(bArr4) >= 0) {
                                                    try {
                                                        byte[] bArr5 = new byte[com.autonavi.aps.amapapi.utils.i.b(bArr4)];
                                                        inputStreamA.read(bArr5);
                                                        byte[] bArrE = m4b.e(bArr3, bArr5, s4b.w());
                                                        length2 += bArrE.length;
                                                        byte[] bArr6 = new byte[4];
                                                        inputStreamA.read(bArr6);
                                                        strArr = list2;
                                                        try {
                                                            arrayList.add(new ueb(a(bArr6), m4b.h(bArr, s4b.u(bArrE), s4b.w())));
                                                            list2 = strArr;
                                                        } catch (Throwable unused) {
                                                            if (inputStreamA != null) {
                                                                try {
                                                                    inputStreamA.close();
                                                                } catch (Throwable unused2) {
                                                                }
                                                            }
                                                            if (eVarB != null) {
                                                                try {
                                                                    eVarB.close();
                                                                } catch (Throwable unused3) {
                                                                }
                                                            }
                                                            i2++;
                                                            list2 = strArr;
                                                            i = 0;
                                                        }
                                                    } catch (Throwable unused4) {
                                                        strArr = list2;
                                                    }
                                                }
                                                strArr = list2;
                                                i3 += length2;
                                                try {
                                                    list.add(str2);
                                                    try {
                                                        if (i3 <= k9bVar.f17615a.a()) {
                                                            try {
                                                                inputStreamA.close();
                                                            } catch (Throwable unused5) {
                                                            }
                                                            eVarB.close();
                                                            i2++;
                                                            list2 = strArr;
                                                            i = 0;
                                                        }
                                                    } catch (Throwable unused6) {
                                                        if (inputStreamA != null) {
                                                            inputStreamA.close();
                                                        }
                                                        if (eVarB != null) {
                                                        }
                                                        i2++;
                                                        list2 = strArr;
                                                        i = 0;
                                                    }
                                                } catch (Throwable unused7) {
                                                }
                                            }
                                            try {
                                                inputStreamA.close();
                                            } catch (Throwable unused8) {
                                            }
                                            try {
                                                eVarB.close();
                                                break;
                                            } catch (Throwable unused9) {
                                                break;
                                            }
                                        }
                                        if (inputStreamA != null) {
                                            try {
                                                inputStreamA.close();
                                            } catch (Throwable unused10) {
                                            }
                                        }
                                    } catch (Throwable unused11) {
                                        strArr = list2;
                                    }
                                    if (inputStreamA != null) {
                                        inputStreamA.close();
                                    }
                                    if (eVarB != null) {
                                        eVarB.close();
                                    }
                                    i2++;
                                    list2 = strArr;
                                    i = 0;
                                } else if (eVarB != null) {
                                }
                                eVarB.close();
                            } catch (Throwable unused12) {
                            }
                        } catch (Throwable unused13) {
                            strArr = list2;
                            eVarB = null;
                        }
                    } catch (Throwable unused14) {
                    }
                }
                strArr = list2;
                i2++;
                list2 = strArr;
                i = 0;
            }
            return arrayList;
        } catch (Throwable th) {
            a7b.m(th, t.p, "upc");
        }
        return arrayList;
    }

    public final void a(e eVar, i iVar, Handler handler) {
        LocationManager locationManager;
        if (this.j || eVar == null || iVar == null || handler == null || com.autonavi.aps.amapapi.utils.i.m(this.f26170a)) {
            return;
        }
        this.j = true;
        this.c = eVar;
        this.b = iVar;
        iVar.a(this);
        this.c.a(this);
        this.g = handler;
        try {
            if (this.h == null) {
                this.h = (LocationManager) this.f26170a.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            }
            if (this.i == null) {
                this.i = new a(this);
            }
            this.i.a(this);
            a aVar = this.i;
            if (aVar != null && (locationManager = this.h) != null) {
                locationManager.requestLocationUpdates("passive", 1000L, -1.0f, aVar);
            }
            if (this.d == null) {
                nfb nfbVar = new nfb("6.1.0", j4b.j(this.f26170a), "S128DF1572465B890OE3F7A13167KLEI", j4b.g(this.f26170a), this);
                this.d = nfbVar;
                nfbVar.d(fj.L()).i(fj.N(this.f26170a)).l(fj.t(this.f26170a)).m(fj.M(this.f26170a)).n(fj.h0(this.f26170a)).o(fj.Q(this.f26170a)).p(Build.MODEL).q(Build.MANUFACTURER).r(Build.BRAND).b(Build.VERSION.SDK_INT).s(Build.VERSION.RELEASE).c(mhb.a(fj.G())).t(fj.G());
                nfb.j();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "col", "init");
        }
    }

    public final void a(Location location) {
        try {
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            a7b.m(th, "cl", "olcc");
        }
    }

    @Override // com.amap.api.col.p0003l.kn
    public final rhb a(qhb qhbVar) {
        try {
            com.autonavi.aps.amapapi.trans.b bVar = new com.autonavi.aps.amapapi.trans.b();
            bVar.a(qhbVar.f19105a);
            bVar.a(qhbVar.f19104a);
            bVar.a(qhbVar.f19107a);
            hl.b();
            i9b i9bVarE = hl.e(bVar);
            rhb rhbVar = new rhb();
            rhbVar.f19325a = i9bVarE.f17171a;
            rhbVar.f19324a = i9bVarE.f17169a;
            rhbVar.f44458a = 200;
            return rhbVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(int i) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }
}
