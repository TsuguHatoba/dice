package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/** This Activity allows user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        diceImage.setImageResource(R.drawable.dice_0)
        diceImage2.setImageResource(R.drawable.dice_0)

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice()
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()


        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Determine which image will show based on roll number
        val drawableResources = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResources2 = when (diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Show Image based on when statement
        diceImage.setImageResource(drawableResources)
        diceImage2.setImageResource(drawableResources2)

        // Update image contentDescription based on roll number
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        if (diceRoll == diceRoll2){
            Toast.makeText(applicationContext, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(applicationContext, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
        }

    }
}

class Dice() {
    fun roll(): Int {
        return (1..6).random()
    }
}

