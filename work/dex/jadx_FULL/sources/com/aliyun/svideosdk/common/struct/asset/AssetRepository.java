package com.aliyun.svideosdk.common.struct.asset;

import android.graphics.Typeface;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AssetRepository {
    public static final int FEATURE_DOWNLOAD = 1;

    public enum Kind {
        SOUND,
        FILTER,
        MV,
        DIY,
        FONT,
        CAPTION,
        ALL
    }

    public void addListener(Kind kind, AssetRepositoryClient.Listener listener) {
    }

    public void attachClient(AssetRepositoryClient assetRepositoryClient) {
    }

    public void clearNew(Kind kind) {
    }

    public void detachClient(AssetRepositoryClient assetRepositoryClient) {
    }

    public abstract AssetInfo find(Kind kind, long j);

    public abstract List<? extends AssetInfo> find(Kind kind);

    public abstract Kind[] findCategory();

    public abstract List<? extends AssetGroup> findDIYCategory();

    public abstract List<? extends AssetGroup> findDIYCategory(int i);

    public abstract List<? extends AssetInfo> findDIYCategoryContent(int i);

    public RepositoryEditor getEditor() {
        return null;
    }

    public FontResolver getFontResolver() {
        return null;
    }

    public boolean onAssetUsed(AssetInfo assetInfo) {
        RepositoryEditor editor = getEditor();
        if (editor == null) {
            return false;
        }
        return editor.onAssetUsed(assetInfo);
    }

    public TypefaceConfig resolveTypeface(String str) {
        long j;
        Typeface typefaceByFont;
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            j = -1;
        }
        if (j < 0 || (typefaceByFont = getFontResolver().getTypefaceByFont(j)) == null) {
            return null;
        }
        return new TypefaceConfig(typefaceByFont);
    }

    public void updateAssetInfo(AssetInfo assetInfo) {
        RepositoryEditor editor = getEditor();
        if (editor == null) {
            return;
        }
        editor.updateAsset(assetInfo);
    }
}
