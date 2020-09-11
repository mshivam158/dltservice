package com.dlt.schedularsvcs;

import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class SystemSchedular {
	//runs once in a day.
	public void updateOpsHrsDaily() {
		//The ops hours is automatically updated everyday as: (Today Date–Commission Date) X 24 X Duty
		//	Cycle
	}
}
