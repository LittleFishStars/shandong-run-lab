package com.byazt.ik;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2058, 54})
public class ve {
    public static volatile ve c;
    public Uri tt;

    private ve() {
        if (com.byazt.bp.tt.getContext() != null) {
            this.tt = com.byazt.pe.c.c(Uri.parse("content://" + com.byazt.bp.tt.getContext().getPackageName() + ".TTMultiProvider/gromore_prime_rit_adn_perform"), "gromore_prime_rit_adn_perform");
        }
    }

    public static ve c() {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new ve();
                }
            }
        }
        return c;
    }

    public void insert(String str, String str2, String str3, String str4) {
        if (com.byazt.bp.tt.getContext() == null || this.tt == null) {
            return;
        }
        ContentResolver contentResolver = com.byazt.bp.tt.getContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADN_NAME, str);
        contentValues.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
        contentValues.put("adn_rit", str3);
        contentValues.put("ad_action", str4);
        contentValues.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
        contentResolver.insert(this.tt, contentValues);
    }

    public List<tt> query(String str, String str2, long j, long j2) {
        String str3;
        String[] strArr;
        if (com.byazt.bp.tt.getContext() == null || this.tt == null) {
            return null;
        }
        ContentResolver contentResolver = com.byazt.bp.tt.getContext().getContentResolver();
        String[] strArr2 = {str, str2, String.valueOf(j), String.valueOf(j2)};
        if (TextUtils.isEmpty(str)) {
            strArr = new String[]{str2, String.valueOf(j), String.valueOf(j2)};
            str3 = "prime_rit=? AND time_stamp>=? AND time_stamp<?";
        } else {
            str3 = "adn_name=? AND prime_rit=? AND time_stamp>=? AND time_stamp<?";
            strArr = strArr2;
        }
        Cursor cursorQuery = contentResolver.query(this.tt, null, str3, strArr, null);
        if (cursorQuery == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(MediationConstant.EXTRA_ADN_NAME));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(MediationConstant.KEY_GM_PRIME_RIT));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("adn_rit"));
                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("ad_action"));
                long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("time_stamp"));
                tt ttVar = new tt();
                ttVar.ve(string);
                ttVar.c(string2);
                ttVar.tt(string3);
                ttVar.uj(string4);
                ttVar.c(j3);
                linkedList.add(ttVar);
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return linkedList;
    }

    public void c(String str, long j) {
        if (com.byazt.bp.tt.getContext() == null || this.tt == null || j <= 0) {
            return;
        }
        try {
            com.byazt.bp.tt.getContext().getContentResolver().delete(this.tt, "prime_rit=? AND time_stamp<?", new String[]{str, String.valueOf(j)});
        } catch (IllegalStateException unused) {
        }
    }
}
