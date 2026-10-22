package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ExtractorsFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f30622a = new ExtractorsFactory() { // from class: com.zj.adlib.hc3
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] d() {
            return ExtractorsFactory.c();
        }
    };

    static /* synthetic */ Extractor[] c() {
        return new Extractor[0];
    }

    default Extractor[] a(Uri uri, Map<String, List<String>> map) {
        return d();
    }

    Extractor[] d();
}
