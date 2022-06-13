package com.lorenzofelletti.regexpviz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var editTextTestString: EditText
    private lateinit var editTextRegex: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTestString = findViewById(R.id.editTextTestString)
        editTextRegex = findViewById(R.id.editTextRegex)

        editTextTestString.addTextChangedListener(
            RegexMatchesSyntaxHighlighter(
                editTextRegex,
                editTextTestString
            )
        )
        editTextRegex.addTextChangedListener(
            RegexMatchesSyntaxHighlighter(
                editTextRegex,
                editTextTestString
            )
        )
    }
}