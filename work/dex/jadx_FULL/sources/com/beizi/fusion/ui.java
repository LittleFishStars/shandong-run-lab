package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ui implements nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27834a;
    private final String b;

    public enum a implements nc {
        ERROR_UNEXPECTED(-99, "error unexpected"),
        ERROR_METHOD(504, "request method error"),
        ERROR_REDIRECT_LOOP(-97, "error redirect loop"),
        ERROR_INVALID_URL(-98, "error invalid request url");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27835a;
        private final String b;

        a(int i, String str) {
            this.f27835a = i;
            this.b = str;
        }

        @Override // com.beizi.fusion.nc
        public String a() {
            return this.b;
        }

        @Override // com.beizi.fusion.nc
        public int b() {
            return this.f27835a;
        }
    }

    public ui(int i, String str) {
        this.f27834a = i;
        this.b = str;
    }

    @Override // com.beizi.fusion.nc
    public String a() {
        return this.b;
    }

    @Override // com.beizi.fusion.nc
    public int b() {
        return this.f27834a;
    }
}
