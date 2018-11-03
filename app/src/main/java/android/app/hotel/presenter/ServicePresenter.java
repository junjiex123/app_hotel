package android.app.hotel.presenter;

import android.app.hotel.model.room.RestResponse;
import android.app.hotel.model.room.Room;
import android.app.hotel.model.service.RestResponseService;
import android.app.hotel.model.service.Service;
import android.app.hotel.service.room.RoomService;
import android.app.hotel.service.room.ServiceService;
import android.app.hotel.view.room.RoomView;
import android.app.hotel.view.service.ServiceView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicePresenter {
    private ServiceView serviceView;
    private ServiceService serviceService;
    private RestResponseService restResponseService;

    public ServicePresenter(ServiceView serviceView) {
        this.serviceView = serviceView;
        if (serviceService == null) {
            serviceService = new ServiceService();
        }
    }

    public void getServices(){
        serviceService
            .getAPI()
            .getResults()
            .enqueue(new Callback<RestResponseService>() {
                @Override
                public void onResponse(Call<RestResponseService> call, Response<RestResponseService> response) {
                    restResponseService = response.body();

                    if (restResponseService != null && restResponseService.getData() != null){
                        List<Service> result = restResponseService.getData();
                        serviceView.serviceRead(result);
                    }
                }

                @Override
                public void onFailure(Call<RestResponseService> call, Throwable t) {
                    try {
                        throw  new InterruptedException("Something went wrong");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}
