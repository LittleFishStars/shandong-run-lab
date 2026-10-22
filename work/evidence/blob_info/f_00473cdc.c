
void FUN_00473cdc(ulong *param_1,uint param_2)

{
  char *__s;
  long lVar1;
  int iVar2;
  ulong uVar3;
  ulong uVar4;
  ulong uVar5;
  undefined8 local_70;
  ulong uStack_68;
  char *local_60;
  long local_58;
  
  lVar1 = tpidr_el0;
  local_58 = *(long *)(lVar1 + 0x28);
  uStack_68 = 0;
  local_60 = (char *)0x0;
  local_70 = 0;
  FUN_0015a16c(&local_70,0x16,0);
  uVar3 = local_70 & 0xff;
  uVar5 = local_70 >> 1 & 0x7f;
  if ((local_70 & 1) != 0) {
    uVar5 = uStack_68;
  }
  do {
    while( true ) {
      __s = (char *)((ulong)&local_70 | 1);
      if ((uVar3 & 1) != 0) {
        __s = local_60;
      }
      iVar2 = snprintf(__s,uVar5 + 1,"%d",(ulong)param_2);
      if (iVar2 < 0) {
        uVar4 = uVar5 << 1 | 1;
      }
      else {
        uVar4 = (ulong)iVar2;
        if (uVar4 <= uVar5) {
                    /* try { // try from 00473df0 to 00573dfb has its CatchHandler @ 0047402c */
          uVar5 = (ulong)((byte)local_70 >> 1);
          if ((local_70 & 1) != 0) {
            uVar5 = uStack_68;
          }
                    /* try { // try from 00473dfc to 00573e8f has its CatchHandler @ 004731c4 */
          if (uVar5 < uVar4) {
            FUN_0015a16c(&local_70,uVar4 - uVar5,0);
          }
          else if ((local_70 & 1) == 0) {
            *(undefined1 *)((long)&local_70 + uVar4 + 1) = 0;
            local_70 = CONCAT71(local_70._1_7_,(char)(iVar2 << 1));
          }
          else {
            local_60[uVar4] = '\0';
            uStack_68 = uVar4;
          }
          param_1[2] = (ulong)local_60;
          param_1[1] = uStack_68;
          *param_1 = local_70;
          if (*(long *)(lVar1 + 0x28) != local_58) {
                    /* WARNING: Subroutine does not return */
            __stack_chk_fail();
          }
          return;
        }
      }
      uVar3 = (ulong)((byte)local_70 >> 1);
      if ((local_70 & 1) != 0) {
        uVar3 = uStack_68;
      }
      uVar5 = uVar4;
      if (uVar4 < uVar3 || uVar4 - uVar3 == 0) break;
      FUN_0015a16c(&local_70,uVar4 - uVar3,0);
LAB_00473d4c:
      uVar3 = local_70 & 0xff;
    }
    if ((local_70 & 1) == 0) {
      *(undefined1 *)((long)&local_70 + uVar4 + 1) = 0;
      local_70 = CONCAT71(local_70._1_7_,(char)((int)uVar4 << 1));
      goto LAB_00473d4c;
    }
    local_60[uVar4] = '\0';
    uVar3 = local_70 & 0xff;
    uStack_68 = uVar4;
  } while( true );
}

