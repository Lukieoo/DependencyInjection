package com.lukieoo.dependencyinjection

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.lukieoo.dependencyinjection.retrofit.adapter.LatestAdapter
import com.lukieoo.dependencyinjection.retrofit.model.TopGames
import com.lukieoo.dependencyinjection.retrofit.network.AuthApi
import dagger.android.AndroidInjection
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @JvmField
    @Inject
    var logo:Drawable?=null


    @JvmField
    @Inject
    var authApi: AuthApi?=null

    @Inject
    lateinit var adapter1: LatestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setImageDrawable(logo)

        initRecyclerView1()
        subscribeObservers()

    }

    private fun subscribeObservers() {
        authApi!!.getTopGames("2019-01-01,2020-05-31","-added").toObservable().subscribeOn(
            Schedulers.io())
            .subscribe(object : Observer<TopGames> {

                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("GoGoPower", "onDisposable: $d")
                }

                override fun onNext(t: TopGames) {


                    Log.d("GoGoPower", "onNext: $t")

                    adapter1!!.setPosts(t.results)
                    adapter1!!.notifyDataSetChanged()
                }

                override fun onError(e: Throwable) {

                }

            })
    }

    private fun initRecyclerView1() {
       recyclerView1.apply {
           layoutManager=GridLayoutManager(this@MainActivity,3)
           adapter=adapter1
       }
    }

}