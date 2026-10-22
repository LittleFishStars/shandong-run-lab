package com.aliyun.svideosdk.common.struct.asset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AssetRepositoryClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetRepository f25657a;
    private final HashMap<AssetRepository.Kind, Listener> b = new HashMap<>();

    public interface Listener {
        void onDataChange(AssetRepositoryClient assetRepositoryClient, AssetRepository.Kind kind);
    }

    public AssetRepositoryClient(AssetRepository assetRepository) {
        this.f25657a = assetRepository;
    }

    public void addListener(AssetRepository.Kind kind, Listener listener) {
        this.b.put(kind, listener);
    }

    public void connect() {
        this.f25657a.attachClient(this);
    }

    public void disconnect() {
        this.f25657a.detachClient(this);
    }

    public List<? extends AssetInfo> find(AssetRepository.Kind kind) {
        return this.f25657a.find(kind);
    }

    public AssetRepository getRepository() {
        return this.f25657a;
    }

    public void onDataChange(AssetRepository.Kind kind) {
        if (kind != null && kind != AssetRepository.Kind.ALL) {
            Listener listener = this.b.get(kind);
            if (listener != null) {
                listener.onDataChange(this, kind);
                return;
            }
            return;
        }
        Iterator<Map.Entry<AssetRepository.Kind, Listener>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Listener value = it.next().getValue();
            if (value != null) {
                value.onDataChange(this, null);
            }
        }
    }
}
