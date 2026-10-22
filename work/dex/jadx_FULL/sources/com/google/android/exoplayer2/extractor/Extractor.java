package com.google.android.exoplayer2.extractor;

import com.zj.adlib.iv6;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30620a = 0;
    public static final int b = 1;
    public static final int c = -1;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReadResult {
    }

    void b(ExtractorOutput extractorOutput);

    int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException;

    boolean d(ExtractorInput extractorInput) throws IOException;

    void release();

    void seek(long j, long j2);
}
