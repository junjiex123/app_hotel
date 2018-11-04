package android.app.hotel.presenter;

import android.app.hotel.model.home.Home;
import android.app.hotel.model.home.RestResponseHome;
import android.app.hotel.service.home.HomeService;
import android.app.hotel.view.Home.HomeView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private HomeView homeview;
    private HomeService homeService;
    private RestResponseHome restResponseHome;
    public static List<Home> homes = new ArrayList<>();

    public HomePresenter(HomeView homeview) {
        this.homeview = homeview;
        if (homeService == null) {
            homeService = new HomeService();
        }
    }

    public void retryHomes(){
        homeService
                .getAPI()
                .getResults()
                .enqueue(new Callback<RestResponseHome>() {
                    @Override
                    public void onResponse(Call<RestResponseHome> call, Response<RestResponseHome> response) {

                        restResponseHome = response.body();

                        if (restResponseHome != null && restResponseHome.getData() != null){

                            homes.clear();
                            List<Home> result = restResponseHome.getData();

                            if(result!=null && result.size()>0){
                                homes = result;
                                homeview.updateView(homes);
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<RestResponseHome> call, Throwable t) {
                        try {
                            throw  new InterruptedException("Something went wrong");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public static List<Home> getHomes() {
        return homes;
    }
}
