
void FUN_0034a644(char *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
                 long param_5)

{
  long lVar1;
  int iVar2;
  ulong uVar3;
  size_t sVar4;
  undefined8 uVar5;
  long lVar6;
  char *pcVar7;
  void *pvVar8;
  ulong local_a0;
  size_t local_98;
  void *local_90;
  ulong local_88;
  size_t local_80;
  void *local_78;
  undefined1 local_70;
  undefined1 local_6f;
  undefined1 local_6e;
  undefined1 local_6d;
  long local_68;
  
  lVar1 = tpidr_el0;
  local_68 = *(long *)(lVar1 + 0x28);
  pthread_rwlock_wrlock((pthread_rwlock_t *)&DAT_005d2690);
  if ((DAT_005d26c8 & 1) != 0) goto LAB_0034aaec;
  uVar3 = (**(code **)(*(long *)PTR_DAT_00577ea0 + 0x98))(param_1);
  if (uVar3 < 0x14) {
    uVar5 = FUN_0036aed4();
    FUN_0036b2c4(uVar5,param_2);
    uVar5 = FUN_0036aed4();
    local_a0 = 0;
    local_98 = 0;
    local_90 = (void *)0x0;
    sVar4 = strlen(param_1);
    if (0xffffffffffffffef < sVar4) {
                    /* WARNING: Subroutine does not return */
      FUN_0011ebc8(&local_a0);
    }
    if (sVar4 < 0x17) {
                    /* catch() { ... } // from try @ 0034a8c0 with catch @ 0034a918 */
      pvVar8 = (void *)((ulong)&local_a0 | 1);
      local_a0 = CONCAT71(local_a0._1_7_,(char)(sVar4 << 1));
      if (sVar4 != 0) goto LAB_0034a998;
    }
    else {
      uVar3 = sVar4 + 0x10 & 0xfffffffffffffff0;
      pvVar8 = (void *)FUN_004780a8(uVar3);
      local_a0 = uVar3 | 1;
      local_98 = sVar4;
      local_90 = pvVar8;
LAB_0034a998:
      memcpy(pvVar8,param_1,sVar4);
    }
    *(undefined1 *)((long)pvVar8 + sVar4) = 0;
    FUN_002df3ec(&local_88,&local_a0);
    thunk_FUN_00130e04(uVar5,&local_88);
    if (((byte)local_88 & 1) != 0) {
      FUN_00478110(local_78);
    }
    if ((local_a0 & 1) != 0) {
      FUN_00478110(local_90);
    }
    uVar5 = FUN_0036aed4();
    lVar6 = 0;
    pcVar7 = (char *)((ulong)&local_a0 | 4);
    local_a0 = 0x2e3334330000005a;
    do {
      pcVar7[lVar6] = pcVar7[lVar6] ^ 0x5a;
      lVar6 = lVar6 + 1;
    } while (lVar6 != 4);
    local_98 = local_98 & 0xffffffffffffff00;
    local_80 = 0;
    local_78 = (void *)0x0;
    local_88 = 0;
    sVar4 = strlen(pcVar7);
    if (0xffffffffffffffef < sVar4) {
                    /* WARNING: Subroutine does not return */
      FUN_0011ebc8(&local_88);
    }
    if (sVar4 < 0x17) {
      pvVar8 = (void *)((ulong)&local_88 | 1);
      local_88 = CONCAT71(local_88._1_7_,(char)(sVar4 << 1));
      if (sVar4 != 0) goto LAB_0034aa9c;
    }
    else {
      uVar3 = sVar4 + 0x10 & 0xfffffffffffffff0;
      pvVar8 = (void *)FUN_004780a8(uVar3);
      local_88 = uVar3 | 1;
      local_80 = sVar4;
      local_78 = pvVar8;
LAB_0034aa9c:
      memcpy(pvVar8,pcVar7,sVar4);
    }
    *(undefined1 *)((long)pvVar8 + sVar4) = 0;
    FUN_0036b93c(uVar5,&local_88);
    if ((local_88 & 1) != 0) {
      FUN_00478110(local_78);
    }
    if (param_5 != 0) {
      lVar6 = FUN_0036aed4();
      *(long *)(lVar6 + 0x160) = param_5;
    }
    FUN_00348470(param_3,param_4);
    DAT_005d26c8 = 1;
    goto LAB_0034aaec;
  }
  lVar6 = 0;
  local_88 = 0x4943595a0000002a;
  local_80 = 0x5759465c11444c5b;
  local_78 = (void *)0x5a59575650184553;
  local_70 = 0x5f;
  local_6f = 0x53;
  pcVar7 = (char *)((ulong)&local_88 | 4);
  local_6e = 0x60;
  do {
    pcVar7[lVar6] = pcVar7[lVar6] ^ (char)lVar6 + 0x2aU;
    lVar6 = lVar6 + 1;
  } while (lVar6 != 0x17);
  local_6d = 0;
  local_98 = 0;
  local_90 = (void *)0x0;
  local_a0 = 0;
  sVar4 = strlen(pcVar7);
  if (0xffffffffffffffef < sVar4) {
                    /* WARNING: Subroutine does not return */
    FUN_0011ebc8(&local_a0);
  }
  if (sVar4 < 0x17) {
                    /* try { // try from 0034a8c0 to 0044a8cf has its CatchHandler @ 0034a918 */
    pvVar8 = (void *)((ulong)&local_a0 | 1);
    local_a0 = CONCAT71(local_a0._1_7_,(char)(sVar4 << 1));
                    /* try { // try from 0034a8d0 to 0044a933 has its CatchHandler @ 0034a51c */
    if (sVar4 != 0) goto LAB_0034a948;
  }
  else {
    uVar3 = sVar4 + 0x10 & 0xfffffffffffffff0;
                    /* try { // try from 0034a934 to 0044ab07 has its CatchHandler @ 0034a934
                       catch() { ... } // from try @ 0034a934 with catch @ 0034a934
                       catch() { ... } // from try @ 0034ab18 with catch @ 0034a934 */
    pvVar8 = (void *)FUN_004780a8(uVar3);
    local_a0 = uVar3 | 1;
    local_98 = sVar4;
    local_90 = pvVar8;
LAB_0034a948:
    memcpy(pvVar8,pcVar7,sVar4);
  }
  *(undefined1 *)((long)pvVar8 + sVar4) = 0;
  FUN_00336420(&local_a0);
  if ((local_a0 & 1) != 0) {
    FUN_00478110(local_90);
  }
LAB_0034aaec:
  iVar2 = pthread_rwlock_unlock((pthread_rwlock_t *)&DAT_005d2690);
  if (*(long *)(lVar1 + 0x28) != local_68) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail(iVar2);
  }
                    /* try { // try from 0034ab08 to 0044ab17 has its CatchHandler @ 0034ab60 */
                    /* try { // try from 0034ab18 to 0044ab7b has its CatchHandler @ 0034a934 */
  return;
}

