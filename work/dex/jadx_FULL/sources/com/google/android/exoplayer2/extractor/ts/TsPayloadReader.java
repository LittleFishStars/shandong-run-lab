package com.google.android.exoplayer2.extractor.ts;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.zj.adlib.g89;
import com.zj.adlib.om6;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TsPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30705a = 1;
    public static final int b = 2;
    public static final int c = 4;

    public interface Factory {
        @Nullable
        TsPayloadReader a(int i, b bVar);

        SparseArray<TsPayloadReader> createInitialPayloadReaders();
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30706a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f3089a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f3090a;

        public a(String str, int i, byte[] bArr) {
            this.f3089a = str;
            this.f30706a = i;
            this.f3090a = bArr;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30707a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f3091a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<a> f3092a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f3093a;

        public b(int i, @Nullable String str, @Nullable List<a> list, byte[] bArr) {
            this.f30707a = i;
            this.f3091a = str;
            this.f3092a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f3093a = bArr;
        }
    }

    public static final class c {
        public static final int d = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30708a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f3094a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f3095b;
        public int c;

        public c(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public void a() {
            int i = this.c;
            this.c = i == Integer.MIN_VALUE ? this.f30708a : i + this.b;
            this.f3095b = this.f3094a + this.c;
        }

        public String b() {
            d();
            return this.f3095b;
        }

        public int c() {
            d();
            return this.c;
        }

        public final void d() {
            if (this.c == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public c(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + WVNativeCallbackUtil.SEPERATER;
            } else {
                str = "";
            }
            this.f3094a = str;
            this.f30708a = i2;
            this.b = i3;
            this.c = Integer.MIN_VALUE;
            this.f3095b = "";
        }
    }

    void a(om6 om6Var, int i) throws ParserException;

    void b(g89 g89Var, ExtractorOutput extractorOutput, c cVar);

    void seek();
}
