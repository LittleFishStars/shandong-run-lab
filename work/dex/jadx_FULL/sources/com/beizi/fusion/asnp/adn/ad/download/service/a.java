package com.beizi.fusion.asnp.adn.ad.download.service;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface a {

    /* JADX INFO: renamed from: com.beizi.fusion.asnp.adn.ad.download.service.a$a, reason: collision with other inner class name */
    public static class C0298a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27067a;
        private final String b;
        private final AdTraceModel c;
        private final String d;
        private final String e;
        private final String f;
        private b g;
        private long h;
        private int i;

        public C0298a(String str, DownloadInfoModel downloadInfoModel, String str2, AdTraceModel adTraceModel) {
            this.f27067a = str;
            this.e = b(downloadInfoModel);
            this.b = str2;
            this.c = adTraceModel;
            this.d = c(downloadInfoModel);
            this.f = a(downloadInfoModel);
        }

        private String a(DownloadInfoModel downloadInfoModel) {
            return downloadInfoModel != null ? downloadInfoModel.getApkMD5() : "";
        }

        private String b(DownloadInfoModel downloadInfoModel) {
            return downloadInfoModel != null ? downloadInfoModel.getBundle() : "";
        }

        private String c(DownloadInfoModel downloadInfoModel) {
            return downloadInfoModel != null ? downloadInfoModel.getName() : "";
        }

        public AdTraceModel d() {
            return this.c;
        }

        public String e() {
            return this.b;
        }

        public String a() {
            return this.f;
        }

        public String b() {
            return this.f27067a;
        }

        public String c() {
            return this.d;
        }

        public void a(b bVar) {
            this.g = bVar;
        }

        public void a(long j) {
            this.h = j;
        }

        public void a(int i) {
            b bVar;
            b bVar2;
            b bVar3;
            if (this.i == 16 && (bVar3 = this.g) != null) {
                bVar3.b(this);
            }
            if (this.i == 4 && i == 2 && (bVar2 = this.g) != null) {
                bVar2.a(this);
            }
            if (this.i == 2 && i == 4 && (bVar = this.g) != null) {
                bVar.c(this);
            }
            this.i = i;
        }
    }

    public interface b {
        void a(C0298a c0298a);

        void b(C0298a c0298a);

        void c(C0298a c0298a);
    }

    void a(C0298a c0298a);
}
