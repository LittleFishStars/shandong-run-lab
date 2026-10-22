package com.google.android.inner_exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.ParserException;
import com.google.android.inner_exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.inner_exoplayer2.util.NalUnitUtil;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;

    @Nullable
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    private HevcConfig(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str, int i4, int i5, int i6) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidthHeightRatio = f;
        this.codecs = str;
        this.colorSpace = i4;
        this.colorRange = i5;
        this.colorTransfer = i6;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.skipBytes(21);
            int unsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i = 0;
            for (int i2 = 0; i2 < unsignedByte2; i2++) {
                parsableByteArray.skipBytes(1);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                for (int i3 = 0; i3 < unsignedShort; i3++) {
                    int unsignedShort2 = parsableByteArray.readUnsignedShort();
                    i += unsignedShort2 + 4;
                    parsableByteArray.skipBytes(unsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i];
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            float f = 1.0f;
            String strBuildHevcCodecString = null;
            int i9 = 0;
            for (int i10 = 0; i10 < unsignedByte2; i10++) {
                int unsignedByte3 = parsableByteArray.readUnsignedByte() & 63;
                int i11 = 0;
                for (int unsignedShort3 = parsableByteArray.readUnsignedShort(); i11 < unsignedShort3; unsignedShort3 = unsignedShort3) {
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    int i12 = unsignedByte2;
                    System.arraycopy(bArr2, 0, bArr, i9, bArr2.length);
                    int length = i9 + bArr2.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, unsignedShort4);
                    if (unsignedByte3 == 33 && i11 == 0) {
                        NalUnitUtil.H265SpsData h265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + unsignedShort4);
                        int i13 = h265SpsNalUnit.width;
                        i5 = h265SpsNalUnit.height;
                        int i14 = h265SpsNalUnit.colorSpace;
                        int i15 = h265SpsNalUnit.colorRange;
                        int i16 = h265SpsNalUnit.colorTransfer;
                        float f2 = h265SpsNalUnit.pixelWidthHeightRatio;
                        i4 = i13;
                        i8 = i16;
                        strBuildHevcCodecString = CodecSpecificDataUtil.buildHevcCodecString(h265SpsNalUnit.generalProfileSpace, h265SpsNalUnit.generalTierFlag, h265SpsNalUnit.generalProfileIdc, h265SpsNalUnit.generalProfileCompatibilityFlags, h265SpsNalUnit.constraintBytes, h265SpsNalUnit.generalLevelIdc);
                        i7 = i15;
                        f = f2;
                        i6 = i14;
                    }
                    i9 = length + unsignedShort4;
                    parsableByteArray.skipBytes(unsignedShort4);
                    i11++;
                    unsignedByte2 = i12;
                    unsignedByte3 = unsignedByte3;
                }
            }
            return new HevcConfig(i == 0 ? Collections.emptyList() : Collections.singletonList(bArr), unsignedByte + 1, i4, i5, f, strBuildHevcCodecString, i6, i7, i8);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e);
        }
    }
}
