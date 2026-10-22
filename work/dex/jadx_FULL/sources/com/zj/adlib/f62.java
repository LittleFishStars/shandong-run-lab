package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.b;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.a;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f62 {
    public static DataSpec a(Representation representation, ka7 ka7Var, int i) {
        return b(representation, representation.f3984a.get(0).f20281a, ka7Var, i);
    }

    public static DataSpec b(Representation representation, String str, ka7 ka7Var, int i) {
        return new DataSpec.b().j(ka7Var.b(str)).i(ka7Var.f17627a).h(ka7Var.b).g(n(representation, ka7Var)).c(i).a();
    }

    @Nullable
    public static Representation c(eo6 eo6Var, int i) {
        int iA = eo6Var.a(i);
        if (iA == -1) {
            return null;
        }
        List<Representation> list = eo6Var.f16370a.get(iA).f20347a;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static b d(DataSource dataSource, int i, Representation representation) throws IOException {
        return e(dataSource, i, representation, 0);
    }

    @Nullable
    public static b e(DataSource dataSource, int i, Representation representation, int i2) throws IOException {
        if (representation.m() == null) {
            return null;
        }
        ChunkExtractor chunkExtractorM = m(i, representation.f3983a);
        try {
            g(chunkExtractorM, dataSource, representation, i2, true);
            return chunkExtractorM.f();
        } finally {
            chunkExtractorM.release();
        }
    }

    @Nullable
    public static d f(DataSource dataSource, eo6 eo6Var) throws IOException {
        int i = 2;
        Representation representationC = c(eo6Var, 2);
        if (representationC == null) {
            i = 1;
            representationC = c(eo6Var, 1);
            if (representationC == null) {
                return null;
            }
        }
        d dVar = representationC.f3983a;
        d dVarK = k(dataSource, i, representationC);
        return dVarK == null ? dVar : dVarK.A(dVar);
    }

    public static void g(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, int i, boolean z) throws IOException {
        ka7 ka7Var = (ka7) sb0.g(representation.m());
        if (z) {
            ka7 ka7VarL = representation.l();
            if (ka7VarL == null) {
                return;
            }
            ka7 ka7VarA = ka7Var.a(ka7VarL, representation.f3984a.get(i).f20281a);
            if (ka7VarA == null) {
                i(dataSource, representation, i, chunkExtractor, ka7Var);
                ka7Var = ka7VarL;
            } else {
                ka7Var = ka7VarA;
            }
        }
        i(dataSource, representation, i, chunkExtractor, ka7Var);
    }

    public static void h(ChunkExtractor chunkExtractor, DataSource dataSource, Representation representation, boolean z) throws IOException {
        g(chunkExtractor, dataSource, representation, 0, z);
    }

    public static void i(DataSource dataSource, Representation representation, int i, ChunkExtractor chunkExtractor, ka7 ka7Var) throws IOException {
        new com.google.android.exoplayer2.source.chunk.d(dataSource, b(representation, representation.f3984a.get(i).f20281a, ka7Var, 0), representation.f3983a, 0, null, chunkExtractor).load();
    }

    public static c62 j(DataSource dataSource, Uri uri) throws IOException {
        return (c62) ParsingLoadable.e(dataSource, new a(), uri, 4);
    }

    @Nullable
    public static d k(DataSource dataSource, int i, Representation representation) throws IOException {
        return l(dataSource, i, representation, 0);
    }

    @Nullable
    public static d l(DataSource dataSource, int i, Representation representation, int i2) throws IOException {
        if (representation.m() == null) {
            return null;
        }
        ChunkExtractor chunkExtractorM = m(i, representation.f3983a);
        try {
            g(chunkExtractorM, dataSource, representation, i2, false);
            return ((d[]) sb0.k(chunkExtractorM.e()))[0];
        } finally {
            chunkExtractorM.release();
        }
    }

    public static ChunkExtractor m(int i, d dVar) {
        String str = dVar.j;
        return new com.google.android.exoplayer2.source.chunk.b(str != null && (str.startsWith("video/webm") || str.startsWith("audio/webm")) ? new MatroskaExtractor() : new FragmentedMp4Extractor(), i, dVar);
    }

    public static String n(Representation representation, ka7 ka7Var) {
        String strJ = representation.j();
        return strJ != null ? strJ : ka7Var.b(representation.f3984a.get(0).f20281a).toString();
    }
}
