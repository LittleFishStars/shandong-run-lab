package com.beizi.fusion.asnp.adn.ad.model.impl.db;

import android.text.TextUtils;
import com.beizi.fusion.j6;
import com.beizi.fusion.ka;
import com.beizi.fusion.no;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class StrategyEventDBModel extends ka {
    public static final String COLUMN_API_KEY = "apiKey";
    public static final String COLUMN_EVENT_CODE = "eventCode";
    public static final String COLUMN_EVENT_TIME = "eventTime";
    public static final String COLUMN_SPACE_ID = "spaceId";

    @j6(column = COLUMN_API_KEY)
    private String apiKey;

    @j6(column = COLUMN_EVENT_CODE)
    private String eventCode;

    @j6(column = COLUMN_EVENT_TIME, encode = false)
    private String eventTime;

    @j6(column = COLUMN_SPACE_ID)
    private String spaceId;

    public String getApiKey() {
        return this.apiKey;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public long getEventTime() {
        if (TextUtils.isEmpty(this.eventTime)) {
            return 0L;
        }
        return no.j(this.eventTime);
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setEventTime(String str) {
        this.eventTime = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
