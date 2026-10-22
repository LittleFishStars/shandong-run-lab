package com.googlecode.mp4parser.authoring.tracks;

import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.text.cea.a;
import com.google.common.primitives.UnsignedBytes;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.zj.adlib.hs5;
import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DTSTrackImpl extends AbstractTrack {
    private static final int BUFFER = 67108864;
    int bcCoreBitRate;
    int bcCoreChannelMask;
    int bcCoreMaxSampleRate;
    int bitrate;
    int channelCount;
    int channelMask;
    int codecDelayAtMaxFs;
    int coreBitRate;
    int coreChannelMask;
    int coreFramePayloadInBytes;
    int coreMaxSampleRate;
    boolean coreSubStreamPresent;
    private int dataOffset;
    private DataSource dataSource;
    DTSSpecificBox ddts;
    int extAvgBitrate;
    int extFramePayloadInBytes;
    int extPeakBitrate;
    int extSmoothBuffSize;
    boolean extensionSubStreamPresent;
    int frameSize;
    boolean isVBR;
    private String lang;
    int lbrCodingPresent;
    int lsbTrimPercent;
    int maxSampleRate;
    int numExtSubStreams;
    int numFramesTotal;
    int numSamplesOrigAudioAtMaxFs;
    SampleDescriptionBox sampleDescriptionBox;
    private long[] sampleDurations;
    int sampleSize;
    int samplerate;
    private List<Sample> samples;
    int samplesPerFrame;
    int samplesPerFrameAtMaxFs;
    TrackMetaData trackMetaData;
    String type;

    public class LookAhead {
        ByteBuffer buffer;
        long bufferStartPos;
        private final int corePresent;
        long dataEnd;
        DataSource dataSource;
        int inBufferPos = 0;
        long start;

        public LookAhead(DataSource dataSource, long j, long j2, int i) throws IOException {
            this.dataSource = dataSource;
            this.bufferStartPos = j;
            this.dataEnd = j2 + j;
            this.corePresent = i;
            fillBuffer();
        }

        private void discardByte() {
            this.inBufferPos++;
        }

        private void discardNext4AndMarkStart() {
            long j = this.bufferStartPos;
            int i = this.inBufferPos;
            this.start = j + ((long) i);
            this.inBufferPos = i + 4;
        }

        private void discardQWord() {
            this.inBufferPos += 4;
        }

        private void fillBuffer() throws IOException {
            System.err.println("Fill Buffer");
            DataSource dataSource = this.dataSource;
            long j = this.bufferStartPos;
            this.buffer = dataSource.map(j, Math.min(this.dataEnd - j, 67108864L));
        }

        private ByteBuffer getSample() {
            long j = this.start;
            long j2 = this.bufferStartPos;
            if (j < j2) {
                throw new RuntimeException("damn! NAL exceeds buffer");
            }
            this.buffer.position((int) (j - j2));
            ByteBuffer byteBufferSlice = this.buffer.slice();
            byteBufferSlice.limit((int) (((long) this.inBufferPos) - (this.start - this.bufferStartPos)));
            return byteBufferSlice;
        }

        private boolean nextFourEquals(byte b, byte b2, byte b3, byte b4) throws IOException {
            int iLimit = this.buffer.limit();
            int i = this.inBufferPos;
            if (iLimit - i >= 4) {
                return this.buffer.get(i) == b && this.buffer.get(this.inBufferPos + 1) == b2 && this.buffer.get(this.inBufferPos + 2) == b3 && this.buffer.get(this.inBufferPos + 3) == b4;
            }
            if (this.bufferStartPos + ((long) i) + 4 < this.dataSource.size()) {
                return false;
            }
            throw new EOFException();
        }

        private boolean nextFourEquals0x64582025() throws IOException {
            return nextFourEquals((byte) 100, (byte) 88, (byte) 32, a.g);
        }

        private boolean nextFourEquals0x64582025orEof() throws IOException {
            return nextFourEqualsOrEof((byte) 100, (byte) 88, (byte) 32, a.g);
        }

        private boolean nextFourEquals0x7FFE8001() throws IOException {
            return nextFourEquals((byte) 127, (byte) -2, UnsignedBytes.f32243a, (byte) 1);
        }

        private boolean nextFourEquals0x7FFE8001orEof() throws IOException {
            return nextFourEqualsOrEof((byte) 127, (byte) -2, UnsignedBytes.f32243a, (byte) 1);
        }

        private boolean nextFourEqualsOrEof(byte b, byte b2, byte b3, byte b4) throws IOException {
            int iLimit = this.buffer.limit();
            int i = this.inBufferPos;
            if (iLimit - i >= 4) {
                if ((this.bufferStartPos + ((long) i)) % 1048576 == 0) {
                    PrintStream printStream = System.err;
                    StringBuilder sb = new StringBuilder();
                    sb.append(((this.bufferStartPos + ((long) this.inBufferPos)) / 1024) / 1024);
                    printStream.println(sb.toString());
                }
                return this.buffer.get(this.inBufferPos) == b && this.buffer.get(this.inBufferPos + 1) == b2 && this.buffer.get(this.inBufferPos + 2) == b3 && this.buffer.get(this.inBufferPos + 3) == b4;
            }
            long j = this.bufferStartPos;
            long j2 = ((long) i) + j + 4;
            long j3 = this.dataEnd;
            if (j2 > j3) {
                return j + ((long) i) == j3;
            }
            this.bufferStartPos = this.start;
            this.inBufferPos = 0;
            fillBuffer();
            return nextFourEquals0x7FFE8001();
        }

        public ByteBuffer findNextStart() throws IOException {
            while (true) {
                try {
                    if (this.corePresent == 1) {
                        if (nextFourEquals0x7FFE8001()) {
                            break;
                        }
                        discardByte();
                    } else {
                        if (nextFourEquals0x64582025()) {
                            break;
                        }
                        discardByte();
                    }
                } catch (EOFException unused) {
                    return null;
                }
            }
            discardNext4AndMarkStart();
            while (true) {
                if (this.corePresent == 1) {
                    if (nextFourEquals0x7FFE8001orEof()) {
                        break;
                    }
                    discardQWord();
                } else {
                    if (nextFourEquals0x64582025orEof()) {
                        break;
                    }
                    discardQWord();
                }
            }
            return getSample();
        }
    }

    public DTSTrackImpl(DataSource dataSource, String str) throws IOException {
        super(dataSource.toString());
        this.trackMetaData = new TrackMetaData();
        this.frameSize = 0;
        this.dataOffset = 0;
        this.ddts = new DTSSpecificBox();
        this.isVBR = false;
        this.coreSubStreamPresent = false;
        this.extensionSubStreamPresent = false;
        this.numExtSubStreams = 0;
        this.coreMaxSampleRate = 0;
        this.coreBitRate = 0;
        this.coreChannelMask = 0;
        this.coreFramePayloadInBytes = 0;
        this.extAvgBitrate = 0;
        this.extPeakBitrate = 0;
        this.extSmoothBuffSize = 0;
        this.extFramePayloadInBytes = 0;
        this.maxSampleRate = 0;
        this.lbrCodingPresent = 0;
        this.numFramesTotal = 0;
        this.samplesPerFrameAtMaxFs = 0;
        this.numSamplesOrigAudioAtMaxFs = 0;
        this.channelMask = 0;
        this.codecDelayAtMaxFs = 0;
        this.bcCoreMaxSampleRate = 0;
        this.bcCoreBitRate = 0;
        this.bcCoreChannelMask = 0;
        this.lsbTrimPercent = 0;
        this.type = "none";
        this.lang = str;
        this.dataSource = dataSource;
        parse();
    }

    private List<Sample> generateSamples(DataSource dataSource, int i, long j, int i2) throws IOException {
        LookAhead lookAhead = new LookAhead(dataSource, i, j, i2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            final ByteBuffer byteBufferFindNextStart = lookAhead.findNextStart();
            if (byteBufferFindNextStart == null) {
                System.err.println("all samples found");
                return arrayList;
            }
            arrayList.add(new Sample() { // from class: com.googlecode.mp4parser.authoring.tracks.DTSTrackImpl.1
                @Override // com.googlecode.mp4parser.authoring.Sample
                public ByteBuffer asByteBuffer() {
                    return byteBufferFindNextStart;
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public long getSize() {
                    return byteBufferFindNextStart.rewind().remaining();
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                    writableByteChannel.write((ByteBuffer) byteBufferFindNextStart.rewind());
                }
            });
        }
    }

    private int getBitRate(int i) throws IOException {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 56;
            case 2:
                return 64;
            case 3:
                return 96;
            case 4:
                return 112;
            case 5:
                return 128;
            case 6:
                return 192;
            case 7:
                return 224;
            case 8:
                return 256;
            case 9:
                return 320;
            case 10:
                return 384;
            case 11:
                return 448;
            case 12:
                return 512;
            case 13:
                return hs5.f;
            case 14:
                return 640;
            case 15:
                return 768;
            case 16:
                return 960;
            case 17:
                return 1024;
            case 18:
                return 1152;
            case 19:
                return 1280;
            case 20:
                return 1344;
            case 21:
                return SecExceptionCode.SEC_ERROR_SECURITYBODY_TOP_ERROR;
            case 22:
                return SecExceptionCode.SEC_ERROR_SECURITYBODY_DATA_FILE_MISMATCH;
            case 23:
                return 1472;
            case 24:
                return 1536;
            case 25:
                return -1;
            default:
                throw new IOException("Unknown bitrate value");
        }
    }

    private int getSampleRate(int i) throws IOException {
        switch (i) {
            case 1:
                return 8000;
            case 2:
                return 16000;
            case 3:
                return com.google.android.exoplayer2.video.spherical.a.h;
            case 4:
            case 5:
            case 9:
            case 10:
            default:
                throw new IOException("Unknown Sample Rate");
            case 6:
                return 11025;
            case 7:
                return 22050;
            case 8:
                return i.K;
            case 11:
                return WifiManagerBridgeExtension.ERROR_12000;
            case 12:
                return 24000;
            case 13:
                return 48000;
        }
    }

    private void parse() throws IOException {
        if (!readVariables()) {
            throw new IOException();
        }
        this.sampleDescriptionBox = new SampleDescriptionBox();
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(this.type);
        audioSampleEntry.setChannelCount(this.channelCount);
        audioSampleEntry.setSampleRate(this.samplerate);
        audioSampleEntry.setDataReferenceIndex(1);
        audioSampleEntry.setSampleSize(16);
        audioSampleEntry.addBox(this.ddts);
        this.sampleDescriptionBox.addBox(audioSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(this.lang);
        this.trackMetaData.setTimescale(this.samplerate);
    }

    private boolean parseAuprhdr(int i, ByteBuffer byteBuffer) {
        int i2;
        byteBuffer.get();
        short s = byteBuffer.getShort();
        this.maxSampleRate = (byteBuffer.get() << com.google.common.base.a.r) | (byteBuffer.getShort() & 65535);
        this.numFramesTotal = byteBuffer.getInt();
        this.samplesPerFrameAtMaxFs = byteBuffer.getShort();
        this.numSamplesOrigAudioAtMaxFs = (byteBuffer.get() << 32) | (byteBuffer.getInt() & 65535);
        this.channelMask = byteBuffer.getShort();
        this.codecDelayAtMaxFs = byteBuffer.getShort();
        if ((s & 3) == 3) {
            this.bcCoreMaxSampleRate = (byteBuffer.get() << com.google.common.base.a.r) | (byteBuffer.getShort() & 65535);
            this.bcCoreBitRate = byteBuffer.getShort();
            this.bcCoreChannelMask = byteBuffer.getShort();
            i2 = 28;
        } else {
            i2 = 21;
        }
        if ((s & 4) > 0) {
            this.lsbTrimPercent = byteBuffer.get();
            i2++;
        }
        if ((s & 8) > 0) {
            this.lbrCodingPresent = 1;
        }
        while (i2 < i) {
            byteBuffer.get();
            i2++;
        }
        return true;
    }

    private boolean parseCoressmd(int i, ByteBuffer byteBuffer) {
        this.coreMaxSampleRate = (byteBuffer.get() << com.google.common.base.a.r) | (byteBuffer.getShort() & 65535);
        this.coreBitRate = byteBuffer.getShort();
        this.coreChannelMask = byteBuffer.getShort();
        this.coreFramePayloadInBytes = byteBuffer.getInt();
        for (int i2 = 11; i2 < i; i2++) {
            byteBuffer.get();
        }
        return true;
    }

    private void parseDtshdhdr(int i, ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        byteBuffer.get();
        byteBuffer.getInt();
        byteBuffer.get();
        short s = byteBuffer.getShort();
        byteBuffer.get();
        byte b = byteBuffer.get();
        this.numExtSubStreams = b;
        if ((s & 1) == 1) {
            this.isVBR = true;
        }
        if ((s & 8) == 8) {
            this.coreSubStreamPresent = true;
        }
        if ((s & 16) == 16) {
            this.extensionSubStreamPresent = true;
            this.numExtSubStreams = b + 1;
        } else {
            this.numExtSubStreams = 0;
        }
        for (int i2 = 14; i2 < i; i2++) {
            byteBuffer.get();
        }
    }

    private boolean parseExtssmd(int i, ByteBuffer byteBuffer) {
        int i2;
        this.extAvgBitrate = (byteBuffer.get() << com.google.common.base.a.r) | (byteBuffer.getShort() & 65535);
        if (this.isVBR) {
            this.extPeakBitrate = (byteBuffer.get() << com.google.common.base.a.r) | (byteBuffer.getShort() & 65535);
            this.extSmoothBuffSize = byteBuffer.getShort();
            i2 = 8;
        } else {
            this.extFramePayloadInBytes = byteBuffer.getInt();
            i2 = 7;
        }
        while (i2 < i) {
            byteBuffer.get();
            i2++;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:305:0x044c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c9  */
    private boolean readVariables() throws IOException {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        ByteBuffer map = this.dataSource.map(0L, 25000L);
        int i4 = map.getInt();
        int i5 = map.getInt();
        if (i4 != 1146377032 || i5 != 1145586770) {
            throw new IOException("data does not start with 'DTSHDHDR' as required for a DTS-HD file");
        }
        while (true) {
            if ((i4 == 1398035021 && i5 == 1145132097) || map.remaining() <= 100) {
                break;
            }
            int i6 = (int) map.getLong();
            if (i4 == 1146377032 && i5 == 1145586770) {
                parseDtshdhdr(i6, map);
            } else if (i4 == 1129271877 && i5 == 1397968196) {
                if (!parseCoressmd(i6, map)) {
                    return false;
                }
            } else {
                if (i4 == 1096110162 && i5 == 759710802) {
                    if (!parseAuprhdr(i6, map)) {
                        return false;
                    }
                } else if (i4 == 1163416659 && i5 == 1398754628) {
                    if (!parseExtssmd(i6, map)) {
                        return false;
                    }
                } else {
                    for (int i7 = 0; i7 < i6; i7++) {
                        map.get();
                    }
                }
            }
            i4 = map.getInt();
            i5 = map.getInt();
        }
        long j = map.getLong();
        this.dataOffset = map.position();
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        byte b = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i11 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int bits = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (!z4) {
            boolean z12 = z10;
            boolean z13 = z11;
            int iPosition = map.position();
            int i12 = map.getInt();
            boolean z14 = z4;
            if (i12 != 2147385345) {
                long j2 = j;
                int i13 = 20;
                if (i12 != 1683496997) {
                    throw new IOException("No DTS_SYNCWORD_* found at " + map.position());
                }
                if (i9 == -1) {
                    this.samplesPerFrame = this.samplesPerFrameAtMaxFs;
                    i9 = 0;
                }
                BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(map);
                int i14 = 8;
                bitReaderBuffer.readBits(8);
                bitReaderBuffer.readBits(2);
                b = 1;
                if (bitReaderBuffer.readBits(1) == 0) {
                    i13 = 16;
                } else {
                    i14 = 12;
                }
                int bits2 = bitReaderBuffer.readBits(i14) + 1;
                int bits3 = bitReaderBuffer.readBits(i13) + 1;
                map.position(iPosition + bits2);
                int i15 = map.getInt();
                if (i15 == 1515870810) {
                    if (z6) {
                        z14 = true;
                    }
                    z6 = true;
                } else {
                    if (i15 == 1191201283) {
                        if (z9) {
                            z14 = true;
                        }
                        z9 = true;
                    } else if (i15 == 496366178) {
                        if (z12) {
                            z14 = true;
                        }
                        z10 = true;
                        z3 = z13;
                    } else if (i15 == 1700671838) {
                        if (z13) {
                            z14 = true;
                        }
                        z10 = z12;
                        z3 = true;
                    } else {
                        z3 = z13;
                        if (i15 == 176167201) {
                            if (z7) {
                                z14 = true;
                            }
                            z10 = z12;
                            z7 = true;
                        } else if (i15 == 1101174087) {
                            if (z5) {
                                z14 = true;
                            }
                            z10 = z12;
                            z5 = true;
                        } else if (i15 == 45126241) {
                            if (z8) {
                                z14 = true;
                            }
                            z10 = z12;
                            z8 = true;
                        } else {
                            z10 = z12;
                        }
                    }
                    if (!z14) {
                        this.frameSize += bits3;
                    }
                    map.position(iPosition + bits3);
                    z11 = z3;
                    z4 = z14;
                    j = j2;
                }
                z10 = z12;
                z3 = z13;
                if (!z14) {
                    this.frameSize += bits3;
                }
                map.position(iPosition + bits3);
                z11 = z3;
                z4 = z14;
                j = j2;
            } else if (i9 == 1) {
                z4 = true;
                z10 = z12;
                z11 = z13;
            } else {
                BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(map);
                int bits4 = bitReaderBuffer2.readBits(1);
                int bits5 = bitReaderBuffer2.readBits(5);
                int bits6 = bitReaderBuffer2.readBits(1);
                if (bits4 != 1 || bits5 != 31 || bits6 != 0) {
                    return false;
                }
                this.samplesPerFrame = (bitReaderBuffer2.readBits(7) + 1) * 32;
                int bits7 = bitReaderBuffer2.readBits(14);
                this.frameSize += bits7 + 1;
                int bits8 = bitReaderBuffer2.readBits(6);
                this.samplerate = getSampleRate(bitReaderBuffer2.readBits(4));
                this.bitrate = getBitRate(bitReaderBuffer2.readBits(5));
                if (bitReaderBuffer2.readBits(1) != 0) {
                    return false;
                }
                bitReaderBuffer2.readBits(1);
                bitReaderBuffer2.readBits(1);
                bitReaderBuffer2.readBits(1);
                bitReaderBuffer2.readBits(1);
                bits = bitReaderBuffer2.readBits(3);
                int bits9 = bitReaderBuffer2.readBits(1);
                bitReaderBuffer2.readBits(1);
                long j3 = j;
                bitReaderBuffer2.readBits(2);
                bitReaderBuffer2.readBits(1);
                if (bits6 == 1) {
                    bitReaderBuffer2.readBits(16);
                }
                bitReaderBuffer2.readBits(1);
                int bits10 = bitReaderBuffer2.readBits(4);
                bitReaderBuffer2.readBits(2);
                int bits11 = bitReaderBuffer2.readBits(3);
                if (bits11 == 0 || bits11 == 1) {
                    this.sampleSize = 16;
                } else if (bits11 == 2 || bits11 == 3) {
                    this.sampleSize = 20;
                } else {
                    if (bits11 != 5 && bits11 != 6) {
                        return false;
                    }
                    this.sampleSize = 24;
                }
                bitReaderBuffer2.readBits(1);
                bitReaderBuffer2.readBits(1);
                if (bits10 == 6 || bits10 != 7) {
                    bitReaderBuffer2.readBits(4);
                } else {
                    bitReaderBuffer2.readBits(4);
                }
                map.position(iPosition + bits7 + 1);
                z10 = z12;
                z11 = z13;
                z4 = z14;
                j = j3;
                i8 = -1;
                i9 = 1;
                i11 = bits9;
                i10 = bits8;
            }
            i8 = -1;
        }
        int i16 = this.samplesPerFrame;
        if (i16 == 512) {
            i = 0;
        } else if (i16 == 1024) {
            i = 1;
        } else if (i16 != 2048) {
            i = i16 != 4096 ? i8 : 3;
        } else {
            i = 2;
        }
        if (i == i8) {
            return false;
        }
        if (i10 != 0 && i10 != 2) {
            switch (i10) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    i10 = 31;
                    break;
            }
        }
        if (i9 == 0) {
            if (z5) {
                if (z8) {
                    this.type = AudioSampleEntry.TYPE12;
                    i2 = 21;
                } else {
                    this.type = AudioSampleEntry.TYPE11;
                    i2 = 17;
                }
            } else if (z7) {
                this.type = AudioSampleEntry.TYPE13;
                i2 = 18;
            } else if (z8) {
                this.type = AudioSampleEntry.TYPE12;
                if (!z9 && !z5) {
                    i2 = 19;
                } else if (z9 && !z5) {
                    i2 = 20;
                } else if (z9 || !z5) {
                    i2 = 0;
                } else {
                    i2 = 21;
                }
            } else {
                i2 = 0;
            }
            this.samplerate = this.maxSampleRate;
            this.sampleSize = 24;
        } else if (b >= 1) {
            int i17 = bits;
            this.type = AudioSampleEntry.TYPE12;
            if (i11 == 0) {
                if (z8 || !z9) {
                    z = z10;
                    z2 = z11;
                } else {
                    z = z10;
                    z2 = z11;
                    if (!z && !z2 && !z5 && !z7) {
                        i2 = 5;
                    }
                }
                if (!z8 && !z9 && !z && z2 && !z5 && !z7) {
                    i2 = 6;
                } else if (!z8 && z9 && !z && z2 && !z5 && !z7) {
                    i2 = 9;
                } else if (!z8 && !z9 && z && !z2 && !z5 && !z7) {
                    i2 = 10;
                } else if (!z8 && z9 && z && !z2 && !z5 && !z7) {
                    i2 = 13;
                } else if (z8 || z9 || z || z2 || !z5 || z7) {
                    i2 = 0;
                } else {
                    i2 = 14;
                }
            } else {
                boolean z15 = z10;
                boolean z16 = z11;
                if (i17 == 0 && !z8 && !z9 && !z15 && z16 && !z5 && !z7) {
                    i2 = 7;
                } else if (i17 == 6 && !z8 && !z9 && !z15 && z16 && !z5 && !z7) {
                    i2 = 8;
                } else if (i17 == 0 && !z8 && !z9 && z15 && !z16 && !z5 && !z7) {
                    i2 = 11;
                } else if (i17 == 6 && !z8 && !z9 && z15 && !z16 && !z5 && !z7) {
                    i2 = 12;
                } else if (i17 == 0 && !z8 && !z9 && !z15 && !z16 && z5 && !z7) {
                    i2 = 15;
                } else if (i17 != 2 || z8 || z9 || z15 || z16 || !z5 || z7) {
                    i2 = 0;
                } else {
                    i2 = 16;
                }
            }
        } else if (i11 > 0) {
            int i18 = bits;
            if (i18 == 0) {
                this.type = "dtsc";
                i2 = 2;
            } else if (i18 == 2) {
                this.type = "dtsc";
                i2 = 4;
            } else if (i18 != 6) {
                this.type = AudioSampleEntry.TYPE12;
                i2 = 0;
            } else {
                this.type = AudioSampleEntry.TYPE12;
                i2 = 3;
            }
        } else {
            this.type = "dtsc";
            i2 = 1;
        }
        this.ddts.setDTSSamplingFrequency(this.maxSampleRate);
        if (this.isVBR) {
            this.ddts.setMaxBitRate((this.coreBitRate + this.extPeakBitrate) * 1000);
        } else {
            this.ddts.setMaxBitRate((this.coreBitRate + this.extAvgBitrate) * 1000);
        }
        this.ddts.setAvgBitRate((this.coreBitRate + this.extAvgBitrate) * 1000);
        this.ddts.setPcmSampleDepth(this.sampleSize);
        this.ddts.setFrameDuration(i);
        this.ddts.setStreamConstruction(i2);
        int i19 = this.coreChannelMask;
        if ((i19 & 8) > 0 || (i19 & 4096) > 0) {
            this.ddts.setCoreLFEPresent(1);
        } else {
            this.ddts.setCoreLFEPresent(0);
        }
        this.ddts.setCoreLayout(i10);
        this.ddts.setCoreSize(this.coreFramePayloadInBytes);
        this.ddts.setStereoDownmix(0);
        this.ddts.setRepresentationType(4);
        this.ddts.setChannelLayout(this.channelMask);
        if (this.coreMaxSampleRate <= 0 || this.extAvgBitrate <= 0) {
            i3 = 0;
            this.ddts.setMultiAssetFlag(0);
        } else {
            this.ddts.setMultiAssetFlag(1);
            i3 = 0;
        }
        this.ddts.setLBRDurationMod(this.lbrCodingPresent);
        this.ddts.setReservedBoxPresent(i3);
        this.channelCount = i3;
        for (int i20 = 0; i20 < 16; i20++) {
            if (((this.channelMask >> i20) & 1) == 1) {
                if (i20 == 0 || i20 == 12 || i20 == 14 || i20 == 3 || i20 == 4 || i20 == 7 || i20 == 8) {
                    this.channelCount++;
                } else {
                    this.channelCount += 2;
                }
            }
        }
        List<Sample> listGenerateSamples = generateSamples(this.dataSource, this.dataOffset, j, i9);
        this.samples = listGenerateSamples;
        long[] jArr = new long[listGenerateSamples.size()];
        this.sampleDurations = jArr;
        Arrays.fill(jArr, this.samplesPerFrame);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dataSource.close();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "soun";
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.sampleDurations;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public DTSTrackImpl(DataSource dataSource) throws IOException {
        super(dataSource.toString());
        this.trackMetaData = new TrackMetaData();
        this.frameSize = 0;
        this.dataOffset = 0;
        this.ddts = new DTSSpecificBox();
        this.isVBR = false;
        this.coreSubStreamPresent = false;
        this.extensionSubStreamPresent = false;
        this.numExtSubStreams = 0;
        this.coreMaxSampleRate = 0;
        this.coreBitRate = 0;
        this.coreChannelMask = 0;
        this.coreFramePayloadInBytes = 0;
        this.extAvgBitrate = 0;
        this.extPeakBitrate = 0;
        this.extSmoothBuffSize = 0;
        this.extFramePayloadInBytes = 0;
        this.maxSampleRate = 0;
        this.lbrCodingPresent = 0;
        this.numFramesTotal = 0;
        this.samplesPerFrameAtMaxFs = 0;
        this.numSamplesOrigAudioAtMaxFs = 0;
        this.channelMask = 0;
        this.codecDelayAtMaxFs = 0;
        this.bcCoreMaxSampleRate = 0;
        this.bcCoreBitRate = 0;
        this.bcCoreChannelMask = 0;
        this.lsbTrimPercent = 0;
        this.type = "none";
        this.lang = "eng";
        this.dataSource = dataSource;
        parse();
    }
}
