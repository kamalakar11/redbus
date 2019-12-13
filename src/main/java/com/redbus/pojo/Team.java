package com.redbus.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iplTeam")
public class Team {

	@Id
	private String teamName;
	private double totalMatches;
	private double win;
	private double lost;
	private String status = "Rejected";

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(double totalMatches) {
		this.totalMatches = totalMatches;
	}

	public double getWin() {
		return win;
	}

	public void setWin(double win) {
		this.win = win;
	}

	public double getLost() {
		return lost;
	}

	public void setLost(double lost) {
		this.lost = lost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
