package org.furygames.screens;

import org.furygames.furyshimp.FuryShimp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ScoreScreen extends GenericScreen{

	private Skin skin;
	private TextButton backButton;
	private Table table;
	
	public ScoreScreen(final FuryShimp universalMonkey) {
		super(universalMonkey);
	}
	
	@Override
	public void show() {
		super.show();
		
		skin = new Skin(Gdx.files.internal("uiskin/uiskin.json"));
		
		backButton = new TextButton("Volver", skin);
		
		table = new Table();
		table.setFillParent(true);
		table.add(backButton).pad(50).width(400f).height(100);
		
		backButton.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	universalMonkey.setScreen(universalMonkey.getMenuScreen());
            }
        });
		
		stage.addActor(table);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
		stage.act();
	}

}
