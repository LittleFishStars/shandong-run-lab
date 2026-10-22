package com.czhj.sdk.common.mta;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bolts.c;
import com.acse.ottn.p3;
import com.alipay.sdk.m.t.e;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.google.android.exoplayer2.offline.a;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.zj.adlib.bv9;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class PointEntitySuper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29405a = UUID.randomUUID().toString();
    private static final AtomicLong b = new AtomicLong(1);
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Map<String, String> j;
    private String k;
    private String l;
    private String m;
    protected Object mPointEntityClass;
    private int n;
    private String o;
    private int p;
    private final long q = b.getAndIncrement();
    private final long r = System.currentTimeMillis();

    private boolean a(String str) {
        return Arrays.asList("motion_before", "motion_after", "frequency_control_list").contains(str);
    }

    public static String captureName(String str) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        if (c <= '`' || c >= '{') {
            return str;
        }
        charArray[0] = (char) (c - ' ');
        return String.valueOf(charArray);
    }

    public static String getSessionId() {
        return f29405a;
    }

    public static String lowFirstChar(String str) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        if (c <= '@' || c >= '[') {
            return str;
        }
        charArray[0] = (char) (c + ' ');
        return String.valueOf(charArray);
    }

    public static String toURLEncoded(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            SigmobLog.e(e.getMessage());
            return "";
        }
    }

    public abstract String appId();

    public void commit() {
        this.mPointEntityClass = this;
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.PointEntitySuper.1
            @Override // java.lang.Runnable
            public void run() {
                PointEntitySuper.this.insertToDB(null);
            }
        });
    }

    public String getAc_type() {
        return this.c;
    }

    public String getAndroid_id() {
        DeviceContext deviceContext = getDeviceContext();
        return deviceContext == null ? ClientMetadata.getInstance().getAndroidId() : deviceContext.getAndroidId();
    }

    public String getAppinfo_switch() {
        return this.e;
    }

    public String getCarrier() {
        DeviceContext deviceContext = getDeviceContext();
        return deviceContext == null ? ClientMetadata.getInstance().getNetworkOperatorForUrl() : deviceContext.getCarrier();
    }

    public String getCategory() {
        return this.g;
    }

    public String getClientversion() {
        return ClientMetadata.getDeviceOsVersion();
    }

    public int getCompatible() {
        return this.p;
    }

    public abstract DeviceContext getDeviceContext();

    public String getExt() {
        return this.i;
    }

    public String getGameversion() {
        return ClientMetadata.getInstance().getAppVersion();
    }

    public String getGoogle_aid() {
        return ClientMetadata.getInstance().getAdvertisingId();
    }

    public String getImei() {
        DeviceContext deviceContext = getDeviceContext();
        return deviceContext == null ? ClientMetadata.getInstance().getDeviceId() : deviceContext.getImei();
    }

    public String getImei1() {
        DeviceContext deviceContext = getDeviceContext();
        return deviceContext == null ? ClientMetadata.getInstance().getDeviceId(0) : deviceContext.getImei1();
    }

    public String getImei2() {
        DeviceContext deviceContext = getDeviceContext();
        return deviceContext == null ? ClientMetadata.getInstance().getDeviceId(1) : deviceContext.getImei2();
    }

    public int getIntegration() {
        return this.n;
    }

    public String getIs_mediation() {
        return this.d;
    }

    public String getLocation_switch() {
        return this.f;
    }

    public String getMd5() {
        return this.l;
    }

    public String getName() {
        return this.m;
    }

    public String getNetworktype() {
        return String.valueOf(ClientMetadata.getInstance().getActiveNetworkType());
    }

    public String getOaid() {
        DeviceContext deviceContext = getDeviceContext();
        return deviceContext == null ? ClientMetadata.getInstance().getOAID() : deviceContext.getOaid();
    }

    public String getOaid_api() {
        return ClientMetadata.getInstance().getOAID_API();
    }

    public Map<String, String> getOptions() {
        if (this.j == null) {
            this.j = new HashMap();
        }
        return this.j;
    }

    public String getOs() {
        return "2";
    }

    public abstract String getSdkversion();

    public String getSeconds_from_GMT() {
        return String.valueOf(((TimeZone.getDefault().getRawOffset() / 1000) / 60) / 60);
    }

    public String getSeq_id() {
        return String.valueOf(this.q);
    }

    public String getSha1() {
        return this.k;
    }

    public String getSub_category() {
        return this.h;
    }

    public String getTime_zone() {
        return TimeZone.getDefault().getID();
    }

    public String getTimestamp() {
        return String.valueOf(this.r);
    }

    public String getUdid() {
        return ClientMetadata.getInstance().getUDID();
    }

    public String getUid() {
        return ClientMetadata.getUid();
    }

    public String getUser_id() {
        return ClientMetadata.getUserId();
    }

    public String getVersion() {
        return this.o;
    }

    public String getWmsession_id() {
        return f29405a;
    }

    public void insertToDB(final SQLiteMTAHelper.ExecCallBack execCallBack) {
        try {
            if (!isAcTypeBlock() && !TextUtils.isEmpty(appId())) {
                Map<String, Object> map = toMap();
                Map<String, String> options = getOptions();
                if (options != null) {
                    map.remove("options");
                    map.putAll(options);
                }
                map.put("_uniq_key", "sigandroid_" + appId());
                String jsonString = toJsonString(map);
                if (TextUtils.isEmpty(jsonString)) {
                    return;
                }
                SigmobLog.d("dcdebug:" + jsonString);
                SQLiteMTAHelper sQLiteMTAHelper = SQLiteMTAHelper.getInstance();
                if (sQLiteMTAHelper == null) {
                    return;
                }
                SQLiteDatabase writableDatabase = sQLiteMTAHelper.getWritableDatabase();
                SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
                builder.setTableName(SQLiteMTAHelper.TABLE_POINT);
                HashMap map2 = new HashMap();
                map2.put("item", AESUtil.EncryptString(jsonString, Constants.AESKEY));
                map2.put("encryption", 1);
                builder.setColumnValues(map2);
                SQLiteMTAHelper.insert(writableDatabase, builder.build(), new SQLiteMTAHelper.ExecCallBack() { // from class: com.czhj.sdk.common.mta.PointEntitySuper.2
                    @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
                    public void onFailed(Throwable th) {
                        SQLiteMTAHelper.ExecCallBack execCallBack2 = execCallBack;
                        if (execCallBack2 != null) {
                            execCallBack2.onFailed(th);
                        }
                        SigmobLog.e(th.getMessage());
                    }

                    @Override // com.czhj.sdk.common.Database.SQLiteMTAHelper.ExecCallBack
                    public void onSuccess() {
                        SigmobLog.d("insert success!");
                        SQLiteMTAHelper.ExecCallBack execCallBack2 = execCallBack;
                        if (execCallBack2 != null) {
                            execCallBack2.onSuccess();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public abstract boolean isAcTypeBlock();

    public void sendServe() {
        sendServe(null);
    }

    public void sendServe(BuriedPointRequest.RequestListener requestListener) {
        this.mPointEntityClass = this;
        String jsonString = toJsonString(toMap());
        if (TextUtils.isEmpty(jsonString)) {
            return;
        }
        try {
            String str = "sigandroid_" + appId();
            BuriedPointRequest.BuriedPointSend(toURLEncoded(BuriedPointManager.deflateAndBase64("_uniq_key=" + str + "&_batch_value=" + ("[" + jsonString + "]"))), requestListener);
        } catch (Exception e) {
            SigmobLog.e(e.getMessage());
        }
    }

    public void setAc_type(String str) {
        this.c = str;
    }

    public void setAppinfo_switch(String str) {
        this.e = str;
    }

    public void setCategory(String str) {
        this.g = str;
    }

    public void setCompatible(int i) {
        this.p = i;
    }

    public void setExt(String str) {
        this.i = str;
    }

    public void setIntegration(int i) {
        this.n = i;
    }

    public void setIs_mediation(String str) {
        this.d = str;
    }

    public void setLocation_switch(String str) {
        this.f = str;
    }

    public void setMd5(String str) {
        this.l = str;
    }

    public void setName(String str) {
        this.m = str;
    }

    public void setOptions(Map<String, String> map) {
        Map<String, String> options = getOptions();
        this.j = options;
        options.putAll(map);
    }

    public void setSha1(String str) {
        this.k = str;
    }

    public void setSub_category(String str) {
        this.h = str;
    }

    public void setTimestamp(String str) {
    }

    public void setVersion(String str) {
        this.o = str;
    }

    public String testJsonString() {
        Map<String, Object> map = toMap();
        if (getOptions() != null) {
            map.remove("options");
            map.putAll(getOptions());
        }
        return toJsonString(map);
    }

    public String toJsonString(Map<String, Object> map) {
        String string;
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bv9.b);
        boolean z = false;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (z) {
                    sb.append(",");
                }
                sb.append("\"" + key + "\":");
                if (value instanceof String) {
                    string = (String) value;
                    if (!a(key)) {
                        string = toURLEncoded(string);
                    }
                } else {
                    string = value.toString();
                }
                if (string.startsWith(bv9.b) || string.startsWith("[")) {
                    sb.append(string);
                } else {
                    sb.append("\"" + string + "\"");
                }
                z = true;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Map<String, Object> toMap() {
        List<Method> methodWithTraversal = ReflectionUtil.getMethodWithTraversal(this.mPointEntityClass.getClass());
        if (methodWithTraversal == null || methodWithTraversal.isEmpty()) {
            return new HashMap();
        }
        HashMap map = new HashMap(methodWithTraversal.size());
        for (Method method : methodWithTraversal) {
            String name = method.getName();
            if (name.startsWith(p3.f) && !name.equals("getLogs") && !name.equals("getDeviceContext")) {
                try {
                    Object objInvoke = method.invoke(this.mPointEntityClass, new Object[0]);
                    String strLowFirstChar = lowFirstChar(name.substring(3));
                    if (objInvoke != null && (!(objInvoke instanceof String) || !TextUtils.isEmpty((String) objInvoke))) {
                        if (strLowFirstChar.equalsIgnoreCase(a.f3594m)) {
                            strLowFirstChar = "content-length";
                        } else if (strLowFirstChar.equalsIgnoreCase("content_type")) {
                            strLowFirstChar = e.f;
                        } else if (strLowFirstChar.equalsIgnoreCase("ac_type")) {
                            strLowFirstChar = "_ac_type";
                        } else if (strLowFirstChar.equalsIgnoreCase(PtgRewardConstant.REWARD_PARAMS.USER_ID)) {
                            strLowFirstChar = "_user_id";
                        } else if (!strLowFirstChar.equalsIgnoreCase(c.f)) {
                        }
                        map.put(strLowFirstChar, objInvoke);
                    }
                } catch (Throwable th) {
                    SigmobLog.e("name " + name + th.getMessage());
                }
            }
        }
        return map;
    }
}
