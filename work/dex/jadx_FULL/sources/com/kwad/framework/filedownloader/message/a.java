package com.kwad.framework.filedownloader.message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface a {

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.message.a$a, reason: collision with other inner class name */
    public static class C1259a extends MessageSnapshot implements a {
        private final MessageSnapshot aCs;

        public C1259a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.AH() != -3) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.AH())));
            }
            this.aCs = messageSnapshot;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte AH() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot CJ() {
            return this.aCs;
        }
    }

    MessageSnapshot CJ();
}
