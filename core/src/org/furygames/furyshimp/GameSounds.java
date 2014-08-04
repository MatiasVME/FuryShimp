package org.furygames.furyshimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class GameSounds {
	private static final String SOUNDWOOP="sounds/other/woop.mp3";
	private static final String SOUNDHIT="sounds/other/hit.mp3";
	private static final String MUSICRIVERSIDE="sounds/levels/Riverside Ride Short Loop.mp3";
	public GameSounds(){

	}
	public Sound newSound(int tipo){
		Sound s=null;
		switch (tipo) {
		case 1:
			s=Gdx.audio.newSound(Gdx.files.internal(SOUNDWOOP));
			break;
		case 2:
			s=Gdx.audio.newSound(Gdx.files.internal(SOUNDHIT));
			break;
		default:
			break;
		}	
		return s;

	}
	public Music newMusic(int tipo){
		Music m=null;
		switch (tipo) {
		case 1:
			m=Gdx.audio.newMusic(
					Gdx.files.internal(MUSICRIVERSIDE));
			break;

		default:
			break;
		}
		return m;
	}
}
