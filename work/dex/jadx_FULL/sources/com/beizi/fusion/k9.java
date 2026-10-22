package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k9 implements ke {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27468a;
    private final cm b;
    private final byte[] c;
    private final m5 d;
    private final boolean e;

    public k9(String str, cm cmVar, byte[] bArr, m5 m5Var, boolean z) {
        this.f27468a = str;
        this.b = cmVar;
        this.c = bArr;
        this.d = m5Var;
        this.e = z;
    }

    @Override // com.beizi.fusion.ke
    public String a() {
        return this.f27468a;
    }

    @Override // com.beizi.fusion.ke
    public cm b() {
        return this.b;
    }

    @Override // com.beizi.fusion.ke
    public byte[] c() {
        return this.c;
    }

    @Override // com.beizi.fusion.ke
    public boolean d() {
        return this.e;
    }

    @Override // com.beizi.fusion.ke
    public m5 e() {
        return this.d;
    }

    public k9(String str, ke keVar) {
        this.f27468a = str;
        this.d = keVar.e();
        this.b = keVar.b();
        this.c = new byte[0];
        this.e = keVar.d();
    }
}
