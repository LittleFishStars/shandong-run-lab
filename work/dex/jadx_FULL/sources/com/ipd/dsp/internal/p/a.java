package com.ipd.dsp.internal.p;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.f.h;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.f.j;
import com.ipd.dsp.internal.q.q;
import com.ipd.dsp.internal.q.r;
import com.ipd.dsp.internal.q.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(api = 28)
public final class a implements ImageDecoder.OnHeaderDecodedListener {
    public static final String h = "ImageDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f38482a = z.c();
    public final int b;
    public final int c;
    public final com.ipd.dsp.internal.f.b d;
    public final q e;
    public final boolean f;
    public final j g;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.p.a$a, reason: collision with other inner class name */
    public class C0911a implements ImageDecoder.OnPartialImageListener {
        public C0911a() {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public a(int i, int i2, @NonNull i iVar) {
        this.b = i;
        this.c = i2;
        this.d = (com.ipd.dsp.internal.f.b) iVar.a(r.g);
        this.e = (q) iVar.a(q.h);
        h<Boolean> hVar = r.k;
        this.f = iVar.a(hVar) != null && Boolean.TRUE.equals(iVar.a(hVar));
        this.g = (j) iVar.a(r.h);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
        if (this.f38482a.a(this.b, this.c, this.f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == com.ipd.dsp.internal.f.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0911a());
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Dsp.isDebugLogEnable()) {
            k.e(h, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        j jVar = this.g;
        if (jVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((jVar == j.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
