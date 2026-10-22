package com.ipd.dsp.internal.g;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j extends b<InputStream> {
    public j(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.ipd.dsp.internal.g.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStream a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    @Override // com.ipd.dsp.internal.g.b
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
