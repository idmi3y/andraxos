package com.thecrackertechnology.dragonterminal.frontend.session.shell.client

import com.thecrackertechnology.dragonterminal.backend.TerminalSession
import com.thecrackertechnology.dragonterminal.frontend.completion.listener.OnAutoCompleteListener
import com.thecrackertechnology.dragonterminal.frontend.session.shell.ShellProfile
import com.thecrackertechnology.dragonterminal.frontend.session.shell.ShellTermSession
import com.thecrackertechnology.dragonterminal.frontend.terminal.TerminalView
import com.thecrackertechnology.dragonterminal.frontend.terminal.extrakey.ExtraKeysView

/**
 * @author kiva
 */
class TermSessionData {
    var termSession: TerminalSession? = null
    var sessionCallback: TermSessionCallback? = null
    var viewClient: TermViewClient? = null
    var onAutoCompleteListener: OnAutoCompleteListener? = null

    var termUI: TermUiPresenter? = null
    var termView: TerminalView? = null
    var extraKeysView: ExtraKeysView? = null

    var profile: ShellProfile? = null

    fun cleanup() {
        onAutoCompleteListener?.onCleanUp()
        onAutoCompleteListener = null

        sessionCallback?.termSessionData = null
        viewClient?.termSessionData = null

        termUI = null
        termView = null
        extraKeysView = null
        termSession = null

        profile = null
    }

    fun initializeSessionWith(session: TerminalSession, sessionCallback: TermSessionCallback?, viewClient: TermViewClient?) {
        this.termSession = session
        this.sessionCallback = sessionCallback
        this.viewClient = viewClient
        this.sessionCallback?.termSessionData = this
        this.viewClient?.termSessionData = this

        if (session is ShellTermSession) {
            profile = session.shellProfile
        }
    }

    fun initializeViewWith(termUI: TermUiPresenter?, termView: TerminalView?, eks: ExtraKeysView?) {
        this.termUI = termUI
        this.termView = termView
        this.extraKeysView = eks
    }
}