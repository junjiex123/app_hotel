package android.app.hotel.presenter;

import android.app.hotel.model.room.RestResponse;
import android.app.hotel.model.room.Room;
import android.app.hotel.service.room.RoomService;
import android.app.hotel.view.room.RoomView;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomPresenter {
    private RoomView roomView;
    private RoomService roomService;
    private RestResponse restResponse;
    private static List<Room> rooms = new ArrayList<>();

    public RoomPresenter(RoomView roomView) {
        this.roomView = roomView;
        if (roomService == null) {
            roomService = new RoomService();

        }
    }

    public void retryRooms(){
        roomService
            .getAPI()
            .getResults()
            .enqueue(new Callback<RestResponse>() {
                @Override
                public void onResponse(Call<RestResponse> call, Response<RestResponse> response) {
                    restResponse = response.body();

                    if (restResponse != null && restResponse.getData() != null){
                        rooms.clear();
                        List<Room> result = restResponse.getData();
                        if (result!=null && result.size() > 0) {
                            rooms = result;
                            roomView.updateView(result);
                        }
                    }
                }

                @Override
                public void onFailure(Call<RestResponse> call, Throwable t) {
                    try {
                        throw  new InterruptedException("Something went wrong");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public static List<Room> getRooms() {
        return rooms;
    }
}
