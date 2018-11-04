package android.app.hotel.view.room;


import android.app.hotel.adapter.RoomAdapter;
import android.app.hotel.model.room.Room;
import android.app.hotel.presenter.RoomPresenter;
import android.app.hotel.view.MainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.app.hotel.R;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomFragment extends Fragment implements RoomView {

    private Toolbar toolbar;
    private RoomAdapter roomAdapter;
    private ListView lvRoom;
    RoomPresenter roomPresenter;


    public RoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitle("Danh sách phòng");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        roomPresenter = new RoomPresenter(this);

        lvRoom = (ListView) view.findViewById(R.id.listviewRoom);

        roomAdapter = new RoomAdapter(this.getContext(), R.layout.view_room, RoomPresenter.getRooms());
        lvRoom.setAdapter(roomAdapter);

        //update rooms list
        roomPresenter.retryRooms();

        return view;
    }

    @Override
    public void updateView(List<Room> rooms) {
        try {
            roomAdapter.setData(rooms);
            roomAdapter.notifyDataSetChanged();
        }catch (Exception e) {
            Log.d("DongA:", "Error: " + e);
        }
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
