package com.thecrackertechnology.dragonterminal.ui.customize

import android.annotation.SuppressLint
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.thecrackertechnology.andrax.R
import com.thecrackertechnology.dragonterminal.backend.TerminalSession
import com.thecrackertechnology.dragonterminal.frontend.config.NeoTermPath
import com.thecrackertechnology.dragonterminal.frontend.session.shell.ShellParameter
import com.thecrackertechnology.dragonterminal.frontend.session.shell.client.BasicSessionCallback
import com.thecrackertechnology.dragonterminal.frontend.session.shell.client.BasicViewClient
import com.thecrackertechnology.dragonterminal.frontend.terminal.TerminalView
import com.thecrackertechnology.dragonterminal.frontend.terminal.extrakey.ExtraKeysView
import com.thecrackertechnology.dragonterminal.utils.TerminalUtils

/**
 * @author kiva
 */
@SuppressLint("Registered")
open class BaseCustomizeActivity : AppCompatActivity() {
    lateinit var terminalView: TerminalView
    lateinit var viewClient: BasicViewClient
    lateinit var sessionCallback: BasicSessionCallback
    lateinit var session: TerminalSession
    lateinit var extraKeysView: ExtraKeysView

    fun initCustomizationComponent(layoutId: Int) {
        setContentView(layoutId)

        val toolbar = findViewById<Toolbar>(R.id.custom_toolbar)
        setSupportActionBar(toolbar)
        toolbar.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.blackfull))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        terminalView = findViewById(R.id.terminal_view)
        extraKeysView = findViewById(R.id.custom_extra_keys)
        viewClient = BasicViewClient(terminalView)
        sessionCallback = BasicSessionCallback(terminalView)
        TerminalUtils.setupTerminalView(terminalView, viewClient)
        TerminalUtils.setupExtraKeysView(extraKeysView)

        Handler().postDelayed({

            val script = resources.getStringArray(R.array.custom_preview_script_colors)
            val parameter = ShellParameter()
                    .executablePath("/data/data/com.thecrackertechnology.andrax/ANDRAX/bin/echo")
                    .arguments(arrayOf("echo", "-e", *script))
                    .callback(sessionCallback)
                    .systemShell(false)

            session = TerminalUtils.createSession(this, parameter)
            terminalView.attachSession(session)

        }, 800)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}