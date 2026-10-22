package com.google.android.inner_exoplayer2.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.ParserException;
import com.google.android.inner_exoplayer2.audio.AacUtil;
import com.google.android.inner_exoplayer2.audio.Ac3Util;
import com.google.android.inner_exoplayer2.audio.Ac4Util;
import com.google.android.inner_exoplayer2.audio.OpusUtil;
import com.google.android.inner_exoplayer2.drm.DrmInitData;
import com.google.android.inner_exoplayer2.extractor.ExtractorUtil;
import com.google.android.inner_exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.inner_exoplayer2.metadata.Metadata;
import com.google.android.inner_exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.inner_exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.inner_exoplayer2.util.Log;
import com.google.android.inner_exoplayer2.util.MimeTypes;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;
import com.google.android.inner_exoplayer2.util.Util;
import com.google.android.inner_exoplayer2.video.AvcConfig;
import com.google.android.inner_exoplayer2.video.ColorInfo;
import com.google.android.inner_exoplayer2.video.DolbyVisionConfig;
import com.google.android.inner_exoplayer2.video.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    public static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    public static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;

        @Nullable
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    public static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if ("audio/raw".equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt == 0 || unsignedIntToInt % pcmFrameSize != 0) {
                    Log.w("AtomParsers", "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    public static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            int unsignedByte = this.data.readUnsignedByte();
            this.currentByte = unsignedByte;
            return (unsignedByte & 240) >> 4;
        }
    }

    public static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private AtomParsers() {
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int i4 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i4 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += i4;
        }
        return -1;
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0165  */
    /* JADX WARN: Code duplicated, block: B:102:0x016e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0170  */
    /* JADX WARN: Code duplicated, block: B:106:0x017f  */
    /* JADX WARN: Code duplicated, block: B:110:0x019a  */
    /* JADX WARN: Code duplicated, block: B:147:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:149:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:150:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:155:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:157:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:175:0x0307 A[SYNTHETIC] */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, @Nullable DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int unsignedFixedPoint1616;
        int i6;
        int unsignedIntToInt;
        String str2;
        String str3;
        int i7;
        String str4;
        EsdsData esdsFromParent;
        String str5;
        List<byte[]> listOf;
        int i8;
        boolean z2;
        int i9;
        int iFindBoxPosition;
        String str6;
        byte[] bArr;
        int i10 = i2;
        int i11 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i10 + 16);
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            int unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            i6 = parsableByteArray.readInt();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            unsignedIntToInt = unsignedShort2;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            unsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
            i6 = 0;
        }
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733217) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i10, i11);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        if (iIntValue == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (iIntValue != 1935767394) {
                str3 = "audio/raw";
                if (iIntValue == 1819304813 || iIntValue == 1936684916) {
                    i7 = 2;
                } else if (iIntValue == 1953984371) {
                    i7 = 268435456;
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str2 = "audio/mpeg";
                } else if (iIntValue == 1835557169) {
                    str2 = "audio/mha1";
                } else if (iIntValue == 1835560241) {
                    str2 = "audio/mhm1";
                } else if (iIntValue == 1634492771) {
                    str2 = "audio/alac";
                } else if (iIntValue == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (iIntValue == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (iIntValue == 1332770163) {
                    str2 = "audio/opus";
                } else if (iIntValue == 1716281667) {
                    str2 = "audio/flac";
                } else if (iIntValue == 1835823201) {
                    str2 = "audio/true-hd";
                } else {
                    i7 = -1;
                    str3 = null;
                }
                str4 = str3;
                esdsFromParent = null;
                str5 = null;
                listOf = null;
                while (position - i10 < i11) {
                    parsableByteArray.setPosition(position);
                    i8 = parsableByteArray.readInt();
                    if (i8 > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ExtractorUtil.checkContainerInput(z2, "childAtomSize must be positive");
                    i9 = parsableByteArray.readInt();
                    if (i9 == 1835557187) {
                        int i12 = i8 - 13;
                        byte[] bArr2 = new byte[i12];
                        parsableByteArray.setPosition(position + 13);
                        parsableByteArray.readBytes(bArr2, 0, i12);
                        listOf = ImmutableList.of(bArr2);
                    } else {
                        if (i9 != 1702061171 || (z && i9 == 2002876005)) {
                            if (i9 == 1702061171) {
                                iFindBoxPosition = position;
                            } else {
                                iFindBoxPosition = findBoxPosition(parsableByteArray, 1702061171, position, i8);
                            }
                            if (iFindBoxPosition != -1) {
                                esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                                str6 = esdsFromParent.mimeType;
                                bArr = esdsFromParent.initializationData;
                                if (bArr != null) {
                                    if ("audio/mp4a-latm".equals(str6)) {
                                        AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
                                        unsignedFixedPoint1616 = audioSpecificConfig.sampleRateHz;
                                        unsignedIntToInt = audioSpecificConfig.channelCount;
                                        str5 = audioSpecificConfig.codecs;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                                str4 = str6;
                            }
                        } else if (i9 == 1684103987) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                        } else if (i9 == 1684366131) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                        } else if (i9 == 1684103988) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                        } else if (i9 == 1684892784) {
                            if (i6 <= 0) {
                                throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + i6, null);
                            }
                            unsignedFixedPoint1616 = i6;
                            unsignedIntToInt = 2;
                        } else if (i9 == 1684305011 || i9 == 1969517683) {
                            stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str4).setChannelCount(unsignedIntToInt).setSampleRate(unsignedFixedPoint1616).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                        } else if (i9 == 1682927731) {
                            int i13 = i8 - 8;
                            byte[] bArr3 = opusMagic;
                            byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i13);
                            parsableByteArray.setPosition(position + 8);
                            parsableByteArray.readBytes(bArrCopyOf, bArr3.length, i13);
                            listOf = OpusUtil.buildInitializationData(bArrCopyOf);
                        } else if (i9 == 1684425825) {
                            byte[] bArr4 = new byte[i8 - 8];
                            bArr4[0] = 102;
                            bArr4[1] = 76;
                            bArr4[2] = 97;
                            bArr4[3] = 67;
                            parsableByteArray.setPosition(position + 12);
                            parsableByteArray.readBytes(bArr4, 4, i8 - 12);
                            listOf = ImmutableList.of(bArr4);
                        } else if (i9 == 1634492771) {
                            int i14 = i8 - 12;
                            byte[] bArr5 = new byte[i14];
                            parsableByteArray.setPosition(position + 12);
                            parsableByteArray.readBytes(bArr5, 0, i14);
                            Pair<Integer, Integer> alacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr5);
                            int iIntValue2 = ((Integer) alacAudioSpecificConfig.first).intValue();
                            int iIntValue3 = ((Integer) alacAudioSpecificConfig.second).intValue();
                            listOf = ImmutableList.of(bArr5);
                            unsignedFixedPoint1616 = iIntValue2;
                            unsignedIntToInt = iIntValue3;
                        }
                        position += i8;
                        i10 = i2;
                        i11 = i3;
                    }
                    position += i8;
                    i10 = i2;
                    i11 = i3;
                }
                if (stsdData.format == null || str4 == null) {
                }
                Format.Builder language = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str5).setChannelCount(unsignedIntToInt).setSampleRate(unsignedFixedPoint1616).setPcmEncoding(i7).setInitializationData(listOf).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str);
                if (esdsFromParent != null) {
                    language.setAverageBitrate(Ints.x(esdsFromParent.bitrate)).setPeakBitrate(Ints.x(esdsFromParent.peakBitrate));
                }
                stsdData.format = language.build();
                return;
            }
            str2 = "audio/amr-wb";
        }
        str3 = str2;
        i7 = -1;
        str4 = str3;
        esdsFromParent = null;
        str5 = null;
        listOf = null;
        while (position - i10 < i11) {
            parsableByteArray.setPosition(position);
            i8 = parsableByteArray.readInt();
            if (i8 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            ExtractorUtil.checkContainerInput(z2, "childAtomSize must be positive");
            i9 = parsableByteArray.readInt();
            if (i9 == 1835557187) {
                int i15 = i8 - 13;
                byte[] bArr6 = new byte[i15];
                parsableByteArray.setPosition(position + 13);
                parsableByteArray.readBytes(bArr6, 0, i15);
                listOf = ImmutableList.of(bArr6);
            } else {
                if (i9 != 1702061171) {
                    if (i9 == 1702061171) {
                        iFindBoxPosition = position;
                    } else {
                        iFindBoxPosition = findBoxPosition(parsableByteArray, 1702061171, position, i8);
                    }
                    if (iFindBoxPosition != -1) {
                        esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                        str6 = esdsFromParent.mimeType;
                        bArr = esdsFromParent.initializationData;
                        if (bArr != null) {
                            if ("audio/mp4a-latm".equals(str6)) {
                                AacUtil.Config audioSpecificConfig2 = AacUtil.parseAudioSpecificConfig(bArr);
                                unsignedFixedPoint1616 = audioSpecificConfig2.sampleRateHz;
                                unsignedIntToInt = audioSpecificConfig2.channelCount;
                                str5 = audioSpecificConfig2.codecs;
                            }
                            listOf = ImmutableList.of(bArr);
                        }
                        str4 = str6;
                    }
                } else {
                    if (i9 == 1702061171) {
                        iFindBoxPosition = position;
                    } else {
                        iFindBoxPosition = findBoxPosition(parsableByteArray, 1702061171, position, i8);
                    }
                    if (iFindBoxPosition != -1) {
                        esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                        str6 = esdsFromParent.mimeType;
                        bArr = esdsFromParent.initializationData;
                        if (bArr != null) {
                            if ("audio/mp4a-latm".equals(str6)) {
                                AacUtil.Config audioSpecificConfig3 = AacUtil.parseAudioSpecificConfig(bArr);
                                unsignedFixedPoint1616 = audioSpecificConfig3.sampleRateHz;
                                unsignedIntToInt = audioSpecificConfig3.channelCount;
                                str5 = audioSpecificConfig3.codecs;
                            }
                            listOf = ImmutableList.of(bArr);
                        }
                        str4 = str6;
                    }
                }
                position += i8;
                i10 = i2;
                i11 = i3;
            }
            position += i8;
            i10 = i2;
            i11 = i3;
        }
        if (stsdData.format == null) {
        }
    }

    @Nullable
    public static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String string = null;
        Integer numValueOf = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == 1935894637) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == 1935894633) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!"cenc".equals(string) && !"cbc1".equals(string) && !"cens".equals(string) && !"cbcs".equals(string)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        ExtractorUtil.checkContainerInput(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.castNonNull(schiFromParent));
    }

    @Nullable
    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1701606260);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, unsignedInt2 > 0 ? unsignedInt2 : -1L, unsignedInt > 0 ? unsignedInt : -1L);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    @Nullable
    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 4 : 8);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(unsignedInt), "" + ((char) (((unsignedShort >> 10) & 31) + 96)) + ((char) (((unsignedShort >> 5) & 31) + 96)) + ((char) ((unsignedShort & 31) + 96)));
    }

    @Nullable
    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1751411826);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1801812339);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1768715124);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != 1835299937) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 < 0 || i5 >= i) {
                Log.w("AtomParsers", "Skipped metadata with unknown key index: " + i5);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String nullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (nullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(nullTerminatedString).build();
            }
        }
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    @Nullable
    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    @Nullable
    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    @Nullable
    private static Metadata parseSmta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1935766900) {
                if (i2 < 14) {
                    return null;
                }
                parsableByteArray.skipBytes(5);
                int unsignedByte = parsableByteArray.readUnsignedByte();
                if (unsignedByte != 12 && unsignedByte != 13) {
                    return null;
                }
                float f = unsignedByte == 12 ? 240.0f : 120.0f;
                parsableByteArray.skipBytes(1);
                return new Metadata(new SmtaMetadataEntry(f, parsableByteArray.readUnsignedByte()));
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:150:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:154:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:156:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:164:0x0411  */
    /* JADX WARN: Code duplicated, block: B:165:0x0413  */
    /* JADX WARN: Code duplicated, block: B:167:0x0417  */
    /* JADX WARN: Code duplicated, block: B:171:0x0432  */
    /* JADX WARN: Code duplicated, block: B:172:0x0434  */
    /* JADX WARN: Code duplicated, block: B:175:0x0439  */
    /* JADX WARN: Code duplicated, block: B:176:0x043c  */
    /* JADX WARN: Code duplicated, block: B:178:0x043f  */
    /* JADX WARN: Code duplicated, block: B:179:0x0442  */
    /* JADX WARN: Code duplicated, block: B:181:0x0445  */
    /* JADX WARN: Code duplicated, block: B:182:0x0447  */
    /* JADX WARN: Code duplicated, block: B:184:0x044b  */
    /* JADX WARN: Code duplicated, block: B:185:0x044e  */
    /* JADX WARN: Code duplicated, block: B:189:0x045d  */
    /* JADX WARN: Code duplicated, block: B:191:0x046b  */
    /* JADX WARN: Code duplicated, block: B:192:0x047b  */
    /* JADX WARN: Code duplicated, block: B:195:0x0483  */
    /* JADX WARN: Code duplicated, block: B:208:0x0428 A[EDGE_INSN: B:208:0x0428->B:169:0x0428 BREAK  A[LOOP:2: B:152:0x03c5->B:168:0x0420], SYNTHETIC] */
    private static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        Track track2;
        int i5;
        long[] jArr;
        int[] iArr;
        int i6;
        long j;
        long[] jArr2;
        int[] iArr2;
        int i7;
        int i8;
        int i9;
        int i10;
        long[] jArr3;
        boolean z3;
        int[] iArr3;
        int[] iArr4;
        long[] jArr4;
        int i11;
        int i12;
        boolean z4;
        int i13;
        long[] jArr5;
        long[] jArr6;
        int[] iArr5;
        int i14;
        boolean z5;
        boolean z6;
        long[] jArr7;
        int[] iArr6;
        int i15;
        int[] iArr7;
        long[] jArr8;
        int i16;
        int[] iArr8;
        long j2;
        int i17;
        long j3;
        int i18;
        int i19;
        int[] iArr9;
        long j4;
        boolean z7;
        boolean z8;
        int i20;
        int i21;
        int i22;
        boolean z9;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1937011578);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType, track.format);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1937013298);
            if (leafAtomOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1937007471);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1668232756));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011555))).data;
        ParsableByteArray parsableByteArray3 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011827))).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(1937011571);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(1668576371);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt4 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt6 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            unsignedIntToInt3 = parsableByteArray4.readUnsignedIntToInt();
            if (unsignedIntToInt3 > 0) {
                unsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt() - 1;
            } else {
                unsignedIntToInt2 = -1;
                parsableByteArray4 = null;
            }
        } else {
            unsignedIntToInt2 = -1;
            unsignedIntToInt3 = 0;
        }
        int fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        String str = track.format.sampleMimeType;
        if (fixedSampleSize != -1 && ("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt3 == 0) {
            int i23 = chunkIterator.length;
            long[] jArr9 = new long[i23];
            int[] iArr10 = new int[i23];
            while (chunkIterator.moveNext()) {
                int i24 = chunkIterator.index;
                jArr9[i24] = chunkIterator.offset;
                iArr10[i24] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr9, iArr10, unsignedIntToInt6);
            long[] jArr10 = resultsRechunk.offsets;
            int[] iArr11 = resultsRechunk.sizes;
            int i25 = resultsRechunk.maximumSize;
            long[] jArr11 = resultsRechunk.timestamps;
            int[] iArr12 = resultsRechunk.flags;
            long j5 = resultsRechunk.duration;
            track2 = track;
            i5 = sampleCount;
            jArr = jArr10;
            iArr = iArr11;
            i6 = i25;
            iArr2 = iArr12;
            j = j5;
            jArr2 = jArr11;
        } else {
            long[] jArrCopyOf = new long[sampleCount];
            int[] iArrCopyOf = new int[sampleCount];
            long[] jArrCopyOf2 = new long[sampleCount];
            int[] iArrCopyOf2 = new int[sampleCount];
            int unsignedIntToInt7 = unsignedIntToInt2;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int unsignedIntToInt8 = 0;
            long j6 = 0;
            long j7 = 0;
            int i30 = unsignedIntToInt;
            int i31 = unsignedIntToInt6;
            int i32 = unsignedIntToInt5;
            int i33 = unsignedIntToInt4;
            int i34 = unsignedIntToInt3;
            while (true) {
                i = i33;
                if (i26 >= sampleCount) {
                    i2 = i32;
                    i3 = i29;
                    break;
                }
                long j8 = j7;
                int i35 = i29;
                boolean zMoveNext = true;
                while (i35 == 0) {
                    zMoveNext = chunkIterator.moveNext();
                    if (!zMoveNext) {
                        break;
                    }
                    int i36 = i32;
                    long j9 = chunkIterator.offset;
                    i35 = chunkIterator.numSamples;
                    j8 = j9;
                    i32 = i36;
                    i31 = i31;
                    sampleCount = sampleCount;
                }
                int i37 = sampleCount;
                i2 = i32;
                int i38 = i31;
                if (!zMoveNext) {
                    Log.w("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i26);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i26);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i26);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i26);
                    sampleCount = i26;
                    i3 = i35;
                    break;
                }
                if (parsableByteArray5 != null) {
                    while (unsignedIntToInt8 == 0 && i30 > 0) {
                        unsignedIntToInt8 = parsableByteArray5.readUnsignedIntToInt();
                        i28 = parsableByteArray5.readInt();
                        i30--;
                    }
                    unsignedIntToInt8--;
                }
                int i39 = i28;
                jArrCopyOf[i26] = j8;
                int nextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                iArrCopyOf[i26] = nextSampleSize;
                if (nextSampleSize > i27) {
                    i27 = nextSampleSize;
                }
                jArrCopyOf2[i26] = j6 + ((long) i39);
                iArrCopyOf2[i26] = parsableByteArray4 == null ? 1 : 0;
                if (i26 == unsignedIntToInt7) {
                    iArrCopyOf2[i26] = 1;
                    i34--;
                    if (i34 > 0) {
                        unsignedIntToInt7 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                    }
                }
                int i40 = unsignedIntToInt7;
                j6 += (long) i38;
                int unsignedIntToInt9 = i2 - 1;
                if (unsignedIntToInt9 != 0 || i <= 0) {
                    i7 = i38;
                    i8 = i;
                } else {
                    unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                    i7 = parsableByteArray3.readInt();
                    i8 = i - 1;
                }
                int i41 = unsignedIntToInt9;
                long j10 = j8 + ((long) iArrCopyOf[i26]);
                i29 = i35 - 1;
                i26++;
                j7 = j10;
                unsignedIntToInt7 = i40;
                i31 = i7;
                sampleCount = i37;
                i28 = i39;
                i33 = i8;
                i32 = i41;
            }
            long j11 = j6 + ((long) i28);
            if (parsableByteArray5 == null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i30 <= 0) {
                    z2 = true;
                    break;
                }
                if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                    z2 = false;
                    break;
                }
                parsableByteArray5.readInt();
                i30--;
            }
            if (i34 == 0 && i2 == 0 && i3 == 0 && i == 0) {
                i4 = unsignedIntToInt8;
                if (i4 == 0 && z2) {
                    track2 = track;
                }
                i5 = sampleCount;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                i6 = i27;
                j = j11;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
            } else {
                i4 = unsignedIntToInt8;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistent stbl box for track ");
            track2 = track;
            sb.append(track2.id);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i34);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i2);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i3);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i4);
            sb.append(!z2 ? ", ctts invalid" : "");
            Log.w("AtomParsers", sb.toString());
            i5 = sampleCount;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            i6 = i27;
            j = j11;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
        }
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track2.timescale);
        long[] jArr12 = track2.editListDurations;
        if (jArr12 == null) {
            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
            return new TrackSampleTable(track, jArr, iArr, i6, jArr2, iArr2, jScaleLargeTimestamp);
        }
        if (jArr12.length == 1 && track2.type == 1 && jArr2.length >= 2) {
            long j12 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
            long jScaleLargeTimestamp2 = j12 + Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale);
            i9 = i5;
            if (canApplyEditWithGaplessInfo(jArr2, j, j12, jScaleLargeTimestamp2)) {
                long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(j12 - jArr2[0], track2.format.sampleRate, track2.timescale);
                i10 = i6;
                long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j - jScaleLargeTimestamp2, track2.format.sampleRate, track2.timescale);
                if ((jScaleLargeTimestamp3 != 0 || jScaleLargeTimestamp4 != 0) && jScaleLargeTimestamp3 <= 2147483647L && jScaleLargeTimestamp4 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp3;
                    gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(track, jArr, iArr, i10, jArr2, iArr2, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000L, track2.movieTimescale));
                }
            }
            jArr3 = track2.editListDurations;
            if (jArr3.length != 1 && jArr3[0] == 0) {
                long j13 = ((long[]) Assertions.checkNotNull(track2.editListMediaTimes))[0];
                for (int i42 = 0; i42 < jArr2.length; i42++) {
                    jArr2[i42] = Util.scaleLargeTimestamp(jArr2[i42] - j13, 1000000L, track2.timescale);
                }
                return new TrackSampleTable(track, jArr, iArr, i10, jArr2, iArr2, Util.scaleLargeTimestamp(j - j13, 1000000L, track2.timescale));
            }
            if (track2.type == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            iArr3 = new int[jArr3.length];
            iArr4 = new int[jArr3.length];
            jArr4 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
            i11 = 0;
            i12 = 0;
            z4 = false;
            i13 = 0;
            while (true) {
                jArr5 = track2.editListDurations;
                if (i11 < jArr5.length) {
                    break;
                }
                long[] jArr13 = jArr;
                int[] iArr13 = iArr;
                j4 = jArr4[i11];
                if (j4 != -1) {
                    long j14 = jArr5[i11];
                    boolean z10 = z4;
                    i21 = i13;
                    long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(j14, track2.timescale, track2.movieTimescale);
                    iArr3[i11] = Util.binarySearchFloor(jArr2, j4, true, true);
                    z7 = z3;
                    iArr4[i11] = Util.binarySearchCeil(jArr2, j4 + jScaleLargeTimestamp5, z7, false);
                    while (true) {
                        i22 = iArr3[i11];
                        i20 = iArr4[i11];
                        if (i22 >= i20 || (iArr2[i22] & 1) != 0) {
                            break;
                        }
                        iArr3[i11] = i22 + 1;
                    }
                    i12 += i20 - i22;
                    if (i21 != i22) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    z8 = z10 | z9;
                } else {
                    int i43 = i13;
                    z7 = z3;
                    z8 = z4;
                    i20 = i43;
                }
                i11++;
                z4 = z8;
                z3 = z7;
                jArr = jArr13;
                i13 = i20;
                iArr = iArr13;
            }
            jArr6 = jArr;
            iArr5 = iArr;
            boolean z11 = z4;
            i14 = 0;
            if (i12 != i9) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z11 | z5;
            if (z6) {
                jArr7 = new long[i12];
            } else {
                jArr7 = jArr6;
            }
            if (z6) {
                iArr6 = new int[i12];
            } else {
                iArr6 = iArr5;
            }
            if (z6) {
                i15 = 0;
            } else {
                i15 = i10;
            }
            if (z6) {
                iArr7 = new int[i12];
            } else {
                iArr7 = iArr2;
            }
            jArr8 = new long[i12];
            i16 = i15;
            iArr8 = iArr5;
            j2 = 0;
            i17 = 0;
            while (i14 < track2.editListDurations.length) {
                j3 = track2.editListMediaTimes[i14];
                i18 = iArr3[i14];
                int[] iArr14 = iArr3;
                i19 = iArr4[i14];
                int[] iArr15 = iArr4;
                if (z6) {
                    int i44 = i19 - i18;
                    System.arraycopy(jArr6, i18, jArr7, i17, i44);
                    iArr9 = iArr8;
                    System.arraycopy(iArr9, i18, iArr6, i17, i44);
                    System.arraycopy(iArr2, i18, iArr7, i17, i44);
                } else {
                    iArr9 = iArr8;
                }
                int i45 = i16;
                while (i18 < i19) {
                    int i46 = i14;
                    int[] iArr16 = iArr7;
                    long[] jArr14 = jArr2;
                    int[] iArr17 = iArr2;
                    long j15 = j2;
                    jArr8[i17] = Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(Math.max(0L, jArr2[i18] - j3), 1000000L, track2.timescale);
                    if (!z6 && iArr6[i17] > i45) {
                        i45 = iArr9[i18];
                    }
                    i17++;
                    i18++;
                    iArr2 = iArr17;
                    j2 = j15;
                    jArr2 = jArr14;
                    iArr7 = iArr16;
                    i14 = i46;
                }
                int i47 = i14;
                i16 = i45;
                j2 += track2.editListDurations[i47];
                iArr8 = iArr9;
                iArr4 = iArr15;
                jArr6 = jArr6;
                iArr7 = iArr7;
                i14 = i47 + 1;
                iArr3 = iArr14;
            }
            return new TrackSampleTable(track, jArr7, iArr6, i16, jArr8, iArr7, Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale));
        }
        i9 = i5;
        i10 = i6;
        jArr3 = track2.editListDurations;
        if (jArr3.length != 1) {
        }
        if (track2.type == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        iArr3 = new int[jArr3.length];
        iArr4 = new int[jArr3.length];
        jArr4 = (long[]) Assertions.checkNotNull(track2.editListMediaTimes);
        i11 = 0;
        i12 = 0;
        z4 = false;
        i13 = 0;
        while (true) {
            jArr5 = track2.editListDurations;
            if (i11 < jArr5.length) {
                break;
                break;
            }
            long[] jArr15 = jArr;
            int[] iArr18 = iArr;
            j4 = jArr4[i11];
            if (j4 != -1) {
                long j16 = jArr5[i11];
                boolean z12 = z4;
                i21 = i13;
                long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(j16, track2.timescale, track2.movieTimescale);
                iArr3[i11] = Util.binarySearchFloor(jArr2, j4, true, true);
                z7 = z3;
                iArr4[i11] = Util.binarySearchCeil(jArr2, j4 + jScaleLargeTimestamp6, z7, false);
                while (true) {
                    i22 = iArr3[i11];
                    i20 = iArr4[i11];
                    if (i22 >= i20) {
                        break;
                    }
                    break;
                    break;
                    iArr3[i11] = i22 + 1;
                }
                i12 += i20 - i22;
                if (i21 != i22) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z8 = z12 | z9;
            } else {
                int i48 = i13;
                z7 = z3;
                z8 = z4;
                i20 = i48;
            }
            i11++;
            z4 = z8;
            z3 = z7;
            jArr = jArr15;
            i13 = i20;
            iArr = iArr18;
        }
        jArr6 = jArr;
        iArr5 = iArr;
        boolean z13 = z4;
        i14 = 0;
        if (i12 != i9) {
            z5 = true;
        } else {
            z5 = false;
        }
        z6 = z13 | z5;
        if (z6) {
            jArr7 = new long[i12];
        } else {
            jArr7 = jArr6;
        }
        if (z6) {
            iArr6 = new int[i12];
        } else {
            iArr6 = iArr5;
        }
        if (z6) {
            i15 = 0;
        } else {
            i15 = i10;
        }
        if (z6) {
            iArr7 = new int[i12];
        } else {
            iArr7 = iArr2;
        }
        jArr8 = new long[i12];
        i16 = i15;
        iArr8 = iArr5;
        j2 = 0;
        i17 = 0;
        while (i14 < track2.editListDurations.length) {
            j3 = track2.editListMediaTimes[i14];
            i18 = iArr3[i14];
            int[] iArr19 = iArr3;
            i19 = iArr4[i14];
            int[] iArr110 = iArr4;
            if (z6) {
                int i49 = i19 - i18;
                System.arraycopy(jArr6, i18, jArr7, i17, i49);
                iArr9 = iArr8;
                System.arraycopy(iArr9, i18, iArr6, i17, i49);
                System.arraycopy(iArr2, i18, iArr7, i17, i49);
            } else {
                iArr9 = iArr8;
            }
            int i410 = i16;
            while (i18 < i19) {
                int i411 = i14;
                int[] iArr111 = iArr7;
                long[] jArr16 = jArr2;
                int[] iArr112 = iArr2;
                long j17 = j2;
                jArr8[i17] = Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(Math.max(0L, jArr2[i18] - j3), 1000000L, track2.timescale);
                if (!z6) {
                }
                i17++;
                i18++;
                iArr2 = iArr112;
                j2 = j17;
                jArr2 = jArr16;
                iArr7 = iArr111;
                i14 = i411;
            }
            int i412 = i14;
            i16 = i410;
            j2 += track2.editListDurations[i412];
            iArr8 = iArr9;
            iArr4 = iArr110;
            jArr6 = jArr6;
            iArr7 = iArr7;
            i14 = i412 + 1;
            iArr3 = iArr19;
        }
        return new TrackSampleTable(track, jArr7, iArr6, i16, jArr8, iArr7, Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, @Nullable DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        parsableByteArray.setPosition(12);
        int i4 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            int position = parsableByteArray.getPosition();
            int i6 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i6 > 0, "childAtomSize must be positive");
            int i7 = parsableByteArray.readInt();
            if (i7 == 1635148593 || i7 == 1635148595 || i7 == 1701733238 || i7 == 1831958048 || i7 == 1836070006 || i7 == 1752589105 || i7 == 1751479857 || i7 == 1932670515 || i7 == 1211250227 || i7 == 1987063864 || i7 == 1987063865 || i7 == 1635135537 || i7 == 1685479798 || i7 == 1685479729 || i7 == 1685481573 || i7 == 1685481521) {
                i3 = position;
                parseVideoSampleEntry(parsableByteArray, i7, i3, i6, i, i2, drmInitData, stsdData, i5);
            } else if (i7 == 1836069985 || i7 == 1701733217 || i7 == 1633889587 || i7 == 1700998451 || i7 == 1633889588 || i7 == 1835823201 || i7 == 1685353315 || i7 == 1685353317 || i7 == 1685353320 || i7 == 1685353324 || i7 == 1685353336 || i7 == 1935764850 || i7 == 1935767394 || i7 == 1819304813 || i7 == 1936684916 || i7 == 1953984371 || i7 == 778924082 || i7 == 778924083 || i7 == 1835557169 || i7 == 1835560241 || i7 == 1634492771 || i7 == 1634492791 || i7 == 1970037111 || i7 == 1332770163 || i7 == 1716281667) {
                i3 = position;
                parseAudioSampleEntry(parsableByteArray, i7, position, i6, i, str, z, drmInitData, stsdData, i5);
            } else {
                if (i7 == 1414810956 || i7 == 1954034535 || i7 == 2004251764 || i7 == 1937010800 || i7 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, i7, position, i6, i, str, stsdData);
                } else if (i7 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray, i7, position, i, stsdData);
                } else if (i7 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i).setSampleMimeType("application/x-camera-motion").build();
                }
                i3 = position;
            }
            parsableByteArray.setPosition(i3 + i6);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListOf = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableListOf = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else {
                if (i != 1664495672) {
                    throw new IllegalStateException();
                }
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableListOf).build();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullAtomVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullAtomVersion == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i4 >= i2) {
                parsableByteArray.skipBytes(i2);
                break;
            }
            if (parsableByteArray.getData()[position + i4] != -1) {
                long unsignedInt = fullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                if (unsignedInt == 0) {
                    break;
                }
                j = unsignedInt;
                break;
            }
            i4++;
        }
        parsableByteArray.skipBytes(16);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && i7 == -65536 && i8 == 0) {
            i3 = 90;
        } else if (i5 == 0 && i6 == -65536 && i7 == 65536 && i8 == 0) {
            i3 = 270;
        } else if (i5 == -65536 && i6 == 0 && i7 == 0 && i8 == -65536) {
            i3 = 180;
        }
        return new TkhdData(i, j, i3);
    }

    @Nullable
    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> edts;
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(1835297121));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1751411826))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1953196132))).data);
        long j2 = j == -9223372036854775807L ? tkhd.duration : j;
        long mvhd = parseMvhd(leafAtom.data);
        long jScaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, mvhd) : -9223372036854775807L;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212));
        Pair<Long, String> mdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1835296868))).data);
        Atom.LeafAtom leafAtomOfType = containerAtom3.getLeafAtomOfType(1937011556);
        if (leafAtomOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData stsd = parseStsd(leafAtomOfType.data, tkhd.id, tkhd.rotationDegrees, (String) mdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom.getContainerAtomOfType(1701082227)) == null || (edts = parseEdts(containerAtomOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        return new Track(tkhd.id, trackTypeForHdlr, ((Long) mdhd.first).longValue(), mvhd, jScaleLargeTimestamp, stsd.format, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
            if (containerAtom2.type == 1953653099 && (trackApply = function.apply(parseTrak(containerAtom2, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(trackApply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835297121))).getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Pair<Metadata, Metadata> parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata udtaMeta = null;
        Metadata smta = null;
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            int i2 = parsableByteArray.readInt();
            if (i2 == 1835365473) {
                parsableByteArray.setPosition(position);
                udtaMeta = parseUdtaMeta(parsableByteArray, position + i);
            } else if (i2 == 1936553057) {
                parsableByteArray.setPosition(position);
                smta = parseSmta(parsableByteArray, position + i);
            }
            parsableByteArray.setPosition(position + i);
        }
        return Pair.create(udtaMeta, smta);
    }

    @Nullable
    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, @Nullable DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str;
        float f;
        List<byte[]> list;
        int i7;
        int i8;
        int i9;
        String str2;
        int i10 = i2;
        int i11 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i10 + 16);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i10, i11);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str3 = "video/3gpp";
        if (iIntValue == 1831958048) {
            str = "video/mpeg";
        } else {
            str = iIntValue == 1211250227 ? "video/3gpp" : null;
        }
        float paspFromParent = 1.0f;
        String str4 = null;
        List<byte[]> listOf = null;
        byte[] projFromParent = null;
        int i12 = -1;
        int iIsoColorPrimariesToColorSpace = -1;
        int i13 = -1;
        int iIsoTransferCharacteristicsToColorTransfer = -1;
        ByteBuffer byteBuffer = null;
        EsdsData esdsFromParent = null;
        boolean z = false;
        while (position - i10 < i11) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i14 = parsableByteArray.readInt();
            if (i14 == 0 && parsableByteArray.getPosition() - i10 == i11) {
                break;
            }
            ExtractorUtil.checkContainerInput(i14 > 0, "childAtomSize must be positive");
            int i15 = parsableByteArray.readInt();
            if (i15 == 1635148611) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                listOf = avcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                str4 = avcConfig.codecs;
                str2 = "video/avc";
            } else {
                if (i15 == 1752589123) {
                    ExtractorUtil.checkContainerInput(str == null, null);
                    parsableByteArray.setPosition(position2 + 8);
                    HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                    listOf = hevcConfig.initializationData;
                    stsdData2.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                    if (!z) {
                        paspFromParent = hevcConfig.pixelWidthHeightRatio;
                    }
                    str4 = hevcConfig.codecs;
                    int i16 = hevcConfig.colorSpace;
                    int i17 = hevcConfig.colorRange;
                    iIsoTransferCharacteristicsToColorTransfer = hevcConfig.colorTransfer;
                    iIsoColorPrimariesToColorSpace = i16;
                    i13 = i17;
                    str = "video/hevc";
                } else {
                    if (i15 == 1685480259 || i15 == 1685485123) {
                        drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                        unsignedShort2 = unsignedShort2;
                        iIntValue = iIntValue;
                        f = paspFromParent;
                        list = listOf;
                        i7 = iIsoColorPrimariesToColorSpace;
                        i8 = i13;
                        i9 = iIsoTransferCharacteristicsToColorTransfer;
                        DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(parsableByteArray);
                        if (dolbyVisionConfig != null) {
                            str4 = dolbyVisionConfig.codecs;
                            str = "video/dolby-vision";
                        }
                    } else if (i15 == 1987076931) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        str2 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        parsableByteArray.setPosition(position2 + 12);
                        parsableByteArray.skipBytes(2);
                        boolean z2 = (parsableByteArray.readUnsignedByte() & 1) != 0;
                        int unsignedByte = parsableByteArray.readUnsignedByte();
                        int unsignedByte2 = parsableByteArray.readUnsignedByte();
                        iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte);
                        i13 = z2 ? 1 : 2;
                        iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte2);
                    } else {
                        if (i15 == 1635135811) {
                            ExtractorUtil.checkContainerInput(str == null, null);
                            str2 = "video/av01";
                        } else if (i15 == 1668050025) {
                            ByteBuffer byteBufferAllocateHdrStaticInfo = byteBuffer == null ? allocateHdrStaticInfo() : byteBuffer;
                            byteBufferAllocateHdrStaticInfo.position(21);
                            byteBufferAllocateHdrStaticInfo.putShort(parsableByteArray.readShort());
                            byteBufferAllocateHdrStaticInfo.putShort(parsableByteArray.readShort());
                            byteBuffer = byteBufferAllocateHdrStaticInfo;
                        } else if (i15 == 1835295606) {
                            ByteBuffer byteBufferAllocateHdrStaticInfo2 = byteBuffer == null ? allocateHdrStaticInfo() : byteBuffer;
                            short s = parsableByteArray.readShort();
                            short s2 = parsableByteArray.readShort();
                            short s3 = parsableByteArray.readShort();
                            short s4 = parsableByteArray.readShort();
                            short s5 = parsableByteArray.readShort();
                            short s6 = parsableByteArray.readShort();
                            List<byte[]> list2 = listOf;
                            short s7 = parsableByteArray.readShort();
                            float f2 = paspFromParent;
                            short s8 = parsableByteArray.readShort();
                            long unsignedInt = parsableByteArray.readUnsignedInt();
                            long unsignedInt2 = parsableByteArray.readUnsignedInt();
                            byteBufferAllocateHdrStaticInfo2.position(1);
                            byteBufferAllocateHdrStaticInfo2.putShort(s5);
                            byteBufferAllocateHdrStaticInfo2.putShort(s6);
                            byteBufferAllocateHdrStaticInfo2.putShort(s);
                            byteBufferAllocateHdrStaticInfo2.putShort(s2);
                            byteBufferAllocateHdrStaticInfo2.putShort(s3);
                            byteBufferAllocateHdrStaticInfo2.putShort(s4);
                            byteBufferAllocateHdrStaticInfo2.putShort(s7);
                            byteBufferAllocateHdrStaticInfo2.putShort(s8);
                            byteBufferAllocateHdrStaticInfo2.putShort((short) (unsignedInt / 10000));
                            byteBufferAllocateHdrStaticInfo2.putShort((short) (unsignedInt2 / 10000));
                            byteBuffer = byteBufferAllocateHdrStaticInfo2;
                            listOf = list2;
                            paspFromParent = f2;
                        } else {
                            drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                            unsignedShort2 = unsignedShort2;
                            iIntValue = iIntValue;
                            f = paspFromParent;
                            list = listOf;
                            if (i15 == 1681012275) {
                                ExtractorUtil.checkContainerInput(str == null, null);
                                str = str3;
                            } else if (i15 == 1702061171) {
                                ExtractorUtil.checkContainerInput(str == null, null);
                                esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                                String str5 = esdsFromParent.mimeType;
                                byte[] bArr = esdsFromParent.initializationData;
                                listOf = bArr != null ? ImmutableList.of(bArr) : list;
                                str = str5;
                                paspFromParent = f;
                            } else if (i15 == 1885434736) {
                                paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                                listOf = list;
                                z = true;
                            } else if (i15 == 1937126244) {
                                projFromParent = parseProjFromParent(parsableByteArray, position2, i14);
                            } else if (i15 == 1936995172) {
                                int unsignedByte3 = parsableByteArray.readUnsignedByte();
                                parsableByteArray.skipBytes(3);
                                if (unsignedByte3 == 0) {
                                    int unsignedByte4 = parsableByteArray.readUnsignedByte();
                                    if (unsignedByte4 == 0) {
                                        listOf = list;
                                        paspFromParent = f;
                                        i12 = 0;
                                    } else if (unsignedByte4 == 1) {
                                        i12 = 1;
                                    } else if (unsignedByte4 == 2) {
                                        i12 = 2;
                                    } else if (unsignedByte4 == 3) {
                                        i12 = 3;
                                    }
                                }
                                i7 = iIsoColorPrimariesToColorSpace;
                                i8 = i13;
                                i9 = iIsoTransferCharacteristicsToColorTransfer;
                            } else {
                                if (i15 == 1668246642) {
                                    i7 = iIsoColorPrimariesToColorSpace;
                                    i8 = i13;
                                    if (i7 == -1) {
                                        i9 = iIsoTransferCharacteristicsToColorTransfer;
                                        if (i8 == -1 && i9 == -1) {
                                            int i18 = parsableByteArray.readInt();
                                            if (i18 == 1852009592 || i18 == 1852009571) {
                                                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                                int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                                parsableByteArray.skipBytes(2);
                                                boolean z3 = i14 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                                iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                                i13 = z3 ? 1 : 2;
                                                iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                                            } else {
                                                Log.w("AtomParsers", "Unsupported color type: " + Atom.getAtomTypeString(i18));
                                            }
                                        }
                                    }
                                } else {
                                    i7 = iIsoColorPrimariesToColorSpace;
                                    i8 = i13;
                                }
                                i9 = iIsoTransferCharacteristicsToColorTransfer;
                            }
                            listOf = list;
                            paspFromParent = f;
                        }
                        position += i14;
                        i10 = i2;
                        i11 = i3;
                        stsdData2 = stsdData;
                        str3 = str3;
                        iIntValue = iIntValue;
                        drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                        unsignedShort2 = unsignedShort2;
                    }
                    i13 = i8;
                    iIsoTransferCharacteristicsToColorTransfer = i9;
                    iIsoColorPrimariesToColorSpace = i7;
                    listOf = list;
                    paspFromParent = f;
                    position += i14;
                    i10 = i2;
                    i11 = i3;
                    stsdData2 = stsdData;
                    str3 = str3;
                    iIntValue = iIntValue;
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    unsignedShort2 = unsignedShort2;
                }
                position += i14;
                i10 = i2;
                i11 = i3;
                stsdData2 = stsdData;
                str3 = str3;
                iIntValue = iIntValue;
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                unsignedShort2 = unsignedShort2;
            }
            str = str2;
            position += i14;
            i10 = i2;
            i11 = i3;
            stsdData2 = stsdData;
            str3 = str3;
            iIntValue = iIntValue;
            drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
            unsignedShort2 = unsignedShort2;
        }
        DrmInitData drmInitData2 = drmInitDataCopyWithSchemeType;
        int i19 = unsignedShort2;
        float f3 = paspFromParent;
        List<byte[]> list3 = listOf;
        int i20 = iIsoColorPrimariesToColorSpace;
        int i21 = i13;
        int i22 = iIsoTransferCharacteristicsToColorTransfer;
        if (str == null) {
            return;
        }
        Format.Builder drmInitData3 = new Format.Builder().setId(i4).setSampleMimeType(str).setCodecs(str4).setWidth(unsignedShort).setHeight(i19).setPixelWidthHeightRatio(f3).setRotationDegrees(i5).setProjectionData(projFromParent).setStereoMode(i12).setInitializationData(list3).setDrmInitData(drmInitData2);
        if (i20 != -1 || i21 != -1 || i22 != -1 || byteBuffer != null) {
            drmInitData3.setColorInfo(new ColorInfo(i20, i21, i22, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (esdsFromParent != null) {
            drmInitData3.setAverageBitrate(Ints.x(esdsFromParent.bitrate)).setPeakBitrate(Ints.x(esdsFromParent.peakBitrate));
        }
        stsdData.format = drmInitData3.build();
    }
}
