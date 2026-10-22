package cn.hzjizhun.admin;

import android.text.TextUtils;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.custom_ad.http.AESUtil;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.ClassUtil;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.net.URLDecoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class addsdaskk {
    public static void a() {
        try {
            String expand = FunctionConfig.instance().getExpand();
            if (TextUtils.isEmpty(expand)) {
                return;
            }
            String strDecode = URLDecoder.decode(new String(AESUtil.base64Decode(expand)), "UTF-8");
            ALog.d("initMob", strDecode);
            JSONObject jSONObjectOptJSONObject = new JSONObject(strDecode).optJSONObject("mob");
            String strOptString = jSONObjectOptJSONObject.optString(CachedContentIndex.a.e);
            String strOptString2 = jSONObjectOptJSONObject.optString("secret");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                ALog.d("MobThirdSdkInit", strOptString + "----" + strOptString2);
                dkkdddkkd.a(ClassUtil.createInstanceByClass("cn.hzjizhun.admin.mob.MobThirdSdkInit"));
                JZAdSdk.getInstance().getContext();
                throw null;
            }
        } catch (Throwable unused) {
        }
    }
}
