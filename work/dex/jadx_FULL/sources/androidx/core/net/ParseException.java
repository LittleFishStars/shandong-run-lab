package androidx.core.net;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class ParseException extends RuntimeException {

    @NonNull
    public final String response;

    public ParseException(@NonNull String str) {
        super(str);
        this.response = str;
    }
}
