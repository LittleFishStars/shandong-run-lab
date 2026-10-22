package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import java.io.Closeable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface Track extends Closeable {
    List<CompositionTimeToSample.Entry> getCompositionTimeEntries();

    long getDuration();

    List<Edit> getEdits();

    String getHandler();

    String getName();

    List<SampleDependencyTypeBox.Entry> getSampleDependencies();

    SampleDescriptionBox getSampleDescriptionBox();

    long[] getSampleDurations();

    Map<GroupEntry, long[]> getSampleGroups();

    List<Sample> getSamples();

    SubSampleInformationBox getSubsampleInformationBox();

    long[] getSyncSamples();

    TrackMetaData getTrackMetaData();
}
