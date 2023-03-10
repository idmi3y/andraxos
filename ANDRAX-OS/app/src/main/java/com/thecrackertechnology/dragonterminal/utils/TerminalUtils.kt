package com.thecrackertechnology.dragonterminal.utils

import android.app.Activity
import android.content.Context
import com.thecrackertechnology.dragonterminal.backend.TerminalSession
import com.thecrackertechnology.dragonterminal.component.font.FontComponent
import com.thecrackertechnology.dragonterminal.component.session.SessionComponent
import com.thecrackertechnology.dragonterminal.frontend.component.ComponentManager
import com.thecrackertechnology.dragonterminal.frontend.config.NeoPreference
import com.thecrackertechnology.dragonterminal.frontend.session.shell.ShellParameter
import com.thecrackertechnology.dragonterminal.frontend.session.xorg.XParameter
import com.thecrackertechnology.dragonterminal.frontend.session.xorg.XSession
import com.thecrackertechnology.dragonterminal.frontend.terminal.TerminalView
import com.thecrackertechnology.dragonterminal.frontend.terminal.TerminalViewClient
import com.thecrackertechnology.dragonterminal.frontend.terminal.extrakey.ExtraKeysView

/**
 * @author kiva
 */
object TerminalUtils {
    fun setupTerminalView(terminalView: TerminalView?, terminalViewClient: TerminalViewClient? = null) {
        terminalView?.textSize = NeoPreference.getFontSize();

        val fontComponent = ComponentManager.getComponent<FontComponent>()
        fontComponent.applyFont(terminalView, null, fontComponent.getCurrentFont())

        if (terminalViewClient != null) {
            terminalView?.setTerminalViewClient(terminalViewClient)
        }
    }

    fun setupExtraKeysView(extraKeysView: ExtraKeysView?) {
        val fontComponent = ComponentManager.getComponent<FontComponent>()
        val font = fontComponent.getCurrentFont()
        fontComponent.applyFont(null, extraKeysView, font)
    }

    fun createSession(context: Context, parameter: ShellParameter): TerminalSession {
        val sessionComponent = ComponentManager.getComponent<SessionComponent>()
        return sessionComponent.createSession(context, parameter)
    }

    fun createSession(activity: Activity, parameter: XParameter) : XSession {
        val sessionComponent = ComponentManager.getComponent<SessionComponent>()
        return sessionComponent.createSession(activity, parameter)
    }

    fun escapeString(s: String?): String {
        if (s == null) {
            return ""
        }

        val builder = StringBuilder()
        val specialChars = "\"\\$`!"
        builder.append('"')
        val length = s.length
        for (i in 0..length - 1) {
            val c = s[i]
            if (specialChars.indexOf(c) >= 0) {
                builder.append('\\')
            }
            builder.append(c)
        }
        builder.append('"')
        return builder.toString()
    }
}