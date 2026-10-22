package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequence;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DecodedResult {
    public Bitmap mBitmap;
    public FrameSequence mFrameSequence;

    public int getByteSize() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getRowBytes() * this.mBitmap.getHeight();
        }
        return 0;
    }

    public boolean isDecoded() {
        Bitmap bitmap = this.mBitmap;
        return (bitmap != null && !bitmap.isRecycled()) || (this.mFrameSequence != null);
    }
}
