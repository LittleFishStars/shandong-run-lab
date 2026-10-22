package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.MultiFileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderSpecificInfo;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Mp4Arrays;
import com.googlecode.mp4parser.util.Path;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class H263TrackImpl extends AbstractH26XTrack {
    private static Logger LOG = Logger.getLogger(ESDescriptor.class.getName());
    int BINARY;
    int BINARY_ONLY;
    int GRAYSCALE;
    int RECTANGULAR;
    boolean esdsComplete;
    List<ByteBuffer> esdsStuff;
    int fixed_vop_time_increment;
    List<Sample> samples;
    SampleDescriptionBox stsd;
    int vop_time_increment_resolution;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.googlecode.mp4parser.authoring.tracks.AbstractH26XTrack, com.googlecode.mp4parser.authoring.tracks.H263TrackImpl] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v14, types: [int] */
    public H263TrackImpl(DataSource dataSource) throws IOException {
        int i;
        char c;
        super(dataSource, false);
        char c2 = 0;
        this.RECTANGULAR = 0;
        int i2 = 1;
        this.BINARY = 1;
        int i3 = 2;
        this.BINARY_ONLY = 2;
        this.GRAYSCALE = 3;
        this.samples = new ArrayList();
        this.esdsStuff = new ArrayList();
        this.esdsComplete = false;
        this.fixed_vop_time_increment = -1;
        this.vop_time_increment_resolution = 0;
        AbstractH26XTrack.LookAhead lookAhead = new AbstractH26XTrack.LookAhead(dataSource);
        ArrayList arrayList = new ArrayList();
        VisualSampleEntry visualSampleEntry = new VisualSampleEntry(VisualSampleEntry.TYPE1);
        SampleDescriptionBox sampleDescriptionBox = new SampleDescriptionBox();
        this.stsd = sampleDescriptionBox;
        sampleDescriptionBox.addBox(visualSampleEntry);
        long j = 0;
        int i4 = 0;
        long j2 = -1;
        while (true) {
            ByteBuffer byteBufferFindNextNal = findNextNal(lookAhead);
            if (byteBufferFindNextNal == null) {
                long[] jArr = this.decodingTimes;
                long[] jArr2 = new long[i2];
                jArr2[c2] = jArr[jArr.length - i2];
                this.decodingTimes = Mp4Arrays.copyOfAndAppend(jArr, jArr2);
                ESDescriptor eSDescriptor = new ESDescriptor();
                eSDescriptor.setEsId(i2);
                DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
                decoderConfigDescriptor.setObjectTypeIndication(32);
                decoderConfigDescriptor.setStreamType(4);
                DecoderSpecificInfo decoderSpecificInfo = new DecoderSpecificInfo();
                Sample sampleCreateSampleObject = createSampleObject(this.esdsStuff);
                byte[] bArr = new byte[CastUtils.l2i(sampleCreateSampleObject.getSize())];
                sampleCreateSampleObject.asByteBuffer().get(bArr);
                decoderSpecificInfo.setData(bArr);
                decoderConfigDescriptor.setDecoderSpecificInfo(decoderSpecificInfo);
                eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
                SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
                sLConfigDescriptor.setPredefined(i3);
                eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
                ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
                eSDescriptorBox.setEsDescriptor(eSDescriptor);
                visualSampleEntry.addBox(eSDescriptorBox);
                this.trackMetaData.setTimescale(this.vop_time_increment_resolution);
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBufferFindNextNal.duplicate();
            int uInt8 = IsoTypeReader.readUInt8(byteBufferFindNextNal);
            if (uInt8 == 176 || uInt8 == 181 || uInt8 == 0 || uInt8 == 32 || uInt8 == 178) {
                int i5 = i4;
                if (this.esdsComplete) {
                    i = i5;
                } else {
                    this.esdsStuff.add(byteBufferDuplicate);
                    if (uInt8 == 32) {
                        i = i5;
                        parse0x20Unit(byteBufferFindNextNal, i, visualSampleEntry);
                    } else {
                        i = i5;
                        if (uInt8 == 181) {
                            i = parse0x05Unit(byteBufferFindNextNal);
                        }
                    }
                }
                i2 = 1;
                i3 = 2;
                i4 = i;
                c2 = 0;
            } else {
                if (uInt8 == 179) {
                    this.esdsComplete = i2;
                    int bits = new BitReaderBuffer(byteBufferFindNextNal).readBits(18);
                    j = (bits & 63) + (((bits >>> 7) & 63) * 60) + (((bits >>> 13) & 31) * 60 * 60);
                    this.stss.add(Integer.valueOf((int) (this.samples.size() + i2)));
                    arrayList.add(byteBufferDuplicate);
                    c2 = 0;
                    i2 = i2;
                } else {
                    if (uInt8 != 182) {
                        throw new RuntimeException("Got start code I don't know. Ask Sebastian via mp4parser mailing list what to do");
                    }
                    BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBufferFindNextNal);
                    bitReaderBuffer.readBits(2);
                    ?? r3 = i2;
                    while (bitReaderBuffer.readBool()) {
                        j++;
                        i4 = i4;
                        r3 = 1;
                    }
                    bitReaderBuffer.readBool();
                    int i6 = 0;
                    int i7 = r3;
                    while (this.vop_time_increment_resolution >= (i7 << i6)) {
                        i6++;
                        i4 = i4;
                        i7 = 1;
                    }
                    int bits2 = bitReaderBuffer.readBits(i6);
                    int i8 = this.vop_time_increment_resolution;
                    int i9 = i4;
                    long j3 = (((long) i8) * j) + ((long) (bits2 % i8));
                    if (j2 != -1) {
                        long[] jArr3 = this.decodingTimes;
                        long[] jArr4 = new long[i7];
                        c = 0;
                        jArr4[0] = j3 - j2;
                        this.decodingTimes = Mp4Arrays.copyOfAndAppend(jArr3, jArr4);
                    } else {
                        c = 0;
                    }
                    System.err.println("Frame increment: " + (j3 - j2) + " vop time increment: " + bits2 + " last_sync_point: " + j + " time_code: " + j3);
                    arrayList.add(byteBufferDuplicate);
                    this.samples.add(createSampleObject(arrayList));
                    arrayList.clear();
                    c2 = c;
                    j2 = j3;
                    i4 = i9;
                    i2 = 1;
                }
                i3 = 2;
            }
        }
    }

    public static void main(String[] strArr) throws IOException {
        FileDataSourceImpl fileDataSourceImpl = new FileDataSourceImpl("C:\\content\\bbb.h263");
        Movie movie = new Movie();
        movie.addTrack(new H263TrackImpl(fileDataSourceImpl));
        new DefaultMp4Builder().build(movie).writeContainer(Channels.newChannel(new FileOutputStream("output.mp4")));
    }

    public static void main1(String[] strArr) throws IOException {
        File[] fileArrListFiles = new File("C:\\dev\\mp4parser\\frames").listFiles();
        Arrays.sort(fileArrListFiles);
        Movie movie = new Movie();
        movie.addTrack(new H263TrackImpl(new MultiFileDataSourceImpl(fileArrListFiles)));
        new DefaultMp4Builder().build(movie).writeContainer(Channels.newChannel(new FileOutputStream("output.mp4")));
    }

    public static void main2(String[] strArr) throws IOException {
        ESDescriptorBox eSDescriptorBox = (ESDescriptorBox) Path.getPath(new IsoFile("C:\\content\\bbb.mp4"), "/moov[0]/trak[0]/mdia[0]/minf[0]/stbl[0]/stsd[0]/mp4v[0]/esds[0]");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        eSDescriptorBox.getBox(Channels.newChannel(byteArrayOutputStream));
        System.err.println(Hex.encodeHex(byteArrayOutputStream.toByteArray()));
        System.err.println(eSDescriptorBox.getEsDescriptor());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        eSDescriptorBox.getBox(Channels.newChannel(byteArrayOutputStream2));
        System.err.println(Hex.encodeHex(byteArrayOutputStream2.toByteArray()));
    }

    private int parse0x05Unit(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        if (!bitReaderBuffer.readBool()) {
            return 0;
        }
        int bits = bitReaderBuffer.readBits(4);
        bitReaderBuffer.readBits(3);
        return bits;
    }

    private void parse0x20Unit(ByteBuffer byteBuffer, int i, VisualSampleEntry visualSampleEntry) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        bitReaderBuffer.readBool();
        bitReaderBuffer.readBits(8);
        if (bitReaderBuffer.readBool()) {
            i = bitReaderBuffer.readBits(4);
            bitReaderBuffer.readBits(3);
        }
        if (bitReaderBuffer.readBits(4) == 15) {
            bitReaderBuffer.readBits(8);
            bitReaderBuffer.readBits(8);
        }
        if (bitReaderBuffer.readBool()) {
            bitReaderBuffer.readBits(2);
            bitReaderBuffer.readBool();
            if (bitReaderBuffer.readBool()) {
                throw new RuntimeException("Implemented when needed");
            }
        }
        int bits = bitReaderBuffer.readBits(2);
        if (bits == this.GRAYSCALE && i != 1) {
            bitReaderBuffer.readBits(4);
        }
        bitReaderBuffer.readBool();
        this.vop_time_increment_resolution = bitReaderBuffer.readBits(16);
        bitReaderBuffer.readBool();
        if (bitReaderBuffer.readBool()) {
            LOG.info("Fixed Frame Rate");
            int i2 = 0;
            while (this.vop_time_increment_resolution >= (1 << i2)) {
                i2++;
            }
            this.fixed_vop_time_increment = bitReaderBuffer.readBits(i2);
        }
        if (bits == this.BINARY_ONLY) {
            throw new RuntimeException("Please implmenet me");
        }
        if (bits == this.RECTANGULAR) {
            bitReaderBuffer.readBool();
            visualSampleEntry.setWidth(bitReaderBuffer.readBits(13));
            bitReaderBuffer.readBool();
            visualSampleEntry.setHeight(bitReaderBuffer.readBits(13));
            bitReaderBuffer.readBool();
        }
    }

    @Override // com.googlecode.mp4parser.authoring.tracks.AbstractH26XTrack
    public Sample createSampleObject(List<? extends ByteBuffer> list) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[]{0, 0, 1});
        ByteBuffer[] byteBufferArr = new ByteBuffer[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = byteBufferWrap;
            byteBufferArr[i2 + 1] = list.get(i);
        }
        return new SampleImpl(byteBufferArr);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "vide";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.stsd;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }
}
