package androidx.profileinstaller;

import androidx.annotation.RestrictTo;
import com.alibaba.ariver.resource.parser.a.e;
import com.zj.adlib.u15;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ProfileVersion {
    public static final int MAX_SUPPORTED_SDK = 33;
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V015_S = {e.i, e.j, e.n, 0};
    static final byte[] V010_P = {e.i, e.j, e.i, 0};
    static final byte[] V009_O_MR1 = {e.i, e.i, 57, 0};
    static final byte[] V005_O = {e.i, e.i, e.n, 0};
    static final byte[] V001_N = {e.i, e.i, e.j, 0};
    static final byte[] METADATA_V001_N = {e.i, e.i, e.j, 0};
    static final byte[] METADATA_V002 = {e.i, e.i, e.k, 0};

    private ProfileVersion() {
    }

    public static String dexKeySeparator(byte[] bArr) {
        return (Arrays.equals(bArr, V001_N) || Arrays.equals(bArr, V005_O)) ? u15.f19942b : "!";
    }
}
