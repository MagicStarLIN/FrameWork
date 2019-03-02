package com.lcl.pojo;

import com.lcl.pojo.JobLevel;

public class JobLevel {
	
	private String jobLevel;
	private Double lowestSal;
	private Double highestSal;
	
	public JobLevel() {
		super();
	}

	public JobLevel(String jobLevel, Double lowestSal, Double highestSal) {
		super();
		this.jobLevel = jobLevel;
		this.lowestSal = lowestSal;
		this.highestSal = highestSal;
	}

	public String getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	public Double getLowestSal() {
		return lowestSal;
	}

	public void setLowestSal(Double lowestSal) {
		this.lowestSal = lowestSal;
	}

	public Double getHighestSal() {
		return highestSal;
	}

	public void setHighestSal(Double highestSal) {
		this.highestSal = highestSal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((highestSal == null) ? 0 : highestSal.hashCode());
		result = prime * result + ((jobLevel == null) ? 0 : jobLevel.hashCode());
		result = prime * result + ((lowestSal == null) ? 0 : lowestSal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobLevel other = (JobLevel) obj;
		if (highestSal == null) {
			if (other.highestSal != null)
				return false;
		} else if (!highestSal.equals(other.highestSal))
			return false;
		if (jobLevel == null) {
			if (other.jobLevel != null)
				return false;
		} else if (!jobLevel.equals(other.jobLevel))
			return false;
		if (lowestSal == null) {
			if (other.lowestSal != null)
				return false;
		} else if (!lowestSal.equals(other.lowestSal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JobLevel [jobLevel=" + jobLevel + ", lowestSal=" + lowestSal + ", highestSal=" + highestSal + "]";
	}
	
}
