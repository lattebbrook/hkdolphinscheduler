package com.example.hk.hkdolphinscheduler.estate;

import org.springframework.stereotype.Component;

@Component
public class StateManager {
	
	public EState state;
	
	public void idle() {
		this.state = EState.HK_STATE_IDLE;
	}
	
	public void read() {
		this.state = EState.HK_STATE_READ;
	}
	
	public void query() {
		this.state = EState.HK_STATE_QUERY;
	}
	
	public EState getState() {
		return state;
	}

	@Override
	public String toString() {
		return "StateManager [state=" + state + "]";
	}	
}

