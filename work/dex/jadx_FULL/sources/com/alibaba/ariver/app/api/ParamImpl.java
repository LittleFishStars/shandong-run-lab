package com.alibaba.ariver.app.api;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParamImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23817a;
    private String b;
    private RVParams.ParamType c;
    private Object d;
    private boolean e;

    public ParamImpl(String str, String str2, RVParams.ParamType paramType, Object obj) {
        this.f23817a = str;
        this.b = str2;
        this.c = paramType;
        this.d = obj;
    }

    public String getLongName() {
        return this.f23817a;
    }

    public String getShortName() {
        return this.b;
    }

    public RVParams.ParamType getType() {
        return this.c;
    }

    public void setDefaultValue(Object obj) {
        this.d = obj;
    }

    public void setType(RVParams.ParamType paramType) {
        this.c = paramType;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0052  */
    public Bundle unify(Bundle bundle, boolean z) {
        if (!z && !bundle.containsKey(this.f23817a) && !bundle.containsKey(this.b)) {
            return bundle;
        }
        RVParams.ParamType paramType = RVParams.ParamType.BOOLEAN;
        RVParams.ParamType paramType2 = this.c;
        Object obj = null;
        if (paramType == paramType2) {
            boolean zBooleanValue = ((Boolean) this.d).booleanValue();
            if (bundle.containsKey(this.b)) {
                obj = bundle.get(this.b);
            } else if (bundle.containsKey(this.f23817a)) {
                obj = bundle.get(this.f23817a);
            }
            if (obj instanceof String) {
                String strTrim = ((String) obj).trim();
                if ("YES".equalsIgnoreCase(strTrim)) {
                    zBooleanValue = true;
                } else if ("NO".equalsIgnoreCase(strTrim) || AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(strTrim)) {
                    zBooleanValue = false;
                } else if ("true".equalsIgnoreCase(strTrim)) {
                    zBooleanValue = true;
                }
            } else if (obj instanceof Boolean) {
                zBooleanValue = ((Boolean) obj).booleanValue();
            }
            bundle.putBoolean(this.f23817a, zBooleanValue);
        } else if (RVParams.ParamType.STRING == paramType2) {
            String stringOnly = (String) this.d;
            if (bundle.containsKey(this.b)) {
                stringOnly = BundleUtils.getStringOnly(bundle, this.b, stringOnly);
            } else if (bundle.containsKey(this.f23817a)) {
                stringOnly = BundleUtils.getStringOnly(bundle, this.f23817a, stringOnly);
            }
            if (stringOnly != null) {
                stringOnly = stringOnly.trim();
            }
            bundle.putString(this.f23817a, stringOnly);
        } else if (RVParams.ParamType.INT.equals(paramType2)) {
            Integer numValueOf = (Integer) this.d;
            if (bundle.containsKey(this.b)) {
                obj = bundle.get(this.b);
            } else if (bundle.containsKey(this.f23817a)) {
                obj = bundle.get(this.f23817a);
            }
            if (obj instanceof String) {
                String strTrim2 = ((String) obj).trim();
                if (!TextUtils.isEmpty(strTrim2)) {
                    if (this.e) {
                        Integer colorInt = TypeUtils.parseColorInt(strTrim2);
                        if (colorInt != null) {
                            numValueOf = colorInt;
                        }
                    } else {
                        numValueOf = Integer.valueOf(TypeUtils.parseInt(strTrim2));
                    }
                }
            } else if (obj instanceof Integer) {
                numValueOf = (Integer) obj;
            }
            if (numValueOf != null) {
                bundle.putInt(this.f23817a, numValueOf.intValue());
            }
        } else if (RVParams.ParamType.DOUBLE.equals(this.c)) {
            double dIntValue = ((Integer) this.d).intValue();
            if (bundle.containsKey(this.b)) {
                obj = bundle.get(this.b);
            } else if (bundle.containsKey(this.f23817a)) {
                obj = bundle.get(this.f23817a);
            }
            if (obj instanceof String) {
                dIntValue = TypeUtils.parseDouble(((String) obj).trim());
            } else if (obj instanceof Double) {
                dIntValue = ((Double) obj).doubleValue();
            }
            bundle.putDouble(this.f23817a, dIntValue);
        }
        if (!TextUtils.equals(this.f23817a, this.b)) {
            bundle.remove(this.b);
        }
        return bundle;
    }

    public ParamImpl(String str, String str2, boolean z, RVParams.ParamType paramType, Object obj) {
        this.f23817a = str;
        this.b = str2;
        this.c = paramType;
        this.d = obj;
        this.e = z;
    }
}
