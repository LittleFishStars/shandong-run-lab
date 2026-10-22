package com.alibaba.ariver.kernel.api.bytedata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class ByteArrayPools {

    public static class ByteArray127Pool extends ByteArrayPool {
        public ByteArray127Pool() {
            super();
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[127];
        }
    }

    public static class ByteArray2Pool extends ByteArrayPool {
        public ByteArray2Pool() {
            super();
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[2];
        }
    }

    public static class ByteArray4Pool extends ByteArrayPool {
        public ByteArray4Pool() {
            super();
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[4];
        }
    }

    public static class ByteArray8Pool extends ByteArrayPool {
        public ByteArray8Pool() {
            super();
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[8];
        }
    }

    public static abstract class ByteArrayPool extends Pool<byte[]> {
        private ByteArrayPool() {
            super(1, 8);
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public synchronized void free(byte[] bArr) {
            super.free(bArr);
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public synchronized byte[] obtain() {
            return (byte[]) super.obtain();
        }
    }
}
