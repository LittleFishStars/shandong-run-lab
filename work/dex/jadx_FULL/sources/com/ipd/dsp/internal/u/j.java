package com.ipd.dsp.internal.u;

import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import com.ipd.dsp.internal.f.k;
import com.ipd.dsp.internal.i.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j implements k<InputStream, c> {
    public static final String d = "StreamGifDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f38552a;
    public final k<ByteBuffer, c> b;
    public final com.ipd.dsp.internal.j.b c;

    public j(List<ImageHeaderParser> list, k<ByteBuffer, c> kVar, com.ipd.dsp.internal.j.b bVar) {
        this.f38552a = list;
        this.b = kVar;
        this.c = bVar;
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return !((Boolean) iVar.a(i.b)).booleanValue() && com.ipd.dsp.internal.components.glide.load.a.b(this.f38552a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.ipd.dsp.internal.f.k
    public v<c> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        byte[] bArrA = a(inputStream);
        if (bArrA == null) {
            return null;
        }
        return this.b.a(ByteBuffer.wrap(bArrA), i, i2, iVar);
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (!Dsp.isDebugLogEnable()) {
                return null;
            }
            com.ipd.dsp.internal.c2.k.e(d, "Error reading data from stream", e);
            return null;
        }
    }
}
