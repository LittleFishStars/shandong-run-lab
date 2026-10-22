package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CroppedTrack extends AbstractTrack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int fromSample;
    Track origTrack;
    private int toSample;

    public CroppedTrack(Track track, long j, long j2) {
        super("crop(" + track.getName() + ")");
        this.origTrack = track;
        this.fromSample = (int) j;
        this.toSample = (int) j2;
    }

    public static List<TimeToSampleBox.Entry> getDecodingTimeEntries(List<TimeToSampleBox.Entry> list, long j, long j2) {
        TimeToSampleBox.Entry next;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ListIterator<TimeToSampleBox.Entry> listIterator = list.listIterator();
        LinkedList linkedList = new LinkedList();
        long count = 0;
        while (true) {
            next = listIterator.next();
            if (next.getCount() + count > j) {
                break;
            }
            count += next.getCount();
        }
        if (next.getCount() + count >= j2) {
            linkedList.add(new TimeToSampleBox.Entry(j2 - j, next.getDelta()));
            return linkedList;
        }
        linkedList.add(new TimeToSampleBox.Entry((next.getCount() + count) - j, next.getDelta()));
        long count2 = next.getCount();
        while (true) {
            count += count2;
            if (!listIterator.hasNext()) {
                break;
            }
            next = listIterator.next();
            if (next.getCount() + count >= j2) {
                break;
            }
            linkedList.add(next);
            count2 = next.getCount();
        }
        linkedList.add(new TimeToSampleBox.Entry(j2 - count, next.getDelta()));
        return linkedList;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.origTrack.close();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return getCompositionTimeEntries(this.origTrack.getCompositionTimeEntries(), this.fromSample, this.toSample);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.origTrack.getHandler();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        if (this.origTrack.getSampleDependencies() == null || this.origTrack.getSampleDependencies().isEmpty()) {
            return null;
        }
        return this.origTrack.getSampleDependencies().subList(this.fromSample, this.toSample);
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.origTrack.getSampleDescriptionBox();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        long[] jArr;
        int i = this.toSample - this.fromSample;
        jArr = new long[i];
        System.arraycopy(this.origTrack.getSampleDurations(), this.fromSample, jArr, 0, i);
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.origTrack.getSamples().subList(this.fromSample, this.toSample);
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.origTrack.getSubsampleInformationBox();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSyncSamples() {
        if (this.origTrack.getSyncSamples() == null) {
            return null;
        }
        long[] syncSamples = this.origTrack.getSyncSamples();
        int length = syncSamples.length;
        int i = 0;
        while (i < syncSamples.length && syncSamples[i] < this.fromSample) {
            i++;
        }
        while (length > 0 && this.toSample < syncSamples[length - 1]) {
            length--;
        }
        int i2 = length - i;
        long[] jArr = new long[i2];
        System.arraycopy(this.origTrack.getSyncSamples(), i, jArr, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = jArr[i3] - ((long) this.fromSample);
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.origTrack.getTrackMetaData();
    }

    public static List<CompositionTimeToSample.Entry> getCompositionTimeEntries(List<CompositionTimeToSample.Entry> list, long j, long j2) {
        CompositionTimeToSample.Entry next;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ListIterator<CompositionTimeToSample.Entry> listIterator = list.listIterator();
        ArrayList arrayList = new ArrayList();
        long count = 0;
        while (true) {
            next = listIterator.next();
            if (((long) next.getCount()) + count > j) {
                break;
            }
            count += (long) next.getCount();
        }
        if (((long) next.getCount()) + count >= j2) {
            arrayList.add(new CompositionTimeToSample.Entry((int) (j2 - j), next.getOffset()));
            return arrayList;
        }
        arrayList.add(new CompositionTimeToSample.Entry((int) ((((long) next.getCount()) + count) - j), next.getOffset()));
        int count2 = next.getCount();
        while (true) {
            count += (long) count2;
            if (!listIterator.hasNext()) {
                break;
            }
            next = listIterator.next();
            if (((long) next.getCount()) + count >= j2) {
                break;
            }
            arrayList.add(next);
            count2 = next.getCount();
        }
        arrayList.add(new CompositionTimeToSample.Entry((int) (j2 - count), next.getOffset()));
        return arrayList;
    }
}
