package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.imagepipeline.common.Priority;
import com.zj.adlib.h76;
import com.zj.adlib.sf7;
import com.zj.adlib.x64;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Immutable
public class ImageRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f30036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Priority f1721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageType f1722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RequestLevel f1723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Postprocessor f1724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public sf7 f1725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final x64 f1726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File f1727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1728a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public enum ImageType {
        SMALL,
        DEFAULT
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);

        private int mValue;

        RequestLevel(int i) {
            this.mValue = i;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        this.f1725a = null;
        this.f1722a = imageRequestBuilder.e();
        this.f30036a = imageRequestBuilder.j();
        this.f1728a = imageRequestBuilder.n();
        this.b = imageRequestBuilder.m();
        this.f1726a = imageRequestBuilder.d();
        this.f1725a = imageRequestBuilder.i();
        this.c = imageRequestBuilder.k();
        this.f1721a = imageRequestBuilder.h();
        this.f1723a = imageRequestBuilder.f();
        this.d = imageRequestBuilder.l();
        this.f1724a = imageRequestBuilder.g();
    }

    public static ImageRequest a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.p(uri).a();
    }

    public static ImageRequest b(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a(Uri.parse(str));
    }

    public boolean c() {
        return this.c;
    }

    public x64 d() {
        return this.f1726a;
    }

    public ImageType e() {
        return this.f1722a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        return h76.a(this.f30036a, imageRequest.f30036a) && h76.a(this.f1722a, imageRequest.f1722a) && h76.a(this.f1727a, imageRequest.f1727a);
    }

    public boolean f() {
        return this.b;
    }

    public RequestLevel g() {
        return this.f1723a;
    }

    @Nullable
    public Postprocessor h() {
        return this.f1724a;
    }

    public int hashCode() {
        return h76.c(this.f1722a, this.f30036a, this.f1727a);
    }

    public int i() {
        sf7 sf7Var = this.f1725a;
        if (sf7Var != null) {
            return sf7Var.b;
        }
        return 2048;
    }

    public int j() {
        sf7 sf7Var = this.f1725a;
        if (sf7Var != null) {
            return sf7Var.f44682a;
        }
        return 2048;
    }

    public Priority k() {
        return this.f1721a;
    }

    public boolean l() {
        return this.f1728a;
    }

    @Nullable
    public sf7 m() {
        return this.f1725a;
    }

    public synchronized File n() {
        if (this.f1727a == null) {
            this.f1727a = new File(this.f30036a.getPath());
        }
        return this.f1727a;
    }

    public Uri o() {
        return this.f30036a;
    }

    public boolean p() {
        return this.d;
    }
}
