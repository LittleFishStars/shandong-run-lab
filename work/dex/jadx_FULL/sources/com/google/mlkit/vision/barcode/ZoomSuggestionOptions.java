package com.google.mlkit.vision.barcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zj.adlib.dbc;
import com.zj.adlib.i76;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ZoomSuggestionOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f32466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ZoomCallback f6668a;

    public interface ZoomCallback {
        boolean a(float f);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f32467a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ZoomCallback f6669a;

        public a(@NonNull ZoomCallback zoomCallback) {
            this.f6669a = zoomCallback;
        }

        @NonNull
        public ZoomSuggestionOptions a() {
            return new ZoomSuggestionOptions(this.f6669a, this.f32467a, null);
        }

        @NonNull
        public a b(float f) {
            this.f32467a = f;
            return this;
        }
    }

    public /* synthetic */ ZoomSuggestionOptions(ZoomCallback zoomCallback, float f, dbc dbcVar) {
        this.f6668a = zoomCallback;
        this.f32466a = f;
    }

    public final float a() {
        return this.f32466a;
    }

    @NonNull
    public final ZoomCallback b() {
        return this.f6668a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoomSuggestionOptions)) {
            return false;
        }
        ZoomSuggestionOptions zoomSuggestionOptions = (ZoomSuggestionOptions) obj;
        return i76.b(this.f6668a, zoomSuggestionOptions.f6668a) && this.f32466a == zoomSuggestionOptions.f32466a;
    }

    public int hashCode() {
        return i76.c(this.f6668a, Float.valueOf(this.f32466a));
    }
}
