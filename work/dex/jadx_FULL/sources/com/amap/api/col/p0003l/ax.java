package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.zj.adlib.asa;
import com.zj.adlib.boa;
import com.zj.adlib.bsa;
import com.zj.adlib.esa;
import com.zj.adlib.fsa;
import com.zj.adlib.gsa;
import com.zj.adlib.hsa;
import com.zj.adlib.isa;
import com.zj.adlib.tna;
import com.zj.adlib.yra;
import com.zj.adlib.zwa;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ax extends OfflineMapCity implements bg, bx {
    public static final Parcelable.Creator<ax> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cb f25880a;
    public final cb b;
    public final cb c;
    public final cb d;
    public final cb e;
    public final cb f;
    public final cb g;
    public final cb h;
    public final cb i;
    public final cb j;
    public final cb k;
    cb l;
    Context m;
    boolean n;
    private String o;
    private String p;
    private long q;

    public static class b implements Parcelable.Creator<ax> {
        public static ax a(Parcel parcel) {
            return new ax(parcel);
        }

        public static ax[] b(int i) {
            return new ax[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax[] newArray(int i) {
            return b(i);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25882a;

        static {
            int[] iArr = new int[by.a.values().length];
            f25882a = iArr;
            try {
                iArr[by.a.amap_exception.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25882a[by.a.file_io_exception.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25882a[by.a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ax(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        s();
    }

    private String A() {
        if (TextUtils.isEmpty(this.o)) {
            return null;
        }
        String str = this.o;
        return str.substring(0, str.lastIndexOf(Consts.DOT));
    }

    private String B() {
        if (TextUtils.isEmpty(this.o)) {
            return null;
        }
        String strA = A();
        return strA.substring(0, strA.lastIndexOf(46));
    }

    private boolean C() {
        boa.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    private void z() {
        ay ayVarB = ay.b(this.m);
        if (ayVarB != null) {
            ayVarB.e(this);
        }
    }

    @Override // com.amap.api.col.p0003l.bg
    public final String b() {
        return getUrl();
    }

    public final cb c() {
        return this.l;
    }

    public final void d() {
        ay ayVarB = ay.b(this.m);
        if (ayVarB != null) {
            ayVarB.p(this);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e() {
        ay ayVarB = ay.b(this.m);
        if (ayVarB != null) {
            ayVarB.w(this);
            d();
        }
    }

    public final void f() {
        c().d();
        if (this.l.equals(this.d)) {
            this.l.g();
            return;
        }
        if (this.l.equals(this.c)) {
            this.l.i();
            return;
        }
        if (this.l.equals(this.g) || this.l.equals(this.h)) {
            z();
            this.n = true;
        } else if (this.l.equals(this.j) || this.l.equals(this.i) || this.l.c(this.k)) {
            this.l.f();
        } else {
            c().h();
        }
    }

    public final void g() {
        this.l.i();
    }

    public final void h() {
        this.l.b(this.k.d());
    }

    public final void i() {
        this.l.a();
        if (this.n) {
            this.l.h();
        }
        this.n = false;
    }

    public final void j() {
        this.l.equals(this.f);
        this.l.j();
    }

    public final void k() {
        ay ayVarB = ay.b(this.m);
        if (ayVarB != null) {
            ayVarB.k(this);
        }
    }

    public final void l() {
        ay ayVarB = ay.b(this.m);
        if (ayVarB != null) {
            ayVarB.t(this);
        }
    }

    @Override // com.amap.api.col.p0003l.by
    public final void m() {
        this.q = 0L;
        this.l.equals(this.b);
        this.l.f();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void n() {
        this.l.equals(this.c);
        this.l.k();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void o() {
        e();
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void p() {
        this.q = 0L;
        setCompleteCode(0);
        this.l.equals(this.e);
        this.l.f();
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void q() {
        this.l.equals(this.e);
        this.l.b(this.h.d());
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void r() {
        e();
    }

    public final void s() {
        String str = ay.f716a;
        String strI = boa.i(getUrl());
        if (strI != null) {
            this.o = str + strI + ".zip.tmp";
            return;
        }
        this.o = str + getPinyin() + ".zip.tmp";
    }

    public final tna t() {
        setState(this.l.d());
        tna tnaVar = new tna(this, this.m);
        tnaVar.m(a());
        a();
        return tnaVar;
    }

    @Override // com.amap.api.col.p0003l.bx
    public final boolean u() {
        return C();
    }

    @Override // com.amap.api.col.p0003l.bx
    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        String strI = boa.i(getUrl());
        if (strI != null) {
            stringBuffer.append(strI);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003l.bx
    public final String w() {
        return getAdcode();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.p);
    }

    @Override // com.amap.api.col.p0003l.br
    public final String x() {
        return A();
    }

    @Override // com.amap.api.col.p0003l.br
    public final String y() {
        return B();
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void b(String str) {
        this.l.equals(this.e);
        this.p = str;
        String strA = A();
        String strB = B();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB)) {
            q();
            return;
        }
        File file = new File(strB + WVNativeCallbackUtil.SEPERATER);
        File file2 = new File(zwa.v(this.m) + File.separator + "map/");
        File file3 = new File(zwa.v(this.m));
        if (file3.exists() || file3.mkdir()) {
            if (file2.exists() || file2.mkdir()) {
                a(file, file2, strA);
            }
        }
    }

    public final void a(String str) {
        this.p = str;
    }

    public class a implements bp.a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ File f714a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f715a;

        public a(String str, File file) {
            this.f715a = str;
            this.f714a = file;
        }

        @Override // com.amap.api.col.3l.bp.a
        public final void a(float f) {
            int i = (int) ((((double) f) * 0.39d) + 60.0d);
            if (i - ax.this.getcompleteCode() <= 0 || System.currentTimeMillis() - ax.this.q <= 1000) {
                return;
            }
            ax.this.setCompleteCode(i);
            ax.this.q = System.currentTimeMillis();
        }

        @Override // com.amap.api.col.3l.bp.a
        public final void b() {
            ax axVar = ax.this;
            axVar.l.b(axVar.k.d());
        }

        @Override // com.amap.api.col.3l.bp.a
        public final void a() {
            try {
                if (new File(this.f715a).delete()) {
                    boa.l(this.f714a);
                    ax.this.setCompleteCode(100);
                    ax.this.l.k();
                }
            } catch (Exception unused) {
                ax axVar = ax.this;
                axVar.l.b(axVar.k.d());
            }
        }
    }

    public final String a() {
        return this.p;
    }

    public final void a(int i) {
        if (i == -1) {
            this.l = this.h;
        } else if (i == 0) {
            this.l = this.c;
        } else if (i == 1) {
            this.l = this.e;
        } else if (i == 2) {
            this.l = this.b;
        } else if (i == 3) {
            this.l = this.d;
        } else if (i == 4) {
            this.l = this.f;
        } else if (i == 6) {
            this.l = this.f25880a;
        } else if (i != 7) {
            switch (i) {
                case 101:
                    this.l = this.i;
                    break;
                case 102:
                    this.l = this.j;
                    break;
                case 103:
                    this.l = this.k;
                    break;
                default:
                    if (i < 0) {
                        this.l = this.h;
                    }
                    break;
            }
        } else {
            this.l = this.g;
        }
        setState(i);
    }

    private ax(Context context, int i) {
        this.f25880a = new asa(this);
        this.b = new isa(this);
        this.c = new esa(this);
        this.d = new gsa(this);
        this.e = new hsa(this);
        this.f = new yra(this);
        this.g = new fsa(this);
        this.h = new bsa(-1, this);
        this.i = new bsa(101, this);
        this.j = new bsa(102, this);
        this.k = new bsa(103, this);
        this.o = null;
        this.p = "";
        this.n = false;
        this.q = 0L;
        this.m = context;
        a(i);
    }

    public final cb b(int i) {
        switch (i) {
            case 101:
                return this.i;
            case 102:
                return this.j;
            case 103:
                return this.k;
            default:
                return this.h;
        }
    }

    public final void a(cb cbVar) {
        this.l = cbVar;
        setState(cbVar.d());
    }

    @Override // com.amap.api.col.p0003l.by
    public final void a(long j, long j2) {
        int i = (int) ((j2 * 100) / j);
        if (i != getcompleteCode()) {
            setCompleteCode(i);
            d();
        }
    }

    @Override // com.amap.api.col.p0003l.by
    public final void a(by.a aVar) {
        int iD;
        int i = c.f25882a[aVar.ordinal()];
        if (i == 1) {
            iD = this.j.d();
        } else if (i != 2) {
            iD = i != 3 ? 6 : this.i.d();
        } else {
            iD = this.k.d();
        }
        if (this.l.equals(this.c) || this.l.equals(this.b)) {
            this.l.b(iD);
        }
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void a(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.q > 500) {
            int i = (int) j;
            if (i > getcompleteCode()) {
                setCompleteCode(i);
                d();
            }
            this.q = jCurrentTimeMillis;
        }
    }

    public ax(Parcel parcel) {
        super(parcel);
        this.f25880a = new asa(this);
        this.b = new isa(this);
        this.c = new esa(this);
        this.d = new gsa(this);
        this.e = new hsa(this);
        this.f = new yra(this);
        this.g = new fsa(this);
        this.h = new bsa(-1, this);
        this.i = new bsa(101, this);
        this.j = new bsa(102, this);
        this.k = new bsa(103, this);
        this.o = null;
        this.p = "";
        this.n = false;
        this.q = 0L;
        this.p = parcel.readString();
    }

    private void a(File file, File file2, String str) {
        new bp().b(file, file2, -1L, boa.b(file), new a(str, file));
    }
}
