package ngo.music.soundcloudplayer.boundary.fragment.real;

import java.util.ArrayList;
import java.util.List;

import ngo.music.soundcloudplayer.R;
import ngo.music.soundcloudplayer.adapters.FavoriteSongAdapter;
import ngo.music.soundcloudplayer.adapters.SCSongAdapter;
import ngo.music.soundcloudplayer.adapters.MySCStreamAdapter;
import ngo.music.soundcloudplayer.adapters.OfflineSongAdapter;
import ngo.music.soundcloudplayer.api.ApiWrapper;
import ngo.music.soundcloudplayer.api.Token;
import ngo.music.soundcloudplayer.boundary.MusicPlayerMainActivity;
import ngo.music.soundcloudplayer.boundary.SCLoginUI.Background;
import ngo.music.soundcloudplayer.boundary.fragment.abstracts.ListContentFragment;
import ngo.music.soundcloudplayer.boundary.fragment.abstracts.NoRefreshListContentFragment;
import ngo.music.soundcloudplayer.controller.SongController;
import ngo.music.soundcloudplayer.controller.SCUserController;
import ngo.music.soundcloudplayer.controller.UIController;
import ngo.music.soundcloudplayer.entity.SCSong;
import ngo.music.soundcloudplayer.entity.Song;
import ngo.music.soundcloudplayer.general.BasicFunctions;
import ngo.music.soundcloudplayer.general.Constants;
import ngo.music.soundcloudplayer.service.MusicPlayerService;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MySCFavoriteFragment extends NoRefreshListContentFragment
		implements Constants {

	private ApiWrapper wrapper;

	public MySCFavoriteFragment() {
		// TODO Auto-generated constructor stub
		super();
		SCUserController soundCloudUserController = SCUserController
				.getInstance();
		Token t = soundCloudUserController.getToken();
		wrapper = new ApiWrapper(CLIENT_ID, CLIENT_SECRET, null, t);
	}

	// private class loadSongBackground extends AsyncTask<String , String,
	// String>{
	//
	// ArrayList<Song> favoriteSongs;
	// @Override
	// protected String doInBackground(String... params) {
	// // TODO Auto-generated method stub
	// SongController songController = SongController.getInstance();
	// try {
	// songController.loadFavoriteSong();
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return null;
	// }
	//
	// @Override
	// protected void onPostExecute(String result) {
	// // TODO Auto-generated method stub
	// if (favoriteSongs.size() == 0) {
	// /*
	// * Display the notice
	// */
	// TextView notification = (TextView) rootView.findViewById(R.id.notice);
	// notification.setVisibility(View.VISIBLE);
	// notification.setText("Do not have any song");
	//
	// }else{
	// adapter = new
	// FavoriteSongAdapter(MusicPlayerMainActivity.getActivity().getApplicationContext(),R.layout.list_view,
	// favoriteSongs ,wrapper);
	// songsList.setAdapter(adapter);
	// }
	// }
	//
	// }

	@Override
	protected int getCategory() {
		// TODO Auto-generated method stub
		return FAVOURITE;
	}

	@Override
	protected ArrayAdapter<?> getAdapter() {
		// TODO Auto-generated method stub
		ArrayList<Song> favoriteSongs = SongController.getInstance()
				.getFavoriteSong();
		return new FavoriteSongAdapter(MusicPlayerMainActivity.getActivity()
				.getApplicationContext(), R.layout.list_view, favoriteSongs,
				wrapper);
	}

	@Override
	protected boolean hasToolbar() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	protected boolean hasLoadMore() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setUpToolBar(Toolbar toolbar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateToolbar(Toolbar toolbar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setUpLoadMore() {
		// TODO Auto-generated method stub
		
	}
}
