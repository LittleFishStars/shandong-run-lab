package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class AppendTrack extends AbstractTrack {
    private static Logger LOG = Logger.getLogger(AppendTrack.class);
    long[] decodingTimes;
    List<Sample> lists;
    SampleDescriptionBox stsd;
    Track[] tracks;

    public AppendTrack(Track... trackArr) throws IOException {
        super(appendTracknames(trackArr));
        this.tracks = trackArr;
        for (Track track : trackArr) {
            SampleDescriptionBox sampleDescriptionBox = this.stsd;
            if (sampleDescriptionBox == null) {
                SampleDescriptionBox sampleDescriptionBox2 = new SampleDescriptionBox();
                this.stsd = sampleDescriptionBox2;
                sampleDescriptionBox2.addBox((Box) track.getSampleDescriptionBox().getBoxes(SampleEntry.class).get(0));
            } else {
                this.stsd = mergeStsds(sampleDescriptionBox, track.getSampleDescriptionBox());
            }
        }
        this.lists = new ArrayList();
        for (Track track2 : trackArr) {
            this.lists.addAll(track2.getSamples());
        }
        int length = 0;
        for (Track track3 : trackArr) {
            length += track3.getSampleDurations().length;
        }
        this.decodingTimes = new long[length];
        int length2 = 0;
        for (Track track4 : trackArr) {
            long[] sampleDurations = track4.getSampleDurations();
            System.arraycopy(sampleDurations, 0, this.decodingTimes, length2, sampleDurations.length);
            length2 += sampleDurations.length;
        }
    }

    public static String appendTracknames(Track... trackArr) {
        String str = "";
        for (Track track : trackArr) {
            str = String.valueOf(str) + track.getName() + " + ";
        }
        return str.substring(0, str.length() - 3);
    }

    private AudioSampleEntry mergeAudioSampleEntries(AudioSampleEntry audioSampleEntry, AudioSampleEntry audioSampleEntry2) {
        AudioSampleEntry audioSampleEntry3 = new AudioSampleEntry(audioSampleEntry2.getType());
        if (audioSampleEntry.getBytesPerFrame() != audioSampleEntry2.getBytesPerFrame()) {
            LOG.logError("BytesPerFrame differ");
            return null;
        }
        audioSampleEntry3.setBytesPerFrame(audioSampleEntry.getBytesPerFrame());
        if (audioSampleEntry.getBytesPerPacket() == audioSampleEntry2.getBytesPerPacket()) {
            audioSampleEntry3.setBytesPerPacket(audioSampleEntry.getBytesPerPacket());
            if (audioSampleEntry.getBytesPerSample() == audioSampleEntry2.getBytesPerSample()) {
                audioSampleEntry3.setBytesPerSample(audioSampleEntry.getBytesPerSample());
                if (audioSampleEntry.getChannelCount() == audioSampleEntry2.getChannelCount()) {
                    audioSampleEntry3.setChannelCount(audioSampleEntry.getChannelCount());
                    if (audioSampleEntry.getPacketSize() == audioSampleEntry2.getPacketSize()) {
                        audioSampleEntry3.setPacketSize(audioSampleEntry.getPacketSize());
                        if (audioSampleEntry.getCompressionId() == audioSampleEntry2.getCompressionId()) {
                            audioSampleEntry3.setCompressionId(audioSampleEntry.getCompressionId());
                            if (audioSampleEntry.getSampleRate() == audioSampleEntry2.getSampleRate()) {
                                audioSampleEntry3.setSampleRate(audioSampleEntry.getSampleRate());
                                if (audioSampleEntry.getSampleSize() == audioSampleEntry2.getSampleSize()) {
                                    audioSampleEntry3.setSampleSize(audioSampleEntry.getSampleSize());
                                    if (audioSampleEntry.getSamplesPerPacket() == audioSampleEntry2.getSamplesPerPacket()) {
                                        audioSampleEntry3.setSamplesPerPacket(audioSampleEntry.getSamplesPerPacket());
                                        if (audioSampleEntry.getSoundVersion() == audioSampleEntry2.getSoundVersion()) {
                                            audioSampleEntry3.setSoundVersion(audioSampleEntry.getSoundVersion());
                                            if (Arrays.equals(audioSampleEntry.getSoundVersion2Data(), audioSampleEntry2.getSoundVersion2Data())) {
                                                audioSampleEntry3.setSoundVersion2Data(audioSampleEntry.getSoundVersion2Data());
                                                if (audioSampleEntry.getBoxes().size() == audioSampleEntry2.getBoxes().size()) {
                                                    Iterator<Box> it = audioSampleEntry2.getBoxes().iterator();
                                                    for (Box box : audioSampleEntry.getBoxes()) {
                                                        Box next = it.next();
                                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                                        try {
                                                            box.getBox(Channels.newChannel(byteArrayOutputStream));
                                                            next.getBox(Channels.newChannel(byteArrayOutputStream2));
                                                            if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                                                                audioSampleEntry3.addBox(box);
                                                            } else if (ESDescriptorBox.TYPE.equals(box.getType()) && ESDescriptorBox.TYPE.equals(next.getType())) {
                                                                ESDescriptorBox eSDescriptorBox = (ESDescriptorBox) box;
                                                                eSDescriptorBox.setDescriptor(mergeDescriptors(eSDescriptorBox.getEsDescriptor(), ((ESDescriptorBox) next).getEsDescriptor()));
                                                                audioSampleEntry3.addBox(box);
                                                            }
                                                        } catch (IOException e) {
                                                            LOG.logWarn(e.getMessage());
                                                            return null;
                                                        }
                                                    }
                                                }
                                                return audioSampleEntry3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return null;
                    }
                    LOG.logError("ChannelCount differ");
                }
                return null;
            }
            LOG.logError("BytesPerSample differ");
        }
        return null;
    }

    private ESDescriptor mergeDescriptors(BaseDescriptor baseDescriptor, BaseDescriptor baseDescriptor2) {
        if (!(baseDescriptor instanceof ESDescriptor) || !(baseDescriptor2 instanceof ESDescriptor)) {
            LOG.logError("I can only merge ESDescriptors");
            return null;
        }
        ESDescriptor eSDescriptor = (ESDescriptor) baseDescriptor;
        ESDescriptor eSDescriptor2 = (ESDescriptor) baseDescriptor2;
        if (eSDescriptor.getURLFlag() != eSDescriptor2.getURLFlag()) {
            return null;
        }
        eSDescriptor.getURLLength();
        eSDescriptor2.getURLLength();
        if (eSDescriptor.getDependsOnEsId() != eSDescriptor2.getDependsOnEsId() || eSDescriptor.getEsId() != eSDescriptor2.getEsId() || eSDescriptor.getoCREsId() != eSDescriptor2.getoCREsId() || eSDescriptor.getoCRstreamFlag() != eSDescriptor2.getoCRstreamFlag() || eSDescriptor.getRemoteODFlag() != eSDescriptor2.getRemoteODFlag() || eSDescriptor.getStreamDependenceFlag() != eSDescriptor2.getStreamDependenceFlag()) {
            return null;
        }
        eSDescriptor.getStreamPriority();
        eSDescriptor2.getStreamPriority();
        if (eSDescriptor.getURLString() != null) {
            eSDescriptor.getURLString().equals(eSDescriptor2.getURLString());
        } else {
            eSDescriptor2.getURLString();
        }
        if (eSDescriptor.getDecoderConfigDescriptor() == null ? eSDescriptor2.getDecoderConfigDescriptor() != null : !eSDescriptor.getDecoderConfigDescriptor().equals(eSDescriptor2.getDecoderConfigDescriptor())) {
            DecoderConfigDescriptor decoderConfigDescriptor = eSDescriptor.getDecoderConfigDescriptor();
            DecoderConfigDescriptor decoderConfigDescriptor2 = eSDescriptor2.getDecoderConfigDescriptor();
            if (decoderConfigDescriptor.getAudioSpecificInfo() != null && decoderConfigDescriptor2.getAudioSpecificInfo() != null && !decoderConfigDescriptor.getAudioSpecificInfo().equals(decoderConfigDescriptor2.getAudioSpecificInfo())) {
                return null;
            }
            if (decoderConfigDescriptor.getAvgBitRate() != decoderConfigDescriptor2.getAvgBitRate()) {
                decoderConfigDescriptor.setAvgBitRate((decoderConfigDescriptor.getAvgBitRate() + decoderConfigDescriptor2.getAvgBitRate()) / 2);
            }
            decoderConfigDescriptor.getBufferSizeDB();
            decoderConfigDescriptor2.getBufferSizeDB();
            if (decoderConfigDescriptor.getDecoderSpecificInfo() == null ? decoderConfigDescriptor2.getDecoderSpecificInfo() != null : !decoderConfigDescriptor.getDecoderSpecificInfo().equals(decoderConfigDescriptor2.getDecoderSpecificInfo())) {
                return null;
            }
            if (decoderConfigDescriptor.getMaxBitRate() != decoderConfigDescriptor2.getMaxBitRate()) {
                decoderConfigDescriptor.setMaxBitRate(Math.max(decoderConfigDescriptor.getMaxBitRate(), decoderConfigDescriptor2.getMaxBitRate()));
            }
            if (!decoderConfigDescriptor.getProfileLevelIndicationDescriptors().equals(decoderConfigDescriptor2.getProfileLevelIndicationDescriptors()) || decoderConfigDescriptor.getObjectTypeIndication() != decoderConfigDescriptor2.getObjectTypeIndication() || decoderConfigDescriptor.getStreamType() != decoderConfigDescriptor2.getStreamType() || decoderConfigDescriptor.getUpStream() != decoderConfigDescriptor2.getUpStream()) {
                return null;
            }
        }
        if (eSDescriptor.getOtherDescriptors() == null ? eSDescriptor2.getOtherDescriptors() != null : !eSDescriptor.getOtherDescriptors().equals(eSDescriptor2.getOtherDescriptors())) {
            return null;
        }
        if (eSDescriptor.getSlConfigDescriptor() == null ? eSDescriptor2.getSlConfigDescriptor() == null : eSDescriptor.getSlConfigDescriptor().equals(eSDescriptor2.getSlConfigDescriptor())) {
            return eSDescriptor;
        }
        return null;
    }

    private SampleEntry mergeSampleEntry(SampleEntry sampleEntry, SampleEntry sampleEntry2) {
        if (!sampleEntry.getType().equals(sampleEntry2.getType())) {
            return null;
        }
        if ((sampleEntry instanceof VisualSampleEntry) && (sampleEntry2 instanceof VisualSampleEntry)) {
            return mergeVisualSampleEntry((VisualSampleEntry) sampleEntry, (VisualSampleEntry) sampleEntry2);
        }
        if ((sampleEntry instanceof AudioSampleEntry) && (sampleEntry2 instanceof AudioSampleEntry)) {
            return mergeAudioSampleEntries((AudioSampleEntry) sampleEntry, (AudioSampleEntry) sampleEntry2);
        }
        return null;
    }

    private SampleDescriptionBox mergeStsds(SampleDescriptionBox sampleDescriptionBox, SampleDescriptionBox sampleDescriptionBox2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            sampleDescriptionBox.getBox(Channels.newChannel(byteArrayOutputStream));
            sampleDescriptionBox2.getBox(Channels.newChannel(byteArrayOutputStream2));
            if (!Arrays.equals(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream.toByteArray())) {
                SampleEntry sampleEntryMergeSampleEntry = mergeSampleEntry((SampleEntry) sampleDescriptionBox.getBoxes(SampleEntry.class).get(0), (SampleEntry) sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0));
                if (sampleEntryMergeSampleEntry == null) {
                    throw new IOException("Cannot merge " + sampleDescriptionBox.getBoxes(SampleEntry.class).get(0) + " and " + sampleDescriptionBox2.getBoxes(SampleEntry.class).get(0));
                }
                sampleDescriptionBox.setBoxes(Collections.singletonList(sampleEntryMergeSampleEntry));
            }
            return sampleDescriptionBox;
        } catch (IOException e) {
            LOG.logError(e.getMessage());
            return null;
        }
    }

    private VisualSampleEntry mergeVisualSampleEntry(VisualSampleEntry visualSampleEntry, VisualSampleEntry visualSampleEntry2) {
        VisualSampleEntry visualSampleEntry3 = new VisualSampleEntry();
        if (visualSampleEntry.getHorizresolution() != visualSampleEntry2.getHorizresolution()) {
            LOG.logError("Horizontal Resolution differs");
            return null;
        }
        visualSampleEntry3.setHorizresolution(visualSampleEntry.getHorizresolution());
        visualSampleEntry3.setCompressorname(visualSampleEntry.getCompressorname());
        if (visualSampleEntry.getDepth() != visualSampleEntry2.getDepth()) {
            LOG.logError("Depth differs");
            return null;
        }
        visualSampleEntry3.setDepth(visualSampleEntry.getDepth());
        if (visualSampleEntry.getFrameCount() != visualSampleEntry2.getFrameCount()) {
            LOG.logError("frame count differs");
            return null;
        }
        visualSampleEntry3.setFrameCount(visualSampleEntry.getFrameCount());
        if (visualSampleEntry.getHeight() != visualSampleEntry2.getHeight()) {
            LOG.logError("height differs");
            return null;
        }
        visualSampleEntry3.setHeight(visualSampleEntry.getHeight());
        if (visualSampleEntry.getWidth() != visualSampleEntry2.getWidth()) {
            LOG.logError("width differs");
            return null;
        }
        visualSampleEntry3.setWidth(visualSampleEntry.getWidth());
        if (visualSampleEntry.getVertresolution() != visualSampleEntry2.getVertresolution()) {
            LOG.logError("vert resolution differs");
            return null;
        }
        visualSampleEntry3.setVertresolution(visualSampleEntry.getVertresolution());
        if (visualSampleEntry.getHorizresolution() != visualSampleEntry2.getHorizresolution()) {
            LOG.logError("horizontal resolution differs");
            return null;
        }
        visualSampleEntry3.setHorizresolution(visualSampleEntry.getHorizresolution());
        if (visualSampleEntry.getBoxes().size() == visualSampleEntry2.getBoxes().size()) {
            Iterator<Box> it = visualSampleEntry2.getBoxes().iterator();
            for (Box box : visualSampleEntry.getBoxes()) {
                Box next = it.next();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    box.getBox(Channels.newChannel(byteArrayOutputStream));
                    next.getBox(Channels.newChannel(byteArrayOutputStream2));
                    if (Arrays.equals(byteArrayOutputStream.toByteArray(), byteArrayOutputStream2.toByteArray())) {
                        visualSampleEntry3.addBox(box);
                    } else if ((box instanceof AbstractDescriptorBox) && (next instanceof AbstractDescriptorBox)) {
                        AbstractDescriptorBox abstractDescriptorBox = (AbstractDescriptorBox) box;
                        abstractDescriptorBox.setDescriptor(mergeDescriptors(abstractDescriptorBox.getDescriptor(), ((AbstractDescriptorBox) next).getDescriptor()));
                        visualSampleEntry3.addBox(box);
                    }
                } catch (IOException e) {
                    LOG.logWarn(e.getMessage());
                    return null;
                }
            }
        }
        return visualSampleEntry3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        for (Track track : this.tracks) {
            track.close();
        }
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        if (this.tracks[0].getCompositionTimeEntries() == null || this.tracks[0].getCompositionTimeEntries().isEmpty()) {
            return null;
        }
        LinkedList<int[]> linkedList = new LinkedList();
        for (Track track : this.tracks) {
            linkedList.add(CompositionTimeToSample.blowupCompositionTimes(track.getCompositionTimeEntries()));
        }
        LinkedList linkedList2 = new LinkedList();
        for (int[] iArr : linkedList) {
            for (int i : iArr) {
                if (linkedList2.isEmpty() || ((CompositionTimeToSample.Entry) linkedList2.getLast()).getOffset() != i) {
                    linkedList2.add(new CompositionTimeToSample.Entry(1, i));
                } else {
                    CompositionTimeToSample.Entry entry = (CompositionTimeToSample.Entry) linkedList2.getLast();
                    entry.setCount(entry.getCount() + 1);
                }
            }
        }
        return linkedList2;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.tracks[0].getHandler();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        if (this.tracks[0].getSampleDependencies() == null || this.tracks[0].getSampleDependencies().isEmpty()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (Track track : this.tracks) {
            linkedList.addAll(track.getSampleDependencies());
        }
        return linkedList;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.stsd;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        return this.decodingTimes;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.lists;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.tracks[0].getSubsampleInformationBox();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        if (this.tracks[0].getSyncSamples() == null || this.tracks[0].getSyncSamples().length <= 0) {
            return null;
        }
        int length = 0;
        for (Track track : this.tracks) {
            length += track.getSyncSamples() != null ? track.getSyncSamples().length : 0;
        }
        long[] jArr = new long[length];
        long size = 0;
        int i = 0;
        for (Track track2 : this.tracks) {
            if (track2.getSyncSamples() != null) {
                long[] syncSamples = track2.getSyncSamples();
                int length2 = syncSamples.length;
                int i2 = 0;
                while (i2 < length2) {
                    jArr[i] = syncSamples[i2] + size;
                    i2++;
                    i++;
                }
            }
            size += (long) track2.getSamples().size();
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.tracks[0].getTrackMetaData();
    }
}
