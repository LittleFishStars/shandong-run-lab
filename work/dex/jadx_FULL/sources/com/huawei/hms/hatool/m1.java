package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class m1 {
    private static m1 b = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f37572a = new a();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f37573a;
        String b;
        long c = 0;

        public a() {
        }

        public void a(long j) {
            m1.this.f37572a.c = j;
        }

        public void a(String str) {
            m1.this.f37572a.b = str;
        }

        public void b(String str) {
            m1.this.f37572a.f37573a = str;
        }
    }

    public static m1 d() {
        return b;
    }

    public String a() {
        return this.f37572a.b;
    }

    public void a(String str, String str2) {
        long jB = b();
        String strC = w0.c(str, str2);
        if (strC == null || strC.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jB == 0) {
            jB = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - jB <= com.heytap.mcssdk.constant.a.g) {
            return;
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String strA = h0.a(strC, strGenerateSecureRandomStr);
        this.f37572a.a(jB);
        this.f37572a.b(strGenerateSecureRandomStr);
        this.f37572a.a(strA);
    }

    public long b() {
        return this.f37572a.c;
    }

    public String c() {
        return this.f37572a.f37573a;
    }
}
