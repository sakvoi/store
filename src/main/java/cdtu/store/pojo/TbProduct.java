package cdtu.store.pojo;

import java.util.Date;

public class TbProduct {
    private Integer pid;

    private String pname;

    private Double marketprice;

    private Double storeprice;

    private String image;

    private String descs;

    private Date pdate;

    private String pcode;

    private String status;

    private Integer csid;

    private Integer sid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Double marketprice) {
        this.marketprice = marketprice;
    }

    public Double getStoreprice() {
        return storeprice;
    }

    public void setStoreprice(Double storeprice) {
        this.storeprice = storeprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String desc) {
        this.descs = desc == null ? null : desc.trim();
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode == null ? null : pcode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}