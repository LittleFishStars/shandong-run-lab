package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentedMp4SampleList extends AbstractList<Sample> {
    private List<TrackFragmentBox> allTrafs;
    private int[] firstSamples;
    IsoFile[] fragments;
    private SoftReference<Sample>[] sampleCache;
    Container topLevel;
    TrackBox trackBox;
    TrackExtendsBox trex;
    private Map<TrackRunBox, SoftReference<ByteBuffer>> trunDataCache = new HashMap();
    private int size_ = -1;

    public FragmentedMp4SampleList(long j, Container container, IsoFile... isoFileArr) {
        this.trackBox = null;
        this.trex = null;
        this.topLevel = container;
        this.fragments = isoFileArr;
        for (TrackBox trackBox : Path.getPaths(container, "moov[0]/trak")) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j) {
                this.trackBox = trackBox;
            }
        }
        if (this.trackBox == null) {
            throw new RuntimeException("This MP4 does not contain track " + j);
        }
        for (TrackExtendsBox trackExtendsBox : Path.getPaths(container, "moov[0]/mvex[0]/trex")) {
            if (trackExtendsBox.getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                this.trex = trackExtendsBox;
            }
        }
        this.sampleCache = (SoftReference[]) Array.newInstance((Class<?>) SoftReference.class, size());
        initAllFragments();
    }

    private int getTrafSize(TrackFragmentBox trackFragmentBox) {
        List<Box> boxes = trackFragmentBox.getBoxes();
        int iL2i = 0;
        for (int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            if (box instanceof TrackRunBox) {
                iL2i += CastUtils.l2i(((TrackRunBox) box).getSampleCount());
            }
        }
        return iL2i;
    }

    private List<TrackFragmentBox> initAllFragments() {
        List<TrackFragmentBox> list = this.allTrafs;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.topLevel.getBoxes(MovieFragmentBox.class).iterator();
        while (it.hasNext()) {
            for (TrackFragmentBox trackFragmentBox : ((MovieFragmentBox) it.next()).getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    arrayList.add(trackFragmentBox);
                }
            }
        }
        IsoFile[] isoFileArr = this.fragments;
        if (isoFileArr != null) {
            for (IsoFile isoFile : isoFileArr) {
                Iterator it2 = isoFile.getBoxes(MovieFragmentBox.class).iterator();
                while (it2.hasNext()) {
                    for (TrackFragmentBox trackFragmentBox2 : ((MovieFragmentBox) it2.next()).getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                            arrayList.add(trackFragmentBox2);
                        }
                    }
                }
            }
        }
        this.allTrafs = arrayList;
        this.firstSamples = new int[arrayList.size()];
        int trafSize = 1;
        for (int i = 0; i < this.allTrafs.size(); i++) {
            this.firstSamples[i] = trafSize;
            trafSize += getTrafSize(this.allTrafs.get(i));
        }
        return arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int i = this.size_;
        if (i != -1) {
            return i;
        }
        Iterator it = this.topLevel.getBoxes(MovieFragmentBox.class).iterator();
        int sampleCount = 0;
        while (it.hasNext()) {
            for (TrackFragmentBox trackFragmentBox : ((MovieFragmentBox) it.next()).getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    Iterator it2 = trackFragmentBox.getBoxes(TrackRunBox.class).iterator();
                    while (it2.hasNext()) {
                        sampleCount = (int) (((long) sampleCount) + ((TrackRunBox) it2.next()).getSampleCount());
                    }
                }
            }
        }
        for (IsoFile isoFile : this.fragments) {
            Iterator it3 = isoFile.getBoxes(MovieFragmentBox.class).iterator();
            while (it3.hasNext()) {
                for (TrackFragmentBox trackFragmentBox2 : ((MovieFragmentBox) it3.next()).getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                        Iterator it4 = trackFragmentBox2.getBoxes(TrackRunBox.class).iterator();
                        while (it4.hasNext()) {
                            sampleCount = (int) (((long) sampleCount) + ((TrackRunBox) it4.next()).getSampleCount());
                        }
                    }
                }
            }
        }
        this.size_ = sampleCount;
        return sampleCount;
    }

    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        long j;
        ByteBuffer byteBuffer;
        MovieFragmentBox parent;
        long defaultSampleSize;
        Sample sample;
        SoftReference<Sample> softReference = this.sampleCache[i];
        if (softReference != null && (sample = softReference.get()) != null) {
            return sample;
        }
        int i2 = i + 1;
        int length = this.firstSamples.length;
        do {
            length--;
        } while (i2 - this.firstSamples[length] < 0);
        TrackFragmentBox trackFragmentBox = this.allTrafs.get(length);
        int i3 = i2 - this.firstSamples[length];
        MovieFragmentBox movieFragmentBox = (MovieFragmentBox) trackFragmentBox.getParent();
        int size = 0;
        for (Box box : trackFragmentBox.getBoxes()) {
            if (box instanceof TrackRunBox) {
                TrackRunBox trackRunBox = (TrackRunBox) box;
                int i4 = i3 - size;
                if (trackRunBox.getEntries().size() > i4) {
                    List<TrackRunBox.Entry> entries = trackRunBox.getEntries();
                    TrackFragmentHeaderBox trackFragmentHeaderBox = trackFragmentBox.getTrackFragmentHeaderBox();
                    boolean zIsSampleSizePresent = trackRunBox.isSampleSizePresent();
                    boolean zHasDefaultSampleSize = trackFragmentHeaderBox.hasDefaultSampleSize();
                    long dataOffset = 0;
                    if (zIsSampleSizePresent) {
                        j = 0;
                    } else {
                        if (zHasDefaultSampleSize) {
                            defaultSampleSize = trackFragmentHeaderBox.getDefaultSampleSize();
                        } else {
                            TrackExtendsBox trackExtendsBox = this.trex;
                            if (trackExtendsBox == null) {
                                throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                            }
                            defaultSampleSize = trackExtendsBox.getDefaultSampleSize();
                        }
                        j = defaultSampleSize;
                    }
                    SoftReference<ByteBuffer> softReference2 = this.trunDataCache.get(trackRunBox);
                    ByteBuffer byteBuffer2 = softReference2 != null ? softReference2.get() : null;
                    if (byteBuffer2 == null) {
                        if (trackFragmentHeaderBox.hasBaseDataOffset()) {
                            parent = movieFragmentBox;
                            dataOffset = 0 + trackFragmentHeaderBox.getBaseDataOffset();
                            parent = movieFragmentBox.getParent();
                        }
                        parent = movieFragmentBox;
                        if (trackRunBox.isDataOffsetPresent()) {
                            dataOffset += (long) trackRunBox.getDataOffset();
                        }
                        Iterator<TrackRunBox.Entry> it = entries.iterator();
                        int sampleSize = 0;
                        while (it.hasNext()) {
                            sampleSize = zIsSampleSizePresent ? (int) (((long) sampleSize) + it.next().getSampleSize()) : (int) (((long) sampleSize) + j);
                        }
                        try {
                            ByteBuffer byteBuffer3 = parent.getByteBuffer(dataOffset, sampleSize);
                            this.trunDataCache.put(trackRunBox, new SoftReference<>(byteBuffer3));
                            byteBuffer = byteBuffer3;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        byteBuffer = byteBuffer2;
                    }
                    int sampleSize2 = 0;
                    for (int i5 = 0; i5 < i4; i5++) {
                        sampleSize2 = (int) (zIsSampleSizePresent ? ((long) sampleSize2) + entries.get(i5).getSampleSize() : ((long) sampleSize2) + j);
                    }
                    final long sampleSize3 = zIsSampleSizePresent ? entries.get(i4).getSampleSize() : j;
                    final ByteBuffer byteBuffer4 = byteBuffer;
                    final int i6 = sampleSize2;
                    Sample sample2 = new Sample() { // from class: com.googlecode.mp4parser.authoring.samples.FragmentedMp4SampleList.1
                        @Override // com.googlecode.mp4parser.authoring.Sample
                        public ByteBuffer asByteBuffer() {
                            return (ByteBuffer) ((ByteBuffer) byteBuffer4.position(i6)).slice().limit(CastUtils.l2i(sampleSize3));
                        }

                        @Override // com.googlecode.mp4parser.authoring.Sample
                        public long getSize() {
                            return sampleSize3;
                        }

                        @Override // com.googlecode.mp4parser.authoring.Sample
                        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                            writableByteChannel.write(asByteBuffer());
                        }
                    };
                    this.sampleCache[i] = new SoftReference<>(sample2);
                    return sample2;
                }
                size += trackRunBox.getEntries().size();
            }
        }
        throw new RuntimeException("Couldn't find sample in the traf I was looking");
    }
}
