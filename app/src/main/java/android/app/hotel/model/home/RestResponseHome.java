package android.app.hotel.model.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponseHome {
    @SerializedName("status")
    private Integer status;

    @SerializedName("error")
    private Object error;

    @SerializedName("data")
    private List<Home> data = null;

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

    public List<Home> getData() {
        return data;
    }

    public void setData(List<Home> data) {
        this.data = data;
    }
}
