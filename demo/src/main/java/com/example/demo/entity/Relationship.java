package com.example.demo.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@JacksonXmlRootElement(localName = "OBJECT")
public class Relationship {
    @JacksonXmlProperty(isAttribute = true)
    private int ID;

    @JacksonXmlProperty(isAttribute = true)
    private int OBJECTID;

    @JacksonXmlProperty(isAttribute = true)
    private int PARENTOBJID;
    @JacksonXmlProperty(isAttribute = true)
    private int CHANGEID;
    @JacksonXmlProperty(isAttribute = true)
    private int PREVID;
    @JacksonXmlProperty(isAttribute = true)
    private int NEXTID;
    @JacksonXmlProperty(isAttribute = true)
    private Date UPDATEDATE;

    @JacksonXmlProperty(isAttribute = true)
    private Date STARTDATE;

    @JacksonXmlProperty(isAttribute = true)
    private Date ENDDATE;

    @JacksonXmlProperty(isAttribute = true)
    private int ISACTIVE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Relationship that = (Relationship) o;

        if (ID != that.ID) return false;
        if (OBJECTID != that.OBJECTID) return false;
        if (PARENTOBJID != that.PARENTOBJID) return false;
        if (CHANGEID != that.CHANGEID) return false;
        if (PREVID != that.PREVID) return false;
        if (NEXTID != that.NEXTID) return false;
        if (ISACTIVE != that.ISACTIVE) return false;
        if (!Objects.equals(UPDATEDATE, that.UPDATEDATE)) return false;
        if (!Objects.equals(STARTDATE, that.STARTDATE)) return false;
        return Objects.equals(ENDDATE, that.ENDDATE);
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + OBJECTID;
        result = 31 * result + PARENTOBJID;
        result = 31 * result + CHANGEID;
        result = 31 * result + PREVID;
        result = 31 * result + NEXTID;
        result = 31 * result + (UPDATEDATE != null ? UPDATEDATE.hashCode() : 0);
        result = 31 * result + (STARTDATE != null ? STARTDATE.hashCode() : 0);
        result = 31 * result + (ENDDATE != null ? ENDDATE.hashCode() : 0);
        result = 31 * result + ISACTIVE;
        return result;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "ID=" + ID +
                ", OBJECTID=" + OBJECTID +
                ", PARENTOBJID=" + PARENTOBJID +
                ", CHANGEID=" + CHANGEID +
                ", PREVID=" + PREVID +
                ", NEXTID=" + NEXTID +
                ", UPDATEDATE=" + UPDATEDATE +
                ", STARTDATE=" + STARTDATE +
                ", ENDDATE=" + ENDDATE +
                ", ISACTIVE=" + ISACTIVE +
                '}';
    }
}
