package com.example.demo.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@JacksonXmlRootElement(localName = "OBJECT")
public class AdressObject{

    @JacksonXmlProperty(isAttribute = true)
    private int ID;

    @JacksonXmlProperty(isAttribute = true)
    private int OBJECTID;

    @JacksonXmlProperty(isAttribute = true)
    private String OBJECTGUID;

    @JacksonXmlProperty(isAttribute = true)
    private String CHANGEID;

    @JacksonXmlProperty(isAttribute = true)
    private String NAME;

    @JacksonXmlProperty(isAttribute = true)
    private String TYPENAME;

    @JacksonXmlProperty(isAttribute = true)
    private String LEVEL;

    @JacksonXmlProperty(isAttribute = true)
    private String OPERTYPEID;

    @JacksonXmlProperty(isAttribute = true)
    private String PREVID;

    @JacksonXmlProperty(isAttribute = true)
    private String NEXTID;

    @JacksonXmlProperty(isAttribute = true)
    private Date UPDATEDATE;

    @JacksonXmlProperty(isAttribute = true)
    private Date STARTDATE;

    @JacksonXmlProperty(isAttribute = true)
    private Date ENDDATE;

    @JacksonXmlProperty(isAttribute = true)
    private String ISACTUAL;

    @JacksonXmlProperty(isAttribute = true)
    private String ISACTIVE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdressObject that = (AdressObject) o;

        if (ID != that.ID) return false;
        if (OBJECTID != that.OBJECTID) return false;
        if (!Objects.equals(OBJECTGUID, that.OBJECTGUID)) return false;
        if (!Objects.equals(CHANGEID, that.CHANGEID)) return false;
        if (!Objects.equals(NAME, that.NAME)) return false;
        if (!Objects.equals(TYPENAME, that.TYPENAME)) return false;
        if (!Objects.equals(LEVEL, that.LEVEL)) return false;
        if (!Objects.equals(OPERTYPEID, that.OPERTYPEID)) return false;
        if (!Objects.equals(PREVID, that.PREVID)) return false;
        if (!Objects.equals(NEXTID, that.NEXTID)) return false;
        if (!Objects.equals(UPDATEDATE, that.UPDATEDATE)) return false;
        if (!Objects.equals(STARTDATE, that.STARTDATE)) return false;
        if (!Objects.equals(ENDDATE, that.ENDDATE)) return false;
        if (!Objects.equals(ISACTUAL, that.ISACTUAL)) return false;
        return Objects.equals(ISACTIVE, that.ISACTIVE);
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + OBJECTID;
        result = 31 * result + (OBJECTGUID != null ? OBJECTGUID.hashCode() : 0);
        result = 31 * result + (CHANGEID != null ? CHANGEID.hashCode() : 0);
        result = 31 * result + (NAME != null ? NAME.hashCode() : 0);
        result = 31 * result + (TYPENAME != null ? TYPENAME.hashCode() : 0);
        result = 31 * result + (LEVEL != null ? LEVEL.hashCode() : 0);
        result = 31 * result + (OPERTYPEID != null ? OPERTYPEID.hashCode() : 0);
        result = 31 * result + (PREVID != null ? PREVID.hashCode() : 0);
        result = 31 * result + (NEXTID != null ? NEXTID.hashCode() : 0);
        result = 31 * result + (UPDATEDATE != null ? UPDATEDATE.hashCode() : 0);
        result = 31 * result + (STARTDATE != null ? STARTDATE.hashCode() : 0);
        result = 31 * result + (ENDDATE != null ? ENDDATE.hashCode() : 0);
        result = 31 * result + (ISACTUAL != null ? ISACTUAL.hashCode() : 0);
        result = 31 * result + (ISACTIVE != null ? ISACTIVE.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AdressObject" +'\n'+
                "{ID=" + ID +
                ", OBJECTID=" + OBJECTID +
                ", OBJECTGUID='" + OBJECTGUID + '\'' +
                ", CHANGEID='" + CHANGEID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", TYPENAME='" + TYPENAME + '\'' +
                ", LEVEL='" + LEVEL + '\'' +
                ", OPERTYPEID='" + OPERTYPEID + '\'' +
                ", PREVID='" + PREVID + '\'' +
                ", NEXTID='" + NEXTID + '\'' +
                ", UPDATEDATE=" + UPDATEDATE +
                ", STARTDATE=" + STARTDATE +
                ", ENDDATE=" + ENDDATE +
                ", ISACTUAL='" + ISACTUAL + '\'' +
                ", ISACTIVE='" + ISACTIVE +
                '}'+'\n';
    }
}
