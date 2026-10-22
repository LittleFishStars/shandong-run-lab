package com.google.android.inner_exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.alibaba.ariver.remotedebug.b.c;
import com.alibaba.ariver.resource.parser.a.e;
import com.google.android.exoplayer2.text.cea.a;
import com.google.android.inner_exoplayer2.C;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.ParserException;
import com.google.android.inner_exoplayer2.audio.AacUtil;
import com.google.android.inner_exoplayer2.drm.DrmInitData;
import com.google.android.inner_exoplayer2.extractor.ChunkIndex;
import com.google.android.inner_exoplayer2.extractor.Extractor;
import com.google.android.inner_exoplayer2.extractor.ExtractorInput;
import com.google.android.inner_exoplayer2.extractor.ExtractorOutput;
import com.google.android.inner_exoplayer2.extractor.ExtractorsFactory;
import com.google.android.inner_exoplayer2.extractor.PositionHolder;
import com.google.android.inner_exoplayer2.extractor.SeekMap;
import com.google.android.inner_exoplayer2.extractor.TrackOutput;
import com.google.android.inner_exoplayer2.extractor.TrueHdSampleRechunker;
import com.google.android.inner_exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.inner_exoplayer2.upstream.DataReader;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.Log;
import com.google.android.inner_exoplayer2.util.LongArray;
import com.google.android.inner_exoplayer2.util.MimeTypes;
import com.google.android.inner_exoplayer2.util.NalUnitUtil;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;
import com.google.android.inner_exoplayer2.util.Util;
import com.google.android.inner_exoplayer2.video.AvcConfig;
import com.google.android.inner_exoplayer2.video.ColorInfo;
import com.google.android.inner_exoplayer2.video.DolbyVisionConfig;
import com.google.android.inner_exoplayer2.video.HevcConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.UnsignedBytes;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MatroskaExtractor implements Extractor {
    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_ADD_ID_TYPE_DVCC = 1685480259;
    private static final int BLOCK_ADD_ID_TYPE_DVVC = 1685485123;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_FLOAT = "A_PCM/FLOAT/IEEE";
    private static final String CODEC_ID_PCM_INT_BIG = "A_PCM/INT/BIG";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String CODEC_ID_VTT = "S_TEXT/WEBVTT";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 859189832;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_ADDITIONAL = 165;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADDITION_MAPPING = 16868;
    private static final int ID_BLOCK_ADD_ID = 238;
    private static final int ID_BLOCK_ADD_ID_EXTRA_DATA = 16877;
    private static final int ID_BLOCK_ADD_ID_TYPE = 16871;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_BLOCK_MORE = 166;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISCARD_PADDING = 30114;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 21998;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final Map<String, Integer> TRACK_NAME_TO_ROTATION_DEGREES;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int VTT_PREFIX_END_TIMECODE_OFFSET = 25;
    private static final String VTT_TIMECODE_FORMAT = "%02d:%02d:%02d.%03d";
    private static final long VTT_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private long blockGroupDiscardPaddingNs;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;

    @Nullable
    private LongArray cueClusterPositions;

    @Nullable
    private LongArray cueTimesUs;
    private long cuesContentPosition;

    @Nullable
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private final ParsableByteArray supplementalData;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.zj.adlib.xe5
        @Override // com.google.android.inner_exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return MatroskaExtractor.lambda$static$0();
        }
    };
    private static final byte[] SUBRIP_PREFIX = {e.j, 10, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, a.m, e.i, e.i, e.i, 32, a.n, a.n, 62, 32, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, a.m, e.i, e.i, e.i, 10};
    private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, e.i, 58, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, a.m, e.i, 58, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, a.m};
    private static final byte[] VTT_PREFIX = {87, 69, 66, 86, 84, 84, 10, 10, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, a.o, e.i, e.i, e.i, 32, a.n, a.n, 62, 32, e.i, e.i, 58, e.i, e.i, 58, e.i, e.i, a.o, e.i, e.i, e.i, 10};
    private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws ParserException {
            MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public void endMasterElement(int i) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i);
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public void floatElement(int i, double d) {
            MatroskaExtractor.this.floatElement(i, d);
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public int getElementType(int i) {
            return MatroskaExtractor.this.getElementType(i);
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public void integerElement(int i, long j) throws ParserException {
            MatroskaExtractor.this.integerElement(i, j);
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int i) {
            return MatroskaExtractor.this.isLevel1Element(i);
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        @Override // com.google.android.inner_exoplayer2.extractor.mkv.EbmlProcessor
        public void stringElement(int i, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i, str);
        }
    }

    public static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        private int blockAddIdType;
        public String codecId;
        public byte[] codecPrivate;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagForced;
        public boolean hasContentEncryption;
        public int maxBlockAdditionId;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public byte[] sampleStrippedBytes;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public int width = -1;
        public int height = -1;
        public int displayWidth = -1;
        public int displayHeight = -1;
        public int displayUnit = 0;
        public int projectionType = -1;
        public float projectionPoseYaw = 0.0f;
        public float projectionPosePitch = 0.0f;
        public float projectionPoseRoll = 0.0f;
        public byte[] projectionData = null;
        public int stereoMode = -1;
        public boolean hasColorInfo = false;
        public int colorSpace = -1;
        public int colorTransfer = -1;
        public int colorRange = -1;
        public int maxContentLuminance = 1000;
        public int maxFrameAverageLuminance = 200;
        public float primaryRChromaticityX = -1.0f;
        public float primaryRChromaticityY = -1.0f;
        public float primaryGChromaticityX = -1.0f;
        public float primaryGChromaticityY = -1.0f;
        public float primaryBChromaticityX = -1.0f;
        public float primaryBChromaticityY = -1.0f;
        public float whitePointChromaticityX = -1.0f;
        public float whitePointChromaticityY = -1.0f;
        public float maxMasteringLuminance = -1.0f;
        public float minMasteringLuminance = -1.0f;
        public int channelCount = 1;
        public int audioBitDepth = -1;
        public int sampleRate = 8000;
        public long codecDelayNs = 0;
        public long seekPreRollNs = 0;
        public boolean flagDefault = true;
        private String language = "eng";

        /* JADX INFO: Access modifiers changed from: private */
        @EnsuresNonNull({c.g})
        public void assertOutputInitialized() {
            Assertions.checkNotNull(this.output);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] getCodecPrivate(String str) throws ParserException {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        @Nullable
        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.maxMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) (this.minMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) this.maxContentLuminance);
            byteBufferOrder.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (littleEndianUnsignedInt == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (littleEndianUnsignedInt == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (littleEndianUnsignedInt != 826496599) {
                    Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>("video/x-unknown", null);
                }
                byte[] data = parsableByteArray.getData();
                for (int position = parsableByteArray.getPosition() + 20; position < data.length - 4; position++) {
                    if (data[position] == 0 && data[position + 1] == 0 && data[position + 2] == 1 && data[position + 3] == 15) {
                        return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(data, position, data.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (littleEndianUnsignedShort == 1) {
                    return true;
                }
                if (littleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                return parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4] & 255;
                    if (i != 255) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + i;
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5] & 255;
                    if (i2 != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + i2;
                if (bArr[i8] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean samplesHaveSupplementalData(boolean z) {
            if ("A_OPUS".equals(this.codecId)) {
                return z;
            }
            return this.maxBlockAdditionId > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:206:0x042f  */
        /* JADX WARN: Code duplicated, block: B:211:0x0447  */
        /* JADX WARN: Code duplicated, block: B:212:0x0449  */
        /* JADX WARN: Code duplicated, block: B:215:0x0456  */
        /* JADX WARN: Code duplicated, block: B:216:0x0468  */
        /* JADX WARN: Code duplicated, block: B:218:0x046e  */
        /* JADX WARN: Code duplicated, block: B:220:0x0472  */
        /* JADX WARN: Code duplicated, block: B:222:0x0477  */
        /* JADX WARN: Code duplicated, block: B:225:0x047f  */
        /* JADX WARN: Code duplicated, block: B:227:0x0484  */
        /* JADX WARN: Code duplicated, block: B:230:0x0489  */
        /* JADX WARN: Code duplicated, block: B:233:0x0497  */
        /* JADX WARN: Code duplicated, block: B:236:0x049d  */
        /* JADX WARN: Code duplicated, block: B:239:0x04b0  */
        /* JADX WARN: Code duplicated, block: B:244:0x04d0  */
        /* JADX WARN: Code duplicated, block: B:250:0x04e9  */
        /* JADX WARN: Code duplicated, block: B:251:0x04eb  */
        /* JADX WARN: Code duplicated, block: B:253:0x04f5  */
        /* JADX WARN: Code duplicated, block: B:254:0x04f8  */
        /* JADX WARN: Code duplicated, block: B:256:0x0502  */
        /* JADX WARN: Code duplicated, block: B:262:0x051a  */
        /* JADX WARN: Code duplicated, block: B:264:0x0541  */
        /* JADX WARN: Code duplicated, block: B:266:0x0547  */
        /* JADX WARN: Code duplicated, block: B:282:0x0572  */
        /* JADX WARN: Code duplicated, block: B:4:0x0015  */
        @EnsuresNonNull({"this.output"})
        @RequiresNonNull({"codecId"})
        public void initializeOutput(ExtractorOutput extractorOutput, int i) throws ParserException {
            byte b;
            List<byte[]> listSingletonList;
            String str;
            int pcmEncoding;
            String str2;
            String str3;
            int i2;
            int i3;
            int i4;
            List<byte[]> list;
            String str4;
            String str5;
            String str6;
            int i5;
            int i6;
            Format.Builder builder;
            int i7;
            int iIntValue;
            int i8;
            float f;
            int i9;
            int i10;
            int i11;
            DolbyVisionConfig dolbyVisionConfig;
            String str7 = this.codecId;
            str7.hashCode();
            switch (str7) {
                case "V_MPEG4/ISO/AP":
                    b = 0;
                    break;
                case "V_MPEG4/ISO/SP":
                    b = 1;
                    break;
                case "A_MS/ACM":
                    b = 2;
                    break;
                case "A_TRUEHD":
                    b = 3;
                    break;
                case "A_VORBIS":
                    b = 4;
                    break;
                case "A_MPEG/L2":
                    b = 5;
                    break;
                case "A_MPEG/L3":
                    b = 6;
                    break;
                case "V_MS/VFW/FOURCC":
                    b = 7;
                    break;
                case "S_DVBSUB":
                    b = 8;
                    break;
                case "V_MPEG4/ISO/ASP":
                    b = 9;
                    break;
                case "V_MPEG4/ISO/AVC":
                    b = 10;
                    break;
                case "S_VOBSUB":
                    b = 11;
                    break;
                case "A_DTS/LOSSLESS":
                    b = 12;
                    break;
                case "A_AAC":
                    b = 13;
                    break;
                case "A_AC3":
                    b = com.google.common.base.a.p;
                    break;
                case "A_DTS":
                    b = com.google.common.base.a.q;
                    break;
                case "V_AV1":
                    b = 16;
                    break;
                case "V_VP8":
                    b = 17;
                    break;
                case "V_VP9":
                    b = com.google.common.base.a.u;
                    break;
                case "S_HDMV/PGS":
                    b = 19;
                    break;
                case "V_THEORA":
                    b = com.google.common.base.a.x;
                    break;
                case "A_DTS/EXPRESS":
                    b = com.google.common.base.a.y;
                    break;
                case "A_PCM/FLOAT/IEEE":
                    b = com.google.common.base.a.z;
                    break;
                case "A_PCM/INT/BIG":
                    b = com.google.common.base.a.A;
                    break;
                case "A_PCM/INT/LIT":
                    b = com.google.common.base.a.B;
                    break;
                case "S_TEXT/ASS":
                    b = com.google.common.base.a.C;
                    break;
                case "V_MPEGH/ISO/HEVC":
                    b = com.google.common.base.a.D;
                    break;
                case "S_TEXT/WEBVTT":
                    b = com.google.common.base.a.E;
                    break;
                case "S_TEXT/UTF8":
                    b = com.google.common.base.a.F;
                    break;
                case "V_MPEG2":
                    b = com.google.common.base.a.G;
                    break;
                case "A_EAC3":
                    b = com.google.common.base.a.H;
                    break;
                case "A_FLAC":
                    b = 31;
                    break;
                case "A_OPUS":
                    b = 32;
                    break;
                default:
                    b = -1;
                    break;
            }
            int i12 = 4096;
            String str8 = "audio/raw";
            switch (b) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr = this.codecPrivate;
                    listSingletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str = "video/mp4v-es";
                    str8 = str;
                    i4 = -1;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null && (dolbyVisionConfig = DolbyVisionConfig.parse(new ParsableByteArray(this.dolbyVisionConfigBytes))) != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i13 = (z ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    } else if (MimeTypes.isVideo(str2)) {
                        if (this.displayUnit == 0) {
                            i10 = this.displayWidth;
                            iIntValue = -1;
                            if (i10 == -1) {
                                i10 = this.width;
                            }
                            this.displayWidth = i10;
                            i11 = this.displayHeight;
                            if (i11 == -1) {
                                i11 = this.height;
                            }
                            this.displayHeight = i11;
                        } else {
                            iIntValue = -1;
                        }
                        i8 = this.displayWidth;
                        if (i8 != iIntValue || (i9 = this.displayHeight) == iIntValue) {
                            f = -1.0f;
                        } else {
                            f = (this.height * i8) / (this.width * i9);
                        }
                        ColorInfo colorInfo = this.hasColorInfo ? new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo()) : null;
                        if (this.name != null && MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) {
                            iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                        }
                        if (this.projectionType == 0 && Float.compare(this.projectionPoseYaw, 0.0f) == 0 && Float.compare(this.projectionPosePitch, 0.0f) == 0) {
                            if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                iIntValue = 0;
                            } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                iIntValue = 90;
                            } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0 || Float.compare(this.projectionPosePitch, 180.0f) == 0) {
                                iIntValue = 180;
                            } else if (Float.compare(this.projectionPosePitch, -90.0f) == 0) {
                                iIntValue = 270;
                            }
                        }
                        builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                        i7 = 2;
                    } else {
                        if ("application/x-subrip".equals(str2) && !"text/x-ssa".equals(str2) && !"text/vtt".equals(str2) && !"application/vobsub".equals(str2) && !"application/pgs".equals(str2) && !"application/dvbsubs".equals(str2)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                        }
                        i7 = 3;
                    }
                    if (this.name != null && !MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i13).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack;
                    trackOutputTrack.format(formatBuild);
                    return;
                case 2:
                    if (parseMsAcmCodecPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)))) {
                        pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                        if (pcmEncoding == 0) {
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        }
                        i4 = pcmEncoding;
                        listSingletonList = null;
                        i5 = i4;
                        str6 = null;
                        i3 = i5;
                        i2 = -1;
                        str3 = str6;
                        str2 = str8;
                        if (this.dolbyVisionConfigBytes != null) {
                            str3 = dolbyVisionConfig.codecs;
                            str2 = "video/dolby-vision";
                        }
                        boolean z2 = this.flagDefault;
                        if (this.flagForced) {
                            i6 = 2;
                        } else {
                            i6 = 0;
                        }
                        int i14 = (z2 ? 1 : 0) | i6;
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str2)) {
                            if (MimeTypes.isVideo(str2)) {
                                if (this.displayUnit == 0) {
                                    i10 = this.displayWidth;
                                    iIntValue = -1;
                                    if (i10 == -1) {
                                        i10 = this.width;
                                    }
                                    this.displayWidth = i10;
                                    i11 = this.displayHeight;
                                    if (i11 == -1) {
                                        i11 = this.height;
                                    }
                                    this.displayHeight = i11;
                                } else {
                                    iIntValue = -1;
                                }
                                i8 = this.displayWidth;
                                if (i8 != iIntValue) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.hasColorInfo) {
                                }
                                if (this.name != null) {
                                    iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                                }
                                if (this.projectionType == 0) {
                                    if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                        iIntValue = 0;
                                    } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                        iIntValue = 90;
                                    } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                        iIntValue = 180;
                                    } else {
                                        iIntValue = 180;
                                    }
                                }
                                builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                                i7 = 2;
                            } else {
                                if ("application/x-subrip".equals(str2)) {
                                }
                                i7 = 3;
                            }
                            break;
                        } else {
                            builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                            i7 = 1;
                        }
                        if (this.name != null) {
                            builder.setLabel(this.name);
                        }
                        Format formatBuild2 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i14).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack2 = extractorOutput.track(this.number, i7);
                        this.output = trackOutputTrack2;
                        trackOutputTrack2.format(formatBuild2);
                        return;
                    }
                    Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    str8 = "audio/x-unknown";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z3 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i15 = (z3 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild3 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i15).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack3 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack3;
                    trackOutputTrack3.format(formatBuild3);
                    return;
                case 3:
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str8 = "audio/true-hd";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z4 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i16 = (z4 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild4 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i16).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack4 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack4;
                    trackOutputTrack4.format(formatBuild4);
                    return;
                case 4:
                    listSingletonList = parseVorbisCodecPrivate(getCodecPrivate(this.codecId));
                    str2 = "audio/vorbis";
                    i12 = 8192;
                    str3 = null;
                    i2 = i12;
                    i3 = -1;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z5 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i17 = (z5 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild5 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i17).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack5 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack5;
                    trackOutputTrack5.format(formatBuild5);
                    return;
                case 5:
                    str2 = "audio/mpeg-L2";
                    listSingletonList = null;
                    str3 = null;
                    i2 = i12;
                    i3 = -1;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z6 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i18 = (z6 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild6 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i18).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack6 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack6;
                    trackOutputTrack6.format(formatBuild6);
                    return;
                case 6:
                    str2 = "audio/mpeg";
                    listSingletonList = null;
                    str3 = null;
                    i2 = i12;
                    i3 = -1;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z7 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i19 = (z7 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild7 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i19).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack7 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack7;
                    trackOutputTrack7.format(formatBuild7);
                    return;
                case 7:
                    Pair<String, List<byte[]>> fourCcPrivate = parseFourCcPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    str = (String) fourCcPrivate.first;
                    listSingletonList = (List) fourCcPrivate.second;
                    str8 = str;
                    i4 = -1;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z8 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i110 = (z8 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild8 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i110).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack8 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack8;
                    trackOutputTrack8.format(formatBuild8);
                    return;
                case 8:
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(getCodecPrivate(this.codecId), 0, bArr2, 0, 4);
                    listSingletonList = ImmutableList.of(bArr2);
                    str8 = "application/dvbsubs";
                    i4 = -1;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z9 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i111 = (z9 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild9 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i111).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack9 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack9;
                    trackOutputTrack9.format(formatBuild9);
                    return;
                case 10:
                    AvcConfig avcConfig = AvcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list = avcConfig.initializationData;
                    this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                    str4 = avcConfig.codecs;
                    str5 = "video/avc";
                    str8 = str5;
                    i5 = -1;
                    List<byte[]> list2 = list;
                    str6 = str4;
                    listSingletonList = list2;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z10 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i112 = (z10 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild10 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i112).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack10 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack10;
                    trackOutputTrack10.format(formatBuild10);
                    return;
                case 11:
                    listSingletonList = ImmutableList.of(getCodecPrivate(this.codecId));
                    str8 = "application/vobsub";
                    i4 = -1;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z11 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i113 = (z11 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild11 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i113).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack11 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack11;
                    trackOutputTrack11.format(formatBuild11);
                    return;
                case 12:
                    str8 = "audio/vnd.dts.hd";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z12 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i114 = (z12 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild12 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i114).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack12 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack12;
                    trackOutputTrack12.format(formatBuild12);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(getCodecPrivate(this.codecId));
                    AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(this.codecPrivate);
                    this.sampleRate = audioSpecificConfig.sampleRateHz;
                    this.channelCount = audioSpecificConfig.channelCount;
                    str6 = audioSpecificConfig.codecs;
                    str8 = "audio/mp4a-latm";
                    i5 = -1;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z13 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i115 = (z13 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild13 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i115).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack13 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack13;
                    trackOutputTrack13.format(formatBuild13);
                    return;
                case 14:
                    str8 = "audio/ac3";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z14 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i116 = (z14 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild14 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i116).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack14 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack14;
                    trackOutputTrack14.format(formatBuild14);
                    return;
                case 15:
                case 21:
                    str8 = "audio/vnd.dts";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z15 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i117 = (z15 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild15 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i117).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack15 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack15;
                    trackOutputTrack15.format(formatBuild15);
                    return;
                case 16:
                    str8 = "video/av01";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z16 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i118 = (z16 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild16 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i118).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack16 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack16;
                    trackOutputTrack16.format(formatBuild16);
                    return;
                case 17:
                    str8 = "video/x-vnd.on2.vp8";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z17 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i119 = (z17 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild17 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i119).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack17 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack17;
                    trackOutputTrack17.format(formatBuild17);
                    return;
                case 18:
                    str8 = "video/x-vnd.on2.vp9";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z18 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1110 = (z18 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild18 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1110).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack18 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack18;
                    trackOutputTrack18.format(formatBuild18);
                    return;
                case 19:
                    str8 = "application/pgs";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z19 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1111 = (z19 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild19 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1111).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack19 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack19;
                    trackOutputTrack19.format(formatBuild19);
                    return;
                case 20:
                    str8 = "video/x-unknown";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z110 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1112 = (z110 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild110 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1112).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack110 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack110;
                    trackOutputTrack110.format(formatBuild110);
                    return;
                case 22:
                    if (this.audioBitDepth == 32) {
                        pcmEncoding = 4;
                    } else {
                        Log.w("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        str8 = "audio/x-unknown";
                        pcmEncoding = -1;
                    }
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z111 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1113 = (z111 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild111 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1113).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack111 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack111;
                    trackOutputTrack111.format(formatBuild111);
                    return;
                case 23:
                    int i20 = this.audioBitDepth;
                    if (i20 == 8) {
                        pcmEncoding = 3;
                    } else if (i20 == 16) {
                        pcmEncoding = 268435456;
                    } else {
                        Log.w("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        str8 = "audio/x-unknown";
                        pcmEncoding = -1;
                    }
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z112 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1114 = (z112 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild112 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1114).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack112 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack112;
                    trackOutputTrack112.format(formatBuild112);
                    return;
                case 24:
                    pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                    if (pcmEncoding == 0) {
                        Log.w("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        str8 = "audio/x-unknown";
                        pcmEncoding = -1;
                    }
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z113 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1115 = (z113 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild113 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1115).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack113 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack113;
                    trackOutputTrack113.format(formatBuild113);
                    return;
                case 25:
                    listSingletonList = ImmutableList.of(MatroskaExtractor.SSA_DIALOGUE_FORMAT, getCodecPrivate(this.codecId));
                    str8 = "text/x-ssa";
                    i4 = -1;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z114 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1116 = (z114 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild114 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1116).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack114 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack114;
                    trackOutputTrack114.format(formatBuild114);
                    return;
                case 26:
                    HevcConfig hevcConfig = HevcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list = hevcConfig.initializationData;
                    this.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                    str4 = hevcConfig.codecs;
                    str5 = "video/hevc";
                    str8 = str5;
                    i5 = -1;
                    List<byte[]> list3 = list;
                    str6 = str4;
                    listSingletonList = list3;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z115 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1117 = (z115 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild115 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1117).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack115 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack115;
                    trackOutputTrack115.format(formatBuild115);
                    return;
                case 27:
                    str8 = "text/vtt";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z116 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1118 = (z116 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild116 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1118).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack116 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack116;
                    trackOutputTrack116.format(formatBuild116);
                    return;
                case 28:
                    str8 = "application/x-subrip";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z117 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i1119 = (z117 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild117 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i1119).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack117 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack117;
                    trackOutputTrack117.format(formatBuild117);
                    return;
                case 29:
                    str8 = "video/mpeg2";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z118 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i11110 = (z118 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild118 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i11110).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack118 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack118;
                    trackOutputTrack118.format(formatBuild118);
                    return;
                case 30:
                    str8 = "audio/eac3";
                    pcmEncoding = -1;
                    i4 = pcmEncoding;
                    listSingletonList = null;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z119 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i11111 = (z119 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild119 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i11111).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack119 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack119;
                    trackOutputTrack119.format(formatBuild119);
                    return;
                case 31:
                    listSingletonList = Collections.singletonList(getCodecPrivate(this.codecId));
                    str8 = "audio/flac";
                    i4 = -1;
                    i5 = i4;
                    str6 = null;
                    i3 = i5;
                    i2 = -1;
                    str3 = str6;
                    str2 = str8;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1110 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i11112 = (z1110 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild1110 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i11112).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack1110 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack1110;
                    trackOutputTrack1110.format(formatBuild1110);
                    return;
                case 32:
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(getCodecPrivate(this.codecId));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.codecDelayNs).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.seekPreRollNs).array());
                    str2 = "audio/opus";
                    str3 = null;
                    i2 = 5760;
                    i3 = -1;
                    if (this.dolbyVisionConfigBytes != null) {
                        str3 = dolbyVisionConfig.codecs;
                        str2 = "video/dolby-vision";
                    }
                    boolean z1111 = this.flagDefault;
                    if (this.flagForced) {
                        i6 = 2;
                    } else {
                        i6 = 0;
                    }
                    int i11113 = (z1111 ? 1 : 0) | i6;
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str2)) {
                        if (MimeTypes.isVideo(str2)) {
                            if (this.displayUnit == 0) {
                                i10 = this.displayWidth;
                                iIntValue = -1;
                                if (i10 == -1) {
                                    i10 = this.width;
                                }
                                this.displayWidth = i10;
                                i11 = this.displayHeight;
                                if (i11 == -1) {
                                    i11 = this.height;
                                }
                                this.displayHeight = i11;
                            } else {
                                iIntValue = -1;
                            }
                            i8 = this.displayWidth;
                            if (i8 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                                    iIntValue = 0;
                                } else if (Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                                    iIntValue = 90;
                                } else if (Float.compare(this.projectionPosePitch, -180.0f) != 0) {
                                    iIntValue = 180;
                                } else {
                                    iIntValue = 180;
                                }
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(iIntValue).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfo);
                            i7 = 2;
                        } else {
                            if ("application/x-subrip".equals(str2)) {
                            }
                            i7 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i3);
                        i7 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format formatBuild1111 = builder.setId(i).setSampleMimeType(str2).setMaxInputSize(i2).setLanguage(this.language).setSelectionFlags(i11113).setInitializationData(listSingletonList).setCodecs(str3).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack1111 = extractorOutput.track(this.number, i7);
                    this.output = trackOutputTrack1111;
                    trackOutputTrack1111.format(formatBuild1111);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
        }

        @RequiresNonNull({c.g})
        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this.output, this.cryptoData);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(map);
    }

    public MatroskaExtractor() {
        this(0);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void assertInCues(int i) throws ParserException {
        if (this.cueTimesUs == null || this.cueClusterPositions == null) {
            throw ParserException.createForMalformedContainer("Element " + i + " must be in a Cues", null);
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void assertInTrackEntry(int i) throws ParserException {
        if (this.currentTrack != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i + " must be in a TrackEntry", null);
    }

    @EnsuresNonNull({"extractorOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.extractorOutput);
    }

    private SeekMap buildSeekMap(@Nullable LongArray longArray, @Nullable LongArray longArray2) {
        int i;
        if (this.segmentContentPosition == -1 || this.durationUs == -9223372036854775807L || longArray == null || longArray.size() == 0 || longArray2 == null || longArray2.size() != longArray.size()) {
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = longArray.size();
        int[] iArrCopyOf = new int[size];
        long[] jArrCopyOf = new long[size];
        long[] jArrCopyOf2 = new long[size];
        long[] jArrCopyOf3 = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jArrCopyOf3[i3] = longArray.get(i3);
            jArrCopyOf[i3] = this.segmentContentPosition + longArray2.get(i3);
        }
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArrCopyOf[i2] = (int) (jArrCopyOf[i4] - jArrCopyOf[i2]);
            jArrCopyOf2[i2] = jArrCopyOf3[i4] - jArrCopyOf3[i2];
            i2 = i4;
        }
        iArrCopyOf[i] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArrCopyOf[i]);
        long j = this.durationUs - jArrCopyOf3[i];
        jArrCopyOf2[i] = j;
        if (j <= 0) {
            Log.w("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i);
        }
        return new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    @RequiresNonNull({"#1.output"})
    private void commitSampleToOutput(Track track, long j, int i, int i2, int i3) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track.output, j, i, i2, i3, track.cryptoData);
        } else {
            if ("S_TEXT/UTF8".equals(track.codecId) || "S_TEXT/ASS".equals(track.codecId) || "S_TEXT/WEBVTT".equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.blockDurationUs;
                    if (j2 == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        setSubtitleEndTime(track.codecId, j2, this.subtitleSample.getData());
                        for (int position = this.subtitleSample.getPosition(); position < this.subtitleSample.limit(); position++) {
                            if (this.subtitleSample.getData()[position] == 0) {
                                this.subtitleSample.setLimit(position);
                                break;
                            }
                        }
                        TrackOutput trackOutput = track.output;
                        ParsableByteArray parsableByteArray = this.subtitleSample;
                        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                        i2 += this.subtitleSample.limit();
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.blockSampleCount > 1) {
                    this.supplementalData.reset(0);
                } else {
                    int iLimit = this.supplementalData.limit();
                    track.output.sampleData(this.supplementalData, iLimit, 2);
                    i2 += iLimit;
                }
            }
            track.output.sampleMetadata(j, i, i2, i3, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private static int[] ensureArrayCapacity(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    private int finishWriteSampleData() {
        int i = this.sampleBytesWritten;
        resetWriteSampleData();
        return i;
    }

    private static byte[] formatSubtitleTimecode(long j, String str, long j2) {
        Assertions.checkArgument(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean isCodecSupported(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    b = 0;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    b = 1;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    b = 2;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    b = 3;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    b = 4;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    b = 5;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    b = 6;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    b = 7;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    b = 8;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    b = 9;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    b = 10;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    b = 11;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    b = 12;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    b = 13;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    b = com.google.common.base.a.p;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    b = com.google.common.base.a.q;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    b = com.google.common.base.a.r;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    b = 17;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    b = com.google.common.base.a.u;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    b = 19;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    b = com.google.common.base.a.x;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    b = com.google.common.base.a.y;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    b = com.google.common.base.a.z;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    b = com.google.common.base.a.A;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    b = com.google.common.base.a.B;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    b = com.google.common.base.a.C;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    b = com.google.common.base.a.D;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    b = com.google.common.base.a.E;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b = com.google.common.base.a.F;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b = com.google.common.base.a.G;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b = com.google.common.base.a.H;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b = 31;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b = 32;
                }
                break;
        }
        switch (b) {
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
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j2 = this.seekPositionAfterBuildingCues;
            if (j2 != -1) {
                positionHolder.position = j2;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i) {
        if (this.scratch.limit() >= i) {
            return;
        }
        if (this.scratch.capacity() < i) {
            ParsableByteArray parsableByteArray = this.scratch;
            parsableByteArray.ensureCapacity(Math.max(parsableByteArray.capacity() * 2, i));
        }
        extractorInput.readFully(this.scratch.getData(), this.scratch.limit(), i - this.scratch.limit());
        this.scratch.setLimit(i);
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    private long scaleTimecodeToUs(long j) throws ParserException {
        long j2 = this.timecodeScale;
        if (j2 != -9223372036854775807L) {
            return Util.scaleLargeTimestamp(j, j2, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void setSubtitleEndTime(String str, long j, byte[] bArr) {
        byte[] subtitleTimecode;
        int i;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                subtitleTimecode = formatSubtitleTimecode(j, "%01d:%02d:%02d:%02d", 10000L);
                i = 21;
                break;
            case "S_TEXT/WEBVTT":
                subtitleTimecode = formatSubtitleTimecode(j, "%02d:%02d:%02d.%03d", 1000L);
                i = 25;
                break;
            case "S_TEXT/UTF8":
                subtitleTimecode = formatSubtitleTimecode(j, "%02d:%02d:%02d,%03d", 1000L);
                i = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(subtitleTimecode, 0, bArr, i, subtitleTimecode.length);
    }

    @RequiresNonNull({"#2.output"})
    private int writeSampleData(ExtractorInput extractorInput, Track track, int i, boolean z) throws ParserException {
        int i2;
        if ("S_TEXT/UTF8".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i);
            return finishWriteSampleData();
        }
        if ("S_TEXT/ASS".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i);
            return finishWriteSampleData();
        }
        if ("S_TEXT/WEBVTT".equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, VTT_PREFIX, i);
            return finishWriteSampleData();
        }
        TrackOutput trackOutput = track.output;
        if (!this.sampleEncodingHandled) {
            if (track.hasContentEncryption) {
                this.blockFlags &= -1073741825;
                if (!this.sampleSignalByteRead) {
                    extractorInput.readFully(this.scratch.getData(), 0, 1);
                    this.sampleBytesRead++;
                    if ((this.scratch.getData()[0] & UnsignedBytes.f32243a) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.sampleSignalByte = this.scratch.getData()[0];
                    this.sampleSignalByteRead = true;
                }
                byte b = this.sampleSignalByte;
                if ((b & 1) == 1) {
                    boolean z2 = (b & 2) == 2;
                    this.blockFlags |= 1073741824;
                    if (!this.sampleInitializationVectorRead) {
                        extractorInput.readFully(this.encryptionInitializationVector.getData(), 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        this.scratch.getData()[0] = (byte) ((z2 ? 128 : 0) | 8);
                        this.scratch.setPosition(0);
                        trackOutput.sampleData(this.scratch, 1, 1);
                        this.sampleBytesWritten++;
                        this.encryptionInitializationVector.setPosition(0);
                        trackOutput.sampleData(this.encryptionInitializationVector, 8, 1);
                        this.sampleBytesWritten += 8;
                    }
                    if (z2) {
                        if (!this.samplePartitionCountRead) {
                            extractorInput.readFully(this.scratch.getData(), 0, 1);
                            this.sampleBytesRead++;
                            this.scratch.setPosition(0);
                            this.samplePartitionCount = this.scratch.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int i3 = this.samplePartitionCount * 4;
                        this.scratch.reset(i3);
                        extractorInput.readFully(this.scratch.getData(), 0, i3);
                        this.sampleBytesRead += i3;
                        short s = (short) ((this.samplePartitionCount / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i4);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.samplePartitionCount;
                            if (i5 >= i2) {
                                break;
                            }
                            int unsignedIntToInt = this.scratch.readUnsignedIntToInt();
                            if (i5 % 2 == 0) {
                                this.encryptionSubsampleDataBuffer.putShort((short) (unsignedIntToInt - i6));
                            } else {
                                this.encryptionSubsampleDataBuffer.putInt(unsignedIntToInt - i6);
                            }
                            i5++;
                            i6 = unsignedIntToInt;
                        }
                        int i7 = (i - this.sampleBytesRead) - i6;
                        if (i2 % 2 == 1) {
                            this.encryptionSubsampleDataBuffer.putInt(i7);
                        } else {
                            this.encryptionSubsampleDataBuffer.putShort((short) i7);
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i4);
                        trackOutput.sampleData(this.encryptionSubsampleData, i4, 1);
                        this.sampleBytesWritten += i4;
                    }
                }
            } else {
                byte[] bArr = track.sampleStrippedBytes;
                if (bArr != null) {
                    this.sampleStrippedBytes.reset(bArr, bArr.length);
                }
            }
            if (track.samplesHaveSupplementalData(z)) {
                this.blockFlags |= 268435456;
                this.supplementalData.reset(0);
                int iLimit = (this.sampleStrippedBytes.limit() + i) - this.sampleBytesRead;
                this.scratch.reset(4);
                this.scratch.getData()[0] = (byte) ((iLimit >> 24) & 255);
                this.scratch.getData()[1] = (byte) ((iLimit >> 16) & 255);
                this.scratch.getData()[2] = (byte) ((iLimit >> 8) & 255);
                this.scratch.getData()[3] = (byte) (iLimit & 255);
                trackOutput.sampleData(this.scratch, 4, 2);
                this.sampleBytesWritten += 4;
            }
            this.sampleEncodingHandled = true;
        }
        int iLimit2 = i + this.sampleStrippedBytes.limit();
        if (!"V_MPEG4/ISO/AVC".equals(track.codecId) && !"V_MPEGH/ISO/HEVC".equals(track.codecId)) {
            if (track.trueHdSampleRechunker != null) {
                Assertions.checkState(this.sampleStrippedBytes.limit() == 0);
                track.trueHdSampleRechunker.startSample(extractorInput);
            }
            while (true) {
                int i8 = this.sampleBytesRead;
                if (i8 >= iLimit2) {
                    break;
                }
                int iWriteToOutput = writeToOutput(extractorInput, trackOutput, iLimit2 - i8);
                this.sampleBytesRead += iWriteToOutput;
                this.sampleBytesWritten += iWriteToOutput;
            }
        } else {
            byte[] data = this.nalLength.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i9 = track.nalUnitLengthFieldLength;
            int i10 = 4 - i9;
            while (this.sampleBytesRead < iLimit2) {
                int i11 = this.sampleCurrentNalBytesRemaining;
                if (i11 == 0) {
                    writeToTarget(extractorInput, data, i10, i9);
                    this.sampleBytesRead += i9;
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                } else {
                    int iWriteToOutput2 = writeToOutput(extractorInput, trackOutput, i11);
                    this.sampleBytesRead += iWriteToOutput2;
                    this.sampleBytesWritten += iWriteToOutput2;
                    this.sampleCurrentNalBytesRemaining -= iWriteToOutput2;
                }
            }
        }
        if ("A_VORBIS".equals(track.codecId)) {
            this.vorbisNumPageSamples.setPosition(0);
            trackOutput.sampleData(this.vorbisNumPageSamples, 4);
            this.sampleBytesWritten += 4;
        }
        return finishWriteSampleData();
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.reset(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.getData(), bArr.length, i);
        this.subtitleSample.setPosition(0);
        this.subtitleSample.setLimit(length);
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i) {
        int iBytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (iBytesLeft <= 0) {
            return trackOutput.sampleData((DataReader) extractorInput, i, false);
        }
        int iMin = Math.min(i, iBytesLeft);
        trackOutput.sampleData(this.sampleStrippedBytes, iMin);
        return iMin;
    }

    private void writeToTarget(ExtractorInput extractorInput, byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i, iMin);
        }
    }

    /* JADX WARN: Code duplicated, block: B:99:0x027a  */
    @CallSuper
    public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws ParserException {
        Track track;
        int i3;
        Track track2;
        Track track3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        Throwable th = null;
        int i8 = 1;
        int i9 = 0;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (this.blockState != 2) {
                    return;
                }
                handleBlockAdditionalData(this.tracks.get(this.blockTrackNumber), this.blockAdditionalId, extractorInput, i2);
                return;
            }
            if (i == 16877) {
                handleBlockAddIDExtraData(getCurrentTrack(i), extractorInput, i2);
                return;
            }
            if (i == 16981) {
                assertInTrackEntry(i);
                byte[] bArr = new byte[i2];
                this.currentTrack.sampleStrippedBytes = bArr;
                extractorInput.readFully(bArr, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr2 = new byte[i2];
                extractorInput.readFully(bArr2, 0, i2);
                getCurrentTrack(i).cryptoData = new TrackOutput.CryptoData(1, bArr2, 0, 0);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.seekEntryIdBytes.getData(), (byte) 0);
                extractorInput.readFully(this.seekEntryIdBytes.getData(), 4 - i2, i2);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
                return;
            }
            if (i == 25506) {
                assertInTrackEntry(i);
                byte[] bArr3 = new byte[i2];
                this.currentTrack.codecPrivate = bArr3;
                extractorInput.readFully(bArr3, 0, i2);
                return;
            }
            if (i != 30322) {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i, null);
            }
            assertInTrackEntry(i);
            byte[] bArr4 = new byte[i2];
            this.currentTrack.projectionData = bArr4;
            extractorInput.readFully(bArr4, 0, i2);
            return;
        }
        if (this.blockState == 0) {
            this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            this.blockTrackNumberLength = this.varintReader.getLastLength();
            this.blockDurationUs = -9223372036854775807L;
            this.blockState = 1;
            this.scratch.reset(0);
        }
        Track track4 = this.tracks.get(this.blockTrackNumber);
        if (track4 == null) {
            extractorInput.skipFully(i2 - this.blockTrackNumberLength);
            this.blockState = 0;
            return;
        }
        track4.assertOutputInitialized();
        if (this.blockState == 1) {
            readScratch(extractorInput, 3);
            int i10 = (this.scratch.getData()[2] & 6) >> 1;
            if (i10 == 0) {
                this.blockSampleCount = 1;
                int[] iArrEnsureArrayCapacity = ensureArrayCapacity(this.blockSampleSizes, 1);
                this.blockSampleSizes = iArrEnsureArrayCapacity;
                iArrEnsureArrayCapacity[0] = (i2 - this.blockTrackNumberLength) - 3;
            } else {
                int i11 = 4;
                readScratch(extractorInput, 4);
                int i12 = (this.scratch.getData()[3] & 255) + 1;
                this.blockSampleCount = i12;
                int[] iArrEnsureArrayCapacity2 = ensureArrayCapacity(this.blockSampleSizes, i12);
                this.blockSampleSizes = iArrEnsureArrayCapacity2;
                if (i10 == 2) {
                    int i13 = (i2 - this.blockTrackNumberLength) - 4;
                    int i14 = this.blockSampleCount;
                    Arrays.fill(iArrEnsureArrayCapacity2, 0, i14, i13 / i14);
                } else {
                    if (i10 == 1) {
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i4 = this.blockSampleCount - 1;
                            if (i15 >= i4) {
                                break;
                            }
                            this.blockSampleSizes[i15] = 0;
                            while (true) {
                                i5 = i11 + 1;
                                readScratch(extractorInput, i5);
                                int i17 = this.scratch.getData()[i11] & 255;
                                int[] iArr = this.blockSampleSizes;
                                i6 = iArr[i15] + i17;
                                iArr[i15] = i6;
                                if (i17 != 255) {
                                    break;
                                } else {
                                    i11 = i5;
                                }
                            }
                            i16 += i6;
                            i15++;
                            i11 = i5;
                        }
                        this.blockSampleSizes[i4] = ((i2 - this.blockTrackNumberLength) - i11) - i16;
                    } else {
                        if (i10 != 3) {
                            throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i10, null);
                        }
                        int i18 = 0;
                        int i19 = 0;
                        while (true) {
                            int i20 = this.blockSampleCount - i8;
                            if (i18 >= i20) {
                                track2 = track4;
                                this.blockSampleSizes[i20] = ((i2 - this.blockTrackNumberLength) - i11) - i19;
                                break;
                            }
                            this.blockSampleSizes[i18] = i9;
                            int i21 = i11 + 1;
                            readScratch(extractorInput, i21);
                            if (this.scratch.getData()[i11] == 0) {
                                throw ParserException.createForMalformedContainer("No valid varint length mask found", th);
                            }
                            int i22 = i9;
                            while (true) {
                                if (i22 < 8) {
                                    int i23 = i8 << (7 - i22);
                                    if ((this.scratch.getData()[i11] & i23) != 0) {
                                        int i24 = i21 + i22;
                                        readScratch(extractorInput, i24);
                                        j = (~i23) & this.scratch.getData()[i11] & 255;
                                        while (i21 < i24) {
                                            j = (j << 8) | ((long) (this.scratch.getData()[i21] & 255));
                                            i21++;
                                            track4 = track4;
                                        }
                                        track3 = track4;
                                        if (i18 > 0) {
                                            j -= (1 << ((i22 * 7) + 6)) - 1;
                                            i11 = i24;
                                            break;
                                        }
                                        i21 = i24;
                                    } else {
                                        i22++;
                                        i8 = 1;
                                    }
                                } else {
                                    track3 = track4;
                                    j = 0;
                                }
                                i11 = i21;
                                break;
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
                            }
                            int i25 = (int) j;
                            int[] iArr2 = this.blockSampleSizes;
                            if (i18 != 0) {
                                i25 += iArr2[i18 - 1];
                            }
                            iArr2[i18] = i25;
                            i19 += i25;
                            i18++;
                            track4 = track3;
                            th = null;
                            i8 = 1;
                            i9 = 0;
                        }
                    }
                    this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((this.scratch.getData()[0] << 8) | (this.scratch.getData()[1] & 255));
                    track = track2;
                    if (track.type != 2 || (i == 163 && (this.scratch.getData()[2] & UnsignedBytes.f32243a) == 128)) {
                        i7 = 1;
                    } else {
                        i7 = 0;
                    }
                    this.blockFlags = i7;
                    this.blockState = 2;
                    this.blockSampleIndex = 0;
                    i3 = 163;
                }
            }
            track2 = track4;
            this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((this.scratch.getData()[0] << 8) | (this.scratch.getData()[1] & 255));
            track = track2;
            if (track.type != 2) {
                i7 = 1;
            } else {
                i7 = 1;
            }
            this.blockFlags = i7;
            this.blockState = 2;
            this.blockSampleIndex = 0;
            i3 = 163;
        } else {
            track = track4;
            i3 = 163;
        }
        if (i == i3) {
            while (true) {
                int i26 = this.blockSampleIndex;
                if (i26 >= this.blockSampleCount) {
                    this.blockState = 0;
                    return;
                }
                commitSampleToOutput(track, ((long) ((this.blockSampleIndex * track.defaultSampleDurationNs) / 1000)) + this.blockTimeUs, this.blockFlags, writeSampleData(extractorInput, track, this.blockSampleSizes[i26], false), 0);
                this.blockSampleIndex++;
            }
        } else {
            while (true) {
                int i27 = this.blockSampleIndex;
                if (i27 >= this.blockSampleCount) {
                    return;
                }
                int[] iArr3 = this.blockSampleSizes;
                iArr3[i27] = writeSampleData(extractorInput, track, iArr3[i27], true);
                this.blockSampleIndex++;
            }
        }
    }

    @CallSuper
    public void endMasterElement(int i) throws ParserException {
        assertInitialized();
        if (i == 160) {
            if (this.blockState != 2) {
                return;
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            track.assertOutputInitialized();
            if (this.blockGroupDiscardPaddingNs > 0 && "A_OPUS".equals(track.codecId)) {
                this.supplementalData.reset(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.blockGroupDiscardPaddingNs).array());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.blockSampleCount; i3++) {
                i2 += this.blockSampleSizes[i3];
            }
            int i4 = 0;
            while (i4 < this.blockSampleCount) {
                long j = this.blockTimeUs + ((long) ((track.defaultSampleDurationNs * i4) / 1000));
                int i5 = this.blockFlags;
                if (i4 == 0 && !this.blockHasReferenceBlock) {
                    i5 |= 1;
                }
                int i6 = this.blockSampleSizes[i4];
                int i7 = i2 - i6;
                commitSampleToOutput(track, j, i5, i6, i7);
                i4++;
                i2 = i7;
            }
            this.blockState = 0;
            return;
        }
        if (i == 174) {
            Track track2 = (Track) Assertions.checkStateNotNull(this.currentTrack);
            String str = track2.codecId;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (isCodecSupported(str)) {
                track2.initializeOutput(this.extractorOutput, track2.number);
                this.tracks.put(track2.number, track2);
            }
            this.currentTrack = null;
            return;
        }
        if (i == 19899) {
            int i8 = this.seekEntryId;
            if (i8 != -1) {
                long j2 = this.seekEntryPosition;
                if (j2 != -1) {
                    if (i8 == 475249515) {
                        this.cuesContentPosition = j2;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i == 25152) {
            assertInTrackEntry(i);
            Track track3 = this.currentTrack;
            if (track3.hasContentEncryption) {
                if (track3.cryptoData == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                track3.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey));
                return;
            }
            return;
        }
        if (i == 28032) {
            assertInTrackEntry(i);
            Track track4 = this.currentTrack;
            if (track4.hasContentEncryption && track4.sampleStrippedBytes != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.timecodeScale == -9223372036854775807L) {
                this.timecodeScale = 1000000L;
            }
            long j3 = this.durationTimecode;
            if (j3 != -9223372036854775807L) {
                this.durationUs = scaleTimecodeToUs(j3);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.tracks.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.extractorOutput.endTracks();
        } else {
            if (i != 475249515) {
                return;
            }
            if (!this.sentSeekMap) {
                this.extractorOutput.seekMap(buildSeekMap(this.cueTimesUs, this.cueClusterPositions));
                this.sentSeekMap = true;
            }
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
        }
    }

    @CallSuper
    public void floatElement(int i, double d) {
        if (i == 181) {
            getCurrentTrack(i).sampleRate = (int) d;
        }
        if (i == 17545) {
            this.durationTimecode = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                getCurrentTrack(i).primaryRChromaticityX = (float) d;
                break;
            case 21970:
                getCurrentTrack(i).primaryRChromaticityY = (float) d;
                break;
            case 21971:
                getCurrentTrack(i).primaryGChromaticityX = (float) d;
                break;
            case 21972:
                getCurrentTrack(i).primaryGChromaticityY = (float) d;
                break;
            case 21973:
                getCurrentTrack(i).primaryBChromaticityX = (float) d;
                break;
            case 21974:
                getCurrentTrack(i).primaryBChromaticityY = (float) d;
                break;
            case 21975:
                getCurrentTrack(i).whitePointChromaticityX = (float) d;
                break;
            case 21976:
                getCurrentTrack(i).whitePointChromaticityY = (float) d;
                break;
            case 21977:
                getCurrentTrack(i).maxMasteringLuminance = (float) d;
                break;
            case 21978:
                getCurrentTrack(i).minMasteringLuminance = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        getCurrentTrack(i).projectionPoseYaw = (float) d;
                        break;
                    case 30324:
                        getCurrentTrack(i).projectionPosePitch = (float) d;
                        break;
                    case 30325:
                        getCurrentTrack(i).projectionPoseRoll = (float) d;
                        break;
                }
                break;
        }
    }

    public Track getCurrentTrack(int i) throws ParserException {
        assertInTrackEntry(i);
        return this.currentTrack;
    }

    @CallSuper
    public int getElementType(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public void handleBlockAddIDExtraData(Track track, ExtractorInput extractorInput, int i) {
        if (track.blockAddIdType != 1685485123 && track.blockAddIdType != 1685480259) {
            extractorInput.skipFully(i);
            return;
        }
        byte[] bArr = new byte[i];
        track.dolbyVisionConfigBytes = bArr;
        extractorInput.readFully(bArr, 0, i);
    }

    public void handleBlockAdditionalData(Track track, int i, ExtractorInput extractorInput, int i2) {
        if (i != 4 || !"V_VP9".equals(track.codecId)) {
            extractorInput.skipFully(i2);
        } else {
            this.supplementalData.reset(i2);
            extractorInput.readFully(this.supplementalData.getData(), 0, i2);
        }
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    @CallSuper
    public void integerElement(int i, long j) throws ParserException {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                getCurrentTrack(i).type = (int) j;
                return;
            case 136:
                getCurrentTrack(i).flagDefault = j == 1;
                return;
            case 155:
                this.blockDurationUs = scaleTimecodeToUs(j);
                return;
            case 159:
                getCurrentTrack(i).channelCount = (int) j;
                return;
            case 176:
                getCurrentTrack(i).width = (int) j;
                return;
            case 179:
                assertInCues(i);
                this.cueTimesUs.add(scaleTimecodeToUs(j));
                return;
            case 186:
                getCurrentTrack(i).height = (int) j;
                return;
            case 215:
                getCurrentTrack(i).number = (int) j;
                return;
            case 231:
                this.clusterTimecodeUs = scaleTimecodeToUs(j);
                return;
            case 238:
                this.blockAdditionalId = (int) j;
                return;
            case 241:
                if (this.seenClusterPositionForCurrentCuePoint) {
                    return;
                }
                assertInCues(i);
                this.cueClusterPositions.add(j);
                this.seenClusterPositionForCurrentCuePoint = true;
                return;
            case 251:
                this.blockHasReferenceBlock = true;
                return;
            case 16871:
                getCurrentTrack(i).blockAddIdType = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.seekEntryPosition = j + this.segmentContentPosition;
                return;
            case 21432:
                int i2 = (int) j;
                assertInTrackEntry(i);
                if (i2 == 0) {
                    this.currentTrack.stereoMode = 0;
                    return;
                }
                if (i2 == 1) {
                    this.currentTrack.stereoMode = 2;
                    return;
                } else if (i2 == 3) {
                    this.currentTrack.stereoMode = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.currentTrack.stereoMode = 3;
                    return;
                }
            case 21680:
                getCurrentTrack(i).displayWidth = (int) j;
                return;
            case 21682:
                getCurrentTrack(i).displayUnit = (int) j;
                return;
            case 21690:
                getCurrentTrack(i).displayHeight = (int) j;
                return;
            case 21930:
                getCurrentTrack(i).flagForced = j == 1;
                return;
            case 21998:
                getCurrentTrack(i).maxBlockAdditionId = (int) j;
                return;
            case 22186:
                getCurrentTrack(i).codecDelayNs = j;
                return;
            case 22203:
                getCurrentTrack(i).seekPreRollNs = j;
                return;
            case 25188:
                getCurrentTrack(i).audioBitDepth = (int) j;
                return;
            case 30114:
                this.blockGroupDiscardPaddingNs = j;
                return;
            case 30321:
                assertInTrackEntry(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.currentTrack.projectionType = 0;
                    return;
                }
                if (i3 == 1) {
                    this.currentTrack.projectionType = 1;
                    return;
                } else if (i3 == 2) {
                    this.currentTrack.projectionType = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.currentTrack.projectionType = 3;
                    return;
                }
            case 2352003:
                getCurrentTrack(i).defaultSampleDurationNs = (int) j;
                return;
            case 2807729:
                this.timecodeScale = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        assertInTrackEntry(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.currentTrack.colorRange = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.currentTrack.colorRange = 1;
                            return;
                        }
                    case 21946:
                        assertInTrackEntry(i);
                        int iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer((int) j);
                        if (iIsoTransferCharacteristicsToColorTransfer != -1) {
                            this.currentTrack.colorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                            return;
                        }
                        return;
                    case 21947:
                        assertInTrackEntry(i);
                        this.currentTrack.hasColorInfo = true;
                        int iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace((int) j);
                        if (iIsoColorPrimariesToColorSpace != -1) {
                            this.currentTrack.colorSpace = iIsoColorPrimariesToColorSpace;
                            return;
                        }
                        return;
                    case 21948:
                        getCurrentTrack(i).maxContentLuminance = (int) j;
                        return;
                    case 21949:
                        getCurrentTrack(i).maxFrameAverageLuminance = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public boolean isLevel1Element(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        this.haveOutputSample = false;
        boolean z = true;
        while (z && !this.haveOutputSample) {
            z = this.reader.read(extractorInput);
            if (z && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.tracks.size(); i++) {
            Track trackValueAt = this.tracks.valueAt(i);
            trackValueAt.assertOutputInitialized();
            trackValueAt.outputPendingSampleMetadata();
        }
        return -1;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public final void release() {
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    @CallSuper
    public void seek(long j, long j2) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).reset();
        }
    }

    @Override // com.google.android.inner_exoplayer2.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        return new Sniffer().sniff(extractorInput);
    }

    @CallSuper
    public void startMasterElement(int i, long j, long j2) throws ParserException {
        assertInitialized();
        if (i == 160) {
            this.blockHasReferenceBlock = false;
            this.blockGroupDiscardPaddingNs = 0L;
            return;
        }
        if (i == 174) {
            this.currentTrack = new Track();
            return;
        }
        if (i == 187) {
            this.seenClusterPositionForCurrentCuePoint = false;
            return;
        }
        if (i == 19899) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
            return;
        }
        if (i == 20533) {
            getCurrentTrack(i).hasContentEncryption = true;
            return;
        }
        if (i == 21968) {
            getCurrentTrack(i).hasColorInfo = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.segmentContentPosition;
            if (j3 != -1 && j3 != j) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.segmentContentPosition = j;
            this.segmentContentSize = j2;
            return;
        }
        if (i == 475249515) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i == 524531317 && !this.sentSeekMap) {
            if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                this.seekForCues = true;
            } else {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
            }
        }
    }

    @CallSuper
    public void stringElement(int i, String str) throws ParserException {
        if (i == 134) {
            getCurrentTrack(i).codecId = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                getCurrentTrack(i).name = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                getCurrentTrack(i).language = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    public MatroskaExtractor(int i) {
        this(new DefaultEbmlReader(), i);
    }

    public MatroskaExtractor(EbmlReader ebmlReader, int i) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlProcessor());
        this.seekForCuesEnabled = (i & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.supplementalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
    }
}
