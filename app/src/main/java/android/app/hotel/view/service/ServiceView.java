package android.app.hotel.view.service;

import android.app.hotel.model.service.ServiceCategory;

import java.util.List;

public interface ServiceView {
    void updateView(List <ServiceCategory> serviceCategories);
}
