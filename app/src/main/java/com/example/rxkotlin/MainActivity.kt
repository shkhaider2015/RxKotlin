package com.example.rxkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lambdaExpressionExample()
        inlineFunctionsExample()
        reactiveEvenOdd()

        findViewById<View>(R.id.textView)
                .setOnClickListener(View.OnClickListener {
                    val intent = Intent()
                })
    }


    private fun lambdaExpressionExample()
    {
        val sum = { x : Int, y : Int -> x + y }
        val anonyMousMult = { x : Int -> (Random().nextInt(15) + 1) * x }

        Log.d(TAG, "functionalProgrammingExample: ############################ Print Sum : " + sum(12, 14))
        Log.d(TAG, "functionalProgrammingExample: ############################ Print Mult : " + anonyMousMult(2) )
    }

    private fun inlineFunctionsExample()
    {
        fun doSomething(a:Int = 0) = a + (a * a);
        for (i in 1..5)
        {
            Log.d(TAG, "inlineFunctionsExample: ############################ doSomething() : " + doSomething(i) );
        }

    }

    private fun reactiveEvenOdd()
    {
        val subject: Subject<Int> = PublishSubject.create();

        subject.map({ isEven(it) }).subscribe({ Log.d(TAG, "reactiveEvenOdd: ############################ " + "The Number is ${(if(it) "Even" else "Odd")}  " ) });
        subject.onNext(4);
        subject.onNext(7);
    }

    private fun isEven(x: Int): Boolean {
        return x % 2 == 0
    }
}