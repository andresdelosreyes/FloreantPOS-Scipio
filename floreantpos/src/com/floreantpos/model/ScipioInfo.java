package com.floreantpos.model;

import com.floreantpos.model.base.BaseScipioInfo;

public class ScipioInfo  extends BaseScipioInfo{
    private static final long serialVersionUID = 1L;
    
	/*[CONSTRUCTOR MARKER BEGIN]*/
	public ScipioInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ScipioInfo (java.lang.Integer id) {
		super(id);
	}    
    
    
/*

     private int id;
     private Integer pei;
     private Integer tei;
     private Integer pin;
     private Integer transactionId;
     private Integer ticketId;

    public ScipioInfo() {
    }

	
    public ScipioInfo(int id) {
        this.id = id;
    }
    public ScipioInfo(int id, Integer pei, Integer tei, Integer pin, Integer transactionId, Integer ticketId) {
       this.id = id;
       this.pei = pei;
       this.tei = tei;
       this.pin = pin;
       this.transactionId = transactionId;
       this.ticketId = ticketId;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Integer getPei() {
        return this.pei;
    }
    
    public void setPei(Integer pei) {
        this.pei = pei;
    }
    public Integer getTei() {
        return this.tei;
    }
    
    public void setTei(Integer tei) {
        this.tei = tei;
    }
    public Integer getPin() {
        return this.pin;
    }
    
    public void setPin(Integer pin) {
        this.pin = pin;
    }
    public Integer getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
    public Integer getTicketId() {
        return this.ticketId;
    }
    
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }



*/

    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

