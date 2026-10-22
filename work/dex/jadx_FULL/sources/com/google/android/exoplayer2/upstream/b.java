package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.huachenjie.common.constants.ErrorCode;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.igexin.assist.sdk.AssistPushConsts;
import com.ipd.dsp.internal.q.u;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.aq6;
import com.zj.adlib.gj9;
import com.zj.adlib.go6;
import com.zj.adlib.i55;
import com.zj.adlib.ib3;
import com.zj.adlib.kk8;
import com.zj.adlib.sb0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements BandwidthMeter, TransferListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static b f31126a = null;
    public static final int d = 2000;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final long f5089g = 1000000;
    public static final int h = 3;
    public static final int i = 4;
    public static final int j = 5;
    public static final int k = 2000;
    public static final int l = 524288;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f5090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BandwidthMeter.EventListener.a f5092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f5093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableMap<Integer, Long> f5094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kk8 f5095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5096a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f5097b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5098b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5099b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f5100c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f5101c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f5102d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f5103e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f5104f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ImmutableList<Long> f5085a = ImmutableList.of(4800000L, 3100000L, 2100000L, 1500000L, 800000L);
    public static final ImmutableList<Long> b = ImmutableList.of(1500000L, 1000000L, 730000L, 440000L, 170000L);
    public static final ImmutableList<Long> c = ImmutableList.of(2200000L, 1400000L, 1100000L, 910000L, 620000L);

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final ImmutableList<Long> f5086d = ImmutableList.of(3000000L, 1900000L, 1400000L, 1000000L, 660000L);

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final ImmutableList<Long> f5087e = ImmutableList.of(6000000L, 4100000L, 3200000L, 1800000L, 1000000L);

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final ImmutableList<Long> f5088f = ImmutableList.of(2800000L, 2400000L, 1600000L, 1100000L, 950000L);

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.b$b, reason: collision with other inner class name */
    public static final class C0701b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31127a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Context f5105a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Clock f5106a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<Integer, Long> f5107a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5108a;

        public C0701b(Context context) {
            this.f5105a = context == null ? null : context.getApplicationContext();
            this.f5107a = b(gj9.V(context));
            this.f31127a = 2000;
            this.f5106a = Clock.f31152a;
            this.f5108a = true;
        }

        public static Map<Integer, Long> b(String str) {
            int[] iArrJ = b.j(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            ImmutableList<Long> immutableList = b.f5085a;
            map.put(2, immutableList.get(iArrJ[0]));
            map.put(3, b.b.get(iArrJ[1]));
            map.put(4, b.c.get(iArrJ[2]));
            map.put(5, b.f5086d.get(iArrJ[3]));
            map.put(10, b.f5087e.get(iArrJ[4]));
            map.put(9, b.f5088f.get(iArrJ[5]));
            map.put(7, immutableList.get(iArrJ[0]));
            return map;
        }

        public b a() {
            return new b(this.f5105a, this.f5107a, this.f31127a, this.f5106a, this.f5108a);
        }

        public C0701b c(Clock clock) {
            this.f5106a = clock;
            return this;
        }

        public C0701b d(int i, long j) {
            this.f5107a.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        public C0701b e(long j) {
            Iterator<Integer> it = this.f5107a.keySet().iterator();
            while (it.hasNext()) {
                d(it.next().intValue(), j);
            }
            return this;
        }

        public C0701b f(String str) {
            this.f5107a = b(com.google.common.base.a.j(str));
            return this;
        }

        public C0701b g(boolean z) {
            this.f5108a = z;
            return this;
        }

        public C0701b h(int i) {
            this.f31127a = i;
            return this;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int[] j(String str) {
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    b2 = 0;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    b2 = 1;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    b2 = 2;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    b2 = 3;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    b2 = 4;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    b2 = 5;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    b2 = 6;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    b2 = 7;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    b2 = 8;
                }
                break;
            case 2097:
                if (str.equals("AR")) {
                    b2 = 9;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    b2 = 10;
                }
                break;
            case i55.b /* 2099 */:
                if (str.equals("AT")) {
                    b2 = 11;
                }
                break;
            case 2100:
                if (str.equals("AU")) {
                    b2 = 12;
                }
                break;
            case ErrorCode.FENCE_ERROR.f33661a /* 2102 */:
                if (str.equals("AW")) {
                    b2 = 13;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    b2 = com.google.common.base.a.p;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    b2 = com.google.common.base.a.q;
                }
                break;
            case 2111:
                if (str.equals("BA")) {
                    b2 = com.google.common.base.a.r;
                }
                break;
            case 2112:
                if (str.equals("BB")) {
                    b2 = 17;
                }
                break;
            case 2114:
                if (str.equals("BD")) {
                    b2 = com.google.common.base.a.u;
                }
                break;
            case 2115:
                if (str.equals("BE")) {
                    b2 = 19;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    b2 = com.google.common.base.a.x;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    b2 = com.google.common.base.a.y;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    b2 = com.google.common.base.a.z;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    b2 = com.google.common.base.a.A;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    b2 = com.google.common.base.a.B;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    b2 = com.google.common.base.a.C;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    b2 = com.google.common.base.a.D;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    b2 = com.google.common.base.a.E;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    b2 = com.google.common.base.a.F;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    b2 = com.google.common.base.a.G;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    b2 = com.google.common.base.a.H;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    b2 = 31;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    b2 = 32;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.e;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    b2 = 34;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    b2 = 35;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    b2 = 36;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.g;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.h;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.i;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    b2 = MaterialProgressDrawable.c;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.j;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    b2 = 42;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.l;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.m;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.n;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    b2 = com.google.android.exoplayer2.text.cea.a.o;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    b2 = 47;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.i;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.j;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.k;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.l;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.m;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.n;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.o;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    b2 = com.alibaba.ariver.resource.parser.a.e.p;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    b2 = MaterialProgressDrawable.d;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    b2 = 57;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    b2 = 58;
                }
                break;
            case SecExceptionCode.SEC_ERROR_LBSRISK_INIT_JNI_FAILED /* 2206 */:
                if (str.equals("EC")) {
                    b2 = 59;
                }
                break;
            case SecExceptionCode.SEC_ERROR_LBSRISK_GET_WUA_FAILED /* 2208 */:
                if (str.equals("EE")) {
                    b2 = 60;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    b2 = 61;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    b2 = 62;
                }
                break;
            case SecExceptionCode.SEC_ERROR_LBSRISK_INVALID_BINARY_FORMAT /* 2222 */:
                if (str.equals("ES")) {
                    b2 = 63;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    b2 = SignedBytes.f32242a;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    b2 = 65;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    b2 = 66;
                }
                break;
            case 2245:
                if (str.equals("FK")) {
                    b2 = 67;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    b2 = 68;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    b2 = 69;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    b2 = 70;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    b2 = 71;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    b2 = 72;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    b2 = 73;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    b2 = 74;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    b2 = 75;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    b2 = 76;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    b2 = 77;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    b2 = 78;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    b2 = 79;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    b2 = 80;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    b2 = 81;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    b2 = 82;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    b2 = 83;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    b2 = 84;
                }
                break;
            case 2285:
                if (str.equals(com.igexin.push.core.b.j)) {
                    b2 = 85;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    b2 = 86;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    b2 = 87;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    b2 = 88;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    b2 = 89;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    b2 = 90;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    b2 = 91;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    b2 = 92;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    b2 = 93;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    b2 = 94;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    b2 = 95;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    b2 = 96;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    b2 = 97;
                }
                break;
            case 2342:
                if (str.equals(RVScheduleType.IO)) {
                    b2 = 98;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    b2 = 99;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    b2 = 100;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    b2 = 101;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    b2 = 102;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    b2 = 103;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    b2 = 104;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    b2 = 105;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    b2 = 106;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    b2 = 107;
                }
                break;
            case 2396:
                if (str.equals(ib3.o)) {
                    b2 = 108;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    b2 = 109;
                }
                break;
            case SecExceptionCode.SEC_ERROR_MIDDLE_TIER_UNKONWN_ENCODING_ERROR /* 2398 */:
                if (str.equals("KI")) {
                    b2 = 110;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_NO_APPKEY /* 2402 */:
                if (str.equals("KM")) {
                    b2 = 111;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_INIT_FAILED /* 2403 */:
                if (str.equals("KN")) {
                    b2 = 112;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_SIGN_FAILED /* 2405 */:
                if (str.equals("KP")) {
                    b2 = 113;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_WUA_FAILED /* 2407 */:
                if (str.equals("KR")) {
                    b2 = 114;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    b2 = 115;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    b2 = 116;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    b2 = 117;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    b2 = 118;
                }
                break;
            case 2422:
                if (str.equals(ib3.p)) {
                    b2 = 119;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    b2 = aq6.f40585a;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    b2 = 121;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    b2 = 122;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    b2 = 123;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    b2 = 124;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    b2 = 125;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    b2 = 126;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    b2 = 127;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    b2 = UnsignedBytes.f32243a;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    b2 = 129;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    b2 = 130;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    b2 = 131;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    b2 = 132;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    b2 = 133;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    b2 = 134;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    b2 = 135;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    b2 = 136;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    b2 = 137;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    b2 = 138;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    b2 = 139;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    b2 = 140;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    b2 = 141;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    b2 = 142;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    b2 = 143;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    b2 = 144;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    b2 = 145;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    b2 = 146;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    b2 = 147;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    b2 = 148;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    b2 = 149;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    b2 = 150;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    b2 = 151;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    b2 = 152;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    b2 = 153;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    b2 = 154;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    b2 = 155;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    b2 = 156;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    b2 = 157;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    b2 = 158;
                }
                break;
            case SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_UNKONWN_ENCODING_ERROR /* 2498 */:
                if (str.equals("NP")) {
                    b2 = 159;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    b2 = 160;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    b2 = 161;
                }
                break;
            case AVMDLDataLoader.KeyIsEnablePreconnect /* 2508 */:
                if (str.equals("NZ")) {
                    b2 = 162;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    b2 = 163;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    b2 = 164;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    b2 = 165;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    b2 = 166;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    b2 = 167;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    b2 = 168;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    b2 = 169;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    b2 = 170;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    b2 = 171;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    b2 = 172;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    b2 = 173;
                }
                break;
            case 2564:
                if (str.equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                    b2 = 174;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    b2 = 175;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    b2 = 176;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    b2 = 177;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    b2 = 178;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    b2 = 179;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    b2 = 180;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    b2 = 181;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    b2 = 182;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    b2 = 183;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    b2 = 184;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    b2 = 185;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    b2 = 186;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    b2 = 187;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    b2 = 188;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    b2 = 189;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    b2 = 190;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    b2 = 191;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    b2 = u.n7;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    b2 = u.o7;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    b2 = u.p7;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    b2 = u.q7;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    b2 = 196;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    b2 = u.r7;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    b2 = u.s7;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    b2 = u.t7;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    b2 = 200;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    b2 = u.u7;
                }
                break;
            case 2671:
                if (str.equals(com.ipd.dsp.internal.s0.b.d)) {
                    b2 = u.v7;
                }
                break;
            case 2672:
                if (str.equals(com.ipd.dsp.internal.s0.b.e)) {
                    b2 = u.w7;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    b2 = 204;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    b2 = u.x7;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    b2 = u.y7;
                }
                break;
            case 2679:
                if (str.equals("TK")) {
                    b2 = u.z7;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    b2 = 208;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    b2 = 209;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    b2 = 210;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    b2 = 211;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    b2 = 212;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    b2 = 213;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    b2 = 214;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    b2 = 215;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    b2 = u.m7;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    b2 = u.D7;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    b2 = u.A7;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    b2 = 219;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    b2 = 220;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    b2 = 221;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    b2 = 222;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    b2 = 223;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    b2 = 224;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    b2 = u.B7;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    b2 = 226;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    b2 = 227;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    b2 = 228;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    b2 = 229;
                }
                break;
            case 2780:
                if (str.equals(com.alipay.android.phone.mobilesdk.socketcraft.e.c.f25296a)) {
                    b2 = 230;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    b2 = 231;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    b2 = 232;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    b2 = 233;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    b2 = 234;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    b2 = 235;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    b2 = 236;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 26:
            case 29:
            case 73:
            case 79:
            case 112:
            case 116:
            case 120:
            case MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG /* 223 */:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 4, 4, 4, 0};
            case 2:
            case 80:
                return new int[]{4, 3, 3, 4, 2, 2};
            case 3:
                return new int[]{2, 4, 1, 2, 2, 2};
            case 4:
                return new int[]{0, 2, 0, 3, 2, 2};
            case 5:
            case 231:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 6:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 8:
            case 62:
            case 188:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
            case 108:
            case 210:
            case MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM /* 220 */:
                return new int[]{2, 1, 1, 1, 2, 2};
            case 10:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 11:
                return new int[]{1, 0, 1, 1, 0, 0};
            case 12:
                return new int[]{0, 1, 1, 1, 2, 0};
            case 13:
                return new int[]{1, 3, 4, 4, 2, 2};
            case 14:
            case 121:
            case 144:
            case MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE /* 171 */:
            case 192:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case 75:
            case 128:
            case 169:
            case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
            case 211:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 16:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 17:
            case 56:
            case 69:
            case 78:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 18:
                return new int[]{2, 1, 3, 3, 2, 2};
            case 19:
                return new int[]{0, 1, 4, 4, 3, 2};
            case 20:
                return new int[]{4, 3, 4, 3, 2, 2};
            case 21:
            case 145:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME /* 190 */:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 2, 1, 3, 4, 2};
            case 23:
            case 91:
            case 111:
            case 134:
            case 154:
            case 185:
            case 203:
            case 224:
            case 232:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 3, 3, 2, 2};
            case 25:
            case 50:
            case 222:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 27:
            case 49:
                return new int[]{2, 2, 0, 0, 2, 2};
            case 28:
                return new int[]{1, 2, 3, 2, 2, 2};
            case 30:
                return new int[]{4, 4, 2, 2, 2, 2};
            case 31:
                return new int[]{3, 1, 3, 2, 2, 2};
            case 32:
                return new int[]{3, 2, 1, 0, 2, 2};
            case 33:
                return new int[]{0, 1, 2, 3, 2, 2};
            case 34:
                return new int[]{2, 4, 2, 1, 2, 2};
            case 35:
                return new int[]{0, 2, 2, 2, 3, 2};
            case 36:
                return new int[]{4, 2, 3, 2, 2, 2};
            case 37:
            case 110:
                return new int[]{4, 2, 4, 2, 2, 2};
            case 38:
            case 61:
            case 87:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 39:
                return new int[]{0, 0, 0, 1, 0, 2};
            case 40:
            case 58:
            case 123:
                return new int[]{3, 4, 4, 4, 2, 2};
            case 41:
            case 166:
                return new int[]{2, 2, 2, 1, 2, 2};
            case 42:
            case 95:
                return new int[]{1, 2, 2, 2, 3, 2};
            case 43:
                return new int[]{3, 3, 3, 3, 2, 2};
            case 44:
                return new int[]{2, 0, 1, 1, 3, 2};
            case 45:
                return new int[]{2, 3, 4, 3, 2, 2};
            case 46:
                return new int[]{2, 3, 4, 4, 2, 2};
            case 47:
            case 54:
            case 200:
            case 206:
            case 208:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 48:
                return new int[]{2, 1, 0, 0, 2, 2};
            case 51:
            case 115:
                return new int[]{1, 0, 0, 0, 0, 2};
            case 52:
            case 158:
                return new int[]{0, 0, 2, 0, 1, 2};
            case 53:
                return new int[]{0, 1, 2, 2, 2, 3};
            case 55:
                return new int[]{0, 0, 3, 2, 0, 2};
            case 57:
                return new int[]{3, 4, 4, 4, 4, 2};
            case 59:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 60:
            case 101:
            case 127:
            case 174:
            case 186:
            case 215:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 63:
            case 94:
                return new int[]{0, 1, 1, 1, 2, 2};
            case 64:
                return new int[]{4, 3, 3, 1, 2, 2};
            case 65:
                return new int[]{0, 0, 0, 3, 0, 2};
            case 66:
                return new int[]{3, 1, 2, 2, 2, 2};
            case 67:
            case 107:
            case 113:
                return new int[]{3, 2, 2, 2, 2, 2};
            case 68:
                return new int[]{4, 2, 4, 1, 2, 2};
            case 70:
                return new int[]{1, 2, 3, 1, 0, 2};
            case 71:
            case 204:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 72:
                return new int[]{0, 0, 1, 1, 1, 1};
            case 74:
                return new int[]{1, 1, 1, 2, 2, 2};
            case 76:
            case 226:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 77:
            case 152:
            case 228:
                return new int[]{3, 3, 3, 2, 2, 2};
            case 81:
                return new int[]{4, 3, 4, 2, 2, 2};
            case 82:
            case 142:
                return new int[]{2, 1, 2, 3, 2, 2};
            case 83:
                return new int[]{4, 2, 1, 4, 2, 2};
            case 84:
            case 90:
            case 189:
                return new int[]{1, 0, 0, 0, 1, 2};
            case 85:
                return new int[]{2, 3, 2, 2, 2, 2};
            case 86:
            case 165:
                return new int[]{1, 2, 4, 4, 4, 2};
            case 88:
                return new int[]{3, 2, 2, 1, 2, 2};
            case 89:
                return new int[]{0, 1, 2, 3, 2, 0};
            case 92:
                return new int[]{0, 0, 0, 1, 3, 2};
            case 93:
                return new int[]{3, 1, 2, 2, 3, 2};
            case 96:
            case 217:
                return new int[]{0, 2, 1, 1, 2, 2};
            case 97:
                return new int[]{1, 1, 3, 2, 3, 3};
            case 98:
            case 135:
            case go6.g /* 214 */:
            case 229:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 99:
                return new int[]{3, 2, 2, 3, 2, 2};
            case 100:
                return new int[]{3, 0, 1, 1, 4, 1};
            case 102:
                return new int[]{0, 0, 0, 1, 1, 2};
            case 103:
            case 233:
                return new int[]{4, 2, 2, 3, 2, 2};
            case 104:
                return new int[]{2, 4, 3, 2, 2, 2};
            case 105:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 106:
                return new int[]{0, 1, 1, 2, 2, 4};
            case 109:
                return new int[]{2, 1, 4, 2, 2, 2};
            case 114:
                return new int[]{0, 1, 1, 3, 4, 4};
            case 117:
                return new int[]{2, 1, 2, 2, 2, 2};
            case 118:
                return new int[]{1, 2, 1, 3, 2, 2};
            case 119:
                return new int[]{3, 3, 2, 4, 2, 2};
            case 122:
                return new int[]{3, 1, 3, 3, 4, 2};
            case 124:
                return new int[]{3, 3, 2, 2, 2, 2};
            case 125:
                return new int[]{0, 0, 0, 0, 2, 2};
            case 126:
                return new int[]{1, 0, 3, 2, 1, 4};
            case 129:
                return new int[]{3, 3, 1, 1, 2, 2};
            case 130:
                return new int[]{0, 2, 2, 0, 2, 2};
            case 131:
            case 179:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 132:
                return new int[]{2, 0, 0, 1, 2, 2};
            case 133:
            case 177:
                return new int[]{1, 2, 1, 2, 2, 2};
            case 136:
                return new int[]{1, 0, 0, 1, 3, 2};
            case 137:
            case 167:
                return new int[]{4, 3, 3, 2, 2, 2};
            case 138:
                return new int[]{2, 4, 2, 3, 2, 2};
            case 139:
                return new int[]{2, 0, 1, 2, 2, 2};
            case 140:
            case 141:
                return new int[]{0, 2, 4, 4, 2, 2};
            case 143:
            case 236:
                return new int[]{4, 2, 4, 4, 2, 2};
            case 146:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 147:
                return new int[]{3, 4, 1, 4, 2, 2};
            case 148:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 149:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 150:
                return new int[]{1, 0, 3, 1, 3, 2};
            case 151:
                return new int[]{3, 1, 2, 1, 2, 2};
            case 153:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 155:
                return new int[]{3, 4, 2, 1, 2, 2};
            case 156:
            case 164:
            case 198:
                return new int[]{2, 3, 3, 3, 2, 2};
            case 157:
                return new int[]{0, 2, 2, 3, 0, 3};
            case 159:
                return new int[]{2, 2, 4, 3, 2, 2};
            case 160:
            case 161:
                return new int[]{4, 2, 2, 1, 2, 2};
            case 162:
            case com.google.common.math.c.f6376a /* 170 */:
                return new int[]{1, 1, 2, 2, 4, 2};
            case 163:
                return new int[]{2, 3, 1, 3, 4, 2};
            case 168:
                return new int[]{2, 1, 3, 3, 3, 0};
            case 172:
                return new int[]{2, 0, 2, 1, 2, 1};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT /* 173 */:
                return new int[]{3, 4, 1, 2, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED /* 175 */:
                return new int[]{2, 2, 4, 1, 2, 2};
            case 176:
                return new int[]{2, 4, 4, 4, 4, 2};
            case 178:
                return new int[]{0, 0, 1, 2, 1, 2};
            case 180:
                return new int[]{1, 0, 0, 0, 4, 3};
            case 181:
                return new int[]{3, 4, 2, 0, 2, 2};
            case 182:
                return new int[]{3, 1, 1, 1, 2, 2};
            case 183:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 184:
            case 209:
                return new int[]{4, 2, 1, 1, 2, 2};
            case 187:
                return new int[]{1, 1, 2, 2, 2, 1};
            case MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED /* 191 */:
            case 218:
                return new int[]{3, 3, 4, 3, 2, 2};
            case 193:
                return new int[]{4, 4, 4, 3, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO /* 195 */:
                return new int[]{2, 4, 3, 0, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE /* 196 */:
                return new int[]{4, 3, 2, 3, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY /* 197 */:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 199:
            case 202:
                return new int[]{1, 2, 1, 0, 2, 2};
            case 201:
                return new int[]{3, 3, 3, 4, 2, 2};
            case 205:
                return new int[]{0, 2, 2, 3, 3, 4};
            case 207:
                return new int[]{2, 2, 2, 4, 2, 2};
            case 212:
                return new int[]{1, 1, 0, 0, 2, 2};
            case 213:
                return new int[]{1, 4, 1, 3, 2, 2};
            case 216:
                return new int[]{3, 4, 3, 2, 2, 2};
            case 219:
                return new int[]{1, 0, 2, 2, 3, 1};
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR /* 221 */:
                return new int[]{2, 2, 3, 4, 2, 2};
            case 225:
                return new int[]{2, 2, 1, 1, 2, 2};
            case 227:
                return new int[]{0, 3, 3, 4, 2, 2};
            case MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT /* 230 */:
                return new int[]{3, 1, 3, 1, 2, 2};
            case 234:
                return new int[]{3, 2, 2, 1, 1, 2};
            case 235:
                return new int[]{3, 3, 4, 2, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    public static synchronized b l(Context context) {
        if (f31126a == null) {
            f31126a = new C0701b(context).a();
        }
        return f31126a;
    }

    public static boolean m(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.d(8);
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void a(DataSource dataSource, DataSpec dataSpec, boolean z, int i2) {
        if (m(dataSpec, z)) {
            this.f5098b += (long) i2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public TransferListener b() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void c(Handler handler, BandwidthMeter.EventListener eventListener) {
        sb0.g(handler);
        sb0.g(eventListener);
        this.f5092a.b(handler, eventListener);
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void d(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void e(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (m(dataSpec, z)) {
            if (this.f5090a == 0) {
                this.f5091a = this.f5093a.elapsedRealtime();
            }
            this.f5090a++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void f(BandwidthMeter.EventListener eventListener) {
        this.f5092a.e(eventListener);
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void g(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (m(dataSpec, z)) {
            sb0.i(this.f5090a > 0);
            long jElapsedRealtime = this.f5093a.elapsedRealtime();
            int i2 = (int) (jElapsedRealtime - this.f5091a);
            this.f5101c += (long) i2;
            long j2 = this.f5102d;
            long j3 = this.f5098b;
            this.f5102d = j2 + j3;
            if (i2 > 0) {
                this.f5095a.c((int) Math.sqrt(j3), (j3 * 8000.0f) / i2);
                if (this.f5101c >= 2000 || this.f5102d >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.f5103e = (long) this.f5095a.f(0.5f);
                }
                n(i2, this.f5098b, this.f5103e);
                this.f5091a = jElapsedRealtime;
                this.f5098b = 0L;
            }
            this.f5090a--;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.f5103e;
    }

    public final long k(int i2) {
        Long l2 = this.f5094a.get(Integer.valueOf(i2));
        if (l2 == null) {
            l2 = this.f5094a.get(0);
        }
        if (l2 == null) {
            l2 = 1000000L;
        }
        return l2.longValue();
    }

    public final void n(int i2, long j2, long j3) {
        if (i2 == 0 && j2 == 0 && j3 == this.f5104f) {
            return;
        }
        this.f5104f = j3;
        this.f5092a.c(i2, j2, j3);
    }

    public final synchronized void o(int i2) {
        int i3 = this.f5097b;
        if (i3 == 0 || this.f5096a) {
            if (this.f5099b) {
                i2 = this.f5100c;
            }
            if (i3 == i2) {
                return;
            }
            this.f5097b = i2;
            if (i2 != 1 && i2 != 0 && i2 != 8) {
                this.f5103e = k(i2);
                long jElapsedRealtime = this.f5093a.elapsedRealtime();
                n(this.f5090a > 0 ? (int) (jElapsedRealtime - this.f5091a) : 0, this.f5098b, this.f5103e);
                this.f5091a = jElapsedRealtime;
                this.f5098b = 0L;
                this.f5102d = 0L;
                this.f5101c = 0L;
                this.f5095a.i();
            }
        }
    }

    public synchronized void p(int i2) {
        this.f5100c = i2;
        this.f5099b = true;
        o(i2);
    }

    @Deprecated
    public b() {
        this(null, ImmutableMap.of(), 2000, Clock.f31152a, false);
    }

    public b(@Nullable Context context, Map<Integer, Long> map, int i2, Clock clock, boolean z) {
        this.f5094a = ImmutableMap.copyOf((Map) map);
        this.f5092a = new BandwidthMeter.EventListener.a();
        this.f5095a = new kk8(i2);
        this.f5093a = clock;
        this.f5096a = z;
        if (context != null) {
            NetworkTypeObserver networkTypeObserverD = NetworkTypeObserver.d(context);
            int iF = networkTypeObserverD.f();
            this.f5097b = iF;
            this.f5103e = k(iF);
            networkTypeObserverD.i(new NetworkTypeObserver.Listener() { // from class: com.zj.adlib.se2
                @Override // com.google.android.exoplayer2.util.NetworkTypeObserver.Listener
                public final void onNetworkTypeChanged(int i3) {
                    this.f44668a.o(i3);
                }
            });
            return;
        }
        this.f5097b = 0;
        this.f5103e = k(0);
    }
}
