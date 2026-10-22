package com.googlecode.mp4parser.authoring.tracks.h264;

import com.alipay.sdk.m.p.a;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.tracks.AbstractH26XTrack;
import com.googlecode.mp4parser.h264.model.HRDParameters;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import com.googlecode.mp4parser.h264.model.SeqParameterSet;
import com.googlecode.mp4parser.h264.model.VUIParameters;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.util.Mp4Arrays;
import com.googlecode.mp4parser.util.RangeStartMap;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class H264TrackImpl extends AbstractH26XTrack {
    private static final Logger LOG = Logger.getLogger(H264TrackImpl.class.getName());
    PictureParameterSet currentPictureParameterSet;
    SeqParameterSet currentSeqParameterSet;
    private boolean determineFrameRate;
    PictureParameterSet firstPictureParameterSet;
    SeqParameterSet firstSeqParameterSet;
    int frameNrInGop;
    private int frametick;
    private int height;
    private String lang;
    int[] pictureOrderCounts;
    RangeStartMap<Integer, byte[]> pictureParameterRangeMap;
    Map<Integer, PictureParameterSet> ppsIdToPps;
    Map<Integer, byte[]> ppsIdToPpsBytes;
    int prevPicOrderCntLsb;
    int prevPicOrderCntMsb;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    private SEIMessage seiMessage;
    RangeStartMap<Integer, byte[]> seqParameterRangeMap;
    Map<Integer, SeqParameterSet> spsIdToSps;
    Map<Integer, byte[]> spsIdToSpsBytes;
    private long timescale;
    private int width;

    public class SEIMessage {
        boolean clock_timestamp_flag;
        int cnt_dropped_flag;
        int counting_type;
        int cpb_removal_delay;
        int ct_type;
        int discontinuity_flag;
        int dpb_removal_delay;
        int full_timestamp_flag;
        int hours_value;
        int minutes_value;
        int n_frames;
        int nuit_field_based_flag;
        int payloadSize;
        int payloadType;
        int pic_struct;
        boolean removal_delay_flag;
        int seconds_value;
        SeqParameterSet sps;
        int time_offset;
        int time_offset_length;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v1, types: [int] */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.StringBuilder] */
        public SEIMessage(InputStream inputStream, SeqParameterSet seqParameterSet) throws IOException {
            char c;
            boolean z = false;
            this.payloadType = 0;
            this.payloadSize = 0;
            this.sps = seqParameterSet;
            inputStream.read();
            int iAvailable = inputStream.available();
            int i = 0;
            while (i < iAvailable) {
                this.payloadType = z ? 1 : 0;
                this.payloadSize = z ? 1 : 0;
                int i2 = inputStream.read();
                int i3 = i + 1;
                while (i2 == 255) {
                    this.payloadType += i2;
                    i2 = inputStream.read();
                    i3++;
                    z = false;
                }
                this.payloadType += i2;
                int i4 = inputStream.read();
                i = i3 + 1;
                while (i4 == 255) {
                    this.payloadSize += i4;
                    i4 = inputStream.read();
                    i++;
                    z = false;
                }
                int i5 = this.payloadSize + i4;
                this.payloadSize = i5;
                if (iAvailable - i < i5) {
                    i = iAvailable;
                } else if (this.payloadType == 1) {
                    VUIParameters vUIParameters = seqParameterSet.vuiParams;
                    if (vUIParameters == null || (vUIParameters.nalHRDParams == null && vUIParameters.vclHRDParams == null && !vUIParameters.pic_struct_present_flag)) {
                        for (int i6 = 0; i6 < this.payloadSize; i6++) {
                            inputStream.read();
                            i++;
                        }
                    } else {
                        byte[] bArr = new byte[i5];
                        inputStream.read(bArr);
                        i += this.payloadSize;
                        CAVLCReader cAVLCReader = new CAVLCReader(new ByteArrayInputStream(bArr));
                        VUIParameters vUIParameters2 = seqParameterSet.vuiParams;
                        HRDParameters hRDParameters = vUIParameters2.nalHRDParams;
                        if (hRDParameters == null && vUIParameters2.vclHRDParams == null) {
                            this.removal_delay_flag = z;
                        } else {
                            this.removal_delay_flag = true;
                            this.cpb_removal_delay = cAVLCReader.readU(hRDParameters.cpb_removal_delay_length_minus1 + 1, "SEI: cpb_removal_delay");
                            this.dpb_removal_delay = cAVLCReader.readU(seqParameterSet.vuiParams.nalHRDParams.dpb_output_delay_length_minus1 + 1, "SEI: dpb_removal_delay");
                        }
                        if (seqParameterSet.vuiParams.pic_struct_present_flag) {
                            int u = cAVLCReader.readU(4, "SEI: pic_struct");
                            this.pic_struct = u;
                            switch (u) {
                                case 3:
                                case 4:
                                case 7:
                                    c = 2;
                                    break;
                                case 5:
                                case 6:
                                case 8:
                                    c = 3;
                                    break;
                                default:
                                    c = 1;
                                    break;
                            }
                            for (?? r10 = z; r10 < c; r10++) {
                                boolean bool = cAVLCReader.readBool("pic_timing SEI: clock_timestamp_flag[" + r10 + "]");
                                this.clock_timestamp_flag = bool;
                                if (bool) {
                                    this.ct_type = cAVLCReader.readU(2, "pic_timing SEI: ct_type");
                                    this.nuit_field_based_flag = cAVLCReader.readU(1, "pic_timing SEI: nuit_field_based_flag");
                                    this.counting_type = cAVLCReader.readU(5, "pic_timing SEI: counting_type");
                                    this.full_timestamp_flag = cAVLCReader.readU(1, "pic_timing SEI: full_timestamp_flag");
                                    this.discontinuity_flag = cAVLCReader.readU(1, "pic_timing SEI: discontinuity_flag");
                                    this.cnt_dropped_flag = cAVLCReader.readU(1, "pic_timing SEI: cnt_dropped_flag");
                                    this.n_frames = cAVLCReader.readU(8, "pic_timing SEI: n_frames");
                                    if (this.full_timestamp_flag == 1) {
                                        this.seconds_value = cAVLCReader.readU(6, "pic_timing SEI: seconds_value");
                                        this.minutes_value = cAVLCReader.readU(6, "pic_timing SEI: minutes_value");
                                        this.hours_value = cAVLCReader.readU(5, "pic_timing SEI: hours_value");
                                    } else if (cAVLCReader.readBool("pic_timing SEI: seconds_flag")) {
                                        this.seconds_value = cAVLCReader.readU(6, "pic_timing SEI: seconds_value");
                                        if (cAVLCReader.readBool("pic_timing SEI: minutes_flag")) {
                                            this.minutes_value = cAVLCReader.readU(6, "pic_timing SEI: minutes_value");
                                            if (cAVLCReader.readBool("pic_timing SEI: hours_flag")) {
                                                this.hours_value = cAVLCReader.readU(5, "pic_timing SEI: hours_value");
                                            }
                                        }
                                    }
                                    VUIParameters vUIParameters3 = seqParameterSet.vuiParams;
                                    HRDParameters hRDParameters2 = vUIParameters3.nalHRDParams;
                                    if (hRDParameters2 != null) {
                                        this.time_offset_length = hRDParameters2.time_offset_length;
                                    } else {
                                        HRDParameters hRDParameters3 = vUIParameters3.vclHRDParams;
                                        if (hRDParameters3 != null) {
                                            this.time_offset_length = hRDParameters3.time_offset_length;
                                        } else {
                                            this.time_offset_length = 24;
                                        }
                                    }
                                    this.time_offset = cAVLCReader.readU(24, "pic_timing SEI: time_offset");
                                }
                            }
                        }
                    }
                } else {
                    for (int i7 = 0; i7 < this.payloadSize; i7++) {
                        inputStream.read();
                        i++;
                    }
                }
                H264TrackImpl.LOG.fine(toString());
                z = false;
            }
        }

        public String toString() {
            String str = "SEIMessage{payloadType=" + this.payloadType + ", payloadSize=" + this.payloadSize;
            if (this.payloadType == 1) {
                VUIParameters vUIParameters = this.sps.vuiParams;
                if (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null) {
                    str = String.valueOf(str) + ", cpb_removal_delay=" + this.cpb_removal_delay + ", dpb_removal_delay=" + this.dpb_removal_delay;
                }
                if (this.sps.vuiParams.pic_struct_present_flag) {
                    str = String.valueOf(str) + ", pic_struct=" + this.pic_struct;
                    if (this.clock_timestamp_flag) {
                        str = String.valueOf(str) + ", ct_type=" + this.ct_type + ", nuit_field_based_flag=" + this.nuit_field_based_flag + ", counting_type=" + this.counting_type + ", full_timestamp_flag=" + this.full_timestamp_flag + ", discontinuity_flag=" + this.discontinuity_flag + ", cnt_dropped_flag=" + this.cnt_dropped_flag + ", n_frames=" + this.n_frames + ", seconds_value=" + this.seconds_value + ", minutes_value=" + this.minutes_value + ", hours_value=" + this.hours_value + ", time_offset_length=" + this.time_offset_length + ", time_offset=" + this.time_offset;
                    }
                }
            }
            return String.valueOf(str) + '}';
        }
    }

    public H264TrackImpl(DataSource dataSource, String str, long j, int i) throws IOException {
        super(dataSource);
        this.spsIdToSpsBytes = new HashMap();
        this.spsIdToSps = new HashMap();
        this.ppsIdToPpsBytes = new HashMap();
        this.ppsIdToPps = new HashMap();
        this.firstSeqParameterSet = null;
        this.firstPictureParameterSet = null;
        this.currentSeqParameterSet = null;
        this.currentPictureParameterSet = null;
        this.seqParameterRangeMap = new RangeStartMap<>();
        this.pictureParameterRangeMap = new RangeStartMap<>();
        this.frameNrInGop = 0;
        this.pictureOrderCounts = new int[0];
        this.prevPicOrderCntLsb = 0;
        this.prevPicOrderCntMsb = 0;
        this.determineFrameRate = true;
        this.lang = str;
        this.timescale = j;
        this.frametick = i;
        if (j > 0 && i > 0) {
            this.determineFrameRate = false;
        }
        parse(new AbstractH26XTrack.LookAhead(dataSource));
    }

    private int calcPOC0(H264NalUnitHeader h264NalUnitHeader, SliceHeader sliceHeader) {
        int i;
        int i2 = sliceHeader.pic_order_cnt_lsb;
        int i3 = 1 << (sliceHeader.sps.log2_max_pic_order_cnt_lsb_minus4 + 4);
        int i4 = this.prevPicOrderCntLsb;
        if (i2 >= i4 || i4 - i2 < i3 / 2) {
            i = (i2 <= i4 || i2 - i4 <= i3 / 2) ? this.prevPicOrderCntMsb : this.prevPicOrderCntMsb - i3;
        } else {
            i = this.prevPicOrderCntMsb + i3;
        }
        if (h264NalUnitHeader.nal_ref_idc != 0) {
            this.prevPicOrderCntMsb = i;
            this.prevPicOrderCntLsb = i2;
        }
        return i + i2;
    }

    private int calcPOC1(int i, H264NalUnitHeader h264NalUnitHeader, SliceHeader sliceHeader) {
        int i2;
        int i3 = 0;
        if (sliceHeader.sps.num_ref_frames_in_pic_order_cnt_cycle == 0) {
            i = 0;
        }
        if (h264NalUnitHeader.nal_ref_idc == 0 && i > 0) {
            i--;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            SeqParameterSet seqParameterSet = sliceHeader.sps;
            i2 = seqParameterSet.num_ref_frames_in_pic_order_cnt_cycle;
            if (i4 >= i2) {
                break;
            }
            i5 += seqParameterSet.offsetForRefFrame[i4];
            i4++;
        }
        if (i > 0) {
            int i6 = i - 1;
            int i7 = i6 / i2;
            int i8 = i6 % i2;
            int i9 = i7 * i5;
            while (i3 <= i8) {
                i9 += sliceHeader.sps.offsetForRefFrame[i3];
                i3++;
            }
            i3 = i9;
        }
        if (h264NalUnitHeader.nal_ref_idc == 0) {
            i3 += sliceHeader.sps.offset_for_non_ref_pic;
        }
        return i3 + sliceHeader.delta_pic_order_cnt_0;
    }

    private int calcPOC2(int i, H264NalUnitHeader h264NalUnitHeader, SliceHeader sliceHeader) {
        return h264NalUnitHeader.nal_ref_idc == 0 ? (i * 2) - 1 : i * 2;
    }

    private int calcPoc(int i, H264NalUnitHeader h264NalUnitHeader, SliceHeader sliceHeader) {
        int i2 = sliceHeader.sps.pic_order_cnt_type;
        if (i2 == 0) {
            return calcPOC0(h264NalUnitHeader, sliceHeader);
        }
        return i2 == 1 ? calcPOC1(i, h264NalUnitHeader, sliceHeader) : calcPOC2(i, h264NalUnitHeader, sliceHeader);
    }

    private void configureFramerate() {
        if (this.determineFrameRate) {
            VUIParameters vUIParameters = this.firstSeqParameterSet.vuiParams;
            if (vUIParameters == null) {
                LOG.warning("Can't determine frame rate. Guessing 25 fps");
                this.timescale = 90000L;
                this.frametick = 3600;
                return;
            }
            long j = vUIParameters.time_scale >> 1;
            this.timescale = j;
            int i = vUIParameters.num_units_in_tick;
            this.frametick = i;
            if (j == 0 || i == 0) {
                LOG.warning("vuiParams contain invalid values: time_scale: " + this.timescale + " and frame_tick: " + this.frametick + ". Setting frame rate to 25fps");
                this.timescale = 90000L;
                this.frametick = 3600;
            }
            if (this.timescale / ((long) this.frametick) > 100) {
                LOG.warning("Framerate is " + (this.timescale / ((long) this.frametick)) + ". That is suspicious.");
            }
        }
    }

    private void createSample(List<ByteBuffer> list) throws IOException {
        int i;
        SampleDependencyTypeBox.Entry entry = new SampleDependencyTypeBox.Entry(0);
        Iterator<ByteBuffer> it = list.iterator();
        H264NalUnitHeader h264NalUnitHeader = null;
        boolean z = false;
        while (it.hasNext()) {
            H264NalUnitHeader nalUnitHeader = getNalUnitHeader(it.next());
            int i2 = nalUnitHeader.nal_unit_type;
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
                if (i2 == 5) {
                    z = true;
                }
            }
            h264NalUnitHeader = nalUnitHeader;
        }
        if (h264NalUnitHeader == null) {
            LOG.warning("Sample without Slice");
            return;
        }
        if (z) {
            calcCtts();
        }
        SliceHeader sliceHeader = new SliceHeader(AbstractH26XTrack.cleanBuffer(new ByteBufferBackedInputStream(list.get(list.size() - 1))), this.spsIdToSps, this.ppsIdToPps, z);
        if (h264NalUnitHeader.nal_ref_idc == 0) {
            entry.setSampleIsDependentOn(2);
        } else {
            entry.setSampleIsDependentOn(1);
        }
        SliceHeader.SliceType sliceType = sliceHeader.slice_type;
        if (sliceType == SliceHeader.SliceType.I || sliceType == SliceHeader.SliceType.SI) {
            entry.setSampleDependsOn(2);
        } else {
            entry.setSampleDependsOn(1);
        }
        Sample sampleCreateSampleObject = createSampleObject(list);
        list.clear();
        SEIMessage sEIMessage = this.seiMessage;
        if (sEIMessage == null || sEIMessage.n_frames == 0) {
            this.frameNrInGop = 0;
        }
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        int i3 = seqParameterSet.pic_order_cnt_type;
        if (i3 == 0) {
            int i4 = 1 << (seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 + 4);
            int i5 = sliceHeader.pic_order_cnt_lsb;
            int i6 = this.prevPicOrderCntLsb;
            if (i5 >= i6 || i6 - i5 < i4 / 2) {
                i = (i5 <= i6 || i5 - i6 <= i4 / 2) ? this.prevPicOrderCntMsb : this.prevPicOrderCntMsb - i4;
            } else {
                i = this.prevPicOrderCntMsb + i4;
            }
            this.pictureOrderCounts = Mp4Arrays.copyOfAndAppend(this.pictureOrderCounts, i + i5);
            this.prevPicOrderCntLsb = i5;
            this.prevPicOrderCntMsb = i;
        } else {
            if (i3 == 1) {
                throw new RuntimeException("pic_order_cnt_type == 1 needs to be implemented");
            }
            if (i3 == 2) {
                this.pictureOrderCounts = Mp4Arrays.copyOfAndAppend(this.pictureOrderCounts, this.samples.size());
            }
        }
        this.sdtp.add(entry);
        this.frameNrInGop++;
        this.samples.add(sampleCreateSampleObject);
        if (z) {
            this.stss.add(Integer.valueOf(this.samples.size()));
        }
    }

    public static H264NalUnitHeader getNalUnitHeader(ByteBuffer byteBuffer) {
        H264NalUnitHeader h264NalUnitHeader = new H264NalUnitHeader();
        byte b = byteBuffer.get(0);
        h264NalUnitHeader.nal_ref_idc = (b >> 5) & 3;
        h264NalUnitHeader.nal_unit_type = b & 31;
        return h264NalUnitHeader;
    }

    private void handlePPS(ByteBuffer byteBuffer) throws IOException {
        ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBuffer);
        byteBufferBackedInputStream.read();
        PictureParameterSet pictureParameterSet = PictureParameterSet.read(byteBufferBackedInputStream);
        if (this.firstPictureParameterSet == null) {
            this.firstPictureParameterSet = pictureParameterSet;
        }
        this.currentPictureParameterSet = pictureParameterSet;
        byte[] array = AbstractH26XTrack.toArray((ByteBuffer) byteBuffer.rewind());
        byte[] bArr = this.ppsIdToPpsBytes.get(Integer.valueOf(pictureParameterSet.pic_parameter_set_id));
        if (bArr != null && !Arrays.equals(bArr, array)) {
            throw new RuntimeException("OMG - I got two SPS with same ID but different settings! (AVC3 is the solution)");
        }
        if (bArr == null) {
            this.pictureParameterRangeMap.put(Integer.valueOf(this.samples.size()), array);
        }
        this.ppsIdToPpsBytes.put(Integer.valueOf(pictureParameterSet.pic_parameter_set_id), array);
        this.ppsIdToPps.put(Integer.valueOf(pictureParameterSet.pic_parameter_set_id), pictureParameterSet);
    }

    private void handleSPS(ByteBuffer byteBuffer) throws IOException {
        InputStream inputStreamCleanBuffer = AbstractH26XTrack.cleanBuffer(new ByteBufferBackedInputStream(byteBuffer));
        inputStreamCleanBuffer.read();
        SeqParameterSet seqParameterSet = SeqParameterSet.read(inputStreamCleanBuffer);
        if (this.firstSeqParameterSet == null) {
            this.firstSeqParameterSet = seqParameterSet;
            configureFramerate();
        }
        this.currentSeqParameterSet = seqParameterSet;
        byte[] array = AbstractH26XTrack.toArray((ByteBuffer) byteBuffer.rewind());
        byte[] bArr = this.spsIdToSpsBytes.get(Integer.valueOf(seqParameterSet.seq_parameter_set_id));
        if (bArr != null && !Arrays.equals(bArr, array)) {
            throw new RuntimeException("OMG - I got two SPS with same ID but different settings!");
        }
        if (bArr != null) {
            this.seqParameterRangeMap.put(Integer.valueOf(this.samples.size()), array);
        }
        this.spsIdToSpsBytes.put(Integer.valueOf(seqParameterSet.seq_parameter_set_id), array);
        this.spsIdToSps.put(Integer.valueOf(seqParameterSet.seq_parameter_set_id), seqParameterSet);
    }

    private void parse(AbstractH26XTrack.LookAhead lookAhead) throws IOException {
        this.samples = new ArrayList();
        if (!readSamples(lookAhead)) {
            throw new IOException();
        }
        if (!readVariables()) {
            throw new IOException();
        }
        this.sampleDescriptionBox = new SampleDescriptionBox();
        VisualSampleEntry visualSampleEntry = new VisualSampleEntry("avc1");
        visualSampleEntry.setDataReferenceIndex(1);
        visualSampleEntry.setDepth(24);
        visualSampleEntry.setFrameCount(1);
        visualSampleEntry.setHorizresolution(72.0d);
        visualSampleEntry.setVertresolution(72.0d);
        visualSampleEntry.setWidth(this.width);
        visualSampleEntry.setHeight(this.height);
        visualSampleEntry.setCompressorname("AVC Coding");
        AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
        avcConfigurationBox.setSequenceParameterSets(new ArrayList(this.spsIdToSpsBytes.values()));
        avcConfigurationBox.setPictureParameterSets(new ArrayList(this.ppsIdToPpsBytes.values()));
        avcConfigurationBox.setAvcLevelIndication(this.firstSeqParameterSet.level_idc);
        avcConfigurationBox.setAvcProfileIndication(this.firstSeqParameterSet.profile_idc);
        avcConfigurationBox.setBitDepthLumaMinus8(this.firstSeqParameterSet.bit_depth_luma_minus8);
        avcConfigurationBox.setBitDepthChromaMinus8(this.firstSeqParameterSet.bit_depth_chroma_minus8);
        avcConfigurationBox.setChromaFormat(this.firstSeqParameterSet.chroma_format_idc.getId());
        avcConfigurationBox.setConfigurationVersion(1);
        avcConfigurationBox.setLengthSizeMinusOne(3);
        SeqParameterSet seqParameterSet = this.firstSeqParameterSet;
        avcConfigurationBox.setProfileCompatibility((seqParameterSet.constraint_set_0_flag ? 128 : 0) + (seqParameterSet.constraint_set_1_flag ? 64 : 0) + (seqParameterSet.constraint_set_2_flag ? 32 : 0) + (seqParameterSet.constraint_set_3_flag ? 16 : 0) + (seqParameterSet.constraint_set_4_flag ? 8 : 0) + ((int) (seqParameterSet.reserved_zero_2bits & 3)));
        visualSampleEntry.addBox(avcConfigurationBox);
        this.sampleDescriptionBox.addBox(visualSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(this.lang);
        this.trackMetaData.setTimescale(this.timescale);
        this.trackMetaData.setWidth(this.width);
        this.trackMetaData.setHeight(this.height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.googlecode.mp4parser.authoring.tracks.h264.H264TrackImpl$1FirstVclNalDetector] */
    private boolean readSamples(AbstractH26XTrack.LookAhead lookAhead) throws IOException {
        ArrayList arrayList = new ArrayList();
        C1FirstVclNalDetector c1FirstVclNalDetector = 0;
        while (true) {
            ByteBuffer byteBufferFindNextNal = findNextNal(lookAhead);
            if (byteBufferFindNextNal != null) {
                H264NalUnitHeader nalUnitHeader = getNalUnitHeader(byteBufferFindNextNal);
                int i = nalUnitHeader.nal_unit_type;
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        ?? r6 = new Object(byteBufferFindNextNal, nalUnitHeader.nal_ref_idc, i) { // from class: com.googlecode.mp4parser.authoring.tracks.h264.H264TrackImpl.1FirstVclNalDetector
                            boolean bottom_field_flag;
                            int delta_pic_order_cnt_0;
                            int delta_pic_order_cnt_1;
                            int delta_pic_order_cnt_bottom;
                            boolean field_pic_flag;
                            int frame_num;
                            boolean idrPicFlag;
                            int idr_pic_id;
                            int nal_ref_idc;
                            int pic_order_cnt_lsb;
                            int pic_order_cnt_type;
                            int pic_parameter_set_id;

                            {
                                SliceHeader sliceHeader = new SliceHeader(AbstractH26XTrack.cleanBuffer(H264TrackImpl.this.new ByteBufferBackedInputStream(byteBufferFindNextNal)), H264TrackImpl.this.spsIdToSps, H264TrackImpl.this.ppsIdToPps, i == 5);
                                this.frame_num = sliceHeader.frame_num;
                                int i2 = sliceHeader.pic_parameter_set_id;
                                this.pic_parameter_set_id = i2;
                                this.field_pic_flag = sliceHeader.field_pic_flag;
                                this.bottom_field_flag = sliceHeader.bottom_field_flag;
                                this.nal_ref_idc = i;
                                this.pic_order_cnt_type = H264TrackImpl.this.spsIdToSps.get(Integer.valueOf(H264TrackImpl.this.ppsIdToPps.get(Integer.valueOf(i2)).seq_parameter_set_id)).pic_order_cnt_type;
                                this.delta_pic_order_cnt_bottom = sliceHeader.delta_pic_order_cnt_bottom;
                                this.pic_order_cnt_lsb = sliceHeader.pic_order_cnt_lsb;
                                this.delta_pic_order_cnt_0 = sliceHeader.delta_pic_order_cnt_0;
                                this.delta_pic_order_cnt_1 = sliceHeader.delta_pic_order_cnt_1;
                                this.idr_pic_id = sliceHeader.idr_pic_id;
                            }

                            public boolean isFirstInNew(C1FirstVclNalDetector c1FirstVclNalDetector2) {
                                boolean z;
                                boolean z2;
                                boolean z3;
                                if (c1FirstVclNalDetector2.frame_num != this.frame_num || c1FirstVclNalDetector2.pic_parameter_set_id != this.pic_parameter_set_id || (z = c1FirstVclNalDetector2.field_pic_flag) != this.field_pic_flag) {
                                    return true;
                                }
                                if ((z && c1FirstVclNalDetector2.bottom_field_flag != this.bottom_field_flag) || c1FirstVclNalDetector2.nal_ref_idc != this.nal_ref_idc) {
                                    return true;
                                }
                                int i2 = c1FirstVclNalDetector2.pic_order_cnt_type;
                                if (i2 == 0 && this.pic_order_cnt_type == 0 && (c1FirstVclNalDetector2.pic_order_cnt_lsb != this.pic_order_cnt_lsb || c1FirstVclNalDetector2.delta_pic_order_cnt_bottom != this.delta_pic_order_cnt_bottom)) {
                                    return true;
                                }
                                if (!(i2 == 1 && this.pic_order_cnt_type == 1 && (c1FirstVclNalDetector2.delta_pic_order_cnt_0 != this.delta_pic_order_cnt_0 || c1FirstVclNalDetector2.delta_pic_order_cnt_1 != this.delta_pic_order_cnt_1)) && (z2 = c1FirstVclNalDetector2.idrPicFlag) == (z3 = this.idrPicFlag)) {
                                    return z2 && z3 && c1FirstVclNalDetector2.idr_pic_id != this.idr_pic_id;
                                }
                                return true;
                            }
                        };
                        if (c1FirstVclNalDetector != 0 && c1FirstVclNalDetector.isFirstInNew(r6)) {
                            LOG.finer("Wrapping up cause of first vcl nal is found");
                            createSample(arrayList);
                        }
                        arrayList.add((ByteBuffer) byteBufferFindNextNal.rewind());
                        c1FirstVclNalDetector = r6;
                        continue;
                    case 6:
                        if (c1FirstVclNalDetector != 0) {
                            LOG.finer("Wrapping up cause of SEI after vcl marks new sample");
                            createSample(arrayList);
                            c1FirstVclNalDetector = 0;
                        }
                        this.seiMessage = new SEIMessage(AbstractH26XTrack.cleanBuffer(new ByteBufferBackedInputStream(byteBufferFindNextNal)), this.currentSeqParameterSet);
                        arrayList.add(byteBufferFindNextNal);
                        continue;
                    case 7:
                        if (c1FirstVclNalDetector != 0) {
                            LOG.finer("Wrapping up cause of SPS after vcl marks new sample");
                            createSample(arrayList);
                            c1FirstVclNalDetector = 0;
                        }
                        handleSPS((ByteBuffer) byteBufferFindNextNal.rewind());
                        continue;
                    case 8:
                        if (c1FirstVclNalDetector != 0) {
                            LOG.finer("Wrapping up cause of PPS after vcl marks new sample");
                            createSample(arrayList);
                            c1FirstVclNalDetector = 0;
                        }
                        handlePPS((ByteBuffer) byteBufferFindNextNal.rewind());
                        continue;
                    case 9:
                        if (c1FirstVclNalDetector != 0) {
                            LOG.finer("Wrapping up cause of AU after vcl marks new sample");
                            createSample(arrayList);
                            c1FirstVclNalDetector = 0;
                        }
                        arrayList.add(byteBufferFindNextNal);
                        continue;
                    case 10:
                    case 11:
                        break;
                    case 12:
                    default:
                        LOG.warning("Unknown NAL unit type: " + nalUnitHeader.nal_unit_type);
                        continue;
                    case 13:
                        throw new RuntimeException("Sequence parameter set extension is not yet handled. Needs TLC.");
                }
            }
        }
        if (arrayList.size() > 0) {
            createSample(arrayList);
        }
        calcCtts();
        long[] jArr = new long[this.samples.size()];
        this.decodingTimes = jArr;
        Arrays.fill(jArr, this.frametick);
        return true;
    }

    private boolean readVariables() {
        int subWidth;
        SeqParameterSet seqParameterSet = this.firstSeqParameterSet;
        this.width = (seqParameterSet.pic_width_in_mbs_minus1 + 1) * 16;
        int subHeight = seqParameterSet.frame_mbs_only_flag ? 1 : 2;
        this.height = (seqParameterSet.pic_height_in_map_units_minus1 + 1) * 16 * subHeight;
        if (seqParameterSet.frame_cropping_flag) {
            if ((!seqParameterSet.residual_color_transform_flag ? seqParameterSet.chroma_format_idc.getId() : 0) != 0) {
                subWidth = this.firstSeqParameterSet.chroma_format_idc.getSubWidth();
                subHeight *= this.firstSeqParameterSet.chroma_format_idc.getSubHeight();
            } else {
                subWidth = 1;
            }
            int i = this.width;
            SeqParameterSet seqParameterSet2 = this.firstSeqParameterSet;
            this.width = i - (subWidth * (seqParameterSet2.frame_crop_left_offset + seqParameterSet2.frame_crop_right_offset));
            this.height -= subHeight * (seqParameterSet2.frame_crop_top_offset + seqParameterSet2.frame_crop_bottom_offset);
        }
        return true;
    }

    public void calcCtts() {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.pictureOrderCounts.length) {
            int i4 = Integer.MAX_VALUE;
            int i5 = 0;
            for (int iMax = Math.max(0, i2 + a.g); iMax < Math.min(this.pictureOrderCounts.length, i2 + 128); iMax++) {
                int i6 = this.pictureOrderCounts[iMax];
                if (i6 > i && i6 < i4) {
                    i5 = iMax;
                    i4 = i6;
                }
            }
            int[] iArr = this.pictureOrderCounts;
            int i7 = iArr[i5];
            iArr[i5] = i3;
            i2++;
            i = i7;
            i3++;
        }
        int i8 = 0;
        while (true) {
            int[] iArr2 = this.pictureOrderCounts;
            if (i8 >= iArr2.length) {
                this.pictureOrderCounts = new int[0];
                return;
            } else {
                this.ctts.add(new CompositionTimeToSample.Entry(1, iArr2[i8] - i8));
                i8++;
            }
        }
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "vide";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    public class ByteBufferBackedInputStream extends InputStream {
        private final ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer.duplicate();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.buf.hasRemaining()) {
                return this.buf.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.buf.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i2, this.buf.remaining());
            this.buf.get(bArr, i, iMin);
            return iMin;
        }
    }

    public H264TrackImpl(DataSource dataSource, String str) throws IOException {
        this(dataSource, str, -1L, -1);
    }

    public H264TrackImpl(DataSource dataSource) throws IOException {
        this(dataSource, "eng");
    }
}
