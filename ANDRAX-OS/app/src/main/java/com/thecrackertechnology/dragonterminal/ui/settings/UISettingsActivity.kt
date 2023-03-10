package com.thecrackertechnology.dragonterminal.ui.settings

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.MenuItem
import com.thecrackertechnology.andrax.R

/**
 * @author kiva
 */
class UISettingsActivity : BasePreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.ui_settings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(applicationContext,R.color.blackfull))
        addPreferencesFromResource(R.xml.settings_ui)
    }

    override fun onBuildHeaders(target: MutableList<Header>?) {
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home ->
                finish()
        }
        return super.onOptionsItemSelected(item)
    }
}