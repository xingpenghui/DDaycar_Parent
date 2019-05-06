package com.ttesc.entity.user;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-04-30
 */
public class Userwallet  {

	private Integer id;
	private Integer uid;
	private Integer totalscore;
	private Integer losescore;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getTotalscore() {
		return totalscore;
	}

	public void setTotalscore(Integer totalscore) {
		this.totalscore = totalscore;
	}

	public Integer getLosescore() {
		return losescore;
	}

	public void setLosescore(Integer losescore) {
		this.losescore = losescore;
	}

}
