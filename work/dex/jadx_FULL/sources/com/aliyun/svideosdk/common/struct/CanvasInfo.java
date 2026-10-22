package com.aliyun.svideosdk.common.struct;

import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import com.aliyun.svideosdk.common.struct.project.CanvasAction;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CanvasInfo implements Serializable {
    public static String mSavePath = "/sdcard/pathinfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<SerInfo> f25654a = new ArrayList();
    private SerInfo b;

    public class SerInfo implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25655a;
        private float b;
        private List<SerPoint> c = new ArrayList();

        public SerInfo() {
        }

        public SerInfo convertCoordinate(int i, int i2, boolean z) {
            SerInfo serInfo = CanvasInfo.this.new SerInfo();
            serInfo.f25655a = this.f25655a;
            float f = this.b;
            float f2 = i;
            serInfo.b = z ? f * f2 : f / f2;
            for (SerPoint serPoint : this.c) {
                List<SerPoint> list = serInfo.c;
                CanvasInfo canvasInfo = CanvasInfo.this;
                float f3 = serPoint.x;
                float f4 = i;
                list.add(z ? new SerPoint(canvasInfo, f3 * f4, serPoint.y * i2) : new SerPoint(canvasInfo, f3 / f4, serPoint.y / i2));
            }
            return serInfo;
        }
    }

    public class SerPoint implements Serializable {
        public float x;
        public float y;

        public SerPoint(CanvasInfo canvasInfo, float f, float f2) {
            this.x = f;
            this.y = f2;
        }
    }

    private Paint a(SerInfo serInfo) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(serInfo.b);
        paint.setColor(serInfo.f25655a);
        return paint;
    }

    private Path b(SerInfo serInfo) {
        Path path = new Path();
        int size = serInfo.c.size();
        if (size < 3) {
            return path;
        }
        SerPoint serPoint = (SerPoint) serInfo.c.get(0);
        path.moveTo(serPoint.x, serPoint.y);
        float f = serPoint.x;
        float f2 = serPoint.y;
        int i = 1;
        while (true) {
            int i2 = size - 1;
            if (i >= i2) {
                SerPoint serPoint2 = (SerPoint) serInfo.c.get(i2);
                path.lineTo(serPoint2.x, serPoint2.y);
                return path;
            }
            SerPoint serPoint3 = (SerPoint) serInfo.c.get(i);
            path.quadTo(f, f2, (serPoint3.x + f) / 2.0f, (serPoint3.y + f2) / 2.0f);
            f = serPoint3.x;
            f2 = serPoint3.y;
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf A[PHI: r0 r1
      0x00cf: PHI (r0v17 ??) = (r0v10 ??), (r0v13 ??), (r0v16 ??), (r0v21 ??) binds: [B:41:0x007f, B:51:0x0097, B:71:0x00c7, B:61:0x00af] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r1v17 com.aliyun.svideosdk.common.struct.CanvasInfo) = 
      (r1v14 com.aliyun.svideosdk.common.struct.CanvasInfo)
      (r1v15 com.aliyun.svideosdk.common.struct.CanvasInfo)
      (r1v16 com.aliyun.svideosdk.common.struct.CanvasInfo)
      (r1v19 com.aliyun.svideosdk.common.struct.CanvasInfo)
     binds: [B:41:0x007f, B:51:0x0097, B:71:0x00c7, B:61:0x00af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:84:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r5v1 */
    public static CanvasInfo load() throws Throwable {
        CanvasInfo canvasInfo;
        ClassNotFoundException e;
        CanvasInfo canvasInfo2;
        IOException e2;
        StreamCorruptedException e3;
        FileNotFoundException e4;
        ?? objectInputStream;
        Throwable th;
        ?? r0;
        ?? r1 = 0;
        CanvasInfo canvasInfo3 = null;
        CanvasInfo canvasInfo4 = null;
        CanvasInfo canvasInfo5 = null;
        CanvasInfo canvasInfo6 = null;
        ?? r2 = 0;
        ?? r3 = 0;
        ?? r4 = 0;
        ?? r5 = 0;
        ?? r6 = 0;
        try {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(mSavePath));
                try {
                    canvasInfo = (CanvasInfo) objectInputStream.readObject();
                    try {
                        Log.i("CanvasInfo", "load ok, size = " + canvasInfo.f25654a.size());
                        try {
                            objectInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    } catch (FileNotFoundException e6) {
                        e4 = e6;
                        canvasInfo3 = canvasInfo;
                        canvasInfo2 = canvasInfo3;
                        r2 = objectInputStream;
                        e4.printStackTrace();
                        r0 = r2;
                        if (r2 != 0) {
                            try {
                                r2.close();
                                r0 = r2;
                            } catch (IOException e7) {
                                e7.printStackTrace();
                                r0 = e7;
                            }
                        }
                        if (canvasInfo2 == null) {
                            canvasInfo = new CanvasInfo();
                            r1 = r0;
                        } else {
                            canvasInfo = canvasInfo2;
                            r1 = r0;
                        }
                    } catch (StreamCorruptedException e8) {
                        e3 = e8;
                        canvasInfo4 = canvasInfo;
                        canvasInfo2 = canvasInfo4;
                        r3 = objectInputStream;
                        e3.printStackTrace();
                        r0 = r3;
                        if (r3 != 0) {
                            try {
                                r3.close();
                                r0 = r3;
                            } catch (IOException e9) {
                                e9.printStackTrace();
                                r0 = e9;
                            }
                        }
                        if (canvasInfo2 == null) {
                            canvasInfo = new CanvasInfo();
                            r1 = r0;
                        } else {
                            canvasInfo = canvasInfo2;
                            r1 = r0;
                        }
                    } catch (IOException e10) {
                        e2 = e10;
                        canvasInfo5 = canvasInfo;
                        canvasInfo2 = canvasInfo5;
                        r4 = objectInputStream;
                        e2.printStackTrace();
                        r0 = r4;
                        if (r4 != 0) {
                            try {
                                r4.close();
                                r0 = r4;
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                r0 = e11;
                            }
                        }
                        if (canvasInfo2 == null) {
                            canvasInfo = new CanvasInfo();
                            r1 = r0;
                        } else {
                            canvasInfo = canvasInfo2;
                            r1 = r0;
                        }
                    } catch (ClassNotFoundException e12) {
                        e = e12;
                        canvasInfo6 = canvasInfo;
                        canvasInfo2 = canvasInfo6;
                        r5 = objectInputStream;
                        e.printStackTrace();
                        r0 = r5;
                        if (r5 != 0) {
                            try {
                                r5.close();
                                r0 = r5;
                            } catch (IOException e13) {
                                e13.printStackTrace();
                                r0 = e13;
                            }
                        }
                        if (canvasInfo2 == null) {
                            canvasInfo = new CanvasInfo();
                            r1 = r0;
                        } else {
                            canvasInfo = canvasInfo2;
                            r1 = r0;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        ?? r7 = objectInputStream;
                        th = th;
                        r6 = r7;
                        if (r6 != 0) {
                            try {
                                r6.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                        }
                        if (canvasInfo == null) {
                            throw th;
                        }
                        new CanvasInfo();
                        throw th;
                    }
                } catch (FileNotFoundException e15) {
                    e4 = e15;
                } catch (StreamCorruptedException e16) {
                    e3 = e16;
                } catch (IOException e17) {
                    e2 = e17;
                } catch (ClassNotFoundException e18) {
                    e = e18;
                } catch (Throwable th3) {
                    canvasInfo = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                CanvasInfo canvasInfo7 = canvasInfo2;
                objectInputStream = r1;
                th = th4;
                canvasInfo = canvasInfo7;
            }
        } catch (FileNotFoundException e19) {
            e4 = e19;
            canvasInfo2 = null;
        } catch (StreamCorruptedException e20) {
            e3 = e20;
            canvasInfo2 = null;
        } catch (IOException e21) {
            e2 = e21;
            canvasInfo2 = null;
        } catch (ClassNotFoundException e22) {
            e = e22;
            canvasInfo2 = null;
        } catch (Throwable th5) {
            th = th5;
            canvasInfo = null;
            if (r6 != 0) {
                r6.close();
            }
            if (canvasInfo == null) {
                throw th;
            }
            new CanvasInfo();
            throw th;
        }
        return canvasInfo;
    }

    public void clean() {
        this.f25654a.clear();
    }

    public CanvasInfo convertCoordinate(int i, int i2, boolean z) {
        CanvasInfo canvasInfo = new CanvasInfo();
        SerInfo serInfo = this.b;
        if (serInfo != null) {
            canvasInfo.b = serInfo.convertCoordinate(i, i2, z);
        }
        Iterator<SerInfo> it = this.f25654a.iterator();
        while (it.hasNext()) {
            canvasInfo.f25654a.add(it.next().convertCoordinate(i, i2, z));
        }
        return canvasInfo;
    }

    public void lineEnd(float f, float f2, Paint paint) {
        this.b.c.add(new SerPoint(this, f, f2));
        this.b.f25655a = paint.getColor();
        this.b.b = paint.getStrokeWidth();
        this.f25654a.add(this.b);
    }

    public void lineMove(float f, float f2) {
        this.b.c.add(new SerPoint(this, f, f2));
    }

    public void lineStart(float f, float f2) {
        SerInfo serInfo = new SerInfo();
        this.b = serInfo;
        serInfo.c.add(new SerPoint(this, f, f2));
    }

    public void remove() {
        List<SerInfo> list = this.f25654a;
        if (list == null || list.size() <= 0) {
            return;
        }
        List<SerInfo> list2 = this.f25654a;
        list2.remove(list2.size() - 1);
    }

    public void resore(CanvasInfo canvasInfo) {
        List<SerInfo> list = canvasInfo.f25654a;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f25654a.addAll(0, canvasInfo.f25654a);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void save() throws Throwable {
        ObjectOutputStream objectOutputStream;
        IOException e;
        FileNotFoundException e2;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(mSavePath));
                try {
                    objectOutputStream.writeObject(this);
                    Log.i("CanvasInfo", "save ok, size = " + this.f25654a.size());
                } catch (FileNotFoundException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (objectOutputStream == null) {
                        return;
                    }
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (objectOutputStream == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                ObjectOutputStream objectOutputStream3 = objectOutputStream;
                th = th;
                objectOutputStream2 = objectOutputStream3;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            objectOutputStream = null;
            e2 = e6;
        } catch (IOException e7) {
            objectOutputStream = null;
            e = e7;
        } catch (Throwable th2) {
            th = th2;
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
            }
            throw th;
        }
        try {
            objectOutputStream.close();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    public List<CanvasAction> transfer() {
        ArrayList arrayList = new ArrayList();
        for (SerInfo serInfo : this.f25654a) {
            arrayList.add(new CanvasAction(a(serInfo), b(serInfo)));
        }
        return arrayList;
    }
}
