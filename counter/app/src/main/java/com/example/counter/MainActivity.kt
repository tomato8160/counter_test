package com.example.counter

import android.app.Activity
import android.app.Application
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG = MainActivity::class.java.simpleName
    }
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counterText.text = "${viewModel.count}"


        binding.addButton.setOnClickListener {
            viewModel.count++
            binding.counterText.text = "${viewModel.count}"
        }

        binding.subButton.setOnClickListener {
            viewModel.count--
            binding.counterText.text = "${viewModel.count}"
        }
        
        registerActivityLifecycleCallbacks(object:Application
        .ActivityLifecycleCallbacks{
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                Log.d(TAG, "onActivityCreated: ")
            }

            override fun onActivityStarted(p0: Activity) {
                Log.d(TAG, "onActivityStarted: ")
            }

            override fun onActivityResumed(p0: Activity) {
                Log.d(TAG, "onActivityResumed: ")
            }

            override fun onActivityPaused(p0: Activity) {
                Log.d(TAG, "onActivityPaused: ")
            }

            override fun onActivityStopped(p0: Activity) {
                Log.d(TAG, "onActivityStopped: ")
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                Log.d(TAG, "onActivitySaveInstanceState: ")
            }

            override fun onActivityDestroyed(p0: Activity) {
                Log.d(TAG, "onActivityDestroyed: ")
            }

        })
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("count", viewModel.count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.count = savedInstanceState.getInt("count")
    }
}