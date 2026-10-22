package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u54 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om6 f45066a = new om6(10);

    @Nullable
    public Metadata a(ExtractorInput extractorInput, @Nullable Id3Decoder.FramePredicate framePredicate) throws IOException {
        Metadata metadataD = null;
        int i = 0;
        while (true) {
            try {
                extractorInput.peekFully(this.f45066a.d(), 0, 10);
                this.f45066a.S(0);
                if (this.f45066a.J() != 4801587) {
                    break;
                }
                this.f45066a.T(3);
                int iF = this.f45066a.F();
                int i2 = iF + 10;
                if (metadataD == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f45066a.d(), 0, bArr, 0, 10);
                    extractorInput.peekFully(bArr, 10, iF);
                    metadataD = new Id3Decoder(framePredicate).d(bArr, i2);
                } else {
                    extractorInput.advancePeekPosition(iF);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i);
        return metadataD;
    }
}
