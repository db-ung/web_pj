package com.project.DTO;

public class PostDTO {
    private String IDX;
    private String tag;
    private String id;
    private String TITLE;
    private String CONTENT;
    private String DATE;
    private String FILE;
    private String isgood;
    private String viewcount;
    

    public String getViewcount() {
		return viewcount;
	}

	public void setViewcount(String viewcount) {
		this.viewcount = viewcount;
	}

	public String getIDX() {
        return IDX;
    }

    public void setIDX(String iDX) {
        IDX = iDX;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String tITLE) {
        TITLE = tITLE;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String cONTENT) {
        CONTENT = cONTENT;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String dATE) {
        DATE = dATE;
    }

    public String getFILE() {
        return FILE;
    }

    public void setFILE(String fILE) {
        FILE = fILE;
    }

    public String getIsgood() {
        return isgood;
    }

    public void setIsgood(String isgood) {
        this.isgood = isgood;
    }
}
