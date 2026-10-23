import React, { useEffect, useState } from 'react';
import { Button, Input } from 'antd';
import MapCanvas from '../MapCanvas';
import Joystick from '../Joystick';
import { fmtPaceShort } from '../format';

export default function RunPage({ mapProps, walk, params, planDistance, actions }) {
  // 配速输入只在回车时生效：草稿存在本地，回车才交给 actions.setPace
  const [paceDraft, setPaceDraft] = useState((params && params.pace) || '');
  useEffect(() => { setPaceDraft((params && params.pace) || ''); }, [params && params.pace]);
  const st = (walk && walk.state) || {};
  const dist = Number(st.dist_m) || 0;
  const dur = Number(st.elapsed_sec || st.move_sec) || 0;
  // 配速 = 用时 / 距离（平均配速，和记录页口径一致）；刚起步距离太小时不显示
  const pace = (dist > 5 && dur > 0) ? dur / (dist / 1000) : 0;
  // 实时配速 = 当前速度换算（1 km 需要多少秒）
  const speed = Number(st.speed_mps) || 0;
  const livePace = speed > 0.1 ? 1000 / speed : 0;
  return (
    <div className="run-layout">
      <div className="map-card"><MapCanvas {...mapProps} /></div>
      <aside className="side-panel">
        <div className="live-stats">
          <div className="live-line"><span>距离</span><b>{dist.toFixed(0)} m</b></div>
          <div className="live-line"><span>计划距离</span><b>{Math.round(Number(planDistance) || 0)} m</b></div>
          <div className="live-line"><span>配速</span><b>{pace ? fmtPaceShort(pace) : '--'}</b></div>
          <div className="live-line"><span>实时配速</span><b>{livePace ? fmtPaceShort(livePace) : '--'}</b></div>
        </div>
        <div className="run-ctl">
          <Joystick onMove={actions.joystick} onEnd={actions.joystickEnd} />
        </div>
        <div className="run-pace">
          <span>配速</span>
          <Input
            value={paceDraft}
            placeholder={'6\'40"'}
            onChange={(e) => setPaceDraft(e.target.value)}
            onPressEnter={() => setPaceDraft(actions.setPace(paceDraft) || paceDraft)}
          />
        </div>
        <Button
          type="primary"
          shape="circle"
          className="btn-end"
          disabled={!walk || !walk.running}
          onClick={actions.endRun}
        >
          结束
        </Button>
      </aside>
    </div>
  );
}
