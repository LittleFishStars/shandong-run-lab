package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class SmallDisplaySizeQuirk implements Quirk {
    private static final Map<String, Size> MODEL_TO_DISPLAY_SIZE_MAP;
    private static final String TAG = "SmallDisplaySizeQuirk";

    static {
        HashMap map = new HashMap();
        MODEL_TO_DISPLAY_SIZE_MAP = map;
        map.put("REDMI NOTE 8", new Size(1080, 2340));
        map.put("REDMI NOTE 7", new Size(1080, 2340));
        map.put("SM-A207M", new Size(720, 1560));
        map.put("REDMI NOTE 7S", new Size(1080, 2340));
        map.put("SM-A127F", new Size(720, 1600));
        map.put("SM-A536E", new Size(1080, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY));
        map.put("220233L2I", new Size(720, 1600));
        map.put("V2149", new Size(720, 1600));
        map.put("VIVO 1920", new Size(1080, 2340));
        map.put("CPH2223", new Size(1080, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY));
        map.put("V2029", new Size(720, 1600));
        map.put("CPH1901", new Size(720, 1520));
        map.put("REDMI Y3", new Size(720, 1520));
        map.put("SM-A045M", new Size(720, 1600));
        map.put("SM-A146U", new Size(1080, 2408));
        map.put("CPH1909", new Size(720, 1520));
        map.put("NOKIA 4.2", new Size(720, 1520));
        map.put("SM-G960U1", new Size(1440, 2960));
        map.put("SM-A137F", new Size(1080, 2408));
        map.put("VIVO 1816", new Size(720, 1520));
        map.put("INFINIX X6817", new Size(720, SecExceptionCode.SEC_ERROR_SAFETOKEN_CALL_VM_FAILED));
        map.put("SM-A037F", new Size(720, 1600));
        map.put("NOKIA 2.4", new Size(720, 1600));
        map.put("SM-A125M", new Size(720, 1600));
        map.put("INFINIX X670", new Size(1080, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY));
    }

    public static boolean load() {
        return MODEL_TO_DISPLAY_SIZE_MAP.containsKey(Build.MODEL.toUpperCase(Locale.US));
    }

    @NonNull
    public Size getDisplaySize() {
        return MODEL_TO_DISPLAY_SIZE_MAP.get(Build.MODEL.toUpperCase(Locale.US));
    }
}
