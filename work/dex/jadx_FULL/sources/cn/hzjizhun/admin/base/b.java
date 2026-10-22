package cn.hzjizhun.admin.base;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f22696a = new JSONObject();

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.trim();
    }
}
