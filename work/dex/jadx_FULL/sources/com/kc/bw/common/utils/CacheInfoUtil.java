package com.kc.bw.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kc.bw.common.runnable.HasReturnRunnable;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CacheInfoUtil {

    @Keep
    public static class HelperEntity {
        public long expirationTime;
        public String info;

        public HelperEntity(String str, long j) {
            this.info = str;
            this.expirationTime = j;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public String getInfo() {
            return this.info;
        }

        public void setExpirationTime(long j) {
            this.expirationTime = j;
        }

        public void setInfo(String str) {
            this.info = str;
        }

        public String toString() {
            return dexg.dexa("|") + dexg.dexa("#jogp#;#") + this.info + '\"' + dexg.dexa("-#fyqjsbujpoUjnf#;") + this.expirationTime + '}';
        }
    }

    public static String getInfo(Context context, String str, String str2, boolean z, long j, HasReturnRunnable<String> hasReturnRunnable) {
        try {
            if (j == 0) {
                DebugLog.common_debug(dexg.dexa("櫓徔溴搱睫潁摰꜇瞄ꚑ-幎ꈈ꜇"), str2);
                return "";
            }
            if (j < 0) {
                DebugLog.common_debug(dexg.dexa("櫓徔溴搱渳潁摰ꈈ꜇瞄ꚑ-毟瘷鏸搗"), str2);
                return hasReturnRunnable.run();
            }
            long j2 = j * 60 * 1000;
            String preferencesString = SharedPreferencesHelper.getInstance(context).getPreferencesString(str2, z);
            if (TextUtils.isEmpty(preferencesString)) {
                DebugLog.common_debug(dexg.dexa("櫓徔溴搱渳潁摰ꈈ꜇瞄ꚑ-幕睭東幎殙杩-ꈎ痱ꈈ꜇"), str2);
                String strRun = hasReturnRunnable.run();
                if (TextUtils.isEmpty(strRun)) {
                    DebugLog.common_debug(dexg.dexa("睭筢ꈈ꜇牑拠"), str2);
                    strRun = "";
                }
                SharedPreferencesHelper.getInstance(context).savePreferencesString(str2, GsonUtils.getInstance().toJson(new HelperEntity(strRun, System.currentTimeMillis() + j2)), z);
                return strRun;
            }
            HelperEntity helperEntity = (HelperEntity) GsonUtils.getInstance().fromJson(preferencesString, HelperEntity.class);
            if (helperEntity.getExpirationTime() > System.currentTimeMillis()) {
                DebugLog.common_debug(dexg.dexa("櫓徔溴搱渳潁摰ꈈ꜇瞄ꚑ-幕睭東睫���睠-蜵珦��蕩幎ꈎ痱鏸搗"), str2);
                return helperEntity.getInfo();
            }
            DebugLog.common_debug(dexg.dexa("櫓徔溴搱渳潁摰ꈈ꜇瞄ꚑ-幕睭東渳���睠-潁樌ꈎ痱鏸搗"), str2);
            String strRun2 = hasReturnRunnable.run();
            if (TextUtils.isEmpty(strRun2)) {
                return "";
            }
            SharedPreferencesHelper.getInstance(context).savePreferencesString(str2, GsonUtils.getInstance().toJson(new HelperEntity(strRun2, System.currentTimeMillis() + j2)), z);
            return strRun2;
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("hfuJogp!gbjm!") + th);
            reportErrorInfo(dexg.dexa("hfuJogp!gbjm-lfz>") + str2 + dexg.dexa(c49.f40900a), th);
            return "";
        }
    }

    public static void reportErrorInfo(String str, Throwable th) {
        ReportUtils.exReport(ContextContainer.getApplicationContext(), 999961, dexg.dexa("睭東轔殙ꆎ辯鰼懚楲鵦"), str + (th != null ? th.toString() : ""));
    }
}
