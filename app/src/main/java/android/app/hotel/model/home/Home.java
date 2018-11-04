package android.app.hotel.model.home;

import com.google.gson.annotations.SerializedName;

public class Home {
    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("link_img")
    private String linkImg;

    @SerializedName("price")
    private Integer price;

    @SerializedName("acreage")
    private Integer acreage;

    @SerializedName("short_description")
    private String shortDescription;

    @SerializedName("description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAcreage() {
        return acreage;
    }

    public void setAcreage(Integer acreage) {
        this.acreage = acreage;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
