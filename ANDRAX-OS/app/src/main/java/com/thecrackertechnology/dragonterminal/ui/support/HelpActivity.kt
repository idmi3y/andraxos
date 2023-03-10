package com.thecrackertechnology.dragonterminal.ui.support

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.thecrackertechnology.andrax.R

/**
 * @author kiva
 */
class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ui_faq)
        setSupportActionBar(findViewById(R.id.faq_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home ->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }
}