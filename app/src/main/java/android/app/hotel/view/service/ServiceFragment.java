package android.app.hotel.view.service;


import android.app.hotel.R;

import android.app.hotel.adapter.ServiceAdapter;
import android.app.hotel.model.service.ServiceCategory;
import android.app.hotel.presenter.ServicePresenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment implements ServiceView {

    private Toolbar toolbar;
    private ServiceAdapter serviceAdapter;
    private ListView lvService;
    ServicePresenter servicePresenter;

    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitle("Danh sách dịch vụ");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        servicePresenter = new ServicePresenter(this);
        lvService = (ListView) view.findViewById(R.id.listviewService);
        serviceAdapter = new ServiceAdapter(this.getContext(),R.layout.view_service,ServicePresenter.getServices());
        lvService.setAdapter(serviceAdapter);

        //update rooms list
        servicePresenter.retryServices();

        return view;
    }

    @Override
    public void updateView(final List<ServiceCategory> serviceCategories) {
        serviceAdapter = new ServiceAdapter(this.getContext(), R.layout.view_service, serviceCategories);
        lvService.setAdapter(serviceAdapter);

        lvService.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(),"name" + serviceCategories.get(position).getName(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home)
        {
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
