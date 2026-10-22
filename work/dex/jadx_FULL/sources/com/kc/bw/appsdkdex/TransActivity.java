package com.kc.bw.appsdkdex;

import android.app.Activity;
import android.os.Bundle;
import com.kc.bw.common.IAdLoader;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.MessageEvent;
import com.kc.bw.dexe;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TransActivity extends Activity {
    public static final String dexa = "TransActivity";

    @Keep
    public class dexa implements dexe.dexb {
        public final TransActivity dexa;

        public dexa(TransActivity transActivity) {
            this.dexa = transActivity;
        }

        @Override // com.kc.bw.dexe.dexb
        public void onFailed(String str) {
            DebugLog.W(TransActivity.dexa, dexg.dexa("cvjme!beMpbefs!gbjm-") + str);
            MessageEvent.notify(dexg.dexa("fwfou`gbjmfe"));
            this.dexa.finish();
        }

        @Override // com.kc.bw.dexe.dexb
        public void onLoaded(IAdLoader iAdLoader) {
            if (iAdLoader != null) {
                iAdLoader.dispatchAction(this.dexa);
                return;
            }
            DebugLog.W(TransActivity.dexa, dexg.dexa("cvjme!beMpbefs!gbjm"));
            MessageEvent.notify(dexg.dexa("fwfou`gbjmfe"));
            this.dexa.finish();
        }
    }

    public void dexa() {
        dexe.dexa(getApplicationContext(), "", new dexa(this));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dexa();
    }
}
