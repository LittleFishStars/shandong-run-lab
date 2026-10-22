package com.beizi.fusion.asnp.common.analyse2.base.model.init;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alipay.mobile.jsengine.BuildConfig;
import com.aliyun.credentials.utils.AuthConstant;
import com.beizi.fusion.asnp.common.analyse2.base.model.Analyse2JsonLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdCommon;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdEventLog;
import com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseSimpleLog;
import com.beizi.fusion.asnp.common.v2.crash.ScopeCrashLog;
import com.beizi.fusion.ig;
import com.beizi.fusion.j2;
import com.beizi.fusion.kg;
import com.beizi.fusion.nn;
import com.beizi.fusion.q8;
import com.beizi.fusion.xk;
import com.beizi.fusion.y6;
import com.beizi.fusion.yb;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.dv9;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseInitConfigModel extends AnalyseBasicReceiveLog {

    @kg(key = AuthConstant.ACCESS_KEY)
    private final String accessKey;

    @kg(key = "config_version_md5")
    private String configVersionMd5;

    @kg(key = "lastUpdateTime")
    private String lastUpdateTime;

    @kg(key = "log_version")
    private final String logVersion;

    @kg(key = "app_id")
    private String mAppID;

    @kg(key = "custom_id")
    private String mBizID;

    @kg(key = "hex_id")
    private String mHex;

    @kg(key = "start_id")
    private String mStartID;

    @kg(key = "sdk")
    private AnalyseSDKModel sdkModel;

    @kg(key = "logStrategy")
    private AnalyseLogStrategyModel strategyModel;

    @kg(key = RichTextUtils.USER_SCHEME)
    private AnalyseUserModel userModel;

    public static final class AnalyseAdapterInfo extends Analyse2JsonLog {

        @kg(key = "adapter")
        private String name;

        @kg(key = "version")
        private String version;

        private AnalyseAdapterInfo(String str, String str2) {
            this.name = str;
            this.version = str2;
        }
    }

    public static final class AnalyseAppInfo extends Analyse2JsonLog {

        @kg(key = "app_name")
        private String appName;

        @kg(key = AlibcCommonConstant.APP_VERSION)
        private String appVersion;

        @kg(key = "bundle_id")
        private String bundleID;

        @kg(key = "install_time")
        private String installTime;

        @kg(key = "update_time")
        private String updateTime;

        private AnalyseAppInfo(Context context) {
            this.appName = xk.c(context);
            this.appVersion = xk.d(context);
            this.bundleID = context.getPackageName();
            this.installTime = xk.a(context) + "";
            this.updateTime = xk.b(context) + "";
        }
    }

    public static final class AnalyseConfigInfo extends Analyse2JsonLog {

        @kg(key = "custom_data")
        private String mCustomData;

        @kg(key = "version")
        private String mVersionMD5;

        private AnalyseConfigInfo(String str, String str2) {
            this.mVersionMD5 = str;
            this.mCustomData = str2;
        }
    }

    public static class AnalyseDevInfo extends Analyse2JsonLog {

        @kg(key = "brand")
        private String brand;

        @kg(key = "carrier")
        private String carrier;

        @kg(key = "connection_type")
        private String connectType;

        @kg(key = ze1.s)
        private String country;

        @kg(key = "device_name")
        private String deviceName;

        @kg(key = "device_type")
        private String deviceType;

        @kg(key = "hard_disk_size")
        private String diskSize;

        @kg(key = "file_mark")
        private String fileMark;

        @kg(key = y6b.g)
        private String h;

        @kg(key = dv9.h)
        private String language;

        @kg(key = "make")
        private String make;

        @kg(key = "physical_memory")
        private String memory;

        @kg(key = ze1.k)
        private String model;

        @kg(key = DeviceIdType.OAID)
        private String oaid;

        @kg(key = "os")
        private String os;

        @kg(key = "osv")
        private String osv;

        @kg(key = "said")
        private String said;

        @kg(key = "zone")
        private String timezone;

        @kg(key = "user_agent")
        private String ua;

        @kg(key = "update_mark")
        private String updateMark;

        @kg(key = "w")
        private String w;

        private AnalyseDevInfo(yb ybVar, String str, String str2) {
            this.deviceName = ybVar.b();
            this.deviceType = ybVar.y() + "";
            this.said = str2;
            this.os = ybVar.B() + "";
            this.country = ybVar.s();
            this.timezone = ybVar.F();
            this.language = ybVar.D();
            this.connectType = ybVar.a() + "";
            this.carrier = ybVar.q();
            this.osv = ybVar.j();
            this.oaid = str;
            this.model = ybVar.g();
            this.w = ybVar.C() + "";
            this.h = ybVar.u() + "";
            this.make = ybVar.e();
            this.brand = ybVar.h();
            this.updateMark = ybVar.A();
            this.fileMark = ybVar.r();
            this.diskSize = ybVar.l();
            this.ua = ybVar.d();
            this.memory = ybVar.n();
        }
    }

    public static final class AnalyseSDKInfo extends Analyse2JsonLog {

        @kg(key = "adapter")
        private List<AnalyseAdapterInfo> adapters;

        @kg(key = "version")
        private String mVersion;

        private AnalyseSDKInfo(String str) {
            this.mVersion = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(List list) {
            this.adapters = list;
        }
    }

    public static final class AnalyseUserInfo extends Analyse2JsonLog {

        @kg(key = "user_custom_data")
        private String customData;

        @kg(key = "lmt")
        private String lmt;

        @kg(key = PtgRewardConstant.REWARD_PARAMS.USER_ID)
        private String userID;

        private AnalyseUserInfo(String str, String str2, String str3) {
            this.userID = str;
            this.customData = str2;
            this.lmt = str3;
        }
    }

    public AnalyseInitConfigModel(JSONObject jSONObject) {
        super(jSONObject);
        this.logVersion = BuildConfig.VERSION_NAME;
        this.accessKey = "sdk";
    }

    public String a() {
        return this.mStartID;
    }

    public AnalyseLogStrategyModel b() {
        return this.strategyModel;
    }

    public j2 a(Context context, Map map) {
        Analyse2FinalLog analyse2FinalLog;
        synchronized (this) {
            analyse2FinalLog = new Analyse2FinalLog(this);
            analyse2FinalLog.a(context);
            analyse2FinalLog.b(map);
        }
        return analyse2FinalLog;
    }

    public static class Analyse2FinalLog extends Analyse2JsonLog implements j2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27082a;
        private String b;
        private String c;

        @kg(key = "config_version_md5")
        private String configVersionMd5;

        @kg(key = "crash")
        private List<ScopeCrashLog> crashLogs;
        private String d;
        private String e;
        private String f;
        private String g;
        private String i;

        @kg(key = "event_list")
        private List<j2.c> initLogs;
        private String[] j;

        @kg(key = "lastUpdateTime")
        private String lastUpdateTime;

        @kg(key = "app_id")
        private String mAppID;

        @kg(key = NativeCallContext.DOMAIN_APP)
        private AnalyseAppInfo mAppInfo;

        @kg(key = "custom_id")
        private String mBizID;

        @kg(key = "configuration")
        private AnalyseConfigInfo mConfigInfo;

        @kg(key = "device")
        private AnalyseDevInfo mDevInfo;

        @kg(key = "hex_id")
        private String mHex;

        @kg(key = "sdk")
        private AnalyseSDKInfo mSDKInfo;

        @kg(key = "start_id")
        private String mStartID;

        @kg(key = RichTextUtils.USER_SCHEME)
        private AnalyseUserInfo mUserInfo;

        @kg(key = "session_list")
        private List<j2.b> sessionLogs;

        @kg(key = "log_version")
        private final String logVersion = BuildConfig.VERSION_NAME;

        @kg(key = AuthConstant.ACCESS_KEY)
        private final String accessKey = "sdk";

        public Analyse2FinalLog(AnalyseInitConfigModel analyseInitConfigModel) {
            this.f27082a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.i = "";
            this.mStartID = analyseInitConfigModel.mStartID;
            this.mAppID = analyseInitConfigModel.mAppID;
            this.mBizID = analyseInitConfigModel.mBizID;
            this.lastUpdateTime = analyseInitConfigModel.lastUpdateTime;
            this.configVersionMd5 = analyseInitConfigModel.configVersionMd5;
            AnalyseLogStrategyModel analyseLogStrategyModel = analyseInitConfigModel.strategyModel;
            if (analyseLogStrategyModel != null) {
                this.f27082a = analyseLogStrategyModel.getVersion();
                this.b = analyseInitConfigModel.strategyModel.getCustomData();
            }
            AnalyseUserModel analyseUserModel = analyseInitConfigModel.userModel;
            if (analyseUserModel != null) {
                this.c = analyseUserModel.d();
                this.d = analyseInitConfigModel.userModel.c();
                this.e = analyseInitConfigModel.userModel.e();
                this.g = analyseInitConfigModel.userModel.a();
                this.i = analyseInitConfigModel.userModel.b();
            }
            AnalyseSDKModel analyseSDKModel = analyseInitConfigModel.sdkModel;
            if (analyseSDKModel != null) {
                this.f = analyseSDKModel.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(Context context) {
            if (TextUtils.isEmpty(this.mHex)) {
                this.mHex = nn.a(this.mStartID) + "";
            }
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            if (this.mConfigInfo == null) {
                this.mConfigInfo = new AnalyseConfigInfo(this.f27082a, this.b);
            }
            if (this.mUserInfo == null) {
                this.mUserInfo = new AnalyseUserInfo(this.c, this.d, this.e);
            }
            if (this.mAppInfo == null) {
                this.mAppInfo = new AnalyseAppInfo(context);
            }
            if (this.mSDKInfo == null) {
                this.mSDKInfo = new AnalyseSDKInfo(this.f);
            }
            if (this.mDevInfo == null) {
                this.mDevInfo = new AnalyseDevInfo((yb) y6.a().b(context), this.g, this.i);
            }
        }

        public void b(Map map) {
            if (this.mSDKInfo == null || map == null || map.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                if (entry != null) {
                    arrayList.add(new AnalyseAdapterInfo((String) entry.getKey(), (String) entry.getValue()));
                }
            }
            this.mSDKInfo.d(arrayList);
        }

        @Override // com.beizi.fusion.j2
        public void c(List list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AnalyseSimpleLog analyseSimpleLog = (AnalyseSimpleLog) it.next();
                if (analyseSimpleLog != null) {
                    arrayList.add(analyseSimpleLog.a());
                }
            }
            this.initLogs = arrayList;
        }

        @Override // com.beizi.fusion.j2
        public void a(List list) {
            this.mBizID = "crash";
            this.crashLogs = list;
        }

        @Override // com.beizi.fusion.j2
        public void a(Map map) {
            if (map == null || map.isEmpty()) {
                return;
            }
            Collection collectionValues = map.values();
            if (collectionValues.isEmpty()) {
                return;
            }
            this.sessionLogs = new ArrayList(collectionValues.size());
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                j2.b bVarA = a((LinkedList) it.next());
                if (bVarA != null) {
                    this.sessionLogs.add(bVarA);
                }
            }
        }

        @Override // com.beizi.fusion.j2
        public void a(String[] strArr) {
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            this.j = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        @Override // com.beizi.fusion.j2
        public byte[] a() {
            String[] strArr;
            ig analyseGsonObject = getAnalyseGsonObject();
            if (analyseGsonObject != null && (strArr = this.j) != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        analyseGsonObject.a(str);
                    }
                }
            }
            return q8.a(getAnalyseGsonObject());
        }

        private j2.b a(LinkedList linkedList) {
            AnalyseAdEventLog analyseAdEventLog;
            AnalyseAdCommon analyseAdCommonB;
            if (linkedList == null || linkedList.isEmpty() || (analyseAdEventLog = (AnalyseAdEventLog) linkedList.get(0)) == null || (analyseAdCommonB = analyseAdEventLog.b()) == null) {
                return null;
            }
            j2.b bVarA = analyseAdCommonB.a();
            bVarA.b(linkedList);
            return bVarA;
        }
    }
}
