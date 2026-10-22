package com.beizi.fusion;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class rj extends cp {
    private static final dp b = b(zo.b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ap f27726a;

    public class a implements dp {
        public a() {
        }
    }

    private rj(ap apVar) {
        this.f27726a = apVar;
    }

    private static dp b(ap apVar) {
        return new rj(apVar).new a();
    }

    public static dp a(ap apVar) {
        return apVar == zo.b ? b : b(apVar);
    }

    @Override // com.beizi.fusion.cp
    public void a(og ogVar, Number number) throws IOException {
        ogVar.a(number);
    }
}
