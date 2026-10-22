package com.google.android.inner_exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.google.android.inner_exoplayer2.C;
import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.ParserException;
import com.google.android.inner_exoplayer2.drm.DrmInitData;
import com.google.android.inner_exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.inner_exoplayer2.metadata.Metadata;
import com.google.android.inner_exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.inner_exoplayer2.upstream.ParsingLoadable;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.Log;
import com.google.android.inner_exoplayer2.util.MimeTypes;
import com.google.android.inner_exoplayer2.util.UriUtil;
import com.google.android.inner_exoplayer2.util.Util;
import com.google.common.collect.o;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String LOG_TAG = "HlsPlaylistParser";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_IFRAME = "#EXT-X-I-FRAMES-ONLY";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_I_FRAME_STREAM_INF = "#EXT-X-I-FRAME-STREAM-INF";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PART = "#EXT-X-PART";
    private static final String TAG_PART_INF = "#EXT-X-PART-INF";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PRELOAD_HINT = "#EXT-X-PRELOAD-HINT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_RENDITION_REPORT = "#EXT-X-RENDITION-REPORT";
    private static final String TAG_SERVER_CONTROL = "#EXT-X-SERVER-CONTROL";
    private static final String TAG_SESSION_KEY = "#EXT-X-SESSION-KEY";
    private static final String TAG_SKIP = "#EXT-X-SKIP";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_MAP = "MAP";
    private static final String TYPE_PART = "PART";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMultivariantPlaylist multivariantPlaylist;

    @Nullable
    private final HlsMediaPlaylist previousMediaPlaylist;
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_ATTR_DURATION = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_TARGET_DURATION = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_CAN_SKIP_UNTIL = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_SKIP_DATE_RANGES = compileBooleanAttrPattern("CAN-SKIP-DATERANGES");
    private static final Pattern REGEX_SKIPPED_SEGMENTS = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern REGEX_HOLD_BACK = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_HOLD_BACK = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_BLOCK_RELOAD = compileBooleanAttrPattern("CAN-BLOCK-RELOAD");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern REGEX_LAST_MSN = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern REGEX_LAST_PART = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_BYTERANGE_START = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE_LENGTH = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_PRELOAD_HINT_TYPE = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_INDEPENDENT = compileBooleanAttrPattern("INDEPENDENT");
    private static final Pattern REGEX_GAP = compileBooleanAttrPattern("GAP");
    private static final Pattern REGEX_PRECISE = compileBooleanAttrPattern("PRECISE");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static final class DeltaUpdateException extends IOException {
    }

    public static class LineIterator {
        private final Queue<String> extraLines;

        @Nullable
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean hasNext() throws IOException {
            String strTrim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = (String) Assertions.checkNotNull(this.extraLines.poll());
                return true;
            }
            do {
                String line = this.reader.readLine();
                this.next = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.next = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.next;
            this.next = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.EMPTY, null);
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int i = bufferedReader.read();
        if (i == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i = bufferedReader.read();
        }
        int iSkipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, i);
        for (int i2 = 0; i2 < 7; i2++) {
            if (iSkipIgnorableWhitespace != "#EXTM3U".charAt(i2)) {
                return false;
            }
            iSkipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, iSkipIgnorableWhitespace));
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    private static DrmInitData getPlaylistProtectionSchemes(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i = 0; i < schemeDataArr.length; i++) {
            schemeDataArr2[i] = schemeDataArr[i].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @Nullable
    private static String getSegmentEncryptionIV(long j, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j);
    }

    @Nullable
    private static HlsMultivariantPlaylist.Variant getVariantWithAudioGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    @Nullable
    private static HlsMultivariantPlaylist.Variant getVariantWithSubtitleGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    @Nullable
    private static HlsMultivariantPlaylist.Variant getVariantWithVideoGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static double parseDoubleAttr(String str, Pattern pattern) {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    private static DrmInitData.SchemeData parseDrmSchemeData(String str, String str2, Map<String, String> map) throws ParserException {
        String optionalStringAttr = parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String stringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(stringAttr.substring(stringAttr.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, LiveConfigKey.HLS, Util.getUtf8Bytes(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(optionalStringAttr)) {
            return null;
        }
        String stringAttr2 = parseStringAttr(str, REGEX_URI, map);
        byte[] bArrDecode = Base64.decode(stringAttr2.substring(stringAttr2.indexOf(44)), 0);
        UUID uuid = C.PLAYREADY_UUID;
        return new DrmInitData.SchemeData(uuid, "video/mp4", PsshAtomUtil.buildPsshAtom(uuid, bArrDecode));
    }

    private static String parseEncryptionScheme(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int parseIntAttr(String str, Pattern pattern) {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static long parseLongAttr(String str, Pattern pattern) {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HlsMediaPlaylist parseMediaPlaylist(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist, LineIterator lineIterator, String str) throws ParserException, DeltaUpdateException {
        boolean z;
        String str2;
        int i;
        HlsMediaPlaylist.Part part;
        long j;
        long j2;
        boolean z2;
        DrmInitData drmInitData;
        long j3;
        long j4;
        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
        hlsMediaPlaylist = hlsMediaPlaylist;
        boolean z3 = hlsMultivariantPlaylist.hasIndependentSegments;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HlsMediaPlaylist.ServerControl serverControl = new HlsMediaPlaylist.ServerControl(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        boolean z4 = false;
        String str3 = "";
        boolean z5 = z3;
        HlsMediaPlaylist.ServerControl serverControl2 = serverControl;
        int i2 = 0;
        boolean optionalBooleanAttribute = false;
        boolean z6 = false;
        int i3 = 0;
        boolean z7 = false;
        boolean z8 = false;
        int i4 = 0;
        boolean z9 = false;
        String optionalStringAttr = str3;
        String stringAttr = null;
        long doubleAttr = -9223372036854775807L;
        long jMsToUs = 0;
        long j5 = 0;
        int intAttr = 1;
        long intAttr2 = -9223372036854775807L;
        long doubleAttr2 = -9223372036854775807L;
        DrmInitData playlistProtectionSchemes = null;
        long j6 = 0;
        DrmInitData drmInitData2 = null;
        long j7 = 0;
        long j8 = -1;
        String str4 = null;
        String encryptionScheme = null;
        long j9 = 0;
        long longAttr = 0;
        HlsMediaPlaylist.Segment segment = null;
        long timeSecondsToUs = 0;
        long j10 = 0;
        ArrayList arrayList5 = arrayList2;
        HlsMediaPlaylist.Part part2 = null;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith("#EXT")) {
                arrayList4.add(next);
            }
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String stringAttr2 = parseStringAttr(next, REGEX_PLAYLIST_TYPE, map);
                if ("VOD".equals(stringAttr2)) {
                    i2 = 1;
                } else if ("EVENT".equals(stringAttr2)) {
                    i2 = 2;
                } else {
                    z = z4 ? 1 : 0;
                    str2 = str4;
                    i = i2;
                    part = part2;
                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                    str4 = str2;
                    i2 = i;
                    part2 = part;
                    longAttr = longAttr;
                    encryptionScheme = encryptionScheme;
                    arrayList5 = arrayList5;
                    arrayList4 = arrayList4;
                    z4 = z;
                    hlsMediaPlaylist = hlsMediaPlaylist;
                }
            } else if (next.equals("#EXT-X-I-FRAMES-ONLY")) {
                z9 = true;
            } else if (next.startsWith("#EXT-X-START")) {
                doubleAttr = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
                optionalBooleanAttribute = parseOptionalBooleanAttribute(next, REGEX_PRECISE, z4);
            } else if (next.startsWith("#EXT-X-SERVER-CONTROL")) {
                serverControl2 = parseServerControl(next);
            } else if (next.startsWith("#EXT-X-PART-INF")) {
                doubleAttr2 = (long) (parseDoubleAttr(next, REGEX_PART_TARGET_DURATION) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                String stringAttr3 = parseStringAttr(next, REGEX_URI, map);
                String optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                if (optionalStringAttr2 != null) {
                    String[] strArrSplit = Util.split(optionalStringAttr2, "@");
                    j8 = Long.parseLong(strArrSplit[z4 ? 1 : 0]);
                    if (strArrSplit.length > 1) {
                        j6 = Long.parseLong(strArrSplit[1]);
                    }
                }
                if (j8 == -1) {
                    j6 = 0;
                }
                String str5 = str4;
                if (stringAttr != null && str5 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                segment = new HlsMediaPlaylist.Segment(stringAttr3, j6, j8, stringAttr, str5);
                if (j8 != -1) {
                    j6 += j8;
                }
                str4 = str5;
                j8 = -1;
            } else {
                str2 = str4;
                str4 = null;
                if (next.startsWith("#EXT-X-TARGETDURATION")) {
                    intAttr2 = 1000000 * ((long) parseIntAttr(next, REGEX_TARGET_DURATION));
                } else {
                    if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        longAttr = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                        str4 = str2;
                        j5 = longAttr;
                    } else if (next.startsWith("#EXT-X-VERSION")) {
                        intAttr = parseIntAttr(next, REGEX_VERSION);
                    } else if (next.startsWith("#EXT-X-DEFINE")) {
                        String optionalStringAttr3 = parseOptionalStringAttr(next, REGEX_IMPORT, map);
                        if (optionalStringAttr3 != null) {
                            String str6 = hlsMultivariantPlaylist.variableDefinitions.get(optionalStringAttr3);
                            if (str6 != null) {
                                map.put(optionalStringAttr3, str6);
                            }
                        } else {
                            map.put(parseStringAttr(next, REGEX_NAME, map), parseStringAttr(next, REGEX_VALUE, map));
                        }
                        z = false;
                        i = i2;
                        part = part2;
                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                        str4 = str2;
                        i2 = i;
                        part2 = part;
                        longAttr = longAttr;
                        encryptionScheme = encryptionScheme;
                        arrayList5 = arrayList5;
                        arrayList4 = arrayList4;
                        z4 = z;
                        hlsMediaPlaylist = hlsMediaPlaylist;
                    } else if (next.startsWith("#EXTINF")) {
                        timeSecondsToUs = parseTimeSecondsToUs(next, REGEX_MEDIA_DURATION);
                        optionalStringAttr = parseOptionalStringAttr(next, REGEX_MEDIA_TITLE, str3, map);
                    } else {
                        String str7 = str3;
                        if (next.startsWith("#EXT-X-SKIP")) {
                            int intAttr3 = parseIntAttr(next, REGEX_SKIPPED_SEGMENTS);
                            Assertions.checkState(hlsMediaPlaylist != null && arrayList.isEmpty());
                            int i5 = (int) (j5 - ((HlsMediaPlaylist) Util.castNonNull(hlsMediaPlaylist)).mediaSequence);
                            int i6 = intAttr3 + i5;
                            if (i5 < 0 || i6 > hlsMediaPlaylist.segments.size()) {
                                throw new DeltaUpdateException();
                            }
                            str3 = str7;
                            String str8 = str2;
                            long j11 = j9;
                            while (i5 < i6) {
                                HlsMediaPlaylist.Segment segmentCopyWith = hlsMediaPlaylist.segments.get(i5);
                                ArrayList arrayList6 = arrayList5;
                                ArrayList arrayList7 = arrayList4;
                                if (j5 != hlsMediaPlaylist.mediaSequence) {
                                    segmentCopyWith = segmentCopyWith.copyWith(j11, (hlsMediaPlaylist.discontinuitySequence - i3) + segmentCopyWith.relativeDiscontinuitySequence);
                                }
                                arrayList.add(segmentCopyWith);
                                j11 += segmentCopyWith.durationUs;
                                long j12 = segmentCopyWith.byteRangeLength;
                                if (j12 != -1) {
                                    j6 = segmentCopyWith.byteRangeOffset + j12;
                                }
                                int i7 = segmentCopyWith.relativeDiscontinuitySequence;
                                HlsMediaPlaylist.Segment segment2 = segmentCopyWith.initializationSegment;
                                DrmInitData drmInitData3 = segmentCopyWith.drmInitData;
                                String str9 = segmentCopyWith.fullSegmentEncryptionKeyUri;
                                String str10 = segmentCopyWith.encryptionIV;
                                if (str10 == null || !str10.equals(Long.toHexString(longAttr))) {
                                    str8 = segmentCopyWith.encryptionIV;
                                }
                                longAttr++;
                                i5++;
                                hlsMediaPlaylist = hlsMediaPlaylist;
                                drmInitData2 = drmInitData3;
                                stringAttr = str9;
                                j7 = j11;
                                i6 = i6;
                                i4 = i7;
                                segment = segment2;
                                arrayList5 = arrayList6;
                                arrayList4 = arrayList7;
                            }
                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                            hlsMediaPlaylist = hlsMediaPlaylist;
                            j9 = j11;
                            str4 = str8;
                        } else {
                            arrayList5 = arrayList5;
                            arrayList4 = arrayList4;
                            str3 = str7;
                            if (next.startsWith("#EXT-X-KEY")) {
                                String stringAttr4 = parseStringAttr(next, REGEX_METHOD, map);
                                String optionalStringAttr4 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, "identity", map);
                                if ("NONE".equals(stringAttr4)) {
                                    treeMap.clear();
                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                    arrayList5 = arrayList5;
                                    stringAttr = null;
                                    drmInitData2 = null;
                                    arrayList4 = arrayList4;
                                } else {
                                    String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_IV, map);
                                    if (!"identity".equals(optionalStringAttr4)) {
                                        String str11 = encryptionScheme;
                                        encryptionScheme = str11 == null ? parseEncryptionScheme(stringAttr4) : str11;
                                        DrmInitData.SchemeData drmSchemeData = parseDrmSchemeData(next, optionalStringAttr4, map);
                                        if (drmSchemeData != null) {
                                            treeMap.put(optionalStringAttr4, drmSchemeData);
                                            stringAttr = null;
                                            drmInitData2 = null;
                                        }
                                        z4 = false;
                                        str4 = optionalStringAttr5;
                                        arrayList4 = arrayList4;
                                    } else if ("AES-128".equals(stringAttr4)) {
                                        stringAttr = parseStringAttr(next, REGEX_URI, map);
                                        str4 = optionalStringAttr5;
                                        arrayList5 = arrayList5;
                                        arrayList4 = arrayList4;
                                    }
                                    stringAttr = null;
                                    z4 = false;
                                    str4 = optionalStringAttr5;
                                    arrayList4 = arrayList4;
                                }
                            } else {
                                String str12 = encryptionScheme;
                                if (next.startsWith("#EXT-X-BYTERANGE")) {
                                    String[] strArrSplit2 = Util.split(parseStringAttr(next, REGEX_BYTERANGE, map), "@");
                                    j8 = Long.parseLong(strArrSplit2[0]);
                                    if (strArrSplit2.length > 1) {
                                        j6 = Long.parseLong(strArrSplit2[1]);
                                    }
                                } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                    i3 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                    encryptionScheme = str12;
                                    str4 = str2;
                                    arrayList5 = arrayList5;
                                    arrayList4 = arrayList4;
                                    z4 = false;
                                    z6 = true;
                                } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                                    i4++;
                                } else {
                                    if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                        if (jMsToUs == 0) {
                                            jMsToUs = Util.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j9;
                                        } else {
                                            i = i2;
                                            encryptionScheme = str12;
                                        }
                                    } else if (next.equals("#EXT-X-GAP")) {
                                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                        encryptionScheme = str12;
                                        str4 = str2;
                                        arrayList5 = arrayList5;
                                        arrayList4 = arrayList4;
                                        z4 = false;
                                        z8 = true;
                                    } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                        encryptionScheme = str12;
                                        str4 = str2;
                                        arrayList5 = arrayList5;
                                        arrayList4 = arrayList4;
                                        z4 = false;
                                        z5 = true;
                                    } else if (next.equals("#EXT-X-ENDLIST")) {
                                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                        encryptionScheme = str12;
                                        str4 = str2;
                                        arrayList5 = arrayList5;
                                        arrayList4 = arrayList4;
                                        z4 = false;
                                        z7 = true;
                                    } else if (next.startsWith("#EXT-X-RENDITION-REPORT")) {
                                        i = i2;
                                        encryptionScheme = str12;
                                        arrayList3.add(new HlsMediaPlaylist.RenditionReport(Uri.parse(UriUtil.resolve(str, parseStringAttr(next, REGEX_URI, map))), parseOptionalLongAttr(next, REGEX_LAST_MSN, -1L), parseOptionalIntAttr(next, REGEX_LAST_PART, -1)));
                                    } else {
                                        i = i2;
                                        encryptionScheme = str12;
                                        if (!next.startsWith("#EXT-X-PRELOAD-HINT")) {
                                            longAttr = longAttr;
                                            if (next.startsWith("#EXT-X-PART")) {
                                                String segmentEncryptionIV = getSegmentEncryptionIV(longAttr, stringAttr, str2);
                                                String stringAttr5 = parseStringAttr(next, REGEX_URI, map);
                                                long doubleAttr3 = (long) (parseDoubleAttr(next, REGEX_ATTR_DURATION) * 1000000.0d);
                                                HlsMediaPlaylist.Part part3 = part2;
                                                boolean optionalBooleanAttribute2 = parseOptionalBooleanAttribute(next, REGEX_INDEPENDENT, false) | (z5 && arrayList5.isEmpty());
                                                boolean optionalBooleanAttribute3 = parseOptionalBooleanAttribute(next, REGEX_GAP, false);
                                                String optionalStringAttr6 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                                                if (optionalStringAttr6 != null) {
                                                    String[] strArrSplit3 = Util.split(optionalStringAttr6, "@");
                                                    j4 = Long.parseLong(strArrSplit3[0]);
                                                    if (strArrSplit3.length > 1) {
                                                        j10 = Long.parseLong(strArrSplit3[1]);
                                                    }
                                                    j3 = -1;
                                                } else {
                                                    j3 = -1;
                                                    j4 = -1;
                                                }
                                                if (j4 == j3) {
                                                    j10 = 0;
                                                }
                                                if (drmInitData2 == null && !treeMap.isEmpty()) {
                                                    DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData4 = new DrmInitData(encryptionScheme, schemeDataArr);
                                                    if (playlistProtectionSchemes == null) {
                                                        playlistProtectionSchemes = getPlaylistProtectionSchemes(encryptionScheme, schemeDataArr);
                                                    }
                                                    drmInitData2 = drmInitData4;
                                                }
                                                arrayList5.add(new HlsMediaPlaylist.Part(stringAttr5, segment, doubleAttr3, i4, j7, drmInitData2, stringAttr, segmentEncryptionIV, j10, j4, optionalBooleanAttribute3, optionalBooleanAttribute2, false));
                                                j7 += doubleAttr3;
                                                if (j4 != j3) {
                                                    j10 += j4;
                                                }
                                                hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist = hlsMediaPlaylist;
                                                str4 = str2;
                                                i2 = i;
                                                part2 = part3;
                                                longAttr = longAttr;
                                                encryptionScheme = encryptionScheme;
                                                arrayList5 = arrayList5;
                                                arrayList4 = arrayList4;
                                            } else {
                                                part = part2;
                                                arrayList5 = arrayList5;
                                                if (next.startsWith("#")) {
                                                    z = false;
                                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                    str4 = str2;
                                                    i2 = i;
                                                    part2 = part;
                                                    longAttr = longAttr;
                                                    encryptionScheme = encryptionScheme;
                                                    arrayList5 = arrayList5;
                                                    arrayList4 = arrayList4;
                                                    z4 = z;
                                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                                } else {
                                                    String segmentEncryptionIV2 = getSegmentEncryptionIV(longAttr, stringAttr, str2);
                                                    long j13 = longAttr + 1;
                                                    String strReplaceVariableReferences = replaceVariableReferences(next, map);
                                                    HlsMediaPlaylist.Segment segment3 = (HlsMediaPlaylist.Segment) map2.get(strReplaceVariableReferences);
                                                    if (j8 == -1) {
                                                        j = 0;
                                                    } else {
                                                        if (z9 && segment == null && segment3 == null) {
                                                            segment3 = new HlsMediaPlaylist.Segment(strReplaceVariableReferences, 0L, j6, null, null);
                                                            map2.put(strReplaceVariableReferences, segment3);
                                                        }
                                                        j = j6;
                                                    }
                                                    if (drmInitData2 != null || treeMap.isEmpty()) {
                                                        j2 = j13;
                                                        z2 = false;
                                                        drmInitData = drmInitData2;
                                                    } else {
                                                        j2 = j13;
                                                        z2 = false;
                                                        DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        drmInitData = new DrmInitData(encryptionScheme, schemeDataArr2);
                                                        if (playlistProtectionSchemes == null) {
                                                            playlistProtectionSchemes = getPlaylistProtectionSchemes(encryptionScheme, schemeDataArr2);
                                                        }
                                                    }
                                                    arrayList.add(new HlsMediaPlaylist.Segment(strReplaceVariableReferences, segment != null ? segment : segment3, optionalStringAttr, timeSecondsToUs, i4, j9, drmInitData, stringAttr, segmentEncryptionIV2, j, j8, z8, arrayList5));
                                                    j7 = j9 + timeSecondsToUs;
                                                    arrayList5 = new ArrayList();
                                                    if (j8 != -1) {
                                                        j += j8;
                                                    }
                                                    j6 = j;
                                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                    z8 = z2;
                                                    str4 = str2;
                                                    drmInitData2 = drmInitData;
                                                    optionalStringAttr = str3;
                                                    j9 = j7;
                                                    i2 = i;
                                                    part2 = part;
                                                    arrayList4 = arrayList4;
                                                    j8 = -1;
                                                    timeSecondsToUs = 0;
                                                    encryptionScheme = encryptionScheme;
                                                    longAttr = j2;
                                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                                    z4 = z8;
                                                }
                                            }
                                        } else if (part2 == null && "PART".equals(parseStringAttr(next, REGEX_PRELOAD_HINT_TYPE, map))) {
                                            String stringAttr6 = parseStringAttr(next, REGEX_URI, map);
                                            long optionalLongAttr = parseOptionalLongAttr(next, REGEX_BYTERANGE_START, -1L);
                                            long optionalLongAttr2 = parseOptionalLongAttr(next, REGEX_BYTERANGE_LENGTH, -1L);
                                            long j14 = longAttr;
                                            String segmentEncryptionIV3 = getSegmentEncryptionIV(j14, stringAttr, str2);
                                            if (drmInitData2 == null && !treeMap.isEmpty()) {
                                                DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                DrmInitData drmInitData5 = new DrmInitData(encryptionScheme, schemeDataArr3);
                                                if (playlistProtectionSchemes == null) {
                                                    playlistProtectionSchemes = getPlaylistProtectionSchemes(encryptionScheme, schemeDataArr3);
                                                }
                                                drmInitData2 = drmInitData5;
                                            }
                                            if (optionalLongAttr == -1 || optionalLongAttr2 != -1) {
                                                part2 = new HlsMediaPlaylist.Part(stringAttr6, segment, 0L, i4, j7, drmInitData2, stringAttr, segmentEncryptionIV3, optionalLongAttr != -1 ? optionalLongAttr : 0L, optionalLongAttr2, false, false, true);
                                            }
                                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            longAttr = j14;
                                            str4 = str2;
                                            arrayList5 = arrayList5;
                                            i2 = i;
                                            arrayList4 = arrayList4;
                                            encryptionScheme = encryptionScheme;
                                        }
                                    }
                                    arrayList5 = arrayList5;
                                    longAttr = longAttr;
                                    z = false;
                                    part = part2;
                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                    str4 = str2;
                                    i2 = i;
                                    part2 = part;
                                    longAttr = longAttr;
                                    encryptionScheme = encryptionScheme;
                                    arrayList5 = arrayList5;
                                    arrayList4 = arrayList4;
                                    z4 = z;
                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                }
                                encryptionScheme = str12;
                                str4 = str2;
                                arrayList5 = arrayList5;
                                arrayList4 = arrayList4;
                            }
                        }
                    }
                    z4 = false;
                }
                str4 = str2;
                z4 = false;
            }
        }
        int i8 = i2;
        HlsMediaPlaylist.Part part4 = part2;
        ArrayList arrayList8 = arrayList5;
        ArrayList arrayList9 = arrayList4;
        Object[] objArr = z4 ? 1 : 0;
        HashMap map3 = new HashMap();
        for (int i9 = objArr == true ? 1 : 0; i9 < arrayList3.size(); i9++) {
            HlsMediaPlaylist.RenditionReport renditionReport = (HlsMediaPlaylist.RenditionReport) arrayList3.get(i9);
            long size = renditionReport.lastMediaSequence;
            if (size == -1) {
                size = (j5 + ((long) arrayList.size())) - (arrayList8.isEmpty() ? 1L : 0L);
            }
            int size2 = renditionReport.lastPartIndex;
            if (size2 == -1 && doubleAttr2 != -9223372036854775807L) {
                size2 = (arrayList8.isEmpty() ? ((HlsMediaPlaylist.Segment) o.w(arrayList)).parts : arrayList8).size() - 1;
            }
            Uri uri = renditionReport.playlistUri;
            map3.put(uri, new HlsMediaPlaylist.RenditionReport(uri, size, size2));
        }
        if (part4 != null) {
            arrayList8.add(part4);
        }
        return new HlsMediaPlaylist(i8, str, arrayList9, doubleAttr, optionalBooleanAttribute, jMsToUs, z6, i3, j5, intAttr, intAttr2, doubleAttr2, z5, z7, jMsToUs != 0, playlistProtectionSchemes, arrayList, arrayList8, serverControl2, map3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x0114  */
    /* JADX WARN: Code duplicated, block: B:76:0x02ff  */
    private static HlsMultivariantPlaylist parseMultivariantPlaylist(LineIterator lineIterator, String str) throws ParserException {
        ArrayList arrayList;
        String mediaMimeType;
        int i;
        String str2;
        String mediaMimeType2;
        int i2;
        int i3;
        Uri uriResolveToUri;
        String str3 = str;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            String str4 = "application/x-mpegURL";
            if (!lineIterator.hasNext()) {
                HashMap map3 = map;
                ArrayList arrayList10 = arrayList7;
                ArrayList arrayList11 = arrayList3;
                ArrayList arrayList12 = arrayList4;
                ArrayList arrayList13 = arrayList5;
                ArrayList arrayList14 = arrayList6;
                ArrayList arrayList15 = arrayList9;
                boolean z3 = z;
                ArrayList arrayList16 = arrayList8;
                ArrayList arrayList17 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                    HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList2.get(i4);
                    if (hashSet.add(variant.url)) {
                        Assertions.checkState(variant.format.metadata == null);
                        arrayList17.add(variant.copyWithFormat(variant.format.buildUpon().setMetadata(new Metadata(new HlsTrackMetadataEntry(null, null, (List) Assertions.checkNotNull((ArrayList) map3.get(variant.url))))).build()));
                    }
                }
                Uri uri = null;
                ArrayList arrayList18 = null;
                Format formatBuild = null;
                int i5 = 0;
                while (i5 < arrayList10.size()) {
                    ArrayList arrayList19 = arrayList10;
                    String str5 = (String) arrayList19.get(i5);
                    String stringAttr = parseStringAttr(str5, REGEX_GROUP_ID, map2);
                    String stringAttr2 = parseStringAttr(str5, REGEX_NAME, map2);
                    Format.Builder language = new Format.Builder().setId(stringAttr + u15.f19942b + stringAttr2).setLabel(stringAttr2).setContainerMimeType(str4).setSelectionFlags(parseSelectionFlags(str5)).setRoleFlags(parseRoleFlags(str5, map2)).setLanguage(parseOptionalStringAttr(str5, REGEX_LANGUAGE, map2));
                    String optionalStringAttr = parseOptionalStringAttr(str5, REGEX_URI, map2);
                    Uri uriResolveToUri2 = optionalStringAttr == null ? uri : UriUtil.resolveToUri(str, optionalStringAttr);
                    arrayList10 = arrayList19;
                    String str6 = str4;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(stringAttr, stringAttr2, Collections.emptyList()));
                    String stringAttr3 = parseStringAttr(str5, REGEX_TYPE, map2);
                    stringAttr3.hashCode();
                    switch (stringAttr3) {
                        case "SUBTITLES":
                            formatBuild = formatBuild;
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            HlsMultivariantPlaylist.Variant variantWithSubtitleGroup = getVariantWithSubtitleGroup(arrayList2, stringAttr);
                            if (variantWithSubtitleGroup != null) {
                                String codecsOfType = Util.getCodecsOfType(variantWithSubtitleGroup.format.codecs, 3);
                                language.setCodecs(codecsOfType);
                                mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType);
                            } else {
                                mediaMimeType = null;
                            }
                            if (mediaMimeType == null) {
                                mediaMimeType = "text/vtt";
                            }
                            language.setSampleMimeType(mediaMimeType).setMetadata(metadata);
                            if (uriResolveToUri2 != null) {
                                HlsMultivariantPlaylist.Rendition rendition = new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2);
                                arrayList13 = arrayList13;
                                arrayList13.add(rendition);
                                break;
                            } else {
                                arrayList13 = arrayList13;
                                Log.w("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                            break;
                        case "CLOSED-CAPTIONS":
                            formatBuild = formatBuild;
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            String stringAttr4 = parseStringAttr(str5, REGEX_INSTREAM_ID, map2);
                            if (stringAttr4.startsWith("CC")) {
                                i = Integer.parseInt(stringAttr4.substring(2));
                                str2 = "application/cea-608";
                            } else {
                                i = Integer.parseInt(stringAttr4.substring(7));
                                str2 = "application/cea-708";
                            }
                            if (arrayList18 == null) {
                                arrayList18 = new ArrayList();
                            }
                            language.setSampleMimeType(str2).setAccessibilityChannel(i);
                            arrayList18.add(language.build());
                            arrayList13 = arrayList13;
                            break;
                        case "AUDIO":
                            arrayList = arrayList11;
                            HlsMultivariantPlaylist.Variant variantWithAudioGroup = getVariantWithAudioGroup(arrayList2, stringAttr);
                            if (variantWithAudioGroup != null) {
                                String codecsOfType2 = Util.getCodecsOfType(variantWithAudioGroup.format.codecs, 1);
                                language.setCodecs(codecsOfType2);
                                mediaMimeType2 = MimeTypes.getMediaMimeType(codecsOfType2);
                            } else {
                                mediaMimeType2 = null;
                            }
                            String optionalStringAttr2 = parseOptionalStringAttr(str5, REGEX_CHANNELS, map2);
                            if (optionalStringAttr2 != null) {
                                language.setChannelCount(Integer.parseInt(Util.splitAtFirst(optionalStringAttr2, WVNativeCallbackUtil.SEPERATER)[0]));
                                if ("audio/eac3".equals(mediaMimeType2) && optionalStringAttr2.endsWith("/JOC")) {
                                    language.setCodecs("ec+3");
                                    mediaMimeType2 = "audio/eac3-joc";
                                }
                            }
                            language.setSampleMimeType(mediaMimeType2);
                            if (uriResolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList12 = arrayList12;
                                arrayList12.add(new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2));
                            } else {
                                arrayList12 = arrayList12;
                                if (variantWithAudioGroup != null) {
                                    formatBuild = language.build();
                                }
                            }
                            arrayList13 = arrayList13;
                            break;
                        case "VIDEO":
                            HlsMultivariantPlaylist.Variant variantWithVideoGroup = getVariantWithVideoGroup(arrayList2, stringAttr);
                            if (variantWithVideoGroup != null) {
                                Format format = variantWithVideoGroup.format;
                                String codecsOfType3 = Util.getCodecsOfType(format.codecs, 2);
                                language.setCodecs(codecsOfType3).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType3)).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate);
                            }
                            if (uriResolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList = arrayList11;
                                arrayList.add(new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2));
                            }
                        default:
                            arrayList = arrayList11;
                            break;
                    }
                    i5++;
                    arrayList13 = arrayList13;
                    arrayList12 = arrayList12;
                    arrayList11 = arrayList;
                    str4 = str6;
                    formatBuild = formatBuild;
                    uri = null;
                }
                return new HlsMultivariantPlaylist(str, arrayList15, arrayList17, arrayList11, arrayList12, arrayList13, arrayList14, formatBuild, z2 ? Collections.emptyList() : arrayList18, z3, map2, arrayList16);
            }
            String next = lineIterator.next();
            if (next.startsWith("#EXT")) {
                arrayList9.add(next);
            }
            boolean zStartsWith = next.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            boolean z4 = z;
            if (next.startsWith("#EXT-X-DEFINE")) {
                map2.put(parseStringAttr(next, REGEX_NAME, map2), parseStringAttr(next, REGEX_VALUE, map2));
            } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z = true;
            } else if (next.startsWith("#EXT-X-MEDIA")) {
                arrayList7.add(next);
            } else if (next.startsWith("#EXT-X-SESSION-KEY")) {
                DrmInitData.SchemeData drmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr(next, REGEX_KEYFORMAT, "identity", map2), map2);
                if (drmSchemeData != null) {
                    arrayList8.add(new DrmInitData(parseEncryptionScheme(parseStringAttr(next, REGEX_METHOD, map2)), drmSchemeData));
                }
            } else if (next.startsWith("#EXT-X-STREAM-INF") || zStartsWith) {
                boolean zContains = z2 | next.contains("CLOSED-CAPTIONS=NONE");
                int i6 = zStartsWith ? 16384 : 0;
                int intAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                ArrayList arrayList20 = arrayList8;
                ArrayList arrayList21 = arrayList6;
                int optionalIntAttr = parseOptionalIntAttr(next, REGEX_AVERAGE_BANDWIDTH, -1);
                String optionalStringAttr3 = parseOptionalStringAttr(next, REGEX_CODECS, map2);
                ArrayList arrayList22 = arrayList9;
                String optionalStringAttr4 = parseOptionalStringAttr(next, REGEX_RESOLUTION, map2);
                ArrayList arrayList23 = arrayList5;
                if (optionalStringAttr4 != null) {
                    String[] strArrSplit = Util.split(optionalStringAttr4, "x");
                    i3 = Integer.parseInt(strArrSplit[0]);
                    i2 = Integer.parseInt(strArrSplit[1]);
                    if (i3 <= 0 || i2 <= 0) {
                        i2 = -1;
                        i3 = -1;
                    }
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_FRAME_RATE, map2);
                float f = optionalStringAttr5 != null ? Float.parseFloat(optionalStringAttr5) : -1.0f;
                ArrayList arrayList24 = arrayList3;
                String optionalStringAttr6 = parseOptionalStringAttr(next, REGEX_VIDEO, map2);
                ArrayList arrayList25 = arrayList7;
                String optionalStringAttr7 = parseOptionalStringAttr(next, REGEX_AUDIO, map2);
                HashMap map4 = map;
                String optionalStringAttr8 = parseOptionalStringAttr(next, REGEX_SUBTITLES, map2);
                String optionalStringAttr9 = parseOptionalStringAttr(next, REGEX_CLOSED_CAPTIONS, map2);
                if (zStartsWith) {
                    uriResolveToUri = UriUtil.resolveToUri(str3, parseStringAttr(next, REGEX_URI, map2));
                } else {
                    if (!lineIterator.hasNext()) {
                        throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                    }
                    uriResolveToUri = UriUtil.resolveToUri(str3, replaceVariableReferences(lineIterator.next(), map2));
                }
                arrayList2.add(new HlsMultivariantPlaylist.Variant(uriResolveToUri, new Format.Builder().setId(arrayList2.size()).setContainerMimeType("application/x-mpegURL").setCodecs(optionalStringAttr3).setAverageBitrate(optionalIntAttr).setPeakBitrate(intAttr).setWidth(i3).setHeight(i2).setFrameRate(f).setRoleFlags(i6).build(), optionalStringAttr6, optionalStringAttr7, optionalStringAttr8, optionalStringAttr9));
                ArrayList arrayList26 = (ArrayList) map4.get(uriResolveToUri);
                if (arrayList26 == null) {
                    arrayList26 = new ArrayList();
                    map4.put(uriResolveToUri, arrayList26);
                }
                arrayList26.add(new HlsTrackMetadataEntry.VariantInfo(optionalIntAttr, intAttr, optionalStringAttr6, optionalStringAttr7, optionalStringAttr8, optionalStringAttr9));
                map = map4;
                z = z4;
                z2 = zContains;
                arrayList8 = arrayList20;
                arrayList6 = arrayList21;
                arrayList9 = arrayList22;
                arrayList5 = arrayList23;
                arrayList4 = arrayList4;
                arrayList3 = arrayList24;
                arrayList7 = arrayList25;
                str3 = str;
            }
            z = z4;
        }
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z;
    }

    private static double parseOptionalDoubleAttr(String str, Pattern pattern, double d) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) Assertions.checkNotNull(matcher.group(1))) : d;
    }

    private static int parseOptionalIntAttr(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))) : i;
    }

    private static long parseOptionalLongAttr(String str, Pattern pattern, long j) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) : j;
    }

    @Nullable
    private static String parseOptionalStringAttr(String str, Pattern pattern, Map<String, String> map) {
        return parseOptionalStringAttr(str, pattern, null, map);
    }

    private static int parseRoleFlags(String str, Map<String, String> map) {
        String optionalStringAttr = parseOptionalStringAttr(str, REGEX_CHARACTERISTICS, map);
        if (TextUtils.isEmpty(optionalStringAttr)) {
            return 0;
        }
        String[] strArrSplit = Util.split(optionalStringAttr, ",");
        int i = Util.contains(strArrSplit, "public.accessibility.describes-video") ? 512 : 0;
        if (Util.contains(strArrSplit, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (Util.contains(strArrSplit, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        return Util.contains(strArrSplit, "public.easy-to-read") ? i | 8192 : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int parseSelectionFlags(String str) {
        boolean optionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false);
        ?? r0 = optionalBooleanAttribute;
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            r0 = (optionalBooleanAttribute ? 1 : 0) | 2;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? r0 | 4 : r0;
    }

    private static HlsMediaPlaylist.ServerControl parseServerControl(String str) {
        double optionalDoubleAttr = parseOptionalDoubleAttr(str, REGEX_CAN_SKIP_UNTIL, -9.223372036854776E18d);
        long j = optionalDoubleAttr == -9.223372036854776E18d ? -9223372036854775807L : (long) (optionalDoubleAttr * 1000000.0d);
        boolean optionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_CAN_SKIP_DATE_RANGES, false);
        double optionalDoubleAttr2 = parseOptionalDoubleAttr(str, REGEX_HOLD_BACK, -9.223372036854776E18d);
        long j2 = optionalDoubleAttr2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (optionalDoubleAttr2 * 1000000.0d);
        double optionalDoubleAttr3 = parseOptionalDoubleAttr(str, REGEX_PART_HOLD_BACK, -9.223372036854776E18d);
        return new HlsMediaPlaylist.ServerControl(j, optionalBooleanAttribute, j2, optionalDoubleAttr3 != -9.223372036854776E18d ? (long) (optionalDoubleAttr3 * 1000000.0d) : -9223372036854775807L, parseOptionalBooleanAttribute(str, REGEX_CAN_BLOCK_RELOAD, false));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String optionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (optionalStringAttr != null) {
            return optionalStringAttr;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    private static long parseTimeSecondsToUs(String str, Pattern pattern) {
        return new BigDecimal(parseStringAttr(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    private static String replaceVariableReferences(String str, Map<String, String> map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !Util.isLinebreak(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.previousMediaPlaylist = hlsMediaPlaylist;
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) Assertions.checkNotNull(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : replaceVariableReferences(str2, map);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.inner_exoplayer2.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws ParserException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!checkPlaylistHeader(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    Util.closeQuietly(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.startsWith("#EXT-X-STREAM-INF")) {
                        arrayDeque.add(strTrim);
                        HlsMultivariantPlaylist multivariantPlaylist = parseMultivariantPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                        Util.closeQuietly(bufferedReader);
                        return multivariantPlaylist;
                    }
                    if (!strTrim.startsWith("#EXT-X-TARGETDURATION") && !strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") && !strTrim.startsWith("#EXTINF") && !strTrim.startsWith("#EXT-X-KEY") && !strTrim.startsWith("#EXT-X-BYTERANGE") && !strTrim.equals("#EXT-X-DISCONTINUITY") && !strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") && !strTrim.equals("#EXT-X-ENDLIST")) {
                        arrayDeque.add(strTrim);
                    }
                    arrayDeque.add(strTrim);
                    HlsMediaPlaylist mediaPlaylist = parseMediaPlaylist(this.multivariantPlaylist, this.previousMediaPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
                    Util.closeQuietly(bufferedReader);
                    return mediaPlaylist;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(bufferedReader);
            throw th;
        }
    }
}
