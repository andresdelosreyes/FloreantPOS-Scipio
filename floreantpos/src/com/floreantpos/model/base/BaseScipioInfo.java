package com.floreantpos.model.base;

import java.io.Serializable;

/**
 *
 * @author Andres de los Reyes
 */
public abstract class BaseScipioInfo implements Comparable, Serializable {
         public static String ID ="";
         public static String PEI="";
         public static String TEI="";
         public static String PIN="";
         public static String TRANSACTIONID="";
         public static String TICKETID="";
    
         
         
         	// constructors
	public BaseScipioInfo () {
		initialize();
	}
        
	/**
	 * Constructor for primary key
	 */
	public BaseScipioInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}        
        
	/**
	 * Constructor for required fields
	 */
	public BaseScipioInfo (
		java.lang.Integer id,
		java.lang.Integer pei,
		java.lang.Integer tei,
                java.lang.Integer pin,
                java.lang.Integer transactionId,
                java.lang.Integer ticket_id) {

		this.setId(id);
		this.setPei(pei);
		this.setTei(tei);
                this.setPin(pin);
                this.setTransactionId(transactionId);
                this.setTicketId(ticket_id);
		initialize();
	}

	protected void initialize () {}        
        
        
        private int hashCode = Integer.MIN_VALUE;
        
        
        	// primary key
	private java.lang.Integer id;

	 private java.util.Date modifiedTime;
         
	// fields
        private java.lang.Integer pei;
        private java.lang.Integer tei;
        private java.lang.Integer pin;
        private java.lang.Integer transactionId;
        private java.lang.Integer TicketId;
        //many to one
        //comentado
        //private com.floreantpos.model.Ticket ticket;

    /**
     * @return the id
     */
    public java.lang.Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    /**
     * @return the modifiedTime
     */
    public java.util.Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @param modifiedTime the modifiedTime to set
     */
    public void setModifiedTime(java.util.Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * @return the pei
     */
    public java.lang.Integer getPei() {
        return pei;
    }

    /**
     * @param pei the pei to set
     */
    public void setPei(java.lang.Integer pei) {
        this.pei = pei;
    }

    /**
     * @return the tei
     */
    public java.lang.Integer getTei() {
        return tei;
    }

    /**
     * @param tei the tei to set
     */
    public void setTei(java.lang.Integer tei) {
        this.tei = tei;
    }

    /**
     * @return the pin
     */
    public java.lang.Integer getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(java.lang.Integer pin) {
        this.pin = pin;
    }

    /**
     * @return the transaction_id
     */
    public java.lang.Integer getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transaction_id to set
     */
    public void setTransactionId(java.lang.Integer transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the ticket
     */
    /*
    public com.floreantpos.model.Ticket getTicket() {
        return ticket;
    }
    * 
    */
    
    /**
     * @return the ticket
     */
    public java.lang.Integer getTicketId() {
        /*
        if (ticket == null)
            return null;        
        return ticket.getId();
        * 
        */
        return TicketId;
    }  
    
    
    public void setTicketId (java.lang.Integer p){
        //this.ticket.setId(p);
        this.TicketId=p;
    }
     
    

    /**
     * @param ticket the ticket to set
     */
    /*
    public void setTicket(java.lang.Integer ticket) {
        this.ticket = new com.floreantpos.model.Ticket(ticket);
    }

    public void setTicket(com.floreantpos.model.Ticket ticket) {
        this.ticket = ticket;
    }    
      
      * 
      */
        
        
}
