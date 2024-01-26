package com.example.diceroller

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var  player:MediaPlayer
    lateinit var RandomButton:Button
    lateinit var SettoButton:Button
    lateinit var DiceImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RandomButton=findViewById((R.id.button))
        SettoButton=findViewById((R.id.button2))
        DiceImage=findViewById((R.id.imageView2))

        RandomButton.setOnClickListener {
            player =MediaPlayer.create(this,R.raw.dice)
            player.start()
            val random=(1..6).random()
            val drawable=when(random)
            {
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                6->R.drawable.dice_6
                else->
                {R.drawable.dice_random}

            }
            if(random<=6)
            {
                Log.e("error","value was not between 1 to 6")
            }
            DiceImage.setImageDrawable(resources.getDrawable(drawable))
            SettoButton.setOnClickListener {
                player=MediaPlayer.create(this,R.raw.dice)
                player.start()
                DiceImage.setImageDrawable(resources.getDrawable(R.drawable.dice_random))
            }
        }

    }
}