package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "accesses")

public class Access {

    @Id
    @NotNull
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @Column(name = "timeOfAccess")
    private long timeOfAccess;
    
    @Column(name = "documentID")
    private String documentID;
    
    @Column(name = "userID")
    private String userID;
    
    public Access() {
        
    }
    
    public Access(long timeOfAccess, String documentID, String userID) {
	this.timeOfAccess = timeOfAccess;
	this.documentID = documentID;
	this.userID = userID;
    }    
    
    public Long getId() {
	return id;
    }
    
    public long getTimeOfAccess() {
	return timeOfAccess;
    }

    public void setTimeOfAccess(long timeOfAccess) {
	this.timeOfAccess = timeOfAccess;
    }
    
    public String getDocumentID() {
	return documentID;
    }

    public void setDocumentID(String documentID) {
	this.documentID = documentID;
    }
    
    public String getUserID() {
	return userID;
    }

    public void setUserID(String userID) {
	this.userID = userID;
    }
    
    @Override
	public String toString() {
		return "Access [id=" + id + ", time=" + timeOfAccess + ", documentID=" + documentID + ", userID=" + userID + "]";
	}        
}
