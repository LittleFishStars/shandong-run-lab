package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.ChunkOffsetBox;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack;
import com.googlecode.mp4parser.util.Path;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import com.mp4parser.iso23001.part7.TrackEncryptionBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CencMp4TrackImplImpl extends Mp4TrackImpl implements CencEncryptedTrack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private UUID defaultKeyId;
    private List<CencSampleAuxiliaryDataFormat> sampleEncryptionEntries;

    public class FindSaioSaizPair {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Container container;
        private SampleAuxiliaryInformationOffsetsBox saio;
        private SampleAuxiliaryInformationSizesBox saiz;

        public FindSaioSaizPair(Container container) {
            this.container = container;
        }

        public SampleAuxiliaryInformationOffsetsBox getSaio() {
            return this.saio;
        }

        public SampleAuxiliaryInformationSizesBox getSaiz() {
            return this.saiz;
        }

        public FindSaioSaizPair invoke() {
            List boxes = this.container.getBoxes(SampleAuxiliaryInformationSizesBox.class);
            List boxes2 = this.container.getBoxes(SampleAuxiliaryInformationOffsetsBox.class);
            this.saiz = null;
            this.saio = null;
            for (int i = 0; i < boxes.size(); i++) {
                if ((this.saiz == null && ((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType() == null) || "cenc".equals(((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType())) {
                    this.saiz = (SampleAuxiliaryInformationSizesBox) boxes.get(i);
                } else {
                    SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = this.saiz;
                    if (sampleAuxiliaryInformationSizesBox == null || sampleAuxiliaryInformationSizesBox.getAuxInfoType() != null || !"cenc".equals(((SampleAuxiliaryInformationSizesBox) boxes.get(i)).getAuxInfoType())) {
                        throw new RuntimeException("Are there two cenc labeled saiz?");
                    }
                    this.saiz = (SampleAuxiliaryInformationSizesBox) boxes.get(i);
                }
                if ((this.saio == null && ((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType() == null) || "cenc".equals(((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType())) {
                    this.saio = (SampleAuxiliaryInformationOffsetsBox) boxes2.get(i);
                } else {
                    SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = this.saio;
                    if (sampleAuxiliaryInformationOffsetsBox == null || sampleAuxiliaryInformationOffsetsBox.getAuxInfoType() != null || !"cenc".equals(((SampleAuxiliaryInformationOffsetsBox) boxes2.get(i)).getAuxInfoType())) {
                        throw new RuntimeException("Are there two cenc labeled saio?");
                    }
                    this.saio = (SampleAuxiliaryInformationOffsetsBox) boxes2.get(i);
                }
            }
            return this;
        }
    }

    public CencMp4TrackImplImpl(String str, TrackBox trackBox, IsoFile... isoFileArr) throws IOException {
        long size;
        long j;
        int sampleCount;
        Container parent;
        long baseDataOffset;
        int i;
        super(str, trackBox, isoFileArr);
        this.sampleEncryptionEntries = new ArrayList();
        long trackId = trackBox.getTrackHeaderBox().getTrackId();
        if (trackBox.getParent().getBoxes(MovieExtendsBox.class).size() <= 0) {
            TrackEncryptionBox path = Path.getPath((AbstractContainerBox) trackBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schi[0]/tenc[0]");
            this.defaultKeyId = path.getDefault_KID();
            ChunkOffsetBox chunkOffsetBox = (ChunkOffsetBox) Path.getPath((AbstractContainerBox) trackBox, "mdia[0]/minf[0]/stbl[0]/stco[0]");
            long[] jArrBlowup = trackBox.getSampleTableBox().getSampleToChunkBox().blowup((chunkOffsetBox == null ? (ChunkOffsetBox) Path.getPath((AbstractContainerBox) trackBox, "mdia[0]/minf[0]/stbl[0]/co64[0]") : chunkOffsetBox).getChunkOffsets().length);
            FindSaioSaizPair findSaioSaizPairInvoke = new FindSaioSaizPair((Container) Path.getPath((AbstractContainerBox) trackBox, "mdia[0]/minf[0]/stbl[0]")).invoke();
            SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = findSaioSaizPairInvoke.saio;
            SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = findSaioSaizPairInvoke.saiz;
            Container parent2 = ((MovieBox) trackBox.getParent()).getParent();
            if (sampleAuxiliaryInformationOffsetsBox.getOffsets().length == 1) {
                long j2 = sampleAuxiliaryInformationOffsetsBox.getOffsets()[0];
                if (sampleAuxiliaryInformationSizesBox.getDefaultSampleInfoSize() > 0) {
                    sampleCount = (sampleAuxiliaryInformationSizesBox.getSampleCount() * sampleAuxiliaryInformationSizesBox.getDefaultSampleInfoSize()) + 0;
                } else {
                    sampleCount = 0;
                    for (int i2 = 0; i2 < sampleAuxiliaryInformationSizesBox.getSampleCount(); i2++) {
                        sampleCount += sampleAuxiliaryInformationSizesBox.getSampleInfoSizes()[i2];
                    }
                }
                ByteBuffer byteBuffer = parent2.getByteBuffer(j2, sampleCount);
                for (int i3 = 0; i3 < sampleAuxiliaryInformationSizesBox.getSampleCount(); i3++) {
                    this.sampleEncryptionEntries.add(parseCencAuxDataFormat(path.getDefaultIvSize(), byteBuffer, sampleAuxiliaryInformationSizesBox.getSize(i3)));
                }
                return;
            }
            if (sampleAuxiliaryInformationOffsetsBox.getOffsets().length != jArrBlowup.length) {
                throw new RuntimeException("Number of saio offsets must be either 1 or number of chunks");
            }
            int i4 = 0;
            for (int i5 = 0; i5 < jArrBlowup.length; i5++) {
                long j3 = sampleAuxiliaryInformationOffsetsBox.getOffsets()[i5];
                if (sampleAuxiliaryInformationSizesBox.getDefaultSampleInfoSize() > 0) {
                    size = (((long) sampleAuxiliaryInformationSizesBox.getSampleCount()) * jArrBlowup[i5]) + 0;
                } else {
                    size = 0;
                    for (int i6 = 0; i6 < jArrBlowup[i5]; i6++) {
                        size += (long) sampleAuxiliaryInformationSizesBox.getSize(i4 + i6);
                    }
                }
                ByteBuffer byteBuffer2 = parent2.getByteBuffer(j3, size);
                int i7 = 0;
                while (true) {
                    long j4 = i7;
                    j = jArrBlowup[i5];
                    if (j4 >= j) {
                        break;
                    }
                    this.sampleEncryptionEntries.add(parseCencAuxDataFormat(path.getDefaultIvSize(), byteBuffer2, sampleAuxiliaryInformationSizesBox.getSize(i4 + i7)));
                    i7++;
                }
                i4 = (int) (((long) i4) + j);
            }
            return;
        }
        Iterator it = ((Box) trackBox.getParent()).getParent().getBoxes(MovieFragmentBox.class).iterator();
        while (it.hasNext()) {
            MovieFragmentBox movieFragmentBox = (MovieFragmentBox) it.next();
            Iterator it2 = movieFragmentBox.getBoxes(TrackFragmentBox.class).iterator();
            while (it2.hasNext()) {
                TrackFragmentBox trackFragmentBox = (TrackFragmentBox) it2.next();
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                    TrackEncryptionBox path2 = Path.getPath((AbstractContainerBox) trackBox, "mdia[0]/minf[0]/stbl[0]/stsd[0]/enc.[0]/sinf[0]/schi[0]/tenc[0]");
                    this.defaultKeyId = path2.getDefault_KID();
                    if (trackFragmentBox.getTrackFragmentHeaderBox().hasBaseDataOffset()) {
                        parent = ((Box) trackBox.getParent()).getParent();
                        baseDataOffset = trackFragmentBox.getTrackFragmentHeaderBox().getBaseDataOffset();
                    } else {
                        parent = movieFragmentBox;
                        baseDataOffset = 0;
                    }
                    FindSaioSaizPair findSaioSaizPairInvoke2 = new FindSaioSaizPair(trackFragmentBox).invoke();
                    SampleAuxiliaryInformationOffsetsBox saio = findSaioSaizPairInvoke2.getSaio();
                    SampleAuxiliaryInformationSizesBox saiz = findSaioSaizPairInvoke2.getSaiz();
                    long[] offsets = saio.getOffsets();
                    List boxes = trackFragmentBox.getBoxes(TrackRunBox.class);
                    long j5 = trackId;
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < offsets.length) {
                        int size2 = ((TrackRunBox) boxes.get(i8)).getEntries().size();
                        long j6 = offsets[i8];
                        Iterator it3 = it;
                        long[] jArr = offsets;
                        List list = boxes;
                        int i10 = i9;
                        long size3 = 0;
                        while (true) {
                            i = i9 + size2;
                            if (i10 >= i) {
                                break;
                            }
                            size3 += (long) saiz.getSize(i10);
                            i10++;
                            movieFragmentBox = movieFragmentBox;
                            it2 = it2;
                        }
                        ByteBuffer byteBuffer3 = parent.getByteBuffer(baseDataOffset + j6, size3);
                        int i11 = i9;
                        while (i11 < i) {
                            this.sampleEncryptionEntries.add(parseCencAuxDataFormat(path2.getDefaultIvSize(), byteBuffer3, saiz.getSize(i11)));
                            i11++;
                            i = i;
                            movieFragmentBox = movieFragmentBox;
                            it2 = it2;
                        }
                        i8++;
                        offsets = jArr;
                        i9 = i;
                        boxes = list;
                        it = it3;
                    }
                    trackId = j5;
                }
            }
        }
    }

    private CencSampleAuxiliaryDataFormat parseCencAuxDataFormat(int i, ByteBuffer byteBuffer, long j) {
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = new CencSampleAuxiliaryDataFormat();
        if (j > 0) {
            byte[] bArr = new byte[i];
            cencSampleAuxiliaryDataFormat.iv = bArr;
            byteBuffer.get(bArr);
            if (j > i) {
                cencSampleAuxiliaryDataFormat.pairs = new CencSampleAuxiliaryDataFormat.Pair[IsoTypeReader.readUInt16(byteBuffer)];
                int i2 = 0;
                while (true) {
                    CencSampleAuxiliaryDataFormat.Pair[] pairArr = cencSampleAuxiliaryDataFormat.pairs;
                    if (i2 >= pairArr.length) {
                        break;
                    }
                    pairArr[i2] = cencSampleAuxiliaryDataFormat.createPair(IsoTypeReader.readUInt16(byteBuffer), IsoTypeReader.readUInt32(byteBuffer));
                    i2++;
                }
            }
        }
        return cencSampleAuxiliaryDataFormat;
    }

    @Override // com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack
    public UUID getDefaultKeyId() {
        return this.defaultKeyId;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public String getName() {
        return "enc(" + super.getName() + ")";
    }

    @Override // com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack
    public List<CencSampleAuxiliaryDataFormat> getSampleEncryptionEntries() {
        return this.sampleEncryptionEntries;
    }

    @Override // com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack
    public boolean hasSubSampleEncryption() {
        return false;
    }

    public String toString() {
        return "CencMp4TrackImpl{handler='" + getHandler() + "'}";
    }
}
