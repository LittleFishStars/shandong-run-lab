package com.aliyun.player;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IListPlayer extends IPlayer {

    public enum SceneType {
        SCENE_NONE(-1),
        SCENE_VERY_SHORT(0),
        SCENE_SHORT(1),
        SCENE_MIDDLE(2),
        SCENE_LONG(3);

        private int mValue;

        SceneType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public enum StrategyType {
        STRATEGY_DYNAMIC_PRELOAD_DURATION(1);

        private int mValue;

        StrategyType(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    void clear();

    void enablePreloadStrategy(StrategyType strategyType, boolean z);

    String getCurrentUid();

    int getMaxPreloadMemorySizeMB();

    void removeSource(String str);

    void setMaxPreloadMemorySizeMB(int i);

    void setPreloadCount(int i);

    void setPreloadCount(int i, int i2);

    void setPreloadScene(SceneType sceneType);

    void setPreloadStrategy(StrategyType strategyType, String str);
}
