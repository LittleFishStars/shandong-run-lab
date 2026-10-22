package com.byazt.ds;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 158})
public class sl extends ve {
    public final Context n;

    public sl(Context context) {
        super(true, true);
        this.n = context;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        i.c(jSONObject, MediaFormat.KEY_LANGUAGE, this.n.getResources().getConfiguration().locale.getLanguage());
        jSONObject.put("timezone", com.byazt.yv.c.ve());
        i.c(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        i.c(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
