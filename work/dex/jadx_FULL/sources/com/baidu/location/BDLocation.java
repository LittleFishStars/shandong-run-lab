package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.baidu.location.e.h;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.huachenjie.common.constants.UserConstants;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_COOR_TYPE_BD09LL = "bd09";
    public static final String BDLOCATION_COOR_TYPE_BD09MC = "bd09mc";
    public static final String BDLOCATION_COOR_TYPE_GCJ02 = "gcj02";
    public static final String BDLOCATION_COOR_TYPE_GCJ03 = "gcj03";
    public static final String BDLOCATION_COOR_TYPE_WGS84 = "wgs84";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU = "bd_beidou";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM = "system";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator<BDLocation>() { // from class: com.baidu.location.BDLocation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BDLocation[] newArray(int i) {
            return new BDLocation[i];
        }
    };
    public static final int GNSS_ACCURACY_BAD = 3;
    public static final int GNSS_ACCURACY_GOOD = 1;
    public static final int GNSS_ACCURACY_MID = 2;
    public static final int GNSS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int MOCK_GNSS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GNSS_PROBABILITY_LOW = 1;
    public static final int MOCK_GNSS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GNSS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GNSS_PROBABILITY_ZERO = 0;
    public static final int MOCK_GPS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GPS_PROBABILITY_LOW = 1;
    public static final int MOCK_GPS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GPS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GPS_PROBABILITY_ZERO = 0;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TYPE_BMS_HD_LOCATION = 602;
    public static final int TYPE_CLOSE_LOCATION_SERVICE_SWITCH_FAIL = 69;
    public static final int TYPE_HD_LOCATION = 601;
    public static final int TYPE_LANE_HD_LOCATION = 603;
    public static final int TYPE_NO_PERMISSION_AND_CLOSE_SWITCH_FAIL = 71;
    public static final int TYPE_NO_PERMISSION_LOCATION_FAIL = 70;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCoarseLocation = 160;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGnssLocation = 61;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckFlowError = 506;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;
    private String A;
    private String B;
    private String C;
    private double D;
    private boolean E;
    private int F;
    private int G;
    private String H;
    private int I;
    private String J;
    private int K;
    private int L;
    private int M;
    private int N;
    private String O;
    private String P;
    private String Q;
    private int R;
    private List<Poi> S;
    private String T;
    private String U;
    private String V;
    private Bundle W;
    private int X;
    private int Y;
    private long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26319a;
    private String aa;
    private String ab;
    private double ac;
    private double ad;
    private boolean ae;
    private PoiRegion af;
    private float ag;
    private double ah;
    private int ai;
    private int aj;
    private BDLocation ak;
    private Bundle al;
    private String am;
    private long an;
    private String b;
    private double c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private String k;
    private float l;
    private int m;
    private float n;
    private boolean o;
    private int p;
    private float q;
    private String r;
    private boolean s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private Address z;

    public BDLocation() {
        this.f26319a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
    }

    private BDLocation(Parcel parcel) {
        this.f26319a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
        this.f26319a = parcel.readInt();
        this.b = parcel.readString();
        this.an = parcel.readLong();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.k = parcel.readString();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt();
        this.q = parcel.readFloat();
        this.A = parcel.readString();
        this.F = parcel.readInt();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readDouble();
        this.H = parcel.readString();
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        String string10 = parcel.readString();
        this.z = new Address.Builder().country(string7).countryCode(string8).province(string).city(string2).cityCode(string6).district(string3).street(string4).streetNumber(string5).adcode(string9).town(string10).townCode(parcel.readString()).build();
        boolean[] zArr = new boolean[8];
        this.I = parcel.readInt();
        this.J = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.G = parcel.readInt();
        this.T = parcel.readString();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readInt();
        this.X = parcel.readInt();
        this.U = parcel.readString();
        this.Y = parcel.readInt();
        this.V = parcel.readString();
        this.aa = parcel.readString();
        this.ab = parcel.readString();
        this.Z = parcel.readLong();
        this.ac = parcel.readDouble();
        this.ad = parcel.readDouble();
        this.ag = parcel.readFloat();
        this.ah = parcel.readDouble();
        this.ai = parcel.readInt();
        this.aj = parcel.readInt();
        this.r = parcel.readString();
        this.am = parcel.readString();
        this.u = parcel.readString();
        try {
            this.ak = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e) {
            this.ak = null;
            e.printStackTrace();
        }
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.o = zArr[3];
            this.s = zArr[4];
            this.y = zArr[5];
            this.E = zArr[6];
            this.ae = zArr[7];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            parcel.readList(arrayList, Poi.class.getClassLoader());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.S = null;
        } else {
            this.S = arrayList;
        }
        try {
            this.W = parcel.readBundle();
        } catch (Exception e3) {
            e3.printStackTrace();
            this.W = new Bundle();
        }
        try {
            this.al = parcel.readBundle();
        } catch (Exception e4) {
            e4.printStackTrace();
            this.al = new Bundle();
        }
        try {
            this.af = (PoiRegion) parcel.readParcelable(PoiRegion.class.getClassLoader());
        } catch (Exception e5) {
            this.af = null;
            e5.printStackTrace();
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.f26319a = 0;
        ArrayList arrayList = null;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
        this.f26319a = bDLocation.f26319a;
        this.b = bDLocation.b;
        this.an = bDLocation.an;
        this.c = bDLocation.c;
        this.d = bDLocation.d;
        this.e = bDLocation.e;
        this.f = bDLocation.f;
        this.g = bDLocation.g;
        this.h = bDLocation.h;
        this.i = bDLocation.i;
        this.j = bDLocation.j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.t = bDLocation.t;
        this.y = bDLocation.y;
        this.z = new Address.Builder().country(bDLocation.z.country).countryCode(bDLocation.z.countryCode).province(bDLocation.z.province).city(bDLocation.z.city).cityCode(bDLocation.z.cityCode).district(bDLocation.z.district).street(bDLocation.z.street).streetNumber(bDLocation.z.streetNumber).adcode(bDLocation.z.adcode).town(bDLocation.z.town).townCode(bDLocation.z.townCode).build();
        this.A = bDLocation.A;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.D = bDLocation.D;
        this.G = bDLocation.G;
        this.F = bDLocation.F;
        this.E = bDLocation.E;
        this.H = bDLocation.H;
        this.I = bDLocation.I;
        this.J = bDLocation.J;
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.x = bDLocation.x;
        this.K = bDLocation.K;
        this.L = bDLocation.L;
        this.M = bDLocation.L;
        this.N = bDLocation.N;
        this.O = bDLocation.O;
        this.P = bDLocation.P;
        this.Q = bDLocation.Q;
        this.R = bDLocation.R;
        this.X = bDLocation.X;
        this.V = bDLocation.V;
        this.aa = bDLocation.aa;
        this.ab = bDLocation.ab;
        this.ac = bDLocation.ac;
        this.ad = bDLocation.ad;
        this.Z = bDLocation.Z;
        this.ah = bDLocation.ah;
        this.ai = bDLocation.ai;
        this.aj = bDLocation.aj;
        this.ak = bDLocation.ak;
        this.U = bDLocation.U;
        if (bDLocation.S != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < bDLocation.S.size(); i++) {
                Poi poi = bDLocation.S.get(i);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank(), poi.getTags(), poi.getAddr()));
            }
        }
        this.S = arrayList;
        this.T = bDLocation.T;
        this.W = bDLocation.W;
        this.Y = bDLocation.Y;
        this.ae = bDLocation.ae;
        this.af = bDLocation.af;
        this.ag = bDLocation.ag;
        this.al = bDLocation.al;
        this.am = bDLocation.am;
        this.u = bDLocation.u;
    }

    /* JADX WARN: Code duplicated, block: B:230:0x04f1 A[Catch: Exception -> 0x0186, Error -> 0x0804, TRY_LEAVE, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:232:0x052e  */
    /* JADX WARN: Code duplicated, block: B:239:0x0548 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:241:0x0556 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x0561 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:246:0x056d A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x0580 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:251:0x058e A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x0599 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:256:0x05a7 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:259:0x05b2 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:261:0x05c0 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x05cb A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:267:0x05db A[Catch: Exception -> 0x0186, Error -> 0x0804, TRY_LEAVE, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:269:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:274:0x05ef A[Catch: Exception -> 0x0186, Error -> 0x0804, TRY_ENTER, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:282:0x0618 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:284:0x0628 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:285:0x062d  */
    /* JADX WARN: Code duplicated, block: B:287:0x0630 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:290:0x063b A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:293:0x0654 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:296:0x0664 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:299:0x0674 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:304:0x0695 A[Catch: Exception -> 0x06b1, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:306:0x069f A[Catch: Exception -> 0x06b1, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:312:0x06b9 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:314:0x06c5 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:315:0x06c9 A[Catch: Exception -> 0x06d3, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:316:0x06ce A[Catch: Exception -> 0x06d3, Error -> 0x0804, TRY_LEAVE, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:323:0x06e0 A[Catch: Exception -> 0x0186, Error -> 0x0804, TRY_LEAVE, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:325:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:329:0x06f4 A[Catch: Exception -> 0x0704, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:330:0x0700 A[Catch: Exception -> 0x0704, Error -> 0x0804, TRY_LEAVE, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:333:0x0708  */
    /* JADX WARN: Code duplicated, block: B:335:0x070e  */
    /* JADX WARN: Code duplicated, block: B:338:0x0719 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:341:0x0729 A[Catch: Exception -> 0x0186, Error -> 0x0804, TRY_LEAVE, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:346:0x0739 A[Catch: all -> 0x075d, TryCatch #22 {all -> 0x075d, blocks: (B:344:0x0733, B:346:0x0739, B:348:0x073f, B:350:0x0743, B:352:0x075a), top: B:434:0x0733 }] */
    /* JADX WARN: Code duplicated, block: B:352:0x075a A[Catch: all -> 0x075d, TRY_LEAVE, TryCatch #22 {all -> 0x075d, blocks: (B:344:0x0733, B:346:0x0739, B:348:0x073f, B:350:0x0743, B:352:0x075a), top: B:434:0x0733 }] */
    /* JADX WARN: Code duplicated, block: B:361:0x0778 A[Catch: all -> 0x0795, TryCatch #18 {all -> 0x0795, blocks: (B:359:0x076a, B:361:0x0778, B:363:0x0780), top: B:428:0x076a }] */
    /* JADX WARN: Code duplicated, block: B:363:0x0780 A[Catch: all -> 0x0795, TRY_LEAVE, TryCatch #18 {all -> 0x0795, blocks: (B:359:0x076a, B:361:0x0778, B:363:0x0780), top: B:428:0x076a }] */
    /* JADX WARN: Code duplicated, block: B:369:0x07a3 A[Catch: Exception -> 0x0186, Error -> 0x0804, TryCatch #8 {Error -> 0x0804, blocks: (B:7:0x00b9, B:8:0x00bb, B:11:0x00ee, B:13:0x0146, B:14:0x014f, B:16:0x0157, B:17:0x0160, B:19:0x0166, B:20:0x0172, B:21:0x0176, B:24:0x017c, B:25:0x0181, B:30:0x0190, B:32:0x01bf, B:33:0x01c6, B:35:0x01cc, B:36:0x01d7, B:38:0x01dd, B:39:0x01e4, B:41:0x01ea, B:42:0x01f5, B:45:0x01ff, B:47:0x020d, B:49:0x0219, B:50:0x021c, B:52:0x0223, B:54:0x022b, B:55:0x023d, B:57:0x0243, B:59:0x0261, B:61:0x026c, B:63:0x0272, B:65:0x027b, B:66:0x0288, B:67:0x028a, B:69:0x0292, B:71:0x029e, B:72:0x02a0, B:74:0x02a8, B:76:0x02b6, B:78:0x02c1, B:80:0x02c9, B:82:0x02d4, B:84:0x02dc, B:86:0x02e7, B:88:0x02ef, B:90:0x02fa, B:92:0x0302, B:94:0x030d, B:95:0x0316, B:97:0x031e, B:99:0x032a, B:101:0x032f, B:104:0x0337, B:108:0x0341, B:110:0x0349, B:112:0x0351, B:114:0x0359, B:116:0x0361, B:118:0x0369, B:120:0x0371, B:122:0x0379, B:124:0x0381, B:126:0x0389, B:128:0x0395, B:130:0x039d, B:132:0x03a8, B:134:0x03b0, B:136:0x03bb, B:138:0x03c3, B:140:0x03ce, B:142:0x03d6, B:144:0x03e1, B:146:0x03e9, B:148:0x03f4, B:150:0x03fc, B:230:0x04f1, B:237:0x0540, B:239:0x0548, B:241:0x0556, B:242:0x0559, B:244:0x0561, B:246:0x056d, B:247:0x0578, B:249:0x0580, B:251:0x058e, B:252:0x0591, B:254:0x0599, B:256:0x05a7, B:257:0x05aa, B:259:0x05b2, B:261:0x05c0, B:262:0x05c3, B:264:0x05cb, B:265:0x05d3, B:267:0x05db, B:270:0x05e8, B:274:0x05ef, B:277:0x05f8, B:278:0x0602, B:280:0x060a, B:282:0x0618, B:284:0x0628, B:287:0x0630, B:288:0x0633, B:290:0x063b, B:291:0x064c, B:293:0x0654, B:294:0x065c, B:296:0x0664, B:297:0x066c, B:299:0x0674, B:300:0x067d, B:302:0x0685, B:304:0x0695, B:306:0x069f, B:308:0x06a3, B:310:0x06b1, B:312:0x06b9, B:314:0x06c5, B:315:0x06c9, B:316:0x06ce, B:321:0x06d8, B:323:0x06e0, B:327:0x06ee, B:329:0x06f4, B:330:0x0700, B:331:0x0704, B:334:0x070a, B:336:0x0711, B:338:0x0719, B:339:0x0721, B:341:0x0729, B:356:0x075f, B:357:0x0762, B:367:0x079b, B:369:0x07a3, B:366:0x0797, B:326:0x06eb, B:320:0x06d5, B:154:0x042f, B:156:0x043a, B:160:0x0443, B:166:0x0450, B:174:0x045d, B:182:0x046a, B:190:0x0476, B:198:0x0486, B:206:0x0496, B:214:0x04a8, B:228:0x04d7, B:234:0x053a, B:236:0x053d, B:379:0x07bf, B:380:0x07c4), top: B:408:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:413:0x060a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x0685 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:428:0x076a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:441:0x06ae A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:446:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v127 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    public BDLocation(String str) {
        ?? r2;
        boolean z;
        Exception exc;
        boolean z2;
        String str2;
        String str3;
        JSONObject jSONObject;
        boolean z3;
        Exception exc2;
        String string;
        String str4;
        String str5;
        String string2;
        String string3;
        String str6;
        String str7;
        String str8;
        String string4;
        String string5;
        String string6;
        String str9;
        String string7;
        String string8;
        String string9;
        String string10;
        int i;
        int i2;
        String str10;
        boolean z4;
        JSONObject jSONObject2;
        int i3;
        String[] strArrSplit;
        int iOptInt;
        int iIntValue;
        String str11;
        JSONObject jSONObject3;
        String str12;
        String str13;
        String string11;
        String str14;
        String[] strArrSplit2;
        int iIntValue2;
        String string12;
        String string13;
        String string14;
        String string15;
        String string16;
        String string17;
        this.f26319a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = new Address.Builder().build();
        this.A = null;
        this.B = null;
        this.C = null;
        this.E = false;
        this.F = 0;
        this.G = 1;
        this.H = null;
        this.J = "";
        this.K = -1;
        this.L = 0;
        this.M = 2;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new Bundle();
        this.X = 0;
        this.Y = 0;
        this.Z = 0L;
        this.aa = null;
        this.ab = null;
        this.ac = Double.MIN_VALUE;
        this.ad = Double.MIN_VALUE;
        this.ae = false;
        this.af = null;
        this.ag = -1.0f;
        this.ah = -1.0d;
        this.ai = 0;
        this.aj = -1;
        this.al = null;
        this.am = null;
        this.an = -1L;
        if (str == null || str.equals("")) {
            return;
        }
        try {
            try {
                try {
                    JSONObject jSONObject4 = new JSONObject(str);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject("result");
                    int i4 = Integer.parseInt(jSONObject5.getString("error"));
                    setLocType(i4);
                    setTime(jSONObject5.getString("time"));
                    String str15 = "x";
                    String str16 = "y";
                    try {
                        if (i4 == 61) {
                            JSONObject jSONObject6 = jSONObject4.getJSONObject("content");
                            JSONObject jSONObject7 = jSONObject6.getJSONObject(SQLiteMTAHelper.TABLE_POINT);
                            setLatitude(Double.parseDouble(jSONObject7.getString("y")));
                            setLongitude(Double.parseDouble(jSONObject7.getString("x")));
                            setRadius(Float.parseFloat(jSONObject6.getString("radius")));
                            setSpeed(Float.parseFloat(jSONObject6.getString("s")));
                            setDirection(Float.parseFloat(jSONObject6.getString("d")));
                            setSatelliteNumber(Integer.parseInt(jSONObject6.getString("n")));
                            if (jSONObject6.has("is_mock")) {
                                setMockGpsStrategy(jSONObject6.getInt("is_mock"));
                            }
                            if (jSONObject6.has(y6b.g)) {
                                try {
                                    setAltitude(jSONObject6.getDouble(y6b.g));
                                } catch (Exception unused) {
                                }
                            }
                            try {
                                if (jSONObject6.has("in_cn")) {
                                    setLocationWhere(Integer.parseInt(jSONObject6.getString("in_cn")));
                                } else {
                                    setLocationWhere(1);
                                }
                            } catch (Exception unused2) {
                            }
                            if (this.G != 0) {
                                setCoorType("gcj02");
                                return;
                            }
                            str2 = "wgs84";
                        } else {
                            str2 = "gcj02";
                            if (i4 == 161) {
                                JSONObject jSONObject8 = jSONObject4.getJSONObject("content");
                                JSONObject jSONObject9 = jSONObject8.getJSONObject(SQLiteMTAHelper.TABLE_POINT);
                                setLatitude(Double.parseDouble(jSONObject9.getString("y")));
                                setLongitude(Double.parseDouble(jSONObject9.getString("x")));
                                setRadius(Float.parseFloat(jSONObject8.getString("radius")));
                                if (jSONObject8.has("traffic")) {
                                    setTraffic(jSONObject8.getString("traffic"));
                                }
                                if (jSONObject8.has("traffic_prop")) {
                                    setTrafficConfidence(Float.parseFloat(jSONObject8.optString("traffic_prop")));
                                }
                                if (jSONObject8.has("is_station")) {
                                    setIsTrafficStation(jSONObject8.optInt("is_station"));
                                }
                                if (jSONObject8.has("traffic_skip_prop")) {
                                    setTrafficSkipProb(Float.parseFloat(jSONObject8.optString("traffic_skip_prop")));
                                }
                                if (jSONObject8.has("sema")) {
                                    JSONObject jSONObject10 = jSONObject8.getJSONObject("sema");
                                    if (jSONObject10.has("aptag")) {
                                        String string18 = jSONObject10.getString("aptag");
                                        if (TextUtils.isEmpty(string18)) {
                                            str3 = "";
                                            this.v = str3;
                                        } else {
                                            this.v = string18;
                                            str3 = "";
                                        }
                                    } else {
                                        str3 = "";
                                    }
                                    if (jSONObject10.has("aptagd")) {
                                        JSONArray jSONArray = jSONObject10.getJSONObject("aptagd").getJSONArray("pois");
                                        ArrayList arrayList = new ArrayList();
                                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                            JSONObject jSONObject11 = jSONArray.getJSONObject(i5);
                                            arrayList.add(new Poi(jSONObject11.getString("pid"), jSONObject11.getString("pname"), jSONObject11.getDouble("pr"), jSONObject11.has(PageLog.PAGE_LOG_TAGS) ? jSONObject11.getString(PageLog.PAGE_LOG_TAGS) : str3, jSONObject11.has("addr") ? jSONObject11.getString("addr") : str3));
                                        }
                                        this.S = arrayList;
                                    }
                                    if (jSONObject10.has("poiregion")) {
                                        String string19 = jSONObject10.getString("poiregion");
                                        if (!TextUtils.isEmpty(string19)) {
                                            this.w = string19;
                                        }
                                    }
                                    if (jSONObject10.has("poi_regions")) {
                                        JSONObject jSONObject12 = jSONObject10.getJSONObject("poi_regions");
                                        this.af = new PoiRegion(jSONObject12.has("direction_desc") ? jSONObject12.getString("direction_desc") : str3, jSONObject12.has("name") ? jSONObject12.getString("name") : str3, jSONObject12.has("tag") ? jSONObject12.getString("tag") : str3, jSONObject12.has(UserConstants.URL_PARAMS.b) ? jSONObject12.getString(UserConstants.URL_PARAMS.b) : str3, jSONObject12.has("bid") ? jSONObject12.getString("bid") : str3);
                                    }
                                    if (jSONObject10.has("regular")) {
                                        String string20 = jSONObject10.getString("regular");
                                        if (!TextUtils.isEmpty(string20)) {
                                            this.x = string20;
                                        }
                                    }
                                } else {
                                    str3 = "";
                                }
                                String str17 = ",";
                                if (jSONObject8.has("addr")) {
                                    try {
                                        jSONObject = jSONObject8.getJSONObject("addr");
                                        z3 = true;
                                    } catch (Exception unused3) {
                                        jSONObject = null;
                                        z3 = false;
                                    }
                                    if (jSONObject != null) {
                                        string4 = jSONObject.has("city") ? jSONObject.getString("city") : str3;
                                        string10 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : str3;
                                        string5 = jSONObject.has(ze1.s) ? jSONObject.getString(ze1.s) : str3;
                                        string6 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : str3;
                                        string9 = jSONObject.has("province") ? jSONObject.getString("province") : str3;
                                        string2 = jSONObject.has("district") ? jSONObject.getString("district") : str3;
                                        string = jSONObject.has("street") ? jSONObject.getString("street") : str3;
                                        string3 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : str3;
                                        string8 = jSONObject.has("adcode") ? jSONObject.getString("adcode") : str3;
                                        String string21 = jSONObject.has("town") ? jSONObject.getString("town") : null;
                                        string7 = jSONObject.has("town_code") ? jSONObject.getString("town_code") : str3;
                                        str9 = string21;
                                    } else {
                                        try {
                                            String[] strArrSplit3 = jSONObject8.getString("addr").split(",");
                                            int length = strArrSplit3.length;
                                            if (length > 0) {
                                                str4 = strArrSplit3[0];
                                                i = 1;
                                            } else {
                                                i = 1;
                                                str4 = null;
                                            }
                                            if (length > i) {
                                                try {
                                                    str5 = strArrSplit3[i];
                                                    i2 = 2;
                                                } catch (Exception e) {
                                                    exc2 = e;
                                                    string = null;
                                                    str5 = null;
                                                    string2 = null;
                                                    string3 = null;
                                                    str6 = null;
                                                    str7 = null;
                                                    str8 = null;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str18 = str6;
                                                    string9 = str4;
                                                    string10 = str18;
                                                    if (z3) {
                                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                                        this.s = true;
                                                    }
                                                    if (jSONObject8.has("floor")) {
                                                        string17 = jSONObject8.getString("floor");
                                                        this.A = string17;
                                                        if (TextUtils.isEmpty(string17)) {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoor")) {
                                                        string16 = jSONObject8.getString("indoor");
                                                        if (!TextUtils.isEmpty(string16)) {
                                                            setUserIndoorState(Integer.valueOf(string16).intValue());
                                                        }
                                                    }
                                                    if (jSONObject8.has("loctp")) {
                                                        string15 = jSONObject8.getString("loctp");
                                                        this.H = string15;
                                                        if (TextUtils.isEmpty(string15)) {
                                                            this.H = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldgid")) {
                                                        string14 = jSONObject8.getString("bldgid");
                                                        this.B = string14;
                                                        if (TextUtils.isEmpty(string14)) {
                                                            this.B = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldg")) {
                                                        string13 = jSONObject8.getString("bldg");
                                                        this.C = string13;
                                                        if (TextUtils.isEmpty(string13)) {
                                                            this.C = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("acc")) {
                                                        this.D = jSONObject8.getDouble("acc");
                                                    }
                                                    if (jSONObject8.has("ibav")) {
                                                        string12 = jSONObject8.getString("ibav");
                                                        if (TextUtils.isEmpty(string12)) {
                                                            try {
                                                                this.F = 0;
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                z = false;
                                                                exc = e;
                                                                z2 = z;
                                                                exc.printStackTrace();
                                                                r2 = z2;
                                                                this.f26319a = r2;
                                                                this.s = r2;
                                                            }
                                                        } else {
                                                            this.F = Integer.valueOf(string12).intValue();
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoorflags")) {
                                                        try {
                                                            jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                            if (jSONObject2.has("area")) {
                                                                iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                                if (iIntValue == 0) {
                                                                    setIndoorLocationSurpport(2);
                                                                } else if (iIntValue == 1) {
                                                                    setIndoorLocationSurpport(1);
                                                                }
                                                            }
                                                            if (jSONObject2.has("support")) {
                                                                setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                            }
                                                            if (jSONObject2.has("inbldg")) {
                                                                this.O = jSONObject2.getString("inbldg");
                                                            }
                                                            if (jSONObject2.has("inbldgid")) {
                                                                this.P = jSONObject2.getString("inbldgid");
                                                            }
                                                            if (jSONObject2.has("polygon")) {
                                                                setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                                            }
                                                            if (jSONObject2.has("ret_fields")) {
                                                                try {
                                                                    for (String str19 : jSONObject2.getString("ret_fields").split("\\|")) {
                                                                        strArrSplit = str19.split("=");
                                                                        if (strArrSplit == null) {
                                                                        }
                                                                    }
                                                                } catch (Exception unused4) {
                                                                }
                                                            }
                                                            if (jSONObject2.has("inout_ble")) {
                                                                iOptInt = jSONObject2.optInt("inout_ble");
                                                                setInOutStatus(iOptInt);
                                                                if (iOptInt == 1) {
                                                                    setIsInIndoorPark(true);
                                                                } else {
                                                                    setIsInIndoorPark(false);
                                                                }
                                                            } else {
                                                                setInOutStatus(-1);
                                                            }
                                                        } catch (Exception e3) {
                                                            e3.printStackTrace();
                                                        }
                                                    }
                                                    if (jSONObject8.has("gpscs")) {
                                                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                                    } else {
                                                        z4 = false;
                                                        setGpsCheckStatus(0);
                                                    }
                                                    if (jSONObject8.has("in_cn")) {
                                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                                    } else {
                                                        setLocationWhere(1);
                                                    }
                                                    if (this.G == 0) {
                                                        str11 = "wgs84";
                                                    } else {
                                                        str11 = str2;
                                                    }
                                                    setCoorType(str11);
                                                    if (jSONObject8.has("navi")) {
                                                        this.aa = jSONObject8.getString("navi");
                                                    }
                                                    if (jSONObject8.has("navi_client")) {
                                                        str14 = str17;
                                                        try {
                                                            if (string11.contains(str14)) {
                                                                iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                                Integer.valueOf(strArrSplit2[1]).intValue();
                                                                if (iIntValue2 > 0) {
                                                                    this.ae = true;
                                                                }
                                                            }
                                                        } catch (Throwable th) {
                                                            th.printStackTrace();
                                                        }
                                                    }
                                                    if (jSONObject8.has("nrl_point")) {
                                                        try {
                                                            jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                            str12 = str15;
                                                            if (jSONObject3.has(str12)) {
                                                                str13 = str16;
                                                                if (jSONObject3.has(str13)) {
                                                                    this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                                                    this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                                                }
                                                            }
                                                        } catch (Throwable unused5) {
                                                            this.ac = Double.MIN_VALUE;
                                                            this.ad = Double.MIN_VALUE;
                                                        }
                                                    }
                                                    if (jSONObject8.has("loc_nlp")) {
                                                        setSemanticParams(jSONObject8.getString("loc_nlp"));
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                i2 = 2;
                                                str5 = null;
                                            }
                                            if (length > i2) {
                                                try {
                                                    string2 = strArrSplit3[i2];
                                                } catch (Exception e4) {
                                                    exc2 = e4;
                                                    string = null;
                                                    string2 = null;
                                                    string3 = null;
                                                    str6 = null;
                                                    str7 = null;
                                                    str8 = null;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str110 = str6;
                                                    string9 = str4;
                                                    string10 = str110;
                                                    if (z3) {
                                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                                        this.s = true;
                                                    }
                                                    if (jSONObject8.has("floor")) {
                                                        string17 = jSONObject8.getString("floor");
                                                        this.A = string17;
                                                        if (TextUtils.isEmpty(string17)) {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoor")) {
                                                        string16 = jSONObject8.getString("indoor");
                                                        if (!TextUtils.isEmpty(string16)) {
                                                            setUserIndoorState(Integer.valueOf(string16).intValue());
                                                        }
                                                    }
                                                    if (jSONObject8.has("loctp")) {
                                                        string15 = jSONObject8.getString("loctp");
                                                        this.H = string15;
                                                        if (TextUtils.isEmpty(string15)) {
                                                            this.H = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldgid")) {
                                                        string14 = jSONObject8.getString("bldgid");
                                                        this.B = string14;
                                                        if (TextUtils.isEmpty(string14)) {
                                                            this.B = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldg")) {
                                                        string13 = jSONObject8.getString("bldg");
                                                        this.C = string13;
                                                        if (TextUtils.isEmpty(string13)) {
                                                            this.C = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("acc")) {
                                                        this.D = jSONObject8.getDouble("acc");
                                                    }
                                                    if (jSONObject8.has("ibav")) {
                                                        string12 = jSONObject8.getString("ibav");
                                                        if (TextUtils.isEmpty(string12)) {
                                                            this.F = 0;
                                                        } else {
                                                            this.F = Integer.valueOf(string12).intValue();
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoorflags")) {
                                                        jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                        if (jSONObject2.has("area")) {
                                                            iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                            if (iIntValue == 0) {
                                                                setIndoorLocationSurpport(2);
                                                            } else if (iIntValue == 1) {
                                                                setIndoorLocationSurpport(1);
                                                            }
                                                        }
                                                        if (jSONObject2.has("support")) {
                                                            setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                        }
                                                        if (jSONObject2.has("inbldg")) {
                                                            this.O = jSONObject2.getString("inbldg");
                                                        }
                                                        if (jSONObject2.has("inbldgid")) {
                                                            this.P = jSONObject2.getString("inbldgid");
                                                        }
                                                        if (jSONObject2.has("polygon")) {
                                                            setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                                        }
                                                        if (jSONObject2.has("ret_fields")) {
                                                            while (i3 < r4) {
                                                                strArrSplit = str19.split("=");
                                                                if (strArrSplit == null) {
                                                                }
                                                            }
                                                        }
                                                        if (jSONObject2.has("inout_ble")) {
                                                            iOptInt = jSONObject2.optInt("inout_ble");
                                                            setInOutStatus(iOptInt);
                                                            if (iOptInt == 1) {
                                                                setIsInIndoorPark(true);
                                                            } else {
                                                                setIsInIndoorPark(false);
                                                            }
                                                        } else {
                                                            setInOutStatus(-1);
                                                        }
                                                    }
                                                    if (jSONObject8.has("gpscs")) {
                                                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                                    } else {
                                                        z4 = false;
                                                        setGpsCheckStatus(0);
                                                    }
                                                    if (jSONObject8.has("in_cn")) {
                                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                                    } else {
                                                        setLocationWhere(1);
                                                    }
                                                    if (this.G == 0) {
                                                        str11 = "wgs84";
                                                    } else {
                                                        str11 = str2;
                                                    }
                                                    setCoorType(str11);
                                                    if (jSONObject8.has("navi")) {
                                                        this.aa = jSONObject8.getString("navi");
                                                    }
                                                    if (jSONObject8.has("navi_client")) {
                                                        str14 = str17;
                                                        if (string11.contains(str14)) {
                                                            iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                            Integer.valueOf(strArrSplit2[1]).intValue();
                                                            if (iIntValue2 > 0) {
                                                                this.ae = true;
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("nrl_point")) {
                                                        jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                        str12 = str15;
                                                        if (jSONObject3.has(str12)) {
                                                            str13 = str16;
                                                            if (jSONObject3.has(str13)) {
                                                                this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                                                this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("loc_nlp")) {
                                                        setSemanticParams(jSONObject8.getString("loc_nlp"));
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                string2 = null;
                                            }
                                            if (length > 3) {
                                                try {
                                                    string = strArrSplit3[3];
                                                } catch (Exception e5) {
                                                    exc2 = e5;
                                                    string = null;
                                                    string3 = null;
                                                    str6 = null;
                                                    str7 = null;
                                                    str8 = null;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str111 = str6;
                                                    string9 = str4;
                                                    string10 = str111;
                                                    if (z3) {
                                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                                        this.s = true;
                                                    }
                                                    if (jSONObject8.has("floor")) {
                                                        string17 = jSONObject8.getString("floor");
                                                        this.A = string17;
                                                        if (TextUtils.isEmpty(string17)) {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoor")) {
                                                        string16 = jSONObject8.getString("indoor");
                                                        if (!TextUtils.isEmpty(string16)) {
                                                            setUserIndoorState(Integer.valueOf(string16).intValue());
                                                        }
                                                    }
                                                    if (jSONObject8.has("loctp")) {
                                                        string15 = jSONObject8.getString("loctp");
                                                        this.H = string15;
                                                        if (TextUtils.isEmpty(string15)) {
                                                            this.H = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldgid")) {
                                                        string14 = jSONObject8.getString("bldgid");
                                                        this.B = string14;
                                                        if (TextUtils.isEmpty(string14)) {
                                                            this.B = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldg")) {
                                                        string13 = jSONObject8.getString("bldg");
                                                        this.C = string13;
                                                        if (TextUtils.isEmpty(string13)) {
                                                            this.C = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("acc")) {
                                                        this.D = jSONObject8.getDouble("acc");
                                                    }
                                                    if (jSONObject8.has("ibav")) {
                                                        string12 = jSONObject8.getString("ibav");
                                                        if (TextUtils.isEmpty(string12)) {
                                                            this.F = 0;
                                                        } else {
                                                            this.F = Integer.valueOf(string12).intValue();
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoorflags")) {
                                                        jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                        if (jSONObject2.has("area")) {
                                                            iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                            if (iIntValue == 0) {
                                                                setIndoorLocationSurpport(2);
                                                            } else if (iIntValue == 1) {
                                                                setIndoorLocationSurpport(1);
                                                            }
                                                        }
                                                        if (jSONObject2.has("support")) {
                                                            setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                        }
                                                        if (jSONObject2.has("inbldg")) {
                                                            this.O = jSONObject2.getString("inbldg");
                                                        }
                                                        if (jSONObject2.has("inbldgid")) {
                                                            this.P = jSONObject2.getString("inbldgid");
                                                        }
                                                        if (jSONObject2.has("polygon")) {
                                                            setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                                        }
                                                        if (jSONObject2.has("ret_fields")) {
                                                            while (i3 < r4) {
                                                                strArrSplit = str19.split("=");
                                                                if (strArrSplit == null) {
                                                                }
                                                            }
                                                        }
                                                        if (jSONObject2.has("inout_ble")) {
                                                            iOptInt = jSONObject2.optInt("inout_ble");
                                                            setInOutStatus(iOptInt);
                                                            if (iOptInt == 1) {
                                                                setIsInIndoorPark(true);
                                                            } else {
                                                                setIsInIndoorPark(false);
                                                            }
                                                        } else {
                                                            setInOutStatus(-1);
                                                        }
                                                    }
                                                    if (jSONObject8.has("gpscs")) {
                                                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                                    } else {
                                                        z4 = false;
                                                        setGpsCheckStatus(0);
                                                    }
                                                    if (jSONObject8.has("in_cn")) {
                                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                                    } else {
                                                        setLocationWhere(1);
                                                    }
                                                    if (this.G == 0) {
                                                        str11 = "wgs84";
                                                    } else {
                                                        str11 = str2;
                                                    }
                                                    setCoorType(str11);
                                                    if (jSONObject8.has("navi")) {
                                                        this.aa = jSONObject8.getString("navi");
                                                    }
                                                    if (jSONObject8.has("navi_client")) {
                                                        str14 = str17;
                                                        if (string11.contains(str14)) {
                                                            iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                            Integer.valueOf(strArrSplit2[1]).intValue();
                                                            if (iIntValue2 > 0) {
                                                                this.ae = true;
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("nrl_point")) {
                                                        jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                        str12 = str15;
                                                        if (jSONObject3.has(str12)) {
                                                            str13 = str16;
                                                            if (jSONObject3.has(str13)) {
                                                                this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                                                this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("loc_nlp")) {
                                                        setSemanticParams(jSONObject8.getString("loc_nlp"));
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                string = null;
                                            }
                                            if (length > 4) {
                                                try {
                                                    string3 = strArrSplit3[4];
                                                } catch (Exception e6) {
                                                    exc2 = e6;
                                                    string3 = null;
                                                    str6 = null;
                                                    str7 = null;
                                                    str8 = null;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str112 = str6;
                                                    string9 = str4;
                                                    string10 = str112;
                                                    if (z3) {
                                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                                        this.s = true;
                                                    }
                                                    if (jSONObject8.has("floor")) {
                                                        string17 = jSONObject8.getString("floor");
                                                        this.A = string17;
                                                        if (TextUtils.isEmpty(string17)) {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoor")) {
                                                        string16 = jSONObject8.getString("indoor");
                                                        if (!TextUtils.isEmpty(string16)) {
                                                            setUserIndoorState(Integer.valueOf(string16).intValue());
                                                        }
                                                    }
                                                    if (jSONObject8.has("loctp")) {
                                                        string15 = jSONObject8.getString("loctp");
                                                        this.H = string15;
                                                        if (TextUtils.isEmpty(string15)) {
                                                            this.H = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldgid")) {
                                                        string14 = jSONObject8.getString("bldgid");
                                                        this.B = string14;
                                                        if (TextUtils.isEmpty(string14)) {
                                                            this.B = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldg")) {
                                                        string13 = jSONObject8.getString("bldg");
                                                        this.C = string13;
                                                        if (TextUtils.isEmpty(string13)) {
                                                            this.C = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("acc")) {
                                                        this.D = jSONObject8.getDouble("acc");
                                                    }
                                                    if (jSONObject8.has("ibav")) {
                                                        string12 = jSONObject8.getString("ibav");
                                                        if (TextUtils.isEmpty(string12)) {
                                                            this.F = 0;
                                                        } else {
                                                            this.F = Integer.valueOf(string12).intValue();
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoorflags")) {
                                                        jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                        if (jSONObject2.has("area")) {
                                                            iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                            if (iIntValue == 0) {
                                                                setIndoorLocationSurpport(2);
                                                            } else if (iIntValue == 1) {
                                                                setIndoorLocationSurpport(1);
                                                            }
                                                        }
                                                        if (jSONObject2.has("support")) {
                                                            setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                        }
                                                        if (jSONObject2.has("inbldg")) {
                                                            this.O = jSONObject2.getString("inbldg");
                                                        }
                                                        if (jSONObject2.has("inbldgid")) {
                                                            this.P = jSONObject2.getString("inbldgid");
                                                        }
                                                        if (jSONObject2.has("polygon")) {
                                                            setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                                        }
                                                        if (jSONObject2.has("ret_fields")) {
                                                            while (i3 < r4) {
                                                                strArrSplit = str19.split("=");
                                                                if (strArrSplit == null) {
                                                                }
                                                            }
                                                        }
                                                        if (jSONObject2.has("inout_ble")) {
                                                            iOptInt = jSONObject2.optInt("inout_ble");
                                                            setInOutStatus(iOptInt);
                                                            if (iOptInt == 1) {
                                                                setIsInIndoorPark(true);
                                                            } else {
                                                                setIsInIndoorPark(false);
                                                            }
                                                        } else {
                                                            setInOutStatus(-1);
                                                        }
                                                    }
                                                    if (jSONObject8.has("gpscs")) {
                                                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                                    } else {
                                                        z4 = false;
                                                        setGpsCheckStatus(0);
                                                    }
                                                    if (jSONObject8.has("in_cn")) {
                                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                                    } else {
                                                        setLocationWhere(1);
                                                    }
                                                    if (this.G == 0) {
                                                        str11 = "wgs84";
                                                    } else {
                                                        str11 = str2;
                                                    }
                                                    setCoorType(str11);
                                                    if (jSONObject8.has("navi")) {
                                                        this.aa = jSONObject8.getString("navi");
                                                    }
                                                    if (jSONObject8.has("navi_client")) {
                                                        str14 = str17;
                                                        if (string11.contains(str14)) {
                                                            iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                            Integer.valueOf(strArrSplit2[1]).intValue();
                                                            if (iIntValue2 > 0) {
                                                                this.ae = true;
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("nrl_point")) {
                                                        jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                        str12 = str15;
                                                        if (jSONObject3.has(str12)) {
                                                            str13 = str16;
                                                            if (jSONObject3.has(str13)) {
                                                                this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                                                this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("loc_nlp")) {
                                                        setSemanticParams(jSONObject8.getString("loc_nlp"));
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                string3 = null;
                                            }
                                            if (length > 5) {
                                                try {
                                                    str6 = strArrSplit3[5];
                                                } catch (Exception e7) {
                                                    exc2 = e7;
                                                    str6 = null;
                                                    str7 = null;
                                                    str8 = null;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str113 = str6;
                                                    string9 = str4;
                                                    string10 = str113;
                                                    if (z3) {
                                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                                        this.s = true;
                                                    }
                                                    if (jSONObject8.has("floor")) {
                                                        string17 = jSONObject8.getString("floor");
                                                        this.A = string17;
                                                        if (TextUtils.isEmpty(string17)) {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoor")) {
                                                        string16 = jSONObject8.getString("indoor");
                                                        if (!TextUtils.isEmpty(string16)) {
                                                            setUserIndoorState(Integer.valueOf(string16).intValue());
                                                        }
                                                    }
                                                    if (jSONObject8.has("loctp")) {
                                                        string15 = jSONObject8.getString("loctp");
                                                        this.H = string15;
                                                        if (TextUtils.isEmpty(string15)) {
                                                            this.H = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldgid")) {
                                                        string14 = jSONObject8.getString("bldgid");
                                                        this.B = string14;
                                                        if (TextUtils.isEmpty(string14)) {
                                                            this.B = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldg")) {
                                                        string13 = jSONObject8.getString("bldg");
                                                        this.C = string13;
                                                        if (TextUtils.isEmpty(string13)) {
                                                            this.C = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("acc")) {
                                                        this.D = jSONObject8.getDouble("acc");
                                                    }
                                                    if (jSONObject8.has("ibav")) {
                                                        string12 = jSONObject8.getString("ibav");
                                                        if (TextUtils.isEmpty(string12)) {
                                                            this.F = 0;
                                                        } else {
                                                            this.F = Integer.valueOf(string12).intValue();
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoorflags")) {
                                                        jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                        if (jSONObject2.has("area")) {
                                                            iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                            if (iIntValue == 0) {
                                                                setIndoorLocationSurpport(2);
                                                            } else if (iIntValue == 1) {
                                                                setIndoorLocationSurpport(1);
                                                            }
                                                        }
                                                        if (jSONObject2.has("support")) {
                                                            setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                        }
                                                        if (jSONObject2.has("inbldg")) {
                                                            this.O = jSONObject2.getString("inbldg");
                                                        }
                                                        if (jSONObject2.has("inbldgid")) {
                                                            this.P = jSONObject2.getString("inbldgid");
                                                        }
                                                        if (jSONObject2.has("polygon")) {
                                                            setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                                        }
                                                        if (jSONObject2.has("ret_fields")) {
                                                            while (i3 < r4) {
                                                                strArrSplit = str19.split("=");
                                                                if (strArrSplit == null) {
                                                                }
                                                            }
                                                        }
                                                        if (jSONObject2.has("inout_ble")) {
                                                            iOptInt = jSONObject2.optInt("inout_ble");
                                                            setInOutStatus(iOptInt);
                                                            if (iOptInt == 1) {
                                                                setIsInIndoorPark(true);
                                                            } else {
                                                                setIsInIndoorPark(false);
                                                            }
                                                        } else {
                                                            setInOutStatus(-1);
                                                        }
                                                    }
                                                    if (jSONObject8.has("gpscs")) {
                                                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                                    } else {
                                                        z4 = false;
                                                        setGpsCheckStatus(0);
                                                    }
                                                    if (jSONObject8.has("in_cn")) {
                                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                                    } else {
                                                        setLocationWhere(1);
                                                    }
                                                    if (this.G == 0) {
                                                        str11 = "wgs84";
                                                    } else {
                                                        str11 = str2;
                                                    }
                                                    setCoorType(str11);
                                                    if (jSONObject8.has("navi")) {
                                                        this.aa = jSONObject8.getString("navi");
                                                    }
                                                    if (jSONObject8.has("navi_client")) {
                                                        str14 = str17;
                                                        if (string11.contains(str14)) {
                                                            iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                            Integer.valueOf(strArrSplit2[1]).intValue();
                                                            if (iIntValue2 > 0) {
                                                                this.ae = true;
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("nrl_point")) {
                                                        jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                        str12 = str15;
                                                        if (jSONObject3.has(str12)) {
                                                            str13 = str16;
                                                            if (jSONObject3.has(str13)) {
                                                                this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                                                this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("loc_nlp")) {
                                                        setSemanticParams(jSONObject8.getString("loc_nlp"));
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                str6 = null;
                                            }
                                            if (length > 6) {
                                                try {
                                                    str7 = strArrSplit3[6];
                                                } catch (Exception e8) {
                                                    string = string;
                                                    exc2 = e8;
                                                    str7 = null;
                                                    str8 = null;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str114 = str6;
                                                    string9 = str4;
                                                    string10 = str114;
                                                    if (z3) {
                                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                                        this.s = true;
                                                    }
                                                    if (jSONObject8.has("floor")) {
                                                        string17 = jSONObject8.getString("floor");
                                                        this.A = string17;
                                                        if (TextUtils.isEmpty(string17)) {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoor")) {
                                                        string16 = jSONObject8.getString("indoor");
                                                        if (!TextUtils.isEmpty(string16)) {
                                                            setUserIndoorState(Integer.valueOf(string16).intValue());
                                                        }
                                                    }
                                                    if (jSONObject8.has("loctp")) {
                                                        string15 = jSONObject8.getString("loctp");
                                                        this.H = string15;
                                                        if (TextUtils.isEmpty(string15)) {
                                                            this.H = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldgid")) {
                                                        string14 = jSONObject8.getString("bldgid");
                                                        this.B = string14;
                                                        if (TextUtils.isEmpty(string14)) {
                                                            this.B = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldg")) {
                                                        string13 = jSONObject8.getString("bldg");
                                                        this.C = string13;
                                                        if (TextUtils.isEmpty(string13)) {
                                                            this.C = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("acc")) {
                                                        this.D = jSONObject8.getDouble("acc");
                                                    }
                                                    if (jSONObject8.has("ibav")) {
                                                        string12 = jSONObject8.getString("ibav");
                                                        if (TextUtils.isEmpty(string12)) {
                                                            this.F = 0;
                                                        } else {
                                                            this.F = Integer.valueOf(string12).intValue();
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoorflags")) {
                                                        jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                        if (jSONObject2.has("area")) {
                                                            iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                            if (iIntValue == 0) {
                                                                setIndoorLocationSurpport(2);
                                                            } else if (iIntValue == 1) {
                                                                setIndoorLocationSurpport(1);
                                                            }
                                                        }
                                                        if (jSONObject2.has("support")) {
                                                            setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                        }
                                                        if (jSONObject2.has("inbldg")) {
                                                            this.O = jSONObject2.getString("inbldg");
                                                        }
                                                        if (jSONObject2.has("inbldgid")) {
                                                            this.P = jSONObject2.getString("inbldgid");
                                                        }
                                                        if (jSONObject2.has("polygon")) {
                                                            setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                                        }
                                                        if (jSONObject2.has("ret_fields")) {
                                                            while (i3 < r4) {
                                                                strArrSplit = str19.split("=");
                                                                if (strArrSplit == null) {
                                                                }
                                                            }
                                                        }
                                                        if (jSONObject2.has("inout_ble")) {
                                                            iOptInt = jSONObject2.optInt("inout_ble");
                                                            setInOutStatus(iOptInt);
                                                            if (iOptInt == 1) {
                                                                setIsInIndoorPark(true);
                                                            } else {
                                                                setIsInIndoorPark(false);
                                                            }
                                                        } else {
                                                            setInOutStatus(-1);
                                                        }
                                                    }
                                                    if (jSONObject8.has("gpscs")) {
                                                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                                    } else {
                                                        z4 = false;
                                                        setGpsCheckStatus(0);
                                                    }
                                                    if (jSONObject8.has("in_cn")) {
                                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                                    } else {
                                                        setLocationWhere(1);
                                                    }
                                                    if (this.G == 0) {
                                                        str11 = "wgs84";
                                                    } else {
                                                        str11 = str2;
                                                    }
                                                    setCoorType(str11);
                                                    if (jSONObject8.has("navi")) {
                                                        this.aa = jSONObject8.getString("navi");
                                                    }
                                                    if (jSONObject8.has("navi_client")) {
                                                        str14 = str17;
                                                        if (string11.contains(str14)) {
                                                            iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                            Integer.valueOf(strArrSplit2[1]).intValue();
                                                            if (iIntValue2 > 0) {
                                                                this.ae = true;
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("nrl_point")) {
                                                        jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                        str12 = str15;
                                                        if (jSONObject3.has(str12)) {
                                                            str13 = str16;
                                                            if (jSONObject3.has(str13)) {
                                                                this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                                                this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("loc_nlp")) {
                                                        setSemanticParams(jSONObject8.getString("loc_nlp"));
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                str7 = null;
                                            }
                                            if (length > 7) {
                                                try {
                                                    str8 = strArrSplit3[7];
                                                } catch (Exception e9) {
                                                    string = string;
                                                    exc2 = e9;
                                                    str8 = null;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str115 = str6;
                                                    string9 = str4;
                                                    string10 = str115;
                                                    if (z3) {
                                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                                        this.s = true;
                                                    }
                                                    if (jSONObject8.has("floor")) {
                                                        string17 = jSONObject8.getString("floor");
                                                        this.A = string17;
                                                        if (TextUtils.isEmpty(string17)) {
                                                            this.A = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoor")) {
                                                        string16 = jSONObject8.getString("indoor");
                                                        if (!TextUtils.isEmpty(string16)) {
                                                            setUserIndoorState(Integer.valueOf(string16).intValue());
                                                        }
                                                    }
                                                    if (jSONObject8.has("loctp")) {
                                                        string15 = jSONObject8.getString("loctp");
                                                        this.H = string15;
                                                        if (TextUtils.isEmpty(string15)) {
                                                            this.H = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldgid")) {
                                                        string14 = jSONObject8.getString("bldgid");
                                                        this.B = string14;
                                                        if (TextUtils.isEmpty(string14)) {
                                                            this.B = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("bldg")) {
                                                        string13 = jSONObject8.getString("bldg");
                                                        this.C = string13;
                                                        if (TextUtils.isEmpty(string13)) {
                                                            this.C = null;
                                                        }
                                                    }
                                                    if (jSONObject8.has("acc")) {
                                                        this.D = jSONObject8.getDouble("acc");
                                                    }
                                                    if (jSONObject8.has("ibav")) {
                                                        string12 = jSONObject8.getString("ibav");
                                                        if (TextUtils.isEmpty(string12)) {
                                                            this.F = 0;
                                                        } else {
                                                            this.F = Integer.valueOf(string12).intValue();
                                                        }
                                                    }
                                                    if (jSONObject8.has("indoorflags")) {
                                                        jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                        if (jSONObject2.has("area")) {
                                                            iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                            if (iIntValue == 0) {
                                                                setIndoorLocationSurpport(2);
                                                            } else if (iIntValue == 1) {
                                                                setIndoorLocationSurpport(1);
                                                            }
                                                        }
                                                        if (jSONObject2.has("support")) {
                                                            setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                        }
                                                        if (jSONObject2.has("inbldg")) {
                                                            this.O = jSONObject2.getString("inbldg");
                                                        }
                                                        if (jSONObject2.has("inbldgid")) {
                                                            this.P = jSONObject2.getString("inbldgid");
                                                        }
                                                        if (jSONObject2.has("polygon")) {
                                                            setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                                        }
                                                        if (jSONObject2.has("ret_fields")) {
                                                            while (i3 < r4) {
                                                                strArrSplit = str19.split("=");
                                                                if (strArrSplit == null) {
                                                                }
                                                            }
                                                        }
                                                        if (jSONObject2.has("inout_ble")) {
                                                            iOptInt = jSONObject2.optInt("inout_ble");
                                                            setInOutStatus(iOptInt);
                                                            if (iOptInt == 1) {
                                                                setIsInIndoorPark(true);
                                                            } else {
                                                                setIsInIndoorPark(false);
                                                            }
                                                        } else {
                                                            setInOutStatus(-1);
                                                        }
                                                    }
                                                    if (jSONObject8.has("gpscs")) {
                                                        setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                                    } else {
                                                        z4 = false;
                                                        setGpsCheckStatus(0);
                                                    }
                                                    if (jSONObject8.has("in_cn")) {
                                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                                    } else {
                                                        setLocationWhere(1);
                                                    }
                                                    if (this.G == 0) {
                                                        str11 = "wgs84";
                                                    } else {
                                                        str11 = str2;
                                                    }
                                                    setCoorType(str11);
                                                    if (jSONObject8.has("navi")) {
                                                        this.aa = jSONObject8.getString("navi");
                                                    }
                                                    if (jSONObject8.has("navi_client")) {
                                                        str14 = str17;
                                                        if (string11.contains(str14)) {
                                                            iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                            Integer.valueOf(strArrSplit2[1]).intValue();
                                                            if (iIntValue2 > 0) {
                                                                this.ae = true;
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("nrl_point")) {
                                                        jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                        str12 = str15;
                                                        if (jSONObject3.has(str12)) {
                                                            str13 = str16;
                                                            if (jSONObject3.has(str13)) {
                                                                this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                                                this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                                            }
                                                        }
                                                    }
                                                    if (jSONObject8.has("loc_nlp")) {
                                                        setSemanticParams(jSONObject8.getString("loc_nlp"));
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                str8 = null;
                                            }
                                            if (length > 8) {
                                                try {
                                                    str10 = strArrSplit3[8];
                                                } catch (Exception e10) {
                                                    string = string;
                                                    exc2 = e10;
                                                    exc2.printStackTrace();
                                                    string4 = str5;
                                                    str16 = "y";
                                                    string5 = str7;
                                                    string6 = str8;
                                                    str9 = null;
                                                    string7 = null;
                                                    z3 = false;
                                                    str15 = "x";
                                                    string8 = null;
                                                    String str116 = str6;
                                                    string9 = str4;
                                                    string10 = str116;
                                                }
                                            } else {
                                                str10 = null;
                                            }
                                            string = string;
                                            string4 = str5;
                                            str16 = "y";
                                            string5 = str7;
                                            str9 = null;
                                            string7 = null;
                                            z3 = true;
                                            string8 = str10;
                                            string6 = str8;
                                            str15 = "x";
                                            String str20 = str6;
                                            string9 = str4;
                                            string10 = str20;
                                        } catch (Exception e11) {
                                            exc2 = e11;
                                            string = null;
                                            str4 = null;
                                        }
                                    }
                                    if (z3) {
                                        this.z = new Address.Builder().country(string5).countryCode(string6).province(string9).city(string4).cityCode(string10).district(string2).street(string).streetNumber(string3).adcode(string8).town(str9).townCode(string7).build();
                                        this.s = true;
                                    }
                                } else {
                                    str17 = ",";
                                    str15 = "x";
                                    str16 = "y";
                                    z4 = false;
                                    try {
                                        this.s = false;
                                        setAddrStr(null);
                                    } catch (Exception e12) {
                                        e = e12;
                                        z = z4;
                                        exc = e;
                                        z2 = z;
                                        exc.printStackTrace();
                                        r2 = z2;
                                        this.f26319a = r2;
                                        this.s = r2;
                                    }
                                }
                                if (jSONObject8.has("floor")) {
                                    string17 = jSONObject8.getString("floor");
                                    this.A = string17;
                                    if (TextUtils.isEmpty(string17)) {
                                        this.A = null;
                                    }
                                }
                                if (jSONObject8.has("indoor")) {
                                    string16 = jSONObject8.getString("indoor");
                                    if (!TextUtils.isEmpty(string16)) {
                                        setUserIndoorState(Integer.valueOf(string16).intValue());
                                    }
                                }
                                if (jSONObject8.has("loctp")) {
                                    string15 = jSONObject8.getString("loctp");
                                    this.H = string15;
                                    if (TextUtils.isEmpty(string15)) {
                                        this.H = null;
                                    }
                                }
                                if (jSONObject8.has("bldgid")) {
                                    string14 = jSONObject8.getString("bldgid");
                                    this.B = string14;
                                    if (TextUtils.isEmpty(string14)) {
                                        this.B = null;
                                    }
                                }
                                if (jSONObject8.has("bldg")) {
                                    string13 = jSONObject8.getString("bldg");
                                    this.C = string13;
                                    if (TextUtils.isEmpty(string13)) {
                                        this.C = null;
                                    }
                                }
                                if (jSONObject8.has("acc")) {
                                    this.D = jSONObject8.getDouble("acc");
                                }
                                if (jSONObject8.has("ibav")) {
                                    string12 = jSONObject8.getString("ibav");
                                    if (TextUtils.isEmpty(string12) && !string12.equals("0")) {
                                        this.F = Integer.valueOf(string12).intValue();
                                    } else {
                                        this.F = 0;
                                    }
                                }
                                if (jSONObject8.has("indoorflags")) {
                                    jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                    if (jSONObject2.has("area")) {
                                        iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                        if (iIntValue == 0) {
                                            setIndoorLocationSurpport(2);
                                        } else if (iIntValue == 1) {
                                            setIndoorLocationSurpport(1);
                                        }
                                    }
                                    if (jSONObject2.has("support")) {
                                        setIndoorLocationSource(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                    }
                                    if (jSONObject2.has("inbldg")) {
                                        this.O = jSONObject2.getString("inbldg");
                                    }
                                    if (jSONObject2.has("inbldgid")) {
                                        this.P = jSONObject2.getString("inbldgid");
                                    }
                                    if (jSONObject2.has("polygon")) {
                                        setIndoorSurpportPolygon(jSONObject2.getString("polygon"));
                                    }
                                    if (jSONObject2.has("ret_fields")) {
                                        while (i3 < r4) {
                                            strArrSplit = str19.split("=");
                                            if (strArrSplit == null && strArrSplit.length >= 2) {
                                                this.W.putString(strArrSplit[0], strArrSplit[1]);
                                            }
                                        }
                                    }
                                    if (jSONObject2.has("inout_ble")) {
                                        iOptInt = jSONObject2.optInt("inout_ble");
                                        setInOutStatus(iOptInt);
                                        if (iOptInt == 1) {
                                            setIsInIndoorPark(true);
                                        } else {
                                            setIsInIndoorPark(false);
                                        }
                                    } else {
                                        setInOutStatus(-1);
                                    }
                                }
                                if (jSONObject8.has("gpscs")) {
                                    setGpsCheckStatus(jSONObject8.getInt("gpscs"));
                                } else {
                                    z4 = false;
                                    setGpsCheckStatus(0);
                                }
                                try {
                                    if (jSONObject8.has("in_cn")) {
                                        setLocationWhere(Integer.parseInt(jSONObject8.getString("in_cn")));
                                    } else {
                                        setLocationWhere(1);
                                    }
                                } catch (Exception unused6) {
                                }
                                if (this.G == 0) {
                                    str11 = "wgs84";
                                } else {
                                    str11 = str2;
                                }
                                setCoorType(str11);
                                if (jSONObject8.has("navi")) {
                                    this.aa = jSONObject8.getString("navi");
                                }
                                if (jSONObject8.has("navi_client") && (string11 = jSONObject8.getString("navi_client")) != null) {
                                    str14 = str17;
                                    if (string11.contains(str14) && (strArrSplit2 = string11.split(str14)) != null && strArrSplit2.length >= 2) {
                                        iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                        Integer.valueOf(strArrSplit2[1]).intValue();
                                        if (iIntValue2 > 0) {
                                            this.ae = true;
                                        }
                                    }
                                }
                                if (jSONObject8.has("nrl_point")) {
                                    jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                    str12 = str15;
                                    if (jSONObject3.has(str12)) {
                                        str13 = str16;
                                        if (jSONObject3.has(str13)) {
                                            this.ac = Double.parseDouble(jSONObject3.getString(str13));
                                            this.ad = Double.parseDouble(jSONObject3.getString(str12));
                                        }
                                    }
                                }
                                if (jSONObject8.has("loc_nlp")) {
                                    setSemanticParams(jSONObject8.getString("loc_nlp"));
                                    return;
                                }
                                return;
                            }
                            if (i4 != 66 && i4 != 68) {
                                if (i4 == 167) {
                                    setLocationWhere(2);
                                    return;
                                }
                                return;
                            }
                            JSONObject jSONObject13 = jSONObject4.getJSONObject("content");
                            JSONObject jSONObject14 = jSONObject13.getJSONObject(SQLiteMTAHelper.TABLE_POINT);
                            setLatitude(Double.parseDouble(jSONObject14.getString("y")));
                            setLongitude(Double.parseDouble(jSONObject14.getString("x")));
                            setRadius(Float.parseFloat(jSONObject13.getString("radius")));
                            a(Boolean.valueOf(Boolean.parseBoolean(jSONObject13.getString("isCellChanged"))));
                        }
                        setCoorType(str2);
                    } catch (Exception e13) {
                        exc = e13;
                        z2 = false;
                        exc.printStackTrace();
                        r2 = z2;
                        this.f26319a = r2;
                        this.s = r2;
                    }
                } catch (Exception e14) {
                    exc = e14;
                    z2 = false;
                }
            } catch (Exception e15) {
                e = e15;
                z = false;
            }
        } catch (Error e16) {
            e16.printStackTrace();
            r2 = 0;
            this.f26319a = r2;
            this.s = r2;
        }
    }

    private void a(Boolean bool) {
        this.y = bool.booleanValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAcc() {
        return this.D;
    }

    public String getAdCode() {
        return this.z.adcode;
    }

    public String getAddrStr() {
        return this.z.address;
    }

    public Address getAddress() {
        return this.z;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getBuildingID() {
        return this.B;
    }

    public String getBuildingName() {
        return this.C;
    }

    public String getCity() {
        return this.z.city;
    }

    public String getCityCode() {
        return this.z.cityCode;
    }

    public String getCoorType() {
        return this.r;
    }

    public String getCountry() {
        return this.z.country;
    }

    public String getCountryCode() {
        return this.z.countryCode;
    }

    public long getDelayTime() {
        return this.Z;
    }

    @Deprecated
    public float getDerect() {
        return this.q;
    }

    public float getDirection() {
        return this.q;
    }

    public double getDisToRealLocation() {
        return this.ah;
    }

    public String getDistrict() {
        return this.z.district;
    }

    public Bundle getExtraInfo() {
        return this.al;
    }

    public Location getExtraLocation(String str) {
        Bundle bundle = this.W;
        if (bundle == null) {
            return null;
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (parcelable instanceof Location) {
            return (Location) parcelable;
        }
        return null;
    }

    public String getFloor() {
        return this.A;
    }

    public double[] getFusionLocInfo(String str) {
        return this.W.getDoubleArray(str);
    }

    public int getGnssAccuracyStatus() {
        return this.X;
    }

    public float getGnssBiasProb() {
        return this.ag;
    }

    public int getGnssCheckStatus() {
        return this.Y;
    }

    public String getGnssProvider() {
        return this.am;
    }

    @Deprecated
    public int getGpsAccuracyStatus() {
        return this.X;
    }

    @Deprecated
    public float getGpsBiasProb() {
        return this.ag;
    }

    @Deprecated
    public int getGpsCheckStatus() {
        return this.Y;
    }

    public int getInOutStatus() {
        return this.R;
    }

    public int getIndoorLocationSource() {
        return this.N;
    }

    public int getIndoorLocationSurpport() {
        return this.L;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.P;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.O;
    }

    public int getIndoorNetworkState() {
        return this.M;
    }

    public String getIndoorSurpportPolygon() {
        return this.Q;
    }

    public double getLatitude() {
        return this.c;
    }

    public int getLocType() {
        return this.f26319a;
    }

    public String getLocTypeDescription() {
        return this.T;
    }

    public String getLocationDescribe() {
        return this.v;
    }

    public String getLocationID() {
        return this.U;
    }

    public int getLocationWhere() {
        return this.G;
    }

    public double getLongitude() {
        return this.d;
    }

    public int getMockGnssProbability() {
        return this.aj;
    }

    public int getMockGnssStrategy() {
        return this.ai;
    }

    @Deprecated
    public int getMockGpsProbability() {
        return this.aj;
    }

    @Deprecated
    public int getMockGpsStrategy() {
        return this.ai;
    }

    public String getNetworkLocationType() {
        return this.H;
    }

    public double getNrlLat() {
        return this.ac;
    }

    public double getNrlLon() {
        return this.ad;
    }

    public String getNrlResult() {
        return this.aa;
    }

    @Deprecated
    public int getOperators() {
        return this.I;
    }

    public List<Poi> getPoiList() {
        return this.S;
    }

    public PoiRegion getPoiRegion() {
        return this.af;
    }

    public String getProvince() {
        return this.z.province;
    }

    public float getRadius() {
        return this.j;
    }

    public BDLocation getReallLocation() {
        if (getMockGpsStrategy() > 0) {
            return this.ak;
        }
        return null;
    }

    public String getRetFields(String str) {
        return this.W.getString(str);
    }

    public String getRoadLocString() {
        return this.V;
    }

    public int getSatelliteNumber() {
        this.o = true;
        return this.p;
    }

    @Deprecated
    public String getSemaAptag() {
        return this.v;
    }

    public String getSemanticParams() {
        return this.u;
    }

    public float getSpeed() {
        return this.h;
    }

    public String getStreet() {
        return this.z.street;
    }

    public String getStreetNumber() {
        return this.z.streetNumber;
    }

    public String getTime() {
        return this.b;
    }

    public long getTimeStamp() {
        return this.an;
    }

    public String getTown() {
        return this.z.town;
    }

    public String getTownCode() {
        return this.z.townCode;
    }

    public String getTraffic() {
        return this.k;
    }

    public float getTrafficConfidence() {
        return this.l;
    }

    public float getTrafficSkipProb() {
        return this.n;
    }

    public int getUserIndoorState() {
        return this.K;
    }

    public String getVdrJsonString() {
        Bundle bundle = this.W;
        if (bundle == null || !bundle.containsKey("vdr")) {
            return null;
        }
        return this.W.getString("vdr");
    }

    public String getViaductResult() {
        return this.ab;
    }

    public boolean hasAddr() {
        return this.s;
    }

    public boolean hasAltitude() {
        return this.e;
    }

    public boolean hasRadius() {
        return this.i;
    }

    public boolean hasSateNumber() {
        return this.o;
    }

    public boolean hasSpeed() {
        return this.g;
    }

    public boolean isCellChangeFlag() {
        return this.y;
    }

    public boolean isInIndoorPark() {
        return this.ae;
    }

    public boolean isIndoorLocMode() {
        return this.E;
    }

    public boolean isNrlAvailable() {
        return (this.ad == Double.MIN_VALUE || this.ac == Double.MIN_VALUE) ? false : true;
    }

    public int isParkAvailable() {
        return this.F;
    }

    public int isTrafficStation() {
        return this.m;
    }

    public void setAcc(double d) {
        this.D = d;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.z = address;
            this.s = true;
        }
    }

    public void setAddrStr(String str) {
        this.t = str;
        this.s = str != null;
    }

    public void setAltitude(double d) {
        if (d < 9999.0d) {
            this.f = d;
            this.e = true;
        }
    }

    public void setBuildingID(String str) {
        this.B = str;
    }

    public void setBuildingName(String str) {
        this.C = str;
    }

    public void setCoorType(String str) {
        this.r = str;
    }

    public void setDelayTime(long j) {
        this.Z = j;
    }

    public void setDirection(float f) {
        this.q = f;
    }

    public void setDisToRealLocation(double d) {
        this.ah = d;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.W == null) {
            this.W = new Bundle();
        }
        this.W.putParcelable(str, location);
    }

    public void setExtrainfo(Bundle bundle) {
        this.al = bundle == null ? null : new Bundle(bundle);
    }

    public void setFloor(String str) {
        this.A = str;
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        if (this.W == null) {
            this.W = new Bundle();
        }
        this.W.putDoubleArray(str, dArr);
    }

    public void setGnssAccuracyStatus(int i) {
        this.X = i;
    }

    public void setGnssBiasProb(float f) {
        this.ag = f;
    }

    public void setGnssCheckStatus(int i) {
        this.Y = i;
    }

    public void setGnssProvider(String str) {
        this.am = str;
    }

    @Deprecated
    public void setGpsAccuracyStatus(int i) {
        this.X = i;
    }

    @Deprecated
    public void setGpsBiasProb(float f) {
        this.ag = f;
    }

    @Deprecated
    public void setGpsCheckStatus(int i) {
        this.Y = i;
    }

    public void setInOutStatus(int i) {
        this.R = i;
    }

    public void setIndoorLocMode(boolean z) {
        this.E = z;
    }

    public void setIndoorLocationSource(int i) {
        this.N = i;
    }

    public void setIndoorLocationSurpport(int i) {
        this.L = i;
    }

    public void setIndoorNetworkState(int i) {
        this.M = i;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.Q = str;
    }

    public void setIsInIndoorPark(boolean z) {
        this.ae = z;
    }

    public void setIsTrafficStation(int i) {
        this.m = i;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    public void setLocType(int i) {
        String str;
        this.f26319a = i;
        if (i == 66) {
            str = "Offline location successful!";
        } else if (i == 67) {
            str = "Offline location failed, please check the net (wifi/cell)!";
        } else if (i == 167) {
            str = "NetWork location failed because baidu location service can not caculate the location!";
        } else if (i != 505) {
            switch (i) {
                case 61:
                    setLocTypeDescription("GPS location successful!");
                    setUserIndoorState(0);
                    setGnssProvider(BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM);
                    return;
                case 62:
                    str = "Location failed beacuse we can not get any loc information!";
                    break;
                case 63:
                    str = "Offline location failed, please check the net (wifi/cell)!";
                    break;
                default:
                    switch (i) {
                        case 69:
                            str = "Location failed because the location service switch is not on";
                            break;
                        case 70:
                            str = "Location failed because the location permission is not enabled";
                            break;
                        case 71:
                            str = "Location failed because the location service switch is not on and the location permission is not enabled";
                            break;
                        default:
                            switch (i) {
                                case 160:
                                    str = "Coarse location successful";
                                    break;
                                case 161:
                                    str = "NetWork location successful!";
                                    break;
                                case 162:
                                    str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                                    break;
                                default:
                                    str = "UnKnown!";
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
        }
        setLocTypeDescription(str);
    }

    public void setLocTypeDescription(String str) {
        this.T = str;
    }

    public void setLocationDescribe(String str) {
        this.v = str;
    }

    public void setLocationID(String str) {
        this.U = str;
    }

    public void setLocationWhere(int i) {
        this.G = i;
    }

    public void setLongitude(double d) {
        this.d = d;
    }

    public void setMockGnssProbability(int i) {
        this.aj = i;
    }

    public void setMockGnssStrategy(int i) {
        this.ai = i;
    }

    @Deprecated
    public void setMockGpsProbability(int i) {
        this.aj = i;
    }

    @Deprecated
    public void setMockGpsStrategy(int i) {
        this.ai = i;
    }

    public void setNetworkLocationType(String str) {
        this.H = str;
    }

    public void setNrlData(String str) {
        this.aa = str;
    }

    public void setOperators(int i) {
        this.I = i;
    }

    public void setParkAvailable(int i) {
        this.F = i;
    }

    public void setPoiList(List<Poi> list) {
        this.S = list;
    }

    public void setPoiRegion(PoiRegion poiRegion) {
        this.af = poiRegion;
    }

    public void setRadius(float f) {
        this.j = f;
        this.i = true;
    }

    public void setReallLocation(BDLocation bDLocation) {
        if (getMockGpsStrategy() > 0) {
            this.ak = bDLocation;
        }
    }

    public void setRetFields(String str, String str2) {
        if (this.W == null) {
            this.W = new Bundle();
        }
        this.W.putString(str, str2);
    }

    public void setRoadLocString(float f, float f2, String str, String str2) {
        String str3;
        String str4 = ((double) f) > 0.001d ? String.format("%.2f", Float.valueOf(f)) : "";
        String str5 = ((double) f2) > 0.001d ? String.format("%.2f", Float.valueOf(f2)) : "";
        String str6 = this.aa;
        if (str6 != null) {
            Locale locale = Locale.US;
            str3 = String.format(locale, "%s|%s,%s", str6, str4, str5);
            String str7 = this.ab;
            if (str7 != null) {
                str3 = String.format(locale, "%s|%s", str3, str7);
            }
        } else {
            str3 = null;
        }
        if (str == null) {
            str = str3;
        } else if (str3 != null) {
            str = String.format(Locale.US, "%s|%s", str3, str);
        }
        if (str2 == null) {
            str2 = str;
        } else if (str != null) {
            str2 = String.format(Locale.US, "%s|%s", str, str2);
        }
        this.V = str2;
    }

    public void setSatelliteNumber(int i) {
        this.p = i;
    }

    public void setSemanticParams(String str) {
        this.u = str;
    }

    public void setSpeed(float f) {
        this.h = f;
        this.g = true;
    }

    public void setTime(String str) {
        this.b = str;
        setLocationID(h.a(str));
    }

    public void setTimeStamp(long j) {
        this.an = j;
    }

    public void setTraffic(String str) {
        this.k = str;
    }

    public void setTrafficConfidence(float f) {
        this.l = f;
    }

    public void setTrafficSkipProb(float f) {
        this.n = f;
    }

    public void setUserIndoorState(int i) {
        this.K = i;
    }

    public void setVdrJsonValue(String str) {
        try {
            if (this.W == null) {
                this.W = new Bundle();
            }
            this.W.putString("vdr", str);
        } catch (Exception unused) {
        }
    }

    public void setViaductData(String str) {
        this.ab = str;
    }

    public String toString() {
        return "&loctype=" + getLocType() + "&lat=" + getLatitude() + "&lon=" + getLongitude() + "&radius=" + getRadius() + "&biasprob=" + getGpsBiasProb() + "&altitude=" + getAltitude() + "&speed=" + getSpeed() + "&time=" + getTimeStamp() + "&extrainfo=" + getExtraInfo();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f26319a);
        parcel.writeString(this.b);
        parcel.writeLong(this.an);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.f);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.j);
        parcel.writeString(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p);
        parcel.writeFloat(this.q);
        parcel.writeString(this.A);
        parcel.writeInt(this.F);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeDouble(this.D);
        parcel.writeString(this.H);
        parcel.writeString(this.z.province);
        parcel.writeString(this.z.city);
        parcel.writeString(this.z.district);
        parcel.writeString(this.z.street);
        parcel.writeString(this.z.streetNumber);
        parcel.writeString(this.z.cityCode);
        parcel.writeString(this.z.address);
        parcel.writeString(this.z.country);
        parcel.writeString(this.z.countryCode);
        parcel.writeString(this.z.adcode);
        parcel.writeString(this.z.town);
        parcel.writeString(this.z.townCode);
        parcel.writeInt(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeInt(this.G);
        parcel.writeString(this.T);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.X);
        parcel.writeString(this.U);
        parcel.writeInt(this.Y);
        parcel.writeString(this.V);
        parcel.writeString(this.aa);
        parcel.writeString(this.ab);
        parcel.writeLong(this.Z);
        parcel.writeDouble(this.ac);
        parcel.writeDouble(this.ad);
        parcel.writeFloat(this.ag);
        parcel.writeDouble(this.ah);
        parcel.writeInt(this.ai);
        parcel.writeInt(this.aj);
        parcel.writeString(this.r);
        parcel.writeString(this.am);
        parcel.writeString(this.u);
        parcel.writeParcelable(this.ak, i);
        parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.o, this.s, this.y, this.E, this.ae});
        parcel.writeList(this.S);
        parcel.writeBundle(this.W);
        parcel.writeBundle(this.al);
        parcel.writeParcelable(this.af, i);
    }
}
