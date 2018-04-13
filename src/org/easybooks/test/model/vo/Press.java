package org.easybooks.test.model.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * Press entity. @author MyEclipse Persistence Tools
 */

public class Press  implements java.io.Serializable {


    // Fields    

     private Short pno;
     private String paddress;
     private String pname;
     private String pphone;
     private Set publics = new HashSet(0);


    // Constructors

    /** default constructor */
    public Press() {
    }

	/** minimal constructor */
    public Press(String paddress, String pname, String pphone) {
        this.paddress = paddress;
        this.pname = pname;
        this.pphone = pphone;
    }
    
    /** full constructor */
    public Press(String paddress, String pname, String pphone, Set publics) {
        this.paddress = paddress;
        this.pname = pname;
        this.pphone = pphone;
        this.publics = publics;
    }

   
    // Property accessors

    public Short getPno() {
        return this.pno;
    }
    
    public void setPno(Short pno) {
        this.pno = pno;
    }

    public String getPaddress() {
        return this.paddress;
    }
    
    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPname() {
        return this.pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPphone() {
        return this.pphone;
    }
    
    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public Set getPublics() {
        return this.publics;
    }
    
    public void setPublics(Set publics) {
        this.publics = publics;
    }
   








}