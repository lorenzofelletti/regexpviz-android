package com.lorenzofelletti.regexpviz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextTestString: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTestString = findViewById(R.id.editTextTestString)
        editTextTestString.addTextChangedListener(
            RegexMatchesSyntaxHighlighter(
                findViewById(R.id.editTextRegex),
                findViewById(R.id.editTextTestString)
            )
        )
    }
}