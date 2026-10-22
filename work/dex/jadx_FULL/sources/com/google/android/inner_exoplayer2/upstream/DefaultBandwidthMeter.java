package com.google.android.inner_exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.inner_exoplayer2.util.Assertions;
import com.google.android.inner_exoplayer2.util.Clock;
import com.google.android.inner_exoplayer2.util.NetworkTypeObserver;
import com.google.android.inner_exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.huachenjie.common.constants.ErrorCode;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.igexin.assist.sdk.AssistPushConsts;
import com.ipd.dsp.internal.q.u;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import com.zj.adlib.go6;
import com.zj.adlib.i55;
import com.zj.adlib.ib3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    private static final int COUNTRY_GROUP_INDEX_2G = 1;
    private static final int COUNTRY_GROUP_INDEX_3G = 2;
    private static final int COUNTRY_GROUP_INDEX_4G = 3;
    private static final int COUNTRY_GROUP_INDEX_5G_NSA = 4;
    private static final int COUNTRY_GROUP_INDEX_5G_SA = 5;
    private static final int COUNTRY_GROUP_INDEX_WIFI = 0;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;

    @Nullable
    private static DefaultBandwidthMeter singletonInstance;
    private long bitrateEstimate;
    private final Clock clock;
    private final BandwidthMeter.EventListener.EventDispatcher eventDispatcher;
    private final ImmutableMap<Integer, Long> initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private final boolean resetOnNetworkTypeChange;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.of(4400000L, 3200000L, 2300000L, 1600000L, 810000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.of(1400000L, 990000L, 730000L, 510000L, 230000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.of(2100000L, 1400000L, 1000000L, 890000L, 640000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.of(2600000L, 1700000L, 1300000L, 1000000L, 700000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.of(5700000L, 3700000L, 2300000L, 1700000L, 990000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA = ImmutableList.of(2800000L, 1800000L, 1400000L, 1100000L, 870000L);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int[] getInitialBitrateCountryGroupAssignment(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    b = 0;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    b = 1;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    b = 2;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    b = 3;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    b = 4;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    b = 5;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    b = 6;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    b = 7;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    b = 8;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    b = 9;
                }
                break;
            case i55.b /* 2099 */:
                if (str.equals("AT")) {
                    b = 10;
                }
                break;
            case 2100:
                if (str.equals("AU")) {
                    b = 11;
                }
                break;
            case ErrorCode.FENCE_ERROR.f33661a /* 2102 */:
                if (str.equals("AW")) {
                    b = 12;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    b = 13;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    b = com.google.common.base.a.p;
                }
                break;
            case 2111:
                if (str.equals("BA")) {
                    b = com.google.common.base.a.q;
                }
                break;
            case 2112:
                if (str.equals("BB")) {
                    b = com.google.common.base.a.r;
                }
                break;
            case 2114:
                if (str.equals("BD")) {
                    b = 17;
                }
                break;
            case 2115:
                if (str.equals("BE")) {
                    b = com.google.common.base.a.u;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    b = 19;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    b = com.google.common.base.a.x;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    b = com.google.common.base.a.y;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    b = com.google.common.base.a.z;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    b = com.google.common.base.a.A;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    b = com.google.common.base.a.B;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    b = com.google.common.base.a.C;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    b = com.google.common.base.a.D;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    b = com.google.common.base.a.E;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    b = com.google.common.base.a.F;
                }
                break;
            case 2128:
                if (str.equals("BR")) {
                    b = com.google.common.base.a.G;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    b = com.google.common.base.a.H;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    b = 31;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    b = 32;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    b = com.google.android.exoplayer2.text.cea.a.e;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    b = 34;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    b = 35;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    b = 36;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    b = com.google.android.exoplayer2.text.cea.a.g;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    b = com.google.android.exoplayer2.text.cea.a.h;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    b = com.google.android.exoplayer2.text.cea.a.i;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    b = MaterialProgressDrawable.c;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    b = com.google.android.exoplayer2.text.cea.a.j;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    b = 42;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    b = com.google.android.exoplayer2.text.cea.a.l;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    b = com.google.android.exoplayer2.text.cea.a.m;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    b = com.google.android.exoplayer2.text.cea.a.n;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    b = com.google.android.exoplayer2.text.cea.a.o;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    b = 47;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    b = com.alibaba.ariver.resource.parser.a.e.i;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    b = com.alibaba.ariver.resource.parser.a.e.j;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    b = com.alibaba.ariver.resource.parser.a.e.k;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    b = com.alibaba.ariver.resource.parser.a.e.l;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    b = com.alibaba.ariver.resource.parser.a.e.m;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    b = com.alibaba.ariver.resource.parser.a.e.n;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    b = com.alibaba.ariver.resource.parser.a.e.o;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    b = com.alibaba.ariver.resource.parser.a.e.p;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    b = MaterialProgressDrawable.d;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    b = 57;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    b = 58;
                }
                break;
            case SecExceptionCode.SEC_ERROR_LBSRISK_INIT_JNI_FAILED /* 2206 */:
                if (str.equals("EC")) {
                    b = 59;
                }
                break;
            case SecExceptionCode.SEC_ERROR_LBSRISK_GET_WUA_FAILED /* 2208 */:
                if (str.equals("EE")) {
                    b = 60;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    b = 61;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    b = 62;
                }
                break;
            case SecExceptionCode.SEC_ERROR_LBSRISK_INVALID_BINARY_FORMAT /* 2222 */:
                if (str.equals("ES")) {
                    b = 63;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    b = SignedBytes.f32242a;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    b = 65;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    b = 66;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    b = 67;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    b = 68;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    b = 69;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    b = 70;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    b = 71;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    b = 72;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    b = 73;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    b = 74;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    b = 75;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    b = 76;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    b = 77;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    b = 78;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    b = 79;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    b = 80;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    b = 81;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    b = 82;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    b = 83;
                }
                break;
            case 2285:
                if (str.equals(com.igexin.push.core.b.j)) {
                    b = 84;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    b = 85;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    b = 86;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    b = 87;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    b = 88;
                }
                break;
            case 2310:
                if (str.equals("HN")) {
                    b = 89;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    b = 90;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    b = 91;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    b = 92;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    b = 93;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    b = 94;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    b = 95;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    b = 96;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    b = 97;
                }
                break;
            case 2342:
                if (str.equals(RVScheduleType.IO)) {
                    b = 98;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    b = 99;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    b = 100;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    b = 101;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    b = 102;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    b = 103;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    b = 104;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    b = 105;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    b = 106;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    b = 107;
                }
                break;
            case 2396:
                if (str.equals(ib3.o)) {
                    b = 108;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    b = 109;
                }
                break;
            case SecExceptionCode.SEC_ERROR_MIDDLE_TIER_UNKONWN_ENCODING_ERROR /* 2398 */:
                if (str.equals("KI")) {
                    b = 110;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_NO_APPKEY /* 2402 */:
                if (str.equals("KM")) {
                    b = 111;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_INIT_FAILED /* 2403 */:
                if (str.equals("KN")) {
                    b = 112;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_WUA_FAILED /* 2407 */:
                if (str.equals("KR")) {
                    b = 113;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    b = 114;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    b = 115;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    b = 116;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    b = 117;
                }
                break;
            case 2422:
                if (str.equals(ib3.p)) {
                    b = 118;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    b = 119;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    b = aq6.f40585a;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    b = 121;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    b = 122;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    b = 123;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    b = 124;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    b = 125;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    b = 126;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    b = 127;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    b = UnsignedBytes.f32243a;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    b = 129;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    b = 130;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    b = 131;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    b = 132;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    b = 133;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    b = 134;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    b = 135;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    b = 136;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    b = 137;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    b = 138;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    b = 139;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    b = 140;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    b = 141;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    b = 142;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    b = 143;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    b = 144;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    b = 145;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    b = 146;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    b = 147;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    b = 148;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    b = 149;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    b = 150;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    b = 151;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    b = 152;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    b = 153;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    b = 154;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    b = 155;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    b = 156;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    b = 157;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_UNKONWN_ENCODING_ERROR /* 2498 */:
                if (str.equals("NP")) {
                    b = 158;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    b = 159;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    b = 160;
                }
                break;
            case AVMDLDataLoader.KeyIsEnablePreconnect /* 2508 */:
                if (str.equals("NZ")) {
                    b = 161;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    b = 162;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    b = 163;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    b = 164;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    b = 165;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    b = 166;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    b = 167;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    b = 168;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    b = 169;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    b = 170;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    b = 171;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    b = 172;
                }
                break;
            case 2564:
                if (str.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                    b = 173;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    b = 174;
                }
                break;
            case 2569:
                if (str.equals("PY")) {
                    b = 175;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    b = 176;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    b = 177;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    b = 178;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    b = 179;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    b = 180;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    b = 181;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    b = 182;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    b = 183;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    b = 184;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    b = 185;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    b = 186;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    b = 187;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    b = 188;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    b = 189;
                }
                break;
            case 2647:
                if (str.equals("SJ")) {
                    b = 190;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    b = 191;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    b = u.n7;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    b = u.o7;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    b = u.p7;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    b = u.q7;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    b = 196;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    b = u.r7;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    b = u.s7;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    b = u.t7;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    b = 200;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    b = u.u7;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    b = u.v7;
                }
                break;
            case 2671:
                if (str.equals(com.ipd.dsp.internal.s0.b.d)) {
                    b = u.w7;
                }
                break;
            case 2672:
                if (str.equals(com.ipd.dsp.internal.s0.b.e)) {
                    b = 204;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    b = u.x7;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    b = u.y7;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    b = u.z7;
                }
                break;
            case 2679:
                if (str.equals("TK")) {
                    b = 208;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    b = 209;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    b = 210;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    b = 211;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    b = 212;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    b = 213;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    b = 214;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    b = 215;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    b = u.m7;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    b = u.D7;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    b = u.A7;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    b = 219;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    b = 220;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    b = 221;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    b = 222;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    b = 223;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    b = 224;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    b = u.B7;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    b = 226;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    b = 227;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    b = 228;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    b = 229;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    b = 230;
                }
                break;
            case 2780:
                if (str.equals(com.alipay.android.phone.mobilesdk.socketcraft.e.c.f25296a)) {
                    b = 231;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    b = 232;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    b = 233;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    b = 234;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    b = 235;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    b = 236;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    b = 237;
                }
                break;
        }
        switch (b) {
            case 0:
            case 49:
                return new int[]{2, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 3, 4, 4, 2};
            case 2:
            case 166:
                return new int[]{4, 3, 3, 3, 2, 2};
            case 3:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 4:
            case 16:
            case 25:
            case 28:
            case 56:
            case 68:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 5:
                return new int[]{1, 1, 1, 3, 2, 2};
            case 6:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{4, 4, 4, 3, 2, 2};
            case 8:
            case 62:
            case 188:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 10:
                return new int[]{1, 2, 1, 4, 1, 4};
            case 11:
                return new int[]{0, 2, 1, 1, 3, 0};
            case 12:
            case 85:
                return new int[]{1, 2, 4, 4, 2, 2};
            case 13:
            case 50:
            case 120:
            case 140:
            case 143:
            case com.google.common.math.c.f6376a /* 170 */:
            case 193:
            case MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG /* 223 */:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 14:
            case 19:
            case 58:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 15:
            case 94:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 17:
            case 116:
                return new int[]{2, 1, 2, 2, 2, 2};
            case 18:
                return new int[]{0, 1, 4, 4, 3, 2};
            case 20:
            case 63:
            case 83:
            case 189:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 21:
                return new int[]{1, 3, 1, 4, 4, 2};
            case 22:
            case 91:
            case 133:
            case 153:
            case 204:
            case 225:
            case 233:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 23:
                return new int[]{4, 4, 2, 3, 2, 2};
            case 24:
            case 132:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED /* 175 */:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 26:
                return new int[]{3, 2, 0, 1, 2, 2};
            case 27:
                return new int[]{1, 2, 3, 2, 2, 2};
            case 29:
                return new int[]{1, 1, 2, 1, 1, 0};
            case 30:
            case 118:
                return new int[]{3, 2, 1, 2, 2, 2};
            case 31:
            case 150:
            case 231:
                return new int[]{3, 1, 2, 1, 2, 2};
            case 32:
                return new int[]{3, 2, 1, 0, 2, 2};
            case 33:
                return new int[]{1, 1, 2, 3, 2, 2};
            case 34:
            case 41:
                return new int[]{2, 2, 2, 1, 2, 2};
            case 35:
                return new int[]{0, 2, 3, 3, 3, 3};
            case 36:
            case 111:
                return new int[]{4, 3, 3, 2, 2, 2};
            case 37:
            case 183:
                return new int[]{4, 2, 4, 2, 2, 2};
            case 38:
            case 76:
                return new int[]{3, 3, 3, 3, 2, 2};
            case 39:
                return new int[]{0, 0, 0, 0, 0, 3};
            case 40:
            case 61:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 42:
                return new int[]{1, 1, 2, 1, 3, 2};
            case 43:
                return new int[]{4, 3, 3, 4, 2, 2};
            case 44:
                return new int[]{2, 0, 4, 3, 3, 1};
            case 45:
                return new int[]{2, 3, 4, 2, 2, 2};
            case 46:
                return new int[]{2, 4, 4, 4, 2, 2};
            case 47:
            case 110:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 48:
                return new int[]{2, 3, 0, 1, 2, 2};
            case 51:
            case 90:
            case 126:
                return new int[]{1, 0, 0, 0, 0, 2};
            case 52:
                return new int[]{0, 0, 2, 0, 1, 2};
            case 53:
                return new int[]{0, 1, 3, 2, 2, 2};
            case 54:
            case 201:
            case 207:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 55:
            case 60:
            case 92:
            case 124:
            case 144:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 57:
                return new int[]{3, 4, 4, 4, 4, 2};
            case 59:
                return new int[]{1, 3, 2, 1, 2, 2};
            case 64:
            case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 65:
                return new int[]{0, 0, 0, 2, 0, 2};
            case 66:
                return new int[]{3, 1, 2, 3, 2, 2};
            case 67:
                return new int[]{4, 2, 3, 0, 2, 2};
            case 69:
                return new int[]{1, 1, 2, 1, 1, 2};
            case 70:
            case 205:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 71:
                return new int[]{0, 1, 1, 2, 1, 2};
            case 72:
            case 112:
            case 115:
            case 119:
            case 200:
            case 224:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 73:
                return new int[]{1, 0, 0, 2, 2, 2};
            case 74:
            case 168:
            case 192:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 75:
                return new int[]{0, 2, 1, 0, 2, 2};
            case 77:
            case 103:
                return new int[]{1, 2, 0, 1, 2, 2};
            case 78:
            case 208:
                return new int[]{2, 2, 2, 4, 2, 2};
            case 79:
                return new int[]{4, 3, 2, 4, 2, 2};
            case 80:
                return new int[]{4, 4, 4, 2, 2, 2};
            case 81:
                return new int[]{3, 1, 1, 3, 2, 2};
            case 82:
                return new int[]{4, 4, 3, 3, 2, 2};
            case 84:
                return new int[]{2, 2, 2, 1, 1, 2};
            case 86:
                return new int[]{4, 4, 2, 2, 2, 2};
            case 87:
                return new int[]{3, 0, 1, 1, 2, 2};
            case 88:
                return new int[]{0, 1, 1, 3, 2, 0};
            case 89:
                return new int[]{3, 3, 2, 2, 2, 2};
            case 93:
                return new int[]{3, 1, 1, 2, 3, 2};
            case 95:
                return new int[]{1, 2, 2, 3, 4, 2};
            case 96:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 97:
                return new int[]{1, 1, 2, 1, 2, 1};
            case 98:
            case 215:
            case MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT /* 230 */:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 99:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME /* 190 */:
                return new int[]{3, 2, 2, 2, 2, 2};
            case 100:
                return new int[]{4, 2, 3, 3, 4, 2};
            case 101:
                return new int[]{0, 0, 1, 0, 0, 2};
            case 102:
                return new int[]{0, 0, 1, 1, 1, 2};
            case 104:
                return new int[]{2, 4, 2, 1, 2, 2};
            case 105:
                return new int[]{2, 0, 1, 1, 2, 2};
            case 106:
                return new int[]{0, 3, 3, 3, 4, 4};
            case 107:
                return new int[]{3, 2, 2, 1, 2, 2};
            case 108:
            case 141:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 109:
                return new int[]{1, 0, 4, 2, 2, 2};
            case 113:
                return new int[]{0, 2, 2, 4, 4, 4};
            case 114:
                return new int[]{1, 0, 1, 0, 0, 2};
            case 117:
                return new int[]{1, 2, 1, 3, 2, 2};
            case 121:
                return new int[]{3, 2, 3, 4, 4, 2};
            case 122:
                return new int[]{3, 4, 3, 4, 2, 2};
            case 123:
            case 219:
                return new int[]{3, 3, 3, 2, 2, 2};
            case 125:
                return new int[]{1, 1, 4, 2, 0, 2};
            case 127:
            case 212:
            case 237:
                return new int[]{3, 2, 4, 3, 2, 2};
            case 128:
                return new int[]{3, 3, 2, 1, 2, 2};
            case 129:
                return new int[]{0, 2, 2, 0, 2, 2};
            case 130:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 131:
                return new int[]{2, 0, 0, 1, 1, 2};
            case 134:
                return new int[]{4, 2, 1, 3, 2, 2};
            case 135:
                return new int[]{2, 0, 0, 1, 3, 2};
            case 136:
            case 217:
                return new int[]{3, 4, 2, 2, 2, 2};
            case 137:
                return new int[]{2, 2, 2, 3, 4, 2};
            case 138:
                return new int[]{2, 0, 1, 2, 2, 2};
            case 139:
                return new int[]{0, 2, 4, 4, 4, 2};
            case 142:
                return new int[]{4, 2, 3, 4, 2, 2};
            case 145:
            case 182:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 146:
                return new int[]{3, 4, 1, 3, 3, 2};
            case 147:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 148:
                return new int[]{3, 4, 4, 4, 2, 2};
            case 149:
                return new int[]{1, 0, 4, 1, 2, 2};
            case 151:
                return new int[]{3, 4, 3, 2, 2, 2};
            case 152:
                return new int[]{3, 2, 3, 4, 2, 2};
            case 154:
                return new int[]{3, 4, 2, 1, 2, 2};
            case 155:
                return new int[]{2, 3, 4, 3, 2, 2};
            case 156:
                return new int[]{0, 2, 3, 3, 0, 4};
            case 157:
                return new int[]{0, 1, 2, 1, 1, 2};
            case 158:
                return new int[]{2, 1, 4, 3, 2, 2};
            case 159:
                return new int[]{4, 0, 3, 2, 2, 2};
            case 160:
                return new int[]{4, 2, 2, 1, 2, 2};
            case 161:
                return new int[]{1, 0, 2, 2, 4, 2};
            case 162:
                return new int[]{2, 3, 1, 3, 4, 2};
            case 163:
                return new int[]{2, 3, 3, 3, 2, 2};
            case 164:
                return new int[]{1, 2, 4, 4, 3, 2};
            case 165:
            case 199:
                return new int[]{2, 3, 3, 1, 2, 2};
            case 167:
                return new int[]{2, 1, 3, 2, 2, 0};
            case 169:
                return new int[]{2, 1, 2, 2, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE /* 171 */:
                return new int[]{2, 0, 2, 0, 2, 1};
            case 172:
                return new int[]{3, 4, 1, 4, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT /* 173 */:
                return new int[]{1, 0, 0, 0, 1, 2};
            case 174:
                return new int[]{2, 2, 4, 2, 2, 2};
            case 176:
                return new int[]{1, 4, 4, 4, 4, 2};
            case 177:
                return new int[]{1, 2, 2, 3, 1, 2};
            case 178:
                return new int[]{0, 0, 1, 2, 1, 2};
            case 179:
                return new int[]{2, 0, 0, 0, 2, 2};
            case 180:
                return new int[]{1, 0, 0, 0, 3, 3};
            case 181:
                return new int[]{3, 3, 1, 0, 2, 2};
            case 184:
                return new int[]{4, 3, 1, 1, 2, 2};
            case 185:
                return new int[]{4, 3, 4, 2, 2, 2};
            case 186:
                return new int[]{0, 1, 1, 1, 0, 2};
            case 187:
                return new int[]{2, 3, 3, 3, 3, 3};
            case MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED /* 191 */:
                return new int[]{1, 1, 1, 1, 3, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO /* 195 */:
                return new int[]{3, 2, 2, 4, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE /* 196 */:
                return new int[]{2, 4, 3, 0, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY /* 197 */:
            case 210:
                return new int[]{4, 2, 2, 3, 2, 2};
            case 198:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 202:
                return new int[]{4, 4, 3, 4, 2, 2};
            case 203:
                return new int[]{2, 2, 1, 3, 2, 2};
            case 206:
                return new int[]{0, 1, 2, 1, 2, 2};
            case 209:
                return new int[]{4, 2, 4, 4, 2, 2};
            case 211:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR /* 221 */:
                return new int[]{2, 1, 1, 1, 2, 2};
            case 213:
                return new int[]{1, 0, 0, 1, 3, 2};
            case go6.g /* 214 */:
                return new int[]{1, 4, 0, 0, 2, 2};
            case 216:
                return new int[]{0, 2, 0, 0, 0, 0};
            case 218:
                return new int[]{0, 1, 1, 2, 4, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM /* 220 */:
                return new int[]{1, 1, 4, 1, 3, 1};
            case 222:
                return new int[]{2, 2, 3, 4, 3, 2};
            case 226:
                return new int[]{2, 2, 0, 1, 2, 2};
            case 227:
                return new int[]{0, 2, 1, 2, 2, 2};
            case 228:
                return new int[]{0, 0, 1, 2, 2, 1};
            case 229:
                return new int[]{4, 3, 3, 1, 2, 2};
            case 232:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 234:
                return new int[]{2, 3, 3, 4, 2, 2};
            case 235:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 236:
                return new int[]{4, 4, 4, 3, 3, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    private long getInitialBitrateEstimateForNetworkType(int i) {
        Long l = this.initialBitrateEstimates.get(Integer.valueOf(i));
        if (l == null) {
            l = this.initialBitrateEstimates.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context) {
        if (singletonInstance == null) {
            singletonInstance = new Builder(context).build();
        }
        return singletonInstance;
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    private void maybeNotifyBandwidthSample(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.lastReportedBitrateEstimate) {
            return;
        }
        this.lastReportedBitrateEstimate = j2;
        this.eventDispatcher.bandwidthSample(i, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onNetworkTypeChanged(int i) {
        int i2 = this.networkType;
        if (i2 == 0 || this.resetOnNetworkTypeChange) {
            if (this.networkTypeOverrideSet) {
                i = this.networkTypeOverride;
            }
            if (i2 == i) {
                return;
            }
            this.networkType = i;
            if (i != 1 && i != 0 && i != 8) {
                this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(i);
                long jElapsedRealtime = this.clock.elapsedRealtime();
                maybeNotifyBandwidthSample(this.streamCount > 0 ? (int) (jElapsedRealtime - this.sampleStartTimeMs) : 0, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = jElapsedRealtime;
                this.sampleBytesTransferred = 0L;
                this.totalBytesTransferred = 0L;
                this.totalElapsedTimeMs = 0L;
                this.slidingPercentile.reset();
            }
        }
    }

    @Override // com.google.android.inner_exoplayer2.upstream.BandwidthMeter
    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.eventDispatcher.addListener(handler, eventListener);
    }

    @Override // com.google.android.inner_exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.google.android.inner_exoplayer2.upstream.BandwidthMeter
    public TransferListener getTransferListener() {
        return this;
    }

    @Override // com.google.android.inner_exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            this.sampleBytesTransferred += (long) i;
        }
    }

    @Override // com.google.android.inner_exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            Assertions.checkState(this.streamCount > 0);
            long jElapsedRealtime = this.clock.elapsedRealtime();
            int i = (int) (jElapsedRealtime - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += (long) i;
            long j = this.totalBytesTransferred;
            long j2 = this.sampleBytesTransferred;
            this.totalBytesTransferred = j + j2;
            if (i > 0) {
                this.slidingPercentile.addSample((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                }
                maybeNotifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = jElapsedRealtime;
                this.sampleBytesTransferred = 0L;
            }
            this.streamCount--;
        }
    }

    @Override // com.google.android.inner_exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.inner_exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        }
    }

    @Override // com.google.android.inner_exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.removeListener(eventListener);
    }

    public synchronized void setNetworkTypeOverride(int i) {
        this.networkTypeOverride = i;
        this.networkTypeOverrideSet = true;
        onNetworkTypeChanged(i);
    }

    public static final class Builder {
        private Clock clock;

        @Nullable
        private final Context context;
        private Map<Integer, Long> initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context) {
            this.context = context == null ? null : context.getApplicationContext();
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.getCountryCode(context));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        private static Map<Integer, Long> getInitialBitrateEstimatesForCountry(String str) {
            int[] initialBitrateCountryGroupAssignment = DefaultBandwidthMeter.getInitialBitrateCountryGroupAssignment(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            ImmutableList<Long> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
            map.put(2, immutableList.get(initialBitrateCountryGroupAssignment[0]));
            map.put(3, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(initialBitrateCountryGroupAssignment[1]));
            map.put(4, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(initialBitrateCountryGroupAssignment[2]));
            map.put(5, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(initialBitrateCountryGroupAssignment[3]));
            map.put(10, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(initialBitrateCountryGroupAssignment[4]));
            map.put(9, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA.get(initialBitrateCountryGroupAssignment[5]));
            map.put(7, immutableList.get(initialBitrateCountryGroupAssignment[0]));
            return map;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange);
        }

        @CanIgnoreReturnValue
        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setInitialBitrateEstimate(long j) {
            Iterator<Integer> it = this.initialBitrateEstimates.keySet().iterator();
            while (it.hasNext()) {
                setInitialBitrateEstimate(it.next().intValue(), j);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.resetOnNetworkTypeChange = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setInitialBitrateEstimate(int i, long j) {
            this.initialBitrateEstimates.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setInitialBitrateEstimate(String str) {
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(com.google.common.base.a.j(str));
            return this;
        }
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, ImmutableMap.of(), 2000, Clock.DEFAULT, false);
    }

    private DefaultBandwidthMeter(@Nullable Context context, Map<Integer, Long> map, int i, Clock clock, boolean z) {
        this.initialBitrateEstimates = ImmutableMap.copyOf((Map) map);
        this.eventDispatcher = new BandwidthMeter.EventListener.EventDispatcher();
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock;
        this.resetOnNetworkTypeChange = z;
        if (context != null) {
            NetworkTypeObserver networkTypeObserver = NetworkTypeObserver.getInstance(context);
            int networkType = networkTypeObserver.getNetworkType();
            this.networkType = networkType;
            this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType);
            networkTypeObserver.register(new NetworkTypeObserver.Listener() { // from class: com.zj.adlib.re2
                @Override // com.google.android.inner_exoplayer2.util.NetworkTypeObserver.Listener
                public final void onNetworkTypeChanged(int i2) {
                    this.f44430a.onNetworkTypeChanged(i2);
                }
            });
            return;
        }
        this.networkType = 0;
        this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(0);
    }
}
