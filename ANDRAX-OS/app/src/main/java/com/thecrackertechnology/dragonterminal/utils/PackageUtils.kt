package com.thecrackertechnology.dragonterminal.utils

import android.content.Context
import com.thecrackertechnology.dragonterminal.backend.TerminalSession
import com.thecrackertechnology.dragonterminal.component.pm.PackageComponent
import com.thecrackertechnology.dragonterminal.component.pm.SourceManager
import com.thecrackertechnology.dragonterminal.frontend.component.ComponentManager
import com.thecrackertechnology.dragonterminal.frontend.config.NeoTermPath
import com.thecrackertechnology.dragonterminal.frontend.floating.TerminalDialog
import java.io.File

/**
 * @author kiva
 */
object PackageUtils {
    fun apt(context: Context, subCommand: String, extraArgs: Array<String>?, callback: (Int, TerminalDialog) -> Unit) {
        val argArray =
                if (extraArgs != null) arrayOf(NeoTermPath.APT_BIN_PATH, subCommand, *extraArgs)
                else arrayOf(NeoTermPath.APT_BIN_PATH, subCommand)

        TerminalDialog(context)
                .onFinish(object : TerminalDialog.SessionFinishedCallback {
                    override fun onSessionFinished(dialog: TerminalDialog, finishedSession: TerminalSession?) {
                        val exit = finishedSession?.exitStatus ?: 1
                        callback(exit, dialog)
                    }
                })
                .imeEnabled(true)
                .execute(NeoTermPath.APT_BIN_PATH, argArray)
                .show("apt $subCommand")
    }
}