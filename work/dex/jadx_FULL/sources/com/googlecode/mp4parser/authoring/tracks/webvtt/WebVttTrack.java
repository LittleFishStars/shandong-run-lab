package com.googlecode.mp4parser.authoring.tracks.webvtt;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CuePayloadBox;
import com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSettingsBox;
import com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.VTTCueBox;
import com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.VTTEmptyCueBox;
import com.googlecode.mp4parser.util.ByteBufferByteChannel;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Mp4Arrays;
import com.mp4parser.iso14496.part30.WebVTTConfigurationBox;
import com.mp4parser.iso14496.part30.WebVTTSampleEntry;
import com.mp4parser.iso14496.part30.WebVTTSourceLabelBox;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class WebVttTrack extends AbstractTrack {
    long[] sampleDurations;
    WebVTTSampleEntry sampleEntry;
    List<Sample> samples;
    SampleDescriptionBox stsd;
    TrackMetaData trackMetaData;
    private static final String WEBVTT_FILE_HEADER_STRING = "^\ufeff?WEBVTT((\\u0020|\t).*)?$";
    private static final Pattern WEBVTT_FILE_HEADER = Pattern.compile(WEBVTT_FILE_HEADER_STRING);
    private static final String WEBVTT_METADATA_HEADER_STRING = "\\S*[:=]\\S*";
    private static final Pattern WEBVTT_METADATA_HEADER = Pattern.compile(WEBVTT_METADATA_HEADER_STRING);
    private static final String WEBVTT_CUE_IDENTIFIER_STRING = "^(?!.*(-->)).*$";
    private static final Pattern WEBVTT_CUE_IDENTIFIER = Pattern.compile(WEBVTT_CUE_IDENTIFIER_STRING);
    private static final String WEBVTT_TIMESTAMP_STRING = "(\\d+:)?[0-5]\\d:[0-5]\\d\\.\\d{3}";
    private static final Pattern WEBVTT_TIMESTAMP = Pattern.compile(WEBVTT_TIMESTAMP_STRING);
    private static final String WEBVTT_CUE_SETTING_STRING = "\\S*:\\S*";
    private static final Pattern WEBVTT_CUE_SETTING = Pattern.compile(WEBVTT_CUE_SETTING_STRING);
    private static final Sample EMPTY_SAMPLE = new Sample() { // from class: com.googlecode.mp4parser.authoring.tracks.webvtt.WebVttTrack.1
        ByteBuffer vtte;

        {
            VTTEmptyCueBox vTTEmptyCueBox = new VTTEmptyCueBox();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(CastUtils.l2i(vTTEmptyCueBox.getSize()));
            this.vtte = byteBufferAllocate;
            try {
                vTTEmptyCueBox.getBox(new ByteBufferByteChannel(byteBufferAllocate));
                this.vtte.rewind();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            return this.vtte.duplicate();
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.vtte.remaining();
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(this.vtte.duplicate());
        }
    };

    public static class BoxBearingSample implements Sample {
        List<Box> boxes;

        public BoxBearingSample(List<Box> list) {
            this.boxes = list;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                writeTo(Channels.newChannel(byteArrayOutputStream));
                return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            Iterator<Box> it = this.boxes.iterator();
            long size = 0;
            while (it.hasNext()) {
                size += it.next().getSize();
            }
            return size;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            Iterator<Box> it = this.boxes.iterator();
            while (it.hasNext()) {
                it.next().getBox(writableByteChannel);
            }
        }
    }

    public WebVttTrack(InputStream inputStream, String str, Locale locale) throws IOException {
        super(str);
        this.trackMetaData = new TrackMetaData();
        this.samples = new ArrayList();
        this.sampleDurations = new long[0];
        this.trackMetaData.setTimescale(1000L);
        this.trackMetaData.setLanguage(locale.getISO3Language());
        this.stsd = new SampleDescriptionBox();
        Box webVTTSampleEntry = new WebVTTSampleEntry();
        this.sampleEntry = webVTTSampleEntry;
        this.stsd.addBox(webVTTSampleEntry);
        Box webVTTConfigurationBox = new WebVTTConfigurationBox();
        this.sampleEntry.addBox(webVTTConfigurationBox);
        this.sampleEntry.addBox(new WebVTTSourceLabelBox());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String line = bufferedReader.readLine();
        if (line == null || !WEBVTT_FILE_HEADER.matcher(line).matches()) {
            throw new IOException("Expected WEBVTT. Got " + line);
        }
        webVTTConfigurationBox.setConfig(String.valueOf(webVTTConfigurationBox.getConfig()) + "\n" + line);
        while (true) {
            String line2 = bufferedReader.readLine();
            if (line2 == null) {
                throw new IOException("Expected an empty line after webvtt header");
            }
            if (line2.isEmpty()) {
                long j = 0;
                while (true) {
                    String line3 = bufferedReader.readLine();
                    if (line3 == null) {
                        return;
                    }
                    if (!"".equals(line3.trim())) {
                        line3 = WEBVTT_CUE_IDENTIFIER.matcher(line3).find() ? bufferedReader.readLine() : line3;
                        Matcher matcher = WEBVTT_TIMESTAMP.matcher(line3);
                        if (!matcher.find()) {
                            throw new IOException("Expected cue start time: " + line3);
                        }
                        long timestampUs = parseTimestampUs(matcher.group());
                        if (!matcher.find()) {
                            throw new IOException("Expected cue end time: " + line3);
                        }
                        String strGroup = matcher.group();
                        long timestampUs2 = parseTimestampUs(strGroup);
                        Matcher matcher2 = WEBVTT_CUE_SETTING.matcher(line3.substring(line3.indexOf(strGroup) + strGroup.length()));
                        String strGroup2 = null;
                        while (matcher2.find()) {
                            strGroup2 = matcher2.group();
                        }
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line4 = bufferedReader.readLine();
                            if (line4 == null || line4.isEmpty()) {
                                break;
                            }
                            if (sb.length() > 0) {
                                sb.append("\n");
                            }
                            sb.append(line4.trim());
                        }
                        if (timestampUs != j) {
                            this.sampleDurations = Mp4Arrays.copyOfAndAppend(this.sampleDurations, timestampUs - j);
                            this.samples.add(EMPTY_SAMPLE);
                        }
                        this.sampleDurations = Mp4Arrays.copyOfAndAppend(this.sampleDurations, timestampUs2 - timestampUs);
                        VTTCueBox vTTCueBox = new VTTCueBox();
                        if (strGroup2 != null) {
                            CueSettingsBox cueSettingsBox = new CueSettingsBox();
                            cueSettingsBox.setContent(strGroup2);
                            vTTCueBox.setCueSettingsBox(cueSettingsBox);
                        }
                        CuePayloadBox cuePayloadBox = new CuePayloadBox();
                        cuePayloadBox.setContent(sb.toString());
                        vTTCueBox.setCuePayloadBox(cuePayloadBox);
                        this.samples.add(new BoxBearingSample(Collections.singletonList(vTTCueBox)));
                        j = timestampUs2;
                    }
                }
            } else {
                if (!WEBVTT_METADATA_HEADER.matcher(line2).find()) {
                    throw new IOException("Expected WebVTT metadata header. Got " + line2);
                }
                webVTTConfigurationBox.setConfig(String.valueOf(webVTTConfigurationBox.getConfig()) + "\n" + line2);
            }
        }
    }

    private static long parseTimestampUs(String str) throws NumberFormatException {
        if (!str.matches(WEBVTT_TIMESTAMP_STRING)) {
            throw new NumberFormatException("has invalid format");
        }
        String[] strArrSplit = str.split("\\.", 2);
        long j = 0;
        for (String str2 : strArrSplit[0].split(u15.f19942b)) {
            j = (j * 60) + Long.parseLong(str2);
        }
        return (j * 1000) + Long.parseLong(strArrSplit[1]);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "text";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.stsd;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        int length = this.sampleDurations.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = (this.sampleDurations[i] * this.trackMetaData.getTimescale()) / 1000;
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }
}
