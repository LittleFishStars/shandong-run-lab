package com.beizi.fusion.asnp.common.v2.crash;

import android.text.TextUtils;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.common.analyse2.base.model.Analyse2JsonLog;
import com.beizi.fusion.kg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeCrashLog extends Analyse2JsonLog {

    @kg(key = "affiliated")
    private String mAffiliated;

    @kg(key = c.f25231a)
    private String mException;

    @kg(key = StrategyEventDBModel.COLUMN_EVENT_TIME)
    private final String mTime;

    public ScopeCrashLog(String str, String str2, String str3) {
        this.mException = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = System.currentTimeMillis() + "";
        }
        this.mTime = str3;
        this.mAffiliated = str;
    }
}
