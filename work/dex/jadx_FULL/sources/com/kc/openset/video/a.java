package com.kc.openset.video;

import com.kc.openset.ad.config.AdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40001a;
    private final AdType b;
    private final String c;
    private final String d;
    private final int e;
    private final int f;
    private final VideoTubeDramaMode g;

    /* JADX INFO: renamed from: com.kc.openset.video.a$a, reason: collision with other inner class name */
    @Keep
    public static final class C1127a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f40002a;
        private AdType b;
        private String c;
        private String d;
        private int e;
        private int f;
        private VideoTubeDramaMode g;

        public C1127a a(int i) {
            this.e = i;
            return this;
        }

        public C1127a a(AdType adType) {
            this.b = adType;
            return this;
        }

        public C1127a a(VideoTubeDramaMode videoTubeDramaMode) {
            this.g = videoTubeDramaMode;
            return this;
        }

        public C1127a a(String str) {
            this.c = str;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public C1127a b(int i) {
            this.f = i;
            return this;
        }

        public C1127a b(String str) {
            this.d = str;
            return this;
        }

        public C1127a c(String str) {
            this.f40002a = str;
            return this;
        }
    }

    public a(C1127a c1127a) {
        this.f40001a = c1127a.f40002a;
        this.b = c1127a.b;
        this.c = c1127a.c;
        this.d = c1127a.d;
        this.e = c1127a.e;
        this.f = c1127a.f;
        this.g = c1127a.g;
    }

    public AdType a() {
        return this.b;
    }

    public VideoTubeDramaMode b() {
        return this.g;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.f;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.f40001a;
    }
}
