package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fl.saas.base.cache.DatabaseHelper;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.zj.adlib.bv9;
import com.zj.adlib.c49;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 20})
public abstract class c implements Cloneable {
    public static final SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29074a;
    public long c;
    public int da;
    public int i;
    public long n;
    public String sl;
    public String sp;
    public long tt;
    public String uj;
    public long ve;
    public String x;

    public c() {
        c(0L);
    }

    public static String tt(long j) {
        return t.format(new Date(j));
    }

    @NonNull
    public final JSONObject a() {
        try {
            this.sl = tt(this.tt);
            return tt();
        } catch (JSONException e) {
            com.byazt.yv.da.tt(e);
            return null;
        }
    }

    public void c(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.tt = j;
    }

    public String i() {
        return null;
    }

    @NonNull
    public final JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", uj());
            c(jSONObject);
        } catch (JSONException e) {
            com.byazt.yv.da.tt(e);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            com.byazt.yv.da.tt(e);
            return null;
        }
    }

    @NonNull
    public String toString() {
        String strUj = uj();
        if (!getClass().getSimpleName().equalsIgnoreCase(strUj)) {
            strUj = strUj + ", " + getClass().getSimpleName();
        }
        String strSubstring = this.uj;
        String str = c49.f40900a;
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf(c49.f40900a);
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            str = strSubstring;
        }
        return bv9.b + strUj + ", " + x() + ", " + str + ", " + this.tt + "}";
    }

    public abstract JSONObject tt() throws JSONException;

    @NonNull
    public abstract String uj();

    public final String ve() {
        List<String> listC = c();
        if (listC == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(uj());
        sb.append("(");
        for (int i = 0; i < listC.size(); i += 2) {
            sb.append(listC.get(i));
            sb.append(" ");
            sb.append(listC.get(i + 1));
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public String x() {
        return "sid:" + this.uj;
    }

    public c tt(@NonNull JSONObject jSONObject) {
        this.tt = jSONObject.optLong("local_time_ms", 0L);
        this.c = 0L;
        this.ve = 0L;
        this.i = 0;
        this.n = 0L;
        this.uj = null;
        this.f29074a = null;
        this.sp = null;
        this.x = null;
        return this;
    }

    public List<String> c() {
        return Arrays.asList(DatabaseHelper.COLUMN_ID, "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, PtgRewardConstant.REWARD_PARAMS.USER_ID, TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar", "event_type", TypedValues.Custom.S_INT);
    }

    public int c(@NonNull Cursor cursor) {
        this.c = cursor.getLong(0);
        this.tt = cursor.getLong(1);
        this.ve = cursor.getLong(2);
        this.i = cursor.getInt(3);
        this.n = cursor.getLong(4);
        this.uj = cursor.getString(5);
        this.f29074a = cursor.getString(6);
        this.sp = cursor.getString(7);
        this.x = cursor.getString(8);
        this.da = cursor.getInt(9);
        return 10;
    }

    public final ContentValues tt(@Nullable ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        c(contentValues);
        return contentValues;
    }

    public void c(@NonNull ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.tt));
        contentValues.put("tea_event_index", Long.valueOf(this.ve));
        contentValues.put("nt", Integer.valueOf(this.i));
        contentValues.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, Long.valueOf(this.n));
        contentValues.put("session_id", this.uj);
        contentValues.put("user_unique_id", this.f29074a);
        contentValues.put("ssid", this.sp);
        contentValues.put("ab_sdk_version", this.x);
        contentValues.put("event_type", Integer.valueOf(this.da));
    }

    public void c(@NonNull JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.tt);
    }

    public static c c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return tt.tt.get(jSONObject.optString("k_cls", "")).clone().tt(jSONObject);
        } catch (Throwable th) {
            com.byazt.yv.da.tt(th);
            return null;
        }
    }
}
