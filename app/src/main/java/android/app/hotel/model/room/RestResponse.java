package android.app.hotel.model.room;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse {
    @SerializedName("status")
    private Integer status;

    @SerializedName("error")
    private Object error;

    @SerializedName("data")
    private List<Room> data = null;

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

    public List<Room> getData() {
        return data;
    }

    public void setData(List<Room> data) {
        this.data = data;
    }
}
