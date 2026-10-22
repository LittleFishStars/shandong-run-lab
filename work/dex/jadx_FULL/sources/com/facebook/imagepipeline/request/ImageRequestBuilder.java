package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.imagepipeline.common.Priority;
import com.zj.adlib.ax6;
import com.zj.adlib.sf7;
import com.zj.adlib.th9;
import com.zj.adlib.x64;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ImageRequestBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f30037a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageRequest.RequestLevel f1731a = ImageRequest.RequestLevel.FULL_FETCH;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1735a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public sf7 f1733a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public x64 f1734a = x64.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageRequest.ImageType f1730a = ImageRequest.ImageType.DEFAULT;
    public boolean b = false;
    public boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Priority f1729a = Priority.HIGH;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Postprocessor f1732a = null;
    public boolean d = true;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    public static ImageRequestBuilder c(ImageRequest imageRequest) {
        return p(imageRequest.o()).q(imageRequest.c()).r(imageRequest.d()).s(imageRequest.e()).t(imageRequest.f()).u(imageRequest.g()).v(imageRequest.h()).w(imageRequest.l()).x(imageRequest.k()).y(imageRequest.m());
    }

    public static ImageRequestBuilder o(int i) {
        return p(new Uri.Builder().scheme("res").path(String.valueOf(i)).build());
    }

    public static ImageRequestBuilder p(Uri uri) {
        return new ImageRequestBuilder().z(uri);
    }

    public ImageRequest a() {
        validate();
        return new ImageRequest(this);
    }

    public void b() {
        this.d = false;
    }

    public x64 d() {
        return this.f1734a;
    }

    public ImageRequest.ImageType e() {
        return this.f1730a;
    }

    public ImageRequest.RequestLevel f() {
        return this.f1731a;
    }

    @Nullable
    public Postprocessor g() {
        return this.f1732a;
    }

    public Priority h() {
        return this.f1729a;
    }

    @Nullable
    public sf7 i() {
        return this.f1733a;
    }

    public Uri j() {
        return this.f30037a;
    }

    public boolean k() {
        return this.f1735a;
    }

    public boolean l() {
        return this.d && th9.i(this.f30037a);
    }

    public boolean m() {
        return this.c;
    }

    public boolean n() {
        return this.b;
    }

    public ImageRequestBuilder q(boolean z) {
        this.f1735a = z;
        return this;
    }

    public ImageRequestBuilder r(x64 x64Var) {
        this.f1734a = x64Var;
        return this;
    }

    public ImageRequestBuilder s(ImageRequest.ImageType imageType) {
        this.f1730a = imageType;
        return this;
    }

    public ImageRequestBuilder t(boolean z) {
        this.c = z;
        return this;
    }

    public ImageRequestBuilder u(ImageRequest.RequestLevel requestLevel) {
        this.f1731a = requestLevel;
        return this;
    }

    public ImageRequestBuilder v(Postprocessor postprocessor) {
        this.f1732a = postprocessor;
        return this;
    }

    public void validate() {
        Uri uri = this.f30037a;
        if (uri == null) {
            throw new BuilderException("Source must be set!");
        }
        if (th9.h(uri)) {
            if (!this.f30037a.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.f30037a.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.f30037a.getPath().substring(1));
            } catch (NumberFormatException unused) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (th9.c(this.f30037a) && !this.f30037a.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }

    public ImageRequestBuilder w(boolean z) {
        this.b = z;
        return this;
    }

    public ImageRequestBuilder x(Priority priority) {
        this.f1729a = priority;
        return this;
    }

    public ImageRequestBuilder y(sf7 sf7Var) {
        this.f1733a = sf7Var;
        return this;
    }

    public ImageRequestBuilder z(Uri uri) {
        ax6.i(uri);
        this.f30037a = uri;
        return this;
    }
}
