package com.insightface.sdk.inspireface.base;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class FeatureHubConfiguration {
    public int primaryKeyMode = 0;
    public int enablePersistence = 0;
    public String persistenceDbPath = "";
    public float searchThreshold = 0.42f;
    public int searchMode = 1;

    public FeatureHubConfiguration setEnablePersistence(boolean z) {
        this.enablePersistence = z ? 1 : 0;
        return this;
    }

    public FeatureHubConfiguration setPersistenceDbPath(String str) {
        this.persistenceDbPath = str;
        return this;
    }

    public FeatureHubConfiguration setPrimaryKeyMode(int i) {
        this.primaryKeyMode = i;
        return this;
    }

    public FeatureHubConfiguration setSearchMode(int i) {
        this.searchMode = i;
        return this;
    }

    public FeatureHubConfiguration setSearchThreshold(float f) {
        this.searchThreshold = f;
        return this;
    }
}
