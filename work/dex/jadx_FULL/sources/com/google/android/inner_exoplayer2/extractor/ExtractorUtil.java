package com.google.android.inner_exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.ParserException;
import java.io.EOFException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ExtractorUtil {
    private ExtractorUtil() {
    }

    @Pure
    public static void checkContainerInput(boolean z, @Nullable String str) throws ParserException {
        if (!z) {
            throw ParserException.createForMalformedContainer(str, null);
        }
    }

    public static boolean peekFullyQuietly(ExtractorInput extractorInput, byte[] bArr, int i, int i2, boolean z) throws EOFException {
        try {
            return extractorInput.peekFully(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static int peekToLength(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int iPeek = extractorInput.peek(bArr, i + i3, i2 - i3);
            if (iPeek == -1) {
                break;
            }
            i3 += iPeek;
        }
        return i3;
    }

    public static boolean readFullyQuietly(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        try {
            extractorInput.readFully(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean skipFullyQuietly(ExtractorInput extractorInput, int i) {
        try {
            extractorInput.skipFully(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
