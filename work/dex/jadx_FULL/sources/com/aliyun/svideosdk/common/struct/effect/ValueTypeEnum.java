package com.aliyun.svideosdk.common.struct.effect;

import android.util.Log;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public enum ValueTypeEnum {
    INT,
    FLOAT,
    VEC1I,
    VEC2I,
    VEC3I,
    VEC4I,
    VEC1F,
    VEC2F,
    VEC3F,
    VEC4F,
    SCA1I,
    SCA2I,
    SCA3I,
    SCA4I,
    SCA1F,
    SCA2F,
    SCA3F,
    SCA4F,
    MAT3F,
    MAT4F;

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.struct.effect.ValueTypeEnum$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25670a;

        static {
            int[] iArr = new int[ValueTypeEnum.values().length];
            f25670a = iArr;
            try {
                iArr[ValueTypeEnum.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25670a[ValueTypeEnum.MAT3F.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25670a[ValueTypeEnum.MAT4F.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25670a[ValueTypeEnum.SCA1F.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25670a[ValueTypeEnum.SCA2F.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25670a[ValueTypeEnum.SCA3F.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25670a[ValueTypeEnum.SCA4F.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25670a[ValueTypeEnum.VEC1F.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25670a[ValueTypeEnum.VEC2F.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25670a[ValueTypeEnum.VEC3F.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25670a[ValueTypeEnum.VEC4F.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f25670a[ValueTypeEnum.INT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f25670a[ValueTypeEnum.SCA1I.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f25670a[ValueTypeEnum.SCA2I.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f25670a[ValueTypeEnum.SCA3I.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f25670a[ValueTypeEnum.SCA4I.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f25670a[ValueTypeEnum.VEC1I.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f25670a[ValueTypeEnum.VEC2I.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f25670a[ValueTypeEnum.VEC3I.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f25670a[ValueTypeEnum.VEC4I.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public static class Value<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ValueTypeEnum f25671a;
        private T[] b;

        public Value(ValueTypeEnum valueTypeEnum, T[] tArr) {
            this.b = tArr;
            this.f25671a = valueTypeEnum;
        }

        private void a() {
            Log.e("AliYunLog", "ValueTypeEnum.Value updateValue failure!");
        }

        public ValueTypeEnum getType() {
            return this.f25671a;
        }

        public T[] getValue() {
            return this.b;
        }

        public void updateFLOAT(Float f) {
            T[] tArr = this.b;
            if (tArr.length == 1 && this.f25671a == ValueTypeEnum.FLOAT) {
                tArr[0] = f;
            } else {
                a();
            }
        }

        public void updateINT(Integer num) {
            T[] tArr = this.b;
            if (tArr.length == 1 && this.f25671a == ValueTypeEnum.INT) {
                tArr[0] = num;
            } else {
                a();
            }
        }

        public void updateMAT3F(Float f, Float f2, Float f3) {
            T[] tArr = this.b;
            if (tArr.length != 3 || this.f25671a != ValueTypeEnum.MAT3F) {
                a();
                return;
            }
            tArr[0] = f;
            tArr[1] = f2;
            tArr[2] = f3;
        }

        public void updateMAT4F(Float f, Float f2, Float f3, Float f4) {
            T[] tArr = this.b;
            if (tArr.length != 4 || this.f25671a != ValueTypeEnum.MAT4F) {
                a();
                return;
            }
            tArr[0] = f;
            tArr[1] = f2;
            tArr[2] = f3;
            tArr[3] = f4;
        }

        public void updateSCA1F(Float f) {
            T[] tArr = this.b;
            if (tArr.length == 1 && this.f25671a == ValueTypeEnum.SCA1F) {
                tArr[0] = f;
            } else {
                a();
            }
        }

        public void updateSCA1I(Integer num) {
            T[] tArr = this.b;
            if (tArr.length == 1 && this.f25671a == ValueTypeEnum.SCA1I) {
                tArr[0] = num;
            } else {
                a();
            }
        }

        public void updateSCA2F(Float f, Float f2) {
            T[] tArr = this.b;
            if (tArr.length != 2 || this.f25671a != ValueTypeEnum.SCA2F) {
                a();
            } else {
                tArr[0] = f;
                tArr[1] = f2;
            }
        }

        public void updateSCA2I(Integer num, Integer num2) {
            T[] tArr = this.b;
            if (tArr.length != 2 || this.f25671a != ValueTypeEnum.SCA2I) {
                a();
            } else {
                tArr[0] = num;
                tArr[1] = num2;
            }
        }

        public void updateSCA3F(Float f, Float f2, Float f3) {
            T[] tArr = this.b;
            if (tArr.length != 3 || this.f25671a != ValueTypeEnum.SCA3F) {
                a();
                return;
            }
            tArr[0] = f;
            tArr[1] = f2;
            tArr[2] = f3;
        }

        public void updateSCA3I(Integer num, Integer num2, Integer num3) {
            T[] tArr = this.b;
            if (tArr.length != 3 || this.f25671a != ValueTypeEnum.SCA3I) {
                a();
                return;
            }
            tArr[0] = num;
            tArr[1] = num2;
            tArr[2] = num3;
        }

        public void updateSCA4F(Float f, Float f2, Float f3, Float f4) {
            T[] tArr = this.b;
            if (tArr.length != 4 || this.f25671a != ValueTypeEnum.SCA4F) {
                a();
                return;
            }
            tArr[0] = f;
            tArr[1] = f2;
            tArr[2] = f3;
            tArr[3] = f4;
        }

        public void updateSCA4I(Integer num, Integer num2, Integer num3, Integer num4) {
            T[] tArr = this.b;
            if (tArr.length != 4 || this.f25671a != ValueTypeEnum.SCA4I) {
                a();
                return;
            }
            tArr[0] = num;
            tArr[1] = num2;
            tArr[2] = num3;
            tArr[3] = num4;
        }

        public void updateVEC1F(Float f) {
            T[] tArr = this.b;
            if (tArr.length == 1 && this.f25671a == ValueTypeEnum.VEC1F) {
                tArr[0] = f;
            } else {
                a();
            }
        }

        public void updateVEC1I(Integer num) {
            T[] tArr = this.b;
            if (tArr.length == 1 && this.f25671a == ValueTypeEnum.VEC1I) {
                tArr[0] = num;
            } else {
                a();
            }
        }

        public void updateVEC2F(Float f, Float f2) {
            T[] tArr = this.b;
            if (tArr.length != 2 || this.f25671a != ValueTypeEnum.VEC2F) {
                a();
            } else {
                tArr[0] = f;
                tArr[1] = f2;
            }
        }

        public void updateVEC2I(Integer num, Integer num2) {
            T[] tArr = this.b;
            if (tArr.length != 2 || this.f25671a != ValueTypeEnum.VEC2I) {
                a();
            } else {
                tArr[0] = num;
                tArr[1] = num2;
            }
        }

        public void updateVEC3F(Float f, Float f2, Float f3) {
            T[] tArr = this.b;
            if (tArr.length != 3 || this.f25671a != ValueTypeEnum.VEC3F) {
                a();
                return;
            }
            tArr[0] = f;
            tArr[1] = f2;
            tArr[2] = f3;
        }

        public void updateVEC3I(Integer num, Integer num2, Integer num3) {
            T[] tArr = this.b;
            if (tArr.length != 3 || this.f25671a != ValueTypeEnum.VEC3I) {
                a();
                return;
            }
            tArr[0] = num;
            tArr[1] = num2;
            tArr[2] = num3;
        }

        public void updateVEC4F(Float f, Float f2, Float f3, Float f4) {
            T[] tArr = this.b;
            if (tArr.length != 4 || this.f25671a != ValueTypeEnum.VEC4F) {
                a();
                return;
            }
            tArr[0] = f;
            tArr[1] = f2;
            tArr[2] = f3;
            tArr[3] = f4;
        }

        public void updateVEC4I(Integer num, Integer num2, Integer num3, Integer num4) {
            T[] tArr = this.b;
            if (tArr.length != 4 || this.f25671a != ValueTypeEnum.VEC4I) {
                a();
                return;
            }
            tArr[0] = num;
            tArr[1] = num2;
            tArr[2] = num3;
            tArr[3] = num4;
        }

        public void updateValue(T... tArr) {
            if (tArr.length != this.b.length) {
                a();
            } else {
                this.b = tArr;
            }
        }
    }

    public static Value getValue(String str, Object[] objArr) {
        Value value;
        ValueTypeEnum valueTypeEnumTypeOf = typeOf(str);
        int i = 0;
        Object[] objArr2 = null;
        switch (AnonymousClass1.f25670a[valueTypeEnumTypeOf.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                if (objArr != null) {
                    objArr2 = new Float[objArr.length];
                    while (i < objArr.length) {
                        objArr2[i] = Float.valueOf(((Double) objArr[i]).floatValue());
                        i++;
                    }
                }
                value = new Value(valueTypeEnumTypeOf, objArr2);
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                if (objArr != null) {
                    objArr2 = new Integer[objArr.length];
                    while (i < objArr.length) {
                        objArr2[i] = Integer.valueOf(((Double) objArr[i]).intValue());
                        i++;
                    }
                }
                value = new Value(valueTypeEnumTypeOf, objArr2);
                break;
            default:
                return null;
        }
        return value;
    }

    public static ValueTypeEnum typeOf(String str) {
        return valueOf(str.toUpperCase());
    }
}
