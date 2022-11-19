package com.frkl.hwjun;

/**
 *
 * @author klimci
 */

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "popularity")

public class Popularity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
    @NotNull
    @Column(name = "documentID", unique = true)
    private String documentID;
    
    @Column(name = "numOfAccesses")
    private int numOfAccesses;
    
    public Popularity() {
        
    }
    
    public Popularity(Integer id, String documentID, int numOfAccesses) {
        this.id = id;
	this.documentID = documentID;
	this.numOfAccesses = numOfAccesses;
    }
    
    public Integer getId() {
	return id;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }
    
    public String getDocumentID() {
        return documentID;
    }
    
    public void setNumOfAccesses(Integer numOfAccesses) {
        this.numOfAccesses = numOfAccesses;
    }
    
    public Integer getNumOfAccesses() {
        return numOfAccesses;
    }
    
    @Override
	public String toString() {
		return "Access [numOfAccesses=" + numOfAccesses + ", documentID=" + documentID + "]";
	}    
}