package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.video.spherical.a;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MP3TrackImpl extends AbstractTrack {
    private static final int ES_OBJECT_TYPE_INDICATION = 107;
    private static final int ES_STREAM_TYPE = 5;
    private static final int MPEG_L3 = 1;
    private static final int MPEG_V1 = 3;
    private static final int SAMPLES_PER_FRAME = 1152;
    long avgBitRate;
    private final DataSource dataSource;
    private long[] durations;
    MP3Header firstHeader;
    long maxBitRate;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    TrackMetaData trackMetaData;
    private static final int[] SAMPLE_RATE = {i.K, 48000, a.h, 0};
    private static final int[] BIT_RATE = {0, a.h, 40000, 48000, 56000, 64000, 80000, 96000, 112000, a.i, 160000, 192000, 224000, 256000, 320000, 0};

    public class MP3Header {
        int bitRate;
        int bitRateIndex;
        int channelCount;
        int channelMode;
        int layer;
        int mpegVersion;
        int padding;
        int protectionAbsent;
        int sampleFrequencyIndex;
        int sampleRate;

        public MP3Header() {
        }

        public int getFrameLength() {
            return ((this.bitRate * 144) / this.sampleRate) + this.padding;
        }
    }

    public MP3TrackImpl(DataSource dataSource) throws IOException {
        this(dataSource, "eng");
    }

    private MP3Header readMP3Header(DataSource dataSource) throws IOException {
        MP3Header mP3Header = new MP3Header();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        while (byteBufferAllocate.position() < 4) {
            if (dataSource.read(byteBufferAllocate) == -1) {
                return null;
            }
        }
        if (byteBufferAllocate.get(0) == 84 && byteBufferAllocate.get(1) == 65 && byteBufferAllocate.get(2) == 71) {
            return null;
        }
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) byteBufferAllocate.rewind());
        if (bitReaderBuffer.readBits(11) != 2047) {
            throw new IOException("Expected Start Word 0x7ff");
        }
        int bits = bitReaderBuffer.readBits(2);
        mP3Header.mpegVersion = bits;
        if (bits != 3) {
            throw new IOException("Expected MPEG Version 1 (ISO/IEC 11172-3)");
        }
        int bits2 = bitReaderBuffer.readBits(2);
        mP3Header.layer = bits2;
        if (bits2 != 1) {
            throw new IOException("Expected Layer III");
        }
        mP3Header.protectionAbsent = bitReaderBuffer.readBits(1);
        int bits3 = bitReaderBuffer.readBits(4);
        mP3Header.bitRateIndex = bits3;
        int i = BIT_RATE[bits3];
        mP3Header.bitRate = i;
        if (i == 0) {
            throw new IOException("Unexpected (free/bad) bit rate");
        }
        int bits4 = bitReaderBuffer.readBits(2);
        mP3Header.sampleFrequencyIndex = bits4;
        int i2 = SAMPLE_RATE[bits4];
        mP3Header.sampleRate = i2;
        if (i2 == 0) {
            throw new IOException("Unexpected (reserved) sample rate frequency");
        }
        mP3Header.padding = bitReaderBuffer.readBits(1);
        bitReaderBuffer.readBits(1);
        int bits5 = bitReaderBuffer.readBits(2);
        mP3Header.channelMode = bits5;
        mP3Header.channelCount = bits5 == 3 ? 1 : 2;
        return mP3Header;
    }

    private MP3Header readSamples(DataSource dataSource) throws IOException {
        MP3Header mP3Header = null;
        while (true) {
            long jPosition = dataSource.position();
            MP3Header mP3Header2 = readMP3Header(dataSource);
            if (mP3Header2 == null) {
                return mP3Header;
            }
            if (mP3Header == null) {
                mP3Header = mP3Header2;
            }
            dataSource.position(jPosition);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(mP3Header2.getFrameLength());
            dataSource.read(byteBufferAllocate);
            byteBufferAllocate.rewind();
            this.samples.add(new SampleImpl(byteBufferAllocate));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dataSource.close();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "soun";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.durations;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public String toString() {
        return "MP3TrackImpl";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public MP3TrackImpl(DataSource dataSource, String str) throws IOException {
        super(dataSource.toString());
        this.trackMetaData = new TrackMetaData();
        this.dataSource = dataSource;
        this.samples = new LinkedList();
        MP3Header samples = readSamples(dataSource);
        this.firstHeader = samples;
        double d = ((double) samples.sampleRate) / 1152.0d;
        double size = ((double) this.samples.size()) / d;
        LinkedList linkedList = new LinkedList();
        Iterator<Sample> it = this.samples.iterator();
        long j = 0;
        while (true) {
            int iIntValue = 0;
            if (!it.hasNext()) {
                this.avgBitRate = (int) ((j * 8) / size);
                this.sampleDescriptionBox = new SampleDescriptionBox();
                AudioSampleEntry audioSampleEntry = new AudioSampleEntry("mp4a");
                audioSampleEntry.setChannelCount(this.firstHeader.channelCount);
                audioSampleEntry.setSampleRate(this.firstHeader.sampleRate);
                audioSampleEntry.setDataReferenceIndex(1);
                audioSampleEntry.setSampleSize(16);
                ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
                ESDescriptor eSDescriptor = new ESDescriptor();
                eSDescriptor.setEsId(0);
                SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
                sLConfigDescriptor.setPredefined(2);
                eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
                DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
                decoderConfigDescriptor.setObjectTypeIndication(107);
                decoderConfigDescriptor.setStreamType(5);
                decoderConfigDescriptor.setMaxBitRate(this.maxBitRate);
                decoderConfigDescriptor.setAvgBitRate(this.avgBitRate);
                eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
                eSDescriptorBox.setData(eSDescriptor.serialize());
                audioSampleEntry.addBox(eSDescriptorBox);
                this.sampleDescriptionBox.addBox(audioSampleEntry);
                this.trackMetaData.setCreationTime(new Date());
                this.trackMetaData.setModificationTime(new Date());
                this.trackMetaData.setLanguage(str);
                this.trackMetaData.setVolume(1.0f);
                this.trackMetaData.setTimescale(this.firstHeader.sampleRate);
                long[] jArr = new long[this.samples.size()];
                this.durations = jArr;
                Arrays.fill(jArr, 1152L);
                return;
            }
            int size2 = (int) it.next().getSize();
            j += (long) size2;
            linkedList.add(Integer.valueOf(size2));
            while (linkedList.size() > d) {
                linkedList.pop();
            }
            if (linkedList.size() == ((int) d)) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    iIntValue += ((Integer) it2.next()).intValue();
                }
                double size3 = ((((double) iIntValue) * 8.0d) / ((double) linkedList.size())) * d;
                if (size3 > this.maxBitRate) {
                    this.maxBitRate = (int) size3;
                }
            }
        }
    }
}
