package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.Math;
import com.googlecode.mp4parser.util.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SyncSampleIntersectFinderImpl implements Fragmenter {
    private static Logger LOG = Logger.getLogger(SyncSampleIntersectFinderImpl.class.getName());
    private final int minFragmentDurationSeconds;
    private Movie movie;
    private Track referenceTrack;

    public SyncSampleIntersectFinderImpl(Movie movie, Track track, int i) {
        this.movie = movie;
        this.referenceTrack = track;
        this.minFragmentDurationSeconds = i;
    }

    private static long calculateTracktimesScalingFactor(Movie movie, Track track) {
        long jLcm = 1;
        for (Track track2 : movie.getTracks()) {
            if (track2.getHandler().equals(track.getHandler()) && track2.getTrackMetaData().getTimescale() != track.getTrackMetaData().getTimescale()) {
                jLcm = Math.lcm(jLcm, track2.getTrackMetaData().getTimescale());
            }
        }
        return jLcm;
    }

    public static String getFormat(Track track) {
        SampleDescriptionBox sampleDescriptionBox = track.getSampleDescriptionBox();
        OriginalFormatBox originalFormatBox = (OriginalFormatBox) Path.getPath((AbstractContainerBox) sampleDescriptionBox, "enc./sinf/frma");
        return originalFormatBox != null ? originalFormatBox.getDataFormat() : sampleDescriptionBox.getSampleEntry().getType();
    }

    public static List<long[]> getSyncSamplesTimestamps(Movie movie, Track track) {
        long[] syncSamples;
        LinkedList linkedList = new LinkedList();
        for (Track track2 : movie.getTracks()) {
            if (track2.getHandler().equals(track.getHandler()) && (syncSamples = track2.getSyncSamples()) != null && syncSamples.length > 0) {
                linkedList.add(getTimes(track2, movie));
            }
        }
        return linkedList;
    }

    private static long[] getTimes(Track track, Movie movie) {
        long[] syncSamples = track.getSyncSamples();
        long[] jArr = new long[syncSamples.length];
        long jCalculateTracktimesScalingFactor = calculateTracktimesScalingFactor(movie, track);
        long j = 0;
        int i = 0;
        int i2 = 1;
        while (true) {
            long j2 = i2;
            if (j2 > syncSamples[syncSamples.length - 1]) {
                return jArr;
            }
            if (j2 == syncSamples[i]) {
                jArr[i] = j * jCalculateTracktimesScalingFactor;
                i++;
            }
            j += track.getSampleDurations()[i2 - 1];
            i2++;
        }
    }

    public long[] getCommonIndices(long[] jArr, long[] jArr2, long j, long[]... jArr3) {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (int i = 0; i < jArr2.length; i++) {
            boolean z = true;
            for (long[] jArr4 : jArr3) {
                z &= Arrays.binarySearch(jArr4, jArr2[i]) >= 0;
            }
            if (z) {
                linkedList2.add(Long.valueOf(jArr[i]));
                linkedList3.add(Long.valueOf(jArr2[i]));
            }
        }
        if (linkedList2.size() < ((double) jArr.length) * 0.25d) {
            String str = "" + String.format("%5d - Common:  [", Integer.valueOf(linkedList2.size()));
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                str = String.valueOf(str) + String.format("%10d,", Long.valueOf(((Long) it.next()).longValue()));
            }
            LOG.warning(String.valueOf(str) + "]");
            String str2 = "" + String.format("%5d - In    :  [", Integer.valueOf(jArr.length));
            for (long j2 : jArr) {
                str2 = String.valueOf(str2) + String.format("%10d,", Long.valueOf(j2));
            }
            LOG.warning(String.valueOf(str2) + "]");
            LOG.warning("There are less than 25% of common sync samples in the given track.");
            throw new RuntimeException("There are less than 25% of common sync samples in the given track.");
        }
        if (linkedList2.size() < ((double) jArr.length) * 0.5d) {
            LOG.fine("There are less than 50% of common sync samples in the given track. This is implausible but I'm ok to continue.");
        } else if (linkedList2.size() < jArr.length) {
            LOG.finest("Common SyncSample positions vs. this tracks SyncSample positions: " + linkedList2.size() + " vs. " + jArr.length);
        }
        LinkedList linkedList4 = new LinkedList();
        if (this.minFragmentDurationSeconds > 0) {
            Iterator it2 = linkedList2.iterator();
            Iterator it3 = linkedList3.iterator();
            long j3 = -1;
            long j4 = -1;
            while (it2.hasNext() && it3.hasNext()) {
                long jLongValue = ((Long) it2.next()).longValue();
                long jLongValue2 = ((Long) it3.next()).longValue();
                if (j4 == j3 || (jLongValue2 - j4) / j >= this.minFragmentDurationSeconds) {
                    linkedList4.add(Long.valueOf(jLongValue));
                    j4 = jLongValue2;
                }
                j3 = -1;
            }
            linkedList = linkedList4;
        } else {
            linkedList = linkedList2;
        }
        int size = linkedList.size();
        long[] jArr5 = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr5[i2] = ((Long) linkedList.get(i2)).longValue();
        }
        return jArr5;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Fragmenter
    public long[] sampleNumbers(Track track) {
        long sampleRate;
        if ("vide".equals(track.getHandler())) {
            if (track.getSyncSamples() == null || track.getSyncSamples().length <= 0) {
                throw new RuntimeException("Video Tracks need sync samples. Only tracks other than video may have no sync samples.");
            }
            List<long[]> syncSamplesTimestamps = getSyncSamplesTimestamps(this.movie, track);
            return getCommonIndices(track.getSyncSamples(), getTimes(track, this.movie), track.getTrackMetaData().getTimescale(), (long[][]) syncSamplesTimestamps.toArray(new long[syncSamplesTimestamps.size()][]));
        }
        int i = 0;
        if (!"soun".equals(track.getHandler())) {
            for (Track track2 : this.movie.getTracks()) {
                if (track2.getSyncSamples() != null && track2.getSyncSamples().length > 0) {
                    long[] jArrSampleNumbers = sampleNumbers(track2);
                    int size = track2.getSamples().size();
                    int length = jArrSampleNumbers.length;
                    long[] jArr = new long[length];
                    double size2 = ((double) track.getSamples().size()) / ((double) size);
                    for (int i2 = 0; i2 < length; i2++) {
                        jArr[i2] = ((long) Math.ceil((jArrSampleNumbers[i2] - 1) * size2)) + 1;
                    }
                    return jArr;
                }
            }
            throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
        }
        if (this.referenceTrack == null) {
            for (Track track3 : this.movie.getTracks()) {
                if (track3.getSyncSamples() != null && "vide".equals(track3.getHandler()) && track3.getSyncSamples().length > 0) {
                    this.referenceTrack = track3;
                }
            }
        }
        Track track4 = this.referenceTrack;
        if (track4 == null) {
            throw new RuntimeException("There was absolutely no Track with sync samples. I can't work with that!");
        }
        long[] jArrSampleNumbers2 = sampleNumbers(track4);
        int size3 = this.referenceTrack.getSamples().size();
        int length2 = jArrSampleNumbers2.length;
        long[] jArr2 = new long[length2];
        Iterator<Track> it = this.movie.getTracks().iterator();
        while (true) {
            sampleRate = 192000;
            if (!it.hasNext()) {
                break;
            }
            Track next = it.next();
            if (getFormat(track).equals(getFormat(next))) {
                AudioSampleEntry audioSampleEntry = (AudioSampleEntry) next.getSampleDescriptionBox().getSampleEntry();
                if (audioSampleEntry.getSampleRate() < 192000) {
                    sampleRate = audioSampleEntry.getSampleRate();
                    double size4 = ((double) next.getSamples().size()) / ((double) size3);
                    long j = next.getSampleDurations()[0];
                    int i3 = 0;
                    while (i3 < length2) {
                        jArr2[i3] = (long) Math.ceil((jArrSampleNumbers2[i3] - 1) * size4 * j);
                        i3++;
                        length2 = length2;
                        i = 0;
                    }
                    break;
                }
            }
        }
        AudioSampleEntry audioSampleEntry2 = (AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry();
        long j2 = track.getSampleDurations()[i];
        double sampleRate2 = audioSampleEntry2.getSampleRate() / sampleRate;
        if (sampleRate2 != Math.rint(sampleRate2)) {
            throw new RuntimeException("Sample rates must be a multiple of the lowest sample rate to create a correct file!");
        }
        while (i < length2) {
            jArr2[i] = (long) (((jArr2[i] * sampleRate2) / j2) + 1.0d);
            i++;
        }
        return jArr2;
    }
}
