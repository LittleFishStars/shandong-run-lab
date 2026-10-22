package com.amap.api.maps.model.particle;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ParticleOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ParticleOverlayOptions options;

    public ParticleOverlay(IGlOverlayLayer iGlOverlayLayer, ParticleOverlayOptions particleOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = particleOverlayOptions;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentParticleNum() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.getCurrentParticleNum(this.overlayName);
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setDuration(long j) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setDuration(j);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoop(boolean z) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setLoop(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxParticles(int i) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setMaxParticles(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleEmission(ParticleEmissionModule particleEmissionModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleEmissionModule(particleEmissionModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleLifeTime(long j) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleLifeTime(j);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleShapeModule(particleShapeModule);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartSpeed(velocityGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartColor(ColorGenerate colorGenerate) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setParticleStartColor(colorGenerate);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartParticleSize(int i, int i2) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setStartParticleSize(i, i2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            ParticleOverlayOptions particleOverlayOptions = this.options;
            if (particleOverlayOptions != null) {
                particleOverlayOptions.setVisible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
