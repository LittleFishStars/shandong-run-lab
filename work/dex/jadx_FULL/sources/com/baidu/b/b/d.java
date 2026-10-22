package com.baidu.b.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.baidu.b.h;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d extends com.baidu.b.b.a {
    com.baidu.b.e.a.C0258a d;
    private a e;

    public class a {
        private long c;
        private h.a d;
        private boolean e;
        private int g;
        private com.baidu.b.f.b b = new com.baidu.b.f.b();
        private boolean f = true;

        public a() {
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.c = jSONObject.getLong("pub_lst_ts");
                    this.d = h.a(jSONObject.getString("pub_info"));
                    this.g = jSONObject.getInt("d_form_ver");
                    this.e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public long a() {
            return this.c;
        }

        public boolean a(PackageInfo packageInfo) {
            String strA = d.this.d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f = false;
            return a(strA);
        }

        public h.a b() {
            return this.d;
        }
    }

    public class b extends com.baidu.b.b.a.b {
        private int b;
        private String c;
        private long d;
        private long e;
        private long f;
        private h.a g;

        public b(String str) {
            super(d.this.d, str);
        }

        public void a(a aVar) {
            a(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.b.b.a.b
        public void a(JSONObject jSONObject) throws JSONException {
            this.c = jSONObject.getString(com.igexin.push.core.b.aC);
            this.e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.d = jSONObject.getLong("last_fe_ts");
            this.g = h.a(jSONObject.getString(AliyunLogCommon.LogLevel.INFO));
            this.f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.d == j) {
                return false;
            }
            this.d = j;
            a(true);
            return true;
        }

        public boolean a(h.a aVar) {
            if (aVar.equals(this.g)) {
                return false;
            }
            this.g = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.c)) {
                return false;
            }
            this.c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.b.b.a.b
        public void b(JSONObject jSONObject) throws JSONException {
            jSONObject.put(com.igexin.push.core.b.aC, this.c);
            jSONObject.put("last_fe_ts", this.d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.e);
            jSONObject.put(AliyunLogCommon.LogLevel.INFO, this.g.a());
            jSONObject.put("tar_pkg_lst_up_ts", this.f);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.e == j) {
                return false;
            }
            this.e = j;
            a(true);
            return true;
        }

        public String c() {
            return this.c;
        }

        public boolean c(long j) {
            if (this.f == j) {
                return false;
            }
            this.f = j;
            a(true);
            return true;
        }

        public h.a d() {
            return this.g;
        }

        public long e() {
            return this.f;
        }
    }

    public d() {
        super("isc", 8000000L);
        this.e = new a();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0041 A[PHI: r2
      0x0041: PHI (r2v1 com.baidu.b.b.d$b) = (r2v0 com.baidu.b.b.d$b), (r2v2 com.baidu.b.b.d$b), (r2v2 com.baidu.b.b.d$b) binds: [B:11:0x001a, B:13:0x002c, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    @Override // com.baidu.b.b.a
    public com.baidu.b.b.a.e a(String str, com.baidu.b.b.a.d dVar) {
        PackageInfo packageInfo;
        a aVar;
        h.a aVarB;
        b bVar = null;
        try {
            packageInfo = this.b.f26262a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return com.baidu.b.b.a.e.a(-2);
        }
        if (dVar.f26264a) {
            bVar = new b(str);
            bVar.a();
            if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                aVarB = bVar.d();
            } else {
                aVar = new a();
                if (!aVar.a(packageInfo)) {
                    return com.baidu.b.b.a.e.a(-2);
                }
                if (dVar.f26264a && bVar != null) {
                    bVar.a(aVar);
                    bVar.a(System.currentTimeMillis());
                    bVar.c(packageInfo.lastUpdateTime);
                    bVar.a(str);
                    bVar.b();
                }
                aVarB = aVar.b();
            }
        } else {
            aVar = new a();
            if (!aVar.a(packageInfo)) {
                return com.baidu.b.b.a.e.a(-2);
            }
            if (dVar.f26264a) {
                bVar.a(aVar);
                bVar.a(System.currentTimeMillis());
                bVar.c(packageInfo.lastUpdateTime);
                bVar.a(str);
                bVar.b();
            }
            aVarB = aVar.b();
        }
        return com.baidu.b.b.a.e.a(aVarB);
    }

    @Override // com.baidu.b.b.a
    public void a(com.baidu.b.b.a.c cVar) {
        this.d = this.c.a("isc");
    }
}
