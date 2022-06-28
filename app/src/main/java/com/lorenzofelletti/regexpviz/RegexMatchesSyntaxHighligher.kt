package com.lorenzofelletti.regexpviz

import android.graphics.Color
import android.text.Editable
import android.text.Spannable
import android.text.style.BackgroundColorSpan
import android.widget.EditText

class RegexMatchesSyntaxHighlighter(
    private val editTextRegex: EditText,
    private val editTextTestString: EditText
) :
    SyntaxHighlighter() {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {

        val testStringEditable = editTextTestString.text

        // clears the outputs of the previous search
        testStringEditable.setSpan(
            BackgroundColorSpan(Color.TRANSPARENT),
            0,
            testStringEditable.toString().length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        if (editTextRegex.text.toString().isEmpty())
            return

        val regex = Regex.fromLiteral(editTextRegex.text.toString())
        val matchesSequence = regex.findAll(editTextTestString.text.toString(), 0)

        matchesSequence.forEach {
            if (it.range.last > 0) {
                //val last =
                //    if (it.range.last + 1 > testStringEditable.length) it.range.last else it.range.last + 1
                testStringEditable.setSpan(
                    BackgroundColorSpan(Color.CYAN),
                    it.range.first,
                    //last,
                    it.range.last + 1,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE
                )
            }
        }

    }
}