package com.google.android.inner_exoplayer2.text;

import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.ParserException;
import com.google.android.inner_exoplayer2.extractor.Extractor;
import com.google.android.inner_exoplayer2.extractor.ExtractorInput;
import com.google.android.inner_exoplayer2.extractor.ExtractorOutput;
import com.google.android.inner_exoplayer2.extractor.IndexSeekMap;
import com.google.android.inner_exoplayer2.extractor.PositionHolder;
import com.google.android.inner_exoplayer2.extractor.TrackOutput;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;
import com.google.android.inner_exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SubtitleExtractor implements Extractor {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int STATE_CREATED = 0;
    private static final int STATE_EXTRACTING = 2;
    private static final int STATE_FINISHED = 4;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 5;
    private static final int STATE_SEEKING = 3;
    private int bytesRead;
    private ExtractorOutput extractorOutput;
    private final Format format;
    private final SubtitleDecoder subtitleDecoder;
    private TrackOutput trackOutput;
    private final CueEncoder cueEncoder = new CueEncoder();
    private final ParsableByteArray subtitleData = new ParsableByteArray();
    private final List<Long> timestamps = new ArrayList();
    private final List<ParsableByteArray> samples = new ArrayList();
    private int state = 0;
    private long seekTimeUs = -9223372036854775807L;

    public SubtitleExtractor(SubtitleDecoder subtitleDecoder, Format format) {
        this.subtitleDecoder = subtitleDecoder;
        this.format = format.buildUpon().setSampleMimeType("text/x-exoplayer-cues").setCodecs(format.sampleMimeType).build();
    }

    private void decode() throws ParserException, InterruptedIOException {
        try {
            SubtitleInputBuffer subtitleInputBufferDequeueInputBuffer = this.subtitleDecoder.dequeueInputBuffer();
            while (subtitleInputBufferDequeueInputBuffer == null) {
                Thread.sleep(5L);
                subtitleInputBufferDequeueInputBuffer = this.subtitleDecoder.dequeueInputBuffer();
            }
            subtitleInputBufferDequeueInputBuffer.ensureSpaceForWrite(this.bytesRead);
            subtitleInputBufferDequeueInputBuffer.data.put(this.subtitleData.getData(), 0, this.bytesRead);
            subtitleInputBufferDequeueInputBuffer.data.limit(this.bytesRead);
            this.subtitleDecoder.queueInputBuffer(subtitleInputBufferDequeueInputBuffer);
            SubtitleOutputBuffer subtitleOutputBufferDequeueOutputBuffer = this.subtitleDecoder.dequeueOutputBuffer();
            while (subtitleOutputBufferDequeueOutputBuffer == null) {
                Thread.sleep(5L);
                subtitleOutputBufferDequeueOutputBuffer = this.subtitleDecoder.dequeueOutputBuffer();
            }
            for (int i = 0; i < subtitleOutputBufferDequeueOutputBuffer.getEventTimeCount(); i++) {
                byte[] bArrEncode = this.cueEncoder.encode(subtitleOutputBufferDequeueOutputBuffer.getCues(subtitleOutputBufferDequeueOutputBuffer.getEventTime(i)));
                this.timestamps.add(Long.valueOf(subtitleOutputBufferDequeueOutputBuffer.getEventTime(i)));
                this.samples.add(new ParsableByteArray(bArrEncode));
            }
            subtitleOutputBufferDequeueOutputBuffer.release();
        } catch (SubtitleDecoderException e) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    private boolean readFromInput(ExtractorInput extractorInput) {
        int iCapacity = this.subtitleData.capacity();
        int i = this.bytesRead;
        if (iCapacity == i) {
            this.subtitleData.ensureCapacity(i + 1024);
        }
        int i2 = extractorInput.read(this.subtitleData.getData(), this.bytesRead, this.subtitleData.capacity() - this.bytesRead);
        if (i2 != -1) {
            this.bytesRead += i2;
        }
        long length = extractorInput.getLength();
        return (length != -1 && ((long) this.bytesRead) == length) || i2 == -1;
    }

    private boolean skipInput(ExtractorInput extractorInput) {
        return extractorInput.skip((extractorInput.getLength() > (-1L) ? 1 : (extractorInput.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(extractorInput.getLength()) : 1024) == -1;
    }

    private void writeToOutput() {
        Assertions.checkStateNotNull(this.trackOutput);
        Assertions.checkState(this.timestamps.size() == this.samples.size());
        long j = this.seekTimeUs;
        for (int iBinarySearchFloor = j == -9223372036854775807L ? 0 : Util.binarySearchFloor((List<? extends Comparable<? super Long>>) this.timestamps, Long.valueOf(j), true, true); iBinarySearchFloor < this.samples.size(); iBinarySearchFloor++) {
            ParsableByteArray parsableByteArray = this.samples.get(iBinarySearchFloor);
            parsableByteArray.setPosition(0);
            int length = parsableByteArray.getData().length;
            this.trackOutput.sampleData(parsableByteArray, length);
            this.trackOutput.sampleMetadata(this.timestamps.get(iBinarySearchFloor).longValue(), 1, length, 0, null);
        }
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        Assertions.checkState(this.state == 0);
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 3);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(new IndexSeekMap(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.trackOutput.format(this.format);
        this.state = 1;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException, InterruptedIOException {
        int i = this.state;
        Assertions.checkState((i == 0 || i == 5) ? false : true);
        if (this.state == 1) {
            this.subtitleData.reset(extractorInput.getLength() != -1 ? Ints.d(extractorInput.getLength()) : 1024);
            this.bytesRead = 0;
            this.state = 2;
        }
        if (this.state == 2 && readFromInput(extractorInput)) {
            decode();
            writeToOutput();
            this.state = 4;
        }
        if (this.state == 3 && skipInput(extractorInput)) {
            writeToOutput();
            this.state = 4;
        }
        return this.state == 4 ? -1 : 0;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public void release() {
        if (this.state == 5) {
            return;
        }
        this.subtitleDecoder.release();
        this.state = 5;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        int i = this.state;
        Assertions.checkState((i == 0 || i == 5) ? false : true);
        this.seekTimeUs = j2;
        if (this.state == 2) {
            this.state = 1;
        }
        if (this.state == 4) {
            this.state = 3;
        }
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        return true;
    }
}
