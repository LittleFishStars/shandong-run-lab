package com.google.android.inner_exoplayer2.metadata.dvbsi;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.metadata.Metadata;
import com.google.android.inner_exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.inner_exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.inner_exoplayer2.util.ParsableBitArray;
import com.google.common.base.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class AppInfoTableDecoder extends SimpleMetadataDecoder {
    public static final int APPLICATION_INFORMATION_TABLE_ID = 116;
    private static final int DESCRIPTOR_SIMPLE_APPLICATION_LOCATION = 21;
    private static final int DESCRIPTOR_TRANSPORT_PROTOCOL = 2;
    private static final int TRANSPORT_PROTOCOL_HTTP = 3;

    @Nullable
    private static Metadata parseAit(ParsableBitArray parsableBitArray) {
        parsableBitArray.skipBits(12);
        int bytePosition = (parsableBitArray.getBytePosition() + parsableBitArray.readBits(12)) - 4;
        parsableBitArray.skipBits(44);
        parsableBitArray.skipBytes(parsableBitArray.readBits(12));
        parsableBitArray.skipBits(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String bytesAsString = null;
            if (parsableBitArray.getBytePosition() >= bytePosition) {
                break;
            }
            parsableBitArray.skipBits(48);
            int bits = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(4);
            int bytePosition2 = parsableBitArray.getBytePosition() + parsableBitArray.readBits(12);
            String bytesAsString2 = null;
            while (parsableBitArray.getBytePosition() < bytePosition2) {
                int bits2 = parsableBitArray.readBits(8);
                int bits3 = parsableBitArray.readBits(8);
                int bytePosition3 = parsableBitArray.getBytePosition() + bits3;
                if (bits2 == 2) {
                    int bits4 = parsableBitArray.readBits(16);
                    parsableBitArray.skipBits(8);
                    if (bits4 == 3) {
                        while (parsableBitArray.getBytePosition() < bytePosition3) {
                            bytesAsString = parsableBitArray.readBytesAsString(parsableBitArray.readBits(8), b.f31594a);
                            int bits5 = parsableBitArray.readBits(8);
                            for (int i = 0; i < bits5; i++) {
                                parsableBitArray.skipBytes(parsableBitArray.readBits(8));
                            }
                        }
                    }
                } else if (bits2 == 21) {
                    bytesAsString2 = parsableBitArray.readBytesAsString(bits3, b.f31594a);
                }
                parsableBitArray.setPosition(bytePosition3 * 8);
            }
            parsableBitArray.setPosition(bytePosition2 * 8);
            if (bytesAsString != null && bytesAsString2 != null) {
                arrayList.add(new AppInfoTable(bits, bytesAsString + bytesAsString2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // com.google.android.inner_exoplayer2.metadata.SimpleMetadataDecoder
    @Nullable
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return parseAit(new ParsableBitArray(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
