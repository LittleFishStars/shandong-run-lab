package com.zj.adlib;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.a;
import com.google.android.exoplayer2.extractor.ts.c;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jg2 implements HlsExtractorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f42578a = {8, 13, 11, 2, 0, 1, 7};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17386a;

    public jg2() {
        this(0, true);
    }

    public static void b(int i, List<Integer> list) {
        if (Ints.m(f42578a, i) == -1 || list.contains(Integer.valueOf(i))) {
            return;
        }
        list.add(Integer.valueOf(i));
    }

    public static FragmentedMp4Extractor e(g89 g89Var, d dVar, @Nullable List<d> list) {
        int i = g(dVar) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new FragmentedMp4Extractor(i, g89Var, null, list);
    }

    public static TsExtractor f(int i, boolean z, d dVar, @Nullable List<d> list, g89 g89Var) {
        int i2 = i | 16;
        if (list != null) {
            i2 |= 32;
        } else {
            list = z ? Collections.singletonList(new d.b().e0("application/cea-608").E()) : Collections.emptyList();
        }
        String str = dVar.i;
        if (!TextUtils.isEmpty(str)) {
            if (!bp5.b(str, "audio/mp4a-latm")) {
                i2 |= 2;
            }
            if (!bp5.b(str, "video/avc")) {
                i2 |= 4;
            }
        }
        return new TsExtractor(2, g89Var, new DefaultTsPayloadReaderFactory(i2, list));
    }

    public static boolean g(d dVar) {
        Metadata metadata = dVar.f2567a;
        if (metadata == null) {
            return false;
        }
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) entry).variantInfos.isEmpty();
            }
        }
        return false;
    }

    public static boolean h(Extractor extractor, ExtractorInput extractorInput) throws IOException {
        try {
            return extractor.d(extractorInput);
        } catch (EOFException unused) {
            return false;
        } finally {
            extractorInput.resetPeekPosition();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e51 a(Uri uri, d dVar, @Nullable List<d> list, g89 g89Var, Map<String, List<String>> map, ExtractorInput extractorInput, at6 at6Var) throws IOException {
        int iA = FileTypes.a(dVar.k);
        int iB = FileTypes.b(map);
        int iC = FileTypes.c(uri);
        int[] iArr = f42578a;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(iA, arrayList);
        b(iB, arrayList);
        b(iC, arrayList);
        for (int i : iArr) {
            b(i, arrayList);
        }
        extractorInput.resetPeekPosition();
        Extractor extractor = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int iIntValue = ((Integer) arrayList.get(i2)).intValue();
            Extractor extractor2 = (Extractor) sb0.g(d(iIntValue, dVar, list, g89Var));
            if (h(extractor2, extractorInput)) {
                return new e51(extractor2, dVar, g89Var);
            }
            if (extractor == null && (iIntValue == iA || iIntValue == iB || iIntValue == iC || iIntValue == 11)) {
                extractor = extractor2;
            }
        }
        return new e51((Extractor) sb0.g(extractor), dVar, g89Var);
    }

    @Nullable
    @SuppressLint({"SwitchIntDef"})
    public final Extractor d(int i, d dVar, @Nullable List<d> list, g89 g89Var) {
        if (i == 0) {
            return new a();
        }
        if (i == 1) {
            return new c();
        }
        if (i == 2) {
            return new AdtsExtractor();
        }
        if (i == 7) {
            return new Mp3Extractor(0, 0L);
        }
        if (i == 8) {
            return e(g89Var, dVar, list);
        }
        if (i == 11) {
            return f(this.f17385a, this.f17386a, dVar, list, g89Var);
        }
        if (i != 13) {
            return null;
        }
        return new gv9(dVar.h, g89Var);
    }

    public jg2(int i, boolean z) {
        this.f17385a = i;
        this.f17386a = z;
    }
}
