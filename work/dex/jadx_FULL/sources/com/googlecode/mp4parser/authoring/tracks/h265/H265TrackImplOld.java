package com.googlecode.mp4parser.authoring.tracks.h265;

import com.coremedia.iso.IsoTypeReader;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.util.ByteBufferByteChannel;
import com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class H265TrackImplOld {
    public static final int AUD_NUT = 35;
    private static final int BLA_N_LP = 18;
    private static final int BLA_W_LP = 16;
    private static final int BLA_W_RADL = 17;
    private static final long BUFFER = 1048576;
    private static final int CRA_NUT = 21;
    private static final int IDR_N_LP = 20;
    private static final int IDR_W_RADL = 19;
    public static final int PPS_NUT = 34;
    public static final int PREFIX_SEI_NUT = 39;
    private static final int RADL_N = 6;
    private static final int RADL_R = 7;
    private static final int RASL_N = 8;
    private static final int RASL_R = 9;
    public static final int RSV_NVCL41 = 41;
    public static final int RSV_NVCL42 = 42;
    public static final int RSV_NVCL43 = 43;
    public static final int RSV_NVCL44 = 44;
    public static final int SPS_NUT = 33;
    private static final int STSA_N = 4;
    private static final int STSA_R = 5;
    private static final int TRAIL_N = 0;
    private static final int TRAIL_R = 1;
    private static final int TSA_N = 2;
    private static final int TSA_R = 3;
    public static final int UNSPEC48 = 48;
    public static final int UNSPEC49 = 49;
    public static final int UNSPEC50 = 50;
    public static final int UNSPEC51 = 51;
    public static final int UNSPEC52 = 52;
    public static final int UNSPEC53 = 53;
    public static final int UNSPEC54 = 54;
    public static final int UNSPEC55 = 55;
    public static final int VPS_NUT = 32;
    LinkedHashMap<Long, ByteBuffer> videoParamterSets = new LinkedHashMap<>();
    LinkedHashMap<Long, ByteBuffer> sequenceParamterSets = new LinkedHashMap<>();
    LinkedHashMap<Long, ByteBuffer> pictureParamterSets = new LinkedHashMap<>();
    List<Long> syncSamples = new ArrayList();
    List<Sample> samples = new ArrayList();

    public class LookAhead {
        ByteBuffer buffer;
        DataSource dataSource;
        long start;
        long bufferStartPos = 0;
        int inBufferPos = 0;

        public LookAhead(DataSource dataSource) throws IOException {
            this.dataSource = dataSource;
            fillBuffer();
        }

        public void discardByte() {
            this.inBufferPos++;
        }

        public void discardNext3AndMarkStart() {
            int i = this.inBufferPos + 3;
            this.inBufferPos = i;
            this.start = this.bufferStartPos + ((long) i);
        }

        public void fillBuffer() throws IOException {
            DataSource dataSource = this.dataSource;
            this.buffer = dataSource.map(this.bufferStartPos, Math.min(dataSource.size() - this.bufferStartPos, 1048576L));
        }

        public ByteBuffer getNal() {
            long j = this.start;
            long j2 = this.bufferStartPos;
            if (j < j2) {
                throw new RuntimeException("damn! NAL exceeds buffer");
            }
            this.buffer.position((int) (j - j2));
            ByteBuffer byteBufferSlice = this.buffer.slice();
            byteBufferSlice.limit((int) (((long) this.inBufferPos) - (this.start - this.bufferStartPos)));
            return byteBufferSlice;
        }

        public boolean nextThreeEquals000or001orEof() throws IOException {
            int iLimit = this.buffer.limit();
            int i = this.inBufferPos;
            if (iLimit - i >= 3) {
                return this.buffer.get(i) == 0 && this.buffer.get(this.inBufferPos + 1) == 0 && (this.buffer.get(this.inBufferPos + 2) == 0 || this.buffer.get(this.inBufferPos + 2) == 1);
            }
            if (this.bufferStartPos + ((long) i) + 3 > this.dataSource.size()) {
                return this.bufferStartPos + ((long) this.inBufferPos) == this.dataSource.size();
            }
            this.bufferStartPos = this.start;
            this.inBufferPos = 0;
            fillBuffer();
            return nextThreeEquals000or001orEof();
        }

        public boolean nextThreeEquals001() throws IOException {
            int iLimit = this.buffer.limit();
            int i = this.inBufferPos;
            if (iLimit - i >= 3) {
                return this.buffer.get(i) == 0 && this.buffer.get(this.inBufferPos + 1) == 0 && this.buffer.get(this.inBufferPos + 2) == 1;
            }
            if (this.bufferStartPos + ((long) i) == this.dataSource.size()) {
                throw new EOFException();
            }
            throw new RuntimeException("buffer repositioning require");
        }
    }

    public static class NalUnitHeader {
        int forbiddenZeroFlag;
        int nalUnitType;
        int nuhLayerId;
        int nuhTemporalIdPlusOne;
    }

    public enum PARSE_STATE {
        AUD_SEI_SLICE,
        SEI_SLICE,
        SLICE_OES_EOB;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PARSE_STATE[] valuesCustom() {
            PARSE_STATE[] parse_stateArrValuesCustom = values();
            int length = parse_stateArrValuesCustom.length;
            PARSE_STATE[] parse_stateArr = new PARSE_STATE[length];
            System.arraycopy(parse_stateArrValuesCustom, 0, parse_stateArr, 0, length);
            return parse_stateArr;
        }
    }

    public H265TrackImplOld(DataSource dataSource) throws IOException {
        LookAhead lookAhead = new LookAhead(dataSource);
        ArrayList arrayList = new ArrayList();
        long j = 1;
        int i = 0;
        while (true) {
            ByteBuffer byteBufferFindNextNal = findNextNal(lookAhead);
            if (byteBufferFindNextNal == null) {
                System.err.println("");
                HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord = new HevcDecoderConfigurationRecord();
                hevcDecoderConfigurationRecord.setArrays(getArrays());
                hevcDecoderConfigurationRecord.setAvgFrameRate(0);
                return;
            }
            NalUnitHeader nalUnitHeader = getNalUnitHeader(byteBufferFindNextNal);
            switch (nalUnitHeader.nalUnitType) {
                case 32:
                    this.videoParamterSets.put(Long.valueOf(j), byteBufferFindNextNal);
                    break;
                case 33:
                    this.sequenceParamterSets.put(Long.valueOf(j), byteBufferFindNextNal);
                    break;
                case 34:
                    this.pictureParamterSets.put(Long.valueOf(j), byteBufferFindNextNal);
                    break;
            }
            int i2 = nalUnitHeader.nalUnitType;
            i = i2 < 32 ? i2 : i;
            if (isFirstOfAU(i2, byteBufferFindNextNal, arrayList) && !arrayList.isEmpty()) {
                System.err.println("##########################");
                for (ByteBuffer byteBuffer : arrayList) {
                    NalUnitHeader nalUnitHeader2 = getNalUnitHeader(byteBuffer);
                    System.err.println(String.format("type: %3d - layer: %3d - tempId: %3d - size: %3d", Integer.valueOf(nalUnitHeader2.nalUnitType), Integer.valueOf(nalUnitHeader2.nuhLayerId), Integer.valueOf(nalUnitHeader2.nuhTemporalIdPlusOne), Integer.valueOf(byteBuffer.limit())));
                }
                System.err.println("                          ##########################");
                this.samples.add(createSample(arrayList));
                arrayList.clear();
                j++;
            }
            arrayList.add(byteBufferFindNextNal);
            if (i >= 16 && i <= 21) {
                this.syncSamples.add(Long.valueOf(j));
            }
        }
    }

    private ByteBuffer findNextNal(LookAhead lookAhead) throws IOException {
        while (!lookAhead.nextThreeEquals001()) {
            try {
                lookAhead.discardByte();
            } catch (EOFException unused) {
                return null;
            }
        }
        lookAhead.discardNext3AndMarkStart();
        while (!lookAhead.nextThreeEquals000or001orEof()) {
            lookAhead.discardByte();
        }
        return lookAhead.getNal();
    }

    private List<HevcDecoderConfigurationRecord.Array> getArrays() {
        HevcDecoderConfigurationRecord.Array array = new HevcDecoderConfigurationRecord.Array();
        array.array_completeness = true;
        array.nal_unit_type = 32;
        array.nalUnits = new ArrayList();
        for (ByteBuffer byteBuffer : this.videoParamterSets.values()) {
            byte[] bArr = new byte[byteBuffer.limit()];
            byteBuffer.position(0);
            byteBuffer.get(bArr);
            array.nalUnits.add(bArr);
        }
        HevcDecoderConfigurationRecord.Array array2 = new HevcDecoderConfigurationRecord.Array();
        array2.array_completeness = true;
        array2.nal_unit_type = 33;
        array2.nalUnits = new ArrayList();
        for (ByteBuffer byteBuffer2 : this.sequenceParamterSets.values()) {
            byte[] bArr2 = new byte[byteBuffer2.limit()];
            byteBuffer2.position(0);
            byteBuffer2.get(bArr2);
            array2.nalUnits.add(bArr2);
        }
        HevcDecoderConfigurationRecord.Array array3 = new HevcDecoderConfigurationRecord.Array();
        array3.array_completeness = true;
        array3.nal_unit_type = 33;
        array3.nalUnits = new ArrayList();
        for (ByteBuffer byteBuffer3 : this.pictureParamterSets.values()) {
            byte[] bArr3 = new byte[byteBuffer3.limit()];
            byteBuffer3.position(0);
            byteBuffer3.get(bArr3);
            array3.nalUnits.add(bArr3);
        }
        return Arrays.asList(array, array2, array3);
    }

    private void hrd_parameters(boolean z, int i, CAVLCReader cAVLCReader) throws IOException {
        boolean bool;
        boolean bool2;
        boolean bool3;
        if (z) {
            bool = cAVLCReader.readBool("nal_hrd_parameters_present_flag");
            bool2 = cAVLCReader.readBool("vcl_hrd_parameters_present_flag");
            if (bool || bool2) {
                bool3 = cAVLCReader.readBool("sub_pic_hrd_params_present_flag");
                if (bool3) {
                    cAVLCReader.readU(8, "tick_divisor_minus2");
                    cAVLCReader.readU(5, "du_cpb_removal_delay_increment_length_minus1");
                    cAVLCReader.readBool("sub_pic_cpb_params_in_pic_timing_sei_flag");
                    cAVLCReader.readU(5, "dpb_output_delay_du_length_minus1");
                }
                cAVLCReader.readU(4, "bit_rate_scale");
                cAVLCReader.readU(4, "cpb_size_scale");
                if (bool3) {
                    cAVLCReader.readU(4, "cpb_size_du_scale");
                }
                cAVLCReader.readU(5, "initial_cpb_removal_delay_length_minus1");
                cAVLCReader.readU(5, "au_cpb_removal_delay_length_minus1");
                cAVLCReader.readU(5, "dpb_output_delay_length_minus1");
            } else {
                bool3 = false;
            }
        } else {
            bool = false;
            bool2 = false;
            bool3 = false;
        }
        boolean[] zArr = new boolean[i];
        boolean[] zArr2 = new boolean[i];
        boolean[] zArr3 = new boolean[i];
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        for (int i2 = 0; i2 <= i; i2++) {
            boolean bool4 = cAVLCReader.readBool("fixed_pic_rate_general_flag[" + i2 + "]");
            zArr[i2] = bool4;
            if (!bool4) {
                zArr2[i2] = cAVLCReader.readBool("fixed_pic_rate_within_cvs_flag[" + i2 + "]");
            }
            if (zArr2[i2]) {
                iArr2[i2] = cAVLCReader.readUE("elemental_duration_in_tc_minus1[" + i2 + "]");
            } else {
                zArr3[i2] = cAVLCReader.readBool("low_delay_hrd_flag[" + i2 + "]");
            }
            if (!zArr3[i2]) {
                iArr[i2] = cAVLCReader.readUE("cpb_cnt_minus1[" + i2 + "]");
            }
            if (bool) {
                sub_layer_hrd_parameters(i2, iArr[i2], bool3, cAVLCReader);
            }
            if (bool2) {
                sub_layer_hrd_parameters(i2, iArr[i2], bool3, cAVLCReader);
            }
        }
    }

    public static void main(String[] strArr) throws IOException {
        new H265TrackImplOld(new FileDataSourceImpl("c:\\content\\test-UHD-HEVC_01_FMV_Med_track1.hvc"));
    }

    public Sample createSample(List<ByteBuffer> list) {
        byte[] bArr = new byte[list.size() * 4];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            byteBufferWrap.putInt(it.next().remaining());
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = ByteBuffer.wrap(bArr, i * 4, 4);
            byteBufferArr[i2 + 1] = list.get(i);
        }
        return new SampleImpl(byteBufferArr);
    }

    public int getFrameRate(ByteBuffer byteBuffer) throws IOException {
        CAVLCReader cAVLCReader = new CAVLCReader(Channels.newInputStream(new ByteBufferByteChannel((ByteBuffer) byteBuffer.position(0))));
        cAVLCReader.readU(4, "vps_parameter_set_id");
        cAVLCReader.readU(2, "vps_reserved_three_2bits");
        cAVLCReader.readU(6, "vps_max_layers_minus1");
        int u = cAVLCReader.readU(3, "vps_max_sub_layers_minus1");
        cAVLCReader.readBool("vps_temporal_id_nesting_flag");
        cAVLCReader.readU(16, "vps_reserved_0xffff_16bits");
        profile_tier_level(u, cAVLCReader);
        boolean bool = cAVLCReader.readBool("vps_sub_layer_ordering_info_present_flag");
        int[] iArr = new int[bool ? 0 : u];
        int[] iArr2 = new int[bool ? 0 : u];
        int[] iArr3 = new int[bool ? 0 : u];
        for (int i = bool ? 0 : u; i <= u; i++) {
            iArr[i] = cAVLCReader.readUE("vps_max_dec_pic_buffering_minus1[" + i + "]");
            iArr2[i] = cAVLCReader.readUE("vps_max_dec_pic_buffering_minus1[" + i + "]");
            iArr3[i] = cAVLCReader.readUE("vps_max_dec_pic_buffering_minus1[" + i + "]");
        }
        int u2 = cAVLCReader.readU(6, "vps_max_layer_id");
        int ue = cAVLCReader.readUE("vps_num_layer_sets_minus1");
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, ue, u2);
        for (int i2 = 1; i2 <= ue; i2++) {
            for (int i3 = 0; i3 <= u2; i3++) {
                zArr[i2][i3] = cAVLCReader.readBool("layer_id_included_flag[" + i2 + "][" + i3 + "]");
            }
        }
        if (cAVLCReader.readBool("vps_timing_info_present_flag")) {
            cAVLCReader.readU(32, "vps_num_units_in_tick");
            cAVLCReader.readU(32, "vps_time_scale");
            if (cAVLCReader.readBool("vps_poc_proportional_to_timing_flag")) {
                cAVLCReader.readUE("vps_num_ticks_poc_diff_one_minus1");
            }
            int ue2 = cAVLCReader.readUE("vps_num_hrd_parameters");
            int[] iArr4 = new int[ue2];
            boolean[] zArr2 = new boolean[ue2];
            for (int i4 = 0; i4 < ue2; i4++) {
                iArr4[i4] = cAVLCReader.readUE("hrd_layer_set_idx[" + i4 + "]");
                if (i4 > 0) {
                    zArr2[i4] = cAVLCReader.readBool("cprms_present_flag[" + i4 + "]");
                } else {
                    zArr2[0] = true;
                }
                hrd_parameters(zArr2[i4], u, cAVLCReader);
            }
        }
        if (cAVLCReader.readBool("vps_extension_flag")) {
            while (cAVLCReader.moreRBSPData()) {
                cAVLCReader.readBool("vps_extension_data_flag");
            }
        }
        cAVLCReader.readTrailingBits();
        return 0;
    }

    public NalUnitHeader getNalUnitHeader(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        int uInt16 = IsoTypeReader.readUInt16(byteBuffer);
        NalUnitHeader nalUnitHeader = new NalUnitHeader();
        nalUnitHeader.forbiddenZeroFlag = (32768 & uInt16) >> 15;
        nalUnitHeader.nalUnitType = (uInt16 & 32256) >> 9;
        nalUnitHeader.nuhLayerId = (uInt16 & 504) >> 3;
        nalUnitHeader.nuhTemporalIdPlusOne = uInt16 & 7;
        return nalUnitHeader;
    }

    public boolean isFirstOfAU(int i, ByteBuffer byteBuffer, List<ByteBuffer> list) {
        if (list.isEmpty()) {
            return true;
        }
        boolean z = getNalUnitHeader(list.get(list.size() - 1)).nalUnitType <= 31;
        switch (i) {
            case 32:
            case 33:
            case 34:
            case 35:
            case 39:
            case 41:
            case 42:
            case 43:
            case 44:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                if (z) {
                    return true;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                switch (i) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        break;
                    default:
                        return false;
                }
                break;
        }
        byteBuffer.position(0);
        byteBuffer.get(new byte[50]);
        byteBuffer.position(2);
        return z && (IsoTypeReader.readUInt8(byteBuffer) & 128) > 0;
    }

    public void profile_tier_level(int i, CAVLCReader cAVLCReader) throws IOException {
        int i2 = 2;
        cAVLCReader.readU(2, "general_profile_space ");
        cAVLCReader.readBool("general_tier_flag");
        cAVLCReader.readU(5, "general_profile_idc");
        int i3 = 32;
        boolean[] zArr = new boolean[32];
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            zArr[i5] = cAVLCReader.readBool("general_profile_compatibility_flag[" + i5 + "]");
            i5++;
            i3 = 32;
            i2 = 2;
            i4 = 0;
        }
        cAVLCReader.readBool("general_progressive_source_flag");
        cAVLCReader.readBool("general_interlaced_source_flag");
        cAVLCReader.readBool("general_non_packed_constraint_flag");
        cAVLCReader.readBool("general_frame_only_constraint_flag");
        cAVLCReader.readU(44, "general_reserved_zero_44bits");
        cAVLCReader.readU(8, "general_level_idc");
        boolean[] zArr2 = new boolean[i];
        boolean[] zArr3 = new boolean[i];
        int i6 = i4;
        while (i6 < i) {
            zArr2[i6] = cAVLCReader.readBool("sub_layer_profile_present_flag[" + i6 + "]");
            zArr3[i6] = cAVLCReader.readBool("sub_layer_level_present_flag[" + i6 + "]");
            i6++;
            i = i;
            i3 = 32;
            i2 = 2;
            i4 = 0;
        }
        if (i > 0) {
            for (int i7 = i; i7 < 8; i7++) {
                cAVLCReader.readU(i2, "reserved_zero_2bits");
            }
        }
        int[] iArr = new int[i];
        boolean[] zArr4 = new boolean[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i2];
        iArr3[1] = i3;
        iArr3[i4] = i;
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, iArr3);
        boolean[] zArr6 = new boolean[i];
        boolean[] zArr7 = new boolean[i];
        boolean[] zArr8 = new boolean[i];
        boolean[] zArr9 = new boolean[i];
        int[] iArr4 = new int[i];
        int i8 = 0;
        while (i8 < i) {
            if (zArr2[i8]) {
                iArr[i8] = cAVLCReader.readU(2, "sub_layer_profile_space[" + i8 + "]");
                zArr4[i8] = cAVLCReader.readBool("sub_layer_tier_flag[" + i8 + "]");
                iArr2[i8] = cAVLCReader.readU(5, "sub_layer_profile_idc[" + i8 + "]");
                int i9 = 0;
                while (i9 < 32) {
                    zArr5[i8][i9] = cAVLCReader.readBool("sub_layer_profile_compatibility_flag[" + i8 + "][" + i9 + "]");
                    i9++;
                    zArr6 = zArr6;
                }
                zArr6[i8] = cAVLCReader.readBool("sub_layer_progressive_source_flag[" + i8 + "]");
                zArr7[i8] = cAVLCReader.readBool("sub_layer_interlaced_source_flag[" + i8 + "]");
                zArr8[i8] = cAVLCReader.readBool("sub_layer_non_packed_constraint_flag[" + i8 + "]");
                zArr9[i8] = cAVLCReader.readBool("sub_layer_frame_only_constraint_flag[" + i8 + "]");
                cAVLCReader.readNBit(44, "reserved");
            }
            boolean[] zArr10 = zArr6;
            if (zArr3[i8]) {
                iArr4[i8] = cAVLCReader.readU(8, "sub_layer_level_idc");
            }
            i8++;
            i = i;
            zArr6 = zArr10;
        }
    }

    public void sub_layer_hrd_parameters(int i, int i2, boolean z, CAVLCReader cAVLCReader) throws IOException {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        boolean[] zArr = new boolean[i2];
        for (int i3 = 0; i3 <= i2; i3++) {
            iArr[i3] = cAVLCReader.readUE("bit_rate_value_minus1[" + i3 + "]");
            iArr2[i3] = cAVLCReader.readUE("cpb_size_value_minus1[" + i3 + "]");
            if (z) {
                iArr3[i3] = cAVLCReader.readUE("cpb_size_du_value_minus1[" + i3 + "]");
                iArr4[i3] = cAVLCReader.readUE("bit_rate_du_value_minus1[" + i3 + "]");
            }
            zArr[i3] = cAVLCReader.readBool("cbr_flag[" + i3 + "]");
        }
    }
}
