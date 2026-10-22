package com.autonavi.aps.amapapi.restruct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.amap.api.col.p0003l.ka;
import com.amap.api.col.p0003l.kb;
import com.amap.api.col.p0003l.kc;
import com.amap.api.col.p0003l.kd;
import com.amap.api.col.p0003l.ke;
import com.amap.api.col.p0003l.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"NewApi"})
public final class e {
    TelephonyManager b;
    SignalStrength d;
    private Context h;
    private c m;

    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback q;
    private com.autonavi.aps.amapapi.c u;
    private boolean i = false;
    private boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<d> f26183a = new ArrayList<>();
    private String k = null;
    private ArrayList<d> l = new ArrayList<>();
    private long n = 0;
    PhoneStateListener c = null;
    private boolean o = false;
    private Object p = new Object();
    private boolean r = false;
    boolean e = false;
    StringBuilder f = null;
    private String s = null;
    private String t = null;
    String g = null;

    @SuppressLint({"NewApi"})
    public class a extends TelephonyManager.CellInfoCallback {
        public a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                if (com.autonavi.aps.amapapi.utils.i.b() - e.this.n < 500) {
                    return;
                }
                e.b(e.this);
                e.this.a(e.this.t());
                e.this.a(list);
                e.this.n = com.autonavi.aps.amapapi.utils.i.b();
            } catch (SecurityException e) {
                e.this.g = e.getMessage();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "cellInfo");
            }
        }
    }

    public class b extends PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                if (e.this.u != null) {
                    e.this.u.c();
                }
                if (com.autonavi.aps.amapapi.utils.i.b() - e.this.n < 500) {
                    return;
                }
                e.this.a(e.this.t());
                e.this.a(list);
                e.this.n = com.autonavi.aps.amapapi.utils.i.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            if (com.autonavi.aps.amapapi.utils.i.b() - e.this.n < 500) {
                return;
            }
            try {
                e.this.a(cellLocation);
                e.this.a(e.this.u());
                e.this.n = com.autonavi.aps.amapapi.utils.i.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i) {
            super.onDataConnectionStateChanged(i);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    e.this.a(false, false);
                } else {
                    if (state != 1) {
                        return;
                    }
                    e.this.j();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength == null) {
                return;
            }
            e eVar = e.this;
            eVar.d = signalStrength;
            try {
                if (eVar.u != null) {
                    e.this.u.c();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public e(Context context, Handler handler) {
        this.b = null;
        this.m = null;
        this.h = context;
        this.b = (TelephonyManager) com.autonavi.aps.amapapi.utils.i.a(context, AliyunLogCommon.TERMINAL_TYPE);
        o();
        c cVar = new c(context, "cellAge", handler);
        this.m = cVar;
        cVar.a();
    }

    public static boolean a(int i) {
        return i > 0 && i <= 15;
    }

    private static int b(int i) {
        return (i * 2) - 113;
    }

    public static /* synthetic */ boolean b(e eVar) {
        eVar.r = true;
        return true;
    }

    private void o() {
        if (this.b == null) {
            return;
        }
        p();
    }

    private void p() {
        try {
            if (this.c == null) {
                this.c = new b();
            }
            int i = Build.VERSION.SDK_INT;
            String str = "hasFineLocPerm";
            int i2 = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME;
            if (i >= 31) {
                if (this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                    this.t = "hasFineLocPerm";
                } else {
                    this.t = "hasNoFineLocPerm";
                    i2 = 320;
                }
            }
            if (i >= 31) {
                boolean z = true;
                boolean z2 = this.h.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                if (this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                    z = false;
                }
                if (z2 && z) {
                    i2 |= 1024;
                }
                this.s = z2 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                if (!z) {
                    str = "hasNoFineLocPerm";
                }
                this.t = str;
            } else {
                i2 |= 1024;
            }
            PhoneStateListener phoneStateListener = this.c;
            if (phoneStateListener != null) {
                this.b.listen(phoneStateListener, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int q() {
        d dVarE = e();
        if (dVarE != null) {
            return dVarE.l;
        }
        return 0;
    }

    private CellLocation r() {
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                this.g = null;
                return cellLocation;
            } catch (SecurityException e) {
                this.g = e.getMessage();
            } catch (Throwable th) {
                this.g = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean s() {
        return !this.e && com.autonavi.aps.amapapi.utils.i.b() - this.n >= 45000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation t() {
        if (this.b == null) {
            return null;
        }
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public List<CellInfo> u() {
        TelephonyManager telephonyManager;
        List<CellInfo> allCellInfo;
        try {
            if (com.autonavi.aps.amapapi.utils.i.c() < 18 || (telephonyManager = this.b) == null) {
                return null;
            }
            try {
                allCellInfo = telephonyManager.getAllCellInfo();
                try {
                    this.g = null;
                } catch (SecurityException e) {
                    e = e;
                    this.g = e.getMessage();
                }
            } catch (SecurityException e2) {
                e = e2;
                allCellInfo = null;
            }
            return allCellInfo;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    public final synchronized d f() {
        if (this.e) {
            return null;
        }
        ArrayList<d> arrayList = this.l;
        if (arrayList.size() <= 0) {
            return null;
        }
        for (d dVar : arrayList) {
            if (dVar.n) {
                return dVar.clone();
            }
        }
        return arrayList.get(0).clone();
    }

    public final int g() {
        return q() | (this.i ? 4 : 0) | (this.j ? 8 : 0);
    }

    public final int h() {
        return q() & 3;
    }

    public final TelephonyManager i() {
        return this.b;
    }

    public final synchronized void j() {
        this.g = null;
        this.f26183a.clear();
        this.l.clear();
        this.i = false;
        this.j = false;
    }

    public final String k() {
        return this.g;
    }

    public final String l() {
        return this.k;
    }

    public final synchronized String m() {
        if (this.e) {
            j();
        }
        StringBuilder sb = this.f;
        if (sb == null) {
            this.f = new StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if (h() == 1) {
            for (int i = 1; i < this.f26183a.size(); i++) {
                StringBuilder sb2 = this.f;
                sb2.append("#");
                sb2.append(this.f26183a.get(i).b);
                StringBuilder sb3 = this.f;
                sb3.append("|");
                sb3.append(this.f26183a.get(i).c);
                StringBuilder sb4 = this.f;
                sb4.append("|");
                sb4.append(this.f26183a.get(i).d);
            }
        }
        for (int i2 = 1; i2 < this.l.size(); i2++) {
            d dVar = this.l.get(i2);
            int i3 = dVar.l;
            if (i3 == 1 || i3 == 3 || i3 == 4 || i3 == 5) {
                StringBuilder sb5 = this.f;
                sb5.append("#");
                sb5.append(dVar.l);
                StringBuilder sb6 = this.f;
                sb6.append("|");
                sb6.append(dVar.f26182a);
                StringBuilder sb7 = this.f;
                sb7.append("|");
                sb7.append(dVar.b);
                StringBuilder sb8 = this.f;
                sb8.append("|");
                sb8.append(dVar.c);
                StringBuilder sb9 = this.f;
                sb9.append("|");
                sb9.append(dVar.a());
            } else if (i3 == 2) {
                StringBuilder sb10 = this.f;
                sb10.append("#");
                sb10.append(dVar.l);
                StringBuilder sb11 = this.f;
                sb11.append("|");
                sb11.append(dVar.f26182a);
                StringBuilder sb12 = this.f;
                sb12.append("|");
                sb12.append(dVar.h);
                StringBuilder sb13 = this.f;
                sb13.append("|");
                sb13.append(dVar.i);
                StringBuilder sb14 = this.f;
                sb14.append("|");
                sb14.append(dVar.j);
            }
        }
        if (this.f.length() > 0) {
            this.f.deleteCharAt(0);
        }
        return this.f.toString();
    }

    public final boolean n() {
        try {
            TelephonyManager telephonyManager = this.b;
            if (telephonyManager != null && (!TextUtils.isEmpty(telephonyManager.getSimOperator()) || !TextUtils.isEmpty(this.b.getSimCountryIso()))) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            int iA = com.autonavi.aps.amapapi.utils.i.a(com.autonavi.aps.amapapi.utils.i.c(this.h));
            return iA == 0 || iA == 4 || iA == 2 || iA == 5 || iA == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public final void b() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                String str = this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                String str2 = this.h.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z = true;
                boolean z2 = (TextUtils.isEmpty(this.t) || this.t.equals(str)) ? false : true;
                if (TextUtils.isEmpty(this.s) || this.s.equals(str2)) {
                    z = z2;
                }
                if (z) {
                    p();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized ArrayList<d> c() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.f26183a;
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<d> d() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.l;
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized d e() {
        if (this.e) {
            return null;
        }
        ArrayList<d> arrayList = this.f26183a;
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0).clone();
    }

    public final List<ka> a() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> allCellInfo = this.b.getAllCellInfo();
        if (allCellInfo != null) {
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    kb kbVar = new kb(cellInfo.isRegistered(), true);
                    kbVar.m = cellIdentity.getLatitude();
                    kbVar.n = cellIdentity.getLongitude();
                    kbVar.j = cellIdentity.getSystemId();
                    kbVar.k = cellIdentity.getNetworkId();
                    kbVar.l = cellIdentity.getBasestationId();
                    kbVar.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    kbVar.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(kbVar);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    kc kcVar = new kc(cellInfo.isRegistered(), true);
                    kcVar.f25983a = String.valueOf(cellIdentity2.getMcc());
                    kcVar.b = String.valueOf(cellIdentity2.getMnc());
                    kcVar.j = cellIdentity2.getLac();
                    kcVar.k = cellIdentity2.getCid();
                    kcVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    kcVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    kcVar.m = cellIdentity2.getArfcn();
                    kcVar.n = cellIdentity2.getBsic();
                    arrayList.add(kcVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    kd kdVar = new kd(cellInfo.isRegistered());
                    kdVar.f25983a = String.valueOf(cellIdentity3.getMcc());
                    kdVar.b = String.valueOf(cellIdentity3.getMnc());
                    kdVar.l = cellIdentity3.getPci();
                    kdVar.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    kdVar.k = cellIdentity3.getCi();
                    kdVar.j = cellIdentity3.getTac();
                    kdVar.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    kdVar.c = cellInfoLte.getCellSignalStrength().getDbm();
                    kdVar.m = cellIdentity3.getEarfcn();
                    arrayList.add(kdVar);
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    ke keVar = new ke(cellInfo.isRegistered(), true);
                    keVar.f25983a = String.valueOf(cellIdentity4.getMcc());
                    keVar.b = String.valueOf(cellIdentity4.getMnc());
                    keVar.j = cellIdentity4.getLac();
                    keVar.k = cellIdentity4.getCid();
                    keVar.l = cellIdentity4.getPsc();
                    keVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                    keVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                    keVar.m = cellIdentity4.getUarfcn();
                    arrayList.add(keVar);
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    private void b(boolean z, boolean z2) {
        if (!this.e && this.b != null && Build.VERSION.SDK_INT >= 29 && this.h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.q == null) {
                this.q = new a();
            }
            this.b.requestCellInfoUpdate(z.g().e(), this.q);
            if (z2 || z) {
                for (int i = 0; !this.r && i < 20; i++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.j = false;
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.k = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.j = true;
            }
        }
        this.n = com.autonavi.aps.amapapi.utils.i.b();
    }

    public final void a(boolean z, boolean z2) {
        try {
            this.e = com.autonavi.aps.amapapi.utils.i.a(this.h);
            if (s()) {
                b(z, z2);
                a(t());
                a(u());
            }
            if (this.e) {
                j();
            }
        } catch (SecurityException e) {
            this.g = e.getMessage();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", com.alipay.sdk.m.c0.d.x);
        }
    }

    public final void a(boolean z) {
        PhoneStateListener phoneStateListener;
        this.m.a(z);
        this.n = 0L;
        synchronized (this.p) {
            this.o = true;
        }
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null && (phoneStateListener = this.c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "destroy");
            }
        }
        this.c = null;
        this.d = null;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(CellLocation cellLocation) {
        String[] strArrA = com.autonavi.aps.amapapi.utils.i.a(this.b);
        this.f26183a.clear();
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            d dVar = new d(1, true);
            dVar.f26182a = com.autonavi.aps.amapapi.utils.i.e(strArrA[0]);
            dVar.b = com.autonavi.aps.amapapi.utils.i.e(strArrA[1]);
            dVar.c = gsmCellLocation.getLac();
            dVar.d = gsmCellLocation.getCid();
            SignalStrength signalStrength = this.d;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                dVar.s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : b(gsmSignalStrength);
            }
            dVar.r = false;
            this.m.a(dVar);
            this.f26183a.add(dVar);
            return;
        }
        if (cellLocation instanceof CdmaCellLocation) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            d dVar2 = new d(2, true);
            dVar2.f26182a = Integer.parseInt(strArrA[0]);
            dVar2.b = Integer.parseInt(strArrA[1]);
            dVar2.f = cdmaCellLocation.getBaseStationLatitude();
            dVar2.g = cdmaCellLocation.getBaseStationLongitude();
            dVar2.h = cdmaCellLocation.getSystemId();
            dVar2.i = cdmaCellLocation.getNetworkId();
            dVar2.j = cdmaCellLocation.getBaseStationId();
            SignalStrength signalStrength2 = this.d;
            if (signalStrength2 != null) {
                dVar2.s = signalStrength2.getCdmaDbm();
            }
            dVar2.r = false;
            this.m.a(dVar2);
            this.f26183a.add(dVar2);
        }
    }

    public final synchronized void a(List<CellInfo> list) {
        d dVarA;
        ArrayList<d> arrayList = this.l;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                CellInfo cellInfo = list.get(i);
                if (cellInfo != null) {
                    boolean zIsRegistered = cellInfo.isRegistered();
                    if (cellInfo instanceof CellInfoCdma) {
                        dVarA = a((CellInfoCdma) cellInfo, zIsRegistered);
                    } else if (cellInfo instanceof CellInfoGsm) {
                        dVarA = a((CellInfoGsm) cellInfo, zIsRegistered);
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        dVarA = a((CellInfoWcdma) cellInfo, zIsRegistered);
                    } else if (cellInfo instanceof CellInfoLte) {
                        dVarA = a((CellInfoLte) cellInfo, zIsRegistered);
                    } else {
                        dVarA = (Build.VERSION.SDK_INT < 29 || !(cellInfo instanceof CellInfoNr)) ? null : a((CellInfoNr) cellInfo, zIsRegistered);
                    }
                    if (dVarA != null) {
                        this.m.a(dVarA);
                        dVarA.m = (short) Math.min(65535L, this.m.e(dVarA));
                        dVarA.r = true;
                        this.l.add(dVarA);
                    }
                }
            }
            this.i = false;
            ArrayList<d> arrayList2 = this.l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.i = true;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static d a(CellInfoGsm cellInfoGsm, boolean z) {
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        d dVarA = a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        dVarA.o = cellInfoGsm.getCellIdentity().getBsic();
        dVarA.p = cellInfoGsm.getCellIdentity().getArfcn();
        dVarA.q = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        dVarA.s = cellInfoGsm.getCellSignalStrength().getDbm();
        return dVarA;
    }

    private static d a(CellInfoWcdma cellInfoWcdma, boolean z) {
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        d dVarA = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        dVarA.o = cellIdentity.getPsc();
        dVarA.p = cellInfoWcdma.getCellIdentity().getUarfcn();
        dVarA.s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return dVarA;
    }

    private static d a(CellInfoLte cellInfoLte, boolean z) {
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        d dVarA = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        dVarA.o = cellIdentity.getPci();
        dVarA.p = cellIdentity.getEarfcn();
        dVarA.q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        dVarA.s = cellInfoLte.getCellSignalStrength().getDbm();
        return dVarA;
    }

    private static d a(CellInfoNr cellInfoNr, boolean z) {
        int i;
        if (cellInfoNr == null || cellInfoNr.getCellIdentity() == null) {
            return null;
        }
        CellIdentityNr cellIdentityNr = (CellIdentityNr) cellInfoNr.getCellIdentity();
        int tac = cellIdentityNr.getTac();
        int i2 = 0;
        if (tac == Integer.MAX_VALUE && "HUAWEI".equals(Build.MANUFACTURER)) {
            try {
                tac = com.autonavi.aps.amapapi.utils.e.b(cellIdentityNr, "getHwTac", new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        long nci = cellIdentityNr.getNci();
        try {
            i = Integer.parseInt(cellIdentityNr.getMccString());
            try {
                i2 = Integer.parseInt(cellIdentityNr.getMncString());
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
        }
        d dVarA = a(5, z, i, i2, cellIdentityNr.getTac(), 0, ((CellSignalStrengthNr) cellInfoNr.getCellSignalStrength()).getSsRsrp());
        dVarA.e = nci;
        if (tac > 16777215) {
            dVarA.c = 65535;
        } else if (tac > 65535) {
            dVarA.c = 65535;
            dVarA.q = tac;
        } else {
            dVarA.c = tac;
        }
        dVarA.o = cellIdentityNr.getPci();
        dVarA.p = cellIdentityNr.getNrarfcn();
        dVarA.s = cellInfoNr.getCellSignalStrength().getDbm();
        return dVarA;
    }

    private d a(CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] strArrA = com.autonavi.aps.amapapi.utils.i.a(this.b);
                int i2 = 0;
                try {
                    i = Integer.parseInt(strArrA[0]);
                    try {
                        i2 = Integer.parseInt(strArrA[1]);
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    i = 0;
                }
                d dVarA = a(2, z, i, i2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                dVarA.h = cellIdentity2.getSystemId();
                dVarA.i = cellIdentity2.getNetworkId();
                dVarA.j = cellIdentity2.getBasestationId();
                dVarA.f = cellIdentity2.getLatitude();
                dVarA.g = cellIdentity2.getLongitude();
                dVarA.s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return dVarA;
            }
        }
        return null;
    }

    private static d a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        d dVar = new d(i, z);
        dVar.f26182a = i2;
        dVar.b = i3;
        dVar.c = i4;
        dVar.d = i5;
        dVar.k = i6;
        return dVar;
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.u = cVar;
    }
}
