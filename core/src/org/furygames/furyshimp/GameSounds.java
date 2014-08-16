package org.furygames.furyshimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class GameSounds {
	
	private static final String SOUND_WOOP = "sounds/other/woop.mp3";
	private static final String SOUND_HIT = "sounds/other/hit.mp3";
	
	private static final String MUSIC_RIVERSIDE = "sounds/levels/Riverside Ride Short Loop.mp3";
	private static final String MUSIC_PLEASANT = "sounds/levels/Pleasant Creek Loop.mp3";
	private static final String MUSIC_SNOWLAND = "sounds/levels/Snowland Loop Short.mp3";
	private static final String MUSIC_ENCHANTED = "sounds/levels/Enchanted Festival Loop.mp3";
	
	public static Sound newSound(int tipo) {
		Sound s = null;
		
		switch (tipo) {
			case 1:
				s = Gdx.audio.newSound(Gdx.files.internal(SOUND_WOOP));
				break;
			case 2:
				s = Gdx.audio.newSound(Gdx.files.internal(SOUND_HIT));
				break;
			default:
				break;
		}
		
		return s;

	}
	
	public static Music newMusic(int tipo) {
		Music m = null;
		
		switch (tipo) {
			case 1:
				m = Gdx.audio.newMusic(
						Gdx.files.internal(MUSIC_RIVERSIDE));
				break;
			case 2:
				m = Gdx.audio.newMusic(
						Gdx.files.internal(MUSIC_PLEASANT));
				break;
			case 3:
				m = Gdx.audio.newMusic(
						Gdx.files.internal(MUSIC_SNOWLAND));
				break;
			case 4:
				m = Gdx.audio.newMusic(
						Gdx.files.internal(MUSIC_ENCHANTED));
				break;
			default:
				break;
		}
		
		return m;
	}
}
