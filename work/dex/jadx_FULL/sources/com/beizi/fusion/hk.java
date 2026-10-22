package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class hk extends cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final dp f27368a = b(zo.f28110a);

    public class a implements dp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ap f27369a;

        public a(ap apVar) {
            this.f27369a = apVar;
        }
    }

    public static dp a(ap apVar) {
        return apVar == zo.f28110a ? f27368a : b(apVar);
    }

    private static dp b(ap apVar) {
        return new a(apVar);
    }
}
