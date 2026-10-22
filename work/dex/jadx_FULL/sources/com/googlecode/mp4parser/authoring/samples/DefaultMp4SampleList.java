package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DefaultMp4SampleList extends AbstractList<Sample> {
    private static final Logger LOG = Logger.getLogger(DefaultMp4SampleList.class);
    SoftReference<ByteBuffer>[] cache;
    int[] chunkNumsStartSampleNum;
    long[] chunkOffsets;
    long[] chunkSizes;
    int lastChunk = 0;
    long[][] sampleOffsetsWithinChunks;
    SampleSizeBox ssb;
    Container topLevel;
    TrackBox trackBox;

    public class SampleImpl implements Sample {
        private int index;

        public SampleImpl(int i) {
            this.index = i;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public synchronized ByteBuffer asByteBuffer() {
            long j;
            ByteBuffer byteBuffer;
            int chunkForSample = DefaultMp4SampleList.this.getChunkForSample(this.index);
            DefaultMp4SampleList defaultMp4SampleList = DefaultMp4SampleList.this;
            SoftReference<ByteBuffer> softReference = defaultMp4SampleList.cache[chunkForSample];
            int i = defaultMp4SampleList.chunkNumsStartSampleNum[chunkForSample] - 1;
            int i2 = this.index - i;
            long j2 = chunkForSample;
            long[] jArr = defaultMp4SampleList.sampleOffsetsWithinChunks[CastUtils.l2i(j2)];
            j = jArr[i2];
            if (softReference == null || (byteBuffer = softReference.get()) == null) {
                try {
                    DefaultMp4SampleList defaultMp4SampleList2 = DefaultMp4SampleList.this;
                    byteBuffer = defaultMp4SampleList2.topLevel.getByteBuffer(defaultMp4SampleList2.chunkOffsets[CastUtils.l2i(j2)], jArr[jArr.length - 1] + DefaultMp4SampleList.this.ssb.getSampleSizeAtIndex((i + jArr.length) - 1));
                    DefaultMp4SampleList.this.cache[chunkForSample] = new SoftReference<>(byteBuffer);
                } catch (IOException e) {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    DefaultMp4SampleList.LOG.logError(stringWriter.toString());
                    throw new IndexOutOfBoundsException(e.getMessage());
                }
            }
            return (ByteBuffer) ((ByteBuffer) byteBuffer.duplicate().position(CastUtils.l2i(j))).slice().limit(CastUtils.l2i(DefaultMp4SampleList.this.ssb.getSampleSizeAtIndex(this.index)));
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return DefaultMp4SampleList.this.ssb.getSampleSizeAtIndex(this.index);
        }

        public String toString() {
            return "Sample(index: " + this.index + " size: " + DefaultMp4SampleList.this.ssb.getSampleSizeAtIndex(this.index) + ")";
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(asByteBuffer());
        }
    }

    public DefaultMp4SampleList(long j, Container container) {
        int i;
        this.trackBox = null;
        this.cache = null;
        int i2 = 0;
        this.topLevel = container;
        for (TrackBox trackBox : ((MovieBox) container.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.trackBox = trackBox;
            }
        }
        TrackBox trackBox2 = this.trackBox;
        if (trackBox2 == null) {
            throw new RuntimeException("This MP4 does not contain track " + j);
        }
        long[] chunkOffsets = trackBox2.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
        this.chunkOffsets = chunkOffsets;
        this.chunkSizes = new long[chunkOffsets.length];
        SoftReference<ByteBuffer>[] softReferenceArr = new SoftReference[chunkOffsets.length];
        this.cache = softReferenceArr;
        Arrays.fill(softReferenceArr, new SoftReference(null));
        this.sampleOffsetsWithinChunks = new long[this.chunkOffsets.length][];
        this.ssb = this.trackBox.getSampleTableBox().getSampleSizeBox();
        List<SampleToChunkBox.Entry> entries = this.trackBox.getSampleTableBox().getSampleToChunkBox().getEntries();
        SampleToChunkBox.Entry[] entryArr = (SampleToChunkBox.Entry[]) entries.toArray(new SampleToChunkBox.Entry[entries.size()]);
        SampleToChunkBox.Entry entry = entryArr[0];
        long firstChunk = entry.getFirstChunk();
        int iL2i = CastUtils.l2i(entry.getSamplesPerChunk());
        int size = size();
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        do {
            i3++;
            if (i3 == firstChunk) {
                if (entryArr.length > i5) {
                    SampleToChunkBox.Entry entry2 = entryArr[i5];
                    i4 = iL2i;
                    iL2i = CastUtils.l2i(entry2.getSamplesPerChunk());
                    i5++;
                    firstChunk = entry2.getFirstChunk();
                } else {
                    i4 = iL2i;
                    iL2i = -1;
                    firstChunk = Long.MAX_VALUE;
                }
            }
            this.sampleOffsetsWithinChunks[i3 - 1] = new long[i4];
            i6 += i4;
        } while (i6 <= size);
        this.chunkNumsStartSampleNum = new int[i3 + 1];
        SampleToChunkBox.Entry entry3 = entryArr[0];
        long firstChunk2 = entry3.getFirstChunk();
        int iL2i2 = CastUtils.l2i(entry3.getSamplesPerChunk());
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        int i10 = 1;
        while (true) {
            i = i7 + 1;
            this.chunkNumsStartSampleNum[i7] = i9;
            int i11 = i9;
            if (i == firstChunk2) {
                if (entryArr.length > i10) {
                    SampleToChunkBox.Entry entry4 = entryArr[i10];
                    i8 = iL2i2;
                    iL2i2 = CastUtils.l2i(entry4.getSamplesPerChunk());
                    i10++;
                    firstChunk2 = entry4.getFirstChunk();
                } else {
                    i8 = iL2i2;
                    iL2i2 = -1;
                    firstChunk2 = Long.MAX_VALUE;
                }
            }
            i9 = i11 + i8;
            if (i9 > size) {
                break;
            } else {
                i7 = i;
            }
        }
        this.chunkNumsStartSampleNum[i] = Integer.MAX_VALUE;
        long sampleSizeAtIndex = 0;
        for (int i12 = 1; i12 <= this.ssb.getSampleCount(); i12++) {
            while (i12 == this.chunkNumsStartSampleNum[i2]) {
                i2++;
                sampleSizeAtIndex = 0;
            }
            long[] jArr = this.chunkSizes;
            int i13 = i2 - 1;
            int i14 = i12 - 1;
            jArr[i13] = jArr[i13] + this.ssb.getSampleSizeAtIndex(i14);
            this.sampleOffsetsWithinChunks[i13][i12 - this.chunkNumsStartSampleNum[i13]] = sampleSizeAtIndex;
            sampleSizeAtIndex += this.ssb.getSampleSizeAtIndex(i14);
        }
    }

    public synchronized int getChunkForSample(int i) {
        int i2 = i + 1;
        int[] iArr = this.chunkNumsStartSampleNum;
        int i3 = this.lastChunk;
        int i4 = iArr[i3];
        if (i2 >= i4 && i2 < iArr[i3 + 1]) {
            return i3;
        }
        if (i2 < i4) {
            this.lastChunk = 0;
            while (true) {
                int[] iArr2 = this.chunkNumsStartSampleNum;
                int i5 = this.lastChunk;
                if (iArr2[i5 + 1] > i2) {
                    return i5;
                }
                this.lastChunk = i5 + 1;
            }
        } else {
            this.lastChunk = i3 + 1;
            while (true) {
                int[] iArr3 = this.chunkNumsStartSampleNum;
                int i6 = this.lastChunk;
                if (iArr3[i6 + 1] > i2) {
                    return i6;
                }
                this.lastChunk = i6 + 1;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return CastUtils.l2i(this.trackBox.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }

    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        if (i < this.ssb.getSampleCount()) {
            return new SampleImpl(i);
        }
        throw new IndexOutOfBoundsException();
    }
}
