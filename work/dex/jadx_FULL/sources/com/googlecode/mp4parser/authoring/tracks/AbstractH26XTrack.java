package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AbstractH26XTrack extends AbstractTrack {
    public static int BUFFER = 67107840;
    protected List<CompositionTimeToSample.Entry> ctts;
    private DataSource dataSource;
    protected long[] decodingTimes;
    protected List<SampleDependencyTypeBox.Entry> sdtp;
    protected List<Integer> stss;
    protected TrackMetaData trackMetaData;
    boolean tripleZeroIsEndOfSequence;

    public static class LookAhead {
        ByteBuffer buffer;
        DataSource dataSource;
        long start;
        long bufferStartPos = 0;
        int inBufferPos = 0;

        public LookAhead(DataSource dataSource) throws IOException {
            this.dataSource = dataSource;
            fillBuffer();
        }

        public void discardByte() {
            this.inBufferPos++;
        }

        public void discardNext3AndMarkStart() {
            int i = this.inBufferPos + 3;
            this.inBufferPos = i;
            this.start = this.bufferStartPos + ((long) i);
        }

        public void fillBuffer() throws IOException {
            DataSource dataSource = this.dataSource;
            this.buffer = dataSource.map(this.bufferStartPos, Math.min(dataSource.size() - this.bufferStartPos, AbstractH26XTrack.BUFFER));
        }

        public ByteBuffer getNal() {
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

        public boolean nextThreeEquals000or001orEof(boolean z) throws IOException {
            int iLimit = this.buffer.limit();
            int i = this.inBufferPos;
            if (iLimit - i >= 3) {
                return this.buffer.get(i) == 0 && this.buffer.get(this.inBufferPos + 1) == 0 && ((this.buffer.get(this.inBufferPos + 2) == 0 && z) || this.buffer.get(this.inBufferPos + 2) == 1);
            }
            if (this.bufferStartPos + ((long) i) + 3 > this.dataSource.size()) {
                return this.bufferStartPos + ((long) this.inBufferPos) == this.dataSource.size();
            }
            this.bufferStartPos = this.start;
            this.inBufferPos = 0;
            fillBuffer();
            return nextThreeEquals000or001orEof(z);
        }

        public boolean nextThreeEquals001() throws IOException {
            int iLimit = this.buffer.limit();
            int i = this.inBufferPos;
            if (iLimit - i >= 3) {
                return this.buffer.get(i) == 0 && this.buffer.get(this.inBufferPos + 1) == 0 && this.buffer.get(this.inBufferPos + 2) == 1;
            }
            if (this.bufferStartPos + ((long) i) + 3 < this.dataSource.size()) {
                return false;
            }
            throw new EOFException();
        }
    }

    public AbstractH26XTrack(DataSource dataSource, boolean z) {
        super(dataSource.toString());
        this.ctts = new ArrayList();
        this.sdtp = new ArrayList();
        this.stss = new ArrayList();
        this.trackMetaData = new TrackMetaData();
        this.dataSource = dataSource;
        this.tripleZeroIsEndOfSequence = z;
    }

    public static InputStream cleanBuffer(InputStream inputStream) {
        return new CleanInputStream(inputStream);
    }

    public static byte[] toArray(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int iRemaining = byteBufferDuplicate.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBufferDuplicate.get(bArr, 0, iRemaining);
        return bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dataSource.close();
    }

    public Sample createSampleObject(List<? extends ByteBuffer> list) {
        byte[] bArr = new byte[list.size() * 4];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Iterator<? extends ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            byteBufferWrap.putInt(it.next().remaining());
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = ByteBuffer.wrap(bArr, i * 4, 4);
            byteBufferArr[i2 + 1] = list.get(i);
        }
        return new SampleImpl(byteBufferArr);
    }

    public ByteBuffer findNextNal(LookAhead lookAhead) throws IOException {
        while (!lookAhead.nextThreeEquals001()) {
            try {
                lookAhead.discardByte();
            } catch (EOFException unused) {
                return null;
            }
        }
        lookAhead.discardNext3AndMarkStart();
        while (!lookAhead.nextThreeEquals000or001orEof(this.tripleZeroIsEndOfSequence)) {
            lookAhead.discardByte();
        }
        return lookAhead.getNal();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.ctts;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.sdtp;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.decodingTimes;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        long[] jArr = new long[this.stss.size()];
        for (int i = 0; i < this.stss.size(); i++) {
            jArr[i] = this.stss.get(i).intValue();
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public AbstractH26XTrack(DataSource dataSource) {
        this(dataSource, true);
    }
}
