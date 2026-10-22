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
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SubtitleMediaHeaderBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
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
import com.googlecode.mp4parser.util.Logger;
import com.googlecode.mp4parser.util.Math;
import com.googlecode.mp4parser.util.Mp4Arrays;
import com.googlecode.mp4parser.util.Path;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DefaultMp4Builder implements Mp4Builder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Logger LOG = Logger.getLogger(DefaultMp4Builder.class);
    private Fragmenter fragmenter;
    Map<Track, StaticChunkOffsetBox> chunkOffsetBoxes = new HashMap();
    Set<SampleAuxiliaryInformationOffsetsBox> sampleAuxiliaryInformationOffsetsBoxes = new HashSet();
    HashMap<Track, List<Sample>> track2Sample = new HashMap<>();
    HashMap<Track, long[]> track2SampleSizes = new HashMap<>();

    public static long gcd(long j, long j2) {
        return j2 == 0 ? j : gcd(j2, j % j2);
    }

    private static long sum(int[] iArr) {
        long j = 0;
        for (int i : iArr) {
            j += (long) i;
        }
        return j;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
        Box next;
        if (this.fragmenter == null) {
            this.fragmenter = new BetterFragmenter(2.0d);
        }
        LOG.logDebug("Creating movie " + movie);
        Iterator<Track> it = movie.getTracks().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Track next2 = it.next();
            List<Sample> samples = next2.getSamples();
            putSamples(next2, samples);
            int size = samples.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = samples.get(i).getSize();
            }
            this.track2SampleSizes.put(next2, jArr);
        }
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(createFileTypeBox(movie));
        HashMap map = new HashMap();
        for (Track track : movie.getTracks()) {
            map.put(track, getChunkSizes(track));
        }
        MovieBox movieBoxCreateMovieBox = createMovieBox(movie, map);
        basicContainer.addBox(movieBoxCreateMovieBox);
        Iterator it2 = Path.getPaths((Box) movieBoxCreateMovieBox, "trak/mdia/minf/stbl/stsz").iterator();
        long jSum = 0;
        while (it2.hasNext()) {
            jSum += sum(((SampleSizeBox) it2.next()).getSampleSizes());
        }
        LOG.logDebug("About to create mdat");
        InterleaveChunkMdat interleaveChunkMdat = new InterleaveChunkMdat(this, movie, map, jSum, null);
        basicContainer.addBox(interleaveChunkMdat);
        LOG.logDebug("mdat crated");
        long dataOffset = interleaveChunkMdat.getDataOffset();
        Iterator<StaticChunkOffsetBox> it3 = this.chunkOffsetBoxes.values().iterator();
        while (it3.hasNext()) {
            long[] chunkOffsets = it3.next().getChunkOffsets();
            for (int i2 = 0; i2 < chunkOffsets.length; i2++) {
                chunkOffsets[i2] = chunkOffsets[i2] + dataOffset;
            }
        }
        for (SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox : this.sampleAuxiliaryInformationOffsetsBoxes) {
            long size2 = sampleAuxiliaryInformationOffsetsBox.getSize() + 44;
            SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox2 = sampleAuxiliaryInformationOffsetsBox;
            while (true) {
                SampleAuxiliaryInformationOffsetsBox parent = ((Box) sampleAuxiliaryInformationOffsetsBox2).getParent();
                Iterator<Box> it4 = parent.getBoxes().iterator();
                while (it4.hasNext() && (next = it4.next()) != sampleAuxiliaryInformationOffsetsBox2) {
                    size2 += next.getSize();
                }
                if (!(parent instanceof Box)) {
                    break;
                }
                sampleAuxiliaryInformationOffsetsBox2 = parent;
            }
            long[] offsets = sampleAuxiliaryInformationOffsetsBox.getOffsets();
            for (int i3 = 0; i3 < offsets.length; i3++) {
                offsets[i3] = offsets[i3] + size2;
            }
            sampleAuxiliaryInformationOffsetsBox.setOffsets(offsets);
        }
        return basicContainer;
    }

    public void createCencBoxes(CencEncryptedTrack cencEncryptedTrack, SampleTableBox sampleTableBox, int[] iArr) {
        SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = new SampleAuxiliaryInformationSizesBox();
        sampleAuxiliaryInformationSizesBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationSizesBox.setFlags(1);
        List<CencSampleAuxiliaryDataFormat> sampleEncryptionEntries = cencEncryptedTrack.getSampleEncryptionEntries();
        if (cencEncryptedTrack.hasSubSampleEncryption()) {
            int size = sampleEncryptionEntries.size();
            short[] sArr = new short[size];
            for (int i = 0; i < size; i++) {
                sArr[i] = (short) sampleEncryptionEntries.get(i).getSize();
            }
            sampleAuxiliaryInformationSizesBox.setSampleInfoSizes(sArr);
        } else {
            sampleAuxiliaryInformationSizesBox.setDefaultSampleInfoSize(8);
            sampleAuxiliaryInformationSizesBox.setSampleCount(cencEncryptedTrack.getSamples().size());
        }
        Box sampleAuxiliaryInformationOffsetsBox = new SampleAuxiliaryInformationOffsetsBox();
        SampleEncryptionBox sampleEncryptionBox = new SampleEncryptionBox();
        sampleEncryptionBox.setSubSampleEncryption(cencEncryptedTrack.hasSubSampleEncryption());
        sampleEncryptionBox.setEntries(sampleEncryptionEntries);
        long offsetToFirstIV = sampleEncryptionBox.getOffsetToFirstIV();
        long[] jArr = new long[iArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            jArr[i3] = offsetToFirstIV;
            int i4 = 0;
            while (i4 < iArr[i3]) {
                offsetToFirstIV += (long) sampleEncryptionEntries.get(i2).getSize();
                i4++;
                i2++;
                sampleEncryptionBox = sampleEncryptionBox;
            }
        }
        sampleAuxiliaryInformationOffsetsBox.setOffsets(jArr);
        sampleTableBox.addBox(sampleAuxiliaryInformationSizesBox);
        sampleTableBox.addBox(sampleAuxiliaryInformationOffsetsBox);
        sampleTableBox.addBox(sampleEncryptionBox);
        this.sampleAuxiliaryInformationOffsetsBoxes.add(sampleAuxiliaryInformationOffsetsBox);
    }

    public void createCtts(Track track, SampleTableBox sampleTableBox) {
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        if (compositionTimeEntries == null || compositionTimeEntries.isEmpty()) {
            return;
        }
        CompositionTimeToSample compositionTimeToSample = new CompositionTimeToSample();
        compositionTimeToSample.setEntries(compositionTimeEntries);
        sampleTableBox.addBox(compositionTimeToSample);
    }

    public Box createEdts(Track track, Movie movie) {
        if (track.getEdits() == null || track.getEdits().size() <= 0) {
            return null;
        }
        EditListBox editListBox = new EditListBox();
        editListBox.setVersion(0);
        ArrayList arrayList = new ArrayList();
        for (Edit edit : track.getEdits()) {
            arrayList.add(new EditListBox.Entry(editListBox, Math.round(edit.getSegmentDuration() * movie.getTimescale()), (edit.getMediaTime() * track.getTrackMetaData().getTimescale()) / edit.getTimeScale(), edit.getMediaRate()));
        }
        editListBox.setEntries(arrayList);
        EditBox editBox = new EditBox();
        editBox.addBox(editListBox);
        return editBox;
    }

    public FileTypeBox createFileTypeBox(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("mp42");
        linkedList.add("iso6");
        linkedList.add("avc1");
        linkedList.add("isom");
        return new FileTypeBox("iso6", 1L, linkedList);
    }

    public MovieBox createMovieBox(Movie movie, Map<Track, int[]> map) {
        long duration;
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(movie.getMatrix());
        long timescale = getTimescale(movie);
        long j = 0;
        for (Track track : movie.getTracks()) {
            if (track.getEdits() == null || track.getEdits().isEmpty()) {
                duration = (track.getDuration() * timescale) / track.getTrackMetaData().getTimescale();
            } else {
                Iterator<Edit> it = track.getEdits().iterator();
                double segmentDuration = AudioStats.AUDIO_AMPLITUDE_NONE;
                while (it.hasNext()) {
                    segmentDuration += (long) it.next().getSegmentDuration();
                }
                duration = (long) (segmentDuration * timescale);
            }
            if (duration > j) {
                j = duration;
            }
        }
        movieHeaderBox.setDuration(j);
        movieHeaderBox.setTimescale(timescale);
        long trackId = 0;
        for (Track track2 : movie.getTracks()) {
            if (trackId < track2.getTrackMetaData().getTrackId()) {
                trackId = track2.getTrackMetaData().getTrackId();
            }
        }
        movieHeaderBox.setNextTrackId(trackId + 1);
        movieBox.addBox(movieHeaderBox);
        Iterator<Track> it2 = movie.getTracks().iterator();
        while (it2.hasNext()) {
            movieBox.addBox(createTrackBox(it2.next(), movie, map));
        }
        Box boxCreateUdta = createUdta(movie);
        if (boxCreateUdta != null) {
            movieBox.addBox(boxCreateUdta);
        }
        return movieBox;
    }

    public void createSdtp(Track track, SampleTableBox sampleTableBox) {
        if (track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) {
            return;
        }
        SampleDependencyTypeBox sampleDependencyTypeBox = new SampleDependencyTypeBox();
        sampleDependencyTypeBox.setEntries(track.getSampleDependencies());
        sampleTableBox.addBox(sampleDependencyTypeBox);
    }

    public Box createStbl(Track track, Movie movie, Map<Track, int[]> map) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        createStsd(track, sampleTableBox);
        createStts(track, sampleTableBox);
        createCtts(track, sampleTableBox);
        createStss(track, sampleTableBox);
        createSdtp(track, sampleTableBox);
        createStsc(track, map, sampleTableBox);
        createStsz(track, sampleTableBox);
        createStco(track, movie, map, sampleTableBox);
        HashMap map2 = new HashMap();
        for (Map.Entry<GroupEntry, long[]> entry : track.getSampleGroups().entrySet()) {
            String type = entry.getKey().getType();
            List arrayList = (List) map2.get(type);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map2.put(type, arrayList);
            }
            arrayList.add(entry.getKey());
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            SampleGroupDescriptionBox sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            String str = (String) entry2.getKey();
            sampleGroupDescriptionBox.setGroupingType(str);
            sampleGroupDescriptionBox.setGroupEntries((List) entry2.getValue());
            SampleToGroupBox sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType(str);
            SampleToGroupBox.Entry entry3 = null;
            for (int i = 0; i < track.getSamples().size(); i++) {
                int i2 = 0;
                for (int i3 = 0; i3 < ((List) entry2.getValue()).size(); i3++) {
                    if (Arrays.binarySearch(track.getSampleGroups().get((GroupEntry) ((List) entry2.getValue()).get(i3)), i) >= 0) {
                        i2 = i3 + 1;
                    }
                }
                if (entry3 == null || entry3.getGroupDescriptionIndex() != i2) {
                    SampleToGroupBox.Entry entry4 = new SampleToGroupBox.Entry(1L, i2);
                    sampleToGroupBox.getEntries().add(entry4);
                    entry3 = entry4;
                } else {
                    entry3.setSampleCount(entry3.getSampleCount() + 1);
                }
            }
            sampleTableBox.addBox(sampleGroupDescriptionBox);
            sampleTableBox.addBox(sampleToGroupBox);
        }
        if (track instanceof CencEncryptedTrack) {
            createCencBoxes((CencEncryptedTrack) track, sampleTableBox, map.get(track));
        }
        createSubs(track, sampleTableBox);
        LOG.logDebug("done with stbl for track_" + track.getTrackMetaData().getTrackId());
        return sampleTableBox;
    }

    public void createStco(Track track, Movie movie, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        char c;
        int i;
        if (this.chunkOffsetBoxes.get(track) == null) {
            LOG.logDebug("Calculating chunk offsets for track_" + track.getTrackMetaData().getTrackId());
            ArrayList<Track> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList, new Comparator<Track>() { // from class: com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder.1
                @Override // java.util.Comparator
                public int compare(Track track2, Track track3) {
                    return CastUtils.l2i(track2.getTrackMetaData().getTrackId() - track3.getTrackMetaData().getTrackId());
                }
            });
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            Iterator it = arrayList.iterator();
            while (true) {
                c = 0;
                if (!it.hasNext()) {
                    break;
                }
                Track track2 = (Track) it.next();
                map2.put(track2, 0);
                map3.put(track2, 0);
                map4.put(track2, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
                this.chunkOffsetBoxes.put(track2, new StaticChunkOffsetBox());
            }
            long j = 0;
            while (true) {
                Track track3 = null;
                for (Track track4 : arrayList) {
                    if ((track3 == null || ((Double) map4.get(track4)).doubleValue() < ((Double) map4.get(track3)).doubleValue()) && ((Integer) map2.get(track4)).intValue() < map.get(track4).length) {
                        track3 = track4;
                    }
                    c = 0;
                }
                if (track3 == null) {
                    break;
                }
                StaticChunkOffsetBox staticChunkOffsetBox = this.chunkOffsetBoxes.get(track3);
                long[] chunkOffsets = staticChunkOffsetBox.getChunkOffsets();
                long[] jArr = new long[1];
                jArr[c] = j;
                staticChunkOffsetBox.setChunkOffsets(Mp4Arrays.copyOfAndAppend(chunkOffsets, jArr));
                int iIntValue = ((Integer) map2.get(track3)).intValue();
                int i2 = map.get(track3)[iIntValue];
                int iIntValue2 = ((Integer) map3.get(track3)).intValue();
                double dDoubleValue = ((Double) map4.get(track3)).doubleValue();
                long[] sampleDurations = track3.getSampleDurations();
                int i3 = iIntValue2;
                while (true) {
                    i = iIntValue2 + i2;
                    if (i3 >= i) {
                        break;
                    }
                    long j2 = j + this.track2SampleSizes.get(track3)[i3];
                    dDoubleValue += sampleDurations[i3] / track3.getTrackMetaData().getTimescale();
                    i3++;
                    j = j2;
                    iIntValue = iIntValue;
                }
                map2.put(track3, Integer.valueOf(iIntValue + 1));
                map3.put(track3, Integer.valueOf(i));
                map4.put(track3, Double.valueOf(dDoubleValue));
                c = 0;
            }
        }
        sampleTableBox.addBox(this.chunkOffsetBoxes.get(track));
    }

    public void createStsc(Track track, Map<Track, int[]> map, SampleTableBox sampleTableBox) {
        int[] iArr = map.get(track);
        SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
        sampleToChunkBox.setEntries(new LinkedList());
        long j = -2147483648L;
        for (int i = 0; i < iArr.length; i++) {
            if (j != iArr[i]) {
                sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry(i + 1, iArr[i], 1L));
                j = iArr[i];
            }
        }
        sampleTableBox.addBox(sampleToChunkBox);
    }

    public void createStsd(Track track, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(track.getSampleDescriptionBox());
    }

    public void createStss(Track track, SampleTableBox sampleTableBox) {
        long[] syncSamples = track.getSyncSamples();
        if (syncSamples == null || syncSamples.length <= 0) {
            return;
        }
        SyncSampleBox syncSampleBox = new SyncSampleBox();
        syncSampleBox.setSampleNumber(syncSamples);
        sampleTableBox.addBox(syncSampleBox);
    }

    public void createStsz(Track track, SampleTableBox sampleTableBox) {
        SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes(this.track2SampleSizes.get(track));
        sampleTableBox.addBox(sampleSizeBox);
    }

    public void createStts(Track track, SampleTableBox sampleTableBox) {
        ArrayList arrayList = new ArrayList();
        TimeToSampleBox.Entry entry = null;
        for (long j : track.getSampleDurations()) {
            if (entry == null || entry.getDelta() != j) {
                entry = new TimeToSampleBox.Entry(1L, j);
                arrayList.add(entry);
            } else {
                entry.setCount(entry.getCount() + 1);
            }
        }
        TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
        timeToSampleBox.setEntries(arrayList);
        sampleTableBox.addBox(timeToSampleBox);
    }

    public void createSubs(Track track, SampleTableBox sampleTableBox) {
        if (track.getSubsampleInformationBox() != null) {
            sampleTableBox.addBox(track.getSubsampleInformationBox());
        }
    }

    public TrackBox createTrackBox(Track track, Movie movie, Map<Track, int[]> map) {
        TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setEnabled(true);
        trackHeaderBox.setInMovie(true);
        trackHeaderBox.setMatrix(track.getTrackMetaData().getMatrix());
        trackHeaderBox.setAlternateGroup(track.getTrackMetaData().getGroup());
        trackHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        if (track.getEdits() == null || track.getEdits().isEmpty()) {
            trackHeaderBox.setDuration((track.getDuration() * getTimescale(movie)) / track.getTrackMetaData().getTimescale());
        } else {
            Iterator<Edit> it = track.getEdits().iterator();
            long segmentDuration = 0;
            while (it.hasNext()) {
                segmentDuration += (long) it.next().getSegmentDuration();
            }
            trackHeaderBox.setDuration(segmentDuration * track.getTrackMetaData().getTimescale());
        }
        trackHeaderBox.setHeight(track.getTrackMetaData().getHeight());
        trackHeaderBox.setWidth(track.getTrackMetaData().getWidth());
        trackHeaderBox.setLayer(track.getTrackMetaData().getLayer());
        trackHeaderBox.setModificationTime(new Date());
        trackHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackHeaderBox.setVolume(track.getTrackMetaData().getVolume());
        trackBox.addBox(trackHeaderBox);
        trackBox.addBox(createEdts(track, movie));
        MediaBox mediaBox = new MediaBox();
        trackBox.addBox(mediaBox);
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        mediaHeaderBox.setDuration(track.getDuration());
        mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
        mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
        mediaBox.addBox(mediaHeaderBox);
        HandlerBox handlerBox = new HandlerBox();
        mediaBox.addBox(handlerBox);
        handlerBox.setHandlerType(track.getHandler());
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
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        mediaInformationBox.addBox(createStbl(track, movie, map));
        mediaBox.addBox(mediaInformationBox);
        LOG.logDebug("done with trak for track_" + track.getTrackMetaData().getTrackId());
        return trackBox;
    }

    public Box createUdta(Movie movie) {
        return null;
    }

    public int[] getChunkSizes(Track track) {
        long[] jArrSampleNumbers = this.fragmenter.sampleNumbers(track);
        int[] iArr = new int[jArrSampleNumbers.length];
        int i = 0;
        while (i < jArrSampleNumbers.length) {
            int i2 = i + 1;
            iArr[i] = CastUtils.l2i((jArrSampleNumbers.length == i2 ? track.getSamples().size() : jArrSampleNumbers[i2] - 1) - (jArrSampleNumbers[i] - 1));
            i = i2;
        }
        return iArr;
    }

    public long getTimescale(Movie movie) {
        long timescale = movie.getTracks().iterator().next().getTrackMetaData().getTimescale();
        Iterator<Track> it = movie.getTracks().iterator();
        while (it.hasNext()) {
            timescale = Math.lcm(timescale, it.next().getTrackMetaData().getTimescale());
        }
        return timescale;
    }

    public List<Sample> putSamples(Track track, List<Sample> list) {
        return this.track2Sample.put(track, list);
    }

    public void setFragmenter(Fragmenter fragmenter) {
        this.fragmenter = fragmenter;
    }

    private static long sum(long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    public class InterleaveChunkMdat implements Box {
        List<List<Sample>> chunkList;
        long contentSize;
        Container parent;
        List<Track> tracks;

        private InterleaveChunkMdat(Movie movie, Map<Track, int[]> map, long j) {
            int i;
            this.chunkList = new ArrayList();
            this.contentSize = j;
            this.tracks = movie.getTracks();
            ArrayList<Track> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList, new Comparator<Track>() { // from class: com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder.InterleaveChunkMdat.1
                @Override // java.util.Comparator
                public int compare(Track track, Track track2) {
                    return CastUtils.l2i(track.getTrackMetaData().getTrackId() - track2.getTrackMetaData().getTrackId());
                }
            });
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            for (Track track : arrayList) {
                map2.put(track, 0);
                map3.put(track, 0);
                map4.put(track, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
            }
            while (true) {
                Track track2 = null;
                for (Track track3 : arrayList) {
                    if (track2 == null || ((Double) map4.get(track3)).doubleValue() < ((Double) map4.get(track2)).doubleValue()) {
                        if (((Integer) map2.get(track3)).intValue() < map.get(track3).length) {
                            track2 = track3;
                        }
                    }
                }
                if (track2 == null) {
                    return;
                }
                int iIntValue = ((Integer) map2.get(track2)).intValue();
                int i2 = map.get(track2)[iIntValue];
                int iIntValue2 = ((Integer) map3.get(track2)).intValue();
                double dDoubleValue = ((Double) map4.get(track2)).doubleValue();
                int i3 = iIntValue2;
                while (true) {
                    i = iIntValue2 + i2;
                    if (i3 >= i) {
                        break;
                    }
                    dDoubleValue += track2.getSampleDurations()[i3] / track2.getTrackMetaData().getTimescale();
                    i3++;
                    i2 = i2;
                    iIntValue = iIntValue;
                }
                this.chunkList.add(track2.getSamples().subList(iIntValue2, i));
                map2.put(track2, Integer.valueOf(iIntValue + 1));
                map3.put(track2, Integer.valueOf(i));
                map4.put(track2, Double.valueOf(dDoubleValue));
            }
        }

        private boolean isSmallBox(long j) {
            return j + 8 < 4294967296L;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long size = getSize();
            if (isSmallBox(size)) {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, size);
            } else {
                IsoTypeWriter.writeUInt32(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(IsoFile.fourCCtoBytes(MediaDataBox.TYPE));
            if (isSmallBox(size)) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                IsoTypeWriter.writeUInt64(byteBufferAllocate, size);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
            DefaultMp4Builder.LOG.logDebug("About to write " + this.contentSize);
            Iterator<List<Sample>> it = this.chunkList.iterator();
            long size2 = 0;
            long j = 0;
            while (it.hasNext()) {
                for (Sample sample : it.next()) {
                    sample.writeTo(writableByteChannel);
                    size2 += sample.getSize();
                    if (size2 > 1048576) {
                        size2 -= 1048576;
                        j++;
                        DefaultMp4Builder.LOG.logDebug("Written " + j + "MB");
                    }
                }
            }
        }

        public long getDataOffset() {
            Box next;
            long size = 16;
            Object parent = this;
            while (parent instanceof Box) {
                Box box = (Box) parent;
                Iterator<Box> it = box.getParent().getBoxes().iterator();
                while (it.hasNext() && parent != (next = it.next())) {
                    size += next.getSize();
                }
                parent = box.getParent();
            }
            return size;
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
            return this.contentSize + 16;
        }

        @Override // com.coremedia.iso.boxes.Box
        public String getType() {
            return MediaDataBox.TYPE;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container container) {
            this.parent = container;
        }

        public /* synthetic */ InterleaveChunkMdat(DefaultMp4Builder defaultMp4Builder, Movie movie, Map map, long j, InterleaveChunkMdat interleaveChunkMdat) {
            this(movie, map, j);
        }
    }
}
