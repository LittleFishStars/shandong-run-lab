package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class FallbackStrategy {
    static final int FALLBACK_RULE_HIGHER = 2;
    static final int FALLBACK_RULE_HIGHER_OR_LOWER = 1;
    static final int FALLBACK_RULE_LOWER = 4;
    static final int FALLBACK_RULE_LOWER_OR_HIGHER = 3;
    static final int FALLBACK_RULE_NONE = 0;
    static final FallbackStrategy NONE = new AutoValue_FallbackStrategy_RuleStrategy(Quality.NONE, 0);

    @AutoValue
    public static abstract class RuleStrategy extends FallbackStrategy {
        public RuleStrategy() {
            super();
        }

        @NonNull
        public abstract Quality getFallbackQuality();

        public abstract int getFallbackRule();
    }

    @NonNull
    public static FallbackStrategy higherQualityOrLowerThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 1);
    }

    @NonNull
    public static FallbackStrategy higherQualityThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 2);
    }

    @NonNull
    public static FallbackStrategy lowerQualityOrHigherThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 3);
    }

    @NonNull
    public static FallbackStrategy lowerQualityThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 4);
    }

    private FallbackStrategy() {
    }
}
