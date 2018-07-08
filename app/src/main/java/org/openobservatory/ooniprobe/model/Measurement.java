package org.openobservatory.ooniprobe.model;

import java.util.Date;

public class Measurement {
	public int id;
	public String name;
	public Date startTime;
	public double duration;
	public String ip;
	public String asn;
	public String asnName;
	public String country;
	public String networkName;
	public String networkType;
	public State state;
	public boolean anomaly;
	public Result result;
	public String reportId;
	public String input;
	public String category;

	public Measurement(Result result, String name) {
		this.result = result;
		this.name = name;
		startTime = new java.util.Date();
		state = State.FAILED;
	}

	public void save() {
	}

	public void deleteObject() {
		//TODO delete logFile and jsonFile
	}

	// The possible states of a measurements are:
	//  active, while the measurement is in progress
	//  done, when it's finished, but not necessarily uploaded
	//  uploaded, if it has been uploaded successfully
	//  processed, if the pipeline has processed the measurement
	public enum State {
		ACTIVE,
		FAILED,
		DONE,
		UPLOADED,
		PROCESSED
	}
}
