package android.app.hotel.model.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponseService {
    @SerializedName("status")
    private Integer status;

    @SerializedName("error")
    private Object error;

    @SerializedName("data")
    private List<ServiceCategory> data = null;

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

    public List<ServiceCategory> getData() {
        return data;
    }

    public void setData(List<ServiceCategory> data) {
        this.data = data;
    }
}
