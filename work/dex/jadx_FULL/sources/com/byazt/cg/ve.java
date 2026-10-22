package com.byazt.cg;

import android.text.TextUtils;
import com.byazt.dna.or;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 549, 54})
public class ve implements or {
    public tt tt = new tt();
    public c ve = new c();
    public boolean c = !this.tt.c();

    @Override // com.byazt.dna.or
    public String get(String str) {
        String str2 = this.tt.c() ? this.tt.get(str) : "";
        return (this.c && TextUtils.isEmpty(str2)) ? this.ve.get(str) : str2;
    }

    @Override // com.byazt.dna.or
    public boolean getBoolean(String str) {
        boolean z = this.tt.c() ? this.tt.getBoolean(str) : false;
        return (!this.c || z) ? z : this.ve.getBoolean(str);
    }

    @Override // com.byazt.dna.or
    public int getInt(String str) {
        int i = this.tt.c() ? this.tt.getInt(str) : Integer.MAX_VALUE;
        return (this.c && i == Integer.MAX_VALUE) ? this.ve.getInt(str) : i;
    }

    @Override // com.byazt.dna.or
    public long getLong(String str) {
        long j = this.tt.c() ? this.tt.getLong(str) : Long.MAX_VALUE;
        return (this.c && j == 2147483647L) ? this.ve.getLong(str) : j;
    }

    @Override // com.byazt.dna.or
    public void set(String str, String str2) {
        if (this.tt.c()) {
            this.tt.set(str, str2);
        }
    }
}
