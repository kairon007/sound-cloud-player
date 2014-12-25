package ngo.music.soundcloudplayer.boundary;


import java.util.ArrayList;

import ngo.music.soundcloudplayer.R;
import ngo.music.soundcloudplayer.Adapters.OfflineSongAdapter;
import ngo.music.soundcloudplayer.entity.Song;
import ngo.music.soundcloudplayer.service.MusicPlayerService;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class OfflineSongsFragment extends Fragment {
	public static OfflineSongsFragment instance = null;
	private OfflineSongsFragment() {
		
	}
	View rootView = null;
	public static OfflineSongsFragment getInstance() {
		// TODO Auto-generated method stub
		if(instance == null) {
			instance = new OfflineSongsFragment();
		}
		return instance;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		rootView = inflater.inflate(R.layout.tab_songs_view, container,false);
		final ListView songsList = (ListView) rootView.findViewById(R.id.songs_list);
		songsList.setAdapter(OfflineSongAdapter.getInstance());
		songsList.setOnItemClickListener(new  OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				Song song = (Song) songsList.getAdapter().getItem(position);
				ArrayList<Song> songs = (((OfflineSongAdapter) songsList.getAdapter()).getSongs());
				MusicPlayerService.getInstance().playNewSong(position, songs);
			}
		});
		return rootView;
	}

}
