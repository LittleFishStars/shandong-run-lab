package androidx.datastore.migrations;

import android.content.SharedPreferences;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0086\u0002J\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006J(\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00062\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/datastore/migrations/SharedPreferencesView;", "", "prefs", "Landroid/content/SharedPreferences;", "keySet", "", "", "(Landroid/content/SharedPreferences;Ljava/util/Set;)V", "checkKey", CachedContentIndex.a.e, "contains", "", "getAll", "", "getBoolean", "defValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "defValues", "datastore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SharedPreferencesView {

    @Nullable
    private final Set<String> keySet;

    @NotNull
    private final SharedPreferences prefs;

    public SharedPreferencesView(@NotNull SharedPreferences sharedPreferences, @Nullable Set<String> set) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.keySet = set;
    }

    private final String checkKey(String key) {
        Set<String> set = this.keySet;
        if (set == null || set.contains(key)) {
            return key;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Can't access key outside migration: ", key).toString());
    }

    public static /* synthetic */ String getString$default(SharedPreferencesView sharedPreferencesView, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.getString(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set getStringSet$default(SharedPreferencesView sharedPreferencesView, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.getStringSet(str, set);
    }

    public final boolean contains(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        return this.prefs.contains(checkKey(key));
    }

    @NotNull
    public final Map<String, Object> getAll() {
        Map<String, ?> all = this.prefs.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Set<String> set = this.keySet;
            if (set == null ? true : set.contains(key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof Set) {
                value = CollectionsKt.toSet((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        return linkedHashMap2;
    }

    public final boolean getBoolean(@NotNull String key, boolean defValue) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        return this.prefs.getBoolean(checkKey(key), defValue);
    }

    public final float getFloat(@NotNull String key, float defValue) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        return this.prefs.getFloat(checkKey(key), defValue);
    }

    public final int getInt(@NotNull String key, int defValue) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        return this.prefs.getInt(checkKey(key), defValue);
    }

    public final long getLong(@NotNull String key, long defValue) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        return this.prefs.getLong(checkKey(key), defValue);
    }

    @Nullable
    public final String getString(@NotNull String key, @Nullable String defValue) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        return this.prefs.getString(checkKey(key), defValue);
    }

    @Nullable
    public final Set<String> getStringSet(@NotNull String key, @Nullable Set<String> defValues) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        Set<String> stringSet = this.prefs.getStringSet(checkKey(key), defValues);
        if (stringSet == null) {
            return null;
        }
        return CollectionsKt.toMutableSet(stringSet);
    }
}
