
void FUN_00178b60(undefined8 *param_1,undefined8 param_2,long param_3)

{
  long lVar1;
  long lVar2;
  size_t sVar3;
  int iVar4;
  char *pcVar5;
  char *pcVar6;
  long lVar7;
  char cVar8;
  ldiv_t lVar9;
  undefined8 local_c0;
  undefined8 uStack_b8;
  undefined6 uStack_b0;
  undefined2 local_aa;
  undefined6 uStack_a8;
  char acStack_5e [6];
  long local_58;
  
  pcVar6 = (char *)&local_c0;
  lVar1 = tpidr_el0;
  local_58 = *(long *)(lVar1 + 0x28);
  *param_1 = 0;
  param_1[1] = 0;
  param_1[2] = 0;
  local_c0 = 0;
  uStack_b8 = 0;
  uStack_a8 = 0;
  uStack_b0 = 0;
  local_aa = 0;
  acStack_5e[2] = 0;
  if (param_3 < 0) {
    pcVar6 = (char *)((ulong)&local_c0 | 1);
    param_3 = -param_3;
    local_c0 = 0x2d;
  }
  if (param_3 == 0) {
    pcVar5 = acStack_5e;
    acStack_5e[1] = 0x30;
    iVar4 = 2;
  }
  else {
    lVar2 = 0;
    do {
      lVar7 = lVar2;
      lVar9 = ldiv(param_3,10);
      param_3 = lVar9.quot;
      cVar8 = '7';
      if (lVar9.rem < 10) {
        cVar8 = '0';
      }
      acStack_5e[lVar7 + 1] = cVar8 + (char)lVar9.rem;
      lVar2 = lVar7 + -1;
    } while (param_3 != 0);
    iVar4 = 1 - (int)(lVar7 + -1);
    pcVar5 = acStack_5e + lVar7;
  }
  iVar4 = iVar4 + 1;
  do {
    pcVar5 = pcVar5 + 1;
    iVar4 = iVar4 + -1;
    *pcVar6 = *pcVar5;
    pcVar6 = pcVar6 + 1;
  } while (1 < iVar4);
  sVar3 = strlen((char *)&local_c0);
  FUN_0011ff98(param_1,&local_c0,sVar3);
  if (*(long *)(lVar1 + 0x28) == local_58) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}

