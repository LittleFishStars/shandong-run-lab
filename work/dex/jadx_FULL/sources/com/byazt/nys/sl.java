package com.byazt.nys;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 158})
public class sl implements com.byazt.uk.da {
    public SharedPreferences c;

    private SharedPreferences c() {
        Context context = TTAppContextHolder.getContext();
        if (context != null && this.c == null) {
            String string = tt.tt(context, tt("09152a11360f011014022a1c2f1f3a1513070712"), 0).getString(tt("00000000001815"), null);
            if (TextUtils.isEmpty(string)) {
                string = tt("0a041b14330e3a1a090f");
            }
            SharedPreferences sharedPreferencesTt = tt.tt(context, string, 0);
            this.c = sharedPreferencesTt;
            if (!sharedPreferencesTt.getBoolean("0000000000060c1e0804011a30053a1d150b10", false)) {
                c(tt.tt(context, tt("0a041b14330e3a141f11142c3b0a1118251605"), 0), this.c, "0000000000060c1e0804011a30053a1d150b10", true);
            }
        }
        return this.c;
    }

    private String uj(String str) {
        return (str == null || str.isEmpty()) ? "" : c(c(str.getBytes(), "zeus_key".getBytes()));
    }

    private byte[] ve(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    @Override // com.byazt.uk.da
    public String tt(String str, String str2) {
        SharedPreferences sharedPreferencesC = c();
        return sharedPreferencesC != null ? sharedPreferencesC.getString(str, str2) : str2;
    }

    @Override // com.byazt.uk.da
    public void tt(String str, int i) {
        SharedPreferences sharedPreferencesC = c();
        if (sharedPreferencesC != null) {
            sharedPreferencesC.edit().putInt(str, i).apply();
        }
    }

    @Override // com.byazt.uk.da
    public boolean tt(String str, boolean z) {
        SharedPreferences sharedPreferencesC = c();
        return sharedPreferencesC != null ? sharedPreferencesC.getBoolean(str, z) : z;
    }

    private String tt(String str) {
        return new String(c(ve(str), "zeus_key".getBytes()));
    }

    private void c(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, String str, boolean z) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (!all.isEmpty()) {
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            Iterator<String> it = all.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object obj = all.get(next);
                if (z) {
                    next = uj(next);
                }
                if (obj instanceof String) {
                    editorEdit.putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    editorEdit.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    editorEdit.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof Float) {
                    editorEdit.putFloat(next, ((Float) obj).floatValue());
                } else if (obj instanceof Boolean) {
                    editorEdit.putBoolean(next, ((Boolean) obj).booleanValue());
                }
                editorEdit.apply();
            }
            return;
        }
        sharedPreferences2.edit().putBoolean(str, true).apply();
    }

    @Override // com.byazt.uk.da
    public void c(String str, String str2) {
        SharedPreferences sharedPreferencesC = c();
        if (sharedPreferencesC != null) {
            sharedPreferencesC.edit().putString(str, str2).apply();
        }
    }

    @Override // com.byazt.uk.da
    public int c(String str, int i) {
        SharedPreferences sharedPreferencesC = c();
        return sharedPreferencesC != null ? sharedPreferencesC.getInt(str, i) : i;
    }

    @Override // com.byazt.uk.da
    public void c(String str, boolean z) {
        SharedPreferences sharedPreferencesC = c();
        if (sharedPreferencesC != null) {
            sharedPreferencesC.edit().putBoolean(str, z).apply();
        }
    }

    @Override // com.byazt.uk.da
    public void c(String str) {
        SharedPreferences sharedPreferencesC = c();
        if (sharedPreferencesC != null) {
            sharedPreferencesC.edit().remove(str).apply();
        }
    }

    private byte[] c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    private String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
