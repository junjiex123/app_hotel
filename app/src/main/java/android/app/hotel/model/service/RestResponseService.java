package android.app.hotel.model.service;

import android.app.hotel.model.room.Room;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponseService {
    @SerializedName("status")
    private Integer status;

    @SerializedName("error")
    private Object error;

    @SerializedName("data")
    private List<Service> data = null;

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

    public List<Service> getData() {
        return data;
    }

    public void setData(List<Service> data) {
        this.data = data;
    }
}
