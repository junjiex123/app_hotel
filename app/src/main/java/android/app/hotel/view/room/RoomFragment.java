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


        lvRoom = (ListView) view.findViewById(R.id.listviewRoom);

        RoomPresenter roomPresenter = new RoomPresenter(this);
        roomPresenter.getRooms();

        return view;
    }

    @Override
    public void roomRead(final List<Room> rooms) {
        roomAdapter = new RoomAdapter(this.getContext(), R.layout.view_room, rooms);
        lvRoom.setAdapter(roomAdapter);

        lvRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), RoomDetail.class);
                intent.putExtra("name", rooms.get(position).getName());
                intent.putExtra("price", "" +rooms.get(position).getPrice());
                intent.putExtra("image", rooms.get(position).getLinkImg());
                intent.putExtra("acreage", "" + rooms.get(position).getAcreage());
                intent.putExtra("description", rooms.get(position).getDescription());
                startActivity(intent);

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
