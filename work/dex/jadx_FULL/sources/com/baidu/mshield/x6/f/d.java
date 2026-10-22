package com.baidu.mshield.x6.f;

import android.text.TextUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {
    public static int a(int i, String str) {
        int iA;
        try {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return -1;
            }
            if (jSONArray.length() == 1) {
                return jSONArray.optInt(0);
            }
            if (i == 1) {
                iA = a(jSONArray);
            } else if (i == 2) {
                iA = d(jSONArray);
            } else if (i == 3) {
                iA = e(jSONArray);
            } else if (i == 4) {
                iA = b(jSONArray);
            } else {
                if (i != 5) {
                    return -1;
                }
                iA = c(jSONArray);
            }
            return iA;
        } catch (Throwable th) {
            f.b(th);
            return -1;
        }
    }

    public static int b(JSONArray jSONArray) {
        int iOptInt = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    iOptInt = jSONArray.optInt(0);
                    for (int i = 1; i < jSONArray.length(); i++) {
                        iOptInt <<= jSONArray.optInt(i);
                    }
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return iOptInt;
    }

    public static int c(JSONArray jSONArray) {
        int iOptInt = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    iOptInt = jSONArray.optInt(0);
                    for (int i = 1; i < jSONArray.length(); i++) {
                        iOptInt >>= jSONArray.optInt(i);
                    }
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return iOptInt;
    }

    public static int d(JSONArray jSONArray) {
        int iOptInt = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    iOptInt = jSONArray.optInt(0);
                    for (int i = 1; i < jSONArray.length(); i++) {
                        iOptInt |= jSONArray.optInt(i);
                    }
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return iOptInt;
    }

    public static int e(JSONArray jSONArray) {
        int iOptInt = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    iOptInt = jSONArray.optInt(0);
                    for (int i = 1; i < jSONArray.length(); i++) {
                        iOptInt ^= jSONArray.optInt(i);
                    }
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return iOptInt;
    }

    public static int a(JSONArray jSONArray) {
        int iOptInt = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    iOptInt = jSONArray.optInt(0);
                    for (int i = 1; i < jSONArray.length(); i++) {
                        iOptInt &= jSONArray.optInt(i);
                    }
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return iOptInt;
    }
}
