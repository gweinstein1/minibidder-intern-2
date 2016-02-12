package com.dstillery.minibidder.model;

import java.util.Objects;

/**
 * Experiment id and sample rate spec.  In the simplified MiniBidder model, 
 * we assume all experiments are carried out on the backend and so we only
 * need to tag bid requests w/o worrying how that information is sent or used.  
 */
public class ExperimentTag {
	private final long id;
	private final double sampleRate;
	
	public ExperimentTag(long id, double sampleRate) {
		this.id = id;
		this.sampleRate = sampleRate;
	}
	
	public long getId() {
		return id;
	}
	
	public double getSampleRate() {
		return sampleRate;
	}
	
	public int hashCode() {
		return Objects.hash(id, sampleRate);
	}	
	
	public boolean equals(Object o) {
		if(o == null || !(o instanceof ExperimentTag)) {
			return false;
		}
		ExperimentTag that = (ExperimentTag)o;
		return Objects.equals(this.id, that.id)
		    && Objects.equals(this.sampleRate, that.sampleRate);
	}
}
