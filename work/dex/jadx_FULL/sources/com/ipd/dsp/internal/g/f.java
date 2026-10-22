package com.ipd.dsp.internal.g;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f extends b<AssetFileDescriptor> {
    public f(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.ipd.dsp.internal.g.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str);
    }

    @Override // com.ipd.dsp.internal.g.b
    public void a(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }
}
