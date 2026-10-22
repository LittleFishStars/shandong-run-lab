package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.fusion.model.RequestInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class t2 {
    private static t2 c;
    private static List d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27770a = false;
    private boolean b = false;

    public class a extends p9 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27771a;

        /* JADX INFO: renamed from: com.beizi.fusion.t2$a$a, reason: collision with other inner class name */
        public class C0323a implements c0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BeiZiLocation f27772a;

            public C0323a(BeiZiLocation beiZiLocation) {
                this.f27772a = beiZiLocation;
            }

            @Override // com.beizi.fusion.jd
            public double a() {
                try {
                    String latitude = this.f27772a.getLatitude();
                    return !TextUtils.isEmpty(latitude) ? Double.parseDouble(latitude) : AudioStats.AUDIO_AMPLITUDE_NONE;
                } catch (Exception unused) {
                    return AudioStats.AUDIO_AMPLITUDE_NONE;
                }
            }

            @Override // com.beizi.fusion.jd
            public double b() {
                try {
                    String longitude = this.f27772a.getLongitude();
                    return !TextUtils.isEmpty(longitude) ? Double.parseDouble(longitude) : AudioStats.AUDIO_AMPLITUDE_NONE;
                } catch (Exception unused) {
                    return AudioStats.AUDIO_AMPLITUDE_NONE;
                }
            }

            @Override // com.beizi.fusion.jd
            public jd.a c() {
                try {
                    String type = this.f27772a.getType();
                    if (TextUtils.isEmpty(type)) {
                        return null;
                    }
                    int iHashCode = type.hashCode();
                    if (iHashCode == -1736143482) {
                        if (type.equals("WGS-84")) {
                            return jd.a.WGS_84;
                        }
                        return null;
                    }
                    if (iHashCode == 62961147) {
                        if (type.equals("BAIDU")) {
                            return jd.a.BD_09;
                        }
                        return null;
                    }
                    if (iHashCode == 2096794945 && type.equals("GCJ-02")) {
                        return jd.a.GCJ_02;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }

            @Override // com.beizi.fusion.jd
            public long d() {
                try {
                    return this.f27772a.getTime();
                } catch (Exception unused) {
                    return 0L;
                }
            }
        }

        public a(Context context) {
            this.f27771a = context;
        }

        @Override // com.beizi.fusion.p9
        public c0 a() {
            BeiZiLocation location;
            return (BeiZis.getCustomController() == null || (location = BeiZis.getCustomController().getLocation()) == null) ? super.a() : new C0323a(location);
        }

        @Override // com.beizi.fusion.p9
        public String b() {
            return BeiZis.getCustomController() != null ? BeiZis.getCustomController().getAndroidId() : super.b();
        }

        @Override // com.beizi.fusion.p9
        public String d() {
            try {
                if (RequestInfo.getInstance(this.f27771a).getDevInfo() != null) {
                    String oaid = RequestInfo.getInstance(this.f27771a).getDevInfo().getOaid();
                    if (!TextUtils.isEmpty(oaid)) {
                        return oaid;
                    }
                    String customOaid = RequestInfo.getInstance(this.f27771a).getCustomOaid();
                    if (!TextUtils.isEmpty(customOaid)) {
                        return customOaid;
                    }
                }
            } catch (Exception unused) {
            }
            return super.d();
        }

        @Override // com.beizi.fusion.p9
        public String f() {
            return this.f27771a != null ? rf.a().b(this.f27771a.getApplicationContext()) : super.f();
        }

        @Override // com.beizi.fusion.p9
        public boolean g() {
            return false;
        }

        @Override // com.beizi.fusion.p9
        public boolean h() {
            return BeiZis.getCustomController() != null ? BeiZis.getCustomController().isCanUseLocation() : super.h();
        }

        @Override // com.beizi.fusion.p9
        public boolean i() {
            return BeiZis.getCustomController() != null ? BeiZis.getCustomController().isCanUseAndroidId() : super.i();
        }

        @Override // com.beizi.fusion.p9
        public boolean j() {
            return !q1.h().u();
        }

        @Override // com.beizi.fusion.p9
        public boolean k() {
            return !al.b();
        }
    }

    public static synchronized t2 a() {
        if (c == null) {
            synchronized (t2.class) {
                c = new t2();
            }
        }
        return c;
    }

    public void a(Context context, String str, BeiZiInitCallBack beiZiInitCallBack) {
        if (this.f27770a) {
            if (beiZiInitCallBack != null) {
                beiZiInitCallBack.success();
                return;
            }
            return;
        }
        if (beiZiInitCallBack != null) {
            d.add(beiZiInitCallBack);
        }
        if (this.b) {
            return;
        }
        this.b = true;
        v.a aVar = new v.a(str);
        aVar.a(q1.h().e());
        aVar.a(BeiZis.getTransferProtocol());
        aVar.a(new a(context));
        c.a().a(context, aVar.a(), new b());
    }

    public class b implements qc {
        public b() {
        }

        @Override // com.beizi.fusion.qc
        public void a() {
            t2 t2Var = t2.this;
            t2Var.b = false;
            t2Var.f27770a = true;
            synchronized (this) {
                List list = t2.d;
                if (list != null && !list.isEmpty()) {
                    for (BeiZiInitCallBack beiZiInitCallBack : t2.d) {
                        if (beiZiInitCallBack != null) {
                            beiZiInitCallBack.success();
                        }
                    }
                    t2.d.clear();
                }
            }
        }

        @Override // com.beizi.fusion.qc
        public void b() {
            t2 t2Var = t2.this;
            t2Var.b = false;
            t2Var.f27770a = true;
            synchronized (this) {
                List list = t2.d;
                if (list != null && !list.isEmpty()) {
                    for (BeiZiInitCallBack beiZiInitCallBack : t2.d) {
                        if (beiZiInitCallBack != null) {
                            beiZiInitCallBack.success();
                        }
                    }
                    t2.d.clear();
                }
            }
        }

        @Override // com.beizi.fusion.qc
        public void c() {
        }

        @Override // com.beizi.fusion.qc
        public void a(int i, String str) {
            t2.this.b = false;
            synchronized (this) {
                List list = t2.d;
                if (list != null && !list.isEmpty()) {
                    for (BeiZiInitCallBack beiZiInitCallBack : t2.d) {
                        if (beiZiInitCallBack != null) {
                            beiZiInitCallBack.fail(i, str);
                        }
                    }
                    t2.d.clear();
                }
            }
        }
    }
}
