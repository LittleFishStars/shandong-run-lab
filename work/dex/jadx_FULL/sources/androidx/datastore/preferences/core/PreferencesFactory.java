package androidx.datastore.preferences.core;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a+\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\"\u0006\u0012\u0002\b\u00030\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\n\u001a\u00020\u00012\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\"\u0006\u0012\u0002\b\u00030\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"emptyPreferences", "Landroidx/datastore/preferences/core/Preferences;", "createEmpty", "mutablePreferencesOf", "Landroidx/datastore/preferences/core/MutablePreferences;", "pairs", "", "Landroidx/datastore/preferences/core/Preferences$Pair;", "createMutable", "([Landroidx/datastore/preferences/core/Preferences$Pair;)Landroidx/datastore/preferences/core/MutablePreferences;", "preferencesOf", "create", "([Landroidx/datastore/preferences/core/Preferences$Pair;)Landroidx/datastore/preferences/core/Preferences;", "datastore-preferences-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "PreferencesFactory")
public final class PreferencesFactory {
    @JvmName(name = "create")
    @NotNull
    public static final Preferences create(@NotNull Preferences.Pair<?>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        return createMutable((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @JvmName(name = "createEmpty")
    @NotNull
    public static final Preferences createEmpty() {
        return new MutablePreferences(null, true, 1, null);
    }

    @JvmName(name = "createMutable")
    @NotNull
    public static final MutablePreferences createMutable(@NotNull Preferences.Pair<?>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        MutablePreferences mutablePreferences = new MutablePreferences(null, false, 1, null);
        mutablePreferences.putAll((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        return mutablePreferences;
    }
}
