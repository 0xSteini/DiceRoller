package com.example.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer?= null
    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

            mediaPlayer = MediaPlayer.create(this, R.raw.rolldice1)
            mediaPlayer?.start()
            //mediaPlayer.start()
            Toast.makeText(this, "Würfel ... würfel . .", Toast.LENGTH_SHORT).show()
        }

        // show first dice on open the app
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create a new Dice objet with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        //diceImage.setImageResource(R.drawable.dice_2)
        /**when (diceRoll) {
        1 -> diceImage.setImageResource(R.drawable.dice_1)
        2 -> diceImage.setImageResource(R.drawable.dice_2)
        3 -> diceImage.setImageResource(R.drawable.dice_3)
        4 -> diceImage.setImageResource(R.drawable.dice_4)
        5 -> diceImage.setImageResource(R.drawable.dice_5)
        6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
         */
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}