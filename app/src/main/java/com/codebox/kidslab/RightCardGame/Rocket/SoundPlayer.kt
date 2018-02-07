package com.codebox.kidslab.RightCardGame.Rocket

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build


/**
 * Created by Abed on 9/28/2017.
 */
class SoundPlayer(mContext: Context) {

    private var sp: SoundPool
    private var explodeID: Int
    private var startFire: Int
    private var right: Int
    private var wrong: Int

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build()
            sp = SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build()
        } else {
            sp = SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        }
        val assetManager = mContext.assets

        explodeID = sp.load(assetManager.openFd("fireworks_finale.mp3"), 0)
        startFire = sp.load(assetManager.openFd("fireworks.mp3"), 0)
        wrong = sp.load(assetManager.openFd("colors/wrong.mp3"), 0)
        right = sp.load(assetManager.openFd("colors/clapping.mp3"), 0)
    }

    fun playExplode() {
        sp.play(explodeID, 1f, 1f, 0, 0, 1f)
    }

    fun playFireWorks() {
        sp.play(startFire, 1f, 1f, 0, 0, 1f)
    }
    fun wrong() {
        sp.play(wrong, 1f, 1f, 0, 0, 1f)
    }
    fun right() {
        sp.play(right, 1f, 1f, 0, 0, 1f)
    }

}

