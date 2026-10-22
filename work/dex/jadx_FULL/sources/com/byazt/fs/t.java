package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 66})
public class t implements aw<Float> {
    public static final t c = new t();

    private t() {
    }

    @Override // com.byazt.fs.aw
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float tt(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(my.tt(jsonReader) * f);
    }
}
