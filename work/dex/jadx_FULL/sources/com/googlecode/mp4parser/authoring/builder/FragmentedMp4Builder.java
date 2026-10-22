package com.googlecode.mp4parser.authoring.builder;

import androidx.camera.video.AudioStats;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.HintMediaHeaderBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.NullMediaHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SubtitleMediaHeaderBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Edit;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack;
import com.googlecode.mp4parser.boxes.dece.SampleEncryptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import com.mp4parser.iso23001.part7.TrackEncryptionBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentedMp4Builder implements Mp4Builder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = Logger.getLogger(FragmentedMp4Builder.class.getName());
    protected Fragmenter fragmenter;

    private long getTrackDuration(Movie movie, Track track) {
        return (track.getDuration() * movie.getTimescale()) / track.getTrackMetaData().getTimescale();
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
        LOG.fine("Creating movie " + movie);
        if (this.fragmenter == null) {
            this.fragmenter = new BetterFragmenter(2.0d);
        }
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(createFtyp(movie));
        basicContainer.addBox(createMoov(movie));
        Iterator<Box> it = createMoofMdat(movie).iterator();
        while (it.hasNext()) {
            basicContainer.addBox(it.next());
        }
        basicContainer.addBox(createMfra(movie, basicContainer));
        return basicContainer;
    }

    public DataInformationBox createDinf(Movie movie, Track track) {
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        return dataInformationBox;
    }

    public Box createEdts(Track track, Movie movie) {
        if (track.getEdits() == null || track.getEdits().size() <= 0) {
            return null;
        }
        EditListBox editListBox = new EditListBox();
        editListBox.setVersion(1);
        ArrayList arrayList = new ArrayList();
        for (Edit edit : track.getEdits()) {
            arrayList.add(new EditListBox.Entry(editListBox, Math.round(edit.getSegmentDuration() * movie.getTimescale()), (edit.getMediaTime() * track.getTrackMetaData().getTimescale()) / edit.getTimeScale(), edit.getMediaRate()));
        }
        editListBox.setEntries(arrayList);
        EditBox editBox = new EditBox();
        editBox.addBox(editListBox);
        return editBox;
    }

    public int createFragment(List<Box> list, Track track, long j, long j2, int i) {
        if (j != j2) {
            list.add(createMoof(j, j2, track, i));
            list.add(createMdat(j, j2, track, i));
        }
        return i;
    }

    public Box createFtyp(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("mp42");
        linkedList.add("iso6");
        linkedList.add("avc1");
        linkedList.add("isom");
        return new FileTypeBox("iso6", 1L, linkedList);
    }

    public Box createMdat(final long j, final long j2, final Track track, int i) {
        return new Box() { // from class: com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder.1Mdat
            Container parent;
            long size_ = -1;

            @Override // com.coremedia.iso.boxes.Box
            public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                IsoTypeWriter.writeUInt32(byteBufferAllocate, CastUtils.l2i(getSize()));
                byteBufferAllocate.put(IsoFile.fourCCtoBytes(getType()));
                byteBufferAllocate.rewind();
                writableByteChannel.write(byteBufferAllocate);
                Iterator<Sample> it = FragmentedMp4Builder.this.getSamples(j, j2, track).iterator();
                while (it.hasNext()) {
                    it.next().writeTo(writableByteChannel);
                }
            }

            @Override // com.coremedia.iso.boxes.Box
            public long getOffset() {
                throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
            }

            @Override // com.coremedia.iso.boxes.Box
            public Container getParent() {
                return this.parent;
            }

            @Override // com.coremedia.iso.boxes.Box
            public long getSize() {
                long j3 = this.size_;
                if (j3 != -1) {
                    return j3;
                }
                Iterator<Sample> it = FragmentedMp4Builder.this.getSamples(j, j2, track).iterator();
                long size = 8;
                while (it.hasNext()) {
                    size += it.next().getSize();
                }
                this.size_ = size;
                return size;
            }

            @Override // com.coremedia.iso.boxes.Box
            public String getType() {
                return MediaDataBox.TYPE;
            }

            @Override // com.coremedia.iso.boxes.Box
            public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j3, BoxParser boxParser) throws IOException {
            }

            @Override // com.coremedia.iso.boxes.Box
            public void setParent(Container container) {
                this.parent = container;
            }
        };
    }

    public Box createMdhd(Movie movie, Track track) {
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        mediaHeaderBox.setModificationTime(getDate());
        mediaHeaderBox.setDuration(0L);
        mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
        mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
        return mediaHeaderBox;
    }

    public Box createMdia(Track track, Movie movie) {
        MediaBox mediaBox = new MediaBox();
        mediaBox.addBox(createMdhd(movie, track));
        mediaBox.addBox(createMdiaHdlr(track, movie));
        mediaBox.addBox(createMinf(track, movie));
        return mediaBox;
    }

    public Box createMdiaHdlr(Track track, Movie movie) {
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.setHandlerType(track.getHandler());
        return handlerBox;
    }

    public void createMfhd(long j, long j2, Track track, int i, MovieFragmentBox movieFragmentBox) {
        MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
        movieFragmentHeaderBox.setSequenceNumber(i);
        movieFragmentBox.addBox(movieFragmentHeaderBox);
    }

    public Box createMfra(Movie movie, Container container) {
        MovieFragmentRandomAccessBox movieFragmentRandomAccessBox = new MovieFragmentRandomAccessBox();
        Iterator<Track> it = movie.getTracks().iterator();
        while (it.hasNext()) {
            movieFragmentRandomAccessBox.addBox(createTfra(it.next(), container));
        }
        MovieFragmentRandomAccessOffsetBox movieFragmentRandomAccessOffsetBox = new MovieFragmentRandomAccessOffsetBox();
        movieFragmentRandomAccessBox.addBox(movieFragmentRandomAccessOffsetBox);
        movieFragmentRandomAccessOffsetBox.setMfraSize(movieFragmentRandomAccessBox.getSize());
        return movieFragmentRandomAccessBox;
    }

    public Box createMinf(Track track, Movie movie) {
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        if (track.getHandler().equals("vide")) {
            mediaInformationBox.addBox(new VideoMediaHeaderBox());
        } else if (track.getHandler().equals("soun")) {
            mediaInformationBox.addBox(new SoundMediaHeaderBox());
        } else if (track.getHandler().equals("text")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        } else if (track.getHandler().equals("subt")) {
            mediaInformationBox.addBox(new SubtitleMediaHeaderBox());
        } else if (track.getHandler().equals("hint")) {
            mediaInformationBox.addBox(new HintMediaHeaderBox());
        } else if (track.getHandler().equals("sbtl")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        }
        mediaInformationBox.addBox(createDinf(movie, track));
        mediaInformationBox.addBox(createStbl(movie, track));
        return mediaInformationBox;
    }

    public Box createMoof(long j, long j2, Track track, int i) {
        MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
        createMfhd(j, j2, track, i, movieFragmentBox);
        createTraf(j, j2, track, i, movieFragmentBox);
        TrackRunBox trackRunBox = movieFragmentBox.getTrackRunBoxes().get(0);
        trackRunBox.setDataOffset(1);
        trackRunBox.setDataOffset((int) (movieFragmentBox.getSize() + 8));
        return movieFragmentBox;
    }

    public List<Box> createMoofMdat(Movie movie) {
        LinkedList linkedList = new LinkedList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (Track track : movie.getTracks()) {
            map.put(track, this.fragmenter.sampleNumbers(track));
            map2.put(track, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        int i = 1;
        int i2 = 1;
        while (!map.isEmpty()) {
            double dDoubleValue = Double.MAX_VALUE;
            Track track2 = null;
            for (Map.Entry entry : map2.entrySet()) {
                int i3 = i;
                int i4 = i2;
                if (((Double) entry.getValue()).doubleValue() < dDoubleValue) {
                    dDoubleValue = ((Double) entry.getValue()).doubleValue();
                    track2 = (Track) entry.getKey();
                }
                i = i3;
                i2 = i4;
            }
            long[] jArr = (long[]) map.get(track2);
            long j = jArr[0];
            long size = jArr.length > i ? jArr[i] : track2.getSamples().size() + i;
            long[] sampleDurations = track2.getSampleDurations();
            int i5 = i2;
            long timescale = track2.getTrackMetaData().getTimescale();
            double d = dDoubleValue;
            long j2 = j;
            while (j2 < size) {
                d += sampleDurations[CastUtils.l2i(j2 - 1)] / timescale;
                j2++;
                j = j;
                size = size;
            }
            createFragment(linkedList, track2, j, size, i5);
            if (jArr.length == 1) {
                map.remove(track2);
                map2.remove(track2);
            } else {
                int length = jArr.length - 1;
                long[] jArr2 = new long[length];
                System.arraycopy(jArr, 1, jArr2, 0, length);
                map.put(track2, jArr2);
                map2.put(track2, Double.valueOf(d));
            }
            i2 = i5 + 1;
            i = 1;
        }
        return linkedList;
    }

    public Box createMoov(Movie movie) {
        MovieBox movieBox = new MovieBox();
        movieBox.addBox(createMvhd(movie));
        Iterator<Track> it = movie.getTracks().iterator();
        while (it.hasNext()) {
            movieBox.addBox(createTrak(it.next(), movie));
        }
        movieBox.addBox(createMvex(movie));
        return movieBox;
    }

    public Box createMvex(Movie movie) {
        MovieExtendsBox movieExtendsBox = new MovieExtendsBox();
        MovieExtendsHeaderBox movieExtendsHeaderBox = new MovieExtendsHeaderBox();
        movieExtendsHeaderBox.setVersion(1);
        Iterator<Track> it = movie.getTracks().iterator();
        while (it.hasNext()) {
            long trackDuration = getTrackDuration(movie, it.next());
            if (movieExtendsHeaderBox.getFragmentDuration() < trackDuration) {
                movieExtendsHeaderBox.setFragmentDuration(trackDuration);
            }
        }
        movieExtendsBox.addBox(movieExtendsHeaderBox);
        Iterator<Track> it2 = movie.getTracks().iterator();
        while (it2.hasNext()) {
            movieExtendsBox.addBox(createTrex(movie, it2.next()));
        }
        return movieExtendsBox;
    }

    public Box createMvhd(Movie movie) {
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setVersion(1);
        movieHeaderBox.setCreationTime(getDate());
        movieHeaderBox.setModificationTime(getDate());
        long trackId = 0;
        movieHeaderBox.setDuration(0L);
        movieHeaderBox.setTimescale(movie.getTimescale());
        for (Track track : movie.getTracks()) {
            if (trackId < track.getTrackMetaData().getTrackId()) {
                trackId = track.getTrackMetaData().getTrackId();
            }
        }
        movieHeaderBox.setNextTrackId(trackId + 1);
        return movieHeaderBox;
    }

    public void createSaio(long j, long j2, CencEncryptedTrack cencEncryptedTrack, int i, TrackFragmentBox trackFragmentBox) {
        Box next;
        SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = new SampleAuxiliaryInformationOffsetsBox();
        trackFragmentBox.addBox(sampleAuxiliaryInformationOffsetsBox);
        sampleAuxiliaryInformationOffsetsBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationOffsetsBox.setFlags(1);
        long offsetToFirstIV = 8;
        for (Box box : trackFragmentBox.getBoxes()) {
            if (box instanceof SampleEncryptionBox) {
                offsetToFirstIV += (long) ((SampleEncryptionBox) box).getOffsetToFirstIV();
                break;
            }
            offsetToFirstIV += box.getSize();
        }
        long size = offsetToFirstIV + 16;
        Iterator<Box> it = ((MovieFragmentBox) trackFragmentBox.getParent()).getBoxes().iterator();
        while (it.hasNext() && (next = it.next()) != trackFragmentBox) {
            size += next.getSize();
        }
        sampleAuxiliaryInformationOffsetsBox.setOffsets(new long[]{size});
    }

    public void createSaiz(long j, long j2, CencEncryptedTrack cencEncryptedTrack, int i, TrackFragmentBox trackFragmentBox) {
        SampleDescriptionBox sampleDescriptionBox = cencEncryptedTrack.getSampleDescriptionBox();
        TrackEncryptionBox path = Path.getPath((AbstractContainerBox) sampleDescriptionBox, "enc.[0]/sinf[0]/schi[0]/tenc[0]");
        SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = new SampleAuxiliaryInformationSizesBox();
        sampleAuxiliaryInformationSizesBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationSizesBox.setFlags(1);
        if (cencEncryptedTrack.hasSubSampleEncryption()) {
            int iL2i = CastUtils.l2i(j2 - j);
            short[] sArr = new short[iL2i];
            List<CencSampleAuxiliaryDataFormat> listSubList = cencEncryptedTrack.getSampleEncryptionEntries().subList(CastUtils.l2i(j - 1), CastUtils.l2i(j2 - 1));
            for (int i2 = 0; i2 < iL2i; i2++) {
                sArr[i2] = (short) listSubList.get(i2).getSize();
            }
            sampleAuxiliaryInformationSizesBox.setSampleInfoSizes(sArr);
        } else {
            sampleAuxiliaryInformationSizesBox.setDefaultSampleInfoSize(path.getDefaultIvSize());
            sampleAuxiliaryInformationSizesBox.setSampleCount(CastUtils.l2i(j2 - j));
        }
        trackFragmentBox.addBox(sampleAuxiliaryInformationSizesBox);
    }

    public void createSenc(long j, long j2, CencEncryptedTrack cencEncryptedTrack, int i, TrackFragmentBox trackFragmentBox) {
        SampleEncryptionBox sampleEncryptionBox = new SampleEncryptionBox();
        sampleEncryptionBox.setSubSampleEncryption(cencEncryptedTrack.hasSubSampleEncryption());
        sampleEncryptionBox.setEntries(cencEncryptedTrack.getSampleEncryptionEntries().subList(CastUtils.l2i(j - 1), CastUtils.l2i(j2 - 1)));
        trackFragmentBox.addBox(sampleEncryptionBox);
    }

    public Box createStbl(Movie movie, Track track) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        createStsd(track, sampleTableBox);
        sampleTableBox.addBox(new TimeToSampleBox());
        sampleTableBox.addBox(new SampleToChunkBox());
        sampleTableBox.addBox(new SampleSizeBox());
        sampleTableBox.addBox(new StaticChunkOffsetBox());
        return sampleTableBox;
    }

    public void createStsd(Track track, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(track.getSampleDescriptionBox());
    }

    public void createTfdt(long j, Track track, TrackFragmentBox trackFragmentBox) {
        TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = new TrackFragmentBaseMediaDecodeTimeBox();
        trackFragmentBaseMediaDecodeTimeBox.setVersion(1);
        long[] sampleDurations = track.getSampleDurations();
        long j2 = 0;
        for (int i = 1; i < j; i++) {
            j2 += sampleDurations[i - 1];
        }
        trackFragmentBaseMediaDecodeTimeBox.setBaseMediaDecodeTime(j2);
        trackFragmentBox.addBox(trackFragmentBaseMediaDecodeTimeBox);
    }

    public void createTfhd(long j, long j2, Track track, int i, TrackFragmentBox trackFragmentBox) {
        TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
        trackFragmentHeaderBox.setDefaultSampleFlags(new SampleFlags());
        trackFragmentHeaderBox.setBaseDataOffset(-1L);
        trackFragmentHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackFragmentHeaderBox.setDefaultBaseIsMoof(true);
        trackFragmentBox.addBox(trackFragmentHeaderBox);
    }

    public Box createTfra(Track track, Container container) {
        int i;
        LinkedList linkedList;
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox = new TrackFragmentRandomAccessBox();
        trackFragmentRandomAccessBox.setVersion(1);
        LinkedList linkedList2 = new LinkedList();
        trackExtendsBox = null;
        for (TrackExtendsBox trackExtendsBox : Path.getPaths(container, "moov/mvex/trex")) {
            trackFragmentRandomAccessBox = trackFragmentRandomAccessBox;
            linkedList2 = linkedList2;
            TrackExtendsBox trackExtendsBox2 = trackExtendsBox;
            if (trackExtendsBox.getTrackId() != track.getTrackMetaData().getTrackId()) {
                trackExtendsBox = trackExtendsBox2;
            }
        }
        Iterator<Box> it = container.getBoxes().iterator();
        long size = 0;
        long j = 0;
        while (it.hasNext()) {
            Box next = it.next();
            if (next instanceof MovieFragmentBox) {
                List boxes = ((MovieFragmentBox) next).getBoxes(TrackFragmentBox.class);
                int i2 = 0;
                int i3 = 0;
                while (i3 < boxes.size()) {
                    TrackFragmentBox trackFragmentBox = (TrackFragmentBox) boxes.get(i3);
                    if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == track.getTrackMetaData().getTrackId()) {
                        List boxes2 = trackFragmentBox.getBoxes(TrackRunBox.class);
                        int i4 = i2;
                        while (i4 < boxes2.size()) {
                            LinkedList linkedList3 = new LinkedList();
                            TrackRunBox trackRunBox = (TrackRunBox) boxes2.get(i4);
                            long sampleDuration = j;
                            int i5 = i2;
                            while (i5 < trackRunBox.getEntries().size()) {
                                TrackRunBox.Entry entry = trackRunBox.getEntries().get(i5);
                                SampleFlags firstSampleFlags = (i5 == 0 && trackRunBox.isFirstSampleFlagsPresent()) ? trackRunBox.getFirstSampleFlags() : trackRunBox.isSampleFlagsPresent() ? entry.getSampleFlags() : trackExtendsBox.getDefaultSampleFlags();
                                if (firstSampleFlags == null && track.getHandler().equals("vide")) {
                                    throw new RuntimeException("Cannot find SampleFlags for video track but it's required to build tfra");
                                }
                                if (firstSampleFlags == null || firstSampleFlags.getSampleDependsOn() == 2) {
                                    i = 0;
                                    linkedList = linkedList3;
                                    linkedList.add(new TrackFragmentRandomAccessBox.Entry(sampleDuration, size, i3 + 1, i4 + 1, i5 + 1));
                                } else {
                                    linkedList = linkedList3;
                                    i = 0;
                                }
                                sampleDuration += entry.getSampleDuration();
                                i5++;
                                boxes = boxes;
                                linkedList3 = linkedList;
                                trackFragmentRandomAccessBox = trackFragmentRandomAccessBox;
                                linkedList2 = linkedList2;
                                trackExtendsBox = trackExtendsBox;
                                it = it;
                                next = next;
                                i4 = i4;
                                i3 = i3;
                                boxes2 = boxes2;
                                i2 = i;
                            }
                            if (linkedList3.size() != trackRunBox.getEntries().size() || trackRunBox.getEntries().size() <= 0) {
                                linkedList2.addAll(linkedList3);
                            } else {
                                linkedList2.add((TrackFragmentRandomAccessBox.Entry) linkedList3.get(i2));
                            }
                            i4++;
                            j = sampleDuration;
                        }
                    }
                    i3++;
                    boxes = boxes;
                    trackFragmentRandomAccessBox = trackFragmentRandomAccessBox;
                    linkedList2 = linkedList2;
                    trackExtendsBox = trackExtendsBox;
                    it = it;
                    next = next;
                    i2 = i2;
                }
            }
            size += next.getSize();
            trackFragmentRandomAccessBox = trackFragmentRandomAccessBox;
            linkedList2 = linkedList2;
            trackExtendsBox = trackExtendsBox;
            it = it;
        }
        trackFragmentRandomAccessBox.setEntries(linkedList2);
        trackFragmentRandomAccessBox.setTrackId(track.getTrackMetaData().getTrackId());
        return trackFragmentRandomAccessBox;
    }

    public Box createTkhd(Movie movie, Track track) {
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setVersion(1);
        trackHeaderBox.setFlags(7);
        trackHeaderBox.setAlternateGroup(track.getTrackMetaData().getGroup());
        trackHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        trackHeaderBox.setDuration(0L);
        trackHeaderBox.setHeight(track.getTrackMetaData().getHeight());
        trackHeaderBox.setWidth(track.getTrackMetaData().getWidth());
        trackHeaderBox.setLayer(track.getTrackMetaData().getLayer());
        trackHeaderBox.setModificationTime(getDate());
        trackHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackHeaderBox.setVolume(track.getTrackMetaData().getVolume());
        return trackHeaderBox;
    }

    public void createTraf(long j, long j2, Track track, int i, MovieFragmentBox movieFragmentBox) {
        TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
        movieFragmentBox.addBox(trackFragmentBox);
        createTfhd(j, j2, track, i, trackFragmentBox);
        createTfdt(j, track, trackFragmentBox);
        createTrun(j, j2, track, i, trackFragmentBox);
        if (track instanceof CencEncryptedTrack) {
            CencEncryptedTrack cencEncryptedTrack = (CencEncryptedTrack) track;
            createSaiz(j, j2, cencEncryptedTrack, i, trackFragmentBox);
            createSenc(j, j2, cencEncryptedTrack, i, trackFragmentBox);
            createSaio(j, j2, cencEncryptedTrack, i, trackFragmentBox);
        }
        HashMap map = new HashMap();
        for (Map.Entry<GroupEntry, long[]> entry : track.getSampleGroups().entrySet()) {
            String type = entry.getKey().getType();
            List arrayList = (List) map.get(type);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(type, arrayList);
            }
            arrayList.add(entry.getKey());
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            SampleGroupDescriptionBox sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            String str = (String) entry2.getKey();
            sampleGroupDescriptionBox.setGroupEntries((List) entry2.getValue());
            sampleGroupDescriptionBox.setGroupingType(str);
            SampleToGroupBox sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType(str);
            long j3 = 1;
            SampleToGroupBox.Entry entry3 = null;
            for (int iL2i = CastUtils.l2i(j - 1); iL2i < CastUtils.l2i(j2 - j3); iL2i++) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < ((List) entry2.getValue()).size()) {
                    Iterator it2 = it;
                    i3 = Arrays.binarySearch(track.getSampleGroups().get((GroupEntry) ((List) entry2.getValue()).get(i2)), (long) iL2i) >= 0 ? 65537 + i2 : i3;
                    i2++;
                    it = it2;
                    j3 = 1;
                }
                if (entry3 == null || entry3.getGroupDescriptionIndex() != i3) {
                    SampleToGroupBox.Entry entry4 = new SampleToGroupBox.Entry(j3, i3);
                    sampleToGroupBox.getEntries().add(entry4);
                    entry3 = entry4;
                } else {
                    entry3.setSampleCount(entry3.getSampleCount() + j3);
                }
            }
            trackFragmentBox.addBox(sampleGroupDescriptionBox);
            trackFragmentBox.addBox(sampleToGroupBox);
        }
    }

    public Box createTrak(Track track, Movie movie) {
        LOG.fine("Creating Track " + track);
        TrackBox trackBox = new TrackBox();
        trackBox.addBox(createTkhd(movie, track));
        Box boxCreateEdts = createEdts(track, movie);
        if (boxCreateEdts != null) {
            trackBox.addBox(boxCreateEdts);
        }
        trackBox.addBox(createMdia(track, movie));
        return trackBox;
    }

    public Box createTrex(Movie movie, Track track) {
        TrackExtendsBox trackExtendsBox = new TrackExtendsBox();
        trackExtendsBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackExtendsBox.setDefaultSampleDescriptionIndex(1L);
        trackExtendsBox.setDefaultSampleDuration(0L);
        trackExtendsBox.setDefaultSampleSize(0L);
        SampleFlags sampleFlags = new SampleFlags();
        if ("soun".equals(track.getHandler()) || "subt".equals(track.getHandler())) {
            sampleFlags.setSampleDependsOn(2);
            sampleFlags.setSampleIsDependedOn(2);
        }
        trackExtendsBox.setDefaultSampleFlags(sampleFlags);
        return trackExtendsBox;
    }

    public void createTrun(long j, long j2, Track track, int i, TrackFragmentBox trackFragmentBox) {
        long[] jArr;
        long j3;
        boolean z;
        TrackRunBox trackRunBox = new TrackRunBox();
        boolean z2 = true;
        trackRunBox.setVersion(1);
        long[] sampleSizes = getSampleSizes(j, j2, track, i);
        trackRunBox.setSampleDurationPresent(true);
        trackRunBox.setSampleSizePresent(true);
        ArrayList arrayList = new ArrayList(CastUtils.l2i(j2 - j));
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        CompositionTimeToSample.Entry[] entryArr = (compositionTimeEntries == null || compositionTimeEntries.size() <= 0) ? null : (CompositionTimeToSample.Entry[]) compositionTimeEntries.toArray(new CompositionTimeToSample.Entry[compositionTimeEntries.size()]);
        long count = entryArr != null ? entryArr[0].getCount() : -1;
        trackRunBox.setSampleCompositionTimeOffsetPresent(count > 0);
        int i2 = 0;
        long j4 = 1;
        while (j4 < j) {
            long[] jArr2 = sampleSizes;
            if (entryArr != null) {
                count--;
                j3 = 0;
                if (count == 0) {
                    z = true;
                    if (entryArr.length - i2 > 1) {
                        i2++;
                        count = entryArr[i2].getCount();
                    }
                }
                j4++;
                sampleSizes = jArr2;
                z2 = z;
            } else {
                j3 = 0;
            }
            z = true;
            j4++;
            sampleSizes = jArr2;
            z2 = z;
        }
        boolean z3 = ((track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) && (track.getSyncSamples() == null || track.getSyncSamples().length == 0)) ? false : z2;
        trackRunBox.setSampleFlagsPresent(z3);
        int i3 = 0;
        while (i3 < sampleSizes.length) {
            TrackRunBox.Entry entry = new TrackRunBox.Entry();
            entry.setSampleSize(sampleSizes[i3]);
            if (z3) {
                SampleFlags sampleFlags = new SampleFlags();
                if (track.getSampleDependencies() != null && !track.getSampleDependencies().isEmpty()) {
                    SampleDependencyTypeBox.Entry entry2 = track.getSampleDependencies().get(i3);
                    sampleFlags.setSampleDependsOn(entry2.getSampleDependsOn());
                    sampleFlags.setSampleIsDependedOn(entry2.getSampleIsDependentOn());
                    sampleFlags.setSampleHasRedundancy(entry2.getSampleHasRedundancy());
                }
                if (track.getSyncSamples() == null || track.getSyncSamples().length <= 0) {
                    jArr = sampleSizes;
                } else {
                    jArr = sampleSizes;
                    if (Arrays.binarySearch(track.getSyncSamples(), j + ((long) i3)) >= 0) {
                        sampleFlags.setSampleIsDifferenceSample(false);
                        sampleFlags.setSampleDependsOn(2);
                    } else {
                        sampleFlags.setSampleIsDifferenceSample(true);
                        sampleFlags.setSampleDependsOn(1);
                    }
                }
                entry.setSampleFlags(sampleFlags);
            } else {
                jArr = sampleSizes;
            }
            entry.setSampleDuration(track.getSampleDurations()[CastUtils.l2i((j + ((long) i3)) - 1)]);
            if (entryArr != null) {
                entry.setSampleCompositionTimeOffset(entryArr[i2].getOffset());
                count--;
                if (count == 0 && entryArr.length - i2 > 1) {
                    i2++;
                    count = entryArr[i2].getCount();
                }
            }
            arrayList.add(entry);
            i3++;
            sampleSizes = jArr;
        }
        trackRunBox.setEntries(arrayList);
        trackFragmentBox.addBox(trackRunBox);
    }

    public Date getDate() {
        return new Date();
    }

    public Fragmenter getFragmenter() {
        return this.fragmenter;
    }

    public long[] getSampleSizes(long j, long j2, Track track, int i) {
        List<Sample> samples = getSamples(j, j2, track);
        int size = samples.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = samples.get(i2).getSize();
        }
        return jArr;
    }

    public List<Sample> getSamples(long j, long j2, Track track) {
        return track.getSamples().subList(CastUtils.l2i(j) - 1, CastUtils.l2i(j2) - 1);
    }

    public void setFragmenter(Fragmenter fragmenter) {
        this.fragmenter = fragmenter;
    }

    public List<Track> sortTracksInSequence(List<Track> list, final int i, final Map<Track, long[]> map) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList, new Comparator<Track>() { // from class: com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder.1
            @Override // java.util.Comparator
            public int compare(Track track, Track track2) {
                long j = ((long[]) map.get(track))[i];
                long j2 = ((long[]) map.get(track2))[i];
                long[] sampleDurations = track.getSampleDurations();
                long[] sampleDurations2 = track2.getSampleDurations();
                long j3 = 0;
                for (int i2 = 1; i2 < j; i2++) {
                    j3 += sampleDurations[i2 - 1];
                }
                long j4 = 0;
                for (int i3 = 1; i3 < j2; i3++) {
                    j4 += sampleDurations2[i3 - 1];
                }
                return (int) (((j3 / track.getTrackMetaData().getTimescale()) - (j4 / track2.getTrackMetaData().getTimescale())) * 100.0d);
            }
        });
        return linkedList;
    }
}
