package com.ipd.dsp.internal.q;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(27)
public final class v implements ImageHeaderParser {
    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        int iA = new u(inputStream).a("Orientation", 1);
        if (iA == 0) {
            return -1;
        }
        return iA;
    }

    @Override // com.ipd.dsp.internal.components.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        return a(com.ipd.dsp.internal.d0.a.d(byteBuffer), bVar);
    }
}
