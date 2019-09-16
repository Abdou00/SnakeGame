package com.dev.snakegame;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class SnakeActivity extends Activity {
    /**
     * Declare an instance of SnakeEngine
     * We will code this soon
     * @param savedInstanceState
     */
    SnakeEngine snakeEngine;

    @Override
    /**
     * La méthode onCreate utilise la classe Display et un objet de type Point
     * pour obtenir la résolution du périphérique sur lequel le jeu est exécuté.
     * classe SnakeEngine aura besoin d’une référence à l’Activité et à la résolution,
     * de sorte que nous les transmettons au constructeur SnakeEngine.
     * La dernière chose que nous faisons est d'utiliser snakeEngine pour être la vue de SnakeActivity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Initialize the result into a Point object
        Point size = new Point();
        display.getSize(size);

        // Create a new instance of the SnakeEngine class
        snakeEngine = new SnakeEngine(this, size);

        // Make snakeEngine the view of the Activity
        setContentView(snakeEngine);
    }

    // Start the thread in snakeEngine
    @Override
    protected void onResume() {
        super.onResume();
        snakeEngine.resume();
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        snakeEngine.pause();
    }
}
