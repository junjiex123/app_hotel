package android.app.hotel.model.post;


import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private Integer Id;

    @SerializedName("title")
    private String Title;

    @SerializedName("admin")
    private String Admin;

    @SerializedName("tag")
    private String Tag;

    @SerializedName("link_img")
    private String Image;

    @SerializedName("short_description")
    private String ShortDescription;

    @SerializedName("description")
    private String LongDescription;

    @SerializedName("ago")
    private String Ago;
//
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }
//
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        this.Title = title;
    }
//
    public String getImage() {
        return Image;
    }
    public void setImage(String image) {
        this.Image = image;
    }
//
    public String getAdmin() {
        return Admin;
    }
    public void setAdmin(String admin) { this.Admin = admin; }
//
    public String getTag() {
        return Tag;
    }
    public void setTag(String tag) {
        this.Tag = tag;
    }
//
    public String getShortDescription() {
        return ShortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.ShortDescription = shortDescription;
    }
//
    public String getLongDescription() {
    return LongDescription;
}
    public void setLongDescription(String longDescription) {
        this.LongDescription = longDescription;
    }
//
    public String getAgo() {
    return Ago;
}
    public void setAgo(String ago) { this.Ago = ago; }

}
