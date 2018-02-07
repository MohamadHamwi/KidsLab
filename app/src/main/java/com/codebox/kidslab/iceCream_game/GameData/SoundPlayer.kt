package com.codebox.kidslab.iceCream_game.GameData

import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import com.codebox.kidslab.iceCream_game.IceCreamActivity


/**
 * Created by Abed on 9/28/2017.
 */
class SoundPlayer(val mContext: Context) {
    private val assetManager = mContext.assets
    private var sp: SoundPool
    private var red: Int
    private var green: Int
    private var yellow: Int
    private var blue: Int
    private var orange: Int
    private var brown: Int
    private var right: Int
    private var wrong: Int
    private var endGame: Int
    private val maxStreams = 10

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sp = SoundPool.Builder()
                    .setMaxStreams(maxStreams)
                    .build()

        } else {
            sp = SoundPool(maxStreams, AudioManager.STREAM_MUSIC, 0)
        }
        blue = sp.load(assetManager.openFd("colors/blue.mp3"), 1)
        yellow = sp.load(assetManager.openFd("colors/yellow.ogg"), 1)
        red = sp.load(assetManager.openFd("colors/red.ogg"), 1)
        brown = sp.load(assetManager.openFd("colors/brown.mp3"), 1)
        green = sp.load(assetManager.openFd("colors/green.ogg"), 1)
        orange = sp.load(assetManager.openFd("colors/orange.mp3"), 1)
        right = sp.load(assetManager.openFd("right_for_color.ogg"), 0)
        wrong = sp.load(assetManager.openFd("colors/wrong.mp3"), 0)
        endGame = sp.load(assetManager.openFd("right_full.ogg"), 0)
    }

    fun red() {
        play(red)
    }

    fun green() {
        play(green)
    }


    fun yellow() {
        play(yellow)
    }

    fun orange() {
        play(orange)
    }

    fun blue() {
        play(blue)
    }

    fun brown() {
        play(brown)
    }

    fun right() {
        play(right)
    }

    fun wrong() {
        play(wrong)
    }

    fun endGame() {
        play(endGame)
    }

    fun play(media: Int) {
        // Getting the user sound settings
        val audioManager = mContext.getSystemService(AUDIO_SERVICE) as AudioManager
        val actualVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC).toFloat()
        val maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC).toFloat()
        val volume = actualVolume / maxVolume
        sp.pause(wrong)
        (mContext) as IceCreamActivity

        if (media != wrong) {
            if ((mContext).isLastPage()) {
                sp.play(endGame, volume, volume, 1, 0, 1f)

            } else {
                sp.play(right, volume, volume, 1, 0, 1f)
            }
        }
// Is the sound loaded already?

        sp.play(media, volume, volume, 1, 0, 1f)

    }
}

