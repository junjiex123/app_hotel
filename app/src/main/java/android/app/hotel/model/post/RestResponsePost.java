package android.app.hotel.model.post;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponsePost {
    @SerializedName("status")
    private Integer status;

    @SerializedName("error")
    private Object error;

    @SerializedName("data")
    private List<Post> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public List<Post> getData() {
        return data;
    }

    public void setData(List<Post> data) {
        this.data = data;
    }
}
